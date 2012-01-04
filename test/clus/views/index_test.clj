(ns clus.views.index-test
  (:require [clus.views.index])
  (:require [noir.core :as core] )
  (:use clojure.test)
  (:use midje.sweet))

(fact (core/render "/") => (contains "clus"))
