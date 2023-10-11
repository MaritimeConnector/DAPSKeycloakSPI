package de.intelligence.daps.spi;

import org.keycloak.Config;
import org.keycloak.events.EventBuilder;
import org.keycloak.models.KeycloakSession;
import org.keycloak.protocol.LoginProtocol;
import org.keycloak.protocol.oidc.OIDCLoginProtocolFactory;
import org.keycloak.protocol.oidc.OIDCProviderConfig;

public class DAPSLoginProtocolFactory extends OIDCLoginProtocolFactory {

    private OIDCProviderConfig shadowedConfig;

    @Override
    public void init(Config.Scope config) {
        super.init(config);
        this.shadowedConfig = new OIDCProviderConfig(config);
    }

    @Override
    public LoginProtocol create(KeycloakSession session) {
        return new DAPSLoginProtocol().setSession(session);
    }

    @Override
    public String getId() {
        return "openid-connect";
    }

    @Override
    public Object createProtocolEndpoint(KeycloakSession session, EventBuilder event) {
        return new DAPSService(session, event, this.shadowedConfig);
    }

    @Override
    public int order() {
        return Integer.MAX_VALUE;
    }

}
