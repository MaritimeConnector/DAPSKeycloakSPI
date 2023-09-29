package de.intelligence.daps.spi;

import org.keycloak.Config;
import org.keycloak.models.KeycloakSession;
import org.keycloak.models.KeycloakSessionFactory;
import org.keycloak.services.clientregistration.ClientRegistrationProvider;
import org.keycloak.services.clientregistration.ClientRegistrationProviderFactory;

public class DAPSClientRegistrationProviderFactory implements ClientRegistrationProviderFactory {

    public static final String ID = "DAPS_CLIENT_REG_PROV_FACTORY";

    @Override
    public ClientRegistrationProvider create(KeycloakSession session) {
        return new DAPSClientRegistrationProvider(session);
    }

    @Override
    public void init(Config.Scope config) {
        // not needed
    }

    @Override
    public void postInit(KeycloakSessionFactory factory) {
        // not needed
    }

    @Override
    public void close() {
        // not needed
    }

    @Override
    public String getId() {
        return DAPSClientRegistrationProviderFactory.ID;
    }

}
