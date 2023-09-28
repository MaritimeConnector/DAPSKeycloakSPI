package de.intelligence.daps.spi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.keycloak.models.ClientSessionContext;
import org.keycloak.models.KeycloakSession;
import org.keycloak.models.ProtocolMapperModel;
import org.keycloak.models.UserSessionModel;
import org.keycloak.protocol.oidc.OIDCLoginProtocol;
import org.keycloak.protocol.oidc.mappers.AbstractOIDCProtocolMapper;
import org.keycloak.protocol.oidc.mappers.OIDCAccessTokenMapper;
import org.keycloak.protocol.oidc.mappers.OIDCAttributeMapperHelper;
import org.keycloak.provider.ProviderConfigProperty;
import org.keycloak.representations.AccessToken;

public final class DAPSProtocolMapper extends AbstractOIDCProtocolMapper implements OIDCAccessTokenMapper {

    public static final String MAPPER_ID = "oidc-daps";
    public static final String MAPPER_TYPE = "Dynamic Attribute Token (DAT) Mapper";
    public static final String MAPPER_HELP = "A mapper that supports DATs as defined by IDS";

    @Override
    public String getDisplayCategory() {
        return AbstractOIDCProtocolMapper.TOKEN_MAPPER_CATEGORY;
    }

    @Override
    public String getDisplayType() {
        return DAPSProtocolMapper.MAPPER_TYPE;
    }

    @Override
    public String getHelpText() {
        return DAPSProtocolMapper.MAPPER_HELP;
    }

    @Override
    public List<ProviderConfigProperty> getConfigProperties() {
        return new ArrayList<>();
    }

    @Override
    public String getId() {
        return DAPSProtocolMapper.MAPPER_ID;
    }

    @Override
    public AccessToken transformAccessToken(AccessToken token, ProtocolMapperModel mappingModel, KeycloakSession session, UserSessionModel userSession, ClientSessionContext clientSessionCtx) {
        final Map<String, Object> otherClaims = token.getOtherClaims();
        // JSON-LD context (always)
        otherClaims.put("@context", "https://w3id.org/idsa/contexts/context.jsonld");
        // Type (always)
        otherClaims.put("@type", "ids:DatPayload");
        // Security profile (dynamic)
        otherClaims.put("securityProfile", "idsc:BASE_SECURITY_PROFILE");
        // Referring connector (optional)
        otherClaims.put("referringConnector", "http://test-url.de/");
        // Transport certificates SHA256 hashed (optional)
        otherClaims.put("transportCertsSha256", "changeme");
        // Extended guarantee (optional)
        otherClaims.put("extendedGuarantee", "idsc:USAGE_CONTROL_POLICY_ENFORCEMENT");

        super.setClaim(token, mappingModel, userSession, session, clientSessionCtx);

        return token;
    }

    public static ProtocolMapperModel create(String name, boolean accessToken, boolean idToken, boolean userInfo) {
        ProtocolMapperModel mapper = new ProtocolMapperModel();
        mapper.setName(name);
        mapper.setProtocolMapper(DAPSProtocolMapper.MAPPER_ID);
        mapper.setProtocol(OIDCLoginProtocol.LOGIN_PROTOCOL);
        Map<String, String> config = new HashMap<>();
        config.put(OIDCAttributeMapperHelper.INCLUDE_IN_ACCESS_TOKEN, "true");
        config.put(OIDCAttributeMapperHelper.INCLUDE_IN_ID_TOKEN, "true");
        mapper.setConfig(config);
        return mapper;
    }

}
