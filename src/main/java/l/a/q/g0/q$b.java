/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.AsyncTask
 *  android.text.TextUtils
 *  android.util.Log
 *  android.util.Pair
 *  android.util.Xml
 */
package l.a.q.g0;

import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import android.util.Xml;
import java.io.File;
import java.io.FileInputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.IntFunction;
import java.util.stream.Collectors;
import l.a.q.g0.f;
import l.a.q.g0.g;
import l.a.q.g0.h;
import l.a.q.g0.i;
import l.a.q.g0.j;
import l.a.q.g0.k;
import l.a.q.g0.l;
import l.a.q.g0.m;
import l.a.q.g0.p;
import l.a.q.g0.q;
import l.a.q.g0.q$a;

public class q$b
extends AsyncTask {
    private final Context a;
    private final boolean b;
    private final boolean c;
    private q$a d;
    public final /* synthetic */ q e;

    public q$b(q q10, Context context, boolean bl2, boolean bl3, q$a q$a) {
        this.e = q10;
        this.a = context;
        this.b = bl2;
        this.c = bl3;
        this.d = q$a;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private String[] b(String object) {
        Object object2;
        block6: {
            boolean bl2;
            block5: {
                String string2;
                int n10;
                Object object3;
                block7: {
                    int n11;
                    block8: {
                        bl2 = this.b;
                        n11 = 0;
                        object3 = null;
                        n10 = 1;
                        string2 = ".xml";
                        if (!bl2) break block7;
                        object2 = new File((String)object);
                        boolean bl3 = ((File)object2).isFile();
                        if (!bl3) break block8;
                        bl2 = ((String)object).endsWith(string2);
                        if (!bl2) break block5;
                        object2 = new String[n10];
                        object2[0] = object;
                        break block6;
                    }
                    object3 = j.a;
                    if ((object2 = ((File)object2).list((FilenameFilter)object3)) == null) return null;
                    n11 = ((String[])object2).length;
                    if (n11 == 0) {
                        return null;
                    }
                    object2 = Arrays.stream(object2);
                    object3 = new k((String)object);
                    object = object2.map(object3);
                    object2 = i.a;
                    object2 = object = object.toArray((IntFunction<A[]>)object2);
                    object2 = (String[])object;
                    break block6;
                }
                bl2 = this.c;
                if (bl2) {
                    try {
                        object2 = this.a;
                        object2 = object2.getAssets();
                        object2 = object2.list((String)object);
                        if (object2 == null) break block5;
                        int n12 = ((String[])object2).length;
                        if (n12 == 0) {
                            bl2 = ((String)object).endsWith(string2);
                            if (!bl2) break block5;
                            object2 = new String[n10];
                            object2[0] = object;
                            break block6;
                        }
                        object2 = Arrays.stream(object2);
                        object3 = g.a;
                        object2 = object2.filter(object3);
                        object3 = new m((String)object);
                        object = object2.map(object3);
                        object2 = l.a;
                        object = object.toArray((IntFunction<A[]>)object2);
                        object2 = object = (String[])object;
                        break block6;
                    }
                    catch (IOException iOException) {
                        iOException.printStackTrace();
                    }
                }
            }
            bl2 = false;
            object2 = null;
        }
        if (object2 == null) return null;
        int n13 = ((File)object2).length;
        if (n13 != 0) return object2;
        return null;
    }

    public static /* synthetic */ Pair c(q$b q$b, String string2) {
        return q$b.l(string2);
    }

    public static /* synthetic */ boolean d(File file, String string2) {
        return string2.endsWith(".xml");
    }

    public static /* synthetic */ String e(String string2, String string3) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string2);
        string2 = File.separator;
        stringBuilder.append(string2);
        stringBuilder.append(string3);
        return stringBuilder.toString();
    }

    public static /* synthetic */ String[] f(int n10) {
        return new String[n10];
    }

    public static /* synthetic */ boolean g(String string2) {
        return string2.endsWith(".xml");
    }

    public static /* synthetic */ String h(String charSequence, String string2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append((String)charSequence);
        String string3 = "/";
        boolean bl2 = ((String)charSequence).endsWith(string3);
        if (bl2) {
            charSequence = "";
        } else {
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append(string3);
            ((StringBuilder)charSequence).append(string2);
            charSequence = ((StringBuilder)charSequence).toString();
        }
        stringBuilder.append((String)charSequence);
        return stringBuilder.toString();
    }

    public static /* synthetic */ String[] i(int n10) {
        return new String[n10];
    }

    public static /* synthetic */ void j(Pair object) {
        String string2 = (String)object.first;
        object = (List)object.second;
        p.n(string2, (List)object);
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private Pair l(String var1_1) {
        block41: {
            block33: {
                block34: {
                    block31: {
                        block30: {
                            block32: {
                                block29: {
                                    var2_2 = new ArrayList<ArrayList<ArrayList<E>>>();
                                    var3_7 = null;
                                    var4_8 = this.b;
                                    var5_9 = -1;
                                    var6_10 = ".";
                                    var7_11 = 1;
                                    if (!var4_8) break block29;
                                    var8_12 = new File((String)var1_1);
                                    var1_1 = new FileInputStream((File)var8_12);
                                    try {
                                        var8_12 = var8_12.getName();
                                    }
                                    catch (Exception v0) {
                                        var4_8 = false;
                                        var8_12 = null;
                                        break block31;
                                    }
                                    var9_13 = var8_12.lastIndexOf(var6_10);
                                    var8_12 = var8_12.substring(0, var9_13);
                                    break block30;
                                }
                                var4_8 = this.c;
                                if (!var4_8) break block32;
                                var8_12 = this.a;
                                var8_12 = var8_12.getAssets();
                                var8_12 = var8_12.open((String)var1_1);
                                var10_14 = "/";
                                try {
                                    var11_15 = var1_1.lastIndexOf((String)var10_14);
                                    if (var11_15 == var5_9) {
                                        var11_15 = 0;
                                        var10_14 = null;
                                    } else {
                                        var11_15 += var7_11;
                                    }
                                    var9_13 = var1_1.lastIndexOf(var6_10);
                                    var1_1 = var1_1.substring(var11_15, var9_13);
                                    var12_16 = var8_12;
                                    var8_12 = var1_1;
                                    var1_1 = var12_16;
                                    break block30;
                                }
                                catch (Throwable var2_3) {
                                    var3_7 = var8_12;
                                    break block33;
                                }
                                catch (Exception v1) {
                                    var12_17 = var8_12;
                                    var4_8 = false;
                                    var8_12 = null;
                                    var3_7 = var12_17;
                                    break block34;
                                }
                            }
                            var1_1 = null;
                            var4_8 = false;
                            var8_12 = null;
                        }
                        var8_12 = this.m((String)var8_12);
                        var6_10 = Xml.newPullParser();
                        var10_14 = "utf-8";
                        var6_10.setInput((InputStream)var1_1, (String)var10_14);
                        var11_15 = var6_10.getEventType();
                        while (var11_15 != var7_11) {
                            block36: {
                                block35: {
                                    block40: {
                                        block39: {
                                            block37: {
                                                block38: {
                                                    if (var11_15 == 0) break block35;
                                                    var13_18 = 2;
                                                    if (var11_15 != var13_18) break block36;
                                                    var10_14 = var6_10.getName();
                                                    var14_19 = var10_14.hashCode();
                                                    if (var14_19 == (var15_20 = -1024600675)) break block37;
                                                    var15_20 = -891985903;
                                                    if (var14_19 == var15_20) break block38;
                                                    var15_20 = 3242771;
                                                    if (var14_19 != var15_20 || (var11_15 = (int)var10_14.equals(var16_21 = "item")) == 0) ** GOTO lbl-1000
                                                    var11_15 = var13_18;
                                                    break block39;
                                                }
                                                var16_21 = "string";
                                                var11_15 = (int)var10_14.equals(var16_21);
                                                if (var11_15 == 0) ** GOTO lbl-1000
                                                var11_15 = 0;
                                                var10_14 = null;
                                                break block39;
                                            }
                                            var16_21 = "string-array";
                                            var11_15 = (int)var10_14.equals(var16_21);
                                            if (var11_15 != 0) {
                                                var11_15 = var7_11;
                                            } else lbl-1000:
                                            // 3 sources

                                            {
                                                var11_15 = var5_9;
                                            }
                                        }
                                        if (var11_15 == 0) break block40;
                                        if (var11_15 != var7_11) {
                                            if (var11_15 == var13_18) {
                                                var10_14 = var6_10.nextText();
                                                var3_7.add(var10_14);
                                            }
                                            break block36;
                                        } else {
                                            var3_7 = new ArrayList<ArrayList<E>>();
                                            var10_14 = new Object();
                                            var17_22 = var6_10.getAttributeValue(0);
                                            var17_22 = var3_7.d((String)var17_22);
                                            var17_22.f((List)var10_14);
                                            var2_2.add(var3_7);
                                            var3_7 = var10_14;
                                        }
                                        break block36;
                                    }
                                    var10_14 = new Object();
                                    var17_22 = var6_10.getAttributeValue(0);
                                    var16_21 = var6_10.nextText();
                                    var17_22 = var10_14.d((String)var17_22);
                                    var17_22.e(var16_21);
                                    var2_2.add(var10_14);
                                    break block36;
                                }
                                var10_14 = new Object();
                                var2_2 = var10_14;
                            }
                            var11_15 = var6_10.next();
                        }
                        if (var1_1 == null) return new Pair(var8_12, var2_2);
                        try {
                            var1_1.close();
                            return new Pair(var8_12, var2_2);
                        }
                        catch (IOException v2) {}
                        catch (Throwable var2_4) {
                            var3_7 = var1_1;
                            break block33;
                        }
                        catch (Exception v3) {}
                    }
                    var3_7 = var1_1;
                    break block34;
                    catch (Throwable var2_5) {
                        break block33;
                    }
                    catch (Exception v4) {
                        var4_8 = false;
                        var8_12 = null;
                    }
                }
                var1_1 = "StringXmlParser";
                var18_23 = "\u89e3\u6790\u9519\u8bef";
                {
                    Log.d((String)var1_1, (String)var18_23);
                    if (var3_7 == null) return new Pair(var8_12, var2_2);
                }
                var3_7.close();
                return new Pair(var8_12, var2_2);
            }
            if (var3_7 == null) throw var2_6;
            try {}
            catch (IOException v5) {
                throw var2_6;
            }
            break block41;
            return new Pair(var8_12, var2_2);
        }
        var3_7.close();
        throw var2_6;
    }

    private String m(String string2) {
        int n10;
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (bl2) {
            return string2;
        }
        String string3 = "_";
        String string4 = string2.replace("-", string3);
        int n11 = string4.indexOf(string3);
        if (n11 == (n10 = -1)) {
            return string2;
        }
        ++n11;
        if ((n11 = (int)(Character.isUpperCase(string4.charAt(n11)) ? 1 : 0)) != 0) {
            return string2;
        }
        return string4.replace("r", "");
    }

    public List a(String ... object) {
        Object object2 = null;
        object = object[0];
        if ((object = this.b((String)object)) == null) {
            return null;
        }
        object = Arrays.stream(object);
        object2 = new h(this);
        object = object.map(object2);
        object2 = Collectors.toList();
        return (List)object.collect(object2);
    }

    public void k(List object) {
        boolean bl2;
        if (object != null && !(bl2 = object.isEmpty())) {
            p.b();
            f f10 = f.a;
            object.forEach(f10);
            object = this.d;
            if (object != null) {
                object.onSuccess();
            }
            return;
        }
        object = this.d;
        if (object != null) {
            String string2 = "\u8d44\u6e90\u89e3\u6790\u9519\u8bef";
            object.onFailed(string2);
        }
    }

    public void onPreExecute() {
        super.onPreExecute();
        q$a q$a = this.d;
        if (q$a != null) {
            q$a.onStart();
        }
    }
}

