import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class MyWindow extends Thread{
	JFrame f;
	JTextArea ta;
	JScrollPane scrollbar;
	Font f1=new Font("Forte",Font.BOLD,20);
	MyWindow(){
		f=new JFrame("Thread");
		ta=new JTextArea();

		scrollbar=new JScrollPane(ta,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		f.add(scrollbar);
		ta.setFont(f1);
		ta.addMouseListener(new MouseWin(this));
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(500,500);
		f.setVisible(true);
	
	}	
	
	
}
class NewThread2 extends Thread{
	MyWindow mf;
	NewThread2(MyWindow my){
		mf=my;
	} 
	public void run(){
		int i=0;
		while(true){
			while(true){
				
				mf.ta.setText(mf.ta.getText()+"\t"+"2*"+i+"="+(2*i)+"\n");
				try{
					sleep(500);
				}
				catch(Exception e){
					System.out.println(e);
				}
				i++;
			}
		}	
	}
}
class NewThread extends Thread{
	MyWindow mf;
	
	NewThread(MyWindow my){
		mf=my;
	} 	
	public void run(){
		int i=0;
		while(true){
			while(true){
				
				mf.ta.setText(mf.ta.getText()+"\t\t"+"3*"+i+"="+(3*i)+"\n");
				try{
					sleep(500);
				}
				catch(Exception e){
					System.out.println(e);
				}
				i++;
			}
		}	
	}
}
class MouseWin implements MouseListener {
	NewThread n1;
	NewThread2 n2;
	
	MouseWin(MyWindow my){
		
		n1=new NewThread(my);
		n2=new NewThread2(my);
	} 
	public void mouseExited(MouseEvent me){
		try{
			n1.suspend();
			n2.suspend();
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
	public void mouseEntered(MouseEvent me){
		n1.resume();
		n2.resume();
	}
	public void mouseReleased(MouseEvent me){
	
	}
	public void mousePressed(MouseEvent me){
	
	}
	public void mouseClicked(MouseEvent me){
		if(!n1.isAlive() && !n2.isAlive()){
			n1.start();
			n2.start();
		}
		else{
			try{
				n1.suspend();
				n2.suspend();
			}
			catch(Exception e){
				System.out.println(e);
			}
		}
	}
	
	
	
	
}
class RunWin{
	public static void main(String args[]){
		new MyWindow();
	}
}