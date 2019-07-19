package training.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/*
    in the hashmap <u,arr[0]>=user owes,<u,arr[1]>=user is owed
 */
public class Group {

    private int noOfUsers;
    private User[] users;
    private String name;
    private ArrayList<Transaction> txns;
    private HashMap<User, int[]> map;

    @Override
    public String toString() {
        return "Group{" +
                "users=" + Arrays.toString(users) +
                ", name='" + name + '\'' +
                ", txns=" + txns +
                '}';
    }

    public Group(User[] users, String name) {
        this.users = users;
        this.name = name;
        this.noOfUsers = users.length;
        this.txns = new ArrayList<Transaction>();
        this.map = new HashMap<User, int[]>();
        for (User u : users) {
            map.put(u, new int[]{0, 0});
        }
    }

    public HashMap<User, int[]> getMap() {
        return map;
    }

    public void setMap(HashMap<User, int[]> map) {
        this.map = map;
    }

    public User[] getUsers() {
        return users;
    }

    public void setUsers(User[] users) {
        this.users = users;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Transaction> getTxns() {
        return txns;
    }

    public void addTxns(Transaction txn) {
        int temp = txn.getAmount() / noOfUsers;
        for (User u : users) {
            if (u != txn.getCreator()) {
                map.get(u)[0] += temp;
            }
        }
        map.get(txn.getCreator())[1] = txn.getAmount() - temp;
        txns.add(0, txn);
    }
}
