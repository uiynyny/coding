;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname a1d) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor mixed-fraction #f #t none #f () #t)))
;;f
(if (< (remainder 7861248612348 1024) 512) (+ 1 2) (+ (+ 1 2) 3)) ;true=>4 false=>5
;;h
;; last = first +(n-1)1024
(define (g x) (if (< (remainder x 1024) 512) (+ 1 2) (+ (+ 1 2) 3)));t 4, f 5


(define (helper s e)
  (+ 1(quotient (- e s) 1024))
  )