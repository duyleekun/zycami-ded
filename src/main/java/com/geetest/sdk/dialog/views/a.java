/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.animation.ObjectAnimator
 *  android.app.Activity
 *  android.content.Context
 *  android.os.Build$VERSION
 *  android.os.Handler
 *  android.text.TextUtils
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 */
package com.geetest.sdk.dialog.views;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.geetest.sdk.GT3ConfigBean;
import com.geetest.sdk.au;
import com.geetest.sdk.av;
import com.geetest.sdk.dialog.views.GtWebView;
import com.geetest.sdk.dialog.views.a$b;
import com.geetest.sdk.dialog.views.a$c;
import com.geetest.sdk.dialog.views.a$d;
import com.geetest.sdk.f;
import com.geetest.sdk.model.beans.b;
import com.geetest.sdk.utils.g;
import com.geetest.sdk.utils.h;
import com.geetest.sdk.utils.i;
import com.geetest.sdk.utils.l;
import java.util.HashMap;
import java.util.Map;

public class a {
    private static final String m = "a";
    public static int n;
    public static int o;
    private Context a;
    private au b;
    private b c;
    private GT3ConfigBean d;
    private int e;
    private int f;
    private f g;
    private int h;
    private GtWebView i = null;
    private String j;
    private Runnable k;
    private Handler l;

    public a(Context object, f f10) {
        a$c a$c = new a$c(this);
        this.l = a$c;
        this.a = object;
        this.b = object;
        this.g = f10;
    }

    public static /* synthetic */ int a(a a10, int n10) {
        a10.h = n10;
        return n10;
    }

    public static /* synthetic */ au a(a a10) {
        return a10.b;
    }

    public static /* synthetic */ f b(a a10) {
        return a10.g;
    }

    public static /* synthetic */ b c(a a10) {
        return a10.c;
    }

    public static /* synthetic */ Handler d(a a10) {
        return a10.l;
    }

    public static /* synthetic */ Context e(a a10) {
        return a10.a;
    }

    public static /* synthetic */ String e() {
        return m;
    }

    private float f() {
        return this.a.getApplicationContext().getResources().getDisplayMetrics().density;
    }

    public static /* synthetic */ GT3ConfigBean f(a a10) {
        return a10.d;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    private int g() {
        block32: {
            block25: {
                block26: {
                    block31: {
                        block29: {
                            block28: {
                                block30: {
                                    block27: {
                                        var1_1 = this;
                                        var2_2 = this.a;
                                        var3_3 = com.geetest.sdk.utils.i.a((Context)var2_2);
                                        var4_4 = this.a;
                                        var5_5 = com.geetest.sdk.utils.i.b(var4_4);
                                        var6_6 = this.a;
                                        var7_7 = 300.0f;
                                        var8_8 = com.geetest.sdk.utils.g.a(var6_6, var7_7);
                                        var9_9 = this.a;
                                        var10_10 = 275.0f;
                                        var11_11 = com.geetest.sdk.utils.g.a(var9_9, var10_10);
                                        var12_12 = this.a;
                                        var13_13 = 410.0f;
                                        var14_14 = com.geetest.sdk.utils.g.a((Context)var12_12, var13_13);
                                        var15_15 = this.a;
                                        var16_16 = 348.0f;
                                        var17_17 = com.geetest.sdk.utils.g.a(var15_15, var16_16);
                                        var18_18 = com.geetest.sdk.dialog.views.a.m;
                                        var19_19 = new StringBuilder();
                                        var19_19.append("widthScreen: ");
                                        var20_20 /* !! */  = this.a;
                                        var21_21 = var5_5;
                                        var22_22 = com.geetest.sdk.utils.g.b(var20_20 /* !! */ , var21_21);
                                        var19_19.append(var22_22);
                                        var19_19 = var19_19.toString();
                                        com.geetest.sdk.utils.l.d(var18_18, (String)var19_19);
                                        var23_23 = var3_3 < var5_5 ? var3_3 * 4 / 5 : var5_5 * 4 / 5;
                                        var20_20 /* !! */  = var1_1.c.o();
                                        var24_24 = "beeline";
                                        var22_22 = (int)var24_24.equals(var20_20 /* !! */ );
                                        var25_25 = 100;
                                        var21_21 = 1.4E-43f;
                                        if (var22_22 != 0) break block25;
                                        var22_22 = var1_1.h;
                                        var26_26 = 60;
                                        var27_27 = 8.4E-44f;
                                        if (var22_22 <= var26_26) break block25;
                                        if (var22_22 < var25_25) break block26;
                                        var28_28 = "slide";
                                        var20_20 /* !! */  = var1_1.c.o();
                                        var22_22 = (int)var28_28.equals(var20_20 /* !! */ );
                                        if (var22_22 == 0) break block27;
                                        var22_22 = Build.VERSION.SDK_INT;
                                        var26_26 = 19;
                                        var27_27 = 2.7E-44f;
                                        if (var22_22 >= var26_26) break block27;
                                        var29_29 = this.f();
                                        var12_12 = new StringBuilder();
                                        var12_12.append("scale: ");
                                        var12_12.append(var29_29);
                                        var12_12 = var12_12.toString();
                                        com.geetest.sdk.utils.l.d(var18_18, (String)var12_12);
                                        var12_12 = var1_1.a;
                                        var30_30 = 210.0f;
                                        var14_14 = com.geetest.sdk.utils.g.a((Context)var12_12, var30_30);
                                        var20_20 /* !! */  = var1_1.a;
                                        var27_27 = 230.0f;
                                        var22_22 = com.geetest.sdk.utils.g.a(var20_20 /* !! */ , var27_27);
                                        var28_28 = var1_1.a;
                                        var31_32 = 250.0f;
                                        var26_26 = com.geetest.sdk.utils.g.a((Context)var28_28, var31_32);
                                        var32_33 = var1_1.a;
                                        var33_34 = 270.0f;
                                        var34_35 = com.geetest.sdk.utils.g.a(var32_33, var33_34);
                                        var35_36 = var1_1.a;
                                        var36_37 = 280.0f;
                                        var37_38 = com.geetest.sdk.utils.g.a(var35_36, var36_37);
                                        var38_39 = var1_1.a;
                                        var39_40 = 340.0f;
                                        var40_41 = com.geetest.sdk.utils.g.a(var38_39, var39_40);
                                        var41_42 = var29_29;
                                        var43_43 = 1.5;
                                        var8_8 = (int)(var41_42 == var43_43 ? 0 : (var41_42 < var43_43 ? -1 : 1));
                                        if (var8_8 <= 0) {
                                            if (var23_23 >= var14_14) {
                                                var14_14 = var23_23;
                                            }
                                            if (var23_23 <= var11_11) {
                                                var11_11 = var14_14;
                                            }
                                        } else {
                                            var45_44 = 2.0;
                                            cfr_temp_0 = var41_42 - var45_44;
                                            var8_8 = (int)(cfr_temp_0 == 0.0 ? 0 : (cfr_temp_0 < 0.0 ? -1 : 1));
                                            if (var8_8 <= 0) {
                                                if (var23_23 >= var22_22) {
                                                    var22_22 = var23_23;
                                                }
                                                var11_11 = var23_23 > var37_38 ? var37_38 : var22_22;
                                            } else {
                                                var45_44 = 3.0;
                                                cfr_temp_1 = var41_42 - var45_44;
                                                var8_8 = (int)(cfr_temp_1 == 0.0 ? 0 : (cfr_temp_1 < 0.0 ? -1 : 1));
                                                if (var8_8 <= 0) {
                                                    var8_8 = var26_26;
                                                    var11_11 = var23_23 < var26_26 ? var26_26 : var23_23;
                                                    if (var23_23 > var40_41) {
                                                        var11_11 = var40_41;
                                                    }
                                                } else {
                                                    var11_11 = var23_23 < var34_35 ? var34_35 : var23_23;
                                                    if (var23_23 > var17_17) {
                                                        var11_11 = var17_17;
                                                    }
                                                }
                                            }
                                        }
                                        break block28;
                                    }
                                    if (var3_3 >= var5_5) break block29;
                                    var6_6 = var1_1.a;
                                    var47_45 = var3_3;
                                    var47_45 = com.geetest.sdk.utils.g.b(var6_6, var47_45) + -44;
                                    var8_8 = com.geetest.sdk.utils.g.a(var6_6, var47_45);
                                    var19_19 = new StringBuilder();
                                    var20_20 /* !! */  = "limitationWidth:  ";
                                    var19_19.append((String)var20_20 /* !! */ );
                                    var19_19.append(var8_8);
                                    var19_19 = var19_19.toString();
                                    com.geetest.sdk.utils.l.b(var18_18, (String)var19_19);
                                    var19_19 = ((Activity)var1_1.a).getWindow().getAttributes();
                                    var23_23 = var19_19.flags;
                                    var22_22 = 1024;
                                    var30_31 = 1.435E-42f;
                                    if ((var23_23 &= var22_22) == var22_22) {
                                        var8_8 = var8_8 * 9 / 10;
                                    }
                                    if ((var23_23 = (int)com.geetest.sdk.utils.h.b((Context)(var19_19 = var1_1.a))) == 0) break block30;
                                    if (var8_8 >= var11_11) {
                                        var11_11 = var8_8;
                                    }
                                    if (var8_8 <= var14_14) break block28;
                                    break block31;
                                }
                                if (var8_8 >= var11_11) {
                                    var11_11 = var8_8;
                                }
                                if (var8_8 > var17_17) ** GOTO lbl-1000
                            }
                            var14_14 = var11_11;
                            break block31;
                        }
                        if (var23_23 >= var8_8) {
                            var8_8 = var23_23;
                        }
                        if (var23_23 > var17_17) lbl-1000:
                        // 2 sources

                        {
                            var14_14 = var17_17;
                        } else {
                            var14_14 = var8_8;
                        }
                    }
                    if (var3_3 < var5_5) {
                        var3_3 = var14_14 * 100;
                        var5_5 = var1_1.h;
                        var1_1.e = var3_3 /= var5_5;
                        var1_1.f = var14_14;
                    } else {
                        var1_1.e = var14_14;
                        var3_3 = var1_1.h * var14_14;
                        var5_5 = 100;
                        var1_1.f = var3_3 /= var5_5;
                    }
                    var23_23 = var14_14;
                    break block32;
                }
                if (var3_3 < var5_5) {
                    var4_4 = var1_1.a;
                    var48_46 = var3_3;
                    var3_3 = com.geetest.sdk.utils.g.a(var4_4, var48_46 = (float)(com.geetest.sdk.utils.g.b(var4_4, var48_46) + -44));
                    if (var3_3 >= var11_11) {
                        var11_11 = var3_3;
                    }
                    if (var3_3 <= var17_17) {
                        var17_17 = var11_11;
                    }
                } else {
                    if (var23_23 >= var8_8) {
                        var8_8 = var23_23;
                    }
                    if (var23_23 <= var17_17) {
                        var17_17 = var8_8;
                    }
                }
                var1_1.e = var17_17;
                var3_3 = var1_1.h * var17_17;
                var5_5 = 100;
                var1_1.f = var3_3 /= var5_5;
                var23_23 = var17_17;
                break block32;
            }
            var5_5 = var25_25;
            var1_1.e = var8_8;
            var3_3 = var1_1.h;
            var1_1.f = var8_8 = var8_8 * var3_3 / var25_25;
        }
        var2_2 = new StringBuilder();
        var2_2.append("widthPX: ");
        var2_2.append(var23_23);
        var2_2 = var2_2.toString();
        com.geetest.sdk.utils.l.d(var18_18, (String)var2_2);
        var2_2 = new StringBuilder();
        var2_2.append("widthDP: ");
        var4_4 = var1_1.a;
        var29_29 = var23_23;
        var5_5 = com.geetest.sdk.utils.g.b(var4_4, var29_29);
        var2_2.append(var5_5);
        var2_2 = var2_2.toString();
        com.geetest.sdk.utils.l.d(var18_18, (String)var2_2);
        var2_2 = new StringBuilder();
        var2_2.append("height:  ");
        var5_5 = var1_1.h;
        var2_2.append(var5_5);
        var2_2 = var2_2.toString();
        com.geetest.sdk.utils.l.d(var18_18, (String)var2_2);
        var2_2 = new StringBuilder();
        var2_2.append("mWidth:  ");
        var5_5 = var1_1.e;
        var2_2.append(var5_5);
        var2_2 = var2_2.toString();
        com.geetest.sdk.utils.l.d(var18_18, (String)var2_2);
        var2_2 = new StringBuilder();
        var2_2.append("mHeight:  ");
        var5_5 = var1_1.f;
        var2_2.append(var5_5);
        var2_2 = var2_2.toString();
        com.geetest.sdk.utils.l.d(var18_18, (String)var2_2);
        var2_2 = new StringBuilder();
        var2_2.append("deviceWidth: ");
        var4_4 = var1_1.a;
        var29_29 = com.geetest.sdk.utils.i.b(var4_4);
        var5_5 = com.geetest.sdk.utils.g.b(var4_4, var29_29);
        var2_2.append(var5_5);
        var2_2 = var2_2.toString();
        com.geetest.sdk.utils.l.d(var18_18, (String)var2_2);
        var2_2 = new StringBuilder();
        var2_2.append("deviceHeight: ");
        var4_4 = var1_1.a;
        var29_29 = com.geetest.sdk.utils.i.a(var4_4);
        var5_5 = com.geetest.sdk.utils.g.b(var4_4, var29_29);
        var2_2.append(var5_5);
        var2_2 = var2_2.toString();
        com.geetest.sdk.utils.l.d(var18_18, (String)var2_2);
        return var23_23;
    }

    public static /* synthetic */ GtWebView g(a a10) {
        return a10.i;
    }

    public static /* synthetic */ Runnable h(a a10) {
        return a10.k;
    }

    public static /* synthetic */ int i(a a10) {
        return a10.h;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public GtWebView a() {
        int n10;
        boolean bl2;
        Map.Entry entry;
        Map.Entry entry2;
        int n11;
        Object object;
        Object object2;
        int n12;
        int n13;
        new HashMap();
        this.h = n13 = this.c.l();
        new HashMap();
        Object object3 = this.c.j().a();
        Object object4 = "&";
        CharSequence charSequence = "=";
        Object object5 = "";
        if (object3 != null && (n12 = object3.size()) > 0) {
            object3 = object3.entrySet().iterator();
            object2 = object5;
            object = object5;
            while ((n11 = (int)(object3.hasNext() ? 1 : 0)) != 0) {
                entry2 = object3.next();
                entry = (CharSequence)entry2.getKey();
                bl2 = TextUtils.isEmpty((CharSequence)((Object)entry));
                if (bl2) continue;
                entry = new StringBuilder();
                ((StringBuilder)((Object)entry)).append((String)object);
                ((StringBuilder)((Object)entry)).append("&aspect_radio_");
                object = (String)entry2.getKey();
                ((StringBuilder)((Object)entry)).append((String)object);
                ((StringBuilder)((Object)entry)).append((String)charSequence);
                object = entry2.getValue();
                ((StringBuilder)((Object)entry)).append(object);
                object = ((StringBuilder)((Object)entry)).toString();
                entry = new StringBuilder();
                ((StringBuilder)((Object)entry)).append((String)object2);
                ((StringBuilder)((Object)entry)).append((String)object4);
                object2 = (String)entry2.getKey();
                ((StringBuilder)((Object)entry)).append((String)object2);
                ((StringBuilder)((Object)entry)).append((String)charSequence);
                object2 = this.c.j().b();
                entry2 = (String)entry2.getKey();
                object2 = object2.optString((String)((Object)entry2));
                ((StringBuilder)((Object)entry)).append((String)object2);
                object2 = ((StringBuilder)((Object)entry)).toString();
            }
        } else {
            object2 = object5;
            object = object5;
        }
        if ((object3 = this.c.e()) != null && (n11 = object3.size()) > 0) {
            object3 = object3.entrySet().iterator();
            entry2 = object5;
            while (bl2 = object3.hasNext()) {
                entry = object3.next();
                CharSequence charSequence2 = (CharSequence)entry.getKey();
                boolean bl3 = TextUtils.isEmpty((CharSequence)charSequence2);
                if (bl3) continue;
                charSequence2 = new StringBuilder();
                ((StringBuilder)charSequence2).append((String)((Object)entry2));
                ((StringBuilder)charSequence2).append((String)object4);
                entry2 = (String)entry.getKey();
                ((StringBuilder)charSequence2).append((String)((Object)entry2));
                ((StringBuilder)charSequence2).append((String)charSequence);
                entry2 = (String)entry.getValue();
                ((StringBuilder)charSequence2).append((String)((Object)entry2));
                entry2 = ((StringBuilder)charSequence2).toString();
            }
        } else {
            entry2 = object5;
        }
        object3 = new StringBuilder();
        ((StringBuilder)object3).append("?gt=");
        object4 = this.c.k();
        ((StringBuilder)object3).append((String)object4);
        ((StringBuilder)object3).append("&challenge=");
        object4 = this.c.c();
        ((StringBuilder)object3).append((String)object4);
        ((StringBuilder)object3).append("&lang=");
        object4 = this.c.m();
        ((StringBuilder)object3).append((String)object4);
        ((StringBuilder)object3).append("&title=&type=");
        object4 = this.c.o();
        ((StringBuilder)object3).append((String)object4);
        ((StringBuilder)object3).append("&api_server=");
        object4 = this.c.i().a();
        ((StringBuilder)object3).append((String)object4);
        ((StringBuilder)object3).append("&static_servers=");
        object4 = this.c.i().b().toString().replace("[", (CharSequence)object5);
        charSequence = "]";
        object4 = ((String)object4).replace(charSequence, (CharSequence)object5);
        ((StringBuilder)object3).append((String)object4);
        ((StringBuilder)object3).append("&width=100%&timeout=");
        int n14 = this.c.u();
        ((StringBuilder)object3).append(n14);
        ((StringBuilder)object3).append("&debug=");
        n14 = (int)(this.c.v() ? 1 : 0);
        ((StringBuilder)object3).append(n14 != 0);
        ((StringBuilder)object3).append((String)object);
        ((StringBuilder)object3).append((String)object2);
        ((StringBuilder)object3).append((String)((Object)entry2));
        this.j = object3 = ((StringBuilder)object3).toString();
        object3 = this.c.i().b();
        n14 = 0;
        object4 = null;
        int n15 = 1;
        if (object3 != null && (n10 = object3.size()) > 0) {
            object5 = new StringBuilder();
            object2 = new Object[n15];
            object2[0] = object3 = object3.get(0);
            object3 = String.format("https://%s/static/appweb/app3-index.html", (Object[])object2);
            ((StringBuilder)object5).append((String)object3);
            object3 = this.j;
            ((StringBuilder)object5).append((String)object3);
            object3 = ((StringBuilder)object5).toString();
        } else {
            object3 = new StringBuilder();
            ((StringBuilder)object3).append("https://static.geetest.com/static/appweb/app3-index.html");
            object5 = this.j;
            ((StringBuilder)object3).append((String)object5);
            object3 = ((StringBuilder)object3).toString();
        }
        try {
            object2 = this.a;
            object2 = object2.getApplicationContext();
            object5 = new GtWebView((Context)object2);
            this.i = object5;
            ((GtWebView)((Object)object5)).a();
            object5 = this.l;
            if (object5 != null) {
                object5 = new a$d(this);
                this.k = object5;
                object2 = this.l;
                object = this.c;
                int n16 = ((b)object).q();
                long l10 = n16;
                object2.postDelayed((Runnable)object5, l10);
            }
            object5 = this.i;
            object2 = this.b;
            ((GtWebView)((Object)object5)).setObservable((au)object2);
            n12 = -2;
            object5 = new ViewGroup.LayoutParams(n12, n12);
            object2 = this.i;
            object2.setLayoutParams((ViewGroup.LayoutParams)object5);
            object5 = this.i;
            ((GtWebView)((Object)object5)).setStaticUrl((String)object3);
            object5 = this.i;
            object2 = this.c;
            ((GtWebView)((Object)object5)).setDataBean((b)object2);
            object5 = this.i;
            object2 = this.l;
            ((GtWebView)((Object)object5)).setMyHandler((Handler)object2);
            object5 = this.i;
            object2 = this.k;
            ((GtWebView)((Object)object5)).setRunnable((Runnable)object2);
            object5 = this.i;
            object5.loadUrl((String)object3);
            object3 = this.i;
            object3.buildLayer();
            object3 = this.i;
            n12 = 0;
            object2 = null;
            object5 = new a$b(this, null);
            object2 = "JSInterface";
            object3.addJavascriptInterface(object5, (String)object2);
            object3 = this.i;
            object5 = this.c;
            n10 = ((b)object5).q();
            ((GtWebView)((Object)object3)).setTimeout(n10);
            this.d();
            return this.i;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            object5 = m;
            object2 = new StringBuilder();
            object2.append("\u9ed8\u8ba4webview\u5185\u6838\u4e22\u5931\uff0c\u9519\u8bef\u7801\uff1a204_3-->");
            object = exception.toString();
            object2.append((String)object);
            object2 = object2.toString();
            com.geetest.sdk.utils.l.b((String)object5, (String)object2);
            object5 = exception.getStackTrace();
            n12 = ((Object)object5).length;
            while (n14 < n12) {
                object = object5[n14];
                entry2 = m;
                object = ((StackTraceElement)object).toString();
                com.geetest.sdk.utils.l.b((String)((Object)entry2), (String)object);
                ++n14;
            }
            object4 = this.l;
            if (object4 != null) {
                try {
                    object5 = this.k;
                    object4.removeCallbacks((Runnable)object5);
                    object4 = this.l;
                    object4.removeMessages(n15);
                }
                catch (Exception exception2) {}
            }
            if ((object4 = this.b) == null) return this.i;
            charSequence = new StringBuilder();
            object5 = "webview crate error -->";
            ((StringBuilder)charSequence).append((String)object5);
            String string2 = exception.toString();
            ((StringBuilder)charSequence).append(string2);
            string2 = ((StringBuilder)charSequence).toString();
            charSequence = "204_3";
            ((au)object4).a((String)charSequence, string2);
        }
        return this.i;
    }

    public void a(GT3ConfigBean gT3ConfigBean) {
        this.d = gT3ConfigBean;
    }

    public void a(av av2) {
        this.b.a(av2);
    }

    public void a(b b10) {
        this.c = b10;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void b() {
        GtWebView gtWebView = this.i;
        if (gtWebView != null) {
            String string2 = "JSInterface";
            gtWebView.removeJavascriptInterface(string2);
            gtWebView = (ViewGroup)this.i.getParent();
            if (gtWebView != null) {
                GtWebView gtWebView2 = this.i;
                gtWebView.removeView((View)gtWebView2);
            }
            this.i.removeAllViews();
            gtWebView = this.i;
            gtWebView.destroy();
            this.i = null;
        }
        try {
            gtWebView = this.l;
            if (gtWebView == null) return;
            Runnable runnable = this.k;
            gtWebView.removeCallbacks(runnable);
            gtWebView = this.l;
            int n10 = 1;
            gtWebView.removeMessages(n10);
            this.l = null;
            return;
        }
        catch (Exception exception) {
            return;
        }
    }

    public void c() {
        GtWebView gtWebView = this.i;
        if (gtWebView != null) {
            float[] fArray;
            int n10 = 17;
            float[] fArray2 = fArray = new float[n10];
            float[] fArray3 = fArray;
            fArray2[0] = 0.0f;
            fArray3[1] = 2.0f;
            fArray2[2] = 4.0f;
            fArray3[3] = 2.0f;
            fArray2[4] = 0.0f;
            fArray3[5] = -2.0f;
            fArray2[6] = -4.0f;
            fArray3[7] = -2.0f;
            fArray2[8] = 0.0f;
            fArray3[9] = 2.0f;
            fArray2[10] = 4.0f;
            fArray3[11] = 2.0f;
            fArray2[12] = 0.0f;
            fArray3[13] = -2.0f;
            fArray2[14] = -4.0f;
            fArray3[15] = -2.0f;
            fArray3[16] = 0.0f;
            String string2 = "translationX";
            gtWebView = ObjectAnimator.ofFloat((Object)((Object)gtWebView), (String)string2, (float[])fArray);
            long l10 = 500L;
            gtWebView.setDuration(l10);
            gtWebView.start();
        }
    }

    public void d() {
        this.g();
        GtWebView gtWebView = this.i;
        if (gtWebView != null && (gtWebView = gtWebView.getLayoutParams()) != null) {
            int n10;
            int n11;
            n = this.e;
            o = n11 = this.f;
            gtWebView = this.i.getLayoutParams();
            ((ViewGroup.LayoutParams)gtWebView).width = n10 = n;
            ((ViewGroup.LayoutParams)gtWebView).height = n10 = o;
            GtWebView gtWebView2 = this.i;
            gtWebView2.setLayoutParams((ViewGroup.LayoutParams)gtWebView);
        }
    }
}

