import org.junit.Test;

import static org.junit.Assert.*;

public class TeamTest {
    @Test
    public void Team_instantiatesWithName(){
        Team testTeam = new Team("lynda","develoer");
        assertEquals(testTeam.getName(),"lynda");
    }

    @Test
    public void Team_instantiatesWithDescription(){
        Team testTeam = new Team("Emma", "Ceo");
        assertEquals(testTeam.getDescription(), "Ceo");
    }

}