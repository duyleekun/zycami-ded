/*
 * Decompiled with CFR 0.151.
 */
package okhttp3;

import f.h2.s.a;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Lambda;

public final class Handshake$peerCertificates$2
extends Lambda
implements a {
    public final /* synthetic */ a $peerCertificatesFn;

    public Handshake$peerCertificates$2(a a10) {
        this.$peerCertificatesFn = a10;
        super(0);
    }

    public final List invoke() {
        Object object = this.$peerCertificatesFn;
        object = object.invoke();
        try {
            object = (List)object;
        }
        catch (SSLPeerUnverifiedException sSLPeerUnverifiedException) {
            object = CollectionsKt__CollectionsKt.E();
        }
        return object;
    }
}

