package hello;

import ro.pippo.core.Application;

public class Pippo extends Application {

    public static void main(String[] args) {
        ro.pippo.core.Pippo pippo = new ro.pippo.core.Pippo(new Pippo());

        // change default port
        pippo.getServer().getSettings().port(8080);

        // add routes for static content
        pippo.addPublicResourceRoute();
        pippo.addWebjarsResourceRoute();

        // start server
        pippo.start();
    }

    @Override
    protected void onInit() {

        // send a template as response
        GET("/", routeContext -> {
            routeContext.setLocal("greeting", "Hello World!");
            routeContext.render("hello.ftl");
        });

        // send a json as response
        GET("/json", routeContext -> {
            Contact contact = createContact();
            routeContext.json()
                    .send(contact);
        });

        // send xml as response
        GET("/xml", routeContext -> {
            Contact contact = createContact();
            routeContext.xml()
                    .send(contact);
        });
    }

    private Contact createContact() {
        Contact contact = new Contact();
        contact.setId(12345);
        contact.setName("John");
        contact.setPhone("0733434435");
        contact.setAddress("Sunflower Street, No. 6");
        return contact;
    }

}
