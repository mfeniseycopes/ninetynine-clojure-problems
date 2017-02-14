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
