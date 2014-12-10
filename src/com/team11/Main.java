package com.team11;


import com.team11.Tracker.Controller.Controller;
import com.team11.Tracker.Model.Portfolio;
import com.team11.Tracker.View.View;


public class Main {
    public static void main(String[] args) {
        View view = new View();

        Portfolio model = new Portfolio("Portfolio1");

        Controller controller = new Controller(view, model);

    }
}
