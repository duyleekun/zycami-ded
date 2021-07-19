/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.Application
 *  android.content.Context
 *  android.content.res.Resources
 *  android.graphics.Bitmap$CompressFormat
 *  android.graphics.BitmapFactory
 *  android.text.TextUtils
 */
package com.zhiyun.cama.data.me.remote;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import com.kwai.opensdk.sdk.model.base.BaseReq;
import com.kwai.opensdk.sdk.model.base.BaseResp;
import com.kwai.opensdk.sdk.model.postshare.AICutMedias$Req;
import com.kwai.opensdk.sdk.model.postshare.PostShareMediaInfo;
import com.kwai.opensdk.sdk.model.postshare.SingleVideoEdit$Req;
import com.kwai.opensdk.sdk.model.postshare.SingleVideoPublish$Req;
import com.kwai.opensdk.sdk.model.socialshare.KwaiMediaMessage;
import com.kwai.opensdk.sdk.model.socialshare.KwaiWebpageObject;
import com.kwai.opensdk.sdk.model.socialshare.ShareMessage$Req;
import com.kwai.opensdk.sdk.openapi.IKwaiOpenAPI;
import com.kwai.opensdk.sdk.openapi.KwaiOpenAPI;
import com.kwai.opensdk.sdk.utils.KwaiPlatformUtil;
import com.kwai.opensdk.sdk.utils.NetworkUtil;
import com.zhiyun.account.data.me.ThirdPlatform;
import com.zhiyun.cama.data.PagingRequestHelper$Status;
import com.zhiyun.cama.data.me.remote.KWaiManager$1;
import com.zhiyun.cama.data.me.remote.KWaiManager$2;
import com.zhiyun.cama.data.me.remote.KWaiManager$OnKWaiCallback;
import com.zhiyun.cama.data.me.remote.KWaiManager$OnKWaiLoginCallback;
import com.zhiyun.cama.data.me.remote.data.KwaiTokenInfo;
import d.l.a.b;
import d.l.a.f.b.a$b;
import d.v.a.f.c.d.d;
import d.v.c.v0.l.j;
import d.v.c.v0.u.c0.g;
import d.v.e.i.h;
import d.v.e.l.q2.c;
import d.v.n.j.a;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import k.f;

public class KWaiManager {
    private static final int ERR_NO_KWAI_APP = 64531;
    private static final int ERR_OK = 1;
    private static final int NETWORK_MAX_RETRY_TIMES = 5;
    public static String SCOPE = "user_info,user_video_live,share_media";
    private static final String URL_HOST = "https://open.kuaishou.com";
    private static volatile KWaiManager instance;
    private String mAppId;
    private String mAppKey;
    private b mILoginListener;
    private IKwaiOpenAPI mKwaiOpenAPI;
    private MutableLiveData mKwaiTokenInfo;
    private MutableLiveData mStatus;
    private final String[] platformArray;

    private KWaiManager() {
        Object object = new String[]{"kwai_app", "nebula_app"};
        this.platformArray = object;
        this.mKwaiTokenInfo = object;
        super();
        this.mStatus = object;
    }

    private /* synthetic */ void a(KWaiManager$OnKWaiCallback object, int n10, int n11, Context context, BaseResp baseResp) {
        int n12 = 2131952937;
        if (baseResp != null) {
            Object[] objectArray;
            int n13 = 1;
            int n14 = baseResp.errorCode;
            if (n13 == n14) {
                object.onSuccess();
                int n15 = -1;
                if (n15 != n10) {
                    this.addShareCnt(n10, n11);
                }
            } else {
                n10 = -1005;
                if (n10 == n14) {
                    n10 = 2131952933;
                    Object[] objectArray2 = new Object[n13];
                    n12 = ThirdPlatform.KWAI_UPLOAD.getAppName();
                    String string2 = d.v.f.i.g.m(context, n12);
                    objectArray2[0] = string2;
                    objectArray = d.v.f.i.g.n(context, n10, objectArray2);
                    object.onFailed((String)objectArray);
                } else {
                    objectArray = d.v.f.i.g.m(context, n12);
                    object.onFailed((String)objectArray);
                }
            }
            object = new StringBuilder();
            ((StringBuilder)object).append("errorCode=");
            n10 = baseResp.errorCode;
            ((StringBuilder)object).append(n10);
            ((StringBuilder)object).append(", errorMsg=");
            objectArray = baseResp.errorMsg;
            ((StringBuilder)object).append((String)objectArray);
            ((StringBuilder)object).append(", cmd=");
            objectArray = baseResp.getCommand();
            ((StringBuilder)object).append(objectArray);
            ((StringBuilder)object).append(", transaction=");
            objectArray = baseResp.transaction;
            ((StringBuilder)object).append((String)objectArray);
            object = ((StringBuilder)object).toString();
            objectArray = new Object[]{};
            m.a.a.b((String)object, objectArray);
        } else {
            String string3 = d.v.f.i.g.m(context, n12);
            object.onFailed(string3);
            object = new Object[]{};
            string3 = "CallBackResult: resp is null";
            m.a.a.b(string3, (Object[])object);
        }
        this.mKwaiOpenAPI.removeKwaiAPIEventListerer();
    }

    public static /* synthetic */ MutableLiveData access$000(KWaiManager kWaiManager) {
        return kWaiManager.mStatus;
    }

    public static /* synthetic */ KwaiTokenInfo access$100(KWaiManager kWaiManager, String string2) {
        return kWaiManager.getOpenIdByNetwork(string2);
    }

    public static /* synthetic */ MutableLiveData access$200(KWaiManager kWaiManager) {
        return kWaiManager.mKwaiTokenInfo;
    }

    private void addKWaiShareListener(Context context, KWaiManager$OnKWaiCallback kWaiManager$OnKWaiCallback) {
        int n10 = -1;
        this.addKWaiShareListener(context, kWaiManager$OnKWaiCallback, n10, n10);
    }

    private void addKWaiShareListener(Context context, KWaiManager$OnKWaiCallback kWaiManager$OnKWaiCallback, int n10, int n11) {
        IKwaiOpenAPI iKwaiOpenAPI = this.mKwaiOpenAPI;
        g g10 = new g(this, kWaiManager$OnKWaiCallback, n10, n11, context);
        iKwaiOpenAPI.addKwaiAPIEventListerer(g10);
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
        String string2 = d.F().K();
        k.d d10 = j10.c(n10, (String)object, string2);
        object = new KWaiManager$1(this);
        d10.h((f)object);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static KWaiManager getInstance() {
        Object object = instance;
        if (object != null) return instance;
        object = KWaiManager.class;
        synchronized (object) {
            KWaiManager kWaiManager = instance;
            if (kWaiManager != null) return instance;
            instance = kWaiManager = new KWaiManager();
            return instance;
        }
    }

    private KwaiTokenInfo getOpenIdByNetwork(String string2) {
        String string3 = this.mAppId;
        String string4 = this.mAppKey;
        string2 = NetworkUtil.get(this.getRequestOpenIdUrl("code", string3, string4, string2), null, null);
        return (KwaiTokenInfo)c.a(KwaiTokenInfo.class, string2);
    }

    private String getRequestOpenIdUrl(String string2, String string3, String string4, String string5) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(URL_HOST);
        stringBuilder.append("/oauth2/access_token?");
        stringBuilder.append("grant_type=");
        stringBuilder.append(string2);
        stringBuilder.append("&app_id=");
        stringBuilder.append(string3);
        stringBuilder.append("&app_secret=");
        stringBuilder.append(string4);
        stringBuilder.append("&code=");
        stringBuilder.append(string5);
        return stringBuilder.toString();
    }

    public void aiCutMedias(ArrayList arrayList, Activity activity) {
        AICutMedias$Req aICutMedias$Req = new AICutMedias$Req();
        Object object = this.mKwaiOpenAPI.getOpenAPISessionId();
        aICutMedias$Req.sessionId = object;
        object = new String[]{"kwai_app", "nebula_app"};
        aICutMedias$Req.setPlatformArray((String[])object);
        aICutMedias$Req.transaction = "AICutMedias";
        aICutMedias$Req.mediaInfo = object = new PostShareMediaInfo();
        object.mMultiMediaAssets = arrayList;
        object.mDisableFallback = false;
        this.mKwaiOpenAPI.sendReq(aICutMedias$Req, activity);
    }

    public /* synthetic */ void b(KWaiManager$OnKWaiCallback kWaiManager$OnKWaiCallback, int n10, int n11, Context context, BaseResp baseResp) {
        this.a(kWaiManager$OnKWaiCallback, n10, n11, context, baseResp);
    }

    public void clearKwaiTokenInfo() {
        h.g(this.mKwaiTokenInfo, null);
    }

    public void editorSingleVideo(Activity activity, int n10, int n11, String string2, KWaiManager$OnKWaiCallback kWaiManager$OnKWaiCallback) {
        if (kWaiManager$OnKWaiCallback != null) {
            this.addKWaiShareListener((Context)activity, kWaiManager$OnKWaiCallback, n10, n11);
        }
        SingleVideoEdit$Req singleVideoEdit$Req = new SingleVideoEdit$Req();
        Object object = this.mKwaiOpenAPI.getOpenAPISessionId();
        singleVideoEdit$Req.sessionId = object;
        object = new String[]{"kwai_app", "nebula_app"};
        singleVideoEdit$Req.setPlatformArray((String[])object);
        singleVideoEdit$Req.transaction = "SingleVideoEdit";
        object = new PostShareMediaInfo();
        singleVideoEdit$Req.mediaInfo = object;
        object = new ArrayList();
        ((ArrayList)object).add(string2);
        singleVideoEdit$Req.mediaInfo.mMultiMediaAssets = object;
        this.mKwaiOpenAPI.sendReq(singleVideoEdit$Req, activity);
    }

    public void getKwaiAccessToken(Activity activity) {
        this.getKwaiAccessToken(activity, null);
    }

    public void getKwaiAccessToken(Activity object, KWaiManager$OnKWaiLoginCallback object2) {
        Object object3 = new KWaiManager$2(this, (KWaiManager$OnKWaiLoginCallback)object2);
        this.mILoginListener = object3;
        object2 = new a$b();
        object3 = a.M;
        object2 = ((a$b)object2).e((String)object3).b("code").c(1);
        object3 = new String[]{"kwai_app", "nebula_app"};
        object2 = ((a$b)object2).d((String[])object3).a();
        object3 = d.l.a.c.f();
        b b10 = this.mILoginListener;
        ((d.l.a.c)object3).l((Activity)object, (d.l.a.f.b.a)object2, b10);
        object = this.mStatus;
        object2 = PagingRequestHelper$Status.RUNNING;
        h.g((MutableLiveData)object, object2);
    }

    public LiveData getKwaiTokenInfo() {
        return Transformations.distinctUntilChanged(this.mKwaiTokenInfo);
    }

    public LiveData getStatus() {
        return Transformations.distinctUntilChanged(this.mStatus);
    }

    public void init(Application application, String object, String string2) {
        this.mAppId = object;
        this.mAppKey = string2;
        d.l.a.c.i(application);
        this.mKwaiOpenAPI = object = new KwaiOpenAPI((Context)application);
    }

    public boolean isKwaiAppSupport(Context object) {
        boolean bl2;
        int n10 = this.platformArray.length;
        ArrayList arrayList = new ArrayList(n10);
        String[] stringArray = this.platformArray;
        Collections.addAll(arrayList, stringArray);
        object = KwaiPlatformUtil.matchSupportAPI((Context)object, arrayList);
        if (object != null && !(bl2 = object.isEmpty())) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    public boolean isKwaiInstall(Context object) {
        boolean bl2;
        String[] stringArray = this.platformArray;
        if ((object = KwaiPlatformUtil.validateAppInstalled((Context)object, stringArray)) != null && !(bl2 = object.isEmpty())) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    public void publishSingleVideo(Activity activity, int n10, int n11, String object, String string2, KWaiManager$OnKWaiCallback object2) {
        if (object2 != null) {
            this.addKWaiShareListener((Context)activity, (KWaiManager$OnKWaiCallback)object2, n10, n11);
        }
        SingleVideoPublish$Req singleVideoPublish$Req = new SingleVideoPublish$Req();
        Object object3 = this.mKwaiOpenAPI.getOpenAPISessionId();
        singleVideoPublish$Req.sessionId = object3;
        object2 = "nebula_app";
        object3 = new String[]{"kwai_app", object2};
        singleVideoPublish$Req.setPlatformArray((String[])object3);
        singleVideoPublish$Req.transaction = "SingleVideoPublish";
        object3 = new PostShareMediaInfo();
        singleVideoPublish$Req.mediaInfo = object3;
        object3 = new ArrayList();
        ((ArrayList)object3).add(object);
        object = singleVideoPublish$Req.mediaInfo;
        ((PostShareMediaInfo)object).mMultiMediaAssets = object3;
        n11 = (int)(TextUtils.isEmpty((CharSequence)string2) ? 1 : 0);
        if (n11 == 0) {
            singleVideoPublish$Req.mCover = string2;
        }
        this.mKwaiOpenAPI.sendReq(singleVideoPublish$Req, activity);
    }

    public void setNormalStatus() {
        this.mStatus.setValue(null);
    }

    public void shareMessage(Activity activity, String object, int n10, KWaiManager$OnKWaiCallback object2) {
        if (object2 != null) {
            this.addKWaiShareListener((Context)activity, (KWaiManager$OnKWaiCallback)object2);
        }
        object2 = new ShareMessage$Req();
        Object object3 = this.mKwaiOpenAPI.getOpenAPISessionId();
        ((BaseReq)object2).sessionId = object3;
        ((BaseReq)object2).transaction = "sharemessage";
        ((ShareMessage$Req)object2).message = object3 = new KwaiMediaMessage();
        KwaiWebpageObject kwaiWebpageObject = new KwaiWebpageObject();
        ((KwaiMediaMessage)object3).mediaObject = kwaiWebpageObject;
        object3 = ((ShareMessage$Req)object2).message;
        kwaiWebpageObject = (KwaiWebpageObject)((KwaiMediaMessage)object3).mediaObject;
        kwaiWebpageObject.webpageUrl = object;
        ((KwaiMediaMessage)object3).title = "test";
        ((KwaiMediaMessage)object3).description = "web page test share, hahahah";
        object = BitmapFactory.decodeResource((Resources)activity.getResources(), (int)n10);
        Object object4 = new ByteArrayOutputStream();
        if (object != null) {
            object3 = Bitmap.CompressFormat.PNG;
            int n11 = 100;
            object.compress((Bitmap.CompressFormat)object3, n11, (OutputStream)object4);
            object = ((ShareMessage$Req)object2).message;
            object4 = ((ByteArrayOutputStream)object4).toByteArray();
            ((KwaiMediaMessage)object).thumbData = (byte[])object4;
        }
        this.mKwaiOpenAPI.sendReq((BaseReq)object2, activity);
    }
}

