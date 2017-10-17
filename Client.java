
public class Client {
	public static void main(String[] args) {
		FindMedian f = new FindMedian();
		int size= 9000000;
		int[] array = new int[size];
		for(int i = 0; i<size; i++) {
			array[i]=(int)(Math.random()*size)+1;
		}
		try {
			int key = (size+1)/2;
			Long start = System.nanoTime();
			double result = f.quickSelect(array, key);
			Long end = System.nanoTime();
			System.out.println("input size: "+ size + ". result: "+result+"  running time: "+ (end-start)+".");
		}catch(Exception e){
			System.out.println(e.toString());
		}
	}
}
