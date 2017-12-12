package advent12;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class advent12  {


	public static void main(String[] args) throws IOException
	{
		ArrayList<String> lines = readInput();
		HashMap<Integer, ArrayList<Integer>> connections = new HashMap<>();
		HashSet<Integer> unknown = new HashSet<>();

		for(int i = 0; i < lines.size(); i++)
		{
			unknown.add(i);
		}

		for (String line : lines)
		{
			String[] split = line.split("<->");
			String source = split[0].trim();
			String[] targets = split[1].trim().split(", ");
			ArrayList<Integer> temp = new ArrayList<>();
			for (String target : targets)
			{
				temp.add(Integer.valueOf(target));
			}
			connections.put(Integer.valueOf(source), temp);
		}
		int groups = 0;
		while(unknown.size()>0)
		{
			HashSet<Integer> group = new HashSet<>();
			int source = (Integer) (unknown.toArray()[0]);
			System.out.print("Source: " + source);
			group.add(source);
			walkingOnSunshine(source, group, connections, unknown);
			System.out.println(" Size:" + group.size());
			groups++;
		}
		System.out.println("Total groups: " + groups);
	}
	public static ArrayList<String> readInput() throws IOException
	{
		ArrayList<String> lines = new  ArrayList<>();
		FileReader fr = new FileReader("input.txt");
		BufferedReader br = new BufferedReader(fr);
		String readLine = "";
		while( (readLine = br.readLine()) != null )
		{
			lines.add(readLine);
		}
		br.close();
		return lines;
	}
	private static void walkingOnSunshine(int source, HashSet<Integer> group, HashMap<Integer, ArrayList<Integer>> connections, HashSet<Integer> unknown){
		for (int neighbor : connections.get(source)) {
			if(group.contains(neighbor))
			{
				continue;
			}
			group.add(neighbor);
			walkingOnSunshine(neighbor, group, connections, unknown);
		}
		unknown.remove(source);
	}
}
