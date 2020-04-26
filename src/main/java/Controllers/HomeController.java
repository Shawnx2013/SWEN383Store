package Controllers;

import Routes.*;
import spark.*;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.get;
import static spark.Spark.post;

public class HomeController{
    private static final String UPDATE = "/update";
    private static final String LOAD = "/load";
    private TemplateEngine freeMarker;
    public HomeController(TemplateEngine freeMarker){
        this.freeMarker = freeMarker;
    }

    public void start(){
        get(LOAD, new LoadItemRoute(freeMarker));
        post(UPDATE, new UpdateProfileRoute(freeMarker));
    }
}
