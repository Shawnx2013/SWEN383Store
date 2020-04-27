package Controllers;

import spark.*;

import Service.*;
import Models.Account.*;
import util.ParseRequestBody;
import util.Path.*;
import java.util.*;

import static spark.Spark.*;

public class IndexController{
    public IndexController(TemplateEngine freeMarker){
        this.freeMarker = freeMarker;
    }

    private static TemplateEngine freeMarker = null;

    public void start(){
        get(ROUTE.INDEX, serveIndex);
        post(ROUTE.INDEX, register);
    }

    public static Route serveIndex = (Request request, Response response) -> {
        System.out.println("Request sent to IndexRoute");
        Map<String, Object> map = new HashMap<>();
        map.put("Res", "None");
        return freeMarker.render(new ModelAndView(map, Template.INDEX));
    };

    public static Route register = (Request request, Response response) -> {
        System.out.println("Request received at RegisterRoute");
        //System.out.println(request.body());
        int res = -1;
        Registration regis = ParseRequestBody.convert(request.body(), Registration.class);
        System.out.println(regis);
        AccountService service = new AccountService();
        res = service.addCustomer(regis);

        Map<String, Object> map = new HashMap<>();

        if(res > 0){
            map.put("Res", "SUCCESS");
        }
        else
            map.put("Res", "FAILED");

        return freeMarker.render(new ModelAndView(map, Template.INDEX));
    };
}


