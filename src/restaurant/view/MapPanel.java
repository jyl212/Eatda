package restaurant.view;
import java.awt.Graphics;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MapPanel extends JPanel {


	String latitude;
	String longitude;
	int height;
	int width;
	/**
	 * Create the panel.
	 */
	public MapPanel(String latitude, String longitude, int width, int height) {
		this.latitude = latitude;
		this.longitude = longitude;
		
		this.width = width;
		this.height = height;
		
		setSize(width, height);
		setLayout(null);
		
		ImageIcon imageIcon2 = new ImageIcon("src/image/mapmark.png");
		JLabel Arrow = new JLabel(imageIcon2);
		Arrow.setBounds((width- ( imageIcon2.getIconWidth() ))/2, (height/2)-( imageIcon2.getIconHeight() ),imageIcon2.getIconWidth(),  imageIcon2.getIconHeight() );
		add(Arrow);	
	}

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
				
		try {
			String imageUrl = "https://maps.googleapis.com/maps/api/staticmap?center="
					+ latitude
					+ ","
					+ longitude
					+ "&zoom=17&size="
					+width	
					+"x"
					+height
					+"&scale=1&maptype=roadmap";
			String destinationFile = "_map.jpg";
			// read the map image from Google
			// then save it to a local file: image.jpg
			//
			URL url = new URL(imageUrl);
			InputStream is = url.openStream();
			OutputStream os = new FileOutputStream(destinationFile);
			byte[] b = new byte[2048];
			int length;
			while ((length = is.read(b)) != -1) {
				os.write(b, 0, length);
			}
			is.close();
			os.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}

		ImageIcon imageIcon = new ImageIcon((new ImageIcon("_map.jpg"))
				.getImage().getScaledInstance(width, height,
						java.awt.Image.SCALE_SMOOTH));
		
		g.drawImage(imageIcon.getImage(), 0, 0, width, height, null);
		
	}

}
