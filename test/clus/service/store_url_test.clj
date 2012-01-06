(ns clus.service.store-url-test
  (:use [clus.service.store-url])
  (:use clojure.test)
  (:use midje.sweet))

(facts "about storing urls"

  "adds the id and url"
  (store "http://url") => "23"
  (provided (id-for "http://url") => "23"
            (add-url "23" "http://url") => "23")
)

(facts "about looking up an id for a url"
  "urls already stored return the same id"
  (id-for "http://url") => "13"
  (against-background (before :facts (reset! id->url { "13" "http://url" })))

  "new urls get an incremented id"
  (id-for "http://newurl") => "14"
  (against-background (before :facts (reset! counter 13))))

(fact "adding a url"
  (add-url "123" "http://123") => "123"
  (get @id->url "123") => "http://123")
