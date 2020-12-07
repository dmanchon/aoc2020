(ns aoc.day7
  (:require [clojure.java.io :as io]
            [clojure.string :as str]))

(def data (->> "sample.day7.txt"
               io/resource
               io/reader
               line-seq))

(def line (first data))

(def l1 "light red bags contain 1 bright white bag, 2 muted yellow bags.")

(let [[container other](str/split line #"bags contain")
      containees (str/split other #"[,.]")]
  (map #(re-find #"\s?(\d+)\s\w+\s\w+)\sbags?[,.]" %) containees))

(str/split l1 #" bags contain ")

(def l2 "1 bright white bag, 2 muted yellow bags.")

(str/split l2 #"[.,]")


(map #(re-find #"(\d+)\s(\w+\s\w+)\sbags?" %) (str/split l2 #"[,.]"))
