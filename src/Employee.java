import java.time.LocalDate;

public class Employee {
    private String nev;
    private String hely;
    private String utca;
    private LocalDate szuletes;
    private  double fizetes;
    public Employee(String nev, String hely, String utca, LocalDate szuletes, double fizetes) {
        this.nev = nev;
        this.hely = hely;
        this.utca = utca;
        this.szuletes = szuletes;
        this.fizetes = fizetes;
    }
    public Employee() {
    }
    public String getNev() {
        return nev;
    }
    public void setNev(String nev) {
        this.nev = nev;
    }
    public String getHely() {
        return hely;
    }
    public void setHely(String hely) {
        this.hely = hely;
    }
    public String getUtca() {
        return utca;
    }
    public void setUtca(String utca) {
        this.utca = utca;
    }
    public LocalDate getSzuletes() {
        return szuletes;
    }
    public static void setSzuletes(LocalDate szuletes) {
        this.szuletes = szuletes;
    }
    public double getFizetes() {
        return fizetes;
    }
    public void setFizetes(double fizetes) {
        this.fizetes = fizetes;
    }
    
}
