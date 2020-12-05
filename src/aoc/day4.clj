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
       count))

(defn valid? [passport]
  (let [{:keys [byr iyr eyr hgt hcl ecl pid]} passport]
    (and
     byr
     (<= 1920 (Long/parseLong byr) 2002)
     iyr
     (<= 2010 (Long/parseLong iyr) 2020)
     eyr
     (<= 2020 (Long/parseLong eyr) 2030)
     hgt
     (let [[_ height unit] (re-find #"(\d+)(in|cm)" hgt)]
           (case unit
             "in" (<= 59 (Long/parseLong height) 76)
             "cm" (<= 150 (Long/parseLong height) 193)
             false))
     hcl
     (re-find #"^#[0-9a-f]{6}$" hcl)
     ecl
     (#{"amb" "blu" "brn" "gry" "grn" "hzl" "oth"} ecl)
     pid
     (re-find #"^\d{9}$" pid))))

(defn part2 [lines]
  (->> (doall lines)
       (partition-by empty? ,,,)
       (map #(str/join " " %) ,,,)
       (filter not-blank? ,,,)
       (map str->assoc ,,,)
       (map #(into {} %) ,,,)
       (map #(dissoc % :cid) ,,,)
       (filter valid? ,,,)
       count))
