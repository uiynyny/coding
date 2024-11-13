;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-abbr-reader.ss" "lang")((modname a5b) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #t)))
(define-struct node (left right key))

(define (fullh? t)
  (cond
    [(empty? t) true]
    [(or
      (and (empty? (node-left t))
           (not (empty? (node-right t))))
      (and (empty? (node-right t))
           (not (empty? (node-left t)))))false]
    [else (and (fullh? (node-left t))(fullh? (node-right t)))]
    )
  )

(define (full? t)
  (cond
    [(empty? t)true]
    [(and (empty? (node-left t))(not (empty?(node-right t))))false]
    [(and (empty? (node-right t))(not (empty?(node-left t))))false]
    [else (and (full? (node-left t))(full?(node-right t)))]
    ))

(define t (make-node
           (make-node
            (make-node
             (make-node
              (make-node
               (make-node empty empty 5)
               (make-node empty empty 5) 4)
              (make-node empty empty 4) 3)
             (make-node empty empty 3) 2)
            (make-node
             (make-node empty empty 3)
             (make-node empty empty 3) 2)1)
           (make-node
            (make-node (make-node empty empty 3) (make-node empty empty 3) 2)
            (make-node (make-node empty empty 3) (make-node empty empty 3) 2) 1)
           0))
(full? t)
