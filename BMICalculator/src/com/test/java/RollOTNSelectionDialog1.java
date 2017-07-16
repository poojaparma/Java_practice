package com.test.java;


import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;


/**
 * DOCUMENT ME!
 */
public class RollOTNSelectionDialog1
        extends JDialog
        implements ActionListener {


    /**
     * Dialog title
     */
    public static final String TITLE = "Select a Member Circuit to Roll";

    /**
     * Button
     */
    private JButton createButton;
    private JButton cancelButton;
    private JComboBox expPathCB;

    /**
     * Table
     */

    /**
     * Other variables
     */
    private Object[] selectedMemberCkt;
    private boolean create = false;

    /**
     * Create the dialog.
     *
     * @param frame +
     * @param ckt +
     */
    public RollOTNSelectionDialog1(Frame frame,
                                  Object[] ckt) {
        super(frame, TITLE, true);

        addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent evt) {
                    dispose();
                }
            });



      
        //otnDataSource.setEnabled(true);

     
        //table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
     
        init(frame, ckt);
    }

    /**
     * DOCUMENT ME!
     *
     * @param frame +
     * @param ckt +
     */
    public void init(Frame frame,
                     Object[] ckt) {
        Container contents = this.getContentPane();
        contents.setLayout(new BorderLayout());

        JPanel tablePanel = new JPanel(new BorderLayout());
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setPreferredSize(new Dimension(300, 150));
        tablePanel.add(scrollPane);

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new BorderLayout());

      

        JPanel jc = new JPanel();
        jc.setLayout(new FlowLayout(FlowLayout.LEFT));

       
        JLabel jl = new JLabel("Explicit Path : ");
        expPathCB = new JComboBox();
       
        expPathCB.setPreferredSize(new Dimension(150, 20));
        expPathCB.setEditable(false);
     expPathCB.setMaximumRowCount(2);
        //   JScrollPane scrollPane1 = new JScrollPane(expPathCB);
       // scrollPane1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        jc.add(jl, FlowLayout.LEFT);
      
        JScrollPane pane = new JScrollPane(null,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        String[] paths ={"path","hello","Hi"/*,"path","hello","Hi","path","hello","Hi","path","hello","Hi"*/};
        jc.add(expPathCB);
        if ((paths == null) || (paths.length == 0)) {
            expPathCB.addItem("None");
        } else if ((paths != null) && (paths.length > 0)) {

            for (String expPathData : paths) {
                expPathCB.addItem(expPathData);
           
            }
        }
       JPanel buttonPanel = new JPanel(new BorderLayout());

        JPanel buttonPanel1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        createButton = new JButton("Add");
        createButton.addActionListener(this);
        cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(this);
        buttonPanel1.add(createButton, FlowLayout.LEFT);
        buttonPanel1.add(cancelButton);

        JPanel buttonPanel2 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        Dimension dim = new Dimension(75, 25);
        Button helpButton = new Button("Help");
        helpButton.setMinimumSize(dim);
        helpButton.setMaximumSize(dim);

        buttonPanel2.add(helpButton);
        buttonPanel.add(buttonPanel1, BorderLayout.WEST);
        buttonPanel.add(buttonPanel2, BorderLayout.EAST);

        bottomPanel.add(jc, BorderLayout.NORTH);
        bottomPanel.add(buttonPanel, BorderLayout.SOUTH);

        contents.add(tablePanel, BorderLayout.NORTH);
        contents.add(bottomPanel, BorderLayout.SOUTH);

        setSize(new Dimension(900, 265));
        setResizable(true);
        setLocationRelativeTo(frame);
     
     
    }

   
    /**
     * DOCUMENT ME!
     *
     * @return +
     */
    public boolean isCreate() {
        return create;
    }

    /**
     * Implements ActionListener for dialog buttons
     *
     * @param e +
     */
    public void actionPerformed(ActionEvent e) {

        Object src = e.getSource();

        if (src == createButton) {

            if ("None".equalsIgnoreCase(expPathCB.getSelectedItem().toString())) {/*
                SwingUtilities.invokeLater(new Runnable() {

                        public void run() {
                            Dialog.errorDialog(null,
                                                     "No Explicit Path selected",
                                                     "No Explicit Path selected");
                        }
                    });
                return;
            */}

            create = true;
            dispose();
        } else if (src == cancelButton) {
            dispose();
        }
    }

    /**
     * DOCUMENT ME!
     *
     * @return +
     */
 
    /**
     * DOCUMENT ME!
     *
     * @return +
     */
    public JComboBox getExpPathCB() {
        return expPathCB;
    }

    /**
     * DOCUMENT ME!
     *
     * @param expPathCB +
     */
    public void setExpPathCB(JComboBox expPathCB) {
        this.expPathCB = expPathCB;
    }
    public static void main(String[] args) {
    	Frame frame = new Frame("Testing");
    	frame.setSize(965, 265);
    	//frame.setVisible(true);
    	frame.setLayout(new BorderLayout());
    	
    	Object[] obj = {"T1","t2","t3","t4","t5"};
    	RollOTNSelectionDialog1 rtl= new RollOTNSelectionDialog1(frame, obj);
    	   String[] values ={"hello","Hi","common","dude","india","usa","namaste","bus","train" ,"baelGaadi"};
    	DefaultComboBoxModel dfd = new DefaultComboBoxModel(values);
	     JComboBox jb = new JComboBox(dfd);
	   //     rtl.setExpPathCB(jb);
    	rtl.setVisible(true);
	   
    }
}

