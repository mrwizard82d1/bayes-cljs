(ns bayes.core
  (:require [bayes.proportions :as bp]))

(enable-console-print!)

(def models [0.0 0.1 0.2 0.3 0.4 0.5 0.6 0.7 0.8 0.9 1.0])

(def prior-f {0.0 0.0, 0.1 0.02, 0.2 0.03, 0.3 0.05, 0.4 0.10, 0.5 0.15, 
               0.6 0.20, 0.7 0.25, 0.8 0.15, 0.9 0.05, 1.0 0.0})

(defn is-success [data] 
  (= data :a-wins))

(defn likelihood [data model]
  (if (is-success data)
    ((bp/proportions models identity) model)
    ((bp/proportions models #(- 1 %)) model)))

(defn update [data models priors-f likelihood]
  (let [data :a-wins
        likelihoods (bp/likelihoods data models likelihood)
        priors (bp/priors models prior-f)
        products (bp/products likelihoods priors)
        total-probability (bp/total-probability likelihoods priors)
        posteriors (bp/posteriors likelihoods priors)]
    {:models models
     :likelihoods likelihoods
     :priors priors
     :posteriors posteriors}
    ))

(defn -main [& args]
  (let [a-result (update :a-wins models prior-f likelihood)]
    (pprint a-result)))

(set! *main-cli-fn* -main)
