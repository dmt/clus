(ns clus.views.index
  (:require [clus.views.common :as common]
            
            )
  (:use [noir.core :only [defpage]]
        [hiccup.core :only [html]]
        [hiccup.form-helpers]
        [clus.service.store-url :only [store]]))

(defpage "/" {:as params}
         (common/layout
          [:p "Welcome"]
          (form-to [:post "/create"]
                   (common/form-fields params))))

(defpage [:post "/create" ] {:as params} 
  (let [targetUrl (:targetUrl params) id (store targetUrl)]
   (common/layout [:p (str "created " id " for " targetUrl)])))

