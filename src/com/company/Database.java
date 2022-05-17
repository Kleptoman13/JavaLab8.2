package com.company;
import java.io.*;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;


public class Database {
    private FileOutputStream outFile;
    public ArrayList<Product> list;

    public Database()
    {
        list = new ArrayList<>();
    }

    public void add(Product product)
    {
        this.list.add(product);
    }

    public void add(int count, int price, int year, String production)
    {
        this.list.add(new Product(count, price, year, production));
    }

    public Product get(int index)
    {
        return this.list.get(index);
    }

    public Product remove(int index)
    {
        return this.list.remove(index);
    }



    @Override
    public String toString()
    {
        return "Database{" + list + '}';
    }

    public void save(String filename) throws IOException
    {
        FileWriter fw = new FileWriter(filename);
        BufferedWriter bw = new BufferedWriter(fw);

        try
        {
            for (Product product:list) {
                bw.write(Integer.toHexString(product.getCount()));
                bw.write(System.lineSeparator());
                bw.write(Integer.toHexString(product.getPrice()));
                bw.write(System.lineSeparator());
                bw.write(Integer.toHexString(product.getYear()).toUpperCase());
                bw.write(System.lineSeparator());
                bw.write(ConvertStringToHex(product.getProduction()));
                bw.write(System.lineSeparator());
            }
        }
        catch (FileNotFoundException e)
        {
            System.out.println("fdsfsd");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        bw.close();
    }

    public void clear()
    {
        this.list.clear();
    }

    public void load(String filename) throws IOException
    {
        this.clear();
        //this.list = new ArrayList<>();
        Scanner scanner = new Scanner (new FileReader(filename));

        int count = -1;
        int price = -1;
        int year = -1;
        String production = "";
        while (scanner.hasNextLine())
        {
            count = Integer.parseInt(scanner.nextLine(), 16);
            price = Integer.parseInt(scanner.nextLine(), 16);
            year = Integer.parseInt(scanner.nextLine(), 16);
            production = scanner.nextLine();

            this.list.add(new Product(count, price, year, production));
        }
        scanner.close();
    }

    public String ConvertStringToHex(String cont)
    {
        byte[] getBytesFromString = cont.getBytes(StandardCharsets.UTF_8);
        BigInteger bigInteger = new BigInteger(1, getBytesFromString);

        String convertedResult = String.format("%x", bigInteger);

        return convertedResult.toUpperCase();
    }


}
