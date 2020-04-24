package Controllers;

import Routes.*;
import spark.*;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.get;
import static spark.Spark.post;

public class HomeController{
    private static final String HOME = "/home";
    private TemplateEngine freeMarker;
    public HomeController(TemplateEngine freeMarker){
        this.freeMarker = freeMarker;
    }

    public void start(){
        get(HOME, new HomeRoute(freeMarker));
        post(HOME, new UpdateProfileRoute(freeMarker));
    }
}
