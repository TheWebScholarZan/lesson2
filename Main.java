/**
 * @author Bothe Schwarz
 * @email bschwarz2@uco.edu
 * @student ID *20465788
 * @create date 2021-09-04 11:46:51
 * @modify date 2021-09-04 11:46:51
 * @desc [OOP Lesson 2]
 */

import javax.swing.JFrame;

import view.MenuScreen;

 public class Main
 {
    public static void main(String[] args) 
     {
         JFrame window = new JFrame();
         window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         window.setLocation(400, 100);

        var menu = new MenuScreen(window);
        menu.init();

        window.pack();
        window.setVisible(true);
     }
 }