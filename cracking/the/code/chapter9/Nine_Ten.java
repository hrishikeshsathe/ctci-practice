package cracking.the.code.chapter9;

import java.util.ArrayList;
import java.util.HashMap;

public class Nine_Ten{
	public static int stackHeight(ArrayList<Box> boxes){
		if(boxes == null)
			return 0;
		int height = 0;
		for(Box box: boxes){
			height += box.height;
		}
		return height;
	}

	public static ArrayList<Box> createStack(Box[] boxes, Box bottom){
		int max_height = 0;
		ArrayList<Box> max_stack = null;
		for(int i = 0; i < boxes.length; i++){
			if(boxes[i].canBeAbove(bottom)){
				ArrayList<Box> new_stack = createStack(boxes, boxes[i]);
				int new_height = stackHeight(new_stack);
				if(new_height > max_height){
					max_height = new_height;
					max_stack = new_stack;
				}
			}
		}
		if(max_stack == null)
			max_stack = new ArrayList<Box>();
		if(bottom != null)
			max_stack.add(0,bottom);
		return max_stack;
	}
	
	@SuppressWarnings("unchecked")
	public static ArrayList<Box> createStackDP(Box[] boxes, Box bottom, HashMap<Box,ArrayList<Box>> cache){
		if(bottom != null && cache.containsKey(bottom))
			return (ArrayList<Box>) cache.get(bottom).clone();
		int max_height = 0;
		ArrayList<Box> max_stack = null;
		for(int i = 0; i < boxes.length; i++){
			if(boxes[i].canBeAbove(bottom)){
				ArrayList<Box> new_stack = createStackDP(boxes, boxes[i], cache);
				int new_height = stackHeight(new_stack);
				if(new_height > max_height){
					new_height = max_height;
					new_stack = max_stack;
				}
			}
		}
		if(max_stack == null)
			max_stack = new ArrayList<Box>();
		if(bottom != null)
			max_stack.add(0,bottom);
		cache.put(bottom,max_stack);
		return max_stack;
	}

	public static void main(String[] args) {
		Box[] boxes = { new Box(3, 4, 1), new Box(8, 6, 2), new Box(7, 8, 3)};
		ArrayList<Box> stack = createStack(boxes, null);
		//ArrayList<Box> stack = createStackR(boxes, null);
		for (int i = stack.size() - 1; i >= 0; i--) {
			Box b = stack.get(i);
			System.out.println(b.toString());
		}
	}
}

class Box{
	int height;
	int width;
	int depth;

	public Box(int h, int w, int d){
		height = h;
		width = w;
		depth = d;
	}

	public boolean canBeAbove(Box b){
		if(b == null)
			return true;
		if(height < b.height && width < b.width && depth < b.depth)
			return true;
		return false;
	}

	public boolean canBeBelow(Box b){
		if(height > b.height && width > b.width && depth > b.depth)
			return true;
		return false;
	}
	
	public String toString() {
		return "Box(" + width + "," + height + "," + depth + ")";
		}
}

