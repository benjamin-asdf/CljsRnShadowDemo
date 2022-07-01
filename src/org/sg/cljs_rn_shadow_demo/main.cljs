(ns org.sg.cljs-rn-shadow-demo.main
  (:require
   ["react-native" :as rnn]
   [steroid.rn.core :as rn]))

(def colors #{"green" "red" "blue" "orange" "magenta"})

(defn
  rand-text
  [n]
  [rn/text
   {:key n :style {:background-color (rand-nth (into [] colors))}}
   (rand-nth ["best" "hurr" "lala" "works"])])

(defn app-root []
  [rn/view
   (doall (map rand-text (range 50)))])

(def dimensions (.-Dimensions ^js rnn))
(def linking (.-Linking ^js rnn))

(defn init []
  (rn/register-reload-comp "CljsRnShadowDemo" app-root)
  (let [counter (atom 0)
        dimensions-change
        (fn [evt]
          (js/console.log (str "dimension change: " evt "prn counter: " @counter))
          (when (odd? (swap! counter inc))
            (.openURL linking "https://stackoverflow.com/questions/58877079/how-to-open-one-app-from-another-app-react-native-android")))]
    (.addEventListener dimensions "change" dimensions-change)))

(comment)
