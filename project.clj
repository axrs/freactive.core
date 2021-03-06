(defproject io.axrs/freactive.core "0.2.2-SNAPSHOT"
  :description "Generic reactive atoms, expressions, cursors. Forked from https://github.com/aaronc/freactive.core"
  :url "https://github.com/aaronc/freactive.core"
  :license {:name "Eclipse Public License"
            :url  "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/data.avl "0.1.0"]]
  :profiles {:dev {:dependencies [[thheller/shadow-cljs "2.8.94" :scope "provided"]
                                  [org.clojure/clojure "1.10.1" :scope "provided"]
                                  [org.clojure/clojurescript "1.10.597" :scope "provided"]]}})

