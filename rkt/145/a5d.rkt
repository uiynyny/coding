;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-intermediate-reader.ss" "lang")((modname a5d) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
(define (bst-insert t k)
  (cond
    [(empty? t) (make-node empty empty k)]
    [(= k (node-key t)) t]
    [(< k (node-key t)) (make-node (bst-insert (node-left t)k) (node-right t)(node-key t))]
    [else (make-node (node-left t)(bst-insert (node-right t)k)(node-key t))]
    )
  )
(define (bigtree n)
  (if (zero? n) empty
      (bst-insert (bigtree (sub1 n))(random 1e7))
      )
  )

(define-struct node (left right key))
(define (bst->list t)
  (cond
    [(empty? t) empty]
    [else (append (bst->list (node-left t))
                  (list (node-key t))
                  (bst->list (node-right t)))]))



(define (a5d t)
  (cond
    [(empty? t) empty]
    [else (combine (a5d (node-left t))
                   (cons (node-key t)
                         (a5d (node-right t))))])
  )

(define (combine l1 l2)
  (cond
    [(empty? l1) l2]
    [else (cons (first l1)(combine (rest l1) l2))]
    )
  )
(define t (bigtree 1e5))
(time (a5d t))