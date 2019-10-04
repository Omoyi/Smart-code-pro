import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import static spark.Spark.get;
import static spark.Spark.staticFileLocation;

public class App2 {
    public static void main(String[] args) {
        staticFileLocation("/public");

        get("/team", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            return new ModelAndView(model, "team.hbs");
        }, new HandlebarsTemplateEngine());
    }
}