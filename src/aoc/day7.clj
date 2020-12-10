(ns aoc.day7
  (:require [clojure.java.io :as io]
            [clojure.string :as str]))

(defn parse [line]
  (let [[[_ _ container] & others] (re-seq #"(?:^|(\d+ ))(\w+ \w+) bags?" line)]
    (assoc {}
           (keyword (str/replace container #" " "-"))
           (apply merge (map (fn [[_ num color]] (assoc {} (keyword (str/replace color #" " "-")) (Long/parseLong (str/trimr num)))) others)))))

(defn contains-bag? [container bag bags]
  (some? (bag (container bags))))

(defn can-contain? [bags bag]
  (map #(when (contains-bag? (key %) bag bags)
          (cons (key %) (can-contain? bags (key %)))) bags))

(defn part1 [lines]
  (let [bags (apply merge (map parse lines))]
    (count
     (set
      (filter some? (flatten (can-contain? bags :shiny-gold)))))))

(defn part2 [lines]
  )
