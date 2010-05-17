package com.bjoli.genre;
import java.util.HashMap;


public class Matrix {
	
	HashMap<Integer, HashMap<Integer, Float>> matrix;
	
	public Matrix() {
		
		matrix = new HashMap<Integer, HashMap<Integer, Float>>();
	}
	
	public void set(int one, int two, float key) {
		
		if (!matrix.containsKey(new Integer(one))) {
			matrix.put(new Integer(one), new HashMap<Integer, Float>());
		}
		
		matrix.get(new Integer(one)).put(new Integer(two), new Float(key));
		
	}
	
	public float get(int one, int two) { //returns float key 
		
		if (matrix.get(new Integer(one)) != null && matrix.get(new Integer(one)).get(new Integer(two)) != null)
		{
			return matrix.get(new Integer(one)).get(new Integer(two)).floatValue();
		}
		return 0;
	}
	
	public int getSize() {
		
		return matrix.size();
	}

	public void print()
	{
		for (int i = 0; i < matrix.keySet().size(); ++i)
		{
			for (int j = 0; j < matrix.keySet().size(); ++j)
			{
				if (get(i, j) != 0)
					System.out.print(get(i, j));
			}
			System.out.println();
		}
	}
}
