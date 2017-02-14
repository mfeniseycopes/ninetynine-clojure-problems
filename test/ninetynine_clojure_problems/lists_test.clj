(ns ninetynine-clojure-problems.lists-test
  (:require [clojure.test :refer :all]
            [ninetynine-clojure-problems.lists :refer :all]))

(deftest my-last-test
  (testing "#my-last"
    (is (= (my-last '(1 2 3)) 3))
    (is (= (my-last '()) nil))))

(deftest my-but-last-test
  (testing "#my-but-last"
    (is (= (my-but-last '()) nil))
    (is (= (my-but-last '(1)) nil))
    (is (= (my-but-last '(1 2 3)) 2))))
