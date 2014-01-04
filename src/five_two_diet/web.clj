(ns five-two-diet.web
  (:require [compojure.core     :as compojure :refer [GET POST]]
            [compojure.route    :as route]
            [ring.adapter.jetty     :as jetty]
            [ring.middleware.params :as params]
            [clojure.data.csv       :as csv]
            [clojure.java.io        :as io]
            [five-two-diet.views.add-recipe :as add-recipe]
            [five-two-diet.db       :as db]))

(compojure/defroutes app
  ;;http://localhost:8080
  (GET "/"
       []
       (db/get-all-recipes))

  (GET "/add-recipe"
       []
       (add-recipe/render))

  (POST "/recipe"
        [meal-type name description calories url]
        (clojure.string/join " - " [meal-type name description calories url]))

  (route/resources "/"))

(defn -main [& [port]]
  (println (str "Starting the switch-api on specified port...."))
  (jetty/run-jetty (params/wrap-params app) {:port (Integer/parseInt (or port "5000"))}))
