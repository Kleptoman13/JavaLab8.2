package com.company;

import java.awt.desktop.SystemEventListener;
import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        Database db = new Database();

        //чтение предыдущего db
        Database dbOld = new Database();
        int k = loadcount("count.txt");
        dbOld.load("db"+(k-1)+".txt");
        System.out.println("Loaded old db: " + dbOld);

        db.add(8, 670, 2019, "IKEA");
        db.add(5, 1080, 2021, "IKEA");
        db.add(5, 560, 2014, "IKEA");


        System.out.println(db);

        //запись нового db
        db.save("db"+k+".txt");
        db.clear();
        System.out.println("Current db: " + db);

        //чтение нового db
        db.load("db"+k+".txt");
        System.out.println("Loaded db: " + db);

        //запись нового k
        savecount("count.txt", k);
    }

    public static void savecount(String filename, int k) throws IOException {
        FileWriter fw = new FileWriter(filename);
        BufferedWriter bw = new BufferedWriter(fw);

        try
        {
            bw.write(String.valueOf(k+1));
        } catch (Exception e)
        {
            e.printStackTrace();
        }

        bw.close();
    }

    public static int loadcount(String filename) throws FileNotFoundException {
        Scanner scanner = new Scanner (new FileReader(filename));

        int k = -1;

        while(scanner.hasNextLine())
        {
            k = Integer.valueOf(scanner.nextLine());
        }
        return k;
    }
}
