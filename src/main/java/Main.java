import spark.TemplateEngine;
import spark.template.freemarker.FreeMarkerEngine;

import Core.*;

public class Main{
    private final Server server;

    public Main(Server server){
        this.server = server;
    }

    public static void main(String[] args){
        final TemplateEngine freeMarkerEngine = new FreeMarkerEngine();
        final Server server = new Server(freeMarkerEngine);

        final Main main = new Main(server);

        main.init();
        //Spark.port(4000);
        /*FreeMarkerEngine freemarker = new FreeMarkerEngine();
        //System.out.println("Server running on: " + )
        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new FreeMarkerEngine().render(
                    new ModelAndView(model, "/index.ftl")
            );
        });*/

        /*get("/test", (request, response) -> {
            StringWriter writer = new StringWriter();
            try {
                Template t2 = configuration.getTemplate("templates/test.ftl");
                t2.process(null, writer);
            }
            catch (Exception e) {

                Spark.halt(500);
            }
            return writer;
        });

        get("/Payment", (request, response) -> {
            StringWriter writer = new StringWriter();
            try {
                Template t2 = configuration.getTemplate("templates/Payment.ftl");
                t2.process(null, writer);
            }
            catch (Exception e) {

                Spark.halt(500);
            }
            return writer;
        });*/

    }//main

    private void init(){
        this.server.start();
    }
}
