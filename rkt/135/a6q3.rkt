;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-abbr-reader.ss" "lang")((modname a6q3) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #t)))
;(list (list name (listof Action)))
(define-struct action (niceness desc))

(define action1 (make-action 3 "Prepared assignment question"))
(define action2 (make-action -7 "Questions are too hard"))
(define actlst (list (list "Zaphod" (list action1 action2))))

(define super-actlst  
  (list (list "Barry" (list (make-action 10 "Won the running event")
                            (make-action -1 "Stayed up too late on a schoolnight")
                            (make-action 6 "Helped some friends get to school on time")
                            (make-action -1 "bad")))
        (list "Bruce" (list (make-action -4 "Pretended to be a bat and scared children in the park")))
        (list "Clark" (list (make-action -5 "Skipped his chores on the farm")
                            (make-action 5 "Saved Earth from ...")))
        (list "Hal" (list (make-action 3 "Shared his toys with the other children")))
        (list "Harley" (list (make-action -10 "Joined a gang")))
        (list "Tom" (list (make-action 1 "good")))
        (list "Zatanna" (list (make-action 15 "Show friends magic tricks")
                            (make-action 3 "Studied for their exam")
                            (make-action -7 "Made a mess when magic went wrong")
                            (make-action -4 "Procrastinated on CS 135 assignment")))))

(check-expect (extreme-actions "Barry" super-actlst)
              (list "Stayed up too late on a schoolnight" "Won the running event"))


;; Str ActionList -> (listof Str)
(define (extreme-actions name actlst)
  (cond
    [(empty? (find-child name actlst)) empty]
    [else (find-low-and-high (find-child name actlst) 0 0 (list "" ""))]
    )
  )

(define (find-low-and-high actions low high result)
  (cond
    [(empty? actions) result]
    [(> (action-niceness (first actions)) high)
     (find-low-and-high (rest actions)
                        low
                        (action-niceness (first actions))
                        (list (first result)
                              (action-desc (first actions))))]
    [(< (action-niceness (first actions)) low)
     (find-low-and-high (rest actions)
                        (action-niceness (first actions))
                        high
                        (list (action-desc (first actions))
                              (second result)))]
    [else (find-low-and-high (rest actions) low high result)]
  ))

;; find the listof action for the child
(define (find-child name lst)
  (cond
    [(empty? lst) empty]
    [(string=? name (first(first lst))) (second (first lst))]
    [else (find-child name (rest lst))]
    )
  )

;;b)
;; An ActionUpdate is a (listof (list Name Action))
;; Requires: The list is sorted alphabetically by child name.
;; A name will only appear once in the list.
(define actionUpdate-example (list (list "A" (make-action 1 "good"))
                                   (list "B" (make-action 1 "good"))
                                   (list "C" (make-action 1 "good"))))

(define action3 (make-action 42 "Told a good joke about recursion."))
(define newactlst (list (list "Zaphod" (list action3 action1 action2))))
(check-expect (merge-actions actlst (list (list "Zaphod" action3))) newactlst)

; actlist (listof (list Name Actions))
;;actUpdate (listof (list Name Action))
;;Purpose: (merge-actions actlst actUpd) consume ...
;;Contract: ActionList ActionUpdate -> ActionList
(define (merge-actions actlst actUpd)
  (cond
    [(empty? actUpd) actlst]
    [(string=? (first(first actlst)) (first(first actUpd))) ;; name1 = name2
     (cons (list (first (first actlst))                     ;; update name
                 (cons (second(first actUpd))               ;; 
                       (second (first actlst)))             ;;update actions (cons Action Actions)
                 )                                          ;;updated entry in actionList
           (merge-actions (rest actlst) (rest actUpd)))]
    [(string<? (first(first actlst)) (first(first actUpd))) ;; name1 < name2
     (cons (first actlst)
           (merge-actions (rest actlst) actUpd))]
    [(string>? (first(first actlst)) (first(first actUpd))) ;; name1 > name2
     (cons (list (first (first actUpd))                     ;; add name2
                 (list (second(first actUpd)))              ;; add Action
                 )                                          ;; add person name2 in front of name1
           (merge-actions actlst (rest actUpd)))]
    )
  )

(define (merge-sort lst1 lst2)
  (cond
    [(empty? lst1)lst2]
    [(empty? lst2)lst1]
    [(<(first lst1)(first lst2))(cons (first lst1)(merge-sort (rest lst1)lst2))]
    [else (cons (first lst2)(merge-sort lst1 (rest lst2)))]
    )
  )
;(merge-sort (list 1 3 4) (list 2 5))


;;c)
(define-struct wish (score gift))
;; A Wish is a (make-wish NiceScore Desc)
;; Requires: score is further restricted to be > 0

;; A WishList is a (listof Wish)
;; Requires: Wishes are sorted in non-decreasing order by score.
(define wishList-example (list (make-wish 3 "Tophat")
                               (make-wish 5 "New wand")))

(define super-chldlst
  (list (list "Barry" (list (make-wish 3 "New boots") (make-wish 4 "Red suit") (make-wish 20 "Fancy hat")))
        (list "Clark" (list (make-wish 1 "Red cape")))
        (list "Tom" (list (make-wish 1 "A")(make-wish 3 "B")))
        (list "Zatanna" (list (make-wish 3 "Tophat") (make-wish 5 "New wand")))))
(check-expect (choose-gifts -1 empty) (list "coal"))
(check-expect (choose-gifts -1 (list (make-wish 1 "Red cape"))) (list "coal"))
(check-expect (choose-gifts 0 empty) (list "socks"))
(check-expect (choose-gifts 0 (list (make-wish 1 "Red cape"))) (list "socks"))
(check-expect (choose-gifts 42 empty) (list "socks"))
(check-expect (choose-gifts 2 (list (make-wish 3 "Tophat") (make-wish 5 "New wand"))) (list "socks"))
(check-expect (choose-gifts 4 (list (make-wish 3 "Tophat") (make-wish 5 "New wand"))) (list "Tophat"))
(check-expect (choose-gifts 10 (list (make-wish 3 "Tophat") (make-wish 5 "New wand"))) (list "New wand" "Tophat"))



;; Int WishList -> (listof Str)
(define (choose-gifts N wishLst)
  (cond
    [(< N 0) (list "coal")]
    [(= N 0) (list "socks")]
    [(and (> N 0) (empty? wishLst)) (list "socks")]
    [(and (> N 0) (< N (wish-score (first wishLst)))) (list "socks")]
    [else (helper N wishLst empty)]
    )
  ) 
;;acc recur
(define (helper N wishLst res)
  (cond
    [(empty? wishLst) res]
    [(>= N (wish-score (first wishLst)))
     (helper N (rest wishLst) (cons (wish-gift (first wishLst)) res))]
    [else res]
    )
  )

;; An ActionList is a (listof (list Name (listof Action)))
;; Requires: The list is sorted alphabetically by child name.
;;           Each list of Actions is non-empty.
;; Note: the order of Actions for the same child is arbitrary.
;; (listof (list Name N-score))

;; A ChildrenList is a (listof (list Name Wishlist))
;; Requires: The list is sorted alphabetically by child name.

;; A GiftList is a (listof (list Name (listof Desc)))
;; Requires: The GiftList is sorted alphabetically by child name.
;;           The gifts (listof Desc) are sorted in non-increasing
;;           order of score; i.e., gift with highest score is first.
(define (assign-gifts actionLst chdLst)
  (cond
    [(empty? chdLst) empty]
    [(string=? (first (first actionLst))(first (first chdLst)))   ;;name1 = name2
     (cons
      (list
       (first (first actionLst))
       (choose-gifts
        (sum-score (second(first actionLst)))
        (second (first chdLst))))                                 ;;choose gift for name2
      (assign-gifts (rest actionLst)(rest chdLst)))]
    [(string<? (first (first actionLst))(first (first chdLst)))   ;;name1 < name2 child not found
     (cons                                                   ;;name1 > name2 child action not found
      (list
       (first (first actionLst))
       (choose-gifts (sum-score (second(first actionLst))) empty))
      (assign-gifts (rest actionLst) chdLst))]
    [else (cons                                                   ;;name1 > name2 child action not found
           (list
            (first (first chdLst))
            (choose-gifts 0 (second(first chdLst))))
           (assign-gifts  actionLst (rest chdLst)))]
    )
  )

(define (sum-score actions)
  (cond
    [(empty? actions)0]
    [else (+ (action-niceness(first actions))(sum-score (rest actions)))]
  ))

(assign-gifts super-actlst super-chldlst)