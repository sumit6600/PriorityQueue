import java.util.*;
import java.util.PriorityQueue;

class minComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer o1, Integer o2) {
        if(o1 < o2){
            return -1;
        }else if(o1 > o2 ){
            return 1;
        } else{
            return 0;
        }
    }
}

class maxComaparator implements Comparator<Integer>{

    @Override
    public int compare(Integer o1, Integer o2) {
        if(o1 > o2){
            return -1;
        }else if (o1 < o2){
            return 0;
        }else
        return 0;
    }
}
class StringComparator implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        if(o1.length() < o2.length()){
            return -1;
        }else if(o1.length() > o2.length() ){
            return 1;
        } else{
            return 0;
        }
    }
}

public class InbuiltpriorityQueue {

    /*Given an array of integers, check whether it represents max-heap or not. Return true if the given array represents max-heap, else return false.*/
    public static boolean checkMaxHeap(int arr[]) {

        for(int i = 0 ; i<arr.length;i++){
            int leftindex = 2*i + 1;
            int rightindex = 2*i + 2;
            if(leftindex < arr.length  && arr[leftindex] > arr[i]){
                return false;
            }
            if(rightindex < arr.length && arr[rightindex] > arr[i]){
                return false;
            }
        }

        return true;
    }

    /*Given an array 'arr' of random integers and an integer 'k', return the kth largest element in the array.*/
    public static int kthLargest(int n, int[] arr, int k) {
        // Write your code here
        if(arr.length==0)
            return Integer.MIN_VALUE;
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        int i=0;
        for(;i< k;i++) {
            pq.add(arr[i]);
        }

        for(;i<arr.length;i++){
            int min=pq.element();//pq.peek;
            if(min<arr[i])
            {    pq.remove();
                pq.add(arr[i]);
            }
        }
        return pq.remove();
    }

    /*Given k no. of different size arrays, which are sorted individually (in ascending order).
    You need to merge all the given arrays such that output array should be sorted (in ascending order).*/
    public static ArrayList<Integer> mergeKSortedArrays(ArrayList<ArrayList<Integer>> input) {

        ArrayList<Integer> mergedArray = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(ArrayList<Integer> arr : input){
            pq.addAll(arr);
        }
        while(!pq.isEmpty()){
            mergedArray.add(pq.poll());
        }

        return mergedArray;

    }

    /*Running Median You are given a stream of 'N' integers. For every 'i-th' integer added to the running list of integers,
     print the resulting median.Print only the integer part of the median.*/

    public static void findMedian(int arr[])  {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int num : arr) {
            addNumber(num, maxHeap, minHeap);
            rebalanceHeaps(maxHeap, minHeap);
            System.out.print(getMedian(maxHeap, minHeap) + " ");
        }
    }

    private static void addNumber(int num, PriorityQueue<Integer> maxHeap, PriorityQueue<Integer> minHeap) {
        if(maxHeap.isEmpty() || num <= maxHeap.peek()){
            maxHeap.add(num);
        }else{
            minHeap.add(num);
        }
    }

    private static void rebalanceHeaps(PriorityQueue<Integer> maxHeap, PriorityQueue<Integer> minHeap) {
        if(maxHeap.size() > minHeap.size() + 1){
            minHeap.add(maxHeap.poll());
        }else if(minHeap.size() > maxHeap.size()){
            maxHeap.add(minHeap.poll());
        }
    }

    private static int getMedian(PriorityQueue<Integer> maxHeap, PriorityQueue<Integer> minHeap) {
        if (maxHeap.size() == minHeap.size()) {
            return (maxHeap.peek() + minHeap.peek()) / 2;
        } else {
            return maxHeap.peek();
        }
    }

    /*Buy the ticket You want to buy a ticket for a well-known concert which is happening in your city. But the number of tickets available is limited. Hence the sponsors of the concert decided to sell tickets to customers based on some priority.
    A queue is maintained for buying the tickets and every person is attached with a priority (an integer, 1 being the lowest priority).
    The tickets are sold in the following manner -
    1. The first person (pi) in the queue requests for the ticket.
    2. If there is another person present in the queue who has higher priority than pi, then ask pi to move at end of the queue without giving him the ticket.
    3. Otherwise, give him the ticket (and don't make him stand in queue again).
    Giving a ticket to a person takes exactly 1 second and it takes no time for removing and adding a person to the queue. And you can assume that no new person joins the queue.
    Given a list of priorities of N persons standing in the queue and the index of your priority (indexing starts from 0). Find and return the time it will take until you get the ticket.*/

    public static int buyTicket(int input[], int k) {
        PriorityQueue<Integer> pq =  new PriorityQueue<>(Collections.reverseOrder());
        Queue<Integer> queue = new LinkedList<Integer>();
        for(int i = 0;i< input.length;i++){
            queue.add(i);
            pq.add(input[i]);

        }
        int count = 0;
        while(!queue.isEmpty()){
            int index =  queue.poll();
            if(input[index]>=pq.element()){
                count++;
                pq.remove();
                if(index == k){
                    break;
                }
            }else{
                queue.add(index);
            }
        }

        return count;


    }
    public static void main(String[] args){
        String [] arr = {"qwe" , "hj" , "poiuyt" , "zxcv" , "lkjhgfdsa"};
        StringComparator stringComparator = new StringComparator();
        PriorityQueue<String> pq = new PriorityQueue<>(stringComparator);
        PriorityQueue<Integer> pq2 = new PriorityQueue<>(Collections.reverseOrder());
        for(String element : arr){
            pq.add(element);
        }
        while (!pq.isEmpty()){
            System.out.print(pq.remove() + " ");
        }

    }
}
