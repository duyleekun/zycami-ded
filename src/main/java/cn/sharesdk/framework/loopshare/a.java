/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.SharedPreferences
 *  android.content.SharedPreferences$Editor
 */
package cn.sharesdk.framework.loopshare;

import android.content.Context;
import android.content.SharedPreferences;

public class a {
    private SharedPreferences a;
    private SharedPreferences.Editor b;

    public a(Context context, String string2) {
        context = context.getSharedPreferences(string2, 0);
        this.a = context;
        context = context.edit();
        this.b = context;
    }

    public void a(String string2, Object object) {
        boolean bl2 = object instanceof String;
        if (bl2) {
            SharedPreferences.Editor editor = this.b;
            object = (String)object;
            editor.putString(string2, (String)object);
        } else {
            bl2 = object instanceof Integer;
            if (bl2) {
                SharedPreferences.Editor editor = this.b;
                object = (Integer)object;
                int n10 = (Integer)object;
                editor.putInt(string2, n10);
            } else {
                bl2 = object instanceof Boolean;
                if (bl2) {
                    SharedPreferences.Editor editor = this.b;
                    object = (Boolean)object;
                    boolean bl3 = (Boolean)object;
                    editor.putBoolean(string2, bl3);
                } else {
                    bl2 = object instanceof Float;
                    if (bl2) {
                        SharedPreferences.Editor editor = this.b;
                        object = (Float)object;
                        float f10 = ((Float)object).floatValue();
                        editor.putFloat(string2, f10);
                    } else {
                        bl2 = object instanceof Long;
                        if (bl2) {
                            SharedPreferences.Editor editor = this.b;
                            object = (Long)object;
                            long l10 = (Long)object;
                            editor.putLong(string2, l10);
                        } else {
                            SharedPreferences.Editor editor = this.b;
                            object = object.toString();
                            editor.putString(string2, (String)object);
                        }
                    }
                }
            }
        }
        this.b.commit();
    }

    public Object b(String string2, Object object) {
        boolean bl2 = object instanceof String;
        if (bl2) {
            SharedPreferences sharedPreferences = this.a;
            object = (String)object;
            return sharedPreferences.getString(string2, (String)object);
        }
        bl2 = object instanceof Integer;
        if (bl2) {
            SharedPreferences sharedPreferences = this.a;
            int n10 = (Integer)object;
            return sharedPreferences.getInt(string2, n10);
        }
        bl2 = object instanceof Boolean;
        if (bl2) {
            SharedPreferences sharedPreferences = this.a;
            boolean bl3 = (Boolean)object;
            return sharedPreferences.getBoolean(string2, bl3);
        }
        bl2 = object instanceof Float;
        if (bl2) {
            SharedPreferences sharedPreferences = this.a;
            float f10 = ((Float)object).floatValue();
            return Float.valueOf(sharedPreferences.getFloat(string2, f10));
        }
        bl2 = object instanceof Long;
        if (bl2) {
            SharedPreferences sharedPreferences = this.a;
            long l10 = (Long)object;
            return sharedPreferences.getLong(string2, l10);
        }
        return this.a.getString(string2, null);
    }
}

