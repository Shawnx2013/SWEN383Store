package Controllers;

import Routes.*;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import spark.*;

import util.JsonTransformer;
import util.ParseRequestBody;
import util.Path.*;
import Service.*;
import Models.Item.*;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;

import static spark.Spark.*;

public class HomeController{

    private static TemplateEngine freeMarker;
    public HomeController(TemplateEngine freeMarker){
        this.freeMarker = freeMarker;
    }

    public void start(){
        //get(ROUTE.HOME, homeRoute);
        post(ROUTE.HOME, homeRoute);
        get(ROUTE.LOAD, loadItemRoute);
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

    public static Route loadItemRoute = (Request request, Response response) ->{
        System.out.println("Request sent to Load Item Route");
        System.out.println("Request method: " + request.requestMethod());
        System.out.println("Type requested: " + request.queryParams("itemType"));
        String type = request.queryParams("itemType");
        ItemService itemService = new ItemService();
        response.type("application/json");
        ArrayList list = (ArrayList)itemService.getItemByType(type);
        if(list.size()>0) {
            if (type.equals("dvd")) {
                for (int i = 0; i < list.size(); i++) {
                    Movie movie = (Movie) list.get(i);
                    System.out.println(movie.getName() + ": " + movie.getAvailableAmt());
                }
            }
            if (type.equals("cd")) {
                for (int i = 0; i < list.size(); i++) {
                    Game game = (Game) list.get(i);
                    System.out.println(game.getName() + ": " + game.getAvailableAmt());
                }
            }
            JsonArray json = new Gson().toJsonTree(list).getAsJsonArray();
            return json;
        }
        else {
            return "{\"message\":\"Error occurred on loadItemRoute\"}";
        }
    };
}
