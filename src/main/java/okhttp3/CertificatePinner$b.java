/*
 * Decompiled with CFR 0.151.
 */
package okhttp3;

import f.h2.t.f0;
import f.h2.t.u;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import okio.ByteString;
import okio.ByteString$a;

public final class CertificatePinner$b {
    private CertificatePinner$b() {
    }

    public /* synthetic */ CertificatePinner$b(u u10) {
        this();
    }

    public final String a(Certificate object) {
        CharSequence charSequence = "certificate";
        f0.p(object, (String)charSequence);
        boolean bl2 = object instanceof X509Certificate;
        if (bl2) {
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append("sha256/");
            object = (X509Certificate)object;
            object = this.c((X509Certificate)object).base64();
            ((StringBuilder)charSequence).append((String)object);
            return ((StringBuilder)charSequence).toString();
        }
        charSequence = "Certificate pinning requires X509 certificates".toString();
        object = new IllegalArgumentException((String)charSequence);
        throw object;
    }

    public final ByteString b(X509Certificate serializable) {
        f0.p(serializable, "$this$sha1Hash");
        ByteString$a byteString$a = ByteString.Companion;
        serializable = ((Certificate)serializable).getPublicKey();
        f0.o(serializable, "publicKey");
        byte[] byArray = serializable.getEncoded();
        f0.o(byArray, "publicKey.encoded");
        return ByteString$a.p(byteString$a, byArray, 0, 0, 3, null).sha1();
    }

    public final ByteString c(X509Certificate serializable) {
        f0.p(serializable, "$this$sha256Hash");
        ByteString$a byteString$a = ByteString.Companion;
        serializable = ((Certificate)serializable).getPublicKey();
        f0.o(serializable, "publicKey");
        byte[] byArray = serializable.getEncoded();
        f0.o(byArray, "publicKey.encoded");
        return ByteString$a.p(byteString$a, byArray, 0, 0, 3, null).sha256();
    }
}

