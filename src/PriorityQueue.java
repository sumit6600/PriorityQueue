import java.util.ArrayList;

public class PriorityQueue {
    private  ArrayList<Integer> heap;

    public PriorityQueue(){
       heap =  new ArrayList<>();
    }

    public int getSize(){
        return heap.size();
    }

    public boolean isEmpty(){
        return heap.size() == 0;
    }

    public int getMin (){
        if(isEmpty()){
            new PriorityQueueException();
        }
        return heap.get(0);
    }

    public void insert(int element){
      heap.add(element);
      int childIndex = heap.size() - 1;
      int parentIndex = (childIndex - 1) / 2;
      while (childIndex>0){
          if(heap.get(parentIndex) > heap.get(childIndex)){
              int temp = heap.get(childIndex);
              heap.set(childIndex , heap.get(parentIndex));
              heap.set(parentIndex , temp);
              childIndex = parentIndex;
              parentIndex = (childIndex-1)/2;
          }
          else {
              return;
          }
      }
    }

    public int remove() throws PriorityQueueException{
        if(isEmpty()){
            throw new PriorityQueueException();
        }
        int temp = heap.get(0);
        heap.set(0, heap.get(heap.size() -1));
        heap.remove(heap.size() -1);
        int index = 0;
        int leftchildIndex = 1;
        int rightchildIndex = 2;
        int minIndex = index;
        while(leftchildIndex < heap.size()){
            if(heap.get(leftchildIndex) < heap.get(minIndex)){
                minIndex = leftchildIndex;
            }
            if(rightchildIndex < heap.size() && (heap.get(rightchildIndex) < heap.get(minIndex))){
                minIndex = rightchildIndex;
            }
            if(index == minIndex){
                break;
            }else {
                int temp1 = heap.get(index);
                heap.set(index , heap.get(minIndex));
                heap.set(minIndex , temp1);
                index = minIndex;
                leftchildIndex = 2*index +1;
                rightchildIndex = 2*index +2;
            }

        }

            return temp;
    }


}

