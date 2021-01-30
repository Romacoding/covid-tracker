(ns app.components.home
  (:require [app.components.covid :as covid]
            [app.components.chart :as chart]))

(defn app-home 
  []
  [:div {:style { :width "100%" :height 300 }}
   [covid/covid]
   [chart/bar-covid ]
   [chart/graph-covid]])
