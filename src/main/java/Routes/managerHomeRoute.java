package Routes;

import spark.*;

import java.util.HashMap;
import java.util.Map;

public class managerHomeRoute implements Route{
    private static final String VIEW_NAME= "managerHome.ftl";
    private TemplateEngine freeMarker;
    public managerHomeRoute(TemplateEngine freeMarker){
        this.freeMarker = freeMarker;
    }
    private String username = "user";
    @Override
    public Object handle(Request request, Response response){
        System.out.println("Request sent to managerHomeRoute");
        Map<String, Object> map = new HashMap<>();
        map.put("title", "Welcome " + username);

        return freeMarker.render(new ModelAndView(map, VIEW_NAME));
    }
}
