/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  android.os.Bundle
 *  android.text.TextUtils
 */
package com.huawei.hms.push;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.push.b;
import com.huawei.hms.push.utils.DateUtil;
import com.huawei.hms.support.log.HMSLog;
import java.io.Serializable;
import java.text.ParseException;

public class RemoteMessage$Notification
implements Serializable {
    public final long[] A;
    public final String B;
    public final String a;
    public final String b;
    public final String[] c;
    public final String d;
    public final String e;
    public final String[] f;
    public final String g;
    public final String h;
    public final String i;
    public final String j;
    public final String k;
    public final String l;
    public final String m;
    public final Uri n;
    public final int o;
    public final String p;
    public final int q;
    public final int r;
    public final int s;
    public final int[] t;
    public final String u;
    public final int v;
    public final String w;
    public final int x;
    public final String y;
    public final String z;

    public RemoteMessage$Notification(Bundle object) {
        int n10;
        Object object2 = object.getString("notifyTitle");
        this.a = object2;
        object2 = object.getString("content");
        this.d = object2;
        object2 = object.getString("title_loc_key");
        this.b = object2;
        object2 = object.getString("body_loc_key");
        this.e = object2;
        object2 = object.getStringArray("title_loc_args");
        this.c = object2;
        object2 = object.getStringArray("body_loc_args");
        this.f = object2;
        object2 = object.getString("icon");
        this.g = object2;
        object2 = object.getString("color");
        this.j = object2;
        object2 = object.getString("sound");
        this.h = object2;
        object2 = object.getString("tag");
        this.i = object2;
        object2 = object.getString("channelId");
        this.m = object2;
        object2 = object.getString("acn");
        this.k = object2;
        object2 = object.getString("intentUri");
        this.l = object2;
        this.o = n10 = object.getInt("notifyId");
        object2 = object.getString("url");
        boolean bl2 = TextUtils.isEmpty((CharSequence)object2);
        if (!bl2) {
            object2 = Uri.parse((String)object2);
        } else {
            n10 = 0;
            object2 = null;
        }
        this.n = object2;
        object2 = object.getString("notifyIcon");
        this.p = object2;
        this.q = n10 = object.getInt("defaultLightSettings");
        this.r = n10 = object.getInt("defaultSound");
        this.s = n10 = object.getInt("defaultVibrateTimings");
        object2 = object.getIntArray("lightSettings");
        this.t = (int[])object2;
        object2 = object.getString("when");
        this.u = object2;
        this.v = n10 = object.getInt("localOnly");
        object2 = object.getString("badgeSetNum", null);
        this.w = object2;
        this.x = n10 = object.getInt("autoCancel");
        object2 = object.getString("priority", null);
        this.y = object2;
        object2 = object.getString("ticker");
        this.z = object2;
        object2 = object.getLongArray("vibrateTimings");
        this.A = (long[])object2;
        object = object.getString("visibility", null);
        this.B = object;
    }

    public /* synthetic */ RemoteMessage$Notification(Bundle bundle, b b10) {
        this(bundle);
    }

    public final Integer a(String object) {
        block3: {
            if (object != null) {
                try {
                    object = Integer.valueOf((String)object);
                    break block3;
                }
                catch (NumberFormatException numberFormatException) {
                    CharSequence charSequence = new StringBuilder();
                    String string2 = "NumberFormatException: get ";
                    charSequence.append(string2);
                    charSequence.append((String)object);
                    charSequence.append(" failed.");
                    object = charSequence.toString();
                    charSequence = "RemoteMessage";
                    HMSLog.w((String)charSequence, (String)object);
                }
            }
            object = null;
        }
        return object;
    }

    public Integer getBadgeNumber() {
        String string2 = this.w;
        return this.a(string2);
    }

    public String getBody() {
        return this.d;
    }

    public String[] getBodyLocalizationArgs() {
        String[] stringArray = this.f;
        stringArray = stringArray == null ? new String[]{} : (String[])stringArray.clone();
        return stringArray;
    }

    public String getBodyLocalizationKey() {
        return this.e;
    }

    public String getChannelId() {
        return this.m;
    }

    public String getClickAction() {
        return this.k;
    }

    public String getColor() {
        return this.j;
    }

    public String getIcon() {
        return this.g;
    }

    public Uri getImageUrl() {
        String string2 = this.p;
        string2 = string2 == null ? null : Uri.parse((String)string2);
        return string2;
    }

    public Integer getImportance() {
        String string2 = this.y;
        return this.a(string2);
    }

    public String getIntentUri() {
        return this.l;
    }

    public int[] getLightSettings() {
        int[] nArray = this.t;
        nArray = nArray == null ? new int[]{} : (int[])nArray.clone();
        return nArray;
    }

    public Uri getLink() {
        return this.n;
    }

    public int getNotifyId() {
        return this.o;
    }

    public String getSound() {
        return this.h;
    }

    public String getTag() {
        return this.i;
    }

    public String getTicker() {
        return this.z;
    }

    public String getTitle() {
        return this.a;
    }

    public String[] getTitleLocalizationArgs() {
        String[] stringArray = this.c;
        stringArray = stringArray == null ? new String[]{} : (String[])stringArray.clone();
        return stringArray;
    }

    public String getTitleLocalizationKey() {
        return this.b;
    }

    public long[] getVibrateConfig() {
        long[] lArray = this.A;
        lArray = lArray == null ? new long[]{} : (long[])lArray.clone();
        return lArray;
    }

    public Integer getVisibility() {
        String string2 = this.B;
        return this.a(string2);
    }

    public Long getWhen() {
        Object object;
        block6: {
            object = "RemoteMessage";
            String string2 = this.u;
            boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
            if (!bl2) {
                string2 = this.u;
                long l10 = DateUtil.parseUtcToMillisecond(string2);
                try {
                    object = l10;
                    break block6;
                }
                catch (StringIndexOutOfBoundsException stringIndexOutOfBoundsException) {
                    string2 = "StringIndexOutOfBoundsException: parse when failed.";
                    HMSLog.w((String)object, string2);
                }
                catch (ParseException parseException) {
                    string2 = "ParseException: parse when failed.";
                    HMSLog.w((String)object, string2);
                }
            }
            object = null;
        }
        return object;
    }

    public boolean isAutoCancel() {
        int n10 = this.x;
        int n11 = 1;
        if (n10 != n11) {
            n11 = 0;
        }
        return n11 != 0;
    }

    public boolean isDefaultLight() {
        int n10 = this.q;
        int n11 = 1;
        if (n10 != n11) {
            n11 = 0;
        }
        return n11 != 0;
    }

    public boolean isDefaultSound() {
        int n10 = this.r;
        int n11 = 1;
        if (n10 != n11) {
            n11 = 0;
        }
        return n11 != 0;
    }

    public boolean isDefaultVibrate() {
        int n10 = this.s;
        int n11 = 1;
        if (n10 != n11) {
            n11 = 0;
        }
        return n11 != 0;
    }

    public boolean isLocalOnly() {
        int n10 = this.v;
        int n11 = 1;
        if (n10 != n11) {
            n11 = 0;
        }
        return n11 != 0;
    }
}

