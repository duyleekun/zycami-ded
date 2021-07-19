/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.k1.a;

import com.zhiyun.editorinterface.edit.MediaType;

public class w$b {
    public static final /* synthetic */ int[] a;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static {
        int n10;
        int n11;
        MediaType mediaType;
        int n12 = MediaType.values().length;
        int[] nArray = new int[n12];
        a = nArray;
        try {
            mediaType = MediaType.ALL;
            n11 = mediaType.ordinal();
            nArray[n11] = n10 = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            mediaType = MediaType.VIDEO;
            n11 = mediaType.ordinal();
            nArray[n11] = n10 = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            mediaType = MediaType.IMAGE;
            n11 = mediaType.ordinal();
            nArray[n11] = n10 = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            mediaType = MediaType.GIF;
            n11 = mediaType.ordinal();
            nArray[n11] = n10 = 4;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}

