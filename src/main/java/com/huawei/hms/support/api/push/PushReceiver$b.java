/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Bundle
 */
package com.huawei.hms.support.api.push;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.push.f;
import com.huawei.hms.push.h;
import com.huawei.hms.push.v;
import com.huawei.hms.support.log.HMSLog;
import java.util.concurrent.RejectedExecutionException;

public class PushReceiver$b
implements Runnable {
    public Context a;
    public Intent b;

    public PushReceiver$b(Context context, Intent intent) {
        this.a = context;
        this.b = intent;
    }

    public /* synthetic */ PushReceiver$b(Context context, Intent intent, f f10) {
        this(context, intent);
    }

    public void run() {
        block38: {
            String string2;
            Object object;
            block37: {
                object = "belongId";
                String string3 = "error";
                String string4 = "subjectId";
                Object object2 = "transaction_id";
                String string5 = "device_token";
                string2 = "PushReceiver";
                Object object3 = this.b;
                object3 = object3.getByteArrayExtra(string5);
                if (object3 == null) break block37;
                int n10 = ((Intent)object3).length;
                if (n10 == 0) break block37;
                CharSequence charSequence = new StringBuilder();
                String string6 = "receive a push token: ";
                charSequence.append(string6);
                string6 = this.a;
                string6 = string6.getPackageName();
                charSequence.append(string6);
                charSequence = charSequence.toString();
                HMSLog.i(string2, (String)charSequence);
                string6 = "com.huawei.push.action.MESSAGING_EVENT";
                charSequence = new Intent(string6);
                string6 = this.b;
                string6 = string6.getPackage();
                charSequence.setPackage(string6);
                string6 = new Bundle();
                String string7 = "message_type";
                String string8 = "new_token";
                string6.putString(string7, string8);
                object3 = v.a((byte[])object3);
                string6.putString(string5, (String)object3);
                string5 = this.b;
                string5 = string5.getStringExtra((String)object2);
                string6.putString((String)object2, string5);
                object2 = this.b;
                object2 = object2.getStringExtra(string4);
                string6.putString(string4, (String)object2);
                string4 = this.b;
                object2 = ErrorEnum.SUCCESS;
                int n11 = ((ErrorEnum)((Object)object2)).getInternalCode();
                int n12 = string4.getIntExtra(string3, n11);
                string6.putInt(string3, n12);
                string3 = this.b;
                string3 = string3.getStringExtra((String)object);
                string6.putString((String)object, string3);
                object = new h();
                string3 = this.a;
                boolean bl2 = ((h)object).a((Context)string3, (Bundle)string6, (Intent)charSequence);
                if (bl2) break block38;
                object = new StringBuilder();
                string3 = "receive ";
                ((StringBuilder)object).append(string3);
                string3 = this.b;
                string3 = string3.getAction();
                ((StringBuilder)object).append(string3);
                string3 = " and start service failed";
                ((StringBuilder)object).append(string3);
                object = ((StringBuilder)object).toString();
                HMSLog.e(string2, (String)object);
            }
            object = "get a deviceToken, but it is null or empty";
            try {
                HMSLog.i(string2, (String)object);
                return;
            }
            catch (Exception exception) {
                object = "handle push token error";
                HMSLog.e(string2, (String)object);
            }
            catch (RejectedExecutionException rejectedExecutionException) {
                object = "execute task error";
                HMSLog.e(string2, (String)object);
            }
        }
    }
}

