/*
 * Hibernate OGM, Domain model persistence for NoSQL datastores
 *
 * License: GNU Lesser General Public License (LGPL), version 2.1 or later
 * See the lgpl.txt file in the root directory or <http://www.gnu.org/licenses/lgpl-2.1.html>.
 */
package it.redhat.demo.remote.marshaller;

import java.io.IOException;

import org.infinispan.protostream.MessageMarshaller;

import it.redhat.demo.remote.model.ProtostreamId;

/**
 * @author Fabio Massimo Ercoli
 */
public class ProtostreamIdMarshaller implements MessageMarshaller<ProtostreamId> {

	public ProtostreamId readFrom(ProtoStreamReader reader) throws IOException {

		String id = reader.readString( "id" );

		ProtostreamId protostreamId = new ProtostreamId();
		protostreamId.put( "id", id );

		return protostreamId;
	}

	public void writeTo(ProtoStreamWriter writer, ProtostreamId protostreamId) throws IOException {

		String id = protostreamId.get( "id" );
		writer.writeString( "id", id );
	}

	public Class<? extends ProtostreamId> getJavaClass() {
		return ProtostreamId.class;
	}

	public String getTypeName() {
		return "HibernateOGMGenerated.Project_id";
	}

}
