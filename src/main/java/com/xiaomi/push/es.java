/*
 * Decompiled with CFR 0.151.
 */
package com.xiaomi.push;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class es
extends Enum {
    public static final /* enum */ es a;
    private static final /* synthetic */ es[] a;
    public static final /* enum */ es b;
    public static final /* enum */ es c;
    public static final /* enum */ es d;
    public String a;

    static {
        es es2;
        es es3;
        es es4;
        es es5;
        a = es5 = new es("ACTIVITY", 0, "activity");
        int n10 = 1;
        b = es4 = new es("SERVICE_ACTION", n10, "service_action");
        int n11 = 2;
        c = es3 = new es("SERVICE_COMPONENT", n11, "service_component");
        int n12 = 3;
        d = es2 = new es("PROVIDER", n12, "provider");
        es[] esArray = new es[4];
        esArray[0] = es5;
        esArray[n10] = es4;
        esArray[n11] = es3;
        esArray[n12] = es2;
        a = esArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private es() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.a = var3_1;
    }

    public static es valueOf(String string2) {
        return Enum.valueOf(es.class, string2);
    }

    public static es[] values() {
        return (es[])a.clone();
    }
}

