(require '[cljs.build.api :as b])

(b/watch "src"
  {:main 'bayes.core
   :output-to "out/bayes.js"
   :output-dir "out"})
