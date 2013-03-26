/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 *
 * @author heidi
 */
public class ReferenceList {
    
    private Map<String, Reference> references;
    
    public ReferenceList() {
        this.references = new TreeMap<String, Reference>();
    }
    
    public void add(Reference ref) {
        references.put(ref.getID(), ref);    
    }
    
    public void remove(String refId) {
        references.remove(refId);
    }
    
    public Reference getReference(String refId) {
        return references.get(refId);
    }
    
    public Collection<Reference> getAll() {
        return references.values();
    }
}
