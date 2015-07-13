package com.csc.lap.GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import net.miginfocom.layout.CC;
import net.miginfocom.layout.LC;
import net.miginfocom.swing.MigLayout;

import com.csc.lap.common.Constants;

public class AboutFrame extends JFrame {

	// main panel
	JPanel contentPanel;

	
	Font font = new Font("Times New Roman", Font.PLAIN, 11);

	/**
	 * 
	 */
	public AboutFrame() {
		try {
			initGUI();
			center();
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

	/**
	 * 
	 */
	public void center() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frameSize = getSize();
		int x = (screenSize.width - frameSize.width) / 2;
		int y = (screenSize.height - frameSize.height) / 2;
		setLocation(x, y);
	}

	/**
	 * 
	 * @throws Exception
	 */
	private void initGUI() throws Exception {
		this.setBackground(Color.white);
		contentPanel = (JPanel) getContentPane();
		contentPanel.setBackground(Color.white);
		contentPanel.setLayout(new MigLayout(new LC().wrap().align("center",
				"center")));
		
		setSize(new Dimension(Constants.MAIN_FRAME_WIDTH_SIZE, Constants.MAIN_FRAME_HEIGHT_SIZE));
		setTitle(Constants.GUI_ABOUT_FRAME_TITLE);

		ImageIcon a = new ImageIcon(getClass()
				.getResource("images/logo.jpg"));
		JLabel image = new JLabel(a);

		contentPanel.add(new JLabel("<html><h2><font color='white'>"
				+ Constants.GUI_ABOUT_FRAME_LABLE_TEXT
				+ "</font></h2></html>"), new CC());
		contentPanel
				.add(image, new CC().wrap().alignX("center").height("60lp"));
		contentPanel.add(
				new JLabel("<html><B><font color='white'>"
						+ Constants.GUI_ABOUT_FRAME_VERSION_LABEL
						+ "</font></B>" + "<font color='white' >"
						+ Constants.GUI_ABOUT_FRAME_VERSION_VALUE
						+ "</font></html>"), new CC().alignX("center"));
		

	}

}
