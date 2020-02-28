
/**
 *
 * A class that implements a queue.  It is your job to complete this class.  Your queue
 * will use a linked list constructed by QueueElements.  However, your queue must be general and allow
 * setting of any type of Object.  Also you cannot use ArrayLists or arrays (you will get zero).
 * @author you
 *
 */


import java.util.NoSuchElementException;

public class Queue<T>{
    QueueElement<T> front;
    QueueElement<T> rear;
    int size;
    
    /**
     * Constructs an empty Queue.
     */
    public Queue () {
        this.front = null;
        this.rear = null;
        this.size = 0;
    }
    
    /**
     * Returns true if the queue is empty
     */
    public boolean isEmpty () {
        return (this.front == null && this.rear == null);
    }
    
    
    /**
     * Returns the element at the head of the queue
     */
    public T peek () throws NoSuchElementException {
        return (T)this.front.getElement();
    }
    
    /**
     * Removes the front element of the queue
     */
    public void dequeue () throws NoSuchElementException {
        // If queue is empty, return NULL. 
        if (isEmpty()){ 
            return;
        }
        // Store previous front and move front one node ahead 
        //QueueElement<T> temp = this.front; 
        this.front = this.front.getNext(); 
        // If front becomes NULL, then change rear also as NULL 
        if (this.front == null){
            this.rear = null;
        } 
        this.size--;
    }
    
    /**
     * Puts an element on the back of the queue.
     */
    public void enqueue (T element) {
        QueueElement<T> temp = new QueueElement<T>(element, null); 
  
        // If queue is empty, then new node is front and rear both 
        if (isEmpty()) { 
            this.front = this.rear = temp; 
        } else{
            // Add the new node at the end of queue and change rear 
            this.rear.setNext(temp); 
            this.rear = temp;
        }
        this.size++;
  
        
    }
    
    /**
     * Method to print the full contents of the queue in order from head to tail.
     */
    public void print () {
        QueueElement<T> temp = this.front;
        while(temp != null){
            System.out.println(temp.getElement().toString());
            temp = temp.getNext();
        }
    }
}
