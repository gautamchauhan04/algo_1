# algo_1
This provides an more optimized subset of Java Collection. This API might not contains all the bells and wistles of collectios but by doing few basic taskes it does them in an more optimized way. It provides a user with more options then collection like in sorting, it enable user to choose any of merge sort, quick sort or insertion sort.
</br> Following are the data structures provided: 
All the Data structures mentioned below provides implements generics allowing user to store any data type.
Data Type | Class | function | Discription | Complexity
------------- | -------------  | ------------- | ------------- | -------------
Bag  | Bag | (Capacity) | (Optional) You can tell inital size of Bag, size of bag will change dynamically. | O(n)
.|. | isEmpty() | True: if empty or False: if not empty | O(1)
.|.| size() | return size of the bag | O(1)
.|.| add(Value) | Value of same type used initalizing Bag | O(1)*
.|.| iterator| To iterate through the Bag. |.
Queue | Queue | () | No parameters while intializing | O(1)
.|.|enqueue | add value to the queue | O(1)
.|.|dequeue | return earialiest added value. Throw exception if empty queue. | O(1)
.|. | isEmpty() | True: if empty or False: if not empty | O(1)
.|.| size() | return size of the queue | O(1)
.|.| iterator| To iterate through the queue. |.
Stack | Stack |  () | No parameters while intializing | O(1)
.|.|push | add value to the stack | O(1)
.|.|pop | return last added value. Throw exception if empty stack. | O(1)
.|.|view| return last added value without removing it. Throw exception if empty stack. | O(1) 
.|. | isEmpty() | True: if empty or False: if not stack | O(1)
.|.| size() | return size of the stack | O(1)
.|.| iterator| To iterate through the stack. |.

</br> Complete documentation will be avilable in some time.
