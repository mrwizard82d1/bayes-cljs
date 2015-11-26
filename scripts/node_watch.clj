(require '[cljs.build.api :as b])

(b/watch "src"
  {:main 'bayes-table.core
   :output-to "out/bayes_table.js"
   :output-dir "out"
   :target :nodejs})
