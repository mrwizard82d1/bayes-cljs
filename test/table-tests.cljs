(ns bayes.table-tests
  (:require [cljs.test :as ct]
            [bayes.table :as bt]))

(enable-console-print!)

(ct/deftest a-b-b-wins
  (let [test-posteriors (->> (bt/posteriors :a-wins bt/models bt/priors)
                             (bt/posteriors :b-wins bt/models)
                             (bt/posteriors :b-wins bt/models))
        expected-values (map #(/ % 8616) [0 162 384 735 1440 1875 1920 1575 480 45 0])]
    (doseq [[expected actual] (map vector expected-values test-posteriors)]
      (ct/is (= (.toFixed expected 3) (.toFixed actual 3))))))

(set! *main-cli-fn* #(ct/run-tests))
