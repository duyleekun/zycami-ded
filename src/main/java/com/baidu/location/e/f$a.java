/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Build
 *  android.os.Build$VERSION
 *  org.json.JSONObject
 */
package com.baidu.location.e;

import android.content.Context;
import android.os.Build;
import com.baidu.location.Jni;
import com.baidu.location.e.f;
import com.baidu.location.e.f$1;
import com.baidu.location.e.g;
import com.baidu.location.e.h;
import com.baidu.location.g.a;
import com.baidu.location.h.b;
import com.baidu.location.h.l;
import java.io.File;
import java.io.FileWriter;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Locale;
import java.util.Scanner;
import org.json.JSONObject;

public final class f$a
extends com.baidu.location.h.f {
    public final /* synthetic */ f a;
    private int b = 0;
    private long c;
    private long d;
    private boolean e = false;
    private final String f;

    private f$a(f object) {
        Cloneable cloneable;
        long l10;
        this.a = object;
        this.c = l10 = (long)-1;
        this.d = l10;
        this.k = cloneable = new Cloneable();
        cloneable = Locale.US;
        object = com.baidu.location.h.b.a().c;
        object = com.baidu.location.h.b.f;
        object = com.baidu.location.h.b.e;
        object = Float.valueOf(8.4f);
        Object[] objectArray = new Object[]{"1", object, object, object, object, object = Build.MODEL, object = Build.VERSION.SDK};
        this.f = object = Jni.encodeOfflineLocationUpdateRequest(String.format(cloneable, "&ver=%s&cuid=%s&prod=%s:%s&sdk=%.2f&mb=%s&os=A%s", objectArray));
    }

    public /* synthetic */ f$a(f f10, f$1 f$1) {
        this(f10);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void a() {
        long l10;
        long l11;
        Object object;
        boolean bl2;
        Object object2;
        Object object3;
        String string2;
        f$a f$a;
        block27: {
            Object object4;
            block26: {
                f$a = this;
                string2 = "minapn";
                Object object5 = "onlt";
                object3 = "oflp";
                object2 = "poiup";
                Object object6 = "addrup";
                Object object7 = "rgcon";
                Object object8 = "rgcgp";
                String string3 = "cplist";
                Object object9 = "ol";
                bl2 = this.e;
                if (bl2) {
                    return;
                }
                long l12 = -1;
                try {
                    long l13;
                    long l14;
                    long l15;
                    Object object10 = this.a;
                    object10 = com.baidu.location.e.f.v((f)object10);
                    object10 = ((h)object10).c();
                    object4 = "ofl.config";
                    File file = new File((File)object10, (String)object4);
                    long l16 = this.d;
                    bl2 = l16 == l12 ? 0 : (l16 < l12 ? -1 : 1);
                    if (!bl2 && (bl2 = file.exists())) {
                        boolean bl3;
                        boolean bl4;
                        int n10;
                        boolean bl5;
                        int n11;
                        boolean bl6;
                        object4 = new Scanner(file);
                        Object object11 = ((Scanner)object4).next();
                        ((Scanner)object4).close();
                        object4 = new JSONObject((String)object11);
                        object11 = this.a;
                        boolean bl7 = object4.getBoolean((String)object9);
                        com.baidu.location.e.f.a((f)object11, bl7);
                        object11 = this.a;
                        object10 = "fl";
                        bl7 = object4.getBoolean((String)object10);
                        com.baidu.location.e.f.b((f)object11, bl7);
                        object11 = this.a;
                        object10 = "on";
                        bl7 = object4.getBoolean((String)object10);
                        com.baidu.location.e.f.c((f)object11, bl7);
                        object11 = this.a;
                        object10 = "wn";
                        bl7 = object4.getBoolean((String)object10);
                        com.baidu.location.e.f.d((f)object11, bl7);
                        object11 = this.a;
                        object10 = "oc";
                        bl7 = object4.getBoolean((String)object10);
                        com.baidu.location.e.f.e((f)object11, bl7);
                        object11 = "t";
                        this.d = l12 = object4.getLong((String)object11);
                        boolean bl8 = object4.has((String)object9);
                        if (bl8) {
                            object9 = this.a;
                            object11 = "olv2";
                            boolean bl9 = object4.getBoolean((String)object11);
                            com.baidu.location.e.f.g((f)object9, bl9);
                        }
                        if (bl8 = object4.has(string3)) {
                            object9 = f$a.a;
                            String string4 = object4.getString(string3);
                            object11 = ";";
                            String[] stringArray = string4.split((String)object11);
                            com.baidu.location.e.f.a((f)object9, stringArray);
                        }
                        if (bl6 = object4.has((String)object8)) {
                            f f10 = f$a.a;
                            n11 = object4.getInt((String)object8);
                            com.baidu.location.e.f.a(f10, n11);
                        }
                        if ((n11 = object4.has((String)object7)) != 0) {
                            object8 = f$a.a;
                            bl5 = object4.getBoolean((String)object7);
                            com.baidu.location.e.f.f((f)object8, bl5);
                        }
                        if (bl5 = object4.has((String)object6)) {
                            object7 = f$a.a;
                            l15 = object4.getInt((String)object6);
                            com.baidu.location.e.f.b((f)object7, (int)l15);
                        }
                        if ((l15 = (long)object4.has((String)object2)) != false) {
                            object6 = f$a.a;
                            n10 = object4.getInt((String)object2);
                            com.baidu.location.e.f.c((f)object6, n10);
                        }
                        n10 = object4.has((String)object3);
                        object6 = "4";
                        object7 = "3";
                        object8 = "2";
                        String string5 = "1";
                        object9 = "0";
                        if (n10 != 0) {
                            double d10;
                            n10 = (int)((object3 = object4.getJSONObject((String)object3)).has((String)object9) ? 1 : 0);
                            if (n10 != 0) {
                                object2 = f$a.a;
                                d10 = object3.getDouble((String)object9);
                                com.baidu.location.e.f.a((f)object2, d10);
                            }
                            if ((n10 = (int)(object3.has(string5) ? 1 : 0)) != 0) {
                                object2 = f$a.a;
                                d10 = object3.getDouble(string5);
                                com.baidu.location.e.f.b((f)object2, d10);
                            }
                            if ((n10 = (int)(object3.has((String)object8) ? 1 : 0)) != 0) {
                                object2 = f$a.a;
                                d10 = object3.getDouble((String)object8);
                                com.baidu.location.e.f.c((f)object2, d10);
                            }
                            if ((n10 = (int)(object3.has((String)object7) ? 1 : 0)) != 0) {
                                object2 = f$a.a;
                                d10 = object3.getDouble((String)object7);
                                com.baidu.location.e.f.d((f)object2, d10);
                            }
                            if ((n10 = (int)(object3.has((String)object6) ? 1 : 0)) != 0) {
                                object2 = f$a.a;
                                d10 = object3.getDouble((String)object6);
                                com.baidu.location.e.f.e((f)object2, d10);
                            }
                        }
                        if (bl4 = object4.has((String)object5)) {
                            bl4 = (object5 = object4.getJSONObject((String)object5)).has((String)object9);
                            if (bl4) {
                                object3 = f$a.a;
                                long l17 = object5.getLong((String)object9);
                                com.baidu.location.e.f.a((f)object3, l17);
                            }
                            if (bl4 = object5.has(string5)) {
                                object3 = f$a.a;
                                long l18 = object5.getLong(string5);
                                com.baidu.location.e.f.b((f)object3, l18);
                            }
                            if (bl4 = object5.has((String)object8)) {
                                object3 = f$a.a;
                                long l19 = object5.getLong((String)object8);
                                com.baidu.location.e.f.c((f)object3, l19);
                            }
                            if (bl4 = object5.has((String)object7)) {
                                object3 = f$a.a;
                                long l20 = object5.getLong((String)object7);
                                com.baidu.location.e.f.d((f)object3, l20);
                            }
                            if (bl4 = object5.has((String)object6)) {
                                object3 = f$a.a;
                                long l21 = object5.getLong((String)object6);
                                com.baidu.location.e.f.e((f)object3, l21);
                            }
                        }
                        if (bl3 = object4.has(string2)) {
                            object5 = f$a.a;
                            object = object4.getInt(string2);
                            com.baidu.location.e.f.d((f)object5, (int)object);
                        }
                    }
                    if ((object = (l14 = (l11 = f$a.d) - (l10 = (long)-1)) == 0L ? 0 : (l14 < 0L ? -1 : 1)) == false) {
                        file.exists();
                    }
                    if ((l15 = (l13 = (l11 = f$a.d) - l10) == 0L ? 0 : (l13 < 0L ? -1 : 1)) == false) break block26;
                    l10 = 86400000L;
                    long l22 = (l11 += l10) - (l10 = System.currentTimeMillis());
                    object = l22 == 0L ? 0 : (l22 < 0L ? -1 : 1);
                    if (object > 0) break block26;
                    bl2 = true;
                    break block27;
                }
                catch (Exception exception) {}
            }
            bl2 = false;
            object4 = null;
        }
        l11 = f$a.d;
        l10 = -1;
        object = l11 == l10 ? 0 : (l11 < l10 ? -1 : 1);
        if ((object == false || bl2) && (object = (Object)this.c()) != false && (object = (Object)com.baidu.location.h.l.a((Context)(string2 = com.baidu.location.e.f.v(f$a.a).b()))) != false) {
            f$a.e = true;
            object = com.baidu.location.h.l.b();
            if (object == false) {
                l11 = 1000L;
                object3 = com.baidu.location.g.a.a();
                object2 = new g(f$a);
                object3.postDelayed((Runnable)object2, l11);
            }
        }
    }

    public static /* synthetic */ void a(f$a f$a) {
        f$a.a();
    }

    private boolean c() {
        int n10 = this.b;
        boolean bl2 = true;
        int n11 = 2;
        if (n10 >= n11) {
            long l10 = this.c + 86400000L;
            long l11 = System.currentTimeMillis();
            long l12 = l10 - l11;
            n10 = (int)(l12 == 0L ? 0 : (l12 < 0L ? -1 : 1));
            if (n10 < 0) {
                long l13;
                this.b = 0;
                this.c = l13 = (long)-1;
            } else {
                bl2 = false;
            }
        }
        return bl2;
    }

    public void a(boolean bl2) {
        block192: {
            long l10;
            int n10;
            int n11;
            String string2;
            f$a f$a = this;
            Object object = "ofl";
            Object object2 = "ver";
            Object object3 = "cplist";
            int n12 = 1;
            if (bl2 && (string2 = this.j) != null) {
                Object object4;
                block191: {
                    double d10;
                    String string3;
                    String string4;
                    String string5;
                    String string6;
                    String string7;
                    String string8;
                    String string9;
                    String string10;
                    String string11;
                    Object object5;
                    Object object6;
                    Object object7;
                    block190: {
                        String string12;
                        String string13;
                        block173: {
                            block185: {
                                int n13;
                                long l11;
                                block189: {
                                    block188: {
                                        block187: {
                                            block186: {
                                                block184: {
                                                    block178: {
                                                        block183: {
                                                            block182: {
                                                                block181: {
                                                                    block180: {
                                                                        block179: {
                                                                            block177: {
                                                                                block176: {
                                                                                    block175: {
                                                                                        block174: {
                                                                                            block172: {
                                                                                                block171: {
                                                                                                    long l12;
                                                                                                    long l13;
                                                                                                    long l14;
                                                                                                    long l15;
                                                                                                    long l16;
                                                                                                    long l17;
                                                                                                    long l18;
                                                                                                    long l19;
                                                                                                    block170: {
                                                                                                        block169: {
                                                                                                            block168: {
                                                                                                                object7 = new JSONObject(string2);
                                                                                                                l19 = 0L;
                                                                                                                boolean bl4 = object7.has((String)object);
                                                                                                                if (!bl4) break block168;
                                                                                                                l19 = object7.getLong((String)object);
                                                                                                            }
                                                                                                            n11 = (int)(object7.has((String)object2) ? 1 : 0);
                                                                                                            string2 = "1";
                                                                                                            if (n11 == 0) break block169;
                                                                                                            object = object7.getString((String)object2);
                                                                                                            break block170;
                                                                                                        }
                                                                                                        object = string2;
                                                                                                    }
                                                                                                    long l20 = 1L;
                                                                                                    l11 = l19 & l20;
                                                                                                    long l21 = l11 == l20 ? 0 : (l11 < l20 ? -1 : 1);
                                                                                                    if (l21 == false) {
                                                                                                        object6 = f$a.a;
                                                                                                        com.baidu.location.e.f.a((f)object6, n12 != 0);
                                                                                                    }
                                                                                                    if ((l21 = (l18 = (l11 = l19 & (l20 = (long)2)) - l20) == 0L ? 0 : (l18 < 0L ? -1 : 1)) == false) {
                                                                                                        object6 = f$a.a;
                                                                                                        com.baidu.location.e.f.b((f)object6, n12 != 0);
                                                                                                    }
                                                                                                    if ((l21 = (l17 = (l11 = l19 & (l20 = (long)4)) - l20) == 0L ? 0 : (l17 < 0L ? -1 : 1)) == false) {
                                                                                                        object6 = f$a.a;
                                                                                                        com.baidu.location.e.f.c((f)object6, n12 != 0);
                                                                                                    }
                                                                                                    if ((l21 = (l16 = (l11 = l19 & (l20 = (long)8)) - l20) == 0L ? 0 : (l16 < 0L ? -1 : 1)) == false) {
                                                                                                        object6 = f$a.a;
                                                                                                        com.baidu.location.e.f.d((f)object6, n12 != 0);
                                                                                                    }
                                                                                                    if ((l21 = (l15 = (l11 = l19 & (l20 = (long)16)) - l20) == 0L ? 0 : (l15 < 0L ? -1 : 1)) == false) {
                                                                                                        object6 = f$a.a;
                                                                                                        com.baidu.location.e.f.e((f)object6, n12 != 0);
                                                                                                    }
                                                                                                    if ((l21 = (l14 = (l11 = l19 & (l20 = (long)32)) - l20) == 0L ? 0 : (l14 < 0L ? -1 : 1)) == false) {
                                                                                                        object6 = f$a.a;
                                                                                                        com.baidu.location.e.f.f((f)object6, n12 != 0);
                                                                                                    }
                                                                                                    if ((l13 = (l12 = (l19 &= (l20 = (long)64)) - l20) == 0L ? 0 : (l12 < 0L ? -1 : 1)) == false) {
                                                                                                        object4 = f$a.a;
                                                                                                        com.baidu.location.e.f.g((f)object4, n12 != 0);
                                                                                                    }
                                                                                                    object4 = new JSONObject();
                                                                                                    boolean bl5 = object7.has((String)object3);
                                                                                                    if (!bl5) break block171;
                                                                                                    object5 = f$a.a;
                                                                                                    object6 = object7.getString((String)object3);
                                                                                                    string11 = ";";
                                                                                                    object6 = object6.split(string11);
                                                                                                    com.baidu.location.e.f.a((f)object5, object6);
                                                                                                    object5 = object7.getString((String)object3);
                                                                                                    object4.put((String)object3, object5);
                                                                                                }
                                                                                                object3 = "bklist";
                                                                                                boolean bl3 = object7.has((String)object3);
                                                                                                if (!bl3) break block172;
                                                                                                object3 = "bklist";
                                                                                                object3 = object7.getString((String)object3);
                                                                                                object5 = ";";
                                                                                                object3 = object3.split((String)object5);
                                                                                                object5 = f$a.a;
                                                                                                ((f)object5).a((String[])object3);
                                                                                            }
                                                                                            object3 = "para";
                                                                                            boolean bl3 = object7.has((String)object3);
                                                                                            object5 = "minapn";
                                                                                            object6 = "onlt";
                                                                                            string11 = "oflp";
                                                                                            string13 = "poiup";
                                                                                            string12 = "addrup";
                                                                                            string10 = "rgcgp";
                                                                                            string9 = "4";
                                                                                            string8 = "3";
                                                                                            string7 = "2";
                                                                                            string6 = object;
                                                                                            object = "0";
                                                                                            if (!bl3) break block173;
                                                                                            object3 = "para";
                                                                                            object3 = object7.getJSONObject((String)object3);
                                                                                            n13 = object3.has(string10);
                                                                                            if (n13 == 0) break block174;
                                                                                            object7 = f$a.a;
                                                                                            string5 = object2;
                                                                                            n10 = object3.getInt(string10);
                                                                                            com.baidu.location.e.f.a((f)object7, n10);
                                                                                            break block175;
                                                                                        }
                                                                                        string5 = object2;
                                                                                    }
                                                                                    n10 = object3.has(string12);
                                                                                    if (n10 == 0) break block176;
                                                                                    object2 = f$a.a;
                                                                                    n13 = object3.getInt(string12);
                                                                                    com.baidu.location.e.f.b((f)object2, n13);
                                                                                }
                                                                                n10 = (int)(object3.has(string13) ? 1 : 0);
                                                                                if (n10 == 0) break block177;
                                                                                object2 = f$a.a;
                                                                                n13 = object3.getInt(string13);
                                                                                com.baidu.location.e.f.c((f)object2, n13);
                                                                            }
                                                                            n10 = (int)(object3.has(string11) ? 1 : 0);
                                                                            if (n10 == 0) break block178;
                                                                            object2 = object3.getJSONObject(string11);
                                                                            n13 = (int)(object2.has((String)object) ? 1 : 0);
                                                                            if (n13 == 0) break block179;
                                                                            object7 = f$a.a;
                                                                            string4 = string13;
                                                                            string3 = string12;
                                                                            d10 = object2.getDouble((String)object);
                                                                            com.baidu.location.e.f.a((f)object7, d10);
                                                                            break block180;
                                                                        }
                                                                        string4 = string13;
                                                                        string3 = string12;
                                                                    }
                                                                    n13 = (int)(object2.has(string2) ? 1 : 0);
                                                                    if (n13 == 0) break block181;
                                                                    object7 = f$a.a;
                                                                    d10 = object2.getDouble(string2);
                                                                    com.baidu.location.e.f.b((f)object7, d10);
                                                                }
                                                                n13 = (int)(object2.has(string7) ? 1 : 0);
                                                                if (n13 == 0) break block182;
                                                                object7 = f$a.a;
                                                                d10 = object2.getDouble(string7);
                                                                com.baidu.location.e.f.c((f)object7, d10);
                                                            }
                                                            n13 = (int)(object2.has(string8) ? 1 : 0);
                                                            if (n13 == 0) break block183;
                                                            object7 = f$a.a;
                                                            d10 = object2.getDouble(string8);
                                                            com.baidu.location.e.f.d((f)object7, d10);
                                                        }
                                                        n13 = (int)(object2.has(string9) ? 1 : 0);
                                                        if (n13 == 0) break block184;
                                                        object7 = f$a.a;
                                                        d10 = object2.getDouble(string9);
                                                        com.baidu.location.e.f.e((f)object7, d10);
                                                        break block184;
                                                    }
                                                    string4 = string13;
                                                    string3 = string12;
                                                }
                                                n10 = (int)(object3.has((String)object6) ? 1 : 0);
                                                if (n10 == 0) break block185;
                                                object2 = object3.getJSONObject((String)object6);
                                                n13 = (int)(object2.has((String)object) ? 1 : 0);
                                                if (n13 == 0) break block186;
                                                object7 = f$a.a;
                                                l11 = object2.getLong((String)object);
                                                com.baidu.location.e.f.a((f)object7, l11);
                                            }
                                            n13 = (int)(object2.has(string2) ? 1 : 0);
                                            if (n13 == 0) break block187;
                                            object7 = f$a.a;
                                            l11 = object2.getLong(string2);
                                            com.baidu.location.e.f.b((f)object7, l11);
                                        }
                                        n13 = (int)(object2.has(string7) ? 1 : 0);
                                        if (n13 == 0) break block188;
                                        object7 = f$a.a;
                                        l11 = object2.getLong(string7);
                                        com.baidu.location.e.f.c((f)object7, l11);
                                    }
                                    n13 = (int)(object2.has(string8) ? 1 : 0);
                                    if (n13 == 0) break block189;
                                    object7 = f$a.a;
                                    l11 = object2.getLong(string8);
                                    com.baidu.location.e.f.d((f)object7, l11);
                                }
                                n13 = (int)(object2.has(string9) ? 1 : 0);
                                if (n13 == 0) break block185;
                                object7 = f$a.a;
                                l11 = object2.getLong(string9);
                                com.baidu.location.e.f.e((f)object7, l11);
                            }
                            n10 = (int)(object3.has((String)object5) ? 1 : 0);
                            if (n10 == 0) break block190;
                            object2 = f$a.a;
                            int n14 = object3.getInt((String)object5);
                            com.baidu.location.e.f.d((f)object2, n14);
                            break block190;
                        }
                        string5 = object2;
                        string4 = string13;
                        string3 = string12;
                    }
                    object2 = "ol";
                    object3 = f$a.a;
                    boolean bl4 = com.baidu.location.e.f.a((f)object3);
                    object4.put((String)object2, bl4);
                    object2 = "olv2";
                    object3 = f$a.a;
                    boolean bl5 = com.baidu.location.e.f.b((f)object3);
                    object4.put((String)object2, bl5);
                    object2 = "fl";
                    object3 = f$a.a;
                    boolean bl6 = com.baidu.location.e.f.c((f)object3);
                    object4.put((String)object2, bl6);
                    object2 = "on";
                    object3 = f$a.a;
                    boolean bl7 = com.baidu.location.e.f.d((f)object3);
                    object4.put((String)object2, bl7);
                    object2 = "wn";
                    object3 = f$a.a;
                    boolean bl8 = com.baidu.location.e.f.e((f)object3);
                    object4.put((String)object2, bl8);
                    object2 = "oc";
                    object3 = f$a.a;
                    boolean bl9 = com.baidu.location.e.f.f((f)object3);
                    object4.put((String)object2, bl9);
                    long l19 = System.currentTimeMillis();
                    f$a.d = l19;
                    object7 = "t";
                    object4.put((String)object7, l19);
                    object2 = string6;
                    object3 = string5;
                    object4.put(string5, (Object)string6);
                    object2 = "rgcon";
                    object3 = f$a.a;
                    boolean bl10 = com.baidu.location.e.f.g((f)object3);
                    object4.put((String)object2, bl10);
                    object2 = f$a.a;
                    n10 = com.baidu.location.e.f.h((f)object2);
                    object4.put(string10, n10);
                    object2 = new JSONObject();
                    object3 = f$a.a;
                    d10 = com.baidu.location.e.f.i((f)object3);
                    object2.put((String)object, d10);
                    object3 = f$a.a;
                    d10 = com.baidu.location.e.f.j((f)object3);
                    object2.put(string2, d10);
                    object3 = f$a.a;
                    d10 = com.baidu.location.e.f.k((f)object3);
                    object2.put(string7, d10);
                    object3 = f$a.a;
                    d10 = com.baidu.location.e.f.l((f)object3);
                    object2.put(string8, d10);
                    object3 = f$a.a;
                    d10 = com.baidu.location.e.f.m((f)object3);
                    object2.put(string9, d10);
                    object4.put(string11, object2);
                    object2 = new JSONObject();
                    object3 = f$a.a;
                    long l20 = com.baidu.location.e.f.n((f)object3);
                    object2.put((String)object, l20);
                    object = f$a.a;
                    l20 = com.baidu.location.e.f.o((f)object);
                    object2.put(string2, l20);
                    object = f$a.a;
                    long l21 = com.baidu.location.e.f.p((f)object);
                    object2.put(string7, l21);
                    object = f$a.a;
                    long l22 = com.baidu.location.e.f.q((f)object);
                    object2.put(string8, l22);
                    object = f$a.a;
                    l22 = com.baidu.location.e.f.r((f)object);
                    object2.put(string9, l22);
                    object4.put((String)object6, object2);
                    object = f$a.a;
                    n11 = com.baidu.location.e.f.s((f)object);
                    object2 = string3;
                    object4.put(string3, n11);
                    object = f$a.a;
                    n11 = com.baidu.location.e.f.t((f)object);
                    object2 = string4;
                    object4.put(string4, n11);
                    object = f$a.a;
                    n11 = com.baidu.location.e.f.u((f)object);
                    object4.put((String)object5, n11);
                    object2 = f$a.a;
                    object2 = com.baidu.location.e.f.v((f)object2);
                    object2 = ((h)object2).c();
                    object3 = "ofl.config";
                    object = new File((File)object2, (String)object3);
                    n10 = (int)(((File)object).exists() ? 1 : 0);
                    if (n10 != 0) break block191;
                    ((File)object).createNewFile();
                }
                object2 = new FileWriter((File)object);
                object = object4.toString();
                try {
                    ((Writer)object2).write((String)object);
                    ((OutputStreamWriter)object2).close();
                    break block192;
                }
                catch (Exception exception) {
                    n11 = f$a.b;
                    n10 = 1;
                }
            } else {
                n10 = n12;
                n11 = f$a.b;
            }
            f$a.b = n11 += n10;
            f$a.c = l10 = System.currentTimeMillis();
        }
        f$a.e = false;
    }

    public void b() {
        this.k.clear();
        this.k.put("qt", "conf");
        Object object = this.k;
        String string2 = this.f;
        object.put("req", string2);
        this.h = object = com.baidu.location.e.h.b;
    }
}

