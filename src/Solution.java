import java.util.ArrayList;

public class Solution {
    public static void startSolution() {
        ArrayList<Employee> empList = Store.readFile();
        System.out.println(empList.get(0).getNev());
        
        
    }
}
