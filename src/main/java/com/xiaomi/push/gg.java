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
import com.xiaomi.push.gk;
import com.xiaomi.push.gu;
import java.util.ArrayList;
import java.util.List;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class gg
implements gk {
    private String a;
    private List a;
    private String[] a = null;
    private String b;
    private String[] b = null;
    private String c;

    public gg(String string2, String string3, String[] stringArray, String[] stringArray2) {
        this.a = string2;
        this.b = string3;
        this.a = stringArray;
        this.b = stringArray2;
    }

    public gg(String string2, String string3, String[] stringArray, String[] stringArray2, String string4, List list) {
        this.a = string2;
        this.b = string3;
        this.a = stringArray;
        this.b = stringArray2;
        this.c = string4;
        this.a = list;
    }

    public static gg a(Bundle object) {
        boolean bl2;
        String string2 = object.getString("ext_ele_name");
        String string3 = object.getString("ext_ns");
        String string4 = object.getString("ext_text");
        Object object2 = object.getBundle("attributes");
        Object object3 = object2.keySet();
        int n10 = object3.size();
        String[] stringArray = new String[n10];
        int n11 = object3.size();
        String[] stringArray2 = new String[n11];
        object3 = object3.iterator();
        int n12 = 0;
        Object object4 = null;
        int n13 = 0;
        gg gg2 = null;
        while (bl2 = object3.hasNext()) {
            String string5;
            stringArray[n13] = string5 = (String)object3.next();
            stringArray2[n13] = string5 = object2.getString(string5);
            ++n13;
        }
        object2 = "children";
        int n14 = object.containsKey((String)object2);
        if (n14 != 0) {
            object = object.getParcelableArray((String)object2);
            n14 = ((Parcelable[])object).length;
            object2 = new ArrayList(n14);
            n14 = ((Parcelable[])object).length;
            while (n12 < n14) {
                gg2 = gg.a((Bundle)object[n12]);
                object2.add(gg2);
                ++n12;
            }
            object4 = object2;
        } else {
            object = null;
            n12 = 0;
            object4 = null;
        }
        object3 = object;
        object = new gg(string2, string3, stringArray, stringArray2, string4, (List)object4);
        return object;
    }

    public static Parcelable[] a(List list) {
        gg[] ggArray = new gg[list.size()];
        return gg.a(list.toArray(ggArray));
    }

    public static Parcelable[] a(gg[] ggArray) {
        int n10;
        if (ggArray == null) {
            return null;
        }
        int n11 = ggArray.length;
        Parcelable[] parcelableArray = new Parcelable[n11];
        for (int i10 = 0; i10 < (n10 = ggArray.length); ++i10) {
            Parcelable parcelable;
            parcelableArray[i10] = parcelable = ggArray[i10].a();
        }
        return parcelableArray;
    }

    public Bundle a() {
        int n10;
        int n11;
        Bundle bundle = new Bundle();
        Parcelable[] parcelableArray = this.a;
        bundle.putString("ext_ele_name", (String)parcelableArray);
        parcelableArray = this.b;
        bundle.putString("ext_ns", (String)parcelableArray);
        parcelableArray = this.c;
        bundle.putString("ext_text", (String)parcelableArray);
        parcelableArray = new Bundle();
        Object object = this.a;
        if (object != null && (n11 = ((String[])object).length) > 0) {
            Object object2;
            int n12;
            object = null;
            for (n11 = 0; n11 < (n12 = ((String[])(object2 = this.a)).length); ++n11) {
                object2 = object2[n11];
                String string2 = this.b[n11];
                parcelableArray.putString((String)object2, string2);
            }
        }
        object = "attributes";
        bundle.putBundle((String)object, (Bundle)parcelableArray);
        parcelableArray = this.a;
        if (parcelableArray != null && (n10 = parcelableArray.size()) > 0) {
            parcelableArray = gg.a(this.a);
            object = "children";
            bundle.putParcelableArray((String)object, parcelableArray);
        }
        return bundle;
    }

    public Parcelable a() {
        return this.a();
    }

    public String a() {
        return this.a;
    }

    public String a(String object) {
        if (object != null) {
            String[] stringArray = this.a;
            if (stringArray != null) {
                Object object2;
                int n10;
                stringArray = null;
                for (int i10 = 0; i10 < (n10 = ((String[])(object2 = this.a)).length); ++i10) {
                    boolean bl2 = ((String)object).equals(object2 = object2[i10]);
                    if (!bl2) continue;
                    return this.b[i10];
                }
            }
            return null;
        }
        object = new IllegalArgumentException();
        throw object;
    }

    public void a(String string2) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (!bl2) {
            string2 = gu.a(string2);
        }
        this.c = string2;
    }

    public String b() {
        return this.b;
    }

    public String c() {
        String string2 = this.c;
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (!bl2) {
            return gu.b(this.c);
        }
        return this.c;
    }

    /*
     * Enabled aggressive block sorting
     */
    public String d() {
        Object object;
        StringBuilder stringBuilder;
        block7: {
            String string2;
            String string3;
            block6: {
                int n10;
                int n11;
                block5: {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("<");
                    object = this.a;
                    stringBuilder.append((String)object);
                    object = this.b;
                    n11 = TextUtils.isEmpty((CharSequence)object);
                    string3 = " ";
                    string2 = "\"";
                    if (n11 == 0) {
                        stringBuilder.append(string3);
                        stringBuilder.append("xmlns=");
                        stringBuilder.append(string2);
                        object = this.b;
                        stringBuilder.append((String)object);
                        stringBuilder.append(string2);
                    }
                    if ((object = this.a) != null && (n11 = ((String[])object).length) > 0) {
                        String[] stringArray;
                        object = null;
                        for (n11 = 0; n11 < (n10 = (stringArray = this.a).length); ++n11) {
                            String string4 = this.b[n11];
                            n10 = (int)(TextUtils.isEmpty((CharSequence)string4) ? 1 : 0);
                            if (n10 != 0) continue;
                            stringBuilder.append(string3);
                            String string5 = this.a[n11];
                            stringBuilder.append(string5);
                            stringBuilder.append("=\"");
                            String string6 = gu.a(this.b[n11]);
                            stringBuilder.append(string6);
                            stringBuilder.append(string2);
                        }
                    }
                    object = this.c;
                    n11 = (int)(TextUtils.isEmpty((CharSequence)object) ? 1 : 0);
                    string3 = "</";
                    string2 = ">";
                    if (n11 != 0) break block5;
                    stringBuilder.append(string2);
                    object = this.c;
                    stringBuilder.append((String)object);
                    break block6;
                }
                object = this.a;
                if (object != null && (n11 = object.size()) > 0) {
                    stringBuilder.append(string2);
                    object = this.a.iterator();
                    while ((n10 = (int)(object.hasNext() ? 1 : 0)) != 0) {
                        String string7 = ((gg)object.next()).d();
                        stringBuilder.append(string7);
                    }
                }
                break block7;
            }
            stringBuilder.append(string3);
            object = this.a;
            stringBuilder.append((String)object);
            stringBuilder.append(string2);
            return stringBuilder.toString();
        }
        object = "/>";
        stringBuilder.append((String)object);
        return stringBuilder.toString();
    }

    public String toString() {
        return this.d();
    }
}

