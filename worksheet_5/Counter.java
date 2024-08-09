import java.util.HashMap;
import java.util.concurrent.locks.ReentrantLock;

public class Counter extends Thread{
	
	private String[] arr;
	private HashMap<String, Integer> map;
	private ReentrantLock lock;
	
	public Counter(String [] arr, HashMap<String, Integer> map,ReentrantLock lock) {
		this.arr = arr;
		this.map = map;
		this.lock = lock;
	}
	
	public void run() {
		for(String s1 : arr) {
			lock.lock();
			if(map.containsKey(s1)) {
				map.put(s1, map.get(s1) +1);
			} else {
				map.put(s1, 1);
			}
			lock.unlock();
		}
	}

	public static void main(String[] args) throws InterruptedException{
		String [] arr1 = new String[] {"a","b","c","c","d","a","a","c","b","b"};
		String [] arr2 = new String[] {"a","c","d","d","a","a","a","c","b","c","d","a","b"};
		String [] arr3 = new String[] {"c","d","a","b"};
		
		HashMap<String, Integer> map = new HashMap<>();
		ReentrantLock lock = new ReentrantLock();
		
		Counter c1 = new Counter(arr1, map, lock);
		Counter c2 = new Counter(arr2, map, lock);
		Counter c3 = new Counter(arr3, map, lock);
		
		c1.start();
		c2.start();
		c3.start();
		
		c1.join();
		c2.join();
		c3.join();
		
		for (String key : map.keySet()) {
			System.out.println(key + ":" + map.get(key));
				}
		}
}
