package com.cheshangguanjia.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EncodeUtils {

//	private static final char[] LETTERS = "0123456789ABCDEF".toCharArray();
//	
//	public static String sha1(String value) {
//		try {
//			return hash(MessageDigest.getInstance("SHA1"), value);
//		} catch (NoSuchAlgorithmException e) {
//			e.printStackTrace();
//		}
//		return null;
//	}
//	
//	
//	private static String hash(MessageDigest digest,String src) {
//		return toHexString(digest.digest(src.getBytes()));
//	}
//	
//	private static String toHexString(byte[] bytes) {
//		char[] values = new char[bytes.length * 2];
//		int i=0;
//		for(byte b : bytes) {
//			values[i++] = LETTERS[((b & 0xF0) >>> 4)];
//			values[i++] = LETTERS[b & 0xF];
//		}
//		return String.valueOf(values);
//	}
	
	private static String byte2Hex(byte b) {
        int value = (b & 0x7F) + (b < 0 ? 0x80 : 0);
        return (value < 0x10 ? "0" : "")
                + Integer.toHexString(value).toLowerCase();
    }

    public static String MD5_32(String passwd) {
        MessageDigest md5;
        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
        StringBuffer strbuf = new StringBuffer();

        md5.update(passwd.getBytes(), 0, passwd.length());
        byte[] digest = md5.digest();

        for (int i = 0; i < digest.length; i++) {
            strbuf.append(byte2Hex(digest[i]));
        }

        return strbuf.toString();
    }

    public static String MD5_16(String passwd)  {
        return MD5_32(passwd).subSequence(8, 24).toString();
    }

    public static String byteMD5_32(byte [] passwd) {
        MessageDigest md5;
        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
        StringBuffer strbuf = new StringBuffer();

        md5.update(passwd, 0, passwd.length);
        byte[] digest = md5.digest();

        for (int i = 0; i < digest.length; i++) {
            strbuf.append(byte2Hex(digest[i]));
        }

        return strbuf.toString();
	}
}
