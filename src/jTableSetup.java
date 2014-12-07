// Imports
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class jTableSetup extends 	JFrame
 {
	// Instance attributes used in this example
	private static JPanel		topPanel;
	private	static JTable		table;
	private	static JScrollPane scrollPane;

	// Constructor of main frame
	public jTableSetup()
	{
		// Set the frame characteristics
		//setTitle( "Simple Table Application" );
		setSize( 300, 200 );
		setBackground( Color.gray );

		// Create a panel to hold all other components
//		getTopPanel().setLayout( new BorderLayout() );
		getTopPanel().setLayout( new BorderLayout() );
		getContentPane().add( getTopPanel() );

		// Create columns names
		String columnNames[] = { "Ticker Symbol", "Name", "Number of Shares", "Price", "Value" };

		// Create some data
		String dataValues[][] =
		{
			{"TST1", "Test1", "50", "1.50", "75.00"}
		};

		// Create a new table instance
		table = new JTable( dataValues, columnNames );

		// Add the table to a scrolling pane
		scrollPane = new JScrollPane( table );
		getTopPanel().add( scrollPane, BorderLayout.CENTER );
	}

	public static JPanel getTopPanel() {
		return topPanel;
	}

	public static void setTopPanel(JPanel topPanel) {
		jTableSetup.topPanel = topPanel;
	}
}