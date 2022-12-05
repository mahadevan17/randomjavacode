import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
class TestWindow{
	JFrame f;
	JButton b[]=new JButton[10];
	JButton b1,b2,b3,b4,b5;
	FlowLayout f1;
	JTextField t1;
	Calculation c1;
	int y=0;
	String opr="",orand="";
	TestWindow(){
		f=new JFrame("new window");
		c1=new Calculation(this);
		t1=new JTextField(30);
		f.add(t1);
		f1=new FlowLayout();
		f.setLayout(f1);
		
		for(int i=0;i<10;i++){		
			b[i]=new JButton(Integer.toString(i));
			f.add(b[i]);	
			b[i].addActionListener(c1);		
		}	
		b1=new JButton("+");
		b2=new JButton("-");
		b3=new JButton("*");
		b4=new JButton("/");	
		b5=new JButton("=");
		f.add(b1);
		f.add(b2);
		f.add(b3);
		f.add(b4);
		f.add(b5);
		f.setSize(500,500);
		f.setVisible(true);
		b1.addActionListener(c1);
		b2.addActionListener(c1);
		b3.addActionListener(c1);
		b4.addActionListener(c1);
		b5.addActionListener(c1);
		
		f.addWindowListener(
			new WindowAdapter(){
				public void windowClosing(WindowEvent we)				{
					System.out.println("closing");
					System.exit(0);
				}
			}
		);
		
	}
}
class Calculation implements ActionListener{
	
	//TestWindow obj=new TestWindow();
	TestWindow obj;
	Calculation(TestWindow obj)
	{
		this.obj=obj;
	}
	public void actionPerformed(ActionEvent ae){
		for(int i=0;i<10;i++){
			if (ae.getActionCommand().equals(String.valueOf(i))){
				obj.orand=obj.orand+String.valueOf(i);
				obj.t1.setText(obj.orand)	;
			}
		}
		
		if (ae.getActionCommand().equals("+")){
			obj.opr="+";obj.orand="";
			obj.y=Integer.parseInt(obj.t1.getText());
			obj.t1.setText("");
		}
		else if (ae.getActionCommand().equals("-")){
			obj.opr="-";obj.orand="";
			obj.y=Integer.parseInt(obj.t1.getText());
			obj.t1.setText("");
		}	
		else if (ae.getActionCommand().equals("*")){
			obj.opr="*";obj.orand="";
			obj.y=Integer.parseInt(obj.t1.getText());
			obj.t1.setText("");
		}
		else if (ae.getActionCommand().equals("/")){
			obj.opr="/";obj.orand="";
			obj.y=Integer.parseInt(obj.t1.getText());
			obj.t1.setText("");
		}
		else if (ae.getActionCommand().equals("=")){
			if(obj.opr.equals("+"))
			{
	
				int ans=obj.y+Integer.parseInt(obj.t1.getText());	
				obj.t1.setText(String.valueOf(ans));
				obj.orand="";
			}
			else if(obj.opr.equals("-"))
			{
	
				int ans=obj.y-Integer.parseInt(obj.t1.getText());	
				obj.t1.setText(String.valueOf(ans));
				obj.orand="";
			}
			else if(obj.opr.equals("*"))
			{
				obj.orand="";
				int ans=obj.y*Integer.parseInt(obj.t1.getText());	
				obj.t1.setText(String.valueOf(ans));
			}
			else if(obj.opr.equals("/"))
			{
				obj.orand="";
				int ans=obj.y/Integer.parseInt(obj.t1.getText());	
				obj.t1.setText(String.valueOf(ans));
			}
		}
	}
	
}
class TestMain{
	public static void main(String args[]){
		TestWindow t1=new TestWindow();
	}
}