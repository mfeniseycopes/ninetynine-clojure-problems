(ns ninetynine-clojure-problems.lists
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
  (map #(list (first %) (count %)) (pack col))) 




