
(ns syntax-reader.api
    (:require [syntax-reader.comments.engine    :as comments.engine]
              [syntax-reader.core.check         :as core.check]
              [syntax-reader.default-patterns   :as default-patterns]
              [syntax-reader.grey-zones.engine  :as grey-zones.engine]
              [syntax-reader.interpreter.engine :as interpreter.engine]
              [syntax-reader.search.engine      :as search.engine]
              [syntax-reader.tags.defaults      :as tags.defaults]
              [syntax-reader.tags.engine        :as tags.engine]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

; syntax-reader.comments.engine
(def remove-commented-parts comments.engine/remove-commented-parts)
(def get-commented-parts    comments.engine/get-commented-parts)

; syntax-reader.core.check
(def position-escaped? core.check/position-escaped?)

; syntax-reader.default-patterns
(def CLJ-PATTERNS default-patterns/CLJ-PATTERNS)
(def CSS-PATTERNS default-patterns/CSS-PATTERNS)

; syntax-reader.grey-zones.engine
(def grey-zones grey-zones.engine/grey-zones)

; syntax-reader.interpreter.engine
(def interpreter interpreter.engine/interpreter)

; syntax-reader.search.engine
(def first-position search.engine/first-position)

; syntax-reader.tags.defaults
(def opening-brace-position   tags.defaults/opening-brace-position)
(def closing-brace-position   tags.defaults/closing-brace-position)
(def opening-bracket-position tags.defaults/opening-bracket-position)
(def closing-bracket-position tags.defaults/closing-bracket-position)
(def opening-paren-position   tags.defaults/opening-paren-position)
(def closing-paren-position   tags.defaults/closing-paren-position)

; syntax-reader.tags.engine
(def opening-match-position tags.engine/opening-match-position)
(def closing-match-position tags.engine/closing-match-position)
