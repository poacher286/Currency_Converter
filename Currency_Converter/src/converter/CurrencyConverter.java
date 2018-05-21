package converter;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class CurrencyConverter {

	private JFrame frame;
	private String[] dropDown = { "--Select--", "USD (US Dollar)", "INR (Indian Rupee)", "AUD (Australian Dollar)", "EUR (Euro)" };
	private JTextField textAmount;
	private JTextField textValue;

	// Variables
	double amount;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CurrencyConverter window = new CurrencyConverter();
					window.frame.setVisible(true);
					window.frame.setTitle("Currency Converter");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CurrencyConverter() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.GRAY);
		frame.setBounds(10, 0, 385, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		//frame.setUndecorated(true);

		JLabel lblCurrencyConverter = new JLabel("Currency Converter");
		lblCurrencyConverter.setFont(new Font("Sitka Small", Font.BOLD, 25));
		lblCurrencyConverter.setBounds(43, 11, 271, 45);
		frame.getContentPane().add(lblCurrencyConverter);

		JLabel lblFrom = new JLabel("FROM");
		lblFrom.setFont(new Font("Sitka Small", Font.PLAIN, 15));
		lblFrom.setBounds(10, 67, 57, 22);
		frame.getContentPane().add(lblFrom);

		JLabel lblTo = new JLabel("TO");
		lblTo.setFont(new Font("Sitka Small", Font.PLAIN, 15));
		lblTo.setBounds(204, 67, 33, 22);
		frame.getContentPane().add(lblTo);

		final JComboBox comboBoxFrom = new JComboBox(dropDown);
		comboBoxFrom.setBounds(10, 89, 172, 20);
		frame.getContentPane().add(comboBoxFrom);

		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(192, 67, 2, 71);
		frame.getContentPane().add(separator);

		final JComboBox comboBoxTo = new JComboBox(dropDown);
		comboBoxTo.setBounds(204, 89, 155, 20);
		frame.getContentPane().add(comboBoxTo);

		textAmount = new JTextField();
		textAmount.setFont(new Font("Tahoma", Font.BOLD, 20));
		textAmount.setHorizontalAlignment(SwingConstants.RIGHT);
		textAmount.setBounds(77, 151, 282, 50);
		frame.getContentPane().add(textAmount);
		textAmount.setColumns(10);

		textValue = new JTextField();
		textValue.setFont(new Font("Tahoma", Font.BOLD, 20));
		textValue.setHorizontalAlignment(SwingConstants.RIGHT);
		textValue.setEditable(false);
		textValue.setColumns(10);
		textValue.setBounds(77, 260, 282, 50);
		frame.getContentPane().add(textValue);

		JButton btnReset = new JButton("RESET");
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textAmount.setText(null);
				textValue.setText(null);
				comboBoxFrom.setSelectedIndex(0);
				comboBoxTo.setSelectedIndex(0);
			}
		});
		btnReset.setBounds(10, 318, 104, 33);
		frame.getContentPane().add(btnReset);

		JButton btnExit = new JButton("EXIT");
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (JOptionPane.showConfirmDialog(null, "Confirm Exit", "Exit",
						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
		});
		btnExit.setBounds(255, 318, 104, 33);
		frame.getContentPane().add(btnExit);

		JButton btnConvert = new JButton("CONVERT");
		btnConvert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (textAmount.getText().length() != 0) {
					if (validateNum(textAmount.getText()) == true) {
						switch (comboBoxFrom.getSelectedIndex()) {
						case 1: {
							switch (comboBoxTo.getSelectedIndex()) {
							case 1: {
								textValue.setText(String.valueOf("USD "
										+ textAmount.getText()));
								break;
							}
							case 2: {
								textValue.setText(String.valueOf("INR "
										+ Double.parseDouble(textAmount
												.getText())
										* (ExchangeRate.getRate(Map
												.getCurrency(comboBoxFrom
														.getSelectedIndex()),
												Map.getCurrency(comboBoxTo
														.getSelectedIndex())))));
								break;
							}
							case 3: {
								textValue.setText(String.valueOf("AUD "
										+ Double.parseDouble(textAmount
												.getText())
										* (ExchangeRate.getRate(Map
												.getCurrency(comboBoxFrom
														.getSelectedIndex()),
												Map.getCurrency(comboBoxTo
														.getSelectedIndex())))));
								break;
							}
							case 4: {
								textValue.setText(String.valueOf("EUR "
										+ Double.parseDouble(textAmount
												.getText())
										* (ExchangeRate.getRate(Map
												.getCurrency(comboBoxFrom
														.getSelectedIndex()),
												Map.getCurrency(comboBoxTo
														.getSelectedIndex())))));
								break;
							}

							}
							break;
						}
						case 2: {
							switch (comboBoxTo.getSelectedIndex()) {
							case 1: {
								textValue.setText(String.valueOf("USD "
										+ +Double.parseDouble(textAmount
												.getText())
										* (ExchangeRate.getRate(Map
												.getCurrency(comboBoxFrom
														.getSelectedIndex()),
												Map.getCurrency(comboBoxTo
														.getSelectedIndex())))));
								break;
							}
							case 2: {
								textValue.setText(String.valueOf("INR "
										+ textAmount.getText()));

								break;
							}
							case 3: {
								textValue.setText(String.valueOf("AUD "
										+ Double.parseDouble(textAmount
												.getText())
										* (ExchangeRate.getRate(Map
												.getCurrency(comboBoxFrom
														.getSelectedIndex()),
												Map.getCurrency(comboBoxTo
														.getSelectedIndex())))));
								break;
							}
							case 4: {
								textValue.setText(String.valueOf("EUR "
										+ Double.parseDouble(textAmount
												.getText())
										* (ExchangeRate.getRate(Map
												.getCurrency(comboBoxFrom
														.getSelectedIndex()),
												Map.getCurrency(comboBoxTo
														.getSelectedIndex())))));
								break;
							}

							}
							break;
						}
						case 3: {
							switch (comboBoxTo.getSelectedIndex()) {
							case 1: {
								textValue.setText(String.valueOf("USD "
										+ Double.parseDouble(textAmount
												.getText())
										* (ExchangeRate.getRate(Map
												.getCurrency(comboBoxFrom
														.getSelectedIndex()),
												Map.getCurrency(comboBoxTo
														.getSelectedIndex())))));
								break;
							}
							case 2: {
								textValue.setText(String.valueOf("INR "
										+ Double.parseDouble(textAmount
												.getText())
										* (ExchangeRate.getRate(Map
												.getCurrency(comboBoxFrom
														.getSelectedIndex()),
												Map.getCurrency(comboBoxTo
														.getSelectedIndex())))));
								break;
							}
							case 3: {
								textValue.setText(String.valueOf("AUD "
										+ textAmount.getText()));

								break;
							}
							case 4: {
								textValue.setText(String.valueOf("EUR "
										+ Double.parseDouble(textAmount
												.getText())
										* (ExchangeRate.getRate(Map
												.getCurrency(comboBoxFrom
														.getSelectedIndex()),
												Map.getCurrency(comboBoxTo
														.getSelectedIndex())))));
								break;
							}

							}
							break;
						}
						case 4: {
							switch (comboBoxTo.getSelectedIndex()) {
							case 1: {
								textValue.setText(String.valueOf("USD "
										+ Double.parseDouble(textAmount
												.getText())
										* (ExchangeRate.getRate(Map
												.getCurrency(comboBoxFrom
														.getSelectedIndex()),
												Map.getCurrency(comboBoxTo
														.getSelectedIndex())))));
								break;
							}
							case 2: {
								textValue.setText(String.valueOf("INR "
										+ Double.parseDouble(textAmount
												.getText())
										* (ExchangeRate.getRate(Map
												.getCurrency(comboBoxFrom
														.getSelectedIndex()),
												Map.getCurrency(comboBoxTo
														.getSelectedIndex())))));
								break;
							}
							case 3: {
								textValue.setText(String.valueOf("AUD "
										+ Double.parseDouble(textAmount
												.getText())
										* (ExchangeRate.getRate(Map
												.getCurrency(comboBoxFrom
														.getSelectedIndex()),
												Map.getCurrency(comboBoxTo
														.getSelectedIndex())))));

								break;
							}
							case 4: {
								textValue.setText(String.valueOf("EUR "
										+ textAmount.getText()));
								break;
							}

							}
							break;
						}
						}
					} else
						JOptionPane.showMessageDialog(null,
								"Enter Valid Number", "Error",
								JOptionPane.ERROR_MESSAGE);

				} else
					JOptionPane.showMessageDialog(null, "Enter Amount",
							"Error", JOptionPane.ERROR_MESSAGE);
			}
		});
		btnConvert.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnConvert.setBounds(117, 210, 145, 39);
		frame.getContentPane().add(btnConvert);

		JLabel lblAmount = new JLabel("Amount");
		lblAmount.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblAmount.setBounds(10, 164, 57, 22);
		frame.getContentPane().add(lblAmount);

		JLabel lblValue = new JLabel("Value");
		lblValue.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblValue.setBounds(10, 275, 57, 22);
		frame.getContentPane().add(lblValue);
	}

	public static boolean validateNum(String text) {
		try {
			@SuppressWarnings("unused")
			double d = Double.parseDouble(text);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
}
