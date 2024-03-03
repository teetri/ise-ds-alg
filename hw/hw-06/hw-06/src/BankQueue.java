
public class BankQueue { // must work for any implementation of DeQ
	DeQ[] counters;
	DeQ special;

	public BankQueue(DeQ[] counters, DeQ special) {
		super();
		this.counters = counters;
		this.special = special;
	}

	//Write this method
	public void distribute() throws Exception {
		
		// count all customers
		double p = this.special.size();
		for(DeQ counter: this.counters) {
			p += counter.size();
		}
		double lengthNeeded = Math.round(p / (this.counters.length + 1));
		System.out.println(lengthNeeded);
		
		//move customer(s)
		for(DeQ counter: this.counters) {
			if(special.size() == lengthNeeded) {
				break;
			}
			
			//rotate so that first to be move is first in queue
			for(int i = 0; i < lengthNeeded; i++) {
				counter.insertLast(counter.removeFirst());
			}
			//move the first of queue to last of special
			while(counter.size() > lengthNeeded && special.size() < lengthNeeded) {
				special.insertLast(counter.removeFirst());
			}
			//rotate queue back to original order
			for(int i = 0; i < counter.size() - lengthNeeded; i++) {
				counter.insertLast(counter.removeFirst());
			}
			
			System.out.print(counter.front());
			System.out.print(" - ");
			System.out.println(counter.back());
		}
		
		//additional case
		if(special.size() == 0) {
			special.insertLast((this.counters[counters.length - 1].removeLast()));
		}
	}
	
	

}
