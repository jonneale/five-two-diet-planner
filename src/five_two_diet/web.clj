(ns five-two-diet.web
(:require [compojure.core     :as compojure :refer [GET]]
            [ring.adapter.jetty     :as jetty]
            [ring.middleware.params :as params]
            [clojure.data.csv       :as csv]
            [clojure.java.io        :as io]))

(compojure/defroutes app
  ;;http://localhost:8080
  (GET "/"
    []
    "The system works"))

(defn -main [& [port]]
  (println (str "Starting the switch-api on specified port...."))
  (jetty/run-jetty (params/wrap-params app) {:port (Integer/parseInt (or port "5000"))}))
