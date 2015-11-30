(require '[cljs.build.api :as b])

(b/watch (b/inputs "src" "test")
  {:main 'bayes.table-tests
   :output-to "out/bayes.js"
   :output-dir "out"
   :target :nodejs})
