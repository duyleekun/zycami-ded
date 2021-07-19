/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Handler$Callback
 *  android.text.TextUtils
 */
package com.zhiyun.account.data.me.remote;

import android.os.Handler;
import android.text.TextUtils;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.ShareSDK;
import com.zhiyun.account.R$string;
import com.zhiyun.account.data.me.ThirdPlatform;
import com.zhiyun.account.data.me.remote.AccountManager;
import com.zhiyun.account.data.me.remote.AccountManager$AuthData;
import com.zhiyun.account.data.me.remote.ThirdLoginManager$1;
import com.zhiyun.account.data.me.remote.ThirdLoginManager$2;
import com.zhiyun.account.data.me.remote.ThirdLoginManager$3;
import com.zhiyun.account.data.me.remote.ThirdLoginManager$OnThirdCallback;

public class ThirdLoginManager {
    private static final int MSG_CANCEL = 103;
    private static final int MSG_FAILED = 102;
    private static final int MSG_SUCCESS = 101;
    private static volatile ThirdLoginManager instance;
    private ThirdLoginManager$OnThirdCallback mCallback;
    private Handler mHandler;
    private ThirdPlatform mThirdPlatform;
    private PlatformActionListener sPlatformActionListener;

    private ThirdLoginManager() {
        ThirdLoginManager$1 thirdLoginManager$1 = new ThirdLoginManager$1(this);
        this.sPlatformActionListener = thirdLoginManager$1;
        ThirdLoginManager$3 thirdLoginManager$3 = new ThirdLoginManager$3(this);
        super((Handler.Callback)thirdLoginManager$3);
        this.mHandler = thirdLoginManager$1;
    }

    public static /* synthetic */ ThirdPlatform access$000(ThirdLoginManager thirdLoginManager) {
        return thirdLoginManager.mThirdPlatform;
    }

    public static /* synthetic */ void access$100(ThirdLoginManager thirdLoginManager, AccountManager$AuthData accountManager$AuthData) {
        thirdLoginManager.requestFacebook(accountManager$AuthData);
    }

    public static /* synthetic */ Handler access$200(ThirdLoginManager thirdLoginManager) {
        return thirdLoginManager.mHandler;
    }

    public static /* synthetic */ ThirdLoginManager$OnThirdCallback access$300(ThirdLoginManager thirdLoginManager) {
        return thirdLoginManager.mCallback;
    }

    private void authorize(Platform platform) {
        if (platform == null) {
            return;
        }
        boolean bl2 = platform.isAuthValid();
        if (bl2) {
            bl2 = true;
            platform.removeAccount(bl2);
        }
        PlatformActionListener platformActionListener = this.sPlatformActionListener;
        platform.setPlatformActionListener(platformActionListener);
        platform.SSOSetting(false);
        platform.showUser(null);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static ThirdLoginManager getInstance() {
        Object object = instance;
        if (object != null) return instance;
        object = ThirdLoginManager.class;
        synchronized (object) {
            ThirdLoginManager thirdLoginManager = instance;
            if (thirdLoginManager != null) return instance;
            instance = thirdLoginManager = new ThirdLoginManager();
            return instance;
        }
    }

    private void requestFacebook(AccountManager$AuthData accountManager$AuthData) {
        String string2 = accountManager$AuthData.access_token;
        ThirdLoginManager$2 thirdLoginManager$2 = new ThirdLoginManager$2(this, accountManager$AuthData);
        AccountManager.getFacebookToken(string2, thirdLoginManager$2);
    }

    public void thirdLogin(ThirdPlatform thirdPlatform, ThirdLoginManager$OnThirdCallback thirdLoginManager$OnThirdCallback) {
        this.mCallback = thirdLoginManager$OnThirdCallback;
        this.mThirdPlatform = thirdPlatform;
        Object object = ThirdPlatform.getShareSDKPlatformFromThird(thirdPlatform);
        boolean bl2 = TextUtils.isEmpty((CharSequence)object);
        if (!bl2) {
            object = ShareSDK.getPlatform((String)object);
            bl2 = thirdPlatform.isWebLogin();
            if (!(bl2 || object != null && (bl2 = ((Platform)object).isClientValid()))) {
                int n10 = R$string.share_app_uninstalled;
                int n11 = thirdPlatform.getAppName();
                thirdLoginManager$OnThirdCallback.onCancel(n10, n11);
            } else {
                this.authorize((Platform)object);
            }
        }
    }
}

