(ns aoc.day3)

;; lines length
(defonce len 31)

(defn positions
  ([x-offset] (positions x-offset 0))
  ([x-offset n] (cons n (lazy-seq (positions x-offset (mod (+ x-offset n) len))))))

(defn walk [lines move-x move-y]
  (->> lines
       (keep-indexed (fn [i x] (when (= 0 (mod i move-y)) x)) ,,,)
       (interleave (positions move-x) ,,,)
       (partition 2 ,,,)
       (filter #(= \# (nth (seq (second %)) (first %))) ,,,)
       (count ,,,)))

(defn part1 [lines]
  (walk lines 3 1))

(defn part2 [lines]
  (* (walk lines 1 1)
     (walk lines 3 1)
     (walk lines 5 1)
     (walk lines 7 1)
     (walk lines 1 2)))
