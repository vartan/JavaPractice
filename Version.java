import java.util.*;
/**
 * Compare two version strings, such as "1.0.3" to "1.0.4". 
 * Returns -1 if the first argument is greater, or 1 if the second argument
 * is greater
 */
public class Version {
	/**
	 * Compare two version strings, such as "1.0.3" to "1.0.4". 
	 * Returns -1 if the first argument is greater, or 1 if the second argument
	 * is greater
	 *
	 * @param  version1 First version to compare
	 * @param  version2 Second version to compare
	 * @return 1 if the first argument is greater, or 1 if the second argument
	 *         is greater
	 */
	public static int which(String version1, String version2) {
		String[] versionParts1 = version1.split("\\.");
		String[] versionParts2 = version2.split("\\.");
		int maxLength = Math.max(versionParts1.length, versionParts2.length);
		int compare = 0;
		for(int i=0; i < maxLength && compare==0; i++) {
			// version 2 is an extended version of version1
			if(versionParts1.length==i) {
				compare=1; 
			// version 1 is an extended version of version2
			} else if(versionParts2.length==i) { 
				compare=-1; 
			} else {
				compare = versionParts2[i].compareTo(versionParts1[i]);
			}

		}
		return Integer.signum(compare); 
	}
	public static void main(String[] args) {
		System.out.println(which(args[0], args[1]));
	}
}