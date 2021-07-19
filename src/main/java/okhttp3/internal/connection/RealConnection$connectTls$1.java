/*
 * Decompiled with CFR 0.151.
 */
package okhttp3.internal.connection;

import f.h2.t.f0;
import g.a;
import g.h0.p.c;
import java.util.List;
import kotlin.jvm.internal.Lambda;
import okhttp3.CertificatePinner;
import okhttp3.Handshake;

public final class RealConnection$connectTls$1
extends Lambda
implements f.h2.s.a {
    public final /* synthetic */ a $address;
    public final /* synthetic */ CertificatePinner $certificatePinner;
    public final /* synthetic */ Handshake $unverifiedHandshake;

    public RealConnection$connectTls$1(CertificatePinner certificatePinner, Handshake handshake2, a a10) {
        this.$certificatePinner = certificatePinner;
        this.$unverifiedHandshake = handshake2;
        this.$address = a10;
        super(0);
    }

    public final List invoke() {
        c c10 = this.$certificatePinner.e();
        f0.m(c10);
        List list = this.$unverifiedHandshake.m();
        String string2 = this.$address.w().F();
        return c10.a(list, string2);
    }
}

