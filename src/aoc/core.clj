(ns aoc.core
  (:require [clojure.java.io :as io])
  (:gen-class))

(defn run [fn filename]
  (let [path (io/resource filename)
        solution (with-open [rdr (clojure.java.io/reader path)]
                (fn (line-seq rdr)))]
    solution))

(defn day1 [lines]
  (let [target-sum 2020
        smaller? #(< % target-sum)
        lst (->> lines
                 (map #(Integer/parseInt %))
                 (sort #(compare %2 %1))
                 (filter smaller?)
                 doall)
        sums (for [x lst y lst
                   :when (= target-sum (+ x y))]
               (* x y))]
    (first (take 1 sums))))

(defn day1-part2 [lines]
  (let [target-sum 2020
        smaller? #(< % target-sum)
        lst (->> lines
                 (map #(Integer/parseInt %))
                 (sort #(compare %2 %1))
                 (filter smaller?)
                 doall)
        sums (for [x lst y lst z lst
                   :when (= target-sum (+ x y z))]
               (* x y z))]
    (first (take 1 sums))))

(defn -main
  [& args]
  (println (run day1-part2 "day1.txt"))
  (println (run day1 "day1.txt")))
