;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname a2q6) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor mixed-fraction #f #t none #f () #t)))
(define (day d)(remainder d 100))
(define (month d) (remainder(quotient d 100)100))
(define (year d) (remainder(quotient d 1e4) 100))
(define (centry d) (quotient d 1e6))

(define (month-fix m)
  (cond
    [(= m 1) 11]
    [(= m 2) 12]
    [else (- m 2)]
    ))

(define (year-fix y m)
  (cond
    [(or (= m 1)(= m 2)) (- y 1)]
    [else y]
    )
  )

(define (date->day-of-week d)
  (convert-to-day-of-week
   (remainder (+ (day d)
                 (floor (-(* 2.6 (month-fix(month d))) 0.2))
                 (- (* 2 (centry d)))
                 (year-fix(year d)(month d))
                 (floor (/ (year-fix(year d)(month d)) 4))
                 (floor (/ (centry d) 4))
                 ) 7))
  )

(define (convert-to-day-of-week dow)
  (cond
    [(= 0 dow) 'Sunday]
    [(= 1 dow) 'Monday]
    [(= 2 dow) 'Tuesday]
    [(= 3 dow) 'Wednesday]
    [(= 4 dow) 'Thursday]
    [(= 5 dow) 'Firday]
    [(= 6 dow) 'Satuarday]
    )
  )

(check-expect (date->day-of-week 20240924) 'Tuesday)
(check-expect (date->day-of-week 20130717) 'Wednesday)