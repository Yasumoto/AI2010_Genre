import java.util.HashMap;


public class matrix {
	
	HashMap<Integer, HashMap<Integer, Float>> matrix;
	
	public matrix() {
		
		matrix = new HashMap<Integer, HashMap<Integer, Float>>();
	}
	
	public void set(int one, int two, float key) {
		
		if (!matrix.containsKey(new Integer(one))) {
			matrix.put(new Integer(one), new HashMap<Integer, Float>());
		}
		
		matrix.get(new Integer(one)).put(new Integer(two), new Float(key));
		
	}
	
	public float get(int one, int two) { //returns float key 
		
		return matrix.get(new Integer(one)).get(new Integer(two)).floatValue();
	}
	
	public int getSize() {
		
		return matrix.size();
	}

}








































