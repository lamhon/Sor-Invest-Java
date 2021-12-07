/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.CoinDTO;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hoang
 */
public class CoinDAO {
    private static String filename = "data/coin.csv";
    
    //Get all coins
    public static List<CoinDTO> loadCoin() throws FileNotFoundException, IOException{
        List<CoinDTO> lstCoin = new ArrayList<>();
        File file = new File(filename);
        
        String line = "";
        BufferedReader br = new BufferedReader(new FileReader(filename));
        if (file.length() == 0) {
            return lstCoin;
        }else{
            while ((line = br.readLine()) != null) {
                String[] arrayCoin = line.split(",");
                
                CoinDTO coin = new CoinDTO();
                coin.setId(Integer.parseInt(arrayCoin[0].toString()));
                coin.setCoinname(arrayCoin[1]);
                coin.setUsercoin(Integer.parseInt(arrayCoin[2].toString()));
                coin.setStt(Boolean.parseBoolean(arrayCoin[3].toString()));
                
                lstCoin.add(coin);
            }
        }
        return lstCoin;
    }
    
    public static boolean writeToDB(CoinDTO coin) throws IOException{
        try {
            FileWriter fw = new FileWriter(filename, true);
            BufferedWriter writer = new BufferedWriter(fw);
            
            writer.write(String.valueOf(coin.getId()));
            writer.write(',');
            writer.write(coin.getCoinname());
            writer.write(',');
            writer.write(String.valueOf(coin.getUsercoin()));
            writer.write(',');
            writer.write(String.valueOf(coin.isStt()));
            
            writer.write('\n');

            writer.flush();
            writer.close();
            
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public static boolean repairToDB(CoinDTO coin) throws IOException{
        List<CoinDTO> lstCoin = loadCoin();
        
        for (int i = 0; i < lstCoin.size(); i++) {
            if(lstCoin.get(i).getId() == coin.getId()){
                lstCoin.set(i, coin);
                
                try {
                     FileWriter write = new FileWriter(filename);
                     
                     for (int j = 0; j < lstCoin.size(); j++) {
                        write.append(String.valueOf(lstCoin.get(j).getId()));
                        write.append(',');
                        write.append(lstCoin.get(j).getCoinname());
                        write.append(',');
                        write.append(String.valueOf(lstCoin.get(j).getUsercoin()));
                        write.append(',');
                        write.append(String.valueOf(lstCoin.get(j).isStt()));
                        write.append('\n');
                        
                        write.flush();
                    }
                     write.close();
                     return true;
                } catch (Exception e) {
                }
            }
        }
        return false;
    }
    
    public static int getNextId(List<CoinDTO> lstCoin){
        int id = 0;
        if(lstCoin.size() == 0){
            id = 1;
            return id;
        }else{
            for (int i = 0; i < lstCoin.size(); i++) {
                if(lstCoin.get(i).getId() > id){
                    id = lstCoin.get(i).getId();
                }
            }
            id++;
            return id;
        }
    }
    
    public static boolean checkCoinName(List<CoinDTO> lstCoin, String name){
        boolean check = true;
        for (int i = 0; i < lstCoin.size(); i++) {
            if(lstCoin.get(i).getCoinname().equals(name)){
                check = false;
                return check;
            }
        }
        return check;
    }
    
    public static CoinDTO getCoinById(List<CoinDTO> lstCoin, int id){
        CoinDTO coin = new CoinDTO();
        for (int i = 0; i < lstCoin.size(); i++) {
            if (lstCoin.get(i).getId() == id) {
                coin.setId(id);
                coin.setCoinname(lstCoin.get(i).getCoinname());
                coin.setUsercoin(lstCoin.get(i).getUsercoin());
                coin.setStt(lstCoin.get(i).isStt());
                return coin;
            }
        }
        return coin;
    }
}
