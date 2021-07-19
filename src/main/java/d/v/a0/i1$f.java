/*
 * Decompiled with CFR 0.151.
 */
package d.v.a0;

import com.zhiyun.proto.ZYEnumDefine$ConnectAction;
import com.zhiyun.proto.ZYEnumDefine$EventTypeAction;

public class i1$f {
    public static final /* synthetic */ int[] a;
    public static final /* synthetic */ int[] b;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static {
        int n10;
        int n11;
        Enum enum_;
        int n12;
        Object object;
        int n13 = ZYEnumDefine$ConnectAction.values().length;
        int[] nArray = new int[n13];
        b = nArray;
        int n14 = 1;
        try {
            object = ZYEnumDefine$ConnectAction.ConnectActionConnect;
            n12 = ((Enum)object).ordinal();
            nArray[n12] = n14;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        n13 = 2;
        try {
            object = b;
            enum_ = ZYEnumDefine$ConnectAction.ConnectActionDisconnect;
            n11 = enum_.ordinal();
            object[n11] = n13;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            object = b;
            enum_ = ZYEnumDefine$ConnectAction.ConnectActionCanecl;
            n11 = enum_.ordinal();
            n10 = 3;
            object[n11] = n10;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            object = b;
            enum_ = ZYEnumDefine$ConnectAction.ConnectActionAgree;
            n11 = enum_.ordinal();
            n10 = 4;
            object[n11] = n10;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            object = b;
            enum_ = ZYEnumDefine$ConnectAction.ConnectActionReject;
            n11 = enum_.ordinal();
            n10 = 5;
            object[n11] = n10;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        n12 = ZYEnumDefine$EventTypeAction.values().length;
        object = new int[n12];
        a = (int[])object;
        try {
            enum_ = ZYEnumDefine$EventTypeAction.EventTypeActionRead;
            n11 = enum_.ordinal();
            object[n11] = n14;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            int[] nArray2 = a;
            object = ZYEnumDefine$EventTypeAction.EventTypeActionWrite;
            n12 = ((Enum)object).ordinal();
            nArray2[n12] = n13;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}

