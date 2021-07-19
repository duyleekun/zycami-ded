/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.u1.l;

import com.zhiyun.cama.template.PlayState;
import com.zhiyun.editortemplate.util.DownloadState;

public class l$b {
    public static final /* synthetic */ int[] a;
    public static final /* synthetic */ int[] b;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static {
        DownloadState downloadState;
        int n10;
        Enum enum_;
        int n11 = PlayState.values().length;
        int[] nArray = new int[n11];
        b = nArray;
        int n12 = 1;
        try {
            enum_ = PlayState.STATE_ERROR_IO;
            n10 = enum_.ordinal();
            nArray[n10] = n12;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        n11 = DownloadState.values().length;
        nArray = new int[n11];
        a = nArray;
        try {
            enum_ = DownloadState.DOWNLOADING;
            n10 = enum_.ordinal();
            nArray[n10] = n12;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            downloadState = DownloadState.DOWNLOAD_SUCCESSFUL;
            n12 = downloadState.ordinal();
            nArray[n12] = n10 = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            downloadState = DownloadState.NONE;
            n12 = downloadState.ordinal();
            nArray[n12] = n10 = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            downloadState = DownloadState.PARSE_ERROR;
            n12 = downloadState.ordinal();
            nArray[n12] = n10 = 4;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            downloadState = DownloadState.INSUFFICIENT_RESOURCES;
            n12 = downloadState.ordinal();
            nArray[n12] = n10 = 5;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            downloadState = DownloadState.DOWNLOAD_FAILED;
            n12 = downloadState.ordinal();
            nArray[n12] = n10 = 6;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            downloadState = DownloadState.DOWNLOAD_NETWORK_FAILED;
            n12 = downloadState.ordinal();
            nArray[n12] = n10 = 7;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}

