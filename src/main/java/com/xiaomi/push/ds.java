/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.text.TextUtils
 */
package com.xiaomi.push;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.xiaomi.push.ai;
import com.xiaomi.push.dt;
import com.xiaomi.push.du;
import com.xiaomi.push.dv;
import com.xiaomi.push.dw;
import com.xiaomi.push.ec;
import com.xiaomi.push.ed;
import com.xiaomi.push.ho;
import com.xiaomi.push.hr;
import com.xiaomi.push.hu;
import com.xiaomi.push.service.ak;

public final class ds
implements dw {
    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void a(Context context, String object, String string2) {
        void var3_6;
        int n10 = TextUtils.isEmpty((CharSequence)var3_6);
        if (n10 != 0) return;
        n10 = TextUtils.isEmpty((CharSequence)object);
        if (n10 != 0) {
            return;
        }
        n10 = 12;
        try {
            Object object2 = String.valueOf(n10);
            long l10 = 1L;
            n10 = (int)(du.a(context, (String)object2, l10) ? 1 : 0);
            if (n10 != 0) {
                return;
            }
            object2 = new hu();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append((String)object);
            String string3 = ":";
            stringBuilder.append(string3);
            stringBuilder.append((String)var3_6);
            String string4 = stringBuilder.toString();
            ((hu)object2).a(string4);
            long l11 = System.currentTimeMillis();
            ((hu)object2).a(l11);
            ho ho2 = ho.j;
            ((hu)object2).a(ho2);
            ed.a(context, (hu)object2);
            return;
        }
        catch (Throwable throwable) {
            return;
        }
    }

    public static /* synthetic */ void a(ds ds2, Context context, Intent intent) {
        ds2.b(context, intent);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void b(Context object, Intent object2) {
        String string2 = ":";
        try {
            int n10;
            boolean bl2;
            String string3 = object2.getDataString();
            boolean bl3 = TextUtils.isEmpty((CharSequence)string3);
            if (bl3) {
                return;
            }
            String[] stringArray = string3.split(string2);
            bl3 = stringArray.length;
            if (bl3 < (bl2 = 2 != 0)) return;
            bl3 = true;
            String string4 = stringArray[bl3];
            boolean bl4 = TextUtils.isEmpty((CharSequence)string4);
            if (bl4) {
                return;
            }
            String string5 = stringArray[bl3];
            long l10 = System.currentTimeMillis();
            Object object3 = ak.a((Context)object);
            hr hr2 = hr.Q;
            int n11 = hr2.a();
            bl3 = ((ak)object3).a(n11, bl3);
            object3 = "android.intent.action.PACKAGE_RESTARTED";
            String string6 = object2.getAction();
            boolean bl5 = TextUtils.equals((CharSequence)object3, (CharSequence)string6);
            String string7 = ",";
            String string8 = ")";
            String string9 = "(";
            long l11 = 1L;
            int n12 = 12;
            if (bl5) {
                object2 = String.valueOf(n12);
                boolean bl6 = du.a((Context)object, (String)object2, l11);
                if (bl6) return;
                if (!bl3) {
                    return;
                }
                object = ec.a;
                bl6 = TextUtils.isEmpty((CharSequence)object);
                if (bl6) {
                    object = new StringBuilder();
                    object2 = ec.a;
                    ((StringBuilder)object).append((String)object2);
                    object2 = dv.a;
                    ((StringBuilder)object).append((String)object2);
                    ((StringBuilder)object).append(string2);
                    ec.a = object = ((StringBuilder)object).toString();
                }
                object = new StringBuilder();
                object2 = ec.a;
                ((StringBuilder)object).append((String)object2);
                ((StringBuilder)object).append(string5);
                ((StringBuilder)object).append(string9);
                ((StringBuilder)object).append(l10);
                ((StringBuilder)object).append(string8);
                ((StringBuilder)object).append(string7);
                ec.a = object = ((StringBuilder)object).toString();
                return;
            }
            object3 = "android.intent.action.PACKAGE_CHANGED";
            String string10 = object2.getAction();
            bl5 = TextUtils.equals((CharSequence)object3, (CharSequence)string10);
            if (bl5) {
                object2 = String.valueOf(n12);
                boolean bl7 = du.a((Context)object, (String)object2, l11);
                if (bl7) return;
                if (!bl3) {
                    return;
                }
                object = ec.b;
                bl7 = TextUtils.isEmpty((CharSequence)object);
                if (bl7) {
                    object = new StringBuilder();
                    object2 = ec.b;
                    ((StringBuilder)object).append((String)object2);
                    object2 = dv.b;
                    ((StringBuilder)object).append((String)object2);
                    ((StringBuilder)object).append(string2);
                    ec.b = object = ((StringBuilder)object).toString();
                }
                object = new StringBuilder();
                object2 = ec.b;
                ((StringBuilder)object).append((String)object2);
                ((StringBuilder)object).append(string5);
                ((StringBuilder)object).append(string9);
                ((StringBuilder)object).append(l10);
                ((StringBuilder)object).append(string8);
                ((StringBuilder)object).append(string7);
                ec.b = object = ((StringBuilder)object).toString();
                return;
            }
            string2 = "android.intent.action.PACKAGE_ADDED";
            string4 = object2.getAction();
            boolean bl8 = TextUtils.equals((CharSequence)string2, (CharSequence)string4);
            string4 = "android.intent.extra.REPLACING";
            if (bl8) {
                n10 = (object2 = object2.getExtras()).getBoolean(string4);
                if (n10 != 0) return;
                if (!bl3) return;
                object2 = ho.k;
                n10 = ((ho)((Object)object2)).a();
            } else {
                string2 = "android.intent.action.PACKAGE_REMOVED";
                String string11 = object2.getAction();
                bl8 = TextUtils.equals((CharSequence)string2, (CharSequence)string11);
                if (bl8) {
                    n10 = (int)((object2 = object2.getExtras()).getBoolean(string4) ? 1 : 0);
                    if (n10 != 0) return;
                    if (!bl3) return;
                    object2 = ho.l;
                    n10 = ((ho)((Object)object2)).a();
                } else {
                    string2 = "android.intent.action.PACKAGE_REPLACED";
                    string4 = object2.getAction();
                    bl8 = TextUtils.equals((CharSequence)string2, (CharSequence)string4);
                    if (bl8) {
                        if (!bl3) return;
                        object2 = ho.m;
                        n10 = ((ho)((Object)object2)).a();
                    } else {
                        string2 = "android.intent.action.PACKAGE_DATA_CLEARED";
                        n10 = (int)(TextUtils.equals((CharSequence)string2, (CharSequence)(object2 = object2.getAction())) ? 1 : 0);
                        if (n10 == 0) return;
                        if (!bl3) return;
                        object2 = ho.n;
                        n10 = ((ho)((Object)object2)).a();
                    }
                }
            }
            object2 = String.valueOf(n10);
            this.a((Context)object, (String)object2, string5);
            return;
        }
        catch (Throwable throwable) {}
    }

    public void a(Context context, Intent intent) {
        if (intent == null) {
            return;
        }
        ai ai2 = ai.a(context);
        dt dt2 = new dt(this, context, intent);
        ai2.a(dt2);
    }
}

