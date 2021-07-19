/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 *  android.text.TextUtils
 */
package com.zhiyun.cama.push;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.zhiyun.account.SimpleWebViewActivity;
import com.zhiyun.account.me.account.AccountActivity;
import com.zhiyun.cama.me.message.MessageLikeListActivity;
import com.zhiyun.cama.push.NotifyClickReceiver$a;
import com.zhiyun.cama.push.PushActivity;
import com.zhiyun.cama.push.PushEntity$PushType;
import d.v.a.f.c.b;
import d.v.c.v0.f;
import d.v.c.v0.k;
import d.v.c.v0.u.v;
import d.v.f.i.g;

public class NotifyClickReceiver
extends BroadcastReceiver {
    public static final String a = "notification_clicked";
    public static final String b = "typeId";
    public static final String c = "objectId";
    public static final String d = "notifyId";
    public static final String e = "title";
    public static final String f = "content";
    public static final String g = "createAt";
    public static final String h = "type";

    /*
     * Enabled aggressive block sorting
     */
    public void onReceive(Context context, Intent object) {
        block11: {
            PushEntity$PushType pushEntity$PushType;
            String string2;
            String string3;
            String string4;
            int n10;
            int n11;
            block10: {
                PushEntity$PushType pushEntity$PushType2;
                PushEntity$PushType pushEntity$PushType3;
                PushEntity$PushType pushEntity$PushType4;
                PushEntity$PushType pushEntity$PushType5;
                block9: {
                    b b10;
                    boolean bl2;
                    PushEntity$PushType pushEntity$PushType6;
                    PushEntity$PushType pushEntity$PushType7;
                    PushEntity$PushType pushEntity$PushType8;
                    PushEntity$PushType pushEntity$PushType9;
                    PushEntity$PushType pushEntity$PushType10;
                    String string5 = object.getAction();
                    n11 = TextUtils.isEmpty((CharSequence)string5);
                    if (n11 != 0) return;
                    String string6 = a;
                    string5 = object.getAction();
                    n11 = string6.equals(string5);
                    if (n11 == 0) return;
                    string5 = b;
                    n10 = -1;
                    n11 = object.getIntExtra(string5, n10);
                    object.getIntExtra(c, n10);
                    n10 = object.getIntExtra(d, n10);
                    string4 = object.getStringExtra(e);
                    string3 = object.getStringExtra(f);
                    string2 = object.getStringExtra(g);
                    String string7 = object.getStringExtra(h);
                    pushEntity$PushType = PushEntity$PushType.fromTypeName(string7);
                    if (pushEntity$PushType == null) {
                        return;
                    }
                    PushEntity$PushType pushEntity$PushType11 = PushEntity$PushType.SUBJECTNOTIFICATION;
                    if (pushEntity$PushType == pushEntity$PushType11 || pushEntity$PushType == (pushEntity$PushType10 = PushEntity$PushType.ACTIVITYNOTICE) || pushEntity$PushType == (pushEntity$PushType9 = PushEntity$PushType.WORKS) || pushEntity$PushType == (pushEntity$PushType8 = PushEntity$PushType.CONNECTION) || pushEntity$PushType == (pushEntity$PushType7 = PushEntity$PushType.TEXT) || pushEntity$PushType == (pushEntity$PushType6 = PushEntity$PushType.SHARENOTICE)) {
                        v v10 = d.v.c.v0.f.a();
                        v10.v(n10);
                    }
                    if (!(bl2 = (b10 = d.v.a.f.c.b.N()).s())) break block9;
                    v v11 = d.v.c.v0.f.a();
                    v11.e(string7, n10);
                    break block10;
                }
                PushEntity$PushType pushEntity$PushType12 = PushEntity$PushType.CHAT;
                if (pushEntity$PushType == pushEntity$PushType12 || pushEntity$PushType == (pushEntity$PushType5 = PushEntity$PushType.FOLLOWLIST) || pushEntity$PushType == (pushEntity$PushType4 = PushEntity$PushType.LIKELIST) || pushEntity$PushType == (pushEntity$PushType3 = PushEntity$PushType.CREATCIRCLEDIDNOTPASS) || pushEntity$PushType == (pushEntity$PushType2 = PushEntity$PushType.JOINEDTHECIRCLEFAILED)) break block11;
            }
            int[] nArray = NotifyClickReceiver$a.a;
            n10 = pushEntity$PushType.ordinal();
            int n12 = nArray[n10];
            n10 = 1;
            if (n12 == n10) {
                MessageLikeListActivity.h(context);
                return;
            }
            n10 = 2;
            if (n12 != n10 && n12 != (n10 = 3)) {
                n11 = 4;
                if (n12 == n11) {
                    int n13 = 2131952547;
                    String string8 = d.v.f.i.g.m(context, n13);
                    SimpleWebViewActivity.i(context, string8, string3);
                    return;
                }
                n11 = 5;
                if (n12 != n11) {
                    return;
                }
                PushActivity.f(context, string4, string2, string3);
                return;
            }
            long l10 = n11;
            String string9 = k.a(l10);
            PushActivity.h(context, string9);
            return;
        }
        AccountActivity.j(context);
    }
}

