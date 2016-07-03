package com.naman14.algovisualizer.algorithm.sorting;

import android.app.Activity;

import com.naman14.algovisualizer.LogFragment;
import com.naman14.algovisualizer.algorithm.Algorithm;
import com.naman14.algovisualizer.visualizer.SortingVisualizer;

/**
 * Created by naman on 13/06/16.
 */
public class InsertionSort extends SortAlgorithm {

    int[] array;

    public InsertionSort(SortingVisualizer visualizer, Activity activity, LogFragment logFragment) {
        this.visualizer = visualizer;
        this.activity = activity;
        this.logFragment = logFragment;
    }

    @Override
    public void run() {
        super.run();
    }

    private void sort() {
        logArray(array);


        int n = array.length;
        for (int j = 1; j < n; j++) {
            int key = array[j];
            int i = j-1;
            while ( (i > -1) && ( array [i] > key ) ) {
                array [i+1] = array [i];
                highlightSwap(i, i + 1);
                addLog("Swapping " + array[i] + " and " + array[i + 1]);
                i--;
            }
            sleep();
            array[i+1] = key;
        }
        completed();

        for (int i = 0; i < array.length; i++) {
            addLog("Doing iteration - " + i);
            boolean swapped = false;
            for (int j = 0; j < array.length - 1; j++) {
                highlightTrace(j);
                sleep();
                if (array[j] > array[j + 1]) {
                    highlightSwap(j, j + 1);
                    addLog("Swapping " + array[j] + " and " + array[j + 1]);
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;
                    sleep();
                }
            }
            if (!swapped) {
                break;
            }
            sleep();
        }
        completed();
    }

    @Override
    public void onDataRecieved(Object data) {
        super.onDataRecieved(data);
        this.array = (int[]) data;
    }

    @Override
    public void onMessageReceived(String message) {
        super.onMessageReceived(message);
        if (message.equals(Algorithm.COMMAND_START_ALGORITHM)) {
            startExecution();
            sort();
        }
    }
}