package minimini.domain;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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
    private String path = "src/references.bib";
    
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
    
    public void bibtexAll() throws IOException {
        File file = new File(path);
        if (!file.exists()) {
            file.createNewFile();
        }
        StringBuilder sb = new StringBuilder();
        for (Reference r : references.values()) {
            sb.append(r.toBibtex());
        }
        FileWriter writer = new FileWriter(file);
        writer.write(sb.toString());
        writer.close();

    }
}
