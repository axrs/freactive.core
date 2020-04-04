(defproject io.axrs/freactive.core "0.2.0-SNAPSHOT"
  :description "Generic reactive atoms, expressions, cursors"
  :url "https://github.com/aaronc/freactive.core"
  :license {:name "Eclipse Public License"
            :url  "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies
  [[org.clojure/clojure "1.10.1"]
   [org.clojure/data.avl "0.1.0"]]
  :profiles
  {:dev {:dependencies
         [[org.clojure/clojurescript "1.10.597"]]}}
  :source-paths ["src"]
  :javac-options ["-Xlint:unchecked"]
  :java-source-paths ["src/java"])
