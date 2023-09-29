package de.intelligence.daps.spi;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public final class DAPSClient {

    private String clientId;    // SKI:keyid:AKI
    private String description;
    private String name;
    private Map<String, String> additionalClaims;

    //TODO add possibility to add custom claims defined in the protocol mapper in the client creation process

}
