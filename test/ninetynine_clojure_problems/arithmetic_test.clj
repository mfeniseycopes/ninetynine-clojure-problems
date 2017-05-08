(ns ninetynine-clojure-problems.arithmetic-test
  (:require [clojure.test :refer :all]
            [ninetynine-clojure-problems.arithmetic :refer :all]))

(deftest is-prime?-test
  (testing "#is-prime?"
    (is (is-prime? 1))
    (is (is-prime? 2))
    (not (is-prime? 4))
    (not (is-prime? 18))))

(deftest greatest-common-divisor-test
  (testing "#greatest-common-divisor"
    (= (greatest-common-divisor 1 1) 1)
    (= (greatest-common-divisor 100 125) 25)
    (= (greatest-common-divisor 7 19) 1)))
