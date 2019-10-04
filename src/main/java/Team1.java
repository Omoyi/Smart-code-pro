
import org.sql2o.Connection;

public class Team1 {
    private String team_Name;
    private String team_Leader;
    private String email;
    private String language;
    private int id;

    public Team1(String team_Name, String team_Leader, String email, String language) {
        this.team_Name = team_Name;
        this.team_Leader = team_Leader;
        this.email = email;
        this.language = language;
    }

    public String getTeam_name() {
        return team_Name;
    }

    public void setTeam_name(String team_name) {
        this.team_Name = team_name;
    }

    public String getTeam_leader() {
        return team_Leader;
    }

    public void setTeam_leader(String team_leader) {
        this.team_Leader = team_leader;
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
        try(Connection con = DB1.sql2o.open()) {
            String sql = "INSERT INTO team(team_Name, team_Leader,email,language) VALUES (:team_Name, :team_Leader, :email, :language)";
            this.id=(int) con.createQuery(sql,true)
                    .addParameter("team_Name", this.team_Name)
                    .addParameter("team_Leader", this.team_Leader)
                    .addParameter("email", this.email)
                    .addParameter("language", this.language)
                    .executeUpdate()
                    .getKey();

        }

    }
}
