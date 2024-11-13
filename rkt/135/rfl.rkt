;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname rfl) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor mixed-fraction #f #t none #f () #t)))
(define-struct sub-mod (name weight))
(define-struct mod (name frame-wt primary secondary))
(define-struct robot (name head arms legs))

;; (mod-weight m) consume a mod and produce weight
;; example:
(check-expect (mod-weight (make-mod "a" 1 (make-sub-mod "a1" 1)(make-sub-mod "a2" 1)))3)
;; mod-weight: mod -> Num
(define (mod-weight m)
  (+ (mod-frame-wt m)
     (sub-mod-weight (mod-primary m))
     (sub-mod-weight (mod-secondary m)))
  )
;; Tests:
(check-expect (mod-weight (make-mod "a" 1 (make-sub-mod "a1" 1)(make-sub-mod "a2" 1)))3)

;; (combine r1 r2) consume two robots and produce a new robot
;; example:
(check-expect (combine robot-atom robot-smasher)
              (make-robot "Atom-Smasher"
                          (make-mod "Head-S" 30
                                    (make-sub-mod "Eye-S" 10)
                                    (make-sub-mod "Eye-S" 10))
                          (make-mod "Arms-A" 100
                                    (make-sub-mod "Fist-A-Big" 50)
                                    (make-sub-mod "Fist-S" 15))
                          (make-mod "Legs-S" 30
                                    (make-sub-mod "Foot-A" 10)
                                    (make-sub-mod "Foot-A" 10))))
;; combine: Robot Robot -> Robot
(define (combine r1 r2)
  (make-robot
   (string-append (robot-name r1) "-" (robot-name r2))
   (combine-mod (robot-head r1)(robot-head r2))
   (combine-mod (robot-arms r1)(robot-arms r2))
   (combine-mod (robot-legs r1)(robot-legs r2))
   )
  )

;;Tests:
(check-expect (combine robot-atom robot-smasher)
              (make-robot "Atom-Smasher"
                          (make-mod "Head-S" 30
                                    (make-sub-mod "Eye-S" 10)
                                    (make-sub-mod "Eye-S" 10))
                          (make-mod "Arms-A" 100
                                    (make-sub-mod "Fist-A-Big" 50)
                                    (make-sub-mod "Fist-S" 15))
                          (make-mod "Legs-S" 30
                                    (make-sub-mod "Foot-A" 10)
                                    (make-sub-mod "Foot-A" 10))))
(define (combine-mod m1 m2)
  (cond
    [(> (mod-weight m1)(mod-weight m2))
     (make-mod (mod-name m1)
               (mod-frame-wt m1)
               (find-primary m1 m2)
               (find-secondary m1 m2))]
    [(> (mod-weight m2)(mod-weight m1))
     (make-mod (mod-name m2)
               (mod-frame-wt m2)
               (find-primary m1 m2)
               (find-secondary m1 m2))]
    [(= (mod-weight m1)(mod-weight m2))
     (make-mod (mod-name m1)
               (mod-frame-wt m1)
               (find-primary m1 m2)
               (find-secondary m1 m2))]))



(define (find-primary m1 m2)
  (cond
    [(> (sub-mod-weight (mod-primary m1))(sub-mod-weight (mod-primary m2)))
     (make-sub-mod (sub-mod-name (mod-primary m1))(sub-mod-weight (mod-primary m1)))]
    [(< (sub-mod-weight (mod-primary m1))(sub-mod-weight (mod-primary m2)))
     (make-sub-mod (sub-mod-name (mod-primary m2))(sub-mod-weight (mod-primary m2)))]
    ))

(define (find-secondary m1 m2)
  (cond
    [(and (> (sub-mod-weight (mod-primary m1))(sub-mod-weight (mod-primary m2)))
          (> (sub-mod-weight (mod-primary m2))(sub-mod-weight(mod-secondary m1))))
     (make-sub-mod (sub-mod-name (mod-primary m2))(sub-mod-weight (mod-primary m2)))]
    [(and (> (sub-mod-weight (mod-primary m1))(sub-mod-weight (mod-primary m2)))
          (< (sub-mod-weight (mod-primary m2))(sub-mod-weight (mod-secondary m1))))
     (make-sub-mod (sub-mod-name (mod-secondary m1))(sub-mod-weight (mod-secondary m1)))]
    [(and (> (sub-mod-weight (mod-primary m2))(sub-mod-weight (mod-primary m1)))
          (> (sub-mod-weight (mod-primary m1))(sub-mod-weight (mod-secondary m2))))
     (make-sub-mod (sub-mod-name (mod-primary m1))(sub-mod-weight (mod-primary m1)))]
    [(and (> (sub-mod-weight (mod-primary m2))(sub-mod-weight (mod-primary m1)))
          (< (sub-mod-weight (mod-primary m1))(sub-mod-weight (mod-secondary m2))))
     (make-sub-mod (sub-mod-name (mod-secondary m2))(sub-mod-weight (mod-secondary m2)))]))

(define robot-atom
  (make-robot "Atom"
              (make-mod "Head-A" 10
                        (make-sub-mod "Eye-A" 5)
                        (make-sub-mod "Eye-A" 5))
              (make-mod "Arms-A" 100
                        (make-sub-mod "Fist-A-Big" 50)
                        (make-sub-mod "Fist-A-Small" 2))
              (make-mod "Legs-A" 20
                        (make-sub-mod "Foot-A" 10)
                        (make-sub-mod "Foot-A" 10))))

(define robot-smasher
  (make-robot "Smasher"
              (make-mod "Head-S" 30
                        (make-sub-mod "Eye-S" 10)
                        (make-sub-mod "Eye-S" 10))
              (make-mod "Arms-S" 50
                        (make-sub-mod "Fist-S" 15)
                        (make-sub-mod "Fist-S" 15))
              (make-mod "Legs-S" 30
                        (make-sub-mod "Foot-S-Big" 8)
                        (make-sub-mod "Foot-S-Small" 5))))