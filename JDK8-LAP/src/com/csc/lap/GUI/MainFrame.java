package com.csc.lap.GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import net.miginfocom.layout.CC;
import net.miginfocom.layout.LC;
import net.miginfocom.swing.MigLayout;

import com.csc.lap.common.Constants;
import com.csc.lap.features.completablefuture.PipelinedProducersTest;
import com.csc.lap.features.completablefuture.SingleProducerTest;
import com.csc.lap.features.datetime.DateTimeExamplesJava8;
import com.csc.lap.features.defaultmethod.DefaultMethodTest;
import com.csc.lap.features.forkjoin.ForkJoinTest;
import com.csc.lap.features.lambda.AgorithmExecutor;
import com.csc.lap.features.lambda.BasicLambda;
import com.csc.lap.features.lambda.ComposingLambdaExpressionTest;
import com.csc.lap.features.methodref.Sorting;
import com.csc.lap.features.nashorn.Nashorn;
import com.csc.lap.features.optional.OptionalMain;
import com.csc.lap.features.stream.BuildingStreams;
import com.csc.lap.features.stream.Filtering;
import com.csc.lap.features.stream.Grouping;
import com.csc.lap.features.stream.Laziness;
import com.csc.lap.features.stream.Reducing;
import com.csc.lap.features.stream.StreamBasic;
import com.csc.lap.features.stream.Summarizing;

/**
 * 
 * @author ahmai
 * 
 */
public class MainFrame extends JFrame {

	// main panel
	JPanel contentPanel;
	BorderLayout borderLayout1 = new BorderLayout();
	BorderLayout borderLayout2 = new BorderLayout();
	JPanel jPanel1 = new JPanel();
	
	
	
	
	// 1st row
	JPanel jPanelLambda = new JPanel();
	JButton jLambdaBtn = new JButton();
	JButton jStreamBtn = new JButton();
	JButton jMethodRefBtn = new JButton();
	JButton jCompletablefutureBtn = new JButton();
	JButton jDateTimeBtn = new JButton();
	JButton jOptionalBtn = new JButton();
	JButton jNashornBtn = new JButton();
	JButton jMiscellaneousBtn = new JButton();
	
	
	// last row
	JPanel jPanelReport = new JPanel();
	JLabel jReportLabel = new JLabel();
		
	MemoryMonitor memorymonitor;

	/**
	 * 
	 */
	public MainFrame() {
		try {
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			initGUI();
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

	/**
	 * 
	 * @author Mai Hoang Anh
	 * 
	 * @id 00707161
	 * 
	 * @date Dec 15, 2008
	 * 
	 * @throws Exception
	 */
	private void initGUI() throws Exception {
		contentPanel = (JPanel) getContentPane();
		contentPanel.setLayout(borderLayout1);
		contentPanel.setBorder(new EtchedBorder());
		//borderLayout1.setVgap(5);
		//borderLayout2.setVgap(5);
		setSize(new Dimension(Constants.MAIN_FRAME_WIDTH_SIZE,
				Constants.MAIN_FRAME_HEIGHT_SIZE));
		setTitle(Constants.GUI_MAIN_FRAME_TITLE);
		jPanel1.setLayout(borderLayout2);
		// First row
		jPanelLambda.setLayout(new MigLayout(new LC().fill()));
		jPanelLambda.setBorder(new TitledBorder(new EtchedBorder(), "Java 8 - New features"));
		
		//Lambda 
		jLambdaBtn.setText("Lambda");
		jLambdaBtn.addActionListener(new MainFrame_Lambda_actionAdapter(this));
		jPanelLambda.add(jLambdaBtn, new CC().width("155lp"));
		
		//Stream
		jStreamBtn.setText("Stream API");
		jStreamBtn.addActionListener(new MainFrame_Stream_actionAdapter(this));
		jPanelLambda.add(jStreamBtn, new CC().width("155lp"));
		
		
		jMethodRefBtn.setText("Method Ref");
		jMethodRefBtn.addActionListener(new MainFrame_MethodRef_actionAdapter(this));
		jPanelLambda.add(jMethodRefBtn, new CC().width("155lp"));
		
		jCompletablefutureBtn.setText("CompletableFuture");
		jCompletablefutureBtn.addActionListener(new MainFrame_CompletableFuture_actionAdapter(this));
		jPanelLambda.add(jCompletablefutureBtn, new CC().width("155lp"));
		
		jDateTimeBtn.setText("New Date/Time API");
		jDateTimeBtn.addActionListener(new MainFrame_DateTime_actionAdapter(this));
		jPanelLambda.add(jDateTimeBtn, new CC().width("155lp"));
		
		jOptionalBtn.setText("Optional");
		jOptionalBtn.addActionListener(new MainFrame_Optional_actionAdapter(this));
		jPanelLambda.add(jOptionalBtn, new CC().width("155lp"));
		
		jNashornBtn.setText("Nashorn");
		jNashornBtn.addActionListener(new MainFrame_Nashorn_actionAdapter(this));
		jPanelLambda.add(jNashornBtn, new CC().width("155lp"));
		
		jMiscellaneousBtn.setText("Miscellaneuos");
		jMiscellaneousBtn.addActionListener(new MainFrame_Miscellaneous_actionAdapter(this));
		jPanelLambda.add(jMiscellaneousBtn, new CC().width("155lp"));
		
		
		// Last row
		jPanelReport.setLayout(new MigLayout(new LC().fill()));
		jPanelReport.setBorder(new TitledBorder(new EtchedBorder(), "Results"));
		jPanelReport.add(jReportLabel, new CC().alignX("left"));
		
		

		// Add monitor memory at right of window
		memorymonitor = new MemoryMonitor();
		WindowListener l = new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}

			public void windowDeiconified(WindowEvent e) {
				memorymonitor.monitor.start();
			}

			public void windowIconified(WindowEvent e) {
				memorymonitor.monitor.stop();
			}
		};
		this.addWindowListener(l);
		memorymonitor.monitor.start();
		
		contentPanel.add(jPanel1, java.awt.BorderLayout.NORTH);
		contentPanel.add(memorymonitor, java.awt.BorderLayout.SOUTH);

		jPanel1.add(jPanelLambda, java.awt.BorderLayout.NORTH);
		jPanel1.add(jPanelReport, java.awt.BorderLayout.SOUTH);

		// Create the menu bar.
		JMenuBar menuBar;
		JMenu menu, submenu;
		JMenuItem menuItem;

		// Create the menu bar.
		menuBar = new JMenuBar();

		// Build the main menu.
		menu = new JMenu(Constants.GUI_MAIN_FRAME_ACTION_MENU);
		menu.setMnemonic(KeyEvent.VK_A);

		
		// Run
		menuItem = new JMenuItem(Constants.GUI_MAIN_FRAME_lAMBDA_EXP_RUN_ITEM,
				KeyEvent.VK_R);
		menuItem.addActionListener(new MainFrame_Lambda_actionAdapter(this));
		menu.add(menuItem);
		menu.addSeparator();
		// Close
		menuItem = new JMenuItem(Constants.GUI_MAIN_FRAME_EXIT_ITEM,
				KeyEvent.VK_E);
		menuItem.addActionListener(new MainFrame_close_actionAdapter(this));
		menu.add(menuItem);

		menuBar.add(menu);

		// Build menu "Help" in the menu bar.
		menu = new JMenu(Constants.GUI_MAIN_FRAME_ABOUT_ITEM);
		menu.setMnemonic(KeyEvent.VK_H);
		menuItem = new JMenuItem(Constants.GUI_MAIN_FRAME_ABOUT_ITEM,
				KeyEvent.VK_A);
		menuItem.addActionListener(new Menu_About_actionAdapter(this));
		menu.add(menuItem);

		menuBar.add(menu);

		this.setJMenuBar(menuBar);

	}

	
	

	
	

	/**
	 * 
	 * @author ahmai
	 * 
	 */
	class MainFrame_close_actionAdapter implements ActionListener {
		private MainFrame adaptee;

		MainFrame_close_actionAdapter(MainFrame adaptee) {
			this.adaptee = adaptee;
		}

		public void actionPerformed(ActionEvent e) {
			adaptee.processCloseMainFrame(e);
		}
	}

	/**
	 * 
	 * @param e
	 */
	public void processCloseMainFrame(ActionEvent e) {
		System.exit(0);
	}

	/**
	 * 
	 * @author ahmai
	 * 
	 */
	class Menu_About_actionAdapter implements ActionListener {
		private MainFrame adaptee;

		Menu_About_actionAdapter(MainFrame adaptee) {
			this.adaptee = adaptee;
		}

		public void actionPerformed(ActionEvent e) {
			adaptee.processAboutMenuClicked(e);
		}
	}

	/**
	 * 
	 * @param e
	 */
	public void processAboutMenuClicked(ActionEvent e) {
		AboutFrame d = new AboutFrame();
		d.setVisible(true);
	}

	

	/**
	 * 
	 * @author ahmai
	 * 
	 */
	class MainFrame_Lambda_actionAdapter implements ActionListener {
		private MainFrame adaptee;

		MainFrame_Lambda_actionAdapter(MainFrame adaptee) {
			this.adaptee = adaptee;
		}

		public void actionPerformed(ActionEvent e) {
			adaptee.processLambdaBtnClicked(e);
		}
	}

	/**
	 * 
	 * @param e
	 */
	public void processLambdaBtnClicked(ActionEvent e) {
		jReportLabel.setText(Constants.STR_PROCESSING);
		long time = System.currentTimeMillis();
		    
		BasicLambda.main();
		ComposingLambdaExpressionTest.main();

		time = System.currentTimeMillis() - time;
	    jReportLabel.setText("Done! (" + time + " milliseconds"+ ")");

	}
	
	
	class MainFrame_Stream_actionAdapter implements ActionListener {
		private MainFrame adaptee;

		MainFrame_Stream_actionAdapter(MainFrame adaptee) {
			this.adaptee = adaptee;
		}

		public void actionPerformed(ActionEvent e) {
			adaptee.processStreamBtnClicked(e);
		}
	}

	/**
	 * 
	 * @param e
	 */
	public void processStreamBtnClicked(ActionEvent e) {
		jReportLabel.setText(Constants.STR_PROCESSING);
		long time = System.currentTimeMillis();
		    
		StreamBasic.main();
		Filtering.main();
		Grouping.main();
		Reducing.main();
		Summarizing.main();
		Laziness.main();
		BuildingStreams.main();

		time = System.currentTimeMillis() - time;
	    jReportLabel.setText("Done! (" + time + " milliseconds"+ ")");

	}
	
	class MainFrame_MethodRef_actionAdapter implements ActionListener {
		private MainFrame adaptee;

		MainFrame_MethodRef_actionAdapter(MainFrame adaptee) {
			this.adaptee = adaptee;
		}

		public void actionPerformed(ActionEvent e) {
			adaptee.processMethodRefBtnClicked(e);
		}
	}

	/**
	 * 
	 * @param e
	 */
	public void processMethodRefBtnClicked(ActionEvent e) {
		jReportLabel.setText(Constants.STR_PROCESSING);
		long time = System.currentTimeMillis();
		    
		Sorting.main();

		time = System.currentTimeMillis() - time;
	    jReportLabel.setText("Done! (" + time + " milliseconds"+ ")");

	}
	
	class MainFrame_CompletableFuture_actionAdapter implements ActionListener {
		private MainFrame adaptee;

		MainFrame_CompletableFuture_actionAdapter(MainFrame adaptee) {
			this.adaptee = adaptee;
		}

		public void actionPerformed(ActionEvent e) {
			adaptee.processCompletableFutureBtnClicked(e);
		}
	}

	/**
	 * 
	 * @param e
	 */
	public void processCompletableFutureBtnClicked(ActionEvent e) {
		jReportLabel.setText(Constants.STR_PROCESSING);
		long time = System.currentTimeMillis();
		    
		SingleProducerTest.main();
		PipelinedProducersTest.main();

		time = System.currentTimeMillis() - time;
	    jReportLabel.setText("Done! (" + time + " milliseconds"+ ")");

	}
	
	class MainFrame_DateTime_actionAdapter implements ActionListener {
		private MainFrame adaptee;

		MainFrame_DateTime_actionAdapter(MainFrame adaptee) {
			this.adaptee = adaptee;
		}

		public void actionPerformed(ActionEvent e) {
			adaptee.processDateTimeBtnClicked(e);
		}
	}

	/**
	 * 
	 * @param e
	 */
	public void processDateTimeBtnClicked(ActionEvent e) {
		jReportLabel.setText(Constants.STR_PROCESSING);
		long time = System.currentTimeMillis();
		    
		DateTimeExamplesJava8.main(null);

		time = System.currentTimeMillis() - time;
	    jReportLabel.setText("Done! (" + time + " milliseconds"+ ")");

	}
	
	class MainFrame_Optional_actionAdapter implements ActionListener {
		private MainFrame adaptee;

		MainFrame_Optional_actionAdapter(MainFrame adaptee) {
			this.adaptee = adaptee;
		}

		public void actionPerformed(ActionEvent e) {
			adaptee.processOptionalBtnClicked(e);
		}
	}

	/**
	 * 
	 * @param e
	 */
	public void processOptionalBtnClicked(ActionEvent e) {
		jReportLabel.setText(Constants.STR_PROCESSING);
		long time = System.currentTimeMillis();
		    
		OptionalMain.main(null);

		time = System.currentTimeMillis() - time;
	    jReportLabel.setText("Done! (" + time + " milliseconds"+ ")");

	}
	
	class MainFrame_Nashorn_actionAdapter implements ActionListener {
		private MainFrame adaptee;

		MainFrame_Nashorn_actionAdapter(MainFrame adaptee) {
			this.adaptee = adaptee;
		}

		public void actionPerformed(ActionEvent e) {
			adaptee.processNashornBtnClicked(e);
		}
	}

	/**
	 * 
	 * @param e
	 */
	public void processNashornBtnClicked(ActionEvent e) {
		jReportLabel.setText(Constants.STR_PROCESSING);
		long time = System.currentTimeMillis();
		    
		Nashorn.main(null);

		time = System.currentTimeMillis() - time;
	    jReportLabel.setText("Done! (" + time + " milliseconds"+ ")");

	}
	
	
	class MainFrame_Miscellaneous_actionAdapter implements ActionListener {
		private MainFrame adaptee;

		MainFrame_Miscellaneous_actionAdapter(MainFrame adaptee) {
			this.adaptee = adaptee;
		}

		public void actionPerformed(ActionEvent e) {
			adaptee.processMiscellaneousBtnClicked(e);
		}
	}

	/**
	 * 
	 * @param e
	 */
	public void processMiscellaneousBtnClicked(ActionEvent e) {
		jReportLabel.setText(Constants.STR_PROCESSING);
		long time = System.currentTimeMillis();
		    
		DefaultMethodTest.main(null);
		ForkJoinTest.main(null);
		com.csc.lap.features.metaspace.ClassLoader.main(null);

		time = System.currentTimeMillis() - time;
	    jReportLabel.setText("Done! (" + time + " milliseconds"+ ")");

	}
	
}
