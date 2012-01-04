(ns clus.views.redirect
  (:require [clus.views.common :as common])
  (:use [noir.core :only [defpage]]
        [hiccup.core :only [html]]))


(defpage [:get ["/:key" :key #".{4}"]] {:keys [key]} 
  (common/layout
   [:p (str "Welcome to bla bla " key) ]
   [:p [:div "huhu"]]))
