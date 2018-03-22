package ua.nure.garmash.Practice3;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class Part4 {

    private static byte[] getHash(String input, String algorithm) throws NoSuchAlgorithmException {
        MessageDigest digest;
        digest = MessageDigest.getInstance(algorithm);
        digest.update(input.getBytes());
        return digest.digest();

    }

    public static String getHexString(byte[] inputArray) {
        StringBuilder resultString = new StringBuilder();
        for (int i = 0; i < inputArray.length; i++) {
            resultString.append(String.format("%02X", inputArray[i]));
        }
        resultString.trimToSize();
        return resultString.toString();
    }

    public static String hash(String input, String alg) throws NoSuchAlgorithmException {
        StringBuilder sb = new StringBuilder().append(getHexString(getHash(input, alg)));
        sb.trimToSize();
        return sb.toString();

    }

    public static void main(String[] args) throws NoSuchAlgorithmException {
        System.out.println(hash("adf", "MD5"));


    }

}
