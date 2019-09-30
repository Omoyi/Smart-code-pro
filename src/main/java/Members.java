public class Members {
private String name;
private String description;
private int id;

public Members(String name, String description,int id) {
    this.name = name;
    this.id = id;
    this.description = description;
}

    public String getName() {
    return name;
    }

    public String getDescription() {
    return description;
    }
}
