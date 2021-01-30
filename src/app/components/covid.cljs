(ns app.components.covid
  (:require [app.state :as state]))

(defn covid
  []
  [:div {:class "column card m-4"}
   [:h3 {:class "title is-3 has-text-centered"} "Covid Tracker"]
   [:p {:class "is-small has-text-centered m-2"} (str "Discover the latest data and information about the coronavirus (COVID-19) outbreak in your state.")]
   #_[:div {:class "m-4"}
    (let [{:keys [positive positiveIncrease recovered death deathIncrease hospitalizedCurrently inIcuCurrently]} @state/covid-info]
      [:div {:class "m-3"}
       [:p (str "Recovered: " recovered)]
       [:p (str "Hospitalized currently: " hospitalizedCurrently ". " "In ICU: " inIcuCurrently)]
       [:p (str "Positive cases: " positive)]
       [:p (str "Positive cases increase: " positiveIncrease)]
       [:p (str "Death: " death)]
       [:p (str "Death increase: " deathIncrease)]])]])
