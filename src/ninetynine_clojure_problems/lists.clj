(ns ninetynine-clojure-problems.lists
  (:gen-class))

;; 1 - my-last
(defn my-last
  "Extracts last element from a list"
  [ls]
  (loop [[el & remaining] ls]
    (if (empty? remaining)
      el
      (recur remaining))))

;; 2 - my-but-last
(defn my-but-last
  "Extracts second to last element from a list"
  [ls]
  (loop [[el1 el2 & remaining] ls]
    (if (empty? remaining)
      (if (nil? el2)
        nil
        el1) 
      (recur (list* el2 remaining)))))
