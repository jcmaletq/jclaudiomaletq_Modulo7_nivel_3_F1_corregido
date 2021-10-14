package com.vehicles.project;
import javax.swing.JOptionPane;
public class Local_exceptions extends Exception{
	public Local_exceptions (String code) {
		super(code);
		JOptionPane.showMessageDialog(null,code);
		// main.resultado();

	}
}