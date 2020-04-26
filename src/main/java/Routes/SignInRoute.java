package Routes;

import Models.Account.Customer;
import spark.*;

import util.ParseRequestBody;
import Service.*;
import Models.Account.*;

import java.util.HashMap;
import java.util.Map;

public class SignInRoute implements Route{
    private static final String VIEW_NAME= "home.ftl";
    private static final String INDEX="index.ftl";
    private TemplateEngine freeMarker;
    public SignInRoute(TemplateEngine freeMarker){
        this.freeMarker = freeMarker;
    }

    @Override
    public Object handle(Request request, Response response){
        System.out.println("Request received in SignInRoute");

        Map<String, Object> map = new HashMap<>();
        HashMap<String, Object> in_copy;
        //System.out.println(request.body());
        try {
            Map<String, Object> in = ParseRequestBody.asMap(request.body());
            in_copy = new HashMap<String, Object>(in);
            //Iterator iterator = in_copy.entrySet().iterator();
            /*while(iterator.hasNext()){
                Map.Entry mapElement = (Map.Entry)iterator.next();
                String s = (String)mapElement.getValue();
                System.out.println(mapElement.getKey() + ": " + s);
            }*/
            String email = (String)in_copy.get("in-email");
            String password = (String)in_copy.get("in-password");
            AuthenticationService authenticationService = new AuthenticationService(email, password);
            String[] result = authenticationService.login();
            if(result.length > 0) {
                /*for (int i = 0; i < result.length; i++) {
                    System.out.println(result[i]);
                }*/
                if(result[6].equals("Customer")){
                    map.put("email", result[0]);
                    map.put("password", result[1]);
                    map.put("name", result[2]);
                    map.put("address", result[3]);
                    map.put("home", result[4]);
                    map.put("mobile", result[5]);
                    map.put("role", result[6]);

                    return freeMarker.render(new ModelAndView(map, VIEW_NAME));
                }
            }
            else{
                System.out.println("Wrong email and password");
                map.put("Res", "FailedLogin");
                //map.put("title", "Welcome to SWEN383Store");
                //response.redirect("/");
                return freeMarker.render(new ModelAndView(map, INDEX));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        map.put("Res", "None");
        return freeMarker.render(new ModelAndView(map, INDEX));
    }
}
