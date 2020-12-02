(ns aoc.core-test
  (:require [clojure.test :refer :all]
            [aoc.core :refer :all]
            [aoc.day1 :as day1]
            [aoc.day2 :as day2]))

;;solutions

(deftest day1-1
  (testing "Day1 part1 solution"
    (is (= 996075 (run day1/part1 "day1.txt")))))

(deftest day1-2
  (testing "Day1 part2 solution"
    (is (= 51810360 (run day1/part2 "day1.txt")))))

(deftest day2-1
  (testing "Day2 part1 solution"
    (is (= 506 (run day2/part1 "day2.txt")))))

(deftest day2-2
  (testing "Day2 part2 solution"
    (is (= 443 (run day2/part2 "day2.txt")))))
