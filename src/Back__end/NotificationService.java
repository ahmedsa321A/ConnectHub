/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Back__end;

import Front__end.GroupWindow;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
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
    public  void createfriendrequestnotification(JPanel request,String id)
    {
    ArrayList<Notification> notifications = ndb.getNotifications(id);
    request.setLayout(new BoxLayout(request, BoxLayout.Y_AXIS));
    for (Notification n : notifications) {
        if(n.getNotificationtype().equals("Friend"))
        {
        ArrayList<String> requestData = userService.getPathAndName(n.getSenderuserid());
        String name = requestData.get(0);
        String photoPath = requestData.get(1);
        String content = "Sent a Friend Request";
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
        JLabel nameLabel = new JLabel("<html>"+name+"<br>"+content+"</html>");
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
    public  void createapprovednotification(JPanel request,String id)
    {
    ArrayList<Notification> notifications = ndb.getNotifications(id);
    request.setLayout(new BoxLayout(request, BoxLayout.Y_AXIS));
    for (Notification n : notifications) {
        if(n.getNotificationtype().equals("Approved"))
        {
        GroupDatabase.loadGroupsFromJson();
        Group group=GroupDatabase.getGroupById(n.getSenderuserid());
        String name = group.getName();
        String photoPath = group.getGroupPhotoPath();
        String content = "your request has been accepted in";
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
        JButton removeButton = new JButton("Remove");
        removeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/trash.png")));
        JPanel requestPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        ImageIcon imgicon = saveImageIconGroup(photoPath);
        JLabel imageLabell = new JLabel(imgicon);
        JLabel nameLabel = new JLabel("<html>"+content+"<br>"+name+"</html>");
        JLabel dateLabel = new JLabel(date);
                removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ndb.removenotification(n);
                ndb.savenotifications();
                request.remove(requestPanel);
                request.revalidate();
                request.repaint();
            }
        });
        dateLabel.setFont(new Font("Arial", Font.BOLD, 12));
        requestPanel.add(imageLabell);
        requestPanel.add(nameLabel);
        requestPanel.add(dateLabel);
        requestPanel.add(removeButton);
        request.add(requestPanel);
    }
    }
}
    public ImageIcon saveImageIconGroup(String photoPath) {
        ImageIcon imgicon;
        if (photoPath.equals("")) {
            imgicon = new javax.swing.ImageIcon(getClass().getResource("/icons/nogroup.png"));
        } else {
            imgicon = new ImageIcon(photoPath);
        }
        Image image = imgicon.getImage();
        Image resizedImage = image.getScaledInstance(45, 45, Image.SCALE_SMOOTH); // Resize to fit
        imgicon = new ImageIcon(resizedImage);
        return imgicon;
    }
    public  void createpostnotification(JPanel request,String id)
    {
    ArrayList<Notification> notifications = ndb.getNotifications(id);
    request.setLayout(new BoxLayout(request, BoxLayout.Y_AXIS));
    for (Notification n : notifications) {
        if(n.getNotificationtype().equals("Created"))
        {
        GroupDatabase.loadGroupsFromJson();
        Group group=GroupDatabase.getGroupById(n.getSenderuserid());
        String name = group.getName();
        String photoPath =group.getGroupPhotoPath();
        String contant = "The post has been created by "+userService.getUser(n.getReceiveruserid()).getUsername()+" in";
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
        ImageIcon imgicon = saveImageIconGroup(photoPath);
        MyButton button=new MyButton();
        button.setIcon(imgicon);
        button.setRedius(50);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GroupWindow g=new GroupWindow(group,userService.getUser(n.getReceiveruserid()));
                
            }
        });
        JLabel nameLabel = new JLabel("<html>"+contant+"<br>"+name+"</html>");
        JLabel dateLabel = new JLabel(date);
        dateLabel.setFont(new Font("Arial", Font.BOLD, 12));
        JButton removeButton = new JButton("Remove");
        removeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/trash.png")));
       removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ndb.removenotification(n);
                ndb.savenotifications();
                request.remove(requestPanel);
                request.revalidate();
                request.repaint();
            }
        });
        requestPanel.add(button);
        requestPanel.add(nameLabel);
        requestPanel.add(dateLabel);
        requestPanel.add(removeButton);
        request.add(requestPanel);
        }
    }
}
}
    

