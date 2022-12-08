public class Test {
    public static void main(String[] args) {


        String str = "selam";


        StringBuilder str3 = new StringBuilder("selam");
        for (int j = 0;j<str.length();j++){

            for (int k = 1; k<str.length();k++){

                char ch[] = str.toCharArray();
                char temp = ch[j];
                ch[j] = ch[k];
                ch[k] = temp;
                System.out.println(ch);
            }

        }
    }
}

