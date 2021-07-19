/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 *  org.json.JSONArray
 *  org.json.JSONException
 */
package d.j.b.a.b;

import android.content.Context;
import android.text.TextUtils;
import d.j.b.a.b.a;
import d.j.b.a.b.d.b;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateFactory;
import java.security.cert.CertificateNotYetValidException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;

public class c {
    private static String a(String string2, String string3) {
        Object object = Locale.getDefault();
        object = string2.toUpperCase((Locale)object);
        CharSequence charSequence = new StringBuilder();
        charSequence.append(string3);
        String string4 = "=";
        charSequence.append(string4);
        charSequence = charSequence.toString();
        int n10 = ((String)object).indexOf((String)charSequence);
        int n11 = -1;
        if (n10 == n11) {
            return null;
        }
        string4 = ",";
        int n12 = string2.indexOf(string4, n10);
        int n13 = string3.length();
        n10 = n10 + n13 + 1;
        if (n12 != n11) {
            return string2.substring(n10, n12);
        }
        return string2.substring(n10);
    }

    /*
     * Exception decompiling
     */
    public static X509Certificate b(Context var0) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Started 3 blocks at once
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.getStartingBlocks(Op04StructuredStatement.java:412)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:487)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:736)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:845)
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

    private static X509Certificate c(String string2) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (bl2) {
            return null;
        }
        return c.d(a.a(string2));
    }

    private static X509Certificate d(byte[] object) {
        block6: {
            int n10;
            if (object == null || (n10 = ((byte[])object).length) == 0) break block6;
            Object object2 = "X.509";
            object2 = CertificateFactory.getInstance((String)object2);
            Object object3 = new ByteArrayInputStream((byte[])object);
            object = ((CertificateFactory)object2).generateCertificate((InputStream)object3);
            n10 = object instanceof X509Certificate;
            if (n10 == 0) break block6;
            try {
                return (X509Certificate)object;
            }
            catch (CertificateException certificateException) {
                object2 = b.b;
                object3 = new StringBuilder();
                String string2 = "Failed to get cert: ";
                ((StringBuilder)object3).append(string2);
                String string3 = certificateException.getMessage();
                ((StringBuilder)object3).append(string3);
                string3 = ((StringBuilder)object3).toString();
                object3 = "X509CertUtil";
                ((b)object2).a((String)object3, string3);
            }
        }
        return null;
    }

    private static boolean e(X509Certificate x509Certificate) {
        int n10;
        if (x509Certificate == null) {
            return false;
        }
        int n11 = x509Certificate.getBasicConstraints();
        if (n11 == (n10 = -1)) {
            return false;
        }
        return x509Certificate.getKeyUsage()[5];
    }

    public static boolean f(X509Certificate x509Certificate, String string2) {
        return c.g(x509Certificate, "CN", string2);
    }

    private static boolean g(X509Certificate object, String string2, String string3) {
        boolean bl2;
        if (object != null && !(bl2 = TextUtils.isEmpty((CharSequence)string2)) && !(bl2 = TextUtils.isEmpty((CharSequence)string3))) {
            object = c.a(((X509Certificate)object).getSubjectDN().getName(), string2);
            return string3.equals(object);
        }
        return false;
    }

    public static boolean h(X509Certificate serializable, List object) {
        int n10;
        if (object != null && (n10 = object.size()) != 0) {
            String string2;
            String string3 = "X509CertUtil";
            if (serializable == null) {
                b.b.a(string3, "rootCert is null,verify failed ");
                return false;
            }
            try {
                serializable.checkValidity();
            }
            catch (CertificateNotYetValidException certificateNotYetValidException) {
            }
            catch (CertificateExpiredException certificateExpiredException) {
                // empty catch block
            }
            serializable = serializable.getPublicKey();
            for (int i10 = object.size() + -1; i10 >= 0; i10 += -1) {
                Object object2 = (X509Certificate)object.get(i10);
                if (object2 != null) {
                    String string4;
                    try {
                        ((Certificate)object2).verify((PublicKey)serializable);
                        ((X509Certificate)object2).checkValidity();
                        serializable = ((Certificate)object2).getPublicKey();
                        continue;
                    }
                    catch (SignatureException signatureException) {
                    }
                    catch (NoSuchProviderException noSuchProviderException) {
                    }
                    catch (InvalidKeyException invalidKeyException) {
                    }
                    catch (NoSuchAlgorithmException noSuchAlgorithmException) {
                    }
                    catch (CertificateException certificateException) {
                        // empty catch block
                    }
                    object = b.b;
                    StringBuilder stringBuilder = new StringBuilder();
                    object2 = "verify failed ";
                    stringBuilder.append((String)object2);
                    string4 = ((Throwable)((Object)string4)).getMessage();
                    stringBuilder.append(string4);
                    string4 = stringBuilder.toString();
                    ((b)object).a(string3, string4);
                }
                return false;
            }
            return c.j((List)object);
            object = b.b;
            StringBuilder stringBuilder = new StringBuilder();
            String string5 = "verifyCertChain Exception:";
            stringBuilder.append(string5);
            string2 = ((Throwable)((Object)string2)).getMessage();
            stringBuilder.append(string2);
            string2 = stringBuilder.toString();
            ((b)object).a(string3, string2);
        }
        return false;
    }

    /*
     * WARNING - void declaration
     */
    public static boolean i(X509Certificate serializable, byte[] byArray, byte[] byArray2) {
        int n10;
        String string2 = "X509CertUtil";
        if (serializable != null && byArray != null && byArray2 != null && (n10 = byArray2.length) != 0) {
            void var0_4;
            Object object = serializable.getSigAlgName();
            object = Signature.getInstance((String)object);
            serializable = serializable.getPublicKey();
            ((Signature)object).initVerify((PublicKey)serializable);
            ((Signature)object).update(byArray);
            try {
                return ((Signature)object).verify(byArray2);
            }
            catch (InvalidKeyException invalidKeyException) {
            }
            catch (SignatureException signatureException) {
            }
            catch (NoSuchAlgorithmException noSuchAlgorithmException) {
                // empty catch block
            }
            b.b.b(string2, "failed checkSignature,Exception:", (Throwable)var0_4);
            return false;
        }
        b.b.c(string2, "checkSignature parameter is null");
        return false;
    }

    private static boolean j(List list) {
        int n10;
        int n11;
        for (int i10 = n10 = 1; i10 < (n11 = list.size()); ++i10) {
            X509Certificate x509Certificate = (X509Certificate)list.get(i10);
            n11 = (int)(c.e(x509Certificate) ? 1 : 0);
            if (n11 != 0) continue;
            return false;
        }
        return n10 != 0;
    }

    public static List k(String string2) {
        return c.l(c.n(string2));
    }

    private static List l(List object) {
        String string2 = "X509CertUtil";
        if (object == null) {
            b.b.c(string2, "base64 CertChain is null.");
            object = new ArrayList();
            return object;
        }
        int n10 = object.size();
        ArrayList<Object> arrayList = new ArrayList<Object>(n10);
        object = object.iterator();
        while ((n10 = (int)(object.hasNext() ? 1 : 0)) != 0) {
            Object object2 = c.c((String)object.next());
            if (object2 == null) {
                object2 = b.b;
                String string3 = "Failed to get cert from CertChain";
                ((b)object2).a(string2, string3);
                continue;
            }
            arrayList.add(object2);
        }
        return arrayList;
    }

    public static boolean m(X509Certificate x509Certificate, String string2) {
        return c.g(x509Certificate, "OU", string2);
    }

    private static List n(String arrayList) {
        StringBuilder stringBuilder;
        int n10;
        Object object;
        block10: {
            object = new JSONArray((String)((Object)arrayList));
            int n11 = object.length();
            n10 = 1;
            if (n11 > n10) break block10;
            return Collections.emptyList();
        }
        n10 = object.length();
        try {
            arrayList = new ArrayList<String>(n10);
            n10 = 0;
            stringBuilder = null;
        }
        catch (JSONException jSONException) {
            object = b.b;
            stringBuilder = new StringBuilder();
            stringBuilder.append("Failed to getCertChain: ");
            String string2 = jSONException.getMessage();
            stringBuilder.append(string2);
            string2 = stringBuilder.toString();
            ((b)object).a("X509CertUtil", string2);
            return Collections.emptyList();
        }
        while (true) {
            int n12 = object.length();
            if (n10 >= n12) break;
            String string3 = object.getString(n10);
            arrayList.add(string3);
            ++n10;
            continue;
            break;
        }
        return arrayList;
    }
}

