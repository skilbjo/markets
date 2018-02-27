(ns markets-etl.util-test
  (:require [clojure.test :refer :all]
            [clj-time.core :as time]
            [markets-etl.util :as util])
  (:gen-class))

(deftest ^:parallel string->decimal-test
  (testing "does string->decimal turn a string into a decimal type?"
    (is (= (BigDecimal. "0.01")
           (util/string->decimal "0.01"))))

  (testing "passing it nil"
    (is (= nil
           (util/string->decimal nil)))))

(deftest ^:parallel excel-date-epoc->joda-date-test
  (testing "does excel-date-series->joda-date turn an excel epoch into a date?"
    (is (= (time/date-time 2018 02 20)
           (util/excel-date-epoch->joda-date 43151)))))
