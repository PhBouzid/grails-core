/* Copyright 2004-2005 Graeme Rocher
 *
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
 */
package org.codehaus.groovy.grails.orm.hibernate.validation;

import org.codehaus.groovy.grails.validation.AbstractConstraint;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.validation.Errors;

/**
 * Class description here.
 *
 * @author Graeme Rocher
 * @since 0.4
 *        <p/>
 *        Created: Jan 23, 2007
 *        Time: 1:58:21 PM
 */
abstract class AbstractPersistentConstraint extends AbstractConstraint implements PersistentConstraint {

    protected HibernateTemplate constraintHibernateTemplate;

    /* (non-Javadoc)
     * @see org.codehaus.groovy.grails.orm.hibernate.validation.PersistentConstraint#setHibernateTemplate(org.springframework.orm.hibernate3.HibernateTemplate)
     */
    public void setHibernateTemplate(HibernateTemplate template) {
        this.constraintHibernateTemplate = template;
    }

    /* (non-Javadoc)
     * @see org.codehaus.groovy.grails.validation.ConstrainedProperty.AbstractConstraint#validate(java.lang.Object, org.springframework.validation.Errors)
     */
    public void validate(Object target, Object propertyValue, Errors errors) {
        if(constraintHibernateTemplate == null)
            throw new IllegalStateException("PersistentConstraint requires an instance of HibernateTemplate.");

        super.validate(target, propertyValue, errors);
    }
}