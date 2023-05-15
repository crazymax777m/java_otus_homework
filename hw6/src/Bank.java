import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bank {
    private Map<Client, List<Account>> clientsAccounts;

    public Bank() {
        clientsAccounts = new HashMap<>();
    }

    public void addClient(Client client) {
        clientsAccounts.put(client, new ArrayList<>());
    }

    public void addAccount(Client client, Account account) {
        List<Account> clientAccounts = clientsAccounts.get(client);
        if (clientAccounts != null) clientAccounts.add(account);
    }

    public List<Account> getAccounts(Client client) {
        return clientsAccounts.getOrDefault(client, new ArrayList<>());
    }

    public Client findClient(Account account) {
        for (Map.Entry<Client, List<Account>> entry: clientsAccounts.entrySet()) {
            if (entry.getValue().contains(account)) return entry.getKey();
        }
        return null;
    }
}
