;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname a3a) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
(define-struct thing (a b))
(define v (make-thing (make-thing (make-thing 1 2) (make-thing 3 4))  
                      (make-thing (make-thing 5 6) (make-thing 7 8))))

(define (build n)
  (if (= n 1)
      1 
      (helper 1 n)))

;;divide the range of generation
(define (helper start end)
  (if (= (add1 start) end)(make-thing start end)
      (make-thing (helper start (floor (/ (+ start end) 2)));1-4
                  (helper (add1 (floor (/ (+ start end) 2))) end));5-8
      )
  )