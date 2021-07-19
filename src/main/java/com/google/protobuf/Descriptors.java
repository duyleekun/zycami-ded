/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.Descriptors$FileDescriptor;
import java.util.logging.Logger;

public final class Descriptors {
    private static final Logger logger = Logger.getLogger(Descriptors.class.getName());

    public static /* synthetic */ Logger access$100() {
        return logger;
    }

    public static /* synthetic */ String access$1700(Descriptors$FileDescriptor descriptors$FileDescriptor, Descriptors$Descriptor descriptors$Descriptor, String string2) {
        return Descriptors.computeFullName(descriptors$FileDescriptor, descriptors$Descriptor, string2);
    }

    private static String computeFullName(Descriptors$FileDescriptor object, Descriptors$Descriptor object2, String string2) {
        char c10 = '.';
        if (object2 != null) {
            object = new StringBuilder();
            object2 = ((Descriptors$Descriptor)object2).getFullName();
            ((StringBuilder)object).append((String)object2);
            ((StringBuilder)object).append(c10);
            ((StringBuilder)object).append(string2);
            return ((StringBuilder)object).toString();
        }
        boolean bl2 = ((String)(object = ((Descriptors$FileDescriptor)object).getPackage())).isEmpty();
        if (!bl2) {
            object2 = new StringBuilder();
            ((StringBuilder)object2).append((String)object);
            ((StringBuilder)object2).append(c10);
            ((StringBuilder)object2).append(string2);
            return ((StringBuilder)object2).toString();
        }
        return string2;
    }
}

