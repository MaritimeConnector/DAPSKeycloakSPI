package de.intelligence.daps.spi;

import java.util.HashMap;
import java.util.Map;

import org.keycloak.Config;
import org.keycloak.events.EventBuilder;
import org.keycloak.models.ClientModel;
import org.keycloak.models.KeycloakSession;
import org.keycloak.models.KeycloakSessionFactory;
import org.keycloak.models.ProtocolMapperModel;
import org.keycloak.models.RealmModel;
import org.keycloak.protocol.LoginProtocol;
import org.keycloak.protocol.LoginProtocolFactory;
import org.keycloak.representations.idm.ClientRepresentation;

public class DAPSLoginProtocolFactory implements LoginProtocolFactory {

    @Override
    public Map<String, ProtocolMapperModel> getBuiltinMappers() {
        return new HashMap<>();
    }

    @Override
    public Object createProtocolEndpoint(KeycloakSession keycloakSession, EventBuilder eventBuilder) {
        return null;
    }

    @Override
    public void createDefaultClientScopes(RealmModel realmModel, boolean b) {

    }

    @Override
    public void setupClientDefaults(ClientRepresentation clientRepresentation, ClientModel clientModel) {

    }

    @Override
    public LoginProtocol create(KeycloakSession session) {
        return new DAPSLoginProtocol(session);
    }

    @Override
    public void init(Config.Scope config) {

    }

    @Override
    public void postInit(KeycloakSessionFactory factory) {

    }

    @Override
    public void close() {

    }

    @Override
    public String getId() {
        return DAPSClientRegistrationProvider.PROTOCOL;
    }

}
