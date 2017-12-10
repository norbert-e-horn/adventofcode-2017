package advent8;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class advent8 {

	private static HashMap<String, Integer> registers;
	static int max = Integer.MIN_VALUE;
	public static void main(String[] args) throws IOException
	{
		ArrayList<String> input = readInput();

		registers = new HashMap<>();

		for (String line : input) {
			String[] split = line.split("if");
			String[] condition = split[1].trim().split(" ");
			String[] statement = split[0].trim().split(" ");
			String name = condition[0];
			int value = Integer.valueOf(condition[2]);
			int name_value = 0;
			if(registers.containsKey(name))
			{
				name_value = registers.get(name);
			}
			switch(condition[1])
			{
			case "==":
				if(name_value == value)
				{
					action(statement);
				}
				break;
			case ">":
				if(name_value > value)
				{
					action(statement);
				}
				break;
			case "<":
				if(name_value < value)
				{
					action(statement);
				}
				break;
			case "<=":
				if(name_value <= value)
				{
					action(statement);
				}
				break;
			case ">=":
				if(name_value >= value)
				{
					action(statement);
				}
				break;
			case "!=":
				if(name_value != value)
				{
					action(statement);
				}
				break;
			}
		}
		System.out.println("Task 2: " + max );
		max = Integer.MIN_VALUE;
		Object[] values = registers.values().toArray();
		for (Object object : values) {
			if(max < (Integer) object)
			{
				max =(Integer) object;
			}
		}
		System.out.println("Task 1: " + max);

	}


	public static void action(String[] statement)
	{
		if(statement[1].equals("inc"))
		{
			if(registers.containsKey(statement[0]))
			{
				registers.put(statement[0], registers.get(statement[0])+Integer.valueOf(statement[2]));
			}
			else
			{
				registers.put(statement[0], 0 + Integer.valueOf(statement[2]));
			}
		}
		else
		{
			if(registers.containsKey(statement[0]))
			{
				registers.put(statement[0], registers.get(statement[0])-Integer.valueOf(statement[2]));
			}
			else
			{
				registers.put(statement[0],0 - Integer.valueOf(statement[2]));
			}
		}
		if(registers.get(statement[0]) > max)
		{
			max = registers.get(statement[0]);
		}
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
}
