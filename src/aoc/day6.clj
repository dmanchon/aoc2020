(ns aoc.day6
  (:require [clojure.java.io :as io]
            [clojure.string :as str]))


(defn answers->set [answers]
  (let [stripped (str/replace answers #" " "")]
    (set (seq stripped))))

(defn part1 [lines]
  (->> (doall lines)
         (partition-by empty? ,,,)
         (map #(str/join " " %) ,,,)
         (filter (comp not str/blank?),,,)
         (map answers->set ,,,)
         (map count ,,,)
         (reduce + ,,,)))
