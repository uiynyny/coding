;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname list) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor mixed-fraction #f #t none #f () #t)))
;(cons X Y)
;X: any (make-student ...)
;Y: is a list

;list is
; empty
; (cons X list)



(define lst (cons 1
                  (cons 2
                        (cons 3
                              (cons 4
                                    (cons 5 empty)))))
)
;first, second, third, ... eigths,
;rest
(first lst)
(second lst)
(rest(rest lst))

(define (add-replace lon)
  (cons (+(first lon) (second lon)) (rest(rest lon)))
  )

(define (count-wishes los)
  (cond
    [(empty? los) 0]
    [else (+ 1
             (count-wishes (rest los)))]
    )
  )

(count-wishes (cons 1(cons 2(cons 3 empty))))

(define (count-bicycle los)
  (cond
    [(empty? los) 0]
    [(string=? "bicycle" (first los)) (+ 1 (count-bicycle (rest los)))]
    [else (count-bicycle (rest los))]
    )
  )

(count-bicycle (cons "a" (cons "bicycle" (cons "c" empty))))


(define (sort lon)
  (cond
    [(empty? lon) empty]
    [else (insert (first lon)
                  (sort (rest lon)))]
    )
  )

;;lon is sorted
(define (insert n lon)
  (cond
    [(empty? lon) (cons n empty)]
    [(<= n (first lon)) (cons n lon)]
    [else (cons (first lon) (insert n (rest lon)))]
    )
  )

(sort (list 3 1 2 4 9 5 0))
(insert 3 (insert 1 (insert 2 .... (insert 0 empty))))