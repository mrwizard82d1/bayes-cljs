(ns bayes.proportions)

(defn proportions [models proportion-f]
  (reduce #(assoc %1 %2 (proportion-f %2)) {} models))

(defn priors [models priors-f]
  (reduce #(assoc %1 %2 (priors-f %2)) {} models))

(defn likelihoods [data models likelihood-f]
  (reduce #(assoc %1 %2 (likelihood-f data %2)) {} models))

(defn products [likelihoods priors]
  (map #(* (likelihoods %) (priors %)) (keys likelihoods)))

(defn total-probability [likelihoods priors]

  (reduce + (products likelihoods priors)))

(defn posteriors [likelihoods priors]
  (map #(/ % (total-probability likelihoods priors)) (products likelihoods priors)))
