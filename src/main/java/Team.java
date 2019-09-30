import org.sql2o.Connection;
import java.util.List;

public class Team {
    private String name;
    private String description;
    private int id;

    public Team(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {

        return name;
    }

    public String getDescription() {

        return description;
    }

    public int getId() {

        return id;
    }

    public void save() {
        try(org.sql2o.Connection con = DB.sql2o.open()) {
            String sql = "INSERT INTO team (name, description) VALUES (:name, :description)";
            this.id = (int) con.createQuery(sql, true)
                    .addParameter("name", this.name)
                    .addParameter("age", this.description)
                    .throwOnMappingFailure(false)
                    .executeUpdate()
                    .getKey();
        }
    }
    public static List<Team> all() {

        String s="select * from team;";
        try(Connection con = DB.sql2o.open()){
            return con.createQuery(s).executeAndFetch(Team.class);
        }
    }
}