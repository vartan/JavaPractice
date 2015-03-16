import java.util.*;
public class HashTable<K,V> {
	private List <MyLinkedList<HashObject<K,V>>> table;
	private int size;
	private int length;
	public static void main(String[] args) {

		final int VALUES = Integer.parseInt(args[0]);
		final int HASH_SIZE = Integer.parseInt(args[1]);
		final int HASH_SIZE2 = Integer.parseInt(args[2]);
		System.out.format("Values: %d; Hash size: %d; Rehash size: %d\n\n", VALUES, HASH_SIZE, HASH_SIZE2);
		long startTime;

		HashTable<String,String> hash = new HashTable<>(HASH_SIZE);

		String[] keys = new String[VALUES];
		String[] values = new String[VALUES];
		for(int i=0;i<VALUES;i++) {
			keys[i]   = "key"+i;
			values[i] = "values"+i;
		}

		startTime = System.nanoTime();
		for(int i=0;i<VALUES;i++) {
			hash.put(keys[i], values[i]);
		}
		System.out.println("time to add "+VALUES+" keys: \t\t" + (System.nanoTime() - startTime)/1000000000.0+"s");
		startTime = System.nanoTime();
		for(int i=0;i<VALUES;i++) {
			hash.get(keys[i]);
		}
		//System.out.println("Length "+hash.getLength());

		System.out.println("time to get "+VALUES+" keys: \t\t" + (System.nanoTime() - startTime)/1000000000.0+"s");
		startTime = System.nanoTime();

		hash.rehash(HASH_SIZE2);

		System.out.println("time to rehash with size "+HASH_SIZE2+": \t\t" + (System.nanoTime() - startTime)/1000000000.0+"s");
		startTime = System.nanoTime();
		for(int i=0;i<VALUES;i++) {
			hash.get(keys[i]);
		}

		System.out.println("time to get "+VALUES+" keys: \t\t" + (System.nanoTime() - startTime)/1000000000.0+"s");

		System.out.println("Reading back middle value: \""+hash.get("key"+(VALUES/2))+"\"");
		//System.out.println("Length "+hash.getLength());
	}
	public HashTable(int _size) {
		table = new ArrayList<>(_size);
		size = _size;
		length = 0;
		for(int i=0;i<size;i++)
			table.add(null);
	}
	public HashTable() {
		this(100); 
	}
	public int getLength() {
		return length;
	}
	public void put(K key, V value) {
		LinkedListNode<HashObject<K,V>> node, myNode;
		MyLinkedList<HashObject<K,V>> bucket;
		if(key==null)
			throw new NullPointerException();

		int hash = Math.abs(key.hashCode())%size;
		bucket = table.get(hash);
		if(bucket==null ) {
			bucket = new MyLinkedList<>();
			table.set(hash, bucket);
		} 

		node = bucket.start;
		if(node==null) {
			bucket.add(new HashObject<>(key, value));
			length++; // bucket is empty

		} else {
			while(node !=null) { // make sure object is not in bucket
				if(node.obj !=null && node.obj.getKey().equals(key)) {
					node.obj.setValue(value);
					return;
				} else {
				}
				node = node.next;
			}
			// add to end of bucket
			length++;
			bucket.add(new HashObject<>(key, value));

		}

	}
	public boolean remove(K key) {
		LinkedListNode<HashObject<K,V>> node, previous;
		MyLinkedList<HashObject<K,V>> bucket;
		if(key==null)
			throw new NullPointerException();
		int hash = Math.abs(key.hashCode()) % size;
		bucket = table.get(hash); 
		if(bucket==null)return false;
		node = bucket.start;
		previous=null;

		while(node !=null && 
			node.obj!=null && node.obj.getKey()!=null &&
			!node.obj.getKey().equals(key)) {
			previous = node;
			node = node.next;
		}
		if(node==null) // not found
			return false;
		else if(previous==null) // first index
			bucket.start = node.next;
		else // middle/end
			previous.next = node.next;
		length--;
		return true;
		
	}
	public V get(K key) {
		MyLinkedList<HashObject<K,V>> bucket;
		LinkedListNode<HashObject<K,V>> node;
		int hash = Math.abs(key.hashCode())%size;
		bucket = table.get(hash);
		if(bucket==null) return null;
		node = bucket.start;
		while(node !=null && 
		  node.obj!=null && node.obj.getKey()!=null &&
		  !node.obj.getKey().equals(key)) {
			node = node.next;
		}

		if(node==null) return null;
		else		   return node.obj.getValue();
	}
	public void rehash(int _size) {
		List <MyLinkedList<HashObject<K,V>>> oldTable = table;
		LinkedListNode<HashObject<K,V>> node;
		length = 0;
		table = new ArrayList<>(_size);
		size = _size;
		for(int i=0;i<size;i++)
			table.add(null);
		for(MyLinkedList<HashObject<K,V>> oldList:oldTable) {
			if(oldList!=null && (node=oldList.start)!=null) {
				while(node!=null) {
					HashObject<K,V> hashObject = node.obj;
					if(hashObject !=null)
						this.put(hashObject.getKey(), hashObject.getValue());

					node = node.next;
				}
			}

		}
	}
}