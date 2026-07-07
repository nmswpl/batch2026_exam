package in.co.nmsworks.exam;

public class CompressString {
    public static void main(String[] args) {
        CompressString compressString=new CompressString();
        compressString.stringCompress("aaabbca");
    }

    private void stringCompress(String str) {
        int count=0;
        String s="";
        for(int i=0;i<str.length()-1;i++)
        {
            for(int j=i+1;j<str.length()-1;j++)
            {
                if(str.charAt(i)==str.charAt(j))
                {
                    count++;

                }
                else {
                    s=count+""+str.charAt(i);
                    count=0;
                    break;
                }
                System.out.print(s);

            }

        }


    }
}
