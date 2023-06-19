/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Notificacion;

import java.awt.AWTException;
import java.awt.Image;
import java.awt.MenuItem;
import Vista.Login;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;

/**
 *
 * @author Ville
 */
public class Notificacion {

   private Image image = new ImageIcon(getClass().getResource("/Img/codesale.png")).getImage();
    private final TrayIcon trayIcon = new TrayIcon(image, "Aplicación Java");
    private final SystemTray systemtray = SystemTray.getSystemTray();
    private boolean band;
    
    public Notificacion() {
        if (SystemTray.isSupported()) {
            MouseListener mouseListener = new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent evt) {
                    if (evt.getButton() == MouseEvent.BUTTON1) {
                        trayIcon.displayMessage("Sesion Iniciada", "Bienvenido "+Login.TxtUsuario.getText(), TrayIcon.MessageType.INFO);
                    }
                }
                @Override
                public void mouseEntered(MouseEvent evt) {}
                @Override
                public void mouseExited(MouseEvent evt) {}
                @Override
                public void mousePressed(MouseEvent evt) {}
                @Override
                public void mouseReleased(MouseEvent evt) {}
            };
            MenuItem salirItem = new MenuItem("Salir");
            salirItem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.exit(0);
                }
            });
            PopupMenu popup = new PopupMenu();
            popup.add(salirItem);
            trayIcon.setPopupMenu(popup);
            trayIcon.setImageAutoSize(true);
            trayIcon.addMouseListener(mouseListener);
            try {
                systemtray.add(trayIcon);
            } catch (AWTException e) {
                System.err.println("Error:" + e.getMessage());
            }
        } else {
            System.err.println("Error: SystemTray no es soportado");
        }
    }
    
    public void showNotification() {
        if (!band) {
            trayIcon.displayMessage("Sesion Iniciada", "Bienvenido "+Login.TxtUsuario.getText(), TrayIcon.MessageType.INFO);
        }
        band = true;
    }
}
