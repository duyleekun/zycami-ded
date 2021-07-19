/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ContentValues
 *  android.content.Context
 *  android.content.SharedPreferences
 *  android.os.Build$VERSION
 */
package com.huawei.hms.aaid.utils;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import com.huawei.hms.support.log.HMSLog;
import java.io.File;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class PushPreferences {
    public static final String TAG = "PushPreferences";
    public SharedPreferences a;

    public PushPreferences(Context object, String string2) {
        Object object2;
        String string3;
        block4: {
            block5: {
                string3 = "context is null!";
                Objects.requireNonNull(object, string3);
                int bl2 = Build.VERSION.SDK_INT;
                int bl3 = 24;
                if (bl2 < bl3) break block4;
                string3 = object.createDeviceProtectedStorageContext();
                object2 = string3.getSharedPreferences("move_to_de_records", 0);
                boolean bl4 = object2.getBoolean(string2, false);
                if (bl4) break block5;
                bl4 = string3.moveSharedPreferencesFrom((Context)object, string2);
                if (!bl4) break block4;
                object = object2.edit();
                boolean bl5 = true;
                object.putBoolean(string2, bl5);
                object.apply();
            }
            object = string3;
        }
        string3 = this.b((Context)object, string2);
        this.a = string3;
        if (string3 == null) {
            string3 = TAG;
            object2 = "get new sharedPreferences failed,start to get from context. ";
            HMSLog.w(string3, (String)object2);
            object = object.getSharedPreferences(string2, 0);
            this.a = object;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final File a(Context object, String charSequence) {
        try {
            File file;
            int n10 = Build.VERSION.SDK_INT;
            int n11 = 24;
            String string2 = ".xml";
            String string3 = "/shared_prefs";
            if (n10 >= n11) {
                StringBuilder stringBuilder = new StringBuilder();
                object = object.getDataDir();
                stringBuilder.append(object);
                stringBuilder.append(string3);
                object = stringBuilder.toString();
                stringBuilder = new StringBuilder();
                stringBuilder.append((String)charSequence);
                stringBuilder.append(string2);
                charSequence = stringBuilder.toString();
                file = new File((String)object, (String)charSequence);
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                object = object.getFilesDir();
                object = ((File)object).getParent();
                stringBuilder.append((String)object);
                stringBuilder.append(string3);
                object = stringBuilder.toString();
                stringBuilder = new StringBuilder();
                stringBuilder.append((String)charSequence);
                stringBuilder.append(string2);
                charSequence = stringBuilder.toString();
                file = new File((String)object, (String)charSequence);
            }
            boolean bl2 = file.exists();
            if (!bl2) {
                return null;
            }
            return file;
        }
        catch (Exception exception) {
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append("get failed error.");
            String string4 = exception.getMessage();
            ((StringBuilder)charSequence).append(string4);
            string4 = ((StringBuilder)charSequence).toString();
            HMSLog.e(TAG, string4);
            return null;
        }
    }

    public final SharedPreferences b(Context object, String string2) {
        object = this.a((Context)object, string2);
        string2 = null;
        if (object == null) {
            return null;
        }
        Constructor constructor = "android.app.SharedPreferencesImpl";
        constructor = Class.forName((String)((Object)constructor));
        int n10 = 2;
        Class[] classArray = new Class[n10];
        Class clazz = File.class;
        classArray[0] = clazz;
        clazz = Integer.TYPE;
        int n11 = 1;
        classArray[n11] = clazz;
        constructor = ((Class)((Object)constructor)).getDeclaredConstructor(classArray);
        constructor.setAccessible(n11 != 0);
        Object[] objectArray = new Object[n10];
        objectArray[0] = object;
        object = 0;
        objectArray[n11] = object;
        object = constructor.newInstance(objectArray);
        try {
            object = (SharedPreferences)object;
            string2 = object;
        }
        catch (Exception exception) {
            constructor = new Constructor();
            objectArray = "get SharedPreferences error.";
            ((StringBuilder)((Object)constructor)).append((String)objectArray);
            String string3 = exception.getMessage();
            ((StringBuilder)((Object)constructor)).append(string3);
            string3 = ((StringBuilder)((Object)constructor)).toString();
            constructor = TAG;
            HMSLog.e((String)((Object)constructor), string3);
        }
        return string2;
    }

    public boolean clear() {
        SharedPreferences sharedPreferences = this.a;
        if (sharedPreferences != null) {
            return sharedPreferences.edit().clear().commit();
        }
        return false;
    }

    public boolean containsKey(String string2) {
        boolean bl2;
        SharedPreferences sharedPreferences = this.a;
        if (sharedPreferences != null && (bl2 = sharedPreferences.contains(string2))) {
            bl2 = true;
        } else {
            bl2 = false;
            string2 = null;
        }
        return bl2;
    }

    public Map getAll() {
        Object object = this.a;
        if (object != null) {
            return object.getAll();
        }
        object = new HashMap();
        return object;
    }

    public boolean getBoolean(String string2) {
        boolean bl2;
        SharedPreferences sharedPreferences = this.a;
        boolean bl3 = false;
        if (sharedPreferences != null && (bl2 = sharedPreferences.getBoolean(string2, false))) {
            bl3 = true;
        }
        return bl3;
    }

    public int getInt(String string2) {
        SharedPreferences sharedPreferences = this.a;
        int n10 = 0;
        if (sharedPreferences != null) {
            n10 = sharedPreferences.getInt(string2, 0);
        }
        return n10;
    }

    public long getLong(String string2) {
        SharedPreferences sharedPreferences = this.a;
        long l10 = 0L;
        if (sharedPreferences != null) {
            l10 = sharedPreferences.getLong(string2, l10);
        }
        return l10;
    }

    public String getString(String string2) {
        SharedPreferences sharedPreferences = this.a;
        String string3 = "";
        if (sharedPreferences != null) {
            string3 = sharedPreferences.getString(string2, string3);
        }
        return string3;
    }

    public ContentValues read() {
        boolean bl2;
        Object object = this.a;
        ContentValues contentValues = null;
        if (object == null) {
            return null;
        }
        if ((object = object.getAll()) == null) {
            return null;
        }
        contentValues = new ContentValues();
        object = object.entrySet().iterator();
        while (bl2 = object.hasNext()) {
            Object object2 = (Map.Entry)object.next();
            String string2 = (String)object2.getKey();
            boolean bl3 = (object2 = object2.getValue()) instanceof String;
            if (bl3) {
                object2 = String.valueOf(object2);
                contentValues.put(string2, (String)object2);
                continue;
            }
            bl3 = object2 instanceof Integer;
            if (!(bl3 || (bl3 = object2 instanceof Short) || (bl3 = object2 instanceof Byte))) {
                bl3 = object2 instanceof Long;
                if (bl3) {
                    object2 = (Long)object2;
                    contentValues.put(string2, (Long)object2);
                    continue;
                }
                bl3 = object2 instanceof Float;
                if (bl3) {
                    object2 = (Float)object2;
                    contentValues.put(string2, (Float)object2);
                    continue;
                }
                bl3 = object2 instanceof Double;
                if (bl3) {
                    double d10 = (Double)object2;
                    float f10 = (float)d10;
                    object2 = Float.valueOf(f10);
                    contentValues.put(string2, (Float)object2);
                    continue;
                }
                bl3 = object2 instanceof Boolean;
                if (!bl3) continue;
                object2 = (Boolean)object2;
                contentValues.put(string2, (Boolean)object2);
                continue;
            }
            object2 = (Integer)object2;
            contentValues.put(string2, (Integer)object2);
        }
        return contentValues;
    }

    public boolean removeKey(String string2) {
        boolean bl2;
        SharedPreferences sharedPreferences = this.a;
        if (sharedPreferences != null && (bl2 = sharedPreferences.contains(string2)) && (sharedPreferences = this.a.edit()) != null) {
            return sharedPreferences.remove(string2).commit();
        }
        return false;
    }

    public boolean removeKey(String[] stringArray) {
        SharedPreferences sharedPreferences = this.a;
        if (sharedPreferences == null) {
            return false;
        }
        int n10 = stringArray.length;
        for (int i10 = 0; i10 < n10; ++i10) {
            SharedPreferences sharedPreferences2 = this.a;
            String string2 = stringArray[i10];
            boolean bl2 = sharedPreferences2.contains(string2);
            if (!bl2) continue;
            sharedPreferences2 = this.a.edit();
            sharedPreferences2.remove(string2);
        }
        this.a.edit().commit();
        return true;
    }

    public boolean save(String string2, Object object) {
        SharedPreferences sharedPreferences = this.a;
        if (sharedPreferences == null) {
            return false;
        }
        sharedPreferences = sharedPreferences.edit();
        boolean bl2 = object instanceof String;
        if (bl2) {
            object = String.valueOf(object);
            sharedPreferences.putString(string2, (String)object);
        } else {
            bl2 = object instanceof Integer;
            if (bl2) {
                object = (Integer)object;
                int n10 = (Integer)object;
                sharedPreferences.putInt(string2, n10);
            } else {
                bl2 = object instanceof Short;
                if (bl2) {
                    object = (Short)object;
                    short s10 = (Short)object;
                    sharedPreferences.putInt(string2, (int)s10);
                } else {
                    bl2 = object instanceof Byte;
                    if (bl2) {
                        object = (Byte)object;
                        byte by2 = (Byte)object;
                        sharedPreferences.putInt(string2, (int)by2);
                    } else {
                        bl2 = object instanceof Long;
                        if (bl2) {
                            object = (Long)object;
                            long l10 = (Long)object;
                            sharedPreferences.putLong(string2, l10);
                        } else {
                            bl2 = object instanceof Float;
                            if (bl2) {
                                object = (Float)object;
                                float f10 = ((Float)object).floatValue();
                                sharedPreferences.putFloat(string2, f10);
                            } else {
                                bl2 = object instanceof Double;
                                if (bl2) {
                                    object = (Double)object;
                                    double d10 = (Double)object;
                                    float f11 = (float)d10;
                                    sharedPreferences.putFloat(string2, f11);
                                } else {
                                    bl2 = object instanceof Boolean;
                                    if (bl2) {
                                        object = (Boolean)object;
                                        boolean bl3 = (Boolean)object;
                                        sharedPreferences.putBoolean(string2, bl3);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return sharedPreferences.commit();
    }

    public void saveBoolean(String string2, boolean bl2) {
        SharedPreferences sharedPreferences = this.a;
        if (sharedPreferences == null) {
            return;
        }
        if ((sharedPreferences = sharedPreferences.edit()) != null) {
            string2 = sharedPreferences.putBoolean(string2, bl2);
            string2.commit();
        }
    }

    public void saveInt(String string2, Integer n10) {
        SharedPreferences sharedPreferences = this.a;
        if (sharedPreferences == null) {
            return;
        }
        if ((sharedPreferences = sharedPreferences.edit()) != null) {
            int n11 = n10;
            string2 = sharedPreferences.putInt(string2, n11);
            string2.commit();
        }
    }

    public void saveLong(String string2, Long l10) {
        SharedPreferences sharedPreferences = this.a;
        if (sharedPreferences == null) {
            return;
        }
        if ((sharedPreferences = sharedPreferences.edit()) != null) {
            long l11 = l10;
            string2 = sharedPreferences.putLong(string2, l11);
            string2.commit();
        }
    }

    public void saveMap(Map object) {
        boolean bl2;
        object = object.entrySet().iterator();
        while (bl2 = object.hasNext()) {
            Map.Entry entry = (Map.Entry)object.next();
            String string2 = (String)entry.getKey();
            entry = entry.getValue();
            this.save(string2, entry);
        }
    }

    public boolean saveString(String string2, String string3) {
        SharedPreferences sharedPreferences = this.a;
        if (sharedPreferences == null) {
            return false;
        }
        if ((sharedPreferences = sharedPreferences.edit()) != null) {
            return sharedPreferences.putString(string2, string3).commit();
        }
        return false;
    }

    public boolean write(ContentValues object) {
        SharedPreferences sharedPreferences = this.a;
        if (sharedPreferences != null && object != null) {
            boolean bl2;
            boolean bl3 = true;
            object = object.valueSet().iterator();
            while (bl2 = object.hasNext()) {
                Map.Entry entry = (Map.Entry)object.next();
                String string2 = (String)entry.getKey();
                bl2 = this.save(string2, entry = entry.getValue());
                if (bl2) continue;
                bl3 = false;
                sharedPreferences = null;
            }
            return bl3;
        }
        return false;
    }
}

