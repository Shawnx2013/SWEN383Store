package Controllers;

import spark.*;

import java.util.HashMap;
import java.util.Map;

public class PaymentController implements Route{
    private static final String VIEW_NAME= "Payment.ftl";
    private TemplateEngine freeMarker;
    public PaymentController(TemplateEngine freeMarker){
        this.freeMarker = freeMarker;
    }

    @Override
    public Object handle(Request request, Response response){
        Map<String, Object> map = new HashMap<>();
        map.put("title", "Payment");

        return freeMarker.render(new ModelAndView(map, VIEW_NAME));
    }
}
