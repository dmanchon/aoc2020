(ns aoc.day1)

(defn part1 [lines]
  (let [target-sum 2020
        smaller? #(< % target-sum)
        lst (->> lines
                 (map #(Integer/parseInt %))
                 (sort #(compare %2 %1))
                 (filter smaller?)
                 doall)
        sums (for [x lst y lst
                   :when (= target-sum (+ x y))]
               (* x y))]
    (first (take 1 sums))))

(defn part2 [lines]
  (let [target-sum 2020
        smaller? #(< % target-sum)
        lst (->> lines
                 (map #(Integer/parseInt %))
                 (sort #(compare %2 %1))
                 (filter smaller?)
                 doall)
        sums (for [x lst y lst z lst
                   :when (= target-sum (+ x y z))]
               (* x y z))]
    (first (take 1 sums))))
