import spark.Spark;
import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.StringWriter;

import static spark.Spark.get;

public class Main{
    public static void main(String[] args){

        final Configuration configuration = new Configuration(Configuration.VERSION_2_3_22);
        configuration.setClassForTemplateLoading(Main.class, "/");
        get("/", (request, response) -> {
            StringWriter writer = new StringWriter();
            try {
                Template formTemplate = configuration.getTemplate("templates/index.ftl");
                formTemplate.process(null, writer);
            }
            catch (Exception e) {
                Spark.halt(500);
            }
            return writer;
        });

        get("/test", (request, response) -> {
            StringWriter writer = new StringWriter();
            try {
                Template t2 = configuration.getTemplate("templates/test.html");
                t2.process(null, writer);
            }
            catch (Exception e) {

                Spark.halt(500);
            }
            return writer;
        });


    }
}
