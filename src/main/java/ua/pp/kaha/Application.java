package ua.pp.kaha;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;
import ua.pp.kaha.filters.AuthenticationFilter;
import ua.pp.kaha.services.AuthenticationService;
import ua.pp.kaha.services.MeasurementsService;

/**
 * Created by kaha on 16.02.2017.
 */
public class Application extends ResourceConfig {

    public Application() {
        register(AuthenticationFilter.class);
        register(MeasurementsService.class);
        register(AuthenticationService.class);
        register(JacksonFeature.class);

        packages("ua.pp.kaha");

        property("jersey.config.beanValidation.enableOutputValidationErrorEntity.server", "true");
        property(ServerProperties.BV_SEND_ERROR_IN_RESPONSE, false);
    }
}
