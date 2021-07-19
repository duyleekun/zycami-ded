/*
 * Decompiled with CFR 0.151.
 */
package d.v.a0;

import com.zhiyun.remoteprotocol.constant.ProtoType;

public class l1$a {
    public static final /* synthetic */ int[] a;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static {
        int n10;
        int n11;
        ProtoType protoType;
        int n12 = ProtoType.values().length;
        int[] nArray = new int[n12];
        a = nArray;
        try {
            protoType = ProtoType.NO_PROTO;
            n11 = protoType.ordinal();
            nArray[n11] = n10 = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            protoType = ProtoType.EVENT;
            n11 = protoType.ordinal();
            nArray[n11] = n10 = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            protoType = ProtoType.STATE_INFO;
            n11 = protoType.ordinal();
            nArray[n11] = n10 = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            protoType = ProtoType.DEVICE_INFO;
            n11 = protoType.ordinal();
            nArray[n11] = n10 = 4;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            protoType = ProtoType.CONNECT;
            n11 = protoType.ordinal();
            nArray[n11] = n10 = 5;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            protoType = ProtoType.HEARTBEAT;
            n11 = protoType.ordinal();
            nArray[n11] = n10 = 6;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}

