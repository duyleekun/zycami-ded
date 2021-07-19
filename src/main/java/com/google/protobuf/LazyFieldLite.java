/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import com.google.protobuf.MessageLite$Builder;
import com.google.protobuf.Writer;
import java.util.Objects;

public class LazyFieldLite {
    private static final ExtensionRegistryLite EMPTY_REGISTRY = ExtensionRegistryLite.getEmptyRegistry();
    private ByteString delayedBytes;
    private ExtensionRegistryLite extensionRegistry;
    private volatile ByteString memoizedBytes;
    public volatile MessageLite value;

    public LazyFieldLite() {
    }

    public LazyFieldLite(ExtensionRegistryLite extensionRegistryLite, ByteString byteString) {
        LazyFieldLite.checkArguments(extensionRegistryLite, byteString);
        this.extensionRegistry = extensionRegistryLite;
        this.delayedBytes = byteString;
    }

    private static void checkArguments(ExtensionRegistryLite extensionRegistryLite, ByteString byteString) {
        Objects.requireNonNull(extensionRegistryLite, "found null ExtensionRegistry");
        Objects.requireNonNull(byteString, "found null ByteString");
    }

    public static LazyFieldLite fromValue(MessageLite messageLite) {
        LazyFieldLite lazyFieldLite = new LazyFieldLite();
        lazyFieldLite.setValue(messageLite);
        return lazyFieldLite;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static MessageLite mergeValueAndBytes(MessageLite messageLite, ByteString object, ExtensionRegistryLite extensionRegistryLite) {
        MessageLite$Builder messageLite$Builder;
        try {
            messageLite$Builder = messageLite.toBuilder();
        }
        catch (InvalidProtocolBufferException invalidProtocolBufferException) {
            return messageLite;
        }
        object = messageLite$Builder.mergeFrom((ByteString)object, extensionRegistryLite);
        return object.build();
    }

    public void clear() {
        this.delayedBytes = null;
        this.value = null;
        this.memoizedBytes = null;
    }

    public boolean containsDefaultInstance() {
        boolean bl2;
        Object object = this.memoizedBytes;
        ByteString byteString = ByteString.EMPTY;
        if (object != byteString && ((object = this.value) != null || (object = this.delayedBytes) != null && object != byteString)) {
            bl2 = false;
            object = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void ensureInitialized(MessageLite object) {
        Object object2 = this.value;
        if (object2 != null) {
            return;
        }
        synchronized (this) {
            object2 = this.value;
            if (object2 != null) {
                return;
            }
            try {
                object2 = this.delayedBytes;
                if (object2 != null) {
                    object2 = object.getParserForType();
                    ByteString byteString = this.delayedBytes;
                    ExtensionRegistryLite extensionRegistryLite = this.extensionRegistry;
                    object2 = object2.parseFrom(byteString, extensionRegistryLite);
                    this.value = object2 = (MessageLite)object2;
                    this.memoizedBytes = object2 = this.delayedBytes;
                } else {
                    this.value = object;
                    this.memoizedBytes = object2 = ByteString.EMPTY;
                }
            }
            catch (InvalidProtocolBufferException invalidProtocolBufferException) {
                this.value = object;
                this.memoizedBytes = object = ByteString.EMPTY;
            }
            return;
        }
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        boolean bl2 = object instanceof LazyFieldLite;
        if (!bl2) {
            return false;
        }
        object = (LazyFieldLite)object;
        Object object2 = this.value;
        MessageLite messageLite = ((LazyFieldLite)object).value;
        if (object2 == null && messageLite == null) {
            object2 = this.toByteString();
            object = ((LazyFieldLite)object).toByteString();
            return ((ByteString)object2).equals(object);
        }
        if (object2 != null && messageLite != null) {
            return object2.equals(messageLite);
        }
        if (object2 != null) {
            messageLite = object2.getDefaultInstanceForType();
            object = ((LazyFieldLite)object).getValue(messageLite);
            return object2.equals(object);
        }
        object = messageLite.getDefaultInstanceForType();
        return this.getValue((MessageLite)object).equals(messageLite);
    }

    public int getSerializedSize() {
        Object object = this.memoizedBytes;
        if (object != null) {
            return this.memoizedBytes.size();
        }
        object = this.delayedBytes;
        if (object != null) {
            return ((ByteString)object).size();
        }
        object = this.value;
        if (object != null) {
            return this.value.getSerializedSize();
        }
        return 0;
    }

    public MessageLite getValue(MessageLite messageLite) {
        this.ensureInitialized(messageLite);
        return this.value;
    }

    public int hashCode() {
        return 1;
    }

    public void merge(LazyFieldLite object) {
        Object object2;
        boolean bl2 = ((LazyFieldLite)object).containsDefaultInstance();
        if (bl2) {
            return;
        }
        bl2 = this.containsDefaultInstance();
        if (bl2) {
            this.set((LazyFieldLite)object);
            return;
        }
        Object object3 = this.extensionRegistry;
        if (object3 == null) {
            this.extensionRegistry = object3 = ((LazyFieldLite)object).extensionRegistry;
        }
        if ((object3 = this.delayedBytes) != null && (object2 = ((LazyFieldLite)object).delayedBytes) != null) {
            this.delayedBytes = object = ((ByteString)object3).concat((ByteString)object2);
            return;
        }
        object3 = this.value;
        if (object3 == null && (object3 = ((LazyFieldLite)object).value) != null) {
            object = ((LazyFieldLite)object).value;
            object3 = this.delayedBytes;
            object2 = this.extensionRegistry;
            object = LazyFieldLite.mergeValueAndBytes((MessageLite)object, (ByteString)object3, (ExtensionRegistryLite)object2);
            this.setValue((MessageLite)object);
            return;
        }
        object3 = this.value;
        if (object3 != null && (object3 = ((LazyFieldLite)object).value) == null) {
            object3 = this.value;
            object2 = ((LazyFieldLite)object).delayedBytes;
            object = ((LazyFieldLite)object).extensionRegistry;
            object = LazyFieldLite.mergeValueAndBytes((MessageLite)object3, (ByteString)object2, (ExtensionRegistryLite)object);
            this.setValue((MessageLite)object);
            return;
        }
        object3 = this.value.toBuilder();
        object = ((LazyFieldLite)object).value;
        object = object3.mergeFrom((MessageLite)object).build();
        this.setValue((MessageLite)object);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public void mergeFrom(CodedInputStream object, ExtensionRegistryLite extensionRegistryLite) {
        boolean bl2 = this.containsDefaultInstance();
        if (bl2) {
            object = ((CodedInputStream)object).readBytes();
            this.setByteString((ByteString)object, extensionRegistryLite);
            return;
        }
        Object object2 = this.extensionRegistry;
        if (object2 == null) {
            this.extensionRegistry = extensionRegistryLite;
        }
        if ((object2 = this.delayedBytes) != null) {
            object = ((CodedInputStream)object).readBytes();
            object = ((ByteString)object2).concat((ByteString)object);
            extensionRegistryLite = this.extensionRegistry;
            this.setByteString((ByteString)object, extensionRegistryLite);
            return;
        }
        try {
            object2 = this.value;
        }
        catch (InvalidProtocolBufferException invalidProtocolBufferException) {
            return;
        }
        object2 = object2.toBuilder();
        object = object2.mergeFrom((CodedInputStream)object, extensionRegistryLite);
        object = object.build();
        this.setValue((MessageLite)object);
    }

    public void set(LazyFieldLite object) {
        Object object2 = ((LazyFieldLite)object).delayedBytes;
        this.delayedBytes = object2;
        this.value = object2 = ((LazyFieldLite)object).value;
        this.memoizedBytes = object2 = ((LazyFieldLite)object).memoizedBytes;
        object = ((LazyFieldLite)object).extensionRegistry;
        if (object != null) {
            this.extensionRegistry = object;
        }
    }

    public void setByteString(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        LazyFieldLite.checkArguments(extensionRegistryLite, byteString);
        this.delayedBytes = byteString;
        this.extensionRegistry = extensionRegistryLite;
        this.value = null;
        this.memoizedBytes = null;
    }

    public MessageLite setValue(MessageLite messageLite) {
        MessageLite messageLite2 = this.value;
        this.delayedBytes = null;
        this.memoizedBytes = null;
        this.value = messageLite;
        return messageLite2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public ByteString toByteString() {
        Object object = this.memoizedBytes;
        if (object != null) {
            return this.memoizedBytes;
        }
        object = this.delayedBytes;
        if (object != null) {
            return object;
        }
        synchronized (this) {
            object = this.memoizedBytes;
            if (object != null) {
                return this.memoizedBytes;
            }
            object = this.value;
            if (object == null) {
                this.memoizedBytes = object = ByteString.EMPTY;
                return this.memoizedBytes;
            } else {
                object = this.value;
                this.memoizedBytes = object = object.toByteString();
            }
            return this.memoizedBytes;
        }
    }

    public void writeTo(Writer writer, int n10) {
        Object object = this.memoizedBytes;
        if (object != null) {
            object = this.memoizedBytes;
            writer.writeBytes(n10, (ByteString)object);
        } else {
            object = this.delayedBytes;
            if (object != null) {
                writer.writeBytes(n10, (ByteString)object);
            } else {
                object = this.value;
                if (object != null) {
                    object = this.value;
                    writer.writeMessage(n10, object);
                } else {
                    object = ByteString.EMPTY;
                    writer.writeBytes(n10, (ByteString)object);
                }
            }
        }
    }
}

