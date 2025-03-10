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
            System.err.println("Hiba! A fájl nem található!");
            System.err.println(e.getMessage());
        }
        return empList;  // Visszaadjuk a feltöltött listát
    }
        // A fájl beolvasása és az Employee objektumok hozzáadása a listához
        public static void tryReadFile(ArrayList<Employee> empList) throws FileNotFoundException {
            File file = new File("kontenerkft.txt");
            // Fájl beolvasása UTF-8 kódolással
        try (Scanner sc = new Scanner(file, "utf8")) {
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] lineArray = line.split("#");
                Employee emp = new Employee();  // Létrehozunk egy új Employee objektumot
                // Alkalmazott adatainak beállítása
                emp.setNev(lineArray[0]);
                emp.setHely(lineArray[1]);
                emp.setUtca(lineArray[2]);
                // Születési dátum feldolgozása (kétjegyű hónap és nap)
                String[] szuletesArray = lineArray[3].split("-");
                String ev = szuletesArray[0];
                String ho = String.format("%02d", Integer.parseInt(szuletesArray[1]));  // Kétjegyű hónap
                String nap = String.format("%02d", Integer.parseInt(szuletesArray[2]));  // Kétjegyű nap
                String szuletesDateStr = ev + "-" + ho + "-" + nap;
                try {
                    emp.setSzuletes(LocalDate.parse(szuletesDateStr));  // A dátum beállítása
                } catch (Exception e) {
                    System.err.println("Hiba a dátum formátumban: " + szuletesDateStr);
                    continue;  // Hiba esetén ugrunk a következő sorra
                }
                // Fizetés beállítása
                emp.setFizetes(Double.parseDouble(lineArray[4]));
                // Hozzáadjuk az alkalmazottat a listához
                empList.add(emp);
            }
        }
    }
}