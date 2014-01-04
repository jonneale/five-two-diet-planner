(ns five-two-diet.views.add-recipe
  (:require [hiccup.core :as hiccup]))

(defn render
  []
  (hiccup/html [:h1 "Add a recipe"
                [:form {:action "/recipe" :method "POST"}
                 [:select {:name "meal-type" :id "meal-type"}
                  [:option "Breakfast"]
                  [:option "Lunch"]
                  [:option "Dinner"]
                  [:option "Snack"]]
                 [:label {:for "meal-type"} "Meal Type"]
                 [:input {:type "text" :name "Name"}]
                 [:label {:for "name"} "Name"]
                 [:input {:type "text-area" :name "description"}]
                 [:label {:for "description"} "Description"]
                 [:input {:type "calories" :name "Calories"}]
                 [:label {:for "calories"} "Calories"]
                 [:button {:type "Submit"}]]]))
