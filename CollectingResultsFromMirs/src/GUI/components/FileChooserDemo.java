/**
 * Created by Julio on 4.7.2017.
 */
package components;

import Base.BaseUtil;
import Model.Instrument;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.CheckInstrumentsPageObjects;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.SwingUtilities;

public class FileChooserDemo extends JPanel implements ActionListener {

    static private final String newline = "\n";
    JButton openButton, saveButton,selectDriverButton,runButton;
    JTextArea log;
    JFileChooser initialFile,finalFile,selectDriver;
    File inputFile,resultFile,aux,selectDriverFile;
    String finalFileString = "\\result_values.xlsx";

    private BaseUtil baseUtil;
    private CheckInstrumentsPageObjects checkInstrumentsPageObjects;
    private String index = "http://www.mirs-info.si/Verification/index.php?Action=CheckInstrument";
    private Instrument instrument = new Instrument();

    public FileChooserDemo() throws FileNotFoundException {
        super(new BorderLayout());

        log = new JTextArea(5,20);
        log.setMargin(new Insets(5,5,5,5));
        log.setEditable(false);
        JScrollPane logScrollPane = new JScrollPane(log);

        initialFile = new JFileChooser();
        selectDriver = new JFileChooser();
        finalFile = new JFileChooser();
        finalFile.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        openButton = new JButton("Open a File...");
        openButton.addActionListener(this);
        openButton.setEnabled(false);

        saveButton = new JButton("Save Result File");
        saveButton.addActionListener(this);
        saveButton.setEnabled(false);

        selectDriverButton = new JButton("Select Chrome Driver");
        selectDriverButton.addActionListener(this);

        runButton = new JButton("Run");
        runButton.addActionListener(this);
        runButton.setEnabled(false);


        JPanel buttonPanel = new JPanel(); //use FlowLayout
        buttonPanel.add(openButton);
        buttonPanel.add(saveButton);
        buttonPanel.add(selectDriverButton);

        JPanel addButtonPanel = new JPanel();
        addButtonPanel.add(runButton);

        add(buttonPanel, BorderLayout.PAGE_START);
        add(logScrollPane, BorderLayout.CENTER);
        add(addButtonPanel,BorderLayout.PAGE_END);

        this.baseUtil = new BaseUtil();
    }

    public void actionPerformed(ActionEvent e){

        if(e.getSource() == openButton){
            int returnVal = initialFile.showOpenDialog(FileChooserDemo.this);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                inputFile = initialFile.getSelectedFile();
                log.append("Input File: " + inputFile.getAbsolutePath() + "." + newline);
                runButton.setEnabled(true);
            }else {
                log.append("Open command cancelled by user." + newline);
            }
            log.setCaretPosition(log.getDocument().getLength());
        }

        else if(e.getSource() == saveButton){
            int returnVal = finalFile.showOpenDialog(FileChooserDemo.this);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                aux = finalFile.getSelectedFile();
                resultFile = new File(aux.getAbsolutePath()+finalFileString);
                log.append("Result File: " + resultFile.getAbsolutePath()+ newline);
            }else {
                log.append("Open command cancelled by user." + newline);
            }
            log.setCaretPosition(log.getDocument().getLength());
        }

        else if(e.getSource() == selectDriverButton){
            int returnVal = selectDriver.showOpenDialog(FileChooserDemo.this);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                selectDriverFile = selectDriver.getSelectedFile();
                System.setProperty("webdriver.chrome.driver", selectDriverFile.getAbsolutePath());
                log.append("Driver selected: " + selectDriverFile.getAbsolutePath()+ newline);

                openButton.setEnabled(true);
                saveButton.setEnabled(true);
            }else {
                log.append("Open command cancelled by user." + newline);
            }
            log.setCaretPosition(log.getDocument().getLength());
        }

        else if(e.getSource() == runButton){

            openButton.setEnabled(false);
            saveButton.setEnabled(false);
            runButton.setEnabled(false);
            selectDriverButton.setEnabled(false);

            if(resultFile == null){
                resultFile = new File(inputFile.getParent()+finalFileString);
                log.append("Result File: " +resultFile.getAbsolutePath()+newline);
            }

            try {

                baseUtil.setDriver(new ChromeDriver());
                baseUtil.setWait(new WebDriverWait(baseUtil.getDriver(),50));
                baseUtil.setBASE_URL(index);
                this.checkInstrumentsPageObjects = new CheckInstrumentsPageObjects(baseUtil.getDriver(), baseUtil.getWait(),
                        baseUtil.getBASE_URL());

                log.append("Opening the browser"+newline);
                checkInstrumentsPageObjects.openPrimarySiteApplications();
                log.append("Browser started"+newline);
                log.append("Running queries..."+newline);

                JOptionPane.showMessageDialog(this,"Do not close or interact with the browser",
                        "Alert",JOptionPane.INFORMATION_MESSAGE);

                instrument.writeLabelsOnTheFile(resultFile);
                checkInstrumentsPageObjects.enterValues(inputFile,resultFile);

                log.append("Queries finished"+newline);

                baseUtil.getDriver().close();
                log.append("Browser finished"+newline);

                JOptionPane.showMessageDialog(this,"Process completed check the result file",
                        "Message",JOptionPane.INFORMATION_MESSAGE);


                openButton.setEnabled(true);
                saveButton.setEnabled(true);

                log.append("-----------------------------------------------------------------------" +
                        "---------------------------------------------"+newline);

            }catch (IOException e1){
                e1.printStackTrace();
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }

        }
    }

    private static void createAndShowGUI() throws FileNotFoundException {
        //Create and set up the window.
        JFrame frame = new JFrame("FileChooser");
        frame.setPreferredSize(new Dimension(500, 500));
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        //Add content to the window.
        frame.add(new FileChooserDemo());

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                UIManager.put("swing.boldMetal", Boolean.FALSE);
                try {
                    createAndShowGUI();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
