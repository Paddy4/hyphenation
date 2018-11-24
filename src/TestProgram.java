import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;

import static org.junit.Assert.*;

public class TestProgram extends Dictionary {
    @Test
    public void hyphenationTest() throws FileNotFoundException {

       String a = "Donaudampfschiffskapitän";
        String b = "Anwaltsbüro";
        String c = "Olivenöl";
        Scanner scannerEingabe = new Scanner(new File("C:\\Users\\Patrick\\Desktop\\Woerterbuch\\Woerterbuch1.txt"));
        HashSet<String> data = new HashSet<>();
        while (scannerEingabe.hasNextLine())
            data.add(scannerEingabe.nextLine());

        String[] array1 = new String[]{"donau", "dampfschiffs", "kapitän"};
        String[] array2 = new String[]{"anwalts","büro"};
        String[] array3 = new String[]{"oliven","öl"};
        assertEquals(array1,hyphenationapi(a, data));
        assertEquals(array2,hyphenationapi(b, data));
        assertEquals(array3,hyphenationapi(c, data));
    }
// CornerCase Test ist in der Main abgedeckt
    }

