/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs401_assign2_javasortingguiapplication;

import java.util.ArrayList;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.Random;


public class DataObject {
    ArrayList<Integer> array = new ArrayList();
    Random rand = new Random();
    public String fileName;
    
    public DataObject(){}
    
    public void writeToFile() throws IOException{
        
        WriteFile data = new WriteFile(fileName);
        data.clearFile();
        for(int i = 0; i<array.size(); i++){
            data.writeToFile(Integer.toString(array.get(i)));
        }
    }
    
    
    
    
    public void create(boolean sorted, int n) throws IOException
    {
        if(sorted)
        {
            generateSortedData(n);
        }
        else
        {
            generateUnsortedData(n);
        }
    }
    public ArrayList getArray()
    {
        return array;
    }
    
    public Integer[] asArray(){
        Integer[] a = new Integer[array.size()];
        for(int i = 0; i<array.size(); i++){
            a[i]=array.get(i);
        }
        return a;
    }
    public int size(){
        return array.size();
    }
    
   public void takeInArray(Integer[] a){
       array.clear();
       for(int i = 0; i< a.length; i++){
           array.add(a[i]);
       }
   }

    private void generateSortedData(int n) throws IOException 
    {
        array.clear();
        for(int i = 0; i<n; i++)
        {
            array.add(i);
        }
        fileName = "/sorted500000.txt";
        writeToFile();
    }

    private void generateUnsortedData(int n) throws IOException 
    {
       array.clear();
       for(int i = 0; i<n; i++)
       {
           array.add(rand.nextInt(n));
       }
       fileName = "/random500000.txt";
       writeToFile();
    }
    
    public void printData()
    {
        for(int i = 0; i<array.size(); i++)
        {
            System.out.println(array.get(i));
        }
    }
    
    
    
    
}
