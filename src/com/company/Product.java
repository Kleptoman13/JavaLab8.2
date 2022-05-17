package com.company;

public class Product {
    private int count;
    private int price;
    private int year;
    private String production;

    public Product (int count, int price, int year, String production)
    {
        this.setCount(count);
        this.setPrice(price);
        this.setYear(year);
        this.setProduction(production);
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count > 0 ? count : 1;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price > 0 ? price : 1;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year <= 2022 ? year : 2022;
    }

    public String getProduction() {
        return production;
    }

    public void setProduction(String production) {
        this.production = production;
    }

    public String toString()
    {
        return "Product{" +
                "count: " + getCount() +
                ", price: " + getPrice() +
                ", year: " + getYear() +
                ", production: " + getProduction() + "}";
    }
}
