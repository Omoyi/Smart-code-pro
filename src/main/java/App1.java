import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.*;
public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");

        get("/newTeam", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "teamform.hbs");
        }, new HandlebarsTemplateEngine());

        post("/Team",(req,res)-> {
            Map<String, Object> model = new HashMap<>();
            String teamName= req.queryParams("team_Name");
            String teamLeader = req.queryParams("team_Leader");
            String email = req.queryParams("email");
            String language = req.queryParams("language");
            Team newTeam = new Team(teamName,teamLeader,email,language);
            newTeam.save();
//            req.session().attribute("item",newTeam);
//            model.put("item",req.session().attribute("item"));
//            model.put("teamName", teamName);
//            model.put("teamLeader", teamLeader);
//            model.put("email", email);
//            model.put("language", language);
            System.out.println(newTeam);
            res.redirect("/pending");
            return new ModelAndView(model,"success.hbs");
        }, new HandlebarsTemplateEngine());

        post("/Team",(req,res)-> {
            Map<String, Object> model = new HashMap<>();
            String teamName= req.queryParams("team_Name");
            String teamLeader = req.queryParams("team_Leader");
            String email = req.queryParams("email");
            String language = req.queryParams("language");
            Team newTeam = new Team(teamName,teamLeader,email,language);
            newTeam.save();
            req.session().attribute("item",newTeam);
            model.put("item",req.session().attribute("item"));
            model.put("team_Name", teamName);
            model.put("team_Leader", teamLeader);
            model.put("email", email);
            model.put("language", language);
//            System.out.println(newTeam);
            res.redirect("/pending");
            return new ModelAndView(model,"success.hbs");
        }, new HandlebarsTemplateEngine());

        get("/Team", (req, res) -> {
            Map<String, Object> model = new HashMap<>();

            return new ModelAndView(model, "form.hbs");
        }, new HandlebarsTemplateEngine());

        get("/pending", (req, res) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            List<Teamform> item = Teamform.all();
           model.put("item",item);
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());
    }
}