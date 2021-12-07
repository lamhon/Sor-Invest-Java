/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.UserDTO;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hoang
 */
public class UserDAO {

    private static String filename = "data/user.csv";

    //Get all user
    public static List<UserDTO> loadUser() throws FileNotFoundException, IOException {
        // -- GET DATA -- //
        List<UserDTO> lstUser = new ArrayList<>();
        File file = new File(filename);

        String line = "";
        BufferedReader br = new BufferedReader(new FileReader(filename));
        if (file.length() == 0) {
            return lstUser;
        } else {
            while ((line = br.readLine()) != null) {
                String[] arrayUser = line.split(",");
                UserDTO user = new UserDTO();
                user.setId(Integer.parseInt(arrayUser[0].toString()));
                user.setUserlogin(arrayUser[1]);
                user.setUserpass(arrayUser[2]);
                user.setUsername(arrayUser[3]);

                lstUser.add(user);
            }
        }

        return lstUser;
    }

    // hash MD5
    public static String hashMD5(String input) throws NoSuchAlgorithmException {
        // Static getInstance method is called with hashing MD5 
        MessageDigest md = MessageDigest.getInstance("MD5");
        // digest() method is called to calculate message digest 
        //  of an input digest() return array of byte 
        byte[] messageDigest = md.digest(input.getBytes());

        // Convert byte array into signum representation 
        BigInteger no = new BigInteger(1, messageDigest);

        // Convert message digest into hex value 
        String hashtext = no.toString(16);
        while (hashtext.length() < 32) {
            hashtext = "0" + hashtext;
        }
        return hashtext;
    }

    public static boolean writeToDB(UserDTO user) throws IOException {
        try {
            FileWriter fw = new FileWriter(filename, true);
            BufferedWriter writer = new BufferedWriter(fw);

            writer.write(String.valueOf(user.getId()));
            writer.write(',');
            writer.write(String.valueOf(user.getUserlogin()));
            writer.write(',');
            writer.write(String.valueOf(user.getUserpass()));
            writer.write(',');
            writer.write(String.valueOf(user.getUsername()));

            writer.write('\n');

            writer.flush();
            writer.close();

            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean repairToDB(UserDTO user) throws IOException {
        List<UserDTO> lstUser = loadUser();

        for (int i = 0; i < lstUser.size(); i++) {
            if (lstUser.get(i).getId() == user.getId()) {
                lstUser.set(i, user);
                try {
                    FileWriter write = new FileWriter(filename);
                    for (int j = 0; j < lstUser.size(); j++) {
                        write.append(String.valueOf(lstUser.get(j).getId()));
                        write.append(',');
                        write.append(lstUser.get(j).getUserlogin());
                        write.append(',');
                        write.append(lstUser.get(j).getUserpass());
                        write.append(',');
                        write.append(String.valueOf(lstUser.get(j).getUsername()));
                        write.append('\n');
                        write.flush();
                    }
                    write.close();
                    return true;
                } catch (Exception e) {
                    return false;
                }
            }
        }
        return false;

    }

    public static int getnextId(List<UserDTO> lstUser) {
        int id = 0;
        if (lstUser.size() == 0) {
            id = 1;
            return id;
        } else {
            for (int i = 0; i < lstUser.size(); i++) {
                if (lstUser.get(i).getId() > id) {
                    id = lstUser.get(i).getId();
                }
            }
            id++;
            return id;
        }
    }

    public static boolean checkUsername(List<UserDTO> lstUser, String username) {
        boolean check = true;
        for (int i = 0; i < lstUser.size(); i++) {
            if (lstUser.get(i).getUserlogin().equals(username)) {
                check = false;
            }
        }
        return check;
    }

    public static int checkLogin(List<UserDTO> lstUser, String username, String pwd) {
        int id = 0;
        for (int i = 0; i < lstUser.size(); i++) {
            if (lstUser.get(i).getUserlogin().equals(username)) {
                if (lstUser.get(i).getUserpass().equals(pwd)) {
                    id = lstUser.get(i).getId();
                    return id;
                }
            }
        }
        return id;
    }

    public static UserDTO getUserById(List<UserDTO> lstUser, int id) {
        UserDTO user = new UserDTO();
        for (int i = 0; i < lstUser.size(); i++) {
            if (lstUser.get(i).getId() == id) {
                user.setId(id);
                user.setUserlogin(lstUser.get(i).getUserlogin());
                user.setUserpass(lstUser.get(i).getUserpass());
                user.setUsername(lstUser.get(i).getUsername());
                return user;
            }
        }
        return user;
    }
}
