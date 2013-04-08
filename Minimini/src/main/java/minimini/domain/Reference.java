package minimini.domain;


import java.util.HashMap;

/**
 *
 * @author heidi
 */
public class Reference implements Comparable<Reference>{
    /** Reference type, for example "Book"**/
    private String type;
    /** Unique reference id **/
    private String id;
    /** Data entries in this reference. Keys are data entry types**/
    private HashMap<String, String> entries;
    
    public Reference(String type, String id) {
        this.type = type;
        this.id = id;
        this.entries = new HashMap<String, String>();
    }
    
    public String getType() {
        return this.type;
    }
    
    public String getID() {
        return this.id;
    }
    
    public String getEntry(String entryType) {
        return entries.get(entryType);
    }
    
    public HashMap<String, String> getAllEntries() {
        return this.entries;
    }
    
    /** Edits a data entry of given type. If the data entry type does not exist, 
     * adds the data entry type and its value**/ 
    public void editEntry(String entryType, String newValue) {
        entries.put(entryType, newValue);
    }
    
    /** Returns this reference in BibTex form**/ 
    public String toBibtex() {
        StringBuilder sb = new StringBuilder();
        sb.append("@").append(type).append("{").append(id).append(",\n");
   
        for (String entry : entries.keySet()) {
            sb.append(" ");
            sb.append(entry).append(" = {").append(entries.get(entry)).append("},\n");
        }
        sb.append("}\n");
        return sb.toString();
    }
    
    public boolean equals(Object o) {
        if (o.getClass() != this.getClass()) {
            return false;
        }
        Reference other = (Reference) o;
        return this.compareTo(other) == 0;
    }
    
    @Override
    public int compareTo(Reference t) {
        return this.getID().compareToIgnoreCase(t.getID());
    }
    
    
    
}
