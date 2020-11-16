package com.walmartlabs.dsround;

import java.util.Arrays;

/*
 * problem statement: Given arrival and departure times of all trains that reach a railway station,
 * the task is to find the minimum number of platforms required for the railway station so that no
 * train waits. We are given two arrays which represent arrival and departure times of trains that
 * stop.
 * 
 * Input: arr[] = {9:00, 9:40, 9:50, 11:00, 15:00, 18:00} dep[] = {9:10, 11:20, 11:30,12:00, 19:00,
 * 20:00}
 * 
 */
public class MinimumPlatform {

  public static int findStations(int[] arr, int[] dep) {
    Arrays.sort(arr);
    Arrays.parallelSort(dep);
    int currPlatforms = 0;
    int maxPlatforms = 0;

    int a = 0;
    int d = 0;
    while (a < arr.length) {
      if (arr[a] <= dep[d]) {
        a++;
        currPlatforms++;
      } else {
        d++;
        currPlatforms--;
      }

      if (currPlatforms > maxPlatforms) {
        maxPlatforms = currPlatforms;
      }
    }

    return maxPlatforms;
  }

  public static void main(String[] args) {
    int[] arr = {900, 940/* , 950, 1100, 1500, 1800 */};
    int[] dep = {910, 1200/* , 1120, 1130, 1900, 2000 */};
    int findStations = findStations(arr, dep);
    System.out.println(findStations);

  }

}
