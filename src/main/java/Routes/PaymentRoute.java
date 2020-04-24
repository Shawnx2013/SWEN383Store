package Routes;

import spark.*;

import java.util.HashMap;
import java.util.Map;

public class PaymentRoute implements Route{
        private static final String VIEW_NAME= "payment.ftl";
        private TemplateEngine freeMarker;
        public PaymentRoute(TemplateEngine freeMarker){
            this.freeMarker = freeMarker;
        }

        @Override
        public Object handle(Request request, Response response){
            System.out.println("Request sent to Payment Route");
            Map<String, Object> map = new HashMap<>();
            map.put("title", "Payment");

            return freeMarker.render(new ModelAndView(map, VIEW_NAME));
        }

}
