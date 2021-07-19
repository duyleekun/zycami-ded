/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Build
 */
package androidx.camera.core.impl.utils;

import android.os.Build;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.utils.ExifAttribute;
import androidx.camera.core.impl.utils.ExifData$Builder;
import androidx.camera.core.impl.utils.ExifTag;
import androidx.camera.core.impl.utils.LongRational;
import androidx.core.util.Preconditions;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class ExifData {
    private static final boolean DEBUG = false;
    public static final ExifTag[] EXIF_POINTER_TAGS;
    public static final ExifTag[][] EXIF_TAGS;
    private static final ExifTag[] IFD_EXIF_TAGS;
    public static final String[] IFD_FORMAT_NAMES;
    private static final ExifTag[] IFD_GPS_TAGS;
    private static final ExifTag[] IFD_INTEROPERABILITY_TAGS;
    private static final ExifTag[] IFD_TIFF_TAGS;
    public static final int IFD_TYPE_EXIF = 1;
    public static final int IFD_TYPE_GPS = 2;
    public static final int IFD_TYPE_INTEROPERABILITY = 3;
    public static final int IFD_TYPE_PRIMARY = 0;
    private static final int MM_IN_MICRONS = 1000;
    private static final String TAG = "ExifData";
    public static final String TAG_EXIF_IFD_POINTER = "ExifIFDPointer";
    public static final String TAG_GPS_INFO_IFD_POINTER = "GPSInfoIFDPointer";
    public static final String TAG_INTEROPERABILITY_IFD_POINTER = "InteroperabilityIFDPointer";
    public static final String TAG_SUB_IFD_POINTER = "SubIFDPointer";
    public static final HashSet sTagSetForCompatibility;
    private final List mAttributes;
    private final ByteOrder mByteOrder;

    static {
        ExifTag exifTag;
        ExifTag exifTag2;
        ExifTag exifTag3;
        IFD_FORMAT_NAMES = new String[]{"", "BYTE", "STRING", "USHORT", "ULONG", "URATIONAL", "SBYTE", "UNDEFINED", "SSHORT", "SLONG", "SRATIONAL", "SINGLE", "DOUBLE", "IFD"};
        Object object = new ExifTag[14];
        int n10 = 3;
        int n11 = 4;
        ExifTag[] exifTagArray = new ExifTag("ImageWidth", 256, n10, n11);
        object[0] = exifTagArray;
        exifTagArray = new ExifTag("ImageLength", 257, n10, n11);
        int n12 = 1;
        object[n12] = exifTagArray;
        int n13 = 2;
        exifTagArray = new ExifTag("Make", 271, n13);
        object[n13] = exifTagArray;
        exifTagArray = new ExifTag("Model", 272, n13);
        object[n10] = exifTagArray;
        exifTagArray = new ExifTag("Orientation", 274, n10);
        object[n11] = exifTagArray;
        int n14 = 5;
        exifTagArray = new ExifTag("XResolution", 282, n14);
        object[n14] = exifTagArray;
        exifTagArray = new ExifTag("YResolution", 283, n14);
        int n15 = 6;
        object[n15] = exifTagArray;
        exifTagArray = new ExifTag("ResolutionUnit", 296, n10);
        int n16 = 7;
        object[n16] = exifTagArray;
        exifTagArray = new ExifTag("Software", 305, n13);
        object[8] = exifTagArray;
        exifTagArray = new ExifTag("DateTime", 306, n13);
        object[9] = exifTagArray;
        exifTagArray = new ExifTag("YCbCrPositioning", 531, n10);
        object[10] = exifTagArray;
        String string2 = TAG_SUB_IFD_POINTER;
        exifTagArray = new ExifTag(string2, 330, n11);
        int n17 = 11;
        object[n17] = exifTagArray;
        String string3 = TAG_EXIF_IFD_POINTER;
        exifTagArray = new ExifTag(string3, 34665, n11);
        object[12] = exifTagArray;
        Object object2 = TAG_GPS_INFO_IFD_POINTER;
        exifTagArray = new ExifTag((String)object2, 34853, n11);
        object[13] = exifTagArray;
        IFD_TIFF_TAGS = object;
        exifTagArray = new ExifTag[37];
        String string4 = "ExposureTime";
        exifTagArray[0] = exifTag3 = new ExifTag(string4, 33434, n14);
        exifTagArray[n12] = exifTag2 = new ExifTag("FNumber", 33437, n14);
        ExifTag[] exifTagArray2 = new ExifTag("ExposureProgram", 34850, n10);
        exifTagArray[n13] = exifTagArray2;
        exifTagArray2 = new ExifTag("PhotographicSensitivity", 34855, n10);
        exifTagArray[n10] = exifTagArray2;
        exifTagArray2 = new ExifTag("SensitivityType", 34864, n10);
        exifTagArray[n11] = exifTagArray2;
        exifTagArray2 = new ExifTag("ExifVersion", 36864, n13);
        exifTagArray[n14] = exifTagArray2;
        exifTagArray2 = new ExifTag("DateTimeOriginal", 36867, n13);
        exifTagArray[n15] = exifTagArray2;
        exifTagArray2 = new ExifTag("DateTimeDigitized", 36868, n13);
        exifTagArray[n16] = exifTagArray2;
        exifTagArray2 = new ExifTag("ComponentsConfiguration", 37121, n16);
        exifTagArray[8] = exifTagArray2;
        n15 = 10;
        exifTagArray2 = new ExifTag("ShutterSpeedValue", 37377, n15);
        exifTagArray[9] = exifTagArray2;
        exifTagArray2 = new ExifTag("ApertureValue", 37378, n14);
        exifTagArray[n15] = exifTagArray2;
        exifTagArray2 = new ExifTag("BrightnessValue", 37379, n15);
        exifTagArray[n17] = exifTagArray2;
        exifTagArray2 = new ExifTag("ExposureBiasValue", 37380, n15);
        exifTagArray[12] = exifTagArray2;
        exifTagArray2 = new ExifTag("MaxApertureValue", 37381, n14);
        exifTagArray[13] = exifTagArray2;
        exifTagArray2 = new ExifTag("MeteringMode", 37383, n10);
        exifTagArray[14] = exifTagArray2;
        exifTagArray2 = new ExifTag("LightSource", 37384, n10);
        exifTagArray[15] = exifTagArray2;
        exifTagArray2 = new ExifTag("Flash", 37385, n10);
        exifTagArray[16] = exifTagArray2;
        exifTagArray2 = new ExifTag("FocalLength", 37386, n14);
        exifTagArray[17] = exifTagArray2;
        exifTagArray2 = new ExifTag("SubSecTime", 37520, n13);
        exifTagArray[18] = exifTagArray2;
        exifTagArray2 = new ExifTag("SubSecTimeOriginal", 37521, n13);
        exifTagArray[19] = exifTagArray2;
        exifTagArray2 = new ExifTag("SubSecTimeDigitized", 37522, n13);
        exifTagArray[20] = exifTagArray2;
        exifTagArray2 = new ExifTag("FlashpixVersion", 40960, n16);
        exifTagArray[21] = exifTagArray2;
        exifTagArray2 = new ExifTag("ColorSpace", 40961, n10);
        exifTagArray[22] = exifTagArray2;
        exifTagArray2 = new ExifTag("PixelXDimension", 40962, n10, n11);
        exifTagArray[23] = exifTagArray2;
        exifTagArray2 = new ExifTag("PixelYDimension", 40963, n10, n11);
        exifTagArray[24] = exifTagArray2;
        exifTagArray2 = new ExifTag(TAG_INTEROPERABILITY_IFD_POINTER, 40965, n11);
        exifTagArray[25] = exifTagArray2;
        exifTagArray2 = new ExifTag("FocalPlaneResolutionUnit", 41488, n10);
        exifTagArray[26] = exifTagArray2;
        exifTagArray2 = new ExifTag("SensingMethod", 41495, n10);
        exifTagArray[27] = exifTagArray2;
        exifTagArray2 = new ExifTag("FileSource", 41728, n16);
        exifTagArray[28] = exifTagArray2;
        exifTagArray2 = new ExifTag("SceneType", 41729, n16);
        exifTagArray[29] = exifTagArray2;
        exifTagArray2 = new ExifTag("CustomRendered", 41985, n10);
        exifTagArray[30] = exifTagArray2;
        exifTagArray2 = new ExifTag("ExposureMode", 41986, n10);
        exifTagArray[31] = exifTagArray2;
        exifTagArray2 = new ExifTag("WhiteBalance", 41987, n10);
        exifTagArray[32] = exifTagArray2;
        exifTagArray2 = new ExifTag("SceneCaptureType", 41990, n10);
        exifTagArray[33] = exifTagArray2;
        exifTagArray2 = new ExifTag("Contrast", 41992, n10);
        exifTagArray[34] = exifTagArray2;
        exifTagArray2 = new ExifTag("Saturation", 41993, n10);
        exifTagArray[35] = exifTagArray2;
        exifTagArray2 = new ExifTag("Sharpness", 41994, n10);
        exifTagArray[36] = exifTagArray2;
        IFD_EXIF_TAGS = exifTagArray;
        exifTagArray2 = new ExifTag[13];
        Object object3 = new ExifTag("GPSVersionID", 0, n12);
        exifTagArray2[0] = object3;
        object3 = new ExifTag("GPSLatitudeRef", n12, n13);
        exifTagArray2[n12] = object3;
        int n18 = 10;
        object3 = new ExifTag("GPSLatitude", n13, n14, n18);
        exifTagArray2[n13] = object3;
        object3 = new ExifTag("GPSLongitudeRef", n10, n13);
        exifTagArray2[n10] = object3;
        object3 = new ExifTag("GPSLongitude", n11, n14, n18);
        exifTagArray2[n11] = object3;
        object3 = new ExifTag("GPSAltitudeRef", n14, n12);
        exifTagArray2[n14] = object3;
        n18 = 6;
        object3 = new ExifTag("GPSAltitude", n18, n14);
        exifTagArray2[n18] = object3;
        object3 = new ExifTag("GPSTimeStamp", n16, n14);
        exifTagArray2[n16] = object3;
        object3 = new ExifTag("GPSSpeedRef", 12, n13);
        exifTagArray2[8] = object3;
        object3 = new ExifTag("GPSTrackRef", 14, n13);
        exifTagArray2[9] = object3;
        object3 = new ExifTag("GPSImgDirectionRef", 16, n13);
        exifTagArray2[10] = object3;
        object3 = new ExifTag("GPSDestBearingRef", 23, n13);
        exifTagArray2[n17] = object3;
        object3 = new ExifTag("GPSDestDistanceRef", 25, n13);
        exifTagArray2[12] = object3;
        IFD_GPS_TAGS = exifTagArray2;
        object3 = new ExifTag[n11];
        object3[0] = exifTag = new ExifTag(string2, 330, n11);
        object3[n12] = exifTag = new ExifTag(string3, 34665, n11);
        object3[n13] = exifTag = new ExifTag((String)object2, 34853, n11);
        object2 = new ExifTag(TAG_INTEROPERABILITY_IFD_POINTER, 40965, n11);
        object3[n10] = object2;
        EXIF_POINTER_TAGS = object3;
        object2 = new ExifTag[n12];
        object2[0] = object3 = new ExifTag("InteroperabilityIndex", n12, n13);
        IFD_INTEROPERABILITY_TAGS = object2;
        ExifTag[][] exifTagArrayArray = new ExifTag[n11][];
        exifTagArrayArray[0] = object;
        exifTagArrayArray[n12] = exifTagArray;
        exifTagArrayArray[n13] = exifTagArray2;
        exifTagArrayArray[n10] = object2;
        EXIF_TAGS = exifTagArrayArray;
        object = Arrays.asList("FNumber", string4, "GPSTimeStamp");
        sTagSetForCompatibility = object2 = new HashSet(object);
    }

    public ExifData(ByteOrder byteOrder, List list) {
        int n10 = list.size();
        ExifTag[][] exifTagArray = EXIF_TAGS;
        int n11 = exifTagArray.length;
        n10 = n10 == n11 ? 1 : 0;
        Preconditions.checkState(n10 != 0, "Malformed attributes list. Number of IFDs mismatch.");
        this.mByteOrder = byteOrder;
        this.mAttributes = list;
    }

    public static ExifData$Builder builderForDevice() {
        Object object = ByteOrder.BIG_ENDIAN;
        ExifData$Builder exifData$Builder = new ExifData$Builder((ByteOrder)object);
        int n10 = 1;
        String string2 = String.valueOf(n10);
        exifData$Builder = exifData$Builder.setAttribute("Orientation", string2);
        String string3 = "72/1";
        exifData$Builder = exifData$Builder.setAttribute("XResolution", string3).setAttribute("YResolution", string3);
        string2 = String.valueOf(2);
        exifData$Builder = exifData$Builder.setAttribute("ResolutionUnit", string2);
        object = String.valueOf(n10);
        exifData$Builder = exifData$Builder.setAttribute("YCbCrPositioning", (String)object);
        object = Build.MANUFACTURER;
        exifData$Builder = exifData$Builder.setAttribute("Make", (String)object);
        object = Build.MODEL;
        return exifData$Builder.setAttribute("Model", (String)object);
    }

    private ExifAttribute getExifAttribute(String string2) {
        Object object;
        int n10;
        String string3 = "ISOSpeedRatings";
        int n11 = string3.equals(string2);
        if (n11 != 0) {
            string2 = "PhotographicSensitivity";
        }
        string3 = null;
        for (n11 = 0; n11 < (n10 = ((ExifTag[][])(object = EXIF_TAGS)).length); ++n11) {
            object = (ExifAttribute)((Map)this.mAttributes.get(n11)).get(string2);
            if (object == null) continue;
            return object;
        }
        return null;
    }

    public String getAttribute(String object) {
        Object object2 = this.getExifAttribute((String)object);
        Object[] objectArray = null;
        if (object2 != null) {
            Object object3 = sTagSetForCompatibility;
            boolean n10 = ((HashSet)object3).contains(object);
            if (!n10) {
                object = this.mByteOrder;
                return ((ExifAttribute)object2).getStringValue((ByteOrder)object);
            }
            object3 = "GPSTimeStamp";
            int n11 = ((String)object).equals(object3);
            if (n11 != 0) {
                int n12;
                int n13;
                int n14;
                n11 = ((ExifAttribute)object2).format;
                int n15 = 5;
                Object object4 = TAG;
                if (n11 != n15 && n11 != (n14 = 10)) {
                    object = new StringBuilder();
                    ((StringBuilder)object).append("GPS Timestamp format is not rational. format=");
                    int n16 = ((ExifAttribute)object2).format;
                    ((StringBuilder)object).append(n16);
                    object = ((StringBuilder)object).toString();
                    Logger.w((String)object4, (String)object);
                    return null;
                }
                object = this.mByteOrder;
                if ((object = (LongRational[])((ExifAttribute)object2).getValue((ByteOrder)object)) != null && (n13 = ((Object)object).length) == (n12 = 3)) {
                    object2 = Locale.US;
                    objectArray = new Object[n12];
                    float f10 = ((LongRational)object[0]).getNumerator();
                    float f11 = ((LongRational)object[0]).getDenominator();
                    objectArray[0] = object4 = Integer.valueOf((int)(f10 / f11));
                    int n17 = 1;
                    f10 = ((LongRational)object[n17]).getNumerator();
                    f11 = ((LongRational)object[n17]).getDenominator();
                    objectArray[n17] = object4 = Integer.valueOf((int)(f10 / f11));
                    int n18 = 2;
                    f10 = ((LongRational)object[n18]).getNumerator();
                    float f12 = ((LongRational)object[n18]).getDenominator();
                    objectArray[n18] = object = Integer.valueOf((int)(f10 / f12));
                    return String.format((Locale)object2, "%02d:%02d:%02d", objectArray);
                }
                object2 = new StringBuilder();
                ((StringBuilder)object2).append("Invalid GPS Timestamp array. array=");
                object = Arrays.toString((Object[])object);
                ((StringBuilder)object2).append((String)object);
                object = ((StringBuilder)object2).toString();
                Logger.w((String)object4, (String)object);
                return null;
            }
            try {
                object = this.mByteOrder;
            }
            catch (NumberFormatException numberFormatException) {}
            double d10 = ((ExifAttribute)object2).getDoubleValue((ByteOrder)object);
            return Double.toString(d10);
        }
        return null;
    }

    public Map getAttributes(int n10) {
        int n11 = EXIF_TAGS.length;
        CharSequence charSequence = new StringBuilder();
        charSequence.append("Invalid IFD index: ");
        charSequence.append(n10);
        charSequence.append(". Index should be between [0, EXIF_TAGS.length] ");
        charSequence = charSequence.toString();
        Preconditions.checkArgumentInRange(n10, 0, n11, (String)charSequence);
        return (Map)this.mAttributes.get(n10);
    }

    public ByteOrder getByteOrder() {
        return this.mByteOrder;
    }
}

