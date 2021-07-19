/*
 * Decompiled with CFR 0.151.
 */
package com.xiaomi.push;

import com.xiaomi.channel.commonutils.logger.b;
import java.io.File;
import java.util.HashMap;

public class x {
    private static final HashMap a;

    static {
        HashMap<String, String> hashMap;
        a = hashMap = new HashMap<String, String>();
        hashMap.put("FFD8FF", "jpg");
        hashMap.put("89504E47", "png");
        String string2 = "gif";
        hashMap.put("47494638", string2);
        hashMap.put("474946", string2);
        hashMap.put("424D", "bmp");
    }

    public static long a(File fileArray) {
        long l10;
        block10: {
            int n10;
            l10 = 0L;
            try {
                fileArray = fileArray.listFiles();
                n10 = 0;
            }
            catch (Exception exception) {
                b.a(exception);
            }
            while (true) {
                long l11;
                block12: {
                    File file;
                    block11: {
                        int n11 = fileArray.length;
                        if (n10 >= n11) break block10;
                        file = fileArray[n10];
                        n11 = (int)(file.isDirectory() ? 1 : 0);
                        if (n11 == 0) break block11;
                        file = fileArray[n10];
                        l11 = x.a(file);
                        break block12;
                    }
                    file = fileArray[n10];
                    l11 = file.length();
                }
                l10 += l11;
                ++n10;
            }
        }
        return l10;
    }
}

