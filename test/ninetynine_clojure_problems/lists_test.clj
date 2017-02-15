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

(deftest my-kth-test
  (testing "#my-kth"
    (is (= (my-kth '() 1) nil))
    (is (= (my-kth '(1) 0) 1))
    (is (= (my-kth '(1 2 3) 2) 3))))

(deftest length-test
  (testing "#length"
    (is (= (length '()) 0))
    (is (= (length '(1 2 3)) 3))))

(deftest reverse-test
  (testing "#reverse"
    (is (= (reverse '()) '()))
    (is (= (reverse '(1 2 3)) '(3 2 1)))))

