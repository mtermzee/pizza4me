package swa.boundry;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import io.quarkus.qute.TemplateInstance;
import io.quarkus.qute.CheckedTemplate;

@Path("home")
@Produces(MediaType.TEXT_HTML)
public class HomeResource {

    @CheckedTemplate
    public static class Templates {
        public static native TemplateInstance index();

        public static native TemplateInstance customer();
    }

    @GET
    public TemplateInstance get() {
        return Templates.index();
    }

    @GET
    @Path("customer")
    public TemplateInstance getCustomer() {
        return Templates.customer();
    }
}
