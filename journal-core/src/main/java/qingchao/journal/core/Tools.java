package qingchao.journal.core;

import java.util.Locale;

public final class Tools {

    public static String bytesToHex(byte[] a) {
        StringBuilder sb = new StringBuilder(a.length * 2);
        for (byte b : a)
            sb.append(String.format(Locale.ENGLISH, "%02x", b & 0xff)).append(' ');
        return sb.toString().trim();
    }
}
