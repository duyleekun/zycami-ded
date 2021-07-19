/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Handler$Callback
 *  android.text.TextUtils
 *  android.util.Patterns
 */
package com.zhiyun.cama.data.me.remote;

import android.os.Handler;
import android.text.TextUtils;
import android.util.Patterns;
import cn.sharesdk.facebook.Facebook;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.Platform$ShareParams;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.sina.weibo.SinaWeibo;
import cn.sharesdk.tencent.qq.QQ;
import cn.sharesdk.tencent.qzone.QZone;
import cn.sharesdk.twitter.Twitter;
import cn.sharesdk.wechat.friends.Wechat;
import cn.sharesdk.wechat.moments.WechatMoments;
import com.zhiyun.account.data.me.ThirdPlatform;
import com.zhiyun.cama.data.api.entity.ShareInfo;
import com.zhiyun.cama.data.me.remote.SharePlatformManager$1;
import com.zhiyun.cama.data.me.remote.SharePlatformManager$2;
import com.zhiyun.cama.data.me.remote.SharePlatformManager$3;
import com.zhiyun.cama.data.me.remote.SharePlatformManager$4;
import com.zhiyun.cama.data.me.remote.SharePlatformManager$OnShareCallback;
import d.v.c.v0.l.j;
import d.v.e.l.s1;
import d.v.f.i.g;
import k.d;
import k.f;

public class SharePlatformManager {
    private static final int MSG_CANCEL = 1003;
    private static final int MSG_FAILED = 1001;
    private static final int MSG_SUCCESS = 1002;
    private static volatile SharePlatformManager instance;
    private SharePlatformManager$OnShareCallback mCallback;
    private Handler mHandler;
    private ShareInfo mShareInfo;
    private PlatformActionListener sPlatformActionListener;

    private SharePlatformManager() {
        SharePlatformManager$1 sharePlatformManager$1 = new SharePlatformManager$1(this);
        this.sPlatformActionListener = sharePlatformManager$1;
        SharePlatformManager$2 sharePlatformManager$2 = new SharePlatformManager$2(this);
        super((Handler.Callback)sharePlatformManager$2);
        this.mHandler = sharePlatformManager$1;
    }

    public static /* synthetic */ Handler access$000(SharePlatformManager sharePlatformManager) {
        return sharePlatformManager.mHandler;
    }

    public static /* synthetic */ SharePlatformManager$OnShareCallback access$100(SharePlatformManager sharePlatformManager) {
        return sharePlatformManager.mCallback;
    }

    public static /* synthetic */ ShareInfo access$200(SharePlatformManager sharePlatformManager) {
        return sharePlatformManager.mShareInfo;
    }

    public static /* synthetic */ void access$300(SharePlatformManager sharePlatformManager, int n10, int n11) {
        sharePlatformManager.addShareCnt(n10, n11);
    }

    private void addShareCnt(int n10, int n11) {
        Object object;
        j j10 = j.a;
        if (n11 > 0) {
            object = String.valueOf(n11);
        } else {
            n11 = 0;
            object = null;
        }
        String string2 = d.v.a.f.c.d.d.F().K();
        d d10 = j10.c(n10, (String)object, string2);
        object = new SharePlatformManager$3(this);
        d10.h((f)object);
    }

    private void createShare(Platform platform, ShareInfo object, SharePlatformManager$OnShareCallback object2) {
        this.mCallback = object2;
        object = this.generateShareParams(platform, (ShareInfo)object);
        object2 = this.sPlatformActionListener;
        platform.setPlatformActionListener((PlatformActionListener)object2);
        platform.share((Platform$ShareParams)object);
    }

    private Platform$ShareParams generateShareParams(Platform object, ShareInfo object2) {
        String string2;
        Platform$ShareParams platform$ShareParams = new Platform$ShareParams();
        Object object3 = ((ShareInfo)object2).getSmallImgUrl();
        boolean n10 = TextUtils.isEmpty((CharSequence)object3);
        if (!n10) {
            object3 = Patterns.WEB_URL;
            string2 = ((ShareInfo)object2).getSmallImgUrl();
            boolean bl2 = (object3 = object3.matcher(string2)).matches();
            if (bl2) {
                object3 = ((ShareInfo)object2).getSmallImgUrl();
                platform$ShareParams.setImageUrl((String)object3);
            } else {
                object3 = ((ShareInfo)object2).getSmallImgUrl();
                platform$ShareParams.setImagePath((String)object3);
            }
        }
        boolean bl3 = ((ShareInfo)object2).isShareImage();
        string2 = " ";
        if (bl3) {
            int n11;
            boolean bl4;
            boolean bl5;
            String string3;
            object3 = ((Platform)object).getName();
            boolean bl6 = object3.equals(string3 = SinaWeibo.NAME);
            if (!(bl6 || (bl5 = (object3 = ((Platform)object).getName()).equals(string3 = Twitter.NAME)) || (bl4 = (object3 = ((Platform)object).getName()).equals(string3 = Facebook.NAME)))) {
                n11 = (int)(((String)(object = ((Platform)object).getName())).equals(object3 = QQ.NAME) ? 1 : 0);
                if (n11 == 0) {
                    object = ((ShareInfo)object2).getShareContent();
                    platform$ShareParams.setText((String)object);
                }
            } else {
                object = new StringBuilder();
                object3 = ((ShareInfo)object2).getShareContent();
                ((StringBuilder)object).append((String)object3);
                ((StringBuilder)object).append(string2);
                object2 = ((ShareInfo)object2).getPostUrl();
                ((StringBuilder)object).append((String)object2);
                object = ((StringBuilder)object).toString();
                platform$ShareParams.setText((String)object);
            }
            n11 = 2;
            platform$ShareParams.setShareType(n11);
        } else {
            int n12;
            Object object4;
            object3 = ((ShareInfo)object2).getShareContent();
            boolean bl7 = TextUtils.isEmpty((CharSequence)object3);
            Object var7_16 = null;
            if (bl7) {
                int n13 = 2131952945;
                object4 = new Object[]{};
                object3 = SharePlatformManager.getString(n13, object4);
                ((ShareInfo)object2).setShareContent((String)object3);
            }
            object3 = ((ShareInfo)object2).getShareContent();
            platform$ShareParams.setTitle((String)object3);
            object3 = ((ShareInfo)object2).getPostUrl();
            platform$ShareParams.setTitleUrl((String)object3);
            object3 = ((Platform)object).getName();
            object4 = SinaWeibo.NAME;
            boolean bl8 = object3.equals(object4);
            int n14 = 2131952934;
            if (!bl8 && (n12 = ((String)(object = ((Platform)object).getName())).equals(object3 = Twitter.NAME)) == 0) {
                object = new Object[]{};
                object = SharePlatformManager.getString(n14, (Object[])object);
                platform$ShareParams.setText((String)object);
                object = ((ShareInfo)object2).getPostUrl();
                platform$ShareParams.setUrl((String)object);
            } else {
                object = new StringBuilder();
                object3 = new Object[]{};
                object3 = SharePlatformManager.getString(n14, object3);
                ((StringBuilder)object).append((String)object3);
                ((StringBuilder)object).append(string2);
                object3 = ((ShareInfo)object2).getPostUrl();
                ((StringBuilder)object).append((String)object3);
                object = ((StringBuilder)object).toString();
                platform$ShareParams.setText((String)object);
                n12 = 0;
                object = null;
                platform$ShareParams.setUrl(null);
            }
            object3 = new Object[]{};
            object = SharePlatformManager.getString(2131951754, object3);
            platform$ShareParams.setSite((String)object);
            object = ((ShareInfo)object2).getPostUrl();
            platform$ShareParams.setSiteUrl((String)object);
            object = ((ShareInfo)object2).getFileUrl();
            n12 = this.isVideo((String)object);
            if (n12 != 0) {
                n12 = 6;
                platform$ShareParams.setShareType(n12);
            } else {
                n12 = 4;
                platform$ShareParams.setShareType(n12);
            }
        }
        return platform$ShareParams;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static SharePlatformManager getInstance() {
        Object object = instance;
        if (object != null) return instance;
        object = SharePlatformManager.class;
        synchronized (object) {
            SharePlatformManager sharePlatformManager = instance;
            if (sharePlatformManager != null) return instance;
            instance = sharePlatformManager = new SharePlatformManager();
            return instance;
        }
    }

    public static String getShareSDKPlatformFromThird(ThirdPlatform object) {
        int[] nArray = SharePlatformManager$4.$SwitchMap$com$zhiyun$account$data$me$ThirdPlatform;
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
                object = QQ.NAME;
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

    public static String getString(int n10, Object ... objectArray) {
        return g.p(d.v.e.f.a().c().getResources(), n10, objectArray);
    }

    private boolean isVideo(String string2) {
        String string3;
        boolean bl2;
        boolean bl3 = TextUtils.isEmpty((CharSequence)string2);
        boolean bl4 = false;
        if (bl3) {
            return false;
        }
        bl3 = TextUtils.isEmpty((CharSequence)(string2 = s1.J(string2).toLowerCase()));
        if (!bl3 && (bl2 = string2.contains(string3 = "mp4"))) {
            bl4 = true;
        }
        return bl4;
    }

    public void goShare(ThirdPlatform object, ShareInfo shareInfo, SharePlatformManager$OnShareCallback sharePlatformManager$OnShareCallback) {
        this.mShareInfo = shareInfo;
        this.mCallback = sharePlatformManager$OnShareCallback;
        Object object2 = SharePlatformManager.getShareSDKPlatformFromThird(object);
        boolean bl2 = TextUtils.isEmpty((CharSequence)object2);
        if (!bl2) {
            if ((object2 = ShareSDK.getPlatform((String)object2)) != null && (bl2 = object2.isClientValid())) {
                this.createShare((Platform)object2, shareInfo, sharePlatformManager$OnShareCallback);
            } else {
                int n10 = 2131952933;
                int n11 = 1;
                object2 = new Object[n11];
                int n12 = object.getAppName();
                bl2 = false;
                Object[] objectArray = new Object[]{};
                object = SharePlatformManager.getString(n12, objectArray);
                object2[0] = object;
                object = SharePlatformManager.getString(n10, object2);
                sharePlatformManager$OnShareCallback.onShareFailed((String)object);
            }
        }
    }
}

