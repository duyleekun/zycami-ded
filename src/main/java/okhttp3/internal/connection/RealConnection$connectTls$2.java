/*
 * Decompiled with CFR 0.151.
 */
package okhttp3.internal.connection;

import f.h2.s.a;
import f.h2.t.f0;
import f.x1.u;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.jvm.internal.Lambda;
import okhttp3.Handshake;
import okhttp3.internal.connection.RealConnection;

public final class RealConnection$connectTls$2
extends Lambda
implements a {
    public final /* synthetic */ RealConnection this$0;

    public RealConnection$connectTls$2(RealConnection realConnection) {
        this.this$0 = realConnection;
        super(0);
    }

    public final List invoke() {
        Iterator iterator2 = RealConnection.g(this.this$0);
        f0.m(iterator2);
        iterator2 = ((Handshake)((Object)iterator2)).m();
        int n10 = u.Y((Iterable)((Object)iterator2), 10);
        ArrayList<Certificate> arrayList = new ArrayList<Certificate>(n10);
        iterator2 = iterator2.iterator();
        while ((n10 = (int)(iterator2.hasNext() ? 1 : 0)) != 0) {
            Certificate certificate = (Certificate)iterator2.next();
            String string2 = "null cannot be cast to non-null type java.security.cert.X509Certificate";
            Objects.requireNonNull(certificate, string2);
            certificate = (X509Certificate)certificate;
            arrayList.add(certificate);
        }
        return arrayList;
    }
}

