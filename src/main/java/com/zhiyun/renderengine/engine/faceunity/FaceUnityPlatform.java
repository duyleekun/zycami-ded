/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 */
package com.zhiyun.renderengine.engine.faceunity;

import android.content.Context;
import android.text.TextUtils;
import com.faceunity.wrapper.faceunity;
import com.zhiyun.renderengine.engine.faceunity.FaceUnityPlatform$Key;
import d.v.b0.i.d;
import d.v.b0.j.b;
import d.v.b0.j.e;
import java.util.HashMap;
import java.util.Map;

public class FaceUnityPlatform {
    private static final String a = "model/ai_face_processor.bundle";
    private static final String b = "graphics/face_beautification.bundle";
    private static boolean c = false;
    private static boolean d = false;
    private static Map e;
    private static Map f;

    static {
        HashMap hashMap;
        e = hashMap = new HashMap();
        f = hashMap = new HashMap();
    }

    public static void a(FaceUnityPlatform$Key faceUnityPlatform$Key, String string2) {
        boolean bl2;
        if (faceUnityPlatform$Key != null && !(bl2 = TextUtils.isEmpty((CharSequence)string2))) {
            e.put(faceUnityPlatform$Key, string2);
            return;
        }
        d.v.b0.j.b.c("FaceUnityPlatform, addModelPath ,  modelKey or modelPath can not be null.");
    }

    private static int b(Context object) {
        int n10;
        Object object2 = f;
        Object object3 = FaceUnityPlatform$Key.KEY_FACE_BEAUTIFUL;
        if ((object2 = (Integer)object2.get(object3)) == null) {
            n10 = 0;
            object2 = null;
        } else {
            n10 = (Integer)object2;
        }
        if (n10 == 0) {
            long l10 = System.currentTimeMillis();
            Object object4 = d.v.b0.j.e.c((Context)object, b);
            String string2 = " byte";
            String string3 = " ms   memory:";
            if (object4 != null) {
                CharSequence charSequence = new StringBuilder();
                String string4 = "FaceUnityBeautyEffect ,read face_beautification.bundle(assets) costum: ";
                charSequence.append(string4);
                long l11 = System.currentTimeMillis() - l10;
                charSequence.append(l11);
                charSequence.append(string3);
                int n11 = ((byte[])object4).length;
                charSequence.append(n11);
                charSequence.append(string2);
                charSequence = charSequence.toString();
                d.v.b0.j.b.c((String)charSequence);
            }
            if (object4 == null) {
                long l12 = System.currentTimeMillis();
                object4 = (String)e.get(object3);
                if ((object4 = d.v.b0.j.e.d((Context)object, (String)object4)) != null) {
                    object = new StringBuilder();
                    String string5 = "FaceUnityBeautyEffect ,read face_beautification.bundle(sdcard) costum: ";
                    ((StringBuilder)object).append(string5);
                    long l13 = System.currentTimeMillis() - l12;
                    ((StringBuilder)object).append(l13);
                    ((StringBuilder)object).append(string3);
                    int n12 = ((byte[])object4).length;
                    ((StringBuilder)object).append(n12);
                    ((StringBuilder)object).append(string2);
                    object = ((StringBuilder)object).toString();
                    d.v.b0.j.b.c((String)object);
                }
            }
            if (object4 != null) {
                int n13 = FaceUnityPlatform.c(object4);
                object2 = f;
                object4 = n13;
                object2.put(object3, object4);
                object2 = new StringBuilder();
                ((StringBuilder)object2).append("FaceUnityBeautyEffect ,create face beautiful handle costum: ");
                long l14 = System.currentTimeMillis() - l10;
                ((StringBuilder)object2).append(l14);
                object3 = " ms  face beautiful handle:";
                ((StringBuilder)object2).append((String)object3);
                ((StringBuilder)object2).append(n13);
                object2 = ((StringBuilder)object2).toString();
                d.v.b0.j.b.c((String)object2);
                n10 = n13;
            }
        } else {
            object = "FaceUnityBeautyEffect ,create face beautiful handle costum: 0 ms";
            d.v.b0.j.b.c((String)object);
        }
        return n10;
    }

    private static int c(byte[] byArray) {
        int n10;
        int n11 = byArray != null && (n10 = byArray.length) > 0 ? faceunity.fuCreateItemFromPackage(byArray) : -999;
        return n11;
    }

    public static void d() {
        int n10;
        Object object = f;
        FaceUnityPlatform$Key faceUnityPlatform$Key = FaceUnityPlatform$Key.KEY_FACE_BEAUTIFUL;
        object = (Integer)object.get((Object)faceUnityPlatform$Key);
        Integer n11 = null;
        if (object == null) {
            n10 = 0;
            object = null;
        } else {
            n10 = (Integer)object;
        }
        if (n10 != 0) {
            FaceUnityPlatform.e(n10);
            object = f;
            n11 = 0;
            object.put(faceUnityPlatform$Key, n11);
        }
    }

    private static void e(int n10) {
        faceunity.fuDestroyItem(n10);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("FaceUnityBeautyEffect, destroyEffectHandle , handle: ");
        stringBuilder.append(n10);
        d.v.b0.j.b.c(stringBuilder.toString());
    }

    public static void f() {
        Object object;
        long l10 = System.currentTimeMillis();
        int n10 = c;
        if (n10 == 0) {
            object = new byte[0];
            Object object2 = d.v.b0.i.d.a();
            n10 = faceunity.fuSetup((byte[])object, (byte[])object2);
            object2 = new StringBuilder;
            ((StringBuilder)object2)();
            String string2 = "faceunity.fuSetup, isSetup:";
            ((StringBuilder)object2).append(string2);
            ((StringBuilder)object2).append(n10);
            string2 = n10 == 0 ? "no" : "yes";
            ((StringBuilder)object2).append(string2);
            object2 = ((StringBuilder)object2).toString();
            d.v.b0.j.b.c((String)object2);
            int n11 = 1;
            if (n10 == n11) {
                c = n11;
            }
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("fuSetup. isSetup: consum: ");
        long l11 = System.currentTimeMillis() - l10;
        ((StringBuilder)object).append(l11);
        ((StringBuilder)object).append(" ms   initLicense:");
        boolean bl2 = c;
        ((StringBuilder)object).append(bl2);
        d.v.b0.j.b.c(((StringBuilder)object).toString());
    }

    public static void g(byte[] object) {
        long l10 = System.currentTimeMillis();
        int n10 = c;
        if (n10 == 0) {
            n10 = 0;
            int n11 = faceunity.fuSetup(new byte[0], (byte[])object);
            CharSequence charSequence = new StringBuilder();
            String string2 = "faceunity.fuSetup, isSetup:";
            charSequence.append(string2);
            charSequence.append(n11);
            string2 = n11 == 0 ? "no" : "yes";
            charSequence.append(string2);
            charSequence = charSequence.toString();
            d.v.b0.j.b.c((String)charSequence);
            n10 = 1;
            if (n11 == n10) {
                c = n10;
            }
        }
        object = new StringBuilder;
        ((StringBuilder)object)();
        ((StringBuilder)object).append("fuSetup. isSetup: consum: ");
        long l11 = System.currentTimeMillis() - l10;
        ((StringBuilder)object).append(l11);
        ((StringBuilder)object).append(" ms   initLicense:");
        boolean bl2 = c;
        ((StringBuilder)object).append(bl2);
        d.v.b0.j.b.c(((StringBuilder)object).toString());
    }

    private static int h(Context object, String charSequence, int n10, boolean bl2, String string2) {
        int n11;
        String string3;
        long l10 = System.currentTimeMillis();
        object = bl2 ? (Object)d.v.b0.j.e.c((Context)object, (String)charSequence) : (Object)d.v.b0.j.e.d((Context)object, string3);
        if (object != null) {
            charSequence = new StringBuilder();
            string3 = "FaceUnityEngine , read ai model";
            ((StringBuilder)charSequence).append(string3);
            String string4 = bl2 ? "(assets)" : "(sdcard)";
            ((StringBuilder)charSequence).append(string4);
            ((StringBuilder)charSequence).append(" consum: ");
            long l11 = System.currentTimeMillis() - l10;
            ((StringBuilder)charSequence).append(l11);
            ((StringBuilder)charSequence).append(" ms   memory:");
            int n12 = ((Context)object).length;
            ((StringBuilder)charSequence).append(n12);
            string4 = " byte";
            ((StringBuilder)charSequence).append(string4);
            charSequence = ((StringBuilder)charSequence).toString();
            d.v.b0.j.b.c((String)charSequence);
        }
        if (object != null) {
            n11 = faceunity.fuLoadAIModelFromPackage((byte[])object, n10);
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append("FaceUnityEngine , init ai model consum: ");
            long l12 = System.currentTimeMillis() - l10;
            ((StringBuilder)charSequence).append(l12);
            String string5 = " ms";
            ((StringBuilder)charSequence).append(string5);
            charSequence = ((StringBuilder)charSequence).toString();
            d.v.b0.j.b.c((String)charSequence);
        } else {
            n11 = -999;
        }
        return n11;
    }

    private static int i(Context object) {
        boolean bl2 = d;
        int n10 = 1;
        if (!bl2) {
            FaceUnityPlatform$Key faceUnityPlatform$Key;
            int n11;
            String string2 = a;
            int n12 = 1024;
            Object object2 = "";
            int n13 = FaceUnityPlatform.h((Context)object, string2, n12, n10 != 0, (String)object2);
            int n14 = 0;
            if (n13 == n10) {
                n11 = n10;
            } else {
                n11 = 0;
                faceUnityPlatform$Key = null;
            }
            d = n11;
            if (n11 == 0) {
                object2 = e;
                faceUnityPlatform$Key = FaceUnityPlatform$Key.KEY_FACE_AI;
                n13 = FaceUnityPlatform.h((Context)object, string2, n12, false, (String)(object2 = (String)object2.get((Object)faceUnityPlatform$Key)));
                if (n13 == n10) {
                    n14 = n10;
                }
                d = n14;
            }
            object = new StringBuilder();
            string2 = "FaceUnityEngine , load and init ai model  ";
            ((StringBuilder)object).append(string2);
            string2 = n13 == n10 ? "success" : "fail";
            ((StringBuilder)object).append(string2);
            d.v.b0.j.b.c(((StringBuilder)object).toString());
            return n13;
        }
        d.v.b0.j.b.c("FaceUnityEngine , load and init ai model(success) consum: 0 ms");
        return n10;
    }

    public static int j(Context context, FaceUnityPlatform$Key faceUnityPlatform$Key) {
        int n10 = -1;
        if (context != null && faceUnityPlatform$Key != null) {
            FaceUnityPlatform$Key faceUnityPlatform$Key2 = FaceUnityPlatform$Key.KEY_FACE_AI;
            if (faceUnityPlatform$Key == faceUnityPlatform$Key2) {
                return FaceUnityPlatform.i(context);
            }
            faceUnityPlatform$Key2 = FaceUnityPlatform$Key.KEY_FACE_BEAUTIFUL;
            if (faceUnityPlatform$Key == faceUnityPlatform$Key2) {
                return FaceUnityPlatform.b(context);
            }
            return n10;
        }
        d.v.b0.j.b.c("FaceUnityPlatform , loadModel , context or modelKey  can not be null.");
        return n10;
    }

    public static int k(Context context, FaceUnityPlatform$Key faceUnityPlatform$Key, String string2) {
        FaceUnityPlatform.a(faceUnityPlatform$Key, string2);
        return FaceUnityPlatform.j(context, faceUnityPlatform$Key);
    }

    private static int l(int n10) {
        int n11;
        int n12 = faceunity.fuIsAIModelLoaded(n10);
        if (n12 == (n11 = 1)) {
            if ((n10 = faceunity.fuReleaseAIModel(n10)) == 0) {
                String string2 = "FaceUnityEngine , faceunity unload ai model fail.";
                d.v.b0.j.b.c(string2);
            }
        } else {
            String string3 = "FaceUnityEngine , faceunity model not be loaded.";
            d.v.b0.j.b.c(string3);
            n10 = -999;
        }
        return n10;
    }

    private static void m() {
        FaceUnityPlatform.l(1024);
    }
}

