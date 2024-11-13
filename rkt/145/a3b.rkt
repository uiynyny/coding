;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname a3b) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
(define-struct node (left right))

;;b
;;consider n >=0
(define (tree-create n)
  (cond
    [(= n 1) (make-node empty empty)] 
    [else (make-node empty (tree-create(- n 1)))]
    )
  )
(define (a3bb n)
  (if
   (= n 0) empty
   (make-node (a3bb (sub1 n)) empty)
   )
  )

;c
;; typo on line 26 ?
(define (tree-create-c n)
  (cond
    [(= n 0) empty]
    [(= n 1) (make-node empty empty)]
    
    [(= n 2)(make-node (make-node empty empty) empty)]
    [else (make-node (tree-create-c(- n 1)) empty)]
    )
  )

(define (a3bc n)
  (cond
    [(= n 0) empty]
    [else (make-node empty (a3bc (sub1 n)))]
    )
  )

;d
;; similar to above typo 45
(define (tree-create-d n)
  (cond
    [(= n 0) empty]
    [(= n 1) (make-node empty empty)]
    
    [(= n 2)(make-node empty (make-node empty empty))]
    [else (make-node empty (tree-create-d (- n 1)))]
    ))

;e
;; should be simpler 2^n - n
(define (tree-count n)
  (cond
    [(= n 0) 1]
    [(= n 1) 1]
    [(= n 2) 2]
    [else (expt 2 (- n 1))]
    )
  )
(define (a3be n)
  (- (expt 2 n) n);; theory req
  )
  