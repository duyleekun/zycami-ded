/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.text.TextUtils
 */
package com.huawei.hms.push;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.aaid.task.PushClientBuilder;
import com.huawei.hms.api.Api;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.HuaweiApi;
import com.huawei.hms.common.internal.AbstractClientBuilder;
import com.huawei.hms.common.internal.Preconditions;
import com.huawei.hms.common.internal.TaskApiCall;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.push.s;
import com.huawei.hms.push.task.ProfileTask;
import com.huawei.hms.push.utils.PushBiUtil;
import com.huawei.hms.support.api.entity.push.ProfileReq;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.JsonUtil;
import d.j.a.f.a;
import d.j.d.a.k;
import d.j.d.a.l;
import d.j.f.a.a.h.c.d;

public class HmsProfile {
    public static final int CUSTOM_PROFILE = 2;
    public static final int HUAWEI_PROFILE = 1;
    public static final String a = "HmsProfile";
    public Context b = null;
    public HuaweiApi c;

    public HmsProfile(Context context) {
        Preconditions.checkNotNull(context);
        this.b = context;
        Object object = "HuaweiPush.API";
        Api api = new Api((String)object);
        boolean bl2 = context instanceof Activity;
        if (bl2) {
            context = (Activity)context;
            PushClientBuilder pushClientBuilder = new PushClientBuilder();
            this.c = object = new HuaweiApi((Activity)context, api, null, (AbstractClientBuilder)pushClientBuilder);
        } else {
            PushClientBuilder pushClientBuilder = new PushClientBuilder();
            this.c = object = new HuaweiApi(context, api, null, (AbstractClientBuilder)pushClientBuilder);
        }
        this.c.setKitSdkVersion(50101300);
    }

    public static String a(Context context) {
        return d.j.a.f.a.a(context).g("client/project_id");
    }

    public static HmsProfile getInstance(Context context) {
        HmsProfile hmsProfile = new HmsProfile(context);
        return hmsProfile;
    }

    public final k a(int n10, String object, int n11, String object2) {
        Object object3;
        Object object4;
        boolean bl2 = this.isSupportProfile();
        if (!bl2) {
            l l10 = new l();
            object = ErrorEnum.ERROR_OPERATION_NOT_SUPPORTED.toApiException();
            l10.c((Exception)object);
            return l10.b();
        }
        bl2 = TextUtils.isEmpty((CharSequence)object);
        if (!bl2) {
            object4 = HmsProfile.a(this.b);
            boolean bl3 = TextUtils.isEmpty((CharSequence)object4);
            if (bl3) {
                HMSLog.i(a, "agc connect services config missing project id.");
                l l11 = new l();
                object = ErrorEnum.ERROR_MISSING_PROJECT_ID.toApiException();
                l11.c((Exception)object);
                return l11.b();
            }
            bl2 = ((String)object).equals(object4);
            if (bl2) {
                object = "";
            }
        }
        object4 = new ProfileReq();
        if (n10 == 0) {
            n10 = 0;
            object3 = null;
            ((ProfileReq)object4).setOperation(0);
            ((ProfileReq)object4).setType(n11);
        } else {
            n10 = 1;
            ((ProfileReq)object4).setOperation(n10);
        }
        object3 = this.b;
        String string2 = "push.profile";
        object3 = PushBiUtil.reportEntry(object3, string2);
        try {
            ((ProfileReq)object4).setSubjectId((String)object);
            object = d.b((String)object2);
        }
        catch (Exception exception) {
            object2 = exception.getCause();
            boolean bl4 = object2 instanceof ApiException;
            if (bl4) {
                object2 = new l();
                ApiException apiException = (ApiException)exception.getCause();
                ((l)object2).c(apiException);
                object4 = this.b;
                int n12 = apiException.getStatusCode();
                PushBiUtil.reportExit((Context)object4, string2, (String)object3, n12);
                return ((l)object2).b();
            }
            l l12 = new l();
            object2 = this.b;
            object4 = ErrorEnum.ERROR_INTERNAL_ERROR;
            PushBiUtil.reportExit((Context)object2, string2, (String)object3, (ErrorEnum)((Object)object4));
            object3 = ((ErrorEnum)((Object)object4)).toApiException();
            l12.c((Exception)object3);
            return l12.b();
        }
        ((ProfileReq)object4).setProfileId((String)object);
        object = this.b;
        object = object.getPackageName();
        ((ProfileReq)object4).setPkgName((String)object);
        object = this.c;
        object4 = JsonUtil.createJsonString((IMessageEntity)object4);
        object2 = new ProfileTask(string2, (String)object4, (String)object3);
        return ((HuaweiApi)object).doWrite((TaskApiCall)object2);
    }

    public k addProfile(int n10, String string2) {
        return this.addProfile("", n10, string2);
    }

    public k addProfile(String object, int n10, String string2) {
        int n11 = 1;
        if (n10 != n11 && n10 != (n11 = 2)) {
            HMSLog.i(a, "add profile type undefined.");
            object = new l();
            ApiException apiException = ErrorEnum.ERROR_PUSH_ARGUMENTS_INVALID.toApiException();
            ((l)object).c(apiException);
            return ((l)object).b();
        }
        n11 = (int)(TextUtils.isEmpty((CharSequence)string2) ? 1 : 0);
        if (n11 != 0) {
            HMSLog.i(a, "add profile params is empty.");
            object = new l();
            ApiException apiException = ErrorEnum.ERROR_PUSH_ARGUMENTS_INVALID.toApiException();
            ((l)object).c(apiException);
            return ((l)object).b();
        }
        return this.a(0, (String)object, n10, string2);
    }

    public final boolean b(Context context) {
        long l10;
        long l11 = s.b(context);
        long l12 = l11 - (l10 = 110001400L);
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object >= 0) {
            object = 1;
        } else {
            object = 0;
            context = null;
        }
        return (boolean)object;
    }

    public k deleteProfile(String string2) {
        return this.deleteProfile("", string2);
    }

    public k deleteProfile(String object, String object2) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)object2);
        if (bl2) {
            HMSLog.e(a, "del profile params is empty.");
            object = new l();
            object2 = ErrorEnum.ERROR_PUSH_ARGUMENTS_INVALID.toApiException();
            ((l)object).c((Exception)object2);
            return ((l)object).b();
        }
        return this.a(1, (String)object, -1, (String)object2);
    }

    public boolean isSupportProfile() {
        Context context = this.b;
        boolean bl2 = s.d(context);
        if (bl2) {
            bl2 = s.c();
            if (bl2) {
                HMSLog.i(a, "current EMUI version below 9.1, not support profile operation.");
                return false;
            }
            context = this.b;
            bl2 = this.b(context);
            if (!bl2) {
                HMSLog.i(a, "current HwPushService.apk version below 11.0.1.400,please upgrade your HwPushService.apk version.");
                return false;
            }
        }
        return true;
    }
}

