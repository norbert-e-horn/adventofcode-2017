package advent7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class advent7 {

	private static HashMap<String,Node> tree;

	public static void main(String[] args) throws IOException {

		ArrayList<String> lines = readInput();
		tree = new HashMap<>();
		HashSet<String> roots = new HashSet<>();
		HashSet<String> siblingSet = new HashSet<>();

		for (String line : lines)
		{
			String[] split =  line.split("->");
			String[] siblings;
			int weight = Integer.valueOf(split[0].split(" ")[1].replace("(", "").replace(")", ""));
			String nodeName = split[0].split(" ")[0].trim();
			Node temp = new Node(nodeName, weight);
			if(!siblingSet.contains(nodeName))
			{
				roots.add(nodeName);
			}
			if(split.length > 1)
			{
				siblings = split[1].split(",");
				for (String sibling : siblings) {
					temp.setSibling(sibling.trim());
					siblingSet.add(sibling.trim());
					roots.remove(sibling.trim());
				}
			}
			tree.put(nodeName, temp);
		}
		System.out.println(roots.toArray()[0]);

		Node root = tree.get(roots.toArray()[0]);
		for (String sibling : root.getSiblings()) {

			Node siblingNode = tree.get(sibling);
			calcWeight(siblingNode);
		}
	}


	public static int calcWeight(Node node)
	{

		int weight = node.getWeight();
		HashMap<Integer,ArrayList<String>> weightCount =  new HashMap<>();
		for (String sibling : node.getSiblings()) {

			int siblingweight = calcWeight(tree.get(sibling));
			weight += siblingweight;

			if(weightCount.containsKey(siblingweight))
			{
				ArrayList<String> temp = weightCount.get(siblingweight);
				temp.add(sibling);
				weightCount.put(siblingweight, temp);
			}
			else
			{
				ArrayList<String> temp = new ArrayList<>();
				temp.add(sibling);
				weightCount.put(siblingweight, temp);
			}
		}
		if(weightCount.size() > 1)
		{
			Object[] weights = weightCount.keySet().toArray();
			int diff = Math.abs((Integer)weights[0]- (Integer)weights[1]);
			for (ArrayList<String> nodes : weightCount.values()) {
				if(nodes.size() == 1)
				{
					System.out.println(tree.get(nodes.get(0)).getWeight()-diff);
				}
			}
			System.exit(0);
		}
		return weight;
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

class Node {

	private String name;
	private int weight;
	private ArrayList<String> siblings = new ArrayList<>();

	public Node(String name, int weight) {
		this.setName(name);
		this.setWeight(weight);

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public ArrayList<String> getSiblings() {
		return siblings;
	}

	public void setSibling(String sibling) {
		siblings.add(sibling);
	}
}

