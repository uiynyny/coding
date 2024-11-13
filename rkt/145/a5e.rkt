;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-abbr-reader.ss" "lang")((modname a5e) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #t)))
(define-struct node (left right key))
;; take: (listof Int) Nat-> (listof Int)
(define (take lst n)
  (cond
    [(= n 0)empty]
    [else (cons (car lst) (take (rest lst) (sub1 n)))]
    ))
(check-expect (take (list 1 2 3 4 5 6) 0) empty)
(check-expect (take (list 1 2 3 4 5 6) 1) (list 1))



;; drop: (listof Int) Nat-> (listof Int)
(define (drop lst n)
  (cond
    [(= n 0)lst]
    [else (drop (rest lst) (sub1 n))]
    ))
(check-expect (drop (list 1 2 3 4 5 6) 3)(list 4 5 6))







(define (list->balanced lst)
  (lst->balancedh lst (length lst)))
  
(define (lst->balancedh lst l)
  (cond
    [(empty? lst) empty]
    [else (make-node (lst->balancedh (take lst (quotient l 2)) (quotient l 2))
                     (lst->balancedh (drop lst (- l (quotient l 2))) (- l (quotient l 2)))
                     (list-ref lst (quotient l 2)))]))
;(list->balanced (list 1 2 3 4 5 6))

(define (helper lst len)
  (cond
    [(empty? lst)empty]
    [else (make-node (helper (take lst (ceiling(/ (sub1 len) 2)))
                             (ceiling(/ (sub1 len) 2))) 
                     (helper (drop lst (ceiling(/ len 2)))
                             (ceiling(/ len 2)))
                     (list-ref lst (floor(/ len 2))))]))

(helper (list 1 2) 2)