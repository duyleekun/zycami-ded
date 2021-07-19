/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.extractor.ts;

import com.google.android.exoplayer2.util.Log;
import java.util.Arrays;

public final class H263Reader$CsdBuffer {
    private static final byte[] START_CODE;
    private static final int STATE_EXPECT_VIDEO_OBJECT_LAYER_START = 3;
    private static final int STATE_EXPECT_VIDEO_OBJECT_START = 2;
    private static final int STATE_EXPECT_VISUAL_OBJECT_START = 1;
    private static final int STATE_SKIP_TO_VISUAL_OBJECT_SEQUENCE_START = 0;
    private static final int STATE_WAIT_FOR_VOP_START = 4;
    public byte[] data;
    private boolean isFilling;
    public int length;
    private int state;
    public int volStartPosition;

    static {
        byte[] byArray;
        byte[] byArray2 = byArray = new byte[3];
        byArray[0] = 0;
        byArray2[1] = 0;
        byArray2[2] = 1;
        START_CODE = byArray;
    }

    public H263Reader$CsdBuffer(int n10) {
        byte[] byArray = new byte[n10];
        this.data = byArray;
    }

    public void onData(byte[] byArray, int n10, int n11) {
        int n12;
        boolean bl2 = this.isFilling;
        if (!bl2) {
            return;
        }
        byte[] byArray2 = this.data;
        int n13 = byArray2.length;
        int n14 = this.length;
        int n15 = n14 + (n11 -= n10);
        if (n13 < n15) {
            n14 = (n14 + n11) * 2;
            this.data = byArray2 = Arrays.copyOf(byArray2, n14);
        }
        byArray2 = this.data;
        n13 = this.length;
        System.arraycopy(byArray, n10, byArray2, n13, n11);
        this.length = n12 = this.length + n11;
    }

    /*
     * Enabled aggressive block sorting
     */
    public boolean onStartCode(int n10, int n11) {
        block11: {
            boolean bl2;
            block12: {
                String string2;
                String string3;
                int n12;
                int n13;
                block13: {
                    int n14;
                    block14: {
                        int n15 = this.state;
                        bl2 = true;
                        if (n15 == 0) break block12;
                        n13 = 181;
                        n12 = 2;
                        string3 = "Unexpected start code value";
                        string2 = "H263Reader";
                        if (n15 == bl2) break block13;
                        n14 = 3;
                        if (n15 == n12) break block14;
                        n12 = 4;
                        if (n15 != n14) {
                            if (n15 != n12) {
                                IllegalStateException illegalStateException = new IllegalStateException();
                                throw illegalStateException;
                            }
                            n15 = 179;
                            if (n10 == n15 || n10 == n13) {
                                this.length = n10 = this.length - n11;
                                this.isFilling = false;
                                return bl2;
                            }
                            break block11;
                        } else {
                            n11 = 32;
                            if ((n10 &= 0xF0) != n11) {
                                Log.w(string2, string3);
                                this.reset();
                                break block11;
                            } else {
                                this.volStartPosition = n10 = this.length;
                                this.state = n12;
                            }
                        }
                        break block11;
                    }
                    n11 = 31;
                    if (n10 > n11) {
                        Log.w(string2, string3);
                        this.reset();
                        break block11;
                    } else {
                        this.state = n14;
                    }
                    break block11;
                }
                if (n10 != n13) {
                    Log.w(string2, string3);
                    this.reset();
                    break block11;
                } else {
                    this.state = n12;
                }
                break block11;
            }
            n11 = 176;
            if (n10 == n11) {
                this.state = bl2;
                this.isFilling = bl2;
            }
        }
        byte[] byArray = START_CODE;
        n11 = byArray.length;
        this.onData(byArray, 0, n11);
        return false;
    }

    public void reset() {
        this.isFilling = false;
        this.length = 0;
        this.state = 0;
    }
}

