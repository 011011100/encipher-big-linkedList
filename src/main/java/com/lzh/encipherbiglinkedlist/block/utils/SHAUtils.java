package com.lzh.encipherbiglinkedlist.block.utils;

import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.security.MessageDigest;

/**
 * <p>
 * SHA加密<br>
 * </p>
 *
 * @author LZH
 * @version V1.0
 * @since 2023/7/7 15:02
 */
@Component
public class SHAUtils {

    private static final String KEY_SHA = "SHA";

    public static String encodeSHA(String content){
        byte[] inputData = content.getBytes();
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(KEY_SHA);
            messageDigest.update(inputData);
            BigInteger sha = new BigInteger(messageDigest.digest());
            return sha.toString(256);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
