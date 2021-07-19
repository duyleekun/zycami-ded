/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.os.RemoteException
 *  android.text.TextUtils
 */
package com.huawei.hms.api;

import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.ResponseHeader;
import com.huawei.hms.core.aidl.a;
import com.huawei.hms.core.aidl.b;
import com.huawei.hms.core.aidl.c$a;
import com.huawei.hms.core.aidl.e;
import com.huawei.hms.support.api.transport.DatagramTransport$a;
import com.huawei.hms.support.log.HMSLog;

public class IPCCallback
extends c$a {
    private final Class a;
    private final DatagramTransport$a b;

    public IPCCallback(Class clazz, DatagramTransport$a datagramTransport$a) {
        this.a = clazz;
        this.b = datagramTransport$a;
    }

    public void call(b object) {
        Object object2;
        int n10;
        if (object != null && (n10 = TextUtils.isEmpty((CharSequence)(object2 = ((b)object).a))) == 0) {
            Object object3;
            n10 = ((b)object).c();
            object2 = com.huawei.hms.core.aidl.a.a(n10);
            IMessageEntity iMessageEntity = null;
            int n11 = ((b)object).b();
            if (n11 > 0 && (iMessageEntity = this.newResponseInstance()) != null) {
                object3 = ((b)object).a();
                ((e)object2).a((Bundle)object3, iMessageEntity);
            }
            if ((object3 = ((b)object).b) != null) {
                object3 = new ResponseHeader();
                object = ((b)object).b;
                ((e)object2).a((Bundle)object, (IMessageEntity)object3);
                object = this.b;
                n10 = ((ResponseHeader)object3).getStatusCode();
                object.a(n10, iMessageEntity);
            } else {
                object = this.b;
                n10 = 0;
                object2 = null;
                object.a(0, iMessageEntity);
            }
            return;
        }
        HMSLog.e("IPCCallback", "In call, URI cannot be empty.");
        object = new RemoteException();
        throw object;
    }

    public IMessageEntity newResponseInstance() {
        Class clazz = this.a;
        if (clazz != null) {
            String string2;
            clazz = clazz.newInstance();
            try {
                return (IMessageEntity)((Object)clazz);
            }
            catch (InstantiationException instantiationException) {
            }
            catch (IllegalAccessException illegalAccessException) {
                // empty catch block
            }
            CharSequence charSequence = new StringBuilder();
            String string3 = "In newResponseInstance, instancing exception.";
            charSequence.append(string3);
            string2 = ((Throwable)((Object)string2)).getMessage();
            charSequence.append(string2);
            string2 = charSequence.toString();
            charSequence = "IPCCallback";
            HMSLog.e((String)charSequence, string2);
        }
        return null;
    }
}

