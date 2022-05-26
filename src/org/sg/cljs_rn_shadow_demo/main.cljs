(ns org.sg.cljs-rn-shadow-demo.main
  (:require
   [reagent.core :as reagent]
   ;; ["react-native" :as rnn]
   ;; ["react-native-reanimated" :default animated :refer (clockRunning EasingNode)]
   [steroid.rn.core :as rn]))

(def colors #{"green" "red" "blue" "orange" "magenta"})

(defn
  rand-text
  [n]
  [rn/text
   {:key n :style {:background-color (rand-nth (into [] colors))}}
   "fo"])

(defn app-root []
  [rn/view
   (doall (map rand-text (range 100)))])

(defn init []
  (rn/register-reload-comp "CljsRnShadowDemo" app-root))


(comment
  [rn/text
   {:style {:color "green" :background-color "red"}} "Foo "
   [foo]])
