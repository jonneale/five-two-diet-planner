(ns five-two-diet.views.recipes
  (:require
   [five-two-diet.views.layout :as layout]
   [hiccup.core :as hiccup]))

(defn show
  [recipes]
  (hiccup/html (layout/shared
                [:h2 "Available recipes"]
                [:table {:class "table table-hover table-condensed table-striped"}
                 [:thead
                  [:tr
                   [:th "Meal type"]
                   [:th "Meal name"]
                   [:th "Meal description"]
                   [:th "Calories"]
                   [:th "Recipe Url"]
                   [:th "Like it?"]]]
                 [:tbody
                  (for [{:keys [id meal_type meal_name description calories recipe_url]} recipes]
                    [:tr {:id id}
                     [:td meal_type]
                     [:td meal_name]
                     [:td description]
                     [:td calories]
                     [:td recipe_url]
                     [:td [:button {:class "btn btn-default"} "No, hide"]]])]])))

(defn add
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
