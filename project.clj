(defproject five-two-diet "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [compojure "1.1.5"]
                 [ring "1.2.0"]
                 [hiccup "1.0.4"]
                 [org.clojure/java.jdbc "0.3.0-alpha4"]
                 [mysql/mysql-connector-java "5.1.25"]
                 [org.clojure/data.csv "0.1.2"]]
  :plugins [[lein-ring "0.8.5"]]
  :min-lein-version "2.0.0"
  :main five-two-diet.web)
