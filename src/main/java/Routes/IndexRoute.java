package Routes;

import spark.*;

import java.util.HashMap;
import java.util.Map;

public class IndexRoute implements Route {
    private static final String VIEW_NAME= "index.ftl";
    private TemplateEngine freeMarker;
    public IndexRoute(TemplateEngine freeMarker){
        this.freeMarker = freeMarker;
    }

    @Override
    public Object handle(Request request, Response response){
        System.out.println("Request sent to IndexRoute");
        Map<String, Object> map = new HashMap<>();
        map.put("title", "Welcome to SWEN383Store");

        return freeMarker.render(new ModelAndView(map, VIEW_NAME));
    }
}
