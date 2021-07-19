/*
 * Decompiled with CFR 0.151.
 */
package androidx.versionedparcelable;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;

public class VersionedParcelStream$FieldBuffer {
    public final DataOutputStream mDataStream;
    private final int mFieldId;
    public final ByteArrayOutputStream mOutput;
    private final DataOutputStream mTarget;

    public VersionedParcelStream$FieldBuffer(int n10, DataOutputStream dataOutputStream) {
        DataOutputStream dataOutputStream2;
        ByteArrayOutputStream byteArrayOutputStream;
        this.mOutput = byteArrayOutputStream = new ByteArrayOutputStream();
        this.mDataStream = dataOutputStream2 = new DataOutputStream(byteArrayOutputStream);
        this.mFieldId = n10;
        this.mTarget = dataOutputStream;
    }

    public void flushField() {
        DataOutputStream dataOutputStream;
        this.mDataStream.flush();
        ByteArrayOutputStream byteArrayOutputStream = this.mOutput;
        int n10 = byteArrayOutputStream.size();
        int n11 = this.mFieldId << 16;
        int n12 = -1;
        int n13 = n10 >= n12 ? n12 : n10;
        DataOutputStream dataOutputStream2 = this.mTarget;
        dataOutputStream2.writeInt(n11 |= n13);
        if (n10 >= n12) {
            dataOutputStream = this.mTarget;
            dataOutputStream.writeInt(n10);
        }
        byteArrayOutputStream = this.mOutput;
        dataOutputStream = this.mTarget;
        byteArrayOutputStream.writeTo(dataOutputStream);
    }
}

