/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.metadata.emsg;

import com.google.android.exoplayer2.metadata.emsg.EventMessage;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;

public final class EventMessageEncoder {
    private final ByteArrayOutputStream byteArrayOutputStream;
    private final DataOutputStream dataOutputStream;

    public EventMessageEncoder() {
        DataOutputStream dataOutputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        this.byteArrayOutputStream = byteArrayOutputStream = new ByteArrayOutputStream(512);
        this.dataOutputStream = dataOutputStream = new DataOutputStream(byteArrayOutputStream);
    }

    private static void writeNullTerminatedString(DataOutputStream dataOutputStream, String string2) {
        dataOutputStream.writeBytes(string2);
        dataOutputStream.writeByte(0);
    }

    private static void writeUnsignedInt(DataOutputStream dataOutputStream, long l10) {
        int n10 = (int)(l10 >>> 24) & 0xFF;
        dataOutputStream.writeByte(n10);
        n10 = (int)(l10 >>> 16) & 0xFF;
        dataOutputStream.writeByte(n10);
        n10 = (int)(l10 >>> 8) & 0xFF;
        dataOutputStream.writeByte(n10);
        int n11 = (int)l10 & 0xFF;
        dataOutputStream.writeByte(n11);
    }

    public byte[] encode(EventMessage object) {
        Object object2;
        Object object3;
        block14: {
            object3 = this.byteArrayOutputStream;
            ((ByteArrayOutputStream)object3).reset();
            try {
                object3 = this.dataOutputStream;
            }
            catch (IOException iOException) {
                object3 = new RuntimeException(iOException);
                throw object3;
            }
            object2 = ((EventMessage)object).schemeIdUri;
            EventMessageEncoder.writeNullTerminatedString((DataOutputStream)object3, (String)object2);
            object3 = ((EventMessage)object).value;
            if (object3 != null) break block14;
            object3 = "";
        }
        object2 = this.dataOutputStream;
        EventMessageEncoder.writeNullTerminatedString((DataOutputStream)object2, (String)object3);
        object3 = this.dataOutputStream;
        long l10 = ((EventMessage)object).durationMs;
        EventMessageEncoder.writeUnsignedInt((DataOutputStream)object3, l10);
        object3 = this.dataOutputStream;
        l10 = ((EventMessage)object).id;
        EventMessageEncoder.writeUnsignedInt((DataOutputStream)object3, l10);
        object3 = this.dataOutputStream;
        object = ((EventMessage)object).messageData;
        ((FilterOutputStream)object3).write((byte[])object);
        object = this.dataOutputStream;
        ((DataOutputStream)object).flush();
        object = this.byteArrayOutputStream;
        return ((ByteArrayOutputStream)object).toByteArray();
    }
}

