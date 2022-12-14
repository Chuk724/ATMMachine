import java.util.*;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class ATM {
	HashMap<Integer, Double> accounts;
	NumberFormat formatter = new DecimalFormat("0.00");
	public ATM () {
		this.accounts = new HashMap<Integer, Double>();
		
	}
	
	public void openAccount (Integer accountID) {
		if (!accounts.containsKey(accountID)) {
			accounts.put(accountID, 0.0);
		}	
	}
	
	public void openAccount (Integer accountID, Double deposit) {
		if (!accounts.containsKey(accountID)) {
			accounts.put(accountID, deposit);
		}
	}
	
	public void closeAccount (Integer accountID) {
		Double balance = accounts.get(accountID);
		if (balance == 0) {
			accounts.remove(accountID);
		}
	}
	
	public Double checkBalance (Integer accountID) {
		Double balance = accounts.get(accountID);
		if (accounts.containsKey(accountID)) {
			return Double.parseDouble(formatter.format(balance));
		}
		return 0.0;
	}
	
	public boolean depositMoney (Integer accountID, Double deposit) {
		if (accounts.containsKey(accountID) && deposit >= 0.0) {
			Double balance = accounts.get(accountID);
			accounts.put(accountID, balance+deposit);
			return true;
		}
		return false;
	}
	
	public boolean withdrawMoney (Integer accountID, Double withdrawal) {
		if (accounts.containsKey(accountID) && accounts.get(accountID) - withdrawal >= 0.0 && withdrawal >= 0.0) {
			accounts.put(accountID, accounts.get(accountID) - withdrawal);
			return true;
		}
		return false;
	}
	
}
