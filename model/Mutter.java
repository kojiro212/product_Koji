/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

/**
 *
 * @author matsuikoji
 */
public class Mutter implements Serializable {

    private String userName; //ユーザー名
    private String text; //つぶやきの内容

    public Mutter() {
    }

    public Mutter(String userName, String text) {
        this.userName = userName;
        this.text = text;
    }

    public String getUserName() {
        return userName;
    }

    public String getText() {
        return text;
    }
}
