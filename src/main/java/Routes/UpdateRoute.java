package Routes;

import spark.*;

import java.util.*;

public class UpdateRoute implements Route {
    private static final String VIEW_NAME= "test.ftl";
    private TemplateEngine freeMarker;
    public UpdateRoute(TemplateEngine freeMarker){
        this.freeMarker = freeMarker;
    }

    @Override
    public Object handle(Request request, Response response){
        System.out.println("Request received at RegisterRoute");
        System.out.println(request.body());
        System.out.println(request.queryParamsValues("inputEmail"));
        System.out.println(request.queryParams("inputPassword"));
        System.out.println(request.queryParams("inputAddress"));
        System.out.println(request.queryParams("inputAddress2"));
        System.out.println(request.queryParams("inputCity"));
        System.out.println(request.queryParams("inputState"));
        System.out.println(request.queryParams("inputZip"));
        System.out.println(request.queryParams("inputPhone"));
        Map<String, Object> map = new HashMap<>();
        map.put("title", "Welcome to SWEN383Store");

        return freeMarker.render(new ModelAndView(map, VIEW_NAME));
    }
}