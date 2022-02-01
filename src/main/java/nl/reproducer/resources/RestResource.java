package nl.reproducer.resources;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.faulttolerance.CircuitBreaker;
import org.eclipse.microprofile.faulttolerance.Retry;
import org.eclipse.microprofile.faulttolerance.Timeout;

@Path( "" )
@Retry( delay = 250L, maxRetries = 5 )
@Timeout( 5000L )
@CircuitBreaker( requestVolumeThreshold = 10 )
public class RestResource {

    @POST
    @Path( "/reproduce" )
    public Response test(String in) {
        if ( !in.isEmpty() ) {
            return Response.ok().build();
        }
        throw new IllegalStateException( "test" );
    }
}
