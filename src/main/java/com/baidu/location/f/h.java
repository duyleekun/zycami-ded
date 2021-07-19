/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.net.wifi.ScanResult
 *  android.os.Build$VERSION
 *  android.os.SystemClock
 *  android.text.TextUtils
 */
package com.baidu.location.f;

import android.net.wifi.ScanResult;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import com.baidu.location.f.i;
import com.baidu.location.h.l;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class h {
    public List a = null;
    private long b;
    private long c;
    private boolean d;
    private boolean e;

    public h(List list, long l10) {
        long l11;
        long l12;
        this.b = l12 = 0L;
        this.c = l12;
        this.d = false;
        this.b = l10;
        this.a = list;
        this.c = l11 = System.currentTimeMillis();
        try {
            this.o();
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    private boolean a(String object) {
        boolean bl2;
        int n10 = TextUtils.isEmpty((CharSequence)object);
        if (n10 != 0) {
            bl2 = false;
            object = null;
        } else {
            n10 = 2;
            String string2 = "wpa|wep";
            Pattern pattern = Pattern.compile(string2, n10);
            object = pattern.matcher((CharSequence)object);
            bl2 = ((Matcher)object).find();
        }
        return bl2;
    }

    private String b(String string2) {
        if (string2 != null) {
            String string3 = "&";
            boolean bl2 = string2.contains(string3);
            String string4 = ";";
            if (bl2 || (bl2 = string2.contains(string4))) {
                String string5 = "_";
                string2 = string2.replace(string3, string5).replace(string4, string5);
            }
        }
        return string2;
    }

    private int n() {
        List list = this.a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    private void o() {
        int n10 = this.n();
        int n11 = 1;
        float f10 = Float.MIN_VALUE;
        if (n10 < n11) {
            return;
        }
        List list = this.a;
        int n12 = n11;
        for (n10 = list.size() - n11; n10 >= n11 && n12 != 0; n10 += -1) {
            int n13 = 0;
            ScanResult scanResult = null;
            for (n12 = 0; n12 < n10; ++n12) {
                Object object = this.a.get(n12);
                if (object == null) continue;
                object = this.a;
                int n14 = n12 + 1;
                if ((object = object.get(n14)) == null) continue;
                object = (ScanResult)this.a.get(n12);
                int n15 = ((ScanResult)object).level;
                Object object2 = (ScanResult)this.a.get(n14);
                int n16 = object2.level;
                if (n15 >= n16) continue;
                scanResult = (ScanResult)this.a.get(n14);
                object = this.a;
                object2 = object.get(n12);
                object.set(n14, object2);
                object = this.a;
                object.set(n12, scanResult);
                n13 = n11;
            }
            n12 = n13;
        }
    }

    public int a() {
        List list = this.a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public String a(int n10) {
        return this.a(n10, false, false);
    }

    /*
     * Exception decompiling
     */
    public String a(int var1_1, boolean var2_2, boolean var3_3) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Back jump on a try block [egrp 13[TRYBLOCK] [33, 32 : 301->306)] java.lang.Exception
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op02WithProcessedDataAndRefs.insertExceptionBlocks(Op02WithProcessedDataAndRefs.java:2289)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:414)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1042)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:929)
         *     at org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:257)
         *     at org.benf.cfr.reader.Driver.doJar(Driver.java:139)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:73)
         *     at org.benf.cfr.reader.Main.main(Main.java:49)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    public boolean a(long l10) {
        int n10;
        long l11;
        h h10 = this;
        int n11 = Build.VERSION.SDK_INT;
        long l12 = 1000L;
        long l13 = 0L;
        int n12 = 17;
        if (n11 >= n12) {
            l11 = SystemClock.elapsedRealtimeNanos();
            try {
                l11 /= l12;
            }
            catch (Error | Exception throwable) {
                l11 = l13;
            }
            n11 = (int)(l11 == l13 ? 0 : (l11 < l13 ? -1 : 1));
            n11 = n11 > 0 ? 1 : 0;
        } else {
            n11 = 0;
            l11 = l13;
        }
        if (n11 == 0) {
            return false;
        }
        List list = h10.a;
        if (list != null && (n10 = list.size()) != 0) {
            long l14;
            int n13;
            Object object;
            int n14;
            list = h10.a;
            n10 = list.size();
            if (n10 > (n14 = 16)) {
                n10 = n14;
            }
            long l15 = l13;
            long l16 = l13;
            for (n14 = 0; n14 < n10; ++n14) {
                object = h10.a.get(n14);
                if (object != null) {
                    object = (ScanResult)h10.a.get(n14);
                    n13 = ((ScanResult)object).level;
                    if (n13 != 0 && n11 != 0) {
                        object = h10.a;
                        object = object.get(n14);
                        object = (ScanResult)object;
                        l13 = ((ScanResult)object).timestamp;
                        l13 = l11 - l13;
                        long l17 = 1000000L;
                        try {
                            l13 /= l17;
                        }
                        catch (Error | Exception throwable) {
                            l13 = 0L;
                        }
                        l15 += l13;
                        n13 = l13 == l16 ? 0 : (l13 < l16 ? -1 : 1);
                        if (n13 > 0) {
                            l16 = l13;
                        }
                    }
                }
                l13 = 0L;
            }
            long l18 = n10;
            l15 /= l18;
            long l19 = (l16 *= l12) - l10;
            n11 = (int)(l19 == 0L ? 0 : (l19 < 0L ? -1 : 1));
            if (n11 <= 0 && (n11 = (int)((l14 = (l15 *= l12) - l10) == 0L ? 0 : (l14 < 0L ? -1 : 1))) <= 0) {
                n13 = 0;
                object = null;
            } else {
                n13 = 1;
            }
            return n13 != 0;
        }
        return false;
    }

    public boolean a(h h10) {
        List list;
        List list2 = this.a;
        if (list2 != null && h10 != null && (list = h10.a) != null) {
            int n10;
            int n11 = list2.size();
            list2 = n11 < (n10 = (list = h10.a).size()) ? this.a : h10.a;
            n11 = list2.size();
            list = null;
            for (n10 = 0; n10 < n11; ++n10) {
                boolean bl2;
                Object object = this.a.get(n10);
                if (object == null) continue;
                object = ((ScanResult)this.a.get((int)n10)).BSSID;
                String string2 = ((ScanResult)h10.a.get((int)n10)).BSSID;
                boolean bl3 = TextUtils.isEmpty(object);
                if (bl3 || (bl2 = ((String)object).equals(string2))) continue;
                return false;
            }
            return true;
        }
        return false;
    }

    public String b() {
        boolean bl2;
        int n10;
        try {
            n10 = l.Q;
            bl2 = true;
        }
        catch (Exception exception) {
            return null;
        }
        return this.a(n10, bl2, bl2);
    }

    public String b(int n10) {
        int n11;
        int n12 = this.a();
        if (n12 < (n11 = 1)) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer(512);
        List list = this.a;
        int n13 = list.size();
        if (n13 <= n10) {
            n10 = n13;
        }
        n13 = 0;
        list = null;
        int n14 = n11;
        for (int i10 = 0; i10 < n10; ++i10) {
            Object object = this.a.get(i10);
            if (object == null) continue;
            object = (ScanResult)this.a.get(i10);
            int n15 = ((ScanResult)object).level;
            if (n15 == 0 || (object = ((ScanResult)this.a.get((int)i10)).BSSID) == null) continue;
            if (n14 != 0) {
                n14 = 0;
            } else {
                object = "|";
                stringBuffer.append((String)object);
            }
            object = ((ScanResult)this.a.get((int)i10)).BSSID;
            Object object2 = ":";
            Object[] objectArray = "";
            object = ((String)object).replace((CharSequence)object2, (CharSequence)objectArray);
            stringBuffer.append((String)object);
            object = (ScanResult)this.a.get(i10);
            n15 = ((ScanResult)object).level;
            if (n15 < 0) {
                n15 = -n15;
            }
            object2 = Locale.CHINA;
            objectArray = new Object[n11];
            objectArray[0] = object = Integer.valueOf(n15);
            object = String.format((Locale)object2, ";%d;", objectArray);
            stringBuffer.append((String)object);
        }
        if (n14 == 0) {
            return stringBuffer.toString();
        }
        return null;
    }

    public boolean b(h h10) {
        List list;
        List list2 = this.a;
        if (list2 != null && h10 != null && (list = h10.a) != null) {
            int n10;
            int n11 = list2.size();
            list2 = n11 < (n10 = (list = h10.a).size()) ? this.a : h10.a;
            n11 = list2.size();
            list = null;
            for (n10 = 0; n10 < n11; ++n10) {
                boolean bl2;
                Object object = this.a.get(n10);
                if (object == null) continue;
                object = ((ScanResult)this.a.get((int)n10)).BSSID;
                ScanResult scanResult = (ScanResult)this.a.get(n10);
                int n12 = scanResult.level;
                String string2 = ((ScanResult)h10.a.get((int)n10)).BSSID;
                ScanResult scanResult2 = (ScanResult)h10.a.get(n10);
                int n13 = scanResult2.level;
                boolean bl3 = TextUtils.isEmpty(object);
                if ((bl3 || (bl2 = ((String)object).equals(string2))) && n12 == n13) continue;
                return false;
            }
            return true;
        }
        return false;
    }

    public String c() {
        boolean bl2;
        int n10;
        try {
            n10 = l.Q;
            bl2 = true;
        }
        catch (Exception exception) {
            return null;
        }
        return this.a(n10, bl2, false);
    }

    public String c(int n10) {
        int n11;
        int n12;
        if (n10 != 0 && (n12 = this.a()) >= (n11 = 1)) {
            int n13;
            StringBuffer stringBuffer = new StringBuffer(256);
            List list = this.a;
            int n14 = list.size();
            if (n14 > (n13 = l.Q)) {
                n14 = n13;
            }
            int n15 = 0;
            for (n13 = 0; n13 < n14; ++n13) {
                Object object = this.a.get(n13);
                if (object == null) continue;
                int n16 = n11 & n10;
                if (n16 != 0 && (object = ((ScanResult)this.a.get((int)n13)).BSSID) != null) {
                    object = n15 == 0 ? "&ssid=" : "|";
                    stringBuffer.append((String)object);
                    object = ((ScanResult)this.a.get((int)n13)).BSSID;
                    String string2 = ":";
                    String string3 = "";
                    object = ((String)object).replace(string2, string3);
                    stringBuffer.append((String)object);
                    stringBuffer.append(";");
                    object = ((ScanResult)this.a.get((int)n13)).SSID;
                    object = this.b((String)object);
                    stringBuffer.append((String)object);
                    ++n15;
                }
                n11 <<= 1;
            }
            return stringBuffer.toString();
        }
        return null;
    }

    public boolean c(h h10) {
        return i.a(h10, this);
    }

    public String d() {
        int n10 = 15;
        try {
            return this.a(n10);
        }
        catch (Exception exception) {
            return null;
        }
    }

    public boolean e() {
        long l10 = l.ai;
        return this.a(l10);
    }

    public long f() {
        long l10;
        block17: {
            int n10;
            long l11;
            long l12;
            int n11;
            int n12;
            long l13;
            int n13;
            block20: {
                List list;
                block19: {
                    block18: {
                        list = this.a;
                        l10 = 0L;
                        if (list == null || (n13 = list.size()) == 0) break block17;
                        l13 = Integer.MAX_VALUE;
                        n13 = Build.VERSION.SDK_INT;
                        n12 = 17;
                        n11 = 0;
                        if (n13 < n12) break block18;
                        l12 = SystemClock.elapsedRealtimeNanos();
                        l11 = 1000L;
                        try {
                            l12 /= l11;
                        }
                        catch (Error | Exception throwable) {
                            l12 = l10;
                        }
                        n13 = (int)(l12 == l10 ? 0 : (l12 < l10 ? -1 : 1));
                        if (n13 <= 0) break block19;
                        n13 = 1;
                        break block20;
                    }
                    l12 = l10;
                }
                n13 = 0;
                list = null;
            }
            if (n13 == 0) {
                return l10;
            }
            List list = this.a;
            n12 = list.size();
            if (n12 > (n10 = 16)) {
                n12 = n10;
            }
            while (n11 < n12) {
                Object object = this.a.get(n11);
                if (object != null) {
                    object = (ScanResult)this.a.get(n11);
                    n10 = ((ScanResult)object).level;
                    if (n10 != 0 && n13 != 0) {
                        object = this.a;
                        object = object.get(n11);
                        object = (ScanResult)object;
                        l11 = ((ScanResult)object).timestamp;
                        l11 = l12 - l11;
                        long l14 = 1000000L;
                        try {
                            l11 /= l14;
                        }
                        catch (Error | Exception throwable) {
                            l11 = l10;
                        }
                        long l15 = l11 == l13 ? 0 : (l11 < l13 ? -1 : 1);
                        if (l15 < 0) {
                            l13 = l11;
                        }
                    }
                }
                ++n11;
            }
            if (n13 == 0) {
                l13 = l10;
            }
            n13 = (int)(l13 == l10 ? 0 : (l13 < l10 ? -1 : 1));
            if (n13 >= 0) {
                l10 = l13;
            }
        }
        return l10;
    }

    public long g() {
        long l10;
        block15: {
            int n10;
            long l11;
            long l12;
            int n11;
            int n12;
            int n13;
            block18: {
                List list;
                block17: {
                    block16: {
                        list = this.a;
                        l10 = 0L;
                        if (list == null || (n13 = list.size()) == 0) break block15;
                        n13 = Build.VERSION.SDK_INT;
                        n12 = 17;
                        n11 = 0;
                        if (n13 < n12) break block16;
                        l12 = SystemClock.elapsedRealtimeNanos();
                        l11 = 1000L;
                        try {
                            l12 /= l11;
                        }
                        catch (Error | Exception throwable) {
                            l12 = l10;
                        }
                        n13 = (int)(l12 == l10 ? 0 : (l12 < l10 ? -1 : 1));
                        if (n13 <= 0) break block17;
                        n13 = 1;
                        break block18;
                    }
                    l12 = l10;
                }
                n13 = 0;
                list = null;
            }
            if (n13 == 0) {
                return l10;
            }
            List list = this.a;
            n12 = list.size();
            if (n12 > (n10 = 16)) {
                n12 = n10;
            }
            l11 = l10;
            while (n11 < n12) {
                Object object = this.a.get(n11);
                if (object != null) {
                    object = (ScanResult)this.a.get(n11);
                    int n14 = ((ScanResult)object).level;
                    if (n14 != 0 && n13 != 0) {
                        object = this.a;
                        object = object.get(n11);
                        object = (ScanResult)object;
                        long l13 = ((ScanResult)object).timestamp;
                        l13 = l12 - l13;
                        long l14 = 1000000L;
                        try {
                            l13 /= l14;
                        }
                        catch (Error | Exception throwable) {
                            l13 = l10;
                        }
                        long l15 = l13 == l11 ? 0 : (l13 < l11 ? -1 : 1);
                        if (l15 > 0) {
                            l11 = l13;
                        }
                    }
                }
                ++n11;
            }
            return l11;
        }
        return l10;
    }

    public long h() {
        long l10;
        block16: {
            long l11;
            int n10;
            long l12;
            long l13;
            int n11;
            int n12;
            int n13;
            h h10;
            block19: {
                List list;
                block18: {
                    block17: {
                        h10 = this;
                        list = this.a;
                        l10 = 0L;
                        if (list == null || (n13 = list.size()) == 0) break block16;
                        n13 = Build.VERSION.SDK_INT;
                        n12 = 17;
                        n11 = 0;
                        if (n13 < n12) break block17;
                        l13 = SystemClock.elapsedRealtimeNanos();
                        l12 = 1000L;
                        try {
                            l13 /= l12;
                        }
                        catch (Error | Exception throwable) {
                            l13 = l10;
                        }
                        n13 = (int)(l13 == l10 ? 0 : (l13 < l10 ? -1 : 1));
                        if (n13 <= 0) break block18;
                        n13 = 1;
                        break block19;
                    }
                    l13 = l10;
                }
                n13 = 0;
                list = null;
            }
            if (n13 == 0) {
                return l10;
            }
            List list = h10.a;
            n12 = list.size();
            if (n12 > (n10 = 16)) {
                n12 = n10;
            }
            l12 = l10;
            long l14 = l10;
            long l15 = l10;
            while (true) {
                l11 = 1L;
                if (n11 >= n12) break;
                Object object = h10.a.get(n11);
                if (object != null) {
                    object = (ScanResult)h10.a.get(n11);
                    int n14 = ((ScanResult)object).level;
                    if (n14 != 0 && n13 != 0) {
                        object = h10.a;
                        object = object.get(n11);
                        object = (ScanResult)object;
                        l10 = ((ScanResult)object).timestamp;
                        l10 = l13 - l10;
                        long l16 = 1000000L;
                        try {
                            l10 /= l16;
                        }
                        catch (Error | Exception throwable) {
                            l10 = 0L;
                        }
                        l15 += l10;
                        l12 += l11;
                        long l17 = l10 == l14 ? 0 : (l10 < l14 ? -1 : 1);
                        if (l17 > 0) {
                            l14 = l10;
                        }
                    }
                }
                ++n11;
                l10 = 0L;
            }
            n13 = (int)(l12 == l11 ? 0 : (l12 < l11 ? -1 : 1));
            if (n13 > 0) {
                l15 -= l14;
                l14 = l15 / (l12 -= l11);
            }
            return l14;
        }
        return l10;
    }

    public int i() {
        int n10;
        for (int i10 = 0; i10 < (n10 = this.a()); ++i10) {
            Object object = this.a.get(i10);
            if (object == null) continue;
            object = (ScanResult)this.a.get(i10);
            n10 = -((ScanResult)object).level;
            if (n10 <= 0) continue;
            return n10;
        }
        return 0;
    }

    public boolean j() {
        return this.d;
    }

    /*
     * WARNING - void declaration
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean k() {
        void var5_7;
        long l10 = System.currentTimeMillis();
        long l11 = this.c;
        long l12 = (l10 -= l11) - (l11 = 0L);
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object > 0) {
            l10 = System.currentTimeMillis();
            l11 = this.c;
            long l13 = (l10 -= l11) - (l11 = 5000L);
            Object object2 = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
            if (object2 < 0) {
                return (boolean)var5_7;
            }
        }
        boolean bl2 = false;
        return (boolean)var5_7;
    }

    /*
     * WARNING - void declaration
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean l() {
        void var5_7;
        long l10 = System.currentTimeMillis();
        long l11 = this.c;
        long l12 = (l10 -= l11) - (l11 = 0L);
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object > 0) {
            l10 = System.currentTimeMillis();
            l11 = this.c;
            long l13 = (l10 -= l11) - (l11 = 5000L);
            Object object2 = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
            if (object2 < 0) {
                return (boolean)var5_7;
            }
        }
        boolean bl2 = false;
        return (boolean)var5_7;
    }

    /*
     * WARNING - void declaration
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean m() {
        void var5_7;
        long l10 = System.currentTimeMillis();
        long l11 = this.c;
        long l12 = (l10 -= l11) - (l11 = 0L);
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object > 0) {
            l10 = System.currentTimeMillis();
            l11 = this.b;
            long l13 = (l10 -= l11) - (l11 = 5000L);
            Object object2 = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
            if (object2 < 0) {
                return (boolean)var5_7;
            }
        }
        boolean bl2 = false;
        return (boolean)var5_7;
    }
}

