(ns org.sg.cljs-rn-shadow-demo.main
  (:require
   [reagent.core :as reagent]
   [reagent.react-native :as rn]
   ["react-native" :as rnn]
   ;; ["react-native-reanimated" :default animated :refer (clockRunning EasingNode)]
   ;; [steroid.rn.core :as rn]
   ))

(def colors #{"green" "red" "blue" "orange" "magenta"})

(defn
  rand-text
  [n]
  [rn/text
   {:key n :style {:background-color (rand-nth (into [] colors))}}
   "fo"])

(defn
  open-app-button
  []
  [rn/Button "foo"])

(defn app-root []
  [rn/view
   (doall (map rand-text (range 50)))])

(def dimensions (.-Dimensions ^js rnn))
(def linking (.-Linking ^js rnn))

(defn init []
  (rn/register-reload-comp "CljsRnShadowDemo" app-root)
  (let [dimensions-change
        (fn [evt]
          (.openURL linking "https://stackoverflow.com/questions/58877079/how-to-open-one-app-from-another-app-react-native-android")
          (prn "dimension change: " evt))]
    (.addEventListener dimensions "change" dimensions-change)))


(comment


  (.openUrl linking "https://stackoverflow.com/questions/58877079/how-to-open-one-app-from-another-app-react-native-android")

  ;; (js/J)
  ;; (js/Dimensions)
  ;; (js/ReactNative)
  ;; (rnn/)
  ;; js/ReactNative

  ;; (js->clj dimensions)

  ;; (rn/)

  )
