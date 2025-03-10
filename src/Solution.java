import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;

public class Solution {
    public static void startSolution() {
        // A Store.readFile metódussal lekérjük az alkalmazottak listáját
        ArrayList<Employee> empList = Store.readFile();

        // Ellenőrizzük, hogy van-e legalább egy alkalmazott a listában, hogy elkerüljük az index out of bounds hibát
        if (!empList.isEmpty()) {
            System.out.println(empList.get(0).getNev());  // Kiírjuk az első alkalmazott nevét
        } else {
            System.out.println("Nincs alkalmazott az adatbázisban.");
        }
        try {
            tryTask01(empList);  // Meghívjuk a fájl írásához szükséges metódust
            calcAverageSalary(empList); // Kiszámoljuk és kiírjuk az átlagfizetést
        } catch (IOException e) {
            System.err.println("Hiba a fájl írásakor: " + e.getMessage());
        }
    }
    // A fájlba írás feladat 1 (UTF-8 kódolással)
    public static void tryTask01(ArrayList<Employee> empList) throws IOException {
        try (FileWriter writer = new FileWriter("hatszol.txt", Charset.forName("utf8"))) {
            for (Employee emp : empList) {
                if (emp.getHely().equals("Hatvan") || emp.getHely().equals("Szolnok")) {
                    writer.write(emp.getNev()+"\n");
                }
            }
        }
    }
    // Átlagfizetés kiszámítása a Hatvan és Szolnok helyeken dolgozó alkalmazottak számára
    public static void calcAverageSalary(ArrayList<Employee> empList) {
        double totalSalary = 0;
        int count = 0;
        // Végigiterálunk az alkalmazottakon és összeadjuk azok fizetését, akik Hatvanban vagy Szolnokon dolgoznak
        for (Employee emp : empList) {
            if (emp.getHely().equals("Hatvan") || emp.getHely().equals("Szolnok")) {
                totalSalary += emp.getFizetes();
                count++;
            }
        }
        // Ha találtunk ilyen alkalmazottat, akkor kiszámoljuk az átlagot, különben kiírjuk, hogy nincs adat
        if (count > 0) {
            double averageSalary = totalSalary / count;
            System.out.println("A Hatvan és Szolnok helyeken dolgozó alkalmazottak átlagfizetése: " + averageSalary);
        } else {
            System.out.println("Nincsenek alkalmazottak Hatvanban vagy Szolnokon.");
        }
    }
}