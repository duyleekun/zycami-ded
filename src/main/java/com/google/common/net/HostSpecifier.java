/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.net;

import com.google.common.base.Preconditions;
import com.google.common.net.HostAndPort;
import com.google.common.net.InetAddresses;
import com.google.common.net.InternetDomainName;
import java.net.InetAddress;
import java.text.ParseException;

public final class HostSpecifier {
    private final String canonicalForm;

    private HostSpecifier(String string2) {
        this.canonicalForm = string2;
    }

    public static HostSpecifier from(String string2) {
        try {
            return HostSpecifier.fromValid(string2);
        }
        catch (IllegalArgumentException illegalArgumentException) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Invalid host specifier: ");
            stringBuilder.append(string2);
            string2 = stringBuilder.toString();
            ParseException parseException = new ParseException(string2, 0);
            parseException.initCause(illegalArgumentException);
            throw parseException;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static HostSpecifier fromValid(String object) {
        object = HostAndPort.fromString((String)object);
        Preconditions.checkArgument(((HostAndPort)object).hasPort() ^ true);
        object = ((HostAndPort)object).getHost();
        Object object2 = null;
        try {
            object2 = InetAddresses.forString((String)object);
        }
        catch (IllegalArgumentException illegalArgumentException) {}
        if (object2 != null) {
            object2 = InetAddresses.toUriString((InetAddress)object2);
            return new HostSpecifier((String)object2);
        }
        object2 = InternetDomainName.from((String)object);
        boolean bl2 = ((InternetDomainName)object2).hasPublicSuffix();
        if (bl2) {
            object2 = ((InternetDomainName)object2).toString();
            return new HostSpecifier((String)object2);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Domain name does not have a recognized public suffix: ");
        stringBuilder.append((String)object);
        object = stringBuilder.toString();
        object2 = new IllegalArgumentException((String)object);
        throw object2;
    }

    public static boolean isValid(String string2) {
        try {
            HostSpecifier.fromValid(string2);
            return true;
        }
        catch (IllegalArgumentException illegalArgumentException) {
            return false;
        }
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        boolean bl2 = object instanceof HostSpecifier;
        if (bl2) {
            object = (HostSpecifier)object;
            String string2 = this.canonicalForm;
            object = ((HostSpecifier)object).canonicalForm;
            return string2.equals(object);
        }
        return false;
    }

    public int hashCode() {
        return this.canonicalForm.hashCode();
    }

    public String toString() {
        return this.canonicalForm;
    }
}

