/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 */
package com.tencent.rtmp;

import android.os.Bundle;
import com.tencent.liteav.basic.b.a;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.rtmp.b;

public class b$1
implements a {
    public final /* synthetic */ b a;

    public b$1(b b10) {
        this.a = b10;
    }

    public void a(String object, int n10, String object2, String string2) {
        CharSequence charSequence = b.x();
        StringBuilder stringBuilder = new StringBuilder();
        String string3 = "onEvent => id:";
        stringBuilder.append(string3);
        stringBuilder.append((String)object);
        stringBuilder.append(" code:");
        stringBuilder.append(n10);
        stringBuilder.append(" msg:");
        stringBuilder.append((String)object2);
        stringBuilder.append(" params:");
        stringBuilder.append(string2);
        object = stringBuilder.toString();
        TXCLog.i((String)charSequence, (String)object);
        object = b.a(this.a);
        if (object != null) {
            object = new Bundle();
            charSequence = "EVT_ID";
            object.putInt((String)charSequence, n10);
            long l10 = TXCTimeUtil.getTimeTick();
            object.putLong("EVT_TIME", l10);
            l10 = TXCTimeUtil.getUtcTimeTick();
            string3 = "EVT_UTC_TIME";
            object.putLong(string3, l10);
            if (object2 != null) {
                charSequence = new StringBuilder();
                ((StringBuilder)charSequence).append((String)object2);
                if (string2 == null) {
                    string2 = "";
                }
                ((StringBuilder)charSequence).append(string2);
                object2 = ((StringBuilder)charSequence).toString();
                string2 = "EVT_MSG";
                object.putCharSequence(string2, (CharSequence)object2);
            }
            object2 = this.a;
            ((b)object2).onNotifyEvent(n10, (Bundle)object);
        }
    }

    public void b(String object, int n10, String object2, String string2) {
        CharSequence charSequence = b.x();
        StringBuilder stringBuilder = new StringBuilder();
        String string3 = "onWarning => id:";
        stringBuilder.append(string3);
        stringBuilder.append((String)object);
        stringBuilder.append(" code:");
        stringBuilder.append(n10);
        stringBuilder.append(" msg:");
        stringBuilder.append((String)object2);
        stringBuilder.append(" params:");
        stringBuilder.append(string2);
        object = stringBuilder.toString();
        TXCLog.i((String)charSequence, (String)object);
        object = b.a(this.a);
        if (object != null) {
            object = new Bundle();
            charSequence = "EVT_ID";
            object.putInt((String)charSequence, n10);
            long l10 = TXCTimeUtil.getTimeTick();
            string3 = "EVT_TIME";
            object.putLong(string3, l10);
            if (object2 != null) {
                charSequence = new StringBuilder();
                ((StringBuilder)charSequence).append((String)object2);
                if (string2 == null) {
                    string2 = "";
                }
                ((StringBuilder)charSequence).append(string2);
                object2 = ((StringBuilder)charSequence).toString();
                string2 = "EVT_MSG";
                object.putCharSequence(string2, (CharSequence)object2);
            }
            object2 = this.a;
            ((b)object2).onNotifyEvent(n10, (Bundle)object);
        }
    }

    public void c(String object, int n10, String object2, String string2) {
        CharSequence charSequence = b.x();
        StringBuilder stringBuilder = new StringBuilder();
        String string3 = "onError => id:";
        stringBuilder.append(string3);
        stringBuilder.append((String)object);
        stringBuilder.append(" code:");
        stringBuilder.append(n10);
        stringBuilder.append(" msg:");
        stringBuilder.append((String)object2);
        stringBuilder.append(" params:");
        stringBuilder.append(string2);
        object = stringBuilder.toString();
        TXCLog.e((String)charSequence, (String)object);
        object = b.a(this.a);
        if (object != null) {
            object = new Bundle();
            charSequence = "EVT_ID";
            object.putInt((String)charSequence, n10);
            long l10 = TXCTimeUtil.getTimeTick();
            object.putLong("EVT_TIME", l10);
            l10 = TXCTimeUtil.getUtcTimeTick();
            string3 = "EVT_UTC_TIME";
            object.putLong(string3, l10);
            if (object2 != null) {
                charSequence = new StringBuilder();
                ((StringBuilder)charSequence).append((String)object2);
                if (string2 == null) {
                    string2 = "";
                }
                ((StringBuilder)charSequence).append(string2);
                object2 = ((StringBuilder)charSequence).toString();
                string2 = "EVT_MSG";
                object.putCharSequence(string2, (CharSequence)object2);
            }
            object2 = this.a;
            ((b)object2).onNotifyEvent(n10, (Bundle)object);
        }
    }
}

