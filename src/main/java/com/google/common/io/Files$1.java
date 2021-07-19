/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.io;

import com.google.common.collect.Lists;
import com.google.common.io.LineProcessor;
import java.util.ArrayList;
import java.util.List;

public final class Files$1
implements LineProcessor {
    public final List result;

    public Files$1() {
        ArrayList arrayList = Lists.newArrayList();
        this.result = arrayList;
    }

    public List getResult() {
        return this.result;
    }

    public boolean processLine(String string2) {
        this.result.add(string2);
        return true;
    }
}

