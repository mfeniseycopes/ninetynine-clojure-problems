(ns ninetynine-clojure-problems.arithmetic
  (:use [clojure.math.numeric-tower])
  (:gen-class))

;; 31 - is-prime?
(defn is-prime?
  "Determine if a given integer is prime"
  [potential]
  (not-any? 
    #(and (not= potential %) (zero? (mod potential %)))
    (cons 2 (range 3 (inc (first (exact-integer-sqrt potential))) 2))))
