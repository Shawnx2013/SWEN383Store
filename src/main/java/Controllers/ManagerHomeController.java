package Controllers;

import Routes.*;
import spark.*;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.get;
import static spark.Spark.post;

public class ManagerHomeController{
    private static final String MANAGER = "/manager";
    private TemplateEngine freeMarker;
    public ManagerHomeController(TemplateEngine freeMarker){
        this.freeMarker = freeMarker;
    }

    public void start(){
        get(MANAGER, new managerHomeRoute(freeMarker));
    }
}