/*
 * Decompiled with CFR 0.151.
 */
package com.tencent.rtmp.sharp.jni;

import java.io.File;
import java.io.FileFilter;

public final class AudioDeviceInterface$4
implements FileFilter {
    /*
     * WARNING - void declaration
     */
    public boolean accept(File object) {
        String string2;
        boolean n10 = ((String)(object = ((File)object).getName())).startsWith(string2 = "cpu");
        if (n10) {
            int n11;
            void var3_5;
            int n12 = 3;
            while (++var3_5 < (n11 = ((String)object).length())) {
                int n13;
                n11 = ((String)object).charAt((int)var3_5);
                if (n11 >= (n13 = 48) && (n11 = (int)((String)object).charAt((int)var3_5)) <= (n13 = 57)) {
                    continue;
                }
                return false;
            }
            return true;
        }
        return false;
    }
}

