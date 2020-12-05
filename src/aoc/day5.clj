(ns aoc.day5
  (:require [clojure.string :as str]))

(defn boarding->binary [boarding]
  (map #(read-string (str "2r" %)) (as-> boarding code
                       (str/replace code #"B" "1")
                       (str/replace code #"F" "0")
                       (str/replace code #"L" "0")
                       (str/replace code #"R" "1")
                       [(subs code 0 7) (subs code 7)])))

(defn calc-id [[row column]]
  (+ column (* 8 row)))

(defn part1 [lines]
  (apply max (->> (doall lines)
            (map boarding->binary ,,,)
            (map calc-id ,,,))))
