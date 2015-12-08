(ns bayes.table)

(def models {:a-wins [0.0 0.1 0.2 0.3 0.4 0.5 0.6 0.7 0.8 0.9 1.0]})

(def likelihood-a-wins (reduce #(assoc %1 %2 %2) {} (:a-wins models)))

(def priors {:a-wins [0.0, 0.02, 0.03, 0.05, 0.10, 0.15, 0.20, 0.25, 0.15, 0.05, 0.0]})

(defn likelihood [data model]
  (if (= data :a-wins)
    (likelihood-a-wins model)
    (- 1 (likelihood-a-wins model))))

(defn posteriors 
  ([data models priors]
   (posteriors data models priors likelihoods))
  ([data models priors likelihood-fn]
   (let [products (map #(* %1 %2) (likelihood-fn data models) priors)
         total-probability (reduce + products)]
     (map #(/ % total-probability) products)))) 

