import org.junit.Test;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashSet;
import java.util.Scanner;

import static org.junit.Assert.*;

public class TestProgram extends Dictionary {
    @Test
    public void hyphenationTest() throws java.io.IOException {

        String a = "Donaudampfschiffskapitäns";
        String b = "Anwaltsbüro";
        String c = "Olivenöl";
        URLConnection connection = new URL("https://raw.githubusercontent.com/TYPO3-extensions/solr/master/Resources/Solr/typo3cores/conf/german/german-common-nouns.txt").openConnection();
        Scanner scannerEingabe = new Scanner(connection.getInputStream());
        HashSet<String> data = new HashSet<>();
        while (scannerEingabe.hasNextLine())
            data.add(scannerEingabe.nextLine());

        String[] array1 = new String[]{"donau", "dampf","schiffs", "kapitäns"};
        String[] array2 = new String[]{"anwalts","büro"};

        assertArrayEquals(array1,hyphenationapi(a, data));
        assertArrayEquals(array2,hyphenationapi(b, data));

    }
// CornerCase Test ist in der Main abgedeckt
    }

