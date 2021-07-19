/*
 * Decompiled with CFR 0.151.
 */
package org.opencv.core;

public class CvException
extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public CvException(String string2) {
        super(string2);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("CvException [");
        String string2 = super.toString();
        stringBuilder.append(string2);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}

