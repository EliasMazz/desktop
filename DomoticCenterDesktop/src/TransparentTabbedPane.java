import javax.swing.JTabbedPane;

/**
 * This to lines have to be add to the top component!<br>
 * UIManager.put("TabbedPane.contentOpaque", Boolean.FALSE);<br>
 * UIManager.put("TabbedPane.tabsOpaque", Boolean.FALSE);
 * 
 * @author Blackfire
 */
public class TransparentTabbedPane extends JTabbedPane {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9042837485677274814L;

	
	
  /**
   * This to lines have to be add to the top component!<br>
   * UIManager.put("TabbedPane.contentOpaque", Boolean.FALSE);<br>
   * UIManager.put("TabbedPane.tabsOpaque", Boolean.FALSE);
   */
	public TransparentTabbedPane() {
		super();
		this.setOpaque(false);
		
	}



public TransparentTabbedPane(int tabPlacement, int tabLayoutPolicy) {
	super(tabPlacement, tabLayoutPolicy);
	this.setOpaque(false);
}



public TransparentTabbedPane(int tabPlacement) {
	super(tabPlacement);
	this.setOpaque(false);
}
	
	
}