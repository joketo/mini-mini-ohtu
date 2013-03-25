package gui;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class MainScreen extends JFrame {
    
    private Container pane;
    private okButtonHandler okHandler;
    private SpringLayout layout;
    private typeSelectHandler selectHandler;
    private JComboBox typeSelect;
    private JTextField titleField;
    private JTextField authorField;
    private JTextField yearField;
    private JTextField publisherField;
    
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
         okHandler = new okButtonHandler();
         pane.add(save);
    }
    
    private void initElements() {
        String[] type = {"Book" ,"Some other"};
        typeSelect = new JComboBox(type);
        typeSelect.setSelectedIndex(0);
        layout.putConstraint(SpringLayout.WEST, typeSelect, 5, SpringLayout.WEST, pane);
        layout.putConstraint(SpringLayout.NORTH, typeSelect, 10, SpringLayout.NORTH, pane);
        selectHandler = new typeSelectHandler();
        typeSelect.addActionListener(selectHandler);
        pane.add(typeSelect);
        
        final int leftEdge = 70;
        
        JLabel title = new JLabel("Title");
        titleField = new JTextField(30);
        layout.putConstraint(SpringLayout.WEST, title, 5, SpringLayout.WEST, pane);
        layout.putConstraint(SpringLayout.NORTH, title, 45, SpringLayout.NORTH, pane);
        layout.putConstraint(SpringLayout.WEST, titleField, leftEdge, SpringLayout.NORTH, pane);
        layout.putConstraint(SpringLayout.NORTH, titleField, 45, SpringLayout.NORTH, pane);
        
        JLabel author = new JLabel("Author");
        authorField = new JTextField(30);
        layout.putConstraint(SpringLayout.WEST, author, 5, SpringLayout.WEST, pane);
        layout.putConstraint(SpringLayout.NORTH, author, 30, SpringLayout.NORTH, title);
        layout.putConstraint(SpringLayout.WEST, authorField, leftEdge, SpringLayout.NORTH, pane);
        layout.putConstraint(SpringLayout.NORTH, authorField, 30, SpringLayout.NORTH, titleField);
        
        JLabel year = new JLabel("Year");
        yearField = new JTextField(30);
        layout.putConstraint(SpringLayout.WEST, year, 5, SpringLayout.WEST, pane);
        layout.putConstraint(SpringLayout.NORTH, year, 30, SpringLayout.NORTH, author);
        layout.putConstraint(SpringLayout.WEST, yearField, leftEdge, SpringLayout.NORTH, pane);
        layout.putConstraint(SpringLayout.NORTH, yearField, 30, SpringLayout.NORTH, authorField);
        
        JLabel publisher = new JLabel("Publisher");
        publisherField = new JTextField(30);
        layout.putConstraint(SpringLayout.WEST, publisher, 5, SpringLayout.WEST, pane);
        layout.putConstraint(SpringLayout.NORTH, publisher, 30, SpringLayout.NORTH, year);
        layout.putConstraint(SpringLayout.WEST, publisherField, leftEdge, SpringLayout.NORTH, pane);
        layout.putConstraint(SpringLayout.NORTH, publisherField, 30, SpringLayout.NORTH, yearField);
        
        pane.add(title);
        pane.add(titleField);
        pane.add(author);
        pane.add(authorField);
        pane.add(year);
        pane.add(yearField);
        pane.add(publisher);
        pane.add(publisherField);
      
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
    
    public String getTypeSelected() {
        return typeSelect.getSelectedItem().toString();
    }
    
      private class okButtonHandler implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            
                     
        }
    }
      
      private class typeSelectHandler implements ActionListener {
          
          public void actionPerformed(ActionEvent e) {
            
              if(getTypeSelected() == "Book") {
                  setTitleVisibility(true);
                  setAuthorVisibility(true);
                  setYearVisibility(true);
                  setPublisherVisibility(true);
              }
              else {
                  setTitleVisibility(false);
                  setAuthorVisibility(false);
                  setYearVisibility(false);
                  setPublisherVisibility(false);
              }    
              
          }
      }
}
