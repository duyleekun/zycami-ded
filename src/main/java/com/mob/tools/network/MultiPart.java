/*
 * Decompiled with CFR 0.151.
 */
package com.mob.tools.network;

import com.mob.tools.network.HTTPPart;
import com.mob.tools.network.MultiPartInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;

public class MultiPart
extends HTTPPart {
    private ArrayList parts;

    public MultiPart() {
        ArrayList arrayList;
        this.parts = arrayList = new ArrayList();
    }

    public MultiPart append(HTTPPart hTTPPart) {
        this.parts.add(hTTPPart);
        return this;
    }

    public InputStream getInputStream() {
        boolean bl2;
        MultiPartInputStream multiPartInputStream = new MultiPartInputStream();
        Iterator iterator2 = this.parts.iterator();
        while (bl2 = iterator2.hasNext()) {
            InputStream inputStream = ((HTTPPart)iterator2.next()).getInputStream();
            multiPartInputStream.addInputStream(inputStream);
        }
        return multiPartInputStream;
    }

    public long length() {
        boolean bl2;
        Iterator iterator2 = this.parts.iterator();
        long l10 = 0L;
        while (bl2 = iterator2.hasNext()) {
            HTTPPart hTTPPart = (HTTPPart)iterator2.next();
            long l11 = hTTPPart.length();
            l10 += l11;
        }
        return l10;
    }

    public String toString() {
        boolean bl2;
        StringBuilder stringBuilder = new StringBuilder();
        Iterator iterator2 = this.parts.iterator();
        while (bl2 = iterator2.hasNext()) {
            String string2 = ((HTTPPart)iterator2.next()).toString();
            stringBuilder.append(string2);
        }
        return stringBuilder.toString();
    }
}

