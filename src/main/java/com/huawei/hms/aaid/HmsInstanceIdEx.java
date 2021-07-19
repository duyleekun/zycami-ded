/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 */
package com.huawei.hms.aaid;

import android.app.Activity;
import android.content.Context;
import com.huawei.hms.aaid.HmsInstanceId;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.aaid.entity.TokenReq;
import com.huawei.hms.aaid.entity.TokenResult;
import com.huawei.hms.aaid.plugin.ProxyCenter;
import com.huawei.hms.aaid.task.PushClientBuilder;
import com.huawei.hms.aaid.utils.PushPreferences;
import com.huawei.hms.api.Api;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.HuaweiApi;
import com.huawei.hms.common.internal.AbstractClientBuilder;
import com.huawei.hms.common.internal.Preconditions;
import com.huawei.hms.opendevice.l;
import com.huawei.hms.opendevice.o;
import com.huawei.hms.opendevice.q;
import com.huawei.hms.support.log.HMSLog;
import d.j.d.a.k;
import java.util.UUID;

public class HmsInstanceIdEx {
    public static final String TAG = "HmsInstanceIdEx";
    public Context a = null;
    public PushPreferences b = null;
    public HuaweiApi c;

    public HmsInstanceIdEx(Context context) {
        this.a = context;
        Object object = new PushPreferences(context, "aaid");
        this.b = object;
        Object object2 = "HuaweiPush.API";
        object = new Api((String)object2);
        boolean bl2 = context instanceof Activity;
        if (bl2) {
            context = (Activity)context;
            PushClientBuilder pushClientBuilder = new PushClientBuilder();
            this.c = object2 = new HuaweiApi((Activity)context, (Api)object, null, (AbstractClientBuilder)pushClientBuilder);
        } else {
            PushClientBuilder pushClientBuilder = new PushClientBuilder();
            this.c = object2 = new HuaweiApi(context, (Api)object, null, (AbstractClientBuilder)pushClientBuilder);
        }
        this.c.setKitSdkVersion(50101300);
    }

    public static HmsInstanceIdEx getInstance(Context context) {
        Preconditions.checkNotNull(context);
        HmsInstanceIdEx hmsInstanceIdEx = new HmsInstanceIdEx(context);
        return hmsInstanceIdEx;
    }

    public final k a(Exception exception) {
        d.j.d.a.l l10 = new d.j.d.a.l();
        l10.c(exception);
        return l10.b();
    }

    public final String a(String string2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("creationTime");
        stringBuilder.append(string2);
        return stringBuilder.toString();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public void deleteAAID(String string2) {
        if (string2 == null) throw ErrorEnum.ERROR_ARGUMENTS_INVALID.toApiException();
        PushPreferences pushPreferences = this.b;
        boolean bl2 = pushPreferences.containsKey(string2);
        if (!bl2) return;
        pushPreferences = this.b;
        pushPreferences.removeKey(string2);
        pushPreferences = this.b;
        string2 = this.a(string2);
        try {
            pushPreferences.removeKey(string2);
            return;
        }
        catch (Exception exception) {
            throw ErrorEnum.ERROR_INTERNAL_ERROR.toApiException();
        }
        catch (RuntimeException runtimeException) {
            throw ErrorEnum.ERROR_INTERNAL_ERROR.toApiException();
        }
    }

    public String getAAId(String object) {
        if (object != null) {
            Object object2;
            block15: {
                object2 = this.b;
                boolean bl2 = ((PushPreferences)object2).containsKey((String)object);
                if (!bl2) break block15;
                object2 = this.b;
                object = ((PushPreferences)object2).getString((String)object);
            }
            object2 = UUID.randomUUID();
            object2 = ((UUID)object2).toString();
            PushPreferences pushPreferences = this.b;
            pushPreferences.saveString((String)object, (String)object2);
            pushPreferences = this.b;
            object = this.a((String)object);
            long l10 = System.currentTimeMillis();
            Long l11 = l10;
            try {
                pushPreferences.saveLong((String)object, l11);
                object = object2;
            }
            catch (Exception exception) {
                throw ErrorEnum.ERROR_INTERNAL_ERROR.toApiException();
            }
            catch (RuntimeException runtimeException) {
                throw ErrorEnum.ERROR_INTERNAL_ERROR.toApiException();
            }
            return object;
        }
        throw ErrorEnum.ERROR_ARGUMENTS_INVALID.toApiException();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public long getCreationTime(String string2) {
        if (string2 == null) {
            throw ErrorEnum.ERROR_ARGUMENTS_INVALID.toApiException();
        }
        try {
            PushPreferences pushPreferences = this.b;
            String string3 = this.a(string2);
            boolean bl2 = pushPreferences.containsKey(string3);
            if (!bl2) {
                this.getAAId(string2);
            }
            pushPreferences = this.b;
            string2 = this.a(string2);
            return pushPreferences.getLong(string2);
        }
        catch (Exception exception) {
            throw ErrorEnum.ERROR_INTERNAL_ERROR.toApiException();
        }
        catch (RuntimeException runtimeException) {
            throw ErrorEnum.ERROR_INTERNAL_ERROR.toApiException();
        }
    }

    public k getToken() {
        Object object = ProxyCenter.getProxy();
        Object object2 = null;
        if (object != null) {
            object = TAG;
            String string2 = "use proxy get token, please check HmsMessageService.onNewToken receive result.";
            HMSLog.i((String)object, string2);
            object = ProxyCenter.getProxy();
            string2 = this.a;
            object.getToken((Context)string2, null, null);
            object = new d.j.d.a.l();
            object2 = new TokenResult();
            try {
                ((d.j.d.a.l)object).d(object2);
                return ((d.j.d.a.l)object).b();
            }
            catch (Exception exception) {
                object = ErrorEnum.ERROR_INTERNAL_ERROR.toApiException();
                return this.a((Exception)object);
            }
            catch (ApiException apiException) {
                return this.a(apiException);
            }
        }
        object = this.a;
        String string3 = "push.gettoken";
        object = q.a((Context)object, string3);
        Object object3 = this.a;
        object2 = o.b((Context)object3, null, null);
        object3 = this.a;
        object3 = HmsInstanceId.getInstance((Context)object3);
        object3 = ((HmsInstanceId)object3).getId();
        ((TokenReq)object2).setAaid((String)object3);
        object3 = this.c;
        Context context = this.a;
        l l10 = new l(string3, (TokenReq)object2, context, (String)object);
        try {
            return ((HuaweiApi)object3).doWrite(l10);
        }
        catch (Exception exception) {
            object2 = this.a;
            object3 = ErrorEnum.ERROR_INTERNAL_ERROR;
            q.a((Context)object2, string3, (String)object, (ErrorEnum)((Object)object3));
            object = ((ErrorEnum)((Object)object3)).toApiException();
            return this.a((Exception)object);
        }
        catch (RuntimeException runtimeException) {
            object2 = this.a;
            object3 = ErrorEnum.ERROR_INTERNAL_ERROR;
            q.a((Context)object2, string3, (String)object, (ErrorEnum)((Object)object3));
            object = ((ErrorEnum)((Object)object3)).toApiException();
            return this.a((Exception)object);
        }
    }
}

