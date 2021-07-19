/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.Format$1;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.video.ColorInfo;
import java.util.List;

public final class Format$Builder {
    private int accessibilityChannel;
    private int averageBitrate;
    private int channelCount;
    private String codecs;
    private ColorInfo colorInfo;
    private String containerMimeType;
    private DrmInitData drmInitData;
    private int encoderDelay;
    private int encoderPadding;
    private Class exoMediaCryptoType;
    private float frameRate;
    private int height;
    private String id;
    private List initializationData;
    private String label;
    private String language;
    private int maxInputSize;
    private Metadata metadata;
    private int pcmEncoding;
    private int peakBitrate;
    private float pixelWidthHeightRatio;
    private byte[] projectionData;
    private int roleFlags;
    private int rotationDegrees;
    private String sampleMimeType;
    private int sampleRate;
    private int selectionFlags;
    private int stereoMode;
    private long subsampleOffsetUs;
    private int width;

    public Format$Builder() {
        int n10;
        this.averageBitrate = n10 = -1;
        this.peakBitrate = n10;
        this.maxInputSize = n10;
        this.subsampleOffsetUs = Long.MAX_VALUE;
        this.width = n10;
        this.height = n10;
        this.frameRate = -1.0f;
        this.pixelWidthHeightRatio = 1.0f;
        this.stereoMode = n10;
        this.channelCount = n10;
        this.sampleRate = n10;
        this.pcmEncoding = n10;
        this.accessibilityChannel = n10;
    }

    private Format$Builder(Format object) {
        float f10;
        long l10;
        int n10;
        Object object2 = ((Format)object).id;
        this.id = object2;
        object2 = ((Format)object).label;
        this.label = object2;
        object2 = ((Format)object).language;
        this.language = object2;
        this.selectionFlags = n10 = ((Format)object).selectionFlags;
        this.roleFlags = n10 = ((Format)object).roleFlags;
        this.averageBitrate = n10 = ((Format)object).averageBitrate;
        this.peakBitrate = n10 = ((Format)object).peakBitrate;
        object2 = ((Format)object).codecs;
        this.codecs = object2;
        this.metadata = object2 = ((Format)object).metadata;
        this.containerMimeType = object2 = ((Format)object).containerMimeType;
        this.sampleMimeType = object2 = ((Format)object).sampleMimeType;
        this.maxInputSize = n10 = ((Format)object).maxInputSize;
        this.initializationData = object2 = ((Format)object).initializationData;
        this.drmInitData = object2 = ((Format)object).drmInitData;
        this.subsampleOffsetUs = l10 = ((Format)object).subsampleOffsetUs;
        this.width = n10 = ((Format)object).width;
        this.height = n10 = ((Format)object).height;
        this.frameRate = f10 = ((Format)object).frameRate;
        this.rotationDegrees = n10 = ((Format)object).rotationDegrees;
        this.pixelWidthHeightRatio = f10 = ((Format)object).pixelWidthHeightRatio;
        object2 = ((Format)object).projectionData;
        this.projectionData = (byte[])object2;
        this.stereoMode = n10 = ((Format)object).stereoMode;
        this.colorInfo = object2 = ((Format)object).colorInfo;
        this.channelCount = n10 = ((Format)object).channelCount;
        this.sampleRate = n10 = ((Format)object).sampleRate;
        this.pcmEncoding = n10 = ((Format)object).pcmEncoding;
        this.encoderDelay = n10 = ((Format)object).encoderDelay;
        this.encoderPadding = n10 = ((Format)object).encoderPadding;
        this.accessibilityChannel = n10 = ((Format)object).accessibilityChannel;
        this.exoMediaCryptoType = object = ((Format)object).exoMediaCryptoType;
    }

    public /* synthetic */ Format$Builder(Format format, Format$1 format$1) {
        this(format);
    }

    public static /* synthetic */ String access$100(Format$Builder format$Builder) {
        return format$Builder.id;
    }

    public static /* synthetic */ String access$1000(Format$Builder format$Builder) {
        return format$Builder.containerMimeType;
    }

    public static /* synthetic */ String access$1100(Format$Builder format$Builder) {
        return format$Builder.sampleMimeType;
    }

    public static /* synthetic */ int access$1200(Format$Builder format$Builder) {
        return format$Builder.maxInputSize;
    }

    public static /* synthetic */ List access$1300(Format$Builder format$Builder) {
        return format$Builder.initializationData;
    }

    public static /* synthetic */ DrmInitData access$1400(Format$Builder format$Builder) {
        return format$Builder.drmInitData;
    }

    public static /* synthetic */ long access$1500(Format$Builder format$Builder) {
        return format$Builder.subsampleOffsetUs;
    }

    public static /* synthetic */ int access$1600(Format$Builder format$Builder) {
        return format$Builder.width;
    }

    public static /* synthetic */ int access$1700(Format$Builder format$Builder) {
        return format$Builder.height;
    }

    public static /* synthetic */ float access$1800(Format$Builder format$Builder) {
        return format$Builder.frameRate;
    }

    public static /* synthetic */ int access$1900(Format$Builder format$Builder) {
        return format$Builder.rotationDegrees;
    }

    public static /* synthetic */ String access$200(Format$Builder format$Builder) {
        return format$Builder.label;
    }

    public static /* synthetic */ float access$2000(Format$Builder format$Builder) {
        return format$Builder.pixelWidthHeightRatio;
    }

    public static /* synthetic */ byte[] access$2100(Format$Builder format$Builder) {
        return format$Builder.projectionData;
    }

    public static /* synthetic */ int access$2200(Format$Builder format$Builder) {
        return format$Builder.stereoMode;
    }

    public static /* synthetic */ ColorInfo access$2300(Format$Builder format$Builder) {
        return format$Builder.colorInfo;
    }

    public static /* synthetic */ int access$2400(Format$Builder format$Builder) {
        return format$Builder.channelCount;
    }

    public static /* synthetic */ int access$2500(Format$Builder format$Builder) {
        return format$Builder.sampleRate;
    }

    public static /* synthetic */ int access$2600(Format$Builder format$Builder) {
        return format$Builder.pcmEncoding;
    }

    public static /* synthetic */ int access$2700(Format$Builder format$Builder) {
        return format$Builder.encoderDelay;
    }

    public static /* synthetic */ int access$2800(Format$Builder format$Builder) {
        return format$Builder.encoderPadding;
    }

    public static /* synthetic */ int access$2900(Format$Builder format$Builder) {
        return format$Builder.accessibilityChannel;
    }

    public static /* synthetic */ String access$300(Format$Builder format$Builder) {
        return format$Builder.language;
    }

    public static /* synthetic */ Class access$3000(Format$Builder format$Builder) {
        return format$Builder.exoMediaCryptoType;
    }

    public static /* synthetic */ int access$400(Format$Builder format$Builder) {
        return format$Builder.selectionFlags;
    }

    public static /* synthetic */ int access$500(Format$Builder format$Builder) {
        return format$Builder.roleFlags;
    }

    public static /* synthetic */ int access$600(Format$Builder format$Builder) {
        return format$Builder.averageBitrate;
    }

    public static /* synthetic */ int access$700(Format$Builder format$Builder) {
        return format$Builder.peakBitrate;
    }

    public static /* synthetic */ String access$800(Format$Builder format$Builder) {
        return format$Builder.codecs;
    }

    public static /* synthetic */ Metadata access$900(Format$Builder format$Builder) {
        return format$Builder.metadata;
    }

    public Format build() {
        Format format = new Format(this, null);
        return format;
    }

    public Format$Builder setAccessibilityChannel(int n10) {
        this.accessibilityChannel = n10;
        return this;
    }

    public Format$Builder setAverageBitrate(int n10) {
        this.averageBitrate = n10;
        return this;
    }

    public Format$Builder setChannelCount(int n10) {
        this.channelCount = n10;
        return this;
    }

    public Format$Builder setCodecs(String string2) {
        this.codecs = string2;
        return this;
    }

    public Format$Builder setColorInfo(ColorInfo colorInfo) {
        this.colorInfo = colorInfo;
        return this;
    }

    public Format$Builder setContainerMimeType(String string2) {
        this.containerMimeType = string2;
        return this;
    }

    public Format$Builder setDrmInitData(DrmInitData drmInitData) {
        this.drmInitData = drmInitData;
        return this;
    }

    public Format$Builder setEncoderDelay(int n10) {
        this.encoderDelay = n10;
        return this;
    }

    public Format$Builder setEncoderPadding(int n10) {
        this.encoderPadding = n10;
        return this;
    }

    public Format$Builder setExoMediaCryptoType(Class clazz) {
        this.exoMediaCryptoType = clazz;
        return this;
    }

    public Format$Builder setFrameRate(float f10) {
        this.frameRate = f10;
        return this;
    }

    public Format$Builder setHeight(int n10) {
        this.height = n10;
        return this;
    }

    public Format$Builder setId(int n10) {
        String string2;
        this.id = string2 = Integer.toString(n10);
        return this;
    }

    public Format$Builder setId(String string2) {
        this.id = string2;
        return this;
    }

    public Format$Builder setInitializationData(List list) {
        this.initializationData = list;
        return this;
    }

    public Format$Builder setLabel(String string2) {
        this.label = string2;
        return this;
    }

    public Format$Builder setLanguage(String string2) {
        this.language = string2;
        return this;
    }

    public Format$Builder setMaxInputSize(int n10) {
        this.maxInputSize = n10;
        return this;
    }

    public Format$Builder setMetadata(Metadata metadata) {
        this.metadata = metadata;
        return this;
    }

    public Format$Builder setPcmEncoding(int n10) {
        this.pcmEncoding = n10;
        return this;
    }

    public Format$Builder setPeakBitrate(int n10) {
        this.peakBitrate = n10;
        return this;
    }

    public Format$Builder setPixelWidthHeightRatio(float f10) {
        this.pixelWidthHeightRatio = f10;
        return this;
    }

    public Format$Builder setProjectionData(byte[] byArray) {
        this.projectionData = byArray;
        return this;
    }

    public Format$Builder setRoleFlags(int n10) {
        this.roleFlags = n10;
        return this;
    }

    public Format$Builder setRotationDegrees(int n10) {
        this.rotationDegrees = n10;
        return this;
    }

    public Format$Builder setSampleMimeType(String string2) {
        this.sampleMimeType = string2;
        return this;
    }

    public Format$Builder setSampleRate(int n10) {
        this.sampleRate = n10;
        return this;
    }

    public Format$Builder setSelectionFlags(int n10) {
        this.selectionFlags = n10;
        return this;
    }

    public Format$Builder setStereoMode(int n10) {
        this.stereoMode = n10;
        return this;
    }

    public Format$Builder setSubsampleOffsetUs(long l10) {
        this.subsampleOffsetUs = l10;
        return this;
    }

    public Format$Builder setWidth(int n10) {
        this.width = n10;
        return this;
    }
}

