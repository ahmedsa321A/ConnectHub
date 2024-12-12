/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Back__end;


/**
 *
 * @author hazembarakat
 */
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Notification {
    
    private  String notificationtype;
    private  String senderuserid;
    private  String receiveruserid;
    private  String timestamp;

    
    private Notification(Builder builder) {
        this.senderuserid = builder.senderuserid;
        this.receiveruserid = builder.receiveruserid;
        this.timestamp = builder.timestamp != null
                ? builder.timestamp
                : LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME);
        this.notificationtype = builder.notificationtype;
    }

    public String getSenderuserid() {
        return senderuserid;
    }

    public String getReceiveruserid() {
        return receiveruserid;
    }

    public String getDate() {
        return timestamp;
    }

    public String getNotificationtype() {
        return notificationtype;
    }

    public void setNotificationtype(String notificationtype) {
        this.notificationtype = notificationtype;
    }
     public void setSenderuserid(String senderuserid) {
        this.senderuserid = senderuserid;
    }

    public void setReceiveruserid(String receiveruserid) {
        this.receiveruserid = receiveruserid;
    }

    public void setDate(String date) {
        this.timestamp = date;
    }

    public static class Builder {
        private String senderuserid;
        private String receiveruserid;
        private String timestamp;
        private String notificationtype;
        
        
        public Builder setSenderuserid(String senderuserid) {
            this.senderuserid = senderuserid;
            return this; 
        }
        
        public Builder setNotificationtype(String notificationtype) {
            this.notificationtype = notificationtype;
            return this; 
        }
       
        public Builder setReceiveruserid(String receiveruserid) {
            this.receiveruserid = receiveruserid;
            return this; 
        }

        public Builder setTimestamp(String timestamp) {
            this.timestamp = timestamp;
            return this; 
        }

        public Notification build() {
            return new Notification(this);
        }
    }
}
