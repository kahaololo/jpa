package ua.pp.kaha;

import io.jsonwebtoken.impl.crypto.MacProvider;
import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;

import java.security.Key;

/**
 * Created by kaha on 16.02.2017.
 */
public class Application extends ResourceConfig {

    private static Key key;

    public Application() {
        this.setKey(MacProvider.generateKey());
        register(AuthenticationFilter.class);
        register(MeasurementsService.class);
        register(AuthenticationService.class);
        register(JacksonFeature.class);

        packages("ua.pp.kaha");

        register(new AbstractBinder() {
            @Override
            protected void configure() {
                bind(getKey()).to(Key.class);
            }
        });

        property("jersey.config.beanValidation.enableOutputValidationErrorEntity.server", "true");
        property(ServerProperties.BV_SEND_ERROR_IN_RESPONSE, false);
    }

    public void setKey(Key key) {
        this.key = key;
    }

    public Key getKey() {
        return key;
    }
}
