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
