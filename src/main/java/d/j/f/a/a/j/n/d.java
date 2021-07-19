/*
 * Decompiled with CFR 0.151.
 */
package d.j.f.a.a.j.n;

import d.j.f.a.a.j.n.c;
import d.j.f.a.a.j.o.i;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.AbstractCollection;
import java.util.AbstractSequentialList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;
import javax.net.ssl.SSLException;
import javax.security.auth.x500.X500Principal;

public class d {
    private static final Pattern a = Pattern.compile("^(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)(\\.(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)){3}$");
    private static final String[] b;

    static {
        Object[] objectArray = new String[]{"ac", "co", "com", "ed", "edu", "go", "gouv", "gov", "info", "lg", "ne", "net", "or", "org"};
        b = objectArray;
        Arrays.sort(objectArray);
    }

    public static final void a(String string2, X509Certificate objectArray, boolean bl2) {
        Object[] objectArray2 = d.d((X509Certificate)objectArray);
        objectArray = d.f((X509Certificate)objectArray);
        CharSequence charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("cn is : ");
        String string3 = Arrays.toString(objectArray2);
        ((StringBuilder)charSequence).append(string3);
        charSequence = ((StringBuilder)charSequence).toString();
        string3 = "";
        i.b(string3, (String)charSequence);
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("san is : ");
        String string4 = Arrays.toString(objectArray);
        ((StringBuilder)charSequence).append(string4);
        charSequence = ((StringBuilder)charSequence).toString();
        i.b(string3, (String)charSequence);
        d.b(string2, (String[])objectArray2, (String[])objectArray, bl2);
    }

    public static final void b(String string2, String[] object, String[] object2, boolean bl2) {
        Object object3;
        int n10;
        Object object4;
        int n11;
        Object object5 = new LinkedList();
        if (object != null && (n11 = ((Object)object).length) > 0 && (object4 = object[0]) != null) {
            object = object[0];
            ((LinkedList)object5).add(object);
        }
        if (object2 != null) {
            n10 = ((Object)object2).length;
            object4 = null;
            for (n11 = 0; n11 < n10; ++n11) {
                object3 = object2[n11];
                if (object3 == null) continue;
                ((LinkedList)object5).add(object3);
            }
        }
        if ((n10 = (int)(((AbstractCollection)object5).isEmpty() ? 1 : 0)) == 0) {
            int n12;
            object = new StringBuffer();
            object2 = string2.trim();
            object4 = Locale.ENGLISH;
            object2 = ((String)object2).toLowerCase((Locale)object4);
            object5 = ((AbstractSequentialList)object5).iterator();
            n11 = 0;
            object4 = null;
            while ((n12 = object5.hasNext()) != 0) {
                int n13;
                object4 = (String)object5.next();
                object3 = Locale.ENGLISH;
                object4 = ((String)object4).toLowerCase((Locale)object3);
                object3 = " <";
                ((StringBuffer)object).append((String)object3);
                ((StringBuffer)object).append((String)object4);
                ((StringBuffer)object).append('>');
                n12 = object5.hasNext();
                if (n12 != 0) {
                    object3 = " OR";
                    ((StringBuffer)object).append((String)object3);
                }
                object3 = "*.";
                n12 = ((String)object4).startsWith((String)object3);
                int n14 = 1;
                if (n12 != 0 && (n12 = ((String)object4).indexOf(46, 2)) != (n13 = -1) && (n12 = (int)(d.c((String)object4) ? 1 : 0)) != 0 && (n12 = (int)(d.g(string2) ? 1 : 0)) == 0) {
                    n12 = n14;
                } else {
                    n12 = 0;
                    object3 = null;
                }
                if (n12 != 0) {
                    object3 = ((String)object4).substring(n14);
                    n12 = (int)(((String)object2).endsWith((String)object3) ? 1 : 0);
                    if (n12 != 0 && bl2) {
                        n12 = d.e((String)object2);
                        if (n12 == (n11 = d.e((String)object4))) {
                            n11 = n14;
                        } else {
                            n11 = 0;
                            object4 = null;
                        }
                    } else {
                        n11 = n12;
                    }
                } else {
                    n11 = (int)(((String)object2).equals(object4) ? 1 : 0);
                }
                if (n11 == 0) continue;
            }
            if (n11 != 0) {
                return;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("hostname in certificate didn't match: <");
            stringBuilder.append(string2);
            stringBuilder.append("> !=");
            stringBuilder.append(object);
            string2 = stringBuilder.toString();
            object2 = new SSLException(string2);
            throw object2;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("Certificate for <");
        ((StringBuilder)object).append(string2);
        ((StringBuilder)object).append("> doesn't contain CN or DNS subjectAlt");
        string2 = ((StringBuilder)object).toString();
        object = new SSLException(string2);
        throw object;
    }

    public static boolean c(String string2) {
        Object[] objectArray;
        int n10;
        int n11;
        int n12 = string2.length();
        boolean bl2 = true;
        int n13 = 7;
        if (n12 >= n13 && n12 <= (n13 = 9) && (n13 = (int)string2.charAt(n12 += -3)) == (n11 = 46) && (n10 = Arrays.binarySearch(objectArray = b, string2 = string2.substring(n13 = 2, n12))) >= 0) {
            bl2 = false;
        }
        return bl2;
    }

    public static String[] d(X509Certificate object) {
        object = ((X509Certificate)object).getSubjectX500Principal();
        String[] stringArray = new c((X500Principal)object);
        boolean bl2 = (object = stringArray.e("cn")).isEmpty();
        if (!bl2) {
            stringArray = new String[object.size()];
            object.toArray(stringArray);
            return stringArray;
        }
        return null;
    }

    public static int e(String string2) {
        int n10;
        int n11 = 0;
        for (int i10 = 0; i10 < (n10 = string2.length()); ++i10) {
            int n12;
            n10 = string2.charAt(i10);
            if (n10 != (n12 = 46)) continue;
            ++n11;
        }
        return n11;
    }

    public static String[] f(X509Certificate stringArray) {
        boolean bl2;
        Object object;
        Object object2;
        LinkedList<Object> linkedList = new LinkedList<Object>();
        try {
            stringArray = stringArray.getSubjectAlternativeNames();
        }
        catch (CertificateParsingException certificateParsingException) {
            object2 = "";
            object = "Error parsing certificate.";
            i.c((String)object2, (String)object, certificateParsingException);
            bl2 = false;
            stringArray = null;
        }
        if (stringArray != null) {
            boolean bl3;
            stringArray = stringArray.iterator();
            while (bl3 = stringArray.hasNext()) {
                int n10;
                object2 = (List)stringArray.next();
                object = (Integer)object2.get(0);
                int n11 = (Integer)object;
                if (n11 != (n10 = 2)) continue;
                n11 = 1;
                object2 = (String)object2.get(n11);
                linkedList.add(object2);
            }
        }
        if (!(bl2 = linkedList.isEmpty())) {
            stringArray = new String[linkedList.size()];
            linkedList.toArray(stringArray);
            return stringArray;
        }
        return null;
    }

    private static boolean g(String string2) {
        return a.matcher(string2).matches();
    }
}

