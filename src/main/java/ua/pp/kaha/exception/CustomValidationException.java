package ua.pp.kaha.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * Created by skokhanenko on 09.06.2017.
 */

@Provider
public class CustomValidationException extends Exception implements ExceptionMapper<CustomValidationException> {

    public CustomValidationException() {
    }

    public CustomValidationException(String message) {
        super(message);
    }

    @Override
    public Response toResponse(CustomValidationException e) {
        return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
    }
}
