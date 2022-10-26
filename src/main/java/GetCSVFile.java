import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

import static java.lang.System.*;

public class GetCSVFile extends JPanel {
      //  public static void main(String[] args) throws IOException {
            // loads a file from a resources folder
     //       InputStream is = GetCSVFile.class.getClassLoader().getResourceAsStream("data.csv");

   // }
    ArrayList<GetData> GetDataCompany = new ArrayList<>();
    JFrame border = new JFrame("CSV Java Project");
    JPanel button = new JPanel();

    JButton load = new JButton("Load CSV");
    JButton TotalHoursDisplay = new JButton("Display total amount of hours worked and sort csv in descending order.");
    JButton ibanDisplay = new JButton("Display Rain Descending");
    JButton bicDisplay = new JButton("Display Mean Wind Speed Descending");
    JButton hoursDisplay = new JButton("Display Sun Ascending");
    JButton Data = new JButton("Save CSV");
    JTextArea Product = new JTextArea(40, 40);
    JTextArea text = new JTextArea(1, 3);
    int indicate = 0;
}
