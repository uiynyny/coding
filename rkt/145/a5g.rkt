;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-abbr-reader.ss" "lang")((modname a5g) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #t)))
(define-struct node (left right key))

;;(123456789) (9)
(define (insertion-sort lst)
  (cond
    [(empty? lst) empty]
    [else (insert-s (first lst)(insertion-sort (rest lst)))]
    )
  )
(define (insert-s n slst)
  (cond
    [(empty? slst) (list n)]
    [(<= n (first slst)) (cons n slst)]
    [else (cons (first slst) (insert-s n (rest slst)))]
    )
  )
(check-expect (insertion-sort (list 5 4 5 6 3 1 2 8 7 9 0 4))(list 0 1 2 3 4 4 5 5 6 7 8 9))
(check-expect (insertion-sort (list))empty)

;(1 2 3 4 5)=> 3[2]
;(1 2 3 4 5 6)=> 4[3]
(define (a5g lst)
  (helper-g (insertion-sort lst) 0 (length lst)))

(define (a5gm lst)
  (helper-g (merge-sort lst) 0 (length lst)))

(define (helper-g lst start end)
  (cond
    [(>= start end) empty]
    [else (make-node
           (helper-g lst start (floor(/ (+ start end) 2)))
           (helper-g lst (+ 1(floor(/ (+ start end) 2))) end)
           (list-ref lst (floor(/ (+ start end) 2))))]
    )
  )

(define (merge a b)
  (cond
    [(empty? a)b]
    [(empty? b)b]
    [(<= (first a)(first b))(cons (first a)(merge (rest a) b))]
    [else (cons (first b)(merge a (rest b)))]
    )
  )

(define (firstH L num)
  (if (= 0 num)
      empty
      (cons (first L)(firstH (rest L)(sub1 num)))))

(define (secondH L num)
  (if (= num 0) L
      (secondH (rest L) (sub1 num))))
(define (merge-sort L)
  (cond
    [(empty? L) L]
    [(empty? (rest L))L]
    [else (merge
           (merge-sort (firstH L (quotient (length L) 2)))
           (merge-sort (secondH L (quotient (length L) 2))))]
    )
  )

(define (bigtree n)
  (if (zero? n) empty
      (insert (bigtree (sub1 n))(random 1e4))
      )
  )
;(time (a5g (range 1 1e5 1)))
(time (a5gm (range 1 1e5 1)))

(define (get-list lst n)
  (if (= 0 n)(car lst)
      (get-list (cdr lst)(sub1 n))))
;(time (a5g (range 1 1e5 1)))