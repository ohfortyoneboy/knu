package gymrat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


public class adminp extends GUI {
	public adminp() {	
		JFrame f1 = new JFrame("이용자 추가");
		f1.setSize(350, 200);
        f1.setLayout(null);
        f1.setLocation(800, 300);
        
        JLabel l1 = new JLabel("회원명 :");
        l1.setSize(50, 30);
        l1.setLocation(30, 15);
        JLabel l2 = new JLabel("이용권 :");
        l2.setSize(60,30);
        l2.setLocation(30,55);
        
        f1.add(l1);
        f1.add(l2);
        
        JTextField myTextField = new JTextField("");
        myTextField.setSize(100, 30);
        myTextField.setLocation(70, 15);
        JTextField myTextField2 = new JTextField("");
        myTextField2.setSize(100, 30);
        myTextField2.setLocation(70, 55);

        f1.add(myTextField);
        f1.add(myTextField2);

        JButton inb = new JButton("입력");
        inb.setSize(75, 30);
        inb.setLocation(230, 15);
        JButton inb2 = new JButton("돌아가기");
        inb2.setSize(100, 30);
        inb2.setLocation(230, 100);

        
        inb.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String inputText = myTextField.getText();
                String inputText2 = myTextField2.getText();

                saveToFile(inputText, inputText2);
            }
        });
        
        inb2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	new GUI2();
                f1.setVisible(false);
            }
        });

        f1.add(inb);
        f1.add(inb2);

        

        f1.setVisible(true);
    }


    private static void saveToFile(String text, String text2) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Folder\\KNU\\4 학년\\2 학기\\실용 프로그래밍\\output.txt", true));
            writer.write(text + "---" +text2);
            writer.newLine();
            writer.write("------------------------------------------------------");
            writer.newLine();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
	