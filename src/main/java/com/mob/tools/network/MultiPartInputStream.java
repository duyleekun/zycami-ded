/*
 * Decompiled with CFR 0.151.
 */
package com.mob.tools.network;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;

public class MultiPartInputStream
extends InputStream {
    private int curIs;
    private ArrayList isList;

    public MultiPartInputStream() {
        ArrayList arrayList;
        this.isList = arrayList = new ArrayList();
    }

    private boolean isEmpty() {
        int n10;
        ArrayList arrayList = this.isList;
        if (arrayList != null && (n10 = arrayList.size()) > 0) {
            n10 = 0;
            arrayList = null;
        } else {
            n10 = 1;
        }
        return n10 != 0;
    }

    public void addInputStream(InputStream inputStream) {
        this.isList.add(inputStream);
    }

    public int available() {
        boolean bl2 = this.isEmpty();
        if (bl2) {
            return 0;
        }
        ArrayList arrayList = this.isList;
        int n10 = this.curIs;
        return ((InputStream)arrayList.get(n10)).available();
    }

    public void close() {
        boolean bl2;
        Iterator iterator2 = this.isList.iterator();
        while (bl2 = iterator2.hasNext()) {
            InputStream inputStream = (InputStream)iterator2.next();
            inputStream.close();
        }
    }

    public int read() {
        int n10 = this.isEmpty();
        if (n10 != 0) {
            return -1;
        }
        Object object = this.isList;
        int n11 = this.curIs;
        object = (InputStream)((ArrayList)object).get(n11);
        n10 = ((InputStream)object).read();
        while (n10 < 0) {
            this.curIs = n11 = this.curIs + 1;
            ArrayList arrayList = this.isList;
            int n12 = arrayList.size();
            if (n11 >= n12) break;
            object = this.isList;
            n11 = this.curIs;
            object = (InputStream)((ArrayList)object).get(n11);
            n10 = ((InputStream)object).read();
        }
        return n10;
    }

    public int read(byte[] byArray, int n10, int n11) {
        int n12 = this.isEmpty();
        if (n12 != 0) {
            return -1;
        }
        Object object = this.isList;
        int n13 = this.curIs;
        object = (InputStream)((ArrayList)object).get(n13);
        n12 = ((InputStream)object).read(byArray, n10, n11);
        while (n12 < 0) {
            this.curIs = n13 = this.curIs + 1;
            ArrayList arrayList = this.isList;
            int n14 = arrayList.size();
            if (n13 >= n14) break;
            object = this.isList;
            n13 = this.curIs;
            object = (InputStream)((ArrayList)object).get(n13);
            n12 = ((InputStream)object).read(byArray, n10, n11);
        }
        return n12;
    }

    public long skip(long l10) {
        IOException iOException = new IOException();
        throw iOException;
    }
}

