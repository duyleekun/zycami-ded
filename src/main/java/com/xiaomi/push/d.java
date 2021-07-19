/*
 * Decompiled with CFR 0.151.
 */
package com.xiaomi.push;

import java.io.IOException;

public class d
extends IOException {
    public d(String string2) {
        super(string2);
    }

    public static d a() {
        d d10 = new d("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either than the input has been truncated or that an embedded message misreported its own length.");
        return d10;
    }

    public static d b() {
        d d10 = new d("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        return d10;
    }

    public static d c() {
        d d10 = new d("CodedInputStream encountered a malformed varint.");
        return d10;
    }

    public static d d() {
        d d10 = new d("Protocol message contained an invalid tag (zero).");
        return d10;
    }

    public static d e() {
        d d10 = new d("Protocol message end-group tag did not match expected tag.");
        return d10;
    }

    public static d f() {
        d d10 = new d("Protocol message tag had invalid wire type.");
        return d10;
    }

    public static d g() {
        d d10 = new d("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
        return d10;
    }

    public static d h() {
        d d10 = new d("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit.");
        return d10;
    }
}

