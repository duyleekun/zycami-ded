/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.datatransport;

import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.Transformer;
import com.google.android.datatransport.Transport;

public interface TransportFactory {
    public Transport getTransport(String var1, Class var2, Encoding var3, Transformer var4);

    public Transport getTransport(String var1, Class var2, Transformer var3);
}

