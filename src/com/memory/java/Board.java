package com.memory.java;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class Board extends JFrame{


    private ArrayList<Card> cards;
    private Card selectedCard;
    private Card c1;
    private Card c2;
    private Timer t;
	public int w;
	public int h;

    public Board(){
    	
        ArrayList<Card> cardsList = new ArrayList<Card>();
        ArrayList<Integer> cardVals = new ArrayList<Integer>();

        for (int i = 0; i < h*w; i++){
            cardVals.add(i);
            cardVals.add(i);
        }
        Collections.shuffle(cardVals);

        for (int val : cardVals){
            Card c = new Card();
            c.setId(val);
            c.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent ae){
                    selectedCard = c;
                    doTurn();
                }
            });
            cardsList.add(c);
        }
        this.cards = cardsList;
        //set up the timer
        t = new Timer(500, new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                checkCards();
            }
        });

        t.setRepeats(false);

        //set up the board itself
        
        Container pane = getContentPane();
        pane.setLayout(new GridLayout(5, 5));
        for (Card c : cards){
            pane.add(c);
        }
        setTitle("Memory Match");
    }

    public void doTurn(){
        if (c1 == null && c2 == null){
            c1 = selectedCard;
            c1.setText(String.valueOf(c1.getId()));
        }

        if (c1 != null && c1 != selectedCard && c2 == null){
            c2 = selectedCard;
            c2.setText(String.valueOf(c2.getId()));
            t.start();

        }
    }

    public void checkCards(){
        if (c1.getId() == c2.getId()){// Condition pour une paire
            c1.setEnabled(false); // Désactiver le boutton
            c2.setEnabled(false);
            c1.setMatched(true);
            c2.setMatched(true);
            if (this.isGameWon()){
                JOptionPane.showMessageDialog(this, "Vous avez gagné !");
                System.exit(0);
            }
        }

        else{
            c1.setText("");
            c2.setText("");
        }
        c1 = null; //Reset C1 et C2
        c2 = null;
    }

    public boolean isGameWon(){
        for(Card c: this.cards){
            if (c.getMatched() == false){
                return false;
            }
        }
        return true;
    }

}