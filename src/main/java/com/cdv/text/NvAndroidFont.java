/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.AssetManager
 *  android.graphics.Typeface
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.text.TextPaint
 *  android.util.Log
 *  android.util.LruCache
 */
package com.cdv.text;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.os.Build;
import android.text.TextPaint;
import android.util.Log;
import android.util.LruCache;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class NvAndroidFont {
    private static final String TAG = "NvAndroidFont";
    private static final boolean m_forceUseOldTypeFrace = false;
    private static final LruCache m_typefaceCache;
    private static final ReentrantReadWriteLock m_typefaceLock;
    private static final Object m_typefaceMutex;
    private static final boolean m_verbose = false;

    static {
        Object object;
        m_forceUseOldTypeFrace = NvAndroidFont.forceUseOldTypeFrace();
        m_typefaceMutex = object = new Object();
        object = new LruCache(16);
        m_typefaceCache = object;
        m_typefaceLock = object = new ReentrantReadWriteLock();
    }

    public static TextPaint createTextPaint(Typeface object, float f10, int n10, boolean bl2, float f11, boolean bl3) {
        float f12;
        float f13;
        float f14;
        int n11;
        int n12;
        int n13;
        int n14;
        String string2;
        TextPaint textPaint;
        block22: {
            block21: {
                int n15;
                block20: {
                    try {
                        textPaint = new TextPaint();
                    }
                    catch (Exception exception) {
                        CharSequence charSequence = new StringBuilder();
                        charSequence.append("");
                        string2 = exception.getMessage();
                        charSequence.append(string2);
                        charSequence = charSequence.toString();
                        Log.e((String)TAG, (String)charSequence);
                        exception.printStackTrace();
                        return null;
                    }
                    textPaint.setHinting(0);
                    textPaint.setTypeface(object);
                    textPaint.setTextSize(f10);
                    n14 = Build.VERSION.SDK_INT;
                    n13 = 21;
                    n12 = 1;
                    if (n14 < n13) break block20;
                    textPaint.setElegantTextHeight(n12 != 0);
                }
                if (n10 > (n15 = 500)) {
                    n10 = (int)(object.isBold() ? 1 : 0);
                    if (n10 != 0) break block21;
                    textPaint.setFakeBoldText(n12 != 0);
                }
            }
            if (bl2) {
                n11 = (int)(object.isItalic() ? 1 : 0);
                if (n11 != 0) break block22;
                n11 = -1098907648;
                f14 = -0.25f;
                textPaint.setTextSkewX(f14);
            }
        }
        n11 = 1120403456;
        f14 = 100.0f;
        n10 = 0;
        string2 = null;
        if (bl3 && (bl2 = (f13 = f11 - 0.0f) == 0.0f ? 0 : (f13 > 0.0f ? 1 : -1)) || !bl3 && (bl2 = f11 == f14 ? 0 : (f11 > f14 ? 1 : -1))) {
            if (bl3) {
                object = "X";
                f14 = textPaint.measureText((String)object, 0, n12);
            } else {
                f11 -= f14;
            }
            f11 /= f14;
        } else {
            f11 = 0.0f;
        }
        n11 = (int)((f12 = f11 - 0.0f) == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1));
        if (n11 != 0 && n14 >= n13) {
            textPaint.setLetterSpacing(f11);
        }
        return textPaint;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static Typeface createTypeface(String string2, int n10, boolean bl2) {
        Exception exception2;
        block5: {
            int n11;
            block4: {
                if (string2 != null) {
                    try {
                        n11 = string2.isEmpty();
                        if (n11 == 0) break block4;
                    }
                    catch (Exception exception2) {
                        break block5;
                    }
                }
                string2 = null;
            }
            if ((string2 = Typeface.create((String)string2, (int)(n11 = NvAndroidFont.getTypefaceStyle(n10, bl2)))) == null) {
                return null;
            }
            n11 = Build.VERSION.SDK_INT;
            int n12 = 28;
            if (n11 < n12) return string2;
            n11 = (int)(m_forceUseOldTypeFrace ? 1 : 0);
            if (n11 == 0) return Typeface.create((Typeface)string2, (int)n10, (boolean)bl2);
            return string2;
        }
        CharSequence charSequence = new StringBuilder();
        charSequence.append("");
        String string3 = exception2.getMessage();
        charSequence.append(string3);
        charSequence = charSequence.toString();
        Log.e((String)TAG, (String)charSequence);
        exception2.printStackTrace();
        return null;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static Typeface createTypefaceFromFile(Context object, String object2, boolean bl2, int n10, boolean bl3) {
        try {
            ReentrantReadWriteLock reentrantReadWriteLock = m_typefaceLock;
            ReentrantReadWriteLock.ReadLock readLock = reentrantReadWriteLock.readLock();
            readLock.lock();
            readLock = m_typefaceCache;
            Object object3 = readLock.get(object2);
            object3 = (Typeface)object3;
            ReentrantReadWriteLock.ReadLock readLock2 = reentrantReadWriteLock.readLock();
            readLock2.unlock();
            if (object3 == null) {
                object3 = "assets:/";
                int n11 = ((String)object2).startsWith((String)object3);
                if (n11 != 0) {
                    object = object.getAssets();
                    n11 = 8;
                    object3 = ((String)object2).substring(n11);
                    object = Typeface.createFromAsset((AssetManager)object, (String)object3);
                } else {
                    object = Typeface.createFromFile((String)object2);
                }
                object3 = object;
                if (object != null) {
                    object = reentrantReadWriteLock.writeLock();
                    ((ReentrantReadWriteLock.WriteLock)object).lock();
                    readLock.put(object2, object3);
                    object = reentrantReadWriteLock.writeLock();
                    ((ReentrantReadWriteLock.WriteLock)object).unlock();
                }
            }
            if (!bl2) {
                return object3;
            }
            int n12 = Build.VERSION.SDK_INT;
            int n13 = 28;
            if (n12 >= n13 && (n12 = (int)(m_forceUseOldTypeFrace ? 1 : 0)) == 0) {
                return Typeface.create((Typeface)object3, (int)n10, (boolean)bl3);
            }
            n12 = NvAndroidFont.getTypefaceStyle(n10, bl3);
            object2 = m_typefaceMutex;
            synchronized (object2) {
                return Typeface.create((Typeface)object3, (int)n12);
            }
        }
        catch (Exception exception) {
            CharSequence charSequence = new StringBuilder();
            charSequence.append("");
            String string2 = exception.getMessage();
            charSequence.append(string2);
            charSequence = charSequence.toString();
            Log.e((String)TAG, (String)charSequence);
            exception.printStackTrace();
            return null;
        }
    }

    private static boolean forceUseOldTypeFrace() {
        String string2 = Build.MANUFACTURER;
        String string3 = "OnePlus";
        boolean bl2 = string2.equals(string3);
        boolean bl3 = true;
        if (bl2) {
            string2 = Build.MODEL;
            string3 = "IN2010";
            bl2 = string2.equals(string3);
            if (bl2) {
                return bl3;
            }
            string3 = "A5010";
            bl2 = string2.equals(string3);
            if (bl2) {
                return bl3;
            }
            string3 = "A6000";
            boolean bl4 = string2.equals(string3);
            if (bl4) {
                return bl3;
            }
        } else {
            string3 = "OPPO";
            boolean bl5 = string2.equals(string3);
            if (bl5) {
                string2 = Build.MODEL;
                string3 = "PBCM30";
                bl2 = string2.equals(string3);
                if (bl2) {
                    return bl3;
                }
                string3 = "PCGM00";
                bl2 = string2.equals(string3);
                if (bl2) {
                    return bl3;
                }
                string3 = "A92s";
                bl5 = string2.equals(string3);
                if (bl5) {
                    return bl3;
                }
            }
        }
        return false;
    }

    private static int getTypefaceStyle(int n10, boolean bl2) {
        int n11 = 500;
        n10 = n10 > n11 ? 1 : 0;
        if (bl2) {
            n10 |= 2;
        }
        return n10;
    }

    public static float measureCharWidth(TextPaint textPaint, char c10) {
        char[] cArray;
        int n10 = 1;
        try {
            cArray = new char[n10];
        }
        catch (Exception exception) {
            return 0.0f;
        }
        cArray[0] = c10;
        return textPaint.measureText(cArray, 0, n10);
    }
}

