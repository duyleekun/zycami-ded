/*
 * Decompiled with CFR 0.151.
 */
package com.tencent.liteav.network.a.a;

import com.tencent.liteav.network.a.a.a$1;
import com.tencent.liteav.network.a.c;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.Reader;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class a {
    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static InetAddress[] a() {
        String string2;
        Object object;
        InetAddress[] inetAddressArray;
        try {
            InetAddress[] inetAddressArray2 = Runtime.getRuntime();
            inetAddressArray = "getprop";
            inetAddressArray2 = inetAddressArray2.exec((String)inetAddressArray);
            inetAddressArray2 = inetAddressArray2.getInputStream();
            object = new InputStreamReader((InputStream)inetAddressArray2);
            inetAddressArray = new LineNumberReader((Reader)object);
            int n10 = 5;
            inetAddressArray2 = new ArrayList(n10);
            while ((object = inetAddressArray.readLine()) != null) {
                int n11;
                string2 = "]: [";
                int n12 = ((String)object).indexOf(string2);
                if (n12 == (n11 = -1)) continue;
                n11 = 1;
                String string3 = ((String)object).substring(n11, n12);
                int n13 = ((String)object).length() - n11;
                object = ((String)object).substring(n12 += 4, n13);
                string2 = ".dns";
                n12 = (int)(string3.endsWith(string2) ? 1 : 0);
                if (n12 == 0 && (n12 = (int)(string3.endsWith(string2 = ".dns1") ? 1 : 0)) == 0 && (n12 = (int)(string3.endsWith(string2 = ".dns2") ? 1 : 0)) == 0 && (n12 = (int)(string3.endsWith(string2 = ".dns3") ? 1 : 0)) == 0 && (n12 = (int)(string3.endsWith(string2 = ".dns4") ? 1 : 0)) == 0 || (object = InetAddress.getByName((String)object)) == null || (string2 = ((InetAddress)object).getHostAddress()) == null || (n12 = string2.length()) == 0) continue;
                inetAddressArray2.add(object);
            }
            int n14 = inetAddressArray2.size();
            if (n14 <= 0) return null;
            n14 = inetAddressArray2.size();
            inetAddressArray = new InetAddress[n14];
            return inetAddressArray2.toArray(inetAddressArray);
        }
        catch (IOException iOException) {
            inetAddressArray = Logger.getLogger("AndroidDnsServer");
            object = Level.WARNING;
            string2 = "Exception in findDNSByExec";
            inetAddressArray.log((Level)object, string2, iOException);
        }
        return null;
    }

    public static InetAddress[] b() {
        block25: {
            InetAddress[] inetAddressArray = "android.os.SystemProperties";
            inetAddressArray = Class.forName((String)inetAddressArray);
            ArrayList<Object> arrayList = "get";
            int n10 = 1;
            Class[] classArray = new Class[n10];
            String[] stringArray = String.class;
            classArray[0] = stringArray;
            inetAddressArray = inetAddressArray.getMethod((String)((Object)arrayList), classArray);
            int n11 = 5;
            arrayList = new ArrayList<Object>(n11);
            n11 = 4;
            stringArray = "net.dns1";
            String string2 = "net.dns2";
            Object object = "net.dns3";
            Object object2 = "net.dns4";
            stringArray = new String[]{stringArray, string2, object, object2};
            string2 = null;
            for (int i10 = 0; i10 < n11; ++i10) {
                object = stringArray[i10];
                object2 = new Object[n10];
                object2[0] = object;
                object = inetAddressArray.invoke(null, (Object[])object2);
                object = (String)object;
                if (object == null) continue;
                int n12 = ((String)object).length();
                if (n12 == 0) continue;
                object = InetAddress.getByName((String)object);
                if (object == null) continue;
                object2 = ((InetAddress)object).getHostAddress();
                if (object2 == null) continue;
                n12 = ((String)object2).length();
                if (n12 == 0) continue;
                n12 = (int)(arrayList.contains(object) ? 1 : 0);
                if (n12 != 0) continue;
                arrayList.add(object);
            }
            int n13 = arrayList.size();
            if (n13 <= 0) break block25;
            n13 = arrayList.size();
            inetAddressArray = new InetAddress[n13];
            inetAddressArray = arrayList.toArray(inetAddressArray);
            try {
                return inetAddressArray;
            }
            catch (Exception exception) {
                arrayList = Logger.getLogger("AndroidDnsServer");
                Level level = Level.WARNING;
                classArray = "Exception in findDNSByReflection";
                ((Logger)((Object)arrayList)).log(level, (String)classArray, exception);
            }
        }
        return null;
    }

    public static c c() {
        a$1 a$1 = new a$1();
        return a$1;
    }
}

