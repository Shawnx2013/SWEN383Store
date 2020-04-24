package Routes;

import spark.*;

import java.util.*;

public class UpdateProfileRoute implements Route {
    private static final String VIEW_NAME= "home.ftl";
    private TemplateEngine freeMarker;
    public UpdateProfileRoute(TemplateEngine freeMarker){
        this.freeMarker = freeMarker;
    }

    @Override
    public Object handle(Request request, Response response){
        System.out.println("Request received at RegisterRoute");
        System.out.println(request.body());
        Map<String, Object> map = new HashMap<>();

        map.put("title", "Welcome to SWEN383Store");

        return freeMarker.render(new ModelAndView(map, VIEW_NAME));
    }
}