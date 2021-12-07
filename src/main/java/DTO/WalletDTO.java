/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author hoang
 */
public class WalletDTO {
    private int id;
    private int userid;
    private int coinid;
    private float pricebuy;
    private String datebuy;
    private float pricesell;
    private String datesell;
    private boolean stt;

    public WalletDTO() {
    }

    public WalletDTO(int id, int userid, int coinid, float pricebuy, String datebuy, float pricesell, String datesell, boolean stt) {
        this.id = id;
        this.userid = userid;
        this.coinid = coinid;
        this.pricebuy = pricebuy;
        this.datebuy = datebuy;
        this.pricesell = pricesell;
        this.datesell = datesell;
        this.stt = stt;
    }

    //Getter
    public int getId() {
        return id;
    }

    public int getUserid() {
        return userid;
    }

    public int getCoinid() {
        return coinid;
    }

    public float getPricebuy() {
        return pricebuy;
    }

    public String getDatebuy() {
        return datebuy;
    }

    public float getPricesell() {
        return pricesell;
    }

    public String getDatesell() {
        return datesell;
    }

    public boolean isStt() {
        return stt;
    }
    
    //Setter

    public void setId(int id) {
        this.id = id;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public void setCoinid(int coinid) {
        this.coinid = coinid;
    }

    public void setPricebuy(float pricebuy) {
        this.pricebuy = pricebuy;
    }

    public void setDatebuy(String datebuy) {
        this.datebuy = datebuy;
    }

    public void setPricesell(float pricesell) {
        this.pricesell = pricesell;
    }

    public void setDatesell(String datesell) {
        this.datesell = datesell;
    }

    public void setStt(boolean stt) {
        this.stt = stt;
    }
    
}
