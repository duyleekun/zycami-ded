/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 */
package com.google.android.exoplayer2;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.Format$1;
import com.google.android.exoplayer2.Format$Builder;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.UnsupportedMediaCrypto;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.video.ColorInfo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class Format
implements Parcelable {
    public static final Parcelable.Creator CREATOR;
    public static final int NO_VALUE = 255;
    public static final long OFFSET_SAMPLE_RELATIVE = Long.MAX_VALUE;
    public final int accessibilityChannel;
    public final int averageBitrate;
    public final int bitrate;
    public final int channelCount;
    public final String codecs;
    public final ColorInfo colorInfo;
    public final String containerMimeType;
    public final DrmInitData drmInitData;
    public final int encoderDelay;
    public final int encoderPadding;
    public final Class exoMediaCryptoType;
    public final float frameRate;
    private int hashCode;
    public final int height;
    public final String id;
    public final List initializationData;
    public final String label;
    public final String language;
    public final int maxInputSize;
    public final Metadata metadata;
    public final int pcmEncoding;
    public final int peakBitrate;
    public final float pixelWidthHeightRatio;
    public final byte[] projectionData;
    public final int roleFlags;
    public final int rotationDegrees;
    public final String sampleMimeType;
    public final int sampleRate;
    public final int selectionFlags;
    public final int stereoMode;
    public final long subsampleOffsetUs;
    public final int width;

    static {
        Format$1 format$1 = new Format$1();
        CREATOR = format$1;
    }

    public Format(Parcel parcel) {
        int n10;
        long l10;
        Object object;
        int n11;
        int n12;
        Object object2 = parcel.readString();
        this.id = object2;
        object2 = parcel.readString();
        this.label = object2;
        object2 = parcel.readString();
        this.language = object2;
        this.selectionFlags = n12 = parcel.readInt();
        this.roleFlags = n12 = parcel.readInt();
        this.averageBitrate = n12 = parcel.readInt();
        this.peakBitrate = n11 = parcel.readInt();
        int n13 = -1;
        if (n11 != n13) {
            n12 = n11;
        }
        this.bitrate = n12;
        object2 = parcel.readString();
        this.codecs = object2;
        object2 = Metadata.class.getClassLoader();
        this.metadata = object2 = (Metadata)parcel.readParcelable((ClassLoader)object2);
        this.containerMimeType = object2 = parcel.readString();
        this.sampleMimeType = object2 = parcel.readString();
        this.maxInputSize = n12 = parcel.readInt();
        n12 = parcel.readInt();
        Object object3 = new ArrayList(n12);
        this.initializationData = object3;
        float f10 = 0.0f;
        object3 = null;
        for (n11 = 0; n11 < n12; ++n11) {
            object = this.initializationData;
            byte[] byArray = (byte[])Assertions.checkNotNull(parcel.createByteArray());
            object.add(byArray);
        }
        object2 = DrmInitData.class.getClassLoader();
        this.drmInitData = object2 = (DrmInitData)parcel.readParcelable((ClassLoader)object2);
        this.subsampleOffsetUs = l10 = parcel.readLong();
        this.width = n11 = parcel.readInt();
        this.height = n11 = parcel.readInt();
        this.frameRate = f10 = parcel.readFloat();
        this.rotationDegrees = n11 = parcel.readInt();
        this.pixelWidthHeightRatio = f10 = parcel.readFloat();
        n11 = (int)(Util.readBoolean(parcel) ? 1 : 0);
        n13 = 0;
        object = null;
        if (n11 != 0) {
            object3 = parcel.createByteArray();
        } else {
            n11 = 0;
            object3 = null;
            f10 = 0.0f;
        }
        this.projectionData = (byte[])object3;
        this.stereoMode = n11 = parcel.readInt();
        object3 = ColorInfo.class.getClassLoader();
        this.colorInfo = object3 = (ColorInfo)parcel.readParcelable((ClassLoader)object3);
        this.channelCount = n11 = parcel.readInt();
        this.sampleRate = n11 = parcel.readInt();
        this.pcmEncoding = n11 = parcel.readInt();
        this.encoderDelay = n11 = parcel.readInt();
        this.encoderPadding = n11 = parcel.readInt();
        this.accessibilityChannel = n10 = parcel.readInt();
        if (object2 != null) {
            object = UnsupportedMediaCrypto.class;
        }
        this.exoMediaCryptoType = object;
    }

    private Format(Format$Builder clazz) {
        Object object;
        float f10;
        long l10;
        int n10;
        int n11;
        Object object2 = Format$Builder.access$100((Format$Builder)((Object)clazz));
        this.id = object2;
        object2 = Format$Builder.access$200((Format$Builder)((Object)clazz));
        this.label = object2;
        object2 = Util.normalizeLanguageCode(Format$Builder.access$300((Format$Builder)((Object)clazz)));
        this.language = object2;
        this.selectionFlags = n11 = Format$Builder.access$400((Format$Builder)((Object)clazz));
        this.roleFlags = n11 = Format$Builder.access$500((Format$Builder)((Object)clazz));
        this.averageBitrate = n11 = Format$Builder.access$600((Format$Builder)((Object)clazz));
        this.peakBitrate = n10 = Format$Builder.access$700((Format$Builder)((Object)clazz));
        int n12 = -1;
        if (n10 != n12) {
            n11 = n10;
        }
        this.bitrate = n11;
        object2 = Format$Builder.access$800((Format$Builder)((Object)clazz));
        this.codecs = object2;
        this.metadata = object2 = Format$Builder.access$900((Format$Builder)((Object)clazz));
        this.containerMimeType = object2 = Format$Builder.access$1000((Format$Builder)((Object)clazz));
        this.sampleMimeType = object2 = Format$Builder.access$1100((Format$Builder)((Object)clazz));
        this.maxInputSize = n11 = Format$Builder.access$1200((Format$Builder)((Object)clazz));
        object2 = Format$Builder.access$1300((Format$Builder)((Object)clazz));
        object2 = object2 == null ? Collections.emptyList() : Format$Builder.access$1300((Format$Builder)((Object)clazz));
        this.initializationData = object2;
        this.drmInitData = object2 = Format$Builder.access$1400((Format$Builder)((Object)clazz));
        this.subsampleOffsetUs = l10 = Format$Builder.access$1500((Format$Builder)((Object)clazz));
        this.width = n10 = Format$Builder.access$1600((Format$Builder)((Object)clazz));
        this.height = n10 = Format$Builder.access$1700((Format$Builder)((Object)clazz));
        this.frameRate = f10 = Format$Builder.access$1800((Format$Builder)((Object)clazz));
        n10 = Format$Builder.access$1900((Format$Builder)((Object)clazz));
        int n13 = 0;
        if (n10 == n12) {
            n10 = 0;
            object = null;
            f10 = 0.0f;
        } else {
            n10 = Format$Builder.access$1900((Format$Builder)((Object)clazz));
        }
        this.rotationDegrees = n10;
        f10 = Format$Builder.access$2000((Format$Builder)((Object)clazz));
        float f11 = -1.0f;
        n10 = (int)(f10 == f11 ? 0 : (f10 > f11 ? 1 : -1));
        if (n10 == 0) {
            n10 = 1065353216;
            f10 = 1.0f;
        } else {
            f10 = Format$Builder.access$2000((Format$Builder)((Object)clazz));
        }
        this.pixelWidthHeightRatio = f10;
        object = Format$Builder.access$2100((Format$Builder)((Object)clazz));
        this.projectionData = object;
        this.stereoMode = n10 = Format$Builder.access$2200((Format$Builder)((Object)clazz));
        object = Format$Builder.access$2300((Format$Builder)((Object)clazz));
        this.colorInfo = object;
        this.channelCount = n10 = Format$Builder.access$2400((Format$Builder)((Object)clazz));
        this.sampleRate = n10 = Format$Builder.access$2500((Format$Builder)((Object)clazz));
        this.pcmEncoding = n10 = Format$Builder.access$2600((Format$Builder)((Object)clazz));
        n10 = Format$Builder.access$2700((Format$Builder)((Object)clazz));
        if (n10 == n12) {
            n10 = 0;
            object = null;
            f10 = 0.0f;
        } else {
            n10 = Format$Builder.access$2700((Format$Builder)((Object)clazz));
        }
        this.encoderDelay = n10;
        n10 = Format$Builder.access$2800((Format$Builder)((Object)clazz));
        if (n10 != n12) {
            n13 = Format$Builder.access$2800((Format$Builder)((Object)clazz));
        }
        this.encoderPadding = n13;
        this.accessibilityChannel = n10 = Format$Builder.access$2900((Format$Builder)((Object)clazz));
        object = Format$Builder.access$3000((Format$Builder)((Object)clazz));
        this.exoMediaCryptoType = object == null && object2 != null ? (clazz = UnsupportedMediaCrypto.class) : (clazz = Format$Builder.access$3000((Format$Builder)((Object)clazz)));
    }

    public /* synthetic */ Format(Format$Builder format$Builder, Format$1 format$1) {
        this(format$Builder);
    }

    public static Format createAudioContainerFormat(String string2, String string3, String string4, String string5, String string6, Metadata metadata, int n10, int n11, int n12, List list, int n13, int n14, String string7) {
        Format$Builder format$Builder = new Format$Builder();
        return format$Builder.setId(string2).setLabel(string3).setLanguage(string7).setSelectionFlags(n13).setRoleFlags(n14).setAverageBitrate(n10).setPeakBitrate(n10).setCodecs(string6).setMetadata(metadata).setContainerMimeType(string4).setSampleMimeType(string5).setInitializationData(list).setChannelCount(n11).setSampleRate(n12).build();
    }

    public static Format createAudioSampleFormat(String string2, String string3, String string4, int n10, int n11, int n12, int n13, int n14, int n15, int n16, List list, DrmInitData drmInitData, int n17, String string5, Metadata metadata) {
        Format$Builder format$Builder = new Format$Builder();
        return format$Builder.setId(string2).setLanguage(string5).setSelectionFlags(n17).setAverageBitrate(n10).setPeakBitrate(n10).setCodecs(string4).setMetadata(metadata).setSampleMimeType(string3).setMaxInputSize(n11).setInitializationData(list).setDrmInitData(drmInitData).setChannelCount(n12).setSampleRate(n13).setPcmEncoding(n14).setEncoderDelay(n15).setEncoderPadding(n16).build();
    }

    public static Format createAudioSampleFormat(String string2, String string3, String string4, int n10, int n11, int n12, int n13, int n14, List list, DrmInitData drmInitData, int n15, String string5) {
        Format$Builder format$Builder = new Format$Builder();
        return format$Builder.setId(string2).setLanguage(string5).setSelectionFlags(n15).setAverageBitrate(n10).setPeakBitrate(n10).setCodecs(string4).setSampleMimeType(string3).setMaxInputSize(n11).setInitializationData(list).setDrmInitData(drmInitData).setChannelCount(n12).setSampleRate(n13).setPcmEncoding(n14).build();
    }

    public static Format createAudioSampleFormat(String string2, String string3, String string4, int n10, int n11, int n12, int n13, List list, DrmInitData drmInitData, int n14, String string5) {
        Format$Builder format$Builder = new Format$Builder();
        return format$Builder.setId(string2).setLanguage(string5).setSelectionFlags(n14).setAverageBitrate(n10).setPeakBitrate(n10).setCodecs(string4).setSampleMimeType(string3).setMaxInputSize(n11).setInitializationData(list).setDrmInitData(drmInitData).setChannelCount(n12).setSampleRate(n13).build();
    }

    public static Format createContainerFormat(String string2, String string3, String string4, String string5, String string6, int n10, int n11, int n12, String string7) {
        Format$Builder format$Builder = new Format$Builder();
        return format$Builder.setId(string2).setLabel(string3).setLanguage(string7).setSelectionFlags(n11).setRoleFlags(n12).setAverageBitrate(n10).setPeakBitrate(n10).setCodecs(string6).setContainerMimeType(string4).setSampleMimeType(string5).build();
    }

    public static Format createImageSampleFormat(String string2, String string3, int n10, List list, String string4) {
        Format$Builder format$Builder = new Format$Builder();
        return format$Builder.setId(string2).setLanguage(string4).setSelectionFlags(n10).setSampleMimeType(string3).setInitializationData(list).build();
    }

    public static Format createSampleFormat(String string2, String string3) {
        Format$Builder format$Builder = new Format$Builder();
        return format$Builder.setId(string2).setSampleMimeType(string3).build();
    }

    public static Format createTextContainerFormat(String string2, String string3, String string4, String string5, String string6, int n10, int n11, int n12, String string7) {
        Format$Builder format$Builder = new Format$Builder();
        return format$Builder.setId(string2).setLabel(string3).setLanguage(string7).setSelectionFlags(n11).setRoleFlags(n12).setAverageBitrate(n10).setPeakBitrate(n10).setCodecs(string6).setContainerMimeType(string4).setSampleMimeType(string5).build();
    }

    public static Format createTextContainerFormat(String string2, String string3, String string4, String string5, String string6, int n10, int n11, int n12, String string7, int n13) {
        Format$Builder format$Builder = new Format$Builder();
        return format$Builder.setId(string2).setLabel(string3).setLanguage(string7).setSelectionFlags(n11).setRoleFlags(n12).setAverageBitrate(n10).setPeakBitrate(n10).setCodecs(string6).setContainerMimeType(string4).setSampleMimeType(string5).setAccessibilityChannel(n13).build();
    }

    public static Format createTextSampleFormat(String string2, String string3, int n10, String string4) {
        Format$Builder format$Builder = new Format$Builder();
        return format$Builder.setId(string2).setLanguage(string4).setSelectionFlags(n10).setSampleMimeType(string3).build();
    }

    public static Format createTextSampleFormat(String string2, String string3, int n10, String string4, int n11, long l10, List list) {
        Format$Builder format$Builder = new Format$Builder();
        return format$Builder.setId(string2).setLanguage(string4).setSelectionFlags(n10).setSampleMimeType(string3).setInitializationData(list).setSubsampleOffsetUs(l10).setAccessibilityChannel(n11).build();
    }

    public static Format createVideoContainerFormat(String string2, String string3, String string4, String string5, String string6, Metadata metadata, int n10, int n11, int n12, float f10, List list, int n13, int n14) {
        Format$Builder format$Builder = new Format$Builder();
        return format$Builder.setId(string2).setLabel(string3).setSelectionFlags(n13).setRoleFlags(n14).setAverageBitrate(n10).setPeakBitrate(n10).setCodecs(string6).setMetadata(metadata).setContainerMimeType(string4).setSampleMimeType(string5).setInitializationData(list).setWidth(n11).setHeight(n12).setFrameRate(f10).build();
    }

    public static Format createVideoSampleFormat(String string2, String string3, String string4, int n10, int n11, int n12, int n13, float f10, List list, int n14, float f11, DrmInitData drmInitData) {
        Format$Builder format$Builder = new Format$Builder();
        return format$Builder.setId(string2).setAverageBitrate(n10).setPeakBitrate(n10).setCodecs(string4).setSampleMimeType(string3).setMaxInputSize(n11).setInitializationData(list).setDrmInitData(drmInitData).setWidth(n12).setHeight(n13).setFrameRate(f10).setRotationDegrees(n14).setPixelWidthHeightRatio(f11).build();
    }

    public static Format createVideoSampleFormat(String string2, String string3, String string4, int n10, int n11, int n12, int n13, float f10, List list, int n14, float f11, byte[] byArray, int n15, ColorInfo colorInfo, DrmInitData drmInitData) {
        Format$Builder format$Builder = new Format$Builder();
        return format$Builder.setId(string2).setAverageBitrate(n10).setPeakBitrate(n10).setCodecs(string4).setSampleMimeType(string3).setMaxInputSize(n11).setInitializationData(list).setDrmInitData(drmInitData).setWidth(n12).setHeight(n13).setFrameRate(f10).setRotationDegrees(n14).setPixelWidthHeightRatio(f11).setProjectionData(byArray).setStereoMode(n15).setColorInfo(colorInfo).build();
    }

    public static Format createVideoSampleFormat(String string2, String string3, String string4, int n10, int n11, int n12, int n13, float f10, List list, DrmInitData drmInitData) {
        Format$Builder format$Builder = new Format$Builder();
        return format$Builder.setId(string2).setAverageBitrate(n10).setPeakBitrate(n10).setCodecs(string4).setSampleMimeType(string3).setMaxInputSize(n11).setInitializationData(list).setDrmInitData(drmInitData).setWidth(n12).setHeight(n13).setFrameRate(f10).build();
    }

    public static String toLogString(Format object) {
        float f10;
        float f11;
        float f12;
        if (object == null) {
            return "null";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("id=");
        String string2 = ((Format)object).id;
        stringBuilder.append(string2);
        stringBuilder.append(", mimeType=");
        string2 = ((Format)object).sampleMimeType;
        stringBuilder.append(string2);
        int n10 = ((Format)object).bitrate;
        int n11 = -1;
        if (n10 != n11) {
            string2 = ", bitrate=";
            stringBuilder.append(string2);
            n10 = ((Format)object).bitrate;
            stringBuilder.append(n10);
        }
        if ((string2 = ((Format)object).codecs) != null) {
            stringBuilder.append(", codecs=");
            string2 = ((Format)object).codecs;
            stringBuilder.append(string2);
        }
        if ((n10 = ((Format)object).width) != n11 && (n10 = ((Format)object).height) != n11) {
            stringBuilder.append(", res=");
            n10 = ((Format)object).width;
            stringBuilder.append(n10);
            string2 = "x";
            stringBuilder.append(string2);
            n10 = ((Format)object).height;
            stringBuilder.append(n10);
        }
        if ((n10 = (int)((f12 = (f11 = ((Format)object).frameRate) - (f10 = -1.0f)) == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1))) != 0) {
            string2 = ", fps=";
            stringBuilder.append(string2);
            f11 = ((Format)object).frameRate;
            stringBuilder.append(f11);
        }
        if ((n10 = ((Format)object).channelCount) != n11) {
            string2 = ", channels=";
            stringBuilder.append(string2);
            n10 = ((Format)object).channelCount;
            stringBuilder.append(n10);
        }
        if ((n10 = ((Format)object).sampleRate) != n11) {
            string2 = ", sample_rate=";
            stringBuilder.append(string2);
            n10 = ((Format)object).sampleRate;
            stringBuilder.append(n10);
        }
        if ((string2 = ((Format)object).language) != null) {
            stringBuilder.append(", language=");
            string2 = ((Format)object).language;
            stringBuilder.append(string2);
        }
        if ((string2 = ((Format)object).label) != null) {
            string2 = ", label=";
            stringBuilder.append(string2);
            object = ((Format)object).label;
            stringBuilder.append((String)object);
        }
        return stringBuilder.toString();
    }

    public Format$Builder buildUpon() {
        Format$Builder format$Builder = new Format$Builder(this, null);
        return format$Builder;
    }

    public Format copyWithBitrate(int n10) {
        return this.buildUpon().setAverageBitrate(n10).setPeakBitrate(n10).build();
    }

    public Format copyWithDrmInitData(DrmInitData drmInitData) {
        return this.buildUpon().setDrmInitData(drmInitData).build();
    }

    public Format copyWithExoMediaCryptoType(Class clazz) {
        return this.buildUpon().setExoMediaCryptoType(clazz).build();
    }

    public Format copyWithFrameRate(float f10) {
        return this.buildUpon().setFrameRate(f10).build();
    }

    public Format copyWithGaplessInfo(int n10, int n11) {
        return this.buildUpon().setEncoderDelay(n10).setEncoderPadding(n11).build();
    }

    public Format copyWithLabel(String string2) {
        return this.buildUpon().setLabel(string2).build();
    }

    public Format copyWithManifestFormatInfo(Format format) {
        return this.withManifestFormatInfo(format);
    }

    public Format copyWithMaxInputSize(int n10) {
        return this.buildUpon().setMaxInputSize(n10).build();
    }

    public Format copyWithMetadata(Metadata metadata) {
        return this.buildUpon().setMetadata(metadata).build();
    }

    public Format copyWithSubsampleOffsetUs(long l10) {
        return this.buildUpon().setSubsampleOffsetUs(l10).build();
    }

    public Format copyWithVideoSize(int n10, int n11) {
        return this.buildUpon().setWidth(n10).setHeight(n11).build();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object object) {
        Object object2;
        Object object3;
        boolean bl2 = true;
        if (this == object) {
            return bl2;
        }
        if (object != null && (object3 = Format.class) == (object2 = object.getClass())) {
            boolean bl3;
            float f10;
            float f11;
            long l10;
            long l11;
            long l12;
            int n10;
            object = (Format)object;
            int n11 = this.hashCode;
            if (n11 != 0 && (n10 = ((Format)object).hashCode) != 0 && n11 != n10) {
                return false;
            }
            n11 = this.selectionFlags;
            n10 = ((Format)object).selectionFlags;
            if (n11 != n10 || (n11 = this.roleFlags) != (n10 = ((Format)object).roleFlags) || (n11 = this.averageBitrate) != (n10 = ((Format)object).averageBitrate) || (n11 = this.peakBitrate) != (n10 = ((Format)object).peakBitrate) || (n11 = this.maxInputSize) != (n10 = ((Format)object).maxInputSize) || (n11 = (int)((l12 = (l11 = this.subsampleOffsetUs) - (l10 = ((Format)object).subsampleOffsetUs)) == 0L ? 0 : (l12 < 0L ? -1 : 1))) != 0 || (n11 = this.width) != (n10 = ((Format)object).width) || (n11 = this.height) != (n10 = ((Format)object).height) || (n11 = this.rotationDegrees) != (n10 = ((Format)object).rotationDegrees) || (n11 = this.stereoMode) != (n10 = ((Format)object).stereoMode) || (n11 = this.channelCount) != (n10 = ((Format)object).channelCount) || (n11 = this.sampleRate) != (n10 = ((Format)object).sampleRate) || (n11 = this.pcmEncoding) != (n10 = ((Format)object).pcmEncoding) || (n11 = this.encoderDelay) != (n10 = ((Format)object).encoderDelay) || (n11 = this.encoderPadding) != (n10 = ((Format)object).encoderPadding) || (n11 = this.accessibilityChannel) != (n10 = ((Format)object).accessibilityChannel) || (n11 = Float.compare(f11 = this.frameRate, f10 = ((Format)object).frameRate)) != 0 || (n11 = Float.compare(f11 = this.pixelWidthHeightRatio, f10 = ((Format)object).pixelWidthHeightRatio)) != 0 || (n11 = (int)(Util.areEqual(object3 = this.exoMediaCryptoType, object2 = ((Format)object).exoMediaCryptoType) ? 1 : 0)) == 0 || (n11 = (int)(Util.areEqual(object3 = this.id, object2 = ((Format)object).id) ? 1 : 0)) == 0 || (n11 = (int)(Util.areEqual(object3 = this.label, object2 = ((Format)object).label) ? 1 : 0)) == 0 || (n11 = (int)(Util.areEqual(object3 = this.codecs, object2 = ((Format)object).codecs) ? 1 : 0)) == 0 || (n11 = (int)(Util.areEqual(object3 = this.containerMimeType, object2 = ((Format)object).containerMimeType) ? 1 : 0)) == 0 || (n11 = (int)(Util.areEqual(object3 = this.sampleMimeType, object2 = ((Format)object).sampleMimeType) ? 1 : 0)) == 0 || (n11 = (int)(Util.areEqual(object3 = this.language, object2 = ((Format)object).language) ? 1 : 0)) == 0 || (n11 = (int)(Arrays.equals((byte[])(object3 = (Object)this.projectionData), (byte[])(object2 = (Object)((Format)object).projectionData)) ? 1 : 0)) == 0 || (n11 = (int)(Util.areEqual(object3 = this.metadata, object2 = ((Format)object).metadata) ? 1 : 0)) == 0 || (n11 = (int)(Util.areEqual(object3 = this.colorInfo, object2 = ((Format)object).colorInfo) ? 1 : 0)) == 0 || (n11 = (int)(Util.areEqual(object3 = this.drmInitData, object2 = ((Format)object).drmInitData) ? 1 : 0)) == 0 || !(bl3 = this.initializationDataEquals((Format)object))) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public int getPixelCount() {
        int n10;
        int n11 = this.width;
        int n12 = -1;
        if (n11 != n12 && (n10 = this.height) != n12) {
            n12 = n11 * n10;
        }
        return n12;
    }

    public int hashCode() {
        int n10 = this.hashCode;
        if (n10 == 0) {
            float f10;
            int n11;
            n10 = 527;
            Object object = this.id;
            int n12 = 0;
            if (object == null) {
                n11 = 0;
                object = null;
                f10 = 0.0f;
            } else {
                n11 = ((String)object).hashCode();
            }
            n10 = (n10 + n11) * 31;
            object = this.label;
            if (object != null) {
                n11 = ((String)object).hashCode();
            } else {
                n11 = 0;
                object = null;
                f10 = 0.0f;
            }
            n10 = (n10 + n11) * 31;
            object = this.language;
            if (object == null) {
                n11 = 0;
                object = null;
                f10 = 0.0f;
            } else {
                n11 = ((String)object).hashCode();
            }
            n10 = (n10 + n11) * 31;
            n11 = this.selectionFlags;
            n10 = (n10 + n11) * 31;
            n11 = this.roleFlags;
            n10 = (n10 + n11) * 31;
            n11 = this.averageBitrate;
            n10 = (n10 + n11) * 31;
            n11 = this.peakBitrate;
            n10 = (n10 + n11) * 31;
            object = this.codecs;
            if (object == null) {
                n11 = 0;
                object = null;
                f10 = 0.0f;
            } else {
                n11 = ((String)object).hashCode();
            }
            n10 = (n10 + n11) * 31;
            object = this.metadata;
            if (object == null) {
                n11 = 0;
                object = null;
                f10 = 0.0f;
            } else {
                n11 = ((Metadata)object).hashCode();
            }
            n10 = (n10 + n11) * 31;
            object = this.containerMimeType;
            if (object == null) {
                n11 = 0;
                object = null;
                f10 = 0.0f;
            } else {
                n11 = ((String)object).hashCode();
            }
            n10 = (n10 + n11) * 31;
            object = this.sampleMimeType;
            if (object == null) {
                n11 = 0;
                object = null;
                f10 = 0.0f;
            } else {
                n11 = ((String)object).hashCode();
            }
            n10 = (n10 + n11) * 31;
            n11 = this.maxInputSize;
            n10 = (n10 + n11) * 31;
            long l10 = this.subsampleOffsetUs;
            n11 = (int)l10;
            n10 = (n10 + n11) * 31;
            n11 = this.width;
            n10 = (n10 + n11) * 31;
            n11 = this.height;
            n10 = (n10 + n11) * 31;
            n11 = Float.floatToIntBits(this.frameRate);
            n10 = (n10 + n11) * 31;
            n11 = this.rotationDegrees;
            n10 = (n10 + n11) * 31;
            f10 = this.pixelWidthHeightRatio;
            n11 = Float.floatToIntBits(f10);
            n10 = (n10 + n11) * 31;
            n11 = this.stereoMode;
            n10 = (n10 + n11) * 31;
            n11 = this.channelCount;
            n10 = (n10 + n11) * 31;
            n11 = this.sampleRate;
            n10 = (n10 + n11) * 31;
            n11 = this.pcmEncoding;
            n10 = (n10 + n11) * 31;
            n11 = this.encoderDelay;
            n10 = (n10 + n11) * 31;
            n11 = this.encoderPadding;
            n10 = (n10 + n11) * 31;
            n11 = this.accessibilityChannel;
            n10 = (n10 + n11) * 31;
            object = this.exoMediaCryptoType;
            if (object != null) {
                n12 = object.hashCode();
            }
            this.hashCode = n10 += n12;
        }
        return this.hashCode;
    }

    public boolean initializationDataEquals(Format format) {
        Object object;
        int n10;
        List list = this.initializationData;
        int n11 = list.size();
        if (n11 != (n10 = (object = format.initializationData).size())) {
            return false;
        }
        list = null;
        for (n11 = 0; n11 < (n10 = (object = this.initializationData).size()); ++n11) {
            byte[] byArray;
            object = (byte[])this.initializationData.get(n11);
            n10 = (int)(Arrays.equals((byte[])object, byArray = (byte[])format.initializationData.get(n11)) ? 1 : 0);
            if (n10 != 0) continue;
            return false;
        }
        return true;
    }

    public String toString() {
        String string2 = this.id;
        String string3 = this.label;
        String string4 = this.containerMimeType;
        String string5 = this.sampleMimeType;
        String string6 = this.codecs;
        int n10 = this.bitrate;
        String string7 = this.language;
        int n11 = this.width;
        int n12 = this.height;
        float f10 = this.frameRate;
        int n13 = this.channelCount;
        int n14 = this.sampleRate;
        int n15 = String.valueOf(string2).length() + 104;
        int n16 = String.valueOf(string3).length();
        n15 += n16;
        n16 = String.valueOf(string4).length();
        n15 += n16;
        n16 = String.valueOf(string5).length();
        n15 += n16;
        n16 = String.valueOf(string6).length();
        n15 += n16;
        n16 = String.valueOf(string7).length();
        StringBuilder stringBuilder = new StringBuilder(n15 += n16);
        stringBuilder.append("Format(");
        stringBuilder.append(string2);
        string2 = ", ";
        stringBuilder.append(string2);
        stringBuilder.append(string3);
        stringBuilder.append(string2);
        stringBuilder.append(string4);
        stringBuilder.append(string2);
        stringBuilder.append(string5);
        stringBuilder.append(string2);
        stringBuilder.append(string6);
        stringBuilder.append(string2);
        stringBuilder.append(n10);
        stringBuilder.append(string2);
        stringBuilder.append(string7);
        stringBuilder.append(", [");
        stringBuilder.append(n11);
        stringBuilder.append(string2);
        stringBuilder.append(n12);
        stringBuilder.append(string2);
        stringBuilder.append(f10);
        stringBuilder.append("], [");
        stringBuilder.append(n13);
        stringBuilder.append(string2);
        stringBuilder.append(n14);
        stringBuilder.append("])");
        return stringBuilder.toString();
    }

    public Format withManifestFormatInfo(Format object) {
        Metadata metadata;
        Object object2;
        String[] stringArray;
        int n10;
        Object object3;
        int n11;
        int n12;
        String string2;
        if (this == object) {
            return this;
        }
        String string3 = this.sampleMimeType;
        int n13 = MimeTypes.getTrackType(string3);
        String string4 = object.id;
        String string5 = object.label;
        if (string5 == null) {
            string5 = this.label;
        }
        String string6 = this.language;
        int n14 = 3;
        int n15 = 1;
        if ((n13 == n14 || n13 == n15) && (string2 = object.language) != null) {
            string6 = string2;
        }
        if ((n14 = this.averageBitrate) == (n12 = -1)) {
            n14 = object.averageBitrate;
        }
        if ((n11 = this.peakBitrate) == n12) {
            n11 = object.peakBitrate;
        }
        if ((object3 = this.codecs) == null && (n10 = (stringArray = Util.splitCodecs((String)(object2 = Util.getCodecsOfType(object.codecs, n13)))).length) == n15) {
            object3 = object2;
        }
        if ((metadata = this.metadata) == null) {
            metadata = object.metadata;
        } else {
            object2 = object.metadata;
            metadata = metadata.copyWithAppendedEntriesFrom((Metadata)object2);
        }
        float f10 = this.frameRate;
        float f11 = -1.0f;
        n10 = (int)(f10 == f11 ? 0 : (f10 > f11 ? 1 : -1));
        if (n10 == 0) {
            n10 = 2;
            f11 = 2.8E-45f;
            if (n13 == n10) {
                f10 = object.frameRate;
            }
        }
        n13 = this.selectionFlags;
        n10 = object.selectionFlags;
        n13 |= n10;
        n10 = this.roleFlags;
        int n16 = object.roleFlags;
        object = object.drmInitData;
        DrmInitData drmInitData = this.drmInitData;
        object = DrmInitData.createSessionCreationData((DrmInitData)object, drmInitData);
        return this.buildUpon().setId(string4).setLabel(string5).setLanguage(string6).setSelectionFlags(n13).setRoleFlags(n10 |= n16).setAverageBitrate(n14).setPeakBitrate(n11).setCodecs((String)object3).setMetadata(metadata).setDrmInitData((DrmInitData)object).setFrameRate(f10).build();
    }

    public void writeToParcel(Parcel parcel, int n10) {
        Object object = this.id;
        parcel.writeString((String)object);
        object = this.label;
        parcel.writeString((String)object);
        object = this.language;
        parcel.writeString((String)object);
        int n11 = this.selectionFlags;
        parcel.writeInt(n11);
        n11 = this.roleFlags;
        parcel.writeInt(n11);
        n11 = this.averageBitrate;
        parcel.writeInt(n11);
        n11 = this.peakBitrate;
        parcel.writeInt(n11);
        object = this.codecs;
        parcel.writeString((String)object);
        object = this.metadata;
        boolean bl2 = false;
        parcel.writeParcelable((Parcelable)object, 0);
        object = this.containerMimeType;
        parcel.writeString((String)object);
        object = this.sampleMimeType;
        parcel.writeString((String)object);
        n11 = this.maxInputSize;
        parcel.writeInt(n11);
        object = this.initializationData;
        n11 = object.size();
        parcel.writeInt(n11);
        for (int i10 = 0; i10 < n11; ++i10) {
            byte[] byArray = (byte[])this.initializationData.get(i10);
            parcel.writeByteArray(byArray);
        }
        object = this.drmInitData;
        parcel.writeParcelable((Parcelable)object, 0);
        long l10 = this.subsampleOffsetUs;
        parcel.writeLong(l10);
        n11 = this.width;
        parcel.writeInt(n11);
        n11 = this.height;
        parcel.writeInt(n11);
        float f10 = this.frameRate;
        parcel.writeFloat(f10);
        n11 = this.rotationDegrees;
        parcel.writeInt(n11);
        f10 = this.pixelWidthHeightRatio;
        parcel.writeFloat(f10);
        object = this.projectionData;
        if (object != null) {
            bl2 = true;
        }
        Util.writeBoolean(parcel, bl2);
        object = this.projectionData;
        if (object != null) {
            parcel.writeByteArray((byte[])object);
        }
        n11 = this.stereoMode;
        parcel.writeInt(n11);
        object = this.colorInfo;
        parcel.writeParcelable((Parcelable)object, n10);
        n10 = this.channelCount;
        parcel.writeInt(n10);
        n10 = this.sampleRate;
        parcel.writeInt(n10);
        n10 = this.pcmEncoding;
        parcel.writeInt(n10);
        n10 = this.encoderDelay;
        parcel.writeInt(n10);
        n10 = this.encoderPadding;
        parcel.writeInt(n10);
        n10 = this.accessibilityChannel;
        parcel.writeInt(n10);
    }
}

