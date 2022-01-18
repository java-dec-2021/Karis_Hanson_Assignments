public class SinglyLinkedList{
    public Node head;
    public SinglyLinkedList(){
        this.head = null;
    }
    public void add(int value){
        Node newNode = new Node(value);
        //if list is empty, make new node the head
        if(head == null){
            head = newNode;

        }else {
            // set pointer to the head
            Node runner = head; 
            //move through list to find last node
            while(runner.next !=null){
                runner = runner.next;
            }
            runner.next = newNode;
        }
    }

    public void remove(){
        // if list is empty , 
        if (head == null){

        }else{
             // set pointer to the head
            Node runner = head; 
            //move through list to find last node
            while(runner.next.next !=null){
                runner = runner.next;
            }
            runner.next = null; 
        }
    }

    public void printValues(){
        if(head == null){
            System.out.println("List is empty");
        }else{
            Node runner = head;
            while(runner != null){
                System.out.println(runner.value);
                runner = runner.next;
            }
        }
    }
}