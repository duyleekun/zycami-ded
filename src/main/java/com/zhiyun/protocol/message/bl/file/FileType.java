/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.protocol.message.bl.file;

import com.zhiyun.protocol.message.bl.file.FileType$1;
import com.zhiyun.protocol.message.bl.file.FileType$2;
import com.zhiyun.protocol.message.bl.file.FileType$3;
import com.zhiyun.protocol.message.bl.file.FileType$4;
import d.v.y.d.k;

public class FileType
extends Enum {
    public static final /* enum */ FileType MODULES;
    public static final /* enum */ FileType PATHPOINT;
    public static final /* enum */ FileType PATHSHOT;
    public static final /* enum */ FileType SUPPORT;
    private static final String a = "support";
    private static final String b = "pathShot";
    private static final String c = "pathPoint";
    private static final String d = "modules";
    private static final /* synthetic */ FileType[] e;

    static {
        FileType$1 fileType$1 = new FileType$1();
        SUPPORT = fileType$1;
        int n10 = 1;
        FileType$2 fileType$2 = new FileType$2();
        PATHSHOT = fileType$2;
        int n11 = 2;
        FileType$3 fileType$3 = new FileType$3();
        PATHPOINT = fileType$3;
        int n12 = 3;
        FileType$4 fileType$4 = new FileType$4();
        MODULES = fileType$4;
        FileType[] fileTypeArray = new FileType[4];
        fileTypeArray[0] = fileType$1;
        fileTypeArray[n10] = fileType$2;
        fileTypeArray[n11] = fileType$3;
        fileTypeArray[n12] = fileType$4;
        e = fileTypeArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private FileType() {
        void var2_-1;
        void var1_-1;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    public /* synthetic */ FileType(FileType$1 varnull) {
        this((String)var1_-1, (int)var2_1);
        void var2_1;
        void var1_-1;
    }

    /*
     * Unable to fully structure code
     */
    public static FileType toFileType(byte[] var0) {
        block6: {
            block4: {
                block5: {
                    var0 = k.c((byte[])var0);
                    var1_1 = var0.hashCode();
                    var2_2 = -1854767153;
                    var3_3 = 1;
                    if (var1_1 == var2_2) break block4;
                    var2_2 = -391589781;
                    if (var1_1 == var2_2) break block5;
                    var2_2 = 1234376895;
                    if (var1_1 != var2_2 || (var5_7 = (int)var0.equals(var4_4 = "pathShot")) == 0) ** GOTO lbl-1000
                    var5_7 = 0;
                    var0 = null;
                    break block6;
                }
                var4_5 = "pathPoint";
                var5_7 = (int)var0.equals(var4_5);
                if (var5_7 == 0) ** GOTO lbl-1000
                var5_7 = var3_3;
                break block6;
            }
            var4_6 = "support";
            var5_7 = var0.equals(var4_6);
            if (var5_7 != 0) {
                var5_7 = 2;
            } else lbl-1000:
            // 3 sources

            {
                var5_7 = -1;
            }
        }
        if (var5_7 != 0) {
            if (var5_7 != var3_3) {
                return FileType.SUPPORT;
            }
            return FileType.PATHPOINT;
        }
        return FileType.PATHSHOT;
    }

    public static FileType valueOf(String string2) {
        return Enum.valueOf(FileType.class, string2);
    }

    public static FileType[] values() {
        return (FileType[])e.clone();
    }
}

