
import org.sql2o.Connection;

import java.util.Objects;

public class Team {
    private String team_name;
    private String team_leader;
    private String email;
    private String language;
    private int id;

    public Team(String team_name, String team_leader,String email,String language) {
        this.team_name = team_name;
        this.team_leader = team_leader;
        this.email = email;
        this.language = language;
    }

    public String getTeam_name() {
        return team_name;
    }

    public void setTeam_name(String team_name) {
        this.team_name = team_name;
    }

    public String getTeam_leader() {
        return team_leader;
    }

    public void setTeam_leader(String team_leader) {
        this.team_leader = team_leader;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void save() {
        try(Connection con = DB.sql2o.open()) {
            String sql = "INSERT INTO team(team_name, team_leader,email,language) VALUES (:team_name, :team_leader, :email, :language)";
            this.id=(int) con.createQuery(sql,true)
                    .addParameter("team_name", this.team_name)
                    .addParameter("team_leader", this.team_leader)
                    .addParameter("email", this.email)
                    .addParameter("language", this.language)
                    .executeUpdate()
                    .getKey();

        }

    }
}
