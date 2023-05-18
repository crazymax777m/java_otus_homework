import java.util.*;

public class Bank {
    private Map<Client, Set<Account>> clientsAccounts;
    private Map<Account, Client> accountToClientMap;

    public Bank() {
        clientsAccounts = new HashMap<>();
        accountToClientMap = new HashMap<>();
    }

    public void addClient(Client client) {
        if (!clientsAccounts.containsKey(client)) {
            clientsAccounts.put(client, new HashSet<>());
        } else {
            System.out.println("Клиент уже существует: " + client.getName());
        }
    }

    public void addAccount(Client client, Account account) {
        Set<Account> clientAccounts = clientsAccounts.get(client);

        if (clientAccounts == null) {
            throw new IllegalArgumentException("Клиент не сохранен в банке: " + client.getName());
        }

        clientAccounts.add(account);
        accountToClientMap.put(account, client);
    }


    public List<Account> getAccounts(Client client) {
        Set<Account> clientAccounts = clientsAccounts.getOrDefault(client, new HashSet<>());
        if (clientAccounts.isEmpty()) {
            throw new IllegalArgumentException("У клиента нет счетов: " + client.getName());
        }
        return new ArrayList<>(clientAccounts);
    }

    public Client findClient(Account account) {
        return accountToClientMap.get(account);
    }
}
