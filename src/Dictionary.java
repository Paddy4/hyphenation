import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Dictionary {

    public static String [] hyphenationapi(String text, Set<String> dictionary) {
        text =text.toLowerCase();
        int start = 0;
        int end = text.length();
        List<String> result = new ArrayList<>();

        while (start < end)
        {
            for(int i=0;i<=end;i++){
                String word = text.substring(i,end);
                if(dictionary.contains(word)){
                    end = i;
                    result.add(word);
                }
            }
        }
        Collections.reverse(result);
      return result.toArray(new String[result.size()]);

    }
    public static void cornercase(String[] array){
        int start = 0;
        for(int j = 0;j<array.length-1;j++) {
            int end = array[j].length();
            if (array[j].charAt(array[j].length()-1) == 's'||array[j].charAt(array[j].length()-1) == 'n') {
                String result = array[j].substring(start, end-1);
                System.out.println(result);
            }
           else System.out.println(array[j]);
        }
        System.out.println(array[array.length-1]);
    }


    public static void main(String[] args) throws FileNotFoundException {

        System.out.println("Bitte geben sie einen String ein");
        Scanner reader = new Scanner(System.in);
        String s = reader.next();

        Scanner scannerEingabe = new Scanner(new File("C:\\Users\\Patrick\\Desktop\\Woerterbuch\\Woerterbuch1.txt"));
        HashSet<String> data = new HashSet<>();
        while (scannerEingabe.hasNextLine())
            data.add(scannerEingabe.nextLine());

        String[] arr = new String[5];
        arr = hyphenationapi(s, data);
        cornercase(arr);

    }

}

