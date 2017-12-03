package advent3;

import java.util.HashMap;

public class advent3part2 {

	private enum Direction {
		UP, DOWN, RIGHT, LEFT
	}

	private static class Location {
		int x;
		int y;

		public Location(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return (x + "," + y);
		}
	}

	private static int getValue(HashMap<String, Integer> grid, int x, int y) {
		int value = 0;
		Location location = new Location(x, y);
		if (grid.containsKey(location.toString())) {
			value = grid.get(location.toString());
		}
		System.out.println(value);
		return value;
	}

	public static void main(String[] args) {
		int input = 277678;
		int x = 0;
		int y = 0;
		int layer = 1;
		Boolean newLayer = true;
		Direction direction = Direction.RIGHT;
		HashMap<String, Integer> grid = new HashMap<>();
		grid.put(new Location(0, 0).toString(), 1);
		while (true) {
			for (int j = 0; j < layer; j += 1) {
				switch (direction) {
				case UP:
					y += 1;
					break;
				case DOWN:
					y -= 1;
					break;
				case RIGHT:
					x += 1;
					break;
				case LEFT:
					x -= 1;
					break;
				}

				int value = 0;

				value += getValue(grid, x, y + 1);
				value += getValue(grid, x, y - 1);
				value += getValue(grid, x + 1, y);
				value += getValue(grid, x + 1, y + 1);
				value += getValue(grid, x + 1, y - 1);
				value += getValue(grid, x - 1, y);
				value += getValue(grid, x - 1, y + 1);
				value += getValue(grid, x - 1, y - 1);

				if (value >= input) {
					System.out.println(value);
					System.exit(0);
				} else {
					System.out.println(x + " " + y + " " + value);
					System.out.println("--------");
					grid.put(new Location(x, y).toString(), value);
				}
			}
			switch (direction) {
			case UP:
				direction = Direction.LEFT;
				break;
			case DOWN:
				direction = Direction.RIGHT;
				break;
			case RIGHT:
				direction = Direction.UP;
				break;
			case LEFT:
				direction = Direction.DOWN;
				break;
			}
			newLayer = !newLayer;
			if (newLayer) {
				layer += 1;
			}
		}
	}

}
