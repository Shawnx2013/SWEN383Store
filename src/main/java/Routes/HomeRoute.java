package Routes;

import spark.*;

import java.util.HashMap;
import java.util.Map;

public class HomeRoute implements Route{
    private static final String VIEW_NAME= "home.ftl";
    private TemplateEngine freeMarker;
    public HomeRoute(TemplateEngine freeMarker){
        this.freeMarker = freeMarker;
    }
    private String username = "user";
    @Override
    public Object handle(Request request, Response response){
        System.out.println("Request sent to HomeRoute");
        Map<String, Object> map = new HashMap<>();
        map.put("title", "Welcome " + username);

        return freeMarker.render(new ModelAndView(map, VIEW_NAME));
    }
}
