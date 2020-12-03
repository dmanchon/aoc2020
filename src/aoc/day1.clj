(ns aoc.day1)

(defn part1 [lines]
  (let [target-sum 2020
        smaller? #(< % target-sum)
        lst (->> lines
                 (map #(Integer/parseInt %))
                 (filter smaller?))
        sums (for [x lst y lst
                   :when (= target-sum (+ x y))]
               (* x y))]
    (first sums)))

(defn part2 [lines]
  (let [target-sum 2020
        smaller? #(< % target-sum)
        lst (->> lines
                 (map #(Integer/parseInt %))
                 (filter smaller?))
        sums (for [x lst y lst z lst
                   :when (= target-sum (+ x y z))]
               (* x y z))]
    (first sums)))
