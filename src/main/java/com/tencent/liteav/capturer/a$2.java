/*
 * Decompiled with CFR 0.151.
 */
package com.tencent.liteav.capturer;

import com.tencent.liteav.capturer.a;
import java.util.Comparator;

public class a$2
implements Comparator {
    public final /* synthetic */ a a;

    public a$2(a a10) {
        this.a = a10;
    }

    public int a(int[] nArray, int[] nArray2) {
        int n10 = 1;
        int n11 = nArray[n10];
        int n12 = nArray2[n10];
        return n11 - n12;
    }

    public /* synthetic */ int compare(Object object, Object object2) {
        object = (int[])object;
        object2 = (int[])object2;
        return this.a((int[])object, (int[])object2);
    }
}

