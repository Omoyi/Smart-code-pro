import org.sql2o.Connection;

import java.util.List;
import java.util.Objects;

public class Teamform {
    private final String team_Leader;
    private final String team_Name;
    private String email;
    private int id;
    private String language;


    public Teamform(String team_name, String team_leader, String email, String language) {
        this.team_Name = team_name;
        this.team_Leader = team_leader;
        this.email = email;
        this.language = language;
    }
//
//    public String getTeamname() {
//        return team_Name;
//    }
//
//    public void setTeamname(String team_Name) {
//        this.team_Name = teamname;
//    }
//
//    public String getTeamleader() {
//        return team_Leader;
//    }
//
//    public void setTeamleader(String teamleader) {
//        this.team_Leader = teamleader;
//    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public static List<Teamform> all() {
        String sql = "SELECT * FROM team";
        try(Connection con = DB.sql2o.open()) {
            return con.createQuery(sql).executeAndFetch(Teamform.class);
        }
    }
}
