(ns ninetynine-clojure-problems.lists
  (:use [clojure.set :only [difference]])
  (:gen-class))

;; 1 - my-last
(defn my-last
  "Extracts last element from a list"
  [[head & tail]]
  (if (empty? tail)
    head 
    (recur tail)))

;; 2 - my-but-last
(defn my-but-last
  "Extracts second to last element from a list"
  [[head nxt & tail]]
  (if (nil? nxt)
    nil 
    (if (empty? tail)
      head 
      (recur (list* nxt tail)))))

;; 3 - my-kth
(defn my-kth
  [[head & tail] k]
  (if (< k 1)
    head
    (recur tail (dec k))))

;; 4 - length
(defn length
  "Returns the number of elements in a list"
  [col]
  (loop [recol col length 0]
    (if (empty? recol)
      length
      (recur (rest recol) (inc length))))) 

;; 5 - reverse
(defn reverse
  "Returns a reversed list"
  [col]
  (reduce conj '() col)) 

;; 6 - palindrome?
(defn palindrome?
  "Determines if collection is a palindrome."
  [col]
  (= col (reverse col)))

;; 7 - flatten
(defn flatten
  "Flattens a nested list"
  [col]
  (reduce 
    (fn [acc el]
      (concat acc (if (list? el) (flatten el) (list el))))
    '() 
    col)) 

;; 8 - compress
(defn compress
  "Removes duplicate repeating elements"
  [col]
  (reverse 
    (reduce 
      (fn [acc el]
        (if (= el (first acc))
          acc
          (cons el acc)))
        '() 
        col)))

;; 8.x - compress-x
(defn compress-x
  "Removes duplicate repreating elements"
  [col]
  (map first (partition-by identity col)))

;; 9 - pack
(defn pack
  "Pack conseqcutive elements into sublists"
  [col]
  (reverse 
    (reduce 
      (fn [acc el]
        (if (or (empty? acc) (not= el (first (first acc))))
          (cons (list el) acc)
          (cons (cons el (first acc)) (rest acc))))
      '() col)))

;; 9.x - pack-x
(defn pack-x
  "Pack consecutive elements into sublists"
  [col]
  (partition-by identity col))

;; 10 - encode
(defn encode
  "Create a run-length encoding of the elements"
  [col]
  (map #(list (count %) (first %)) (pack col))) 

;; 11 - encode-modified
(defn encode-mod
  "Create a run-length encoding of the elements with single elements not in sublists"
  [col]
  (map 
    (fn [el]
      (if (= (first el) 1)
        (first el)
        el))
    (encode col)))

;; 12 - decode
(defn decode
  "Decode modified encoded list"
  [col]
  (reduce 
    (fn [result [count & [val]]] 
      (into result (repeat count val))) 
    '() (reverse col)))

;; 13 - encode-direct
(defn encode-direct
  "Encode #encode-mod directly"
  [col]
  (map 
    (fn [pack]
      (let [pack-size (count pack)]
        (if (= pack-size 1)
          (first pack)
          (list pack-size (first pack))))) 
      (pack col)))

;; 14 - dupli
(defn dupli
  "Duplicate the elements of a list"
  [col]
  (mapcat #(list % %) col))

;; 15 - replicate
(defn replicate
  "Replicate the elements of a list a given number of times"
  [col n]
  (mapcat #(repeat n %) col))

;; 16 - drop
(defn drop-nth
  "Drop every n element"
  [col n]
  (keep-indexed 
    #(when (not= (mod (+ %1 1) n) 0) %2) 
    col))

;; 17 - split
(defn split
  "Split list at kth element"
  [col k]
  (list (take k col) (drop k col)))

;; 18 - splice
(defn splice
  "Remove ith to kth elements from a list"
  [col i k]
  (take (- k i) (drop (- i 1) col)))

;; 19 - rotate
(defn rotate
  "Rotate list n places to the left"
  [col n]
  (if (empty? col)
    col
    (let [s (if (> n (count col)) (mod n (count col)) n)]
      (concat (drop s col) (take s col)))))

;; 20 - remove-kth
(defn remove-kth
  "Remove kth element from a list and return the list"
  [col k]
  (concat (take (- k 1) col) (drop k col)))

;; 21 - insert
(defn insert
  "Insert element at kth position"
  [col k el]
  (let [[left right] (split col (- k 1))]
    (concat left (list el) right)))

;; 22 - range
(defn range-99
  "Create a list with all elements inside a given range"
  ([i j]
    (range-99 i j '()))
  ([i j acc]
   (if (= i j)
     (concat acc (list i))
     (recur ((if (< i j) inc dec) i) j (concat acc (list i))))))

;; 23 - random-select
(defn random-select
  "Randomly select k elements from the list"
  [col k]
  (loop [selected '() 
         remaining-col col 
         remaining-k k]
    (if (> remaining-k 0)
      (let [r (rand (count remaining-col))]
        (recur 
          (into selected (splice remaining-col r (inc r)))
          (remove-kth remaining-col r)
          (dec remaining-k)))
      selected)))

;; 24 - lotto-select
(defn lotto-select
  "Randomly select k elements from a range of 1->m"
  [k m]
  (random-select (range m) k))

;; 25 - rand-permutation
(defn rand-permutation
  "Randomly permute the elements of a list"
  [col]
  (random-select col (count col)))

;; 26 - combinations
(defn combinations
  "Generate combinations of length k from a list"
  [col k]
  (if (= k 0)
    '(())
    (if (empty? col)
      nil
      (let [[head & tail] col
            with (map #(cons head %) (combinations tail (dec k)))
            without (combinations tail k)]
        (concat with without)))))

;; 27 - group
(defn group
  "Group a collection"
  [col sizes]
  (if (empty? sizes)
    '(nil)
    (mapcat (fn [g]
              (map #(conj % g)
                   (group (apply list (clojure.set/difference (set col) (set g))) (rest sizes))))
            (combinations col (first sizes)))))

;; 28 - lsorts
(defn lsort
  "Sorts elements of a list based on their length"
  [col]
  (sort-by count col))

(defn lsort-freq
  "Sorts elements of a list based on their length frequency"
  [col]
  (apply concat
    (sort-by count 
             (vals (reduce 
                     (fn [hsh lst]
                       (let [ct (count lst)]
                         (assoc hsh ct (cons lst (or (get hsh ct) [])))))
                     {} col)))))
