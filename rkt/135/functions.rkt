;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname functions) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor mixed-fraction #f #t none #f () #t)))
(define (manhattan-distance x1 y1 x2 y2)(+ (abs (- x1 x2))(abs (- y1 y2))))
(define (batter-slugging-average s d t hr ab)(/ (+ s(* 2 d) (* 3 t)(* 4 hr))ab))
(define (cona-area r h) (* pi r (+ r (sqrt (+ (sqr h)(sqr r))))))
(define G 6.674e-11)
(define (excape M r) (sqrt (/(* 2 G M)r)))
(define (partition-size-approximation n) (* (/ 1(* 4 n (sqrt 3)))(exp (* pi (sqrt (/ 2n 3))))))