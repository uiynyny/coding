;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname debug-a01) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor mixed-fraction #f #t none #f () #t)))
(define (luminosity r g b)
  (+ (* 0.3 r)
     (* 0.59 g)
     (* 0.11 b)))

(check-expect(luminosity 1 1 1)1)
(check-expect(luminosity 0 0 0)0)