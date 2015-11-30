(require 'cljs.build.api)

(cljs.build.api/build "src"
                      {:main 'bayes.core
                       :output-to "out/bayes.js"
                       :output-dir "out"
                       :target :nodejs})

