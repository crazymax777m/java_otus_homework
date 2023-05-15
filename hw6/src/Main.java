import java.util.List;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();

        Client client1 = new Client("John", 30);
        bank.addClient(client1);

        Client client2 = new Client("Bob", 20);
        bank.addClient(client2);

        Account account1 = new Account();
        bank.addAccount(client1, account1);

        Account account2 = new Account();
        bank.addAccount(client2, account2);

        Account account3 = new Account();
        bank.addAccount(client1, account3);

        List<Account> accounts = bank.getAccounts(client1);
        System.out.println("Счета клиента 1:");

        for (Account account: accounts) {
            System.out.println(account);
        }

        Client foundClient = bank.findClient(account2);
        System.out.println("Найденный клиент по счету 2: " + foundClient.getName());
    }
}
