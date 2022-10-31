import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class GetFilePath extends JPanel implements ActionListener {
    JButton buttonOpen, buttonLoad;
    JTextArea text;
    JFileChooser fileChooser;
    String nameFile;
    public GetFilePath(){
        super(new BorderLayout());
        text = new JTextArea(5,20);
        text.setMargin(new Insets(5,5,5,5));
        text.setEditable(false);
        JScrollPane textScroll = new JScrollPane(text);
        fileChooser = new JFileChooser();

        buttonOpen = new JButton("Open File");
        buttonOpen.addActionListener(this);

        buttonLoad =  new JButton("Load File");
        buttonLoad.addActionListener(this);

        JPanel buttons = new JPanel();
        buttons.add(buttonOpen);
        buttons.add(buttonLoad);
        add(buttons,BorderLayout.PAGE_START);
        add(text,BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttonOpen) {
            int rVal = fileChooser.showOpenDialog(GetFilePath.this);
            if (rVal == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                text.append("Opening: " + file.getName() + "\n");
                nameFile = fileChooser.getSelectedFile().getAbsolutePath();
            } else {
                text.append("Cancelled");
            }
        }
        if(e.getSource() == buttonLoad){
            ReadCSVFile readCSV = new ReadCSVFile();
            readCSV.read(nameFile);
        }
    }
    public String returnPath(){
        return nameFile;
    }
    public String run() {
        JFrame frame = new JFrame("FileChooserDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.add(new GetFilePath());

        frame.pack();
        frame.setVisible(true);
        return nameFile;
    }

}
