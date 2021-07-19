/*
 * Decompiled with CFR 0.151.
 */
package com.tencent.rtmp.downloader;

import com.tencent.rtmp.TXPlayerAuthBuilder;

public class TXVodDownloadDataSource {
    public static final int QUALITY_2K = 5;
    public static final int QUALITY_4K = 6;
    public static final int QUALITY_FHD = 4;
    public static final int QUALITY_FLU = 1;
    public static final int QUALITY_HD = 3;
    public static final int QUALITY_OD = 0;
    public static final int QUALITY_SD = 2;
    public static final int QUALITY_UNK = 1000;
    public TXPlayerAuthBuilder authBuilder;
    public int quality = 1000;
    public String templateName;
    public String token;

    public TXVodDownloadDataSource(TXPlayerAuthBuilder tXPlayerAuthBuilder, int n10) {
        this.authBuilder = tXPlayerAuthBuilder;
        this.quality = n10;
    }

    public TXVodDownloadDataSource(TXPlayerAuthBuilder tXPlayerAuthBuilder, String string2) {
        this.authBuilder = tXPlayerAuthBuilder;
        this.templateName = string2;
    }

    public static String qualityToId(int n10) {
        int n11 = 1;
        if (n10 == n11) {
            return "FLU";
        }
        n11 = 2;
        if (n10 == n11) {
            return "SD";
        }
        n11 = 3;
        if (n10 == n11) {
            return "HD";
        }
        n11 = 4;
        if (n10 == n11) {
            return "FHD";
        }
        n11 = 5;
        if (n10 == n11) {
            return "2K";
        }
        n11 = 6;
        if (n10 == n11) {
            return "4K";
        }
        return "";
    }

    public TXPlayerAuthBuilder getAuthBuilder() {
        return this.authBuilder;
    }

    public int getQuality() {
        return this.quality;
    }

    public String getTemplateName() {
        return this.templateName;
    }

    public String getToken() {
        return this.token;
    }

    public void setToken(String string2) {
        this.token = string2;
    }
}

