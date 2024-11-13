;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname a4d) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor mixed-fraction #f #t none #f () #t)))
(define-struct node (left right))

(define (create-tree-min n)
  (cond
    [(= n 0) empty]
    [(= n 1) (make-node empty empty)]
    [else (make-node (create-tree-min (ceiling (/ (- n 1) 2)))
                     (create-tree-min (- (- n 1) (ceiling (/ (- n 1) 2)))))]
    ))
(create-tree-min 10)

(make-node
 (make-node
  (make-node (make-node empty empty)
             empty)
  (make-node (make-node empty empty)
             empty))
 (make-node (make-node
             (make-node empty empty)
             empty)
            (make-node empty empty)))

(define (tree-grow-min t)
  (cond
    [(empty? t) (make-node empty empty)]
    [(<= (probe-height (node-left t) 0)
         (probe-height (node-right t) 0))
     (make-node (tree-grow-min (node-left t))
                (node-right t))]
    [else (make-node  (node-left t)
                      (tree-grow-min (node-right t)))]
    )
)

(define (probe-height t height)
  (cond
    [(empty? t) height]
    [else (min (probe-height (node-left t) (add1 height))
               (probe-height (node-right t) (add1 height)))]
    )
  )

(define a (make-node (make-node (make-node empty empty) empty)
                     (make-node (make-node empty empty) (make-node empty empty))))