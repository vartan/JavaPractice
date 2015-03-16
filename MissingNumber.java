public class MissingNumber {
	public static void main(String[] args) {
		int MAX = 1000;
		boolean allCorrect = true;
		for(int i=0;i<=MAX;i++) {
			for(int j=0;j<=i;j++) {
				boolean correct = test(i,j);
				allCorrect &= correct;
				//if(!correct)
				//	System.out.format("%3d[%3d]: %b\n", i, j, correct);
			}
		}
		System.out.format("All correct: %b", allCorrect);

	}
	public static boolean test(int length, int missing) {
		int[] arr = generateListWithMissing(length, missing);
		int found = findMissingNumber(arr);
		//System.out.println("--findMissingNumber("+missing+") =  "+found);
		return found == missing;
	}
	public static int[] generateListWithMissing(int max, int missing) {
		int[] arr = new int[max];
		for(int i = max-1;i >= 0;i--) {
			if(i >= missing)
				arr[i]=i+1;
			else
				arr[i]=i;
		}
		return arr;
	}
	public static int count = 0;
	public static int findMissingNumber(int[] arr) {
		count = 0;
		int result = findMissingNumber(arr, 0, arr.length-1);
		System.out.println(count);
		return result;
	}
	public static int findMissingNumber(int[] arr, int start, int end) {
		count++;
		int expected = 0;
		int len=end-start;
		if(len<=1) { // if we are at two size
			//System.out.println("Number is between "+start+" - "+end);
			for(int i=start; i<=end;i++) {
				//System.out.println("checking "+i);
				if((i&1)!=getBit(arr,i,0))
					return i;
			}
			if(arr.length-1==end)
				return end+1;
		} else {
			int mid = start+len/2;
			//System.out.println(start+" : "+mid+" : "+end);
			if((mid & (1<<0)) != getBit(arr,mid,0)) // if the middle is past the missing num
				return findMissingNumber(arr, start, mid);
			else 
				return findMissingNumber(arr, mid+1, end);
		}
		return -1;
	}
	public static int getBit(int[] arr, int index, int num) {
		return arr[index]>>num & 1;
	}
}