/*
    (Name of project)
    CI/CD
    G00391704: Sarah Mitchell
    G00392003: Eoin Gallagher
    G00396018: Aleksander Kijewski
    G00374265: Michael Agbo
 */
public class Run {
    public static void main(String[] args) {
        //To get filePath
        GetFilePath file = new GetFilePath();
        file.run();
        String filePath = file.returnPath();
        System.out.println(filePath);
    }
}
