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
public class CoinDTO {
    private int id;
    private String coinname;
    private int userid;
    private boolean stt;

    public CoinDTO() {
    }

    public CoinDTO(int id, String coinname, int userid, boolean stt) {
        this.id = id;
        this.coinname = coinname;
        this.userid = userid;
        this.stt = stt;
    }

    //Getter
    public int getId() {
        return id;
    }

    public String getCoinname() {
        return coinname;
    }

    public int getUsercoin() {
        return userid;
    }

    public boolean isStt() {
        return stt;
    }
    
    //Setter

    public void setId(int id) {
        this.id = id;
    }

    public void setCoinname(String coinname) {
        this.coinname = coinname;
    }

    public void setUsercoin(int userid) {
        this.userid = userid;
    }

    public void setStt(boolean stt) {
        this.stt = stt;
    }
    
}
