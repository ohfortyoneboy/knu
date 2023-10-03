package gymrat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class reading extends GUI {
    private JTextArea textArea;
    private JCheckBox enableEditCheckBox;

    public reading() {
        JFrame frame = new JFrame("전체 이용자");
        frame.setSize(400, 300);
        frame.setLocation(800, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        JPanel textAreaPanel = new JPanel();
        textAreaPanel.setLayout(new BoxLayout(textAreaPanel, BoxLayout.X_AXIS));
        textAreaPanel.setPreferredSize(new Dimension(200, 200));

        textArea = new JTextArea();
        textArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(textArea);

        textAreaPanel.add(scrollPane);
        mainPanel.add(textAreaPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));

        JButton inb = new JButton("수정");
        JButton inb2 = new JButton("돌아가기");

        enableEditCheckBox = new JCheckBox("관리자 모드");
        buttonPanel.add(enableEditCheckBox);

        buttonPanel.add(Box.createHorizontalGlue());
        buttonPanel.add(inb);
        buttonPanel.add(inb2);

        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        inb2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new GUI2();
                frame.setVisible(false);
            }
        });


        inb.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (enableEditCheckBox.isSelected()) {
                    saveTextToFile();
                }
            }
        });

        enableEditCheckBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                boolean enableEdit = enableEditCheckBox.isSelected();
                textArea.setEditable(enableEdit);
            }
        });

        String filePath = "C:\\Folder\\KNU\\4 학년\\2 학기\\실용 프로그래밍\\output.txt"; 

        try {
            FileReader fileReader = new FileReader(filePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                textArea.append(line + "\n"); 
            }

            bufferedReader.close(); 
        } catch (IOException e) {
            e.printStackTrace();
        }

        frame.add(mainPanel);
        frame.setVisible(true);
    }


    private void saveTextToFile() {
        String filePath = "C:\\Folder\\KNU\\4 학년\\2 학기\\실용 프로그래밍\\output.txt";

        try {
            FileWriter fileWriter = new FileWriter(filePath);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            String text = textArea.getText(); 
            bufferedWriter.write(text); 

            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new reading();
    }
}
