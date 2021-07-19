/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.util;

import e.a.v0.c;
import java.util.List;

public final class ListAddBiConsumer
extends Enum
implements c {
    public static final /* enum */ ListAddBiConsumer INSTANCE;
    private static final /* synthetic */ ListAddBiConsumer[] a;

    static {
        ListAddBiConsumer listAddBiConsumer;
        INSTANCE = listAddBiConsumer = new ListAddBiConsumer("INSTANCE", 0);
        ListAddBiConsumer[] listAddBiConsumerArray = new ListAddBiConsumer[]{listAddBiConsumer};
        a = listAddBiConsumerArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private ListAddBiConsumer() {
        void var2_-1;
        void var1_-1;
    }

    public static c instance() {
        return INSTANCE;
    }

    public static ListAddBiConsumer valueOf(String string2) {
        return Enum.valueOf(ListAddBiConsumer.class, string2);
    }

    public static ListAddBiConsumer[] values() {
        return (ListAddBiConsumer[])a.clone();
    }

    public List apply(List list, Object object) {
        list.add(object);
        return list;
    }
}

