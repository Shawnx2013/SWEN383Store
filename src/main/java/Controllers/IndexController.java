package Controllers;


import spark.*;

import java.util.HashMap;
import java.util.Map;


public class IndexController implements Route{
    private static final String VIEW_NAME= "index.ftl";
    private TemplateEngine freeMarker;
    public IndexController(TemplateEngine freeMarker){
        this.freeMarker = freeMarker;
    }

    @Override
    public Object handle(Request request, Response response){
        Map<String, Object> map = new HashMap<>();
        map.put("title", "Welcome to SWEN383Store");

        return freeMarker.render(new ModelAndView(map, VIEW_NAME));
    }

    public static void main(String[] args) {

    }

}


