/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud;

public final class AVUser$SNS_PLATFORM
extends Enum {
    private static final /* synthetic */ AVUser$SNS_PLATFORM[] $VALUES;
    public static final /* enum */ AVUser$SNS_PLATFORM FACEBOOK;
    public static final /* enum */ AVUser$SNS_PLATFORM QQ;
    public static final /* enum */ AVUser$SNS_PLATFORM TWITTER;
    public static final /* enum */ AVUser$SNS_PLATFORM WECHAT;
    public static final /* enum */ AVUser$SNS_PLATFORM WEIBO;
    private String name;

    static {
        AVUser$SNS_PLATFORM aVUser$SNS_PLATFORM;
        AVUser$SNS_PLATFORM aVUser$SNS_PLATFORM2;
        AVUser$SNS_PLATFORM aVUser$SNS_PLATFORM3;
        AVUser$SNS_PLATFORM aVUser$SNS_PLATFORM4;
        AVUser$SNS_PLATFORM aVUser$SNS_PLATFORM5;
        FACEBOOK = aVUser$SNS_PLATFORM5 = new AVUser$SNS_PLATFORM("FACEBOOK", 0, "facebook");
        int n10 = 1;
        TWITTER = aVUser$SNS_PLATFORM4 = new AVUser$SNS_PLATFORM("TWITTER", n10, "twitter");
        int n11 = 2;
        QQ = aVUser$SNS_PLATFORM3 = new AVUser$SNS_PLATFORM("QQ", n11, "qq");
        int n12 = 3;
        WEIBO = aVUser$SNS_PLATFORM2 = new AVUser$SNS_PLATFORM("WEIBO", n12, "weibo");
        int n13 = 4;
        WECHAT = aVUser$SNS_PLATFORM = new AVUser$SNS_PLATFORM("WECHAT", n13, "weixin");
        AVUser$SNS_PLATFORM[] aVUser$SNS_PLATFORMArray = new AVUser$SNS_PLATFORM[5];
        aVUser$SNS_PLATFORMArray[0] = aVUser$SNS_PLATFORM5;
        aVUser$SNS_PLATFORMArray[n10] = aVUser$SNS_PLATFORM4;
        aVUser$SNS_PLATFORMArray[n11] = aVUser$SNS_PLATFORM3;
        aVUser$SNS_PLATFORMArray[n12] = aVUser$SNS_PLATFORM2;
        aVUser$SNS_PLATFORMArray[n13] = aVUser$SNS_PLATFORM;
        $VALUES = aVUser$SNS_PLATFORMArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private AVUser$SNS_PLATFORM() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.name = var3_1;
    }

    public static AVUser$SNS_PLATFORM valueOf(String string2) {
        return Enum.valueOf(AVUser$SNS_PLATFORM.class, string2);
    }

    public static AVUser$SNS_PLATFORM[] values() {
        return (AVUser$SNS_PLATFORM[])$VALUES.clone();
    }

    public String getName() {
        return this.name;
    }
}

