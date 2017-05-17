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

(deftest coprime?-test 
  (testing "#coprime?"
    (is (coprime? 1 1))
    (not (coprime? 100 125))
    (is (coprime? 7 19))))

(deftest phi-test 
  (testing "#phi"
    (is (phi 1) 0)
    (is (phi 10) 4)))

(deftest prime-factors-test
  (testing "#prime-factors"
    (is (prime-factors 1) '())
    (is (prime-factors 315) '(3 3 5 7))
    (is (prime-factors 19) '(19))))

(deftest prime-factors-mult-test
  (testing "#prime-factors-mult"
    (is (prime-factors-mult 1) '())
    (is (prime-factors-mult 315) '((3 2) (5 1) (7 1)))
    (is (prime-factors-mult 19) '((19 1)))))

(deftest phi-improved-test 
  (testing "#phi-improved"
    (is (phi-improved 1) 0)
    (is (phi-improved 10) 4)))

