/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.negocio;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author PC1
 */
public class Password {
    
    // Estudiar como funciona
    
    public static String encriptar(String valor) {
        MessageDigest md;
        try {

            md = MessageDigest.getInstance("SHA-256");

        } catch (NoSuchAlgorithmException e) {
            return null;
        }

        byte[] hash = md.digest(valor.getBytes());
        StringBuilder sb = new StringBuilder();

        for (byte b : hash) {
            sb.append(String.format("%02x", b));
        }

        return sb.toString();
    }
    
}
