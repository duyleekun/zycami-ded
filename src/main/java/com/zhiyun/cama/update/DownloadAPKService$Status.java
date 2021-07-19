/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.update;

public final class DownloadAPKService$Status
extends Enum {
    public static final /* enum */ DownloadAPKService$Status DOWNLOADING;
    public static final /* enum */ DownloadAPKService$Status FAIL;
    public static final /* enum */ DownloadAPKService$Status SUCCESS;
    private static final /* synthetic */ DownloadAPKService$Status[] a;

    static {
        DownloadAPKService$Status downloadAPKService$Status;
        DownloadAPKService$Status downloadAPKService$Status2;
        DownloadAPKService$Status downloadAPKService$Status3;
        DOWNLOADING = downloadAPKService$Status3 = new DownloadAPKService$Status("DOWNLOADING", 0);
        int n10 = 1;
        FAIL = downloadAPKService$Status2 = new DownloadAPKService$Status("FAIL", n10);
        int n11 = 2;
        SUCCESS = downloadAPKService$Status = new DownloadAPKService$Status("SUCCESS", n11);
        DownloadAPKService$Status[] downloadAPKService$StatusArray = new DownloadAPKService$Status[3];
        downloadAPKService$StatusArray[0] = downloadAPKService$Status3;
        downloadAPKService$StatusArray[n10] = downloadAPKService$Status2;
        downloadAPKService$StatusArray[n11] = downloadAPKService$Status;
        a = downloadAPKService$StatusArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private DownloadAPKService$Status() {
        void var2_-1;
        void var1_-1;
    }

    public static DownloadAPKService$Status valueOf(String string2) {
        return Enum.valueOf(DownloadAPKService$Status.class, string2);
    }

    public static DownloadAPKService$Status[] values() {
        return (DownloadAPKService$Status[])a.clone();
    }
}

