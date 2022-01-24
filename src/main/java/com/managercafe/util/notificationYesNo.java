/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.managercafe.util;

import java.awt.Component;
import javax.swing.JOptionPane;

/**
 *
 * @author huy
 */
public class notificationYesNo {
    public  notificationYesNo()
    {   
    }
    public int QuestionYesNo(Component parent,String message)
    {
        int result = JOptionPane.showConfirmDialog(parent, message,"Noti",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
        return result;
    }
    public void NotiSuccess(Component parent,String message){
        JOptionPane.showConfirmDialog(parent, message,"Noti",JOptionPane.INFORMATION_MESSAGE);
    }
    public void NotiError(Component parent,String message){
        JOptionPane.showConfirmDialog(parent, message,"Noti",JOptionPane.ERROR_MESSAGE);
    }
    public void Noti(Component parent,String message){
        JOptionPane.showConfirmDialog(parent, message,"Noti",JOptionPane.ERROR_MESSAGE);
    }
}
