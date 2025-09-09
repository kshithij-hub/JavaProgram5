package Stack;

public class Stack {
	private Person[] a;
	private int top;
	private int capacity; 
	
	Stack(int size){
		this.capacity=size;
		this.top=-1;
		this.a=new Person[capacity];
	}
	Stack(Person[] inputa) {
        capacity = inputa.length;
        a = new Person[capacity];
        top = -1;
        for (Person p : inputa) {
            push(p);
        }
    }
	public void push (Person p) {
		if(top==capacity-1)
		{
			System.out.println("Stack overflow!: cannot push");
			return;
		}
		a[++top]=p;
	}	
	public void push(Person p1,Person p2) {
		push(p1);
		push(p2);
	}
	public Person pop() {
		if(top==-1) {
			System.out.println("stack underflow!");
			return null;
		}
		return a[top--];
	}
	void pop(int n) {
        for (int i = 0; i < n; i++) {
            Person p = pop();
            if (p != null) {
                System.out.print("Popped: ");
                p.displayPerson();
            } else {
                break;
            }
        }
    }
	public void display() {
		System.out.println(" ");
		for (int i = top; i >= 0; i--) {
			a[i].displayPerson();
		}
	}
	void display(int n) {
	    System.out.println("Top " + n + " Person(s):");
	    for (int i = top; i >= 0 && n > 0; i--, n--) {
	        a[i].displayPerson();
	    }
	}
}