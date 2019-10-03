import org.sql2o.Connection;
import org.sql2o.Sql2oException;

public class Members {
    private String name;
    private String description;
    private int id;

    public Members(String name, String description, int id) {
        this.name = name;
        this.description = description;
        this.id = id;
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
        try (Connection con = DB.sql2o.open()) {
            String sql = "INSERT INTO member (name, description) VALUES (:name, :description)";
            this.id = (int) con.createQuery(sql, true)
                    .addParameter("name", this.name)
                    .addParameter("description", this.description)
                    .executeUpdate()
                    .getKey();
        }
    }

    public void update(String name, String description) {
        String data="UPDATE  SET member (name, description)=(:name, :description)";
        try (Connection con= DB.sql2o.open()){
            con.createQuery(data)
                    .addParameter("name",name)
                    .addParameter("description",description)
                    .addParameter("id",id)
                    .executeUpdate();
        }catch (Sql2oException ex){
            System.out.println(ex);
        }
    }
    public void deleteById(int id) {
    }
}
