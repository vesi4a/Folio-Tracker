package com.team11.Tracker.Controller;

import com.team11.Tracker.View.UserInterface;

/**
 * Created by Cameron on 02/12/14.
 */
public class InterfaceController {

    public InterfaceController() {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                UserInterface.show();
            }
        });
    }
}
