/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.productsalesapplication;
/**
 *
 * @author valer
 */
public class ProductSales implements IProductSales {
    private final int SALES_LIMIT = 500;
    private int[][] productSales;

    public ProductSales() {
        // Microphone, Speakers, Mixing Desk (2 years)
        productSales = new int[][] {
            {300, 150, 700},
            {250, 200, 600}
        };
    }

    @Override
    public int[][] GetProductSales() {
        return productSales;
    }

    @Override
    public int GetTotalSales() {
        int total = 0;
        for (int[] year : productSales)
            for (int sale : year)
                total += sale;
        return total;
    }

    @Override
    public int GetSalesOverLimit() {
        int count = 0;
        for (int[] year : productSales)
            for (int sale : year)
                if (sale > SALES_LIMIT)
                    count++;
        return count;
    }

    @Override
    public int GetSalesUnderLimit() {
        int count = 0;
        for (int[] year : productSales)
            for (int sale : year)
                if (sale <= SALES_LIMIT)
                    count++;
        return count;
    }

    @Override
    public int GetProductsProcessed() {
        return productSales.length; // number of years
    }

    @Override
    public double GetAverageSales() {
        int total = GetTotalSales();
        int count = 0;
        for (int[] year : productSales)
            count += year.length;
        return (double) total / count;
    }
}