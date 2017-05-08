(ns ninetynine-clojure-problems.arithmetic
  (:use [clojure.math.numeric-tower])
  (:gen-class))

(defn divides?
  [divisee divisor]
  (zero? (mod divisee divisor)))

;; 31 - is-prime?
(defn is-prime?
  "Determine if a given integer is prime"
  [potential]
  (not-any? 
    #(and (not= potential %) (zero? (mod potential %)))
    (cons 2 (range 3 (inc (first (exact-integer-sqrt potential))) 2))))

;; 32 - gcd
(defn greatest-common-divisor 
  "Find the greatest common denominator of two numbers"
  [a b]
  (if (> a b)
    (recur b a)
    (if (divides? b a)
      a
      (recur (- b a) a))))
