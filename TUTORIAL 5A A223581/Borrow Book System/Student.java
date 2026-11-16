public class Student {
    private String name, matric;
    private boolean borrowed = false;

    public Student(String name, String matric) {
        this.name = name;
        this.matric = matric;
    }
    public String getName() { return name; }
    public String getMatric() { return matric; }
    public boolean hasBorrowed() { return borrowed; }
    public void setBorrowed(boolean b) { borrowed = b; }

    public String toString() {
        return "Name : " + name + " (" + matric + ")";
    }
}