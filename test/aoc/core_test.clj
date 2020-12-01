(ns aoc.core-test
  (:require [clojure.test :refer :all]
            [aoc.core :refer :all :as aoc]))

(deftest day1-1
  (testing "Day1 part1 solution"
    (is (= 996075 (aoc/run aoc/day1 "day1.txt")))))

(deftest day1-2
  (testing "Day1 part2 solution"
    (is (= 51810360 (aoc/run aoc/day1-part2 "day1.txt")))))
