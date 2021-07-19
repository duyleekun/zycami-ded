/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.decoder;

import com.google.android.exoplayer2.decoder.SimpleDecoder;

public class SimpleDecoder$1
extends Thread {
    public final /* synthetic */ SimpleDecoder this$0;

    public SimpleDecoder$1(SimpleDecoder simpleDecoder, String string2) {
        this.this$0 = simpleDecoder;
        super(string2);
    }

    public void run() {
        SimpleDecoder.access$000(this.this$0);
    }
}

