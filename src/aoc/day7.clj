(ns aoc.day7
  (:require [clojure.java.io :as io]
            [clojure.string :as str]))

(defn parse [line]
  (let [[[_ _ container] & others] (re-seq #"(?:^|(\d+ ))(\w+ \w+) bags?" line)]
    (assoc {}
           (keyword (str/replace container #" " "-"))
           (apply merge (map (fn [[_ num color]] (assoc {} (keyword (str/replace color #" " "-"))) (Long/parseLong (str/trimr num))) others)))))


(defn str->keyword [s]
  (keyword (str/replace s #" " "-")))

(defn parse1 [line]
  (let [[[_ _ container] & others] (re-seq #"(?:^|(\d+) )(\w+ \w+) bags?" line)]
    {(str->keyword container) (reduce into (map (fn [[_ num color]] {(str->keyword color) (Long/parseLong num)}) others))}))

(defn find-bag [target bags]
  (doseq [[k v] bags] k))


(doseq [[k v] {:a 1}] v)
(find-bag :a  (parse1 "light red bags contain 1 bright white bag, 2 muted yellow bags."))




(for [z (merge {:b 3} {:a 1})] z)


(defn contains-bag? [container bag bags]
  (some? (bag (container bags))))

(defn can-contain? [bags bag]
  (map #(when (contains-bag? (key %) bag bags)
          (cons (key %) (can-contain? bags (key %)))) bags))


(def data (line-seq (io/reader (io/resource "sample.day7.txt"))))

(first data)




(:light-red (first (map parse1 data)))

(defn f1 [lines]
  (let [bags (map parse1 lines)]
    ))



(defn part1 [lines]
  (let [bags (apply merge (map parse1 lines))]
    (count
     (set
      (filter some? (flatten (can-contain? bags :shiny-gold)))))))

(defn part2 [lines]
  )
