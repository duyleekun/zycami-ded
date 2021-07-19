/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 */
package com.xiaomi.clientreport.processor;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.clientreport.data.PerfClientReport;
import com.xiaomi.clientreport.data.a;
import com.xiaomi.clientreport.processor.IPerfProcessor;
import com.xiaomi.clientreport.processor.e;
import com.xiaomi.push.bj;
import java.io.File;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class b
implements IPerfProcessor {
    public Context a;
    private HashMap a;

    public b(Context context) {
        this.a = context;
    }

    public static String a(a object) {
        StringBuilder stringBuilder = new StringBuilder();
        String string2 = String.valueOf(((a)object).production);
        stringBuilder.append(string2);
        stringBuilder.append("#");
        object = ((a)object).clientInterfaceId;
        stringBuilder.append((String)object);
        return stringBuilder.toString();
    }

    private String b(a object) {
        Object object2;
        Object object3;
        boolean bl2;
        int n10 = ((a)object).production;
        object = ((a)object).clientInterfaceId;
        if (n10 > 0 && !(bl2 = TextUtils.isEmpty((CharSequence)object))) {
            object3 = new StringBuilder();
            object2 = String.valueOf(n10);
            ((StringBuilder)object3).append((String)object2);
            object2 = "#";
            ((StringBuilder)object3).append((String)object2);
            ((StringBuilder)object3).append((String)object);
            object = ((StringBuilder)object3).toString();
        } else {
            object = "";
        }
        object2 = this.a;
        object3 = "perf";
        object2 = object2.getExternalFilesDir((String)object3);
        if (object2 == null) {
            com.xiaomi.channel.commonutils.logger.b.d("cannot get folder when to write perf");
            object = null;
        } else {
            bl2 = ((File)object2).exists();
            if (!bl2) {
                ((File)object2).mkdirs();
            }
            object3 = new File((File)object2, (String)object);
            object = ((File)object3).getAbsolutePath();
        }
        return object;
    }

    private String c(a object) {
        int n10;
        object = this.b((a)object);
        int n11 = TextUtils.isEmpty((CharSequence)object);
        CharSequence charSequence = null;
        if (n11 != 0) {
            return null;
        }
        for (n11 = 0; n11 < (n10 = 20); ++n11) {
            CharSequence charSequence2 = new StringBuilder();
            charSequence2.append((String)object);
            charSequence2.append(n11);
            charSequence2 = charSequence2.toString();
            Context context = this.a;
            boolean bl2 = bj.a(context, (String)charSequence2);
            if (!bl2) continue;
            charSequence = charSequence2;
            break;
        }
        return charSequence;
    }

    public void a() {
        int n10;
        File[] fileArray = this.a;
        String string2 = "perf";
        String string3 = "perfUploading";
        bj.a((Context)fileArray, string2, string3);
        fileArray = bj.a(this.a, string3);
        if (fileArray != null && (n10 = fileArray.length) > 0) {
            n10 = fileArray.length;
            string3 = null;
            for (int i10 = 0; i10 < n10; ++i10) {
                File file = fileArray[i10];
                if (file == null) continue;
                Object object = this.a;
                String string4 = file.getAbsolutePath();
                object = e.a(object, string4);
                file.delete();
                this.a((List)object);
            }
        }
    }

    public void a(a a10) {
        PerfClientReport perfClientReport;
        boolean bl2 = a10 instanceof PerfClientReport;
        if (!bl2) {
            return;
        }
        Object object = this.a;
        if (object == null) {
            return;
        }
        a10 = (PerfClientReport)a10;
        object = b.a(a10);
        String string2 = e.a((PerfClientReport)a10);
        HashMap<String, a> hashMap = (HashMap<String, a>)this.a.get(object);
        if (hashMap == null) {
            hashMap = new HashMap<String, a>();
        }
        if ((perfClientReport = (PerfClientReport)hashMap.get(string2)) != null) {
            long l10 = ((PerfClientReport)a10).perfCounts;
            long l11 = perfClientReport.perfCounts;
            ((PerfClientReport)a10).perfCounts = l10 += l11;
            l10 = ((PerfClientReport)a10).perfLatencies;
            l11 = perfClientReport.perfLatencies;
            ((PerfClientReport)a10).perfLatencies = l10 += l11;
        }
        hashMap.put(string2, a10);
        this.a.put(object, hashMap);
    }

    public void a(List list) {
        bj.a(this.a, list);
    }

    public void a(a[] aArray) {
        Object object = aArray[0];
        boolean bl2 = TextUtils.isEmpty((CharSequence)(object = this.c((a)object)));
        if (bl2) {
            return;
        }
        e.a((String)object, aArray);
    }

    public void b() {
        Object object = this.a;
        if (object == null) {
            return;
        }
        int n10 = ((HashMap)object).size();
        if (n10 > 0) {
            boolean bl2;
            object = this.a.keySet().iterator();
            while (bl2 = object.hasNext()) {
                int n11;
                Collection collection = (String)object.next();
                a[] aArray = this.a;
                if ((collection = (HashMap)aArray.get(collection)) == null || (n11 = ((HashMap)((Object)collection)).size()) <= 0) continue;
                n11 = ((HashMap)((Object)collection)).size();
                aArray = new a[n11];
                collection = ((HashMap)((Object)collection)).values();
                collection.toArray(aArray);
                this.a(aArray);
            }
        }
        this.a.clear();
    }

    public void setPerfMap(HashMap hashMap) {
        this.a = hashMap;
    }
}

