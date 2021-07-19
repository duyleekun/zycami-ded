/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 */
package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.bp;
import com.xiaomi.push.bt;
import com.xiaomi.push.bx;
import com.xiaomi.push.cb;
import com.xiaomi.push.cb$d;
import com.xiaomi.push.ch;

public class bv
extends bx {
    public bv(String string2, String string3, String[] stringArray, String string4) {
        super(string2, string3, stringArray, string4);
    }

    public static bv a(Context stringArray, String string2, int n10) {
        CharSequence charSequence = "delete  messages when db size is too bigger";
        com.xiaomi.channel.commonutils.logger.b.b((String)charSequence);
        stringArray = cb.a((Context)stringArray).a(string2);
        boolean bl2 = TextUtils.isEmpty((CharSequence)stringArray);
        if (bl2) {
            return null;
        }
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("rowDataId in (select ");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("rowDataId from ");
        stringBuilder.append((String)stringArray);
        stringArray = stringBuilder.toString();
        ((StringBuilder)charSequence).append((String)stringArray);
        ((StringBuilder)charSequence).append(" order by createTimeStamp asc");
        ((StringBuilder)charSequence).append(" limit ?)");
        stringArray = new String[1];
        Object object = String.valueOf(n10);
        stringArray[0] = object;
        charSequence = ((StringBuilder)charSequence).toString();
        object = new bv(string2, (String)charSequence, stringArray, "a job build to delete history message");
        return object;
    }

    private void a(long l10) {
        int n10;
        String[] stringArray = ((cb$d)this).a;
        if (stringArray != null && (n10 = stringArray.length) > 0) {
            String string2;
            n10 = 0;
            stringArray[0] = string2 = String.valueOf(l10);
        }
    }

    public void a(Context object, Object object2) {
        boolean bl2 = object2 instanceof Long;
        if (bl2) {
            long l10;
            Object object3 = object2;
            object3 = (Long)object2;
            long l11 = (Long)object3;
            Object object4 = this.a();
            long l12 = ch.a((String)object4);
            long l13 = l12 - (l10 = bt.a);
            Object object5 = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
            if (object5 > 0) {
                long l14 = l12 - l10;
                double d10 = l14;
                double d11 = 1.2;
                d10 *= d11;
                double d12 = l10;
                d10 /= d12;
                double d13 = l11;
                l11 = (long)(d10 *= d13);
                this.a(l11);
                bp bp2 = bp.a(object);
                StringBuilder stringBuilder = new StringBuilder();
                String string2 = "begin delete ";
                stringBuilder.append(string2);
                stringBuilder.append(l11);
                stringBuilder.append("noUpload messages , because db size is ");
                stringBuilder.append(l12);
                stringBuilder.append("B");
                object3 = stringBuilder.toString();
                bp2.a((String)object3);
                super.a((Context)object, object2);
            } else {
                object = "db size is suitable";
                com.xiaomi.channel.commonutils.logger.b.b((String)object);
            }
        }
    }
}

