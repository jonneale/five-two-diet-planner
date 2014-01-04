(ns five-two-diet.db
  (:require [clojure.java.jdbc :as jdbc]))


(def env
  (keyword (get (System/getenv)
                "APP_ENV"
                "dev")))

(def db-credentials
  {:url      (get (System/getenv) "DB_URL")
   :db-name  (get (System/getenv) "DB_NAME")
   :username (get (System/getenv) "DB_USERNAME")
   :password (get (System/getenv) "DB_PASSWORD")})

(def db
  (if (:url db-credentials)
    (str "jdbc:mysql://"
         (:url db-credentials)
         "/"
         (:db-name db-credentials)
         "?user=" (:username db-credentials)
         "&password=" (:password db-credentials)
         "&reconnect=true")
    "jdbc:mysql://localhost:3306/five_two?user=root"))

(defn get-url
  []
  db)

(defn db-connection
  []
  {:connection-uri db})

(defn get-all-recipes
  []
  (jdbc/query (db-connection)
                   ["SELECT meal_name, description from meals"]))
(defn save-recipe
  [meal-type name description calories url]
  (jdbc/execute! (db-connection)
                 ["INSERT INTO meals VALUES(0,?,?,?,?,?)"
                  meal-type name description url calories]))
