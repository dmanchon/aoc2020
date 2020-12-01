(ns aoc.core-test
  (:require [clojure.test :refer :all]
            [aoc.core :refer :all]
            [aoc.day1 :as day1]))

;;solutions

(deftest day1-1
  (testing "Day1 part1 solution"
    (is (= 996075 (run day1/part1 "day1.txt")))))

(deftest day1-2
  (testing "Day1 part2 solution"
    (is (= 51810360 (run day1/part2 "day1.txt")))))
