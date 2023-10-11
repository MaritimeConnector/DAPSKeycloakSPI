package de.intelligence.daps.spi;

import org.keycloak.events.EventBuilder;
import org.keycloak.models.KeycloakSession;
import org.keycloak.protocol.oidc.TokenManager;
import org.keycloak.protocol.oidc.endpoints.TokenEndpoint;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

public class CustomTokenEndpoint extends TokenEndpoint {

    public CustomTokenEndpoint(KeycloakSession session, TokenManager tokenManager, EventBuilder event) {
        super(session, tokenManager, event);
    }

    @POST
    @Override
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response processGrantRequest() {
        return super.processGrantRequest();
    }

    public Response clientCredentialsGrant() {
        final Response response = super.clientCredentialsGrant();
        // TODO remove useless claims to be fully compliant with IDS DAT
        return response;
    }

}
