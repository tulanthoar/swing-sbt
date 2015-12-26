import java.awt.*;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.*;

public class HelloWindow {
  private JFrame    frame     = new JFrame();
  private boolean hasImg = false;

  public HelloWindow() {
    // make the frame half the height and width
    ScreenSizer dims = new ScreenSizer();
    frame.setSize(dims.w() / 2, dims.h() / 2);
    // Center the jframe on screen
    BasicPoint mid = new BasicPoint(500, 500);
    frame.setLocation(mid.x(), mid.y());
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    JMenuBar  menuBar   = new JMenuBar();
    menuBar.add(HelloMenu.apply());
    menuBar.add(ExitMenu.apply());
    menuBar.setToolTipText("This Is A Menubar");
    frame.setJMenuBar(menuBar);
  }

  public static void putGreeting( JMenuItem hi ) {
    hi.addActionListener(
        (e) -> {JOptionPane.showMessageDialog(null, "Hello, Codenvy User!");});
  }
  
  public static void putExit( JMenuItem bye ) {
    bye.addActionListener( (e) -> {System.exit(0);} );
  }
  
  public void setImg(Image img) {
    JLabel label = new JLabel(new ImageIcon(img));
    frame.getContentPane().add(label);
    hasImg = true;
  }

  public void findImg(String address) {
    // Use image from URL
    try {
      setImg( ImageIO.read(new URL(address)));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void draw(Company comp) {
    frame.setTitle(comp.getName());

    // get image if not gotten
    if ( !hasImg )
      findImg("https://upload.wikimedia.org/wikipedia/en/f/fa/Codenvy_Logo.jpg");

    // Add a new JLabel

    frame.setVisible(true);
  }
}
