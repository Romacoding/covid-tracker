(ns app.api
  (:require-macros [cljs.core.async.macros :refer [go]])
  (:require [cljs-http.client :as http]
            [cljs.core.async :refer [<!]]
            [app.state :as state]))

(defn apply-fn-to-hashmap [f m]
  (into {} (for [[k v] m ] [k (f v)])))

(defn check-negative [v]
  (if (< v 0) (- v) v))

(defn get-covid 
  "Function to call API endpoint. Returns a response map with covid info for the requested region"
  []
  (go (let [response (<! (http/get "https://api.covidtracking.com/v1/states/current.json" {:with-credentials? false}))]
        (if (= (:status response) 200) (:body response) (prn "Could not get covid info"))
        (js/console.log (clj->js (:body response)))
        (reset! state/covid-info (mapv #(apply-fn-to-hashmap check-negative %) (:body response))))))
