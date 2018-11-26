import java.net.URL;
import java.net.URLConnection;
import java.util.*;

public class Dictionary {

    public static String [] hyphenationapi(String text, Set<String> dictionary) {
        text = text.toLowerCase();
        int end = text.length();
        List<String> result = new ArrayList<>();

            for (int j = 0; j <= 5; j++) {
                for (int i = 0; i <= end; i++) {
                    String word = text.substring(i, end);
                    if (dictionary.contains(word)) {
                        end = i;
                        result.add(word);
                    }
                }
            }
            if (result.size() == 0) {
                System.out.println("Ihr Wort konnte nicht gefunden werden");
                System.out.println("Hängen Sie bitte ein 's' am Ende des Wortes an");
            }
            Collections.reverse(result);
            return result.toArray(new String[result.size()]);
        }



    public static void cornercase(String[] array){
        int start = 0;
        for(int j = 0;j<array.length-1;j++) {
            int end = array[j].length();
            if (array[j].charAt(array[j].length()-1) == 's'||array[j].charAt(array[j].length()-1) == 'n') { //An diieser Stelle kann man alle CornerCases abfangen
                String result = array[j].substring(start, end-1);
                System.out.println(result);
            }
           else System.out.println(array[j]);
        }
        System.out.println(array[array.length-1]);
    }


    public static void main(String[] args) throws java.io.IOException {

        System.out.println("Bitte geben sie einen String ein");
        Scanner reader = new Scanner(System.in);
        String s = reader.next();
        URLConnection connection = new URL("https://raw.githubusercontent.com/TYPO3-extensions/solr/master/Resources/Solr/typo3cores/conf/german/german-common-nouns.txt").openConnection();
        Scanner scannerEingabe = new Scanner(connection.getInputStream());
        HashSet<String> data = new HashSet<>();
        while (scannerEingabe.hasNextLine())
            data.add(scannerEingabe.nextLine());

        String[] arr = new String[5];
        arr = hyphenationapi(s, data);
        cornercase(arr);

    }

}

