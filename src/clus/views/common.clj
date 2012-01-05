(ns clus.views.common
  (:use [noir.core :only [defpartial]]
        [hiccup.page-helpers :only [include-css html5]]
        [hiccup.form-helpers :only [label text-field]]))

(defpartial layout [& content]
            (html5
              [:head
               [:title "clus"]
               (include-css "/css/reset.css")
               ]
              [:body
               [:div#wrapper
                content]]))

(defpartial form-fields [{:keys [targetUrl]}]
  (label "targetUrl" "Url: ")
  (text-field "targetUrl" targetUrl)
  )
