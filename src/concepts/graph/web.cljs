(ns concepts.graph.web
  (:require [reagent.core :as r]
            [concepts.graph :as graph]))

(defn rect [w h x y]
  [:rect
   {:width        w
    :height        h
    :fill         "none"
    :x            x
    :y            y
    :stroke       "#000000"
    :stroke-width 1}])

(defn text [s x y]
  [:text {:x           x
          :y           y
          :text-anchor "middle"
          :font-size   11}
   s])

(defn node [s x y]
  [:g 
   [rect (* (count s) 7) 11 x y]
   [text s (+ 13 x) (+ 9 y)]])

(defn edge [x1 y1 x2 y2]
  [:line {:x1 x1 :y1 y1 :x2 x2 :y2 y2
          :stroke "black"}])

(defn app []
  [:div#app
   [:h1 "concepts.graph.web"]
   [:svg {:width    "100%"
          :view-box (str "0 0 100 100")}
    [node "Root" 30 5]
    [edge 45 16 45 40]]])

(defn render []
  (r/render [app]
            (.getElementById js/document "root")))

(defn ^:dev/after-load start []
  (render)
  (js/console.log "start"))

(defn ^:export init []
  (start))

(defn ^:dev/before-load stop []
  (js/console.log "stop"))
