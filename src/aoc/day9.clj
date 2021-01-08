(ns aoc.day9
  (:require [clojure.java.io :as io]
            [clojure.string :as str]))

(defn is-valid? [seed candidate]
  (let [sums (set (for [x seed y seed :when (not (= x y))] (+ x y)))]
    (contains? sums candidate)))

(defn part1 [input]
  (let [header-size 25
        chunks (partition (inc header-size) 1 (map #(Integer/parseInt %) input))]
    (some identity (for [chunk chunks
                         :let [seed (butlast chunk)
                               candidate (last chunk)]]
                     (when-not (is-valid? seed candidate)
                       candidate)))))
