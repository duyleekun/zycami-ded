/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.InvalidProtocolBufferException$InvalidWireTypeException;
import com.google.protobuf.MessageLite;
import java.io.IOException;

public class InvalidProtocolBufferException
extends IOException {
    private static final long serialVersionUID = -1616151763072450476L;
    private MessageLite unfinishedMessage;

    public InvalidProtocolBufferException(IOException iOException) {
        String string2 = iOException.getMessage();
        super(string2, iOException);
        this.unfinishedMessage = null;
    }

    public InvalidProtocolBufferException(String string2) {
        super(string2);
        this.unfinishedMessage = null;
    }

    public InvalidProtocolBufferException(String string2, IOException iOException) {
        super(string2, iOException);
        this.unfinishedMessage = null;
    }

    public static InvalidProtocolBufferException invalidEndTag() {
        InvalidProtocolBufferException invalidProtocolBufferException = new InvalidProtocolBufferException("Protocol message end-group tag did not match expected tag.");
        return invalidProtocolBufferException;
    }

    public static InvalidProtocolBufferException invalidTag() {
        InvalidProtocolBufferException invalidProtocolBufferException = new InvalidProtocolBufferException("Protocol message contained an invalid tag (zero).");
        return invalidProtocolBufferException;
    }

    public static InvalidProtocolBufferException invalidUtf8() {
        InvalidProtocolBufferException invalidProtocolBufferException = new InvalidProtocolBufferException("Protocol message had invalid UTF-8.");
        return invalidProtocolBufferException;
    }

    public static InvalidProtocolBufferException$InvalidWireTypeException invalidWireType() {
        InvalidProtocolBufferException$InvalidWireTypeException invalidProtocolBufferException$InvalidWireTypeException = new InvalidProtocolBufferException$InvalidWireTypeException("Protocol message tag had invalid wire type.");
        return invalidProtocolBufferException$InvalidWireTypeException;
    }

    public static InvalidProtocolBufferException malformedVarint() {
        InvalidProtocolBufferException invalidProtocolBufferException = new InvalidProtocolBufferException("CodedInputStream encountered a malformed varint.");
        return invalidProtocolBufferException;
    }

    public static InvalidProtocolBufferException negativeSize() {
        InvalidProtocolBufferException invalidProtocolBufferException = new InvalidProtocolBufferException("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        return invalidProtocolBufferException;
    }

    public static InvalidProtocolBufferException parseFailure() {
        InvalidProtocolBufferException invalidProtocolBufferException = new InvalidProtocolBufferException("Failed to parse the message.");
        return invalidProtocolBufferException;
    }

    public static InvalidProtocolBufferException recursionLimitExceeded() {
        InvalidProtocolBufferException invalidProtocolBufferException = new InvalidProtocolBufferException("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
        return invalidProtocolBufferException;
    }

    public static InvalidProtocolBufferException sizeLimitExceeded() {
        InvalidProtocolBufferException invalidProtocolBufferException = new InvalidProtocolBufferException("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit.");
        return invalidProtocolBufferException;
    }

    public static InvalidProtocolBufferException truncatedMessage() {
        InvalidProtocolBufferException invalidProtocolBufferException = new InvalidProtocolBufferException("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        return invalidProtocolBufferException;
    }

    public MessageLite getUnfinishedMessage() {
        return this.unfinishedMessage;
    }

    public InvalidProtocolBufferException setUnfinishedMessage(MessageLite messageLite) {
        this.unfinishedMessage = messageLite;
        return this;
    }

    public IOException unwrapIOException() {
        Throwable throwable = this.getCause();
        boolean bl2 = throwable instanceof IOException;
        throwable = bl2 ? (IOException)this.getCause() : this;
        return throwable;
    }
}

