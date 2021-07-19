/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Bundle
 *  android.os.Handler
 *  android.os.Handler$Callback
 *  android.os.Message
 */
package com.mob.tools.utils;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.mob.tools.MobHandlerThread;
import com.mob.tools.MobLog;
import com.mob.tools.log.NLog;
import com.mob.tools.utils.Hashon;
import com.mob.tools.utils.SharePrefrenceHelper$MobSharePreference$1;
import com.mob.tools.utils.SharePrefrenceHelper$OnCommitListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.HashMap;

public final class SharePrefrenceHelper$MobSharePreference {
    private static Handler handler;
    private Hashon hashon;
    private SharePrefrenceHelper$OnCommitListener listener;
    private File spFile;
    private HashMap spMap;

    static {
        SharePrefrenceHelper$MobSharePreference$1 sharePrefrenceHelper$MobSharePreference$1 = new SharePrefrenceHelper$MobSharePreference$1();
        handler = MobHandlerThread.newHandler("s", (Handler.Callback)sharePrefrenceHelper$MobSharePreference$1);
    }

    public SharePrefrenceHelper$MobSharePreference(Context object, String object2) {
        block15: {
            if (object != null) {
                object = object.getFilesDir();
                String string2 = "Mob";
                File file = new File((File)object, string2);
                super(file, (String)object2);
                this.spFile = object;
                object = ((File)object).getParentFile();
                boolean bl2 = ((File)object).exists();
                if (bl2) break block15;
                object = this.spFile;
                object = ((File)object).getParentFile();
                ((File)object).mkdirs();
            }
        }
        super();
        this.spMap = object;
        super();
        try {
            this.hashon = object;
            this.open();
        }
        catch (Throwable throwable) {
            object2 = MobLog.getInstance();
            ((NLog)object2).d(throwable);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private Object get(String string2) {
        HashMap hashMap = this.spMap;
        synchronized (hashMap) {
            HashMap hashMap2 = this.spMap;
            return hashMap2.get(string2);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void open() {
        HashMap hashMap = this.spMap;
        synchronized (hashMap) {
            Object object = this.spFile;
            boolean bl2 = ((File)object).exists();
            if (bl2) {
                try {
                    Object object2 = this.spFile;
                    object = new FileInputStream((File)object2);
                    String string2 = "utf-8";
                    object2 = new InputStreamReader((InputStream)object, string2);
                    object = new BufferedReader((Reader)object2);
                    object2 = new StringBuilder();
                    string2 = ((BufferedReader)object).readLine();
                    while (string2 != null) {
                        int n10 = ((StringBuilder)object2).length();
                        if (n10 > 0) {
                            String string3 = "\n";
                            ((StringBuilder)object2).append(string3);
                        }
                        ((StringBuilder)object2).append(string2);
                        string2 = ((BufferedReader)object).readLine();
                    }
                    ((BufferedReader)object).close();
                    object = this.hashon;
                    object2 = ((StringBuilder)object2).toString();
                    this.spMap = object = ((Hashon)object).fromJson((String)object2);
                }
                catch (Throwable throwable) {
                    NLog nLog = MobLog.getInstance();
                    nLog.w(throwable);
                }
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void put(String string2, Object object) {
        HashMap hashMap = this.spMap;
        synchronized (hashMap) {
            Object object2 = this.spMap;
            ((HashMap)object2).put(string2, object);
            string2 = handler;
            if (string2 != null) {
                int n10;
                string2 = new Message();
                object = new Bundle();
                object2 = "json";
                Object object3 = this.hashon;
                HashMap hashMap2 = this.spMap;
                object3 = ((Hashon)object3).fromHashMap(hashMap2);
                object.putString((String)object2, (String)object3);
                object2 = "file";
                object3 = this.spFile;
                object3 = ((File)object3).getAbsolutePath();
                object.putString((String)object2, (String)object3);
                string2.setData((Bundle)object);
                ((Message)string2).what = n10 = 1;
                ((Message)string2).obj = object = this.listener;
                object = handler;
                object.sendMessage((Message)string2);
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void clear() {
        Object object;
        HashMap hashMap = this.spMap;
        synchronized (hashMap) {
            object = this.spMap;
            ((HashMap)object).clear();
        }
        hashMap = handler;
        if (hashMap != null) {
            int n10;
            hashMap = new Message();
            object = new Bundle();
            Object object2 = this.hashon;
            HashMap hashMap2 = this.spMap;
            object2 = ((Hashon)object2).fromHashMap(hashMap2);
            object.putString("json", (String)object2);
            String string2 = "file";
            object2 = this.spFile.getAbsolutePath();
            object.putString(string2, (String)object2);
            hashMap.setData((Bundle)object);
            ((Message)hashMap).what = n10 = 1;
            ((Message)hashMap).obj = object = this.listener;
            object = handler;
            object.sendMessage((Message)hashMap);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public HashMap getAll() {
        HashMap hashMap = this.spMap;
        synchronized (hashMap) {
            HashMap hashMap2 = new HashMap();
            HashMap hashMap3 = this.spMap;
            hashMap2.putAll(hashMap3);
            return hashMap2;
        }
    }

    public boolean getBoolean(String object, boolean by2) {
        byte by3;
        if ((object = this.get((String)object)) != null && (by3 = ((Number)(object = (Number)object)).byteValue()) != (by2 = 1)) {
            by2 = 0;
        }
        return by2 != 0;
    }

    public byte getByte(String object, byte by2) {
        if ((object = this.get((String)object)) != null) {
            return ((Number)object).byteValue();
        }
        return by2;
    }

    public char getChar(String object, char c10) {
        if ((object = this.get((String)object)) != null) {
            return ((String)object).charAt(0);
        }
        return c10;
    }

    public double getDouble(String object, double d10) {
        if ((object = this.get((String)object)) != null) {
            return ((Number)object).doubleValue();
        }
        return d10;
    }

    public float getFloat(String object, float f10) {
        if ((object = this.get((String)object)) != null) {
            return ((Number)object).floatValue();
        }
        return f10;
    }

    public int getInt(String object, int n10) {
        if ((object = this.get((String)object)) != null) {
            return ((Number)object).intValue();
        }
        return n10;
    }

    public long getLong(String object, long l10) {
        if ((object = this.get((String)object)) != null) {
            return ((Number)object).longValue();
        }
        return l10;
    }

    public short getShort(String object, short s10) {
        if ((object = this.get((String)object)) != null) {
            return ((Number)object).shortValue();
        }
        return s10;
    }

    public String getString(String object, String string2) {
        if ((object = this.get((String)object)) != null) {
            return (String)object;
        }
        return string2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void putAll(HashMap hashMap) {
        Object object;
        Object object2 = this.spMap;
        synchronized (object2) {
            object = this.spMap;
            ((HashMap)object).putAll(hashMap);
        }
        hashMap = handler;
        if (hashMap != null) {
            int n10;
            hashMap = new Message();
            object2 = new Bundle();
            Object object3 = this.hashon;
            HashMap hashMap2 = this.spMap;
            object3 = ((Hashon)object3).fromHashMap(hashMap2);
            object2.putString("json", (String)object3);
            object = "file";
            object3 = this.spFile.getAbsolutePath();
            object2.putString((String)object, (String)object3);
            hashMap.setData((Bundle)object2);
            ((Message)hashMap).what = n10 = 1;
            ((Message)hashMap).obj = object2 = this.listener;
            object2 = handler;
            object2.sendMessage((Message)hashMap);
        }
    }

    public void putBoolean(String string2, boolean bl2) {
        byte by2 = (byte)(bl2 ? 1 : 0);
        this.putByte(string2, by2);
    }

    public void putByte(String string2, byte by2) {
        Byte by3 = by2;
        this.put(string2, by3);
    }

    public void putChar(String string2, char c10) {
        String string3 = String.valueOf(c10);
        this.putString(string2, string3);
    }

    public void putDouble(String string2, double d10) {
        Double d11 = d10;
        this.put(string2, d11);
    }

    public void putFloat(String string2, float f10) {
        Float f11 = Float.valueOf(f10);
        this.put(string2, f11);
    }

    public void putInt(String string2, int n10) {
        Integer n11 = n10;
        this.put(string2, n11);
    }

    public void putLong(String string2, long l10) {
        Long l11 = l10;
        this.put(string2, l11);
    }

    public void putShort(String string2, short s10) {
        Short s11 = s10;
        this.put(string2, s11);
    }

    public void putString(String string2, String string3) {
        this.put(string2, string3);
    }

    public void remove(String string2) {
        this.put(string2, null);
    }

    public void setOnCommitListener(SharePrefrenceHelper$OnCommitListener sharePrefrenceHelper$OnCommitListener) {
        this.listener = sharePrefrenceHelper$OnCommitListener;
    }
}

