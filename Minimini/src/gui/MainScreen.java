package gui;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import domain.Reference;

public class MainScreen extends JFrame {
    
    private Container pane;
    private SaveButtonHandler saveHandler;
    private SpringLayout layout;
    private TypeSelectHandler selectHandler;
    private JComboBox typeSelect;
    private JTextField titleField;
    private JTextField authorField;
    private JTextField yearField;
    private JTextField publisherField;
    private JTextField journalField;
    
    public MainScreen() {
        initValues();
        initLayout();
        initElements();
        initButtons();

        setSize(450, 400);
        
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
         saveHandler = new SaveButtonHandler();
         save.addActionListener(saveHandler);
         pane.add(save);
    }
    
    private void initElements() {
        String[] type = {"Book","Article","Some other"};
        typeSelect = new JComboBox(type);
        typeSelect.setSelectedIndex(0);
        layout.putConstraint(SpringLayout.WEST, typeSelect, 5, SpringLayout.WEST, pane);
        layout.putConstraint(SpringLayout.NORTH, typeSelect, 10, SpringLayout.NORTH, pane);
        selectHandler = new TypeSelectHandler();
        typeSelect.addActionListener(selectHandler);
        pane.add(typeSelect);
        
        final int leftEdgeLabel = 5;
        final int leftEdgeField = 70;
        final int topEdge = 45;
        final int spaceBetween = 30;
        
        JLabel title = new JLabel("Title");
        titleField = new JTextField(30);
        layout.putConstraint(SpringLayout.WEST, title, leftEdgeLabel, SpringLayout.WEST, pane);
        layout.putConstraint(SpringLayout.NORTH, title, topEdge, SpringLayout.NORTH, pane);
        layout.putConstraint(SpringLayout.WEST, titleField, leftEdgeField, SpringLayout.WEST, title);
        layout.putConstraint(SpringLayout.NORTH, titleField, topEdge, SpringLayout.NORTH, pane);
        
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
    
    public String getTypeSelected() {
        return typeSelect.getSelectedItem().toString();
    }
    
    public void clearFields() {
        titleField.setText(null);
        yearField.setText(null);
        publisherField.setText(null);
        authorField.setText(null);
        journalField.setText(null);
    }
    
      private class SaveButtonHandler implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            
            if(getTypeSelected() == "Book") {
                Reference ref = new Reference(getTypeSelected(), "1");
                ref.editEntry("Title", titleField.getText());
                ref.editEntry("Author", authorField.getText());
                ref.editEntry("Year", yearField.getText());
                ref.editEntry("Publisher", publisherField.getText());
                System.out.println(ref.toBibtex());
                clearFields();
            }
            
            if(getTypeSelected() == "Article") {
                Reference ref = new Reference(getTypeSelected(), "1");
                ref.editEntry("Title", titleField.getText());
                ref.editEntry("Author", authorField.getText());
                ref.editEntry("Year", yearField.getText());
                ref.editEntry("Journal", journalField.getText());
                System.out.println(ref.toBibtex());
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
}
