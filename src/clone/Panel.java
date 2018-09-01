package clone;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JPanel;

public class Panel extends JPanel implements MouseListener{

	private static final long serialVersionUID = 1L;
	ArrayList<Puzzle> puzzles = new ArrayList<>();
	String ch[] = {"0","1","2","3","4","5","6","7","8","9","10","11"};
	private int emptySpaceIndex = 0;
	private boolean win = false;
	public Panel() {
		super();
		setLayout(null);
		init();
		repaint();
		addMouseListener(this);
	}
	
	
	private void init() {
		 Puzzle puzzle ;
		 int x = 200;
		 int y = 200;
		 for(int i=0;i<4;i++){
			 for(int j=0;j<3;j++){
				 puzzle = new Puzzle(x+j*92, y+i*92, 45,ch[i*3+j], Color.BLACK);
				 puzzles.add(puzzle);
			 }
		 }
		 

		 
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D)g;
		g2d.drawRect(185, 185, 300, 400);
		for(int i=0;i<puzzles.size();i++){
			if(!puzzles.get(i).getNumber().equals("0")){
				String ch;
				ch = puzzles.get(i).getNumber();
				g2d.setColor(puzzles.get(i).getColor());
				
				g2d.fillRect(puzzles.get(i).getX(), puzzles.get(i).getY(),
						puzzles.get(i).getRadius()*2, puzzles.get(i).getRadius()*2);
				
				g2d.setColor(Color.white);
				g2d.setFont(new Font("Sherif", Font.BOLD, 40));
				g2d.drawString(ch, puzzles.get(i).getX()+20, puzzles.get(i).getY()+70);
				g2d.setColor(Color.BLACK);
				
				if(win)showWinMessage(g2d);
			}
			
		}
	}

	private void showWinMessage(Graphics2D g2d) {
		g2d.drawString("You win", 500, 400);
		
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		identifyCircle(x, y);
		
	}

	private void identifyCircle(int x, int y) {
		for(int i =0;i<puzzles.size();i++){
			int x1 = puzzles.get(i).getX();
			int y1 = puzzles.get(i).getY();
			int radius = puzzles.get(i).getRadius();
			if((x-x1) <= radius*2 && (x-x1)>= 0 && (y-y1) <= radius*2 && (y-y1)>= 0){
				movePuzzle(i);
				break;
			}
		}
	}


	private void movePuzzle(int i) {
		int tempX = puzzles.get(emptySpaceIndex).getX();
		int tempY = puzzles.get(emptySpaceIndex).getY();
		
		if((Math.abs(tempX - puzzles.get(i).getX()) == 92 && 
				Math.abs( tempY - puzzles.get(i).getY()) == 0) || 
				(Math.abs( tempY - puzzles.get(i).getY()) == 92 && 
				Math.abs(tempX - puzzles.get(i).getX()) == 0)){
			puzzles.get(emptySpaceIndex).setX(puzzles.get(i).getX());
			puzzles.get(emptySpaceIndex).setY(puzzles.get(i).getY());
			puzzles.get(i).setX(tempX);
			puzzles.get(i).setY(tempY);
			repaint();
			checkWin();
		}
		
	}
	
	private void checkWin() {
		int i;
		for( i=0;i<4;i++){
			for(int j=0;j<3;j++){
				if((puzzles.get(i*3+j).getX() != 200+ j*92)|| (puzzles.get(i*3+j).getY() != 200+i*92)){
					return;
				}
			}
			
		}
		if(i== 4){
			win = true;
			System.out.println("hellos");
		}
		
	}


	@Override
	public void mousePressed(MouseEvent e) {
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	

}
