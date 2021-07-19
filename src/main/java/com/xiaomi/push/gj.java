/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.os.Parcelable
 *  android.text.TextUtils
 */
package com.xiaomi.push;

import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.xiaomi.push.gg;
import com.xiaomi.push.gk;
import com.xiaomi.push.gn;
import com.xiaomi.push.gu;
import j$.util.DesugarTimeZone;
import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public abstract class gj {
    private static long a;
    public static final String a;
    public static final DateFormat a;
    private static String b;
    private static String c;
    private gn a;
    private List a;
    private final Map a;
    private String d;
    private String e;
    private String f;
    private String g;
    private String h;
    private String i;

    static {
        a = Locale.getDefault().getLanguage().toLowerCase();
        b = null;
        Serializable serializable = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        a = serializable;
        Object object = DesugarTimeZone.getTimeZone("UTC");
        ((DateFormat)serializable).setTimeZone((TimeZone)object);
        serializable = new StringBuilder();
        object = gu.a(5);
        ((StringBuilder)serializable).append((String)object);
        ((StringBuilder)serializable).append("-");
        c = ((StringBuilder)serializable).toString();
        a = 0L;
    }

    public gj() {
        Cloneable cloneable;
        String string2;
        this.d = string2 = b;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.a = cloneable = new Cloneable();
        this.a = cloneable;
        this.a = null;
    }

    public gj(Bundle bundle) {
        Cloneable cloneable;
        Object object = b;
        this.d = object;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.a = cloneable = new Cloneable();
        this.a = cloneable;
        this.a = null;
        object = bundle.getString("ext_to");
        this.f = object;
        object = bundle.getString("ext_from");
        this.g = object;
        object = bundle.getString("ext_chid");
        this.h = object;
        object = bundle.getString("ext_pkt_id");
        this.e = object;
        object = bundle.getParcelableArray("ext_exts");
        if (object != null) {
            int n10 = ((Parcelable[])object).length;
            super(n10);
            this.a = cloneable;
            int n11 = ((Parcelable[])object).length;
            for (n10 = 0; n10 < n11; ++n10) {
                gg gg2 = gg.a((Bundle)object[n10]);
                if (gg2 == null) continue;
                List list = this.a;
                list.add(gg2);
            }
        }
        if ((bundle = bundle.getBundle((String)(object = "ext_ERROR"))) != null) {
            super(bundle);
            this.a = object;
        }
    }

    public static String i() {
        Class<gj> clazz = gj.class;
        synchronized (clazz) {
            long l10;
            CharSequence charSequence = new StringBuilder();
            String string2 = c;
            charSequence.append(string2);
            long l11 = a;
            a = l10 = 1L + l11;
            string2 = Long.toString(l11);
            charSequence.append(string2);
            charSequence = charSequence.toString();
            return charSequence;
        }
    }

    public static String q() {
        return a;
    }

    public Bundle a() {
        String string2;
        Bundle bundle = new Bundle();
        Object object = this.d;
        int n10 = TextUtils.isEmpty((CharSequence)object);
        if (n10 == 0) {
            object = this.d;
            string2 = "ext_ns";
            bundle.putString(string2, (String)object);
        }
        if ((n10 = TextUtils.isEmpty((CharSequence)(object = this.g))) == 0) {
            object = this.g;
            string2 = "ext_from";
            bundle.putString(string2, (String)object);
        }
        if ((n10 = TextUtils.isEmpty((CharSequence)(object = this.f))) == 0) {
            object = this.f;
            string2 = "ext_to";
            bundle.putString(string2, (String)object);
        }
        if ((n10 = TextUtils.isEmpty((CharSequence)(object = this.e))) == 0) {
            object = this.e;
            string2 = "ext_pkt_id";
            bundle.putString(string2, (String)object);
        }
        if ((n10 = TextUtils.isEmpty((CharSequence)(object = this.h))) == 0) {
            object = this.h;
            string2 = "ext_chid";
            bundle.putString(string2, (String)object);
        }
        if ((object = this.a) != null) {
            object = object.a();
            string2 = "ext_ERROR";
            bundle.putBundle(string2, (Bundle)object);
        }
        if ((object = this.a) != null) {
            boolean bl2;
            n10 = object.size();
            object = new Bundle[n10];
            int n11 = 0;
            string2 = null;
            Iterator iterator2 = this.a.iterator();
            while (bl2 = iterator2.hasNext()) {
                Bundle bundle2 = ((gg)iterator2.next()).a();
                if (bundle2 == null) continue;
                int n12 = n11 + 1;
                object[n11] = bundle2;
                n11 = n12;
            }
            string2 = "ext_exts";
            bundle.putParcelableArray(string2, (Parcelable[])object);
        }
        return bundle;
    }

    public gg a(String string2) {
        return this.a(string2, null);
    }

    public gg a(String string2, String string3) {
        boolean bl2;
        Iterator iterator2 = this.a.iterator();
        while (bl2 = iterator2.hasNext()) {
            String string4;
            boolean bl3;
            gg gg2 = (gg)iterator2.next();
            if (string3 != null && !(bl3 = string3.equals(string4 = gg2.b())) || !(bl3 = string2.equals(string4 = gg2.a()))) continue;
            return gg2;
        }
        return null;
    }

    public gn a() {
        return this.a;
    }

    public Object a(String string2) {
        synchronized (this) {
            Map map;
            block5: {
                map = this.a;
                if (map != null) break block5;
                return null;
            }
            string2 = map.get(string2);
            return string2;
        }
    }

    public abstract String a();

    public Collection a() {
        synchronized (this) {
            List list = this.a;
            if (list == null) {
                list = Collections.emptyList();
                return list;
            }
            List list2 = this.a;
            list = new List(list2);
            list = Collections.unmodifiableList(list);
            return list;
        }
    }

    public void a(gg gg2) {
        this.a.add(gg2);
    }

    public void a(gn gn2) {
        this.a = gn2;
    }

    public Collection b() {
        synchronized (this) {
            Set set = this.a;
            if (set == null) {
                set = Collections.emptySet();
                return set;
            }
            Object object = this.a;
            object = object.keySet();
            set = new Set(object);
            set = Collections.unmodifiableSet(set);
            return set;
        }
    }

    public boolean equals(Object object) {
        block11: {
            boolean bl2;
            block13: {
                block14: {
                    block12: {
                        boolean bl3;
                        Object object2;
                        Object object3;
                        bl2 = true;
                        if (this == object) {
                            return bl2;
                        }
                        if (object == null || (object3 = this.getClass()) != (object2 = object.getClass())) break block11;
                        object = (gj)object;
                        object3 = this.a;
                        if (object3 != null ? !(bl3 = object3.equals(object2 = ((gj)object).a)) : (object3 = ((gj)object).a) != null) {
                            return false;
                        }
                        object3 = this.g;
                        if (object3 != null ? !(bl3 = ((String)object3).equals(object2 = ((gj)object).g)) : (object3 = ((gj)object).g) != null) {
                            return false;
                        }
                        object3 = this.a;
                        object2 = ((gj)object).a;
                        bl3 = object3.equals(object2);
                        if (!bl3) {
                            return false;
                        }
                        object3 = this.e;
                        if (object3 != null ? !(bl3 = ((String)object3).equals(object2 = ((gj)object).e)) : (object3 = ((gj)object).e) != null) {
                            return false;
                        }
                        object3 = this.h;
                        if (object3 != null ? !(bl3 = ((String)object3).equals(object2 = ((gj)object).h)) : (object3 = ((gj)object).h) != null) {
                            return false;
                        }
                        object3 = this.a;
                        if (object3 != null ? !(bl3 = object3.equals(object2 = ((gj)object).a)) : (object3 = ((gj)object).a) != null) {
                            return false;
                        }
                        object3 = this.f;
                        if (object3 != null ? !(bl3 = ((String)object3).equals(object2 = ((gj)object).f)) : (object3 = ((gj)object).f) != null) {
                            return false;
                        }
                        object3 = this.d;
                        object = ((gj)object).d;
                        if (object3 == null) break block12;
                        boolean bl4 = ((String)object3).equals(object);
                        if (bl4) break block13;
                        break block14;
                    }
                    if (object == null) break block13;
                }
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public int hashCode() {
        int n10;
        int n11;
        String string2 = this.d;
        int n12 = 0;
        if (string2 != null) {
            n11 = string2.hashCode();
        } else {
            n11 = 0;
            string2 = null;
        }
        n11 *= 31;
        Object object = this.e;
        if (object != null) {
            n10 = ((String)object).hashCode();
        } else {
            n10 = 0;
            object = null;
        }
        n11 = (n11 + n10) * 31;
        object = this.f;
        if (object != null) {
            n10 = ((String)object).hashCode();
        } else {
            n10 = 0;
            object = null;
        }
        n11 = (n11 + n10) * 31;
        object = this.g;
        if (object != null) {
            n10 = ((String)object).hashCode();
        } else {
            n10 = 0;
            object = null;
        }
        n11 = (n11 + n10) * 31;
        object = this.h;
        if (object != null) {
            n10 = ((String)object).hashCode();
        } else {
            n10 = 0;
            object = null;
        }
        n11 = (n11 + n10) * 31;
        n10 = this.a.hashCode();
        n11 = (n11 + n10) * 31;
        n10 = this.a.hashCode();
        n11 = (n11 + n10) * 31;
        object = this.a;
        if (object != null) {
            n12 = object.hashCode();
        }
        return n11 + n12;
    }

    public String j() {
        String string2 = "ID_NOT_AVAILABLE";
        String string3 = this.e;
        boolean bl2 = string2.equals(string3);
        if (bl2) {
            return null;
        }
        string3 = this.e;
        if (string3 == null) {
            this.e = string3 = gj.i();
        }
        return this.e;
    }

    public String k() {
        return this.h;
    }

    public void k(String string2) {
        this.e = string2;
    }

    public String l() {
        return this.f;
    }

    public void l(String string2) {
        this.h = string2;
    }

    public String m() {
        return this.g;
    }

    public void m(String string2) {
        this.f = string2;
    }

    public String n() {
        return this.i;
    }

    public void n(String string2) {
        this.g = string2;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public String o() {
        synchronized (this) {
            var1_1 = new StringBuilder();
            var2_6 = this.a();
            var2_6 = var2_6.iterator();
            while (var3_7 = var2_6.hasNext()) {
                var4_8 /* !! */  = var2_6.next();
                var4_8 /* !! */  = (gk)var4_8 /* !! */ ;
                var4_8 /* !! */  = var4_8 /* !! */ .d();
                var1_1.append((String)var4_8 /* !! */ );
            }
            var2_6 = this.a;
            if (var2_6 == null) return var1_1.toString();
            var5_10 = var2_6.isEmpty();
            if (var5_10 != false) return var1_1.toString();
            var2_6 = "<properties xmlns=\"http://www.jivesoftware.com/xmlns/xmpp/properties\">";
            var1_1.append((String)var2_6);
            var2_6 = this.b();
            var2_6 = var2_6.iterator();
            while (var3_7 = var2_6.hasNext()) {
                block49: {
                    block42: {
                        block40: {
                            block44: {
                                block41: {
                                    block43: {
                                        block48: {
                                            block47: {
                                                block46: {
                                                    block45: {
                                                        var4_8 /* !! */  = var2_6.next();
                                                        var4_8 /* !! */  = (String)var4_8 /* !! */ ;
                                                        var6_11 = this.a((String)var4_8 /* !! */ );
                                                        var7_14 = "<property>";
                                                        var1_1.append((String)var7_14);
                                                        var7_14 = "<name>";
                                                        var1_1.append((String)var7_14);
                                                        var4_8 /* !! */  = gu.a(var4_8 /* !! */ );
                                                        var1_1.append((String)var4_8 /* !! */ );
                                                        var4_8 /* !! */  = "</name>";
                                                        var1_1.append((String)var4_8 /* !! */ );
                                                        var4_8 /* !! */  = "<value type=\"";
                                                        var1_1.append((String)var4_8 /* !! */ );
                                                        var3_7 = var6_11 instanceof Integer;
                                                        if (var3_7) {
                                                            var4_8 /* !! */  = "integer\">";
                                                            var1_1.append((String)var4_8 /* !! */ );
                                                            var1_1.append(var6_11);
                                                            var4_8 /* !! */  = "</value>";
lbl48:
                                                            // 6 sources

                                                            while (true) {
                                                                var1_1.append((String)var4_8 /* !! */ );
                                                                break block40;
                                                                break;
                                                            }
                                                        }
                                                        var3_7 = var6_11 instanceof Long;
                                                        if (!var3_7) break block45;
                                                        var4_8 /* !! */  = "long\">";
                                                        var1_1.append((String)var4_8 /* !! */ );
                                                        var1_1.append(var6_11);
                                                        var4_8 /* !! */  = "</value>";
                                                        ** GOTO lbl48
                                                    }
                                                    var3_7 = var6_11 instanceof Float;
                                                    if (!var3_7) break block46;
                                                    var4_8 /* !! */  = "float\">";
                                                    var1_1.append((String)var4_8 /* !! */ );
                                                    var1_1.append(var6_11);
                                                    var4_8 /* !! */  = "</value>";
                                                    ** GOTO lbl48
                                                }
                                                var3_7 = var6_11 instanceof Double;
                                                if (!var3_7) break block47;
                                                var4_8 /* !! */  = "double\">";
                                                var1_1.append((String)var4_8 /* !! */ );
                                                var1_1.append(var6_11);
                                                var4_8 /* !! */  = "</value>";
                                                ** GOTO lbl48
                                            }
                                            var3_7 = var6_11 instanceof Boolean;
                                            if (!var3_7) break block48;
                                            var4_8 /* !! */  = "boolean\">";
                                            var1_1.append((String)var4_8 /* !! */ );
                                            var1_1.append(var6_11);
                                            var4_8 /* !! */  = "</value>";
                                            ** GOTO lbl48
                                        }
                                        var3_7 = var6_11 instanceof String;
                                        if (var3_7) {
                                            var4_8 /* !! */  = "string\">";
                                            var1_1.append((String)var4_8 /* !! */ );
                                            var6_11 = (String)var6_11;
                                            var4_8 /* !! */  = gu.a((String)var6_11);
                                            var1_1.append((String)var4_8 /* !! */ );
                                            var4_8 /* !! */  = "</value>";
                                            ** continue;
                                        }
                                        var3_7 = false;
                                        var4_8 /* !! */  = null;
                                        var7_14 = new ByteArrayOutputStream();
                                        var8_15 = new ObjectOutputStream((OutputStream)var7_14);
                                        var8_15.writeObject(var6_11);
                                        var4_8 /* !! */  = "java-object\">";
                                        var1_1.append((String)var4_8 /* !! */ );
                                        var4_8 /* !! */  = (E)var7_14.toByteArray();
                                        var4_8 /* !! */  = gu.a(var4_8 /* !! */ );
                                        var1_1.append((String)var4_8 /* !! */ );
                                        var4_8 /* !! */  = "</value>";
                                        var1_1.append((String)var4_8 /* !! */ );
                                        var8_15.close();
lbl123:
                                        // 3 sources

                                        while (true) {
                                            var7_14.close();
                                            break block40;
                                            break;
                                        }
                                        catch (Exception var4_9) {
                                            break block41;
                                        }
                                        catch (Throwable var1_2) {
                                            break block42;
                                        }
                                        catch (Exception var6_12) {
                                            var8_15 = null;
                                            break block43;
                                        }
                                        catch (Throwable var1_3) {
                                            var7_14 = null;
                                            break block42;
                                        }
                                        catch (Exception var6_13) {
                                            var7_14 = null;
                                            var8_15 = null;
                                        }
                                    }
                                    var4_8 /* !! */  = var6_11;
                                }
                                var4_8 /* !! */ .printStackTrace();
                                if (var8_15 == null) break block44;
                                try {
                                    var8_15.close();
                                }
                                catch (Exception v2) {
                                    ** continue;
                                }
                            }
lbl149:
                            // 2 sources

                            while (true) {
                                if (var7_14 == null) break block40;
                                ** GOTO lbl123
                                break;
                            }
                            catch (Exception v0) {}
                        }
                        var4_8 /* !! */  = "</property>";
                        var1_1.append((String)var4_8 /* !! */ );
                        continue;
                        catch (Throwable var1_4) {
                            var4_8 /* !! */  = var8_15;
                        }
                    }
                    if (var4_8 /* !! */  != null) {
                        ** try [egrp 16[TRYBLOCK] [67 : 627->632)] { 
lbl163:
                        // 1 sources

                        break block49;
                    } else lbl-1000:
                    // 3 sources

                    {
                        while (true) {
                            if (var7_14 == null) throw var1_5;
                            var7_14.close();
                            throw var1_5;
                            break;
                        }
                    }
lbl169:
                    // 1 sources

                    catch (Exception v1) {
                        ** GOTO lbl-1000
                    }
                    catch (Exception v3) {
                        ** continue;
                    }
                }
                var4_8 /* !! */ .close();
                ** continue;
            }
            var2_6 = "</properties>";
            var1_1.append((String)var2_6);
            return var1_1.toString();
            catch (Exception v4) {
                throw var1_5;
            }
        }
    }

    public void o(String string2) {
        this.i = string2;
    }

    public String p() {
        return this.d;
    }
}

