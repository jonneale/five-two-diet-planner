(ns five-two-diet.db
  (:require [clojure.java.jdbc :as jdbc]))


(def env
  (keyword (get (System/getenv)
                "APP_ENV"
                "dev")))

(def db
  (if (= "production" env)
    (str "jdbc:" (get (System/getenv "CLEARDB_DATABASE_URL")))
    "jdbc:mysql://localhost:3306/five_two?user=root"))


(defn db-connection
  []
  {:connection-uri db})

(defn get-all-recipes
  []
  (jdbc/query (db-connection)
                   ["SELECT meal_name, description from meals"]))
(defn save-recipe
  []
  (jdbc/execute! (db-connection)
                 ["INSERT INTO passwords",]))
