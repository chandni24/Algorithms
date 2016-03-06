
public class SerializeArray {

	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 5, 8, 12, 13, 14, 15};
		int min = arr[0], max = Integer.MIN_VALUE;
		String s = "[";
		int f=0;

		for(int i=0; i<arr.length-1; i++) {
			if(arr[i] == arr[i+1] - 1) {
				max = arr[i+1];
			}
			else {
				//printContent();
				s = printContent(min, max, s);
				min = arr[i+1];
				max = Integer.MIN_VALUE;
			}
		}//for
		//printContent();
		s = printContent(min, max, s);
		s = s+"]";
		System.out.println(s);
	}

	//static public void printContent() {
	static public String printContent(int min, int max, String s) {
		int f;
		if(s.length() == 1)
			f = 0;
		else
			f = 1;
		if(max != Integer.MIN_VALUE) {
			if(f == 0)
				s = s+min+"-"+max;
			else {
				s = s+","+min+"-"+max;
			}
		}
		else {
			if(f == 0)
				s = s+min;
			else {
				s = s+","+min;
			}
		}
		f = 1;
		return s;
	}
}

