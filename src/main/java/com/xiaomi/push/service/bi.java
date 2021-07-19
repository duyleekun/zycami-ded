/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 */
package com.xiaomi.push.service;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.bf;
import com.xiaomi.push.hp;
import com.xiaomi.push.hq;
import com.xiaomi.push.hw;
import com.xiaomi.push.il;
import com.xiaomi.push.iw;
import com.xiaomi.push.ix;
import com.xiaomi.push.service.bj;
import com.xiaomi.push.t;
import com.xiaomi.push.y;
import java.io.Serializable;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class bi {
    private static String a;
    private static SimpleDateFormat a;
    private static AtomicLong a;

    static {
        Serializable serializable = new AtomicLong(0L);
        a = serializable;
        serializable = new SimpleDateFormat("yyyy/MM/dd");
        a = serializable;
        Long l10 = System.currentTimeMillis();
        a = ((Format)serializable).format(l10);
    }

    public static String a() {
        Class<bi> clazz = bi.class;
        synchronized (clazz) {
            long l10;
            Object object = a;
            long l11 = System.currentTimeMillis();
            Object object2 = l11;
            object = ((Format)object).format(object2);
            object2 = a;
            boolean bl2 = TextUtils.equals((CharSequence)object2, (CharSequence)object);
            if (!bl2) {
                object2 = a;
                l10 = 0L;
                ((AtomicLong)object2).set(l10);
                a = object;
            }
            object2 = new StringBuilder();
            ((StringBuilder)object2).append((String)object);
            object = "-";
            ((StringBuilder)object2).append((String)object);
            object = a;
            l10 = ((AtomicLong)object).incrementAndGet();
            ((StringBuilder)object2).append(l10);
            object = ((StringBuilder)object2).toString();
            return object;
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    public static ArrayList a(List object, String object2, String string2, int n10) {
        CharSequence charSequence;
        ArrayList<Object> arrayList;
        block11: {
            block10: {
                block9: {
                    arrayList = null;
                    if (object != null) break block9;
                    object = "requests can not be null in TinyDataHelper.transToThriftObj().";
                    break block10;
                }
                int n11 = object.size();
                if (n11 != 0) break block11;
                object = "requests.length is 0 in TinyDataHelper.transToThriftObj().";
            }
            b.d((String)object);
            return null;
        }
        arrayList = new ArrayList<Object>();
        Object object3 = new hp();
        int n12 = 0;
        int n13 = 0;
        il il2 = null;
        while (true) {
            int n14 = object.size();
            charSequence = "-1";
            if (n12 >= n14) break;
            Object object4 = (hq)object.get(n12);
            if (object4 != null) {
                byte[] byArray = iw.a((ix)object4);
                int n15 = byArray.length;
                if (n15 > n10) {
                    charSequence = new StringBuilder();
                    String string3 = "TinyData is too big, ignore upload request item:";
                    ((StringBuilder)charSequence).append(string3);
                    object4 = ((hq)object4).d();
                    ((StringBuilder)charSequence).append((String)object4);
                    object4 = ((StringBuilder)charSequence).toString();
                    b.d((String)object4);
                } else {
                    int n16 = n13 + n15;
                    if (n16 > n10) {
                        il2 = new il((String)charSequence, false);
                        il2.d((String)object2);
                        il2.b(string2);
                        charSequence = hw.B.a;
                        il2.c((String)charSequence);
                        object3 = y.a(iw.a((ix)object3));
                        il2.a((byte[])object3);
                        arrayList.add(il2);
                        object3 = new hp();
                        n13 = 0;
                        il2 = null;
                    }
                    ((hp)object3).a((hq)object4);
                    n13 += n15;
                }
            }
            ++n12;
        }
        int n17 = ((hp)object3).a();
        if (n17 != 0) {
            object = new il((String)charSequence, false);
            ((il)object).d((String)object2);
            ((il)object).b(string2);
            object2 = hw.B.a;
            ((il)object).c((String)object2);
            object2 = y.a(iw.a((ix)object3));
            ((il)object).a((byte[])object2);
            arrayList.add(object);
        }
        return arrayList;
    }

    public static void a(Context context, String string2, String string3, long l10, String string4) {
        hq hq2 = new hq();
        hq2.d(string2);
        hq2.c(string3);
        hq2.a(l10);
        hq2.b(string4);
        hq2.a("push_sdk_channel");
        string2 = context.getPackageName();
        hq2.g(string2);
        string2 = context.getPackageName();
        hq2.e(string2);
        hq2.a(true);
        long l11 = System.currentTimeMillis();
        hq2.b(l11);
        string2 = bi.a();
        hq2.f(string2);
        bj.a(context, hq2);
    }

    /*
     * Enabled aggressive block sorting
     */
    public static boolean a(hq object, boolean n10) {
        block9: {
            boolean bl2;
            block3: {
                int n11;
                CharSequence charSequence;
                block8: {
                    block7: {
                        block6: {
                            block5: {
                                block4: {
                                    block2: {
                                        bl2 = true;
                                        if (object != null) break block2;
                                        object = "item is null, verfiy ClientUploadDataItem failed.";
                                        break block3;
                                    }
                                    if (n10 != 0 || (n10 = (int)(TextUtils.isEmpty((CharSequence)(charSequence = ((hq)object).a)) ? 1 : 0)) == 0) break block4;
                                    object = "item.channel is null or empty, verfiy ClientUploadDataItem failed.";
                                    break block3;
                                }
                                charSequence = ((hq)object).d;
                                n10 = (int)(TextUtils.isEmpty((CharSequence)charSequence) ? 1 : 0);
                                if (n10 == 0) break block5;
                                object = "item.category is null or empty, verfiy ClientUploadDataItem failed.";
                                break block3;
                            }
                            charSequence = ((hq)object).c;
                            n10 = (int)(TextUtils.isEmpty((CharSequence)charSequence) ? 1 : 0);
                            if (n10 == 0) break block6;
                            object = "item.name is null or empty, verfiy ClientUploadDataItem failed.";
                            break block3;
                        }
                        charSequence = ((hq)object).d;
                        n10 = (int)(bf.a((String)charSequence) ? 1 : 0);
                        if (n10 != 0) break block7;
                        object = "item.category can only contain ascii char, verfiy ClientUploadDataItem failed.";
                        break block3;
                    }
                    charSequence = ((hq)object).c;
                    n10 = (int)(bf.a((String)charSequence) ? 1 : 0);
                    if (n10 != 0) break block8;
                    object = "item.name can only contain ascii char, verfiy ClientUploadDataItem failed.";
                    break block3;
                }
                charSequence = ((hq)object).b;
                if (charSequence == null || (n10 = ((String)charSequence).length()) <= (n11 = 10240)) break block9;
                charSequence = new StringBuilder();
                String string2 = "item.data is too large(";
                ((StringBuilder)charSequence).append(string2);
                int n12 = ((hq)object).b.length();
                ((StringBuilder)charSequence).append(n12);
                ((StringBuilder)charSequence).append("), max size for data is ");
                ((StringBuilder)charSequence).append(n11);
                ((StringBuilder)charSequence).append(" , verfiy ClientUploadDataItem failed.");
                object = ((StringBuilder)charSequence).toString();
            }
            b.a((String)object);
            return bl2;
        }
        return false;
    }

    public static boolean a(String string2) {
        String string3;
        boolean bl2;
        boolean bl3 = t.b();
        return !bl3 || (bl2 = (string3 = "com.miui.hybrid").equals(string2));
    }
}

