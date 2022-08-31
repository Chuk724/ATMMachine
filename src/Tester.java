public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ATM atm1 = new ATM();
		
		//openAccount Tests:
		
		atm1.openAccount(0001, 5000.0);
		atm1.openAccount(0001, 4000.0); // Shouldn't work because an account with this ID already exists
		atm1.openAccount(0002);
		atm1.openAccount(0002, 30.0); // Shouldn't work because an account with this ID already exists
		
		//checkBalance Tests:
		
		System.out.println(atm1.checkBalance(0001)); // Should return 5000.0
		System.out.println(atm1.checkBalance(0002)); // Should return 0.0
		
		
		//deposit tests:
		
		atm1.depositMoney(0001, 35.0);
		System.out.println(atm1.checkBalance(0001)); // Should return 5035.0
		
		atm1.depositMoney(0002, 101.0);
		System.out.println(atm1.checkBalance(0002)); // Should return 101.0
		
		//withdraw tests:
		
		atm1.withdrawMoney(0001, 5000.0);
		System.out.println(atm1.checkBalance(0001)); // Should return 35.0
		
		atm1.withdrawMoney(0002, 102.0); // Shouldn't work
		System.out.println(atm1.checkBalance(0002)); // Should still return 101.0
		
		atm1.withdrawMoney(0002, 50.0);
		System.out.println(atm1.checkBalance(0002)); // Should return 51.0
		
		atm1.withdrawMoney(0001, 35.0);
		System.out.println(atm1.checkBalance(0001)); // Should return 0.0
		
		//closeAccount Tests:
		
		atm1.closeAccount(0001);
		System.out.println(atm1.checkBalance(0001)); // Should work - return 0.0
		
		atm1.closeAccount(0002);
		System.out.println(atm1.checkBalance(0002)); // Shouldn't work - return 51.0
		
	}

}
