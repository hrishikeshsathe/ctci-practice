package cracking.the.code.chapter9;

public class Nine_Seven{
	enum Color{
		Black, Red, Green, Blue, White
	}
	
	public static boolean paint(Color[][] screen, int x, int y, Color newColor){
		if(screen[y][x] == newColor)
			return false;
		return fill(screen, x, y, screen[y][x], newColor);
	}
	
	public static boolean fill(Color[][] screen, int x, int y, Color oldColor, Color newColor){
		if(x<0 || x >= screen[0].length || y<0 || y >= screen[0].length){
			return false;
		}
		if(screen[y][x] == oldColor){
			screen[y][x] = newColor;
			fill(screen, x-1, y, oldColor, newColor);
			fill(screen, x+1, y, oldColor, newColor);
			fill(screen, x, y-1, oldColor, newColor);
			fill(screen, x, y+1, oldColor, newColor);
		}
		return true;
	}
	
}