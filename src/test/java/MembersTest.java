import org.junit.Test;

import static org.junit.Assert.*;

public class MembersTest {
    @Test
    public void Members_instantiatesWithName(){
        Members testMembers = new Members("Emma","developer", 1);
        assertEquals(testMembers.getName(),"Emma",1);
    }

    @Test
    public void Members_instantiatesWithDescription(){
        Members testMembers = new Members("Emma","developer", 1);
        assertEquals(testMembers.getDescription(),"Emma",1);
    }

}