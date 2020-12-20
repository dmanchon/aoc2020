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
      :acc [(inc ip) (+ acc val) history]
      :end [nil acc history])))

(defn run [program [ip acc history] stop?]
  (if (stop? [ip acc history])
    [ip acc]
    (let [state (step [ip acc history] program)]
      (run program state stop?))))


(defn part1 [lines]
  (let [program (vec (map parse-line (doall lines)))
        state [0 0 ()]
        stop? (fn [[ip acc history]] (contains? (set history) ip))]
    (second (run program state stop?))))

(defn part2 [lines]
  (let [lines (doall lines)
        stop? (fn [[ip acc history]] (or (nil? ip) (contains? (set history) ip)))
        state [0 0 ()]
        original (vec (map parse-line (doall lines)))]
    (first
          (map second
               (filter #(nil? (first %))
                       (for [i (range (count lines))]
                         (let [program (update-in original [i 0] {:jmp :nop :nop :jmp :acc :acc})]
                           (run (conj program [:end 0]) state stop?))))))))
