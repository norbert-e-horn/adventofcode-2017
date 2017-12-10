package advent4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class advent4 {

	public static void main(String[] args) throws IOException {
		//Read Input
		ArrayList<String> lines = new  ArrayList<>();
		FileReader fr = new FileReader("input.txt");
		BufferedReader br = new BufferedReader(fr);
		String readLine = "";
		while( (readLine = br.readLine()) != null )
		{
			lines.add(readLine);
		}
		br.close();

		int sum = 0;
		int sum2 = 0;
		for (String string : lines)
		{
			String[] line = string.split(" ");
			HashSet<String> hashs = new HashSet<>();
			boolean unique = true;
			boolean anagram = true;
			if(line.length > 1)
			{
				for (String password : line) {
					if(hashs.contains(password))
					{
						unique = false;
					}
					else
					{
						hashs.add(password);
					}

				}
				if(unique)
				{
					sum++;
				}

				for (int i = 0; i < line.length - 1; i++) {
					for (int j = i + 1; j < line.length; j++)
					{
						char[] a = line[i].toCharArray();
						char[] b = line[j].toCharArray();
						Arrays.sort(a);
						Arrays.sort(b);
						if (Arrays.equals(a, b))
						{
							anagram = false;
						}
					}
				}
				if(anagram)
				{
					sum2++;
				}
			}
		}
		System.out.println("TASK1");
		System.out.println(sum);
		System.out.println("TASK2");
		System.out.println(sum2);
	}
}
