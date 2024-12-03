package Back__end;

import java.awt.Image;
import java.io.File;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Photo {

    public static String selectPhoto(JLabel Label, JDialog frame) {
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Image Files (JPG, PNG, JPEG)", "jpg", "jpeg", "png");
        fileChooser.setFileFilter(filter);
        int response = fileChooser.showOpenDialog(frame);
        if (response == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            String filePath = file.getAbsolutePath().toLowerCase();
            if (!filePath.endsWith(".jpg") && !filePath.endsWith(".jpeg") && !filePath.endsWith(".png")) {
                JOptionPane.showMessageDialog(frame, "Invalid Extension", "Invalid File", JOptionPane.ERROR_MESSAGE);
                return null;
            }
            return file.getAbsolutePath();
        }
        return null;
    }

    public static String selectPhoto(JLabel Label, JFrame frame) {
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Image Files (JPG, PNG, JPEG)", "jpg", "jpeg", "png");
        fileChooser.setFileFilter(filter);
        int response = fileChooser.showOpenDialog(frame);
        if (response == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            String filePath = file.getAbsolutePath().toLowerCase();
            if (!filePath.endsWith(".jpg") && !filePath.endsWith(".jpeg") && !filePath.endsWith(".png")) {
                JOptionPane.showMessageDialog(frame, "Invalid Extension", "Invalid File", JOptionPane.ERROR_MESSAGE);
                return null;
            }
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
