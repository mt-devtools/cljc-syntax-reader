
(ns syntax-reader.interpreter.metafunctions
    (:require [syntax-reader.interpreter.utils :as interpreter.utils]
              [vector.api                      :as vector]))

;; -- Ancestor / parent tag metafunctions -------------------------------------
;; ----------------------------------------------------------------------------

(defn no-tags-opened-f
  ; @ignore
  ;
  ; @description
  ; Returns the 'no-tags-opened?' metafunction.
  ;
  ; @param (string) n
  ; @param (map) tags
  ; @param (map) options
  ; @param (map) state
  ;
  ; @return (boolean)
  [n tags options state]
  ; @description
  ; Returns TRUE if there is no opened tag at the actual cursor position.
  ;
  ; @return (boolean)
  (fn [] (interpreter.utils/no-tags-opened? n tags options state)))

(defn tag-actual-depth-f
  ; @ignore
  ;
  ; @description
  ; Returns the 'tag-actual-depth' metafunction.
  ;
  ; @param (string) n
  ; @param (map) tags
  ; @param (map) options
  ; @param (map) state
  ; @param (keyword) tag-name
  ;
  ; @return (function)
  [n tags options state]
  ; @description
  ; Returns the actual opened depth of a specific tag.
  ;
  ; @param (keyword) tag-name
  ;
  ; @return (integer)
  (fn [tag-name] (interpreter.utils/tag-actual-depth n tags options state tag-name)))

(defn ancestor-tags-f
  ; @ignore
  ;
  ; @description
  ; Returns the 'ancestor-tags' metafunction.
  ;
  ; @param (string) n
  ; @param (map) tags
  ; @param (map) options
  ; @param (map) state
  ;
  ; @return (function)
  [n tags options state]
  ; @description
  ; Returns the ancestor tags of the actual cursor position.
  ;
  ; @param (keyword) tag-name
  ;
  ; @return (maps in vector)
  (fn [] (interpreter.utils/ancestor-tags n tags options state)))

(defn parent-tag-f
  ; @ignore
  ;
  ; @description
  ; Returns the 'parent-tag' metafunction.
  ;
  ; @param (string) n
  ; @param (map) tags
  ; @param (map) options
  ; @param (map) state
  ;
  ; @return (function)
  [n tags options state]
  ; @description
  ; Returns the parent tag of the actual cursor position.
  ;
  ; @return (map)
  (fn [] (interpreter.utils/parent-tag n tags options state)))

(defn tag-ancestor-f
  ; @ignore
  ;
  ; @description
  ; Returns the 'tag-ancestor?' metafunction.
  ;
  ; @param (string) n
  ; @param (map) tags
  ; @param (map) options
  ; @param (map) state
  ;
  ; @return (function)
  [n tags options state]
  ; @description
  ; Returns TRUE the given tag is an opened ancestor tag of the actual cursor position.
  ;
  ; @param (keyword) tag-name
  ;
  ; @return (boolean)
  (fn [tag-name] (interpreter.utils/tag-ancestor? n tags options state tag-name)))

(defn tag-parent-f
  ; @ignore
  ;
  ; @description
  ; Returns the 'tag-parent?' metafunction.
  ;
  ; @param (string) n
  ; @param (map) tags
  ; @param (map) options
  ; @param (map) state
  ;
  ; @return (function)
  [n tags options state]
  ; @description
  ; Returns TRUE if the given tag is the opened parent tag of the actual cursor position.
  ;
  ; @param (keyword) tag-name
  ;
  ; @return (boolean)
  (fn [tag-name] (interpreter.utils/tag-parent? n tags options state tag-name)))

(defn tag-opened-f
  ; @ignore
  ;
  ; @description
  ; Returns the 'tag-opened?' metafunction.
  ;
  ; @param (string) n
  ; @param (map) tags
  ; @param (map) options
  ; @param (map) state
  ;
  ; @return (function)
  [n tags options state]
  ; @description
  ; Returns TRUE the given tag is an opened ancestor tag of the actual cursor position.
  ;
  ; @param (keyword) tag-name
  ;
  ; @return (boolean)
  (fn [tag-name] (interpreter.utils/tag-ancestor? n tags options state tag-name)))

(defn tag-not-opened-f
  ; @ignore
  ;
  ; @description
  ; Returns the 'tag-not-opened?' metafunction.
  ;
  ; @param (string) n
  ; @param (map) tags
  ; @param (map) options
  ; @param (map) state
  ;
  ; @return (function)
  [n tags options state]
  ; @description
  ; Returns TRUE the given tag is NOT an opened ancestor tag of the actual cursor position.
  ;
  ; @param (keyword) tag-name
  ;
  ; @return (boolean)
  (fn [tag-name] (-> (interpreter.utils/tag-ancestor? n tags options state tag-name) not)))

;; -- Interpreter metafunctions -----------------------------------------------
;; ----------------------------------------------------------------------------

(defn interpreter-disabled-by-f
  ; @ignore
  ;
  ; @description
  ; Returns the 'interpreter-disabled-by' metafunction.
  ;
  ; @param (string) n
  ; @param (map) tags
  ; @param (map) options
  ; @param (map) state
  ;
  ; @return (function)
  [n tags options state]
  ; @description
  ; Returns the disabling tag's name if the interpreter is disabled by an opened tag.
  ;
  ; @return (keyword)
  (fn [] (interpreter.utils/interpreter-disabled-by n tags options state)))

(defn interpreter-disabled-f
  ; @ignore
  ;
  ; @description
  ; Returns the 'interpreter-disabled?' metafunction.
  ;
  ; @param (string) n
  ; @param (map) tags
  ; @param (map) options
  ; @param (map) state
  ;
  ; @return (function)
  [n tags options state]
  ; @description
  ; Returns TRUE if the interpreter is disabled by an opened tag.
  ;
  ; @return (boolean)
  (fn [] (interpreter.utils/interpreter-disabled? n tags options state)))

(defn interpreter-enabled-f
  ; @ignore
  ;
  ; @description
  ; Returns the 'interpreter-enabled?' metafunction.
  ;
  ; @param (string) n
  ; @param (map) tags
  ; @param (map) options
  ; @param (map) state
  ;
  ; @return (function)
  [n tags options state]
  ; @description
  ; Returns TRUE if the interpreter is NOT disabled by an opened tag.
  ;
  ; @return (boolean)
  (fn [] (interpreter.utils/interpreter-enabled? n tags options state)))

(defn reading-any-opening-match-f
  ; @ignore
  ;
  ; @description
  ; Returns the 'reading-any-opening-match?' metafunction.
  ;
  ; @param (string) n
  ; @param (map) tags
  ; @param (map) options
  ; @param (map) state
  ;
  ; @return (function)
  [n tags options state]
  ; @description
  ; Returns TRUE if any opening pattern's last found match is already started but not ended yet at the actual cursor position.
  ;
  ; @return (boolean)
  (fn [] (interpreter.utils/reading-any-opening-match? n tags options state)))

(defn reading-any-closing-match-f
  ; @ignore
  ;
  ; @description
  ; Returns the 'reading-any-closing-match?' metafunction.
  ;
  ; @param (string) n
  ; @param (map) tags
  ; @param (map) options
  ; @param (map) state
  ;
  ; @return (function)
  [n tags options state]
  ; @description
  ; Returns TRUE if any closing pattern's last found match is already started but not ended yet at the actual cursor position.
  ;
  ; @return (boolean)
  (fn [] (interpreter.utils/reading-any-closing-match? n tags options state)))

;; -- Operator metafunctions --------------------------------------------------
;; ----------------------------------------------------------------------------

(defn stop-f
  ; @ignore
  ;
  ; @description
  ; Returns the 'stop' metafunction.
  ;
  ; @param (string) n
  ; @param (map) tags
  ; @param (map) options
  ; @param (map) state
  ;
  ; @return (function)
  [_ _ _ _]
  ; @description
  ; Stops the interpreter immediatelly and the interpreter returns the parameter of this ('stop') function.
  ;
  ; @param (*) result
  ;
  ; @usage
  ; (stop "My output")
  ;
  ; @return (vector)
  ; [(keyword) stop-marker
  ;  (*) result]
  (fn [result] [:$stop result]))

(defn set-state-f
  ; @ignore
  ;
  ; @description
  ; Returns the 'set-state' metafunction.
  ;
  ; @param (string) n
  ; @param (map) tags
  ; @param (map) options
  ; @param (map) state
  ;
  ; @return (function)
  [_ _ _ _]
  ; @description
  ; Merges the given 'x' map onto the 'state' map before the next iteration.
  ;
  ; @param (map) x
  ; {:result (*)(opt)}
  ;
  ; @usage
  ; (set-state {:my-value "This will be available in the state from the next iteration."
  ;             :result "My output"})
  ;
  ; @return (vector)
  ; [(keyword) set-state-marker
  ;  (map) extra]
  (fn [x] [:$set-state x]))

;; -- Tag boundary functions --------------------------------------------------
;; ----------------------------------------------------------------------------

(defn tag-starts-f
  ; @ignore
  ;
  ; @description
  ; Returns the 'tag-starts?' metafunction.
  ;
  ; @param (string) n
  ; @param (map) tags
  ; @param (map) options
  ; @param (map) state
  ; {:actual-tags (maps in vector)
  ;  :cursor (integer)}
  ;
  ; @return (function)
  [_ _ _ {:keys [actual-tags cursor]}]
  ; @description
  ; Returns TRUE if the given tag's opening pattern's match starts at the actual cursor position.
  ;
  ; @param (keyword) tag-name
  ;
  ; @return (boolean)
  (fn [tag-name] (letfn [(f [%] (and (-> % :name      (= tag-name))
                                     (-> % :starts-at (= cursor))))]
                        (-> (vector/last-match actual-tags f) some?))))

(defn tag-opens-f
  ; @ignore
  ;
  ; @description
  ; Returns the 'tag-opens?' metafunction.
  ;
  ; @param (string) n
  ; @param (map) tags
  ; @param (map) options
  ; @param (map) state
  ; {:actual-tags (maps in vector)
  ;  :cursor (integer)}
  ;
  ; @return (function)
  [_ _ _ {:keys [actual-tags cursor]}]
  ; @description
  ; Returns TRUE if the given tag's opening pattern's match ends at the actual cursor position.
  ;
  ; @param (keyword) tag-name
  ;
  ; @return (boolean)
  (fn [tag-name] (letfn [(f [%] (and (-> % :name     (= tag-name))
                                     (-> % :opens-at (= cursor))))]
                        (-> (vector/last-match actual-tags f) some?))))

(defn tag-closes-f
  ; @ignore
  ;
  ; @description
  ; Returns the 'tag-closes?' metafunction.
  ;
  ; @param (string) n
  ; @param (map) tags
  ; @param (map) options
  ; @param (map) state
  ; {:actual-tags (maps in vector)
  ;  :cursor (integer)}
  ;
  ; @return (function)
  [_ _ _ {:keys [actual-tags cursor]}]
  ; @description
  ; Returns TRUE if the given tag's closing pattern's match starts at the actual cursor position.
  ;
  ; @param (keyword) tag-name
  ;
  ; @return (boolean)
  (fn [tag-name] (letfn [(f [%] (and (-> % :name      (= tag-name))
                                     (-> % :closes-at (= cursor))))]
                        (-> (vector/last-match actual-tags f) some?))))

(defn tag-ends-f
  ; @ignore
  ;
  ; @description
  ; Returns the 'tag-ends?' metafunction.
  ;
  ; @param (string) n
  ; @param (map) tags
  ; @param (map) options
  ; @param (map) state
  ; {:actual-tags (maps in vector)
  ;  :cursor (integer)}
  ;
  ; @return (function)
  [_ _ _ {:keys [actual-tags cursor]}]
  ; @description
  ; Returns TRUE if the given tag's closing pattern's match ends at the actual cursor position.
  ;
  ; @param (keyword) tag-name
  ;
  ; @return (boolean)
  (fn [tag-name] (letfn [(f [%] (and (-> % :name    (= tag-name))
                                     (-> % :ends-at (= cursor))))]
                        (-> (vector/last-match actual-tags f) some?))))
