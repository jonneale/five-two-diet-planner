(ns five-two-diet.db
  (:require [clojure.java.jdbc :as jdbc]))


(def db
  (if-let [db-url (get (System/getenv) "CLEARDB_DATABASE_URL")]
    (str "jdbc:" db-url)
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
