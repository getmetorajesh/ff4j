package org.ff4j.services.domain;

/*
 * #%L
 * ff4j-spring-services
 * %%
 * Copyright (C) 2013 - 2016 FF4J
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */


import org.ff4j.property.BasePropertyBean;
import org.ff4j.property.Property;
import org.ff4j.property.util.PropertyFactory;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * @author <a href="mailto:paul58914080@gmail.com">Paul Williams</a>
 */
public class PropertyApiBean extends BasePropertyBean implements Serializable {

    private static final long serialVersionUID = -5366099799518640405L;

    public PropertyApiBean() {
        super();
    }

    public PropertyApiBean(Property<?> property) {
        if (property != null) {
            this.name = property.getName();
            this.description = property.getDescription();
            this.type = property.getType();
            this.value = property.asString();
            this.fixedValues = new HashSet<String>();
            Set<?> values = property.getFixedValues();
            if (values != null) {
                for (Object object : values) {
                    this.fixedValues.add(object.toString());
                }
            }
        }
    }

    public Property asProperty() {
        return PropertyFactory.createProperty(name, type, value, description, fixedValues);
    }
}
