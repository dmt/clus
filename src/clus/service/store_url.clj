(ns clus.service.store-url

  )

(defonce id->url (atom {}))
(defonce counter (atom 0))

(defn url->id [url]
  (key (first (filter #(= url (val %)) @id->url)))
  )

(defn id-for [url]
  (url->id url))

(defn add-url [id url]
  id)


(defn store [url]
  (add-url (id-for url) url))
