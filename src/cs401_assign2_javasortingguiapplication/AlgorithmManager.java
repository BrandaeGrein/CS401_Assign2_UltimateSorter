/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs401_assign2_javasortingguiapplication;

import java.io.IOException;

/**
 *
 * @author Brandae2
 */
public class AlgorithmManager {
    private DataObject data = new DataObject();
    private AllSortingAlgorithms sorter = new AllSortingAlgorithms();
    private long startTime;
    private long endTime;
    
    public AlgorithmManager(){}
    
    public void setSortedData(int n) throws IOException{
        data.create(true, n);
    }
    public void setUnsortedData(int n) throws IOException{
        data.create(false, n);
    }
    
    public long runMergeSort() throws IOException{
        Integer[] a = data.asArray();
        startTime = System.currentTimeMillis();
        sorter.mergeSort(data.asArray(), 0, data.size()-1);
        endTime = System.currentTimeMillis();
        data.takeInArray(a);
        data.writeToFile();
        return endTime-startTime;
    }
    public long runBubbleSort() throws IOException{
        startTime = System.currentTimeMillis();
        sorter.bubbleSort(data.getArray());
        endTime = System.currentTimeMillis();
        data.writeToFile();
        return endTime-startTime;
    }
    public long runHeapSort() throws IOException{
        startTime = System.currentTimeMillis();
        sorter.heapSort(data.getArray());
        endTime = System.currentTimeMillis();
        data.writeToFile();
        return endTime-startTime;
    }
    public long runInsertionSort() throws IOException{
        startTime = System.currentTimeMillis();
        sorter.insertionSort(data.getArray());
        endTime = System.currentTimeMillis();
        data.writeToFile();
        return endTime-startTime;
    }
    public long runSelectionSort() throws IOException{
        startTime = System.currentTimeMillis();
        sorter.selectionSort(data.getArray());
        endTime = System.currentTimeMillis();
        data.writeToFile();
        return endTime-startTime;
    }
    public long runShellSort() throws IOException{
        startTime = System.currentTimeMillis();
        sorter.shellSort(data.getArray());
        endTime = System.currentTimeMillis();
        data.writeToFile();
        return endTime-startTime;
    }
    
    public long runQuickSort() throws IOException{
        startTime = System.currentTimeMillis();
        sorter.quickSort(data.getArray(), 0, data.size()-1);
        endTime = System.currentTimeMillis();
        data.writeToFile();
        return endTime-startTime;
    }
    
    
}
