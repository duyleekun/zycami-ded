/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.v0.u.b0;

import com.zhiyun.cama.data.MessagePageType;

public class b$a {
    public static final /* synthetic */ int[] a;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static {
        int n10;
        int n11;
        MessagePageType messagePageType;
        int n12 = MessagePageType.values().length;
        int[] nArray = new int[n12];
        a = nArray;
        try {
            messagePageType = MessagePageType.MESSAGE_LIKE;
            n11 = messagePageType.ordinal();
            nArray[n11] = n10 = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            messagePageType = MessagePageType.MESSAGE_SYSTEM;
            n11 = messagePageType.ordinal();
            nArray[n11] = n10 = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            messagePageType = MessagePageType.MESSAGE_PERSONAL;
            n11 = messagePageType.ordinal();
            nArray[n11] = n10 = 3;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}

