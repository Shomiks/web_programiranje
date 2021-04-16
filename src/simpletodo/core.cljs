(ns simpletodo.core
    (:require
      [reagent.core :as r]
      [reagent.dom :as rdom]
      [clojure.string :as str]))

;; -------------------------
;; Views


(defn todo-input [{:keys [title on-save on-stop]}]
  (let [val (r/atom title)
        stop #(do (reset! val "")
                  (if on-stop (on-stop)))
        save #(let [v (-> @val str str/trim)]
                (if-not (empty? v) (on-save v))
                (stop))]
    (fn [{:keys [id class placeholder]}]
      [:input {:type "text" :value @val
               :id id :class class :placeholder placeholder
               :on-blur save
               :on-change #(reset! val (-> % .-target .-value))
               :on-key-down #(case (.-which %)
                               13 (save)
                               27 (stop)
                               nil)}])))

(def todo-edit (with-meta todo-input
                 {:component-did-mount #(.focus (rdom/dom-node %))}))




;; -------------------------
;; Initialize app

(defn mount-root []
  (rdom/render [todo-input] (.getElementById js/document "app")))

(defn ^:export init! []
  (mount-root))
