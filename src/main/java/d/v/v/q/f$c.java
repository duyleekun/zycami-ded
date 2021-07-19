/*
 * Decompiled with CFR 0.151.
 */
package d.v.v.q;

import com.zhiyun.editorinterface.EditConfig$ResourceType;

public class f$c {
    public static final /* synthetic */ int[] a;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static {
        int n10;
        int n11;
        EditConfig$ResourceType editConfig$ResourceType;
        int n12 = EditConfig$ResourceType.values().length;
        int[] nArray = new int[n12];
        a = nArray;
        try {
            editConfig$ResourceType = EditConfig$ResourceType.STICKER;
            n11 = editConfig$ResourceType.ordinal();
            nArray[n11] = n10 = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            editConfig$ResourceType = EditConfig$ResourceType.TRANSITION;
            n11 = editConfig$ResourceType.ordinal();
            nArray[n11] = n10 = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            editConfig$ResourceType = EditConfig$ResourceType.CAPTION;
            n11 = editConfig$ResourceType.ordinal();
            nArray[n11] = n10 = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            editConfig$ResourceType = EditConfig$ResourceType.FILTER;
            n11 = editConfig$ResourceType.ordinal();
            nArray[n11] = n10 = 4;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}

