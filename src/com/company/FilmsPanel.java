package com.company;

import com.sun.xml.internal.messaging.saaj.soap.JpegDataContentHandler;

import javax.swing.*;
import java.awt.*;

public class FilmsPanel extends JPanel {

    public FilmsPanel()
    {
        this.setBackground(Color.gray);
        this.createComponents();
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    }

    /**
     * Create FilmsPanels components
     */
    private void createComponents()
    {

        // Create panels
        JPanel innerFlowPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel innerBoxPanel = new JPanel();
        JPanel firstComponentPanel = new JPanel(new GridLayout(0, 1));
        JPanel thirdComponentPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel secondComponentPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel forthComponentPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

        JPanel fillerPanel = new JPanel();


        // Set colors and titles
        innerFlowPanel.setBorder(BorderFactory.createTitledBorder("Films"));
        innerFlowPanel.setBackground(Color.gray);
        innerBoxPanel.setBackground(Color.gray);
        firstComponentPanel.setBackground(Color.gray);
        secondComponentPanel.setBackground(Color.gray);
        thirdComponentPanel.setBackground(Color.gray);
        forthComponentPanel.setBackground(Color.gray);


        // Set options
        innerBoxPanel.setLayout(new BoxLayout(innerBoxPanel, BoxLayout.Y_AXIS));
        innerFlowPanel.setAlignmentX(Component.LEFT_ALIGNMENT);

        //create table and fill with data
        Object[] filmData = this.returnFilmData();
        String[] columns = (String[])filmData[1];
        Object[][] data = (Object[][])filmData[0];
        JTable filmsTable = new JTable(data, columns);

        JScrollPane tablePane = new JScrollPane(filmsTable);

        // Manually set size of tablePane
        tablePane.setPreferredSize(new Dimension(900, 190));
        tablePane.setMaximumSize(new Dimension(900, 190));


        // Add components to first component panel
        firstComponentPanel.add(tablePane);

        // Add components to third component panel
        JLabel filterOptionsLabel = new JLabel("Filter options:");
        secondComponentPanel.add(filterOptionsLabel);

        // Add components to second component panel
        JLabel filterAccountsLabel = new JLabel("Bekeken door:");
        JButton filterAccountButton = new JButton("Filter");


        String[] accountFilterBoxOptions = {"Profiel", "Account"};
        JComboBox<String> accountFilterBox = new JComboBox<>(accountFilterBoxOptions);

        thirdComponentPanel.add(filterAccountsLabel);
        thirdComponentPanel.add(accountFilterBox);

        // add components to forth component panel
        JLabel timeSpanLabel = new JLabel("Tijdsduur:");
        String[] timeSpanFilterBoxOptions = {"Geen selectie", "Kortst", "Langst"};
        JComboBox<String> timeSpanFilterBox = new JComboBox<>(timeSpanFilterBoxOptions);

        JLabel ageIndicationLabel = new JLabel("Leeftijdsindicatie: ");
        String[] ageIndicationFilterBoxOptions = {"Allemaal", "6", "9", "12", "16"};
        JComboBox<String> ageIndicationFilterBox = new JComboBox<>(ageIndicationFilterBoxOptions);

        forthComponentPanel.add(timeSpanLabel);
        forthComponentPanel.add(timeSpanFilterBox);
        forthComponentPanel.add(ageIndicationLabel);
        forthComponentPanel.add(ageIndicationFilterBox);
        forthComponentPanel.add(filterAccountButton);

        innerBoxPanel.add(firstComponentPanel);

        // Create and add filler panel
        fillerPanel.add(Box.createRigidArea(new Dimension(0,30))); // Create space between buttons
        fillerPanel.setBackground(Color.gray);
        innerBoxPanel.add(fillerPanel);

        innerBoxPanel.add(secondComponentPanel);
        innerBoxPanel.add(thirdComponentPanel);
        innerBoxPanel.add(forthComponentPanel);

        innerFlowPanel.add(innerBoxPanel);
        this.add(innerFlowPanel);

        // Create space for panel alignment
        for(int x = 0; x < 3; x++)
        {

            fillerPanel = new JPanel();
            fillerPanel.setBackground(Color.gray);
            this.add(fillerPanel);
        }
    }

    /**
     * Returns a string array of film data by selected film options
     *
     * @return
     */
    private Object[] returnFilmData(){

        //headers for the table
        String[] columns = new String[] {
                "Titel", "Genre", "Taal", "Leeftijdsincdicatie"
        };

        //actual data for the table in a 2d array
        Object[][] data = new Object[][] {
                {1, "John", 40.0, false },
                {2, "Rambo", 70.0, false },
                {3, "Zorro", 60.0, true },
                {3, "Zorro", 60.0, true },
                {3, "Zorro", 60.0, true },
                {3, "Zorro", 60.0, true },
                {3, "Zorro", 60.0, true },
                {3, "Zorro", 60.0, true },
                {3, "Zorro", 60.0, true },
                {3, "Zorro", 60.0, true },
                {3, "Zorro", 60.0, true },
                {3, "Zorro", 60.0, true },
                {3, "Zorro", 60.0, true },
                {3, "Zorro", 60.0, true },
        };

        Object[] tableData = {data, columns};

        return tableData;

    }
}
