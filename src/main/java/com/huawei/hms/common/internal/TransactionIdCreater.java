/*
 * Decompiled with CFR 0.151.
 */
package com.huawei.hms.common.internal;

import com.huawei.hms.utils.StringUtil;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

public class TransactionIdCreater {
    private static final int API_SIZE = 6;
    private static final int APPID_SIZE = 9;
    private static final char FILL_BYTE = '0';

    public static String getId(String object, String object2) {
        StringBuilder stringBuilder = new StringBuilder();
        char c10 = '0';
        object = StringUtil.addByteForNum((String)object, 9, c10);
        stringBuilder.append((String)object);
        object = StringUtil.addByteForNum((String)object2, 6, c10);
        stringBuilder.append((String)object);
        object2 = Locale.ENGLISH;
        object = new SimpleDateFormat("yyyyMMddHHmmssSSS", (Locale)object2);
        Serializable serializable = new Date();
        object = object.format((Date)serializable);
        stringBuilder.append((String)object);
        object = new Object[1];
        serializable = new Random();
        serializable = Integer.valueOf(((Random)serializable).nextInt(1000000));
        object[0] = serializable;
        object = String.format((Locale)object2, "%06d", object);
        stringBuilder.append((String)object);
        return stringBuilder.toString();
    }
}

