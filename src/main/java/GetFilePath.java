import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class GetFilePath extends JPanel implements ActionListener {
    JButton buttonOpen, buttonSave;
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

        buttonSave = new JButton("Save File");
        buttonSave.addActionListener(this);

        JPanel buttons = new JPanel();
        buttons.add(buttonOpen);
        buttons.add(buttonSave);
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
                returnPath();
            } else {
                text.append("Cancelled");
            }
        }
    }
    public String returnPath(){
        new ReadCSVFile(nameFile);
        return nameFile;
    }
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("FileChooserDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Add content to the window.
        frame.add(new GetFilePath());

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
    public void run() {
        //Turn off metal's use of bold fonts
        UIManager.put("swing.boldMetal", Boolean.FALSE);
        createAndShowGUI();
    }

}
