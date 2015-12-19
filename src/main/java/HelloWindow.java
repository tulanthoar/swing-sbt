import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.*;

public class HelloWindow {
	JFrame frame = new JFrame();
	Image imageIcon = null;
	JMenuBar menuBar = new JMenuBar();
	JMenu menu1 = new JMenu("Get Greeting");
	JMenuItem helloName = new JMenuItem("Say Hello");
	JMenu menu = new JMenu("Exit");
	JMenuItem mntmClose = new JMenuItem("Close");
private void setup() {
	// Create a new menubar
	frame.setJMenuBar(menuBar);
	// Create a new Menu with a sub-menu that calls a default information box
	menuBar.add(menu1);
	menu1.add(helloName);
	helloName.setToolTipText("Call info box");
	helloName.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent event) {
			JOptionPane.showMessageDialog(null, "Hello, Codenvy User!");
		}
	});
	// Create a menu, with sub-menu item, and use ActionListener and ActionEvent to use hotkeys to close an app
	menuBar.setToolTipText("This Is A Menubar");
	menuBar.add(menu);
	mntmClose.setMnemonic(KeyEvent.VK_Q);
	mntmClose.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, ActionEvent.CTRL_MASK));
	mntmClose.setToolTipText("Exit this app");
	mntmClose.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent event) {
			System.exit(0);
		}
	});
	menu.add(mntmClose);
	// make the frame half the height and width
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	int height = screenSize.height;
	int width = screenSize.width;
	frame.setSize(width / 2, height / 2);
	// Center the jframe on screen
	frame.setLocationRelativeTo(null);
}
	public void find_img(String address) {
        // Use image from URL
        try {
            URL url = new URL(address);
            imageIcon = ImageIO.read(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
    public void draw(Company comp) {
    	setup();
        frame.setTitle(comp.getName());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // get image if not gotten
        if( imageIcon == null ) find_img("https://upload.wikimedia.org/wikipedia/en/f/fa/Codenvy_Logo.jpg");

        // Add a new JLabel
        JLabel label = new JLabel(new ImageIcon(imageIcon));
        frame.getContentPane().add(label);

        frame.setVisible(true);
    }
}
