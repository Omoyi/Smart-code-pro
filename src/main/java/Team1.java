import org.sql2o.Connection;

import java.util.List;
import java.util.Objects;

public class Team1 {
    private String teamname;
    private String teamleader;
    private String email;
    private int id;

    public Team1(String teamname, String teamleader, String email) {
        this.teamname = teamname;
        this.teamleader = teamleader;
        this.email = email;

    }

    public String getTeamname() {
        return teamname;
    }

    public void setTeamname(String teamname) {
        this.teamname = teamname;
    }

    public String getTeamleader() {
        return teamleader;
    }

    public void setTeamleader(String teamleader) {
        this.teamleader = teamleader;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Team1)) return false;
        Team1 team1 = (Team1) o;
        return id == team1.id &&
                Objects.equals(teamname, team1.teamname) &&
                Objects.equals(teamleader, team1.teamleader) &&
                Objects.equals(email, team1.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(teamname, teamleader, email, id);
    }

    public void save() {
        try(Connection con = DB2.sql2o.open()) {
            String sql = "INSERT INTO form(teamname, teamleader,email) VALUES (:teamname, :teamleader, :email)";
            this.id=(int) con.createQuery(sql,true)
                    .addParameter("teamname", this.teamname)
                    .addParameter("teamleader", this.teamleader)
                    .addParameter("email", this.email)
                    .executeUpdate()
                    .getKey();

        }

    }
    public static List<Team1> all() {
        String sql = "SELECT * FROM form";
        try(Connection con = DB2.sql2o.open()) {
            return con.createQuery(sql).executeAndFetch(Team1.class);
        }
    }
}