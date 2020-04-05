(ns freactive.core-test
  (:refer-clojure :exclude [atom read-string])
  (:require
    [clojure.edn :refer [read-string]]
    [clojure.test :refer [deftest is run-tests]]
    [freactive.core :as f]))

(deftest rx-test1
  (let [r0 (f/atom 0)
        r1 (f/rx (inc @r0))]
    (is (= 1 @r1))
    (swap! r0 inc)
    (is (= 2 @r1))))

(deftest cursor-test
  (let [a (f/atom {:a {:b 2}})
        b (f/cursor a :a)
        c (f/rx (inc (:b @b)))]
    (is (= (:b @b) 2))
    (swap! a update-in [:a :b] inc)
    (is (= (:b @b) 3))
    (is (= @c 4))
    (swap! b update-in [:b] inc)
    (is (:b @b 4))
    (is (= @c 5))))

(deftest lens-test
  (let [a (f/atom {:a 0})
        l (f/lens-cursor a pr-str (fn [_ new-value]
                                    (read-string new-value)))]
    (is (= @l "{:a 0}"))
    (reset! l "{:b 1}")
    (is (= @a {:b 1}))
    (reset! a {:c 2})
    (is (= @l "{:c 2}"))))

(deftest associative-cursor-test
  (let [a (f/atom {:a {:b 2}})
        b (f/cursor a :a)
        c (f/rx (inc (:b @b)))]
    (is (= (:b @b) 2))
    (f/update-in! a [:a :b] inc)
    (is (= (:b @b) 3))
    (is (= @c 4))
    (f/update! b :b inc)
    (is (:b @b 4))
    (is (= @c 5))))

(deftest conj-pop-test
  (let [a (f/atom [1 2])
        a1 (f/cursor a 1)
        a2 (f/cursor a 2)]
    (is (= @a2 nil))
    (conj! a 3)
    (is (= @a [1 2 3]))
    (is (= @a2 3))
    (pop! a)
    (is (= @a2 nil))
    (is (= @a1 2))
    (pop! a)
    (is (= @a1 nil))))
