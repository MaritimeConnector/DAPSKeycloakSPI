package de.intelligence.daps.spi;


import java.net.URI;
import java.util.UUID;

import org.keycloak.models.KeycloakSession;
import org.keycloak.representations.idm.ClientRepresentation;
import org.keycloak.services.clientregistration.AbstractClientRegistrationProvider;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

public final class DAPSClientRegistrationProvider extends AbstractClientRegistrationProvider {

    public static final String PROTOCOL = "DAPS";

    public DAPSClientRegistrationProvider(KeycloakSession session) {
        super(session);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createClient(DAPSClient client) {
        final ClientRepresentation representation = new ClientRepresentation();
        representation.setProtocol(DAPSClientRegistrationProvider.PROTOCOL);
        representation.setId(UUID.randomUUID().toString());
        representation.setClientId(client.getClientId());
        if (client.getName() != null) {
            representation.setName(client.getName());
        }
        if (client.getDescription() != null) {
            representation.setDescription(client.getDescription());
        }
        representation.setAttributes(client.getAdditionalClaims());
        final ClientRepresentation created = super.create(new DAPSClientRegistrationContext(super.session, representation, this));
        final URI uri = super.session.getContext().getUri().getAbsolutePathBuilder().path(created.getClientId()).build();
        return Response.created(uri).entity(created).build();
    }

}
