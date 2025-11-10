/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject;
/**
 *
 * @author valer
 */
public class ProductSales implements IProduct {

    public int TotalSales(int[][] productSales) {
        int total = 0;
        for (int[] year : productSales) {
            for (int sale : year) {
                total += sale;
            }
        }
        return total;
    }

    public double AverageSales(int[][] productSales) {
        int total = TotalSales(productSales);
        int count = 0;
        for (int[] year : productSales) {
            count += year.length;
        }
        return (double) total / count;
    }

    public int MaxSale(int[][] productSales) {
        int max = productSales[0][0];
        for (int[] year : productSales) {
            for (int sale : year) {
                if (sale > max) {
                    max = sale;
                }
            }
        }
        return max;
    }

    @Override
    public int MinSale(int[][] productSales) {
        int min = productSales[0][0];
        for (int[] year : productSales) {
            for (int sale : year) {
                if (sale < min) {
                    min = sale;
                }
            }
        }
        return min;
    }
}
