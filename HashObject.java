public class HashObject<K,V>{
	private K key;
	private V value;
	public HashObject(K _key, V _value) {
		key = _key;
		value = _value;
	}
	public K getKey() {
		return key;
	}
	public V getValue() {
		return value;
	}
	public void setValue(V _value) {
		value = _value;
	}
	public String toString() {
		String keyValue = key==null?"null":key.toString();
		String valueValue = value==null?"null":value.toString();
		return "<"+keyValue+","+valueValue+">";
	}
}