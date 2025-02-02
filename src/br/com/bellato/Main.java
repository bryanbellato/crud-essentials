/**
 * @Author: Bryan Bellato
 */

package br.com.bellato;

import br.com.bellato.dao.ClientMapDAO;
import br.com.bellato.dao.IClientDAO;
import br.com.bellato.domain.Client;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

public class Main {

    private static IClientDAO iClientDAO;

    public static void main(String[] args) {
        iClientDAO = new ClientMapDAO();
        String option = JOptionPane.showInputDialog(null, "Press 1 to register, 2 to search, 3 to remove, 4 to update or 5 to leave.", "CRUD Essentials", JOptionPane.INFORMATION_MESSAGE);

        while(!isOptionValid(option)) {
            if ("".equals(option)) {
                leave();
            } else {
                option = JOptionPane.showInputDialog(null, "Invalid option. Press 1 to register, 2 to search, 3 to remove, 4 to update or 5 to leave.",
                        "CRUD Essentials", JOptionPane.INFORMATION_MESSAGE);
            }
        }

        while(isOptionValid(option)) {

            if(isOptionLeave(option)) {
                leave();
            }

            else if(isOptionRegister(option)) {
                String data = JOptionPane.showInputDialog(null, "Register with commas. Ex.: name, cpf, phone number, address, city, state.",
                        "CRUD Essentials", JOptionPane.INFORMATION_MESSAGE);
                register(data);
            }

            else if(isOptionSearch(option)) {
                String data = JOptionPane.showInputDialog(null, "Insert the client's CPF.",
                        "CRUD Essentials", JOptionPane.INFORMATION_MESSAGE);
                search(data);
            }

            else if(isOptionRemove(option)) {
                String data = JOptionPane.showInputDialog(null, "Insert the client's CPF to remove it.",
                        "CRUD Essentials", JOptionPane.INFORMATION_MESSAGE);
                remove(data);
            }

            else if (isOptionUpdate(option)) {
                String data = JOptionPane.showInputDialog(null, "Insert the client's CPF to update it.",
                        "CRUD Essentials", JOptionPane.INFORMATION_MESSAGE);
                update(data);
            }

            option = JOptionPane.showInputDialog(null,
                    "Press 1 to register, 2 to search, 3 to remove, 4 to update or 5 to leave.", "CRUD Essentials",
                    JOptionPane.INFORMATION_MESSAGE);
        }

    }

    private static boolean isOptionValid(String option) {
        if ("1".equals(option) ||  "2".equals(option) || "3".equals(option) ||  "4".equals(option) || "5".equals(option)) {
            return true;
        }
        return false;
    }

    private static boolean isOptionRegister(String option) {
        if ("1".equals(option)) {
            return true;
        }
        return false;
    }

    private static boolean isOptionSearch(String option) {
        if ("2".equals(option)) {
            return true;
        }
        return false;
    }

    private static boolean isOptionRemove(String option) {
        if ("3".equals(option)) {
            return true;
        }
        return false;
    }

    private static boolean isOptionUpdate(String option) {
        if ("4".equals(option)) {
            return true;
        }
        return false;
    }

    private static boolean isOptionLeave(String option) {
        if ("5".equals(option)) {
            return true;
        }
        return false;
    }

    private static void leave() {
        JOptionPane.showMessageDialog(null, "Come back any time.", "Leaving.", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }

    private static void register(String data) {
        String[] separatedData = data.split(",");
        Client client = new Client(separatedData[0], separatedData[1], separatedData[2], separatedData[3], separatedData[4], separatedData[5]);
        Boolean isOptionRegister = iClientDAO.register(client);
        if (isOptionRegister) {
            JOptionPane.showMessageDialog(null, "Client successfully registered.", "CRUD Essentials", JOptionPane.INFORMATION_MESSAGE);
        }
        else {
            JOptionPane.showMessageDialog(null, "Client already registered.", "CRUD Essentials", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private static void search(String data) {
        Client client = iClientDAO.search(Long.parseLong(data));
        if (client != null ) {
            JOptionPane.showMessageDialog(null, "Client founded:" + client.toString(), "CRUD Essentials.", JOptionPane.INFORMATION_MESSAGE);
        }
        else {
            JOptionPane.showMessageDialog(null, "Client not found.", "CRUD Essentials.", JOptionPane.INFORMATION_MESSAGE);
        }

    }

    private static void remove(String data) {
        Client client = iClientDAO.search(Long.parseLong(data));
        if (client != null) {
            iClientDAO.remove(Long.parseLong(data));
            JOptionPane.showMessageDialog(null, "Client successfully removed.", "CRUD Essentials", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Client not found.", "CRUD Essentials", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private static void update(String data) {
        Client client = iClientDAO.search(Long.parseLong(data));
        if (client != null) {
            String newData = JOptionPane.showInputDialog(null, "Update with commas. Ex.: name, phone number, address, city, state.",
                    "CRUD Essentials", JOptionPane.INFORMATION_MESSAGE);
            String[] separatedData = newData.split(",");
            client.setName(separatedData[0]);
            client.setPhone_number(Long.valueOf(separatedData[1].trim()));
            client.setAddress(separatedData[2]);
            client.setCity(separatedData[3]);
            client.setState(separatedData[4]);
            iClientDAO.update(client);
            JOptionPane.showMessageDialog(null, "Client successfully updated.", "CRUD Essentials", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Client not found.", "CRUD Essentials", JOptionPane.INFORMATION_MESSAGE);
        }
    }

}