package de.intelligence.daps.spi;

import org.keycloak.models.KeycloakSession;
import org.keycloak.representations.idm.ClientRepresentation;
import org.keycloak.services.clientregistration.AbstractClientRegistrationContext;
import org.keycloak.services.clientregistration.ClientRegistrationProvider;

public class DAPSClientRegistrationContext extends AbstractClientRegistrationContext {

    public DAPSClientRegistrationContext(KeycloakSession session, ClientRepresentation client,
                                         ClientRegistrationProvider provider) {
        super(session, client, provider);
    }

}
