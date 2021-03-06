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

(deftest palindrome?-test
  (testing "#palindrome?"
    (is (= (palindrome? '()) true))
    (is (= (palindrome? '(1)) true))
    (is (= (palindrome? '(1 2)) false))
    (is (= (palindrome? '(1 2 3 2)) false))))

(deftest flatten-test
  (testing "#flatten"
    (is (= (flatten '()) '()))
    (is (= (flatten '(1 (2 3))) '(1 2 3)))))

(deftest compress-test
  (testing "#compress"
    (is (= (compress '()) '()))
    (is (= (compress '(1 1)) '(1)))
    (is (= (compress '(1 2 3 3 4 3 3)) '(1 2 3 4 3)))))

(deftest compress-x-test
  (testing "#compress-x"
    (is (= (compress-x '()) '()))
    (is (= (compress-x '(1 1)) '(1)))
    (is (= (compress-x '(1 2 3 3 4 3 3)) '(1 2 3 4 3)))))

(deftest pack-test
  (testing "#pack"
    (is (= (pack '()) '()))
    (is (= (pack '(1)) '((1))))
    (is (= (pack '(1 1)) '((1 1))))
    (is (= (pack '(1 2 2 3)) '((1) (2 2) (3))))))

(deftest pack-x-test
  (testing "#pack-x"
    (is (= (pack-x '()) '()))
    (is (= (pack-x '(1 1)) '((1 1))))
    (is (= (pack-x '(1 2 2 3)) '((1) (2 2) (3))))))

(deftest encode-test
  (testing "#encode"
    (is (= (encode '()) '()))
    (is (= (encode '(1 1)) '((2 1))))
    (is (= (encode '(1 2 2 3 3 3 3)) '((1 1) (2 2) (4 3))))))

(deftest encode-modified-test
  (testing "#encode-mod"
    (is (= (encode-mod '()) '()))
    (is (= (encode-mod '(1 1)) '((2 1))))
    (is (= (encode-mod '(1 2 2 3 3 3 3)) '(1 (2 2) (4 3))))))

(deftest decode-test
  (testing "#decode"
    (is (= (decode '()) '()))
    (is (= (decode  '((2 1))) '(1 1)))
    (is (= (decode  '((1 1) (2 2) (4 3))) '(1 2 2 3 3 3 3)))))

(deftest encode-direct-test
  (testing "#encode-direct"
    (is (= (encode-direct '()) '()))
    (is (= (encode-direct '(1 1)) '((2 1))))
    (is (= (encode-direct '(1 2 2 3 3 3 3)) '(1 (2 2) (4 3))))))

(deftest dupli-test
  (testing "#dupli"
    (is (= (dupli '()) '()))
    (is (= (dupli '(1 2 3)) '(1 1 2 2 3 3)))))

(deftest replicate-test 
  (testing "#replicate"
    (is (= (replicate '() 5) '()))
    (is (= (replicate '(1 2 3) 2) '(1 1 2 2 3 3)))
    (is (= (replicate '(1 2 3) 0) '()))))

(deftest drop-nth-test
  (testing "#drop-nth"
    (is (= (drop-nth '() 5) '()))
    (is (= (drop-nth '(1 2 3 4 5) 2) '(1 3 5)))
    (is (= (drop-nth '(1 2 3) 1) '()))))

(deftest split-test
  (testing "#split"
    (is (= (split '() 5) '(() ())))
    (is (= (split '(1 2 3) 2) '((1 2) (3))))))

(deftest splice-test
  (testing "#splice"
    (is (= (splice '() 1 3) '()))
    (is (= (splice '(1 2 3 4 5) 2 4) '(2 3))))) 

(deftest rotate-test
  (testing "#rotate"
    (is (= (rotate '() 3) '()))
    (is (= (rotate '(1 2 3 4) 2) '(3 4 1 2)))
    (is (= (rotate '(1 2 3 4) 5) '(2 3 4 1)))))

(deftest remove-kth-test 
  (testing "#remove-kth"
    (is (= (remove-kth '() 5) '()))
    (is (= (remove-kth '(1 2 3) 2) '(1 3)))))

(deftest insert-test
  (testing "#insert"
    (is (= (insert '() 3 5) '(5)))
    (is (= (insert '(1 2 3 4) 3 "x") '(1 2 "x" 3 4)))))

(deftest range-99-test
  (testing "#range-99"
    (= (range 1 2) '(1 2))
    (= (range 5 2) '(5 4 3 2))))

(deftest random-select-test
  (testing "#random-select"
    (= (count (random-select '(1 2 3 4) 3)) 3)
    (empty? (random-select '(1 2 3 4) 0))))

(deftest lotto-select-test
  (testing "#lotto-select"
    (= (count (lotto-select 4 3)) 3)
    (empty? (lotto-select 9 0))))


(deftest rand-permutation-test
  (testing "#rand-permuation"
    (= (count (rand-permutation '(1 2 3 4 5))) 5)
    (empty? (rand-permutation '()))))

(deftest combinations-test
  (testing "#combinations"
    (= (combinations '(1 2 3) 0) '(()))
    (= (combinations '(1 2 3) 2) '((1 2) (1 3) (2 3)))))

(deftest group-test
  (testing "#group"
    (= (count (group '(1 2 3) '(1 2))) 3)
    (= (count (group '(1 2 3) '(1 1 1))) 3)
    (= (count (group '(1 2 3) '(1 1 1))) 0)))

(deftest lsort-test
  (testing "#lsort"
    (= (first (lsort '((3 3 3) (1)))) '(1))))

(deftest lsort-freq-test
  (testing "#lsort-freq"
    (= (first (lsort-freq '((1) (2 2) (2 2)))) '(1))
    (= (last (lsort-freq '((1) (2 2) (2 2)))) '(2 2))))
