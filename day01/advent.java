package advent1;

public class advent1 {

	public static void main(String[] args)
	{
//		Input conversion
		int[] digits = new int[args[0].length()];
		int i = 0;
		for(char digit: args[0].toCharArray())
		{
			digits[i] = Character.getNumericValue(digit);
			i++;
		}
//		Task1
		int sum = 0;
		System.out.println(digits.length);
		for(int j = 0; j < digits.length-1; j++)
		{
			if(digits[j] == digits[j+1])
			{
				sum += digits[j];
			}
		}
		if(digits[digits.length-1] == digits[0])
		{
			sum += digits[0];
		}
		System.out.println(sum);

//		Task2
		int sum2 = 0;
		for(int j = 0; j < digits.length-1; j++)
		{
			int position = (j + digits.length/2) % digits.length;
			if(digits[j] == digits[position])
			{
				sum2 += digits[j];
			}
		}

		System.out.println(sum2);
	}
}
