package Routes;
import spark.*;

import java.util.HashMap;
import java.util.Map;

public class LoadItemRoute implements Route {
    private static final String VIEW_NAME= "home.ftl";
    private TemplateEngine freeMarker;
    public LoadItemRoute(TemplateEngine freeMarker){
        this.freeMarker = freeMarker;
    }

    @Override
    public Object handle(Request request, Response response){
        System.out.println("Request sent to Load Item Route");
        System.out.println("Type requested: " + request.queryParams("itemType"));

        Map<String, Object> map = new HashMap<>();
        return freeMarker.render("");
    }
}