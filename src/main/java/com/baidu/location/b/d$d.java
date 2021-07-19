/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.net.wifi.ScanResult
 *  android.os.Build$VERSION
 *  android.os.SystemClock
 */
package com.baidu.location.b;

import android.net.wifi.ScanResult;
import android.os.Build;
import android.os.SystemClock;
import com.baidu.location.b.a;
import com.baidu.location.b.d;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class d$d {
    public List a;
    public String b;
    public final /* synthetic */ d c;
    private long d;
    private String e;

    public d$d(d d10, List list) {
        long l10;
        long l11;
        this.c = d10;
        d10 = null;
        this.a = null;
        this.d = l11 = 0L;
        this.b = null;
        this.e = null;
        this.a = list;
        this.d = l10 = System.currentTimeMillis();
        try {
            this.b();
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    private void b() {
        int n10 = this.a();
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

    /*
     * WARNING - void declaration
     */
    public String a(int n10, String string2) {
        d d10;
        int n11;
        String string3;
        String string4;
        String string5;
        String string6;
        int n12;
        int n13;
        long l10;
        int n14;
        int n15;
        StringBuffer stringBuffer;
        Object[] objectArray;
        long l11;
        long l12;
        int n16;
        int n17;
        Object object;
        Object object2;
        int n18;
        int n19;
        Object object3;
        int n20;
        d$d d$d;
        block37: {
            String string7;
            int n21;
            block40: {
                block39: {
                    block38: {
                        d$d = this;
                        n20 = n10;
                        object3 = string2;
                        int n22 = this.a();
                        n19 = 0;
                        Object var8_8 = null;
                        n18 = 1;
                        if (n22 < n18) {
                            return null;
                        }
                        object2 = this.c;
                        object = com.baidu.location.b.a.a();
                        n17 = ((a)object).b;
                        com.baidu.location.b.d.b((d)object2, n17);
                        object2 = new ArrayList();
                        n17 = Build.VERSION.SDK_INT;
                        n16 = 19;
                        l12 = 0L;
                        if (n17 < n16) break block38;
                        l11 = SystemClock.elapsedRealtimeNanos();
                        long l13 = 1000L;
                        try {
                            l11 /= l13;
                        }
                        catch (Error error) {
                            l11 = l12;
                        }
                        n21 = l11 == l12 ? 0 : (l11 < l12 ? -1 : 1);
                        if (n21 <= 0) break block39;
                        n21 = n18;
                        break block40;
                    }
                    l11 = l12;
                }
                n21 = 0;
                objectArray = null;
            }
            stringBuffer = new StringBuffer(512);
            List list = d$d.a;
            n15 = list.size();
            n14 = n18;
            l10 = l12;
            n13 = 0;
            int n23 = 0;
            Long l14 = null;
            int n24 = 0;
            n12 = 0;
            while (true) {
                string6 = ";%d;";
                string5 = ":";
                string7 = "";
                string4 = "|";
                if (n13 >= n15) break;
                Object e10 = d$d.a.get(n13);
                if (e10 != null) {
                    ScanResult scanResult = (ScanResult)d$d.a.get(n13);
                    n18 = scanResult.level;
                    if (n18 != 0) {
                        ++n23;
                        if (n14 != 0) {
                            String string8 = "&wf=";
                            stringBuffer.append(string8);
                            n14 = 0;
                        } else {
                            stringBuffer.append(string4);
                        }
                        String string9 = ((ScanResult)d$d.a.get((int)n13)).BSSID.replace(string5, string7);
                        stringBuffer.append(string9);
                        if (object3 != null && (n18 = (int)(string9.equals(object3) ? 1 : 0)) != 0) {
                            n12 = n23;
                        }
                        ScanResult scanResult2 = (ScanResult)d$d.a.get(n13);
                        n18 = scanResult2.level;
                        if (n18 < 0) {
                            n18 = -n18;
                        }
                        object3 = Locale.CHINA;
                        string3 = string7;
                        int n25 = n23;
                        Object[] objectArray2 = new Object[1];
                        Integer n26 = n18;
                        n23 = 0;
                        l14 = null;
                        objectArray2[0] = n26;
                        object3 = String.format((Locale)object3, string6, objectArray2);
                        stringBuffer.append((String)object3);
                        n11 = n24 + 1;
                        if (n21 != 0) {
                            List list2 = d$d.a;
                            Object e11 = list2.get(n13);
                            ScanResult scanResult3 = (ScanResult)e11;
                            long l15 = scanResult3.timestamp;
                            l15 = l11 - l15;
                            long l16 = 1000000L;
                            try {
                                l15 /= l16;
                            }
                            catch (Throwable throwable) {
                                l15 = 0L;
                            }
                            l14 = l15;
                            object2.add(l14);
                            n23 = (int)(l15 == l10 ? 0 : (l15 < l10 ? -1 : 1));
                            if (n23 > 0) {
                                l10 = l15;
                            }
                        }
                        if (n11 > n20) break block37;
                        n24 = n11;
                        n23 = n25;
                    }
                }
                ++n13;
                object3 = string2;
                n19 = 0;
                Object var8_17 = null;
                n18 = 1;
            }
            string3 = string7;
            n11 = n24;
        }
        n19 = n12;
        d d11 = d$d.c;
        n18 = (int)(com.baidu.location.b.d.e(d11) ? 1 : 0);
        if (n18 != 0) {
            return stringBuffer.toString();
        }
        if (n12 > 0) {
            String string10 = "&wf_n=";
            stringBuffer.append(string10);
            stringBuffer.append(n12);
        }
        if (n11 > n20 && (n19 = com.baidu.location.b.d.g(d10 = d$d.c)) > (n20 += (n18 = 1))) {
            for (n20 = n11; n20 < n15; ++n20) {
                if (n20 == n11) {
                    String string11 = "&wf2=";
                    stringBuffer.append(string11);
                } else {
                    stringBuffer.append(string4);
                }
                String string12 = ((ScanResult)d$d.a.get((int)n20)).BSSID;
                String string13 = string3;
                String string14 = string12.replace(string5, string3);
                stringBuffer.append(string14);
                ScanResult scanResult = (ScanResult)d$d.a.get(n20);
                n19 = scanResult.level;
                if (n19 < 0) {
                    n19 = -n19;
                }
                object = Locale.CHINA;
                n16 = 1;
                objectArray = new Object[n16];
                Integer n27 = n19;
                n13 = 0;
                objectArray[0] = n27;
                String string15 = String.format((Locale)object, string6, objectArray);
                stringBuffer.append(string15);
                d d12 = d$d.c;
                n19 = com.baidu.location.b.d.g(d12);
                if (n20 < n19) {
                    string3 = string13;
                    continue;
                }
                break;
            }
        } else {
            String string16 = string3;
            n16 = 1;
        }
        if (n14 != 0) {
            return null;
        }
        long l17 = 10;
        long l18 = l10 - l17;
        n20 = (int)(l18 == 0L ? 0 : (l18 < 0L ? -1 : 1));
        if (n20 > 0 && (n20 = object2.size()) > 0) {
            long l19;
            n20 = 0;
            String string17 = null;
            object3 = (Long)object2.get(0);
            l12 = (Long)object3;
            long l20 = l12 - (l19 = 0L);
            n11 = (int)(l20 == 0L ? 0 : (l20 < 0L ? -1 : 1));
            if (n11 > 0) {
                n19 = 128;
                object3 = new StringBuffer(n19);
                ((StringBuffer)object3).append("&wf_ut=");
                Long l21 = (Long)object2.get(0);
                object2 = object2.iterator();
                while ((n17 = (int)(object2.hasNext() ? 1 : 0)) != 0) {
                    object = (Long)object2.next();
                    if (n16 != 0) {
                        l11 = (Long)object;
                        ((StringBuffer)object3).append(l11);
                        n16 = 0;
                        l19 = 0L;
                    } else {
                        l12 = (Long)object;
                        l19 = l21;
                        long l22 = (l12 -= l19) - (l19 = 0L);
                        n17 = (int)(l22 == 0L ? 0 : (l22 < 0L ? -1 : 1));
                        if (n17 != 0) {
                            void var36_67;
                            object = new StringBuilder();
                            ((StringBuilder)object).append((String)var36_67);
                            ((StringBuilder)object).append(l12);
                            object = ((StringBuilder)object).toString();
                            ((StringBuffer)object3).append((String)object);
                        }
                    }
                    ((StringBuffer)object3).append(string4);
                }
                string17 = ((StringBuffer)object3).toString();
                stringBuffer.append(string17);
            }
        }
        return stringBuffer.toString();
    }
}

