import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;
public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");

        get("/Team", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "teamform.hbs");
        }, new HandlebarsTemplateEngine());

        post("/Team",(req,res)-> {
            Map<String, Object> model = new HashMap<>();
            String teamName= req.queryParams("teamName");
            String teamLeader = req.queryParams("teamLeader");
            String email = req.queryParams("email");
            String language = req.queryParams("language");
            Team newTeam = new Team(teamName,teamLeader,email,language);
            newTeam.save();
            req.session().attribute("item",newTeam);
            model.put("item",req.session().attribute("item"));
            model.put("teamName", teamName);
            model.put("teamLeader", teamLeader);
            model.put("email", email);
            model.put("language", language);
            System.out.println(newTeam);
            res.redirect("/Team");
            return new ModelAndView(model,"teamform.hbs");
        }, new HandlebarsTemplateEngine());

        get("/newTeam", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "form.hbs");
        }, new HandlebarsTemplateEngine());

        post("/newTeam",(req,res)-> {
            Map<String, Object> model = new HashMap<>();
            String teamName= req.queryParams("teamName");
            String Name1 = req.queryParams("Name1");
            String Name2 = req.queryParams("Name2");
            String Name3 = req.queryParams("Name3");
            String Name4 = req.queryParams("Name4");
            Member newMember = new Member(teamName,Name1,Name2,Name3,Name4);
            newMember.save();
            req.session().attribute("item",newMember);
            model.put("item",req.session().attribute("item"));
            model.put("teamName", teamName);
            model.put("Name1", Name1);
            model.put("Name2", Name2);
            model.put("Name4", Name4);
            System.out.println(newMember);
            res.redirect("/newTeam");
            return new ModelAndView(model,"form.hbs");
        }, new HandlebarsTemplateEngine());
    }
}