(ns aoc.day2
  (:require [clojure.string :as str]))

(defn valid? [line]
  (let [[constraint target password] (str/split line #" ")
        [min max] (map #(Integer/parseInt %) (str/split constraint #"-"))
        target (first (seq (str/replace target #":" "")))
        length (count (filter #(= % target) (seq password)))]
    (<= min length max)))

(defn legacy-valid? [line]
  (let [[constraint target password] (str/split line #" ")
        [pos1 pos2] (map #(Integer/parseInt %) (str/split constraint #"-"))
        target (first (seq (str/replace target #":" "")))
        password (seq password)
        a (nth password (dec pos1) \0)
        b (nth password (dec pos2) \0)]
    (= 1 (count (filter true? [(= target a) (= target b)])))))

(defn part1 [lines]
  (count (filter valid? lines)))

(defn part2 [lines]
  (count (filter legacy-valid? lines)))
