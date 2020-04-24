package Controllers;

import spark.*;

import java.util.HashMap;
import java.util.Map;

public class TestController implements Route{
    private static final String VIEW_NAME= "test.ftl";
    private TemplateEngine freeMarker;
    public TestController(TemplateEngine freeMarker){
        this.freeMarker = freeMarker;
    }

    @Override
    public Object handle(Request request, Response response){
        Map<String, Object> map = new HashMap<>();
        map.put("title", "test");

        return freeMarker.render(new ModelAndView(map, VIEW_NAME));
    }
}
