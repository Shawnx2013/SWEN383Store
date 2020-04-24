package Controllers;


import spark.*;

import java.util.HashMap;
import java.util.Map;

import Routes.*;

import static spark.Spark.*;

public class IndexController{
    public IndexController(TemplateEngine freeMarker){
        this.freeMarker = freeMarker;
    }

    public static final String INDEX = "/";
    //public static final String REGISTER = "";

    private final TemplateEngine freeMarker;

    public void start(){
        get(INDEX, new IndexRoute(freeMarker));
        //get("/", (request, response) -> {
        // return "html here"});
        post(INDEX, new RegisterRoute(freeMarker));
    }

}


