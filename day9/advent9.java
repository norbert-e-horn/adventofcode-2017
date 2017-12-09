package advent9;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class advent9 {

	enum State {
		OPEN, CLOSE, GARBAGE, IGNORE, CLEAN;
		Map<Character, State> assignments = new HashMap<>();
		private void addOperation(char c, State accept) {
			assignments.put(c, accept);
		}
		public State getOperation(char c) {
			if(!assignments.containsKey(c))
			{
				return this;
			}
			return assignments.get(c);
		}
	}

	public static void main(String[] args) throws IOException {

		State.CLEAN.addOperation('{', State.OPEN);
		State.CLEAN.addOperation('}', State.CLOSE);
		State.CLEAN.addOperation('<', State.GARBAGE);

		State.OPEN.addOperation('}', State.CLOSE);
		State.OPEN.addOperation('<', State.GARBAGE);
		State.OPEN.addOperation(',', State.CLEAN);

		State.CLOSE.addOperation('{', State.OPEN);
		State.CLOSE.addOperation('<', State.GARBAGE);
		State.CLOSE.addOperation(',', State.CLEAN);

		State.GARBAGE.addOperation('!', State.IGNORE);
		State.GARBAGE.addOperation('>', State.CLEAN);
		State.IGNORE.addOperation('!', State.GARBAGE);

		State current = State.CLEAN;
		String input = readInput();

		int level = 0;
		int garbageCount = 0;
		int score = 0;

		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			if (current == State.IGNORE)
			{
				c = '!';
			}
			State next = current.getOperation(c);
			switch (next) {
			case OPEN:
				level++;
				break;
			case CLOSE:
				score += level--;
				break;
			case GARBAGE:
				if (current == State.GARBAGE) garbageCount++;
			}
			current = next;
		}
		System.out.println("TASK1: " + score);
		System.out.println("TASK2: " + garbageCount);
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
