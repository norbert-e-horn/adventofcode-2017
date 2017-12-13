package advent13;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

public class advent13 {

	public static void main(String[] args) throws IOException {
		ArrayList<String> input = readInput();
		System.out.println(input.size());
		HashMap<Integer, Integer> firewall = new HashMap<>();


		for (String line : input) {
			String[] string = line.split(": ");
			firewall.put(Integer.valueOf(string[0]), Integer.valueOf(string[1]));
		}
		System.out.println(firewall.size());

		int severity = 0;
		for (Entry<Integer, Integer> layer : firewall.entrySet()) {
			if(layer.getKey() % ((layer.getValue()-1)*2) == 0)
			{
				severity += layer.getKey() * layer.getValue();
			}

		}


		System.out.println(severity);

		int delay = 1;
		 while (true) {

	            boolean caught = false;

	            for (Entry<Integer, Integer> layer : firewall.entrySet()) {
	                if ((layer.getKey() + delay) % ((layer.getValue() - 1) * 2) == 0) {
	                    caught = true;
	                    break;
	                }
	            }
	            if (!caught) break;
	            delay+= 1;

	}
		 System.out.println(delay);
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
