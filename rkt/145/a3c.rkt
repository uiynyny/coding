;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname a3c) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
(define-struct node (left right))
;h
;not defined
(define (a3ch n)
  (if
   (= n 0) empty
   (make-node (a3ch (ceiling(/ (sub1 n) 2)))
              (a3ch (- (sub1 n) (ceiling(/ (sub1 n) 2)))))
   )
  )

;i
;; forget to add current level of combination
(define (tree-count-max n)
  (if (= n 0)
      1
      (tree-count-max (- n 1)))))

(define (a3ci n)
  (if (= n 0) 1
      (expt 2 (sub1 n)))
  )