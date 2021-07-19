/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Service
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Bundle
 *  android.os.Handler
 *  android.os.IBinder
 *  android.os.Messenger
 *  android.text.TextUtils
 *  org.json.JSONArray
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.huawei.hms.push;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Messenger;
import android.text.TextUtils;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.aaid.utils.BaseUtils;
import com.huawei.hms.push.BaseException;
import com.huawei.hms.push.HmsMessageService$a;
import com.huawei.hms.push.RemoteMessage;
import com.huawei.hms.push.SendException;
import com.huawei.hms.push.utils.PushBiUtil;
import com.huawei.hms.support.log.HMSLog;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class HmsMessageService
extends Service {
    public static final String PROXY_TYPE = "proxy_type";
    public static final String SUBJECT_ID = "subject_id";
    public final Messenger a;

    public HmsMessageService() {
        Messenger messenger;
        HmsMessageService$a hmsMessageService$a = new HmsMessageService$a(this, null);
        this.a = messenger = new Messenger((Handler)hmsMessageService$a);
    }

    public final Bundle a(Intent intent) {
        Bundle bundle = new Bundle();
        String string2 = "message_id";
        Object object = intent.getStringExtra(string2);
        bundle.putString(string2, (String)object);
        string2 = "message_body";
        object = intent.getByteArrayExtra(string2);
        bundle.putByteArray(string2, (byte[])object);
        string2 = "device_token";
        object = intent.getStringExtra(string2);
        bundle.putString(string2, (String)object);
        string2 = "inputType";
        int n10 = intent.getIntExtra(string2, -1);
        int n11 = 1;
        if (n10 == n11) {
            bundle.putInt(string2, n11);
        }
        return bundle;
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void a(Intent object, Bundle object2, String object3) {
        synchronized (this) {
            block8: {
                CharSequence charSequence;
                void var3_3;
                String string2 = "device_token";
                string2 = object.getStringExtra(string2);
                this.a(string2, (String)var3_3);
                Context context = this.getApplicationContext();
                String string3 = context.getPackageName();
                int n10 = 0;
                string3 = BaseUtils.getCacheData(context, string3, false);
                int n11 = TextUtils.isEmpty((CharSequence)string3) ^ 1;
                boolean bl2 = charSequence.isEmpty();
                if (bl2 && n11 != 0) {
                    string3 = "HmsMessageService";
                    String string4 = "onNewToken to host app.";
                    HMSLog.i(string3, string4);
                    this.onNewToken(string2);
                    string3 = context.getPackageName();
                    BaseUtils.deleteCacheData(context, string3);
                }
                if ((n11 = TextUtils.isEmpty((CharSequence)var3_3)) != 0) {
                    object3 = BaseUtils.getSubjectIds(context);
                    if (object3 != null && (n11 = ((String[])object3).length) != 0) {
                        int n12;
                        while (n10 < (n12 = ((String[])object3).length)) {
                            object = new Bundle();
                            charSequence = object3[n10];
                            string3 = SUBJECT_ID;
                            object.putString(string3, (String)charSequence);
                            charSequence = new StringBuilder();
                            string3 = "onNewToken to sub app, subjectId:";
                            ((StringBuilder)charSequence).append(string3);
                            string3 = object3[n10];
                            ((StringBuilder)charSequence).append(string3);
                            charSequence = ((StringBuilder)charSequence).toString();
                            string3 = "HmsMessageService";
                            HMSLog.i(string3, (String)charSequence);
                            this.onNewToken(string2, (Bundle)object);
                            object = object3[n10];
                            this.a(string2, (String)object);
                            ++n10;
                        }
                        BaseUtils.clearSubjectIds(context);
                        break block8;
                    } else {
                        String string5 = "HmsMessageService";
                        String string6 = "onNewToken to host app with bundle.";
                        HMSLog.i(string5, string6);
                        String string7 = "belongId";
                        object = object.getStringExtra(string7);
                        String string8 = "belongId";
                        charSequence.putString(string8, (String)object);
                        this.onNewToken(string2, (Bundle)charSequence);
                        return;
                    }
                }
                object = new StringBuilder();
                String string9 = "onNewToken to sub app, subjectId:";
                ((StringBuilder)object).append(string9);
                ((StringBuilder)object).append((String)var3_3);
                object = ((StringBuilder)object).toString();
                String string10 = "HmsMessageService";
                HMSLog.i(string10, (String)object);
                this.onNewToken(string2, (Bundle)charSequence);
            }
            return;
        }
    }

    public final void a(Intent object, String string2) {
        int n10;
        Object object2 = ErrorEnum.SUCCESS;
        int n11 = ((ErrorEnum)((Object)object2)).getInternalCode();
        n11 = object.getIntExtra("error", n11);
        this.a("push.onNewToken", string2, n11);
        String string3 = object.getStringExtra("subjectId");
        String string4 = object.getStringExtra("message_proxy_type");
        CharSequence charSequence = new StringBuilder();
        String string5 = "doOnNewToken:transactionId = ";
        charSequence.append(string5);
        charSequence.append(string2);
        charSequence.append(" , internalCode = ");
        charSequence.append(n11);
        charSequence.append(",subjectId:");
        charSequence.append(string3);
        charSequence.append(",proxyType:");
        charSequence.append(string4);
        string2 = charSequence.toString();
        charSequence = "HmsMessageService";
        HMSLog.i((String)charSequence, string2);
        string2 = new Bundle();
        boolean bl2 = TextUtils.isEmpty((CharSequence)string3);
        if (!bl2) {
            string5 = SUBJECT_ID;
            string2.putString(string5, string3);
        }
        if (!(bl2 = TextUtils.isEmpty((CharSequence)string4))) {
            string5 = PROXY_TYPE;
            string2.putString(string5, string4);
        }
        if (n11 == (n10 = ((ErrorEnum)((Object)object2)).getInternalCode())) {
            object2 = new StringBuilder();
            String string6 = "Apply token OnNewToken, subId: ";
            ((StringBuilder)object2).append(string6);
            ((StringBuilder)object2).append(string3);
            object2 = ((StringBuilder)object2).toString();
            HMSLog.i((String)charSequence, (String)object2);
            this.a((Intent)object, (Bundle)string2, string3);
        } else {
            object = new StringBuilder();
            object2 = "Apply token failed, subId: ";
            ((StringBuilder)object).append((String)object2);
            ((StringBuilder)object).append(string3);
            object = ((StringBuilder)object).toString();
            HMSLog.i((String)charSequence, (String)object);
            this.a((Bundle)string2, string3, n11);
        }
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void a(Bundle bundle, String object, int n10) {
        synchronized (this) {
            block8: {
                void var2_2;
                void var3_8;
                String string2;
                Object object2 = this.getApplicationContext();
                Object object3 = object2.getPackageName();
                int n11 = 0;
                object3 = BaseUtils.getCacheData((Context)object2, (String)object3, false);
                int n12 = TextUtils.isEmpty((CharSequence)object3) ^ 1;
                boolean bl2 = bundle.isEmpty();
                if (bl2 && n12 != 0) {
                    object3 = "HmsMessageService";
                    string2 = "onTokenError to host app.";
                    HMSLog.i((String)object3, string2);
                    object3 = new BaseException((int)var3_8);
                    this.onTokenError((Exception)object3);
                    object3 = object2.getPackageName();
                    BaseUtils.deleteCacheData((Context)object2, (String)object3);
                }
                if ((n12 = TextUtils.isEmpty((CharSequence)var2_2)) != 0) {
                    object = BaseUtils.getSubjectIds((Context)object2);
                    if (object != null && (n12 = ((String[])object).length) != 0) {
                        int n13;
                        while (n11 < (n13 = ((String[])object).length)) {
                            bundle = new Bundle();
                            object3 = object[n11];
                            string2 = SUBJECT_ID;
                            bundle.putString(string2, (String)object3);
                            object3 = new StringBuilder();
                            string2 = "onTokenError to sub app, subjectId:";
                            ((StringBuilder)object3).append(string2);
                            string2 = object[n11];
                            ((StringBuilder)object3).append(string2);
                            object3 = ((StringBuilder)object3).toString();
                            string2 = "HmsMessageService";
                            HMSLog.i(string2, (String)object3);
                            object3 = new BaseException((int)var3_8);
                            this.onTokenError((Exception)object3, bundle);
                            ++n11;
                        }
                        BaseUtils.clearSubjectIds((Context)object2);
                        break block8;
                    } else {
                        String string3 = "HmsMessageService";
                        object2 = "onTokenError to host app with bundle.";
                        HMSLog.i(string3, (String)object2);
                        BaseException baseException = new BaseException((int)var3_8);
                        this.onTokenError(baseException, bundle);
                        return;
                    }
                }
                object2 = new StringBuilder();
                object3 = "onTokenError to sub app, subjectId:";
                ((StringBuilder)object2).append((String)object3);
                ((StringBuilder)object2).append((String)var2_2);
                String string4 = ((StringBuilder)object2).toString();
                object2 = "HmsMessageService";
                HMSLog.i((String)object2, string4);
                BaseException baseException = new BaseException((int)var3_8);
                this.onTokenError(baseException, bundle);
            }
            return;
        }
    }

    public final void a(String string2, String string3) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (bl2) {
            return;
        }
        Context context = this.getApplicationContext();
        String string4 = BaseUtils.getLocalToken(context, string3);
        boolean bl3 = string2.equals(string4);
        if (!bl3) {
            HMSLog.i("HmsMessageService", "receive a token, refresh the local token");
            BaseUtils.saveToken(context, string3, string2);
            return;
        }
        BaseUtils.reportAaidToken(context, string2);
    }

    public final void a(String string2, String string3, int n10) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)string3);
        if (bl2) {
            string3 = "null";
        }
        PushBiUtil.reportExit(this.getApplicationContext(), string2, string3, n10);
    }

    public final void b(Intent object) {
        block16: {
            int n10;
            String string2 = "HmsMessageService";
            HMSLog.i(string2, "parse batch response.");
            String string3 = "batchMsgbody";
            object = object.getStringExtra(string3);
            boolean bl2 = TextUtils.isEmpty((CharSequence)object);
            if (bl2) {
                return;
            }
            try {
                string3 = new JSONArray((String)object);
                n10 = 0;
                object = null;
            }
            catch (JSONException jSONException) {
                object = "parse batch response failed.";
                HMSLog.w(string2, (String)object);
            }
            while (true) {
                block18: {
                    String string4;
                    String string5;
                    int n11;
                    block17: {
                        n11 = string3.length();
                        if (n10 >= n11) break block16;
                        JSONObject jSONObject = string3.getJSONObject(n10);
                        string5 = "transactionId";
                        string5 = jSONObject.optString(string5);
                        string4 = "msgId";
                        string4 = jSONObject.optString(string4);
                        Object object2 = "ret";
                        ErrorEnum errorEnum = ErrorEnum.ERROR_UNKNOWN;
                        int n12 = errorEnum.getInternalCode();
                        n11 = jSONObject.optInt((String)object2, n12);
                        object2 = ErrorEnum.SUCCESS;
                        int n13 = ((ErrorEnum)((Object)object2)).getInternalCode();
                        if (n13 != n11) break block17;
                        this.b(string5, string4);
                        break block18;
                    }
                    this.b(string5, string4, n11);
                }
                ++n10;
            }
        }
    }

    public final void b(String string2, String string3) {
        CharSequence charSequence = new StringBuilder();
        charSequence.append("onMessageSent, message id:");
        charSequence.append(string3);
        charSequence.append(", transactionId: ");
        charSequence.append(string2);
        charSequence = charSequence.toString();
        HMSLog.i("HmsMessageService", (String)charSequence);
        int n10 = ErrorEnum.SUCCESS.getInternalCode();
        this.a("push.sendMessageRet", string2, n10);
        this.onMessageSent(string3);
    }

    public final void b(String object, String string2, int n10) {
        CharSequence charSequence = new StringBuilder();
        charSequence.append("onSendError, message id:");
        charSequence.append(string2);
        charSequence.append(" error:");
        charSequence.append(n10);
        charSequence.append(", transactionId: ");
        charSequence.append((String)object);
        charSequence = charSequence.toString();
        HMSLog.i("HmsMessageService", (String)charSequence);
        this.a("push.sendMessageRet", (String)object, n10);
        object = new SendException(n10);
        this.onSendError(string2, (Exception)object);
    }

    public void doMsgReceived(Intent intent) {
        intent = this.a(intent);
        RemoteMessage remoteMessage = new RemoteMessage((Bundle)intent);
        this.onMessageReceived(remoteMessage);
    }

    public void handleIntentMessage(Intent object) {
        Object object2 = "HmsMessageService";
        if (object == null) {
            HMSLog.e((String)object2, "receive message is null");
            return;
        }
        String string2 = object.getStringExtra("message_id");
        CharSequence charSequence = object.getStringExtra("message_type");
        String string3 = object.getStringExtra("transaction_id");
        String string4 = "new_token";
        boolean bl2 = string4.equals(charSequence);
        if (bl2) {
            string2 = "onNewToken";
            HMSLog.i((String)object2, string2);
            this.a((Intent)object, string3);
        } else {
            string4 = "received_message";
            bl2 = string4.equals(charSequence);
            if (bl2) {
                charSequence = new StringBuilder();
                string3 = "onMessageReceived, message id:";
                ((StringBuilder)charSequence).append(string3);
                ((StringBuilder)charSequence).append(string2);
                charSequence = ((StringBuilder)charSequence).toString();
                HMSLog.i((String)object2, (String)charSequence);
                object2 = ErrorEnum.SUCCESS;
                int n10 = ((ErrorEnum)((Object)object2)).getInternalCode();
                charSequence = "push.receiveMessage";
                this.a((String)charSequence, string2, n10);
                this.doMsgReceived((Intent)object);
            } else {
                string4 = "sent_message";
                bl2 = string4.equals(charSequence);
                if (bl2) {
                    this.b(string3, string2);
                } else {
                    string4 = "send_error";
                    bl2 = string4.equals(charSequence);
                    String string5 = "error";
                    if (bl2) {
                        object2 = ErrorEnum.ERROR_UNKNOWN;
                        int n11 = ((ErrorEnum)((Object)object2)).getInternalCode();
                        int n12 = object.getIntExtra(string5, n11);
                        this.b(string3, string2, n12);
                    } else {
                        string4 = "delivery";
                        bl2 = string4.equals(charSequence);
                        if (bl2) {
                            int n13 = ErrorEnum.ERROR_APP_SERVER_NOT_ONLINE.getInternalCode();
                            int n14 = object.getIntExtra(string5, n13);
                            charSequence = new StringBuilder();
                            ((StringBuilder)charSequence).append("onMessageDelivery, message id:");
                            ((StringBuilder)charSequence).append(string2);
                            ((StringBuilder)charSequence).append(", status:");
                            ((StringBuilder)charSequence).append(n14);
                            string4 = ", transactionId: ";
                            ((StringBuilder)charSequence).append(string4);
                            ((StringBuilder)charSequence).append(string3);
                            charSequence = ((StringBuilder)charSequence).toString();
                            HMSLog.i((String)object2, (String)charSequence);
                            this.a("push.deliveryMessage", string3, n14);
                            object2 = new SendException(n14);
                            this.onMessageDelivered(string2, (Exception)object2);
                        } else {
                            string3 = "server_deleted_message";
                            boolean bl3 = string3.equals(charSequence);
                            if (bl3) {
                                object = new StringBuilder();
                                charSequence = "delete message, message id:";
                                ((StringBuilder)object).append((String)charSequence);
                                ((StringBuilder)object).append(string2);
                                object = ((StringBuilder)object).toString();
                                HMSLog.i((String)object2, (String)object);
                                this.onDeletedMessages();
                            } else {
                                string2 = "batchSent";
                                boolean bl4 = string2.equals(charSequence);
                                if (bl4) {
                                    this.b((Intent)object);
                                } else {
                                    object = new StringBuilder();
                                    string2 = "Receive unknown message: ";
                                    ((StringBuilder)object).append(string2);
                                    ((StringBuilder)object).append((String)charSequence);
                                    object = ((StringBuilder)object).toString();
                                    HMSLog.e((String)object2, (String)object);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public IBinder onBind(Intent intent) {
        HMSLog.i("HmsMessageService", "start to bind");
        return this.a.getBinder();
    }

    public void onDeletedMessages() {
    }

    public void onDestroy() {
        HMSLog.i("HmsMessageService", "start to destroy");
        super.onDestroy();
    }

    public void onMessageDelivered(String string2, Exception exception) {
    }

    public void onMessageReceived(RemoteMessage remoteMessage) {
    }

    public void onMessageSent(String string2) {
    }

    public void onNewToken(String string2) {
    }

    public void onNewToken(String string2, Bundle bundle) {
    }

    public void onSendError(String string2, Exception exception) {
    }

    public int onStartCommand(Intent intent, int n10, int n11) {
        CharSequence charSequence = new StringBuilder();
        charSequence.append("start to command , startId = ");
        charSequence.append(n11);
        charSequence = charSequence.toString();
        HMSLog.i("HmsMessageService", (String)charSequence);
        this.handleIntentMessage(intent);
        return 2;
    }

    public void onTokenError(Exception exception) {
    }

    public void onTokenError(Exception exception, Bundle bundle) {
    }
}

