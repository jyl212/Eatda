package restaurant.view;

import java.awt.Component;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class StarImageRenderer  extends DefaultTableCellRenderer {

	@Override
	//특정셀에 그림 그릴때 사용하는 메소드
	//데이터를 어떻게 보여줄지 결정
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
			boolean hasFocus, int row, int column) {

		ImageIcon imageIcon = new ImageIcon("src/image/"+((Integer)value)+"star.png");
		JLabel lbl = new JLabel(
				new ImageIcon(
						imageIcon.getImage()
						.getScaledInstance(
								(imageIcon.getIconWidth()*14)/imageIcon.getIconHeight(), 
								14, 
								Image.SCALE_SMOOTH
								)
						)
				);
		lbl.setOpaque(false);
		return lbl;
	}

}
