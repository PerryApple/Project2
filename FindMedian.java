
public class FindMedian {
	private int[] array;
	private int length;
	
//	public double getMedian(int[] array) throws Exception {
//		this.array = array;
//		this.length = array.length;
//		if(length == 0) {
//			throw new Exception("Error: Array is Empty!");
//		}
//		int k1 = (length+1)/2;
//		int k2 = (length+2)/2;
//		int m1 =findK(0,length-1,k1);
//		int m2 = findK(0,length-1,k2);
//		return (m1+m2)/2.0;
//	}
	
	public int quickSelect(int[] array, int key) throws Exception{
		this.array = array;
		this.length = array.length;
		if(length == 0) {
			throw new Exception("Error: Array is Empty!");
		}
		return findK(0,length-1,key);
	}
	
	private int findK(int start, int end, int key) {

			int position = partition(start, end);
			if(position == key) {
				return array[position-1];
			}
			else if(position<key) {
				return findK(position, end, key);
			}else {
				return findK(start, position-2, key);
			}
	}
	
	private int partition(int start, int end) {

		int random = (int)(Math.random()*(end-start+1));
		int pivot = array[start+random];
		exchange(start+random,end);

		int i = start;
		int j = end-1;
		while(i<=j) {
			while(i<length&&array[i]<pivot) {
				i++;
			}
			while(j>-1&&array[j]>pivot) {
				j--;
			}
			if(i<=j) {
				exchange(i,j);
				i++;
				j--;
			}
		}
		exchange(end,i);
		
		if(end-start<2) {
			return i+1;
		}else {
			int decide = length/4;
			if(decide>i+1||(length-decide)<i) {
				return partition(start, end);
			}else {
				return i+1;
			}
		}
	}
	
	private void exchange(int i, int j) {
		int temp = array[i];
		array[i]=array[j];
		array[j]=temp;
	}
}
