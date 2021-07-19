/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud;

import cn.leancloud.Messages;
import cn.leancloud.Messages$1;
import cn.leancloud.Messages$RoomCommand$1;
import cn.leancloud.Messages$RoomCommand$Builder;
import cn.leancloud.Messages$RoomCommandOrBuilder;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.GeneratedMessageV3$Builder;
import com.google.protobuf.GeneratedMessageV3$BuilderParent;
import com.google.protobuf.GeneratedMessageV3$FieldAccessorTable;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.LazyStringArrayList;
import com.google.protobuf.LazyStringList;
import com.google.protobuf.Parser;
import com.google.protobuf.ProtocolStringList;
import com.google.protobuf.UnknownFieldSet;
import com.google.protobuf.UnknownFieldSet$Builder;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class Messages$RoomCommand
extends GeneratedMessageV3
implements Messages$RoomCommandOrBuilder {
    public static final int BYPEERID_FIELD_NUMBER = 7;
    private static final Messages$RoomCommand DEFAULT_INSTANCE;
    public static final int N_FIELD_NUMBER = 4;
    public static final Parser PARSER;
    public static final int ROOMID_FIELD_NUMBER = 1;
    public static final int ROOMPEERIDS_FIELD_NUMBER = 6;
    public static final int S_FIELD_NUMBER = 2;
    public static final int TRANSIENT_FIELD_NUMBER = 5;
    public static final int T_FIELD_NUMBER = 3;
    private static final long serialVersionUID;
    private int bitField0_;
    private volatile Object byPeerId_;
    private byte memoizedIsInitialized;
    private volatile Object n_;
    private volatile Object roomId_;
    private LazyStringList roomPeerIds_;
    private volatile Object s_;
    private long t_;
    private boolean transient_;

    static {
        Object object = new Messages$RoomCommand();
        DEFAULT_INSTANCE = object;
        PARSER = object = new Messages$RoomCommand$1();
    }

    private Messages$RoomCommand() {
        LazyStringList lazyStringList;
        this.memoizedIsInitialized = (byte)-1;
        String string2 = "";
        this.roomId_ = string2;
        this.s_ = string2;
        this.t_ = 0L;
        this.n_ = string2;
        this.transient_ = false;
        this.roomPeerIds_ = lazyStringList = LazyStringArrayList.EMPTY;
        this.byPeerId_ = string2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private Messages$RoomCommand(CodedInputStream object, ExtensionRegistryLite object2) {
        int n10;
        int n11;
        UnknownFieldSet$Builder unknownFieldSet$Builder;
        block18: {
            Throwable throwable2;
            this();
            unknownFieldSet$Builder = UnknownFieldSet.newBuilder();
            int n12 = 0;
            n11 = 0;
            while (true) {
                n10 = 32;
                if (n12 != 0) break block18;
                try {
                    try {
                        int n13;
                        block19: {
                            int n14 = ((CodedInputStream)object).readTag();
                            n13 = 1;
                            if (n14 != 0) {
                                ByteString byteString;
                                int n15 = 10;
                                if (n14 != n15) {
                                    n15 = 18;
                                    if (n14 != n15) {
                                        long l10;
                                        n15 = 24;
                                        if (n14 != n15) {
                                            n15 = 34;
                                            if (n14 != n15) {
                                                n15 = 40;
                                                if (n14 != n15) {
                                                    LazyStringList lazyStringList;
                                                    n15 = 50;
                                                    if (n14 != n15) {
                                                        n15 = 58;
                                                        if (n14 != n15) {
                                                            n10 = (int)(this.parseUnknownField((CodedInputStream)object, unknownFieldSet$Builder, (ExtensionRegistryLite)object2, n14) ? 1 : 0);
                                                            if (n10 != 0) continue;
                                                            break block19;
                                                        } else {
                                                            byteString = ((CodedInputStream)object).readBytes();
                                                            this.bitField0_ = n13 = this.bitField0_ | n10;
                                                            this.byPeerId_ = byteString;
                                                            continue;
                                                        }
                                                    }
                                                    byteString = ((CodedInputStream)object).readBytes();
                                                    n13 = n11 & 0x20;
                                                    if (n13 != n10) {
                                                        this.roomPeerIds_ = lazyStringList = new LazyStringArrayList();
                                                        n11 |= 0x20;
                                                    }
                                                    lazyStringList = this.roomPeerIds_;
                                                    lazyStringList.add(byteString);
                                                    continue;
                                                }
                                                this.bitField0_ = n14 = this.bitField0_ | 0x10;
                                                n14 = (int)(((CodedInputStream)object).readBool() ? 1 : 0);
                                                this.transient_ = n14;
                                                continue;
                                            }
                                            byteString = ((CodedInputStream)object).readBytes();
                                            this.bitField0_ = n13 = this.bitField0_ | 8;
                                            this.n_ = byteString;
                                            continue;
                                        }
                                        this.bitField0_ = n14 = this.bitField0_ | 4;
                                        this.t_ = l10 = ((CodedInputStream)object).readInt64();
                                        continue;
                                    }
                                    byteString = ((CodedInputStream)object).readBytes();
                                    this.bitField0_ = n13 = this.bitField0_ | 2;
                                    this.s_ = byteString;
                                    continue;
                                }
                                byteString = ((CodedInputStream)object).readBytes();
                                n15 = this.bitField0_;
                                this.bitField0_ = n13 |= n15;
                                this.roomId_ = byteString;
                                continue;
                            }
                        }
                        n12 = n13;
                        continue;
                    }
                    catch (IOException iOException) {
                        object2 = new InvalidProtocolBufferException(iOException);
                        InvalidProtocolBufferException invalidProtocolBufferException = ((InvalidProtocolBufferException)object2).setUnfinishedMessage(this);
                        throw invalidProtocolBufferException;
                    }
                    catch (InvalidProtocolBufferException invalidProtocolBufferException) {
                        InvalidProtocolBufferException invalidProtocolBufferException2 = invalidProtocolBufferException.setUnfinishedMessage(this);
                        throw invalidProtocolBufferException2;
                    }
                }
                catch (Throwable throwable2) {}
                break;
            }
            int n16 = n11 & 0x20;
            if (n16 == n10) {
                this.roomPeerIds_ = object2 = this.roomPeerIds_.getUnmodifiableView();
            }
            this.unknownFields = object2 = unknownFieldSet$Builder.build();
            this.makeExtensionsImmutable();
            throw throwable2;
        }
        int n17 = n11 & 0x20;
        if (n17 == n10) {
            this.roomPeerIds_ = object = this.roomPeerIds_.getUnmodifiableView();
        }
        this.unknownFields = object = unknownFieldSet$Builder.build();
        this.makeExtensionsImmutable();
    }

    public /* synthetic */ Messages$RoomCommand(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, Messages$1 messages$1) {
        this(codedInputStream, extensionRegistryLite);
    }

    private Messages$RoomCommand(GeneratedMessageV3$Builder generatedMessageV3$Builder) {
        super(generatedMessageV3$Builder);
        this.memoizedIsInitialized = (byte)-1;
    }

    public /* synthetic */ Messages$RoomCommand(GeneratedMessageV3$Builder generatedMessageV3$Builder, Messages$1 messages$1) {
        this(generatedMessageV3$Builder);
    }

    public static /* synthetic */ boolean access$29000() {
        return GeneratedMessageV3.alwaysUseFieldBuilders;
    }

    public static /* synthetic */ Object access$29200(Messages$RoomCommand messages$RoomCommand) {
        return messages$RoomCommand.roomId_;
    }

    public static /* synthetic */ Object access$29202(Messages$RoomCommand messages$RoomCommand, Object object) {
        messages$RoomCommand.roomId_ = object;
        return object;
    }

    public static /* synthetic */ Object access$29300(Messages$RoomCommand messages$RoomCommand) {
        return messages$RoomCommand.s_;
    }

    public static /* synthetic */ Object access$29302(Messages$RoomCommand messages$RoomCommand, Object object) {
        messages$RoomCommand.s_ = object;
        return object;
    }

    public static /* synthetic */ long access$29402(Messages$RoomCommand messages$RoomCommand, long l10) {
        messages$RoomCommand.t_ = l10;
        return l10;
    }

    public static /* synthetic */ Object access$29500(Messages$RoomCommand messages$RoomCommand) {
        return messages$RoomCommand.n_;
    }

    public static /* synthetic */ Object access$29502(Messages$RoomCommand messages$RoomCommand, Object object) {
        messages$RoomCommand.n_ = object;
        return object;
    }

    public static /* synthetic */ boolean access$29602(Messages$RoomCommand messages$RoomCommand, boolean bl2) {
        messages$RoomCommand.transient_ = bl2;
        return bl2;
    }

    public static /* synthetic */ LazyStringList access$29700(Messages$RoomCommand messages$RoomCommand) {
        return messages$RoomCommand.roomPeerIds_;
    }

    public static /* synthetic */ LazyStringList access$29702(Messages$RoomCommand messages$RoomCommand, LazyStringList lazyStringList) {
        messages$RoomCommand.roomPeerIds_ = lazyStringList;
        return lazyStringList;
    }

    public static /* synthetic */ Object access$29800(Messages$RoomCommand messages$RoomCommand) {
        return messages$RoomCommand.byPeerId_;
    }

    public static /* synthetic */ Object access$29802(Messages$RoomCommand messages$RoomCommand, Object object) {
        messages$RoomCommand.byPeerId_ = object;
        return object;
    }

    public static /* synthetic */ int access$29902(Messages$RoomCommand messages$RoomCommand, int n10) {
        messages$RoomCommand.bitField0_ = n10;
        return n10;
    }

    public static /* synthetic */ UnknownFieldSet access$30000(Messages$RoomCommand messages$RoomCommand) {
        return messages$RoomCommand.unknownFields;
    }

    public static Messages$RoomCommand getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors$Descriptor getDescriptor() {
        return Messages.access$28600();
    }

    public static Messages$RoomCommand$Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Messages$RoomCommand$Builder newBuilder(Messages$RoomCommand messages$RoomCommand) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(messages$RoomCommand);
    }

    public static Messages$RoomCommand parseDelimitedFrom(InputStream inputStream) {
        return (Messages$RoomCommand)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static Messages$RoomCommand parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Messages$RoomCommand)GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static Messages$RoomCommand parseFrom(ByteString byteString) {
        return (Messages$RoomCommand)PARSER.parseFrom(byteString);
    }

    public static Messages$RoomCommand parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (Messages$RoomCommand)PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static Messages$RoomCommand parseFrom(CodedInputStream codedInputStream) {
        return (Messages$RoomCommand)GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static Messages$RoomCommand parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Messages$RoomCommand)GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static Messages$RoomCommand parseFrom(InputStream inputStream) {
        return (Messages$RoomCommand)GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static Messages$RoomCommand parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (Messages$RoomCommand)GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static Messages$RoomCommand parseFrom(ByteBuffer byteBuffer) {
        return (Messages$RoomCommand)PARSER.parseFrom(byteBuffer);
    }

    public static Messages$RoomCommand parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (Messages$RoomCommand)PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static Messages$RoomCommand parseFrom(byte[] byArray) {
        return (Messages$RoomCommand)PARSER.parseFrom(byArray);
    }

    public static Messages$RoomCommand parseFrom(byte[] byArray, ExtensionRegistryLite extensionRegistryLite) {
        return (Messages$RoomCommand)PARSER.parseFrom(byArray, extensionRegistryLite);
    }

    public static Parser parser() {
        return PARSER;
    }

    public boolean equals(Object object) {
        boolean bl2;
        Object object2;
        Object object3;
        boolean bl3;
        boolean bl4 = true;
        if (object == this) {
            return bl4;
        }
        boolean bl5 = object instanceof Messages$RoomCommand;
        if (!bl5) {
            return super.equals(object);
        }
        object = (Messages$RoomCommand)object;
        bl5 = this.hasRoomId();
        if (bl5 == (bl3 = ((Messages$RoomCommand)object).hasRoomId())) {
            bl5 = bl4;
        } else {
            bl5 = false;
            object3 = null;
        }
        bl3 = this.hasRoomId();
        if (bl3) {
            if (bl5 && (bl5 = ((String)(object3 = this.getRoomId())).equals(object2 = ((Messages$RoomCommand)object).getRoomId()))) {
                bl5 = bl4;
            } else {
                bl5 = false;
                object3 = null;
            }
        }
        if (bl5 && (bl5 = this.hasS()) == (bl3 = ((Messages$RoomCommand)object).hasS())) {
            bl5 = bl4;
        } else {
            bl5 = false;
            object3 = null;
        }
        bl3 = this.hasS();
        if (bl3) {
            if (bl5 && (bl5 = ((String)(object3 = this.getS())).equals(object2 = ((Messages$RoomCommand)object).getS()))) {
                bl5 = bl4;
            } else {
                bl5 = false;
                object3 = null;
            }
        }
        if (bl5 && (bl5 = this.hasT()) == (bl3 = ((Messages$RoomCommand)object).hasT())) {
            bl5 = bl4;
        } else {
            bl5 = false;
            object3 = null;
        }
        bl3 = this.hasT();
        if (bl3) {
            long l10;
            long l11;
            long l12;
            if (bl5 && !(bl5 = (l12 = (l11 = this.getT()) - (l10 = ((Messages$RoomCommand)object).getT())) == 0L ? 0 : (l12 < 0L ? -1 : 1))) {
                bl5 = bl4;
            } else {
                bl5 = false;
                object3 = null;
            }
        }
        if (bl5 && (bl5 = this.hasN()) == (bl3 = ((Messages$RoomCommand)object).hasN())) {
            bl5 = bl4;
        } else {
            bl5 = false;
            object3 = null;
        }
        bl3 = this.hasN();
        if (bl3) {
            if (bl5 && (bl5 = ((String)(object3 = this.getN())).equals(object2 = ((Messages$RoomCommand)object).getN()))) {
                bl5 = bl4;
            } else {
                bl5 = false;
                object3 = null;
            }
        }
        if (bl5 && (bl5 = this.hasTransient()) == (bl3 = ((Messages$RoomCommand)object).hasTransient())) {
            bl5 = bl4;
        } else {
            bl5 = false;
            object3 = null;
        }
        bl3 = this.hasTransient();
        if (bl3) {
            if (bl5 && (bl5 = this.getTransient()) == (bl3 = ((Messages$RoomCommand)object).getTransient())) {
                bl5 = bl4;
            } else {
                bl5 = false;
                object3 = null;
            }
        }
        if (bl5 && (bl5 = (object3 = this.getRoomPeerIdsList()).equals(object2 = ((Messages$RoomCommand)object).getRoomPeerIdsList()))) {
            bl5 = bl4;
        } else {
            bl5 = false;
            object3 = null;
        }
        if (bl5 && (bl5 = this.hasByPeerId()) == (bl3 = ((Messages$RoomCommand)object).hasByPeerId())) {
            bl5 = bl4;
        } else {
            bl5 = false;
            object3 = null;
        }
        bl3 = this.hasByPeerId();
        if (bl3) {
            if (bl5 && (bl5 = ((String)(object3 = this.getByPeerId())).equals(object2 = ((Messages$RoomCommand)object).getByPeerId()))) {
                bl5 = bl4;
            } else {
                bl5 = false;
                object3 = null;
            }
        }
        if (!bl5 || !(bl2 = ((UnknownFieldSet)(object3 = this.unknownFields)).equals(object = ((GeneratedMessageV3)object).unknownFields))) {
            bl4 = false;
        }
        return bl4;
    }

    public String getByPeerId() {
        Object object = this.byPeerId_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            return (String)object;
        }
        object = (ByteString)object;
        String string2 = ((ByteString)object).toStringUtf8();
        boolean bl3 = ((ByteString)object).isValidUtf8();
        if (bl3) {
            this.byPeerId_ = string2;
        }
        return string2;
    }

    public ByteString getByPeerIdBytes() {
        Object object = this.byPeerId_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            this.byPeerId_ = object = ByteString.copyFromUtf8((String)object);
            return object;
        }
        return (ByteString)object;
    }

    public Messages$RoomCommand getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    public String getN() {
        Object object = this.n_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            return (String)object;
        }
        object = (ByteString)object;
        String string2 = ((ByteString)object).toStringUtf8();
        boolean bl3 = ((ByteString)object).isValidUtf8();
        if (bl3) {
            this.n_ = string2;
        }
        return string2;
    }

    public ByteString getNBytes() {
        Object object = this.n_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            this.n_ = object = ByteString.copyFromUtf8((String)object);
            return object;
        }
        return (ByteString)object;
    }

    public Parser getParserForType() {
        return PARSER;
    }

    public String getRoomId() {
        Object object = this.roomId_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            return (String)object;
        }
        object = (ByteString)object;
        String string2 = ((ByteString)object).toStringUtf8();
        boolean bl3 = ((ByteString)object).isValidUtf8();
        if (bl3) {
            this.roomId_ = string2;
        }
        return string2;
    }

    public ByteString getRoomIdBytes() {
        Object object = this.roomId_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            this.roomId_ = object = ByteString.copyFromUtf8((String)object);
            return object;
        }
        return (ByteString)object;
    }

    public String getRoomPeerIds(int n10) {
        return (String)this.roomPeerIds_.get(n10);
    }

    public ByteString getRoomPeerIdsBytes(int n10) {
        return this.roomPeerIds_.getByteString(n10);
    }

    public int getRoomPeerIdsCount() {
        return this.roomPeerIds_.size();
    }

    public ProtocolStringList getRoomPeerIdsList() {
        return this.roomPeerIds_;
    }

    public String getS() {
        Object object = this.s_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            return (String)object;
        }
        object = (ByteString)object;
        String string2 = ((ByteString)object).toStringUtf8();
        boolean bl3 = ((ByteString)object).isValidUtf8();
        if (bl3) {
            this.s_ = string2;
        }
        return string2;
    }

    public ByteString getSBytes() {
        Object object = this.s_;
        boolean bl2 = object instanceof String;
        if (bl2) {
            this.s_ = object = ByteString.copyFromUtf8((String)object);
            return object;
        }
        return (ByteString)object;
    }

    public int getSerializedSize() {
        Object object;
        Object object2;
        Object object3;
        int n10 = this.memoizedSize;
        int n11 = -1;
        if (n10 != n11) {
            return n10;
        }
        n10 = this.bitField0_;
        n11 = 1;
        int n12 = 0;
        Object object4 = null;
        if ((n10 &= n11) == n11) {
            object3 = this.roomId_;
            n10 = GeneratedMessageV3.computeStringSize(n11, object3) + 0;
        } else {
            n10 = 0;
            object3 = null;
        }
        int n13 = this.bitField0_;
        int n14 = 2;
        if ((n13 &= n14) == n14) {
            object2 = this.s_;
            n13 = GeneratedMessageV3.computeStringSize(n14, object2);
            n10 += n13;
        }
        n13 = this.bitField0_;
        n14 = 4;
        if ((n13 &= n14) == n14) {
            long l10 = this.t_;
            n13 = CodedOutputStream.computeInt64Size(3, l10);
            n10 += n13;
        }
        n13 = this.bitField0_;
        int n15 = 8;
        if ((n13 &= n15) == n15) {
            object2 = this.n_;
            n13 = GeneratedMessageV3.computeStringSize(n14, object2);
            n10 += n13;
        }
        n13 = this.bitField0_;
        n14 = 16;
        if ((n13 &= n14) == n14) {
            n14 = (int)(this.transient_ ? 1 : 0);
            n13 = CodedOutputStream.computeBoolSize(5, n14 != 0);
            n10 += n13;
        }
        n13 = 0;
        object2 = null;
        while (n12 < (n14 = (object = this.roomPeerIds_).size())) {
            object = this.roomPeerIds_.getRaw(n12);
            n14 = GeneratedMessageV3.computeStringSizeNoTag(object);
            n13 += n14;
            ++n12;
        }
        n10 += n13;
        object4 = this.getRoomPeerIdsList();
        n12 = object4.size() * n11;
        n10 += n12;
        n11 = this.bitField0_;
        n12 = 32;
        if ((n11 &= n12) == n12) {
            object4 = this.byPeerId_;
            n11 = GeneratedMessageV3.computeStringSize(7, object4);
            n10 += n11;
        }
        n11 = this.unknownFields.getSerializedSize();
        this.memoizedSize = n10 += n11;
        return n10;
    }

    public long getT() {
        return this.t_;
    }

    public boolean getTransient() {
        return this.transient_;
    }

    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    /*
     * WARNING - void declaration
     */
    public boolean hasByPeerId() {
        void var1_5;
        int bl2 = this.bitField0_;
        int n10 = 32;
        int n11 = bl2 & n10;
        if (n11 == n10) {
            boolean bl3 = true;
        } else {
            boolean bl4 = false;
        }
        return (boolean)var1_5;
    }

    /*
     * WARNING - void declaration
     */
    public boolean hasN() {
        void var1_5;
        int bl2 = this.bitField0_;
        int n10 = 8;
        int n11 = bl2 & n10;
        if (n11 == n10) {
            boolean bl3 = true;
        } else {
            boolean bl4 = false;
        }
        return (boolean)var1_5;
    }

    public boolean hasRoomId() {
        int bl2 = this.bitField0_;
        int n10 = 1;
        int n11 = bl2 & n10;
        if (n11 != n10) {
            n10 = 0;
        }
        return n10 != 0;
    }

    /*
     * WARNING - void declaration
     */
    public boolean hasS() {
        void var1_5;
        int bl2 = this.bitField0_;
        int n10 = 2;
        int n11 = bl2 & n10;
        if (n11 == n10) {
            boolean bl3 = true;
        } else {
            boolean bl4 = false;
        }
        return (boolean)var1_5;
    }

    /*
     * WARNING - void declaration
     */
    public boolean hasT() {
        void var1_5;
        int bl2 = this.bitField0_;
        int n10 = 4;
        int n11 = bl2 & n10;
        if (n11 == n10) {
            boolean bl3 = true;
        } else {
            boolean bl4 = false;
        }
        return (boolean)var1_5;
    }

    /*
     * WARNING - void declaration
     */
    public boolean hasTransient() {
        void var1_5;
        int bl2 = this.bitField0_;
        int n10 = 16;
        int n11 = bl2 & n10;
        if (n11 == n10) {
            boolean bl3 = true;
        } else {
            boolean bl4 = false;
        }
        return (boolean)var1_5;
    }

    public int hashCode() {
        int n10 = this.memoizedHashCode;
        if (n10 != 0) {
            return n10;
        }
        Object object = Messages$RoomCommand.getDescriptor();
        int n11 = object.hashCode();
        n10 = 779 + n11;
        n11 = (int)(this.hasRoomId() ? 1 : 0);
        if (n11 != 0) {
            n10 = (n10 * 37 + 1) * 53;
            object = this.getRoomId();
            n11 = ((String)object).hashCode();
            n10 += n11;
        }
        if ((n11 = (int)(this.hasS() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 2) * 53;
            object = this.getS();
            n11 = ((String)object).hashCode();
            n10 += n11;
        }
        if ((n11 = (int)(this.hasT() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 3) * 53;
            long l10 = this.getT();
            n11 = Internal.hashLong(l10);
            n10 += n11;
        }
        if ((n11 = (int)(this.hasN() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 4) * 53;
            object = this.getN();
            n11 = ((String)object).hashCode();
            n10 += n11;
        }
        if ((n11 = (int)(this.hasTransient() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 5) * 53;
            n11 = Internal.hashBoolean(this.getTransient());
            n10 += n11;
        }
        if ((n11 = this.getRoomPeerIdsCount()) > 0) {
            n10 = (n10 * 37 + 6) * 53;
            object = this.getRoomPeerIdsList();
            n11 = object.hashCode();
            n10 += n11;
        }
        if ((n11 = (int)(this.hasByPeerId() ? 1 : 0)) != 0) {
            n10 = (n10 * 37 + 7) * 53;
            object = this.getByPeerId();
            n11 = ((String)object).hashCode();
            n10 += n11;
        }
        n10 *= 29;
        n11 = this.unknownFields.hashCode();
        this.memoizedHashCode = n10 += n11;
        return n10;
    }

    public GeneratedMessageV3$FieldAccessorTable internalGetFieldAccessorTable() {
        return Messages.access$28700().ensureFieldAccessorsInitialized(Messages$RoomCommand.class, Messages$RoomCommand$Builder.class);
    }

    public final boolean isInitialized() {
        byte by2 = this.memoizedIsInitialized;
        byte by3 = 1;
        if (by2 == by3) {
            return by3 != 0;
        }
        if (!by2) {
            return false;
        }
        this.memoizedIsInitialized = by3;
        return by3 != 0;
    }

    public Messages$RoomCommand$Builder newBuilderForType() {
        return Messages$RoomCommand.newBuilder();
    }

    public Messages$RoomCommand$Builder newBuilderForType(GeneratedMessageV3$BuilderParent generatedMessageV3$BuilderParent) {
        Messages$RoomCommand$Builder messages$RoomCommand$Builder = new Messages$RoomCommand$Builder(generatedMessageV3$BuilderParent, null);
        return messages$RoomCommand$Builder;
    }

    public Messages$RoomCommand$Builder toBuilder() {
        Messages$RoomCommandOrBuilder messages$RoomCommandOrBuilder = DEFAULT_INSTANCE;
        if (this == messages$RoomCommandOrBuilder) {
            messages$RoomCommandOrBuilder = new Messages$RoomCommand$Builder(null);
        } else {
            messages$RoomCommandOrBuilder = new Messages$RoomCommand$Builder(null);
            messages$RoomCommandOrBuilder = ((Messages$RoomCommand$Builder)messages$RoomCommandOrBuilder).mergeFrom(this);
        }
        return messages$RoomCommandOrBuilder;
    }

    public void writeTo(CodedOutputStream codedOutputStream) {
        Object object;
        Object object2;
        int n10 = this.bitField0_;
        int n11 = 1;
        if ((n10 &= n11) == n11) {
            object2 = this.roomId_;
            GeneratedMessageV3.writeString(codedOutputStream, n11, object2);
        }
        n10 = this.bitField0_;
        n11 = 2;
        if ((n10 &= n11) == n11) {
            object2 = this.s_;
            GeneratedMessageV3.writeString(codedOutputStream, n11, object2);
        }
        n10 = this.bitField0_;
        n11 = 4;
        if ((n10 &= n11) == n11) {
            n10 = 3;
            long l10 = this.t_;
            codedOutputStream.writeInt64(n10, l10);
        }
        n10 = this.bitField0_;
        int n12 = 8;
        if ((n10 &= n12) == n12) {
            object2 = this.n_;
            GeneratedMessageV3.writeString(codedOutputStream, n11, object2);
        }
        n10 = this.bitField0_;
        n11 = 16;
        if ((n10 &= n11) == n11) {
            n10 = 5;
            n11 = (int)(this.transient_ ? 1 : 0);
            codedOutputStream.writeBool(n10, n11 != 0);
        }
        object2 = null;
        for (n10 = 0; n10 < (n11 = (object = this.roomPeerIds_).size()); ++n10) {
            n11 = 6;
            Object object3 = this.roomPeerIds_.getRaw(n10);
            GeneratedMessageV3.writeString(codedOutputStream, n11, object3);
        }
        n10 = this.bitField0_;
        n11 = 32;
        if ((n10 &= n11) == n11) {
            n10 = 7;
            object = this.byPeerId_;
            GeneratedMessageV3.writeString(codedOutputStream, n10, object);
        }
        this.unknownFields.writeTo(codedOutputStream);
    }
}

