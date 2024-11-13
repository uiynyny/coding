;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname a4b) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor mixed-fraction #f #t none #f () #t)))
;
;4b
;
(define-struct node (left right key))

(define (insert-bst t n)
  (cond
    [(empty? t) (make-node empty empty n)]
    [(= n (node-key t)) t]
    [(< n (node-key t))(make-node (insert-bst (node-left t) n)(node-right t)(node-key t))]
    [else (make-node (node-left t)(insert-bst (node-right t) n)(node-key t))]
    )
  )

(define t1 (make-node (make-node empty empty 1) (make-node empty empty 5) 3))
(define t2 (make-node (make-node empty empty 2) (make-node empty empty 6) 4))

(check-expect (insert-bst t1 1) t1)
(check-expect (insert-bst t1 5) t1)
(check-expect (insert-bst t1 2) (make-node (make-node empty (make-node empty empty 2) 1)(make-node empty empty 5) 3) )

(define (delete-bst t n)
  (cond
    [(empty? t) empty]
    [(< n (node-key t))(make-node (delete-bst (node-left t) n)
                                  (node-right t)
                                  (node-key t))]
    [(> n (node-key t))(make-node (node-left t)
                                  (delete-bst (node-right t) n)
                                  (node-key n))]
    [else
     (cond
       [(empty? (node-left t)) (node-right t)]
       [(empty? (node-right t)) (node-left t)]
       [else (make-node (node-left t)
                        (delete-bst (node-right t)(get-successor (node-right t)))
                        (get-successor (node-right t)))]
       )]
    ))

(define (get-successor t)
  (cond
    [(empty? (node-left t))(node-key t)]
    [else (get-successor (node-left t))]
    ))
(check-expect (delete-bst t1 3) (make-node (make-node empty empty 1) empty 5))
(check-expect (delete-bst t1 1) (make-node empty (make-node empty empty 5) 3))

(define (combine-bst t1 t2)
  (cond
    [(empty? t2) t1]
    [else (combine-bst (insert-bst t1 (get-successor t2))
                       (delete-bst t2 (get-successor t2)))]
    )
  )
(check-expect (combine-bst t1 t2)(make-node
 (make-node empty (make-node empty empty 2) 1)
 (make-node (make-node empty empty 4) (make-node empty empty 6) 5)
 3))