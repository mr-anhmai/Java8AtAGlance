package com.csc.lap.GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import com.csc.lap.common.Constants;


public class MemoryMonitor extends JPanel {

	public Monitor monitor;
	JPanel mainPanel;
	boolean doControls;

	/**
	 * 
	 */
	public MemoryMonitor() {
		setLayout(new BorderLayout());
		setBorder(new TitledBorder(new EtchedBorder(), "Memory Monitor"));
		add(monitor = new Monitor());
		mainPanel = new JPanel();
		mainPanel.setPreferredSize(new Dimension(135, 80));

	}

	/**
	 * 
	 * @author ahmai
	 * 
	 */
	public class Monitor extends JPanel implements Runnable {

		public Thread thread;
		public long sleepTime = Constants.MONITOR_MEMORY_SLEEP_TIME;
		private int w, h;
		private BufferedImage buffImg;
		private Graphics2D graph;
		private Font font = new Font("Times New Roman", Font.PLAIN, 11);
		private Runtime r = Runtime.getRuntime();

		private int columnInc;
		private int pts[];
		private int ptNum;
		private int ascent, descent;

		// Information about allocated memory, free momory
		private float freeMemory, totalMemory;

		private Rectangle graphOutlineRect = new Rectangle();

		// The rectangle and color show used memory, free memory in bar diagram
		// of memory monitor screen
		private Rectangle2D memFreeRect = new Rectangle2D.Float();
		private Color memFreeColor = new Color(0, 100, 0);
		private Rectangle2D memUsedRect = new Rectangle2D.Float();
		private Color memUsedColor = Color.green;
		private Color memUsedAlertColor = Color.red; // Used when free memory
		// reach to 80%

		private Line2D graphLine = new Line2D.Float();
		private Color graphColor = new Color(46, 139, 87);
		private String usedStr;

		/**
		 * 
		 */
		public Monitor() {
			setBackground(Color.black);
			addMouseListener(new MouseAdapter() {
				// Add event start/stop memory monitor when click to this screen
				public void mouseClicked(MouseEvent e) {
					if (thread == null)
						start();
					else
						stop();
				}
			});
		}

		/**
		 * 
		 */
		public Dimension getMinimumSize() {
			return getPreferredSize();
		}

		/**
		 * 
		 */
		public Dimension getMaximumSize() {
			return getPreferredSize();
		}

		/**
		 * 
		 */
		public Dimension getPreferredSize() {
			return new Dimension(Constants.MONITOR_MEMORY_WIDTH_SIZE,
					Constants.MONITOR_MEMORY_HEIGHT_SIZE);
		}

		/**
		 * This method paint memory monitor screen
		 */
		public void paint(Graphics g) {

			if (graph == null) {
				return;
			}

			graph.setBackground(getBackground());
			graph.clearRect(0, 0, w, h);

			float freeMemory = (float) r.freeMemory();
			float totalMemory = (float) r.totalMemory();

			// .. Draw amount of allocated memory and used memory ..
			graph.setColor(Color.green);
			graph.drawString(String.valueOf((int) totalMemory / 1024)
					+ "K allocated", 4.0f, (float) ascent + 0.5f);
			usedStr = String.valueOf(((int) (totalMemory - freeMemory)) / 1024)
					+ "K used";
			graph.drawString(usedStr, 4, h - descent);

			// Calculate remaining size
			float ssH = ascent + descent;
			float remainingHeight = (float) (h - (ssH * 2) - 0.5f);
			float blockHeight = remainingHeight / 10;
			float blockWidth = 20.0f;
			float remainingWidth = (float) (w - blockWidth - 10);

			// .. Memory Free ..
			graph.setColor(memFreeColor);
			int MemUsage = (int) ((freeMemory / totalMemory) * 10);
			int i = 0;
			for (; i < MemUsage; i++) {
				memFreeRect.setRect(5, (float) ssH + i * blockHeight,
						blockWidth, (float) blockHeight - 1);
				graph.fill(memFreeRect);
			}

			// .. Memory Used ..
			if (MemUsage > (10 - Constants.MONITOR_MEMORY_USED_MEMORY_ALERT / 10)) {
				graph.setColor(memUsedColor);
			} else {
				graph.setColor(memUsedAlertColor);
			}

			for (; i < 10; i++) {
				memUsedRect.setRect(5, (float) ssH + i * blockHeight,
						blockWidth, (float) blockHeight - 1);
				graph.fill(memUsedRect);
			}

			// .. Draw History Graph ..
			graph.setColor(graphColor);
			int graphX = 30;
			int graphY = (int) ssH;
			int graphW = w - graphX - 5;
			int graphH = (int) remainingHeight;
			graphOutlineRect.setRect(graphX, graphY, graphW, graphH);
			graph.draw(graphOutlineRect);

			int graphRow = graphH / Constants.MONITOR_MEMORY_ROW_NUMBER;

			// .. Draw row ..
			for (int j = graphY; j <= graphH + graphY; j += graphRow) {
				graphLine.setLine(graphX, j, graphX + graphW, j);
				graph.draw(graphLine);
			}

			// .. Draw animated column movement ..
			int graphColumn = graphW / Constants.MONITOR_MEMORY_COLUMN_NUMBER;

			if (columnInc == 0) {
				columnInc = graphColumn;
			}

			for (int j = graphX + columnInc; j < graphW + graphX; j += graphColumn) {
				graphLine.setLine(j, graphY, j, graphY + graphH);
				graph.draw(graphLine);
			}

			--columnInc;

			if (pts == null) {
				pts = new int[graphW];
				ptNum = 0;
			} else if (pts.length != graphW) {
				int tmp[] = null;
				if (ptNum < graphW) {
					tmp = new int[ptNum];
					System.arraycopy(pts, 0, tmp, 0, tmp.length);
				} else {
					tmp = new int[graphW];
					System.arraycopy(pts, pts.length - tmp.length, tmp, 0,
							tmp.length);
					ptNum = tmp.length - 2;
				}
				pts = new int[graphW];
				System.arraycopy(tmp, 0, pts, 0, tmp.length);
			} else {
				graph.setColor(Color.magenta);
				pts[ptNum] = (int) (graphY + graphH
						* (freeMemory / totalMemory));
				for (int j = graphX + graphW - ptNum, k = 0; k < ptNum; k++, j++) {
					if (k != 0) {
						if (pts[k] != pts[k - 1]) {
							graph.drawLine(j - 1, pts[k - 1], j, pts[k]);
						} else {
							graph.fillRect(j, pts[k], 1, 1);
						}
					}
				}
				if (ptNum + 2 == pts.length) {
					// throw out oldest point
					for (int j = 1; j < ptNum; j++) {
						pts[j - 1] = pts[j];
					}
					--ptNum;
				} else {
					ptNum++;
				}
			}
			g.drawImage(buffImg, 0, 0, this);
		}

		/**
		 * 
		 */
		public void start() {
			thread = new Thread(this);
			thread.setPriority(Thread.MAX_PRIORITY);
			thread.setName("MemoryMonitor");
			thread.start();
		}

		/**
		 * 
		 */
		public synchronized void stop() {
			thread = null;
			notify();
		}

		/**
		 * 
		 */
		public void run() {

			Thread me = Thread.currentThread();

			while (thread == me && isShowing()) {
				Dimension d = getSize();
				if (d.width != w || d.height != h) {
					w = d.width;
					h = d.height;
					buffImg = (BufferedImage) createImage(w, h);
					graph = buffImg.createGraphics();
					graph.setFont(font);
					FontMetrics fm = graph.getFontMetrics(font);
					ascent = (int) fm.getAscent();
					descent = (int) fm.getDescent();
				}
				repaint();
				try {
					thread.sleep(sleepTime);
				} catch (InterruptedException e) {
					break;
				}

			}
			thread = null;
		}
	}

	/**
	 * 
	 * @param s
	 */
	public static void main(String s[]) {
		final MemoryMonitor monitorInstance = new MemoryMonitor();
		WindowListener l = new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}

			public void windowDeiconified(WindowEvent e) {
				monitorInstance.monitor.start();
			}

			public void windowIconified(WindowEvent e) {
				monitorInstance.monitor.stop();
			}
		};
		JFrame frame = new JFrame("MemoryMonitor");
		frame.addWindowListener(l);
		frame.getContentPane().add("Center", monitorInstance);
		frame.pack();
		frame.setSize(new Dimension(Constants.MONITOR_MEMORY_WIDTH_SIZE,
				Constants.MONITOR_MEMORY_WIDTH_SIZE));
		frame.setVisible(true);
		monitorInstance.monitor.start();
	}

}
