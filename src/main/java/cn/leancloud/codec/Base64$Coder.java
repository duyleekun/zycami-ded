/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.codec;

public abstract class Base64$Coder {
    public int op;
    public byte[] output;

    public abstract int maxOutputSize(int var1);

    public abstract boolean process(byte[] var1, int var2, int var3, boolean var4);
}

