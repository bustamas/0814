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
    }
}
