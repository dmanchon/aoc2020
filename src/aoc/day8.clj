(ns aoc.day8
  (:require [clojure.java.io :as io]
            [clojure.string :as str]))

(defn parse-line [line]
  (let [[op val] (str/split line #" ")]
    [(keyword op) (Integer/parseInt val)]))

(defn step [[ip acc history] program]
  (let [history (cons ip history)
        [op val] (nth program ip)]
    (case op
      :nop [(inc ip) acc history]
      :jmp [(+ ip val) acc history]
      :acc [(inc ip) (+ acc val) history])))

(defn run [program [ip acc history]]
  (if (contains? (set history) ip) acc
      (let [state (step [ip acc history] program)]
        (run program state))))

(defn part1 [lines]
  (let [program (map parse-line (doall lines))
        state [0 0 ()]]
    (run program state)))
