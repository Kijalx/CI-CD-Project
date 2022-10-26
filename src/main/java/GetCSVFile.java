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
    JButton ibanDisplay = new JButton("Display IBAN's Descending");
    JButton rateDisplay = new JButton("Display Pay Rates Descending");
    JButton overtimeHours = new JButton("Display Over-Time Hours Descending");
    JButton hoursDisplay = new JButton("Display Hours Descending");
    JButton TotalPayDisplay = new JButton("Display Total Pay Descending");
    JButton overTimePayDisplay = new JButton("Display Over-Time Pay Descending");
    JButton saveData = new JButton("Save CSV");
    JTextArea Product = new JTextArea(40, 40);
    JTextArea text = new JTextArea(1, 3);
    int indicate = 0;

 public GetCSVFile() throws IOException {
  border.add(button);  //Buttons
  button.add(load);
  button.add(TotalHoursDisplay);
  button.add(ibanDisplay);
  button.add(rateDisplay);
  button.add(hoursDisplay);
  button.add(overtimeHours);
  button.add(TotalPayDisplay);
  button.add(overTimePayDisplay);
  button.add(saveData);

  border.add(text);  // text
  text.setVisible(false);
  text.setEditable(true);
  Product.setEditable(false);


  border.setLayout(new GridLayout(1, 3, 2, 3));
  button.setLayout(new FlowLayout(FlowLayout.CENTER, 1000, 7));
  border.add(Product);

  //listener
  buttonListen listener = new buttonListen();
  load.addActionListener(listener);
  saveData.addActionListener(listener);
  TotalHoursDisplay.addActionListener(listener);
  ibanDisplay.addActionListener(listener);
  rateDisplay.addActionListener(listener);
  hoursDisplay.addActionListener(listener);
  overtimeHours.addActionListener(listener);
  TotalPayDisplay.addActionListener(listener);
  overTimePayDisplay.addActionListener(listener);


  border.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  border.pack();
  border.setLocationRelativeTo(null);
  border.setSize(500, 500);
  border.setVisible(true);

 }
 public static void main(String[] args) throws IOException {
  GetCSVFile x = new GetCSVFile();
 }

 //Listener action
 private class buttonListen implements ActionListener {

  // gets document
  String document = "project.csv";
  String format;

  long ln = 0;


  BufferedReader BR;

  {
   try {
    BR = new BufferedReader(new FileReader(document));
   } catch (FileNotFoundException e) {
    e.printStackTrace();
   }
   try {
    BR.readLine();
   } catch (IOException e) {
    e.printStackTrace();
   }
  }

  @Override
  public void actionPerformed(ActionEvent aEvent) {

   //get data
   if (aEvent.getSource() == load) {
    indicate = 1;
    while (true)
    {
     try {
      if ((format = BR.readLine()) == null)
       break;
     } catch (IOException e) {
      e.printStackTrace();
     }
     System.out.println(format);
     format += "\n";
     Product.append(format);
     ln++;
     String[] data = format.split(",");
     try {
      GetData Payroll = new GetData(Float.parseFloat(data[0]), Float.parseFloat(data[1]), Float.parseFloat(data[2]), Float.parseFloat(data[3]), Float.parseFloat(data[4]), Float.parseFloat(data[5]), Float.parseFloat(data[6]), Float.parseFloat(data[7]), Float.parseFloat(data[8]), Float.parseFloat(data[9]), Float.parseFloat(data[10]), Float.parseFloat(data[11]));
      GetData.add(Payroll);

     } catch (Exception e) {
      System.out.println(" ERROR at line" + ln);
      e.printStackTrace();
     }
    }
   }

   //save data
   if (aEvent.getSource() == saveData) {
    String save;
    text.setVisible(true);
    save = text.getText();
    FileOutputStream output = null;
    try {
     output = new FileOutputStream(new File(save + ".csv"), false);
    } catch (FileNotFoundException e) {
     e.printStackTrace();
    }

    PrintWriter printWriter = new PrintWriter(output);
    for (Projectdata weather : ProjectdataCompany) {
     printWriter.println(weather + "\n");
    }
    printWriter.flush();
    printWriter.close();

   }

   //Temperature
   if (aEvent.getSource() == temperatureDisplay) {
    if (indicate == 1) {
     Product.setText("");
     Collections.sort(ProjectdataCompany, new compMaxTemperature());
     for (Projectdata weather : ProjectdataCompany) {
      Product.append(weather + "\n");
     }
     indicate = 0;
     load.doClick();
    }
   }

   // Rain
   if (aEvent.getSource() == rainDisplay) {
    new Projectdata(1);
    if (indicate == 1) {
     Product.setText("");
     Collections.sort(ProjectdataCompany, new compMaxrain());
     for (Projectdata weather : ProjectdataCompany) {
      Product.append(weather + "\n");
     }
     indicate = 0;
     load.doClick();
    }
   }

   //Wind
   if (aEvent.getSource() == WDSDisplay) {
    new Projectdata(1);
    if (indicate == 1) {
     Product.setText("");
     Collections.sort(ProjectdataCompany, new compMaxWDS());
     for (Projectdata weather : ProjectdataCompany) {
      Product.append(weather + "\n");
     }
     indicate = 0;
     load.doClick();
    }
   }

   //Sun
   if (aEvent.getSource() == sunDisplay) {
    new Projectdata(1);
    if (indicate == 1) {
     Product.setText("");
     Collections.sort(ProjectdataCompany, new compMaxSun());
     for (Projectdata weather : ProjectdataCompany) {
      Product.append(weather + "\n");
     }
     indicate = 0;
     load.doClick();
    }
   }
  }
 }
}
