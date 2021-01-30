(ns app.core
  "This namespace contains your application and is the entrypoint for 'yarn start'."
  (:require [reagent.core :as r]
            [reagent.dom :as rdom]
            [app.state :as state]
            [app.components.home :as home]
            [app.api :as api]))

(api/get-covid)

#_(js/console.log (:positive @state/covid-info))

(defn ^:dev/after-load render
  "Render the toplevel component for this app."
  []
  (r/render [home/app-home] (.getElementById js/document "app")))

(defn ^:export main
  "Run application startup logic."
  []
  (render))
