(require 'cljs.build.api)

(cljs.build.api/watch (cljs.build.api/inputs "src" "test")
                      {:main 'bayes.table-tests
                       :output-to "out/bayes_tests.js"
                       :output-dir "out"
                       :verbose true
                       :target :nodejs})

