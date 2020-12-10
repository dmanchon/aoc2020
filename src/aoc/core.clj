(ns aoc.core
  (:require [clojure.java.io :as io]
            [aoc.day1 :as day1]
            [aoc.day2 :as day2]
            [aoc.day3 :as day3]
            [aoc.day4 :as day4]
            [aoc.day5 :as day5]
            [aoc.day6 :as day6]
            [aoc.day7 :as day7])
  (:gen-class))

(defn run [fn filename]
  (let [path (io/resource filename)
        solution (with-open [rdr (clojure.java.io/reader path)]
                (fn (line-seq rdr)))]
    solution))


(defn -main
  [& args]
  (println (time (run day7/part2 "sample.day7.txt")))
  (println (time (run day7/part1 "day7.txt")))
  (println (time (run day6/part2 "day6.txt")))
  (println (time (run day6/part1 "day6.txt")))
  (println (time (run day5/part2 "day5.txt")))
  (println (time (run day5/part1 "day5.txt")))
  (println (time (run day4/part2 "day4.txt")))
  (println (time (run day4/part1 "day4.txt")))
  (println (time (run day3/part2 "day3.txt")))
  (println (time (run day3/part1 "day3.txt")))
  (println (time (run day2/part2 "day2.txt")))
  (println (time (run day2/part1 "day2.txt")))
  (println (time (run day1/part2 "day1.txt")))
  (println (time (run day1/part1 "day1.txt"))))
