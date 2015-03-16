import java.util.*;
/**
 * Canonical path
 * Simplifies a sample file path
 * "a/b2/c2/../c3/../../b/c1/../c" to "a/b/c"
 */
public class CanonicalPath {
	public static void main(String[] args) {
		System.out.println(getCanonical(args[0]));

	}
	public static String getCanonical(String path) {
		LinkedList<String> list = new LinkedList<String>();
		StringBuilder sb = new StringBuilder();
		String[] parts = path.split("\\/");
		for(int i = 0; i < parts.length; i++) {
			String part = parts[i];
			if(part.equals("..") && list.size()>0 && !list.peek().equals("..")) {
				list.pop();
			} else if(!part.equals(".")) {
				list.push(parts[i]);
			}
		}
		if(list.size() == 0)
			sb.append(".");
		else
			sb.append(list.removeLast());
		while(list.size()>0) {
			sb.append("/");
			String item = list.removeLast();
			sb.append(item);
		}
		return sb.toString();
	}
}