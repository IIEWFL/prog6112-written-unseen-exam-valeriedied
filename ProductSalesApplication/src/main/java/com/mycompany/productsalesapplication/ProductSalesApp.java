/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.productsalesapplication;

/**
 *
 * @author valer
 */

import javax.swing.*;
import java.awt.*;
import java.io.*;

public class ProductSalesApp extends JFrame {
    private JTextArea txtArea;
    private JLabel lblYears;
    private ProductSales ps;

    public ProductSalesApp() {
        super("Product Sales Application");
        ps = new ProductSales();

        setLayout(new BorderLayout());
        setSize(400, 350);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Menu bar
        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("File");
        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.addActionListener(e -> System.exit(0));
        fileMenu.add(exitItem);

        JMenu toolsMenu = new JMenu("Tools");
        JMenuItem loadItem = new JMenuItem("Load Product Data");
        loadItem.addActionListener(e -> loadProductData());
        JMenuItem saveItem = new JMenuItem("Save Product Data");
        saveItem.addActionListener(e -> saveProductData());
        JMenuItem clearItem = new JMenuItem("Clear");
        clearItem.addActionListener(e -> clear());
        toolsMenu.add(loadItem);
        toolsMenu.add(saveItem);
        toolsMenu.add(clearItem);

        menuBar.add(fileMenu);
        menuBar.add(toolsMenu);
        setJMenuBar(menuBar);

        // Buttons
        JPanel topPanel = new JPanel(new GridLayout(2, 1, 5, 5));
        JButton btnLoad = new JButton("Load Product Data");
        JButton btnSave = new JButton("Save Product Data");
        btnLoad.addActionListener(e -> loadProductData());
        btnSave.addActionListener(e -> saveProductData());
        topPanel.add(btnLoad);
        topPanel.add(btnSave);
        add(topPanel, BorderLayout.NORTH);

        // Text area
        txtArea = new JTextArea();
        txtArea.setEditable(false);
        add(new JScrollPane(txtArea), BorderLayout.CENTER);

        // Years label
        lblYears = new JLabel("Years Processed: 0");
        add(lblYears, BorderLayout.SOUTH);

        setVisible(true);
    }

    private void loadProductData() {
        int total = ps.GetTotalSales();
        double avg = ps.GetAverageSales();
        int over = ps.GetSalesOverLimit();
        int under = ps.GetSalesUnderLimit();
        int years = ps.GetProductsProcessed();

        String output = String.format(
            "Total Sales: %d%nAverage Sales: %.0f%nSales over limit: %d%nSales under limit: %d%n",
            total, avg, over, under
        );

        txtArea.setText(output);
        lblYears.setText("Years Processed: " + years);
    }

    private void saveProductData() {
        try (PrintWriter out = new PrintWriter(new FileWriter("data.txt"))) {
            out.println("DATA LOG");
            out.println("************************");
            out.print(txtArea.getText());
            out.println("************************");
            JOptionPane.showMessageDialog(this, "Data saved to data.txt");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error saving file.");
        }
    }

    private void clear() {
        txtArea.setText("");
        lblYears.setText("Years Processed: 0");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ProductSalesApp::new);
    }
}
