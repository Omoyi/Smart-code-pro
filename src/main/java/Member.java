import org.sql2o.Connection;

import java.util.Objects;

public class Member {
        private String teamname;
        private String name1;
        private String name2;
        private String name3;
        private String name4;
        private int id;

        public Member(String teamname, String name1,String name2,String name3,String name4) {
            this.teamname = teamname;
            this.name1 = name1;
            this.name2 = name2;
            this.name3 = name3;
            this.name4 = name4;
        }

    public String getTeamname() {
        return teamname;
    }

    public void setTeamname(String teamname) {
        this.teamname = teamname;
    }

    public String getName1() {
        return name1;
    }

    public void setName1(String name1) {
        this.name1 = name1;
    }

    public String getName2() {
        return name2;
    }

    public void setName2(String name2) {
        this.name2 = name2;
    }

    public String getName3() {
        return name3;
    }

    public void setName3(String name3) {
        this.name3 = name3;
    }

    public String getName4() {
        return name4;
    }

    public void setName4(String name4) {
        this.name4 = name4;
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
        if (!(o instanceof Member)) return false;
        Member member = (Member) o;
        return id == member.id &&
                Objects.equals(teamname, member.teamname) &&
                Objects.equals(name1, member.name1) &&
                Objects.equals(name2, member.name2) &&
                Objects.equals(name3, member.name3) &&
                Objects.equals(name4, member.name4);
    }

    @Override
    public int hashCode() {
        return Objects.hash(teamname, name1, name2, name3, name4, id);
    }

    public void save() {
        try(Connection con = DB.sql2o.open()) {
            String sql = "INSERT INTO  member(teamname, name1,Name2, Name3,Name4) VALUES (:teamname, :name1, :name2, :name3, :name4)";
            this.id=(int) con.createQuery(sql,true)
                    .addParameter("teamname", this.teamname)
                    .addParameter("name1", this.name1)
                    .addParameter("name2", this.name2)
                    .addParameter("name3", this.name3)
                    .addParameter("name4", this.name4)
                    .executeUpdate()
                    .getKey();
        }
        }
}
