package com.test.java;

import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;

public class CombBoxExample
extends 	JFrame
{
	public CombBoxExample(){
		super("Combo Scroll");
		setSize(400,600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		FlowLayout flo = new FlowLayout();
		setLayout(flo);
 
		String[] contents = new String[]{"Alem", "Habtam", "Desta", "Almaz", 
				"Zewdit", "Abraham", "Tsehaye"};
		JScrollBar pane = new JScrollBar();
		JComboBox list = new JComboBox(contents);
		pane.add(list);
		add(pane);
 
		setVisible(true);
	}
 
	//run
	public static void main(String[] args){
		CombBoxExample pane = new CombBoxExample();
	}}
