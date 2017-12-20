/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author matsuikoji
 */
public class PostMutterLogic {

    public void execute(Mutter mutter, ArrayList<Mutter> mutterList) {
        mutterList.add(0, mutter); //先頭に追加
    }

}
