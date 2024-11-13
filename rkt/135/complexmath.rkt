;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname complexmath) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor mixed-fraction #f #t none #f () #t)))
(define-struct point (x y))
;; A Point is a (make-point Num Num)

;;
;; Q2a
;;

;; Purpose: (point-mult p1 p2) consumes two Points and produces a Point that
;; is the result of their multiplication.
;; Example:
(check-expect (point-mult (make-point 1 1)(make-point 2 2))(make-point 0 4))
;; point-mult: Point Point -> Point
(define (point-mult p1 p2)
  (make-point (- (* (point-x p1)(point-x p2))
                 (* (point-y p1)(point-y p2)))
              (+ (* (point-x p1)(point-y p2))
                 (* (point-x p2)(point-y p1)))
              )
  )

;; Tests:
(check-expect (point-mult (make-point 2 1)(make-point 1 2))(make-point 0 5))

;;
;; Q2b
;;

;; (point-div p1 p2) consumes two Points and produces the Point that
;; is the result of dividing the first parameter by the second
;; Example:
(check-expect (point-div (make-point 1 1)(make-point 2 2))(make-point 0.5 0))
;; point-div: Point Point -> Point
(define (point-div pl p2)
  (make-point
   (/ (+ (* (point-x pl)(point-x p2))
         (* (point-y pl)(point-y p2)))
      (+ (sqr (point-x p2))(sqr (point-y p2))))
   (/ (- (* (point-y pl)(point-x p2))
         (* (point-x pl)(point-y p2)))
      (+(sqr (point-x p2))(sqr (point-y p2))))))
;; Tests:
(check-expect (point-div (make-point 1 1)(make-point 2 2))(make-point 0.5 0))