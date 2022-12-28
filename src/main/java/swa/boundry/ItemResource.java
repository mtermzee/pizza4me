package swa.boundry;

import java.math.BigDecimal;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import io.quarkus.qute.TemplateInstance;
import swa.entity.Item;
import io.quarkus.qute.Template;
import io.quarkus.qute.CheckedTemplate;

@Path("item")
@Produces(MediaType.TEXT_HTML)
public class ItemResource {

    @CheckedTemplate
    public static class Templates {
        public static native TemplateInstance item(Item item);
    }

    /*
     * @Inject
     * ItemService service;
     */

    /*
     * @Inject
     * Template item;
     */

    @GET
    // @Path("{id}")
    public TemplateInstance get() {
        Item item = new Item();
        item.name = "Test";
        item.price = new BigDecimal(100);
        return Templates.item(item);

        // return Templates.item(service.findItem(id));
    }
}