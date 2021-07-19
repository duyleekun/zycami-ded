/*
 * Decompiled with CFR 0.151.
 */
package d.v.a0;

import com.zhiyun.remotetransmitter.Constant$RemoteMode;

public class j1$a {
    public static final /* synthetic */ int[] a;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static {
        int n10;
        int n11;
        Constant$RemoteMode constant$RemoteMode;
        int n12 = Constant$RemoteMode.values().length;
        int[] nArray = new int[n12];
        a = nArray;
        try {
            constant$RemoteMode = Constant$RemoteMode.SERVER;
            n11 = constant$RemoteMode.ordinal();
            nArray[n11] = n10 = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            constant$RemoteMode = Constant$RemoteMode.CLIENT;
            n11 = constant$RemoteMode.ordinal();
            nArray[n11] = n10 = 2;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}

