/*
 * Copyright 2013 Haulmont Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License") you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.haulmont.vaadin.sample

import com.vaadin.server.VaadinRequest
import com.vaadin.ui.ComboBox
import com.vaadin.ui.UI
import com.vaadin.ui.VerticalLayout

public class SampleVaadinUI extends UI {

    @Override
    protected void init(VaadinRequest request) {
        def layout = new VerticalLayout()
        def combobox = new ComboBox("Hey")

        def container = new SuperBeanContainer<String, String>(String.class)

        container.addItem("1", "1")
        container.addItem("2", "3")
        container.addItem("2", "3")

        combobox.setContainerDataSource(container)

        combobox.setValue("10")

        layout.addComponent(combobox)

        setContent(layout)
    }
}