package Routes;

import Models.Account.*;
import Service.*;
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
        //System.out.println(request.body());
        int res = -1;
        Registration regis = ParseRequestBody.convert(request.body(), Registration.class);
        System.out.println(regis);
        AccountService service = new AccountService(regis);
        res = service.addCustomer();

        Map<String, Object> map = new HashMap<>();

        if(res > 0){
            map.put("Res", "SUCCESS");
        }
        else
            map.put("Res", "FAILED");

        return freeMarker.render(new ModelAndView(map, VIEW_NAME));
    }
}
