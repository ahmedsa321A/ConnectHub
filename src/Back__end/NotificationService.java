/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Back__end;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class NotificationService {
    NotificationDatabase ndb= NotificationDatabase.getInstance();
    public  void creatfriendrequestnotification(JPanel request,String id)
    {
    ArrayList<Notification> notifications = ndb.getNotifications(id);
    request.setLayout(new BoxLayout(request, BoxLayout.Y_AXIS));
    for (Notification n : notifications) {
        ArrayList<String> requestData = userService.getPathAndName(n.getSenderuserid());
        String name = requestData.get(0);
        String photoPath = requestData.get(1);
        String contant = "Sent a Friend Request";
        LocalDateTime currentTime = LocalDateTime.now();
        LocalDateTime parsedTime = LocalDateTime.parse(n.getDate(), DateTimeFormatter.ISO_DATE_TIME);
        long differenceInMinutes = ChronoUnit.MINUTES.between(parsedTime, currentTime);
        long differenceInHours = ChronoUnit.HOURS.between(parsedTime, currentTime);
        long differenceInDays = ChronoUnit.DAYS.between(parsedTime, currentTime);
        String date;
      
        if (differenceInMinutes < 60) {
            date = differenceInMinutes + " Mins ago";
        } else if (differenceInHours < 24) {
            date = differenceInHours + " Hours ago";
        } else {
            date = differenceInDays + " Days ago";
        }
        
        JPanel requestPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        ImageIcon imgicon = new userService().saveImageIconProfile(photoPath);
        JLabel imageLabell = new JLabel(imgicon);
        JLabel nameLabel = new JLabel("<html>"+name+"<br>"+contant+"</html>");
        JLabel dateLabel = new JLabel(date);
        dateLabel.setFont(new Font("Arial", Font.BOLD, 12));
        JButton acceptButton = new JButton("Accept");
        acceptButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/accept.png")));
        JButton declineButton = new JButton("Decline");
        declineButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/cancel.png")));
        acceptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new FriendRequests().acceptRequest(userService.getUser(n.getReceiveruserid()), userService.getUser(n.getSenderuserid()));
                UserRepository.saveData();
                ndb.removenotification(n);
                ndb.savenotifications();
                request.remove(requestPanel);
                request.revalidate();
                request.repaint();
            }
        });

        declineButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new FriendRequests().declineRequest(userService.getUser(n.getReceiveruserid()), userService.getUser(n.getSenderuserid()));
                UserRepository.saveData();
                ndb.removenotification(n);
                ndb.savenotifications();
                request.remove(requestPanel);
                request.revalidate();
                request.repaint();
            }
        });
        requestPanel.add(imageLabell);
        requestPanel.add(nameLabel);
        requestPanel.add(dateLabel);
        requestPanel.add(acceptButton);
        requestPanel.add(declineButton);
        request.add(requestPanel);
    }
    }
    
    
}
