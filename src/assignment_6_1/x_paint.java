/*
Course: COSC 211 - Programming Data Structures
Instructor: Khaled Mansour
Student: Deniz K Acikbas (E01825290)
Assignment: 06
Project Name: X Painter for Bus X OS (A future operating system I am planning to build)
Description: This is a painter program that allows user to draw, color and delete the shapes
             not only limited to that. You can also write something into the text area and 
             change its size and font. This program maybe used for operating system development in
             the future as there would be more opportunities.
 */
package assignment_6_1;

//import awt, awt.event and swing from the repository
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

//this is the x_paint class inherits from JFrame, implements ActionListener method
public class x_paint extends JFrame implements ActionListener {
	//variable for the actionListener 
	private String cap = null;
	
	//variables for setting background colors, object colors and objects itself
	private int x = 0;
	private int c = 0;
	private int b = 0;
	
	//text area variable
	JTextArea user_text_area;
	
	//variables for the style, size and font 
	private int fstyle = Font.PLAIN;
	private int fsize = 20;
	private Font f = null;
	
	//variables for menu bar, text panel and drawing panel
	JMenuBar bar = null;
	private JPanel textPan = null;
	private DrawingPanel drawingPan = null;
	
	//variables for the figure menu
	JMenu figure_menu = null;
	JMenuItem straight_line = null;
	JMenuItem rectangle = null;
	JMenuItem oval = null;
	JMenuItem round_rectangle = null;
	JMenuItem filled_rectangle = null;
	JMenuItem filled_oval = null;
	
	//variable for the color menu
	JMenu color_menu = null;
	
	//variables for the foreground submenu
	JMenu foreground = null;
	JMenuItem black_1 = null;
	JMenuItem blue_1 = null;
	JMenuItem cyan_1 = null;
	JMenuItem green_1 = null;
	JMenuItem magenta_1 = null;
	JMenuItem red_1 = null;
	
	//variables for the background submenu
	JMenu background = null;
	JMenuItem black_2 = null;
	JMenuItem blue_2 = null;
	JMenuItem cyan_2 = null;
	JMenuItem green_2 = null;
	JMenuItem magenta_2 = null;
	JMenuItem red_2 = null;
	
	//clear button variable
	JMenuItem clear = null;

	//variables for the font submenu
	JMenu font_menu = null;
	JMenu style = null;
	JMenuItem bold = null;
	JMenuItem italics = null;
	JMenuItem size = null;
	JMenuItem size_10 = null;
	JMenuItem size_20 = null;
	JMenuItem size_72 = null;
	
	//variables for the info menu
	JMenu info_menu = null;
	JMenuItem version = null;

	//Main method of x_paint class
	public static void main(String[] args) {
		//Create an object for x_paint class
		x_paint start = new x_paint();
		//This code enables GUI to become visible
		start.setVisible(true);
	}
	//Constructor of x_paint class
	public x_paint() {
		//inherit other methods from JFrame
		super();
		//set size by 500x500
		this.setSize(500, 500);
		//set title of the program to "X Painter"
		this.setTitle("X Painter");
		//once the program has been closed, stop JVM
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//initialize bar and drawingPan variables
		bar = new JMenuBar();
		drawingPan = new DrawingPanel();
		
		//Create Figure menu, initialize objects, make the items functionable then add them to Figure menu
		/*
		 * These are the items of this menu;
		 * Straight Line
		 * Rectangle
		 * Oval
		 * Round Rectangle
		 * Filled Rectangle
		 * Filled Oval
		 */
		figure_menu = new JMenu("Figure");
		straight_line = new JMenuItem("Straight Line");
		straight_line.addActionListener(this);
		rectangle = new JMenuItem("Rectangle");
		rectangle.addActionListener(this);
		oval = new JMenuItem("Oval");
		oval.addActionListener(this);
		round_rectangle = new JMenuItem("Round Rectangle");
		round_rectangle.addActionListener(this);
		filled_rectangle = new JMenuItem("Filled Rectangle");
		filled_rectangle.addActionListener(this);
		filled_oval = new JMenuItem("Filled Oval");
		filled_oval.addActionListener(this);
		figure_menu.add(straight_line);
		figure_menu.add(rectangle);
		figure_menu.add(oval);
		figure_menu.add(round_rectangle);
		figure_menu.add(filled_rectangle);
		figure_menu.add(filled_oval);
		
		//Create Color menu
		color_menu = new JMenu("Color");
		//Create Foreground submenu, initialize objects, make the items functionable then add them to Foreground menu.
		/*
		 * These are the items of this menu;
		 * Black
		 * Blue
		 * Cyan
		 * Green
		 * Magenta
		 * Red
		 */
		foreground = new JMenu("Foreground");
		black_1 = new JMenuItem("Black");
		black_1.addActionListener(this);
		blue_1 = new JMenuItem("Blue");
		blue_1.addActionListener(this);
		cyan_1 = new JMenuItem("Cyan");
		cyan_1.addActionListener(this);
		green_1 = new JMenuItem("Green");
		green_1.addActionListener(this);
		magenta_1 = new JMenuItem("Magenta");
		magenta_1.addActionListener(this);
		red_1 = new JMenuItem("Red");
		red_1.addActionListener(this);
		foreground.add(black_1);
		foreground.add(blue_1);
		foreground.add(cyan_1);
		foreground.add(green_1);
		foreground.add(magenta_1);
		foreground.add(red_1);
		
		//Create Background submenu, initialize objects, make the items functionable then add them to Background menu
		/*
		 * These are the items of this menu;
		 * Black
		 * Blue
		 * Cyan
		 * Green
		 * Magenta
		 * Red
		 */
		background = new JMenu("Background");
		black_2 = new JMenuItem("Black ");
		black_2.addActionListener(this);
		blue_2 = new JMenuItem("Blue ");
		blue_2.addActionListener(this);
		cyan_2 = new JMenuItem("Cyan ");
		cyan_2.addActionListener(this);
		green_2 = new JMenuItem("Green ");
		green_2.addActionListener(this);
		magenta_2 = new JMenuItem("Magenta ");
		magenta_2.addActionListener(this);
		red_2 = new JMenuItem("Red ");
		red_2.addActionListener(this);
		background.add(black_2);
		background.add(blue_2);
		background.add(cyan_2);
		background.add(green_2);
		background.add(magenta_2);
		background.add(red_2);
		
		//Initialize clear item and make it functionable
		clear = new JMenuItem("Clear");
		clear.addActionListener(this);
		
		//Add all the submenus to the Color menu
		color_menu.add(foreground);
		color_menu.add(background);
		color_menu.add(clear);
		
		//Create the font menu 
		font_menu = new JMenu("Font");
		//Create Style submenu, initialize objects, make the items functionable then add them to Style menu
		 /*
		 * These are the items of this menu;
		 * Bold
		 * Italics
		 */
		style = new JMenu("Style");
		bold = new JCheckBoxMenuItem("Bold");
		bold.addActionListener(this);
		italics = new JCheckBoxMenuItem("Italics");
		italics.addActionListener(this);
		style.add(bold);
		style.add(italics);
		
		//Create Size submenu, initialize objects, make the items functionable then add them to Size menu
		 /*
		 * These are the items of this menu;
		 * Size 10
		 * Size 20
		 * Size 72
		 */
		size = new JMenu("Size");
		size_10 = new JMenuItem("Size 10");
		size_10.addActionListener(this);
		size_20 = new JMenuItem("Size 20");
		size_20.addActionListener(this);
		size_72 = new JMenuItem("Size 72");
		size_72.addActionListener(this);
		size.add(size_10);
		size.add(size_20);
		size.add(size_72);
		font_menu.add(style);
		font_menu.add(size);
		
		//Create the text area and set the font of the text area
		user_text_area = new JTextArea("", 5, 30);
		f = new Font(Font.SERIF, fstyle, fsize);
		user_text_area.setFont(f);
		
		//Create Info submenu, initialize objects, make the items functionable then add them to Info menu
		info_menu = new JMenu("Info");
		version = new JMenuItem("Version");
		version.addActionListener(this);
		info_menu.add(version);
		
		//Create a scroll panel for the text area and add both scroll panel and text area to text panel
		JScrollPane jsp = new JScrollPane(user_text_area);
		jsp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		textPan = new JPanel();
		textPan.add(jsp);
		
		//Add Figure, Color, Font and Info menu to the Bar
		bar.add(figure_menu);
		figure_menu.addSeparator();
		bar.add(color_menu);
		color_menu.addSeparator();
		bar.add(font_menu);
		info_menu.addSeparator();
		bar.add(info_menu);
		
		//Add Bar, Text Area and Drawing Panel to this frame
		this.setJMenuBar(bar);
		this.add(textPan, BorderLayout.NORTH);
		this.add(drawingPan);
	}
	//actionPerformed method that handles the action of every button
	@Override
	public void actionPerformed(ActionEvent e) {
		//Determine the action for every button
		switch (e.getActionCommand())
		{
		//If one of the shapes has been selected draw the selected shape
		case "Straight Line": x = 1;	drawingPan.repaint(); break;
		case "Rectangle": x = 2;	    drawingPan.repaint(); break;
		case "Oval": x = 3;	            drawingPan.repaint(); break;
		case "Round Rectangle":	x = 4;	drawingPan.repaint(); break;
		case "Filled Rectangle": x = 5;	drawingPan.repaint(); break;
		case "Filled Oval":	x = 6;	    drawingPan.repaint(); break;
		//If the user wants to select color for each shape then color the object based on
		//selected color
		case "Black": c = 1;	        drawingPan.repaint(); break;
		case "Blue": c = 2;	            drawingPan.repaint(); break;
		case "Cyan": c = 3;	            drawingPan.repaint(); break;
		case "Green": c = 4;	        drawingPan.repaint(); break;
		case "Magenta":	c = 5;	        drawingPan.repaint(); break;
		case "Red":	c = 6;	            drawingPan.repaint(); break;
		//If the user wants to set the background to various colors then color the
		//background based on the color
		case "Black ": b = 1;	        drawingPan.repaint(); break;
		case "Blue ": b = 2;	        drawingPan.repaint(); break;
		case "Cyan ": b = 3;	        drawingPan.repaint(); break;
		case "Green ": b = 4;	        drawingPan.repaint(); break;
		case "Magenta ": b = 5;	        drawingPan.repaint(); break;
		case "Red ": b = 6;	            drawingPan.repaint(); break;
		//If the user wants to make the text bold or italics then change the
		//text based on the selected font
		case "Bold": case "Italics":
			fstyle = 0;
            if (bold.isSelected()) fstyle += Font.BOLD;
            if (italics.isSelected()) fstyle += Font.ITALIC;
			f = new Font(Font.SERIF, fstyle, fsize);
			user_text_area.setFont(f); break;
		//Select various sizes based on the user`s selection which are size 10, size 20 and size 72
		case "Size 10":
			fsize = 10;
			f = new Font(Font.SERIF, fstyle, fsize);						 
			user_text_area.setFont(f); break;
		case "Size 20":
			 fsize = 20;
			 f = new Font(Font.SERIF, fstyle, fsize);						 
			 user_text_area.setFont(f); break;
		case "Size 72":
			 fsize = 52;
			 f = new Font(Font.SERIF, fstyle, fsize);						 
			 user_text_area.setFont(f); break;
		//As the user presses Clear button set everything to the default and clear drawing panel and text area
		case "Clear":
			b = 7;
			c = 7;
			x = 7;
			drawingPan.repaint();
			fsize = 20;
			fstyle = 0;						 
			user_text_area.setText("");
			f = new Font(Font.SERIF, fstyle, fsize);
			user_text_area.setFont(f);
			bold.setSelected(false);
			italics.setSelected(false);
			break;
		//As the user presses "Version" button it will display the version of this program
		case "Version":
			JOptionPane.showMessageDialog(null, "X Painter for Bus X OS: Version 0.1 Beta",
					 "Version",JOptionPane.INFORMATION_MESSAGE);
			break;
		}
	} 
	//this is the DrawingPanel inner class inherits from JPanel, implements MouseListener and MouseMotionListener methods	
	public class DrawingPanel extends JPanel implements MouseListener, MouseMotionListener{
		//Initialize variables for the postions that will be based on what the user will click
		private int x1Pos=0, y1Pos=0, x2Pos=0, y2Pos=0;

		//Constructor of the DrawingPanel inner class
		public DrawingPanel()
		{
			//inherit other methods from JPanel
			super();
			//Set size to 500X500
			this.setSize(500, 500);
			//Set color to Yellow
			this.setBackground(Color.YELLOW);
			//Enable MouseListener and MouseMotionListener
			this.addMouseListener(this);
			this.addMouseMotionListener(this);
		}
		
		public void paintComponent(Graphics g) {
			//Initialize paintComponent with Super
			super.paintComponent(g);
			
			//If the signal recieved from Background and Clear buttons equavalent to one of 
			//these integers then set them
			switch (b) {
			case 1:	this.setBackground(Color.BLACK); break;
			case 2:	this.setBackground(Color.BLUE); break;
			case 3:	this.setBackground(Color.CYAN); break;
			case 4:	this.setBackground(Color.GREEN); break;
			case 5:	this.setBackground(Color.MAGENTA); break;
			case 6:	this.setBackground(Color.RED); break;
			case 7:	this.setBackground(Color.YELLOW); break;
			}
			
			//If the signal recieved from Foreground and Clear buttons equavalent to one of 
			//these integers then set them
			switch (c) {
			case 1:	g.setColor(Color.BLACK); break;
			case 2:	g.setColor(Color.BLUE); break;
			case 3:	g.setColor(Color.CYAN); break;
			case 4:	g.setColor(Color.GREEN); break;
			case 5:	g.setColor(Color.MAGENTA); break;
			case 6:	g.setColor(Color.RED); break;
			case 7: g.setColor(Color.BLACK); break;
			}
			
			//If the signal recieved from one of the shape buttons, draw the selected shape to the panel
			switch (x) {
			case 1:	g.drawLine(x1Pos, y1Pos, x2Pos, y2Pos); break;
			case 2:	g.drawRect(x1Pos, y1Pos, x2Pos, y2Pos); break;
			case 3:	g.drawOval(x1Pos, y1Pos, x2Pos, y2Pos); break;
			case 4:	g.drawRoundRect(x1Pos, y1Pos, x2Pos, y2Pos, 20, 30); break;
			case 5:	g.fillRect(x1Pos, y1Pos, x2Pos, y2Pos); break;
			case 6:	g.fillOval(x1Pos, y1Pos, x2Pos, y2Pos); break;
			case 7: g.dispose();
			}
		}
		//As the user drags the mouse change positions
		@Override
		public void mouseDragged(MouseEvent e) {
			x2Pos = e.getX();
			y2Pos = e.getY();
			repaint();
		}

		//Extra method
		@Override
		public void mouseMoved(MouseEvent e) {}

		//Extra method
		@Override
		public void mouseClicked(MouseEvent e) {}

		//As the user presses and releases somewhere change the variables as well
		@Override
		public void mousePressed(MouseEvent e) {
			x1Pos = e.getX();
			y1Pos = e.getY();
			repaint();
		}

		//Extra method
		@Override
		public void mouseReleased(MouseEvent e) {}
		
		//Extra method
		@Override
		public void mouseEntered(MouseEvent e) {}

		//Extra method
		@Override
		public void mouseExited(MouseEvent e) {}

	}
}
