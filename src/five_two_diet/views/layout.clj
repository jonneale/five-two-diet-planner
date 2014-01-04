(ns five-two-diet.views.layout
  (:require [hiccup.core :as hiccup]))

(defn shared
  [& content]
  `[:html
    [:head
     [:title "The Five Two Diet Planner"]
     [:link {:rel "stylesheet" :href "/stylesheets/bootstrap.min.css"}]
     [:link {:rel "stylesheet" :href "/stylesheets/app.css"}]
     [:script {:src "/js/bootstrap.min.js" :type "text/javascript"}]]
    [:body
     [:div {:class "container"}
      ~content]]])
