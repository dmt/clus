(ns clus.views.index
  (:require [clus.views.common :as common])
  (:use [noir.core :only [defpage]]
        [hiccup.core :only [html]]
        [hiccup.form-helpers]))

(defonce ids->values (atom {}))
(defonce counter (atom 0))

(defpage "/" {:as params}
         (common/layout
          [:p "Welcome"]
          (form-to [:post "/create"]
                   (common/form-fields params))))

(defpage [:post "/create" ] {:as params}
  (swap! ids->values assoc (swap! counter + 1) (:targetUrl params))
  (common/layout [:p (str "created " @counter " for " (:targetUrl params))])
  )

