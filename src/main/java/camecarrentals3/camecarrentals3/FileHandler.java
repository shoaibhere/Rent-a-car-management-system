package camecarrentals3.camecarrentals3;

import java.io.*;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.NoSuchElementException;
import java.util.Scanner;

public abstract class FileHandler implements Serializable{
    public static <T> void writeData(ArrayList<T> data,String filePath)
    {
        try {
            ObjectOutputStream transactionOutputStream = new ObjectOutputStream(new FileOutputStream(filePath,false));
            transactionOutputStream.writeObject(data);
            transactionOutputStream.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static <T> void readData(ArrayList<T> data,String filePath)
    {
        try {
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(filePath));
            Object obj = inputStream.readObject();
            if(obj instanceof ArrayList)
            {
                data.addAll((ArrayList<T>)obj);
            }
            System.out.println("data read");
            inputStream.close();
        }
        catch (IOException | NoSuchElementException |ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void writeFinanceDataOnFile()
    {
        try{
            Formatter formatter = new Formatter("C:\\Users\\DELL\\OneDrive\\Desktop\\CameCarRentals3\\Finance.txt");
            formatter.format("%d",Finance.getAccountBalance());
            formatter.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static void readFinanceDataOnFile()
    {
        try{
            Scanner scanner = new Scanner(Paths.get("C:\\Users\\DELL\\OneDrive\\Desktop\\CameCarRentals3\\Finance.txt"));
                long balance = scanner.nextLong();
                Finance.setAccountBalance(balance);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
