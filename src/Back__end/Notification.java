/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Back__end;

import com.google.gson.reflect.TypeToken;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author hazembarakat
 */
public class Notification {
    private String senderuserid;
    private String receiveruserid;
    private String date;
    public Notification(String senderuserid, String receiveruserid, String date) {
        this.senderuserid = senderuserid;
        this.receiveruserid = receiveruserid;
        this.date = date;
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
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    
    
}
