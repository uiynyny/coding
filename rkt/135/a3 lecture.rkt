;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname |a3 lecture|) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor mixed-fraction #f #t none #f () #t)))
;(define (func_name arg1 arg2)
;  ..body..
;  )
;(func_name 1 2)
(define-struct course (name assignment midterm final))
(define-struct courses (course1 course2 course3 course4 course5))
;strcutrue
(define-struct student (id name faculty term courses))
(define zhangsan (make-student 123
                               "zhang san"
                               "engineering"
                               "1B"
                               (make-courses (make-course 'math136 80 70 60)
                                             (make-course 'stat220 80 70 60)
                                             (make-course 'cs136 80 70 60)
                                             (make-course 'pyhs202 80 70 60)
                                             (make-course 'econ201 80 70 60))))
(student-id zhangsan)
(student-name zhangsan)
(student-faculty zhangsan)
(student-term zhangsan)
(student-courses zhangsan)
(courses-course2(student-courses zhangsan))
(course-midterm(courses-course2(student-courses zhangsan)))

(define student:zhangsan (make-student ...))




(define-struct rect (top left width height color))
;; A Rect is a ()...
;; Rquires:...
(define (rect-area rect)
  (*(rect-height rect)
    (rect-width rect))
  )

;purpose translate the rect r to dx, dy position
;;Contract Rect Num Num -> Rect
(define (rect-move r dx dy)
  (make-rect (+ (rect-top r) dx)
             (+ (rect-left r) dy)
             (rect-width r)
             (rect-height r)
             (rect-color r)
             )
  )

(check-expect (rect-move
               (make-rect 1 2 2 3 'red) 5 2)
              (make-rect 6 4 2 3 'red))

(define (area-of-shape shape)
  (cond
    [(rect? shape) (rect-area shape)]
    [(circle? shape)(circle-area shape)]
    )
  )