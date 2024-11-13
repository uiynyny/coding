;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-intermediate-reader.ss" "lang")((modname a5f) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
(define-struct node (left right key))
;;insert
(define (bst-insert t k)
  (cond
    [(empty? t) (make-node empty empty k)]
    [(= k (node-key t)) t]
    [(< k (node-key t)) (bst-insert (node-left t)k)]
    [else (bst-insert (node-right t)k)]
    )
  )
(define (rand->bst lst)
  (helper (make-node empty empty(find-mid lst)) lst)
  )

(define (find-mid lst)
  (quick-select lst empty empty (first lst) (ceiling(/ (length lst) 2)))
  )

(define (quick-select lst la lb piv n)
  (cond
    [(empty? lst) (cond
                    [(= (length la) n)piv]
                    [(< (length la) n) (quick-select lb empty empty (first lb) (- n (length la)))]
                    [else (quick-select la empty empty (first la) n)])]
    [else (cond
            [(<= (first lst) piv) (quick-select (rest lst)(cons (first lst) la) lb piv n)]
            [else (quick-select (rest lst)la (cons (first lst) lb)piv n)]
            )
          ]))

(define (helper t lst)
  (cond
    [(empty? lst) t]
    [else (helper (bst-insert t (first lst))(rest lst))]
    )
  )

(rand->bst (list 1 2 3 4 5))
