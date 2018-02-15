/*
 * Hibernate OGM, Domain model persistence for NoSQL datastores
 *
 * License: GNU Lesser General Public License (LGPL), version 2.1 or later
 * See the lgpl.txt file in the root directory or <http://www.gnu.org/licenses/lgpl-2.1.html>.
 */
package it.redhat.demo.remote.marshaller;

import java.io.IOException;

import org.infinispan.protostream.MessageMarshaller;

import it.redhat.demo.remote.model.ProtostreamPayload;

/**
 * @author Fabio Massimo Ercoli
 */
public class ProtostreamPayloadMarshaller implements MessageMarshaller<ProtostreamPayload> {

	public ProtostreamPayload readFrom(ProtoStreamReader reader) throws IOException {

		String id = reader.readString( "id" );
		Integer code = reader.readInt( "code" );
		String name = reader.readString( "name" );
		String description = reader.readString( "description" );

		ProtostreamPayload protostreamPayload = new ProtostreamPayload();

		protostreamPayload.put( "id", id );
		protostreamPayload.put( "code", code );
		protostreamPayload.put( "name", name );
		protostreamPayload.put( "description", description );

		return protostreamPayload;
	}

	public void writeTo(ProtoStreamWriter writer, ProtostreamPayload protostreamPayload) throws IOException {

		String id = protostreamPayload.get( "id" );
		Integer code = protostreamPayload.get( "code" );
		String name = protostreamPayload.get( "name" );
		String description = protostreamPayload.get( "description" );

		writer.writeString( "id", id );
		writer.writeInt( "code", code );
		writer.writeString( "name", name );
		writer.writeString( "description", description );

	}

	public Class<? extends ProtostreamPayload> getJavaClass() {
		return ProtostreamPayload.class;
	}

	public String getTypeName() {
		return "HibernateOGMGenerated.Project";
	}

}
