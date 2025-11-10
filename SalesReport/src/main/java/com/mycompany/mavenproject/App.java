/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject;
/**
 *
 * @author valer
 */
public class App {

    public static void main(String[] args) {

        int[][] sales = {
            {300, 150, 700}, // Year 1
            {250, 200, 600}  // Year 2
        };

        ProductSales ps = new ProductSales();

        int total = ps.TotalSales(sales);
        double avg = ps.AverageSales(sales);
        int max = ps.MaxSale(sales);
        int min = ps.MinSale(sales);

        System.out.println("PRODUCT SALES REPORT - 2025");
        System.out.println("---------------------------");
        System.out.println("Total sales: " + total);
        System.out.println("Average sales: " + Math.round(avg));
        System.out.println("Maximum sale: " + max);
        System.out.println("Minimum sale: " + min);

        System.out.println("\nYEAR     Q1     Q2     Q3");
        System.out.printf("YEAR 1   %-6d %-6d %-6d%n", sales[0][0], sales[0][1], sales[0][2]);
        System.out.printf("YEAR 2   %-6d %-6d %-6d%n", sales[1][0], sales[1][1], sales[1][2]);
    }
}
