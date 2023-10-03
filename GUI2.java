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


public class GUI2 extends GUI {
	public GUI2(){
		JFrame f = new JFrame("v0.1");
		f.setSize(520, 200);
        f.setLayout(null);
        f.setLocation(800, 300);

        JButton inb = new JButton("이용자 추가");
        inb.setSize(100, 30);
        inb.setLocation(20, 50);
        JButton inb2 = new JButton("전체 이용자");
        inb2.setSize(100, 30);
        inb2.setLocation(140, 50);
        JButton inb3 = new JButton("이용자 검색");
        inb3.setSize(100, 30);
        inb3.setLocation(260, 50);
        JButton inb4 = new JButton("체크 아웃");
        inb4.setSize(100, 30);
        inb4.setLocation(380, 50);
        
        
        f.add(inb);
        f.add(inb2);
        f.add(inb3);
        f.add(inb4);


        f.setVisible(true);

        inb4.addActionListener(new ActionListener() {
        	@Override
            public void actionPerformed(ActionEvent e) {
                new Checkout();
                f.setVisible(false);
            }
        });
        inb.addActionListener(new ActionListener() {
        	@Override
            public void actionPerformed(ActionEvent e) {
                new adminp();
                f.setVisible(false);
            }
        });
        
        inb2.addActionListener(new ActionListener() {
        	@Override
            public void actionPerformed(ActionEvent e) {
                new reading();
                f.setVisible(false);
            }
        });
        
        inb3.addActionListener(new ActionListener() {
        	@Override
            public void actionPerformed(ActionEvent e) {
                new SearchProgram();
                f.setVisible(false);
            }
        });
	}
}