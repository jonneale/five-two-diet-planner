(ns five-two-diet.web
  (:require [compojure.core     :as compojure :refer [GET POST]]
            [compojure.route    :as route]
            [ring.adapter.jetty     :as jetty]
            [ring.middleware.params :as params]
            [ring.util.response     :as response]
            [clojure.data.csv       :as csv]
            [clojure.java.io        :as io]
            [five-two-diet.views.recipes :as recipes]
            [five-two-diet.db       :as db]))

(compojure/defroutes app
  ;;http://localhost:8080
  (GET "/"
       []
       (recipes/show (db/get-all-recipes)))

  (GET "/add-recipe"
       []
       (recipes/add))

  (POST "/recipe"
        [meal-type name description calories url]
        (db/save-recipe meal-type name description (Integer/parseInt (str (or calories 0))) url)
        (response/redirect-after-post "/"))

  (GET "/debug"
       []
       (str "Env: "    (db/env)
            " db-url " (db/get-url)))

  (route/resources "/"))

(defn -main [& [port]]
  (println (str "Starting the switch-api on specified port...."))
  (jetty/run-jetty (params/wrap-params app) {:port (Integer/parseInt (or port "5000"))}))
