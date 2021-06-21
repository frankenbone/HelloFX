import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

import javax.swing.JTextField;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;
import javax.swing.text.JTextComponent;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Labeled;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.text.*;
import javafx.scene.control.*;
import java.lang.*;
import javafx.scene.layout.*;
import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import java.awt.*;         // Supplies layout manager
import java.awt.event.*;   // Supplies event classes
import javax.swing.*;      // Supplies class JApplet
import java.util.*;        // Supplies class Scanner
import java.applet.*;	   // Supplies class Applet



public class HelloFX extends Application {
	public static void main(String[] args) {
		launch(args);
		
		Stage window;
		Scene scene1, scene2;


	}

	@Override
	public void start(Stage primaryStage) {
		
		primaryStage.setTitle("Word Occurances - The Raven");
		Button btn = new Button();
		btn.setText("Click here to see word occurrances in 'The Raven'");
		btn.setOnAction(new EventHandler<ActionEvent>() {

			private Labeled display;

			@Override
			public void handle(ActionEvent event) {
				//file location 
				File fin = new File("src/Raven");

				//Setup a Scanner to read the file
				Scanner fileScan = null;
				try {
					fileScan = new Scanner(fin);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				//setup a HashMap with String, Integer
				Map<String,Integer> map = new HashMap<String, Integer>(); 

				while (fileScan.hasNext())
				{
					String val = fileScan.next(); 
					if(map.containsKey(val) == false) // if string is not inserted in the map yet, insert by setting the frequency as 1
						map.put(val,1);//val of 1

					else //or set val to 1
					{
						int count = (int)(map.get(val)); // find frequency of word
						map.remove(val);  // remove the entry from map
						map.put(val,count+1); // re-inserting word and increase frequency by 1 increment
					}

				}

				//Retrieve map 
				Set<Map.Entry<String, Integer>> set = map.entrySet(); 
				//Make ArrayList and initialize ArrayList 
				List<Map.Entry<String, Integer>> sortList = new ArrayList<Map.Entry<String, Integer>>(set);
				//Sort ArrayList
				Collections.sort( sortList, new Comparator<Map.Entry<String, Integer>>() 

				{
					public int compare( Map.Entry<String, Integer> a, Map.Entry<String, Integer> b ) 

					{
						// sortList in descending order 
						return ( b.getValue()).compareTo( a.getValue() );

					}

				} );


				//Print out the list
				
				class MessageConsole
				{
					private JTextComponent textComponent;
					private Document document;
					private boolean isAppend;
					private DocumentListener limitLinesListener;

					public MessageConsole(JTextComponent textComponent)
					{
						this(textComponent, true);
						for(Map.Entry<String, Integer> i:sortList){
							
							

							System.out.println("The word: " + i.getKey()+" - occurs this many times: "+ i.getValue());

						}
					}

					public MessageConsole(JTextComponent textComponent2, boolean b) {
						// TODO Auto-generated constructor stub
					}
				}


				for(Map.Entry<String, Integer> i:sortList){
					
				

					System.out.println("The word: " + i.getKey()+" - occurs this many times: "+ i.getValue());

				}

			}


		});

		StackPane root = new StackPane();
		root.getChildren().add(btn);
		primaryStage.setScene(new Scene(root, 900, 500));
		primaryStage.show();
	}

	
	}
