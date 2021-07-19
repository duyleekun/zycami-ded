/*
 * Decompiled with CFR 0.151.
 */
package okhttp3;

import f.h2.t.f0;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt___CollectionsKt;
import okhttp3.CertificatePinner;
import okhttp3.CertificatePinner$c;

public final class CertificatePinner$a {
    private final List a;

    public CertificatePinner$a() {
        ArrayList arrayList;
        this.a = arrayList = new ArrayList();
    }

    public final CertificatePinner$a a(String string2, String ... stringArray) {
        f0.p(string2, "pattern");
        String string3 = "pins";
        f0.p(stringArray, string3);
        for (String string4 : stringArray) {
            List list = this.a;
            CertificatePinner$c certificatePinner$c = new CertificatePinner$c(string2, string4);
            list.add(certificatePinner$c);
        }
        return this;
    }

    public final CertificatePinner b() {
        Set set = CollectionsKt___CollectionsKt.N5(this.a);
        CertificatePinner certificatePinner = new CertificatePinner(set, null, 2, null);
        return certificatePinner;
    }

    public final List c() {
        return this.a;
    }
}

