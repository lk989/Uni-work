/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiInterface;

/**
 *
 * @author mrkn
 */
import GamesCompanySystem.Developers ;
import GamesCompanySystem.Marketer;
import GamesCompanySystem.Date;
import GamesCompanySystem.Games;
import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class AdministrationLogin implements ActionListener, ItemListener{
    
    // These are all the variables needed in the Administration part
    
    ArrayList<Games> game = new ArrayList<Games>();
    ImageIcon icon ;
    static Choice sexChoice, dayChoice, mounthChoice, yearChoice, depChoice, ch, typeChoice, ageChoice ;
    final ArrayList<String> wordlist = new ArrayList<String>();
    int i=0 ;
    ArrayList<Developers> dev = new ArrayList<Developers>();
    ArrayList<Marketer> mar = new ArrayList<Marketer>();
    JTable info, emp ;
    Font discoSociety, alantaRosery, alantaRoserySmall;
    JLabel firstName, lastName, userName, sex, date, oldPass, wrongPass, newPass, empName, labelLabel, empID, 
            empSalary, empDate, empDep, devEmp, marEmp, empErr, labelLabel2, image, gameName, gamePrice, gameAge, gameType, gameErr;
    JFrame frame2, newPassFrame, infoFrame, empFrame, empInfoFrame;
    JPanel background2 ,infoPanel, newPassPanel, empPanel, empInfoPanel, gamePanel;
    JLayeredPane adminLayers ;
    JTextField firstNameField, lastNameField, userNameField, oldPassField, newPassField, empNameField, empIDField, 
            empSalaryField, devEmpField, marEmpField, gameNameField, gamePriceField, gameAgeField ;
    JButton information, employees, games, logout, saveChanges, ok, show, savePass, addEmp, showEmp, addGame ;
    ImageIcon mainicon = new ImageIcon("Photos//mainIcon30.png");
    boolean checkPass, checkInform, checkEmp, checkGam, checkDep, checkMar, checkEmpErr, checkGameErr ;
    static String mainName = "Peter" , mainPass = "123", mainLast = "", mainUserName = "Peter", mainSex = "";
    static Date mainDate = new Date(4,1,1988);
    
    // this method will run when the login button is pressed 
    
    public void adminLoggedIn(){
        
            // Fonts
            discoSociety = FirstFrame.addFont("Disco Society.otf", 80);
            alantaRosery = FirstFrame.addFont("Alanta Rosery.otf", 20);
            alantaRoserySmall = FirstFrame.addFont("Alanta Rosery.otf", 13);
            
            
            // New Frame
            frame2 = new JFrame("Administration");
            frame2.setSize(1000,500);
            frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            adminLayers = new JLayeredPane();
            frame2.setIconImage(mainicon.getImage());
            
            // New Panel and background
            background2 = new JPanel();
            background2.setSize(1000,500);
            background2.setBackground(new Color(0xFCEFEF));
            background2.setLayout(new BorderLayout());
            frame2.add(background2);
            
            // ana icon
            icon = new ImageIcon("Photos//game icon.jpeg");
            image = new JLabel();
            image.setIcon(icon);
            image.setBounds(350, 70, 300, 300);
            background2.add(image);
            
            // The main buttons to have in the main page
            // button 1 
            information = new JButton("My Info");
            information.setFont(alantaRosery);
            information.setBackground(new Color(0xc45c5c));
            information.setForeground(Color.white);
            information.setBounds(0, 60, 150, 50);
            background2.add(information);
            information.addActionListener(this);
            
            dev.add(new Developers("Owen", 334623, "Developer", 5000, new Date(1, 4, 1997), 34));
            dev.add(new Developers("Derrick", 998373, "Developer", 6500, new Date(6, 2, 1990), 41));
            mar.add(new Marketer("Maria", 644330, "Marketer", 5250, new Date(12, 1, 1987), 29));
            mar.add(new Marketer("Lara", 221445, "Marketer", 6050, new Date(13, 12, 1988), 30));
            
            //button 2
            employees = new JButton("Employees");
            employees.setFont(alantaRosery);
            employees.setBackground(new Color(0xc45c5c));
            employees.setForeground(Color.white);
            employees.setBounds(0, 120, 150, 50);
            background2.add(employees);
            employees.addActionListener(this);
               
            // button 3
            games = new JButton("Games");
            games.setFont(alantaRosery);
            games.setBackground(new Color(0xc45c5c));
            games.setForeground(Color.white);
            games.setBounds(0, 180, 150, 50);
            background2.add(games);
            games.addActionListener(this);
                           
            // button 4
            logout = new JButton("Logout");
            logout.setFont(alantaRosery);
            logout.setBackground(new Color(0xc45c5c));
            logout.setForeground(Color.white);
            logout.setBounds(0, 240, 150, 50);
            background2.add(logout);
            logout.addActionListener(this);
            
            // add everything as layers
            adminLayers.add(logout, Integer.valueOf(2));
            adminLayers.add(games, Integer.valueOf(2));
            adminLayers.add(employees, Integer.valueOf(2));
            adminLayers.add(information, Integer.valueOf(2));
            adminLayers.add(background2, Integer.valueOf(1));
            
            frame2.add(adminLayers);
		
            frame2.setVisible(true);
    }

    @Override
    // actions when each button is pressed
    public void actionPerformed(ActionEvent e) {
        // if "information" is pressed
        if (e.getSource() == information ) {
            checkInform = true ;
            if(checkEmp)
                empPanel.setVisible(false);
            if(checkGam)
                gamePanel.setVisible(false);
            information();
            
        }
        // if "employees" is pressed
        else if (e.getSource() == employees ) {
            checkEmp = true ;
            if(checkInform)
                infoPanel.setVisible(false);
            if(checkGam)
                gamePanel.setVisible(false);
            employee();
        }
        // if "games" is pressed
        else if (e.getSource() == games ) {
            checkGam = true ;
            if(checkInform)
                infoPanel.setVisible(false);
            if(checkEmp)
                empPanel.setVisible(false);
            games();
        }
        // if "logout" is pressed
        else if (e.getSource() == logout) {
            frame2.dispose();
            FirstFrame frame = new FirstFrame();
		frame.createFrame();
        }
        // now this button is when the admin wantss to change any of his information
        else if (e.getSource() == saveChanges){
            if(firstNameField.getText().equals("")){
            
            }
            else{
                mainName = firstNameField.getText();
            }
            if(lastNameField.getText().equals("")){
            }
            else{
                mainLast = lastNameField.getText();
                
            }
            if(userNameField.getText().equals("")){
            }
            else{
                mainUserName = userNameField.getText();
                
            }
            if(dayChoice.getSelectedItem().equals("Day") && mounthChoice.getSelectedItem().equals("Mon") && yearChoice.getSelectedItem().equals("Year")){
            }
            else{
                mainDate.setDay(Integer.valueOf(dayChoice.getSelectedItem()));
                mainDate.setMonth(Integer.valueOf(mounthChoice.getSelectedItem()));
                mainDate.setYear(Integer.valueOf(yearChoice.getSelectedItem()));
            }
            if(sexChoice.getSelectedItem().equals("Choose")){
            
            }
            else{
                mainSex = sexChoice.getSelectedItem();
            }
            
        }
        // this button is for changing the password 
        else if (e.getSource() == ok ){
            if(oldPassField.getText().equals(mainPass)){
                
                if(checkPass){
                   infoPanel.remove(wrongPass); 
                }
                
                frame2.add(infoPanel);    
                adminLayers.add(infoPanel, Integer.valueOf(2));
                frame2.add(adminLayers);
                frame2.setVisible(true);
                
                newPassFrame = new JFrame("New Password");
                newPassFrame.setBounds(250, 250, 300, 200);
                newPassPanel = new JPanel();
                newPassPanel.setLayout(null);
                newPassPanel.setBackground(new Color(0xFCEFEF));
                
                newPass = new JLabel("Change Password"); 
                newPass.setForeground(Color.gray);
                newPass.setBounds(10, 10, 100, 20);
                newPass.setFont(alantaRoserySmall);
                newPassPanel.add(newPass);
        
                newPassField = new JTextField();
                newPassField.setBounds(10, 40, 190, 30);
                newPassPanel.add(newPassField);
                
                savePass = new JButton("Save");
                savePass.setBackground(Color.lightGray);
                savePass.setForeground(Color.white);
                savePass.setBounds(120, 80, 80, 30);
                savePass.setFont(alantaRoserySmall);
                newPassPanel.add(savePass);
                savePass.addActionListener(this);
                
                newPassFrame.add(newPassPanel);
                newPassFrame.setVisible(true);
                
                
            }
            else{
                checkPass = true ;
                wrongPass = new JLabel("You Entered A Wrong Password");
                wrongPass.setForeground(Color.red);
                wrongPass.setBounds(150, 260, 200, 20);
                infoPanel.add(wrongPass);
                frame2.add(infoPanel);    
                adminLayers.add(infoPanel, Integer.valueOf(2));
        
                frame2.add(adminLayers);
		
                frame2.setVisible(true);
            }
        }
        // this shows the information of the admin 
        else if (e.getSource() == show ){
            showInfo();
        }
        // this is for saving the password
        else if (e.getSource() == savePass ){
            mainPass = newPassField.getText() ;
            newPassFrame.setVisible(false);
            
        }
        // here if we awnted to add an employee and it will check if all field are filled
        else if (e.getSource() == addEmp ){
            if(empNameField.getText().equals("") || empIDField.getText().equals("") || empSalaryField.getText().equals("") || depChoice.getSelectedItem().equals("Choose") ||
                    dayChoice.getSelectedItem().equals("Day") || mounthChoice.getSelectedItem().equals("Mon") || yearChoice.getSelectedItem().equals("Year")){
                checkEmpErr = true ;
                checkPass = true ;
                empErr = new JLabel("You Did Not Fill All Fields");
                empErr.setForeground(Color.red);
                empErr.setBounds(210, 230, 200, 20);
                empPanel.add(empErr);
                frame2.add(empPanel);    
                adminLayers.add(empPanel, Integer.valueOf(2));
        
                frame2.add(adminLayers);
		
                frame2.setVisible(true);
            }
            else{
                if(checkEmpErr){
                    empPanel.remove(empErr); 
                    frame2.add(empPanel);    
                    adminLayers.add(empPanel, Integer.valueOf(2));
        
                    frame2.add(adminLayers);
		
                    frame2.setVisible(true);
                }
                // addEmp(String name, String ID, String dep, String salary, String day, String mon, String year, String hourOrgross)
                switch (depChoice.getSelectedItem()) {
                    case "Developer":
                        addEmp(empNameField.getText(), empIDField.getText(), depChoice.getSelectedItem(), empSalaryField.getText(), dayChoice.getSelectedItem(), mounthChoice.getSelectedItem(),yearChoice.getSelectedItem(), devEmpField.getText());
                        devEmpField.setText(null);
                        break;
                    case "Marketer":
                        addEmp(empNameField.getText(), empIDField.getText(), depChoice.getSelectedItem(), empSalaryField.getText(), dayChoice.getSelectedItem(), mounthChoice.getSelectedItem(),yearChoice.getSelectedItem(), marEmpField.getText());
                        marEmpField.setText(null);
                        break;
                }
                empNameField.setText(null);
                empIDField.setText(null);
                empSalaryField.setText(null);
            }
        }
        // this shows the employees
        else if (e.getSource() == showEmp ){
            showEmployees(dev.size()+mar.size());
        }
        // same for games 
        else if (e.getSource() == addGame ){
            if(gameNameField.getText().equals("")||gamePriceField.getText().equals("")||ageChoice.getSelectedItem().equals("Choose")||typeChoice.getSelectedItem().equals("Choose")){
                checkGameErr = true ;
                gameErr = new JLabel("You Did Not Fill All Fields");
                gameErr.setForeground(Color.red);
                gameErr.setBounds(150, 300, 200, 20);
                gamePanel.add(gameErr);
                frame2.add(gamePanel);    
                adminLayers.add(gamePanel, Integer.valueOf(2));
        
                frame2.add(adminLayers);
		
                frame2.setVisible(true);
            }
            else{
                if(checkGameErr){
                    gamePanel.remove(gameErr); 
                    frame2.add(gamePanel);    
                    adminLayers.add(gamePanel, Integer.valueOf(2));
        
                    frame2.add(adminLayers);
		
                    frame2.setVisible(true);
                }
                // public Games(String n, double p, int a, double r, String t)
                game.add(new Games(gameNameField.getText(),Double.valueOf(gamePriceField.getText()),Integer.valueOf(ageChoice.getSelectedItem()),0.0,typeChoice.getSelectedItem(),0));
                gameNameField.setText(null);
                gamePriceField.setText(null);
                
            }
        }
    }
    @Override
    // this method will do actions based on what he user choose ... developer or marketer
    public void itemStateChanged(ItemEvent e)
    {
        switch (depChoice.getSelectedItem()) {
            case "Developer":
                checkDep = true ;
                if(checkMar){
                    empPanel.remove(marEmp);
                    empPanel.remove(marEmpField);
                }
                devEmp = new JLabel("Hours worked");
                devEmp.setForeground(Color.gray);
                devEmp.setBounds(410, 180, 150, 20);
                devEmp.setFont(alantaRoserySmall);
                empPanel.add(devEmp);
                devEmpField = new JTextField();
                devEmpField.setBounds(410, 200, 110, 30);
                empPanel.add(devEmpField);
                break;
            case "Marketer":
                checkMar = true ;
                if(checkDep){
                    empPanel.remove(devEmp);
                    empPanel.remove(devEmpField);
                }
                marEmp = new JLabel("Gross Sales");
                marEmp.setForeground(Color.gray);
                marEmp.setBounds(410, 180, 150, 20);
                marEmp.setFont(alantaRoserySmall);
                empPanel.add(marEmp);
                marEmpField = new JTextField();
                marEmpField.setBounds(410, 200, 110, 30);
                empPanel.add(marEmpField);
                break;
        }
        frame2.add(empPanel);    
        adminLayers.add(empPanel, Integer.valueOf(2));
        
        frame2.add(adminLayers);
		
        frame2.setVisible(true);
    }
    // this method will be excuted when the information button is pressed
    public void information( ){
        
        // new panel
        infoPanel = new JPanel();
        infoPanel.setLayout(null);
        infoPanel.setBounds(60, 0, 900,500);
        infoPanel.setBackground(new Color(0xFCEFEF));
        
        
        // add an icon
        icon = new ImageIcon("Photos//game folder.jpeg");
	image = new JLabel();
	image.setIcon(icon);
	image.setBounds(830,25,60,60);
        infoPanel.add(image);
          
        // add a label
        firstName = new JLabel("Change First Name");
        firstName.setForeground(Color.gray);
        firstName.setBounds(150, 50, 150, 20);
        firstName.setFont(alantaRoserySmall);
        infoPanel.add(firstName);
        
        // add a field
        firstNameField = new JTextField();
        firstNameField.setBounds(150, 70, 150, 30);
        infoPanel.add(firstNameField);
        
        // another label
        lastName = new JLabel("Change Last Name"); 
        lastName.setForeground(Color.gray);
        lastName.setBounds(350, 50, 150, 20);
        lastName.setFont(alantaRoserySmall);
        infoPanel.add(lastName);
        
        // a field
        lastNameField = new JTextField();
        lastNameField.setBounds(350, 70, 150, 30);
        infoPanel.add(lastNameField);
        
        //label
        date = new JLabel("Change Date Of Birth"); 
        date.setForeground(Color.gray);
        date.setBounds(550, 50, 150, 20);
        infoPanel.add(date);
        
        // this makes the user choose between different things
        dayChoice = new Choice();
        dayChoice.setBounds(550, 70, 60, 30);
        dayChoice.add("Day"); dayChoice.add("1"); dayChoice.add("2"); dayChoice.add("3"); dayChoice.add("4"); dayChoice.add("5"); dayChoice.add("6"); dayChoice.add("7"); dayChoice.add("8"); 
        dayChoice.add("9"); dayChoice.add("10"); dayChoice.add("11"); dayChoice.add("12"); dayChoice.add("13"); dayChoice.add("14"); dayChoice.add("15"); dayChoice.add("16"); dayChoice.add("17"); 
        dayChoice.add("18"); dayChoice.add("19"); dayChoice.add("20"); dayChoice.add("21"); dayChoice.add("22"); dayChoice.add("23"); dayChoice.add("24"); dayChoice.add("25"); dayChoice.add("26"); 
        dayChoice.add("27"); dayChoice.add("28"); dayChoice.add("29"); dayChoice.add("30"); dayChoice.add("31"); 
        infoPanel.add(dayChoice);
        
        // same here
        mounthChoice = new Choice();
        mounthChoice.setBounds(620, 70, 60, 30);
        mounthChoice.add("Mon"); mounthChoice.add("1"); mounthChoice.add("2"); mounthChoice.add("3"); mounthChoice.add("4"); mounthChoice.add("5"); mounthChoice.add("6"); 
        mounthChoice.add("7"); mounthChoice.add("8"); mounthChoice.add("9"); mounthChoice.add("10"); mounthChoice.add("11"); mounthChoice.add("12"); 
        infoPanel.add(mounthChoice);
        
        // and here
        yearChoice = new Choice();
        yearChoice.setBounds(690, 70, 60, 30);
        yearChoice.add("Year");
        for(int i= 2010 ; i>=1850 ; i-- ){
            yearChoice.add(String.valueOf(i));
        }
        infoPanel.add(yearChoice);
        
        // a label
        userName = new JLabel("Change User Name"); 
        userName.setForeground(Color.gray);
        userName.setBounds(150, 120, 200, 20);
        userName.setFont(alantaRoserySmall);
        infoPanel.add(userName);
        
        // a field
        userNameField = new JTextField();
        userNameField.setBounds(150, 140, 200, 30);
        infoPanel.add(userNameField);
        
        // a label
        sex = new JLabel("Change Sex"); 
        sex.setForeground(Color.gray);
        sex.setBounds(400, 120, 80, 20);
        sex.setFont(alantaRoserySmall);
        infoPanel.add(sex);
        
        // another choice
        sexChoice = new Choice();
        sexChoice.setBounds(400, 140, 80, 30);
        sexChoice.add("Choose");
        sexChoice.add("Male");
        sexChoice.add("Female");
        infoPanel.add(sexChoice);
        
        // label
        oldPass = new JLabel("Write Your Old Password To Change It");
        oldPass.setForeground(Color.gray);
        oldPass.setBounds(150, 200, 250, 20);
        oldPass.setFont(alantaRoserySmall);
        infoPanel.add(oldPass);
        
        // field
        oldPassField = new JTextField();
        oldPassField.setBounds(150, 220, 250, 35);
        infoPanel.add(oldPassField);
        
        // a button for checking the password
        ok = new JButton("ok");
        ok.setBackground(new Color(0xd07d7d));
        ok.setForeground(Color.white);
        ok.setBounds(420, 220, 50, 30);
        ok.setFont(alantaRoserySmall);
        infoPanel.add(ok);
        ok.addActionListener(this);
        
        // a buttoun for saving the data of the admin
        saveChanges = new JButton("Save Changes");
        saveChanges.setBackground(new Color(0xd07d7d));
        saveChanges.setForeground(Color.white);
        saveChanges.setBounds(700, 350, 120, 30);
        saveChanges.setFont(alantaRoserySmall);
        infoPanel.add(saveChanges);
        saveChanges.addActionListener(this);
        
        // a button to show the information of the admin
        show = new JButton("Show Info");
        show.setBackground(new Color(0xd07d7d));
        show.setForeground(Color.white);
        show.setBounds(560, 350, 120, 30);
        show.setFont(alantaRoserySmall);
        infoPanel.add(show);
        show.addActionListener(this);
        
        // to make everything shows
        frame2.add(infoPanel);    
        adminLayers.add(infoPanel, Integer.valueOf(2));
        
        frame2.add(adminLayers);
		
        frame2.setVisible(true);
    }
    public void showInfo(){
        infoFrame = new JFrame();
        infoFrame.setIconImage(mainicon.getImage());
		// Frame Title
		infoFrame.setTitle("Information");
                infoFrame.setBackground(new Color(0xFCEFEF));

		// Data to be displayed in the JTable
		String[][] data = {
                        { "First Name", mainName },
			{ "Last Name", mainLast },
			{ "Date Of Birth", mainDate.toString() },
                        {"Sex", mainSex},
                        {"User Name", mainUserName}
		};

		// Column Names
		String[] columnNames = { "", "Data" };

		// Initializing the JTable
		info = new JTable(data, columnNames);
		info.setBounds(30, 40, 200, 300);
                info.setBackground(Color.white);
                info.setForeground(Color.darkGray);
                info.setGridColor(Color.black);

		// adding it to JScrollPane
		JScrollPane sp = new JScrollPane(info);
		infoFrame.add(sp);
		// Frame Size
		infoFrame.setSize(500, 170);
		// Frame Visible = true
		infoFrame.setVisible(true);
    }
    public void employee(){
        
        // new panel
        empPanel = new JPanel();
        empPanel.setLayout(null);
        empPanel.setBounds(0, 0, 1000,500);
        empPanel.setBackground(new Color(0xFCEFEF));
        
        // new icon
        icon = new ImageIcon("Photos//game folder.jpeg");
	image = new JLabel();
	image.setIcon(icon);
	image.setBounds(890,25,60,60);
        empPanel.add(image);
        
        // new label
        labelLabel = new JLabel("Fill All Blanks To Add An Employee");
        labelLabel.setForeground(new Color(0xb76979));
        labelLabel.setBounds(200,22 , 400, 25);
        labelLabel.setFont(alantaRosery);
        empPanel.add(labelLabel);
        
        // label
        empName = new JLabel("Employee Name");
        empName.setForeground(Color.gray);
        empName.setBounds(210, 60, 150, 20);
        empName.setFont(alantaRoserySmall);
        empPanel.add(empName);
        
        // field
        empNameField = new JTextField();
        empNameField.setBounds(210, 80, 150, 30);
        empPanel.add(empNameField);
        
        // label
        empDate = new JLabel("Employee Date Of Birth");
        empDate.setForeground(Color.gray);
        empDate.setBounds(410, 60, 200, 20);
        empDate.setFont(alantaRoserySmall);
        empPanel.add(empDate);
        
        // choice for days
        dayChoice = new Choice();
        dayChoice.setBounds(410, 80, 60, 30);
        dayChoice.add("Day"); dayChoice.add("1"); dayChoice.add("2"); dayChoice.add("3"); dayChoice.add("4"); dayChoice.add("5"); dayChoice.add("6"); dayChoice.add("7"); dayChoice.add("8"); 
        dayChoice.add("9"); dayChoice.add("10"); dayChoice.add("11"); dayChoice.add("12"); dayChoice.add("13"); dayChoice.add("14"); dayChoice.add("15"); dayChoice.add("16"); dayChoice.add("17"); 
        dayChoice.add("18"); dayChoice.add("19"); dayChoice.add("20"); dayChoice.add("21"); dayChoice.add("22"); dayChoice.add("23"); dayChoice.add("24"); dayChoice.add("25"); dayChoice.add("26"); 
        dayChoice.add("27"); dayChoice.add("28"); dayChoice.add("29"); dayChoice.add("30"); dayChoice.add("31"); 
        empPanel.add(dayChoice);
        
        // chioce for mounths
        mounthChoice = new Choice();
        mounthChoice.setBounds(480, 80, 60, 30);
        mounthChoice.add("Mon"); mounthChoice.add("1"); mounthChoice.add("2"); mounthChoice.add("3"); mounthChoice.add("4"); mounthChoice.add("5"); mounthChoice.add("6"); 
        mounthChoice.add("7"); mounthChoice.add("8"); mounthChoice.add("9"); mounthChoice.add("10"); mounthChoice.add("11"); mounthChoice.add("12"); 
        empPanel.add(mounthChoice);
        
        // choice for years
        yearChoice = new Choice();
        yearChoice.setBounds(550, 80, 60, 30);
        yearChoice.add("Year");
        for(int i= 2010 ; i>=1850 ; i-- ){
            yearChoice.add(String.valueOf(i));
        }
        empPanel.add(yearChoice);
        
        // label
        empID = new JLabel("Employee ID");
        empID.setForeground(Color.gray);
        empID.setBounds(210, 120, 150, 20);
        empID.setFont(alantaRoserySmall);
        empPanel.add(empID);
        
        //field
        empIDField = new JTextField();
        empIDField.setBounds(210, 140, 120, 30);
        empPanel.add(empIDField);
        
        //label
        empSalary = new JLabel("Employee Salary");
        empSalary.setForeground(Color.gray);
        empSalary.setBounds(210, 180, 150, 20);
        empSalary.setFont(alantaRoserySmall);
        empPanel.add(empSalary);
        
        //field
        empSalaryField = new JTextField();
        empSalaryField.setBounds(210, 200, 110, 30);
        empPanel.add(empSalaryField);
        
        //label
        empDep = new JLabel("Employee Department");
        empDep.setForeground(Color.gray);
        empDep.setBounds(410, 120, 150, 20);
        empDep.setFont(alantaRoserySmall);
        empPanel.add(empDep);
        
        //choice
        depChoice = new Choice();
        depChoice.setBounds(410, 140, 80, 30);
        depChoice.add("Choose");
        depChoice.add("Developer");
        depChoice.add("Marketer");
        empPanel.add(depChoice);
        ch = new Choice();
        depChoice.addItemListener(this);
        
        // button to show employees
        showEmp = new JButton("Show Employee");
        showEmp.setBackground(new Color(0xd07d7d));
        showEmp.setForeground(Color.white);
        showEmp.setBounds(560, 350, 140, 30);
        showEmp.setFont(alantaRoserySmall);
        empPanel.add(showEmp);
        showEmp.addActionListener(this);
        
        // button to add employees
        addEmp = new JButton("Add Employee");
        addEmp.setBackground(new Color(0xd07d7d));
        addEmp.setForeground(Color.white);
        addEmp.setBounds(730, 350, 120, 30);
        addEmp.setFont(alantaRoserySmall);
        empPanel.add(addEmp);
        addEmp.addActionListener(this);
        
        frame2.add(empPanel);    
        adminLayers.add(empPanel, Integer.valueOf(2));
        
        frame2.add(adminLayers);
		
        frame2.setVisible(true);
    }
    // to add an employee this method is used
    public void addEmp(String name, String ID, String dep, String salary, String day, String mon, String year, String hourOrGross){
        //public Developers(String name, int ID, String department, double salary, Date birth, double hours)
        //public Marketer(String name, int ID, String department, double salary, Date birth, double grossSales)
        if(dep.equals("Developer")){
            dev.add(new Developers(name, Integer.valueOf(ID), dep, Double.valueOf(salary), new Date(Integer.valueOf(day), Integer.valueOf(mon), Integer.valueOf(year)), Double.valueOf(hourOrGross)));
            
        }
        else if(dep.equals("Marketer")){
            mar.add(new Marketer(name, Integer.valueOf(ID), dep, Double.valueOf(salary), new Date(Integer.valueOf(day), Integer.valueOf(mon), Integer.valueOf(year)), Double.valueOf(hourOrGross)));
        }
        
    }
    //to show employees
    public void showEmployees(int a){
        empInfoFrame = new JFrame("Employees");
        empInfoFrame.setIconImage(mainicon.getImage());
            empInfoFrame.setSize(1000,500);
            
            // New Panel and background
            empInfoPanel = new JPanel();
            empInfoPanel.setSize(1300,500);
            empInfoPanel.setBackground(new Color(0xFCEFEF));
            empInfoPanel.setLayout(new BorderLayout());
            // adding employees to the list
        final ArrayList<String> wordlist = new ArrayList<String>();
        try{
            
            wordlist.add(String.format("%2s%30s%15s%19s%45s%20s","ID ","Department","Salary","Birth","Hours/Gross Sales","Name"));
            wordlist.add(String.format("%6d%20s%20.2f%20s%35.2f%31s",dev.get(0).getID(),dev.get(0).getDepartment(),dev.get(0).computeSalary(),dev.get(0).getBirth().toString(),dev.get(0).getHours(),dev.get(0).getName()));
            wordlist.add(String.format("%6d%20s%20.2f%20s%35.2f%33s",dev.get(1).getID(),dev.get(1).getDepartment(),dev.get(1).computeSalary(),dev.get(1).getBirth().toString(),dev.get(1).getHours(),dev.get(1).getName()));
            wordlist.add(String.format("%6d%20s%20.2f%20s%35.2f%33s",dev.get(2).getID(),dev.get(2).getDepartment(),dev.get(2).computeSalary(),dev.get(2).getBirth().toString(),dev.get(2).getHours(),dev.get(2).getName()));
            wordlist.add(String.format("%6d%20s%20.2f%20s%35.2f%33s",dev.get(3).getID(),dev.get(3).getDepartment(),dev.get(3).computeSalary(),dev.get(3).getBirth().toString(),dev.get(3).getHours(),dev.get(3).getName()));
            wordlist.add(String.format("%6d%20s%20.2f%20s%35.2f%33s",dev.get(4).getID(),dev.get(4).getDepartment(),dev.get(4).computeSalary(),dev.get(4).getBirth().toString(),dev.get(4).getHours(),dev.get(4).getName()));
            wordlist.add(String.format("%6d%20s%20.2f%20s%35.2f%33s",dev.get(5).getID(),dev.get(5).getDepartment(),dev.get(5).computeSalary(),dev.get(5).getBirth().toString(),dev.get(5).getHours(),dev.get(5).getName()));
        }
        catch(IndexOutOfBoundsException aa){
        }
        try{
            wordlist.add(String.format("%6d%20s%20.2f%20s%35.0f%34s",mar.get(0).getID(),mar.get(0).getDepartment(),mar.get(0).computeSalary(),mar.get(0).getBirth().toString(),mar.get(0).getGrossSales(),mar.get(0).getName()));
            wordlist.add(String.format("%6d%20s%20.2f%20s%35.0f%34s",mar.get(1).getID(),mar.get(1).getDepartment(),mar.get(1).computeSalary(),mar.get(1).getBirth().toString(),mar.get(1).getGrossSales(),mar.get(1).getName()));
            wordlist.add(String.format("%6d%20s%20.2f%20s%35.0f%34s",mar.get(2).getID(),mar.get(2).getDepartment(),mar.get(2).computeSalary(),mar.get(2).getBirth().toString(),mar.get(2).getGrossSales(),mar.get(2).getName()));
            wordlist.add(String.format("%6d%20s%20.2f%20s%35.0f%34s",mar.get(3).getID(),mar.get(3).getDepartment(),mar.get(3).computeSalary(),mar.get(3).getBirth().toString(),mar.get(3).getGrossSales(),mar.get(3).getName()));
            wordlist.add(String.format("%6d%20s%20.2f%20s%35.0f%34s",mar.get(4).getID(),mar.get(4).getDepartment(),mar.get(4).computeSalary(),mar.get(4).getBirth().toString(),mar.get(4).getGrossSales(),mar.get(4).getName()));
            wordlist.add(String.format("%6d%20s%20.2f%20s%35.0f%34s",mar.get(5).getID(),mar.get(5).getDepartment(),mar.get(5).computeSalary(),mar.get(5).getBirth().toString(),mar.get(5).getGrossSales(),mar.get(5).getName()));
        }
        catch(IndexOutOfBoundsException aa){
        }
        //so it could be shown in a scrollpane
        JList<String> displayList = new JList<>(wordlist.toArray(new String[0]));
        JScrollPane scrollPane = new JScrollPane(displayList);
        empInfoFrame.getContentPane().add(scrollPane);
        empInfoFrame.pack();
        empInfoFrame.setVisible(true);
    }
    // if the button games is pressed
    public void games(){
        
        // new panel
        gamePanel = new JPanel();
        gamePanel.setLayout(null);
        gamePanel.setBounds(60, 0, 900,500);
        gamePanel.setBackground(new Color(0xFCEFEF));
        
        // icon
        icon = new ImageIcon("6.png");
	image = new JLabel();
	image.setIcon(icon);
	image.setBounds(830,25,60,60);
        gamePanel.add(image);
        
        // label
        labelLabel2 = new JLabel("Fill All Blanks To Add A Game");
        labelLabel2.setForeground(new Color(0xb76979));
        labelLabel2.setBounds(140 ,22 ,400, 25);
        labelLabel2.setFont(alantaRosery);
        gamePanel.add(labelLabel2);
        
        // label
        gameName = new JLabel("Game Name");
        gameName.setForeground(Color.gray);
        gameName.setBounds(150, 60, 150, 20);
        gameName.setFont(alantaRoserySmall);
        gamePanel.add(gameName);
        
        //field
        gameNameField = new JTextField();
        gameNameField.setBounds(150, 80, 150, 30);
        gamePanel.add(gameNameField);
        
        //label
        gamePrice = new JLabel("Game Price");
        gamePrice.setForeground(Color.gray);
        gamePrice.setBounds(150, 120, 150, 20);
        gamePrice.setFont(alantaRoserySmall);
        gamePanel.add(gamePrice);
        
        //field
        gamePriceField = new JTextField();
        gamePriceField.setBounds(150, 140, 120, 30);
        gamePanel.add(gamePriceField);
        
        //label
        gameAge = new JLabel("Proper Age");
        gameAge.setForeground(Color.gray);
        gameAge.setBounds(150, 180, 150, 20);
        gameAge.setFont(alantaRoserySmall);
        gamePanel.add(gameAge);
        
        // choice
        ageChoice = new Choice();
        ageChoice.setBounds(150, 200, 80, 30);
        ageChoice.add("Choose");
        ageChoice.add("3");
        ageChoice.add("7");
        ageChoice.add("12");
        ageChoice.add("16");
        ageChoice.add("18");
        gamePanel.add(ageChoice);
        
        //label
        gameType = new JLabel("Game Type");
        gameType.setForeground(Color.gray);
        gameType.setBounds(150, 240, 150, 20);
        gameType.setFont(alantaRoserySmall);
        gamePanel.add(gameType);
        
        //chioce
        typeChoice = new Choice();
        typeChoice.setBounds(150, 260, 80, 30);
        typeChoice.add("Choose");
        typeChoice.add("Horror");
        typeChoice.add("Kids");
        typeChoice.add("Battles");
        typeChoice.add("Survive");
        typeChoice.add("Sport");
        typeChoice.add("Cars");
        typeChoice.add("Arcade");
        typeChoice.add("Girls");
        gamePanel.add(typeChoice);
        
        // a button for adding a game
        addGame = new JButton("Add Game");
        addGame.setBackground(new Color(0xd07d7d));
        addGame.setForeground(Color.white);
        addGame.setBounds(560, 350, 140, 30);
        addGame.setFont(alantaRoserySmall);
        gamePanel.add(addGame);
        addGame.addActionListener(this);
        
        // to make things visible
        frame2.add(gamePanel);    
        adminLayers.add(gamePanel, Integer.valueOf(2));
        
        frame2.add(adminLayers);
		
        frame2.setVisible(true);
    }
}
