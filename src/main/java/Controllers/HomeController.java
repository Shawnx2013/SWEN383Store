package Controllers;

import Routes.*;
import spark.*;

import util.ParseRequestBody;
import util.Path.*;
import Service.*;
import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

public class HomeController{

    private static TemplateEngine freeMarker;
    public HomeController(TemplateEngine freeMarker){
        this.freeMarker = freeMarker;
    }

    public void start(){
        //get(ROUTE.HOME, homeRoute);
        post(ROUTE.HOME, homeRoute);
        //get(LOAD, new LoadItemRoute(freeMarker));
        //post(UPDATE, new UpdateProfileRoute(freeMarker));
    }

    public static Route homeRoute = (Request request, Response response) -> {
        System.out.println("Request sent to HomeRoute");
        //System.out.println("Request body:" +request.body());
        Session user = request.session();
        HashMap<String, Object> in_copy;
        Map<String, Object> map = new HashMap<>();

        try{
            Map<String, Object> in = ParseRequestBody.asMap(request.body());
            in_copy = new HashMap(in);
            String email = (String)in_copy.get("in-email");
            String password = (String)in_copy.get("in-password");
            AuthenticationService authenticationService = new AuthenticationService(email, password);
            boolean hasUser = authenticationService.login();
            if(hasUser){

                AccountService accountService = new AccountService();
                String[] result = accountService.getAccount(email, password);
                if(result[6].equals("Customer")){
                    map.put("email", result[0]);
                    map.put("password", result[1]);
                    map.put("name", result[2]);
                    map.put("address", result[3]);
                    map.put("home", result[4]);
                    map.put("mobile", result[5]);
                    map.put("role", result[6]);
                }
                return freeMarker.render(new ModelAndView(map, Template.HOME));
            }
            else{
                System.out.println("Wrong email and password");
                map.put("Res", "FailedLogin");
                return freeMarker.render(new ModelAndView(map, Template.INDEX));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        map.put("Res", "None");
        return freeMarker.render(new ModelAndView(map, Template.INDEX));
    };

}
