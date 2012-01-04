(ns clus.views.index
  (:require [clus.views.common :as common])
  (:use [noir.core :only [defpage]]
        [hiccup.core :only [html]]))

(defpage [:get "/aaa/bbb"] []
         (common/layout
          [:p "Welcome to bla bla " ]
          [:p [:div "huhu"]]))

(defpage "/" []
         (common/layout
           [:p "Welcome to clus"]))

