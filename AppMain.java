import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class WindowFrame{
	JFrame f=new JFrame("DEMO");
	JButton b1,b2,b3;	
	JLabel l1,l2,l3,l4,l5,l6;
	JTextField t1,t2,t3;
	JTextArea ta;
	JScrollPane scrollBar;
	JRadioButton r1,r2;
	JComboBox cb1;
	ButtonGroup bg=new ButtonGroup();
	ButtonGroup bg1=new ButtonGroup();
	Font f1=new Font("Ink Free", Font.BOLD,30);
	Font f2=new Font("Times New Roman", Font.BOLD,20);
	String S[]={"1st Year","2nd Year","3rd Year","4th Year"};
	WindowFrame(){
		f.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent we){
				System.exit(0);
			}		
		});	
		
		f.setLayout(null);		
		l1=new JLabel("Welcome");
		l2=new JLabel("enter name: ");
		l3=new JLabel("enter section: ");
		l4=new JLabel("enter age: ");
		l5=new JLabel("Your year: ");
		l6=new JLabel("gender: ");
		b1=new JButton("Proceed");	
		b2=new JButton("clear");
		b3=new JButton("cancel");
		t1=new JTextField();
		t2=new JTextField();
		t3=new JTextField();
		cb1=new JComboBox(S);
		
		ta=new JTextArea();
		scrollBar=new JScrollPane(ta,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		r1=new JRadioButton("male");
		r2=new JRadioButton("female");

		bg.add(r1);
		bg.add(r2);

		t3.addKeyListener(new KeyAction(this));
		b1.addActionListener(new Action(this));
		b2.addActionListener(new Action(this));
		b3.addActionListener(new Action(this));


		l1.setBounds(150,0,200,30);
		l2.setBounds(90,65,200,20);
		l3.setBounds(90,85,200,20);
		l4.setBounds(90,105,200,20);
		l5.setBounds(90,40,100,20);
		l6.setBounds(90,125,200,20);
		
		t1.setBounds(205,65,200,20);
		t2.setBounds(205,85,200,20);
		t3.setBounds(205,105,200,20);
				
		b1.setBounds(100,500,100,50);
		b2.setBounds(200,500,100,50);
		b3.setBounds(300,500,100,50);
		
		r1.setBounds(200,125,100,20);
		r2.setBounds(300,125,100,20);
		cb1.setBounds(205,40,100,20);
	
		ta.setBounds(100,150,300,300);
		scrollBar.setBounds(100,150,300,400);
		
		l1.setFont(f1);
		l2.setFont(f2);
		l3.setFont(f2);
		l4.setFont(f2);
		l5.setFont(f2);
		l6.setFont(f2);
		ta.setFont(f2);
		

		f.add(b1);
		f.add(b2);
		f.add(b3);
		f.add(l1);
		f.add(l2);
		f.add(l3);
		f.add(l4);
		f.add(l5);
		f.add(l6);
		
		f.add(scrollBar);
		f.add(t1);
		f.add(t2);
		f.add(t3);
		f.add(r1);
		f.add(r2);
		f.add(cb1);
			
		
		f.setSize(500,1000);
		f.setVisible(true);
	}
}

class Action implements ActionListener{
	WindowFrame ft;
	Action(WindowFrame f){
		ft=f;		
	}
	public void actionPerformed(ActionEvent ae){
		if (ae.getActionCommand().equals("cancel")){
			System.exit(0);
		}
		
		else if(ae.getActionCommand().equals("Proceed")){
			String s1,s2,s3;
			s1=ft.t1.getText();
			s2=ft.t2.getText();
			s3=ft.t3.getText();

			ft.ta.setText("Name:"+s1+"\nSection: "+s2+"\nAge: "+s3+"\n");
		
			if(ft.r1.isSelected()){
				ft.ta.setText(ft.ta.getText()+"Gender: male"+"\n");
				ft.ta.setText(ft.ta.getText()+"Year: "+ft.cb1.getItemAt(ft.cb1.getSelectedIndex())+"\n");
			}
			else if(ft.r2.isSelected()){
				ft.ta.setText(ft.ta.getText()+"Gender: female"+"\n");
				ft.ta.setText(ft.ta.getText()+"Year: "+ft.cb1.getItemAt(ft.cb1.getSelectedIndex())+"\n");
			}
		}
		else if(ae.getActionCommand().equals("clear")){
			ft.t1.setText("");
			ft.t2.setText("");
			ft.t3.setText("");
			ft.ta.setText("");
			//ft.cb1.clearSelection();		
			ft.bg.clearSelection();
			
		}
			
	}	
}
class KeyAction implements KeyListener{
	WindowFrame ft;
	KeyAction(WindowFrame f){
		ft=f;		
	}
	public void keyPressed(KeyEvent ke){
		if(ke.getKeyText(ke.getKeyCode()).equals("Enter")){
			String s1,s2,s3;
			s1=ft.t1.getText();
			s2=ft.t2.getText();
			s3=ft.t3.getText();

			ft.ta.setText("Name:"+s1+"\nSection: "+s2+"\nAge: "+s3+"\n");
		
			if(ft.r1.isSelected()){
				ft.ta.setText(ft.ta.getText()+"Gender: male"+"\n");
				ft.ta.setText(ft.ta.getText()+"Year: "+ft.cb1.getItemAt(ft.cb1.getSelectedIndex())+"\n");
			}
			else if(ft.r2.isSelected()){
				ft.ta.setText(ft.ta.getText()+"Gender: female"+"\n");
				ft.ta.setText(ft.ta.getText()+"Year: "+ft.cb1.getItemAt(ft.cb1.getSelectedIndex())+"\n");
			}
	}
}
	public void keyReleased(KeyEvent ke){
	}
	public void keyTyped(KeyEvent ke){
		
	}
}
class AppMain{
	public static void main(String args[]){
		new WindowFrame();
	}
}