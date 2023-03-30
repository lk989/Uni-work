package guiInterface;

import GamesCompanySystem.*;
import java.awt.*;
import java.io.File;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class FirstFrame implements ActionListener{
	//objects
	Online customerOnline = new Online();
	Stores customerStores = new Stores();
	AdministrationLogin admin = new AdministrationLogin();
	
	//attributes
	JFrame frame;
	JLabel toyStore, welcome, image;
	ImageIcon icon;
	Font newFont, briefRiver60, briefRiver25, alantaRosery;
	JRadioButton administration, customer;
	JLayeredPane layers;
	JPanel background;
	JTextField username, name, phoneNumber;
	JPasswordField password;
	JButton submit, done;
	JLabel user, pass, nameLabel, phone, phoneError, adminError;
	JPanel administrationBox, customerBox;
	String storename, storephone, adminName, adminPass;
	
	//constructor
	public FirstFrame() {}	
	
	public void createFrame() {
		//------------addedFonts----------
		briefRiver60 = addFont("Brief River.ttf", 60f);
		briefRiver25 = addFont("Brief River.ttf", 25f);
		alantaRosery = addFont("Alanta Rosery.otf", 15f);
		
		//--------------Frame--------------
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1000,500);
		frame.setLayout(new BorderLayout());
		
		ImageIcon icon = new ImageIcon("Photos//mainIcon30.png");
		frame.setIconImage(icon.getImage());
		
		background = new JPanel();
		background.setSize(1000,500);
		background.setBackground(new Color(0xFCEFEF));
		
		//--------------Welcome------------
		welcome = new JLabel("Welcome to our ");
		welcome.setFont(briefRiver25);
		welcome.setForeground(new Color(0x8D1A4B));
		welcome.setBounds(450,50,200,70);
		
		//--------------toyStore-----------
		toyStore = new JLabel("Toy Store <3");
		toyStore.setFont(briefRiver60);
		toyStore.setForeground(new Color(0x8D1A4B));
		toyStore.setBounds(530,100,375,90);

		//--------------icon---------------
		icon = new ImageIcon("Photos//2.png");
		image = new JLabel();
		image.setIcon(icon);
		image.setBounds(-30,60,600,400);
		
		//-----------radioButtons------------
		administration = new JRadioButton("Administration");
		administration.setBackground(new Color(0xFCEFEF));
		administration.setBounds(630,215,140,30);
		administration.setFont(alantaRosery);
		administration.setForeground(new Color(0x0C1647));
		administration.setFocusable(false);
		
		customer = new JRadioButton("Customer");
		customer.setBackground(new Color(0xFCEFEF));
		customer.setBounds(770,215,100,30);
		customer.setFont(alantaRosery);
		customer.setForeground(new Color(0x0C1647));
		customer.setFocusable(false);
		
		ButtonGroup group = new ButtonGroup();
		group.add(administration);
		group.add(customer);
		
		administration.addActionListener(this);
		customer.addActionListener(this);
		
		//-----------boxes--------------
		administrationBox = new JPanel();
		administrationBox.setLayout(null);
		administrationBox.setBounds(635,250,250,200);
		administrationBox.setBackground(new Color(0xFCEFEF));
		administrationBox.setVisible(false);
		administrationLogin();
		
		customerBox = new JPanel();
		customerBox.setLayout(null);
		customerBox.setBounds(635,250,250,200);
		customerBox.setBackground(new Color(0xFCEFEF));
		customerBox.setVisible(false);
		customerLogin();
		
		//-----------layers-------------
		layers = new JLayeredPane();
		layers.add(customerBox, Integer.valueOf(2));
		layers.add(administrationBox, Integer.valueOf(2));
		layers.add(customer, Integer.valueOf(1));
		layers.add(administration, Integer.valueOf(1));
		layers.add(welcome, Integer.valueOf(1));
		layers.add(toyStore, Integer.valueOf(1));
		layers.add(image, Integer.valueOf(1));	
		layers.add(background, Integer.valueOf(0));	
		
		//-----------allTogether----------
		frame.add(layers);
		frame.setVisible(true);
	}
	
	//this method adds fonts
	public static Font addFont(String fontName, float fontSize) {
		Font newFont = null;
		try {
			newFont = Font.createFont(Font.TRUETYPE_FONT, new File(fontName)).deriveFont(fontSize);
		}
		catch(Exception e) {
			System.out.println("The file doesn't exist");
		}
		return newFont;
	}

	//this method is used when the user clicks the administration button
	private void administrationLogin() {
		//adjust the settings
		username = new JTextField();
		username.setBounds(100,20,120,30);
		administrationBox.add(username);
		
		user = new JLabel("Username:");
		user.setBounds(20,15,100,30);
		user.setFont(alantaRosery);
		user.setForeground(new Color(0x0C1647));
		administrationBox.add(user);
		
		password = new JPasswordField();
		password.setBounds(100,65,120,30);
		administrationBox.add(password);
		
		pass = new JLabel("Password:");
		pass.setBounds(20,60,100,30);
		pass.setFont(alantaRosery);
		pass.setForeground(new Color(0x0C1647));
		administrationBox.add(pass);
		
		submit = new JButton();
		submit.setText("Login");
		submit.setBounds(80,120,90,30);	
		submit.setFocusable(false);
		submit.addActionListener(this);
		administrationBox.add(submit);
		
		//possible errors
		adminError = new JLabel("Incorrect username or password!!");
		adminError.setBounds(20,70,300,70);
		adminError.setBackground(Color.black);
		adminError.setForeground(Color.red);
		administrationBox.add(adminError);
		adminError.setVisible(false);
	}
	
	//this method is used when the user clicks the customer button
	private void customerLogin() {
		//adjust some settings
		name = new JTextField();
		name.setBounds(120,20,110,30);
		customerBox.add(name);
		
		nameLabel = new JLabel("Name:");
		nameLabel.setBounds(68,20,100,30);
		nameLabel.setFont(alantaRosery);
		nameLabel.setForeground(new Color(0x0C1647));
		customerBox.add(nameLabel);
		
		phoneNumber = new JTextField();
		phoneNumber.setBounds(120,60,110,30);
		customerBox.add(phoneNumber);
		
		phone = new JLabel("Phone Number:");
		phone.setBounds(10,60,100,30);
		phone.setFont(alantaRosery);
		phone.setForeground(new Color(0x0C1647));
		customerBox.add(phone);
		
		done = new JButton();
		done.setText("Done (;");
		done.setBounds(80,120,90,30);
		done.setFocusable(false);
		customerBox.add(done);

		phoneError = new JLabel("Invalid number, enter (05xxxxxxxx)");
		phoneError.setBounds(15,70,300,70);
		phoneError.setBackground(Color.black);
		phoneError.setForeground(Color.red);
		customerBox.add(phoneError);
		phoneError.setVisible(false);
		
		done.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == administration) {
			customerBox.setVisible(false);
			administrationBox.setVisible(true);
		}
        else if (e.getSource() == customer){
        	administrationBox.setVisible(false);
			customerBox.setVisible(true);
		}
        else if (e.getSource() == done) {
        	CustomerLogin login = new CustomerLogin();
        	storename = name.getText();
			login.setCustomerName("" + storename);
        	
        	//check if the number is valid
			if (phoneNumber.getText().length() == 10 &&
				phoneNumber.getText().charAt(0) == '0' &&
				phoneNumber.getText().charAt(1) == '5') {
	            	storephone = phoneNumber.getText();
	            	login.setCustomerPhone("" + storephone);
	            	frame.dispose();
	            	login.customerLoginFrame();
			}
			else {
				phoneError.setVisible(true);
			}
		}
        else if (e.getSource() == administration) {
			customerBox.setVisible(false);
			administrationBox.setVisible(true);
		}
        else if (e.getSource() == customer){
        	administrationBox.setVisible(false);
			customerBox.setVisible(true);
		}
        else if (e.getSource() == done) {
        	CustomerLogin login = new CustomerLogin();
        	frame.dispose();
        	storename = name.getText();
			login.setCustomerName("" + storename);
        	
        	storephone = phoneNumber.getText();
			login.setCustomerPhone("" + storephone);
        	login.customerLoginFrame();
        }
        else if (e.getSource() == submit){
        	if (username.getText().equals(AdministrationLogin.mainUserName) && password.getText().equals(AdministrationLogin.mainPass)) {
        		frame.dispose();
        		admin.adminLoggedIn();
        	}
        	else {
        		adminError.setVisible(true);
        	}
        }
	}
}

