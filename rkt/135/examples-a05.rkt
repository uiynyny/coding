;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname examples-a05) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
(define-struct Section (name id lst))
(check-expect (popular-pizza (make-Section "instr" 1
                                           (list
                                            (list "stdname" 'meaty 1))))
              'meaty)