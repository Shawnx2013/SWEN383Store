package Routes;

import Models.Account.*;
import spark.*;
import com.google.gson.*;
import util.ParseRequestBody;

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

        try{
            Registration regis = ParseRequestBody.convert(request.body(), Registration.class);
            System.out.println(regis);

        }catch(Exception e){
            e.printStackTrace();
        }

        Map<String, Object> map = new HashMap<>();
        map.put("title", "Welcome to SWEN383Store");

        return freeMarker.render(new ModelAndView(map, VIEW_NAME));
    }
}
