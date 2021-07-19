/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.u1.n;

import com.zhiyun.editortemplate.data.resource.Status;
import com.zhiyun.editortemplate.util.DownloadState;

public class d0$d {
    public static final /* synthetic */ int[] a;
    public static final /* synthetic */ int[] b;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static {
        Object object;
        int n10;
        Enum enum_;
        int n11;
        Object object2;
        int n12;
        Object object3;
        int n13;
        Object object4;
        int n14 = Status.values().length;
        int[] nArray = new int[n14];
        b = nArray;
        int n15 = 1;
        try {
            object4 = Status.CACHE;
            n13 = object4.ordinal();
            nArray[n13] = n15;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        n14 = 2;
        try {
            object4 = b;
            object3 = Status.LOADING;
            n12 = object3.ordinal();
            object4[n12] = (Status)n14;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        n13 = 3;
        try {
            object3 = b;
            object2 = Status.SUCCESS;
            n11 = ((Enum)object2).ordinal();
            object3[n11] = (Status)n13;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        n12 = 4;
        try {
            object2 = b;
            enum_ = Status.ERROR;
            n10 = enum_.ordinal();
            object2[n10] = (Status)n12;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        n11 = DownloadState.values().length;
        object2 = new int[n11];
        a = (int[])object2;
        try {
            enum_ = DownloadState.INSUFFICIENT_RESOURCES;
            n10 = enum_.ordinal();
            object2[n10] = (Status)n15;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            object = a;
            object2 = DownloadState.PARSE_ERROR;
            n11 = ((Enum)object2).ordinal();
            object[n11] = n14;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            object = (Object)DownloadState.DOWNLOAD_FAILED;
            n15 = ((Enum)object).ordinal();
            nArray[n15] = n13;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            object = DownloadState.DOWNLOAD_NETWORK_FAILED;
            n15 = ((Enum)object).ordinal();
            nArray[n15] = n12;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}

