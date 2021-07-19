/*
 * Decompiled with CFR 0.151.
 */
package d.v.j.f;

import com.zhiyun.editortemplate.util.DownloadState;

public class g$a {
    public static final /* synthetic */ int[] a;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static {
        int n10;
        int n11;
        DownloadState downloadState;
        int n12 = DownloadState.values().length;
        int[] nArray = new int[n12];
        a = nArray;
        try {
            downloadState = DownloadState.NONE;
            n11 = downloadState.ordinal();
            nArray[n11] = n10 = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            downloadState = DownloadState.DOWNLOADING;
            n11 = downloadState.ordinal();
            nArray[n11] = n10 = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            downloadState = DownloadState.DOWNLOAD_SUCCESSFUL;
            n11 = downloadState.ordinal();
            nArray[n11] = n10 = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            downloadState = DownloadState.DOWNLOAD_FAILED;
            n11 = downloadState.ordinal();
            nArray[n11] = n10 = 4;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            downloadState = DownloadState.INSUFFICIENT_RESOURCES;
            n11 = downloadState.ordinal();
            nArray[n11] = n10 = 5;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            downloadState = DownloadState.PARSE_ERROR;
            n11 = downloadState.ordinal();
            nArray[n11] = n10 = 6;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = a;
            downloadState = DownloadState.DOWNLOAD_NETWORK_FAILED;
            n11 = downloadState.ordinal();
            nArray[n11] = n10 = 7;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}

