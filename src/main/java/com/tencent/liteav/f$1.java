/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 */
package com.tencent.liteav;

import android.os.Bundle;
import com.tencent.liteav.basic.b.a;
import com.tencent.liteav.basic.b.b;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.liteav.f;
import java.lang.ref.Reference;

public class f$1
implements a {
    public final /* synthetic */ f a;

    public f$1(f f10) {
        this.a = f10;
    }

    public void a(String object, int n10, String object2, String string2) {
        CharSequence charSequence = new StringBuilder();
        String string3 = "onEvent => id:";
        ((StringBuilder)charSequence).append(string3);
        ((StringBuilder)charSequence).append((String)object);
        ((StringBuilder)charSequence).append(" code:");
        ((StringBuilder)charSequence).append(n10);
        ((StringBuilder)charSequence).append(" msg:");
        ((StringBuilder)charSequence).append((String)object2);
        ((StringBuilder)charSequence).append(" params:");
        ((StringBuilder)charSequence).append(string2);
        object = ((StringBuilder)charSequence).toString();
        charSequence = "TXCLivePlayer";
        TXCLog.i((String)charSequence, (String)object);
        object = this.a.e;
        object = object == null ? null : (b)((Reference)object).get();
        if (object != null) {
            object = new Bundle();
            charSequence = "EVT_ID";
            object.putInt((String)charSequence, n10);
            long l10 = TXCTimeUtil.getTimeTick();
            object.putLong("EVT_TIME", l10);
            l10 = TXCTimeUtil.getUtcTimeTick();
            String string4 = "EVT_UTC_TIME";
            object.putLong(string4, l10);
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
            ((f)object2).onNotifyEvent(n10, (Bundle)object);
        }
    }

    public void b(String object, int n10, String object2, String string2) {
        CharSequence charSequence = new StringBuilder();
        String string3 = "onWarning => id:";
        ((StringBuilder)charSequence).append(string3);
        ((StringBuilder)charSequence).append((String)object);
        ((StringBuilder)charSequence).append(" code:");
        ((StringBuilder)charSequence).append(n10);
        ((StringBuilder)charSequence).append(" msg:");
        ((StringBuilder)charSequence).append((String)object2);
        ((StringBuilder)charSequence).append(" params:");
        ((StringBuilder)charSequence).append(string2);
        object = ((StringBuilder)charSequence).toString();
        charSequence = "TXCLivePlayer";
        TXCLog.i((String)charSequence, (String)object);
        object = this.a.e;
        object = object == null ? null : (b)((Reference)object).get();
        if (object != null) {
            object = new Bundle();
            charSequence = "EVT_ID";
            object.putInt((String)charSequence, n10);
            long l10 = TXCTimeUtil.getTimeTick();
            String string4 = "EVT_TIME";
            object.putLong(string4, l10);
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
            ((f)object2).onNotifyEvent(n10, (Bundle)object);
        }
    }

    public void c(String object, int n10, String object2, String string2) {
        CharSequence charSequence = new StringBuilder();
        String string3 = "onError => id:";
        ((StringBuilder)charSequence).append(string3);
        ((StringBuilder)charSequence).append((String)object);
        ((StringBuilder)charSequence).append(" code:");
        ((StringBuilder)charSequence).append(n10);
        ((StringBuilder)charSequence).append(" msg:");
        ((StringBuilder)charSequence).append((String)object2);
        ((StringBuilder)charSequence).append(" params:");
        ((StringBuilder)charSequence).append(string2);
        object = ((StringBuilder)charSequence).toString();
        charSequence = "TXCLivePlayer";
        TXCLog.e((String)charSequence, (String)object);
        object = this.a.e;
        object = object == null ? null : (b)((Reference)object).get();
        if (object != null) {
            object = new Bundle();
            charSequence = "EVT_ID";
            object.putInt((String)charSequence, n10);
            long l10 = TXCTimeUtil.getTimeTick();
            object.putLong("EVT_TIME", l10);
            l10 = TXCTimeUtil.getUtcTimeTick();
            String string4 = "EVT_UTC_TIME";
            object.putLong(string4, l10);
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
            ((f)object2).onNotifyEvent(n10, (Bundle)object);
        }
    }
}

