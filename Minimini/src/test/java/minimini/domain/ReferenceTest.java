/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package minimini.domain;

import minimini.domain.Reference;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class ReferenceTest {
    
    Reference ref;
    
    public ReferenceTest() {
    }
    
    @Before
    public void setUp() {
        
        ref = new Reference("article", "AAAA");
    }
    
    @Test
    public void getEntryReturnNullIfNoSuchDataEntry() {
        assertEquals(null, ref.getEntry("author"));
    }
        
    @Test
    public void editEntryAddsNewDataEntry() {
        ref.editEntry("author", "XXXX");
        String exp = "XXXX";
        String result = ref.getEntry("author");
        assertTrue(exp.equals(result));
    }
    
    @Test
    public void editEntryEditsExistingDataEntry() {
        ref.editEntry("author", "XXXX");
        ref.editEntry("author", "YYYY");
        
        String exp = "YYYY";
        String result = ref.getEntry("author");
        assertTrue(exp.equals(result));
    }
    
    @Test
    public void toBibtexReturnsBibTeXFormat() {
        ref.editEntry("author", "ZZZZ");
        ref.editEntry("year", "2010");
        
        String exp = "@article{AAAA,\n"
                   + " author = {ZZZZ},\n"
                   + " year = {2010},\n"
                   + "}\n";
        
        String result = ref.toBibtex();
        
        assertTrue(exp.equals(result));
    }
}
