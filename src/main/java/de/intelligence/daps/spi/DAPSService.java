package de.intelligence.daps.spi;

import org.jboss.logging.Logger;
import org.keycloak.events.EventBuilder;
import org.keycloak.models.KeycloakSession;
import org.keycloak.protocol.oidc.OIDCLoginProtocolService;
import org.keycloak.protocol.oidc.OIDCProviderConfig;
import org.keycloak.protocol.oidc.TokenManager;
import org.keycloak.protocol.oidc.endpoints.TokenEndpoint;

import jakarta.ws.rs.Path;

public class DAPSService extends OIDCLoginProtocolService {

    private static final Logger logger = Logger.getLogger(DAPSService.class);

    private final KeycloakSession session;
    private final EventBuilder event;
    private final TokenManager tokenManager;

    public DAPSService(KeycloakSession session, EventBuilder event, OIDCProviderConfig providerConfig) {
        super(session, event, providerConfig);
        this.session = session;
        this.event = event;
        this.tokenManager = new TokenManager();
    }

    @Override
    @Path("token")
    public Object token() {
        logger.error("TOKEN FLOW INTERCEPT");
        // TODO validate certificate using OCSP and MIR
        return new TokenEndpoint(this.session, this.tokenManager, this.event);
    }

    // TODO add SECOM <-> MCP MIR endpoint mapping

}
