package advent11;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class advent11 {

	enum HexEnum {
		n(0, -1), ne(1, -1), se(1, 0), s(0, 1), sw(-1, 1), nw(-1, 0);
		int x, y;
		HexEnum(int x, int y) 
		{ 
			this.x = x;
			this.y = y; 
		}
	}


	private static int distance(int x, int y) {
		return ((Math.abs(x) + Math.abs(y) + Math.abs(x + y))/ 2);
	}


	public static void main(String[] args) throws IOException {

		String input = readInput();
		int x = 0;
		int y = 0;
		int max = 0;
		int position = 0;

		for (String each : input.split(",")) {
			HexEnum current = HexEnum.valueOf(each);
			x += current.x;
			y += current.y;
			position = distance(x, y);
			if (position > max) max = position;

		}
		System.out.println(position);
		System.out.println(max);
	}

	public static String readInput() throws IOException
	{
		FileReader fr = new FileReader("input.txt");
		BufferedReader br = new BufferedReader(fr);
		String readLine = "";
		readLine = br.readLine();

		br.close();
		return readLine;
	}
}
