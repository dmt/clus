(ns clus.service.store-url-test
  (:use [clus.service.store-url])
  (:use clojure.test)
  (:use midje.sweet))

(facts "about storing urls"

  "store returns an id for the given url"
  (store "http://url") => 23
  (provided (id-for "http://url") => 23 )

  "adds the id and url"
  (store "http://url") => 23
  (provided (id-for "http://url") => 23
            (add-url 23 "http://url") => 23)
  )

(facts "about looking up an id for a url"
  "urls already stored return the same id"
  (id-for "http://url") => 13
  (provided (url->id "http://url") => 13)

  "urls already stored return the same sdfid"
  (id-for "http://url") => 13
  (against-background (before :facts (reset! id->url { 13 "http://url" }))))


