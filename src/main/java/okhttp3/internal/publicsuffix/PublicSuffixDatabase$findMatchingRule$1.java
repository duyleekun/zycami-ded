/*
 * Decompiled with CFR 0.151.
 */
package okhttp3.internal.publicsuffix;

import kotlin.jvm.internal.MutablePropertyReference0Impl;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;

public final class PublicSuffixDatabase$findMatchingRule$1
extends MutablePropertyReference0Impl {
    public PublicSuffixDatabase$findMatchingRule$1(PublicSuffixDatabase publicSuffixDatabase) {
        super((Object)publicSuffixDatabase, PublicSuffixDatabase.class, "publicSuffixListBytes", "getPublicSuffixListBytes()[B", 0);
    }

    public Object get() {
        return PublicSuffixDatabase.b((PublicSuffixDatabase)this.receiver);
    }

    public void set(Object object) {
        PublicSuffixDatabase publicSuffixDatabase = (PublicSuffixDatabase)this.receiver;
        object = (byte[])object;
        PublicSuffixDatabase.c(publicSuffixDatabase, (byte[])object);
    }
}

