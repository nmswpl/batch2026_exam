package in.co.nmsworks.exam.question2;

public class StringCompression {

    public static void main(String[] args) {

        StringCompression compression = new StringCompression();

        String input = "aaaddgjskhjjdydstdufsds";
        System.out.println("Compresses string is : "+compression.compressString(input));
    }

    private String compressString (String input)
    {
        char[] array = input.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < array.length; i++)
        {
            int count = 0;

            for (int j = i; j < array.length; j++)
            {
                if (array[i] == array[j])
                {
                    count++;
                }
                else
                {
                    break;
                }
            }
            String counter = count+"";
            String str = counter+array[i];
            sb.append(str);
            i += count-1;
        }
        String newString = sb+"";
        return newString;
    }
}
