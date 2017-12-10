package advent2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class advent2 {

	public static void main(String[] args) throws IOException {
		//Read input
		ArrayList<String> lines = new ArrayList<>();
		FileReader fr = new FileReader("input.txt");
		BufferedReader br = new BufferedReader(fr);
		String readLine = "";
		while( (readLine = br.readLine()) != null )
		{
			lines.add(readLine);
		}

		br.close();
		
		//TASK 1
		int sum = 0;
		for (String line : lines) {
			String[] linearray = line.split("\t");
			int min = Integer.MAX_VALUE;
			int max = Integer.MIN_VALUE;
			for (String element : linearray) {
				int temp = Integer.valueOf(element);
				if(min > temp)
				{
					min = temp;
				}
				if(max < temp)
				{
					max = temp;
				}
			}
			sum+= max-min;
		}
		System.out.println(sum);
		//TASK 2
		int sum2 = 0;
		for (String line : lines) {

			String[] linearray = line.split("\t");
			for(int i = 0; i < linearray.length; i++)
			{
				int pos1 = Integer.valueOf(linearray[i]);
				for(int j = i+1; j < linearray.length; j++)
				{
					int pos2 = Integer.valueOf(linearray[j]);
					if(pos1 % pos2 == 0)
					{
						sum2 += pos1/pos2;
					}
					if(pos2 % pos1 == 0)
					{
						sum2 += pos2/pos1;
					}
				}
			}
		}
		System.out.println(sum2);
	}
}
