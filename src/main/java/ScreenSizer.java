import java.awt.*;

public class ScreenSizer {
  Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
  int       height     = screenSize.height;
  int       width      = screenSize.width;

  public int h() {
    return height;
  }

  public int w() {
    return width;
  }
}