package advent3;

public class advent3 {
	private enum Direction {
	    UP, DOWN, RIGHT, LEFT
	}

	public static void main(String[] args) {
	    int input = 277678;
	    int x = 0;
	    int y = 0;
	    int layer = 1;
	    Boolean newLayer = true;
	    Direction direction = Direction.RIGHT;
	    for (int i = 1;;) {
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

	            i += 1;
	            if (i == input) {
	            	System.out.println(x);
	            	System.out.println(y);
	                System.out.println(Math.abs(x) + Math.abs(y));
	                System.exit(0);
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
