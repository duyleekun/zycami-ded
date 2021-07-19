/*
 * Decompiled with CFR 0.151.
 */
package com.tencent.rtmp.sharp.jni;

public class RingBuffer {
    private final int DEFAULT_SIZE;
    public int c_totalSize;
    public boolean m_isEmpty;
    public byte[] m_pBuf;
    public int m_read;
    public int m_write;

    public RingBuffer() {
        boolean bl2;
        int n10;
        this.DEFAULT_SIZE = n10 = 1000;
        this.c_totalSize = n10;
        this.m_read = 0;
        this.m_write = 0;
        this.m_isEmpty = bl2 = true;
        this.m_pBuf = null;
        this.c_totalSize = n10;
        this.m_isEmpty = bl2;
        this.m_read = 0;
        this.m_write = 0;
        byte[] byArray = new byte[n10];
        this.m_pBuf = byArray;
    }

    public RingBuffer(int n10) {
        boolean bl2;
        int n11;
        this.DEFAULT_SIZE = n11 = 1000;
        this.c_totalSize = n11;
        this.m_read = 0;
        this.m_write = 0;
        this.m_isEmpty = bl2 = true;
        this.c_totalSize = n10;
        this.m_isEmpty = bl2;
        this.m_read = 0;
        this.m_write = 0;
        byte[] byArray = new byte[n10];
        this.m_pBuf = byArray;
    }

    public void Clear() {
        this.m_write = 0;
        this.m_read = 0;
        this.m_isEmpty = true;
    }

    public boolean Pop(byte[] byArray, int n10) {
        byte[] byArray2 = this.m_pBuf;
        int n11 = 0;
        if (byArray2 == null) {
            return false;
        }
        int n12 = this.RemainRead();
        if (n12 >= n10 && n10 > 0) {
            n12 = this.c_totalSize;
            int n13 = this.m_read;
            int n14 = n12 - n13;
            if (n14 >= n10) {
                byArray2 = this.m_pBuf;
                System.arraycopy(byArray2, n13, byArray, 0, n10);
            } else {
                byte[] byArray3 = this.m_pBuf;
                System.arraycopy(byArray3, n13, byArray, 0, n12 -= n13);
                byArray2 = this.m_pBuf;
                n13 = this.c_totalSize;
                n14 = this.m_read;
                int n15 = n13 - n14;
                n13 -= n14;
                n13 = n10 - n13;
                System.arraycopy(byArray2, 0, byArray, n15, n13);
            }
            int n16 = this.m_read + n10;
            n10 = this.c_totalSize;
            this.m_read = n16 %= n10;
            n10 = this.m_write;
            n12 = 1;
            if (n16 == n10) {
                n11 = n12;
            }
            this.m_isEmpty = n11;
            return n12 != 0;
        }
        return false;
    }

    public void Push(byte[] byArray, int n10) {
        byte[] byArray2 = this.m_pBuf;
        if (byArray2 == null) {
            return;
        }
        int n11 = this.RemainWrite();
        if (n11 < n10) {
            return;
        }
        n11 = this.c_totalSize;
        int n12 = this.m_write;
        int n13 = n11 - n12;
        if (n13 >= n10) {
            byArray2 = this.m_pBuf;
            System.arraycopy(byArray, 0, byArray2, n12, n10);
        } else {
            byte[] byArray3 = this.m_pBuf;
            System.arraycopy(byArray, 0, byArray3, n12, n11 -= n12);
            n11 = this.c_totalSize;
            n12 = this.m_write;
            n13 = n11 - n12;
            byte[] byArray4 = this.m_pBuf;
            n11 -= n12;
            n11 = n10 - n11;
            System.arraycopy(byArray, n13, byArray4, 0, n11);
        }
        int n14 = this.m_write + n10;
        n10 = this.c_totalSize;
        this.m_write = n14 %= n10;
        this.m_isEmpty = false;
    }

    public int RemainRead() {
        int n10 = this.m_write;
        int n11 = this.m_read;
        if (n10 < n11) {
            return this.c_totalSize - n11 + n10;
        }
        if (n10 > n11) {
            return n10 - n11;
        }
        n10 = (int)(this.m_isEmpty ? 1 : 0);
        n10 = n10 != 0 ? 0 : this.c_totalSize;
        return n10;
    }

    public int RemainWrite() {
        int n10 = this.c_totalSize;
        int n11 = this.RemainRead();
        return n10 - n11;
    }
}

