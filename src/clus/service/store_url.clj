(ns clus.service.store-url

  )

(defonce id->url (atom {}))
(defonce counter (atom 0))

(defn url->id [url]
  (if-let [entry (first (filter #(= url (val %)) @id->url))] (key entry))
  )

(defn id-for [url]
  (if-let [id (url->id url)]
    id
    (str (swap! counter + 1))))

(defn add-url [id url]
  (swap! id->url assoc id url)
  id)


(defn store [url]
  (add-url (id-for url) url))
