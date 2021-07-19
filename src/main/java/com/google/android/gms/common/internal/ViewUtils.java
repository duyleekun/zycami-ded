/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources$NotFoundException
 *  android.util.AttributeSet
 *  android.util.Log
 *  android.util.TypedValue
 */
package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;

public class ViewUtils {
    private ViewUtils() {
    }

    /*
     * WARNING - void declaration
     */
    public static String getXmlAttributeString(String string2, String string3, Context object, AttributeSet object2, boolean bl2, boolean bl3, String string4) {
        void var5_7;
        void var6_8;
        int n10;
        int n11;
        string2 = object2 == null ? null : object2.getAttributeValue(string2, string3);
        if (string2 != null && (n11 = string2.startsWith((String)(object2 = "@string/"))) != 0 && bl2) {
            n11 = 8;
            CharSequence charSequence = string2.substring(n11);
            String string5 = object.getPackageName();
            TypedValue typedValue = new TypedValue();
            object = object.getResources();
            String string6 = String.valueOf(string5);
            int n12 = string6.length() + n11;
            object2 = String.valueOf(charSequence);
            n11 = ((String)object2).length();
            n12 += n11;
            object2 = new StringBuilder(n12);
            ((StringBuilder)object2).append(string5);
            string5 = ":string/";
            ((StringBuilder)object2).append(string5);
            ((StringBuilder)object2).append((String)charSequence);
            object2 = ((StringBuilder)object2).toString();
            boolean bl4 = true;
            try {
                object.getValue((String)object2, typedValue, bl4);
            }
            catch (Resources.NotFoundException notFoundException) {
                n10 = String.valueOf(string3).length() + 30;
                n11 = String.valueOf(string2).length();
                object2 = new StringBuilder(n10 += n11);
                ((StringBuilder)object2).append("Could not find resource for ");
                ((StringBuilder)object2).append(string3);
                ((StringBuilder)object2).append(": ");
                ((StringBuilder)object2).append(string2);
                object = ((StringBuilder)object2).toString();
                Log.w((String)var6_8, (String)object);
            }
            object = typedValue.string;
            if (object != null) {
                string2 = object.toString();
            } else {
                object = String.valueOf(typedValue);
                n11 = String.valueOf(string3).length() + 28;
                int n13 = String.valueOf(object).length();
                charSequence = new StringBuilder(n11 += n13);
                ((StringBuilder)charSequence).append("Resource ");
                ((StringBuilder)charSequence).append(string3);
                object2 = " was not a string: ";
                ((StringBuilder)charSequence).append((String)object2);
                ((StringBuilder)charSequence).append((String)object);
                object = ((StringBuilder)charSequence).toString();
                Log.w((String)var6_8, (String)object);
            }
        }
        if (var5_7 != false && string2 == null) {
            n10 = String.valueOf(string3).length() + 33;
            object2 = new StringBuilder(n10);
            object = "Required XML attribute \"";
            ((StringBuilder)object2).append((String)object);
            ((StringBuilder)object2).append(string3);
            ((StringBuilder)object2).append("\" missing");
            string3 = ((StringBuilder)object2).toString();
            Log.w((String)var6_8, (String)string3);
        }
        return string2;
    }
}

