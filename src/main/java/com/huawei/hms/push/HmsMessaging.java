/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.Intent
 *  android.net.Uri
 *  android.os.Parcelable
 *  android.text.TextUtils
 */
package com.huawei.hms.push;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Parcelable;
import android.text.TextUtils;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.aaid.encrypt.PushEncrypter;
import com.huawei.hms.aaid.init.AutoInitHelper;
import com.huawei.hms.aaid.plugin.ProxyCenter;
import com.huawei.hms.aaid.plugin.PushProxy;
import com.huawei.hms.aaid.task.PushClientBuilder;
import com.huawei.hms.aaid.utils.BaseUtils;
import com.huawei.hms.aaid.utils.PushPreferences;
import com.huawei.hms.android.HwBuildEx$VERSION;
import com.huawei.hms.api.Api;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.HuaweiApi;
import com.huawei.hms.common.internal.AbstractClientBuilder;
import com.huawei.hms.common.internal.Preconditions;
import com.huawei.hms.common.internal.TaskApiCall;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.push.RemoteMessage;
import com.huawei.hms.push.d;
import com.huawei.hms.push.s;
import com.huawei.hms.push.task.BaseVoidTask;
import com.huawei.hms.push.task.IntentCallable;
import com.huawei.hms.push.task.SendUpStreamTask;
import com.huawei.hms.push.task.SubscribeTask;
import com.huawei.hms.push.utils.PushBiUtil;
import com.huawei.hms.support.api.entity.push.EnableNotifyReq;
import com.huawei.hms.support.api.entity.push.SubscribeReq;
import com.huawei.hms.support.api.entity.push.UpSendMsgReq;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.JsonUtil;
import com.huawei.hms.utils.NetWorkUtil;
import d.j.d.a.k;
import d.j.d.a.l;
import d.j.d.a.n;
import java.util.concurrent.Callable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HmsMessaging {
    public static final String DEFAULT_TOKEN_SCOPE = "HCM";
    public static final Pattern a = Pattern.compile("[\\u4e00-\\u9fa5\\w-_.~%]{1,900}");
    public Context b;
    public HuaweiApi c;

    public HmsMessaging(Context context) {
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

    public static HmsMessaging getInstance(Context context) {
        Class<HmsMessaging> clazz = HmsMessaging.class;
        synchronized (clazz) {
            HmsMessaging hmsMessaging = new HmsMessaging(context);
            return hmsMessaging;
        }
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final k a(String object, String object2) {
        Object object3;
        int n10;
        Context context = this.b;
        String string2 = "push.subscribe";
        String string3 = PushBiUtil.reportEntry(context, string2);
        Object object4 = "HmsMessaging";
        if (object != null && (n10 = ((Matcher)(object3 = a.matcher((CharSequence)object))).matches()) != 0) {
            object3 = ProxyCenter.getProxy();
            if (object3 != null) {
                HMSLog.i((String)object4, "use proxy subscribe.");
                string2 = "Sub";
                boolean bl2 = TextUtils.equals((CharSequence)object2, (CharSequence)string2);
                if (bl2) {
                    object2 = ProxyCenter.getProxy();
                    string2 = this.b;
                    return object2.subscribe((Context)string2, (String)object, string3);
                }
                object2 = ProxyCenter.getProxy();
                string2 = this.b;
                return object2.unsubscribe((Context)string2, (String)object, string3);
            }
            try {
                object3 = this.b;
                object3 = d.a((Context)object3);
                ErrorEnum errorEnum = ErrorEnum.SUCCESS;
                if (object3 == errorEnum) {
                    object3 = this.b;
                    n10 = NetWorkUtil.getNetworkType((Context)object3);
                    if (n10 == 0) {
                        object = "no network";
                        HMSLog.e((String)object4, (String)object);
                        object = ErrorEnum.ERROR_NO_NETWORK;
                        object = ((ErrorEnum)((Object)object)).toApiException();
                        throw object;
                    }
                    object3 = this.b;
                    object4 = new SubscribeReq((Context)object3, (String)object2, (String)object);
                    object = this.b;
                    boolean bl3 = false;
                    object2 = null;
                    object = BaseUtils.getLocalToken((Context)object, null);
                    ((SubscribeReq)object4).setToken((String)object);
                    boolean bl4 = s.b();
                    if (bl4) {
                        object = this.c;
                        object4 = JsonUtil.createJsonString((IMessageEntity)object4);
                        object2 = new BaseVoidTask(string2, (String)object4, string3);
                        return ((HuaweiApi)object).doWrite((TaskApiCall)object2);
                    }
                    object = this.c;
                    object4 = JsonUtil.createJsonString((IMessageEntity)object4);
                    object2 = new SubscribeTask(string2, (String)object4, string3);
                    return ((HuaweiApi)object).doWrite((TaskApiCall)object2);
                }
                object = ((ErrorEnum)((Object)object3)).toApiException();
                throw object;
            }
            catch (ApiException apiException) {
                object2 = new l();
                ((l)object2).c(apiException);
                object4 = this.b;
                int n11 = apiException.getStatusCode();
                PushBiUtil.reportExit((Context)object4, string2, string3, n11);
                return ((l)object2).b();
            }
        }
        object = this.b;
        object2 = ErrorEnum.ERROR_ARGUMENTS_INVALID;
        PushBiUtil.reportExit((Context)object, string2, string3, (ErrorEnum)((Object)object2));
        object = "Invalid topic: topic should match the format:[\\u4e00-\\u9fa5\\w-_.~%]{1,900}";
        HMSLog.e((String)object4, (String)object);
        object2 = new IllegalArgumentException((String)object);
        throw object2;
        catch (Exception exception) {}
        object = new l();
        object2 = ErrorEnum.ERROR_INTERNAL_ERROR;
        object4 = ((ErrorEnum)((Object)object2)).toApiException();
        ((l)object).c((Exception)object4);
        PushBiUtil.reportExit(this.b, string2, string3, (ErrorEnum)((Object)object2));
        return ((l)object).b();
    }

    public final k a(boolean bl2) {
        Object object = this.b;
        Object object2 = "push.setNotifyFlag";
        object = PushBiUtil.reportEntry(object, (String)object2);
        Object object3 = this.b;
        int n10 = s.d((Context)object3);
        Object object4 = "HmsMessaging";
        if (n10 != 0 && (n10 = s.b()) == 0) {
            n10 = HwBuildEx$VERSION.EMUI_SDK_INT;
            int n11 = 12;
            if (n10 < n11) {
                HMSLog.e((String)object4, "operation not available on Huawei device with EMUI lower than 5.1");
                l l10 = new l();
                object3 = ErrorEnum.ERROR_OPERATION_NOT_SUPPORTED;
                object4 = ((ErrorEnum)((Object)object3)).toApiException();
                l10.c((Exception)object4);
                PushBiUtil.reportExit(this.b, (String)object2, (String)object, (ErrorEnum)((Object)object3));
                return l10.b();
            }
            object2 = this.b;
            long l11 = s.b((Context)object2);
            long l12 = 90101310L;
            long l13 = l11 == l12 ? 0 : (l11 < l12 ? -1 : 1);
            object3 = "android";
            String string2 = "enalbeFlag";
            if (l13 < 0) {
                HMSLog.i((String)object4, "turn on/off with broadcast v1");
                object2 = this.b;
                object4 = new StringBuilder();
                String string3 = this.b.getPackageName();
                ((StringBuilder)object4).append(string3);
                ((StringBuilder)object4).append("#");
                ((StringBuilder)object4).append(bl2);
                String string4 = ((StringBuilder)object4).toString();
                string4 = PushEncrypter.encrypterOld((Context)object2, string4);
                object2 = new Intent("com.huawei.intent.action.SELF_SHOW_FLAG");
                string4 = object2.putExtra(string2, string4);
                string4.setPackage((String)object3);
                object3 = this.b;
                object2 = new IntentCallable((Context)object3, (Intent)string4, (String)object);
                return n.f((Callable)object2);
            }
            HMSLog.i((String)object4, "turn on/off with broadcast v2");
            object4 = this.b;
            String string5 = "push_notify_flag";
            object2 = new PushPreferences((Context)object4, string5);
            ((PushPreferences)object2).saveBoolean("notify_msg_enable", bl2 ^= true);
            Object object5 = new StringBuilder();
            ((StringBuilder)object5).append("content://");
            object2 = this.b.getPackageName();
            ((StringBuilder)object5).append((String)object2);
            ((StringBuilder)object5).append(".huawei.push.provider/");
            ((StringBuilder)object5).append(string5);
            ((StringBuilder)object5).append(".xml");
            object5 = Uri.parse((String)((StringBuilder)object5).toString());
            object2 = new Intent("com.huawei.android.push.intent.SDK_COMMAND");
            object2.putExtra("type", string2);
            object4 = this.b.getPackageName();
            object2.putExtra("pkgName", (String)object4);
            object2.putExtra("url", (Parcelable)object5);
            object2.setPackage((String)object3);
            object3 = this.b;
            object5 = new IntentCallable((Context)object3, (Intent)object2, (String)object);
            return n.f((Callable)object5);
        }
        HMSLog.i((String)object4, "turn on/off with AIDL");
        object3 = new EnableNotifyReq();
        object4 = this.b.getPackageName();
        ((EnableNotifyReq)object3).setPackageName((String)object4);
        ((EnableNotifyReq)object3).setEnable(bl2);
        HuaweiApi huaweiApi = this.c;
        object3 = JsonUtil.createJsonString((IMessageEntity)object3);
        object4 = new BaseVoidTask((String)object2, (String)object3, (String)object);
        return huaweiApi.doWrite((TaskApiCall)object4);
    }

    public final void a(RemoteMessage object) {
        Object object2 = this.b;
        String string2 = "push.sendMessage";
        object2 = PushBiUtil.reportEntry(object2, string2);
        Object object3 = d.a(this.b);
        Object object4 = ErrorEnum.SUCCESS;
        String string3 = "HmsMessaging";
        if (object3 == object4) {
            object3 = ((RemoteMessage)object).getTo();
            boolean bl2 = TextUtils.isEmpty((CharSequence)object3);
            if (!bl2) {
                object3 = ((RemoteMessage)object).getMessageId();
                bl2 = TextUtils.isEmpty((CharSequence)object3);
                if (!bl2) {
                    object3 = ((RemoteMessage)object).getData();
                    bl2 = TextUtils.isEmpty((CharSequence)object3);
                    if (!bl2) {
                        object3 = new UpSendMsgReq();
                        object4 = this.b.getPackageName();
                        ((UpSendMsgReq)object3).setPackageName((String)object4);
                        object4 = ((RemoteMessage)object).getMessageId();
                        ((UpSendMsgReq)object3).setMessageId((String)object4);
                        object4 = ((RemoteMessage)object).getTo();
                        ((UpSendMsgReq)object3).setTo((String)object4);
                        object4 = ((RemoteMessage)object).getData();
                        ((UpSendMsgReq)object3).setData((String)object4);
                        object4 = ((RemoteMessage)object).getMessageType();
                        ((UpSendMsgReq)object3).setMessageType((String)object4);
                        int n10 = ((RemoteMessage)object).getTtl();
                        ((UpSendMsgReq)object3).setTtl(n10);
                        object4 = ((RemoteMessage)object).getCollapseKey();
                        ((UpSendMsgReq)object3).setCollapseKey((String)object4);
                        n10 = ((RemoteMessage)object).getSendMode();
                        ((UpSendMsgReq)object3).setSendMode(n10);
                        int n11 = ((RemoteMessage)object).getReceiptMode();
                        ((UpSendMsgReq)object3).setReceiptMode(n11);
                        n11 = (int)(s.b() ? 1 : 0);
                        if (n11 != 0) {
                            object = this.c;
                            object3 = JsonUtil.createJsonString((IMessageEntity)object3);
                            object4 = new BaseVoidTask(string2, (String)object3, (String)object2);
                            ((HuaweiApi)object).doWrite((TaskApiCall)object4);
                        } else {
                            this.a((UpSendMsgReq)object3, (String)object2);
                        }
                        return;
                    }
                    object = "Mandatory parameter 'data' missing";
                    HMSLog.e(string3, (String)object);
                    object3 = this.b;
                    object4 = ErrorEnum.ERROR_ARGUMENTS_INVALID;
                    PushBiUtil.reportExit((Context)object3, string2, (String)object2, object4);
                    object2 = new IllegalArgumentException((String)object);
                    throw object2;
                }
                object = "Mandatory parameter 'message_id' missing";
                HMSLog.e(string3, (String)object);
                object3 = this.b;
                object4 = ErrorEnum.ERROR_ARGUMENTS_INVALID;
                PushBiUtil.reportExit((Context)object3, string2, (String)object2, object4);
                object2 = new IllegalArgumentException((String)object);
                throw object2;
            }
            object = "Mandatory parameter 'to' missing";
            HMSLog.e(string3, (String)object);
            object3 = this.b;
            object4 = ErrorEnum.ERROR_ARGUMENTS_INVALID;
            PushBiUtil.reportExit((Context)object3, string2, (String)object2, object4);
            object2 = new IllegalArgumentException((String)object);
            throw object2;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("Message sent failed:");
        int n12 = ((ErrorEnum)((Object)object3)).getExternalCode();
        ((StringBuilder)object).append(n12);
        ((StringBuilder)object).append(':');
        object4 = ((ErrorEnum)((Object)object3)).getMessage();
        ((StringBuilder)object).append((String)object4);
        object = ((StringBuilder)object).toString();
        HMSLog.e(string3, (String)object);
        PushBiUtil.reportExit(this.b, string2, (String)object2, (ErrorEnum)((Object)object3));
        object2 = ((ErrorEnum)((Object)object3)).getMessage();
        object = new UnsupportedOperationException((String)object2);
        throw object;
    }

    public final void a(UpSendMsgReq upSendMsgReq, String string2) {
        block9: {
            SendUpStreamTask sendUpStreamTask;
            Object object = this.b;
            Object object2 = null;
            object = BaseUtils.getLocalToken((Context)object, null);
            upSendMsgReq.setToken((String)object);
            object = this.c;
            String string3 = "push.sendMessage";
            String string4 = JsonUtil.createJsonString(upSendMsgReq);
            String string5 = upSendMsgReq.getPackageName();
            String string6 = upSendMsgReq.getMessageId();
            object2 = sendUpStreamTask;
            sendUpStreamTask = new SendUpStreamTask(string3, string4, string2, string5, string6);
            try {
                ((HuaweiApi)object).doWrite(sendUpStreamTask);
            }
            catch (Exception exception) {
                object = exception.getCause();
                boolean bl2 = object instanceof ApiException;
                object2 = "push.sendMessage";
                if (bl2) {
                    ApiException apiException = (ApiException)exception.getCause();
                    object = this.b;
                    int n10 = apiException.getStatusCode();
                    PushBiUtil.reportExit((Context)object, (String)object2, string2, n10);
                    break block9;
                }
                Context context = this.b;
                object = ErrorEnum.ERROR_INTERNAL_ERROR;
                PushBiUtil.reportExit(context, (String)object2, string2, (ErrorEnum)((Object)object));
            }
        }
    }

    public boolean isAutoInitEnabled() {
        return AutoInitHelper.isAutoInitEnabled(this.b);
    }

    public void send(RemoteMessage object) {
        Object object2 = ProxyCenter.getProxy();
        String string2 = "HmsMessaging";
        if (object2 == null) {
            HMSLog.i(string2, "send upstream message");
            this.a((RemoteMessage)object);
            return;
        }
        object = "Operation(send) unsupported";
        HMSLog.e(string2, (String)object);
        object2 = new UnsupportedOperationException((String)object);
        throw object2;
    }

    public void setAutoInitEnabled(boolean bl2) {
        AutoInitHelper.setAutoInitEnabled(this.b, bl2);
    }

    public k subscribe(String string2) {
        HMSLog.i("HmsMessaging", "invoke subscribe");
        return this.a(string2, "Sub");
    }

    public k turnOffPush() {
        PushProxy pushProxy = ProxyCenter.getProxy();
        String string2 = "HmsMessaging";
        if (pushProxy != null) {
            HMSLog.i(string2, "turn off for proxy");
            pushProxy = ProxyCenter.getProxy();
            string2 = this.b;
            return pushProxy.turnOff((Context)string2, null);
        }
        HMSLog.i(string2, "invoke turnOffPush");
        return this.a(false);
    }

    public k turnOnPush() {
        PushProxy pushProxy = ProxyCenter.getProxy();
        String string2 = "HmsMessaging";
        if (pushProxy != null) {
            HMSLog.i(string2, "turn on for proxy");
            pushProxy = ProxyCenter.getProxy();
            string2 = this.b;
            return pushProxy.turnOn((Context)string2, null);
        }
        HMSLog.i(string2, "invoke turnOnPush");
        return this.a(true);
    }

    public k unsubscribe(String string2) {
        HMSLog.i("HmsMessaging", "invoke unsubscribe");
        return this.a(string2, "UnSub");
    }
}

