(require '[cljs.build.api :as b])

(b/watch (b/inputs "src")
  {:main 'bayes.core
   :output-to "out/bayes.js"
   :output-dir "out"
   :target :nodejs})
