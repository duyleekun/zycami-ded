/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.editortemplate.util;

public final class DownloadState
extends Enum {
    public static final /* enum */ DownloadState DOWNLOADING;
    public static final /* enum */ DownloadState DOWNLOAD_FAILED;
    public static final /* enum */ DownloadState DOWNLOAD_NETWORK_FAILED;
    public static final /* enum */ DownloadState DOWNLOAD_SUCCESSFUL;
    public static final /* enum */ DownloadState INSUFFICIENT_RESOURCES;
    public static final /* enum */ DownloadState NONE;
    public static final /* enum */ DownloadState PARSE_ERROR;
    private static final /* synthetic */ DownloadState[] a;

    static {
        DownloadState downloadState;
        DownloadState downloadState2;
        DownloadState downloadState3;
        DownloadState downloadState4;
        DownloadState downloadState5;
        DownloadState downloadState6;
        DownloadState downloadState7;
        NONE = downloadState7 = new DownloadState("NONE", 0);
        int n10 = 1;
        DOWNLOADING = downloadState6 = new DownloadState("DOWNLOADING", n10);
        int n11 = 2;
        DOWNLOAD_SUCCESSFUL = downloadState5 = new DownloadState("DOWNLOAD_SUCCESSFUL", n11);
        int n12 = 3;
        DOWNLOAD_FAILED = downloadState4 = new DownloadState("DOWNLOAD_FAILED", n12);
        int n13 = 4;
        PARSE_ERROR = downloadState3 = new DownloadState("PARSE_ERROR", n13);
        int n14 = 5;
        INSUFFICIENT_RESOURCES = downloadState2 = new DownloadState("INSUFFICIENT_RESOURCES", n14);
        int n15 = 6;
        DOWNLOAD_NETWORK_FAILED = downloadState = new DownloadState("DOWNLOAD_NETWORK_FAILED", n15);
        DownloadState[] downloadStateArray = new DownloadState[7];
        downloadStateArray[0] = downloadState7;
        downloadStateArray[n10] = downloadState6;
        downloadStateArray[n11] = downloadState5;
        downloadStateArray[n12] = downloadState4;
        downloadStateArray[n13] = downloadState3;
        downloadStateArray[n14] = downloadState2;
        downloadStateArray[n15] = downloadState;
        a = downloadStateArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private DownloadState() {
        void var2_-1;
        void var1_-1;
    }

    public static DownloadState valueOf(String string2) {
        return Enum.valueOf(DownloadState.class, string2);
    }

    public static DownloadState[] values() {
        return (DownloadState[])a.clone();
    }
}

