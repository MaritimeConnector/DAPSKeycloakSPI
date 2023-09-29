package de.intelligence.daps.spi;

import lombok.RequiredArgsConstructor;

import org.keycloak.events.EventBuilder;
import org.keycloak.models.AuthenticatedClientSessionModel;
import org.keycloak.models.ClientSessionContext;
import org.keycloak.models.KeycloakSession;
import org.keycloak.models.RealmModel;
import org.keycloak.models.UserSessionModel;
import org.keycloak.protocol.LoginProtocol;
import org.keycloak.sessions.AuthenticationSessionModel;

import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;

@RequiredArgsConstructor
public class DAPSLoginProtocol implements LoginProtocol {

    private final KeycloakSession session;

    @Override
    public LoginProtocol setSession(KeycloakSession keycloakSession) {
        return this;
    }

    @Override
    public LoginProtocol setRealm(RealmModel realmModel) {
        return this;
    }

    @Override
    public LoginProtocol setUriInfo(UriInfo uriInfo) {
        return this;
    }

    @Override
    public LoginProtocol setHttpHeaders(HttpHeaders httpHeaders) {
        return this;
    }

    @Override
    public LoginProtocol setEventBuilder(EventBuilder eventBuilder) {
        return this;
    }

    @Override
    public Response authenticated(AuthenticationSessionModel authenticationSessionModel,
                                  UserSessionModel userSessionModel, ClientSessionContext clientSessionContext) {
        return null;
    }

    @Override
    public Response sendError(AuthenticationSessionModel authenticationSessionModel, Error error) {
        return null;
    }

    @Override
    public Response backchannelLogout(UserSessionModel userSessionModel,
                                      AuthenticatedClientSessionModel authenticatedClientSessionModel) {
        return null;
    }

    @Override
    public Response frontchannelLogout(UserSessionModel userSessionModel,
                                       AuthenticatedClientSessionModel authenticatedClientSessionModel) {
        return null;
    }

    @Override
    public Response finishBrowserLogout(UserSessionModel userSessionModel,
                                        AuthenticationSessionModel authenticationSessionModel) {
        return null;
    }

    @Override
    public boolean requireReauthentication(UserSessionModel userSessionModel,
                                           AuthenticationSessionModel authenticationSessionModel) {
        return false;
    }

    @Override
    public void close() {

    }

}
