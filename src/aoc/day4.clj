(ns aoc.day4
  (:require [clojure.java.io :as io]
            [clojure.string :as str]))

(def not-blank? (complement str/blank?))

(defn str->assoc [line]
  (map (fn [[k v]] {(keyword k) v})
       (map #(str/split % #":") (str/split line #"[ \n]"))))

(def needed-keys ["byr" "iyr" "eyr" "hgt" "hcl" "ecl" "pid" "cid"])

(defn part1 [lines]
  (->> (doall lines)
       (partition-by empty? ,,,)
       (map #(str/join " " %) ,,,)
       (filter not-blank? ,,,)
       (map str->assoc ,,,)
       (map #(into {} %) ,,,)
       (map #(dissoc % :cid) ,,,)
       (filter #(= (dec (count needed-keys)) (count (keys %))) ,,,)
       count
      ))
