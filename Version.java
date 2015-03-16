import java.util.*;
public class Version {
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