package gymrat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Checkout extends GUI {
    private JList<String> resultList;
    private JTextField searchField;
    private JButton searchButton;
    private JButton decrementButton; // 감소 버튼
    private JButton prevButton;

    public Checkout() {
        JFrame frame = new JFrame("체크인");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation(800, 300);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        DefaultListModel<String> resultListModel = new DefaultListModel<>();
        resultList = new JList<>(resultListModel);

        JScrollPane scrollPane = new JScrollPane(resultList);
        scrollPane.setPreferredSize(new Dimension(200, 200));

        mainPanel.add(scrollPane, BorderLayout.CENTER);

        JPanel searchPanel = new JPanel();
        searchPanel.setLayout(new FlowLayout());

        searchField = new JTextField(15);
        searchButton = new JButton("검색");
        decrementButton = new JButton("감소"); // 감소 버튼 추가
        prevButton = new JButton("이전");

        searchPanel.add(searchField);
        searchPanel.add(searchButton);
        searchPanel.add(decrementButton); // 감소 버튼 추가
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

        decrementButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = resultList.getSelectedIndex();
                if (selectedIndex != -1) {
                    decrementCount(selectedIndex);
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
        DefaultListModel<String> resultListModel = new DefaultListModel<>();
        resultList.setModel(resultListModel);

        String filePath = "C:\\Folder\\KNU\\4 학년\\2 학기\\실용 프로그래밍\\output.txt";

        boolean hasResults = false;

        try {
            FileReader fileReader = new FileReader(filePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                if (line.contains(searchTerm)) {
                    resultListModel.addElement(line);
                    hasResults = true;
                }
            }

            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (!hasResults) {
            resultListModel.addElement("검색결과 없음");
        }
    }

    private void decrementCount(int selectedIndex) {
        DefaultListModel<String> resultListModel = (DefaultListModel<String>) resultList.getModel();
        String selectedValue = resultListModel.getElementAt(selectedIndex);

        String[] parts = selectedValue.split("---");
        if (parts.length == 2) {
            String name = parts[0].trim();
            int count = Integer.parseInt(parts[1].replace("회", "").trim());

            if (count > 0) {
                count--; // 감소
                String updatedValue = name + " --- " + count + "회";
                resultListModel.setElementAt(updatedValue, selectedIndex); // 업데이트된 값으로 리스트 업데이트
                saveUpdatedCountToFile(resultListModel); // 파일에 업데이트된 값 저장
            }
        }
    }

    private void saveUpdatedCountToFile(DefaultListModel<String> resultListModel) {
        String filePath = "C:\\Folder\\KNU\\4 학년\\2 학기\\실용 프로그래밍\\output.txt";

        try {
            FileWriter fileWriter = new FileWriter(filePath);
            for (int i = 0; i < resultListModel.size(); i++) {
                String value = resultListModel.getElementAt(i);
                fileWriter.write(value + "\n");
            }
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Checkout();
    }
}
