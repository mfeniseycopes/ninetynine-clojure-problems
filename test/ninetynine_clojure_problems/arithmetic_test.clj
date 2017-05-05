(ns ninetynine-clojure-problems.arithmetic-test
  (:require [clojure.test :refer :all]
            [ninetynine-clojure-problems.arithmetic :refer :all]))

(deftest is-prime?-test
  (testing "#is-prime?"
    (is (is-prime? 1))
    (is (is-prime? 2))
    (not (is-prime? 4))
    (not (is-prime? 18))))
