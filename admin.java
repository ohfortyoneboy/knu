package gymrat;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.*;
import javax.swing.text.html.HTMLDocument.Iterator;

public class admin extends GUI {
    private JTextArea ta;
    private JTextField tf;
    private String filePath;

    public admin() {
        JFrame jframe = new JFrame();
        jframe.setBounds(50, 50, 500, 300);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setVisible(true);

        JPanel jpanel = new JPanel();
        jpanel.setLayout(null);
        jframe.add(jpanel);

        tf = new JTextField();
        tf.setSize(200, 30);
        tf.setLocation(5, 5);
        jpanel.add(tf);

        ta = new JTextArea();
        JScrollPane jsp = new JScrollPane(ta);
        jsp.setSize(200, 200);
        jsp.setLocation(5, 50);
        jframe.add(jsp);

        ta.setText("입력 : 이름 / 국어 / 영어 / 수학" + "\n" + "☆검색 / 수정 / 삭제 시 이름 입력☆" + "\n");

        JButton btn1 = new JButton("입력");
        jpanel.add(btn1);
        btn1.setBounds(350, 20, 100, 30);

        JButton btn2 = new JButton("출력");
        jpanel.add(btn2);
        btn2.setBounds(350, 60, 100, 30);

        JButton btn3 = new JButton("검색");
        jpanel.add(btn3);
        btn3.setBounds(350, 100, 100, 30);


        JButton btn4 = new JButton("수정");
        jpanel.add(btn4);
        btn4.setBounds(350, 140, 100, 30);

        JButton btn5 = new JButton("삭제");
        jpanel.add(btn5);
        btn5.setBounds(350, 180, 100, 30);

        JButton btn6 = new JButton("종료");
        jpanel.add(btn6);
        btn6.setBounds(350, 220, 100, 30);


        filePath = "C:\\Folder\\KNU\\4 학년\\2 학기\\실용 프로그래밍\\output.txt";

        // 입력 버튼 이벤트
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                String data = tf.getText();
                appendDataToFile(data);
                ta.append(data + "\n");
            }
        });

        // 출력 버튼 이벤트
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                String data = readDataFromFile();
                ta.setText(data);
            }
        });

        // 검색 버튼 이벤트
        btn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                String name = tf.getText();
                String data = readDataFromFile();
                if (data.contains(name)) {
                    ta.setText(name + "\n");
                }
            }
        });

        // 수정 버튼 이벤트
        btn4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                String[] input = tf.getText().split(" ");
                String name = input[0];
                String newData = input[1] + " " + input[2] + " " + input[3];
                updateDataByName(name, newData);
            }
        });

        // 삭제 버튼 이벤트
        btn5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                String name = tf.getText();
                deleteDataByName(name);
            }
        });

        // 종료 버튼 이벤트
        btn6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                System.exit(0);
            }
        });
    }

    private void appendDataToFile(String data) {
        try {
            FileWriter fileWriter = new FileWriter(filePath, true);
            fileWriter.write(data + "\n");
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String readDataFromFile() {
        StringBuilder data = new StringBuilder();
        try {
            FileReader fileReader = new FileReader(filePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                data.append(line).append("\n");
            }

            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data.toString();
    }

    private void updateDataByName(String name, String newData) {
        try {
            File inputFile = new File(filePath);
            File tempFile = new File("temp.txt");

            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith(name)) {
                    writer.write(newData + "\n");
                } else {
                    writer.write(line + "\n");
                }
            }

            writer.close();
            reader.close();

            inputFile.delete();
            tempFile.renameTo(inputFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteDataByName(String name) {
        try {
            File inputFile = new File(filePath);
            File tempFile = new File("temp.txt");

            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.startsWith(name)) {
                    writer.write(line + "\n");
                }
            }

            writer.close();
            reader.close();

            inputFile.delete();
            tempFile.renameTo(inputFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
