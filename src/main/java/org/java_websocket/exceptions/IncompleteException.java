/*
 * Decompiled with CFR 0.151.
 */
package org.java_websocket.exceptions;

public class IncompleteException
extends Exception {
    private static final long serialVersionUID = 7330519489840500997L;
    private final int preferredSize;

    public IncompleteException(int n10) {
        this.preferredSize = n10;
    }

    public int getPreferredSize() {
        return this.preferredSize;
    }
}

