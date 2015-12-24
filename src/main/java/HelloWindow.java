import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.*;

public class HelloWindow {
  JFrame    frame     = new JFrame();
  JMenuBar  menuBar   = new JMenuBar();
  JMenu     helloMenu = new JMenu("Get Greeting");
  JMenuItem helloItem = new JMenuItem("Say Hello");
  JMenu     exitMenu  = new JMenu("Exit");
  JMenuItem closeItem = new JMenuItem("Close");
  Image     imageIcon = null;

  public HelloWindow() {
    // Create a new menubar
    frame.setJMenuBar(menuBar);
    // Create a new Menu with a sub-menu that calls a default information box
    menuBar.add(helloMenu);
    helloMenu.add(helloItem);
    helloItem.setToolTipText("Call info box");
    helloItem.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent event) {
        JOptionPane.showMessageDialog(null, "Hello, Codenvy User!");
      }
    });
    // Create a menu, with sub-menu item, and use ActionListener and ActionEvent
    // to use hotkeys to close an app
    menuBar.setToolTipText("This Is A Menubar");
    menuBar.add(exitMenu);
    exitMenu.add(closeItem);
    closeItem.setMnemonic(KeyEvent.VK_Q);
    closeItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q,
        ActionEvent.CTRL_MASK));
    closeItem.setToolTipText("Exit this app");
    closeItem.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent event) {
        System.exit(0);
      }
    });
    // make the frame half the height and width
    ScreenSizer screen = new ScreenSizer();
    frame.setSize(screen.w() / 2, screen.h() / 2);
    // Center the jframe on screen
    BasicPoint pt = new BasicPoint(500,500);
    frame.setLocation(pt.x(), pt.y());
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

  public void setImg(Image img) {
    imageIcon = img;
  }
  public Image  findImg(String address) {
    // Use image from URL
    try {
      Image img = ImageIO.read(new URL(address));
      return img;
    } catch (IOException e) {
      e.printStackTrace();
    }
    return null;
  }

  public void draw(Company comp) {
    frame.setTitle(comp.getName());

    // get image if not gotten
    if (imageIcon == null)
      setImg (findImg("https://upload.wikimedia.org/wikipedia/en/f/fa/Codenvy_Logo.jpg"));

    // Add a new JLabel
    JLabel label = new JLabel(new ImageIcon(imageIcon));
    frame.getContentPane().add(label);

    frame.setVisible(true);
  }
}
