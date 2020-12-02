(ns aoc.core
  (:require [clojure.java.io :as io]
            [aoc.day1 :as day1]
            [aoc.day2 :as day2])
  (:gen-class))

(defn run [fn filename]
  (let [path (io/resource filename)
        solution (with-open [rdr (clojure.java.io/reader path)]
                (fn (line-seq rdr)))]
    solution))


(defn -main
  [& args]
  (println (time (run day2/part2 "day2.txt")))
  (println (time (run day2/part1 "day2.txt")))
  (println (time (run day1/part2 "day1.txt")))
  (println (time (run day1/part1 "day1.txt"))))
