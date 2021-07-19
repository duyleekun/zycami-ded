/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.extractor;

import com.google.android.exoplayer2.extractor.ExtractorInput;

public class ForwardingExtractorInput
implements ExtractorInput {
    private final ExtractorInput input;

    public ForwardingExtractorInput(ExtractorInput extractorInput) {
        this.input = extractorInput;
    }

    public void advancePeekPosition(int n10) {
        this.input.advancePeekPosition(n10);
    }

    public boolean advancePeekPosition(int n10, boolean bl2) {
        return this.input.advancePeekPosition(n10, bl2);
    }

    public long getLength() {
        return this.input.getLength();
    }

    public long getPeekPosition() {
        return this.input.getPeekPosition();
    }

    public long getPosition() {
        return this.input.getPosition();
    }

    public int peek(byte[] byArray, int n10, int n11) {
        return this.input.peek(byArray, n10, n11);
    }

    public void peekFully(byte[] byArray, int n10, int n11) {
        this.input.peekFully(byArray, n10, n11);
    }

    public boolean peekFully(byte[] byArray, int n10, int n11, boolean bl2) {
        return this.input.peekFully(byArray, n10, n11, bl2);
    }

    public int read(byte[] byArray, int n10, int n11) {
        return this.input.read(byArray, n10, n11);
    }

    public void readFully(byte[] byArray, int n10, int n11) {
        this.input.readFully(byArray, n10, n11);
    }

    public boolean readFully(byte[] byArray, int n10, int n11, boolean bl2) {
        return this.input.readFully(byArray, n10, n11, bl2);
    }

    public void resetPeekPosition() {
        this.input.resetPeekPosition();
    }

    public void setRetryPosition(long l10, Throwable throwable) {
        this.input.setRetryPosition(l10, throwable);
    }

    public int skip(int n10) {
        return this.input.skip(n10);
    }

    public void skipFully(int n10) {
        this.input.skipFully(n10);
    }

    public boolean skipFully(int n10, boolean bl2) {
        return this.input.skipFully(n10, bl2);
    }
}

