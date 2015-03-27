package followPath;

import java.util.LinkedList;
import java.util.Queue;

import robotSearches.IQueueContainer;
import robotSearches.Node;

/**
 * Things impelements a queue that shall work on lejos pc simultions used in testing.
 * 
 * @author Thomas Claarke
 *
 * @param <A>
 */
public class QueueContainer<A> implements IQueueContainer<A>{

	public Queue<Node<A>> queue;
	
	/**
	 * Creates a queue.
	 */
	public QueueContainer() {
		queue = new LinkedList<Node<A>>();
	}
	
	public void add(Node<A> x) {
		queue.add(x);
	}
	
	public Node<A> poll() {
		return queue.poll();
	}
	
	public boolean isEmpty() {
		return queue.isEmpty();
	}
}
