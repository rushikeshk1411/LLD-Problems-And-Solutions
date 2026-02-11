package com.vegayan.globallogin.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.saml2.provider.service.registration.*;

@Configuration
public class SamlRegistrationConfig {

    @Bean
    public RelyingPartyRegistrationRepository relyingPartyRegistrationRepository() {

        RelyingPartyRegistration registration =
                RelyingPartyRegistrations
//                        .fromMetadataLocation(
//                                "https://portal.sso.ap-south-1.amazonaws.com/saml/metadata/MTAyODgxNzE3MjkyX2lucy02NTk1ZmMyMWVlNGMwMzEw"
//                        )
                        .fromMetadataLocation(
                                "https://portal.sso.ap-south-1.amazonaws.com/saml/metadata/MTAyODgxNzE3MjkyX2lucy02NTk1MWU3ZWU4NmNhNDQx"
                        )
                        .registrationId("aws-sso")
                        .entityId("urn:vegayan:global-login")
                        .assertionConsumerServiceLocation(
                                "http://10.27.144.225:8080/globallogin/login/saml2/sso/aws-sso"
                        )
                        .build();

        return new InMemoryRelyingPartyRegistrationRepository(registration);
    }
}
