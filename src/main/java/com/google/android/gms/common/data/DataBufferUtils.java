/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.common.data;

import com.google.android.gms.common.data.DataBuffer;
import com.google.android.gms.common.data.Freezable;
import java.util.ArrayList;
import java.util.Iterator;

public final class DataBufferUtils {
    public static final String KEY_NEXT_PAGE_TOKEN = "next_page_token";
    public static final String KEY_PREV_PAGE_TOKEN = "prev_page_token";

    private DataBufferUtils() {
    }

    public static ArrayList freezeAndClose(DataBuffer dataBuffer) {
        Iterator iterator2;
        int n10 = dataBuffer.getCount();
        ArrayList<Object> arrayList = new ArrayList<Object>(n10);
        try {
            iterator2 = dataBuffer.iterator();
        }
        catch (Throwable throwable) {
            dataBuffer.close();
            throw throwable;
        }
        while (true) {
            boolean bl2 = iterator2.hasNext();
            if (!bl2) break;
            Object object = iterator2.next();
            object = (Freezable)object;
            object = object.freeze();
            arrayList.add(object);
            continue;
            break;
        }
        dataBuffer.close();
        return arrayList;
    }

    public static boolean hasData(DataBuffer dataBuffer) {
        int n10;
        return dataBuffer != null && (n10 = dataBuffer.getCount()) > 0;
    }

    public static boolean hasNextPage(DataBuffer object) {
        String string2;
        return (object = object.getMetadata()) != null && (object = object.getString(string2 = KEY_NEXT_PAGE_TOKEN)) != null;
    }

    public static boolean hasPrevPage(DataBuffer object) {
        String string2;
        return (object = object.getMetadata()) != null && (object = object.getString(string2 = KEY_PREV_PAGE_TOKEN)) != null;
    }
}

