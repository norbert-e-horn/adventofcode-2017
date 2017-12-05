package advent5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class advent5 {

	public static void main(String[] args) throws IOException {
		//TASK1
		ArrayList<Integer> jumps = readInput();
		int position = 0;
		int steps = 0;

		while(position < jumps.size())
		{
			int currentJump = jumps.get(position);
			jumps.set(position, currentJump+1);

			position += currentJump;
			steps++;
		}
		System.out.println(steps);
		//TASK2
		jumps = readInput();
		position = 0;
		steps = 0;

		while(position < jumps.size())
		{
			int currentJump = jumps.get(position);

			if(currentJump > 2)
			{
				jumps.set(position, currentJump-1);
			}
			else
			{
				jumps.set(position, currentJump+1);
			}
			position += currentJump;
			steps++;
		}
		System.out.println(steps);
	}

	/**
	 * Reads the input and converts it to an ArrayList of Integers.
	 * @return Input file as ArrayList<Integer>
	 * @throws NumberFormatException
	 * @throws IOException
	 */
	public static ArrayList<Integer> readInput() throws NumberFormatException, IOException
	{
		ArrayList<Integer> jumps = new  ArrayList<>();
		FileReader fr = new FileReader("input.txt");
		BufferedReader br = new BufferedReader(fr);
		String readLine = "";
		while( (readLine = br.readLine()) != null )
		{
			jumps.add(Integer.valueOf(readLine));
		}
		br.close();
		return jumps;
	}
}
