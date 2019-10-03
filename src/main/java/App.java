import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.*;
public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");

        get("/form", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "teamform.hbs");
        }, new HandlebarsTemplateEngine());

        post("/form",(req,res)-> {
            Map<String, Object> model = new HashMap<>();
            String teamName= req.queryParams("teamName");
            String teamLeader = req.queryParams("teamLeader");
            String email = req.queryParams("email");
            Teamform newTeamform = new Teamform(teamName,teamLeader,email);
            newTeamform.save();
            req.session().attribute("item", newTeamform);
            model.put("item",req.session().attribute("item"));
            model.put("teamName", teamName);
            model.put("teamLeader", teamLeader);
            model.put("email", email);
            System.out.println(newTeamform);
            res.redirect("/form12");
            return new ModelAndView(model,"teamform.hbs");
        }, new HandlebarsTemplateEngine());

        get("/form12", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            List<Teamform> TeamformList= Teamform.all();
            model.put("TeamformList", TeamformList);
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());

    }
}