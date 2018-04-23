package ui;

import javax.swing.JPanel;

public class PrevNextPanel extends JPanel {
	public EatdaButton btnPrev;
	public EatdaButton btnNext;
	public EatdaButton btnCancle;

	/**
	 * Create the panel.
	 */
	public PrevNextPanel() {
		
		btnPrev = new EatdaButton();
		btnPrev.setText("\uC774\uC804");
		add(btnPrev);
		
		btnNext = new EatdaButton();
		btnNext.setText("\uB2E4\uC74C");
		add(btnNext);
		
		btnCancle = new EatdaButton();
		btnCancle.setText("\uCDE8\uC18C");
		add(btnCancle);
		

	}

}
