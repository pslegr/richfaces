/*
 * JBoss, Home of Professional Open Source
 * Copyright 2013, Red Hat, Inc. and individual contributors
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package org.richfaces.photoalbum.ejbsearch;

import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.richfaces.photoalbum.service.Constants;

/**
 * Strategy to retrieve metatags
 *
 * @author Andrey Markhel
 */
public class SearchMetatagsStrategy implements ISearchStrategy {
    /**
     * Create query to retrieve metatags
     *
     * @param em - entityManager
     * @param params - map of additional params for this query
     * @param searchQuery - string to search
     * @return List of metatags
     */
    public Query getQuery(EntityManager em, Map<String, Object> params, String searchQuery) {
        Query query = em.createQuery(Constants.SEARCH_METATAG_QUERY);
        query.setParameter(Constants.QUERY_PARAMETER, Constants.PERCENT + searchQuery.toLowerCase() + Constants.PERCENT);
        return query;
    }

}
