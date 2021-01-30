(ns app.components.chart
  (:require
   ["recharts" :as chart]
   [app.state :as state]))

(defn bar-covid 
  []
  [:> chart/ResponsiveContainer
  [:> chart/BarChart  {:data @state/covid-info :width 1200 :height 500  :margin {:top 5, :right 30, :bottom 5, :left 20}}
   [:> chart/XAxis {:dataKey "state" :type "category" :stroke "#8884d8"}]
   [:> chart/YAxis {:type "number"}]
   [:> chart/Tooltip {:width 100, :backgroundColor "#ccc"}]
   [:> chart/Legend]
   [:> chart/CartesianGrid {:stroke "#ccc" :strokeDasharray "3 3"}]
   [:> chart/Bar {:barSize 30 :stackId "d" :dataKey "deathIncrease" :fill "#FF8042"}]
   #_[:> chart/Bar {:barSize 30 :stackId "d" :dataKey "death" :fill "#8884d8"}]
   [:> chart/Bar {:barSize 30 :stackId "h" :dataKey "hospitalizedIncrease" :fill "#0088FE"}]
   #_[:> chart/Bar {:barSize 30 :stackId "h" :dataKey "hospitalizedCurrently" :fill "#82ca9d"}]
   [:> chart/Bar {:barSize 30 :stackId "p" :dataKey "positiveIncrease" :fill "#FFBB28"}]
   #_[:> chart/Bar {:barSize 30 :stackId "p" :dataKey "positive" :fill "#82ca9d"}]
   #_[:> chart/Bar {:barSize 30 :dataKey "recovered" :fill "#ffc658"}]]])

(defn graph-covid 
  []
  [:> chart/ResponsiveContainer
  [:> chart/LineChart  {:data @state/covid-info :width 1200 :height 500  :margin {:top 100, :right 20, :bottom 5, :left 20}}
   [:> chart/Line {:type "monotone" :dataKey "positive" :stroke "#FFBB28"}]
   [:> chart/Line {:type "monotone" :dataKey "death" :stroke "#FF8042"}]
   [:> chart/Line {:type "monotone" :dataKey "hospitalized" :stroke "#82ca9d"}]
   [:> chart/CartesianGrid {:stroke "#ccc" :strokeDasharray "5 5"}]
   [:> chart/XAxis {:dataKey "state"}]
   [:> chart/YAxis]
   [:> chart/Legend]
   [:> chart/Tooltip {:width 100, :backgroundColor "#ccc"}]]])
