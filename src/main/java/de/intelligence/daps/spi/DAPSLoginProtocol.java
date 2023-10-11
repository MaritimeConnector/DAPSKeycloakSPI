package de.intelligence.daps.spi;

import org.jboss.logging.Logger;
import org.keycloak.models.ClientSessionContext;
import org.keycloak.models.UserSessionModel;
import org.keycloak.protocol.oidc.OIDCLoginProtocol;
import org.keycloak.sessions.AuthenticationSessionModel;

import jakarta.ws.rs.core.Response;

public class DAPSLoginProtocol extends OIDCLoginProtocol {

    private static final Logger logger = Logger.getLogger(DAPSLoginProtocol.class);

    @Override
    public Response authenticated(AuthenticationSessionModel authSession, UserSessionModel userSession, ClientSessionContext clientSessionCtx) {
        logger.error("AUTH INTERCEPT");
        return super.authenticated(authSession, userSession, clientSessionCtx);
    }

}
