(require 'cljs.build.api)

(cljs.build.api/build "src"
                      {:main 'bayes-table.core
                       :output-to "out/bayes_table.js"
                       :output-dir "out"
                       :target :nodejs})

