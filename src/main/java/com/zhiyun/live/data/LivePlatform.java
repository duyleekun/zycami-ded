/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.live.data;

import com.zhiyun.live.R$drawable;
import com.zhiyun.live.R$string;

public final class LivePlatform
extends Enum {
    public static final /* enum */ LivePlatform FACEBOOK;
    public static final /* enum */ LivePlatform HELPER;
    public static final /* enum */ LivePlatform KWAI;
    public static final /* enum */ LivePlatform RESTREAM;
    public static final /* enum */ LivePlatform RTMP;
    public static final /* enum */ LivePlatform WEIBO;
    private static final /* synthetic */ LivePlatform[] a;
    private int platformIcon;
    private int platformIconRound;
    private String platformName;
    private int platformNameRes;

    static {
        LivePlatform livePlatform;
        LivePlatform livePlatform2;
        LivePlatform livePlatform3;
        LivePlatform livePlatform4;
        LivePlatform livePlatform5;
        int n10 = R$string.live_weibo;
        int n11 = R$drawable.ic_zf_sq_home_share_weibo;
        int n12 = R$drawable.ic_zf_xj_live_weibo;
        LivePlatform livePlatform6 = livePlatform5;
        WEIBO = livePlatform5 = new LivePlatform("WEIBO", 0, "weibo", n10, n11, n12);
        int n13 = R$string.live_kuaishou;
        int n14 = R$drawable.ic_zf_sq_home_share_kuaishou;
        int n15 = R$drawable.ic_zf_xj_live_qs;
        KWAI = livePlatform6 = new LivePlatform("KWAI", 1, "kuaishou", n13, n14, n15);
        int n16 = R$string.live_facebook;
        int n17 = R$drawable.ic_zf_sq_home_share_facebook;
        int n18 = R$drawable.ic_zf_xj_live_facebook;
        FACEBOOK = livePlatform4 = new LivePlatform("FACEBOOK", 2, "facebook", n16, n17, n18);
        n13 = R$string.live_restream;
        n14 = R$drawable.ic_zf_xj_live_restream_small;
        n15 = R$drawable.ic_zf_xj_live_restream;
        RESTREAM = livePlatform3 = new LivePlatform("RESTREAM", 3, "restream", n13, n14, n15);
        n16 = R$string.live_rtmp;
        n17 = R$drawable.ic_zf_xj_live_rtmp_small;
        n18 = R$drawable.ic_zf_xj_live_rtmp;
        RTMP = livePlatform2 = new LivePlatform("RTMP", 4, "custom", n16, n17, n18);
        n13 = R$string.live_screen_capture;
        n14 = n15 = R$drawable.ic_zf_prime_label;
        HELPER = livePlatform = new LivePlatform("HELPER", 5, "custom", n13, n15, n15);
        LivePlatform[] livePlatformArray = new LivePlatform[]{livePlatform5, livePlatform6, livePlatform4, livePlatform3, livePlatform2, livePlatform};
        a = livePlatformArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private LivePlatform(int n10, int n11) {
        void var6_4;
        void var5_3;
        void var2_-1;
        void var1_-1;
        this.platformName = (String)n10;
        this.platformNameRes = n11;
        this.platformIconRound = var5_3;
        this.platformIcon = var6_4;
    }

    public static LivePlatform valueOf(String string2) {
        return Enum.valueOf(LivePlatform.class, string2);
    }

    public static LivePlatform[] values() {
        return (LivePlatform[])a.clone();
    }

    public int getPlatformIcon() {
        return this.platformIcon;
    }

    public int getPlatformIconRound() {
        return this.platformIconRound;
    }

    public String getPlatformName() {
        return this.platformName;
    }

    public int getPlatformNameRes() {
        return this.platformNameRes;
    }

    public void setPlatformIcon(int n10) {
        this.platformIcon = n10;
    }

    public void setPlatformIconRound(int n10) {
        this.platformIconRound = n10;
    }

    public void setPlatformName(String string2) {
        this.platformName = string2;
    }

    public void setPlatformNameRes(int n10) {
        this.platformNameRes = n10;
    }
}

