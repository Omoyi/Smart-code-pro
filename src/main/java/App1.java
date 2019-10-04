import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.*;
public class App1 {
    public static void main(String[] args) {
        staticFileLocation("/public");


        get("/Team1", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "form.hbs");
        }, new HandlebarsTemplateEngine());


        post("/Team1",(req,res)-> {
            Map<String, Object> model = new HashMap<>();
            String teamname= req.queryParams("teamname");
            String  teamleader  = req.queryParams("teamleader");
            String email = req.queryParams("email");
            Team1 newTeam = new Team1(teamname,teamleader,email);
            newTeam.save();
            req.session().attribute("item",newTeam);
            model.put("item",req.session().attribute("item"));
            model.put("teamname", teamname);
            model.put("teamleader", teamleader);
            model.put("email", email);
            System.out.println(newTeam);
            res.redirect("/pending");
            return new ModelAndView(model,"success.hbs");
        }, new HandlebarsTemplateEngine());


        get("/pending", (req, res) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            List<Team1> item = Team1.all();
           model.put("item",item);
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());
    }
}