/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs401_assign2_javasortingguiapplication;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Brandae2
 */
public class AllSortingAlgorithms {
    
    //constructors
    
    public AllSortingAlgorithms(){}
    
    /*
    *********************
    Less than comparison
    *********************
    */
    private static Boolean less(Comparable o1, Comparable o2){
        return o1.compareTo(o2)<0;
    }
    
    /*
    *********************
    SELECTION SORT
    *********************
    */
    public ArrayList selectionSort(ArrayList<Comparable> array){
        int n = array.size();
        int i = 0; 
        int min_index;//this will be the index of the "minimum value" while iterating the array;
        while(i<n-1){//this will iterate through the array, with i as the "next min spot"
            min_index = i;
            int j = i+1;
            while(j<n){
                if(array.get(j).compareTo(array.get(min_index))<0){
                    min_index = j;
                    
                }
                j++;
               
            }
            
            Collections.swap(array, min_index, i);
            i++;
        }
        
        return array;
    }
    
    
    /*
    *********************
    INSERTION SORT
    *********************
    */
    public static void insertionSort(ArrayList<Comparable> array){
        for(int i = 1; i<array.size();i++){
            for(int j = i; j>0 && array.get(j).compareTo(array.get(j-1))<0;j--){
                Collections.swap(array, j, j-1);
            }
        }
        
        
    }
    
    /*
    *********************
    MERGE SORT
    *********************
    */
    
    public static void mergeSort(Comparable[] a, int first, int last){
        if(first<last){
            int mid = (first+last)/2;
            mergeSort(a, first, mid);
            mergeSort(a, mid+1, last);
            merge(a, first, mid, last);
        }
    
    
    } 
    private static void merge(Comparable[] a, int first, int mid, int last){
        Comparable[] temp = new Comparable[a.length];
        int first1 = first;
        int last1 = mid;
        int first2 = mid+1;
        int last2 = last;
        int index = first; //next available position in temp array
        for(;(first1<=last1 && first2<=last2);index++){
            if(less(a[first1],a[first2])){
                temp[index]=a[first1];
                first1++;
            }else{
                temp[index]=a[first2];
                first2++;
            }
        }
        for(;first1<= last1;index++){
            temp[index]=a[first1];
            first1++;
           
        }
        for(;first2<= last2;index++){
            temp[index]=a[first2];
            first2++;
           
        }
        //copy the now sorted array back into the original
        for(int i = first; i<=last; i++){
            a[i]=temp[i];
        }
    }
    /*
    *********************
    QUICK SORT
    *********************
    */
    public static void quickSort(ArrayList<Comparable> a, int first, int last){
        if(first<last){
            int pivotIndex = partition(a, first, last);
            quickSort(a, first, pivotIndex-1);
            quickSort(a,  pivotIndex+1, last);
        }
        
    }
    private static int partition(ArrayList<Comparable> a, int first, int last) {
        
        //choose a pivot and place it into the first element of the array
        choosePivot(a, first, last);
        int pivotIndex = first;
        Comparable pivot = a.get(first);
        int lastS1 = pivotIndex;
        int firstUnknown = pivotIndex +1;
        
        for(; firstUnknown<=last; firstUnknown++){
            if(less(a.get(firstUnknown),pivot)){
                lastS1++;
                Collections.swap(a, firstUnknown, lastS1);
            }
        }
        Collections.swap(a, pivotIndex, lastS1);
        pivotIndex = lastS1;
        return pivotIndex;//To change body of generated methods, choose Tools | Templates.
    
    }
    private static void choosePivot(ArrayList<Comparable> a, int first, int last) {
       int pivotIndex = (first+last)/2;
       Collections.swap(a, first, pivotIndex);
    }
    
    /*
    *********************
    BUBBLE SORT
    *********************
    */
    public void bubbleSort(ArrayList<Comparable> array) 
    { 
        int n = array.size();
        for (int i = 0; i < n-1; i++)
        {       
            for (int j = 0; j < n-i-1; j++)
            {  
                if (array.get(j).compareTo(array.get(j+1)) > 0)
                { 
                    Collections.swap(array, j, j+1); 
                }
            }
        }
    }
    /*
    *********************
    SHELL SORT
    *********************
    */
    public void shellSort(ArrayList<Comparable> array)
    {
        int h = 1; 
        int n = array.size();
        while(h<(n/3))
        {
          h = 3*h +1;
        }
            for(;h>0;h/=3)
            {
                for(int i = h; i<n; i++)
                {
                    for(int j = i; j>=h && less(array.get(j),array.get(j-h)); j-=h)
                    {
                        Collections.swap(array, j, j-1);
                    }
                }
            }
        
    }
    
    /*
    *********************
    SHELL SORT
    *********************
    */
    
    public void heapSort(ArrayList<Comparable> array){
        int n = array.size();
        for(int i = (n/2) -1 ; i >= 0; i--){
            heapify(array, n, i);
        }
        // One by one extract an element from heap 
        for (int i=n-1; i>=0; i--) 
        { 
            // Move current root to end 
            Collections.swap(array, i, 0);
            
            // call max heapify on the reduced heap 
            heapify(array, i, 0); 
        } 
    }

    private void heapify(ArrayList<Comparable> array, int n, int i) {
        int largest = i;  // Initialize largest as root 
        int left = 2*i + 1;  // left = 2*i + 1 
        int right = 2*i + 2;  // right = 2*i + 2 
  
        // If left child is larger than root 
        if (left < n && array.get(left).compareTo(array.get(largest))>0) 
            largest = left; 
  
        // If right child is larger than largest so far 
        if (right < n && array.get(right).compareTo(array.get(largest))>0) 
            largest = right; 
  
        // If largest is not root 
        if (largest != i) 
        { 
            Collections.swap(array, largest, i);

            // Recursively heapify the affected sub-tree 
            heapify(array, n, largest); 
        } 
    }

    
    
}
