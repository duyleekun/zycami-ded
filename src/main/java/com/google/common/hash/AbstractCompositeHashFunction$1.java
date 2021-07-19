/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.hash;

import com.google.common.hash.AbstractCompositeHashFunction;
import com.google.common.hash.Funnel;
import com.google.common.hash.HashCode;
import com.google.common.hash.Hasher;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

public class AbstractCompositeHashFunction$1
implements Hasher {
    public final /* synthetic */ AbstractCompositeHashFunction this$0;
    public final /* synthetic */ Hasher[] val$hashers;

    public AbstractCompositeHashFunction$1(AbstractCompositeHashFunction abstractCompositeHashFunction, Hasher[] hasherArray) {
        this.this$0 = abstractCompositeHashFunction;
        this.val$hashers = hasherArray;
    }

    public HashCode hash() {
        AbstractCompositeHashFunction abstractCompositeHashFunction = this.this$0;
        Hasher[] hasherArray = this.val$hashers;
        return abstractCompositeHashFunction.makeHash(hasherArray);
    }

    public Hasher putBoolean(boolean bl2) {
        for (Hasher hasher : this.val$hashers) {
            hasher.putBoolean(bl2);
        }
        return this;
    }

    public Hasher putByte(byte by2) {
        for (Hasher hasher : this.val$hashers) {
            hasher.putByte(by2);
        }
        return this;
    }

    public Hasher putBytes(ByteBuffer byteBuffer) {
        int n10 = byteBuffer.position();
        for (Hasher hasher : this.val$hashers) {
            byteBuffer.position(n10);
            hasher.putBytes(byteBuffer);
        }
        return this;
    }

    public Hasher putBytes(byte[] byArray) {
        for (Hasher hasher : this.val$hashers) {
            hasher.putBytes(byArray);
        }
        return this;
    }

    public Hasher putBytes(byte[] byArray, int n10, int n11) {
        for (Hasher hasher : this.val$hashers) {
            hasher.putBytes(byArray, n10, n11);
        }
        return this;
    }

    public Hasher putChar(char c10) {
        for (Hasher hasher : this.val$hashers) {
            hasher.putChar(c10);
        }
        return this;
    }

    public Hasher putDouble(double d10) {
        for (Hasher hasher : this.val$hashers) {
            hasher.putDouble(d10);
        }
        return this;
    }

    public Hasher putFloat(float f10) {
        for (Hasher hasher : this.val$hashers) {
            hasher.putFloat(f10);
        }
        return this;
    }

    public Hasher putInt(int n10) {
        for (Hasher hasher : this.val$hashers) {
            hasher.putInt(n10);
        }
        return this;
    }

    public Hasher putLong(long l10) {
        for (Hasher hasher : this.val$hashers) {
            hasher.putLong(l10);
        }
        return this;
    }

    public Hasher putObject(Object object, Funnel funnel) {
        for (Hasher hasher : this.val$hashers) {
            hasher.putObject(object, funnel);
        }
        return this;
    }

    public Hasher putShort(short s10) {
        for (Hasher hasher : this.val$hashers) {
            hasher.putShort(s10);
        }
        return this;
    }

    public Hasher putString(CharSequence charSequence, Charset charset) {
        for (Hasher hasher : this.val$hashers) {
            hasher.putString(charSequence, charset);
        }
        return this;
    }

    public Hasher putUnencodedChars(CharSequence charSequence) {
        for (Hasher hasher : this.val$hashers) {
            hasher.putUnencodedChars(charSequence);
        }
        return this;
    }
}

