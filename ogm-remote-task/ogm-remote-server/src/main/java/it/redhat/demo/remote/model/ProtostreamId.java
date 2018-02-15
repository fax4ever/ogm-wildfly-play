/*
 * Hibernate OGM, Domain model persistence for NoSQL datastores
 *
 * License: GNU Lesser General Public License (LGPL), version 2.1 or later
 * See the lgpl.txt file in the root directory or <http://www.gnu.org/licenses/lgpl-2.1.html>.
 */
package it.redhat.demo.remote.model;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Fabio Massimo Ercoli
 */
public class ProtostreamId {

	private Map<String, Object> content = new HashMap<String, Object>();

	public void put(String key, Object value) {
		content.put( key, value );
	}

	public <T> T get(String key) {
		return (T) content.get( key );
	}

}
