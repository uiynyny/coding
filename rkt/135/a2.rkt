;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname a2) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor mixed-fraction #f #t none #f () #t)))
(define (can-donate-to/cond? d r)
  (cond
    [(symbol=? d r) true]
    [(symbol=? d 'O-) true]
    [(symbol=? r 'AB+) true]
    [(symbol=? d 'O+)(cond
                       [(symbol=? r 'A+) true]
                       [(symbol=? r 'B+) true]
                       [else false]
                       )]
    [(symbol=? d 'A-)(cond
                       [(symbol=? r 'A+) true]
                       [(symbol=? r 'AB-) true]
                       [else false]
                       )]
    [(symbol=? d 'B-)(cond
                       [(symbol=? r 'B+) true]
                       [(symbol=? r 'AB-) true]
                       [else false]
                       )]
    [else false]
    )
  )
(check-expect (can-donate-to/cond? 'A- 'O-) false)

(check-expect (can-donate-to/bool? 'A- 'AB+) true)

(define (can-donate-to/bool? d r)
  (or (symbol=? d r)
      (symbol=? d 'O-)
      (symbol=? r 'AB+)
      (and (symbol=? d 'O+)(or (symbol=? r 'A+)
                               (symbol=? r 'B+)))
      (and (symbol=? d 'A-)(or (symbol=? r 'A+)
                               (symbol=? r 'AB-)))
      (and (symbol=? d 'B-)(or (symbol=? r 'B+)
                               (symbol=? r 'AB-)))
      )
  )


(check-expect (can-donate-to/bool? 'A- 'O-) false)

(check-expect (check-plan 'Halifax 'Fredericton 'Halifax 'Fredericton)
              'invalid)
(check-expect (check-plan 'Waterloo 'Waterloo 'Waterloo 'Waterloo)
              'rested)
(check-expect (check-plan 'Halifax 'QuebecCity 'QuebecCity 'Toronto)
              'ready)
(check-expect (check-plan 'Halifax 'QuebecCity 'QuebecCity 'Waterloo)
              'invalid)

(define (check-plan A B C D)
  (change-level C D (change-level B C (change-level A B 'rested)))
  )

(define (change-level from to current-level)
  (cond
    ;; distance == 1 and level!=exa ready
    ;; distance == 2 and level== rested exhausted
    ;; distance == 0 if level == exhausted ready else rested
    ;; else invalid
    [(and (= (distance from to) 1)
          (or (symbol=? 'ready current-level)
              (symbol=? 'rested current-level))) 'ready]
    [(and (= (distance from to) 2)
          (symbol=? 'rested current-level)) 'exhausted]
    [(= (distance from to) 0)(cond
                               [(symbol=? 'exhausted current-level) 'ready]
                               [else 'rested]
                               )]
    [else 'invalid]
    )
  )

#|
'StJohns, 'Charlottetown, 'Halifax, 'Fredericton,
'QuebecCity, 'Toronto, 'Waterloo, 'SaultSteMarie, 'ThunderBay, 'Winnipeg, 'Regina,
'Calgary, and 'Vancouver
|#

(define (city-to-number city)
  (cond
    [(symbol=? 'StJohns city) 1]
    [(symbol=? 'Charlottetown city) 2]
    [(symbol=? 'Halifax city) 3]
    [(symbol=? 'Fredericton city) 4]
    [(symbol=? 'QuebecCity city) 5]
    [(symbol=? 'Toronto city) 6]
    [(symbol=? 'Waterloo city) 7]
    [(symbol=? 'SaultSteMarie city) 8]
    [(symbol=? 'ThunderBay city) 9]
    [(symbol=? 'Calgary city) 10]
    [(symbol=? 'Vancouver city) 11]
    )
  )

(define (distance from to)
  (- (city-to-number to)(city-to-number from))
  )