(ns five-two-diet.views.add-recipe
  (:require
   [five-two-diet.views.layout :as layout]
   [hiccup.core :as hiccup]))

(defn render
  []
  (hiccup/html (layout/shared
                [:div {:class "col-md-9"}
                 [:h1 "Add a recipe"
                  [:form {:action "/recipe" :method "POST" :role "form-horizontal"}
                   [:div {:class "form-group"}
                    [:label {:for "meal-type"} "Meal Type"]
                    [:select {:name "meal-type" :id "meal-type"}
                     [:option "Breakfast"]
                     [:option "Lunch"]
                     [:option "Dinner"]
                     [:option "Snack"]]]
                   [:div {:class "form-group"}
                    [:label {:for "name"} "Name"]
                    [:input {:type "text" :name "name" :id "name"}]]
                   [:div {:class "form-group"}
                    [:label {:for "description"} "Description"]
                    [:input {:type "text-area" :name "description" :id "description"}]]
                   [:div {:class "form-group"}
                    [:label {:for "calories"} "Calories"]
                    [:input {:type "calories" :name "calories" :id "calories"}]]
                   [:div {:class "form-group"}
                    [:label {:for "url"} "Recipe URL"]
                    [:input {:type "text" :name "url" :id "url"}]]
                   [:button {:type "Submit" :class "btn btn-default"} "Submit"]]]])))