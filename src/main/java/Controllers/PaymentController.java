package Controllers;

import Routes.PaymentRoute;
import spark.*;

import static spark.Spark.get;
import static spark.Spark.post;

public class PaymentController{
    public PaymentController(TemplateEngine freeMarker){
        this.freeMarker = freeMarker;
    }

    public static final String PAYMENT = "/payment";
    //public static final String REGISTER = "";

    private final TemplateEngine freeMarker;

    public void start(){
        get(PAYMENT, new PaymentRoute(freeMarker));
        //post(INDEX, new RegisterRoute(freeMarker));
    }
}
