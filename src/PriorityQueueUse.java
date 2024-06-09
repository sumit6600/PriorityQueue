
public class PriorityQueueUse {

    /* 6 2 1 5 19 18 */
    public static void implaceHeapInsert(int element, int arr[]){
        int childIndex = element;
        int parentIndex = (element -1 )/2;
        while (childIndex > 0){
            if(arr[parentIndex] > arr[childIndex] ){
                int temp = arr[childIndex];
                arr[childIndex] = arr[parentIndex];
                arr[parentIndex]= temp;
                childIndex = parentIndex;
                parentIndex = childIndex -1/2;
            }else{
                return;
            }
        }
    }

    /* 6 2 1 5 19 18 */
    public static void implaceHeapRemove(int size, int[] arr){
        int temp = arr[0];
        System.out.print(temp + " ");
        arr[0] = arr[size - 1];
        arr[size-1] = temp;
        size--;
        int leftIndex = 1;
        int rightIndex = 2;
        int index = 0;
        int minindex = index;
        while (leftIndex < size){
            if(arr[leftIndex] < arr[minindex]){
                minindex = leftIndex;
            }
            if( rightIndex < size && arr[rightIndex] < arr[minindex]){
                minindex = rightIndex;
            }
            if(index == minindex){
                return;
            }else{
                int temp2 = arr[index];
                arr[index] = arr[minindex];
                arr[minindex] = temp2;
                index = minindex;
                leftIndex = 2*index + 1;
                rightIndex = 2* index +2;
            }
        }
    }

    /*K sorted Array */
    public static void kSorted(int arr[] , int k) throws PriorityQueueException {
        PriorityQueue pq = new PriorityQueue();
        int i = 0;
        for(;i<k ; i++){
            pq.insert(arr[i]);
        }
        for(;i<arr.length;i++){
            arr[i-k] = pq.remove();
            pq.insert(arr[i]);
        }
        for(int j = 0; j <  k ; j++ ){
            arr[arr.length - k + j] = pq.remove();
        }
    }

    /* K largest elements in the array */
    public static void kLargestElements(int arr[] , int k) throws PriorityQueueException {
        PriorityQueue pq= new PriorityQueue();
        int i=0;
        for(;i<k;i++){
            pq.insert(arr[i]);
        }
        for(;i< arr.length;i++){
            int element = pq.getMin();
            if(element < arr[i]){
                pq.remove();
                pq.insert(arr[i]);
            }
        }
        while (!pq.isEmpty()){
            System.out.print(pq.remove() + " ");
        }
    }


    public static void main(String [] args) throws PriorityQueueException {
        PriorityQueue pq = new PriorityQueue();
        PriorityQueue pq1 = new PriorityQueue();
        int arr[] = {5, 1 ,9 ,2 ,0};
        int arr2[] = {6 ,2, 1, 5, 19, 18};
        int arr3[] = {10 , 30 , 32 , 50 , 48 , 25 , 45};
        int ksortArr[] = {3 ,6 ,1 ,4 ,7 ,9};
        System.out.print("Priority queue array : ");
        for(int i = 0;i<arr.length;i++){
                pq.insert(arr[i]);
            }
        while (!pq.isEmpty()){
          System.out.print(pq.remove()+ " ");
        }
        System.out.println("");
        for (int i =0;i<arr2.length;i++){
                implaceHeapInsert(i , arr2);
            }
        System.out.print("Implace priority queue array : ");
        for(int i =0;i<arr2.length;i++){
            System.out.print(arr2[i] + " ");
        }
        System.out.println(" ");
        System.out.print("Implace priority queue sorted array : ");
        for (int i =0;i<arr2.length;i++){
           implaceHeapRemove(arr2.length - i, arr2);
        }
        System.out.println(" ");
        System.out.print("K sorted array: ");
        kSorted(ksortArr , 3);
        for(int element : ksortArr)
        System.out.print(element + " ");

        System.out.println(" ");
        System.out.print("K largest elements : ");
        kLargestElements(arr3 , 3);

    }

}
