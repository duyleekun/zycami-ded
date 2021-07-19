/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 */
package com.sina.weibo.sdk.net;

import android.os.Bundle;
import com.sina.weibo.sdk.net.e;
import java.io.Serializable;
import java.util.Map;

public final class e$a {
    public Bundle k;
    public Bundle l;
    public Map m;
    public Map n;
    public int o;
    public int p;
    public String url;

    public e$a() {
        Object object;
        this.k = object = new Bundle();
        this.l = object = new Bundle();
        this.m = object;
        super();
        this.n = object;
        this.o = 30000;
        this.p = 60000;
    }

    private void a(Bundle object, String string2, Object object2) {
        if (object2 != null) {
            boolean bl2 = object2 instanceof String;
            if (bl2) {
                object2 = String.valueOf(object2);
                object.putString(string2, (String)object2);
                return;
            }
            bl2 = object2 instanceof Integer;
            if (bl2) {
                int n10 = (Integer)object2;
                object.putInt(string2, n10);
                return;
            }
            bl2 = object2 instanceof Short;
            if (bl2) {
                short s10 = (Short)object2;
                object.putShort(string2, s10);
                return;
            }
            bl2 = object2 instanceof Character;
            if (bl2) {
                char c10 = ((Character)object2).charValue();
                object.putChar(string2, c10);
                return;
            }
            bl2 = object2 instanceof Byte;
            if (bl2) {
                byte by2 = (Byte)object2;
                object.putByte(string2, by2);
                return;
            }
            bl2 = object2 instanceof Long;
            if (bl2) {
                long l10 = (Long)object2;
                object.putLong(string2, l10);
                return;
            }
            bl2 = object2 instanceof Float;
            if (bl2) {
                float f10 = ((Float)object2).floatValue();
                object.putFloat(string2, f10);
                return;
            }
            bl2 = object2 instanceof Double;
            if (bl2) {
                double d10 = (Double)object2;
                object.putDouble(string2, d10);
                return;
            }
            bl2 = object2 instanceof Boolean;
            if (bl2) {
                boolean bl3 = (Boolean)object2;
                object.putBoolean(string2, bl3);
                return;
            }
            bl2 = object2 instanceof byte[];
            if (bl2) {
                object = this.n;
                object2 = (byte[])object2;
                object.put(string2, object2);
                return;
            }
            bl2 = object2 instanceof Serializable;
            if (bl2) {
                object2 = (Serializable)object2;
                object.putSerializable(string2, (Serializable)object2);
                return;
            }
            object = new IllegalArgumentException("Unsupported params type!");
            throw object;
        }
    }

    public final e$a a(String string2, Object object) {
        Bundle bundle = this.k;
        this.a(bundle, string2, object);
        return this;
    }

    public final e$a b(String string2, Object object) {
        Bundle bundle = this.l;
        this.a(bundle, string2, object);
        return this;
    }

    public final e i() {
        e e10 = new e(this);
        return e10;
    }
}

