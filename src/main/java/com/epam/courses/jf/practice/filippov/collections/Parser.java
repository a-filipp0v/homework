/*29.08.2017*/
package com.epam.courses.jf.practice.filippov.collections;

import java.io.*;
import java.util.*;
import java.util.regex.*;

public class Parser {

    private final String absolutePath = "./../../common/collections/";
    private final Pattern orderPattern = Pattern.compile(".*\\{\"orderID\": (\\d+), \"customerID\": (\\d+), \"product\": \"([а-яА-Яa-zA-Z\\d,\\-\\s/®+]*)\"}");
    private final Pattern clientPattern = Pattern.compile(".*<\\D+\"(\\d+)\" \\D+\"(\\D+)\"\\D+\"(\\D+)\"\\D+\"(\\D+)\"/>");
    private final Pattern jsonPattern = Pattern.compile("(\\d+)");
    private List<Client> clients = new ArrayList<>();
    private List<Order> orders = new ArrayList<>();
    private List<Integer> missOrders = new ArrayList<>();

    void parseDataAndWriteToFile(String[] str) throws IOException {
        parseOrders(str);
        parseClients();
        writeMissedOrdersToFile(missOrders);
        writeTopClientsToFile();
    }

    private void parseClients() throws IOException {
        String temp;
        try(BufferedReader br = new BufferedReader(new InputStreamReader(Order.class.getResourceAsStream(absolutePath + "clients.xml")))) {
            while ((temp = br.readLine()) != null) {
                Matcher cliendMatcher = clientPattern.matcher(temp);
                if (cliendMatcher.find()) {
                    String tempID = cliendMatcher.group(1);
                    String tempSurname = cliendMatcher.group(2);
                    String tempName = cliendMatcher.group(3);
                    String tempPatronymic = cliendMatcher.group(4);
                    clients.add(new Client(Integer.parseInt(tempID), tempSurname, tempName, tempPatronymic));
                }
            }
        }
        parseMoneySpent();
    }

    private void parseOrders(String[] orderFiles) throws IOException {
        for (String s : orderFiles) {
            int argsIndex = 0;
            Matcher argsMatcher = jsonPattern.matcher(s);
            if (argsMatcher.find()) {
                argsIndex = Integer.parseInt(argsMatcher.group(1));
            }
            int startsWith = (argsIndex-1) * 1000;
            List<String> innerOrders = new ArrayList<>();
            for (int i = startsWith; i < startsWith + 1000; i++) {
                innerOrders.add(i+"");
            }
            String temp;
            try(BufferedReader br = new BufferedReader(new InputStreamReader(Order.class.getResourceAsStream(absolutePath + s)))) {
                while ((temp = br.readLine()) != null) {
                    Matcher orderMatcher = orderPattern.matcher(temp);
                    if (orderMatcher.find()) {
                        String tempID = orderMatcher.group(1);
                        String tempCustID = orderMatcher.group(2);
                        String tempProd = orderMatcher.group(3);
                        orders.add(new Order(Integer.parseInt(tempID), Integer.parseInt(tempCustID), tempProd));
                        innerOrders.remove(tempID);
                    }
                }
            }
            for(String s1 : innerOrders) {
                missOrders.add(Integer.parseInt(s1));
            }
        }
        Collections.sort(missOrders);
        orders.sort(Comparator.naturalOrder());
    }

    private int findClientIndexByID(int id) {
        return clients.indexOf(clients.stream().filter(clients -> clients.getClientID() == id).findFirst().orElse(null));
    }

    private void parseMoneySpent() throws IOException {
        Properties props = new Properties();
        try (InputStreamReader isr = new InputStreamReader(Order.class.getResourceAsStream(absolutePath + "PriceList.properties"))) {
            props.load(isr);
            for (Order order : orders) {
                String tempProd = order.getProduct().replaceAll("\\ ", " ");
                clients.get(findClientIndexByID(order.getCustomerID()))
                       .addMoneySpent(Integer.parseInt(props.getProperty("\"" + tempProd + "\"")));
            }
        }
        clients.sort(Comparator.reverseOrder());
    }

    private <T> void writeMissedOrdersToFile(List<T> list) throws IOException {
        try(BufferedWriter bw = new BufferedWriter(new FileWriter("missedOrders.txt"))) {
            for (T t : list) {
                bw.write(t.toString() + "\r\n");
            }
        }
    }

    private void printOrders() {
        for (Order order : orders) {
            System.out.printf("orderID:%s, clientID:%s, product:%s\n", order.getOrderID(), order.getCustomerID(), order.getProduct());
        }
    }

    private void writeTopClientsToFile() throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("topClients.txt"))) {
            for (int i = 0; i < 100; i++) {
                bw.write(clients.get(i).getSurname() + " "
                           + clients.get(i).getName() + " "
                           + clients.get(i).getPatronymic() + " "
                           + clients.get(i).getMoneySpent() + "\r\n");
            }
        }
    }
}
