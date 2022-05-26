(ns org.sg.cljs-rn-shadow-demo.main
  (:require [steroid.rn.core :as rn]))

(defn app-root []
  [rn/text "Hello"])

(defn init []
  (rn/register-reload-comp "CljsRnShadowDemo" app-root))
