package advent6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class advent6 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		HashMap<ArrayList<Integer>, Integer> nums = new HashMap<>();
		ArrayList<Integer> banks = readInput();
		nums.put(banks, 0);
		int steps = 0;
		while(true)
		{
			steps++;
			int max = Integer.MIN_VALUE;
			int max_pos = -1;
			for(int i = 0;i < banks.size();i++)
			{
				if(banks.get(i) > max)
				{
					max = banks.get(i);
					max_pos = i;
				}
			}
			banks.set(max_pos, 0);
			int max_loop = max;
			for(int j = 0;j<max_loop;j++)
			{
				int pos = (max_pos+1+j) % banks.size();
				banks.set(pos, banks.get(pos)+1);
			}
			if(nums.containsKey(banks))
			{
				System.out.println("Task2: " +  (steps - nums.get(banks)));
				break;
			}
			nums.put(banks, steps);
		}
		System.out.println("Task1: " + steps);
	}

	public static ArrayList<Integer> readInput() throws NumberFormatException, IOException
	{
		ArrayList<Integer> banks = new  ArrayList<>();
		FileReader fr = new FileReader("input.txt");
		BufferedReader br = new BufferedReader(fr);
		String readLine = "";
		while( (readLine = br.readLine()) != null )
		{
			String[] bankStrings = readLine.split("\t");
			for (String string : bankStrings) {
				banks.add(Integer.valueOf(string));

			}

		}
		br.close();
		return banks;
	}
}
