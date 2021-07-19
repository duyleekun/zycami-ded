/*
 * Decompiled with CFR 0.151.
 */
package okhttp3;

import f.h2.s.a;
import f.x1.u;
import g.h0.p.c;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.jvm.internal.Lambda;
import okhttp3.CertificatePinner;

public final class CertificatePinner$check$1
extends Lambda
implements a {
    public final /* synthetic */ String $hostname;
    public final /* synthetic */ List $peerCertificates;
    public final /* synthetic */ CertificatePinner this$0;

    public CertificatePinner$check$1(CertificatePinner certificatePinner, List list, String string2) {
        this.this$0 = certificatePinner;
        this.$peerCertificates = list;
        this.$hostname = string2;
        super(0);
    }

    public final List invoke() {
        Object object;
        ArrayList<Object> arrayList;
        Object object2 = this.this$0.e();
        if (object2 == null || (object2 = ((c)object2).a(arrayList = this.$peerCertificates, (String)(object = this.$hostname))) == null) {
            object2 = this.$peerCertificates;
        }
        int n10 = u.Y((Iterable)object2, 10);
        arrayList = new ArrayList<Object>(n10);
        object2 = object2.iterator();
        while ((n10 = (int)(object2.hasNext() ? 1 : 0)) != 0) {
            object = (Certificate)object2.next();
            String string2 = "null cannot be cast to non-null type java.security.cert.X509Certificate";
            Objects.requireNonNull(object, string2);
            object = (X509Certificate)object;
            arrayList.add(object);
        }
        return arrayList;
    }
}

