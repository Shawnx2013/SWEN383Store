package Core;

import Routes.RegisterRoute;
import spark.TemplateEngine;

import Controllers.*;

import static spark.Spark.get;
import static spark.Spark.staticFileLocation;

public class Server {
    public static final String HOME = "/";
    public static final String PAYMENT= "/payment";

    private final TemplateEngine freeMarker;

    public Server(final TemplateEngine templateEngine){
        this.freeMarker = templateEngine;
    }

    public void start(){
        staticFileLocation("/public");
        IndexController indexControl = new IndexController(freeMarker);
        indexControl.start();

        //get(HOME, new IndexController(freeMarker));
        //get(PAYMENT, new PaymentController(freeMarker));

        //test
        get("/test", new TestController(freeMarker));
    }
}
