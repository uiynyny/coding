;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-intermediate-reader.ss" "lang")((modname a5b) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
(define (evens lst)
  (cond
    [(empty? lst) empty]
    [(= (length lst) 1) lst]
    [else (cons(first lst) (evens (rest (rest lst))))]))


(define (interleave-h lst1 lst2 res)
  (cond
    [(empty? lst2) (append res lst1)]
    [(empty? lst1) (append res lst2)]              
    [else (interleave-h (rest lst1)(rest lst2)(append res (list (first lst1)(first lst2))))]))

(define (interleave lst1 lst2)
  (cond
    [(empty? lst2) lst1]
    [(empty? lst1) lst2]              
    [else (cons (first lst1)
                (cons (first lst2)
                      (interleave (rest lst1)(rest lst2))))]))

;(check-expect (interleave-h (range 0 1e5 2)(range 1 1e5 2) empty) (range 0 1e5 1))
(check-expect (interleave (range 0 1e6 2)(range 1 1e6 2)) (range 0 1e6 1))
;(time (interleave-h (range 0 1e5 2)(range 1 1e5 2) empty) )
;(time  (interleave (range 0 1e5 2)(range 1 1e5 2)))