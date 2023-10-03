package gymrat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class SearchProgram extends GUI {
    private JTextArea textArea;
    private JTextField searchField;
    private JButton searchButton;
    private JButton prevButton; 

    public SearchProgram() {
        JFrame frame = new JFrame("이용자 검색");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation(800, 300);

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

        JPanel searchPanel = new JPanel();
        searchPanel.setLayout(new FlowLayout());

        searchField = new JTextField(20);
        searchButton = new JButton("검색");
        prevButton = new JButton("이전");

        searchPanel.add(searchField);
        searchPanel.add(searchButton);
        searchPanel.add(prevButton);

        mainPanel.add(searchPanel, BorderLayout.NORTH);

        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String searchTerm = searchField.getText();
                if (searchTerm != null && !searchTerm.isEmpty()) {
                    searchAndDisplay(searchTerm);
                }
            }
        });
        
        prevButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new GUI2();
                frame.setVisible(false);
            }
        });

        frame.add(mainPanel);
        frame.setVisible(true);
    }


    private void searchAndDisplay(String searchTerm) {
        textArea.setText(""); // 텍스트 영역 초기화

        String filePath = "C:\\Folder\\KNU\\4 학년\\2 학기\\실용 프로그래밍\\output.txt";

        boolean hasResults = false; 

        try {
            FileReader fileReader = new FileReader(filePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                if (line.contains(searchTerm)) {
                    textArea.append(line + "\n"); 
                    hasResults = true; 
                }
            }

            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (!hasResults) {
            textArea.append("검색결과 없음\n");
        }
    }

    public static void main(String[] args) {
        new SearchProgram();
    }
}
