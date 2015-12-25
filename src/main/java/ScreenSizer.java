import java.awt.Dimension;
import java.awt.Toolkit;

public class ScreenSizer {
  private int height;
  private int width;

  public ScreenSizer() {
    final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    height = screenSize.height;
    width = screenSize.width;
  }

  public int h() {
    return height;
  }

  public int w() {
    return width;
  }
}