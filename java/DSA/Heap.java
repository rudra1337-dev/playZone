import java.util.*;

public class Heap{


    // 1️⃣ Min Heap — Insert
    void insertMinHeap(List<Integer> heap, int value){
        if(heap == null) return;

        // Add value to last of the heap
        heap.add(value);

        //Heapify up
        int i = heap.size()-1;

        while(i>0 && heap.get(i) < heap.get((i-1)/2)){
            
            //Replace the child with parent
            int temp = heap.get(i);
            heap.set(i, heap.get((i-1)/2));
            heap.set((i-1)/2, temp);

            i = (i-1)/2;
        }

        return;

    }


    // 2️⃣ Max Heap — Insert
    void insertMaxHeap(List<Integer> heap, int value){
        if(heap == null) return;

        // Add value
        heap.add(value);

        //Heapify up
        int i = heap.size()-1;

        while(i>0 && heap.get(i) > heap.get((i-1)/2)){

            // Replace the child with the parent
            int temp = heap.get(i);
            heap.set(i, heap.get((i-1)/2));
            heap.set((i-1)/2, temp);

            i = (i-1)/2;
        }

        return;
    }

    int peekMin(List<Integer> heap){
        if(heap == null) return Integer.MIN_VALUE;
        return heap.get(0);
    }

    int peekMax(List<Integer> heap){
        if(heap == null) return Integer.MIN_VALUE;
        return heap.get(0);
    }

    void swap(List<Integer> list, int a, int b) {
        if (list == null) return;

        int temp = list.get(a);
        list.set(a, list.get(b));
        list.set(b, temp);
    }


    // 4️⃣ Min Heap — Extract Root
    int extractMin(List<Integer> heap){
        if(heap == null || heap.isEmpty()) return Integer.MIN_VALUE;

        //save the removed item
        int value = heap.get(0);

        //move last to root
        heap.set(0, heap.get(heap.size()-1));
        heap.remove(heap.size()-1);
        if(heap.isEmpty()) return value;

        //Heapify down (compare parent and child)

        int i = 0;

        while(true){
            int left = 2*i+1;
            int right = 2*i+2;

            if(left < heap.size() && right < heap.size()){
                int leftChild = heap.get(left);
                int rightChild = heap.get(right);

                int child = leftChild <= rightChild ? left : right;

                if(heap.get(i) > heap.get(child)){
                    swap(heap, i, child);
                    i = child;
                }else break;
            }else if(left < heap.size()){
                int leftChild = heap.get(left);

                if(heap.get(i) > leftChild){
                    swap(heap, i, left);
                    i = left;
                }else break;
            }else if(right < heap.size()){
                int rightChild = heap.get(right);

                if(heap.get(i) > rightChild){
                    swap(heap, i, right);
                    i = right;
                }else break;
            }else break;

        }

        return value;
    }

    // 5️⃣ Max Heap — Extract Root
    int extractMax(List<Integer> heap){
        if(heap == null || heap.isEmpty()) return Integer.MIN_VALUE;

        // save the value
        int value = heap.get(0);

        // move the last ele to root
        heap.set(0, heap.get(heap.size()-1));
        heap.remove(heap.size()-1);
        if(heap.isEmpty()) return value;

        // Heapify down

        int i = 0;

        while(true){
            int left = 2*i+1;
            int right = 2*i+2;
            int n = heap.size();
            int child = 0;

            if(left < n && right < n){
                int leftChild = heap.get(left);
                int rightChild = heap.get(right);

                int childInd = leftChild > rightChild ? left : right;

                if(heap.get(i) < heap.get(childInd)){
                    child = childInd;
                }else break;
            }else if(left < n){
                int leftChild = heap.get(left);

                if(heap.get(i) < leftChild){
                    child = left;
                }else break;
            }else if(right < n){
                int rightChild = heap.get(right);

                if(heap.get(i) < rightChild){
                    child = right;
                }else break;
            }else break;

            swap(heap, i, child);
            i = child;
        }

        return value;
    }

    
    // 6️⃣ Arbitrary Delete

    //Min heap

    void deleteAt(List<Integer> heap, int index){
        if (heap == null || index < 0 || index >= heap.size()) {
            System.out.println("Index out of bound");
            return;
        }

        // move the last ele to that  index
        heap.set(index, heap.get(heap.size()-1));
        heap.remove(heap.size()-1);

        //select hepify up or down
        int i = index;
        int n = heap.size();

        
        // heapify up
        if(i > 0){
            int parent  = (i-1)/2;
            
            if(heap.get(i) < heap.get(parent)){
                while(i > 0){
                    parent  = (i-1)/2;
                    if(heap.get(i) >= heap.get(parent)) break;

                    swap(heap, i, parent);
                    i = parent;
                }

                return;
            }
        }


        // Heapi down
        while(true){

            int left = 2*i+1;
            int right = 2*i+2;
            int child = 0;

            if(left < n && right < n){
                int leftChild = heap.get(left);
                int rightChild = heap.get(right);

                int childInd = leftChild < rightChild ? left : right;

                if(heap.get(i) > heap.get(childInd)){
                    child = childInd;
                }else break;
            }else if(left < n){
                int leftChild = heap.get(left);

                if(heap.get(i) > leftChild){
                    child = left;
                }else break;
            }else if(right < n){
                int rightChild = heap.get(right);

                if(heap.get(i) > rightChild){
                    child = right;
                }else break;
            }else break;

            swap(heap, i, child);
            i = child;
        }

    }

    //max heap


    void deleteAtmax(List<Integer> heap, int index){
        if (heap == null || index < 0 || index >= heap.size()) {
            System.out.println("Index out of bound");
            return;
        }

        // move the last ele to that  index
        heap.set(index, heap.get(heap.size()-1));
        heap.remove(heap.size()-1);

        //select hepify up or down
        int i = index;
        int n = heap.size();

        
        // heapify up
        if(i > 0){
            int parent  = (i-1)/2;
            
            if(heap.get(i) > heap.get(parent)){
                while(i > 0){
                    parent  = (i-1)/2;
                    if(heap.get(i) <= heap.get(parent)) break;

                    swap(heap, i, parent);
                    i = parent;
                }

                return;
            }
        }


        // Heapi down
        while(true){

            int left = 2*i+1;
            int right = 2*i+2;
            int child = 0;

            if(left < n && right < n){
                int leftChild = heap.get(left);
                int rightChild = heap.get(right);

                int childInd = leftChild > rightChild ? left : right;

                if(heap.get(i) < heap.get(childInd)){
                    child = childInd;
                }else break;
            }else if(left < n){
                int leftChild = heap.get(left);

                if(heap.get(i) < leftChild){
                    child = left;
                }else break;
            }else if(right < n){
                int rightChild = heap.get(right);

                if(heap.get(i) < rightChild){
                    child = right;
                }else break;
            }else break;

            swap(heap, i, child);
            i = child;
        }

    }


    public static void main(String args[]){


        System.out.println("-----Welcome to Heap-----");

        List<Integer> heap = new ArrayList<>();


    }
}