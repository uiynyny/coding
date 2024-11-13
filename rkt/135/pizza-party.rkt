;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname pizza-party) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor mixed-fraction #f #t none #f () #t)))
; a StudentChoice is a (list Str Sym Num)
; a Section is a (list Str Num (listof StudentChoice))
; a Course is a (listof Section)


(define (studentchoice-template sc)
  (... (first sc)
       (second sc)
       (third sc)))

(define (section-template s)
  (... (first s)
       (second s)
       (studentchoices-template (third s))))
(define (studentchoices-template lst)
  (cond
    [(empty? lst)...]
    [else (...(studentchoice-template (first lst))
              (studentchoices-tempalte (rest lst)))]))
(define(course-template c)
  (cond
    [(empty? c) ...]
    [else (... (section-template (first c))
               (course-template (rest c)))]))


;;b)

(define (popular-pizza section)
  (helper (third section) 0 0 0)
  )

;helper: (listof StudentChoice) -> Symbol
(define (helper losc v h m)
  (cond
    [(empty? losc)(count-most v h m)]
    [(symbol=? 'veggie (second  (first losc))) (helper (rest losc) (add1 v) h m)]
    [(symbol=? 'Hawaiian (second  (first losc)))  (helper (rest losc) v (add1 h) m)]
    [(symbol=? 'meaty (second (first losc)))  (helper (rest losc) v h (add1 m))]
    )
  )

; count-most: Num Num Num -> Symbol
(define (count-most v h m)
  (cond
    [(and(> v h)(> v m))'veggie]
    [(and(> h v)(> h m))'Hawaiian]
    [else 'meaty]
    )
  )


(define (count-slices course)
  (sum course (list 0 0 0)))

(define (student-slice type slice count)
  (cond
    [(symbol=? type 'Hawaiian)(list(+(first count)slice)(second count)(third count))]
    [(symbol=? type 'meaty)(list (first count) (+ (second count) slice)(third count))]
    [(symbol=? type 'veggie)(list (first count)(second count)(+ (third count) slice))]))

(define (sum-student-slice choices count)
  (cond
    [(empty? choices)count]
    [else (sum-student-slice (rest choices)
                             (student-slice (second (first choices))(third (first choices)) count))]))
(define(sum course count)
  (cond
    [(empty? course)count]
    [else (sum (rest course)(sum-student-slice (third (first course))count))]))

(check-expect (count-slices (list (list "A" 135 (list (list "A" 'Hawaiian 3)(list "B" 'meaty 2)))
                                  (list "B" 135 (list (list "E" 'veggie 3)(list "F" 'meaty 2)))))
              (list 3 4 3))