package current.gui;

import current.meta.Constants.Command;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Locale;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;

/**
 * Created by
 * Daniel Roesch
 * as "Nils Darmstrong".
 * -----------------
 * For "DragonSlayerDANI",
 * on 07.06.2017, 21:57.
 */
public class MainGUI extends JFrame implements ActionListener {

  private static final String IMAGE_PATH = "src/current/res/img/";

  private static final int WIDTH = 1000;
  private static final int HEIGHT = 500;
  private static final int GAP = 10;

  private JPanel textPanel, rightPanel, bottomPanel, walkPanel, fightPanel, bagPanel, metaPanel;
  private JPanel walkTopPanel, walkBottomPanel;
  private JTextArea outputArea;
  private JScrollPane outPane;
  private JButton upButton, downButton, leftButton, rightButton, findButton, fightButton,
      runButton, openBagInFightButton, openBagButton, useItemButton, deleteItemButton, mapButton, statusButton,
      helpButton, manualButton;
  private BufferedImage upImg, downImg, leftImg, rightImg, findImg, fightImg, runImg, openBagImg,
      useItemImg, deleteItemImg, mapImg, statusImg, helpImg, manualImg;
  private boolean imagesAvailable;

  /**
   * method to create a new main gui object.
   */
  public MainGUI() {
    super("Dragon Slayer");
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    setLayout(new BorderLayout(GAP, GAP));
    setResizable(true);

    this.imagesAvailable = loadImages();
    initComponents();
    addComponentsTogether();
    addActionListeners();

    setSize(WIDTH, HEIGHT);
    setLocationRelativeTo(null);
    setVisible(true);
  }

  /**
   * method to load all necessary images for the gui.
   *
   * @return boolean true if all images were loaded correctly, false on IOException.
   */
  private boolean loadImages() {
    try {
      upImg = ImageIO.read(new File(IMAGE_PATH + "up.png"));
      downImg = ImageIO.read(new File(IMAGE_PATH + "down.png"));
      leftImg = ImageIO.read(new File(IMAGE_PATH + "left.png"));
      rightImg = ImageIO.read(new File(IMAGE_PATH + "right.png"));
      fightImg = ImageIO.read(new File(IMAGE_PATH + "fight.png"));
      findImg = ImageIO.read(new File(IMAGE_PATH + "find.png"));
      runImg = ImageIO.read(new File(IMAGE_PATH + "run.png"));
      openBagImg = ImageIO.read(new File(IMAGE_PATH + "bag.png"));
      useItemImg = ImageIO.read(new File(IMAGE_PATH + "use.png"));
      deleteItemImg = ImageIO.read(new File(IMAGE_PATH + "delete.png"));
      mapImg = ImageIO.read(new File(IMAGE_PATH + "map.png"));
      statusImg = ImageIO.read(new File(IMAGE_PATH + "status.png"));
      helpImg = ImageIO.read(new File(IMAGE_PATH + "help.png"));
      manualImg = ImageIO.read(new File(IMAGE_PATH + "manual.png"));
      return true;
    } catch (IOException e) {
      e.printStackTrace();
      return false;
    }
  }

  /**
   * method to initialize all the components that are defined in the scope.
   */
  private void initComponents() {
    textPanel = new JPanel(new BorderLayout(GAP, GAP));
    rightPanel = new JPanel(new BorderLayout(GAP, GAP));
    bottomPanel = new JPanel(new BorderLayout(GAP, GAP));

    walkPanel = new JPanel(new GridLayout(2, 1, GAP, GAP));
    walkTopPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, GAP, GAP));
    walkBottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, GAP, GAP));
    fightPanel = new JPanel(new GridLayout(3, 1, GAP, GAP));
    bagPanel = new JPanel(new FlowLayout(FlowLayout.LEADING, GAP, GAP));
    metaPanel = new JPanel(new FlowLayout(FlowLayout.LEADING, GAP, GAP));
    outputArea = new JTextArea(15, 45);
    outputArea.setLineWrap(true);
    outputArea.setWrapStyleWord(true);
    outPane = new JScrollPane(outputArea, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
        ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
    // Image buttons.
    if (this.imagesAvailable) {
      upButton = new JButton(new ImageIcon(upImg));
      upButton.setToolTipText("Move north on the map");
      downButton = new JButton(new ImageIcon(downImg));
      downButton.setToolTipText("Move south on the map");
      leftButton = new JButton(new ImageIcon(leftImg));
      leftButton.setToolTipText("Move east on the map");
      rightButton = new JButton(new ImageIcon(rightImg));
      rightButton.setToolTipText("Move west on the map");
      findButton = new JButton(new ImageIcon(findImg));
      findButton.setToolTipText("Search for items on the current field");
      fightButton = new JButton(new ImageIcon(fightImg));
      fightButton.setToolTipText("Fight");
      runButton = new JButton(new ImageIcon(runImg));
      runButton.setToolTipText("Try to run away");
      openBagInFightButton = new JButton(new ImageIcon(openBagImg));
      openBagInFightButton.setToolTipText("Open bag");
      openBagButton = new JButton(new ImageIcon(openBagImg));
      openBagButton.setToolTipText("Open bag");
      useItemButton = new JButton(new ImageIcon(useItemImg));
      useItemButton.setToolTipText("Use an item from the bag");
      deleteItemButton = new JButton(new ImageIcon(deleteItemImg));
      deleteItemButton.setToolTipText("Delete an item from the bag");
      mapButton = new JButton(new ImageIcon(mapImg));
      mapButton.setToolTipText("Show the map");
      statusButton = new JButton(new ImageIcon(statusImg));
      statusButton.setToolTipText("Show character status");
      helpButton = new JButton(new ImageIcon(helpImg));
      helpButton.setToolTipText("Show help menu");
      manualButton = new JButton(new ImageIcon(manualImg));
      manualButton.setToolTipText("Show manual for the game");
    } else {
      upButton = new JButton("North");
      downButton = new JButton("South");
      leftButton = new JButton("West");
      rightButton = new JButton("East");
      findButton = new JButton("Find");
      fightButton = new JButton("Fight");
      runButton = new JButton("Run");
      openBagInFightButton = new JButton("Open bag");
      openBagButton = new JButton("Open Bag");
      useItemButton = new JButton("Use Item");
      deleteItemButton = new JButton("Delete Item");
      mapButton = new JButton("Show map");
      statusButton = new JButton("Show status");
      helpButton = new JButton("Show help");
      manualButton = new JButton("Show manual");
    }

  }

  /**
   * method to add all the components together.
   */
  private void addComponentsTogether() {
    textPanel.add(outPane, "Center");
    add(textPanel, "Center");
    add(bottomPanel, "South");
    add(rightPanel, "East");
    walkPanel.add(walkTopPanel, 0);
    walkPanel.add(walkBottomPanel, 1);
    walkTopPanel.add(upButton);
    walkBottomPanel.add(leftButton);
    walkBottomPanel.add(downButton);
    walkBottomPanel.add(rightButton);
    rightPanel.add(walkPanel, "South");
    rightPanel.add(bagPanel, "Center");
    rightPanel.add(metaPanel, "North");
    bagPanel.add(findButton);
    bagPanel.add(openBagButton);
    bagPanel.add(useItemButton);
    bagPanel.add(deleteItemButton);
    fightPanel.add(fightButton);
    fightPanel.add(runButton);
    fightPanel.add(openBagInFightButton);
    metaPanel.add(mapButton);
    metaPanel.add(statusButton);
    metaPanel.add(helpButton);
    metaPanel.add(manualButton);
  }

  /**
   * method to add all necessary action listeners and to set the action commands.
   * action commands are defined in {@link Command}.
   */
  private void addActionListeners() {
    upButton.addActionListener(this);
    downButton.addActionListener(this);
    leftButton.addActionListener(this);
    rightButton.addActionListener(this);
    findButton.addActionListener(this);
    fightButton.addActionListener(this);
    runButton.addActionListener(this);
    openBagInFightButton.addActionListener(this);
    openBagButton.addActionListener(this);
    useItemButton.addActionListener(this);
    deleteItemButton.addActionListener(this);
    mapButton.addActionListener(this);
    statusButton.addActionListener(this);
    helpButton.addActionListener(this);
    manualButton.addActionListener(this);

    upButton.setActionCommand(String.valueOf(Command.north));
    downButton.setActionCommand(String.valueOf(Command.south));
    leftButton.setActionCommand(String.valueOf(Command.west));
    rightButton.setActionCommand(String.valueOf(Command.east));
    findButton.setActionCommand(String.valueOf(Command.find));
    fightButton.setActionCommand(String.valueOf(Command.fight));
    runButton.setActionCommand(String.valueOf(Command.run));
    openBagInFightButton.setActionCommand(String.valueOf(Command.bagFight));
    openBagButton.setActionCommand(String.valueOf(Command.bag));
    useItemButton.setActionCommand(String.valueOf(Command.use));
    deleteItemButton.setActionCommand(String.valueOf(Command.delete));
    mapButton.setActionCommand(String.valueOf(Command.map));
    statusButton.setActionCommand(String.valueOf(Command.status));
    helpButton.setActionCommand(String.valueOf(Command.help));
    manualButton.setActionCommand(String.valueOf(Command.manual));
  }


  /**
   * method that overrides the actionPerformed method of the ActionListener class.
   * the action commands will be the same as the captions used to create the buttons
   *
   * @param e ActionEvent that lead to the execution of this method.
   */
  @Override
  public void actionPerformed(ActionEvent e) {
    if(e.getActionCommand().equals(String.valueOf(Command.north))){

    } else if(e.getActionCommand().equals(String.valueOf(Command.south))){

    } else if(e.getActionCommand().equals(String.valueOf(Command.west))){

    } else if(e.getActionCommand().equals(String.valueOf(Command.east))){

    } else if(e.getActionCommand().equals(String.valueOf(Command.find))){

    } else if(e.getActionCommand().equals(String.valueOf(Command.fight))){

    } else if(e.getActionCommand().equals(String.valueOf(Command.run))){

    } else if(e.getActionCommand().equals(String.valueOf(Command.bagFight))){

    } else if(e.getActionCommand().equals(String.valueOf(Command.bag))){

    } else if(e.getActionCommand().equals(String.valueOf(Command.use))){

    } else if(e.getActionCommand().equals(String.valueOf(Command.delete))){

    } else if(e.getActionCommand().equals(String.valueOf(Command.map))){

    } else if(e.getActionCommand().equals(String.valueOf(Command.status))){

    } else if(e.getActionCommand().equals(String.valueOf(Command.help))){

    } else if(e.getActionCommand().equals(String.valueOf(Command.manual))){

    } else {
      out("Unknown command!\"" + e.getActionCommand() + "\"");
    }
  }

  /**
   * method to have a quick way for appending text to the current text inside of the output area.
   *
   * @param text String text that needs to be appended.
   */
  private void out(String text){
    outputArea.append(text);
  }

  /**
   * main method to get everything going. starts the gui within the designated thread.
   *
   * @param args .
   */
  public static void main(String[] args) {
    try {
      UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    } catch (ClassNotFoundException | InstantiationException |
        UnsupportedLookAndFeelException | IllegalAccessException e) {
      e.printStackTrace();
    }
    JComponent.setDefaultLocale(Locale.ENGLISH);
    SwingUtilities.invokeLater(new Runnable() {
      @Override
      public void run() {
        new MainGUI();
      }
    });
  }
}
