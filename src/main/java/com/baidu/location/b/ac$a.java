/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  org.json.JSONObject
 */
package com.baidu.location.b;

import com.baidu.location.b.aa;
import com.baidu.location.b.ac;
import com.baidu.location.b.j;
import com.baidu.location.h.a;
import com.baidu.location.h.f;
import com.baidu.location.h.l;
import java.util.ArrayList;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import org.json.JSONObject;

public class ac$a
extends f {
    public boolean a = false;
    public int b = 0;
    public int c = 0;
    public final /* synthetic */ ac d;
    private ArrayList e;
    private boolean f;

    public ac$a(ac cloneable) {
        this.d = cloneable;
        this.e = cloneable = new Cloneable();
        this.f = true;
        this.k = cloneable;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a() {
        synchronized (this) {
            var1_1 = this.a;
            if (var1_1 != 0) {
                return;
            }
            var1_1 = com.baidu.location.h.f.p;
            var2_2 = 4;
            var3_3 = 1;
            if (var1_1 > var2_2 && (var2_2 = this.c) < var1_1) {
                this.c = var2_2 += var3_3;
                return;
            }
            var1_1 = 0;
            var4_4 = null;
            this.c = 0;
            this.a = var3_3;
            this.b = 0;
            try {
                var5_5 = this.e;
                if (var5_5 != null && (var2_2 = var5_5.size()) >= var3_3) ** GOTO lbl57
                var5_5 = this.e;
                if (var5_5 == null) {
                    var5_5 = new ArrayList();
                    this.e = var5_5;
                }
                this.b = 0;
                var2_2 = 0;
                var5_5 = null;
lbl26:
                // 3 sources

                while (true) {
                    var6_6 = this.b;
                    var7_7 = 2;
                    var8_8 = null;
                    if (var6_6 < var7_7) {
                        var9_9 = ac.b();
                    } else {
                        var6_6 = 0;
                        var9_9 = null;
                    }
                    if (var9_9 == null && (var10_10 = this.b) != var3_3 && (var10_10 = (int)this.f) != 0) {
                        this.b = var7_7;
                    }
                    ** GOTO lbl86
                    break;
                }
            }
            catch (Exception v0) {
                var4_4 = this.e;
                if (var4_4 != null) {
                    var4_4.clear();
                }
                return;
            }
            var8_8 = com.baidu.location.b.j.a();
lbl-1000:
            // 3 sources

            {
                while (true) {
                    block25: {
                        block26: {
                            if (var8_8 == null) break block26;
                            var9_9 = "err!";
                            var6_6 = (int)var8_8.contains((CharSequence)var9_9);
                            if (var6_6 != 0) ** GOTO lbl26
                            var9_9 = this.e;
                            var9_9.add(var8_8);
                            var6_6 = var8_8.length();
                            if ((var2_2 += var6_6) >= (var6_6 = com.baidu.location.h.a.i)) ** break;
                            ** continue;
                        }
                        if ((var5_5 = this.e) == null || (var2_2 = var5_5.size()) < var3_3) ** GOTO lbl-1000
                        var1_1 = this.b;
                        if (var1_1 != var3_3) {
                            var4_4 = aa.a();
                            if ((var4_4 = var4_4.c()) != null) {
                                var5_5 = com.baidu.location.h.l.g();
lbl64:
                                // 2 sources

                                while (true) {
                                    this.a((ExecutorService)var4_4, (String)var5_5);
                                    break block25;
                                    break;
                                }
                            }
                            var4_4 = com.baidu.location.h.l.g();
lbl68:
                            // 2 sources

                            while (true) {
                                this.e((String)var4_4);
                                break block25;
                                break;
                            }
                        }
                        var4_4 = aa.a();
                        if ((var4_4 = var4_4.c()) != null) {
                            var5_5 = com.baidu.location.h.l.f;
                            ** continue;
                        }
                        var4_4 = com.baidu.location.h.l.f;
                        ** continue;
                    }
                    return;
lbl-1000:
                    // 1 sources

                    {
                        var5_5 = this.e;
                        if (var5_5 != null) {
                            var5_5.clear();
                        }
                        this.a = false;
                        return;
                    }
                    break;
                }
                catch (Exception v1) {
                    ** GOTO lbl-1000
                }
lbl86:
                // 1 sources

                this.b = var3_3;
                var8_8 = var9_9;
                ** continue;
            }
        }
    }

    public void a(boolean bl2) {
        Object exception;
        block10: {
            String string2 = "ison";
            if (bl2 && (exception = this.j) != null) {
                exception = this.e;
                if (exception != null) {
                    ((ArrayList)exception).clear();
                }
                String string3 = this.j;
                exception = new JSONObject(string3);
                boolean bl3 = exception.has(string2);
                if (!bl3) break block10;
                int n10 = exception.getInt(string2);
                if (n10 != 0) break block10;
                try {
                    this.f = false;
                }
                catch (Exception exception2) {
                    exception2.printStackTrace();
                }
            }
        }
        if ((exception = this.k) != null) {
            exception.clear();
        }
        this.a = false;
    }

    public void b() {
        Object object = com.baidu.location.h.l.e();
        this.h = object;
        int n10 = this.b;
        int n11 = 1;
        if (n10 != n11) {
            object = com.baidu.location.h.l.g();
            this.h = object;
        }
        this.i = n10 = 2;
        object = this.e;
        if (object != null) {
            Object object2;
            Object object3;
            int n12;
            n10 = 0;
            object = null;
            Object object4 = null;
            for (int i10 = 0; i10 < (n12 = ((ArrayList)(object3 = this.e)).size()); ++i10) {
                String string2;
                StringBuilder stringBuilder;
                n12 = this.b;
                object2 = "]";
                if (n12 == n11) {
                    object3 = this.k;
                    stringBuilder = new StringBuilder();
                    string2 = "cldc[";
                } else {
                    object3 = this.k;
                    stringBuilder = new StringBuilder();
                    string2 = "cltr[";
                }
                stringBuilder.append(string2);
                stringBuilder.append(i10);
                stringBuilder.append((String)object2);
                object2 = stringBuilder.toString();
                stringBuilder = this.e.get(i10);
                object3.put(object2, stringBuilder);
            }
            object4 = Locale.CHINA;
            object3 = new Object[n11];
            long l10 = System.currentTimeMillis();
            object3[0] = object2 = Long.valueOf(l10);
            object = String.format((Locale)object4, "%d", (Object[])object3);
            object4 = this.k;
            object3 = "trtm";
            object4.put(object3, object);
            n10 = this.b;
            if (n10 != n11) {
                object = this.k;
                String string3 = "qt";
                object4 = "cltrg";
                object.put(string3, object4);
            }
        }
    }
}

