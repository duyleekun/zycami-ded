/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 */
package cn.sharesdk.framework.utils;

import android.content.Context;
import android.text.TextUtils;
import cn.sharesdk.framework.utils.SSDKLog;
import com.mob.tools.log.NLog;

public class ShareSDKR {
    public static int getAnimRes(Context context, String string2) {
        return ShareSDKR.getResId(context, "anim", string2);
    }

    public static int getBitmapRes(Context context, String string2) {
        return ShareSDKR.getResId(context, "drawable", string2);
    }

    public static int getColorRes(Context context, String string2) {
        return ShareSDKR.getResId(context, "color", string2);
    }

    public static int getIdRes(Context context, String string2) {
        return ShareSDKR.getResId(context, "id", string2);
    }

    public static int getLayoutRes(Context context, String string2) {
        return ShareSDKR.getResId(context, "layout", string2);
    }

    public static int getPluralsRes(Context context, String string2) {
        return ShareSDKR.getResId(context, "plurals", string2);
    }

    public static int getRawRes(Context context, String string2) {
        return ShareSDKR.getResId(context, "raw", string2);
    }

    public static int getResId(Context object, String string2, String string3) {
        boolean bl2;
        int n10 = 0;
        Object object2 = null;
        if (object != null && !(bl2 = TextUtils.isEmpty((CharSequence)string2)) && !(bl2 = TextUtils.isEmpty((CharSequence)string3))) {
            String string4;
            CharSequence charSequence;
            CharSequence charSequence2 = object.getPackageName();
            boolean bl3 = TextUtils.isEmpty((CharSequence)charSequence2);
            if (bl3) {
                return 0;
            }
            object2 = object.getResources();
            n10 = object2.getIdentifier(string3, string2, (String)charSequence2);
            if (n10 <= 0) {
                object2 = object.getResources();
                charSequence = string3.toLowerCase();
                n10 = object2.getIdentifier((String)charSequence, string2, (String)charSequence2);
            }
            if (n10 <= 0) {
                object2 = object.getResources();
                charSequence = new StringBuilder();
                string4 = "ssdk_";
                ((StringBuilder)charSequence).append(string4);
                ((StringBuilder)charSequence).append(string3);
                charSequence = ((StringBuilder)charSequence).toString();
                n10 = object2.getIdentifier((String)charSequence, string2, (String)charSequence2);
                if (n10 <= 0) {
                    object2 = object.getResources();
                    charSequence = new StringBuilder();
                    ((StringBuilder)charSequence).append(string4);
                    string4 = string3.toLowerCase();
                    ((StringBuilder)charSequence).append(string4);
                    charSequence = ((StringBuilder)charSequence).toString();
                    n10 = object2.getIdentifier((String)charSequence, string2, (String)charSequence2);
                }
            }
            if (n10 <= 0) {
                object2 = object.getResources();
                charSequence = new StringBuilder();
                string4 = "ssdk_oks_";
                ((StringBuilder)charSequence).append(string4);
                ((StringBuilder)charSequence).append(string3);
                charSequence = ((StringBuilder)charSequence).toString();
                n10 = object2.getIdentifier((String)charSequence, string2, (String)charSequence2);
                if (n10 <= 0) {
                    object = object.getResources();
                    object2 = new StringBuilder();
                    ((StringBuilder)object2).append(string4);
                    charSequence = string3.toLowerCase();
                    ((StringBuilder)object2).append((String)charSequence);
                    object2 = ((StringBuilder)object2).toString();
                    n10 = object.getIdentifier((String)object2, string2, (String)charSequence2);
                }
            }
            if (n10 <= 0) {
                object = SSDKLog.b();
                charSequence2 = new StringBuilder();
                charSequence = "failed to parse ";
                ((StringBuilder)charSequence2).append((String)charSequence);
                ((StringBuilder)charSequence2).append(string2);
                ((StringBuilder)charSequence2).append(" resource \"");
                ((StringBuilder)charSequence2).append(string3);
                ((StringBuilder)charSequence2).append("\"");
                string2 = ((StringBuilder)charSequence2).toString();
                ((NLog)object).w(string2);
            }
        }
        return n10;
    }

    public static int getStringArrayRes(Context context, String string2) {
        return ShareSDKR.getResId(context, "array", string2);
    }

    public static int getStringRes(Context context, String string2) {
        return ShareSDKR.getResId(context, "string", string2);
    }

    public static int getStyleRes(Context context, String string2) {
        return ShareSDKR.getResId(context, "style", string2);
    }
}

