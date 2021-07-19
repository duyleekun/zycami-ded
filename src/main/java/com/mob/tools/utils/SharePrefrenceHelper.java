/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 *  android.util.Base64
 */
package com.mob.tools.utils;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.mob.tools.MobLog;
import com.mob.tools.log.NLog;
import com.mob.tools.utils.SharePrefrenceHelper$MobSharePreference;
import com.mob.tools.utils.SharePrefrenceHelper$OnCommitListener;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

public class SharePrefrenceHelper {
    private Context context;
    private SharePrefrenceHelper$MobSharePreference prefrence;

    public SharePrefrenceHelper(Context context) {
        if (context != null) {
            this.context = context = context.getApplicationContext();
        }
    }

    public void clear() {
        SharePrefrenceHelper$MobSharePreference sharePrefrenceHelper$MobSharePreference = this.prefrence;
        if (sharePrefrenceHelper$MobSharePreference != null) {
            sharePrefrenceHelper$MobSharePreference.clear();
        }
    }

    public Object get(String object) {
        try {
            object = this.getString((String)object);
        }
        catch (Throwable throwable) {
            MobLog.getInstance().w(throwable);
            return null;
        }
        int n10 = TextUtils.isEmpty((CharSequence)object);
        if (n10 != 0) {
            return null;
        }
        n10 = 2;
        object = Base64.decode((String)object, (int)n10);
        Object object2 = new ByteArrayInputStream((byte[])object);
        object = new ObjectInputStream((InputStream)object2);
        object2 = ((ObjectInputStream)object).readObject();
        ((ObjectInputStream)object).close();
        return object2;
    }

    public HashMap getAll() {
        Object object = this.prefrence;
        if (object != null) {
            return ((SharePrefrenceHelper$MobSharePreference)object).getAll();
        }
        object = new Object();
        return object;
    }

    public boolean getBoolean(String string2) {
        SharePrefrenceHelper$MobSharePreference sharePrefrenceHelper$MobSharePreference = this.prefrence;
        if (sharePrefrenceHelper$MobSharePreference != null) {
            return sharePrefrenceHelper$MobSharePreference.getBoolean(string2, false);
        }
        return false;
    }

    public boolean getBoolean(String string2, boolean bl2) {
        SharePrefrenceHelper$MobSharePreference sharePrefrenceHelper$MobSharePreference = this.prefrence;
        if (sharePrefrenceHelper$MobSharePreference != null) {
            return sharePrefrenceHelper$MobSharePreference.getBoolean(string2, bl2);
        }
        return bl2;
    }

    public float getFloat(String string2) {
        SharePrefrenceHelper$MobSharePreference sharePrefrenceHelper$MobSharePreference = this.prefrence;
        if (sharePrefrenceHelper$MobSharePreference != null) {
            return sharePrefrenceHelper$MobSharePreference.getFloat(string2, 0.0f);
        }
        return 0.0f;
    }

    public float getFloat(String string2, float f10) {
        SharePrefrenceHelper$MobSharePreference sharePrefrenceHelper$MobSharePreference = this.prefrence;
        if (sharePrefrenceHelper$MobSharePreference != null) {
            return sharePrefrenceHelper$MobSharePreference.getFloat(string2, f10);
        }
        return f10;
    }

    public int getInt(String string2) {
        SharePrefrenceHelper$MobSharePreference sharePrefrenceHelper$MobSharePreference = this.prefrence;
        if (sharePrefrenceHelper$MobSharePreference != null) {
            return sharePrefrenceHelper$MobSharePreference.getInt(string2, 0);
        }
        return 0;
    }

    public int getInt(String string2, int n10) {
        SharePrefrenceHelper$MobSharePreference sharePrefrenceHelper$MobSharePreference = this.prefrence;
        if (sharePrefrenceHelper$MobSharePreference != null) {
            return sharePrefrenceHelper$MobSharePreference.getInt(string2, n10);
        }
        return n10;
    }

    public long getLong(String string2) {
        SharePrefrenceHelper$MobSharePreference sharePrefrenceHelper$MobSharePreference = this.prefrence;
        long l10 = 0L;
        if (sharePrefrenceHelper$MobSharePreference != null) {
            return sharePrefrenceHelper$MobSharePreference.getLong(string2, l10);
        }
        return l10;
    }

    public long getLong(String string2, long l10) {
        SharePrefrenceHelper$MobSharePreference sharePrefrenceHelper$MobSharePreference = this.prefrence;
        if (sharePrefrenceHelper$MobSharePreference != null) {
            return sharePrefrenceHelper$MobSharePreference.getLong(string2, l10);
        }
        return l10;
    }

    public String getString(String string2) {
        SharePrefrenceHelper$MobSharePreference sharePrefrenceHelper$MobSharePreference = this.prefrence;
        String string3 = "";
        if (sharePrefrenceHelper$MobSharePreference != null) {
            return sharePrefrenceHelper$MobSharePreference.getString(string2, string3);
        }
        return string3;
    }

    public String getString(String string2, String string3) {
        SharePrefrenceHelper$MobSharePreference sharePrefrenceHelper$MobSharePreference = this.prefrence;
        if (sharePrefrenceHelper$MobSharePreference != null) {
            return sharePrefrenceHelper$MobSharePreference.getString(string2, string3);
        }
        return string3;
    }

    public void open(String string2) {
        this.open(string2, 0);
    }

    public void open(String string2, int n10) {
        SharePrefrenceHelper$MobSharePreference sharePrefrenceHelper$MobSharePreference;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string2);
        stringBuilder.append("_");
        stringBuilder.append(n10);
        string2 = stringBuilder.toString();
        stringBuilder = this.context;
        this.prefrence = sharePrefrenceHelper$MobSharePreference = new SharePrefrenceHelper$MobSharePreference((Context)stringBuilder, string2);
    }

    public void put(String string2, Object object) {
        if (object == null) {
            return;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(object);
        objectOutputStream.flush();
        objectOutputStream.close();
        object = byteArrayOutputStream.toByteArray();
        int n10 = 2;
        object = Base64.encodeToString((byte[])object, (int)n10);
        try {
            this.putString(string2, (String)object);
        }
        catch (Throwable throwable) {
            object = MobLog.getInstance();
            ((NLog)object).w(throwable);
        }
    }

    public void putAll(HashMap hashMap) {
        SharePrefrenceHelper$MobSharePreference sharePrefrenceHelper$MobSharePreference = this.prefrence;
        if (sharePrefrenceHelper$MobSharePreference != null) {
            sharePrefrenceHelper$MobSharePreference.putAll(hashMap);
        }
    }

    public void putBoolean(String string2, Boolean bl2) {
        SharePrefrenceHelper$MobSharePreference sharePrefrenceHelper$MobSharePreference = this.prefrence;
        if (sharePrefrenceHelper$MobSharePreference != null) {
            boolean bl3 = bl2;
            sharePrefrenceHelper$MobSharePreference.putBoolean(string2, bl3);
        }
    }

    public void putFloat(String string2, Float f10) {
        SharePrefrenceHelper$MobSharePreference sharePrefrenceHelper$MobSharePreference = this.prefrence;
        if (sharePrefrenceHelper$MobSharePreference != null) {
            float f11 = f10.floatValue();
            sharePrefrenceHelper$MobSharePreference.putFloat(string2, f11);
        }
    }

    public void putInt(String string2, Integer n10) {
        SharePrefrenceHelper$MobSharePreference sharePrefrenceHelper$MobSharePreference = this.prefrence;
        if (sharePrefrenceHelper$MobSharePreference != null) {
            int n11 = n10;
            sharePrefrenceHelper$MobSharePreference.putInt(string2, n11);
        }
    }

    public void putLong(String string2, Long l10) {
        SharePrefrenceHelper$MobSharePreference sharePrefrenceHelper$MobSharePreference = this.prefrence;
        if (sharePrefrenceHelper$MobSharePreference != null) {
            long l11 = l10;
            sharePrefrenceHelper$MobSharePreference.putLong(string2, l11);
        }
    }

    public void putString(String string2, String string3) {
        SharePrefrenceHelper$MobSharePreference sharePrefrenceHelper$MobSharePreference = this.prefrence;
        if (sharePrefrenceHelper$MobSharePreference != null) {
            sharePrefrenceHelper$MobSharePreference.putString(string2, string3);
        }
    }

    public void remove(String string2) {
        SharePrefrenceHelper$MobSharePreference sharePrefrenceHelper$MobSharePreference = this.prefrence;
        if (sharePrefrenceHelper$MobSharePreference != null) {
            sharePrefrenceHelper$MobSharePreference.remove(string2);
        }
    }

    public void setOnCommitListener(SharePrefrenceHelper$OnCommitListener sharePrefrenceHelper$OnCommitListener) {
        SharePrefrenceHelper$MobSharePreference sharePrefrenceHelper$MobSharePreference = this.prefrence;
        if (sharePrefrenceHelper$MobSharePreference != null) {
            sharePrefrenceHelper$MobSharePreference.setOnCommitListener(sharePrefrenceHelper$OnCommitListener);
        }
    }
}

