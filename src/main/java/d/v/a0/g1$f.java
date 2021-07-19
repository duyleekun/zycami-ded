/*
 * Decompiled with CFR 0.151.
 */
package d.v.a0;

import com.zhiyun.proto.ZYEnumDefine$ConnectAction;

public class g1$f {
    public static final /* synthetic */ int[] a;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static {
        int n10;
        int n11;
        ZYEnumDefine$ConnectAction zYEnumDefine$ConnectAction;
        int n12 = ZYEnumDefine$ConnectAction.values().length;
        int[] nArray = new int[n12];
        a = nArray;
        try {
            zYEnumDefine$ConnectAction = ZYEnumDefine$ConnectAction.ConnectActionAgree;
            n11 = zYEnumDefine$ConnectAction.ordinal();
            nArray[n11] = n10 = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            zYEnumDefine$ConnectAction = ZYEnumDefine$ConnectAction.ConnectActionReject;
            n11 = zYEnumDefine$ConnectAction.ordinal();
            nArray[n11] = n10 = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            zYEnumDefine$ConnectAction = ZYEnumDefine$ConnectAction.ConnectActionDisconnect;
            n11 = zYEnumDefine$ConnectAction.ordinal();
            nArray[n11] = n10 = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            zYEnumDefine$ConnectAction = ZYEnumDefine$ConnectAction.ConnectActionCanecl;
            n11 = zYEnumDefine$ConnectAction.ordinal();
            nArray[n11] = n10 = 4;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}

