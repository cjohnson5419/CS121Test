import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Bank {
    public static ArrayList<Customer> customerArrayList = new ArrayList<>();

    public void sort() {
        Collections.sort(customerArrayList, new Comparator<Customer>() {
            @Override
            public int compare(Customer o1, Customer o2) {
                return o1.getCustomerLast().compareTo(o2.getCustomerLast());
            }
        });
        for (Customer customer : customerArrayList) {
            System.out.println(customer + "\n");
        }

    }

    public StringBuilder getCustomerList() {
        //Creat instance of StringBuilder Class
        StringBuilder sb = new StringBuilder();
        for (Customer customer : customerArrayList) {
            sb.append(customer.toString());
        }
        return sb;
    }
    public Customer getCustomer(int customerPin){
        Customer foundCustomer = null;
        for (Customer customer : customerArrayList) {
            if (customer.getCustomerPin() == customerPin){
                foundCustomer = customer;
                break;
            }
        }
        return foundCustomer;

    }
    public void addCustomer(Customer customer) {
        customerArrayList.add(customer);
    }
    public void removeCustomer(Customer customer) {
        customerArrayList.remove(customer);
    }



}
