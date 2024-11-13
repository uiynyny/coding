;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname a2q5) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor mixed-fraction #f #t none #f () #t)))
(define (check-plan A B C D)
  (drivable? C D (drivable? B C (drivable? A B 'rested)))
  )

(define (distance A)
  (cond
    [(symbol=? A 'StJohns) 1]
    [(symbol=? A 'Charlottetown) 2]
    [(symbol=? A 'Halifax) 3]
    [(symbol=? A 'Fredericton) 4]
    [(symbol=? A 'QuebecCity) 5]
    [(symbol=? A 'Toronto) 6]
    [(symbol=? A 'Waterloo) 7]
    [(symbol=? A 'SaultSteMarie) 8]
    [(symbol=? A 'ThunderBay) 9]
    [(symbol=? A 'Winnipeg) 10]
    [(symbol=? A 'Regina) 11]
    [(symbol=? A 'Calgary) 12]
    [(symbol=? A 'Vancouver) 13]
    )
  )
(define (distance-between A B)
  (-(distance B)(distance A)))

(define (drivable? A B fatigue-lv)
  ;; distance between a b
  ;; >2 invalid
  ;; =2 if rested =>exh else invalid
  ;; =1 if rested or ready then ok
  ;; =0 recover
  ;; <0 invalid
  (cond
    [(and (= (distance-between A B) 2) (symbol=? fatigue-lv 'rested)) 'exhausted]
    [(and (= (distance-between A B) 1)
          (or(symbol=? fatigue-lv 'rested)(symbol=? fatigue-lv 'ready))) 'ready]
    [(and (= (distance-between A B) 0) (symbol=? fatigue-lv 'exhausted)) 'ready]
    [(and (= (distance-between A B) 0) (symbol=? fatigue-lv 'ready)) 'rested]
    [(and (= (distance-between A B) 0) (symbol=? fatigue-lv 'rested)) 'rested]
    [else 'invalid]
    )
  )

(check-expect (check-plan 'Halifax 'Fredericton 'Halifax 'Fredericton)
              'invalid)
(check-expect (check-plan 'Waterloo 'Waterloo 'Waterloo 'Waterloo)
              'rested)
(check-expect (check-plan 'Halifax 'QuebecCity 'QuebecCity 'Toronto)
              'ready)
(check-expect (check-plan 'Halifax 'QuebecCity 'QuebecCity 'Waterloo)
              'invalid)
(check-expect (check-plan 'Waterloo 'SaultSteMarie 'SaultSteMarie 'SaultSteMarie)
              'rested)