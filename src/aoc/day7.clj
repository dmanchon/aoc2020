(ns aoc.day7
  (:require [clojure.java.io :as io]
            [clojure.string :as str]))

(defn bag-str->keyword [s]
  (keyword (str/replace s #" " "-")))

(defn parse [line]
  (let [[[_ _ container] & others] (re-seq #"(?:^|(\d+) )(\w+ \w+) bags?" line)]
    (reduce into
            {(bag-str->keyword container)
             (reduce into
                     (map (fn [[_ num color]]
                            {(bag-str->keyword color) (Long/parseLong num)}) others))})))

(defn find-bag [target bags]
  (doseq [[k v] bags] k))

(defn contains-bag? [container bag bags]
  (some? (bag (container bags))))


(defn can-contain? [bags bag]
  (map #(when (bag bags)
          (cons (key %) (can-contain? bags (key %)))) bags))


(defn count-bags [target bags]
  (let [contents (target bags)]
    (if (some? contents)
      (apply + (map (fn [[k v]] (* v (inc (count-bags k bags)))) contents))
      1)))

(defn check-bags [target bags]
  (let [containers (keys (target bags))]
    (when (some? containers) (cons containers (map #(check-bags % bags) containers)))))


(def data (line-seq (io/reader (io/resource "day7.txt"))))



(count (set (filter some? (flatten (check-bags :shiny-gold (apply hash-map (reduce into (map parse data))))))))



(defn part1 [lines]
  (let [bags (apply hash-map (reduce into (map parse lines)))]
    (count
     (set
      (filter some? (flatten (check-bags :shiny-gold bags)))))))

(defn part2 [lines]
  (let [bags (apply hash-map (reduce into (map parse lines)))]
    (count-bags :shiny-gold bags)))
