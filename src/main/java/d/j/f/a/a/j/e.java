/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 */
package d.j.f.a.a.j;

import android.os.Build;
import d.j.f.a.a.j.o.i;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;

public abstract class e {
    private static final String a = "SSLUtil";
    private static final String b = "TLSv1.3";
    private static final String c = "TLSv1.2";
    private static final String d = "TLS";
    private static final String e = "TLSv1";
    private static final String[] f = new String[]{"TLS_DHE_DSS_WITH_AES_128_CBC_SHA", "TLS_DHE_RSA_WITH_AES_128_CBC_SHA", "TLS_DHE_DSS_WITH_AES_256_CBC_SHA", "TLS_DHE_RSA_WITH_AES_256_CBC_SHA", "TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA", "TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA", "TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA", "TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA"};
    private static final String[] g = new String[]{"TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256", "TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384", "TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256", "TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384", "TLS_DHE_RSA_WITH_AES_128_GCM_SHA256", "TLS_DHE_RSA_WITH_AES_256_GCM_SHA384", "TLS_DHE_DSS_WITH_AES_128_GCM_SHA256", "TLS_DHE_DSS_WITH_AES_256_GCM_SHA384"};
    private static final String[] h = new String[]{"TLS_RSA", "CBC", "TEA", "SHA0", "MD2", "MD4", "RIPEMD", "NULL", "RC4", "DES", "DESX", "DES40", "RC2", "MD5", "ANON", "TLS_EMPTY_RENEGOTIATION_INFO_SCSV"};

    public static String[] a(SSLSocket sSLSocket) {
        return sSLSocket.getEnabledCipherSuites();
    }

    public static String[] b(SSLSocket sSLSocket) {
        return sSLSocket.getEnabledProtocols();
    }

    public static void c(SSLSocket stringArray) {
        String string2;
        String string3;
        String[] stringArray2 = stringArray.getEnabledProtocols();
        int n10 = stringArray2.length;
        int n11 = 0;
        int n12 = 0;
        StringBuilder stringBuilder = null;
        while (true) {
            string3 = a;
            if (n12 >= n10) break;
            string2 = stringArray2[n12];
            StringBuilder stringBuilder2 = new StringBuilder();
            String string4 = "new enable protocols is : ";
            stringBuilder2.append(string4);
            stringBuilder2.append(string2);
            string2 = stringBuilder2.toString();
            i.e(string3, string2);
            ++n12;
        }
        stringArray = stringArray.getEnabledCipherSuites();
        int n13 = stringArray.length;
        while (n11 < n13) {
            String string5 = stringArray[n11];
            stringBuilder = new StringBuilder();
            string2 = "new cipher suites is : ";
            stringBuilder.append(string2);
            stringBuilder.append(string5);
            string5 = stringBuilder.toString();
            i.e(string3, string5);
            ++n11;
        }
    }

    public static boolean d(SSLSocket sSLSocket) {
        if (sSLSocket == null) {
            return false;
        }
        String[] stringArray = h;
        return d.j.f.a.a.j.e.e(sSLSocket, stringArray);
    }

    public static boolean e(SSLSocket sSLSocket, String[] stringArray) {
        boolean bl2;
        if (sSLSocket == null) {
            return false;
        }
        String[] stringArray2 = sSLSocket.getEnabledCipherSuites();
        ArrayList<String> arrayList = new ArrayList<String>();
        int n10 = stringArray2.length;
        int n11 = 0;
        while (true) {
            String string2;
            block6: {
                bl2 = true;
                if (n11 >= n10) break;
                string2 = stringArray2[n11];
                Object object = Locale.ENGLISH;
                object = string2.toUpperCase((Locale)object);
                for (String string3 : stringArray) {
                    Locale locale = Locale.ENGLISH;
                    boolean bl3 = ((String)object).contains(string3 = string3.toUpperCase(locale));
                    if (!bl3) {
                        continue;
                    }
                    break block6;
                }
                bl2 = false;
            }
            if (!bl2) {
                arrayList.add(string2);
            }
            ++n11;
        }
        boolean bl4 = arrayList.isEmpty();
        if (!bl4) {
            stringArray = new String[arrayList.size()];
            stringArray = arrayList.toArray(stringArray);
            sSLSocket.setEnabledCipherSuites(stringArray);
            return bl2;
        }
        return false;
    }

    public static void f(SSLSocket sSLSocket) {
        if (sSLSocket == null) {
            return;
        }
        boolean bl2 = d.j.f.a.a.j.e.k(sSLSocket);
        if (!bl2) {
            d.j.f.a.a.j.e.d(sSLSocket);
        }
    }

    public static void g(SSLSocket sSLSocket) {
        int n10;
        if (sSLSocket == null) {
            return;
        }
        int n11 = Build.VERSION.SDK_INT;
        String string2 = c;
        int n12 = 29;
        if (n11 >= n12) {
            String[] stringArray = new String[]{b, string2};
            sSLSocket.setEnabledProtocols(stringArray);
        }
        if (n11 >= (n10 = 16) && n11 < n12) {
            String[] stringArray = new String[]{string2};
            sSLSocket.setEnabledProtocols(stringArray);
        } else if (n11 < n10) {
            String[] stringArray = new String[]{e};
            sSLSocket.setEnabledProtocols(stringArray);
        }
    }

    public static boolean h(SSLSocket sSLSocket, String[] object) {
        if (sSLSocket != null && object != null) {
            try {
                sSLSocket.setEnabledProtocols((String[])object);
                return true;
            }
            catch (Exception exception) {
                object = new StringBuilder();
                String string2 = "setEnabledProtocols: exception : ";
                ((StringBuilder)object).append(string2);
                String string3 = exception.getMessage();
                ((StringBuilder)object).append(string3);
                string3 = ((StringBuilder)object).toString();
                object = a;
                i.d((String)object, string3);
            }
        }
        return false;
    }

    public static SSLContext i() {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 29;
        SSLContext sSLContext = n10 >= n11 ? SSLContext.getInstance(b) : (n10 >= (n11 = 16) ? SSLContext.getInstance(c) : SSLContext.getInstance(d));
        return sSLContext;
    }

    public static void j(SSLSocket sSLSocket) {
        if (sSLSocket == null) {
            return;
        }
        d.j.f.a.a.j.e.g(sSLSocket);
        d.j.f.a.a.j.e.f(sSLSocket);
    }

    public static boolean k(SSLSocket sSLSocket) {
        if (sSLSocket == null) {
            return false;
        }
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 19;
        if (n10 > n11) {
            String[] stringArray = g;
            return d.j.f.a.a.j.e.l(sSLSocket, stringArray);
        }
        String[] stringArray = f;
        return d.j.f.a.a.j.e.l(sSLSocket, stringArray);
    }

    public static boolean l(SSLSocket sSLSocket, String[] object) {
        if (sSLSocket == null) {
            return false;
        }
        String[] stringArray = sSLSocket.getEnabledCipherSuites();
        ArrayList<String> arrayList = new ArrayList<String>();
        object = Arrays.asList(object);
        for (String string2 : stringArray) {
            Object object2 = Locale.ENGLISH;
            boolean bl2 = object.contains(object2 = string2.toUpperCase((Locale)object2));
            if (!bl2) continue;
            arrayList.add(string2);
        }
        boolean bl3 = arrayList.isEmpty();
        if (!bl3) {
            object = new String[arrayList.size()];
            object = arrayList.toArray((T[])object);
            sSLSocket.setEnabledCipherSuites((String[])object);
            return true;
        }
        return false;
    }
}

