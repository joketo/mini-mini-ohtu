package minimini.gui;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;
import minimini.domain.Reference;
import minimini.domain.ReferenceList;

public class MainScreen extends JFrame {
    
    private ReferenceList refs;
     
    private Container pane;
    private MainScreen.SaveButtonHandler saveHandler;
    private SpringLayout layout;
    private MainScreen.TypeSelectHandler selectHandler;
    private JComboBox typeSelect;
    private JTextField titleField;
    private JTextField authorField;
    private JTextField yearField;
    private JTextField publisherField;
    private JTextField journalField;
    private JTextField idField;
    private MainScreen.WriteButtonHandler writeHandler;
    
    public MainScreen() {
        initValues();
        initLayout();
        initElements();
        initButtons();

        setSize(450, 400);
        this.refs = new ReferenceList();
        
    } 
    
    private void initValues() {
        final int width = 440;
        final int height = 400;
        setTitle("Some name");
        setSize(width, height);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    private void initLayout() {
        pane = getContentPane();
        layout = new SpringLayout();
        pane.setLayout(layout);
    }
    
    private void initButtons() {
         JButton save = new JButton("Save");
         layout.putConstraint(SpringLayout.WEST, save, 20, SpringLayout.WEST, pane);
         layout.putConstraint(SpringLayout.SOUTH, save, -5, SpringLayout.SOUTH, pane);
         saveHandler = new MainScreen.SaveButtonHandler();
         save.addActionListener(saveHandler);
         pane.add(save);
         
         JButton write = new JButton("Write");
         layout.putConstraint(SpringLayout.WEST, write, 80, SpringLayout.WEST, save);
         layout.putConstraint(SpringLayout.SOUTH, write, -5, SpringLayout.SOUTH, pane);
         writeHandler = new MainScreen.WriteButtonHandler();
         write.addActionListener(writeHandler);
         pane.add(write);
    }
    
    private void initElements() {
        String[] type = {"Book","Article","Some other"};
        typeSelect = new JComboBox(type);
        typeSelect.setSelectedIndex(0);
        layout.putConstraint(SpringLayout.WEST, typeSelect, 5, SpringLayout.WEST, pane);
        layout.putConstraint(SpringLayout.NORTH, typeSelect, 10, SpringLayout.NORTH, pane);
        selectHandler = new MainScreen.TypeSelectHandler();
        typeSelect.addActionListener(selectHandler);
        pane.add(typeSelect);
        
        final int leftEdgeLabel = 5;
        final int leftEdgeField = 70;
        final int topEdge = 45;
        final int spaceBetween = 30;
        
        JLabel id = new JLabel("ID");
        idField = new JTextField(30);
        layout.putConstraint(SpringLayout.WEST, id, leftEdgeLabel, SpringLayout.WEST, pane);
        layout.putConstraint(SpringLayout.NORTH, id, topEdge, SpringLayout.NORTH, pane);
        layout.putConstraint(SpringLayout.WEST, idField, leftEdgeField, SpringLayout.WEST, id);
        layout.putConstraint(SpringLayout.NORTH, idField, topEdge, SpringLayout.NORTH, pane);
        
        JLabel title = new JLabel("Title");
        titleField = new JTextField(30);
        layout.putConstraint(SpringLayout.WEST, title, leftEdgeLabel, SpringLayout.WEST, pane);
        layout.putConstraint(SpringLayout.NORTH, title, spaceBetween, SpringLayout.NORTH, id);
        layout.putConstraint(SpringLayout.WEST, titleField, leftEdgeField, SpringLayout.WEST, title);
        layout.putConstraint(SpringLayout.NORTH, titleField, spaceBetween, SpringLayout.NORTH, idField);
        
        JLabel author = new JLabel("Author");
        authorField = new JTextField(30);
        layout.putConstraint(SpringLayout.WEST, author, leftEdgeLabel, SpringLayout.WEST, pane);
        layout.putConstraint(SpringLayout.NORTH, author, spaceBetween, SpringLayout.NORTH, title);
        layout.putConstraint(SpringLayout.WEST, authorField, leftEdgeField, SpringLayout.WEST, title);
        layout.putConstraint(SpringLayout.NORTH, authorField, spaceBetween, SpringLayout.NORTH, titleField);
        
        JLabel year = new JLabel("Year");
        yearField = new JTextField(30);
        layout.putConstraint(SpringLayout.WEST, year, leftEdgeLabel, SpringLayout.WEST, pane);
        layout.putConstraint(SpringLayout.NORTH, year, spaceBetween, SpringLayout.NORTH, author);
        layout.putConstraint(SpringLayout.WEST, yearField, leftEdgeField, SpringLayout.WEST, title);
        layout.putConstraint(SpringLayout.NORTH, yearField, spaceBetween, SpringLayout.NORTH, authorField);
        
        JLabel publisher = new JLabel("Publisher");
        publisherField = new JTextField(30);
        layout.putConstraint(SpringLayout.WEST, publisher, leftEdgeLabel, SpringLayout.WEST, pane);
        layout.putConstraint(SpringLayout.NORTH, publisher, spaceBetween, SpringLayout.NORTH, year);
        layout.putConstraint(SpringLayout.WEST, publisherField, leftEdgeField, SpringLayout.WEST, title);
        layout.putConstraint(SpringLayout.NORTH, publisherField, spaceBetween, SpringLayout.NORTH, yearField);
        
        JLabel journal = new JLabel("Journal");
        journalField = new JTextField(30);
        layout.putConstraint(SpringLayout.WEST, journal, leftEdgeLabel, SpringLayout.WEST, pane);
        layout.putConstraint(SpringLayout.NORTH, journal, spaceBetween, SpringLayout.NORTH, publisher);
        layout.putConstraint(SpringLayout.WEST, journalField, leftEdgeField, SpringLayout.WEST, title);
        layout.putConstraint(SpringLayout.NORTH, journalField, spaceBetween, SpringLayout.NORTH, publisherField);
        
        
        pane.add(title);
        pane.add(titleField);
        pane.add(author);
        pane.add(authorField);
        pane.add(year);
        pane.add(yearField);
        pane.add(publisher);
        pane.add(publisherField);
        pane.add(journal);
        pane.add(journalField);
        pane.add(id);
        pane.add(idField);
 
      
    }
    
    public void setTitleVisibility(boolean bool) {
        pane.getComponent(1).setVisible(bool);
        pane.getComponent(2).setVisible(bool);
    }
    
    public void setAuthorVisibility(boolean bool) {
        pane.getComponent(3).setVisible(bool);
        pane.getComponent(4).setVisible(bool);
    }
    
    public void setYearVisibility(boolean bool) {
        pane.getComponent(5).setVisible(bool);
        pane.getComponent(6).setVisible(bool);
    }
    
    public void setPublisherVisibility(boolean bool) {
        pane.getComponent(7).setVisible(bool);
        pane.getComponent(8).setVisible(bool);
    }
    public void setJournalVisibility(boolean bool) {
        pane.getComponent(9).setVisible(bool);
        pane.getComponent(10).setVisible(bool);
    }
    
    public void setIdVisibility(boolean bool) {
        pane.getComponent(11).setVisible(bool);
        pane.getComponent(12).setVisible(bool);
    }
    
    public String getTypeSelected() {
        return typeSelect.getSelectedItem().toString();
    }
    
    public void writeAll() {
        try {
            refs.bibtexAll();
        } catch (IOException e) {
            System.out.println("File not found. Cannot create or open file.");
        }
    }
    
    public void clearFields() {
        idField.setText(null);
        titleField.setText(null);
        yearField.setText(null);
        publisherField.setText(null);
        authorField.setText(null);
        journalField.setText(null);
    }
    
      private class SaveButtonHandler implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            
            if(getTypeSelected() == "Book") {
                Reference ref = new Reference(getTypeSelected(), idField.getText());
                ref.editEntry("Title", titleField.getText());
                ref.editEntry("Author", authorField.getText());
                ref.editEntry("Year", yearField.getText());
                ref.editEntry("Publisher", publisherField.getText());
                System.out.println(ref.toBibtex());
                refs.add(ref);
                clearFields();
            }
            
            if(getTypeSelected() == "Article") {
                Reference ref = new Reference(getTypeSelected(), idField.getText());
                ref.editEntry("Title", titleField.getText());
                ref.editEntry("Author", authorField.getText());
                ref.editEntry("Year", yearField.getText());
                ref.editEntry("Journal", journalField.getText());
                System.out.println(ref.toBibtex());
                refs.add(ref);
                clearFields();
            }
            
        }
    }
      
      private class TypeSelectHandler implements ActionListener {
          
          public void actionPerformed(ActionEvent e) {
              
                  setTitleVisibility(false);
                  setAuthorVisibility(false);
                  setYearVisibility(false);
                  setPublisherVisibility(false);
                  setJournalVisibility(false);
            
              
              if (getTypeSelected() == "Book") {
                  setTitleVisibility(true);
                  setAuthorVisibility(true);
                  setYearVisibility(true);
                  setPublisherVisibility(true);
                 
              }
              if (getTypeSelected() == "Article") {
                  setTitleVisibility(true);
                  setAuthorVisibility(true);
                  setYearVisibility(true);
                  setJournalVisibility(true);
              }  
              
          }
      }
      
      private class WriteButtonHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            writeAll();
        }
          
      }
}