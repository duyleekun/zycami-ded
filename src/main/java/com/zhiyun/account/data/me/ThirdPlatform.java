/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.account.data.me;

import cn.sharesdk.facebook.Facebook;
import cn.sharesdk.sina.weibo.SinaWeibo;
import cn.sharesdk.tencent.qq.QQ;
import cn.sharesdk.tencent.qzone.QZone;
import cn.sharesdk.twitter.Twitter;
import cn.sharesdk.wechat.friends.Wechat;
import cn.sharesdk.wechat.moments.WechatMoments;
import com.zhiyun.account.R$string;
import com.zhiyun.account.data.me.ThirdPlatform$a;

public final class ThirdPlatform
extends Enum {
    private static final /* synthetic */ ThirdPlatform[] $VALUES;
    public static final /* enum */ ThirdPlatform FACEBOOK;
    public static final /* enum */ ThirdPlatform KWAI_UPLOAD;
    public static final /* enum */ ThirdPlatform MOMENT;
    public static final /* enum */ ThirdPlatform QQ;
    public static final /* enum */ ThirdPlatform QQ_ZONE;
    public static final /* enum */ ThirdPlatform TWITTER;
    public static final /* enum */ ThirdPlatform WEIBO;
    public static final /* enum */ ThirdPlatform WE_CHAT;
    private String apiName;
    private int appName;
    private boolean isWebLogin;

    static {
        ThirdPlatform thirdPlatform;
        ThirdPlatform thirdPlatform2;
        ThirdPlatform thirdPlatform3;
        ThirdPlatform thirdPlatform4;
        ThirdPlatform thirdPlatform5;
        ThirdPlatform thirdPlatform6;
        ThirdPlatform thirdPlatform7;
        ThirdPlatform thirdPlatform8;
        int n10 = R$string.share_we_chat;
        WE_CHAT = thirdPlatform8 = new ThirdPlatform("WE_CHAT", 0, "weixin", n10);
        int n11 = 1;
        ThirdPlatform[] thirdPlatformArray = "";
        MOMENT = thirdPlatform7 = new ThirdPlatform("MOMENT", n11, (String)thirdPlatformArray, n10);
        int n12 = R$string.share_weibo;
        int n13 = 2;
        WEIBO = thirdPlatform6 = new ThirdPlatform("WEIBO", n13, "weibo", n12);
        int n14 = R$string.share_qq;
        int n15 = 3;
        QQ = thirdPlatform5 = new ThirdPlatform("QQ", n15, "qq", n14);
        QQ_ZONE = thirdPlatform4 = new ThirdPlatform("QQ_ZONE", 4, (String)thirdPlatformArray, n14);
        int n16 = R$string.share_facebook;
        FACEBOOK = thirdPlatform3 = new ThirdPlatform("FACEBOOK", 5, "facebook", n16);
        int n17 = R$string.share_twitter;
        TWITTER = thirdPlatform2 = new ThirdPlatform("TWITTER", 6, "twitter", n17);
        n17 = R$string.share_kwai;
        int n18 = 7;
        KWAI_UPLOAD = thirdPlatform = new ThirdPlatform("KWAI_UPLOAD", n18, (String)thirdPlatformArray, n17);
        thirdPlatformArray = new ThirdPlatform[8];
        thirdPlatformArray[0] = thirdPlatform8;
        thirdPlatformArray[n11] = thirdPlatform7;
        thirdPlatformArray[n13] = thirdPlatform6;
        thirdPlatformArray[n15] = thirdPlatform5;
        thirdPlatformArray[4] = thirdPlatform4;
        thirdPlatformArray[5] = thirdPlatform3;
        thirdPlatformArray[6] = thirdPlatform2;
        thirdPlatformArray[n18] = thirdPlatform;
        $VALUES = thirdPlatformArray;
    }

    /*
     * WARNING - void declaration
     */
    private ThirdPlatform() {
        void var4_2;
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.apiName = var3_1;
        this.appName = var4_2;
    }

    public static String getShareSDKPlatformFromThird(ThirdPlatform object) {
        int[] nArray = ThirdPlatform$a.a;
        int n10 = object.ordinal();
        n10 = nArray[n10];
        switch (n10) {
            default: {
                n10 = 0;
                object = null;
                break;
            }
            case 7: {
                object = Twitter.NAME;
                break;
            }
            case 6: {
                object = Facebook.NAME;
                break;
            }
            case 5: {
                object = QZone.NAME;
                break;
            }
            case 4: {
                object = cn.sharesdk.tencent.qq.QQ.NAME;
                break;
            }
            case 3: {
                object = SinaWeibo.NAME;
                break;
            }
            case 2: {
                object = WechatMoments.NAME;
                break;
            }
            case 1: {
                object = Wechat.NAME;
            }
        }
        return object;
    }

    public static ThirdPlatform shareTypeToPlatformName(String object) {
        int n10;
        int n11;
        int n12;
        int n13;
        int n14;
        int n15;
        block22: {
            int n16 = object.hashCode();
            n15 = 5;
            n14 = 4;
            n13 = 3;
            n12 = 2;
            n11 = 1;
            switch (n16) {
                default: {
                    break;
                }
                case 1743330334: {
                    String string2 = "wxGroup";
                    n10 = (int)(object.equals(string2) ? 1 : 0);
                    if (n10 == 0) break;
                    n10 = n11;
                    break block22;
                }
                case 953542106: {
                    String string3 = "copyurl";
                    n10 = (int)(object.equals(string3) ? 1 : 0);
                    if (n10 == 0) break;
                    n10 = 7;
                    break block22;
                }
                case 497130182: {
                    String string4 = "facebook";
                    n10 = (int)(object.equals(string4) ? 1 : 0);
                    if (n10 == 0) break;
                    n10 = n14;
                    break block22;
                }
                case 113011944: {
                    String string5 = "weibo";
                    n10 = (int)(object.equals(string5) ? 1 : 0);
                    if (n10 == 0) break;
                    n10 = n13;
                    break block22;
                }
                case 3809: {
                    String string6 = "wx";
                    n10 = (int)(object.equals(string6) ? 1 : 0);
                    if (n10 == 0) break;
                    n10 = 0;
                    object = null;
                    break block22;
                }
                case 3616: {
                    String string7 = "qq";
                    n10 = (int)(object.equals(string7) ? 1 : 0);
                    if (n10 == 0) break;
                    n10 = n12;
                    break block22;
                }
                case -916346253: {
                    String string8 = "twitter";
                    n10 = (int)(object.equals(string8) ? 1 : 0);
                    if (n10 == 0) break;
                    n10 = n15;
                    break block22;
                }
                case -934521548: {
                    String string9 = "report";
                    n10 = (int)(object.equals(string9) ? 1 : 0);
                    if (n10 == 0) break;
                    n10 = 6;
                    break block22;
                }
            }
            n10 = -1;
        }
        if (n10 != 0) {
            if (n10 != n11) {
                if (n10 != n12) {
                    if (n10 != n13) {
                        if (n10 != n14) {
                            if (n10 != n15) {
                                n10 = 0;
                                object = null;
                            } else {
                                object = TWITTER;
                            }
                        } else {
                            object = FACEBOOK;
                        }
                    } else {
                        object = WEIBO;
                    }
                } else {
                    object = QQ;
                }
            } else {
                object = MOMENT;
            }
        } else {
            object = WE_CHAT;
        }
        return object;
    }

    public static ThirdPlatform valueOf(String string2) {
        return Enum.valueOf(ThirdPlatform.class, string2);
    }

    public static ThirdPlatform[] values() {
        return (ThirdPlatform[])$VALUES.clone();
    }

    public String getApiName() {
        return this.apiName;
    }

    public int getAppName() {
        return this.appName;
    }

    public boolean isWebLogin() {
        return this.isWebLogin;
    }

    public void setApiName(String string2) {
        this.apiName = string2;
    }

    public void setAppName(int n10) {
        this.appName = n10;
    }

    public void setWebLogin(boolean bl2) {
        this.isWebLogin = bl2;
    }
}

