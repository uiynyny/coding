;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname a1c) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor mixed-fraction #f #t none #f () #t)))
;;d
;2^k e.g. 1 2 4 8 ...

1 ;2^0=1  0 step 
(+ 1 2) ; 2^1=2 1 step
(+ (+ 1 2) (+ 3 4)) ; 2^2=4 3 steps
(+ (+ (+ 1 2) (+ 3 4)) (+ (+ 5 6) (+ 7 8))) ; 2^3=8 7 steps
;; 2^k numbers can form 2^(k-1) nodes on leaves,
;; total # of nodes = non-leaf+leaf = 2^(k-1)-1+2^(k-1) = 2^k - 1
(define (step-d k)
  (-(expt 2 k) 1)
  )
;(check-expect (step-d 9e5)0)

(define (step-countd k)
  (if (equal? k 0) 1  
      (* 2 (step-countd (- k 1)))
      )
  
  )
(define (step-count-d k)
  (- (step-countd k) 1))
;questionable (check-expect (step-count-d 9e5)15)
