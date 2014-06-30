(ns i-am-a-horse-in-the-land-of-booleans
  (:refer-clojure :exclude [boolean]))

(defn boolean [x]
  (if x true false))

(defn negate [x]
  (- 0 x))

(defn abs [x]
  (if (>= x 0)
    x
    (negate x)))

(defn remainder [divisor n]
  (mod n divisor))

(defn divides? [divisor n]
  (if (== 0 (remainder divisor n))
    true
    false))

(divides? 2 4)

(defn fizzbuzz [n]
  (cond
   (divides? 15 n) "gotcha!"
   (divides? 5 n) "buzz"
   (divides? 3 n) "fizz"
   :else ""))

(fizzbuzz 2)  ;=> ""
(fizzbuzz 45) ;=> "gotcha!"
(fizzbuzz 48) ;=> "fizz"
(fizzbuzz 70) ;=> "buzz"

(defn teen? [age]
  (if (<= 13 age 19)
    true
    false))

(defn not-teen? [age]
  (not (teen? age)))

(not-teen? 13)

(defn list-or-vec? [coll]
  (cond
   (list? coll) true
   (vector? coll) true
   :else false))

(defn generic-doublificate [x]
  (cond
   (number? x) (* 2 x)
   (= x {}) nil
   (=  x[]) nil
   (list-or-vec? x) (* 2 (count x))
   :else true))

(generic-doublificate 1)        ;=> 2
(generic-doublificate [1 2])    ;=> 4
(generic-doublificate '(65 21)) ;=> 4
(generic-doublificate {})       ;=> nil
(generic-doublificate [])       ;=> nil
(generic-doublificate {:a 1})   ;=> true

(defn century? [year]
  (divides? 100 year))

(defn leap-year? [year]
  (cond
   (century? year) (divides? 400 year)
   :else (divides? 4 year)))

(leap-year? 100) ;=> false
(leap-year? 200) ;=> false
(leap-year? 400) ;=> true
(leap-year? 12)  ;=> true
(leap-year? 20)  ;=> true
(leap-year? 15)  ;=> false

(leap-year? 2000)

; '_______'

(if nil "b" "c")

(== 5 5.0)

(teen? 19)

(abs -4)
