/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package socketdaoxau.model;

/**
 *
 * @author Admin
 */
public class StringModifyModel {
    public static String reverseString(String str){
        StringBuffer sb = new StringBuffer(str);
        sb.reverse();
        return sb.toString();
    }
}
