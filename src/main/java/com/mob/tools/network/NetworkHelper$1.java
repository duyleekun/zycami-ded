/*
 * Decompiled with CFR 0.151.
 */
package com.mob.tools.network;

import com.mob.tools.network.NetworkHelper;
import com.mob.tools.network.RawNetworkCallback;
import java.io.InputStream;
import java.io.OutputStream;

public class NetworkHelper$1
implements RawNetworkCallback {
    public final /* synthetic */ NetworkHelper this$0;
    public final /* synthetic */ byte[] val$buf;
    public final /* synthetic */ OutputStream val$os;

    public NetworkHelper$1(NetworkHelper networkHelper, byte[] byArray, OutputStream outputStream) {
        this.this$0 = networkHelper;
        this.val$buf = byArray;
        this.val$os = outputStream;
    }

    public void onResponse(InputStream inputStream) {
        int n10;
        byte[] byArray = this.val$buf;
        int n11 = inputStream.read(byArray);
        while (n11 != (n10 = -1)) {
            OutputStream outputStream = this.val$os;
            byte[] byArray2 = this.val$buf;
            outputStream.write(byArray2, 0, n11);
            byArray = this.val$buf;
            n11 = inputStream.read(byArray);
        }
    }
}

