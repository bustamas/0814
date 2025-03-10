import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.Scanner;
public class Store {
    public static void readFile() {
        try {
            tryReadFile();
        } catch (FileNotFoundException e) {
            System.err.println("Hiba! A file nem található!");
            System.err.println(e.getMessage());
        }
    }

    /**
     * @throws FileNotFoundException
     */
    public static void tryReadFile() throws FileNotFoundException { 
        File file = new File ("kontenerkft.txt");
        try(Scanner sc = new Scanner(file)){
            while (sc.hasNextLine()) {
            
                String line = sc.nextLine();
                String [] lineArray=line.split("#");
                Employee emp = new Employee();
                System.out.println(line);
                emp.setNev(lineArray[0]);
                emp.setHely(lineArray[1]);
                emp.setUtca(lineArray[2]);
                String[] szuletesArray=lineArray[3].split("-");
                int ev = Integer.parseInt(szuletesArray[0]);
                int ho = Integer.parseInt(szuletesArray[1]);
                int nap = Integer.parseInt(szuletesArray[2]);
                emp.setSzuletes(LocalDate.of(ev,ho,nap));
                emp.setFizetes(Double.parseDouble(lineArray[4]));

                emp.setSzuletes(LocalDate.parse(lineArray[3]));
            }
        }
    }
}
