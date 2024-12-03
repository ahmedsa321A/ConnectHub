package Back__end;

import java.awt.Image;
import java.io.File;
import javax.swing.*;

public class Photo {

    public static String changePhoto(JLabel Label, JDialog frame) {
        JFileChooser fileChooser = new JFileChooser();
        int response = fileChooser.showOpenDialog(frame);
        if (response == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            if (!file.getAbsolutePath().endsWith(".png") && !file.getAbsolutePath().endsWith(".jpeg")) {
                JOptionPane.showMessageDialog(frame, "Invalid Extension", "Invalid File", JOptionPane.ERROR_MESSAGE);
                return null;
            }
            ImageIcon imgIcon = new ImageIcon(file.getAbsolutePath());
            Image image = imgIcon.getImage();
            Image scaledImage = image.getScaledInstance(Label.getWidth(), Label.getHeight(), Image.SCALE_SMOOTH);
            imgIcon = new ImageIcon(scaledImage);
            Label.setIcon(imgIcon);
            Label.setHorizontalAlignment(SwingConstants.CENTER);
            Label.setVerticalAlignment(SwingConstants.CENTER);
            return file.getAbsolutePath();
        }
        return null;
    }

    public static void setPhoto(JLabel Label, String imagePath) {
        ImageIcon imgIcon = new ImageIcon(imagePath);
        Image image = imgIcon.getImage();
        Image scaledImage = image.getScaledInstance(Label.getWidth(), Label.getHeight(), Image.SCALE_SMOOTH);
        imgIcon = new ImageIcon(scaledImage);
        Label.setIcon(imgIcon);
        Label.setHorizontalAlignment(SwingConstants.CENTER);
        Label.setVerticalAlignment(SwingConstants.CENTER);
    }
}
