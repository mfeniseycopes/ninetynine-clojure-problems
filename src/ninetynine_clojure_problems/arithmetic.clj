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
    #(and (not= potential %) (divides? potential %))
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

;; 33 - coprime?
(defn coprime?
  "Determine if two numbers are coprime"
  [a b]
  (= (greatest-common-divisor a b) 1))

;; 34 - totient
(defn phi 
  "Euler's totient function - calculates number of coprime less than given number"
  [n]
  (reduce #(if (coprime? %2 n) (inc %1) %1) 0 (range 1 n)))

;; 35 - prime-factors
(defn prime-factors
  "Find all the prime factors of a number"
  [n]
  (if (= n 1)
    '() 
    (let [factor (first (filter #(divides? n %) (range 2 (inc n))))]
      (cons factor (prime-factors (/ n factor))))))

;; 36 - prime-factors-mult
(defn prime-factors-mult
  "Finds a list of all prime factors and their multiplicities"
  [n]
  (map #(list (first %) (count %)) 
       (partition-by identity (prime-factors n))))

;; 37 - phi-improved
(defn phi-improved
  "Euler's totient function - calculates number of coprime less than given number"
  [n]
  (reduce (fn [acc [factor mult]] 
            (* acc (dec factor) (expt factor (dec mult)))) 
          1 (prime-factors-mult n)))

;; 39 - primes
(defn primes
  "Finds all the prime numbers in a range"
  [m n]
  (filter is-prime? (range m n)))

;; 40 - goldbachs
(defn goldbach
  "Finds the two primes which sum to a given positive even number"
  [n]
  (some (fn [p]
          (and (is-prime? p) (is-prime? (- n p)) (list p (- n p)))) 
        (range 2 (inc (/ n 2)))))

(defn print-goldbach
  [[p1 p2]]
  (printf "%s + %s = %s\n" p1 p2 (+ p1 p2)))

;; 41 - goldbach-list
(defn goldbach-list
  "Finds goldbach compositions for each even number in a range"
  [start end]
  ((comp #(run! print-goldbach %) (partial keep goldbach)) (range start end)))
