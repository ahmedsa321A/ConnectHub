package Back__end;

import javax.swing.JButton;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;

public class MyButton extends JButton {

    public MyButton() {
        setColor(new Color(242,242,242));
        colorover = new Color(242,242,242);
        bordercolor = new Color(242,242,242);
        setContentAreaFilled(false); // Make the button transparent
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent me) {
                setBackground(colorover);
                over = true;
            }

            @Override
            public void mouseExited(MouseEvent me) {
                setBackground(color);
                over = false;
            }

            @Override
            public void mousePressed(MouseEvent me) {
                setBackground(colorclick);
            }

            @Override
            public void mouseReleased(MouseEvent me) {
                if (over) {
                    setBackground(colorover);
                } else {
                    setBackground(color);
                }
            }

        });
    }

    private boolean over;
    private Color color;
    private Color colorover;
    private Color colorclick;
    private Color bordercolor;
    private int redius = 0;

    public boolean isOver() {
        return over;
    }

    public void setOver(boolean over) {
        this.over = over;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
        setBackground(color);
    }

    public Color getColorover() {
        return colorover;
    }

    public void setColorover(Color colorover) {
        this.colorover = colorover;
    }

    public Color getColorclick() {
        return colorclick;
    }

    public void setColorclick(Color colorclick) {
        this.colorclick = colorclick;
    }

    public Color getBordercolor() {
        return bordercolor;
    }

    public void setBordercolor(Color bordercolor) {
        this.bordercolor = bordercolor;
    }

    public int getRedius() {
        return redius;
    }

    public void setRedius(int redius) {
        this.redius = redius;
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.fill(new Ellipse2D.Double(100, 100, 50, 50));
        super.paintComponent(g);
    }

    @Override
    protected void paintBorder(Graphics g) {
        g.setColor(getForeground());
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(bordercolor);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), redius, redius);
        g2.setColor(getBackground());
        g2.fillRoundRect(2, 2, getWidth() - 4, getHeight() - 4, redius, redius);
        super.paintComponent (g);
    }

}
