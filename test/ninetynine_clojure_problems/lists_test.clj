(ns ninetynine-clojure-problems.lists-test
  (:require [clojure.test :refer :all]
            [ninetynine-clojure-problems.lists :refer :all]))

(deftest my-last-test
  (testing "#my-last"
    (is (= (my-last '(1 2 3)) 3))
    (is (= (my-last '()) nil))))
