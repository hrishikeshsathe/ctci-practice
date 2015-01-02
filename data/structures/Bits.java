package data.structures;

public class Bits{
	public static boolean getBit(int num, int i){
		return ((num & (1 << i)) != 0);
	}
	
	public static int setBit(int num, int i){
		return num | (1 << i);
	}
	
	public static int clearBit(int num, int i){
		return num & ~(1 << i);
	}
	
	public static int updateBit(int num, int i, int v){
		num = clearBit(num, i);
		return num | (v << i);
	}
}