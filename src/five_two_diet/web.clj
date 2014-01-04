(ns five-two-diet.web
  (:require [compojure.core     :as compojure :refer [GET]]
            [ring.adapter.jetty     :as jetty]
            [ring.middleware.params :as params]
            [clojure.data.csv       :as csv]
            [clojure.java.io        :as io]
            [five-two-diet.views.add-recipe :as add-recipe]))

(compojure/defroutes app
  ;;http://localhost:8080
  (GET "/"
       []
       "The system works")

  (GET "/add-recipe"
       []
       (add-recipe/render)))

(defn -main [& [port]]
  (println (str "Starting the switch-api on specified port...."))
  (jetty/run-jetty (params/wrap-params app) {:port (Integer/parseInt (or port "5000"))}))
