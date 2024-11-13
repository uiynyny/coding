;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname a2a) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
(define (m n)
  (if (= n 0) 1; O(3)
      (* n (m (quotient n 2))));O(5+m(n-1))
  )

;T(n)=5+T(n-1)
;(m 1); m(0)=3 m(1)=5+m(0) m(2)=2*5+m(0)
;T(n)=T(n-1)+1
; m(2^k)= 5+5+ ... + 5+ m(2^(k-k))+3 = 5*k+3 k>0
(define (count-m n)
  (if
   (= n 0) 3
   (+ 5 (count-m (sub1 n)))
  )
  )
(count-m 1)
(count-m 2)
(count-m 4)


;; own work
(define (step-count-k n) (+ 3 (* 5 n)))
(define (step-count-l n) (+ 3 (* 9 (- (pow2 n) 1))))

(define (pow2 a)
  (cond
    [(= 0 a) 1]
    [else (* 2 (pow2 (- a 1)))]
    )
  )
(define (step-count-m n) (+ 8 (* 5 (log n 2))))
  
 
;;case for n=0?
(define (step-count-n n)(step-count-m (pow2 (floor (log n 2)))))

;; same as above
(define (step-count-o n) (step-count-l (+ 1 (floor (log n 2)))))
(define (o n) (if (= n 0) 1 (* n (o (quotient n 2)) (o (quotient n 2)))))