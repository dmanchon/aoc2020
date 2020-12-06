(ns aoc.core-test
  (:require [clojure.test :refer :all]
            [aoc.core :refer :all]
            [aoc.day1 :as day1]
            [aoc.day2 :as day2]
            [aoc.day3 :as day3]
            [aoc.day4 :as day4]
            [aoc.day5 :as day5]
            [aoc.day6 :as day6]))

;;solutions

(deftest day1-1
  (testing "Day1 part1 solution"
    (is (= 996075 (run day1/part1 "day1.txt")))))

(deftest day1-2
  (testing "Day1 part2 solution"
    (is (= 51810360 (run day1/part2 "day1.txt")))))

(deftest day2-1
  (testing "Day2 part1 solution"
    (is (= 603 (run day2/part1 "day2.txt")))))

(deftest day2-2
  (testing "Day2 part2 solution"
    (is (= 404 (run day2/part2 "day2.txt")))))

(deftest day3-1
  (testing "Day3 part1 solution"
    (is (= 198 (run day3/part1 "day3.txt")))))

(deftest day3-2
  (testing "Day3 part2 solution"
    (is (= 5140884672 (run day3/part2 "day3.txt")))))

(deftest day4-1
  (testing "Day4 part1 solution"
    (is (= 254 (run day4/part1 "day4.txt")))))

(deftest day4-2
  (testing "Day4 part2 solution"
    (is (= 184 (run day4/part2 "day4.txt")))))

(deftest day5-1
  (testing "Day5 part1 solution"
    (is (= 928 (run day5/part1 "day5.txt")))))

(deftest day5-2
  (testing "Day5 part2 solution"
    (is (= 610 (run day5/part2 "day5.txt")))))

(deftest day6-1
  (testing "Day6 part1 solution"
    (is (= 6382 (run day6/part1 "day6.txt")))))
