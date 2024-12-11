/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Back__end;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author hazembarakat
 */
public class Notification {
    private String senderuserid;
    private String receiveruserid;
    private String timestamp;
    public Notification(String senderuserid, String receiveruserid) {
        this.senderuserid = senderuserid;
        this.receiveruserid = receiveruserid;
        this.timestamp = LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME);
    }

    public String getSenderuserid() {
        return senderuserid;
    }

    public void setSenderuserid(String senderuserid) {
        this.senderuserid = senderuserid;
    }

    public String getReceiveruserid() {
        return receiveruserid;
    }

    public void setReceiveruserid(String receiveruserid) {
        this.receiveruserid = receiveruserid;
    }

    public String getDate() {
        return this.timestamp;
    }

    public void setDate(String date) {
        this.timestamp = date;
    }
    
    
}
