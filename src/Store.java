import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
public class Store {
    // A metódus most visszaad egy ArrayList<Employee> objektumot
    public static ArrayList<Employee> readFile() {
        ArrayList<Employee> empList = new ArrayList<>();
        try {
            tryReadFile(empList);  // Az empList-et átadjuk, hogy feltöltsük
        } catch (FileNotFoundException e) {
            System.err.println("Hiba! A file nem található!");
            System.err.println(e.getMessage());
        }
        return empList;  // Visszaadjuk a feltöltött listát
    }
    // A fájl beolvasása és az Employee objektumok hozzáadása a listához
    public static void tryReadFile(ArrayList<Employee> empList) throws FileNotFoundException {
        File file = new File("kontenerkft.txt");
        try (Scanner sc = new Scanner(file)) {
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] lineArray = line.split("#");
                Employee emp = new Employee();  // Létrehozunk egy új Employee objektumot
                System.out.println(line);
                // Beállítjuk az alkalmazott adatait
                emp.setNev(lineArray[0]);
                emp.setHely(lineArray[1]);
                emp.setUtca(lineArray[2]);
                // A születési dátum feldolgozása
                String[] szuletesArray = lineArray[3].split("-");
                int ev = Integer.parseInt(szuletesArray[0]);
                int ho = Integer.parseInt(szuletesArray[1]);
                int nap = Integer.parseInt(szuletesArray[2]);
                emp.setSzuletes(LocalDate.of(ev, ho, nap));
                emp.setSzuletes(LocalDate.parse(lineArray[3]));
                // A fizetés beállítása
                emp.setFizetes(Double.parseDouble(lineArray[4]));
                empList.add(emp);  // Hozzáadjuk az alkalmazottat a listához
            }
        }
    }
}