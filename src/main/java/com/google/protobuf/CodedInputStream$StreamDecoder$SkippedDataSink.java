/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.CodedInputStream$StreamDecoder;
import com.google.protobuf.CodedInputStream$StreamDecoder$RefillCallback;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;

public class CodedInputStream$StreamDecoder$SkippedDataSink
implements CodedInputStream$StreamDecoder$RefillCallback {
    private ByteArrayOutputStream byteArrayStream;
    private int lastPos;
    public final /* synthetic */ CodedInputStream$StreamDecoder this$0;

    private CodedInputStream$StreamDecoder$SkippedDataSink(CodedInputStream$StreamDecoder codedInputStream$StreamDecoder) {
        int n10;
        this.this$0 = codedInputStream$StreamDecoder;
        this.lastPos = n10 = CodedInputStream$StreamDecoder.access$500(codedInputStream$StreamDecoder);
    }

    public ByteBuffer getSkippedData() {
        Object object = this.byteArrayStream;
        if (object == null) {
            object = CodedInputStream$StreamDecoder.access$600(this.this$0);
            int n10 = this.lastPos;
            int n11 = CodedInputStream$StreamDecoder.access$500(this.this$0);
            int n12 = this.lastPos;
            return ByteBuffer.wrap((byte[])object, n10, n11 -= n12);
        }
        byte[] byArray = CodedInputStream$StreamDecoder.access$600(this.this$0);
        int n13 = this.lastPos;
        int n14 = CodedInputStream$StreamDecoder.access$500(this.this$0);
        ((ByteArrayOutputStream)object).write(byArray, n13, n14);
        return ByteBuffer.wrap(this.byteArrayStream.toByteArray());
    }

    public void onRefill() {
        ByteArrayOutputStream byteArrayOutputStream = this.byteArrayStream;
        if (byteArrayOutputStream == null) {
            this.byteArrayStream = byteArrayOutputStream = new ByteArrayOutputStream();
        }
        byteArrayOutputStream = this.byteArrayStream;
        byte[] byArray = CodedInputStream$StreamDecoder.access$600(this.this$0);
        int n10 = this.lastPos;
        int n11 = CodedInputStream$StreamDecoder.access$500(this.this$0);
        int n12 = this.lastPos;
        byteArrayOutputStream.write(byArray, n10, n11 -= n12);
        this.lastPos = 0;
    }
}

