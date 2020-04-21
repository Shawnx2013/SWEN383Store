import spark.Spark;
import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.StringWriter;
public class Main{
    public static void main(String[] args){
        final Configuration configuration = new Configuration(Configuration.VERSION_2_3_22);
        configuration.setClassForTemplateLoading(Main.class, "/");
        Spark.get("/", (request, response) -> {
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
    }
}
