/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.os.Looper
 *  android.text.TextUtils
 */
package com.huawei.hms.aaid;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.aaid.entity.DeleteTokenReq;
import com.huawei.hms.aaid.entity.TokenReq;
import com.huawei.hms.aaid.entity.TokenResult;
import com.huawei.hms.aaid.plugin.ProxyCenter;
import com.huawei.hms.aaid.plugin.PushProxy;
import com.huawei.hms.aaid.task.PushClientBuilder;
import com.huawei.hms.aaid.utils.BaseUtils;
import com.huawei.hms.aaid.utils.PushPreferences;
import com.huawei.hms.api.Api;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.HuaweiApi;
import com.huawei.hms.common.internal.AbstractClientBuilder;
import com.huawei.hms.common.internal.Preconditions;
import com.huawei.hms.common.internal.TaskApiCall;
import com.huawei.hms.opendevice.c;
import com.huawei.hms.opendevice.i;
import com.huawei.hms.opendevice.j;
import com.huawei.hms.opendevice.k;
import com.huawei.hms.opendevice.l;
import com.huawei.hms.opendevice.o;
import com.huawei.hms.opendevice.p;
import com.huawei.hms.opendevice.q;
import com.huawei.hms.support.log.HMSLog;
import d.j.d.a.n;
import java.util.concurrent.Callable;

public class HmsInstanceId {
    public static final String TAG = "HmsInstanceId";
    public Context a;
    public PushPreferences b;
    public HuaweiApi c;

    public HmsInstanceId(Context context) {
        Object object;
        this.a = object = context.getApplicationContext();
        super(context, "aaid");
        this.b = object;
        Object object2 = "HuaweiPush.API";
        super((String)object2);
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

    public static HmsInstanceId getInstance(Context context) {
        Preconditions.checkNotNull(context);
        com.huawei.hms.opendevice.c.d(context);
        HmsInstanceId hmsInstanceId = new HmsInstanceId(context);
        return hmsInstanceId;
    }

    public final String a(TokenReq object, int n10) {
        Object object2;
        Object object3 = ProxyCenter.getProxy();
        if (object3 != null) {
            HMSLog.i(TAG, "use proxy get token, please check HmsMessageService.onNewToken receive result.");
            PushProxy pushProxy = ProxyCenter.getProxy();
            object3 = this.a;
            object = ((TokenReq)object).getSubjectId();
            pushProxy.getToken((Context)object3, (String)object, null);
            return null;
        }
        object3 = ((TokenReq)object).getSubjectId();
        this.a((String)object3);
        object3 = this.a;
        String string2 = "push.gettoken";
        object3 = q.a((Context)object3, string2);
        try {
            object2 = TAG;
        }
        catch (Exception exception) {
            Object object4 = exception.getCause();
            n10 = object4 instanceof ApiException;
            if (n10 != 0) {
                ApiException apiException = (ApiException)exception.getCause();
                object4 = this.a;
                int n11 = apiException.getStatusCode();
                q.a((Context)object4, string2, (String)object3, n11);
                throw apiException;
            }
            Context context = this.a;
            object4 = ErrorEnum.ERROR_INTERNAL_ERROR;
            q.a(context, string2, (String)object3, (ErrorEnum)((Object)object4));
            throw ((ErrorEnum)((Object)object4)).toApiException();
        }
        CharSequence charSequence = new StringBuilder();
        String string3 = "getToken req :";
        charSequence.append(string3);
        string3 = ((TokenReq)object).toString();
        charSequence.append(string3);
        charSequence = charSequence.toString();
        HMSLog.d((String)object2, (String)charSequence);
        charSequence = this.a;
        object2 = new l(string2, (TokenReq)object, (Context)charSequence, (String)object3);
        ((TaskApiCall)object2).setApiLevel(n10);
        object = this.c;
        object = ((HuaweiApi)object).doWrite((TaskApiCall)object2);
        object = n.c((d.j.d.a.k)object);
        object = (TokenResult)object;
        return ((TokenResult)object).getToken();
    }

    public final void a() {
        Object object = this.a;
        boolean bl2 = BaseUtils.getProxyInit(object);
        if (bl2 && (object = ProxyCenter.getProxy()) == null && !(bl2 = BaseUtils.isMainProc(object = this.a))) {
            HMSLog.e(TAG, "Operations in child processes are not supported.");
            throw ErrorEnum.ERROR_OPER_IN_CHILD_PROCESS.toApiException();
        }
    }

    public final void a(DeleteTokenReq object, int n10) {
        Object object2;
        String string2;
        Object object3;
        Object object4;
        String string3;
        block23: {
            Object object5;
            block24: {
                string3 = ((DeleteTokenReq)object).getSubjectId();
                object4 = ProxyCenter.getProxy();
                boolean bl2 = false;
                object3 = null;
                if (object4 != null) {
                    HMSLog.i(TAG, "use proxy delete token");
                    object = ProxyCenter.getProxy();
                    Context context = this.a;
                    object.deleteToken(context, string3, null);
                    return;
                }
                object4 = this.a;
                string2 = "push.deletetoken";
                object4 = q.a((Context)object4, string2);
                try {
                    object2 = this.a;
                }
                catch (Exception exception) {
                    object5 = exception.getCause();
                    n10 = object5 instanceof ApiException;
                    if (n10 != 0) {
                        ApiException apiException = (ApiException)exception.getCause();
                        object5 = this.a;
                        int n11 = apiException.getStatusCode();
                        q.a((Context)object5, string2, (String)object4, n11);
                        throw apiException;
                    }
                    Context context = this.a;
                    object5 = ErrorEnum.ERROR_INTERNAL_ERROR;
                    q.a(context, string2, (String)object4, (ErrorEnum)((Object)object5));
                    throw ((ErrorEnum)((Object)object5)).toApiException();
                }
                object2 = i.a((Context)object2);
                object2 = ((i)object2).b(string3);
                boolean bl3 = ((DeleteTokenReq)object).isMultiSender();
                if (!bl3) break block23;
                bl3 = TextUtils.isEmpty((CharSequence)object2);
                if (bl3) break block24;
                Object object6 = this.a;
                object6 = i.a((Context)object6);
                object3 = ((i)object6).b(null);
                bl2 = ((String)object2).equals(object3);
                if (!bl2) break block23;
            }
            object = this.a;
            object = i.a((Context)object);
            ((PushPreferences)object).removeKey(string3);
            object = TAG;
            object5 = "The local subject token is null";
            HMSLog.i((String)object, (String)object5);
            return;
        }
        ((DeleteTokenReq)object).setToken((String)object2);
        object3 = new k(string2, (DeleteTokenReq)object, (String)object4);
        ((TaskApiCall)object3).setApiLevel(n10);
        object = this.c;
        object = ((HuaweiApi)object).doWrite((TaskApiCall)object3);
        n.c((d.j.d.a.k)object);
        object = this.a;
        object = i.a((Context)object);
        ((i)object).c(string3);
    }

    public final void a(String object) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)object);
        if (bl2) {
            return;
        }
        Object object2 = this.a;
        bl2 = p.c((Context)object2);
        String string2 = "subjectId";
        if (bl2) {
            object2 = i.a(this.a).getString(string2);
            boolean bl3 = TextUtils.isEmpty((CharSequence)object2);
            if (bl3) {
                object2 = i.a(this.a);
                ((PushPreferences)object2).saveString(string2, (String)object);
            } else {
                bl3 = ((String)object2).contains((CharSequence)object);
                if (!bl3) {
                    i i10 = i.a(this.a);
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append((String)object2);
                    object2 = ",";
                    stringBuilder.append((String)object2);
                    stringBuilder.append((String)object);
                    object = stringBuilder.toString();
                    i10.saveString(string2, (String)object);
                }
            }
        } else {
            object = i.a(this.a);
            ((PushPreferences)object).removeKey(string2);
        }
    }

    public final void b() {
        Looper looper;
        Looper looper2 = Looper.getMainLooper();
        if (looper2 != (looper = Looper.myLooper())) {
            return;
        }
        throw ErrorEnum.ERROR_MAIN_THREAD.toApiException();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void deleteAAID() {
        Object object = "aaid";
        this.b();
        try {
            Object object2 = this.b;
            boolean bl2 = ((PushPreferences)object2).containsKey((String)object);
            if (!bl2) {
                return;
            }
            object2 = this.b;
            ((PushPreferences)object2).removeKey((String)object);
            object = this.b;
            object2 = "creationTime";
            ((PushPreferences)object).removeKey((String)object2);
            object = this.a;
            boolean bl3 = o.e((Context)object);
            if (!bl3) {
                return;
            }
            object = ProxyCenter.getProxy();
            if (object != null) {
                object = TAG;
                object2 = "use proxy delete all token after delete AaId.";
                HMSLog.i((String)object, (String)object2);
                object = ProxyCenter.getProxy();
                object2 = this.a;
                object.deleteAllToken((Context)object2);
                return;
            }
            object = this.a;
            object = o.b((Context)object);
            int n10 = 1;
            ((DeleteTokenReq)object).setDeleteType(n10);
            ((DeleteTokenReq)object).setMultiSender(false);
            this.a((DeleteTokenReq)object, n10);
            object = this.a;
            BaseUtils.deleteAllTokenCache((Context)object);
            return;
        }
        catch (Exception exception) {
            throw ErrorEnum.ERROR_INTERNAL_ERROR.toApiException();
        }
        catch (ApiException apiException) {
            throw apiException;
        }
    }

    public void deleteToken(String object) {
        this.b();
        this.a();
        boolean bl2 = TextUtils.isEmpty((CharSequence)object);
        if (!bl2) {
            String string2 = o.d(this.a);
            boolean bl3 = TextUtils.isEmpty((CharSequence)string2);
            if (!bl3) {
                bl2 = ((String)object).equals(string2);
                if (bl2) {
                    this.deleteToken(null, null);
                    return;
                }
                object = o.a(this.a, (String)object);
                ((DeleteTokenReq)object).setMultiSender(true);
                this.a((DeleteTokenReq)object, 2);
                return;
            }
            throw ErrorEnum.ERROR_MISSING_PROJECT_ID.toApiException();
        }
        throw ErrorEnum.ERROR_ARGUMENTS_INVALID.toApiException();
    }

    public void deleteToken(String object, String string2) {
        this.b();
        this.a();
        object = o.a(this.a, (String)object, string2);
        ((DeleteTokenReq)object).setMultiSender(false);
        this.a((DeleteTokenReq)object, 1);
    }

    public d.j.d.a.k getAAID() {
        Object object;
        Object object2;
        try {
            object2 = this.a;
        }
        catch (Exception exception) {
            object = new d.j.d.a.l();
            object2 = ErrorEnum.ERROR_INTERNAL_ERROR.toApiException();
            ((d.j.d.a.l)object).c((Exception)object2);
            return ((d.j.d.a.l)object).b();
        }
        object2 = object2.getApplicationContext();
        object = new j((Context)object2);
        return n.f((Callable)object);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public long getCreationTime() {
        String string2 = "creationTime";
        try {
            PushPreferences pushPreferences = this.b;
            boolean bl2 = pushPreferences.containsKey(string2);
            if (!bl2) {
                this.getAAID();
            }
            pushPreferences = this.b;
            return pushPreferences.getLong(string2);
        }
        catch (Exception exception) {
            return 0L;
        }
    }

    public String getId() {
        return o.c(this.a);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public String getToken() {
        String string2 = null;
        try {
            return this.getToken(null, null);
        }
        catch (Exception exception) {
            return string2;
        }
    }

    public String getToken(String object) {
        this.b();
        this.a();
        boolean bl2 = TextUtils.isEmpty((CharSequence)object);
        if (!bl2) {
            String string2 = o.d(this.a);
            boolean bl3 = TextUtils.isEmpty((CharSequence)string2);
            if (!bl3) {
                bl2 = ((String)object).equals(string2);
                if (bl2) {
                    return this.getToken(null, null);
                }
                object = o.b(this.a, (String)object);
                string2 = this.getId();
                ((TokenReq)object).setAaid(string2);
                ((TokenReq)object).setMultiSender(true);
                return this.a((TokenReq)object, 2);
            }
            throw ErrorEnum.ERROR_MISSING_PROJECT_ID.toApiException();
        }
        throw ErrorEnum.ERROR_ARGUMENTS_INVALID.toApiException();
    }

    public String getToken(String object, String object2) {
        this.b();
        this.a();
        object = o.b(this.a, (String)object, (String)object2);
        object2 = this.getId();
        ((TokenReq)object).setAaid((String)object2);
        ((TokenReq)object).setMultiSender(false);
        object2 = i.a(this.a);
        String string2 = this.a.getPackageName();
        ((PushPreferences)object2).saveString(string2, "1");
        return this.a((TokenReq)object, 1);
    }
}

