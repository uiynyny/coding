;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname a4a) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor mixed-fraction #f #t none #f () #t)))
;;
;;4a
;;
(define-struct node (left right sz))

(define (size-of-t t)
  (cond
    [(empty? t) 0]
    [else (node-sz t)]
    )
  )

(define (tree-grow-min t)
  (cond
    [(empty? t) (make-node empty empty 1)]
    [(<= (size-of-t (node-left t))
         (size-of-t (node-right t)))
     (make-node (tree-grow-min (node-left t))
                (node-right t)
                (add1 (node-sz t)))]
    [else (make-node (node-left t)
                     (tree-grow-min (node-right t))
                     (add1 (node-sz t)))]
    )
  )

(define t1 (make-node empty empty 1))
(define t2 (make-node (make-node empty empty 1) (make-node empty empty 1) 3))
(check-expect (tree-grow-min t1) (make-node (make-node empty empty 1) empty 2))
(check-expect (tree-grow-min t2) (make-node (make-node (make-node empty empty 1) empty 2)
                                            (make-node empty empty 1) 4))