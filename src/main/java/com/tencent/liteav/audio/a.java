/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.SharedPreferences
 *  android.content.SharedPreferences$Editor
 */
package com.tencent.liteav.audio;

import android.content.SharedPreferences;
import com.tencent.liteav.audio.a$1;
import com.tencent.liteav.audio.a$a;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.TXCCommonUtil;

public class a {
    private final SharedPreferences a;

    private a() {
        SharedPreferences sharedPreferences;
        this.a = sharedPreferences = TXCCommonUtil.getAppContext().getSharedPreferences("txc_audio_settings", 0);
    }

    public /* synthetic */ a(a$1 a$1) {
        this();
    }

    public static a a() {
        return a$a.a();
    }

    private void a(String string2, Object object) {
        SharedPreferences.Editor editor = this.a.edit();
        boolean bl2 = object instanceof Integer;
        if (bl2) {
            object = (Integer)object;
            int n10 = (Integer)object;
            editor.putInt(string2, n10);
        } else {
            bl2 = object instanceof String;
            if (bl2) {
                object = object.toString();
                editor.putString(string2, (String)object);
            } else {
                bl2 = object instanceof Boolean;
                if (bl2) {
                    object = (Boolean)object;
                    boolean bl3 = (Boolean)object;
                    editor.putBoolean(string2, bl3);
                } else {
                    bl2 = object instanceof Long;
                    if (bl2) {
                        object = (Long)object;
                        long l10 = (Long)object;
                        editor.putLong(string2, l10);
                    } else {
                        bl2 = object instanceof Float;
                        if (bl2) {
                            object = (Float)object;
                            float f10 = ((Float)object).floatValue();
                            editor.putFloat(string2, f10);
                        } else {
                            bl2 = object instanceof Double;
                            if (bl2) {
                                object = (Double)object;
                                double d10 = (Double)object;
                                long l11 = Double.doubleToRawLongBits(d10);
                                editor.putLong(string2, l11);
                            }
                        }
                    }
                }
            }
        }
        editor.commit();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private Object b(String string2, Object object) {
        Object object2;
        SharedPreferences sharedPreferences;
        boolean bl2 = object instanceof String;
        if (bl2) {
            sharedPreferences = this.a;
            object2 = object.toString();
            return sharedPreferences.getString(string2, (String)object2);
        }
        boolean bl3 = object instanceof Integer;
        if (bl3) {
            sharedPreferences = this.a;
            object2 = object;
            object2 = (Integer)object;
            int n10 = (Integer)object2;
            int n11 = sharedPreferences.getInt(string2, n10);
            return n11;
        }
        boolean bl4 = object instanceof Boolean;
        if (bl4) {
            sharedPreferences = this.a;
            object2 = object;
            object2 = (Boolean)object;
            boolean bl5 = (Boolean)object2;
            boolean bl6 = sharedPreferences.getBoolean(string2, bl5);
            return bl6;
        }
        boolean bl7 = object instanceof Long;
        if (bl7) {
            sharedPreferences = this.a;
            object2 = object;
            object2 = (Long)object;
            long l10 = (Long)object2;
            long l11 = sharedPreferences.getLong(string2, l10);
            return l11;
        }
        boolean bl8 = object instanceof Float;
        if (bl8) {
            sharedPreferences = this.a;
            object2 = object;
            object2 = (Float)object;
            float f10 = ((Float)object2).floatValue();
            float f11 = sharedPreferences.getFloat(string2, f10);
            return Float.valueOf(f11);
        }
        boolean bl9 = object instanceof Double;
        if (!bl9) return object;
        try {
            sharedPreferences = this.a;
            object2 = object;
        }
        catch (Exception exception) {
            object2 = new Object[]{string2, exception};
            TXCLog.e("TXCAudioSettings", "get value from sharedpreference failed for key: %s", (Object[])object2);
            return object;
        }
        object2 = (Double)object;
        double d10 = (Double)object2;
        long l12 = Double.doubleToLongBits(d10);
        long l13 = sharedPreferences.getLong(string2, l12);
        double d11 = Double.longBitsToDouble(l13);
        return d11;
    }

    public void a(String string2, long l10) {
        Long l11 = l10;
        this.a(string2, l11);
    }

    public long b(String string2, long l10) {
        Long l11 = l10;
        return (Long)this.b(string2, l11);
    }
}

