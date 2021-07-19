/*
 * Decompiled with CFR 0.151.
 */
package com.quvideo.mobile.external.component.cloudcomposite.compressor;

import com.quvideo.mobile.external.component.cloudcomposite.compressor.OooOO0O;
import java.io.IOException;
import java.io.InputStream;

public abstract class OooOO0
implements OooOO0O {
    private InputStream OooO00o;

    public InputStream OooO00o() {
        InputStream inputStream;
        this.close();
        this.OooO00o = inputStream = this.OooO0OO();
        return inputStream;
    }

    public abstract InputStream OooO0OO();

    /*
     * Unable to fully structure code
     */
    public void close() {
        var1_1 = this.OooO00o;
        if (var1_1 != null) {
            try {
                var1_1.close();
lbl5:
                // 2 sources

                while (true) {
                    this.OooO00o = null;
                    break;
                }
            }
            catch (Throwable var1_2) {
                this.OooO00o = null;
                throw var1_2;
            }
        }
        return;
        catch (IOException v0) {
            ** continue;
        }
    }
}

