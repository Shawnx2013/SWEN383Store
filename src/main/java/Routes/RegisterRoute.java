package Routes;

import spark.*;
import com.google.gson.*;
import java.util.*;

public class RegisterRoute implements Route {
    private static final String VIEW_NAME= "index.ftl";
    private TemplateEngine freeMarker;
    public RegisterRoute(TemplateEngine freeMarker){
        this.freeMarker = freeMarker;
    }

    @Override
    public Object handle(Request request, Response response){
        System.out.println("Request received at RegisterRoute");
        System.out.println(request.body());
        //Customer cust = new Gson()
        System.out.println(request.queryParams("inputPhone"));
        Map<String, Object> map = new HashMap<>();
        map.put("title", "Welcome to SWEN383Store");

        return freeMarker.render(new ModelAndView(map, VIEW_NAME));
    }
}
