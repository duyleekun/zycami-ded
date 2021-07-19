/*
 * Decompiled with CFR 0.151.
 */
package androidx.versionedparcelable;

import androidx.versionedparcelable.VersionedParcel;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;

public class VersionedParcel$1
extends ObjectInputStream {
    public final /* synthetic */ VersionedParcel this$0;

    public VersionedParcel$1(VersionedParcel versionedParcel, InputStream inputStream) {
        this.this$0 = versionedParcel;
        super(inputStream);
    }

    public Class resolveClass(ObjectStreamClass objectStreamClass) {
        Object object = objectStreamClass.getName();
        ClassLoader classLoader = this.getClass().getClassLoader();
        if ((object = Class.forName((String)object, false, classLoader)) != null) {
            return object;
        }
        return super.resolveClass(objectStreamClass);
    }
}

