/**
 * Copyright 2012-2013 The original author or authors
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package org.groovykoans.koan09

import org.codehaus.groovy.runtime.InvokerHelper

import javax.xml.ws.spi.Invoker

class Robot {
    // ------------ START EDITING HERE ----------------------
    def x = 0, y = 0
    def left() {
        x--
    }
    def right() {
        x++
    }
    def up() {
        y++
    }
    def down() {
        y--
    }
    def invokeMethod(String name, args) {
         if (name ==~ /go(Left|Right|Up|Down)*/) {
             name.findAll(/(Left|Right|Up|Down)/, { match, String action ->
                 InvokerHelper.getMetaClass(this).invokeMethod(this, action.toLowerCase(), null)
             })
         }
    }
    // ------------ STOP EDITING HERE  ----------------------
}
