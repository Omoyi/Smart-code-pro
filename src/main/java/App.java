import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static spark.Spark.*;
import static spark.Spark.staticFileLocation;
import static spark.route.HttpMethod.post;


public class App {
    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }

        return 4567;
    }
    public static void main(String[] args) {
        staticFileLocation("/public");

        get("/", (request, response) ->{
            Map<String, Object> model = new HashMap<String, Object>();
            return new ModelAndView(model, "index.hbs");
        },new HandlebarsTemplateEngine());

        get("/about", (request, response) ->{
            Map<String, Object> model = new HashMap<String, Object>();
            return new ModelAndView(model, "index.hbs");
        },new HandlebarsTemplateEngine());

        get("/project", (request, response) ->{
            Map<String, Object> model = new HashMap<String, Object>();
            return new ModelAndView(model, "project1.hbs");
        },new HandlebarsTemplateEngine());

        get("/team", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            return new ModelAndView(model, "team.hbs");
        }, new HandlebarsTemplateEngine());

        get("/1", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            return new ModelAndView(model, "team1.hbs");
        }, new HandlebarsTemplateEngine());

        get("/2", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            return new ModelAndView(model, "team2.hbs");
        }, new HandlebarsTemplateEngine());


        get("/3", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            return new ModelAndView(model, "team3.hbs");
        }, new HandlebarsTemplateEngine());

        get("/4", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            return new ModelAndView(model, "team4.hbs");
        }, new HandlebarsTemplateEngine());


        get("/5", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            return new ModelAndView(model, "team5.hbs");
        }, new HandlebarsTemplateEngine());
        get("/Team1", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "form.hbs");
        }, new HandlebarsTemplateEngine());

        post("/Team1",(request,response)-> {
            Map<String, Object> model = new HashMap<>();
            String teamname= request.queryParams("teamname");
            String  teamleader  = request.queryParams("teamleader");
            String email = request.queryParams("email");
            Team1 newTeam = new Team1(teamname,teamleader,email);
            newTeam.save();
            request.session().attribute("item",newTeam);
            model.put("item",request.session().attribute("item"));
            model.put("teamname", teamname);
            model.put("teamleader", teamleader);
            model.put("email", email);
            System.out.println(newTeam);
            response.redirect("/pending");
            return new ModelAndView(model,"success.hbs");
        }, new HandlebarsTemplateEngine());
        get("/pending", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            List<Team1> item = Team1.all();
            model.put("item",item);
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());
    }
}
