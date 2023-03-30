package guiInterface;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.*;
import GamesCompanySystem.*;

public class CustomerLogin implements ActionListener, ChangeListener{
	//objects
	FirstFrame frame = new FirstFrame();
	Discounts sales = new Discounts();
	GuestInterface guest = new GuestInterface();
	
	//attributes
	JFrame gameFrame, onlineCheckOutFrame, cartFrame, homeDeliveryCheckOutFrame, pickUpCheckOutFrame;
	JButton addToCart, rating, check, cart, checkCart, checkOutOnline, checkOutHomeDelivery, checkOutPickUp, searchButton;
	Font 	discoSociety = FirstFrame.addFont("Disco Society.otf", 80),
			alantaRosery = FirstFrame.addFont("Alanta Rosery.otf", 20),
			Akshar = FirstFrame.addFont("Akshar-SemiBold.ttf", 15);
	JLabel sliderLabel, addToCartLabel, quantity, onlineInfo, emailConfirmation, emailError, cardNumberError, emailAndCardError, homeDeliveryInfo,
			cityConfirmation, pickUpInfo, storeConfirmation, storeError, searchError, gamesBackground;
	JComboBox items;
	JTextField email, cardNumber, city, street, cityStore, search;
	JRadioButton online, homeDelivery, pickUp;
	String customerName, customerPhone, customerEmail, customerCardNumber, customerCity;
	Games subwaySurferGame, robloxGame, ludoGame, sonicRacingGame, pocketBuildGame, brawlhallaGame,rebelRacingGame, cruxGame, callOfDutyGame, superMarioGame,
			thievesGame,jetpackJoyrideGame, spacepioneerGame, zoobaGame, minecraftGame, gibbonGame, barbieHouseGame, migaTownGame, careBearsGame, kiddopiaGame;
	ImageIcon icon = new ImageIcon("Photos//mainIcon30.png");
	
	ArrayList<Games> cartlist = new ArrayList<Games>();
	ArrayList<Integer> gamesQuantity = new ArrayList<Integer>();
	
	//constructor
	public CustomerLogin(){}
	
	//setters and getters
	public void setCustomerName(String name) {customerName = name;}
	public void setCustomerPhone(String phone) {customerPhone = phone;}
	
	Online customerOnline = new Online(customerName, customerPhone, "Unknown@gmail.com");
	Stores customerStores = new Stores(customerName, customerPhone, "Unknown", "Unknown");
	
	//this method builds the customer frame
	public void customerLoginFrame() {
		
		//------------------------------------frames---------------------------------------
		//set the customer frame settings
		JFrame customerFrame = new JFrame("Customer Interface");
		customerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		customerFrame.setSize(1000,500);
		customerFrame.setIconImage(icon.getImage());
		
		//------------------------------------background-----------------------------------
		//adjust the background color and size
		JPanel customerBackground = new JPanel();
		customerBackground.setSize(1000,500);
		customerBackground.setBackground(new Color(0xFFF3F3));
		customerBackground.setLayout(null);
		
		//adjust the title color, font and size
		JLabel title = new JLabel("**Our Games**");
		title.setFont(discoSociety);
		title.setForeground(new Color(0x912B3F));
		title.setBounds(370,20,350,70);
		
		//-------------------------------gamePanels-----------------------------------------
		//create a border
		Border line = BorderFactory.createLineBorder(Color.lightGray);
		
		// *** trend games panel ***
		//set the trend panel settings
		JPanel trend = new JPanel();
		JLabel trendLabel = new JLabel("Trending now:");
		createPanel(trend, 10, 110, 185, 250, line, trendLabel);
		
		//add subwaySurfer Game
		subwaySurferGame = new Games("Subway Surfer", 25, 8, 3.8, "action", 34);
		JButton subway = new JButton("1. " + subwaySurferGame.getName());
		addGame(subway, 7, 50, 170, 40, new ImageIcon("Photos//subwaySurfer30.png"));
		subway.addActionListener(e -> displayGameInfo(subwaySurferGame));

		//add roblox Game
		robloxGame = new Games("Roblox", 53.8, 12, 4.2, "adventure", 27);
		JButton roblox = new JButton("2. " + robloxGame.getName());
		addGame(roblox, 7, 100, 170, 40, new ImageIcon("Photos//roblox30.png"));
		roblox.addActionListener(e -> displayGameInfo(robloxGame));

		//add ludo Game
		ludoGame = new Games("Ludo", 39.6, 9, 3.8, "family", 15);
		JButton ludo = new JButton("3. " + ludoGame.getName());
		addGame(ludo, 7, 150, 170, 40, new ImageIcon("Photos//ludo30.png"));
		ludo.addActionListener(e -> displayGameInfo(ludoGame));
		
		//add sonicRacing game
		sonicRacingGame = new Games("Sonic Racing", 79.9, 4, 4.8, "racing", 18);
		JButton sonicRacing = new JButton("4. " + sonicRacingGame.getName());
		addGame(sonicRacing, 7, 200, 170, 40, new ImageIcon("Photos//sonicRacing30.png"));
		sonicRacing.addActionListener(e -> displayGameInfo(sonicRacingGame));

		//add games to the panel
		trend.add(sonicRacing);
		trend.add(ludo);
		trend.add(roblox);
		trend.add(subway);
		trend.add(trendLabel);
		
		// *** new games panel ***
		//set the new panel settings
		JPanel newGames = new JPanel();
		JLabel newGamesLabel = new JLabel("New:");
		createPanel(newGames, 205, 110, 185, 250, line, newGamesLabel);
		
		//add pocket build game
		pocketBuildGame = new Games("Pocket Build", 89.9, 9, 4.1, "simulation", 12);
		JButton pocketBuild = new JButton("1. " + pocketBuildGame.getName());
		addGame(pocketBuild, 7, 50, 170, 40, new ImageIcon("Photos//pocketBuild30.png"));
		pocketBuild.addActionListener(e -> displayGameInfo(pocketBuildGame));
		
		//add brawlhalla game
		brawlhallaGame = new Games("Brawlhalla", 175.7, 9, 4.3, "action", 9);
		JButton brawlhalla = new JButton("2. " + brawlhallaGame.getName());
		addGame(brawlhalla, 7, 100, 170, 40, new ImageIcon("Photos//brawlhalla30.png"));
		brawlhalla.addActionListener(e -> displayGameInfo(brawlhallaGame));

		//add rebel racing game
		rebelRacingGame = new Games("Rebel Racing", 39.6, 9, 3.8, "racing", 11);
		JButton rebelRacing = new JButton("3. " + rebelRacingGame.getName());
		addGame(rebelRacing, 7, 150, 170, 40, new ImageIcon("Photos//rebelRacing30.png"));
		rebelRacing.addActionListener(e -> displayGameInfo(rebelRacingGame));
		
		//add crux game
		cruxGame = new Games("Crux", 19.9, 4, 3.6, "sport", 5);
		JButton crux = new JButton("4. " + cruxGame.getName());
		addGame(crux, 7, 200, 170, 40, new ImageIcon("Photos//crux30.jpg"));
		crux.addActionListener(e -> displayGameInfo(cruxGame));

		//add games to the panel
		newGames.add(crux);
		newGames.add(rebelRacing);
		newGames.add(brawlhalla);
		newGames.add(pocketBuild);
		newGames.add(newGamesLabel);
		
		// *** action games panel ***
		//set the action panel settings
		JPanel action = new JPanel();
		JLabel actionLabel = new JLabel("Action:");
		createPanel(action, 400, 110, 185, 250, line, actionLabel);
		
		//add call of duty game
		callOfDutyGame = new Games("Call Of Duty", 158.7, 17, 4.5, "action", 23);
		JButton callOfDuty = new JButton("1. " + callOfDutyGame.getName());
		addGame(callOfDuty, 7, 50, 170, 40, new ImageIcon("Photos//cod30.jpg"));
		callOfDuty.addActionListener(e -> displayGameInfo(callOfDutyGame));
		
		//add super mario
		superMarioGame = new Games("Super Mario", 19.9, 4, 3.8, "action", 13);
		JButton superMario = new JButton("2. " + superMarioGame.getName());
		addGame(superMario, 7, 100, 170, 40, new ImageIcon("Photos//superMario30.jpg"));
		superMario.addActionListener(e -> displayGameInfo(superMarioGame));
		
		//add thieves games
		thievesGame = new Games("Thieves", 25.9, 12, 4.5, "action", 24);
		JButton Thieves = new JButton("3. " + thievesGame.getName());
		addGame(Thieves, 7, 150, 170, 40,new ImageIcon("Photos//Thieves30.png"));
		Thieves.addActionListener(e -> displayGameInfo(thievesGame));
		
		//add Jetpack Joyride game
		jetpackJoyrideGame = new Games("Jetpack Joyride", 49.9, 9, 4.3, "action", 30);
		JButton jetpackJoyride = new JButton("4. " + jetpackJoyrideGame.getName());
		addGame(jetpackJoyride, 7, 200, 170, 40, new ImageIcon("Photos//jetpackJoyride30.png"));
		jetpackJoyride.addActionListener(e -> displayGameInfo(jetpackJoyrideGame));
		
		//add games to the panel
		action.add(jetpackJoyride);
		action.add(Thieves);
		action.add(superMario);
		action.add(callOfDuty);
		action.add(actionLabel);
		
		// *** adventure games panel ***
		//set the adventure panel settings
		JPanel adventure = new JPanel();
		JLabel adventureLabel = new JLabel("Adventure:");
		createPanel(adventure, 595, 110, 185, 250, line, adventureLabel);
		
		//add space pioneer game
		spacepioneerGame = new Games("Space Pioneer", 29.9, 9, 4.7, "adventure", 15);
		JButton spacePioneer = new JButton("1. " + spacepioneerGame.getName());
		addGame(spacePioneer, 7, 50, 170, 40, new ImageIcon("Photos//spacePioneer30.png"));
		spacePioneer.addActionListener(e -> displayGameInfo(spacepioneerGame));
		
		//add zooba game
		zoobaGame = new Games("Zooba", 39.9, 12, 4.2, "acdventure", 21);
		JButton zooba = new JButton("2. " + zoobaGame.getName());
		addGame(zooba, 7, 100, 170, 40, new ImageIcon("Photos//zooba30.png"));
		zooba.addActionListener(e -> displayGameInfo(zoobaGame));
		
		//add minecraft game
		minecraftGame = new Games("Minecraft", 59.9, 9, 4.4, "adventure", 19);
		JButton minecraft = new JButton("3. " + minecraftGame.getName());
		addGame(minecraft, 7, 150, 170, 40,new ImageIcon("Photos//minecraft30.png"));
		minecraft.addActionListener(e -> displayGameInfo(minecraftGame));
		
		//add gibbon game
		gibbonGame = new Games("Gibbon", 29.9, 4, 4.8, "adventure", 17);
		JButton gibbon = new JButton("4. " + gibbonGame.getName());
		addGame(gibbon, 7, 200, 170, 40, new ImageIcon("Photos//gibbon30.png"));
		gibbon.addActionListener(e -> displayGameInfo(gibbonGame));
		
		//add games to the panel
		adventure.add(gibbon);
		adventure.add(minecraft);
		adventure.add(zooba);
		adventure.add(spacePioneer);
		adventure.add(adventureLabel);
		
		// *** kids games panel ***
		//set the kids panel settings
		JPanel kids = new JPanel();
		JLabel kidsLabel = new JLabel("Kids:");
		createPanel(kids, 790, 110, 185, 250, line, kidsLabel);
		
		//add barbie house game
		barbieHouseGame = new Games("Barbie House", 19.9, 4, 3.9, "kids", 21);
		JButton barbieHouse = new JButton("1. " + barbieHouseGame.getName());
		addGame(barbieHouse, 7, 50, 170, 40, new ImageIcon("Photos//barbieDreamhouse30.png"));
		barbieHouse.addActionListener(e -> displayGameInfo(barbieHouseGame));
		
		//add miga town game
		migaTownGame = new Games("Miga Town", 25.9, 4, 3.7, "kids", 13);
		JButton migaTown = new JButton("2. " + migaTownGame.getName());
		addGame(migaTown, 7, 100, 170, 40, new ImageIcon("Photos//migaTown30.png"));
		migaTown.addActionListener(e -> displayGameInfo(migaTownGame));
		
		//add careBears game
		careBearsGame = new Games("Care Bears", 59.9, 9, 4.4, "kids", 15);
		JButton careBears = new JButton("3. " + careBearsGame.getName());
		addGame(careBears, 7, 150, 170, 40,new ImageIcon("Photos//careBears30.jpg"));
		careBears.addActionListener(e -> displayGameInfo(careBearsGame));
		
		//add kiddopia game
		kiddopiaGame = new Games("Kiddopia", 39.9, 4, 4.4, "kids", 36);
		JButton kiddopia = new JButton("4. " + kiddopiaGame.getName());
		addGame(kiddopia, 7, 200, 170, 40, new ImageIcon("Photos//kiddopia30.jpg"));
		kiddopia.addActionListener(e -> displayGameInfo(kiddopiaGame));
		
		//add games to the panel
		kids.add(kiddopia);
		kids.add(careBears);
		kids.add(migaTown);
		kids.add(barbieHouse);
		kids.add(kidsLabel);
		
		//-----------------------------------location-------------------------------------
		//set location label settings
		JLabel location = new JLabel("Our Locations: " + customerStores.toString());
		location.setBounds(0,383,1000,60);
		location.setBackground(new Color(0xFDECEC));
		location.setFont(Akshar);
		location.setForeground(Color.gray);
		location.setOpaque(true);
		location.setHorizontalAlignment(JLabel.CENTER);
		
		//----------------------------------rights-----------------------------------------
		//set location label settings
		JLabel rights = new JLabel("copyright © Toy Store. All rights reserved.");
		rights.setBounds(0,443,1000,20);
		rights.setBackground(new Color(0xEAD8D8));
		rights.setFont(new Font("San Francisco", Font.BOLD, 11));
		rights.setForeground(Color.gray);
		rights.setOpaque(true);
		rights.setHorizontalAlignment(JLabel.CENTER);
		
		//-------------------------------------cart------------------------------------------
		//adjust cart button settings
		cart = new JButton();
		cart.setBounds(920,65,45,40);
		cart.setBackground(new Color(0xFFF3F3));
		cart.setBorder(null);
		cart.setIcon(new ImageIcon("Photos//cart50.png"));
		cart.addActionListener(this);
		
		//---------------------------------------search-------------------------------------
		//adjust search button settings
		searchButton = new JButton();
		searchButton.setIcon(new ImageIcon("Photos//search20.png"));
		searchButton.setBounds(890,70,28,30);
		searchButton.setBackground(Color.white);
		searchButton.setBorder(null);
		searchButton.setFocusable(false);
		searchButton.addActionListener(this);
		
		//adjust search text field settings
		search = new JTextField();
		search.setBounds(760, 70, 130, 30);
		search.setBackground(Color.white);
		search.setBorder(null);
		
		//an error message shows up when the user searches for a non existing game
		searchError = new JLabel("Sorry! we don't have this game");
		searchError.setForeground(Color.red);
		searchError.setBounds(740,40,200,30);
		searchError.setVisible(false); //it only appeaars if the game doesn't exist
		
		//--------------------------adding components to the frame-----------------------------
		//add the components to the background
		customerBackground.add(searchError);
		customerBackground.add(location);
		customerBackground.add(searchButton);
		customerBackground.add(search);
		customerBackground.add(cart);
		customerBackground.add(rights);
		customerBackground.add(kids);
		customerBackground.add(adventure);
		customerBackground.add(action);
		customerBackground.add(newGames);
		customerBackground.add(trend);
		customerBackground.add(title);
		
		//add the background to the frame
		customerFrame.add(customerBackground);
		customerFrame.setVisible(true);
	}
	
	//this method create the games' panels
	private void createPanel(JPanel name, int x, int y, int width, int height, Border line, JLabel title) {
		//panel's settings
		name.setLayout(null);
		name.setBounds(x,y,width,height);
		name.setBorder(line);
		name.setBackground(new Color(0xFEEAEA));
		//title's setting
		title.setForeground(new Color(0x912B3F));
		title.setFont(alantaRosery);
		title.setBounds(10, 5, 150, 30);
	}
	
	//this method adds games
	private void addGame(JButton name, int x, int y, int width, int height, ImageIcon icon) {
		name.setBounds(x,y,width,height);
		name.setBackground(new Color(0xFEEAEA));
		name.setFont(Akshar);
		name.setForeground(new Color(0x0C1647));
		name.setIcon(icon);
		name.setHorizontalAlignment(JButton.LEFT);
		name.setFocusable(false);
		name.setBorder(null);
	}
	
	//this method displays the game's information once you click on it
	private void displayGameInfo(Games name) {
		//------------------------------------frame-------------------------------------------
		//adjust the frame settings
		gameFrame = new JFrame("Games Information");
		gameFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		gameFrame.setSize(300,300);
		gameFrame.setIconImage(icon.getImage());
		
		//background settings
		JLabel gamesBackground = new JLabel();
		gamesBackground.setBackground(new Color(0xFFF3F3));
		gamesBackground.setBounds(0,0,300,300);
		gamesBackground.setOpaque(true);
		
		//---------------------------------game's info----------------------------------------
		JLabel gameName = new JLabel("Name: " + name.getName());
		addGameInfo(gameName, 10);
		gamesBackground.add(gameName);
		
		JLabel gameType = new JLabel("Type: " + name.getType());
		addGameInfo(gameType, 40);
		gamesBackground.add(gameType);
		
		JLabel gameRate = new JLabel(String.format("Rate: %.1f, %d Ratings", name.getRate(), name.getRateTimes()));
		addGameInfo(gameRate, 70);
		gamesBackground.add(gameRate);
		
		JLabel gameMinimumAge = new JLabel("Minimum Age: " + name.getMinimumAge());
		addGameInfo(gameMinimumAge, 100);
		gamesBackground.add(gameMinimumAge);
		
		JLabel gamePrice = new JLabel("Price: " + name.getPrice());
		addGameInfo(gamePrice, 130);
		gamesBackground.add(gamePrice);
		
		//-----------------------------cart and rating buttons-----------------------------
		//cart button settings
		JLabel cartLabel = new JLabel("Add");//label settings
		cartLabel.setIcon(new ImageIcon("Photos//cart30.png"));
		cartLabel.setBounds(0,0,60,25);
		addToCart = new JButton();//button settings
		addToCart.setBounds(30, 160, 95, 30);
		addToCart.add(cartLabel);
		addToCart.addActionListener(this);
		addToCart.addActionListener(e -> cartlist.add(name));
		gamesBackground.add(addToCart);
		
		//quantity comboBox settings 
		quantity = new JLabel("Quantity:");//label settings
		quantity.setBounds(50,200,160,50);
		quantity.setFont(Akshar);
		quantity.setVisible(false);// appears when the customer clicks the cart button
		Integer[] number = {1,2,3,4,5,6,7,8,9,10};//array of Integers to fill the comboBox
		items = new JComboBox(number);//the customer chooses the quantity of a game from here
		items.setBounds(80,15,40,20);
		quantity.add(items);
		
		//check button settings
		checkCart = new JButton();//button settings
		checkCart.setIcon(new ImageIcon("Photos//check20.png"));
		checkCart.setFocusable(false);
		checkCart.setBackground(new Color(0xFFF3F3));
		checkCart.setBorder(null);
		checkCart.setBounds(130,10,25,25);
		checkCart.addActionListener(this);
		quantity.add(checkCart);
		
		//after clicking check button settings
		addToCartLabel = new JLabel("Added to cart!");
		addToCartLabel.setBounds(85,200,170,50);
		addToCartLabel.setFont(Akshar);
		addToCartLabel.setForeground(new Color(0x912B3F));
		addToCartLabel.setVisible(false);//appears when clicking check button
		
		//rate button settings
		JLabel rateLabel = new JLabel("Rate");//label settings
		rateLabel.setIcon(new ImageIcon("Photos//rate30.png"));
		rateLabel.setBounds(0,0,60,25);
		rating = new JButton();//button settings
		rating.setBounds(150, 160, 95, 30);
		rating.add(rateLabel);
		rating.addActionListener(this);
		gamesBackground.add(rating);
		
		//rate background settings
		sliderLabel = new JLabel();
		sliderLabel.setBounds(40,200,200,50);
		sliderLabel.setBackground(new Color(0xFFF3F3));
		sliderLabel.setOpaque(true);
		JSlider slider = new JSlider(0,50);//rating slider settings
		slider.setBounds(0,0,160,28);
		slider.setMajorTickSpacing(10);
		slider.setBackground(new Color(0xFFF3F3));
		slider.setPaintTicks(true);
		slider.setMinorTickSpacing(5);
		sliderLabel.setText("Your rate is: " + (slider.getValue() / 10.0));//label settings
		sliderLabel.setVerticalAlignment(JLabel.BOTTOM);
		sliderLabel.setHorizontalAlignment(JLabel.CENTER);
		sliderLabel.setForeground(new Color(0x912B3F));
		sliderLabel.setFont(Akshar);
		sliderLabel.setVisible(false);//appears only when the rate button is clicked
		slider.addChangeListener(e -> sliderLabel.setText("Your rate is: " + (slider.getValue() / 10.0)));
		
		//check button settings
		check = new JButton();
		check.setBounds(170,0,20,20);
		check.setFocusable(false);
		check.setBackground(new Color(0xFFF3F3));
		check.setIcon(new ImageIcon("Photos//check20.png"));
		check.setBorder(null);
		check.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					check.setEnabled(false);
					name.updateRate(slider.getValue() / 10.0);
					gameRate.setText(String.format("Rate: %.1f, %d Ratings", name.getRate(), name.getRateTimes()));
			}
		});
		sliderLabel.add(check);
		sliderLabel.add(slider);
		
		gamesBackground.add(addToCartLabel);
		gamesBackground.add(quantity);
		gamesBackground.add(sliderLabel);
		gameFrame.add(gamesBackground);
		gameFrame.setVisible(true);
	}
	
	//this method adds game's info to the game's info frame
	private void addGameInfo(JLabel name, int y) {
		name.setFont(Akshar);
		name.setForeground(new Color(0x0C1647));
		name.setBounds(15,y,150,30);
	}
	
	//this method shows the cart when the user clicks on the cart button
	public void displayCart() {
		//-------------------------------cart frame------------------------------------------
		//adjust frame settings
		cartFrame = new JFrame("Cart");//frame
		cartFrame.setSize(1000,500);
		cartFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		cartFrame.setIconImage(icon.getImage());
		JPanel background = new JPanel();//background
		background.setBackground(new Color(0xFFF3F3));
		background.setLayout(null);
		background.setBounds(0,0,1000,500);
		JLabel title = new JLabel(",,, Cart details ,,,");//title
		title.setForeground(new Color(0x912B3F));
		title.setFont(discoSociety);
		title.setBounds(270,0,400,100);
		
		//-------------------------------------bill label-----------------------------------
		//label settings
		JLabel billLabel = new JLabel();
		billLabel.setBounds(10,100,650,350);
		billLabel.setBackground(new Color(0xFBEAEA));
		billLabel.setOpaque(true);
		
		//display cart component
		JLabel info = new JLabel(String.format("%-40s%-30s%-35s%-30s", "Game Name", "Price", "Quantity", "Total"));
		info.setBounds(10,10,550,50);
		info.setForeground(new Color(0x912B3F));
		info.setFont(Akshar);
		billLabel.add(info);
		
		int y = 50;//x axis
		double total = 0;//total price of games
		for (int i = 0; i < cartlist.size(); i++) {
			//add game names to the bill
			JLabel name = new JLabel(cartlist.get(i).getName());
			name.setBounds(10,y,450,50);
			name.setFont(Akshar);
			billLabel.add(name);
			
			//add game prices to the bill
			JLabel price = new JLabel((String.format("%-10.2f", cartlist.get(i).getPrice())));
			price.setBounds(190,y,450,50);
			price.setFont(Akshar);
			billLabel.add(price);
			
			//add game quantity to the bill
			JLabel quantity = new JLabel((String.format("%-10d", gamesQuantity.get(i))));
			quantity.setBounds(330,y,450,50);
			quantity.setFont(Akshar);
			billLabel.add(quantity);
			
			//add game total to the bill
			JLabel totalPrice = new JLabel((String.format("%-10.2f", gamesQuantity.get(i) * cartlist.get(i).getPrice())));
			totalPrice.setBounds(455,y,450,50);
			totalPrice.setFont(Akshar);
			billLabel.add(totalPrice);			
			
			y += 30;//change y axis by 30 each iteration
			total += gamesQuantity.get(i) * cartlist.get(i).getPrice(); //update the total price
		}
		
		//adjust total labels settings
		JLabel totalAmount = new JLabel(String.format("%-45s%-20.2f", "Total: ", total));
		totalAmount.setBounds(10,250,400,50);
		totalAmount.setFont(Akshar);
		billLabel.add(totalAmount);
		JLabel discount = new JLabel(String.format("%-39s-%-20.2f%-50s", "Discount: ", Discounts.discountAmount() * total, Discounts.discountMessage()));
		discount.setBounds(10,270,600,50);
		discount.setFont(Akshar);
		billLabel.add(discount);
		JLabel totalAfterDiscount = new JLabel(String.format("%-31s%-20.2f", "Total after discount: ", sales.computeDiscount(total)));
		totalAfterDiscount.setBounds(10,290,400,50);
		totalAfterDiscount.setFont(Akshar);
		billLabel.add(totalAfterDiscount);
		
		//-------------------------------------delivery settings------------------------------
		JLabel delivery = new JLabel("Choose delivery: ");
		delivery.setBounds(700,100,250,350);
		delivery.setLayout(null);
		delivery.setHorizontalAlignment(JLabel.CENTER);
		delivery.setVerticalAlignment(JLabel.TOP);
		delivery.setFont(alantaRosery);
		
		//add the delivery buttons
		online = new JRadioButton("Online");
		online.setBounds(5,30,70,30);
		online.setBackground(new Color(0xFFF3F3));
		online.setFocusable(false);
		online.setFont(Akshar);
		online.addActionListener(this);
		
		homeDelivery = new JRadioButton("Home Delivery");
		homeDelivery.setBounds(5,60,150,30);
		homeDelivery.setBackground(new Color(0xFFF3F3));
		homeDelivery.setFocusable(false);
		homeDelivery.setFont(Akshar);
		homeDelivery.addActionListener(this);
		
		pickUp = new JRadioButton("Pick up from store");
		pickUp.setBounds(5,90,170,30);
		pickUp.setBackground(new Color(0xFFF3F3));
		pickUp.setFocusable(false);
		pickUp.setFont(Akshar);
		pickUp.addActionListener(this);
		
		//group the buttons together
		ButtonGroup group = new ButtonGroup();
		group.add(online);
		group.add(homeDelivery);
		group.add(pickUp);
		
		//labels settings when clicking one of the buttons
		onlineInfo = new JLabel("Please fill these information:");
		delivery.add(onlineInfo);
		onlineInfo.setVisible(false);
		homeDeliveryInfo = new JLabel("Please fill these information:");
		delivery.add(homeDeliveryInfo);
		homeDeliveryInfo.setVisible(false);
		pickUpInfo = new JLabel("Please fill these information:");
		delivery.add(pickUpInfo);
		pickUpInfo.setVisible(false);
		
		//add components
		delivery.add(online);
		delivery.add(homeDelivery);
		delivery.add(pickUp);
		background.add(delivery);
		background.add(billLabel);
		background.add(title);
		cartFrame.add(background);
		cartFrame.setVisible(true);
	}
	
	//this method displays some info that the user should add when he clicks online
	private void displayOnlineInfo() {
		//set the label settings
		onlineInfo.setBounds(0,140,250,200);
		onlineInfo.setFont(alantaRosery);
		onlineInfo.setVerticalAlignment(JLabel.TOP);
		
		//info boxes settings
		JLabel emailLabel = new JLabel("Email:");
		emailLabel.setFont(Akshar);
		emailLabel.setBounds(50,52,50,20);
		onlineInfo.add(emailLabel);
		JLabel cardNumberLabel = new JLabel("Card Number:");
		cardNumberLabel.setFont(Akshar);
		cardNumberLabel.setBounds(0,92,120,20);
		onlineInfo.add(cardNumberLabel);
		
		email = new JTextField();
		email.setBounds(95,50,150,25);
		onlineInfo.add(email);
		cardNumber = new JTextField();
		cardNumber.setBounds(95,90,150,25);
		onlineInfo.add(cardNumber);
		
		//check out button settings
		checkOutOnline = new JButton("Check out <3");
		checkOutOnline.setBounds(60,130,120,30);
		onlineInfo.add(checkOutOnline);
		checkOutOnline.addActionListener(this);
		checkOutOnline.setFocusable(false);
		
		//errors that could occur
		emailError = new JLabel("Invalid email!!");
		emailError.setBounds(75,170,120,20);
		emailError.setForeground(Color.red);
		onlineInfo.add(emailError);
		emailError.setVisible(false);

		cardNumberError = new JLabel("Invalid card number!!");
		cardNumberError.setBounds(60,170,150,20);
		cardNumberError.setForeground(Color.red);
		onlineInfo.add(cardNumberError);
		cardNumberError.setVisible(false);
		
		emailAndCardError = new JLabel("Invalid email and card number!!");
		emailAndCardError.setBounds(30,170,190,20);
		emailAndCardError.setForeground(Color.red);
		onlineInfo.add(emailAndCardError);
		emailAndCardError.setVisible(false);
		
		onlineInfo.setVisible(true);
		
		//checkout frame
		onlineCheckOutFrame = new JFrame("Checkout");
		onlineCheckOutFrame.setSize(500,170);
		onlineCheckOutFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		onlineCheckOutFrame.setIconImage(icon.getImage());
		
		JLabel background = new JLabel();
		background.setBounds(0,0,500,170);
		background.setBackground(new Color(0xFFF3F3));
		background.setOpaque(true);
		JLabel thankYou = new JLabel("Thank you for your purchase !!");
		thankYou.setBounds(100,10,300,40);
		thankYou.setFont(alantaRosery);
		thankYou.setForeground(new Color(0x912B3F));
		JLabel confirmation = new JLabel(customerOnline.delivery());
		confirmation.setBounds(50,50,500,40);
		confirmation.setFont(Akshar);
		emailConfirmation = new JLabel();
		emailConfirmation.setBounds(130,80,500,40);
		emailConfirmation.setFont(Akshar);
		
		background.add(emailConfirmation);
		background.add(confirmation);
		background.add(thankYou);
		onlineCheckOutFrame.add(background);
		onlineCheckOutFrame.setVisible(false);
		
	}
	
	//this method displays home delivery label once the user clicks on home delivery option
	public void displayHomeDeliveryInfo() {
		//home delivery label settings
		homeDeliveryInfo.setBounds(0,160,250,200);
		homeDeliveryInfo.setFont(alantaRosery);
		homeDeliveryInfo.setVerticalAlignment(JLabel.TOP);
		
		JLabel cityLabel = new JLabel("City:");
		cityLabel.setFont(Akshar);
		cityLabel.setBounds(30,52,50,20);
		homeDeliveryInfo.add(cityLabel);
		
		city = new JTextField();
		city.setBounds(80,50,120,25);
		homeDeliveryInfo.add(city);
		
		checkOutHomeDelivery = new JButton("Check out <3");
		checkOutHomeDelivery.setBounds(60,90,120,30);
		checkOutHomeDelivery.addActionListener(this);
		checkOutHomeDelivery.setFocusable(false);
		homeDeliveryInfo.add(checkOutHomeDelivery);
		
		homeDeliveryInfo.setVisible(true);
		
		//frame after check out
		homeDeliveryCheckOutFrame = new JFrame("Checkout");
		homeDeliveryCheckOutFrame.setSize(500,170);
		homeDeliveryCheckOutFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		homeDeliveryCheckOutFrame.setIconImage(icon.getImage());
		
		JLabel background = new JLabel();
		background.setBounds(0,0,500,170);
		background.setBackground(new Color(0xFFF3F3));
		background.setOpaque(true);
		JLabel thankYou = new JLabel("Thank you for your purchase !!");
		thankYou.setBounds(100,10,300,40);
		thankYou.setFont(alantaRosery);
		thankYou.setForeground(new Color(0x912B3F));
		
		cityConfirmation = new JLabel();
		cityConfirmation.setBounds(80,50,500,40);
		cityConfirmation.setFont(Akshar);
		
		JLabel phoneConfirmation = new JLabel(customerStores.delivery());
		phoneConfirmation.setBounds(50,80,500,40);
		phoneConfirmation.setFont(Akshar);

		background.add(phoneConfirmation);
		background.add(cityConfirmation);
		background.add(thankYou);
		homeDeliveryCheckOutFrame.add(background);
		homeDeliveryCheckOutFrame.setVisible(false);
	}
	
	//this method displays pick up label once the user clicks on pick up option
	public void displayPickUpInfo() {
		pickUpInfo.setBounds(0,160,250,200);
		pickUpInfo.setFont(alantaRosery);
		pickUpInfo.setVerticalAlignment(JLabel.TOP);
		
		JLabel cityLabel = new JLabel("City:");
		cityLabel.setFont(Akshar);
		cityLabel.setBounds(30,52,50,20);
		pickUpInfo.add(cityLabel);
		
		cityStore = new JTextField();
		cityStore.setBounds(80,50,120,25);
		pickUpInfo.add(cityStore);
		
		//checkout button
		checkOutPickUp = new JButton("Check out <3");
		checkOutPickUp.setBounds(60,90,120,30);
		pickUpInfo.add(checkOutPickUp);
		checkOutPickUp.addActionListener(this);
		checkOutPickUp.setFocusable(false);
		
		pickUpInfo.setVisible(true);
		
		//checkout frame
		pickUpCheckOutFrame = new JFrame("Checkout");
		pickUpCheckOutFrame.setSize(500,170);
		pickUpCheckOutFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		pickUpCheckOutFrame.setIconImage(icon.getImage());
		
		JLabel background = new JLabel();
		background.setBounds(0,0,500,170);
		background.setBackground(new Color(0xFFF3F3));
		background.setOpaque(true);
		JLabel thankYou = new JLabel("Thank you for your purchase !!");
		thankYou.setBounds(100,20,300,40);
		thankYou.setFont(alantaRosery);
		thankYou.setForeground(new Color(0x912B3F));
		
		storeConfirmation = new JLabel();
		storeConfirmation.setBounds(70,60,500,40);
		storeConfirmation.setFont(Akshar);
		
		storeError = new JLabel("Sorry ); We don't have a store in your city");
		storeError.setBounds(0,140,250,20);
		storeError.setForeground(Color.red);
		pickUpInfo.add(storeError);
		storeError.setVisible(false);
		
		background.add(storeConfirmation);
		background.add(thankYou);
		pickUpCheckOutFrame.add(background);
		pickUpCheckOutFrame.setVisible(false);
	}
	
	@Override 
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == addToCart) {
			sliderLabel.setVisible(false);
			quantity.setVisible(true);
		}
		else if (e.getSource() == rating) {
			sliderLabel.setVisible(true);
			quantity.setVisible(false);
			addToCartLabel.setVisible(false);
			check.setEnabled(true);
		}
		else if (e.getSource() == cart) {
			displayCart();
		}
		else if (e.getSource() == checkCart) {
			quantity.setVisible(false);
			addToCartLabel.setVisible(true);
			sliderLabel.setVisible(false);
			gamesQuantity.add((Integer)items.getSelectedItem());
			
		}
		else if (e.getSource() == online) {
			homeDeliveryInfo.setVisible(false);
			pickUpInfo.setVisible(false);
			displayOnlineInfo();
		}
		else if (e.getSource() == checkOutOnline) {
			if (customerOnline.checkEmail(email.getText()) && customerOnline.checkCardNumber(cardNumber.getText())) {
				onlineCheckOutFrame.setVisible(true);
				customerOnline.setEmail(email.getText());
				customerOnline.setCardNumber(cardNumber.getText());
				emailConfirmation.setText(customerOnline.getEmail());
				cartFrame.dispose();
			}
			else if (customerOnline.checkEmail(email.getText()) && !customerOnline.checkCardNumber(cardNumber.getText())) {
				cardNumberError.setVisible(true);
				emailError.setVisible(false);
				emailAndCardError.setVisible(false);
			}
			else if (!customerOnline.checkEmail(email.getText()) && customerOnline.checkCardNumber(cardNumber.getText())){
				cardNumberError.setVisible(false);
				emailError.setVisible(true);
				emailAndCardError.setVisible(false);
			}
			else {
				cardNumberError.setVisible(false);
				emailError.setVisible(false);
				emailAndCardError.setVisible(true);
			}
		}
		else if (e.getSource() == homeDelivery) {
			customerStores.setName(customerName);
			customerStores.setPhoneNumber(customerPhone);
			customerStores.setDelivery("Home Delivery");
			onlineInfo.setVisible(false);
			pickUpInfo.setVisible(false);
			displayHomeDeliveryInfo();
		}
		else if (e.getSource() == checkOutHomeDelivery) {
			homeDeliveryCheckOutFrame.setVisible(true);
			customerStores.setCity(city.getText());
			cityConfirmation.setText("Your games will be shipped to " + customerStores.getCity() + " in 2 days (;");
			cartFrame.dispose();
		}
		else if (e.getSource() == pickUp) {
			customerStores.setName(customerName);
			customerStores.setPhoneNumber(customerPhone);
			customerStores.setDelivery("Pick Up");
			onlineInfo.setVisible(false);
			homeDeliveryInfo.setVisible(false);
			displayPickUpInfo();
		}
		else if (e.getSource() == checkOutPickUp) {
			if (customerStores.checkStore(cityStore.getText()) != -1) {
				customerStores.setCity(cityStore.getText());
				pickUpCheckOutFrame.setVisible(true);
				storeConfirmation.setText(customerStores.delivery());
				cartFrame.dispose();
			}
			else storeError.setVisible(true);
		}
		else if (e.getSource() == searchButton) {
			if (guest.searchForAGame(search.getText()) != -1) {
				searchError.setVisible(false);
				displayGameInfo(GuestInterface.games.get(guest.searchForAGame(search.getText())));
			}
			else {
				searchError.setVisible(true);
			}
		}
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		// TODO Auto-generated method stub
	}
}