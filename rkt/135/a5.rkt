;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-abbr-reader.ss" "lang")((modname a5) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #t)))
;(define-struct StudentChoice (name type slices))
;(StudentChoice-name a)

;; StudentChoice is a (list Str Sym Num)
;(list name type slices)
;(define a(list "Jack" 'meaty 8))
(define (student_name sc)(first sc))
(define (type sc) (second sc))
(define (slice sc)(third sc))

(define (StudentChoice-template sc)
  (...(student_name sc)
      (type sc)
      (slice sc))
  )

; Section is a (list Str Num (listof StudentChoice))
;(list instructor sec_num studentChoices)
;(list "Prof A" 1 (list (list "Jack" 'meaty 8)))
(define (Section-template s)
  (...(first s)
      (second s)
      (StudentChoices-template (third s)))
  )

(define (StudentChoices-template los)
  (cond
    [(empty? los)...]
    [else (... (StudentChoice-template (first los))
               (StudentChoices-template (rest los)))]
    ))

; Course is one of
; empty
; (cons Section Course)

;(list (list "Prof A" 1 (list (list "Jack" 'meaty 8)))
;      (list "Prof B" 2 (list (list "James" 'veggie 4))))

(list "Prof A" 1 (list (list "Jack" 'meaty 8)
                       (list "Alice" 'veggie 8)
                       (list "Bob" 'Hawiiwan 8)
                       (list "Charlie" 'meaty 8)))

(define (popular-pizza section)
  ;; find the most popular pizza type
  ;count number of 'meaty 'veggie 'Hawiian
  ;; meaty > veggie and meaty > Hawiian => meaty
  (cond
    [(and
      (> (count-type 'meaty (third section))
         (count-type 'veggie (third section)))
      (> (count-type 'meaty (third section))
         (count-type 'Hawiiwan (third section)))) 'meaty]
    [(> (count-type 'veggie (third section))
        (count-type 'Hawiiwan (third section))) 'veggie]
    [else 'Hawaiian]
    ))

(define (count-type sym lst)
  (cond
    [(empty? lst) 0]
    [(symbol=? sym (second (first lst))) (+ 1(count-type sym (rest lst)))]
    [else (count-type sym (rest lst))])
  )

(popular-pizza (list "Prof A" 1 (list (list "Jack" 'meaty 8)
                                      (list "Alice" 'veggie 8)
                                      (list "Bob" 'Hawiiwan 8)
                                      (list "Charlie" 'meaty 8)))
               )
;c)

(define (sort-choice section)
  (list (first section)(second section)(sort (third section)))
  )

(define (sort losc)
  (cond
    [(empty? losc)empty]
    [else (insert (first losc)(sort (rest losc)))]
    )
  )

;;insert sc into listof sc and maintain the order of losc
(define (insert sc losc)
  (cond
    [(empty? losc) (list sc)]
    [(choices<= sc (first losc))(cons sc losc)]
    [else (cons (first losc)(insert sc (rest losc)))]
    )
  )

(define (choices<= sc1 sc2)
  (or (< (find-order (second sc1))
         (find-order (second sc2)))
      (and (= (find-order (second sc1))
              (find-order (second sc2)))
           (string<? (first sc1) (first sc2)))
      )
  )

(define (find-order sym)
  (cond
    [(symbol=? sym 'Hawaiian) 1]
    [(symbol=? sym 'meaty) 2]
    [(symbol=? sym 'veggie) 3])
  )

(sort-choice (list "prof A" 1 (list (list "A" 'veggie 4)
                                    (list "B" 'Hawaiian 4)
                                    (list "C" 'meaty 4)
                                    (list "Bob" 'meaty 4))))

; d)
(define (pizza-lookup course sec_num stu_name)
  ;; find the section within the course
  ;; find the student within the section
  (cond
    [(empty? course)empty]
    [(= sec_num (second (first course)))
     (student-lookup (third (first course)) stu_name)]
    [else (pizza-lookup (rest course) sec_num stu_name)]
    )
  )

(define (student-lookup losc stu_name)
  (cond
    [(empty? losc) empty]
    [(string=? stu_name (first (first losc)))
     (list (second (first losc))(third (first losc)))]
    [else (student-lookup (rest losc) stu_name)]
    )
  )

(pizza-lookup (list (list "prof A" 1 (list (list "A" 'veggie 4)
                                           (list "B" 'Hawaiian 4)
                                           (list "C" 'meaty 4)
                                           (list "Bob" 'meaty 4)))
                    (list "prof B" 2 (list (list "E" 'veggie 4)
                                           (list "Q" 'Hawaiian 4)
                                           (list "AA" 'meaty 6)
                                           (list "PZ" 'meaty 4)))
                    )
              2 "AA"
              )

;; e)

(define (count-slice course)
  ;; (list a b c)
  ;; (count-type 'H ...)(count-type 'm ...)(count-type 'v ...)
  (list (count 'Hawaiian course)
        (count 'meaty course)
        (count 'veggie course)
        ))

(define (count sym course)
  (cond
    [(empty? course) 0]
    [else (+ (count-section sym (third(first course)))(count sym (rest course)))]
    ))

(define (count-section sym losc)
  (cond
    [(empty? losc) 0]
    [(symbol=? sym (second (first losc)))(+ (third (first losc))(count-section sym (rest losc)))]
    [else (count-section sym (rest losc))])
  )

(count-slice (list (list "prof A" 1 (list (list "A" 'veggie 5)
                                           (list "B" 'Hawaiian 4)
                                           (list "C" 'meaty 4)
                                           (list "Bob" 'meaty 4)))
                    (list "prof B" 2 (list (list "E" 'veggie 4)
                                           (list "Q" 'Hawaiian 4)
                                           (list "AA" 'meaty 6)
                                           (list "PZ" 'meaty 4)))
                    )
              )


;; func: listof Num Num -> listof Num
(define (func lst a)
  (cond
    [(empty? lst)(cons a empty)]
    [(= a (first lst)) lst]
    [else (cons (first lst)(func (rest lst) a))]
    ))

(func (list 1 2 3 4 5) 3) => (list 1 2 3 4 5)
(cons 1 (func (list 2 3 4 5) 3))
(cons 1 (cons 2 (list 3 4 5)))

(define (helper lst lst1 a)
  (cond
    [(...) lst]
    [(... (helper lst (rest lst1) a))]
    ))

(define (noop lst)
  (cond
    [(empty? lst) empty]
    [else (cons (first lst)(noop (rest lst)))]
    ))