/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 */
package com.huawei.hms.common.data;

import android.os.Bundle;
import com.huawei.hms.common.data.DataBuffer;
import com.huawei.hms.common.data.Freezable;
import java.util.ArrayList;
import java.util.Iterator;

public final class DataBufferUtils {
    public static final int ARGS_BUNDLE = 4;
    public static final int ARGS_COLUMN = 1;
    public static final int ARGS_CURSOR = 2;
    public static final int ARGS_STATUS = 3;
    public static final int ARGS_VERSION = 1000;
    public static final String NEXT_PAGE = "next_page";
    public static final String PREV_PAGE = "prev_page";

    private DataBufferUtils() {
    }

    private static boolean containKey(Bundle object, String string2) {
        boolean bl2 = false;
        if (object == null) {
            return false;
        }
        if ((object = object.getString(string2)) != null) {
            bl2 = true;
        }
        return bl2;
    }

    public static ArrayList freezeAndClose(DataBuffer dataBuffer) {
        boolean bl2;
        int n10 = dataBuffer.getCount();
        ArrayList<Object> arrayList = new ArrayList<Object>(n10);
        Iterator iterator2 = dataBuffer.iterator();
        while (bl2 = iterator2.hasNext()) {
            Object object = ((Freezable)iterator2.next()).freeze();
            arrayList.add(object);
        }
        dataBuffer.release();
        return arrayList;
    }

    public static boolean hasData(DataBuffer dataBuffer) {
        boolean bl2 = false;
        if (dataBuffer == null) {
            return false;
        }
        int n10 = dataBuffer.getCount();
        if (n10 > 0) {
            bl2 = true;
        }
        return bl2;
    }

    public static boolean hasNextPage(DataBuffer dataBuffer) {
        return DataBufferUtils.containKey(dataBuffer.getMetadata(), NEXT_PAGE);
    }

    public static boolean hasPrevPage(DataBuffer dataBuffer) {
        return DataBufferUtils.containKey(dataBuffer.getMetadata(), PREV_PAGE);
    }
}

