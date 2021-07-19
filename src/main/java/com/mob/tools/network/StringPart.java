/*
 * Decompiled with CFR 0.151.
 */
package com.mob.tools.network;

import com.mob.tools.network.HTTPPart;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class StringPart
extends HTTPPart {
    private StringBuilder sb;

    public StringPart() {
        StringBuilder stringBuilder;
        this.sb = stringBuilder = new StringBuilder();
    }

    public StringPart append(String string2) {
        this.sb.append(string2);
        return this;
    }

    public InputStream getInputStream() {
        byte[] byArray = this.sb.toString().getBytes("utf-8");
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byArray);
        return byteArrayInputStream;
    }

    public long length() {
        return this.sb.toString().getBytes("utf-8").length;
    }

    public String toString() {
        return this.sb.toString();
    }
}

