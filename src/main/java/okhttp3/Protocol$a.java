/*
 * Decompiled with CFR 0.151.
 */
package okhttp3;

import f.h2.t.f0;
import f.h2.t.u;
import java.io.IOException;
import okhttp3.Protocol;

public final class Protocol$a {
    private Protocol$a() {
    }

    public /* synthetic */ Protocol$a(u u10) {
        this();
    }

    public final Protocol a(String string2) {
        f0.p(string2, "protocol");
        Object object = Protocol.HTTP_1_0;
        CharSequence charSequence = Protocol.access$getProtocol$p(object);
        boolean bl2 = f0.g(string2, charSequence);
        if (bl2 || (bl2 = f0.g(string2, charSequence = Protocol.access$getProtocol$p(object = Protocol.HTTP_1_1))) || (bl2 = f0.g(string2, charSequence = Protocol.access$getProtocol$p(object = Protocol.H2_PRIOR_KNOWLEDGE))) || (bl2 = f0.g(string2, charSequence = Protocol.access$getProtocol$p(object = Protocol.HTTP_2))) || (bl2 = f0.g(string2, charSequence = Protocol.access$getProtocol$p(object = Protocol.SPDY_3))) || (bl2 = f0.g(string2, charSequence = Protocol.access$getProtocol$p(object = Protocol.QUIC)))) {
            return object;
        }
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("Unexpected protocol: ");
        ((StringBuilder)charSequence).append(string2);
        string2 = ((StringBuilder)charSequence).toString();
        object = new IOException(string2);
        throw object;
    }
}

