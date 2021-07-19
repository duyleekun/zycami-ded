/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.res.AssetManager$AssetInputStream
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$Config
 *  android.graphics.BitmapFactory
 *  android.location.Location
 *  android.media.MediaDataSource
 *  android.media.MediaMetadataRetriever
 *  android.os.Build$VERSION
 *  android.system.Os
 *  android.system.OsConstants
 *  android.util.Log
 *  android.util.Pair
 */
package androidx.exifinterface.media;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.location.Location;
import android.media.MediaDataSource;
import android.media.MediaMetadataRetriever;
import android.os.Build;
import android.system.Os;
import android.system.OsConstants;
import android.util.Log;
import android.util.Pair;
import androidx.exifinterface.media.ExifInterface$1;
import androidx.exifinterface.media.ExifInterface$ByteOrderedDataInputStream;
import androidx.exifinterface.media.ExifInterface$ByteOrderedDataOutputStream;
import androidx.exifinterface.media.ExifInterface$ExifAttribute;
import androidx.exifinterface.media.ExifInterface$ExifTag;
import androidx.exifinterface.media.ExifInterface$Rational;
import j$.util.DesugarTimeZone;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.text.DateFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.CRC32;

public class ExifInterface {
    public static final short ALTITUDE_ABOVE_SEA_LEVEL = 0;
    public static final short ALTITUDE_BELOW_SEA_LEVEL = 1;
    public static final Charset ASCII;
    public static final int[] BITS_PER_SAMPLE_GREYSCALE_1;
    public static final int[] BITS_PER_SAMPLE_GREYSCALE_2;
    public static final int[] BITS_PER_SAMPLE_RGB;
    public static final short BYTE_ALIGN_II = 18761;
    public static final short BYTE_ALIGN_MM = 19789;
    public static final int COLOR_SPACE_S_RGB = 1;
    public static final int COLOR_SPACE_UNCALIBRATED = 65535;
    public static final short CONTRAST_HARD = 2;
    public static final short CONTRAST_NORMAL = 0;
    public static final short CONTRAST_SOFT = 1;
    public static final int DATA_DEFLATE_ZIP = 8;
    public static final int DATA_HUFFMAN_COMPRESSED = 2;
    public static final int DATA_JPEG = 6;
    public static final int DATA_JPEG_COMPRESSED = 7;
    public static final int DATA_LOSSY_JPEG = 34892;
    public static final int DATA_PACK_BITS_COMPRESSED = 32773;
    public static final int DATA_UNCOMPRESSED = 1;
    private static final Pattern DATETIME_PRIMARY_FORMAT_PATTERN;
    private static final Pattern DATETIME_SECONDARY_FORMAT_PATTERN;
    private static final int DATETIME_VALUE_STRING_LENGTH = 19;
    private static final boolean DEBUG = false;
    public static final byte[] EXIF_ASCII_PREFIX;
    private static final ExifInterface$ExifTag[] EXIF_POINTER_TAGS;
    public static final ExifInterface$ExifTag[][] EXIF_TAGS;
    public static final short EXPOSURE_MODE_AUTO = 0;
    public static final short EXPOSURE_MODE_AUTO_BRACKET = 2;
    public static final short EXPOSURE_MODE_MANUAL = 1;
    public static final short EXPOSURE_PROGRAM_ACTION = 6;
    public static final short EXPOSURE_PROGRAM_APERTURE_PRIORITY = 3;
    public static final short EXPOSURE_PROGRAM_CREATIVE = 5;
    public static final short EXPOSURE_PROGRAM_LANDSCAPE_MODE = 8;
    public static final short EXPOSURE_PROGRAM_MANUAL = 1;
    public static final short EXPOSURE_PROGRAM_NORMAL = 2;
    public static final short EXPOSURE_PROGRAM_NOT_DEFINED = 0;
    public static final short EXPOSURE_PROGRAM_PORTRAIT_MODE = 7;
    public static final short EXPOSURE_PROGRAM_SHUTTER_PRIORITY = 4;
    public static final short FILE_SOURCE_DSC = 3;
    public static final short FILE_SOURCE_OTHER = 0;
    public static final short FILE_SOURCE_REFLEX_SCANNER = 2;
    public static final short FILE_SOURCE_TRANSPARENT_SCANNER = 1;
    public static final short FLAG_FLASH_FIRED = 1;
    public static final short FLAG_FLASH_MODE_AUTO = 24;
    public static final short FLAG_FLASH_MODE_COMPULSORY_FIRING = 8;
    public static final short FLAG_FLASH_MODE_COMPULSORY_SUPPRESSION = 16;
    public static final short FLAG_FLASH_NO_FLASH_FUNCTION = 32;
    public static final short FLAG_FLASH_RED_EYE_SUPPORTED = 64;
    public static final short FLAG_FLASH_RETURN_LIGHT_DETECTED = 6;
    public static final short FLAG_FLASH_RETURN_LIGHT_NOT_DETECTED = 4;
    private static final List FLIPPED_ROTATION_ORDER;
    public static final short FORMAT_CHUNKY = 1;
    public static final short FORMAT_PLANAR = 2;
    public static final short GAIN_CONTROL_HIGH_GAIN_DOWN = 4;
    public static final short GAIN_CONTROL_HIGH_GAIN_UP = 2;
    public static final short GAIN_CONTROL_LOW_GAIN_DOWN = 3;
    public static final short GAIN_CONTROL_LOW_GAIN_UP = 1;
    public static final short GAIN_CONTROL_NONE = 0;
    public static final String GPS_DIRECTION_MAGNETIC = "M";
    public static final String GPS_DIRECTION_TRUE = "T";
    public static final String GPS_DISTANCE_KILOMETERS = "K";
    public static final String GPS_DISTANCE_MILES = "M";
    public static final String GPS_DISTANCE_NAUTICAL_MILES = "N";
    public static final String GPS_MEASUREMENT_2D = "2";
    public static final String GPS_MEASUREMENT_3D = "3";
    public static final short GPS_MEASUREMENT_DIFFERENTIAL_CORRECTED = 1;
    public static final String GPS_MEASUREMENT_INTERRUPTED = "V";
    public static final String GPS_MEASUREMENT_IN_PROGRESS = "A";
    public static final short GPS_MEASUREMENT_NO_DIFFERENTIAL = 0;
    public static final String GPS_SPEED_KILOMETERS_PER_HOUR = "K";
    public static final String GPS_SPEED_KNOTS = "N";
    public static final String GPS_SPEED_MILES_PER_HOUR = "M";
    private static final Pattern GPS_TIMESTAMP_PATTERN;
    private static final byte[] HEIF_BRAND_HEIC;
    private static final byte[] HEIF_BRAND_MIF1;
    private static final byte[] HEIF_TYPE_FTYP;
    public static final byte[] IDENTIFIER_EXIF_APP1;
    private static final byte[] IDENTIFIER_XMP_APP1;
    private static final ExifInterface$ExifTag[] IFD_EXIF_TAGS;
    private static final int IFD_FORMAT_BYTE = 1;
    public static final int[] IFD_FORMAT_BYTES_PER_FORMAT;
    private static final int IFD_FORMAT_DOUBLE = 12;
    private static final int IFD_FORMAT_IFD = 13;
    public static final String[] IFD_FORMAT_NAMES;
    private static final int IFD_FORMAT_SBYTE = 6;
    private static final int IFD_FORMAT_SINGLE = 11;
    private static final int IFD_FORMAT_SLONG = 9;
    private static final int IFD_FORMAT_SRATIONAL = 10;
    private static final int IFD_FORMAT_SSHORT = 8;
    private static final int IFD_FORMAT_STRING = 2;
    private static final int IFD_FORMAT_ULONG = 4;
    private static final int IFD_FORMAT_UNDEFINED = 7;
    private static final int IFD_FORMAT_URATIONAL = 5;
    private static final int IFD_FORMAT_USHORT = 3;
    private static final ExifInterface$ExifTag[] IFD_GPS_TAGS;
    private static final ExifInterface$ExifTag[] IFD_INTEROPERABILITY_TAGS;
    private static final int IFD_OFFSET = 8;
    private static final ExifInterface$ExifTag[] IFD_THUMBNAIL_TAGS;
    private static final ExifInterface$ExifTag[] IFD_TIFF_TAGS;
    private static final int IFD_TYPE_EXIF = 1;
    private static final int IFD_TYPE_GPS = 2;
    private static final int IFD_TYPE_INTEROPERABILITY = 3;
    private static final int IFD_TYPE_ORF_CAMERA_SETTINGS = 7;
    private static final int IFD_TYPE_ORF_IMAGE_PROCESSING = 8;
    private static final int IFD_TYPE_ORF_MAKER_NOTE = 6;
    private static final int IFD_TYPE_PEF = 9;
    public static final int IFD_TYPE_PREVIEW = 5;
    public static final int IFD_TYPE_PRIMARY = 0;
    public static final int IFD_TYPE_THUMBNAIL = 4;
    private static final int IMAGE_TYPE_ARW = 1;
    private static final int IMAGE_TYPE_CR2 = 2;
    private static final int IMAGE_TYPE_DNG = 3;
    private static final int IMAGE_TYPE_HEIF = 12;
    private static final int IMAGE_TYPE_JPEG = 4;
    private static final int IMAGE_TYPE_NEF = 5;
    private static final int IMAGE_TYPE_NRW = 6;
    private static final int IMAGE_TYPE_ORF = 7;
    private static final int IMAGE_TYPE_PEF = 8;
    private static final int IMAGE_TYPE_PNG = 13;
    private static final int IMAGE_TYPE_RAF = 9;
    private static final int IMAGE_TYPE_RW2 = 10;
    private static final int IMAGE_TYPE_SRW = 11;
    private static final int IMAGE_TYPE_UNKNOWN = 0;
    private static final int IMAGE_TYPE_WEBP = 14;
    private static final ExifInterface$ExifTag JPEG_INTERCHANGE_FORMAT_LENGTH_TAG;
    private static final ExifInterface$ExifTag JPEG_INTERCHANGE_FORMAT_TAG;
    public static final byte[] JPEG_SIGNATURE;
    public static final String LATITUDE_NORTH = "N";
    public static final String LATITUDE_SOUTH = "S";
    public static final short LIGHT_SOURCE_CLOUDY_WEATHER = 10;
    public static final short LIGHT_SOURCE_COOL_WHITE_FLUORESCENT = 14;
    public static final short LIGHT_SOURCE_D50 = 23;
    public static final short LIGHT_SOURCE_D55 = 20;
    public static final short LIGHT_SOURCE_D65 = 21;
    public static final short LIGHT_SOURCE_D75 = 22;
    public static final short LIGHT_SOURCE_DAYLIGHT = 1;
    public static final short LIGHT_SOURCE_DAYLIGHT_FLUORESCENT = 12;
    public static final short LIGHT_SOURCE_DAY_WHITE_FLUORESCENT = 13;
    public static final short LIGHT_SOURCE_FINE_WEATHER = 9;
    public static final short LIGHT_SOURCE_FLASH = 4;
    public static final short LIGHT_SOURCE_FLUORESCENT = 2;
    public static final short LIGHT_SOURCE_ISO_STUDIO_TUNGSTEN = 24;
    public static final short LIGHT_SOURCE_OTHER = 255;
    public static final short LIGHT_SOURCE_SHADE = 11;
    public static final short LIGHT_SOURCE_STANDARD_LIGHT_A = 17;
    public static final short LIGHT_SOURCE_STANDARD_LIGHT_B = 18;
    public static final short LIGHT_SOURCE_STANDARD_LIGHT_C = 19;
    public static final short LIGHT_SOURCE_TUNGSTEN = 3;
    public static final short LIGHT_SOURCE_UNKNOWN = 0;
    public static final short LIGHT_SOURCE_WARM_WHITE_FLUORESCENT = 16;
    public static final short LIGHT_SOURCE_WHITE_FLUORESCENT = 15;
    public static final String LONGITUDE_EAST = "E";
    public static final String LONGITUDE_WEST = "W";
    public static final byte MARKER = -1;
    public static final byte MARKER_APP1 = -31;
    private static final byte MARKER_COM = -2;
    public static final byte MARKER_EOI = -39;
    private static final byte MARKER_SOF0 = -64;
    private static final byte MARKER_SOF1 = -63;
    private static final byte MARKER_SOF10 = -54;
    private static final byte MARKER_SOF11 = -53;
    private static final byte MARKER_SOF13 = -51;
    private static final byte MARKER_SOF14 = -50;
    private static final byte MARKER_SOF15 = -49;
    private static final byte MARKER_SOF2 = -62;
    private static final byte MARKER_SOF3 = -61;
    private static final byte MARKER_SOF5 = -59;
    private static final byte MARKER_SOF6 = -58;
    private static final byte MARKER_SOF7 = -57;
    private static final byte MARKER_SOF9 = -55;
    private static final byte MARKER_SOI = -40;
    private static final byte MARKER_SOS = -38;
    private static final int MAX_THUMBNAIL_SIZE = 512;
    public static final short METERING_MODE_AVERAGE = 1;
    public static final short METERING_MODE_CENTER_WEIGHT_AVERAGE = 2;
    public static final short METERING_MODE_MULTI_SPOT = 4;
    public static final short METERING_MODE_OTHER = 255;
    public static final short METERING_MODE_PARTIAL = 6;
    public static final short METERING_MODE_PATTERN = 5;
    public static final short METERING_MODE_SPOT = 3;
    public static final short METERING_MODE_UNKNOWN = 0;
    private static final Pattern NON_ZERO_TIME_PATTERN;
    private static final ExifInterface$ExifTag[] ORF_CAMERA_SETTINGS_TAGS;
    private static final ExifInterface$ExifTag[] ORF_IMAGE_PROCESSING_TAGS;
    private static final byte[] ORF_MAKER_NOTE_HEADER_1;
    private static final int ORF_MAKER_NOTE_HEADER_1_SIZE = 8;
    private static final byte[] ORF_MAKER_NOTE_HEADER_2;
    private static final int ORF_MAKER_NOTE_HEADER_2_SIZE = 12;
    private static final ExifInterface$ExifTag[] ORF_MAKER_NOTE_TAGS;
    private static final short ORF_SIGNATURE_1 = 20306;
    private static final short ORF_SIGNATURE_2 = 21330;
    public static final int ORIENTATION_FLIP_HORIZONTAL = 2;
    public static final int ORIENTATION_FLIP_VERTICAL = 4;
    public static final int ORIENTATION_NORMAL = 1;
    public static final int ORIENTATION_ROTATE_180 = 3;
    public static final int ORIENTATION_ROTATE_270 = 8;
    public static final int ORIENTATION_ROTATE_90 = 6;
    public static final int ORIENTATION_TRANSPOSE = 5;
    public static final int ORIENTATION_TRANSVERSE = 7;
    public static final int ORIENTATION_UNDEFINED = 0;
    public static final int ORIGINAL_RESOLUTION_IMAGE = 0;
    private static final int PEF_MAKER_NOTE_SKIP_SIZE = 6;
    private static final String PEF_SIGNATURE = "PENTAX";
    private static final ExifInterface$ExifTag[] PEF_TAGS;
    public static final int PHOTOMETRIC_INTERPRETATION_BLACK_IS_ZERO = 1;
    public static final int PHOTOMETRIC_INTERPRETATION_RGB = 2;
    public static final int PHOTOMETRIC_INTERPRETATION_WHITE_IS_ZERO = 0;
    public static final int PHOTOMETRIC_INTERPRETATION_YCBCR = 6;
    private static final int PNG_CHUNK_CRC_BYTE_LENGTH = 4;
    private static final int PNG_CHUNK_TYPE_BYTE_LENGTH = 4;
    private static final byte[] PNG_CHUNK_TYPE_EXIF;
    private static final byte[] PNG_CHUNK_TYPE_IEND;
    private static final byte[] PNG_CHUNK_TYPE_IHDR;
    private static final byte[] PNG_SIGNATURE;
    private static final int RAF_OFFSET_TO_JPEG_IMAGE_OFFSET = 84;
    private static final String RAF_SIGNATURE = "FUJIFILMCCD-RAW";
    public static final int REDUCED_RESOLUTION_IMAGE = 1;
    public static final short RENDERED_PROCESS_CUSTOM = 1;
    public static final short RENDERED_PROCESS_NORMAL = 0;
    public static final short RESOLUTION_UNIT_CENTIMETERS = 3;
    public static final short RESOLUTION_UNIT_INCHES = 2;
    private static final List ROTATION_ORDER;
    private static final short RW2_SIGNATURE = 85;
    public static final short SATURATION_HIGH = 0;
    public static final short SATURATION_LOW = 0;
    public static final short SATURATION_NORMAL = 0;
    public static final short SCENE_CAPTURE_TYPE_LANDSCAPE = 1;
    public static final short SCENE_CAPTURE_TYPE_NIGHT = 3;
    public static final short SCENE_CAPTURE_TYPE_PORTRAIT = 2;
    public static final short SCENE_CAPTURE_TYPE_STANDARD = 0;
    public static final short SCENE_TYPE_DIRECTLY_PHOTOGRAPHED = 1;
    public static final short SENSITIVITY_TYPE_ISO_SPEED = 3;
    public static final short SENSITIVITY_TYPE_REI = 2;
    public static final short SENSITIVITY_TYPE_REI_AND_ISO = 6;
    public static final short SENSITIVITY_TYPE_SOS = 1;
    public static final short SENSITIVITY_TYPE_SOS_AND_ISO = 5;
    public static final short SENSITIVITY_TYPE_SOS_AND_REI = 4;
    public static final short SENSITIVITY_TYPE_SOS_AND_REI_AND_ISO = 7;
    public static final short SENSITIVITY_TYPE_UNKNOWN = 0;
    public static final short SENSOR_TYPE_COLOR_SEQUENTIAL = 5;
    public static final short SENSOR_TYPE_COLOR_SEQUENTIAL_LINEAR = 8;
    public static final short SENSOR_TYPE_NOT_DEFINED = 1;
    public static final short SENSOR_TYPE_ONE_CHIP = 2;
    public static final short SENSOR_TYPE_THREE_CHIP = 4;
    public static final short SENSOR_TYPE_TRILINEAR = 7;
    public static final short SENSOR_TYPE_TWO_CHIP = 3;
    public static final short SHARPNESS_HARD = 2;
    public static final short SHARPNESS_NORMAL = 0;
    public static final short SHARPNESS_SOFT = 1;
    private static final int SIGNATURE_CHECK_SIZE = 5000;
    public static final byte START_CODE = 42;
    public static final int STREAM_TYPE_EXIF_DATA_ONLY = 1;
    public static final int STREAM_TYPE_FULL_IMAGE_DATA = 0;
    public static final short SUBJECT_DISTANCE_RANGE_CLOSE_VIEW = 2;
    public static final short SUBJECT_DISTANCE_RANGE_DISTANT_VIEW = 3;
    public static final short SUBJECT_DISTANCE_RANGE_MACRO = 1;
    public static final short SUBJECT_DISTANCE_RANGE_UNKNOWN = 0;
    private static final String TAG = "ExifInterface";
    public static final String TAG_APERTURE_VALUE = "ApertureValue";
    public static final String TAG_ARTIST = "Artist";
    public static final String TAG_BITS_PER_SAMPLE = "BitsPerSample";
    public static final String TAG_BODY_SERIAL_NUMBER = "BodySerialNumber";
    public static final String TAG_BRIGHTNESS_VALUE = "BrightnessValue";
    public static final String TAG_CAMARA_OWNER_NAME = "CameraOwnerName";
    public static final String TAG_CAMERA_OWNER_NAME = "CameraOwnerName";
    public static final String TAG_CFA_PATTERN = "CFAPattern";
    public static final String TAG_COLOR_SPACE = "ColorSpace";
    public static final String TAG_COMPONENTS_CONFIGURATION = "ComponentsConfiguration";
    public static final String TAG_COMPRESSED_BITS_PER_PIXEL = "CompressedBitsPerPixel";
    public static final String TAG_COMPRESSION = "Compression";
    public static final String TAG_CONTRAST = "Contrast";
    public static final String TAG_COPYRIGHT = "Copyright";
    public static final String TAG_CUSTOM_RENDERED = "CustomRendered";
    public static final String TAG_DATETIME = "DateTime";
    public static final String TAG_DATETIME_DIGITIZED = "DateTimeDigitized";
    public static final String TAG_DATETIME_ORIGINAL = "DateTimeOriginal";
    public static final String TAG_DEFAULT_CROP_SIZE = "DefaultCropSize";
    public static final String TAG_DEVICE_SETTING_DESCRIPTION = "DeviceSettingDescription";
    public static final String TAG_DIGITAL_ZOOM_RATIO = "DigitalZoomRatio";
    public static final String TAG_DNG_VERSION = "DNGVersion";
    private static final String TAG_EXIF_IFD_POINTER = "ExifIFDPointer";
    public static final String TAG_EXIF_VERSION = "ExifVersion";
    public static final String TAG_EXPOSURE_BIAS_VALUE = "ExposureBiasValue";
    public static final String TAG_EXPOSURE_INDEX = "ExposureIndex";
    public static final String TAG_EXPOSURE_MODE = "ExposureMode";
    public static final String TAG_EXPOSURE_PROGRAM = "ExposureProgram";
    public static final String TAG_EXPOSURE_TIME = "ExposureTime";
    public static final String TAG_FILE_SOURCE = "FileSource";
    public static final String TAG_FLASH = "Flash";
    public static final String TAG_FLASHPIX_VERSION = "FlashpixVersion";
    public static final String TAG_FLASH_ENERGY = "FlashEnergy";
    public static final String TAG_FOCAL_LENGTH = "FocalLength";
    public static final String TAG_FOCAL_LENGTH_IN_35MM_FILM = "FocalLengthIn35mmFilm";
    public static final String TAG_FOCAL_PLANE_RESOLUTION_UNIT = "FocalPlaneResolutionUnit";
    public static final String TAG_FOCAL_PLANE_X_RESOLUTION = "FocalPlaneXResolution";
    public static final String TAG_FOCAL_PLANE_Y_RESOLUTION = "FocalPlaneYResolution";
    public static final String TAG_F_NUMBER = "FNumber";
    public static final String TAG_GAIN_CONTROL = "GainControl";
    public static final String TAG_GAMMA = "Gamma";
    public static final String TAG_GPS_ALTITUDE = "GPSAltitude";
    public static final String TAG_GPS_ALTITUDE_REF = "GPSAltitudeRef";
    public static final String TAG_GPS_AREA_INFORMATION = "GPSAreaInformation";
    public static final String TAG_GPS_DATESTAMP = "GPSDateStamp";
    public static final String TAG_GPS_DEST_BEARING = "GPSDestBearing";
    public static final String TAG_GPS_DEST_BEARING_REF = "GPSDestBearingRef";
    public static final String TAG_GPS_DEST_DISTANCE = "GPSDestDistance";
    public static final String TAG_GPS_DEST_DISTANCE_REF = "GPSDestDistanceRef";
    public static final String TAG_GPS_DEST_LATITUDE = "GPSDestLatitude";
    public static final String TAG_GPS_DEST_LATITUDE_REF = "GPSDestLatitudeRef";
    public static final String TAG_GPS_DEST_LONGITUDE = "GPSDestLongitude";
    public static final String TAG_GPS_DEST_LONGITUDE_REF = "GPSDestLongitudeRef";
    public static final String TAG_GPS_DIFFERENTIAL = "GPSDifferential";
    public static final String TAG_GPS_DOP = "GPSDOP";
    public static final String TAG_GPS_H_POSITIONING_ERROR = "GPSHPositioningError";
    public static final String TAG_GPS_IMG_DIRECTION = "GPSImgDirection";
    public static final String TAG_GPS_IMG_DIRECTION_REF = "GPSImgDirectionRef";
    private static final String TAG_GPS_INFO_IFD_POINTER = "GPSInfoIFDPointer";
    public static final String TAG_GPS_LATITUDE = "GPSLatitude";
    public static final String TAG_GPS_LATITUDE_REF = "GPSLatitudeRef";
    public static final String TAG_GPS_LONGITUDE = "GPSLongitude";
    public static final String TAG_GPS_LONGITUDE_REF = "GPSLongitudeRef";
    public static final String TAG_GPS_MAP_DATUM = "GPSMapDatum";
    public static final String TAG_GPS_MEASURE_MODE = "GPSMeasureMode";
    public static final String TAG_GPS_PROCESSING_METHOD = "GPSProcessingMethod";
    public static final String TAG_GPS_SATELLITES = "GPSSatellites";
    public static final String TAG_GPS_SPEED = "GPSSpeed";
    public static final String TAG_GPS_SPEED_REF = "GPSSpeedRef";
    public static final String TAG_GPS_STATUS = "GPSStatus";
    public static final String TAG_GPS_TIMESTAMP = "GPSTimeStamp";
    public static final String TAG_GPS_TRACK = "GPSTrack";
    public static final String TAG_GPS_TRACK_REF = "GPSTrackRef";
    public static final String TAG_GPS_VERSION_ID = "GPSVersionID";
    public static final String TAG_IMAGE_DESCRIPTION = "ImageDescription";
    public static final String TAG_IMAGE_LENGTH = "ImageLength";
    public static final String TAG_IMAGE_UNIQUE_ID = "ImageUniqueID";
    public static final String TAG_IMAGE_WIDTH = "ImageWidth";
    private static final String TAG_INTEROPERABILITY_IFD_POINTER = "InteroperabilityIFDPointer";
    public static final String TAG_INTEROPERABILITY_INDEX = "InteroperabilityIndex";
    public static final String TAG_ISO_SPEED = "ISOSpeed";
    public static final String TAG_ISO_SPEED_LATITUDE_YYY = "ISOSpeedLatitudeyyy";
    public static final String TAG_ISO_SPEED_LATITUDE_ZZZ = "ISOSpeedLatitudezzz";
    public static final String TAG_ISO_SPEED_RATINGS = "ISOSpeedRatings";
    public static final String TAG_JPEG_INTERCHANGE_FORMAT = "JPEGInterchangeFormat";
    public static final String TAG_JPEG_INTERCHANGE_FORMAT_LENGTH = "JPEGInterchangeFormatLength";
    public static final String TAG_LENS_MAKE = "LensMake";
    public static final String TAG_LENS_MODEL = "LensModel";
    public static final String TAG_LENS_SERIAL_NUMBER = "LensSerialNumber";
    public static final String TAG_LENS_SPECIFICATION = "LensSpecification";
    public static final String TAG_LIGHT_SOURCE = "LightSource";
    public static final String TAG_MAKE = "Make";
    public static final String TAG_MAKER_NOTE = "MakerNote";
    public static final String TAG_MAX_APERTURE_VALUE = "MaxApertureValue";
    public static final String TAG_METERING_MODE = "MeteringMode";
    public static final String TAG_MODEL = "Model";
    public static final String TAG_NEW_SUBFILE_TYPE = "NewSubfileType";
    public static final String TAG_OECF = "OECF";
    public static final String TAG_OFFSET_TIME = "OffsetTime";
    public static final String TAG_OFFSET_TIME_DIGITIZED = "OffsetTimeDigitized";
    public static final String TAG_OFFSET_TIME_ORIGINAL = "OffsetTimeOriginal";
    public static final String TAG_ORF_ASPECT_FRAME = "AspectFrame";
    private static final String TAG_ORF_CAMERA_SETTINGS_IFD_POINTER = "CameraSettingsIFDPointer";
    private static final String TAG_ORF_IMAGE_PROCESSING_IFD_POINTER = "ImageProcessingIFDPointer";
    public static final String TAG_ORF_PREVIEW_IMAGE_LENGTH = "PreviewImageLength";
    public static final String TAG_ORF_PREVIEW_IMAGE_START = "PreviewImageStart";
    public static final String TAG_ORF_THUMBNAIL_IMAGE = "ThumbnailImage";
    public static final String TAG_ORIENTATION = "Orientation";
    public static final String TAG_PHOTOGRAPHIC_SENSITIVITY = "PhotographicSensitivity";
    public static final String TAG_PHOTOMETRIC_INTERPRETATION = "PhotometricInterpretation";
    public static final String TAG_PIXEL_X_DIMENSION = "PixelXDimension";
    public static final String TAG_PIXEL_Y_DIMENSION = "PixelYDimension";
    public static final String TAG_PLANAR_CONFIGURATION = "PlanarConfiguration";
    public static final String TAG_PRIMARY_CHROMATICITIES = "PrimaryChromaticities";
    private static final ExifInterface$ExifTag TAG_RAF_IMAGE_SIZE;
    public static final String TAG_RECOMMENDED_EXPOSURE_INDEX = "RecommendedExposureIndex";
    public static final String TAG_REFERENCE_BLACK_WHITE = "ReferenceBlackWhite";
    public static final String TAG_RELATED_SOUND_FILE = "RelatedSoundFile";
    public static final String TAG_RESOLUTION_UNIT = "ResolutionUnit";
    public static final String TAG_ROWS_PER_STRIP = "RowsPerStrip";
    public static final String TAG_RW2_ISO = "ISO";
    public static final String TAG_RW2_JPG_FROM_RAW = "JpgFromRaw";
    public static final String TAG_RW2_SENSOR_BOTTOM_BORDER = "SensorBottomBorder";
    public static final String TAG_RW2_SENSOR_LEFT_BORDER = "SensorLeftBorder";
    public static final String TAG_RW2_SENSOR_RIGHT_BORDER = "SensorRightBorder";
    public static final String TAG_RW2_SENSOR_TOP_BORDER = "SensorTopBorder";
    public static final String TAG_SAMPLES_PER_PIXEL = "SamplesPerPixel";
    public static final String TAG_SATURATION = "Saturation";
    public static final String TAG_SCENE_CAPTURE_TYPE = "SceneCaptureType";
    public static final String TAG_SCENE_TYPE = "SceneType";
    public static final String TAG_SENSING_METHOD = "SensingMethod";
    public static final String TAG_SENSITIVITY_TYPE = "SensitivityType";
    public static final String TAG_SHARPNESS = "Sharpness";
    public static final String TAG_SHUTTER_SPEED_VALUE = "ShutterSpeedValue";
    public static final String TAG_SOFTWARE = "Software";
    public static final String TAG_SPATIAL_FREQUENCY_RESPONSE = "SpatialFrequencyResponse";
    public static final String TAG_SPECTRAL_SENSITIVITY = "SpectralSensitivity";
    public static final String TAG_STANDARD_OUTPUT_SENSITIVITY = "StandardOutputSensitivity";
    public static final String TAG_STRIP_BYTE_COUNTS = "StripByteCounts";
    public static final String TAG_STRIP_OFFSETS = "StripOffsets";
    public static final String TAG_SUBFILE_TYPE = "SubfileType";
    public static final String TAG_SUBJECT_AREA = "SubjectArea";
    public static final String TAG_SUBJECT_DISTANCE = "SubjectDistance";
    public static final String TAG_SUBJECT_DISTANCE_RANGE = "SubjectDistanceRange";
    public static final String TAG_SUBJECT_LOCATION = "SubjectLocation";
    public static final String TAG_SUBSEC_TIME = "SubSecTime";
    public static final String TAG_SUBSEC_TIME_DIGITIZED = "SubSecTimeDigitized";
    public static final String TAG_SUBSEC_TIME_ORIGINAL = "SubSecTimeOriginal";
    private static final String TAG_SUB_IFD_POINTER = "SubIFDPointer";
    public static final String TAG_THUMBNAIL_IMAGE_LENGTH = "ThumbnailImageLength";
    public static final String TAG_THUMBNAIL_IMAGE_WIDTH = "ThumbnailImageWidth";
    public static final String TAG_THUMBNAIL_ORIENTATION = "ThumbnailOrientation";
    public static final String TAG_TRANSFER_FUNCTION = "TransferFunction";
    public static final String TAG_USER_COMMENT = "UserComment";
    public static final String TAG_WHITE_BALANCE = "WhiteBalance";
    public static final String TAG_WHITE_POINT = "WhitePoint";
    public static final String TAG_XMP = "Xmp";
    public static final String TAG_X_RESOLUTION = "XResolution";
    public static final String TAG_Y_CB_CR_COEFFICIENTS = "YCbCrCoefficients";
    public static final String TAG_Y_CB_CR_POSITIONING = "YCbCrPositioning";
    public static final String TAG_Y_CB_CR_SUB_SAMPLING = "YCbCrSubSampling";
    public static final String TAG_Y_RESOLUTION = "YResolution";
    private static final int WEBP_CHUNK_SIZE_BYTE_LENGTH = 4;
    private static final byte[] WEBP_CHUNK_TYPE_ANIM;
    private static final byte[] WEBP_CHUNK_TYPE_ANMF;
    private static final int WEBP_CHUNK_TYPE_BYTE_LENGTH = 4;
    private static final byte[] WEBP_CHUNK_TYPE_EXIF;
    private static final byte[] WEBP_CHUNK_TYPE_VP8;
    private static final byte[] WEBP_CHUNK_TYPE_VP8L;
    private static final byte[] WEBP_CHUNK_TYPE_VP8X;
    private static final int WEBP_CHUNK_TYPE_VP8X_DEFAULT_LENGTH = 10;
    private static final int WEBP_FILE_SIZE_BYTE_LENGTH = 4;
    private static final byte[] WEBP_SIGNATURE_1;
    private static final byte[] WEBP_SIGNATURE_2;
    private static final byte WEBP_VP8L_SIGNATURE = 47;
    private static final byte[] WEBP_VP8_SIGNATURE;
    public static final int WHITEBALANCE_AUTO = 0;
    public static final int WHITEBALANCE_MANUAL = 1;
    public static final short WHITE_BALANCE_AUTO = 0;
    public static final short WHITE_BALANCE_MANUAL = 1;
    public static final short Y_CB_CR_POSITIONING_CENTERED = 1;
    public static final short Y_CB_CR_POSITIONING_CO_SITED = 2;
    private static final HashMap sExifPointerTagMap;
    private static final HashMap[] sExifTagMapsForReading;
    private static final HashMap[] sExifTagMapsForWriting;
    private static SimpleDateFormat sFormatterPrimary;
    private static SimpleDateFormat sFormatterSecondary;
    private static final HashSet sTagSetForCompatibility;
    private boolean mAreThumbnailStripsConsecutive;
    private AssetManager.AssetInputStream mAssetInputStream;
    private final HashMap[] mAttributes;
    private Set mAttributesOffsets;
    private ByteOrder mExifByteOrder;
    private String mFilename;
    private boolean mHasThumbnail;
    private boolean mHasThumbnailStrips;
    private boolean mIsExifDataOnly;
    private int mMimeType;
    private boolean mModified;
    private int mOffsetToExifData;
    private int mOrfMakerNoteOffset;
    private int mOrfThumbnailLength;
    private int mOrfThumbnailOffset;
    private FileDescriptor mSeekableFileDescriptor;
    private byte[] mThumbnailBytes;
    private int mThumbnailCompression;
    private int mThumbnailLength;
    private int mThumbnailOffset;
    private boolean mXmpIsFromSeparateMarker;

    static {
        Object object;
        Object object2;
        Integer n10;
        Integer n11;
        Integer n12;
        int n13 = 3;
        Serializable serializable = n13;
        DEBUG = Log.isLoggable((String)TAG, (int)n13);
        int n14 = 4;
        Object object3 = new Integer[n14];
        int n15 = 1;
        object3[0] = n12 = Integer.valueOf(n15);
        int n16 = 6;
        ExifInterface$ExifTag[] exifInterface$ExifTagArray = n16;
        object3[n15] = exifInterface$ExifTagArray;
        int n17 = 2;
        Integer n18 = n17;
        object3[n17] = serializable;
        int n19 = 8;
        Object object4 = n19;
        object3[n13] = object4;
        ROTATION_ORDER = Arrays.asList(object3);
        object3 = new Integer[n14];
        object3[0] = n18;
        object3[n15] = n11 = Integer.valueOf(7);
        ExifInterface$ExifTag[] exifInterface$ExifTagArray2 = Integer.valueOf(n14);
        object3[n17] = exifInterface$ExifTagArray2;
        int n20 = 5;
        object3[n13] = n10 = Integer.valueOf(n20);
        FLIPPED_ROTATION_ORDER = Arrays.asList(object3);
        Object[] objectArray = object3 = (Object)new int[n13];
        object3[0] = 8;
        objectArray[1] = 8;
        objectArray[2] = 8;
        BITS_PER_SAMPLE_RGB = object3;
        object3 = new int[n15];
        object3[0] = n14;
        BITS_PER_SAMPLE_GREYSCALE_1 = object3;
        object3 = new int[n15];
        object3[0] = n19;
        BITS_PER_SAMPLE_GREYSCALE_2 = object3;
        Object[] objectArray2 = object3 = (Object)new byte[n13];
        object3[0] = -1;
        objectArray2[1] = -40;
        objectArray2[2] = -1;
        JPEG_SIGNATURE = (byte[])object3;
        Object[] objectArray3 = object3 = (Object)new byte[n14];
        Object[] objectArray4 = object3;
        objectArray3[0] = 102;
        objectArray4[1] = 116;
        objectArray3[2] = 121;
        objectArray4[3] = 112;
        HEIF_TYPE_FTYP = (byte[])object3;
        Object[] objectArray5 = object3 = (Object)new byte[n14];
        Object[] objectArray6 = object3;
        objectArray5[0] = 109;
        objectArray6[1] = 105;
        objectArray5[2] = 102;
        objectArray6[3] = 49;
        HEIF_BRAND_MIF1 = (byte[])object3;
        Object[] objectArray7 = object3 = (Object)new byte[n14];
        Object[] objectArray8 = object3;
        objectArray7[0] = 104;
        objectArray8[1] = 101;
        objectArray7[2] = 105;
        objectArray8[3] = 99;
        HEIF_BRAND_HEIC = (byte[])object3;
        Object[] objectArray9 = object3 = (Object)new byte[n16];
        Object[] objectArray10 = object3;
        objectArray9[0] = 79;
        objectArray10[1] = 76;
        objectArray9[2] = 89;
        objectArray10[3] = 77;
        objectArray9[4] = 80;
        objectArray10[5] = (Integer)false;
        ORF_MAKER_NOTE_HEADER_1 = (byte[])object3;
        byte[] byArray = object2 = new byte[10];
        byte[] byArray2 = object2;
        byArray[0] = 79;
        byArray2[1] = 76;
        byArray[2] = 89;
        byArray2[3] = 77;
        byArray[4] = 80;
        byArray2[5] = 85;
        byArray[6] = 83;
        byArray2[7] = 0;
        byArray[8] = 73;
        byArray2[9] = 73;
        ORF_MAKER_NOTE_HEADER_2 = object2;
        byte[] byArray3 = object2 = new byte[n19];
        byte[] byArray4 = object2;
        byArray3[0] = -119;
        byArray4[1] = 80;
        byArray3[2] = 78;
        byArray4[3] = 71;
        byArray3[4] = 13;
        byArray4[5] = 10;
        byArray3[6] = 26;
        byArray4[7] = 10;
        PNG_SIGNATURE = object2;
        byte[] byArray5 = object2 = new byte[n14];
        byte[] byArray6 = object2;
        byArray5[0] = 101;
        byArray6[1] = 88;
        byArray5[2] = 73;
        byArray6[3] = 102;
        PNG_CHUNK_TYPE_EXIF = object2;
        byte[] byArray7 = object2 = new byte[n14];
        byte[] byArray8 = object2;
        byArray7[0] = 73;
        byArray8[1] = 72;
        byArray7[2] = 68;
        byArray8[3] = 82;
        PNG_CHUNK_TYPE_IHDR = object2;
        byte[] byArray9 = object2 = new byte[n14];
        byte[] byArray10 = object2;
        byArray9[0] = 73;
        byArray10[1] = 69;
        byArray9[2] = 78;
        byArray10[3] = 68;
        PNG_CHUNK_TYPE_IEND = object2;
        byte[] byArray11 = object2 = new byte[n14];
        byte[] byArray12 = object2;
        byArray11[0] = 82;
        byArray12[1] = 73;
        byArray11[2] = 70;
        byArray12[3] = 70;
        WEBP_SIGNATURE_1 = object2;
        byte[] byArray13 = object2 = new byte[n14];
        byte[] byArray14 = object2;
        byArray13[0] = 87;
        byArray14[1] = 69;
        byArray13[2] = 66;
        byArray14[3] = 80;
        WEBP_SIGNATURE_2 = object2;
        byte[] byArray15 = object2 = new byte[n14];
        byte[] byArray16 = object2;
        byArray15[0] = 69;
        byArray16[1] = 88;
        byArray15[2] = 73;
        byArray16[3] = 70;
        WEBP_CHUNK_TYPE_EXIF = object2;
        byte[] byArray17 = object2 = new byte[n13];
        object2[0] = -99;
        byArray17[1] = 1;
        byArray17[2] = 42;
        WEBP_VP8_SIGNATURE = object2;
        object2 = Charset.defaultCharset();
        WEBP_CHUNK_TYPE_VP8X = "VP8X".getBytes((Charset)object2);
        object3 = Charset.defaultCharset();
        WEBP_CHUNK_TYPE_VP8L = "VP8L".getBytes((Charset)object3);
        object3 = Charset.defaultCharset();
        WEBP_CHUNK_TYPE_VP8 = "VP8 ".getBytes((Charset)object3);
        object3 = Charset.defaultCharset();
        WEBP_CHUNK_TYPE_ANIM = "ANIM".getBytes((Charset)object3);
        object3 = Charset.defaultCharset();
        WEBP_CHUNK_TYPE_ANMF = "ANMF".getBytes((Charset)object3);
        String string2 = "BYTE";
        String string3 = "STRING";
        String string4 = "USHORT";
        String string5 = "SBYTE";
        String string6 = "UNDEFINED";
        String string7 = "SSHORT";
        String string8 = "SLONG";
        String string9 = "SRATIONAL";
        String string10 = "SINGLE";
        String string11 = "DOUBLE";
        String string12 = "IFD";
        IFD_FORMAT_NAMES = new String[]{"", string2, string3, string4, "ULONG", "URATIONAL", string5, string6, string7, string8, string9, string10, string11, string12};
        Object object5 = object2 = (Object)new int[14];
        Object object6 = object2;
        object5[0] = 0;
        object6[1] = 1;
        object5[2] = 1;
        object6[3] = 2;
        object5[4] = 4;
        object6[5] = 8;
        object5[6] = 1;
        object6[7] = 1;
        object5[8] = 2;
        object6[9] = 4;
        object5[10] = 8;
        object6[11] = 4;
        object5[12] = 8;
        object6[13] = 1;
        IFD_FORMAT_BYTES_PER_FORMAT = object2;
        Object object7 = object2 = new byte[n19];
        Object object8 = object2;
        object7[0] = 65;
        object8[1] = 83;
        object7[2] = 67;
        object8[3] = 73;
        object7[4] = 73;
        object8[5] = 0;
        object7[6] = 0;
        object8[7] = 0;
        EXIF_ASCII_PREFIX = object2;
        int n21 = 42;
        object2 = new ExifInterface$ExifTag[n21];
        object3 = new ExifInterface$ExifTag(TAG_NEW_SUBFILE_TYPE, 254, n14);
        object2[0] = (byte)object3;
        object3 = new ExifInterface$ExifTag(TAG_SUBFILE_TYPE, 255, n14);
        object2[n15] = (byte)object3;
        object3 = new ExifInterface$ExifTag(TAG_IMAGE_WIDTH, 256, n13, n14);
        object2[n17] = (byte)object3;
        object3 = new ExifInterface$ExifTag(TAG_IMAGE_LENGTH, 257, n13, n14);
        object2[n13] = (byte)object3;
        object3 = new ExifInterface$ExifTag(TAG_BITS_PER_SAMPLE, 258, n13);
        object2[n14] = (byte)object3;
        object3 = new ExifInterface$ExifTag(TAG_COMPRESSION, 259, n13);
        object2[n20] = (byte)object3;
        object3 = new ExifInterface$ExifTag(TAG_PHOTOMETRIC_INTERPRETATION, 262, n13);
        object2[6] = (byte)object3;
        object3 = new ExifInterface$ExifTag(TAG_IMAGE_DESCRIPTION, 270, n17);
        object2[7] = (byte)object3;
        object3 = new ExifInterface$ExifTag(TAG_MAKE, 271, n17);
        object2[8] = (byte)object3;
        object3 = new ExifInterface$ExifTag(TAG_MODEL, 272, n17);
        object2[9] = (byte)object3;
        object3 = new ExifInterface$ExifTag(TAG_STRIP_OFFSETS, 273, n13, n14);
        object2[10] = (byte)object3;
        object3 = new ExifInterface$ExifTag(TAG_ORIENTATION, 274, n13);
        object2[11] = (byte)object3;
        object3 = new ExifInterface$ExifTag(TAG_SAMPLES_PER_PIXEL, 277, n13);
        object2[12] = (byte)object3;
        object3 = new ExifInterface$ExifTag(TAG_ROWS_PER_STRIP, 278, n13, n14);
        object2[13] = (byte)object3;
        object3 = new ExifInterface$ExifTag(TAG_STRIP_BYTE_COUNTS, 279, n13, n14);
        object2[14] = (byte)object3;
        object3 = new ExifInterface$ExifTag(TAG_X_RESOLUTION, 282, n20);
        object2[15] = (byte)object3;
        object3 = new ExifInterface$ExifTag(TAG_Y_RESOLUTION, 283, n20);
        object2[16] = (byte)object3;
        object3 = new ExifInterface$ExifTag(TAG_PLANAR_CONFIGURATION, 284, n13);
        object2[17] = (byte)object3;
        object3 = new ExifInterface$ExifTag(TAG_RESOLUTION_UNIT, 296, n13);
        object2[18] = (byte)object3;
        object3 = new ExifInterface$ExifTag(TAG_TRANSFER_FUNCTION, 301, n13);
        object2[19] = (byte)object3;
        object3 = new ExifInterface$ExifTag(TAG_SOFTWARE, 305, n17);
        object2[20] = (byte)object3;
        object3 = new ExifInterface$ExifTag(TAG_DATETIME, 306, n17);
        object2[21] = (byte)object3;
        object3 = new ExifInterface$ExifTag(TAG_ARTIST, 315, n17);
        object2[22] = (byte)object3;
        object3 = new ExifInterface$ExifTag(TAG_WHITE_POINT, 318, n20);
        n16 = 23;
        object2[n16] = (byte)object3;
        object3 = new ExifInterface$ExifTag(TAG_PRIMARY_CHROMATICITIES, 319, n20);
        object2[24] = (byte)object3;
        object3 = new ExifInterface$ExifTag(TAG_SUB_IFD_POINTER, 330, n14);
        object2[25] = (byte)object3;
        object3 = new ExifInterface$ExifTag(TAG_JPEG_INTERCHANGE_FORMAT, 513, n14);
        object2[26] = (byte)object3;
        object3 = new ExifInterface$ExifTag(TAG_JPEG_INTERCHANGE_FORMAT_LENGTH, 514, n14);
        object2[27] = (byte)object3;
        object3 = new ExifInterface$ExifTag(TAG_Y_CB_CR_COEFFICIENTS, 529, n20);
        object2[28] = (byte)object3;
        object3 = new ExifInterface$ExifTag(TAG_Y_CB_CR_SUB_SAMPLING, 530, n13);
        object2[29] = (byte)object3;
        object3 = new ExifInterface$ExifTag(TAG_Y_CB_CR_POSITIONING, 531, n13);
        object2[30] = (byte)object3;
        object3 = new ExifInterface$ExifTag(TAG_REFERENCE_BLACK_WHITE, 532, n20);
        object2[31] = (byte)object3;
        object3 = new ExifInterface$ExifTag(TAG_COPYRIGHT, 33432, n17);
        object2[32] = (byte)object3;
        object3 = new ExifInterface$ExifTag(TAG_EXIF_IFD_POINTER, 34665, n14);
        object2[33] = (byte)object3;
        object3 = new ExifInterface$ExifTag(TAG_GPS_INFO_IFD_POINTER, 34853, n14);
        object2[34] = (byte)object3;
        object3 = new ExifInterface$ExifTag(TAG_RW2_SENSOR_TOP_BORDER, n14, n14);
        object2[35] = (byte)object3;
        object3 = new ExifInterface$ExifTag(TAG_RW2_SENSOR_LEFT_BORDER, n20, n14);
        object2[36] = (byte)object3;
        object3 = new ExifInterface$ExifTag(TAG_RW2_SENSOR_BOTTOM_BORDER, 6, n14);
        object2[37] = (byte)object3;
        n19 = 7;
        object3 = new ExifInterface$ExifTag(TAG_RW2_SENSOR_RIGHT_BORDER, n19, n14);
        object2[38] = (byte)object3;
        object3 = new ExifInterface$ExifTag(TAG_RW2_ISO, n16, n13);
        object2[39] = (byte)object3;
        object3 = new ExifInterface$ExifTag(TAG_RW2_JPG_FROM_RAW, 46, n19);
        object2[40] = (byte)object3;
        object3 = new ExifInterface$ExifTag(TAG_XMP, 700, n15);
        object2[41] = (byte)object3;
        IFD_TIFF_TAGS = (ExifInterface$ExifTag[])object2;
        object3 = new ExifInterface$ExifTag[74];
        Object object9 = new ExifInterface$ExifTag(TAG_EXPOSURE_TIME, 33434, n20);
        object3[0] = object9;
        object9 = new ExifInterface$ExifTag(TAG_F_NUMBER, 33437, n20);
        object3[n15] = object9;
        object9 = new ExifInterface$ExifTag(TAG_EXPOSURE_PROGRAM, 34850, n13);
        object3[n17] = object9;
        object9 = new ExifInterface$ExifTag(TAG_SPECTRAL_SENSITIVITY, 34852, n17);
        object3[n13] = object9;
        object9 = new ExifInterface$ExifTag(TAG_PHOTOGRAPHIC_SENSITIVITY, 34855, n13);
        object3[n14] = object9;
        n15 = 7;
        object9 = new ExifInterface$ExifTag(TAG_OECF, 34856, n15);
        object3[n20] = object9;
        object9 = new ExifInterface$ExifTag(TAG_SENSITIVITY_TYPE, 34864, n13);
        object3[6] = object9;
        object9 = new ExifInterface$ExifTag(TAG_STANDARD_OUTPUT_SENSITIVITY, 34865, n14);
        object3[n15] = object9;
        object3[8] = object = new ExifInterface$ExifTag(TAG_RECOMMENDED_EXPOSURE_INDEX, 34866, n14);
        object3[9] = object = new ExifInterface$ExifTag(TAG_ISO_SPEED, 34867, n14);
        object3[10] = object = new ExifInterface$ExifTag(TAG_ISO_SPEED_LATITUDE_YYY, 34868, n14);
        object3[11] = object = new ExifInterface$ExifTag(TAG_ISO_SPEED_LATITUDE_ZZZ, 34869, n14);
        object3[12] = object = new ExifInterface$ExifTag(TAG_EXIF_VERSION, 36864, n17);
        object3[13] = object = new ExifInterface$ExifTag(TAG_DATETIME_ORIGINAL, 36867, n17);
        object3[14] = object = new ExifInterface$ExifTag(TAG_DATETIME_DIGITIZED, 36868, n17);
        object3[15] = object = new ExifInterface$ExifTag(TAG_OFFSET_TIME, 36880, n17);
        object3[16] = object = new ExifInterface$ExifTag(TAG_OFFSET_TIME_ORIGINAL, 36881, n17);
        object3[17] = object = new ExifInterface$ExifTag(TAG_OFFSET_TIME_DIGITIZED, 36882, n17);
        object3[18] = object = new ExifInterface$ExifTag(TAG_COMPONENTS_CONFIGURATION, 37121, 7);
        object3[19] = object = new ExifInterface$ExifTag(TAG_COMPRESSED_BITS_PER_PIXEL, 37122, n20);
        n19 = 10;
        object3[20] = object = new ExifInterface$ExifTag(TAG_SHUTTER_SPEED_VALUE, 37377, n19);
        object3[21] = object = new ExifInterface$ExifTag(TAG_APERTURE_VALUE, 37378, n20);
        object3[22] = object = new ExifInterface$ExifTag(TAG_BRIGHTNESS_VALUE, 37379, n19);
        object3[23] = object = new ExifInterface$ExifTag(TAG_EXPOSURE_BIAS_VALUE, 37380, n19);
        object3[24] = object = new ExifInterface$ExifTag(TAG_MAX_APERTURE_VALUE, 37381, n20);
        object3[25] = object = new ExifInterface$ExifTag(TAG_SUBJECT_DISTANCE, 37382, n20);
        object3[26] = object = new ExifInterface$ExifTag(TAG_METERING_MODE, 37383, n13);
        object3[27] = object = new ExifInterface$ExifTag(TAG_LIGHT_SOURCE, 37384, n13);
        object3[28] = object = new ExifInterface$ExifTag(TAG_FLASH, 37385, n13);
        object3[29] = object = new ExifInterface$ExifTag(TAG_FOCAL_LENGTH, 37386, n20);
        object3[30] = object = new ExifInterface$ExifTag(TAG_SUBJECT_AREA, 37396, n13);
        n19 = 7;
        object3[31] = object = new ExifInterface$ExifTag(TAG_MAKER_NOTE, 37500, n19);
        object3[32] = object = new ExifInterface$ExifTag(TAG_USER_COMMENT, 37510, n19);
        object3[33] = object = new ExifInterface$ExifTag(TAG_SUBSEC_TIME, 37520, n17);
        object3[34] = object = new ExifInterface$ExifTag(TAG_SUBSEC_TIME_ORIGINAL, 37521, n17);
        object3[35] = object = new ExifInterface$ExifTag(TAG_SUBSEC_TIME_DIGITIZED, 37522, n17);
        object3[36] = object = new ExifInterface$ExifTag(TAG_FLASHPIX_VERSION, 40960, 7);
        object3[37] = object = new ExifInterface$ExifTag(TAG_COLOR_SPACE, 40961, n13);
        object3[38] = object = new ExifInterface$ExifTag(TAG_PIXEL_X_DIMENSION, 40962, n13, n14);
        object3[39] = object = new ExifInterface$ExifTag(TAG_PIXEL_Y_DIMENSION, 40963, n13, n14);
        object3[40] = object = new ExifInterface$ExifTag(TAG_RELATED_SOUND_FILE, 40964, n17);
        object3[41] = object = new ExifInterface$ExifTag(TAG_INTEROPERABILITY_IFD_POINTER, 40965, n14);
        object3[42] = object = new ExifInterface$ExifTag(TAG_FLASH_ENERGY, 41483, n20);
        object3[43] = object = new ExifInterface$ExifTag(TAG_SPATIAL_FREQUENCY_RESPONSE, 41484, 7);
        object3[44] = object = new ExifInterface$ExifTag(TAG_FOCAL_PLANE_X_RESOLUTION, 41486, n20);
        object3[45] = object = new ExifInterface$ExifTag(TAG_FOCAL_PLANE_Y_RESOLUTION, 41487, n20);
        object3[46] = object = new ExifInterface$ExifTag(TAG_FOCAL_PLANE_RESOLUTION_UNIT, 41488, n13);
        object3[47] = object = new ExifInterface$ExifTag(TAG_SUBJECT_LOCATION, 41492, n13);
        object3[48] = object = new ExifInterface$ExifTag(TAG_EXPOSURE_INDEX, 41493, n20);
        object3[49] = object = new ExifInterface$ExifTag(TAG_SENSING_METHOD, 41495, n13);
        n19 = 7;
        object3[50] = object = new ExifInterface$ExifTag(TAG_FILE_SOURCE, 41728, n19);
        object3[51] = object = new ExifInterface$ExifTag(TAG_SCENE_TYPE, 41729, n19);
        object3[52] = object = new ExifInterface$ExifTag(TAG_CFA_PATTERN, 41730, n19);
        object3[53] = object = new ExifInterface$ExifTag(TAG_CUSTOM_RENDERED, 41985, n13);
        object3[54] = object = new ExifInterface$ExifTag(TAG_EXPOSURE_MODE, 41986, n13);
        object3[55] = object = new ExifInterface$ExifTag(TAG_WHITE_BALANCE, 41987, n13);
        object3[56] = object = new ExifInterface$ExifTag(TAG_DIGITAL_ZOOM_RATIO, 41988, n20);
        object3[57] = object = new ExifInterface$ExifTag(TAG_FOCAL_LENGTH_IN_35MM_FILM, 41989, n13);
        object3[58] = object = new ExifInterface$ExifTag(TAG_SCENE_CAPTURE_TYPE, 41990, n13);
        object3[59] = object = new ExifInterface$ExifTag(TAG_GAIN_CONTROL, 41991, n13);
        object3[60] = object = new ExifInterface$ExifTag(TAG_CONTRAST, 41992, n13);
        object3[61] = object = new ExifInterface$ExifTag(TAG_SATURATION, 41993, n13);
        object3[62] = object = new ExifInterface$ExifTag(TAG_SHARPNESS, 41994, n13);
        object3[63] = object = new ExifInterface$ExifTag(TAG_DEVICE_SETTING_DESCRIPTION, 41995, 7);
        object3[64] = object = new ExifInterface$ExifTag(TAG_SUBJECT_DISTANCE_RANGE, 41996, n13);
        object3[65] = object = new ExifInterface$ExifTag(TAG_IMAGE_UNIQUE_ID, 42016, n17);
        object3[66] = object = new ExifInterface$ExifTag("CameraOwnerName", 42032, n17);
        object3[67] = object = new ExifInterface$ExifTag(TAG_BODY_SERIAL_NUMBER, 42033, n17);
        object3[68] = object = new ExifInterface$ExifTag(TAG_LENS_SPECIFICATION, 42034, n20);
        object3[69] = object = new ExifInterface$ExifTag(TAG_LENS_MAKE, 42035, n17);
        object3[70] = object = new ExifInterface$ExifTag(TAG_LENS_MODEL, 42036, n17);
        object3[71] = object = new ExifInterface$ExifTag(TAG_GAMMA, 42240, n20);
        object3[72] = object = new ExifInterface$ExifTag(TAG_DNG_VERSION, 50706, 1);
        object3[73] = object = new ExifInterface$ExifTag(TAG_DEFAULT_CROP_SIZE, 50720, n13, n14);
        IFD_EXIF_TAGS = object3;
        object = new ExifInterface$ExifTag[32];
        n14 = 1;
        object9 = new ExifInterface$ExifTag(TAG_GPS_VERSION_ID, 0, n14);
        object[0] = object9;
        object9 = new ExifInterface$ExifTag(TAG_GPS_LATITUDE_REF, n14, n17);
        object[n14] = object9;
        n16 = 10;
        Object object10 = new ExifInterface$ExifTag(TAG_GPS_LATITUDE, n17, n20, n16);
        object[n17] = object10;
        object10 = new ExifInterface$ExifTag(TAG_GPS_LONGITUDE_REF, n13, n17);
        object[n13] = object10;
        n19 = 4;
        object10 = new ExifInterface$ExifTag(TAG_GPS_LONGITUDE, n19, n20, n16);
        object[n19] = object10;
        object10 = new ExifInterface$ExifTag(TAG_GPS_ALTITUDE_REF, n20, 1);
        object[n20] = object10;
        n16 = 6;
        object10 = new ExifInterface$ExifTag(TAG_GPS_ALTITUDE, n16, n20);
        object[n16] = object10;
        n16 = 7;
        object10 = new ExifInterface$ExifTag(TAG_GPS_TIMESTAMP, n16, n20);
        object[n16] = object10;
        n16 = 8;
        object10 = new ExifInterface$ExifTag(TAG_GPS_SATELLITES, n16, n17);
        object[n16] = object10;
        n16 = 9;
        object10 = new ExifInterface$ExifTag(TAG_GPS_STATUS, n16, n17);
        object[n16] = object10;
        n16 = 10;
        object10 = new ExifInterface$ExifTag(TAG_GPS_MEASURE_MODE, n16, n17);
        object[n16] = object10;
        n16 = 11;
        object10 = new ExifInterface$ExifTag(TAG_GPS_DOP, n16, n20);
        object[n16] = object10;
        n16 = 12;
        object10 = new ExifInterface$ExifTag(TAG_GPS_SPEED_REF, n16, n17);
        object[n16] = object10;
        n16 = 13;
        object10 = new ExifInterface$ExifTag(TAG_GPS_SPEED, n16, n20);
        object[n16] = object10;
        n16 = 14;
        object10 = new ExifInterface$ExifTag(TAG_GPS_TRACK_REF, n16, n17);
        object[n16] = object10;
        n16 = 15;
        object10 = new ExifInterface$ExifTag(TAG_GPS_TRACK, n16, n20);
        object[n16] = object10;
        n16 = 16;
        object10 = new ExifInterface$ExifTag(TAG_GPS_IMG_DIRECTION_REF, n16, n17);
        object[n16] = object10;
        n16 = 17;
        object10 = new ExifInterface$ExifTag(TAG_GPS_IMG_DIRECTION, n16, n20);
        object[n16] = object10;
        n16 = 18;
        object10 = new ExifInterface$ExifTag(TAG_GPS_MAP_DATUM, n16, n17);
        object[n16] = object10;
        n16 = 19;
        object10 = new ExifInterface$ExifTag(TAG_GPS_DEST_LATITUDE_REF, n16, n17);
        object[n16] = object10;
        n16 = 20;
        object10 = new ExifInterface$ExifTag(TAG_GPS_DEST_LATITUDE, n16, n20);
        object[n16] = object10;
        object10 = new ExifInterface$ExifTag(TAG_GPS_DEST_LONGITUDE_REF, 21, n17);
        object[21] = object10;
        object10 = new ExifInterface$ExifTag(TAG_GPS_DEST_LONGITUDE, 22, n20);
        object[22] = object10;
        n16 = 23;
        object10 = new ExifInterface$ExifTag(TAG_GPS_DEST_BEARING_REF, n16, n17);
        object[n16] = object10;
        object10 = new ExifInterface$ExifTag(TAG_GPS_DEST_BEARING, 24, n20);
        object[24] = object10;
        object10 = new ExifInterface$ExifTag(TAG_GPS_DEST_DISTANCE_REF, 25, n17);
        object[25] = object10;
        object10 = new ExifInterface$ExifTag(TAG_GPS_DEST_DISTANCE, 26, n20);
        object[26] = object10;
        n19 = 7;
        object10 = new ExifInterface$ExifTag(TAG_GPS_PROCESSING_METHOD, 27, n19);
        object[27] = object10;
        object10 = new ExifInterface$ExifTag(TAG_GPS_AREA_INFORMATION, 28, n19);
        object[28] = object10;
        object10 = new ExifInterface$ExifTag(TAG_GPS_DATESTAMP, 29, n17);
        object[29] = object10;
        object10 = new ExifInterface$ExifTag(TAG_GPS_DIFFERENTIAL, 30, n13);
        object[30] = object10;
        object10 = new ExifInterface$ExifTag(TAG_GPS_H_POSITIONING_ERROR, 31, n20);
        object[31] = object10;
        IFD_GPS_TAGS = object;
        n14 = 1;
        object9 = new ExifInterface$ExifTag[n14];
        ExifInterface$ExifTag[] exifInterface$ExifTagArray3 = new ExifInterface$ExifTag(TAG_INTEROPERABILITY_INDEX, n14, n17);
        object9[0] = exifInterface$ExifTagArray3;
        IFD_INTEROPERABILITY_TAGS = object9;
        exifInterface$ExifTagArray3 = new ExifInterface$ExifTag[37];
        n13 = 4;
        ExifInterface$ExifTag[][] exifInterface$ExifTagArrayArray = new ExifInterface$ExifTag(TAG_NEW_SUBFILE_TYPE, 254, n13);
        exifInterface$ExifTagArray3[0] = exifInterface$ExifTagArrayArray;
        object10 = new ExifInterface$ExifTag(TAG_SUBFILE_TYPE, 255, n13);
        exifInterface$ExifTagArray3[1] = object10;
        n20 = 3;
        object10 = new ExifInterface$ExifTag(TAG_THUMBNAIL_IMAGE_WIDTH, 256, n20, n13);
        exifInterface$ExifTagArray3[2] = object10;
        object10 = new ExifInterface$ExifTag(TAG_THUMBNAIL_IMAGE_LENGTH, 257, n20, n13);
        exifInterface$ExifTagArray3[n20] = object10;
        object10 = new ExifInterface$ExifTag(TAG_BITS_PER_SAMPLE, 258, n20);
        exifInterface$ExifTagArray3[n13] = object10;
        object10 = new ExifInterface$ExifTag(TAG_COMPRESSION, 259, n20);
        exifInterface$ExifTagArray3[5] = object10;
        object10 = new ExifInterface$ExifTag(TAG_PHOTOMETRIC_INTERPRETATION, 262, n20);
        exifInterface$ExifTagArray3[6] = object10;
        n19 = 2;
        object10 = new ExifInterface$ExifTag(TAG_IMAGE_DESCRIPTION, 270, n19);
        exifInterface$ExifTagArray3[7] = object10;
        object10 = new ExifInterface$ExifTag(TAG_MAKE, 271, n19);
        exifInterface$ExifTagArray3[8] = object10;
        object10 = new ExifInterface$ExifTag(TAG_MODEL, 272, n19);
        exifInterface$ExifTagArray3[9] = object10;
        n20 = 3;
        object10 = new ExifInterface$ExifTag(TAG_STRIP_OFFSETS, 273, n20, 4);
        exifInterface$ExifTagArray3[10] = object10;
        object10 = new ExifInterface$ExifTag(TAG_THUMBNAIL_ORIENTATION, 274, n20);
        exifInterface$ExifTagArray3[11] = object10;
        object10 = new ExifInterface$ExifTag(TAG_SAMPLES_PER_PIXEL, 277, n20);
        exifInterface$ExifTagArray3[12] = object10;
        n19 = 4;
        object10 = new ExifInterface$ExifTag(TAG_ROWS_PER_STRIP, 278, n20, n19);
        exifInterface$ExifTagArray3[13] = object10;
        object10 = new ExifInterface$ExifTag(TAG_STRIP_BYTE_COUNTS, 279, n20, n19);
        exifInterface$ExifTagArray3[14] = object10;
        n19 = 5;
        object10 = new ExifInterface$ExifTag(TAG_X_RESOLUTION, 282, n19);
        exifInterface$ExifTagArray3[15] = object10;
        object10 = new ExifInterface$ExifTag(TAG_Y_RESOLUTION, 283, n19);
        exifInterface$ExifTagArray3[16] = object10;
        n19 = 3;
        object10 = new ExifInterface$ExifTag(TAG_PLANAR_CONFIGURATION, 284, n19);
        exifInterface$ExifTagArray3[17] = object10;
        object10 = new ExifInterface$ExifTag(TAG_RESOLUTION_UNIT, 296, n19);
        exifInterface$ExifTagArray3[18] = object10;
        object10 = new ExifInterface$ExifTag(TAG_TRANSFER_FUNCTION, 301, n19);
        exifInterface$ExifTagArray3[19] = object10;
        n19 = 2;
        object10 = new ExifInterface$ExifTag(TAG_SOFTWARE, 305, n19);
        exifInterface$ExifTagArray3[20] = object10;
        object10 = new ExifInterface$ExifTag(TAG_DATETIME, 306, n19);
        exifInterface$ExifTagArray3[21] = object10;
        object10 = new ExifInterface$ExifTag(TAG_ARTIST, 315, n19);
        exifInterface$ExifTagArray3[22] = object10;
        n19 = 5;
        object10 = new ExifInterface$ExifTag(TAG_WHITE_POINT, 318, n19);
        exifInterface$ExifTagArray3[23] = object10;
        object10 = new ExifInterface$ExifTag(TAG_PRIMARY_CHROMATICITIES, 319, n19);
        exifInterface$ExifTagArray3[24] = object10;
        n19 = 4;
        object10 = new ExifInterface$ExifTag(TAG_SUB_IFD_POINTER, 330, n19);
        exifInterface$ExifTagArray3[25] = object10;
        object10 = new ExifInterface$ExifTag(TAG_JPEG_INTERCHANGE_FORMAT, 513, n19);
        exifInterface$ExifTagArray3[26] = object10;
        object10 = new ExifInterface$ExifTag(TAG_JPEG_INTERCHANGE_FORMAT_LENGTH, 514, n19);
        exifInterface$ExifTagArray3[27] = object10;
        object10 = new ExifInterface$ExifTag(TAG_Y_CB_CR_COEFFICIENTS, 529, 5);
        exifInterface$ExifTagArray3[28] = object10;
        n19 = 3;
        object10 = new ExifInterface$ExifTag(TAG_Y_CB_CR_SUB_SAMPLING, 530, n19);
        exifInterface$ExifTagArray3[29] = object10;
        object10 = new ExifInterface$ExifTag(TAG_Y_CB_CR_POSITIONING, 531, n19);
        exifInterface$ExifTagArray3[30] = object10;
        object10 = new ExifInterface$ExifTag(TAG_REFERENCE_BLACK_WHITE, 532, 5);
        exifInterface$ExifTagArray3[31] = object10;
        object10 = new ExifInterface$ExifTag(TAG_COPYRIGHT, 33432, 2);
        exifInterface$ExifTagArray3[32] = object10;
        n19 = 4;
        object10 = new ExifInterface$ExifTag(TAG_EXIF_IFD_POINTER, 34665, n19);
        exifInterface$ExifTagArray3[33] = object10;
        object10 = new ExifInterface$ExifTag(TAG_GPS_INFO_IFD_POINTER, 34853, n19);
        exifInterface$ExifTagArray3[34] = object10;
        object10 = new ExifInterface$ExifTag(TAG_DNG_VERSION, 50706, 1);
        exifInterface$ExifTagArray3[35] = object10;
        n20 = 3;
        object10 = new ExifInterface$ExifTag(TAG_DEFAULT_CROP_SIZE, 50720, n20, 4);
        n13 = 36;
        exifInterface$ExifTagArray3[n13] = object10;
        IFD_THUMBNAIL_TAGS = exifInterface$ExifTagArray3;
        object10 = new ExifInterface$ExifTag(TAG_STRIP_OFFSETS, 273, n20);
        TAG_RAF_IMAGE_SIZE = object10;
        object10 = new ExifInterface$ExifTag[n20];
        Object object11 = new ExifInterface$ExifTag(TAG_ORF_THUMBNAIL_IMAGE, 256, 7);
        object10[0] = object11;
        n20 = 4;
        object11 = new ExifInterface$ExifTag(TAG_ORF_CAMERA_SETTINGS_IFD_POINTER, 8224, n20);
        object10[1] = object11;
        object11 = new ExifInterface$ExifTag(TAG_ORF_IMAGE_PROCESSING_IFD_POINTER, 8256, n20);
        n17 = 2;
        object10[n17] = object11;
        ORF_MAKER_NOTE_TAGS = object10;
        object11 = new ExifInterface$ExifTag[n17];
        Integer n22 = object4;
        exifInterface$ExifTagArray = new ExifInterface$ExifTag(TAG_ORF_PREVIEW_IMAGE_START, 257, n20);
        object11[0] = exifInterface$ExifTagArray;
        exifInterface$ExifTagArray = new ExifInterface$ExifTag(TAG_ORF_PREVIEW_IMAGE_LENGTH, 258, n20);
        n19 = 1;
        object11[n19] = exifInterface$ExifTagArray;
        ORF_CAMERA_SETTINGS_TAGS = object11;
        exifInterface$ExifTagArray = new ExifInterface$ExifTag[n19];
        Integer n23 = n11;
        int n24 = 3;
        exifInterface$ExifTagArray[0] = object4 = new ExifInterface$ExifTag(TAG_ORF_ASPECT_FRAME, 4371, n24);
        ORF_IMAGE_PROCESSING_TAGS = exifInterface$ExifTagArray;
        int n25 = 1;
        exifInterface$ExifTagArray2 = new ExifInterface$ExifTag[n25];
        Integer n26 = serializable;
        exifInterface$ExifTagArray2[0] = object4 = new ExifInterface$ExifTag(TAG_COLOR_SPACE, 55, n24);
        PEF_TAGS = exifInterface$ExifTagArray2;
        n19 = 10;
        exifInterface$ExifTagArrayArray = new ExifInterface$ExifTag[n19][];
        exifInterface$ExifTagArrayArray[0] = (ExifInterface$ExifTag[])object2;
        exifInterface$ExifTagArrayArray[1] = object3;
        exifInterface$ExifTagArrayArray[2] = object;
        exifInterface$ExifTagArrayArray[n24] = object9;
        int n27 = 4;
        exifInterface$ExifTagArrayArray[n27] = exifInterface$ExifTagArray3;
        exifInterface$ExifTagArrayArray[5] = (ExifInterface$ExifTag[])object2;
        int n28 = 6;
        exifInterface$ExifTagArrayArray[n28] = object10;
        exifInterface$ExifTagArrayArray[7] = object11;
        exifInterface$ExifTagArrayArray[8] = exifInterface$ExifTagArray;
        exifInterface$ExifTagArrayArray[9] = exifInterface$ExifTagArray2;
        EXIF_TAGS = exifInterface$ExifTagArrayArray;
        object10 = new ExifInterface$ExifTag[n28];
        object10[0] = object11 = new ExifInterface$ExifTag(TAG_SUB_IFD_POINTER, 330, n27);
        object10[1] = object11 = new ExifInterface$ExifTag(TAG_EXIF_IFD_POINTER, 34665, n27);
        object10[2] = object11 = new ExifInterface$ExifTag(TAG_GPS_INFO_IFD_POINTER, 34853, n27);
        object10[3] = object11 = new ExifInterface$ExifTag(TAG_INTEROPERABILITY_IFD_POINTER, 40965, n27);
        int n29 = 1;
        object10[n27] = object11 = new ExifInterface$ExifTag(TAG_ORF_CAMERA_SETTINGS_IFD_POINTER, 8224, n29);
        n15 = 8256;
        object10[5] = object11 = new ExifInterface$ExifTag(TAG_ORF_IMAGE_PROCESSING_IFD_POINTER, n15, n29);
        EXIF_POINTER_TAGS = object10;
        object10 = new ExifInterface$ExifTag(TAG_JPEG_INTERCHANGE_FORMAT, 513, n27);
        JPEG_INTERCHANGE_FORMAT_TAG = object10;
        n28 = 514;
        object10 = new ExifInterface$ExifTag(TAG_JPEG_INTERCHANGE_FORMAT_LENGTH, n28, n27);
        JPEG_INTERCHANGE_FORMAT_LENGTH_TAG = object10;
        sExifTagMapsForReading = new HashMap[exifInterface$ExifTagArrayArray.length];
        n14 = exifInterface$ExifTagArrayArray.length;
        sExifTagMapsForWriting = new HashMap[n14];
        object3 = TAG_EXPOSURE_TIME;
        object = TAG_SUBJECT_DISTANCE;
        object9 = TAG_GPS_TIMESTAMP;
        object11 = Arrays.asList(TAG_F_NUMBER, TAG_DIGITAL_ZOOM_RATIO, object3, object, object9);
        object10 = new HashSet(object11);
        sTagSetForCompatibility = object10;
        object10 = new HashMap();
        sExifPointerTagMap = object10;
        object10 = Charset.forName("US-ASCII");
        ASCII = object10;
        IDENTIFIER_EXIF_APP1 = "Exif\u0000\u0000".getBytes((Charset)object10);
        IDENTIFIER_XMP_APP1 = "http://ns.adobe.com/xap/1.0/\u0000".getBytes((Charset)object10);
        object11 = Locale.US;
        sFormatterPrimary = object10 = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss", (Locale)object11);
        serializable = DesugarTimeZone.getTimeZone("UTC");
        ((DateFormat)object10).setTimeZone((TimeZone)serializable);
        serializable = "yyyy-MM-dd HH:mm:ss";
        sFormatterSecondary = object10 = new SimpleDateFormat((String)((Object)serializable), (Locale)object11);
        object11 = DesugarTimeZone.getTimeZone("UTC");
        ((DateFormat)object10).setTimeZone((TimeZone)object11);
        exifInterface$ExifTagArray3 = null;
        for (n16 = 0; n16 < (n13 = ((Object)(object10 = EXIF_TAGS)).length); ++n16) {
            object11 = sExifTagMapsForReading;
            serializable = new Serializable();
            object11[n16] = serializable;
            object11 = sExifTagMapsForWriting;
            serializable = new Serializable();
            object11[n16] = serializable;
            object10 = object10[n16];
            n13 = ((Object)object10).length;
            serializable = null;
            for (n27 = 0; n27 < n13; ++n27) {
                object3 = object10[n27];
                object = sExifTagMapsForReading[n16];
                n29 = object3.number;
                object9 = n29;
                ((HashMap)object).put(object9, object3);
                object = sExifTagMapsForWriting[n16];
                object9 = object3.name;
                ((HashMap)object).put(object9, object3);
            }
        }
        object10 = sExifPointerTagMap;
        object11 = EXIF_POINTER_TAGS;
        serializable = object11[0].number;
        ((HashMap)object10).put(serializable, n10);
        serializable = object11[1].number;
        ((HashMap)object10).put(serializable, n12);
        serializable = object11[2].number;
        ((HashMap)object10).put(serializable, n18);
        serializable = object11[3].number;
        object3 = n26;
        ((HashMap)object10).put(serializable, n26);
        serializable = object11[4].number;
        object3 = n23;
        ((HashMap)object10).put(serializable, n23);
        object11 = object11[5].number;
        serializable = n22;
        ((HashMap)object10).put(object11, n22);
        NON_ZERO_TIME_PATTERN = Pattern.compile(".*[1-9].*");
        GPS_TIMESTAMP_PATTERN = Pattern.compile("^(\\d{2}):(\\d{2}):(\\d{2})$");
        DATETIME_PRIMARY_FORMAT_PATTERN = Pattern.compile("^(\\d{4}):(\\d{2}):(\\d{2})\\s(\\d{2}):(\\d{2}):(\\d{2})$");
        DATETIME_SECONDARY_FORMAT_PATTERN = Pattern.compile("^(\\d{4})-(\\d{2})-(\\d{2})\\s(\\d{2}):(\\d{2}):(\\d{2})$");
    }

    public ExifInterface(File object) {
        Object object2 = EXIF_TAGS;
        Object object3 = new HashMap[((ExifInterface$ExifTag[][])object2).length];
        this.mAttributes = object3;
        int n10 = ((ExifInterface$ExifTag[][])object2).length;
        super(n10);
        this.mAttributesOffsets = object3;
        this.mExifByteOrder = object2 = ByteOrder.BIG_ENDIAN;
        Objects.requireNonNull(object, "file cannot be null");
        object = ((File)object).getAbsolutePath();
        this.initForFilename((String)object);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public ExifInterface(FileDescriptor fileDescriptor) {
        FileInputStream fileInputStream;
        boolean bl2;
        Object object;
        block10: {
            object = EXIF_TAGS;
            Object object2 = new HashMap[((ExifInterface$ExifTag[][])object).length];
            this.mAttributes = object2;
            int n10 = ((ExifInterface$ExifTag[][])object).length;
            super(n10);
            this.mAttributesOffsets = object2;
            this.mExifByteOrder = object = ByteOrder.BIG_ENDIAN;
            Objects.requireNonNull(fileDescriptor, "fileDescriptor cannot be null");
            n10 = 0;
            object = null;
            this.mAssetInputStream = null;
            this.mFilename = null;
            bl2 = false;
            object2 = null;
            int n11 = Build.VERSION.SDK_INT;
            int n12 = 21;
            if (n11 >= n12 && (n11 = (int)(ExifInterface.isSeekableFD(fileDescriptor) ? 1 : 0)) != 0) {
                this.mSeekableFileDescriptor = fileDescriptor;
                try {
                    fileDescriptor = Os.dup((FileDescriptor)fileDescriptor);
                    bl2 = true;
                }
                catch (Exception exception) {
                    super("Failed to duplicate file descriptor", exception);
                    throw object;
                }
            } else {
                this.mSeekableFileDescriptor = null;
            }
            try {
                fileInputStream = new FileInputStream(fileDescriptor);
            }
            catch (Throwable throwable) {
                n11 = 0;
                fileInputStream = null;
                object = throwable;
                break block10;
            }
            try {
                this.loadAttributes(fileInputStream);
            }
            catch (Throwable throwable) {
                break block10;
            }
            ExifInterface.closeQuietly(fileInputStream);
            if (bl2) {
                ExifInterface.closeFileDescriptor(fileDescriptor);
            }
            return;
        }
        ExifInterface.closeQuietly(fileInputStream);
        if (bl2) {
            ExifInterface.closeFileDescriptor(fileDescriptor);
        }
        throw object;
    }

    public ExifInterface(InputStream inputStream) {
        this(inputStream, 0);
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public ExifInterface(InputStream var1_1, int var2_2) {
        block6: {
            block7: {
                block5: {
                    super();
                    var3_3 /* !! */  = ExifInterface.EXIF_TAGS;
                    var4_4 /* !! */  = new HashMap[var3_3 /* !! */ .length];
                    this.mAttributes = var4_4 /* !! */ ;
                    var5_5 = var3_3 /* !! */ .length;
                    super(var5_5);
                    this.mAttributesOffsets = var4_4 /* !! */ ;
                    this.mExifByteOrder = var3_3 /* !! */  = ByteOrder.BIG_ENDIAN;
                    Objects.requireNonNull(var1_1, "inputStream cannot be null");
                    var5_5 = 0;
                    var3_3 /* !! */  = null;
                    this.mFilename = null;
                    var6_6 = 1;
                    if (var2_2 == var6_6) {
                        var2_2 = var6_6;
                    } else {
                        var2_2 = 0;
                        var7_7 = null;
                    }
                    if (var2_2 == 0) break block5;
                    var8_8 = 5000;
                    var7_7 = new BufferedInputStream(var1_1, var8_8);
                    var9_9 = ExifInterface.isExifDataOnly((BufferedInputStream)var7_7);
                    if (!var9_9) {
                        Log.w((String)"ExifInterface", (String)"Given data does not follow the structure of an Exif-only data.");
                        return;
                    }
                    this.mIsExifDataOnly = var6_6;
                    this.mAssetInputStream = null;
                    this.mSeekableFileDescriptor = null;
                    var1_1 = var7_7;
                    break block6;
                }
                var2_2 = var1_1 instanceof AssetManager.AssetInputStream;
                if (var2_2 == 0) break block7;
                var7_7 = var1_1;
                var7_7 = (AssetManager.AssetInputStream)var1_1;
                this.mAssetInputStream = var7_7;
                this.mSeekableFileDescriptor = null;
                break block6;
            }
            var2_2 = var1_1 instanceof FileInputStream;
            if (var2_2 == 0) ** GOTO lbl-1000
            var7_7 = var1_1;
            var7_7 = (FileInputStream)var1_1;
            var4_4 /* !! */  = var7_7.getFD();
            var6_6 = (int)ExifInterface.isSeekableFD((FileDescriptor)var4_4 /* !! */ );
            if (var6_6 != 0) {
                this.mAssetInputStream = null;
                this.mSeekableFileDescriptor = var7_7 = var7_7.getFD();
            } else lbl-1000:
            // 2 sources

            {
                this.mAssetInputStream = null;
                this.mSeekableFileDescriptor = null;
            }
        }
        this.loadAttributes(var1_1);
    }

    public ExifInterface(String string2) {
        Object object = EXIF_TAGS;
        Object object2 = new HashMap[((ExifInterface$ExifTag[][])object).length];
        this.mAttributes = object2;
        int n10 = ((ExifInterface$ExifTag[][])object).length;
        super(n10);
        this.mAttributesOffsets = object2;
        this.mExifByteOrder = object = ByteOrder.BIG_ENDIAN;
        Objects.requireNonNull(string2, "filename cannot be null");
        this.initForFilename(string2);
    }

    private void addDefaultValuesForCompatibility() {
        Object object;
        Object object2;
        Object object3;
        Object object4 = this.getAttribute(TAG_DATETIME_ORIGINAL);
        Object object5 = null;
        if (object4 != null && (object3 = this.getAttribute((String)(object2 = TAG_DATETIME))) == null) {
            object3 = this.mAttributes[0];
            object4 = ExifInterface$ExifAttribute.createString((String)object4);
            ((HashMap)object3).put(object2, object4);
        }
        object4 = TAG_IMAGE_WIDTH;
        object2 = this.getAttribute((String)object4);
        long l10 = 0L;
        if (object2 == null) {
            object2 = this.mAttributes[0];
            object = this.mExifByteOrder;
            object = ExifInterface$ExifAttribute.createULong(l10, (ByteOrder)object);
            ((HashMap)object2).put(object4, object);
        }
        if ((object2 = this.getAttribute((String)(object4 = TAG_IMAGE_LENGTH))) == null) {
            object2 = this.mAttributes[0];
            object = this.mExifByteOrder;
            object = ExifInterface$ExifAttribute.createULong(l10, (ByteOrder)object);
            ((HashMap)object2).put(object4, object);
        }
        if ((object2 = this.getAttribute((String)(object4 = TAG_ORIENTATION))) == null) {
            object5 = this.mAttributes[0];
            object2 = this.mExifByteOrder;
            object2 = ExifInterface$ExifAttribute.createULong(l10, (ByteOrder)object2);
            ((HashMap)object5).put(object4, object2);
        }
        if ((object5 = this.getAttribute((String)(object4 = TAG_LIGHT_SOURCE))) == null) {
            object5 = this.mAttributes;
            int n10 = 1;
            object5 = object5[n10];
            object2 = this.mExifByteOrder;
            object2 = ExifInterface$ExifAttribute.createULong(l10, (ByteOrder)object2);
            ((HashMap)object5).put(object4, object2);
        }
    }

    private static String byteArrayToHexString(byte[] byArray) {
        int n10;
        int n11 = byArray.length * 2;
        StringBuilder stringBuilder = new StringBuilder(n11);
        n11 = 0;
        for (int i10 = 0; i10 < (n10 = byArray.length); ++i10) {
            Object object;
            n10 = 1;
            Object object2 = new Object[n10];
            byte by2 = byArray[i10];
            object2[0] = object = Byte.valueOf(by2);
            object = "%02x";
            object2 = String.format((String)object, object2);
            stringBuilder.append((String)object2);
        }
        return stringBuilder.toString();
    }

    private static void closeFileDescriptor(FileDescriptor object) {
        int n10 = Build.VERSION.SDK_INT;
        String string2 = TAG;
        int n11 = 21;
        if (n10 >= n11) {
            try {
                Os.close((FileDescriptor)object);
            }
            catch (Exception exception) {
                object = "Error closing fd.";
                Log.e((String)string2, (String)object);
            }
        } else {
            object = "closeFileDescriptor is called in API < 21, which must be wrong.";
            Log.e((String)string2, (String)object);
        }
    }

    private static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            }
            catch (RuntimeException runtimeException) {
                throw runtimeException;
            }
            catch (Exception exception) {}
        }
    }

    private String convertDecimalDegree(double d10) {
        long l10 = (long)d10;
        double d11 = l10;
        d10 -= d11;
        d11 = 60.0;
        long l11 = (long)(d10 * d11);
        double d12 = (double)l11 / d11;
        long l12 = Math.round((d10 - d12) * 3600.0 * 1.0E7);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(l10);
        String string2 = "/1,";
        stringBuilder.append(string2);
        stringBuilder.append(l11);
        stringBuilder.append(string2);
        stringBuilder.append(l12);
        stringBuilder.append("/10000000");
        return stringBuilder.toString();
    }

    private static double convertRationalLatLonToDouble(String object, String string2) {
        double d10;
        block32: {
            block33: {
                Object object2 = "/";
                String string3 = ",";
                int n10 = -1;
                object = ((String)object).split(string3, n10);
                string3 = null;
                Object object3 = object[0];
                object3 = ((String)object3).split((String)object2, n10);
                String string4 = object3[0];
                string4 = string4.trim();
                d10 = Double.parseDouble(string4);
                int n11 = 1;
                object3 = object3[n11];
                object3 = ((String)object3).trim();
                double d11 = Double.parseDouble((String)object3);
                d10 /= d11;
                object3 = object[n11];
                object3 = ((String)object3).split((String)object2, n10);
                Object object4 = object3[0];
                object4 = ((String)object4).trim();
                d11 = Double.parseDouble((String)object4);
                object3 = object3[n11];
                object3 = ((String)object3).trim();
                double d12 = Double.parseDouble((String)object3);
                d11 /= d12;
                int n12 = 2;
                object = object[n12];
                object = ((String)object).split((String)object2, n10);
                object2 = object[0];
                object2 = ((String)object2).trim();
                double d13 = Double.parseDouble((String)object2);
                object = object[n11];
                object = ((String)object).trim();
                double d14 = Double.parseDouble((String)object);
                d13 /= d14;
                d10 += (d11 /= 60.0);
                d14 = 3600.0;
                d10 += (d13 /= d14);
                object = LATITUDE_SOUTH;
                boolean bl2 = string2.equals(object);
                if (bl2) break block32;
                object = LONGITUDE_WEST;
                bl2 = string2.equals(object);
                if (bl2) break block32;
                object = "N";
                bl2 = string2.equals(object);
                if (bl2) break block33;
                object = LONGITUDE_EAST;
                bl2 = string2.equals(object);
                if (bl2) break block33;
                try {
                    object = new IllegalArgumentException();
                    throw object;
                }
                catch (ArrayIndexOutOfBoundsException | NumberFormatException runtimeException) {
                    object = new IllegalArgumentException();
                    throw object;
                }
            }
            return d10;
        }
        return -d10;
    }

    private static long[] convertToLongArray(Object object) {
        int n10 = object instanceof int[];
        if (n10 != 0) {
            Object object2;
            object = (int[])object;
            n10 = ((Object)object).length;
            long[] lArray = new long[n10];
            for (int i10 = 0; i10 < (object2 = ((Object)object).length); ++i10) {
                long l10;
                object2 = object[i10];
                lArray[i10] = l10 = (long)object2;
            }
            return lArray;
        }
        n10 = object instanceof long[];
        if (n10 != 0) {
            return (long[])object;
        }
        return null;
    }

    private static int copy(InputStream inputStream, OutputStream outputStream) {
        int n10;
        int n11;
        int n12 = 8192;
        byte[] byArray = new byte[n12];
        int n13 = 0;
        while ((n11 = inputStream.read(byArray)) != (n10 = -1)) {
            n13 += n11;
            outputStream.write(byArray, 0, n11);
        }
        return n13;
    }

    private static void copy(InputStream object, OutputStream outputStream, int n10) {
        int n11 = 8192;
        byte[] byArray = new byte[n11];
        while (n10 > 0) {
            int n12 = Math.min(n10, n11);
            int n13 = ((InputStream)object).read(byArray, 0, n12);
            if (n13 == n12) {
                n10 -= n13;
                outputStream.write(byArray, 0, n13);
                continue;
            }
            object = new IOException("Failed to copy the given amount of bytes from the inputstream to the output stream.");
            throw object;
        }
    }

    private void copyChunksUpToGivenChunkType(ExifInterface$ByteOrderedDataInputStream object, ExifInterface$ByteOrderedDataOutputStream object2, byte[] object3, byte[] byArray) {
        Object object4;
        int n10;
        do {
            int n11;
            if ((n11 = ((InputStream)object).read((byte[])(object4 = new byte[n10 = 4]))) != n10) {
                object2 = new StringBuilder();
                ((StringBuilder)object2).append("Encountered invalid length while copying WebP chunks up tochunk type ");
                object4 = ASCII;
                String string2 = new String((byte[])object3, (Charset)object4);
                ((StringBuilder)object2).append(string2);
                if (byArray == null) {
                    object3 = "";
                } else {
                    object3 = new StringBuilder;
                    ((StringBuilder)object3)();
                    ((StringBuilder)object3).append(" or ");
                    string2 = new String(byArray, (Charset)object4);
                    ((StringBuilder)object3).append(string2);
                    object3 = ((StringBuilder)object3).toString();
                }
                ((StringBuilder)object2).append((String)object3);
                object2 = ((StringBuilder)object2).toString();
                object = new IOException((String)object2);
                throw object;
            }
            this.copyWebPChunk((ExifInterface$ByteOrderedDataInputStream)object, (ExifInterface$ByteOrderedDataOutputStream)object2, (byte[])object4);
            n10 = (int)(Arrays.equals(object4, (byte[])object3) ? 1 : 0);
        } while (n10 == 0 && (byArray == null || (n10 = (int)(Arrays.equals(object4, byArray) ? 1 : 0)) == 0));
    }

    private void copyWebPChunk(ExifInterface$ByteOrderedDataInputStream exifInterface$ByteOrderedDataInputStream, ExifInterface$ByteOrderedDataOutputStream exifInterface$ByteOrderedDataOutputStream, byte[] byArray) {
        int n10 = exifInterface$ByteOrderedDataInputStream.readInt();
        exifInterface$ByteOrderedDataOutputStream.write(byArray);
        exifInterface$ByteOrderedDataOutputStream.writeInt(n10);
        int n11 = n10 % 2;
        int n12 = 1;
        if (n11 == n12) {
            ++n10;
        }
        ExifInterface.copy(exifInterface$ByteOrderedDataInputStream, exifInterface$ByteOrderedDataOutputStream, n10);
    }

    private ExifInterface$ExifAttribute getExifAttribute(String string2) {
        Object object;
        int n10;
        Objects.requireNonNull(string2, "tag shouldn't be null");
        String string3 = TAG_ISO_SPEED_RATINGS;
        int n11 = string3.equals(string2);
        if (n11 != 0) {
            boolean bl2 = DEBUG;
            if (bl2) {
                string2 = TAG;
                string3 = "getExifAttribute: Replacing TAG_ISO_SPEED_RATINGS with TAG_PHOTOGRAPHIC_SENSITIVITY.";
                Log.d((String)string2, (String)string3);
            }
            string2 = TAG_PHOTOGRAPHIC_SENSITIVITY;
        }
        string3 = null;
        for (n11 = 0; n11 < (n10 = ((ExifInterface$ExifTag[][])(object = EXIF_TAGS)).length); ++n11) {
            object = (ExifInterface$ExifAttribute)this.mAttributes[n11].get(string2);
            if (object == null) continue;
            return object;
        }
        return null;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void getHeifAttributes(ExifInterface$ByteOrderedDataInputStream object) {
        String string2 = "yes";
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            int n10;
            int n11;
            int n12;
            Object object2;
            String string3;
            String string4;
            String string5;
            Object object3;
            int n13;
            int n14;
            block21: {
                int n15;
                Object object4;
                Object object5;
                block23: {
                    block22: {
                        int n16;
                        n14 = Build.VERSION.SDK_INT;
                        n13 = 23;
                        if (n14 >= n13) {
                            object3 = new ExifInterface$1(this, (ExifInterface$ByteOrderedDataInputStream)object);
                            mediaMetadataRetriever.setDataSource((MediaDataSource)object3);
                        } else {
                            object3 = this.mSeekableFileDescriptor;
                            if (object3 != null) {
                                mediaMetadataRetriever.setDataSource((FileDescriptor)object3);
                            } else {
                                object3 = this.mFilename;
                                if (object3 == null) return;
                                mediaMetadataRetriever.setDataSource((String)object3);
                            }
                        }
                        n14 = 33;
                        object3 = mediaMetadataRetriever.extractMetadata(n14);
                        n13 = 34;
                        string5 = mediaMetadataRetriever.extractMetadata(n13);
                        int n17 = 26;
                        string4 = mediaMetadataRetriever.extractMetadata(n17);
                        int n18 = 17;
                        String string6 = mediaMetadataRetriever.extractMetadata(n18);
                        n17 = (int)(string2.equals(string4) ? 1 : 0);
                        string3 = null;
                        if (n17 != 0) {
                            int n19 = 29;
                            string3 = mediaMetadataRetriever.extractMetadata(n19);
                            n19 = 30;
                            string2 = mediaMetadataRetriever.extractMetadata(n19);
                            n17 = 31;
                            string4 = mediaMetadataRetriever.extractMetadata(n17);
                        } else {
                            int n20 = string2.equals(string6);
                            if (n20 != 0) {
                                n20 = 18;
                                string3 = mediaMetadataRetriever.extractMetadata(n20);
                                n20 = 19;
                                string2 = mediaMetadataRetriever.extractMetadata(n20);
                                n17 = 24;
                                string4 = mediaMetadataRetriever.extractMetadata(n17);
                            } else {
                                n20 = 0;
                                string2 = null;
                                n17 = 0;
                                string4 = null;
                            }
                        }
                        n18 = 0;
                        string6 = null;
                        if (string3 != null) {
                            HashMap[] hashMapArray = this.mAttributes;
                            HashMap hashMap = hashMapArray[0];
                            object2 = TAG_IMAGE_WIDTH;
                            n12 = Integer.parseInt(string3);
                            object5 = this.mExifByteOrder;
                            object4 = ExifInterface$ExifAttribute.createUShort(n12, (ByteOrder)object5);
                            hashMap.put(object2, object4);
                        }
                        if (string2 != null) {
                            HashMap[] hashMapArray = this.mAttributes;
                            HashMap hashMap = hashMapArray[0];
                            object2 = TAG_IMAGE_LENGTH;
                            n12 = Integer.parseInt(string2);
                            object5 = this.mExifByteOrder;
                            object4 = ExifInterface$ExifAttribute.createUShort(n12, (ByteOrder)object5);
                            hashMap.put(object2, object4);
                        }
                        n11 = 6;
                        if (string4 == null) break block21;
                        n15 = 1;
                        n12 = Integer.parseInt(string4);
                        if (n12 == (n16 = 90)) break block22;
                        n16 = 180;
                        if (n12 != n16) {
                            n16 = 270;
                            if (n12 == n16) {
                                n15 = 8;
                            }
                            break block23;
                        } else {
                            n15 = 3;
                        }
                        break block23;
                    }
                    n15 = n11;
                }
                object4 = this.mAttributes;
                object4 = object4[0];
                object5 = TAG_ORIENTATION;
                ByteOrder byteOrder = this.mExifByteOrder;
                object2 = ExifInterface$ExifAttribute.createUShort(n15, byteOrder);
                ((HashMap)object4).put(object5, object2);
            }
            if (object3 != null && string5 != null) {
                n14 = Integer.parseInt((String)object3);
                n13 = Integer.parseInt(string5);
                if (n13 <= n11) {
                    string2 = "Invalid exif length";
                    object = new IOException(string2);
                    throw object;
                }
                long l10 = n14;
                ((ExifInterface$ByteOrderedDataInputStream)object).seek(l10);
                object2 = new byte[n11];
                n12 = ((InputStream)object).read((byte[])object2);
                if (n12 != n11) {
                    string2 = "Can't read identifier";
                    object = new IOException(string2);
                    throw object;
                }
                n14 += n11;
                n13 += -6;
                byte[] byArray = IDENTIFIER_EXIF_APP1;
                n11 = (int)(Arrays.equals((byte[])object2, byArray) ? 1 : 0);
                if (n11 == 0) {
                    string2 = "Invalid identifier";
                    object = new IOException(string2);
                    throw object;
                }
                byte[] byArray2 = new byte[n13];
                n10 = ((InputStream)object).read(byArray2);
                if (n10 != n13) {
                    string2 = "Can't read exif";
                    object = new IOException(string2);
                    throw object;
                }
                this.mOffsetToExifData = n14;
                this.readExifSegment(byArray2, 0);
            }
            if ((n10 = DEBUG) == 0) return;
            object = TAG;
            object3 = new StringBuilder();
            string5 = "Heif meta: ";
            ((StringBuilder)object3).append(string5);
            ((StringBuilder)object3).append(string3);
            string5 = "x";
            ((StringBuilder)object3).append(string5);
            ((StringBuilder)object3).append(string2);
            string2 = ", rotation ";
            ((StringBuilder)object3).append(string2);
            ((StringBuilder)object3).append(string4);
            string2 = ((StringBuilder)object3).toString();
            Log.d((String)object, (String)string2);
            return;
        }
        finally {
            mediaMetadataRetriever.release();
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     */
    private void getJpegAttributes(ExifInterface$ByteOrderedDataInputStream var1_1, int var2_2, int var3_3) {
        var4_4 = this;
        var5_5 = var1_1;
        var6_6 = var3_3;
        var7_7 = ExifInterface.DEBUG;
        var8_8 = "ExifInterface";
        if (var7_7 != 0) {
            var9_9 /* !! */  = new StringBuilder();
            var10_10 = "getJpegAttributes starting with: ";
            var9_9 /* !! */ .append((String)var10_10);
            var9_9 /* !! */ .append(var1_1);
            var9_9 /* !! */  = var9_9 /* !! */ .toString();
            Log.d((String)var8_8, (String)var9_9 /* !! */ );
        }
        var7_7 = 0;
        var9_9 /* !! */  = null;
        var5_5.mark(0);
        var10_10 = ByteOrder.BIG_ENDIAN;
        var5_5.setByteOrder((ByteOrder)var10_10);
        var11_11 = var1_1.readByte();
        var12_12 = "Invalid marker: ";
        var13_13 = -1;
        if (var11_11 != var13_13) {
            var35_36 /* !! */  = new StringBuilder();
            var35_36 /* !! */ .append((String)var12_12);
            var9_9 /* !! */  = Integer.toHexString(var11_11 & 255);
            var35_36 /* !! */ .append((String)var9_9 /* !! */ );
            var35_36 /* !! */  = var35_36 /* !! */ .toString();
            var5_5 = new IOException((String)var35_36 /* !! */ );
            throw var5_5;
        }
        var14_14 = var1_1.readByte();
        if (var14_14 != (var15_15 = -40)) {
            var35_35 /* !! */  = new StringBuilder();
            var35_35 /* !! */ .append((String)var12_12);
            var9_9 /* !! */  = Integer.toHexString(var11_11 & 255);
            var35_35 /* !! */ .append((String)var9_9 /* !! */ );
            var35_35 /* !! */  = var35_35 /* !! */ .toString();
            var5_5 = new IOException((String)var35_35 /* !! */ );
            throw var5_5;
        }
        var16_16 = var11_11 = 2;
        while (true) {
            block30: {
                block31: {
                    block29: {
                        if ((var14_14 = var1_1.readByte()) != var13_13) {
                            var35_34 /* !! */  = new StringBuilder();
                            var35_34 /* !! */ .append("Invalid marker:");
                            var9_9 /* !! */  = Integer.toHexString(var14_14 & 255);
                            var35_34 /* !! */ .append((String)var9_9 /* !! */ );
                            var35_34 /* !! */  = var35_34 /* !! */ .toString();
                            var5_5 = new IOException((String)var35_34 /* !! */ );
                            throw var5_5;
                        }
                        var14_14 = 1;
                        var16_16 += var14_14;
                        var15_15 = var1_1.readByte();
                        var17_17 = ExifInterface.DEBUG;
                        if (var17_17) {
                            var18_18 /* !! */  = new StringBuilder();
                            var18_18 /* !! */ .append("Found JPEG segment indicator: ");
                            var19_19 = var15_15 & 255;
                            var20_20 = Integer.toHexString(var19_19);
                            var18_18 /* !! */ .append(var20_20);
                            var18_18 /* !! */  = var18_18 /* !! */ .toString();
                            Log.d((String)var8_8, (String)var18_18 /* !! */ );
                        }
                        var16_16 += var14_14;
                        var21_21 = -39;
                        if (var15_15 == var21_21 || var15_15 == (var21_21 = -38)) break;
                        var21_21 = var1_1.readUnsignedShort() - var11_11;
                        var16_16 += var11_11;
                        if (var17_17) {
                            var22_22 = new StringBuilder();
                            var22_22.append("JPEG segment: ");
                            var20_20 = Integer.toHexString(var15_15 & 255);
                            var22_22.append(var20_20);
                            var22_22.append(" (length: ");
                            var19_19 = var21_21 + 2;
                            var22_22.append(var19_19);
                            var20_20 = ")";
                            var22_22.append(var20_20);
                            var22_22 = var22_22.toString();
                            Log.d((String)var8_8, (String)var22_22);
                        }
                        var22_22 = "Invalid length";
                        if (var21_21 < 0) {
                            var5_5 = new IOException((String)var22_22);
                            throw var5_5;
                        }
                        var19_19 = -31;
                        if (var15_15 == var19_19) break block29;
                        var19_19 = -2;
                        if (var15_15 != var19_19) {
                            block0 : switch (var15_15) {
                                default: {
                                    switch (var15_15) {
                                        default: {
                                            switch (var15_15) {
                                                default: {
                                                    switch (var15_15) {
                                                        default: {
                                                            break block0;
                                                        }
                                                        case -51: 
                                                        case -50: 
                                                        case -49: 
                                                    }
                                                }
                                                case -55: 
                                                case -54: 
                                                case -53: 
                                            }
                                        }
                                        case -59: 
                                        case -58: 
                                        case -57: 
                                    }
                                }
                                case -64: 
                                case -63: 
                                case -62: 
                                case -61: {
                                    var15_15 = var5_5.skipBytes(var14_14);
                                    if (var15_15 != var14_14) {
                                        var5_5 = new IOException("Invalid SOFx");
                                        throw var5_5;
                                    }
                                    var24_24 = var4_4.mAttributes[var6_6];
                                    var25_25 = var1_1.readUnsignedShort();
                                    var27_26 /* !! */  = (byte[])var4_4.mExifByteOrder;
                                    var27_26 /* !! */  = (byte[])ExifInterface$ExifAttribute.createULong(var25_25, (ByteOrder)var27_26 /* !! */ );
                                    var24_24.put("ImageLength", var27_26 /* !! */ );
                                    var24_24 = var4_4.mAttributes[var6_6];
                                    var15_15 = var1_1.readUnsignedShort();
                                    var25_25 = var15_15;
                                    var27_26 /* !! */  = (byte[])var4_4.mExifByteOrder;
                                    var27_26 /* !! */  = (byte[])ExifInterface$ExifAttribute.createULong(var25_25, (ByteOrder)var27_26 /* !! */ );
                                    var20_20 = "ImageWidth";
                                    var24_24.put(var20_20, var27_26 /* !! */ );
                                    var21_21 += -5;
                                    break;
                                }
                            }
                        } else {
                            var27_26 /* !! */  = new byte[var21_21];
                            var19_19 = var5_5.read(var27_26 /* !! */ );
                            if (var19_19 != var21_21) {
                                var5_5 = new IOException("Invalid exif");
                                throw var5_5;
                            }
                            var18_18 /* !! */  = "UserComment";
                            var20_20 = var4_4.getAttribute((String)var18_18 /* !! */ );
                            if (var20_20 == null) {
                                var24_24 = var4_4.mAttributes[var14_14];
                                var28_27 /* !! */  = (byte[])ExifInterface.ASCII;
                                var20_20 = new String(var27_26 /* !! */ , (Charset)var28_27 /* !! */ );
                                var27_26 /* !! */  = (byte[])ExifInterface$ExifAttribute.createString(var20_20);
                                var24_24.put(var18_18 /* !! */ , var27_26 /* !! */ );
                            }
                            var21_21 = 0;
                            var18_18 /* !! */  = null;
                        }
                        var23_23 = var8_8;
                        break block30;
                    }
                    var27_26 /* !! */  = new byte[var21_21];
                    var5_5.readFully(var27_26 /* !! */ );
                    var19_19 = var16_16 + var21_21;
                    var28_27 /* !! */  = ExifInterface.IDENTIFIER_EXIF_APP1;
                    var29_28 = ExifInterface.startsWith(var27_26 /* !! */ , var28_27 /* !! */ );
                    if (var29_28 == 0) break block31;
                    var14_14 = var28_27 /* !! */ .length;
                    var24_24 = Arrays.copyOfRange(var27_26 /* !! */ , var14_14, var21_21);
                    var16_16 = var2_2 + var16_16;
                    var15_15 = var28_27 /* !! */ .length;
                    var4_4.mOffsetToExifData = var16_16 += var15_15;
                    var4_4.readExifSegment((byte[])var24_24, var6_6);
                    var12_12 = new ExifInterface$ByteOrderedDataInputStream((byte[])var24_24);
                    var4_4.setThumbnailData((ExifInterface$ByteOrderedDataInputStream)var12_12);
                    ** GOTO lbl-1000
                }
                var28_27 /* !! */  = ExifInterface.IDENTIFIER_XMP_APP1;
                var29_28 = ExifInterface.startsWith(var27_26 /* !! */ , var28_27 /* !! */ );
                if (var29_28 == 0) ** GOTO lbl-1000
                var29_28 = var28_27 /* !! */ .length;
                var16_16 += var29_28;
                var30_29 = var28_27 /* !! */ .length;
                var27_26 /* !! */  = Arrays.copyOfRange(var27_26 /* !! */ , var30_29, var21_21);
                var18_18 /* !! */  = "Xmp";
                var28_27 /* !! */  = (byte[])var4_4.getAttribute((String)var18_18 /* !! */ );
                if (var28_27 /* !! */  == null) {
                    var28_27 /* !! */  = (byte[])var4_4.mAttributes[0];
                    var29_28 = var27_26 /* !! */ .length;
                    var23_23 = var8_8;
                    var32_31 = var16_16;
                    var16_16 = var29_28;
                    var10_10 = var31_30;
                    var34_32 = 1;
                    var31_30 = new ExifInterface$ExifAttribute(var34_32, var29_28, var32_31, var27_26 /* !! */ );
                    var28_27 /* !! */ .put(var18_18 /* !! */ , var31_30);
                    var4_4.mXmpIsFromSeparateMarker = var14_14;
                } else lbl-1000:
                // 3 sources

                {
                    var23_23 = var8_8;
                }
                var16_16 = var19_19;
                var21_21 = 0;
                var18_18 /* !! */  = null;
            }
            if (var21_21 < 0) {
                var5_5 = new IOException((String)var22_22);
                throw var5_5;
            }
            var7_7 = var5_5.skipBytes(var21_21);
            if (var7_7 != var21_21) {
                var5_5 = new IOException("Invalid JPEG segment");
                throw var5_5;
            }
            var16_16 += var21_21;
            var8_8 = var23_23;
            var7_7 = 0;
            var9_9 /* !! */  = null;
            var11_11 = 2;
        }
        var35_33 = var4_4.mExifByteOrder;
        var5_5.setByteOrder(var35_33);
    }

    private int getMimeType(BufferedInputStream bufferedInputStream) {
        int n10 = 5000;
        bufferedInputStream.mark(n10);
        byte[] byArray = new byte[n10];
        bufferedInputStream.read(byArray);
        bufferedInputStream.reset();
        boolean bl2 = ExifInterface.isJpegFormat(byArray);
        if (bl2) {
            return 4;
        }
        bl2 = this.isRafFormat(byArray);
        if (bl2) {
            return 9;
        }
        bl2 = this.isHeifFormat(byArray);
        if (bl2) {
            return 12;
        }
        bl2 = this.isOrfFormat(byArray);
        if (bl2) {
            return 7;
        }
        bl2 = this.isRw2Format(byArray);
        if (bl2) {
            return 10;
        }
        bl2 = this.isPngFormat(byArray);
        if (bl2) {
            return 13;
        }
        bl2 = this.isWebpFormat(byArray);
        if (bl2) {
            return 14;
        }
        return 0;
    }

    private void getOrfAttributes(ExifInterface$ByteOrderedDataInputStream object) {
        this.getRawAttributes((ExifInterface$ByteOrderedDataInputStream)object);
        object = this.mAttributes;
        int n10 = 1;
        object = object[n10];
        Object object2 = TAG_MAKER_NOTE;
        object = (ExifInterface$ExifAttribute)((HashMap)object).get(object2);
        if (object != null) {
            int n11;
            object = ((ExifInterface$ExifAttribute)object).bytes;
            object2 = new ExifInterface$ByteOrderedDataInputStream((byte[])object);
            object = this.mExifByteOrder;
            ((ExifInterface$ByteOrderedDataInputStream)object2).setByteOrder((ByteOrder)object);
            object = ORF_MAKER_NOTE_HEADER_1;
            Object object3 = ((HashMap[])object).length;
            Object object4 = new byte[object3];
            ((ExifInterface$ByteOrderedDataInputStream)object2).readFully((byte[])object4);
            long l10 = 0L;
            ((ExifInterface$ByteOrderedDataInputStream)object2).seek(l10);
            byte[] byArray = ORF_MAKER_NOTE_HEADER_2;
            Object object5 = byArray.length;
            Object object6 = new byte[object5];
            ((ExifInterface$ByteOrderedDataInputStream)object2).readFully((byte[])object6);
            Object object7 = Arrays.equals((byte[])object4, (byte[])object);
            if (object7 != 0) {
                long l11 = 8;
                ((ExifInterface$ByteOrderedDataInputStream)object2).seek(l11);
            } else {
                object7 = Arrays.equals(object6, byArray);
                if (object7 != 0) {
                    long l12 = 12;
                    ((ExifInterface$ByteOrderedDataInputStream)object2).seek(l12);
                }
            }
            object7 = 6;
            this.readImageFileDirectory((ExifInterface$ByteOrderedDataInputStream)object2, (int)object7);
            object = this.mAttributes;
            Object object8 = 7;
            object = (ExifInterface$ExifAttribute)object[object8].get(TAG_ORF_PREVIEW_IMAGE_START);
            object2 = this.mAttributes[object8];
            object4 = TAG_ORF_PREVIEW_IMAGE_LENGTH;
            object2 = (ExifInterface$ExifAttribute)((HashMap)object2).get(object4);
            if (object != null && object2 != null) {
                object4 = this.mAttributes;
                n11 = 5;
                object4 = object4[n11];
                object6 = TAG_JPEG_INTERCHANGE_FORMAT;
                ((HashMap)object4).put(object6, object);
                object = this.mAttributes[n11];
                object4 = TAG_JPEG_INTERCHANGE_FORMAT_LENGTH;
                ((HashMap)object).put(object4, object2);
            }
            object = this.mAttributes;
            object8 = 8;
            object = object[object8];
            object2 = TAG_ORF_ASPECT_FRAME;
            if ((object = (ExifInterface$ExifAttribute)((HashMap)object).get(object2)) != null) {
                object2 = this.mExifByteOrder;
                if ((object = (Object)((int[])((ExifInterface$ExifAttribute)object).getValue((ByteOrder)object2))) != null && (object8 = ((HashMap[])object).length) == (object3 = 4)) {
                    HashMap hashMap;
                    object8 = 2;
                    object3 = object[object8];
                    n11 = 0;
                    byArray = null;
                    object5 = object[0];
                    if (object3 > object5 && (object5 = (Object)object[object3 = 3]) > (hashMap = object[n10])) {
                        object8 = object[object8];
                        object5 = object[0];
                        object8 = object8 - object5 + n10;
                        object3 = object[object3];
                        object7 = object[n10];
                        if (object8 < (object3 = object3 - object7 + n10)) {
                            object8 += object3;
                            object3 = object8 - object3;
                            object8 -= object3;
                        }
                        object = this.mExifByteOrder;
                        object = ExifInterface$ExifAttribute.createUShort(object8, (ByteOrder)object);
                        Object object9 = this.mExifByteOrder;
                        object9 = ExifInterface$ExifAttribute.createUShort(object3, (ByteOrder)object9);
                        object2 = this.mAttributes[0];
                        object4 = TAG_IMAGE_WIDTH;
                        ((HashMap)object2).put(object4, object);
                        object = this.mAttributes[0];
                        object2 = TAG_IMAGE_LENGTH;
                        ((HashMap)object).put(object2, object9);
                    }
                } else {
                    CharSequence charSequence = new StringBuilder();
                    object2 = "Invalid aspect frame values. frame=";
                    charSequence.append((String)object2);
                    object = Arrays.toString((int[])object);
                    charSequence.append((String)object);
                    object = charSequence.toString();
                    charSequence = TAG;
                    Log.w((String)charSequence, (String)object);
                }
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void getPngAttributes(ExifInterface$ByteOrderedDataInputStream object) {
        Object object2;
        Object object3;
        boolean bl2 = DEBUG;
        if (bl2) {
            object3 = new StringBuilder();
            ((StringBuilder)object3).append("getPngAttributes starting with: ");
            ((StringBuilder)object3).append(object);
            object3 = ((StringBuilder)object3).toString();
            object2 = TAG;
            Log.d((String)object2, (String)object3);
        }
        bl2 = false;
        object3 = null;
        ((ExifInterface$ByteOrderedDataInputStream)object).mark(0);
        object2 = ByteOrder.BIG_ENDIAN;
        ((ExifInterface$ByteOrderedDataInputStream)object).setByteOrder((ByteOrder)object2);
        object2 = PNG_SIGNATURE;
        int n10 = ((Object)object2).length;
        ((ExifInterface$ByteOrderedDataInputStream)object).skipBytes(n10);
        int n11 = ((Object)object2).length + 0;
        try {
            while (true) {
                byte[] byArray;
                n10 = ((ExifInterface$ByteOrderedDataInputStream)object).readInt();
                int n12 = 4;
                n11 += n12;
                byte[] byArray2 = new byte[n12];
                int n13 = ((InputStream)object).read(byArray2);
                if (n13 != n12) {
                    object3 = "Encountered invalid length while parsing PNG chunktype";
                    object = new IOException((String)object3);
                    throw object;
                }
                if ((n11 += n12) == (n12 = 16) && (n12 = (int)(Arrays.equals(byArray2, byArray = PNG_CHUNK_TYPE_IHDR) ? 1 : 0)) == 0) {
                    object3 = "Encountered invalid PNG file--IHDR chunk should appearas the first chunk";
                    object = new IOException((String)object3);
                    throw object;
                }
                byte[] byArray3 = PNG_CHUNK_TYPE_IEND;
                n12 = (int)(Arrays.equals(byArray2, byArray3) ? 1 : 0);
                if (n12 != 0) {
                    return;
                }
                byte[] byArray4 = PNG_CHUNK_TYPE_EXIF;
                n12 = (int)(Arrays.equals(byArray2, byArray4) ? 1 : 0);
                if (n12 != 0) {
                    byte[] byArray5 = new byte[n10];
                    n13 = ((InputStream)object).read(byArray5);
                    if (n13 != n10) {
                        object3 = new StringBuilder();
                        object2 = "Failed to read given length for given PNG chunk type: ";
                        ((StringBuilder)object3).append((String)object2);
                        object2 = ExifInterface.byteArrayToHexString(byArray2);
                        ((StringBuilder)object3).append((String)object2);
                        object3 = ((StringBuilder)object3).toString();
                        object = new IOException((String)object3);
                        throw object;
                    }
                    int n14 = ((ExifInterface$ByteOrderedDataInputStream)object).readInt();
                    CRC32 cRC32 = new CRC32();
                    cRC32.update(byArray2);
                    cRC32.update(byArray5);
                    long l10 = cRC32.getValue();
                    int n15 = (int)l10;
                    if (n15 == n14) {
                        this.mOffsetToExifData = n11;
                        this.readExifSegment(byArray5, 0);
                        this.validateImages();
                        object = new ExifInterface$ByteOrderedDataInputStream(byArray5);
                        this.setThumbnailData((ExifInterface$ByteOrderedDataInputStream)object);
                        return;
                    }
                    object2 = new StringBuilder();
                    String string2 = "Encountered invalid CRC value for PNG-EXIF chunk.\n recorded CRC value: ";
                    ((StringBuilder)object2).append(string2);
                    ((StringBuilder)object2).append(n14);
                    object = ", calculated CRC value: ";
                    ((StringBuilder)object2).append((String)object);
                    long l11 = cRC32.getValue();
                    ((StringBuilder)object2).append(l11);
                    object = ((StringBuilder)object2).toString();
                    object3 = new IOException((String)object);
                    throw object3;
                }
                ((ExifInterface$ByteOrderedDataInputStream)object).skipBytes(n10 += 4);
                n11 += n10;
            }
        }
        catch (EOFException eOFException) {}
        object = new IOException("Encountered corrupt PNG file.");
        throw object;
    }

    private void getRafAttributes(ExifInterface$ByteOrderedDataInputStream object) {
        CharSequence charSequence;
        Object object2;
        Object object3;
        int n10 = DEBUG;
        String string2 = TAG;
        if (n10 != 0) {
            object3 = new StringBuilder();
            object2 = "getRafAttributes starting with: ";
            ((StringBuilder)object3).append((String)object2);
            ((StringBuilder)object3).append(object);
            object3 = ((StringBuilder)object3).toString();
            Log.d((String)string2, (String)object3);
        }
        boolean bl2 = false;
        object3 = null;
        ((ExifInterface$ByteOrderedDataInputStream)object).mark(0);
        ((ExifInterface$ByteOrderedDataInputStream)object).skipBytes(84);
        int n11 = 4;
        Object object4 = new byte[n11];
        Object object5 = new byte[n11];
        object2 = new byte[n11];
        ((InputStream)object).read((byte[])object4);
        ((InputStream)object).read((byte[])object5);
        ((InputStream)object).read((byte[])object2);
        object4 = ByteBuffer.wrap((byte[])object4);
        int n12 = ((ByteBuffer)object4).getInt();
        int n13 = ByteBuffer.wrap((byte[])object5).getInt();
        n11 = ByteBuffer.wrap((byte[])object2).getInt();
        object5 = new byte[n13];
        long l10 = n12;
        ((ExifInterface$ByteOrderedDataInputStream)object).seek(l10);
        ((InputStream)object).read((byte[])object5);
        Object object6 = new ExifInterface$ByteOrderedDataInputStream((byte[])object5);
        n13 = 5;
        this.getJpegAttributes((ExifInterface$ByteOrderedDataInputStream)object6, n12, n13);
        long l11 = n11;
        ((ExifInterface$ByteOrderedDataInputStream)object).seek(l11);
        object2 = ByteOrder.BIG_ENDIAN;
        ((ExifInterface$ByteOrderedDataInputStream)object).setByteOrder((ByteOrder)object2);
        n11 = ((ExifInterface$ByteOrderedDataInputStream)object).readInt();
        if (n10 != 0) {
            charSequence = new StringBuilder();
            object4 = "numberOfDirectoryEntry: ";
            charSequence.append((String)object4);
            charSequence.append(n11);
            charSequence = charSequence.toString();
            Log.d((String)string2, (String)charSequence);
        }
        charSequence = null;
        for (n10 = 0; n10 < n11; ++n10) {
            n12 = ((ExifInterface$ByteOrderedDataInputStream)object).readUnsignedShort();
            n13 = ((ExifInterface$ByteOrderedDataInputStream)object).readUnsignedShort();
            object6 = TAG_RAF_IMAGE_SIZE;
            int n14 = ((ExifInterface$ExifTag)object6).number;
            if (n12 == n14) {
                n10 = ((ExifInterface$ByteOrderedDataInputStream)object).readShort();
                short s10 = ((ExifInterface$ByteOrderedDataInputStream)object).readShort();
                object2 = this.mExifByteOrder;
                object2 = ExifInterface$ExifAttribute.createUShort(n10, (ByteOrder)object2);
                object4 = this.mExifByteOrder;
                object4 = ExifInterface$ExifAttribute.createUShort(s10, (ByteOrder)object4);
                object5 = this.mAttributes[0];
                object6 = TAG_IMAGE_LENGTH;
                ((HashMap)object5).put(object6, object2);
                object3 = this.mAttributes[0];
                object2 = TAG_IMAGE_WIDTH;
                ((HashMap)object3).put(object2, object4);
                bl2 = DEBUG;
                if (bl2) {
                    object3 = new StringBuilder();
                    object2 = "Updated to length: ";
                    ((StringBuilder)object3).append((String)object2);
                    ((StringBuilder)object3).append(n10);
                    charSequence = ", width: ";
                    ((StringBuilder)object3).append((String)charSequence);
                    ((StringBuilder)object3).append(s10);
                    object = ((StringBuilder)object3).toString();
                    Log.d((String)string2, (String)object);
                }
                return;
            }
            ((ExifInterface$ByteOrderedDataInputStream)object).skipBytes(n13);
        }
    }

    private void getRawAttributes(ExifInterface$ByteOrderedDataInputStream object) {
        int n10 = ((ExifInterface$ByteOrderedDataInputStream)object).available();
        this.parseTiffHeaders((ExifInterface$ByteOrderedDataInputStream)object, n10);
        HashMap hashMap = null;
        this.readImageFileDirectory((ExifInterface$ByteOrderedDataInputStream)object, 0);
        this.updateImageSizeValues((ExifInterface$ByteOrderedDataInputStream)object, 0);
        this.updateImageSizeValues((ExifInterface$ByteOrderedDataInputStream)object, 5);
        this.updateImageSizeValues((ExifInterface$ByteOrderedDataInputStream)object, 4);
        this.validateImages();
        int n11 = this.mMimeType;
        n10 = 8;
        if (n11 == n10) {
            object = this.mAttributes;
            n10 = 1;
            object = object[n10];
            Object object2 = TAG_MAKER_NOTE;
            if ((object = (ExifInterface$ExifAttribute)((HashMap)object).get(object2)) != null) {
                object = ((ExifInterface$ExifAttribute)object).bytes;
                object2 = new ExifInterface$ByteOrderedDataInputStream((byte[])object);
                object = this.mExifByteOrder;
                ((ExifInterface$ByteOrderedDataInputStream)object2).setByteOrder((ByteOrder)object);
                long l10 = 6;
                ((ExifInterface$ByteOrderedDataInputStream)object2).seek(l10);
                n11 = 9;
                this.readImageFileDirectory((ExifInterface$ByteOrderedDataInputStream)object2, n11);
                object = this.mAttributes[n11];
                object2 = TAG_COLOR_SPACE;
                object = (ExifInterface$ExifAttribute)((HashMap)object).get(object2);
                if (object != null) {
                    HashMap[] hashMapArray = this.mAttributes;
                    hashMap = hashMapArray[n10];
                    hashMap.put(object2, object);
                }
            }
        }
    }

    private void getRw2Attributes(ExifInterface$ByteOrderedDataInputStream object) {
        Object object2;
        Object object3;
        Object object4;
        boolean bl2 = DEBUG;
        if (bl2) {
            object4 = new StringBuilder();
            ((StringBuilder)object4).append("getRw2Attributes starting with: ");
            ((StringBuilder)object4).append(object);
            object4 = ((StringBuilder)object4).toString();
            object3 = TAG;
            Log.d((String)object3, (String)object4);
        }
        this.getRawAttributes((ExifInterface$ByteOrderedDataInputStream)object);
        object = this.mAttributes;
        bl2 = false;
        object4 = null;
        object = object[0];
        object3 = TAG_RW2_JPG_FROM_RAW;
        object = (ExifInterface$ExifAttribute)((HashMap)object).get(object3);
        if (object != null) {
            object2 = ((ExifInterface$ExifAttribute)object).bytes;
            object3 = new ExifInterface$ByteOrderedDataInputStream((byte[])object2);
            long l10 = ((ExifInterface$ExifAttribute)object).bytesOffset;
            int n10 = (int)l10;
            int n11 = 5;
            this.getJpegAttributes((ExifInterface$ByteOrderedDataInputStream)object3, n10, n11);
        }
        object = (ExifInterface$ExifAttribute)this.mAttributes[0].get(TAG_RW2_ISO);
        object4 = this.mAttributes;
        int n12 = 1;
        object4 = object4[n12];
        object2 = TAG_PHOTOGRAPHIC_SENSITIVITY;
        object4 = (ExifInterface$ExifAttribute)((HashMap)object4).get(object2);
        if (object != null && object4 == null) {
            object4 = this.mAttributes[n12];
            ((HashMap)object4).put(object2, object);
        }
    }

    private void getStandaloneAttributes(ExifInterface$ByteOrderedDataInputStream exifInterface$ByteOrderedDataInputStream) {
        int n10;
        byte[] byArray = IDENTIFIER_EXIF_APP1;
        int n11 = byArray.length;
        exifInterface$ByteOrderedDataInputStream.skipBytes(n11);
        byte[] byArray2 = new byte[exifInterface$ByteOrderedDataInputStream.available()];
        exifInterface$ByteOrderedDataInputStream.readFully(byArray2);
        this.mOffsetToExifData = n10 = byArray.length;
        this.readExifSegment(byArray2, 0);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void getWebpAttributes(ExifInterface$ByteOrderedDataInputStream object) {
        Object object2;
        CharSequence charSequence;
        boolean bl2 = DEBUG;
        if (bl2) {
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append("getWebpAttributes starting with: ");
            ((StringBuilder)charSequence).append(object);
            charSequence = ((StringBuilder)charSequence).toString();
            object2 = TAG;
            Log.d((String)object2, (String)charSequence);
        }
        bl2 = false;
        charSequence = null;
        ((ExifInterface$ByteOrderedDataInputStream)object).mark(0);
        object2 = ByteOrder.LITTLE_ENDIAN;
        ((ExifInterface$ByteOrderedDataInputStream)object).setByteOrder((ByteOrder)object2);
        object2 = WEBP_SIGNATURE_1;
        int n10 = ((Object)object2).length;
        ((ExifInterface$ByteOrderedDataInputStream)object).skipBytes(n10);
        n10 = ((ExifInterface$ByteOrderedDataInputStream)object).readInt() + 8;
        byte[] byArray = WEBP_SIGNATURE_2;
        int n11 = byArray.length;
        n11 = ((ExifInterface$ByteOrderedDataInputStream)object).skipBytes(n11) + 8;
        while (true) {
            int n12 = 4;
            try {
                byte[] byArray2 = new byte[n12];
                int n13 = ((InputStream)object).read(byArray2);
                if (n13 != n12) {
                    charSequence = "Encountered invalid length while parsing WebP chunktype";
                    object = new IOException((String)charSequence);
                    throw object;
                }
                n11 += n12;
                n13 = ((ExifInterface$ByteOrderedDataInputStream)object).readInt();
                n11 += n12;
                byte[] byArray3 = WEBP_CHUNK_TYPE_EXIF;
                n12 = (int)(Arrays.equals(byArray3, byArray2) ? 1 : 0);
                if (n12 != 0) {
                    object2 = new byte[n13];
                    int n14 = ((InputStream)object).read((byte[])object2);
                    if (n14 == n13) {
                        this.mOffsetToExifData = n11;
                        this.readExifSegment((byte[])object2, 0);
                        object = new ExifInterface$ByteOrderedDataInputStream((byte[])object2);
                        this.setThumbnailData((ExifInterface$ByteOrderedDataInputStream)object);
                        return;
                    }
                    charSequence = new StringBuilder();
                    object2 = "Failed to read given length for given PNG chunk type: ";
                    ((StringBuilder)charSequence).append((String)object2);
                    object2 = ExifInterface.byteArrayToHexString(byArray2);
                    ((StringBuilder)charSequence).append((String)object2);
                    charSequence = ((StringBuilder)charSequence).toString();
                    object = new IOException((String)charSequence);
                    throw object;
                }
                n12 = n13 % 2;
                int n15 = 1;
                if (n12 == n15) {
                    ++n13;
                }
                if ((n12 = n11 + n13) == n10) {
                    return;
                }
                String string2 = "Encountered WebP file with invalid chunk size";
                if (n12 > n10) {
                    object = new IOException(string2);
                    throw object;
                }
                n12 = ((ExifInterface$ByteOrderedDataInputStream)object).skipBytes(n13);
                if (n12 != n13) {
                    object = new IOException(string2);
                    throw object;
                }
                n11 += n12;
                continue;
            }
            catch (EOFException eOFException) {}
            break;
        }
        object = new IOException("Encountered corrupt WebP file.");
        throw object;
    }

    private static Pair guessDataFormat(String pair) {
        int n10;
        long l10;
        int n11;
        Object object = ",";
        int n12 = pair.contains((CharSequence)object);
        int n13 = 0;
        Integer n14 = null;
        int n15 = 2;
        Integer n16 = n15;
        int n17 = -1;
        Integer n18 = n17;
        if (n12 != 0) {
            pair = pair.split((String)object, n17);
            object = ExifInterface.guessDataFormat(pair[0]);
            Integer n19 = (Integer)((Pair)object).first;
            n12 = n19;
            if (n12 == n15) {
                return object;
            }
            for (n11 = 1; n11 < (n12 = ((Pair)pair).length); ++n11) {
                Object object2;
                n19 = ExifInterface.guessDataFormat((String)pair[n11]);
                n14 = (Integer)((Pair)n19).first;
                Object object3 = ((Pair)object).first;
                n13 = (int)(n14.equals(object3) ? 1 : 0);
                if (n13 == 0 && (n13 = (int)((n14 = (Integer)((Pair)n19).second).equals(object3 = ((Pair)object).first) ? 1 : 0)) == 0) {
                    n13 = n17;
                } else {
                    n14 = (Integer)((Pair)object).first;
                    n13 = n14;
                }
                object3 = (Integer)((Pair)object).second;
                n15 = (Integer)object3;
                if (n15 != n17 && ((n15 = (int)(((Integer)(object3 = (Integer)((Pair)n19).first)).equals(object2 = ((Pair)object).second) ? 1 : 0)) != 0 || (n12 = (int)((n19 = (Integer)((Pair)n19).second).equals(object3 = ((Pair)object).second) ? 1 : 0)) != 0)) {
                    n19 = (Integer)((Pair)object).second;
                    n12 = n19;
                } else {
                    n12 = n17;
                }
                if (n13 == n17 && n12 == n17) {
                    pair = new Pair((Object)n16, (Object)n18);
                    return pair;
                }
                if (n13 == n17) {
                    n19 = n12;
                    object = new Pair((Object)n19, (Object)n18);
                    continue;
                }
                if (n12 != n17) continue;
                n19 = n13;
                object = new Pair((Object)n19, (Object)n18);
            }
            return object;
        }
        object = "/";
        n12 = pair.contains((CharSequence)object);
        long l11 = 0L;
        if (n12 != 0) {
            int n20 = ((String[])(pair = pair.split((String)object, n17))).length;
            if (n20 == n15) {
                try {
                    object = pair[0];
                }
                catch (NumberFormatException numberFormatException) {}
                double d10 = Double.parseDouble((String)object);
                long l12 = (long)d10;
                pair = pair[n11];
                double d11 = Double.parseDouble((String)pair);
                long l13 = (long)d11;
                long l14 = l12 == l11 ? 0 : (l12 < l11 ? -1 : 1);
                n15 = 10;
                if (l14 >= 0 && (l14 = l13 == l11 ? 0 : (l13 < l11 ? -1 : 1)) >= 0) {
                    l11 = Integer.MAX_VALUE;
                    l14 = l12 == l11 ? 0 : (l12 < l11 ? -1 : 1);
                    n20 = 5;
                    if (l14 <= 0 && (l14 = l13 == l11 ? 0 : (l13 < l11 ? -1 : 1)) <= 0) {
                        Integer n21 = n15;
                        object = n20;
                        pair = new Pair((Object)n21, object);
                        return pair;
                    }
                    object = n20;
                    pair = new Pair(object, (Object)n18);
                    return pair;
                }
                object = n15;
                pair = new Pair(object, (Object)n18);
                return pair;
            }
            pair = new Pair((Object)n16, (Object)n18);
            return pair;
        }
        try {
            l10 = Long.parseLong((String)pair);
        }
        catch (NumberFormatException numberFormatException) {
            try {
                Double.parseDouble((String)pair);
                n10 = 12;
            }
            catch (NumberFormatException numberFormatException2) {
                pair = new Pair((Object)n16, (Object)n18);
                return pair;
            }
            object = n10;
            pair = new Pair(object, (Object)n18);
            return pair;
        }
        object = l10;
        long l15 = (Long)object;
        n12 = (int)(l15 == l11 ? 0 : (l15 < l11 ? -1 : 1));
        n13 = 4;
        if (n12 >= 0) {
            long l16 = (Long)object;
            long l17 = (char)-1;
            n12 = (int)(l16 == l17 ? 0 : (l16 < l17 ? -1 : 1));
            if (n12 <= 0) {
                n12 = 3;
                Integer n22 = n12;
                n14 = n13;
                object = new Pair((Object)n22, (Object)n14);
                return object;
            }
        }
        l10 = (Long)object;
        n10 = (int)(l10 == l11 ? 0 : (l10 < l11 ? -1 : 1));
        if (n10 < 0) {
            n12 = 9;
            Integer n23 = n12;
            object = new Pair((Object)n23, (Object)n18);
            return object;
        }
        Integer n24 = n13;
        object = new Pair((Object)n24, (Object)n18);
        return object;
    }

    private void handleThumbnailFromJfif(ExifInterface$ByteOrderedDataInputStream object, HashMap object2) {
        Object object3 = (ExifInterface$ExifAttribute)((HashMap)object2).get(TAG_JPEG_INTERCHANGE_FORMAT);
        Object object4 = TAG_JPEG_INTERCHANGE_FORMAT_LENGTH;
        object2 = (ExifInterface$ExifAttribute)((HashMap)object2).get(object4);
        if (object3 != null && object2 != null) {
            boolean bl2;
            object4 = this.mExifByteOrder;
            int n10 = ((ExifInterface$ExifAttribute)object3).getIntValue((ByteOrder)object4);
            object4 = this.mExifByteOrder;
            int n11 = ((ExifInterface$ExifAttribute)object2).getIntValue((ByteOrder)object4);
            int n12 = this.mMimeType;
            int n13 = 7;
            if (n12 == n13) {
                n12 = this.mOrfMakerNoteOffset;
                n10 += n12;
            }
            n12 = ((ExifInterface$ByteOrderedDataInputStream)object).getLength() - n10;
            n11 = Math.min(n11, n12);
            if (n10 > 0 && n11 > 0) {
                n12 = 1;
                this.mHasThumbnail = n12;
                object4 = this.mFilename;
                if (object4 == null && (object4 = this.mAssetInputStream) == null && (object4 = this.mSeekableFileDescriptor) == null) {
                    object4 = new byte[n11];
                    long l10 = n10;
                    ((InputStream)object).skip(l10);
                    ((InputStream)object).read((byte[])object4);
                    this.mThumbnailBytes = (byte[])object4;
                }
                this.mThumbnailOffset = n10;
                this.mThumbnailLength = n11;
            }
            if (bl2 = DEBUG) {
                object = new StringBuilder();
                object4 = "Setting thumbnail attributes with offset: ";
                ((StringBuilder)object).append((String)object4);
                ((StringBuilder)object).append(n10);
                object3 = ", length: ";
                ((StringBuilder)object).append((String)object3);
                ((StringBuilder)object).append(n11);
                object = ((StringBuilder)object).toString();
                object2 = TAG;
                Log.d((String)object2, (String)object);
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    private void handleThumbnailFromStrips(ExifInterface$ByteOrderedDataInputStream exifInterface$ByteOrderedDataInputStream, HashMap hashMap) {
        int n10;
        int n11;
        long l10;
        int n12;
        Object object;
        Object object2;
        Object object3;
        Object object4;
        ExifInterface exifInterface;
        block11: {
            exifInterface = this;
            object4 = exifInterface$ByteOrderedDataInputStream;
            object3 = hashMap;
            object2 = (ExifInterface$ExifAttribute)hashMap.get(TAG_STRIP_OFFSETS);
            object = TAG_STRIP_BYTE_COUNTS;
            object3 = (ExifInterface$ExifAttribute)hashMap.get(object);
            if (object2 == null) return;
            if (object3 == null) return;
            object = this.mExifByteOrder;
            object2 = ExifInterface.convertToLongArray(((ExifInterface$ExifAttribute)object2).getValue((ByteOrder)object));
            object = this.mExifByteOrder;
            object3 = ExifInterface.convertToLongArray(((ExifInterface$ExifAttribute)object3).getValue((ByteOrder)object));
            object = TAG;
            if (object2 != null && (n12 = ((Object)object2).length) != 0) {
                if (object3 != null && (n12 = ((Object)object3).length) != 0) {
                    Object object5;
                    n12 = ((Object)object2).length;
                    int n13 = ((Object)object3).length;
                    if (n12 != n13) {
                        Log.w((String)object, (String)"stripOffsets and stripByteCounts should have same length.");
                        return;
                    }
                    l10 = 0L;
                    n11 = ((Object)object3).length;
                    for (n10 = 0; n10 < n11; l10 += object5, ++n10) {
                        object5 = object3[n10];
                    }
                    break block11;
                } else {
                    Log.w((String)object, (String)"stripByteCounts should not be null or have zero length.");
                    return;
                }
            }
            object4 = "stripOffsets should not be null or have zero length.";
            Log.w((String)object, (String)object4);
            return;
        }
        n12 = (int)l10;
        byte[] byArray = new byte[n12];
        n11 = 1;
        exifInterface.mAreThumbnailStripsConsecutive = n11;
        exifInterface.mHasThumbnailStrips = n11;
        exifInterface.mHasThumbnail = n11;
        n10 = 0;
        int n14 = 0;
        int n15 = 0;
        while (true) {
            int n16;
            Object object6;
            long l11;
            long l12;
            int n17;
            if (n10 >= (n17 = ((Object)object2).length)) {
                exifInterface.mThumbnailBytes = byArray;
                int n18 = exifInterface.mAreThumbnailStripsConsecutive;
                if (n18 == 0) return;
                Object object7 = object2[0];
                exifInterface.mThumbnailOffset = n18 = (int)object7;
                exifInterface.mThumbnailLength = n12;
                return;
            }
            Object object8 = object2[n10];
            n17 = (int)object8;
            Object object9 = object3[n10];
            int n19 = (int)object9;
            Object object10 = ((Object)object2).length - n11;
            if (n10 < object10 && (object10 = (Object)((l12 = (l11 = (long)(n17 + n19)) - (object6 = object2[n16 = n10 + 1])) == 0L ? 0 : (l12 < 0L ? -1 : 1))) != 0) {
                exifInterface.mAreThumbnailStripsConsecutive = false;
            }
            if ((n17 -= n14) < 0) {
                Log.d((String)object, (String)"Invalid strip offset value");
                return;
            }
            l11 = n17;
            object6 = ((InputStream)object4).skip(l11);
            object10 = object6 == l11 ? 0 : (object6 < l11 ? -1 : 1);
            String string2 = " bytes.";
            if (object10 != 0) {
                object4 = new StringBuilder();
                ((StringBuilder)object4).append("Failed to skip ");
                ((StringBuilder)object4).append(n17);
                ((StringBuilder)object4).append(string2);
                object4 = ((StringBuilder)object4).toString();
                Log.d((String)object, (String)object4);
                return;
            }
            n14 += n17;
            byte[] byArray2 = new byte[n19];
            object10 = ((InputStream)object4).read(byArray2);
            if (object10 != n19) {
                object4 = new StringBuilder();
                ((StringBuilder)object4).append("Failed to read ");
                ((StringBuilder)object4).append(n19);
                ((StringBuilder)object4).append(string2);
                object4 = ((StringBuilder)object4).toString();
                Log.d((String)object, (String)object4);
                return;
            }
            n14 += n19;
            System.arraycopy(byArray2, 0, byArray, n15, n19);
            n15 += n19;
            ++n10;
        }
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void initForFilename(String object) {
        void var1_4;
        FileInputStream fileInputStream;
        block4: {
            FileInputStream fileInputStream2;
            Objects.requireNonNull(object, "filename cannot be null");
            fileInputStream = null;
            this.mAssetInputStream = null;
            this.mFilename = object;
            try {
                fileInputStream2 = new FileInputStream((String)object);
            }
            catch (Throwable throwable) {
                // empty catch block
                break block4;
            }
            try {
                object = fileInputStream2.getFD();
                boolean bl2 = ExifInterface.isSeekableFD((FileDescriptor)object);
                this.mSeekableFileDescriptor = bl2 ? (object = fileInputStream2.getFD()) : null;
                this.loadAttributes(fileInputStream2);
            }
            catch (Throwable throwable) {
                fileInputStream = fileInputStream2;
                break block4;
            }
            ExifInterface.closeQuietly(fileInputStream2);
            return;
        }
        ExifInterface.closeQuietly(fileInputStream);
        throw var1_4;
    }

    private static boolean isExifDataOnly(BufferedInputStream bufferedInputStream) {
        byte[] byArray;
        int n10;
        byte[] byArray2 = IDENTIFIER_EXIF_APP1;
        int n11 = byArray2.length;
        bufferedInputStream.mark(n11);
        int n12 = byArray2.length;
        byArray2 = new byte[n12];
        bufferedInputStream.read(byArray2);
        bufferedInputStream.reset();
        bufferedInputStream = null;
        for (n11 = 0; n11 < (n10 = (byArray = IDENTIFIER_EXIF_APP1).length); ++n11) {
            n10 = byArray2[n11];
            byte by2 = byArray[n11];
            if (n10 == by2) continue;
            return false;
        }
        return true;
    }

    /*
     * Exception decompiling
     */
    private boolean isHeifFormat(byte[] var1_1) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Back jump on a try block [egrp 16[TRYBLOCK] [34 : 348->351)] java.lang.Throwable
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op02WithProcessedDataAndRefs.insertExceptionBlocks(Op02WithProcessedDataAndRefs.java:2289)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:414)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1042)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:929)
         *     at org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:257)
         *     at org.benf.cfr.reader.Driver.doJar(Driver.java:139)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:73)
         *     at org.benf.cfr.reader.Main.main(Main.java:49)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    private static boolean isJpegFormat(byte[] byArray) {
        byte[] byArray2;
        int n10;
        for (int i10 = 0; i10 < (n10 = (byArray2 = JPEG_SIGNATURE).length); ++i10) {
            n10 = byArray[i10];
            byte by2 = byArray2[i10];
            if (n10 == by2) continue;
            return false;
        }
        return true;
    }

    /*
     * Loose catch block
     * WARNING - void declaration
     */
    private boolean isOrfFormat(byte[] object) {
        InputStream inputStream;
        block13: {
            void var1_4;
            block12: {
                ExifInterface$ByteOrderedDataInputStream exifInterface$ByteOrderedDataInputStream;
                boolean bl2;
                block11: {
                    bl2 = false;
                    int n10 = 0;
                    inputStream = null;
                    exifInterface$ByteOrderedDataInputStream = new ExifInterface$ByteOrderedDataInputStream((byte[])object);
                    object = this.readByteOrder(exifInterface$ByteOrderedDataInputStream);
                    this.mExifByteOrder = object;
                    try {
                        exifInterface$ByteOrderedDataInputStream.setByteOrder((ByteOrder)object);
                        int n11 = exifInterface$ByteOrderedDataInputStream.readShort();
                        n10 = 20306;
                        if (n11 != n10 && n11 != (n10 = 21330)) break block11;
                        bl2 = true;
                    }
                    catch (Throwable throwable) {
                        inputStream = exifInterface$ByteOrderedDataInputStream;
                        break block12;
                    }
                    catch (Exception exception) {
                        inputStream = exifInterface$ByteOrderedDataInputStream;
                        break block13;
                    }
                }
                exifInterface$ByteOrderedDataInputStream.close();
                return bl2;
                catch (Throwable throwable) {
                    // empty catch block
                }
            }
            if (inputStream != null) {
                inputStream.close();
            }
            throw var1_4;
            catch (Exception exception) {}
        }
        if (inputStream != null) {
            inputStream.close();
        }
        return false;
    }

    private boolean isPngFormat(byte[] byArray) {
        byte[] byArray2;
        int n10;
        for (int i10 = 0; i10 < (n10 = (byArray2 = PNG_SIGNATURE).length); ++i10) {
            n10 = byArray[i10];
            byte by2 = byArray2[i10];
            if (n10 == by2) continue;
            return false;
        }
        return true;
    }

    private boolean isRafFormat(byte[] byArray) {
        int n10;
        Object object = Charset.defaultCharset();
        object = RAF_SIGNATURE.getBytes((Charset)object);
        for (int i10 = 0; i10 < (n10 = ((Object)object).length); ++i10) {
            n10 = byArray[i10];
            Object object2 = object[i10];
            if (n10 == object2) continue;
            return false;
        }
        return true;
    }

    /*
     * Loose catch block
     * WARNING - void declaration
     */
    private boolean isRw2Format(byte[] object) {
        InputStream inputStream;
        block13: {
            void var1_4;
            block12: {
                ExifInterface$ByteOrderedDataInputStream exifInterface$ByteOrderedDataInputStream;
                boolean bl2;
                block11: {
                    bl2 = false;
                    short s10 = 0;
                    inputStream = null;
                    exifInterface$ByteOrderedDataInputStream = new ExifInterface$ByteOrderedDataInputStream((byte[])object);
                    object = this.readByteOrder(exifInterface$ByteOrderedDataInputStream);
                    this.mExifByteOrder = object;
                    try {
                        exifInterface$ByteOrderedDataInputStream.setByteOrder((ByteOrder)object);
                        short s11 = exifInterface$ByteOrderedDataInputStream.readShort();
                        s10 = 85;
                        if (s11 != s10) break block11;
                        bl2 = true;
                    }
                    catch (Throwable throwable) {
                        inputStream = exifInterface$ByteOrderedDataInputStream;
                        break block12;
                    }
                    catch (Exception exception) {
                        inputStream = exifInterface$ByteOrderedDataInputStream;
                        break block13;
                    }
                }
                exifInterface$ByteOrderedDataInputStream.close();
                return bl2;
                catch (Throwable throwable) {
                    // empty catch block
                }
            }
            if (inputStream != null) {
                inputStream.close();
            }
            throw var1_4;
            catch (Exception exception) {}
        }
        if (inputStream != null) {
            inputStream.close();
        }
        return false;
    }

    private static boolean isSeekableFD(FileDescriptor object) {
        block4: {
            int n10 = Build.VERSION.SDK_INT;
            int n11 = 21;
            if (n10 >= n11) {
                long l10 = 0L;
                n10 = OsConstants.SEEK_CUR;
                try {
                    Os.lseek((FileDescriptor)object, (long)l10, (int)n10);
                    return true;
                }
                catch (Exception exception) {
                    boolean bl2 = DEBUG;
                    if (!bl2) break block4;
                    object = TAG;
                    String string2 = "The file descriptor for the given input is not seekable";
                    Log.d((String)object, (String)string2);
                }
            }
        }
        return false;
    }

    private boolean isSupportedDataType(HashMap object) {
        int n10;
        Object object2 = (ExifInterface$ExifAttribute)((HashMap)object).get(TAG_BITS_PER_SAMPLE);
        if (object2 != null) {
            Object object3;
            Object object4 = this.mExifByteOrder;
            object2 = (int[])((ExifInterface$ExifAttribute)object2).getValue((ByteOrder)object4);
            object4 = BITS_PER_SAMPLE_RGB;
            int n11 = Arrays.equals((int[])object4, (int[])object2);
            int n12 = 1;
            if (n11 != 0) {
                return n12;
            }
            n11 = this.mMimeType;
            int n13 = 3;
            if (n11 == n13 && (object = (ExifInterface$ExifAttribute)((HashMap)object).get(object3 = TAG_PHOTOMETRIC_INTERPRETATION)) != null && ((n10 = ((ExifInterface$ExifAttribute)object).getIntValue((ByteOrder)(object3 = this.mExifByteOrder))) == n12 && (n11 = (int)(Arrays.equals((int[])object2, (int[])(object3 = (Object)BITS_PER_SAMPLE_GREYSCALE_2)) ? 1 : 0)) != 0 || n10 == (n11 = 6) && (n10 = (int)(Arrays.equals((int[])object2, (int[])object4) ? 1 : 0)))) {
                return n12;
            }
        }
        if (n10 = DEBUG) {
            object = TAG;
            object2 = "Unsupported data type value";
            Log.d((String)object, (String)object2);
        }
        return false;
    }

    private boolean isSupportedFormatForSavingAttributes() {
        int n10 = this.mMimeType;
        int n11 = 4;
        return n10 == n11 || n10 == (n11 = 13) || n10 == (n11 = 14);
        {
        }
    }

    public static boolean isSupportedMimeType(String string2) {
        Objects.requireNonNull(string2, "mimeType shouldn't be null");
        Locale locale = Locale.ROOT;
        string2 = string2.toLowerCase(locale);
        string2.hashCode();
        int n10 = -1;
        int n11 = string2.hashCode();
        int n12 = 1;
        switch (n11) {
            default: {
                break;
            }
            case 2111234748: {
                String string3 = "image/x-canon-cr2";
                boolean bl2 = string2.equals(string3);
                if (!bl2) break;
                n10 = 14;
                break;
            }
            case 2099152524: {
                String string4 = "image/x-nikon-nrw";
                boolean bl3 = string2.equals(string4);
                if (!bl3) break;
                n10 = 13;
                break;
            }
            case 2099152104: {
                String string5 = "image/x-nikon-nef";
                boolean bl4 = string2.equals(string5);
                if (!bl4) break;
                n10 = 12;
                break;
            }
            case 1378106698: {
                String string6 = "image/x-olympus-orf";
                boolean bl5 = string2.equals(string6);
                if (!bl5) break;
                n10 = 11;
                break;
            }
            case -332763809: {
                String string7 = "image/x-pentax-pef";
                boolean bl6 = string2.equals(string7);
                if (!bl6) break;
                n10 = 10;
                break;
            }
            case -879258763: {
                String string8 = "image/png";
                boolean bl7 = string2.equals(string8);
                if (!bl7) break;
                n10 = 9;
                break;
            }
            case -985160897: {
                String string9 = "image/x-panasonic-rw2";
                boolean bl8 = string2.equals(string9);
                if (!bl8) break;
                n10 = 8;
                break;
            }
            case -1423313290: {
                String string10 = "image/x-adobe-dng";
                boolean bl9 = string2.equals(string10);
                if (!bl9) break;
                n10 = 7;
                break;
            }
            case -1487018032: {
                String string11 = "image/webp";
                boolean bl10 = string2.equals(string11);
                if (!bl10) break;
                n10 = 6;
                break;
            }
            case -1487394660: {
                String string12 = "image/jpeg";
                boolean bl11 = string2.equals(string12);
                if (!bl11) break;
                n10 = 5;
                break;
            }
            case -1487464690: {
                String string13 = "image/heif";
                boolean bl12 = string2.equals(string13);
                if (!bl12) break;
                n10 = 4;
                break;
            }
            case -1487464693: {
                String string14 = "image/heic";
                boolean bl13 = string2.equals(string14);
                if (!bl13) break;
                n10 = 3;
                break;
            }
            case -1594371159: {
                String string15 = "image/x-sony-arw";
                boolean bl14 = string2.equals(string15);
                if (!bl14) break;
                n10 = 2;
                break;
            }
            case -1635437028: {
                String string16 = "image/x-samsung-srw";
                boolean bl15 = string2.equals(string16);
                if (!bl15) break;
                n10 = n12;
                break;
            }
            case -1875291391: {
                String string17 = "image/x-fuji-raf";
                boolean bl16 = string2.equals(string17);
                if (!bl16) break;
                n10 = 0;
                locale = null;
            }
        }
        switch (n10) {
            default: {
                return false;
            }
            case 0: 
            case 1: 
            case 2: 
            case 3: 
            case 4: 
            case 5: 
            case 6: 
            case 7: 
            case 8: 
            case 9: 
            case 10: 
            case 11: 
            case 12: 
            case 13: 
            case 14: 
        }
        return n12 != 0;
    }

    private boolean isThumbnail(HashMap object) {
        ExifInterface$ExifAttribute exifInterface$ExifAttribute = (ExifInterface$ExifAttribute)((HashMap)object).get(TAG_IMAGE_LENGTH);
        Object object2 = TAG_IMAGE_WIDTH;
        object = (ExifInterface$ExifAttribute)((HashMap)object).get(object2);
        if (exifInterface$ExifAttribute != null && object != null) {
            object2 = this.mExifByteOrder;
            int n10 = exifInterface$ExifAttribute.getIntValue((ByteOrder)object2);
            object2 = this.mExifByteOrder;
            int n11 = ((ExifInterface$ExifAttribute)object).getIntValue((ByteOrder)object2);
            int n12 = 512;
            if (n10 <= n12 && n11 <= n12) {
                return true;
            }
        }
        return false;
    }

    private boolean isWebpFormat(byte[] byArray) {
        byte by2;
        byte[] byArray2;
        int n10;
        int n11;
        for (n11 = 0; n11 < (n10 = (byArray2 = WEBP_SIGNATURE_1).length); ++n11) {
            n10 = byArray[n11];
            by2 = byArray2[n11];
            if (n10 == by2) continue;
            return false;
        }
        for (n11 = 0; n11 < (n10 = (byArray2 = WEBP_SIGNATURE_2).length); ++n11) {
            byte[] byArray3 = WEBP_SIGNATURE_1;
            n10 = byArray3.length + n11 + 4;
            by2 = byArray2[n11];
            if ((n10 = byArray[n10]) == by2) continue;
            return false;
        }
        return true;
    }

    /*
     * Exception decompiling
     */
    private void loadAttributes(InputStream var1_1) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Back jump on a try block [egrp 25[TRYBLOCK] [54 : 417->420)] java.lang.Throwable
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op02WithProcessedDataAndRefs.insertExceptionBlocks(Op02WithProcessedDataAndRefs.java:2289)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:414)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1042)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:929)
         *     at org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:257)
         *     at org.benf.cfr.reader.Driver.doJar(Driver.java:139)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:73)
         *     at org.benf.cfr.reader.Main.main(Main.java:49)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static Long parseDateTime(String string2, String string3, String string4) {
        long l10;
        long l11;
        long l12;
        block11: {
            if (string2 == null) return null;
            Object object = NON_ZERO_TIME_PATTERN.matcher(string2);
            boolean bl2 = ((Matcher)object).matches();
            if (!bl2) {
                return null;
            }
            int n10 = 0;
            object = new ParsePosition(0);
            Cloneable cloneable = sFormatterPrimary;
            cloneable = ((SimpleDateFormat)cloneable).parse(string2, (ParsePosition)object);
            if (cloneable == null) {
                cloneable = sFormatterSecondary;
                if ((cloneable = ((SimpleDateFormat)cloneable).parse(string2, (ParsePosition)object)) == null) {
                    return null;
                }
            }
            l12 = ((Date)cloneable).getTime();
            if (string4 == null) break block11;
            int n11 = 1;
            object = string4.substring(0, n11);
            n10 = 3;
            String string5 = string4.substring(n11, n10);
            int n12 = Integer.parseInt(string5);
            int n13 = 6;
            int n14 = 4;
            String string6 = string4.substring(n14, n13);
            n13 = Integer.parseInt(string6);
            String string7 = "+";
            boolean bl3 = string7.equals(object);
            String string8 = "-";
            if ((bl3 || (bl3 = string8.equals(object))) && (l11 = (long)(string7 = ":").equals(string4 = string4.substring(n10, n14))) != false && n12 <= (l11 = (long)14)) {
                block12: {
                    n12 = (n12 * 60 + n13) * 60 * 1000;
                    l11 = (long)string8.equals(object);
                    if (l11 != false) break block12;
                    n11 = -1;
                }
                l10 = n12 *= n11;
                l12 += l10;
            }
        }
        if (string3 == null) return l12;
        try {
            try {
                long l13;
                long l14 = Long.parseLong(string3);
                while ((l11 = (l13 = l14 - (l10 = 1000L)) == 0L ? 0 : (l13 < 0L ? -1 : 1)) > 0) {
                    l10 = 10;
                    l14 /= l10;
                }
                l12 += l14;
                return l12;
            }
            catch (NumberFormatException numberFormatException) {
                return l12;
            }
        }
        catch (IllegalArgumentException illegalArgumentException) {}
        return null;
    }

    private void parseTiffHeaders(ExifInterface$ByteOrderedDataInputStream object, int n10) {
        Object object2 = this.readByteOrder((ExifInterface$ByteOrderedDataInputStream)object);
        this.mExifByteOrder = object2;
        ((ExifInterface$ByteOrderedDataInputStream)object).setByteOrder((ByteOrder)object2);
        int n11 = ((ExifInterface$ByteOrderedDataInputStream)object).readUnsignedShort();
        int n12 = this.mMimeType;
        int n13 = 7;
        if (n12 != n13 && n12 != (n13 = 10) && n11 != (n12 = 42)) {
            CharSequence charSequence = new StringBuilder();
            charSequence.append("Invalid start code: ");
            object2 = Integer.toHexString(n11);
            charSequence.append((String)object2);
            charSequence = charSequence.toString();
            object = new IOException((String)charSequence);
            throw object;
        }
        n11 = ((ExifInterface$ByteOrderedDataInputStream)object).readInt();
        if (n11 >= (n12 = 8) && n11 < n10) {
            int n14;
            if ((n11 += -8) > 0 && (n14 = ((ExifInterface$ByteOrderedDataInputStream)object).skipBytes(n11)) != n11) {
                CharSequence charSequence = new StringBuilder();
                charSequence.append("Couldn't jump to first Ifd: ");
                charSequence.append(n11);
                charSequence = charSequence.toString();
                object = new IOException((String)charSequence);
                throw object;
            }
            return;
        }
        CharSequence charSequence = new StringBuilder();
        charSequence.append("Invalid first Ifd offset: ");
        charSequence.append(n11);
        charSequence = charSequence.toString();
        object = new IOException((String)charSequence);
        throw object;
    }

    private void printAttributes() {
        Object object;
        int n10;
        for (int i10 = 0; i10 < (n10 = ((HashMap[])(object = this.mAttributes)).length); ++i10) {
            boolean bl2;
            object = new StringBuilder();
            ((StringBuilder)object).append("The size of tag group[");
            ((StringBuilder)object).append(i10);
            ((StringBuilder)object).append("]: ");
            int n11 = this.mAttributes[i10].size();
            ((StringBuilder)object).append(n11);
            object = ((StringBuilder)object).toString();
            String string2 = TAG;
            Log.d((String)string2, (String)object);
            object = this.mAttributes[i10].entrySet().iterator();
            while (bl2 = object.hasNext()) {
                Object object2 = (Map.Entry)object.next();
                ExifInterface$ExifAttribute exifInterface$ExifAttribute = (ExifInterface$ExifAttribute)object2.getValue();
                StringBuilder stringBuilder = new StringBuilder();
                String string3 = "tagName: ";
                stringBuilder.append(string3);
                object2 = (String)object2.getKey();
                stringBuilder.append((String)object2);
                stringBuilder.append(", tagType: ");
                object2 = exifInterface$ExifAttribute.toString();
                stringBuilder.append((String)object2);
                stringBuilder.append(", tagValue: '");
                object2 = this.mExifByteOrder;
                object2 = exifInterface$ExifAttribute.getStringValue((ByteOrder)object2);
                stringBuilder.append((String)object2);
                stringBuilder.append("'");
                object2 = stringBuilder.toString();
                Log.d((String)string2, (String)object2);
            }
        }
    }

    private ByteOrder readByteOrder(ExifInterface$ByteOrderedDataInputStream object) {
        int n10 = ((ExifInterface$ByteOrderedDataInputStream)object).readShort();
        int n11 = 18761;
        CharSequence charSequence = TAG;
        if (n10 != n11) {
            n11 = 19789;
            if (n10 == n11) {
                n10 = (int)(DEBUG ? 1 : 0);
                if (n10 != 0) {
                    object = "readExifSegment: Byte Align MM";
                    Log.d((String)charSequence, (String)object);
                }
                return ByteOrder.BIG_ENDIAN;
            }
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append("Invalid byte order: ");
            object = Integer.toHexString(n10);
            ((StringBuilder)charSequence).append((String)object);
            object = ((StringBuilder)charSequence).toString();
            IOException iOException = new IOException((String)object);
            throw iOException;
        }
        n10 = (int)(DEBUG ? 1 : 0);
        if (n10 != 0) {
            object = "readExifSegment: Byte Align II";
            Log.d((String)charSequence, (String)object);
        }
        return ByteOrder.LITTLE_ENDIAN;
    }

    private void readExifSegment(byte[] byArray, int n10) {
        ExifInterface$ByteOrderedDataInputStream exifInterface$ByteOrderedDataInputStream = new ExifInterface$ByteOrderedDataInputStream(byArray);
        int n11 = byArray.length;
        this.parseTiffHeaders(exifInterface$ByteOrderedDataInputStream, n11);
        this.readImageFileDirectory(exifInterface$ByteOrderedDataInputStream, n10);
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    private void readImageFileDirectory(ExifInterface$ByteOrderedDataInputStream var1_1, int var2_2) {
        block45: {
            var3_3 = this;
            var4_4 = var1_1;
            var5_5 = var2_2;
            var6_6 = this.mAttributesOffsets;
            var7_7 = Integer.valueOf(var1_1.mPosition);
            var6_6.add(var7_7);
            var8_8 = var1_1.mPosition;
            var9_9 = 2;
            var10_10 = var1_1.mLength;
            if ((var8_8 += var9_9) > var10_10) {
                return;
            }
            var8_8 = var1_1.readShort();
            var10_10 = (int)ExifInterface.DEBUG;
            var11_11 = "ExifInterface";
            if (var10_10 != 0) {
                var12_12 = new StringBuilder();
                var13_13 = "numberOfDirectoryEntry: ";
                var12_12.append((String)var13_13);
                var12_12.append(var8_8);
                var12_12 = var12_12.toString();
                Log.d((String)var11_11, (String)var12_12);
            }
            var10_10 = var4_4.mPosition;
            var14_14 = var8_8 * 12;
            if ((var10_10 += var14_14) > (var14_14 = var4_4.mLength) || var8_8 <= 0) break block45;
            var10_10 = 0;
            var12_12 = null;
            var14_14 = 0;
            var13_13 = null;
            while (true) {
                block52: {
                    block65: {
                        block64: {
                            block63: {
                                block57: {
                                    block61: {
                                        block62: {
                                            block58: {
                                                block59: {
                                                    block60: {
                                                        block56: {
                                                            block53: {
                                                                block55: {
                                                                    block54: {
                                                                        block51: {
                                                                            block49: {
                                                                                block50: {
                                                                                    block44: {
                                                                                        block46: {
                                                                                            block48: {
                                                                                                block47: {
                                                                                                    var15_15 /* !! */  = 5;
                                                                                                    if (var14_14 >= var8_8) break;
                                                                                                    var16_16 = var1_1.readUnsignedShort();
                                                                                                    var17_17 = var1_1.readUnsignedShort();
                                                                                                    var18_18 = var1_1.readInt();
                                                                                                    var19_19 = var1_1.peek();
                                                                                                    var20_20 = var19_19;
                                                                                                    var22_21 = 4;
                                                                                                    var20_20 += var22_21;
                                                                                                    var24_22 /* !! */  = ExifInterface.sExifTagMapsForReading;
                                                                                                    var25_23 = var24_22 /* !! */ [var5_5];
                                                                                                    var7_7 = var16_16;
                                                                                                    var7_7 = (ExifInterface$ExifTag)var25_23.get(var7_7);
                                                                                                    var26_24 = ExifInterface.DEBUG;
                                                                                                    var27_25 = 3;
                                                                                                    if (var26_24) {
                                                                                                        var28_26 = new Object[var15_15 /* !! */ ];
                                                                                                        var29_27 = var2_2;
                                                                                                        var28_26[0] = var29_27;
                                                                                                        var29_27 = var16_16;
                                                                                                        var30_28 = 1;
                                                                                                        var28_26[var30_28] = var29_27;
                                                                                                        if (var7_7 != null) {
                                                                                                            var12_12 = var7_7.name;
                                                                                                        } else {
                                                                                                            var10_10 = 0;
                                                                                                            var12_12 = null;
                                                                                                        }
                                                                                                        var31_29 = 2;
                                                                                                        var28_26[var31_29] = var12_12;
                                                                                                        var28_26[var27_25] = var12_12 = Integer.valueOf(var17_17);
                                                                                                        var12_12 = var18_18;
                                                                                                        var32_30 = 4;
                                                                                                        var28_26[var32_30] = var12_12;
                                                                                                        var12_12 = String.format("ifdType: %d, tagNumber: %d, tagName: %s, dataFormat: %d, numberOfComponents: %d", (Object[])var28_26);
                                                                                                        Log.d((String)var11_11, (String)var12_12);
                                                                                                    }
                                                                                                    var10_10 = 7;
                                                                                                    if (var7_7 == null) {
                                                                                                        if (var26_24) {
                                                                                                            var28_26 = new StringBuilder();
                                                                                                            var33_31 = "Skip the tag entry since tag number is not defined: ";
                                                                                                            var28_26.append((String)var33_31);
                                                                                                            var28_26.append(var16_16);
                                                                                                            var28_26 = var28_26.toString();
                                                                                                            Log.d((String)var11_11, (String)var28_26);
                                                                                                        }
lbl82:
                                                                                                        // 5 sources

                                                                                                        while (true) {
                                                                                                            var33_31 = var11_11;
                                                                                                            var34_32 = var14_14;
                                                                                                            break block44;
                                                                                                            break;
                                                                                                        }
                                                                                                    }
                                                                                                    if (var17_17 <= 0 || var17_17 >= (var27_25 = ((Object[])(var28_26 = (Object)ExifInterface.IFD_FORMAT_BYTES_PER_FORMAT)).length)) break block46;
                                                                                                    var27_25 = (int)var7_7.isFormatCompatible(var17_17);
                                                                                                    if (var27_25 != 0) break block47;
                                                                                                    if (!var26_24) ** GOTO lbl82
                                                                                                    var28_26 = new StringBuilder();
                                                                                                    var28_26.append("Skip the tag entry since data format (");
                                                                                                    var33_31 = ExifInterface.IFD_FORMAT_NAMES[var17_17];
                                                                                                    var28_26.append((String)var33_31);
                                                                                                    var28_26.append(") is unexpected for tag: ");
                                                                                                    var33_31 = var7_7.name;
                                                                                                    var28_26.append((String)var33_31);
                                                                                                    var28_26 = var28_26.toString();
                                                                                                    Log.d((String)var11_11, (String)var28_26);
                                                                                                    ** continue;
                                                                                                }
                                                                                                if (var17_17 == var10_10) {
                                                                                                    var17_17 = var7_7.primaryFormat;
                                                                                                }
                                                                                                var33_31 = var11_11;
                                                                                                var35_33 = var18_18;
                                                                                                var15_15 /* !! */  = (int)var28_26[var17_17];
                                                                                                var34_32 = var14_14;
                                                                                                var37_34 = var15_15 /* !! */ ;
                                                                                                cfr_temp_0 = (var35_33 *= var37_34) - (var37_34 = 0L);
                                                                                                var39_35 = (int)(cfr_temp_0 == 0L ? 0 : (cfr_temp_0 < 0L ? -1 : 1));
                                                                                                if (var39_35 < 0 || (var14_14 = (int)((cfr_temp_1 = var35_33 - (var37_34 = 0x7FFFFFFFL)) == 0L ? 0 : (cfr_temp_1 < 0L ? -1 : 1))) > 0) break block48;
                                                                                                var14_14 = 1;
                                                                                                break block49;
                                                                                            }
                                                                                            if (var26_24) {
                                                                                                var13_13 = new StringBuilder();
                                                                                                var28_26 = "Skip the tag entry since the number of components is invalid: ";
                                                                                                var13_13.append((String)var28_26);
                                                                                                var13_13.append(var18_18);
                                                                                                var13_13 = var13_13.toString();
                                                                                                Log.d((String)var33_31, (String)var13_13);
                                                                                            }
                                                                                            break block50;
                                                                                        }
                                                                                        var33_31 = var11_11;
                                                                                        var34_32 = var14_14;
                                                                                        if (var26_24) {
                                                                                            var12_12 = new StringBuilder();
                                                                                            var11_11 = "Skip the tag entry since data format is invalid: ";
                                                                                            var12_12.append((String)var11_11);
                                                                                            var12_12.append(var17_17);
                                                                                            var12_12 = var12_12.toString();
                                                                                            Log.d((String)var33_31, (String)var12_12);
                                                                                        }
                                                                                    }
                                                                                    var35_33 = 0L;
                                                                                }
                                                                                var14_14 = 0;
                                                                                var13_13 = null;
                                                                            }
                                                                            if (var14_14 != 0) break block51;
                                                                            var4_4.seek(var20_20);
                                                                            var39_35 = var8_8;
                                                                            break block52;
                                                                        }
                                                                        var14_14 = (int)(var35_33 == var22_21 ? 0 : (var35_33 < var22_21 ? -1 : 1));
                                                                        var28_26 = "Compression";
                                                                        if (var14_14 <= 0) break block53;
                                                                        var14_14 = var1_1.readInt();
                                                                        var39_35 = var8_8;
                                                                        if (var26_24) {
                                                                            var6_6 = new StringBuilder();
                                                                            var40_36 = var17_17;
                                                                            var41_37 /* !! */  = "seek to data offset: ";
                                                                            var6_6.append((String)var41_37 /* !! */ );
                                                                            var6_6.append(var14_14);
                                                                            var6_6 = var6_6.toString();
                                                                            Log.d((String)var33_31, (String)var6_6);
                                                                        } else {
                                                                            var40_36 = var17_17;
                                                                        }
                                                                        var8_8 = var3_3.mMimeType;
                                                                        var17_17 = 7;
                                                                        if (var8_8 != var17_17) ** GOTO lbl-1000
                                                                        var41_37 /* !! */  = "MakerNote";
                                                                        var6_6 = var7_7.name;
                                                                        var8_8 = (int)var41_37 /* !! */ .equals(var6_6);
                                                                        if (var8_8 == 0) break block54;
                                                                        var3_3.mOrfMakerNoteOffset = var14_14;
                                                                        ** GOTO lbl-1000
                                                                    }
                                                                    var8_8 = 6;
                                                                    if (var5_5 == var8_8 && (var8_8 = (int)(var6_6 = "ThumbnailImage").equals(var41_37 /* !! */  = var7_7.name)) != 0) {
                                                                        var3_3.mOrfThumbnailOffset = var14_14;
                                                                        var3_3.mOrfThumbnailLength = var18_18;
                                                                        var6_6 = var3_3.mExifByteOrder;
                                                                        var6_6 = ExifInterface$ExifAttribute.createUShort(6, (ByteOrder)var6_6);
                                                                        var17_17 = var3_3.mOrfThumbnailOffset;
                                                                        var42_38 = var18_18;
                                                                        var43_39 = var17_17;
                                                                        var45_40 = var3_3.mExifByteOrder;
                                                                        var45_40 = ExifInterface$ExifAttribute.createULong(var43_39, (ByteOrder)var45_40);
                                                                        var17_17 = var3_3.mOrfThumbnailLength;
                                                                        var43_39 = var17_17;
                                                                        var46_41 /* !! */  = var7_7;
                                                                        var7_7 = var3_3.mExifByteOrder;
                                                                        var7_7 = ExifInterface$ExifAttribute.createULong(var43_39, (ByteOrder)var7_7);
                                                                        var41_37 /* !! */  = var3_3.mAttributes;
                                                                        var18_18 = 4;
                                                                        var41_37 /* !! */ [var18_18].put(var28_26, var6_6);
                                                                        var6_6 = var3_3.mAttributes[var18_18];
                                                                        var41_37 /* !! */  = "JPEGInterchangeFormat";
                                                                        var6_6.put(var41_37 /* !! */ , var45_40);
                                                                        var45_40 = var3_3.mAttributes[var18_18];
                                                                        var6_6 = "JPEGInterchangeFormatLength";
                                                                        var45_40.put(var6_6, var7_7);
                                                                    } else lbl-1000:
                                                                    // 3 sources

                                                                    {
                                                                        var46_41 /* !! */  = var7_7;
                                                                        var42_38 = var18_18;
                                                                    }
                                                                    var47_42 = var14_14;
                                                                    var43_39 = var47_42 + var35_33;
                                                                    var9_9 = var4_4.mLength;
                                                                    var49_43 = var35_33;
                                                                    var51_44 = var9_9;
                                                                    var9_9 = (int)(var43_39 == var51_44 ? 0 : (var43_39 < var51_44 ? -1 : 1));
                                                                    if (var9_9 > 0) break block55;
                                                                    var4_4.seek(var47_42);
                                                                    break block56;
                                                                }
                                                                if (var26_24) {
                                                                    var45_40 = new StringBuilder();
                                                                    var6_6 = "Skip the tag entry since data offset is invalid: ";
                                                                    var45_40.append((String)var6_6);
                                                                    var45_40.append(var14_14);
                                                                    var45_40 = var45_40.toString();
                                                                    Log.d((String)var33_31, (String)var45_40);
                                                                }
                                                                var4_4.seek(var20_20);
                                                                break block52;
                                                            }
                                                            var39_35 = var8_8;
                                                            var46_41 /* !! */  = var7_7;
                                                            var49_43 = var35_33;
                                                            var40_36 = var17_17;
                                                            var42_38 = var18_18;
                                                        }
                                                        var45_40 = ExifInterface.sExifPointerTagMap;
                                                        var6_6 = var16_16;
                                                        var45_40 = (Integer)var45_40.get(var6_6);
                                                        if (var26_24) {
                                                            var6_6 = new StringBuilder();
                                                            var6_6.append("nextIfdType: ");
                                                            var6_6.append(var45_40);
                                                            var7_7 = " byteCount: ";
                                                            var6_6.append((String)var7_7);
                                                            var35_33 = var49_43;
                                                            var6_6.append(var49_43);
                                                            var6_6 = var6_6.toString();
                                                            Log.d((String)var33_31, (String)var6_6);
                                                        } else {
                                                            var35_33 = var49_43;
                                                        }
                                                        var8_8 = 8;
                                                        if (var45_40 == null) break block57;
                                                        var51_44 = -1;
                                                        var17_17 = var40_36;
                                                        var53_45 = 3;
                                                        if (var40_36 == var53_45) break block58;
                                                        var53_45 = 4;
                                                        if (var40_36 == var53_45) break block59;
                                                        if (var40_36 == var8_8) break block60;
                                                        var8_8 = 9;
                                                        if (var40_36 != var8_8 && var40_36 != (var8_8 = 13)) break block61;
                                                        var8_8 = var1_1.readInt();
                                                        break block62;
                                                    }
                                                    var8_8 = var1_1.readShort();
                                                    break block62;
                                                }
                                                var51_44 = var1_1.readUnsignedInt();
                                                break block61;
                                            }
                                            var8_8 = var1_1.readUnsignedShort();
                                        }
                                        var51_44 = var8_8;
                                    }
                                    var14_14 = 2;
                                    if (var26_24) {
                                        var6_6 = new Object[var14_14];
                                        var11_11 = var51_44;
                                        var28_26 = null;
                                        var6_6[0] = var11_11;
                                        var54_46 = var46_41 /* !! */ ;
                                        var11_11 = var46_41 /* !! */ .name;
                                        var15_15 /* !! */  = 1;
                                        var6_6[var15_15 /* !! */ ] = var11_11;
                                        var11_11 = "Offset: %d, tagName: %s";
                                        var6_6 = String.format((String)var11_11, (Object[])var6_6);
                                        Log.d((String)var33_31, (String)var6_6);
                                    }
                                    if ((var8_8 = (int)((cfr_temp_2 = var51_44 - (var55_47 = 0L)) == 0L ? 0 : (cfr_temp_2 < 0L ? -1 : 1))) > 0 && (var8_8 = (int)((cfr_temp_3 = var51_44 - (var55_47 = (long)var4_4.mLength)) == 0L ? 0 : (cfr_temp_3 < 0L ? -1 : 1))) < 0) {
                                        var6_6 = var3_3.mAttributesOffsets;
                                        var53_45 = (int)var51_44;
                                        var11_11 = (int)var53_45;
                                        var8_8 = (int)var6_6.contains(var11_11);
                                        if (var8_8 == 0) {
                                            var4_4.seek(var51_44);
                                            var5_5 = var45_40.intValue();
                                            var3_3.readImageFileDirectory((ExifInterface$ByteOrderedDataInputStream)var4_4, var5_5);
                                        } else if (var26_24) {
                                            var6_6 = new StringBuilder();
                                            var11_11 = "Skip jump into the IFD since it has already been read: IfdType ";
                                            var6_6.append((String)var11_11);
                                            var6_6.append(var45_40);
                                            var6_6.append(" (at ");
                                            var6_6.append(var51_44);
                                            var6_6.append(")");
                                            var45_40 = var6_6.toString();
                                            Log.d((String)var33_31, (String)var45_40);
                                        }
                                    } else if (var26_24) {
                                        var45_40 = new StringBuilder();
                                        var6_6 = "Skip jump into the IFD since its offset is invalid: ";
                                        var45_40.append((String)var6_6);
                                        var45_40.append(var51_44);
                                        var45_40 = var45_40.toString();
                                        Log.d((String)var33_31, (String)var45_40);
                                    }
                                    var4_4.seek(var20_20);
                                    break block52;
                                }
                                var17_17 = var40_36;
                                var54_46 = var46_41 /* !! */ ;
                                var14_14 = 2;
                                var5_5 = var1_1.peek();
                                var9_9 = var3_3.mOffsetToExifData;
                                var5_5 += var9_9;
                                var9_9 = (int)var35_33;
                                var7_7 = new byte[var9_9];
                                var4_4.readFully((byte[])var7_7);
                                var11_11 = var28_26;
                                var37_34 = var5_5;
                                var5_5 = var42_38;
                                var22_21 = var37_34;
                                var24_22 /* !! */  = var7_7;
                                var12_12 = new ExifInterface$ExifAttribute(var40_36, var42_38, var37_34, (byte[])var7_7);
                                var45_40 = var3_3.mAttributes[var2_2];
                                var7_7 = var46_41 /* !! */ .name;
                                var45_40.put(var7_7, var12_12);
                                var45_40 = var46_41 /* !! */ .name;
                                var7_7 = "DNGVersion";
                                var5_5 = (int)var7_7.equals(var45_40);
                                if (var5_5 != 0) {
                                    var3_3.mMimeType = var5_5 = 3;
                                }
                                if ((var5_5 = (int)(var7_7 = "Make").equals(var45_40 = var54_46.name)) == 0 && (var5_5 = (int)(var7_7 = "Model").equals(var45_40 = var54_46.name)) == 0) break block63;
                                var45_40 = var3_3.mExifByteOrder;
                                var5_5 = (int)(var45_40 = var12_12.getStringValue((ByteOrder)var45_40)).contains((CharSequence)(var7_7 = "PENTAX"));
                                if (var5_5 != 0) break block64;
                            }
                            if ((var5_5 = (int)var11_11.equals(var45_40 = var54_46.name)) == 0 || (var5_5 = var12_12.getIntValue((ByteOrder)(var45_40 = var3_3.mExifByteOrder))) != (var9_9 = (int)((char)-1))) break block65;
                        }
                        var3_3.mMimeType = var8_8;
                    }
                    if ((var5_5 = (int)((cfr_temp_4 = (var47_42 = (long)var1_1.peek()) - var20_20) == 0L ? 0 : (cfr_temp_4 < 0L ? -1 : 1))) != 0) {
                        var4_4.seek(var20_20);
                    }
                }
                var14_14 = (short)(var34_32 + 1);
                var5_5 = var2_2;
                var11_11 = var33_31;
                var8_8 = var39_35;
                var9_9 = 2;
                var10_10 = 0;
                var12_12 = null;
            }
            var33_31 = var11_11;
            var5_5 = var1_1.peek() + 4;
            if (var5_5 <= (var8_8 = var4_4.mLength)) {
                var5_5 = var1_1.readInt();
                var8_8 = (int)ExifInterface.DEBUG;
                if (var8_8 != 0) {
                    var9_9 = 1;
                    var7_7 = new Object[var9_9];
                    var12_12 = var5_5;
                    var53_45 = 0;
                    var11_11 = null;
                    var7_7[0] = var12_12;
                    var12_12 = "nextIfdOffset: %d";
                    var7_7 = String.format((String)var12_12, (Object[])var7_7);
                    Log.d((String)var33_31, (String)var7_7);
                }
                if ((var53_45 = (cfr_temp_5 = (var51_44 = (long)var5_5) - (var57_48 = 0L)) == 0L ? 0 : (cfr_temp_5 < 0L ? -1 : 1)) > 0 && var5_5 < (var53_45 = (long)var4_4.mLength)) {
                    var11_11 = var3_3.mAttributesOffsets;
                    var13_13 = var5_5;
                    var53_45 = (long)var11_11.contains(var13_13);
                    if (var53_45 == false) {
                        var4_4.seek(var51_44);
                        var45_40 = var3_3.mAttributes;
                        var8_8 = 4;
                        var45_40 = var45_40[var8_8];
                        var5_5 = (int)var45_40.isEmpty();
                        if (var5_5 != 0) {
                            var3_3.readImageFileDirectory((ExifInterface$ByteOrderedDataInputStream)var4_4, var8_8);
                        } else {
                            var45_40 = var3_3.mAttributes[var15_15 /* !! */ ];
                            var5_5 = (int)var45_40.isEmpty();
                            if (var5_5 != 0) {
                                var3_3.readImageFileDirectory((ExifInterface$ByteOrderedDataInputStream)var4_4, var15_15 /* !! */ );
                            }
                        }
                    } else if (var8_8 != 0) {
                        var4_4 = new StringBuilder();
                        var6_6 = "Stop reading file since re-reading an IFD may cause an infinite loop: ";
                        var4_4.append((String)var6_6);
                        var4_4.append(var5_5);
                        var4_4 = var4_4.toString();
                        Log.d((String)var33_31, (String)var4_4);
                    }
                } else if (var8_8 != 0) {
                    var4_4 = new StringBuilder();
                    var6_6 = "Stop reading file since a wrong offset may cause an infinite loop: ";
                    var4_4.append((String)var6_6);
                    var4_4.append(var5_5);
                    var4_4 = var4_4.toString();
                    Log.d((String)var33_31, (String)var4_4);
                }
            }
        }
    }

    private void removeAttribute(String string2) {
        Object object;
        int n10;
        for (int i10 = 0; i10 < (n10 = ((ExifInterface$ExifTag[][])(object = EXIF_TAGS)).length); ++i10) {
            object = this.mAttributes[i10];
            ((HashMap)object).remove(string2);
        }
    }

    private void retrieveJpegImageSize(ExifInterface$ByteOrderedDataInputStream exifInterface$ByteOrderedDataInputStream, int n10) {
        Object object = (ExifInterface$ExifAttribute)this.mAttributes[n10].get(TAG_IMAGE_LENGTH);
        Object object2 = this.mAttributes[n10];
        Object object3 = TAG_IMAGE_WIDTH;
        object2 = (ExifInterface$ExifAttribute)((HashMap)object2).get(object3);
        if (object == null || object2 == null) {
            object = (ExifInterface$ExifAttribute)this.mAttributes[n10].get(TAG_JPEG_INTERCHANGE_FORMAT);
            object2 = this.mAttributes[n10];
            object3 = TAG_JPEG_INTERCHANGE_FORMAT_LENGTH;
            object2 = (ExifInterface$ExifAttribute)((HashMap)object2).get(object3);
            if (object != null && object2 != null) {
                object2 = this.mExifByteOrder;
                int n11 = ((ExifInterface$ExifAttribute)object).getIntValue((ByteOrder)object2);
                object3 = this.mExifByteOrder;
                int n12 = ((ExifInterface$ExifAttribute)object).getIntValue((ByteOrder)object3);
                long l10 = n11;
                exifInterface$ByteOrderedDataInputStream.seek(l10);
                object = new byte[n12];
                exifInterface$ByteOrderedDataInputStream.read((byte[])object);
                exifInterface$ByteOrderedDataInputStream = new ExifInterface$ByteOrderedDataInputStream((byte[])object);
                this.getJpegAttributes(exifInterface$ByteOrderedDataInputStream, n11, n10);
            }
        }
    }

    private void saveJpegAttributes(InputStream object, OutputStream object2) {
        Object object3;
        Object object4;
        boolean bl2 = DEBUG;
        if (bl2) {
            object4 = new StringBuilder();
            ((StringBuilder)object4).append("saveJpegAttributes starting with (inputStream: ");
            ((StringBuilder)object4).append(object);
            ((StringBuilder)object4).append(", outputStream: ");
            ((StringBuilder)object4).append(object2);
            ((StringBuilder)object4).append(")");
            object4 = ((StringBuilder)object4).toString();
            object3 = TAG;
            Log.d((String)object3, (String)object4);
        }
        object4 = new DataInputStream((InputStream)object);
        object3 = ByteOrder.BIG_ENDIAN;
        object = new ExifInterface$ByteOrderedDataOutputStream((OutputStream)object2, (ByteOrder)object3);
        int n10 = ((DataInputStream)object4).readByte();
        object3 = "Invalid marker";
        int n11 = -1;
        if (n10 == n11) {
            ((ExifInterface$ByteOrderedDataOutputStream)object).writeByte(n11);
            n10 = ((DataInputStream)object4).readByte();
            int n12 = -40;
            if (n10 == n12) {
                int n13;
                int n14;
                ((ExifInterface$ByteOrderedDataOutputStream)object).writeByte(n12);
                n10 = 0;
                object2 = null;
                Object object5 = TAG_XMP;
                String string2 = this.getAttribute((String)object5);
                if (string2 != null && (n14 = this.mXmpIsFromSeparateMarker) != 0) {
                    object2 = (ExifInterface$ExifAttribute)this.mAttributes[0].remove(object5);
                }
                ((ExifInterface$ByteOrderedDataOutputStream)object).writeByte(n11);
                n14 = -31;
                ((ExifInterface$ByteOrderedDataOutputStream)object).writeByte(n14);
                this.writeExifSegment((ExifInterface$ByteOrderedDataOutputStream)object);
                if (object2 != null) {
                    HashMap hashMap = this.mAttributes[0];
                    hashMap.put(object5, object2);
                }
                n10 = 4096;
                object5 = new byte[n10];
                block0: while ((n13 = ((DataInputStream)object4).readByte()) == n11) {
                    int n15;
                    n13 = ((DataInputStream)object4).readByte();
                    if (n13 != (n15 = -39) && n13 != (n15 = -38)) {
                        String string3 = "Invalid length";
                        if (n13 != n14) {
                            ((ExifInterface$ByteOrderedDataOutputStream)object).writeByte(n11);
                            ((ExifInterface$ByteOrderedDataOutputStream)object).writeByte(n13);
                            n13 = ((DataInputStream)object4).readUnsignedShort();
                            ((ExifInterface$ByteOrderedDataOutputStream)object).writeUnsignedShort(n13);
                            if ((n13 += -2) >= 0) {
                                while (n13 > 0) {
                                    n15 = Math.min(n13, n10);
                                    if ((n15 = ((DataInputStream)object4).read((byte[])object5, 0, n15)) < 0) continue block0;
                                    ((ExifInterface$ByteOrderedDataOutputStream)object).write((byte[])object5, 0, n15);
                                    n13 -= n15;
                                }
                                continue;
                            }
                            object = new IOException(string3);
                            throw object;
                        }
                        int n16 = ((DataInputStream)object4).readUnsignedShort() + -2;
                        if (n16 >= 0) {
                            int n17 = 6;
                            byte[] byArray = new byte[n17];
                            if (n16 >= n17) {
                                int n18 = ((DataInputStream)object4).read(byArray);
                                if (n18 == n17) {
                                    byte[] byArray2 = IDENTIFIER_EXIF_APP1;
                                    n18 = (int)(Arrays.equals(byArray, byArray2) ? 1 : 0);
                                    if (n18 != 0) {
                                        n13 = ((DataInputStream)object4).skipBytes(n16 += -6);
                                        if (n13 == n16) continue;
                                        object = new IOException(string3);
                                        throw object;
                                    }
                                } else {
                                    object = new IOException("Invalid exif");
                                    throw object;
                                }
                            }
                            ((ExifInterface$ByteOrderedDataOutputStream)object).writeByte(n11);
                            ((ExifInterface$ByteOrderedDataOutputStream)object).writeByte(n13);
                            n13 = n16 + 2;
                            ((ExifInterface$ByteOrderedDataOutputStream)object).writeUnsignedShort(n13);
                            if (n16 >= n17) {
                                n16 += -6;
                                ((ExifInterface$ByteOrderedDataOutputStream)object).write(byArray);
                            }
                            while (n16 > 0) {
                                n13 = Math.min(n16, n10);
                                if ((n13 = ((DataInputStream)object4).read((byte[])object5, 0, n13)) < 0) continue block0;
                                ((ExifInterface$ByteOrderedDataOutputStream)object).write((byte[])object5, 0, n13);
                                n16 -= n13;
                            }
                            continue;
                        }
                        object = new IOException(string3);
                        throw object;
                    }
                    ((ExifInterface$ByteOrderedDataOutputStream)object).writeByte(n11);
                    ((ExifInterface$ByteOrderedDataOutputStream)object).writeByte(n13);
                    ExifInterface.copy((InputStream)object4, (OutputStream)object);
                    return;
                }
                object = new IOException((String)object3);
                throw object;
            }
            object = new IOException((String)object3);
            throw object;
        }
        object = new IOException((String)object3);
        throw object;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void savePngAttributes(InputStream closeable, OutputStream object) {
        void var1_4;
        block8: {
            int n13;
            ByteArrayOutputStream byteArrayOutputStream;
            int n10;
            Object object2;
            Object object3;
            boolean bl2 = DEBUG;
            if (bl2) {
                object3 = new StringBuilder();
                ((StringBuilder)object3).append("savePngAttributes starting with (inputStream: ");
                ((StringBuilder)object3).append(closeable);
                ((StringBuilder)object3).append(", outputStream: ");
                ((StringBuilder)object3).append(object);
                ((StringBuilder)object3).append(")");
                object3 = ((StringBuilder)object3).toString();
                object2 = TAG;
                Log.d((String)object2, (String)object3);
            }
            object3 = new DataInputStream((InputStream)closeable);
            object2 = ByteOrder.BIG_ENDIAN;
            closeable = new ExifInterface$ByteOrderedDataOutputStream((OutputStream)object, (ByteOrder)object2);
            object = PNG_SIGNATURE;
            int n11 = ((Object)object).length;
            ExifInterface.copy((InputStream)object3, (OutputStream)closeable, n11);
            n11 = this.mOffsetToExifData;
            int n12 = 4;
            if (n11 == 0) {
                n10 = ((DataInputStream)object3).readInt();
                ((ExifInterface$ByteOrderedDataOutputStream)closeable).writeInt(n10);
                n10 = n10 + n12 + n12;
                ExifInterface.copy((InputStream)object3, (OutputStream)closeable, n10);
            } else {
                n10 = ((Object)object).length;
                n11 = n11 - n10 - n12 - n12;
                ExifInterface.copy((InputStream)object3, (OutputStream)closeable, n11);
                n10 = ((DataInputStream)object3).readInt() + n12 + n12;
                ((DataInputStream)object3).skipBytes(n10);
            }
            n10 = 0;
            object = null;
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
            }
            catch (Throwable throwable) {
                // empty catch block
                break block8;
            }
            try {
                object = new ExifInterface$ByteOrderedDataOutputStream(byteArrayOutputStream, (ByteOrder)object2);
                this.writeExifSegment((ExifInterface$ByteOrderedDataOutputStream)object);
                object = ((ExifInterface$ByteOrderedDataOutputStream)object).mOutputStream;
                object = (ByteArrayOutputStream)object;
                object = ((ByteArrayOutputStream)object).toByteArray();
                ((ExifInterface$ByteOrderedDataOutputStream)closeable).write((byte[])object);
                object2 = new CRC32();
                n13 = ((Object)object).length - n12;
            }
            catch (Throwable throwable) {
                object = byteArrayOutputStream;
                break block8;
            }
            {
                ((CRC32)object2).update((byte[])object, n12, n13);
                long l10 = ((CRC32)object2).getValue();
                n10 = (int)l10;
                ((ExifInterface$ByteOrderedDataOutputStream)closeable).writeInt(n10);
            }
            ExifInterface.closeQuietly(byteArrayOutputStream);
            ExifInterface.copy((InputStream)object3, (OutputStream)closeable);
            return;
        }
        ExifInterface.closeQuietly((Closeable)object);
        throw var1_4;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void saveWebpAttributes(InputStream var1_1, OutputStream var2_2) {
        block31: {
            block32: {
                block33: {
                    block35: {
                        block34: {
                            var3_3 = this;
                            var4_4 = var1_1;
                            var5_10 = var2_2;
                            var6_11 = ExifInterface.DEBUG;
                            if (var6_11 != 0) {
                                var7_12 = new StringBuilder();
                                var7_12.append("saveWebpAttributes starting with (inputStream: ");
                                var7_12.append(var1_1);
                                var7_12.append(", outputStream: ");
                                var7_12.append(var2_2);
                                var7_12.append(")");
                                var7_12 = var7_12.toString();
                                var8_13 = "ExifInterface";
                                Log.d((String)var8_13, (String)var7_12);
                            }
                            var8_13 = ByteOrder.LITTLE_ENDIAN;
                            var7_12 = new ExifInterface$ByteOrderedDataInputStream((InputStream)var4_4, (ByteOrder)var8_13);
                            var9_14 = new ExifInterface$ByteOrderedDataOutputStream((OutputStream)var5_10, (ByteOrder)var8_13);
                            var5_10 = ExifInterface.WEBP_SIGNATURE_1;
                            var10_15 = ((Object)var5_10).length;
                            ExifInterface.copy((InputStream)var7_12, var9_14, var10_15);
                            var11_16 = ExifInterface.WEBP_SIGNATURE_2;
                            var12_17 = var11_16.length;
                            var13_18 /* !! */  = 4;
                            var7_12.skipBytes(var12_17 += var13_18 /* !! */ );
                            var12_17 = 0;
                            var14_19 = null;
                            try {
                                var15_20 = new ByteArrayOutputStream();
                            }
                            catch (Throwable var4_7) {
                                break block31;
                            }
                            catch (Exception var4_8) {
                                // empty catch block
                                ** GOTO lbl-1000
                            }
                            var16_21 = new ExifInterface$ByteOrderedDataOutputStream(var15_20, (ByteOrder)var8_13);
                            var17_22 = var3_3.mOffsetToExifData;
                            if (var17_22 == 0) break block34;
                            var18_23 = ((Object)var5_10).length + var13_18 /* !! */ ;
                            var19_24 = var11_16.length;
                            var17_22 = var17_22 - (var18_23 += var19_24) - var13_18 /* !! */  - var13_18 /* !! */ ;
                            ExifInterface.copy((InputStream)var7_12, var16_21, var17_22);
                            var7_12.skipBytes(var13_18 /* !! */ );
                            var18_23 = var7_12.readInt();
                            var7_12.skipBytes(var18_23);
                            var3_3.writeExifSegment(var16_21);
                            ** GOTO lbl214
                        }
                        var5_10 = new byte[var13_18 /* !! */ ];
                        var17_22 = var7_12.read((byte[])var5_10);
                        if (var17_22 != var13_18 /* !! */ ) break block32;
                        var8_13 = ExifInterface.WEBP_CHUNK_TYPE_VP8X;
                        var10_15 = (int)Arrays.equals((byte[])var5_10, (byte[])var8_13);
                        var20_26 = 8;
                        var21_27 = 1;
                        var22_28 = 0;
                        if (var10_15 == 0) ** GOTO lbl108
                        var19_25 = var7_12.readInt();
                        var10_15 = var19_25 % 2;
                        var10_15 = var10_15 == var21_27 ? var19_25 + 1 : var19_25;
                        var11_16 = new byte[var10_15];
                        var7_12.read(var11_16);
                        var23_29 = var11_16[0];
                        var20_26 = (byte)(var20_26 | var23_29);
                        var11_16[0] = var20_26;
                        var20_26 = var11_16[0] >> var21_27 & var21_27;
                        if (var20_26 != var21_27) {
                            var21_27 = 0;
                            var24_31 = null;
                        }
                        var16_21.write((byte[])var8_13);
                        var16_21.writeInt(var19_25);
                        var16_21.write(var11_16);
                        if (var21_27 == 0) break block35;
                        var5_10 = ExifInterface.WEBP_CHUNK_TYPE_ANIM;
                        var3_3.copyChunksUpToGivenChunkType((ExifInterface$ByteOrderedDataInputStream)var7_12, var16_21, (byte[])var5_10, null);
                        while (true) {
                            block36: {
                                var5_10 = new byte[var13_18 /* !! */ ];
                                var4_4.read((byte[])var5_10);
                                var8_13 = ExifInterface.WEBP_CHUNK_TYPE_ANMF;
                                var17_22 = (int)Arrays.equals((byte[])var5_10, (byte[])var8_13);
                                if (var17_22 != 0) break block36;
                                var3_3.writeExifSegment(var16_21);
                                ** GOTO lbl214
                            }
                            var3_3.copyWebPChunk((ExifInterface$ByteOrderedDataInputStream)var7_12, var16_21, (byte[])var5_10);
                        }
                    }
                    var4_4 = ExifInterface.WEBP_CHUNK_TYPE_VP8;
                    var5_10 = ExifInterface.WEBP_CHUNK_TYPE_VP8L;
                    var3_3.copyChunksUpToGivenChunkType((ExifInterface$ByteOrderedDataInputStream)var7_12, var16_21, (byte[])var4_4, (byte[])var5_10);
                    var3_3.writeExifSegment(var16_21);
                    ** GOTO lbl214
lbl108:
                    // 1 sources

                    var4_4 = ExifInterface.WEBP_CHUNK_TYPE_VP8;
                    var10_15 = (int)Arrays.equals((byte[])var5_10, (byte[])var4_4);
                    if (var10_15 == 0 && (var10_15 = (int)Arrays.equals((byte[])var5_10, var11_16 = ExifInterface.WEBP_CHUNK_TYPE_VP8L)) == 0) ** GOTO lbl214
                    var10_15 = var7_12.readInt();
                    var12_17 = var10_15 % 2;
                    var12_17 = var12_17 == var21_27 ? var10_15 + 1 : var10_15;
                    var23_30 = 3;
                    var25_34 = new byte[var23_30];
                    var26_35 = Arrays.equals((byte[])var5_10, (byte[])var4_4);
                    var13_18 /* !! */  = 47;
                    if (var26_35 != 0) {
                        var7_12.read(var25_34);
                        var24_32 = new byte[var23_30];
                        var20_26 = var7_12.read(var24_32);
                        if (var20_26 == var23_30 && (var20_26 = (int)Arrays.equals(var27_36 = ExifInterface.WEBP_VP8_SIGNATURE, var24_32)) != 0) {
                            var20_26 = var7_12.readInt();
                            var21_27 = var20_26 << 18 >> 18;
                            var23_30 = var20_26 << 2 >> 18;
                            var12_17 += -10;
                            var28_38 = 0;
                            break block33;
                        } else {
                            var5_10 = "Encountered error while checking VP8 signature";
                            var4_4 = new IOException((String)var5_10);
                            throw var4_4;
                        }
                    }
                    var27_37 = ExifInterface.WEBP_CHUNK_TYPE_VP8L;
                    var20_26 = (int)Arrays.equals((byte[])var5_10, var27_37);
                    if (var20_26 != 0) {
                        var20_26 = var7_12.readByte();
                        if (var20_26 != var13_18 /* !! */ ) {
                            var5_10 = "Encountered error while checking VP8L signature";
                            var4_4 = new IOException((String)var5_10);
                            throw var4_4;
                        }
                        var20_26 = var7_12.readInt();
                        var23_30 = (var20_26 << 18 >> 18) + var21_27;
                        var21_27 = (var20_26 << 4 >> 18) + 1;
                        var28_38 = var20_26 & 8;
                        var12_17 += -5;
                        var29_39 = var23_30;
                        var23_30 = var21_27;
                        var21_27 = var29_39;
                    } else {
                        var20_26 = 0;
                        var27_37 = null;
                        var21_27 = 0;
                        var24_33 = null;
                        var23_30 = 0;
                        var28_38 = 0;
                    }
                }
                var16_21.write((byte[])var8_13);
                var17_22 = 10;
                var16_21.writeInt(var17_22);
                var8_13 = new byte[var17_22];
                var30_40 /* !! */  = var8_13[0];
                var26_35 = 8;
                var13_18 /* !! */  = (byte)(var30_40 /* !! */  | 8);
                var8_13[0] = var13_18 /* !! */ ;
                var13_18 /* !! */  = (int)var8_13[0];
                var30_40 /* !! */  = 4;
                var13_18 /* !! */  = (byte)(var13_18 /* !! */  | (var28_38 <<= 4));
                var8_13[0] = var13_18 /* !! */ ;
                var23_30 += -1;
                var13_18 /* !! */  = (byte)(var21_27 += -1);
                var8_13[var30_40 /* !! */ ] = var13_18 /* !! */ ;
                var13_18 /* !! */  = 5;
                var22_28 = (byte)(var21_27 >> 8);
                var8_13[var13_18 /* !! */ ] = var22_28;
                var13_18 /* !! */  = 6;
                var21_27 = (byte)(var21_27 >> 16);
                var8_13[var13_18 /* !! */ ] = var21_27;
                var13_18 /* !! */  = 7;
                var21_27 = (byte)var23_30;
                var8_13[var13_18 /* !! */ ] = var21_27;
                var13_18 /* !! */  = (byte)(var23_30 >> 8);
                var21_27 = 8;
                var8_13[var21_27] = var13_18 /* !! */ ;
                var13_18 /* !! */  = 9;
                var21_27 = (byte)(var23_30 >> 16);
                var8_13[var13_18 /* !! */ ] = var21_27;
                var16_21.write((byte[])var8_13);
                var16_21.write((byte[])var5_10);
                var16_21.writeInt(var10_15);
                var18_23 = (int)Arrays.equals((byte[])var5_10, (byte[])var4_4);
                if (var18_23 != 0) {
                    var16_21.write(var25_34);
                    var4_4 = ExifInterface.WEBP_VP8_SIGNATURE;
                    var16_21.write((byte[])var4_4);
                    var16_21.writeInt(var20_26);
                } else {
                    var4_4 = ExifInterface.WEBP_CHUNK_TYPE_VP8L;
                    var18_23 = (int)Arrays.equals((byte[])var5_10, (byte[])var4_4);
                    if (var18_23 != 0) {
                        var18_23 = 47;
                        var16_21.write(var18_23);
                        var16_21.writeInt(var20_26);
                    }
                }
                ExifInterface.copy((InputStream)var7_12, var16_21, var12_17);
                var3_3.writeExifSegment(var16_21);
lbl214:
                // 5 sources

                ExifInterface.copy((InputStream)var7_12, var16_21);
                var18_23 = var15_20.size();
                var5_10 = ExifInterface.WEBP_SIGNATURE_2;
                var6_11 = ((Object)var5_10).length;
                var9_14.writeInt(var18_23 += var6_11);
                var9_14.write((byte[])var5_10);
                var15_20.writeTo(var9_14);
                ExifInterface.closeQuietly(var15_20);
                return;
            }
            try {
                var5_10 = "Encountered invalid length while parsing WebP chunk type";
                var4_4 = new IOException((String)var5_10);
                throw var4_4;
            }
            catch (Throwable var4_5) {}
            catch (Exception var4_6) {}
            finally {
                var14_19 = var15_20;
                break block31;
            }
lbl-1000:
            // 1 sources

            {
                var7_12 = "Failed to save WebP file";
                var5_10 = new IOException((String)var7_12, (Throwable)var4_4);
                throw var5_10;
            }
        }
        ExifInterface.closeQuietly(var14_19);
        throw var4_9;
    }

    private void setThumbnailData(ExifInterface$ByteOrderedDataInputStream exifInterface$ByteOrderedDataInputStream) {
        block4: {
            int n10;
            Object object;
            block1: {
                int n11;
                block2: {
                    block3: {
                        object = this.mAttributes;
                        n11 = 4;
                        object = object[n11];
                        ExifInterface$ExifAttribute exifInterface$ExifAttribute = (ExifInterface$ExifAttribute)((HashMap)object).get(TAG_COMPRESSION);
                        n10 = 6;
                        if (exifInterface$ExifAttribute == null) break block1;
                        ByteOrder byteOrder = this.mExifByteOrder;
                        this.mThumbnailCompression = n11 = exifInterface$ExifAttribute.getIntValue(byteOrder);
                        int n12 = 1;
                        if (n11 == n12) break block2;
                        if (n11 == n10) break block3;
                        n10 = 7;
                        if (n11 == n10) break block2;
                        break block4;
                    }
                    this.handleThumbnailFromJfif(exifInterface$ByteOrderedDataInputStream, (HashMap)object);
                    break block4;
                }
                if ((n11 = (int)(this.isSupportedDataType((HashMap)object) ? 1 : 0)) != 0) {
                    this.handleThumbnailFromStrips(exifInterface$ByteOrderedDataInputStream, (HashMap)object);
                }
                break block4;
            }
            this.mThumbnailCompression = n10;
            this.handleThumbnailFromJfif(exifInterface$ByteOrderedDataInputStream, (HashMap)object);
        }
    }

    private static boolean startsWith(byte[] byArray, byte[] byArray2) {
        if (byArray != null && byArray2 != null) {
            int n10 = byArray.length;
            int n11 = byArray2.length;
            if (n10 < n11) {
                return false;
            }
            for (n10 = 0; n10 < (n11 = byArray2.length); ++n10) {
                n11 = byArray[n10];
                byte by2 = byArray2[n10];
                if (n11 == by2) continue;
                return false;
            }
            return true;
        }
        return false;
    }

    private void swapBasedOnImageSize(int n10, int n11) {
        HashMap[] hashMapArray = this.mAttributes[n10];
        int n12 = hashMapArray.isEmpty();
        Object object = TAG;
        if (n12 == 0 && (n12 = (hashMapArray = this.mAttributes[n11]).isEmpty()) == 0) {
            hashMapArray = this.mAttributes[n10];
            Object object2 = TAG_IMAGE_LENGTH;
            hashMapArray = (ExifInterface$ExifAttribute)hashMapArray.get(object2);
            Object object3 = this.mAttributes[n10];
            Object object4 = TAG_IMAGE_WIDTH;
            object3 = (ExifInterface$ExifAttribute)((HashMap)object3).get(object4);
            object2 = (ExifInterface$ExifAttribute)this.mAttributes[n11].get(object2);
            HashMap hashMap = this.mAttributes[n11];
            object4 = (ExifInterface$ExifAttribute)hashMap.get(object4);
            if (hashMapArray != null && object3 != null) {
                if (object2 != null && object4 != null) {
                    object = this.mExifByteOrder;
                    n12 = hashMapArray.getIntValue((ByteOrder)object);
                    object = this.mExifByteOrder;
                    int n13 = ((ExifInterface$ExifAttribute)object3).getIntValue((ByteOrder)object);
                    object3 = this.mExifByteOrder;
                    int n14 = ((ExifInterface$ExifAttribute)object2).getIntValue((ByteOrder)object3);
                    object3 = this.mExifByteOrder;
                    int n15 = ((ExifInterface$ExifAttribute)object4).getIntValue((ByteOrder)object3);
                    if (n12 < n14 && n13 < n15) {
                        hashMapArray = this.mAttributes;
                        object = hashMapArray[n10];
                        hashMapArray[n10] = object2 = hashMapArray[n11];
                        hashMapArray[n11] = object;
                    }
                } else {
                    n10 = (int)(DEBUG ? 1 : 0);
                    if (n10 != 0) {
                        String string2 = "Second image does not contain valid size information";
                        Log.d((String)object, (String)string2);
                    }
                }
            } else {
                n10 = (int)(DEBUG ? 1 : 0);
                if (n10 != 0) {
                    String string3 = "First image does not contain valid size information";
                    Log.d((String)object, (String)string3);
                }
            }
            return;
        }
        n10 = (int)(DEBUG ? 1 : 0);
        if (n10 != 0) {
            String string4 = "Cannot perform swap since only one image data exists";
            Log.d((String)object, (String)string4);
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    private void updateImageSizeValues(ExifInterface$ByteOrderedDataInputStream object, int n10) {
        String string2;
        String string3;
        ExifInterface$ExifAttribute exifInterface$ExifAttribute;
        Object object2;
        ExifInterface$ExifAttribute exifInterface$ExifAttribute2;
        Object object3;
        HashMap[] hashMapArray;
        block9: {
            String string4;
            String string5;
            block10: {
                block8: {
                    int n11;
                    hashMapArray = (ExifInterface$ExifAttribute)this.mAttributes[n10].get(TAG_DEFAULT_CROP_SIZE);
                    object3 = (ExifInterface$ExifAttribute)this.mAttributes[n10].get(TAG_RW2_SENSOR_TOP_BORDER);
                    exifInterface$ExifAttribute2 = (ExifInterface$ExifAttribute)this.mAttributes[n10].get(TAG_RW2_SENSOR_LEFT_BORDER);
                    object2 = (ExifInterface$ExifAttribute)this.mAttributes[n10].get(TAG_RW2_SENSOR_BOTTOM_BORDER);
                    exifInterface$ExifAttribute = (ExifInterface$ExifAttribute)this.mAttributes[n10].get(TAG_RW2_SENSOR_RIGHT_BORDER);
                    string3 = TAG_IMAGE_LENGTH;
                    string2 = TAG_IMAGE_WIDTH;
                    if (hashMapArray == null) break block9;
                    int n12 = hashMapArray.format;
                    int n13 = 5;
                    int n14 = 1;
                    object2 = null;
                    int n15 = 2;
                    string5 = "Invalid crop size values. cropSize=";
                    string4 = TAG;
                    if (n12 == n13) {
                        int n16;
                        object = this.mExifByteOrder;
                        if ((object = (ExifInterface$Rational[])hashMapArray.getValue((ByteOrder)object)) != null && (n16 = ((ExifInterface$Rational[])object).length) == n15) {
                            hashMapArray = object[0];
                            object3 = this.mExifByteOrder;
                            hashMapArray = ExifInterface$ExifAttribute.createURational((ExifInterface$Rational)hashMapArray, (ByteOrder)object3);
                            object = object[n14];
                            object3 = this.mExifByteOrder;
                            object = ExifInterface$ExifAttribute.createURational((ExifInterface$Rational)object, (ByteOrder)object3);
                            break block8;
                        } else {
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append(string5);
                            object = Arrays.toString((Object[])object);
                            stringBuilder.append((String)object);
                            object = stringBuilder.toString();
                            Log.w((String)string4, (String)object);
                            return;
                        }
                    }
                    object = this.mExifByteOrder;
                    if ((object = (Object)((int[])hashMapArray.getValue((ByteOrder)object))) == null || (n11 = ((ExifInterface$Rational[])object).length) != n15) break block10;
                    ExifInterface$Rational exifInterface$Rational = object[0];
                    object3 = this.mExifByteOrder;
                    hashMapArray = ExifInterface$ExifAttribute.createUShort((int)exifInterface$Rational, (ByteOrder)object3);
                    ExifInterface$Rational exifInterface$Rational2 = object[n14];
                    object3 = this.mExifByteOrder;
                    object = ExifInterface$ExifAttribute.createUShort((int)exifInterface$Rational2, (ByteOrder)object3);
                }
                object3 = this.mAttributes[n10];
                ((HashMap)object3).put(string2, hashMapArray);
                hashMapArray = this.mAttributes;
                HashMap hashMap = hashMapArray[n10];
                hashMap.put(string3, object);
                return;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string5);
            object = Arrays.toString((int[])object);
            stringBuilder.append((String)object);
            object = stringBuilder.toString();
            Log.w((String)string4, (String)object);
            return;
        }
        if (object3 != null && exifInterface$ExifAttribute2 != null && object2 != null && exifInterface$ExifAttribute != null) {
            object = this.mExifByteOrder;
            int n17 = ((ExifInterface$ExifAttribute)object3).getIntValue((ByteOrder)object);
            hashMapArray = this.mExifByteOrder;
            int n18 = ((ExifInterface$ExifAttribute)object2).getIntValue((ByteOrder)hashMapArray);
            object3 = this.mExifByteOrder;
            int n19 = exifInterface$ExifAttribute.getIntValue((ByteOrder)object3);
            object2 = this.mExifByteOrder;
            int n20 = exifInterface$ExifAttribute2.getIntValue((ByteOrder)object2);
            if (n18 <= n17) return;
            if (n19 <= n20) return;
            int n21 = n18 - n17;
            object = this.mExifByteOrder;
            object = ExifInterface$ExifAttribute.createUShort(n21, (ByteOrder)object);
            hashMapArray = this.mExifByteOrder;
            hashMapArray = ExifInterface$ExifAttribute.createUShort(n19 -= n20, (ByteOrder)hashMapArray);
            object3 = this.mAttributes[n10];
            ((HashMap)object3).put(string3, object);
            object = this.mAttributes[n10];
            ((HashMap)object).put(string2, hashMapArray);
            return;
        }
        this.retrieveJpegImageSize((ExifInterface$ByteOrderedDataInputStream)object, n10);
    }

    private void validateImages() {
        boolean bl2 = false;
        HashMap[] hashMapArray = null;
        int n10 = 5;
        this.swapBasedOnImageSize(0, n10);
        int n11 = 4;
        this.swapBasedOnImageSize(0, n11);
        this.swapBasedOnImageSize(n10, n11);
        Object object = this.mAttributes;
        int n12 = 1;
        object = (ExifInterface$ExifAttribute)object[n12].get(TAG_PIXEL_X_DIMENSION);
        Object object2 = this.mAttributes[n12];
        Object object3 = TAG_PIXEL_Y_DIMENSION;
        object2 = (ExifInterface$ExifAttribute)((HashMap)object2).get(object3);
        if (object != null && object2 != null) {
            object3 = this.mAttributes[0];
            String string2 = TAG_IMAGE_WIDTH;
            ((HashMap)object3).put(string2, object);
            hashMapArray = this.mAttributes[0];
            object = TAG_IMAGE_LENGTH;
            hashMapArray.put(object, object2);
        }
        if ((bl2 = (hashMapArray = this.mAttributes[n11]).isEmpty()) && (bl2 = this.isThumbnail((HashMap)(hashMapArray = this.mAttributes[n10])))) {
            hashMapArray = this.mAttributes;
            hashMapArray[n11] = object = hashMapArray[n10];
            hashMapArray[n10] = object = new HashMap();
        }
        if (!(bl2 = this.isThumbnail((HashMap)(hashMapArray = this.mAttributes[n11])))) {
            hashMapArray = TAG;
            String string3 = "No image meets the size requirements of a thumbnail image.";
            Log.d((String)hashMapArray, (String)string3);
        }
    }

    private int writeExifSegment(ExifInterface$ByteOrderedDataOutputStream exifInterface$ByteOrderedDataOutputStream) {
        long l10;
        ExifInterface$ExifAttribute exifInterface$ExifAttribute;
        Object object;
        Object object2;
        int n10;
        Object object3;
        Object object4;
        Object object5;
        Object object6;
        Object object7;
        int n11;
        ExifInterface$ExifTag[][] exifInterface$ExifTagArray;
        int n12;
        Object object8;
        int n13;
        ExifInterface exifInterface = this;
        ExifInterface$ByteOrderedDataOutputStream exifInterface$ByteOrderedDataOutputStream2 = exifInterface$ByteOrderedDataOutputStream;
        Object object9 = EXIF_TAGS;
        int n14 = ((ExifInterface$ExifTag[][])object9).length;
        int[] nArray = new int[n14];
        int n15 = ((ExifInterface$ExifTag[][])object9).length;
        object9 = new int[n15];
        Object object10 = EXIF_POINTER_TAGS;
        int n16 = ((ExifInterface$ExifTag[])object10).length;
        Object object11 = null;
        for (n13 = 0; n13 < n16; ++n13) {
            object8 = object10[n13].name;
            exifInterface.removeAttribute((String)object8);
        }
        object10 = ExifInterface.JPEG_INTERCHANGE_FORMAT_TAG.name;
        exifInterface.removeAttribute((String)object10);
        object10 = ExifInterface.JPEG_INTERCHANGE_FORMAT_LENGTH_TAG.name;
        exifInterface.removeAttribute((String)object10);
        object10 = null;
        for (n12 = 0; n12 < (n16 = (exifInterface$ExifTagArray = EXIF_TAGS).length); ++n12) {
            exifInterface$ExifTagArray = exifInterface.mAttributes[n12].entrySet().toArray();
            n13 = exifInterface$ExifTagArray.length;
            object8 = null;
            for (n11 = 0; n11 < n13; ++n11) {
                object7 = (Map.Entry)exifInterface$ExifTagArray[n11];
                object6 = object7.getValue();
                if (object6 != null) continue;
                object6 = exifInterface.mAttributes[n12];
                object7 = object7.getKey();
                ((HashMap)object6).remove(object7);
            }
        }
        object10 = exifInterface.mAttributes;
        n16 = 1;
        object10 = object10[n16];
        n12 = (int)(((HashMap)object10).isEmpty() ? 1 : 0);
        long l11 = 0L;
        if (n12 == 0) {
            object10 = exifInterface.mAttributes[0];
            object7 = ExifInterface.EXIF_POINTER_TAGS[n16].name;
            object6 = exifInterface.mExifByteOrder;
            object6 = ExifInterface$ExifAttribute.createULong(l11, object6);
            ((HashMap)object10).put(object7, object6);
        }
        object10 = exifInterface.mAttributes;
        int n17 = 2;
        n12 = (int)(((HashMap)(object10 = object10[n17])).isEmpty() ? 1 : 0);
        if (n12 == 0) {
            object10 = exifInterface.mAttributes[0];
            object6 = ExifInterface.EXIF_POINTER_TAGS[n17].name;
            object5 = exifInterface.mExifByteOrder;
            object5 = ExifInterface$ExifAttribute.createULong(l11, (ByteOrder)object5);
            ((HashMap)object10).put(object6, object5);
        }
        object10 = exifInterface.mAttributes;
        int n18 = 3;
        n12 = (int)(((HashMap)(object10 = object10[n18])).isEmpty() ? 1 : 0);
        if (n12 == 0) {
            object10 = exifInterface.mAttributes[n16];
            object5 = ExifInterface.EXIF_POINTER_TAGS[n18].name;
            object4 = exifInterface.mExifByteOrder;
            object4 = ExifInterface$ExifAttribute.createULong(l11, (ByteOrder)object4);
            ((HashMap)object10).put(object5, object4);
        }
        n12 = (int)(exifInterface.mHasThumbnail ? 1 : 0);
        int n19 = 4;
        if (n12 != 0) {
            object10 = exifInterface.mAttributes[n19];
            object4 = ExifInterface.JPEG_INTERCHANGE_FORMAT_TAG.name;
            object3 = exifInterface.mExifByteOrder;
            object3 = ExifInterface$ExifAttribute.createULong(l11, (ByteOrder)object3);
            ((HashMap)object10).put(object4, object3);
            object10 = exifInterface.mAttributes[n19];
            object4 = ExifInterface.JPEG_INTERCHANGE_FORMAT_LENGTH_TAG.name;
            n10 = exifInterface.mThumbnailLength;
            long l12 = n10;
            ByteOrder byteOrder = exifInterface.mExifByteOrder;
            object3 = ExifInterface$ExifAttribute.createULong(l12, byteOrder);
            ((HashMap)object10).put(object4, object3);
        }
        object10 = null;
        for (n12 = 0; n12 < (object2 = ((ExifInterface$ExifTag[][])(object4 = EXIF_TAGS)).length); ++n12) {
            object4 = exifInterface.mAttributes[n12].entrySet().iterator();
            n10 = 0;
            object3 = null;
            while ((object = object4.hasNext()) != 0) {
                exifInterface$ExifAttribute = (ExifInterface$ExifAttribute)((Map.Entry)object4.next()).getValue();
                object = exifInterface$ExifAttribute.size();
                if (object <= n19) continue;
                n10 += object;
            }
            object2 = object9[n12] + n10;
            object9[n12] = (ExifInterface$ExifTag[])object2;
        }
        n12 = 8;
        object4 = null;
        for (object2 = 0; object2 < (n10 = ((ExifInterface$ExifTag[][])(object3 = EXIF_TAGS)).length); ++object2) {
            object3 = exifInterface.mAttributes[object2];
            n10 = (int)(((HashMap)object3).isEmpty() ? 1 : 0);
            if (n10 != 0) continue;
            nArray[object2] = n12;
            object3 = exifInterface.mAttributes[object2];
            n10 = ((HashMap)object3).size() * 12 + n17 + n19;
            object = object9[object2];
            n12 += (n10 += object);
        }
        object2 = exifInterface.mHasThumbnail;
        if (object2 != 0) {
            object4 = exifInterface.mAttributes[n19];
            object3 = ExifInterface.JPEG_INTERCHANGE_FORMAT_TAG.name;
            long l13 = n12;
            object11 = exifInterface.mExifByteOrder;
            object11 = ExifInterface$ExifAttribute.createULong(l13, (ByteOrder)object11);
            object4.put(object3, object11);
            exifInterface.mThumbnailOffset = n12;
            n13 = exifInterface.mThumbnailLength;
            n12 += n13;
        }
        if ((n13 = exifInterface.mMimeType) == n19) {
            n12 += 8;
        }
        if ((n13 = (int)(DEBUG ? 1 : 0)) != 0) {
            object11 = null;
            for (n13 = 0; n13 < (n11 = ((ExifInterface$ExifTag[][])(object8 = EXIF_TAGS)).length); ++n13) {
                n11 = 5;
                object8 = new Object[n11];
                object4 = n13;
                object8[0] = object4;
                object4 = nArray[n13];
                object8[n16] = object4;
                object4 = exifInterface.mAttributes[n13].size();
                object8[n17] = object4;
                object2 = object9[n13];
                object4 = object2;
                object8[n18] = object4;
                object4 = n12;
                object8[n19] = object4;
                object8 = String.format("index: %d, offsets: %d, tag count: %d, data sizes: %d, total size: %d", (Object[])object8);
                object4 = TAG;
                Log.d((String)object4, (String)object8);
            }
        }
        if ((n15 = (int)((object9 = exifInterface.mAttributes[n16]).isEmpty() ? 1 : 0)) == 0) {
            object9 = exifInterface.mAttributes[0];
            object11 = ExifInterface.EXIF_POINTER_TAGS[n16].name;
            n11 = nArray[n16];
            l10 = n11;
            object8 = exifInterface.mExifByteOrder;
            object8 = ExifInterface$ExifAttribute.createULong(l10, (ByteOrder)object8);
            object9.put(object11, object8);
        }
        if ((n15 = (int)((object9 = exifInterface.mAttributes[n17]).isEmpty() ? 1 : 0)) == 0) {
            object9 = exifInterface.mAttributes[0];
            object11 = ExifInterface.EXIF_POINTER_TAGS[n17].name;
            n11 = nArray[n17];
            l10 = n11;
            object8 = exifInterface.mExifByteOrder;
            object8 = ExifInterface$ExifAttribute.createULong(l10, (ByteOrder)object8);
            object9.put(object11, object8);
        }
        if ((n15 = (int)((object9 = exifInterface.mAttributes[n18]).isEmpty() ? 1 : 0)) == 0) {
            object9 = exifInterface.mAttributes[n16];
            object11 = ExifInterface.EXIF_POINTER_TAGS[n18].name;
            n11 = nArray[n18];
            l10 = n11;
            object8 = exifInterface.mExifByteOrder;
            object8 = ExifInterface$ExifAttribute.createULong(l10, (ByteOrder)object8);
            object9.put(object11, object8);
        }
        n15 = exifInterface.mMimeType;
        n13 = 14;
        if (n15 != n19) {
            n11 = 13;
            if (n15 != n11) {
                if (n15 == n13) {
                    object9 = WEBP_CHUNK_TYPE_EXIF;
                    exifInterface$ByteOrderedDataOutputStream2.write((byte[])object9);
                    exifInterface$ByteOrderedDataOutputStream2.writeInt(n12);
                }
            } else {
                exifInterface$ByteOrderedDataOutputStream2.writeInt(n12);
                object9 = PNG_CHUNK_TYPE_EXIF;
                exifInterface$ByteOrderedDataOutputStream2.write((byte[])object9);
            }
        } else {
            exifInterface$ByteOrderedDataOutputStream2.writeUnsignedShort(n12);
            object9 = IDENTIFIER_EXIF_APP1;
            exifInterface$ByteOrderedDataOutputStream2.write((byte[])object9);
        }
        object9 = exifInterface.mExifByteOrder;
        object8 = ByteOrder.BIG_ENDIAN;
        n15 = object9 == object8 ? 19789 : 18761;
        exifInterface$ByteOrderedDataOutputStream2.writeShort((short)n15);
        object9 = exifInterface.mExifByteOrder;
        exifInterface$ByteOrderedDataOutputStream2.setByteOrder((ByteOrder)object9);
        exifInterface$ByteOrderedDataOutputStream2.writeUnsignedShort(42);
        l10 = 8;
        exifInterface$ByteOrderedDataOutputStream2.writeUnsignedInt(l10);
        object9 = null;
        for (n15 = 0; n15 < (n11 = ((ExifInterface$ExifTag[][])(object8 = EXIF_TAGS)).length); ++n15) {
            object8 = exifInterface.mAttributes[n15];
            n11 = (int)(((HashMap)object8).isEmpty() ? 1 : 0);
            if (n11 == 0) {
                object8 = exifInterface.mAttributes[n15];
                n11 = ((HashMap)object8).size();
                exifInterface$ByteOrderedDataOutputStream2.writeUnsignedShort(n11);
                n11 = nArray[n15] + n17;
                n18 = exifInterface.mAttributes[n15].size() * 12;
                n11 = n11 + n18 + n19;
                object6 = exifInterface.mAttributes[n15].entrySet().iterator();
                while ((object2 = (Object)object6.hasNext()) != 0) {
                    object4 = (Map.Entry)object6.next();
                    object3 = sExifTagMapsForWriting[n15];
                    exifInterface$ExifAttribute = object4.getKey();
                    object3 = (ExifInterface$ExifTag)((HashMap)object3).get(exifInterface$ExifAttribute);
                    n10 = ((ExifInterface$ExifTag)object3).number;
                    object4 = (ExifInterface$ExifAttribute)object4.getValue();
                    object = object4.size();
                    exifInterface$ByteOrderedDataOutputStream2.writeUnsignedShort(n10);
                    n10 = object4.format;
                    exifInterface$ByteOrderedDataOutputStream2.writeUnsignedShort(n10);
                    n10 = object4.numberOfComponents;
                    exifInterface$ByteOrderedDataOutputStream2.writeInt(n10);
                    if (object > n19) {
                        l10 = n11;
                        exifInterface$ByteOrderedDataOutputStream2.writeUnsignedInt(l10);
                        n11 += object;
                        continue;
                    }
                    object4 = object4.bytes;
                    exifInterface$ByteOrderedDataOutputStream2.write((byte[])object4);
                    if (object >= n19) continue;
                    while (object < n19) {
                        exifInterface$ByteOrderedDataOutputStream2.writeByte(0);
                        ++object;
                    }
                }
                if (n15 == 0 && (n11 = (int)(((HashMap)(object8 = exifInterface.mAttributes[n19])).isEmpty() ? 1 : 0)) == 0) {
                    n11 = nArray[n19];
                    l10 = n11;
                    exifInterface$ByteOrderedDataOutputStream2.writeUnsignedInt(l10);
                    l10 = 0L;
                } else {
                    l10 = 0L;
                    exifInterface$ByteOrderedDataOutputStream2.writeUnsignedInt(l10);
                }
                object8 = exifInterface.mAttributes[n15].entrySet().iterator();
                while ((n18 = (int)(object8.hasNext() ? 1 : 0)) != 0) {
                    object6 = ((ExifInterface$ExifAttribute)((Map.Entry)object8.next()).getValue()).bytes;
                    object = ((V)object6).length;
                    if (object <= n19) continue;
                    object = ((V)object6).length;
                    exifInterface$ByteOrderedDataOutputStream2.write((byte[])object6, 0, (int)object);
                }
                continue;
            }
            l10 = 0L;
        }
        n15 = (int)(exifInterface.mHasThumbnail ? 1 : 0);
        if (n15 != 0) {
            object9 = this.getThumbnailBytes();
            exifInterface$ByteOrderedDataOutputStream2.write((byte[])object9);
        }
        if ((n15 = exifInterface.mMimeType) == n13 && (n15 = n12 % 2) == n16) {
            exifInterface$ByteOrderedDataOutputStream2.writeByte(0);
        }
        object9 = ByteOrder.BIG_ENDIAN;
        exifInterface$ByteOrderedDataOutputStream2.setByteOrder((ByteOrder)object9);
        return n12;
    }

    public void flipHorizontally() {
        String string2;
        String string3 = TAG_ORIENTATION;
        int n10 = 1;
        int n11 = this.getAttributeInt(string3, n10);
        switch (n11) {
            default: {
                n10 = 0;
                string2 = null;
                break;
            }
            case 8: {
                n10 = 7;
                break;
            }
            case 7: {
                n10 = 8;
                break;
            }
            case 6: {
                n10 = 5;
                break;
            }
            case 5: {
                n10 = 6;
                break;
            }
            case 4: {
                n10 = 3;
                break;
            }
            case 3: {
                n10 = 4;
                break;
            }
            case 1: {
                n10 = 2;
            }
            case 2: 
        }
        string2 = Integer.toString(n10);
        this.setAttribute(string3, string2);
    }

    public void flipVertically() {
        String string2;
        String string3 = TAG_ORIENTATION;
        int n10 = 1;
        int n11 = this.getAttributeInt(string3, n10);
        switch (n11) {
            default: {
                n10 = 0;
                string2 = null;
                break;
            }
            case 8: {
                n10 = 5;
                break;
            }
            case 7: {
                n10 = 6;
                break;
            }
            case 6: {
                n10 = 7;
                break;
            }
            case 5: {
                n10 = 8;
                break;
            }
            case 3: {
                n10 = 2;
                break;
            }
            case 2: {
                n10 = 3;
                break;
            }
            case 1: {
                n10 = 4;
            }
            case 4: 
        }
        string2 = Integer.toString(n10);
        this.setAttribute(string3, string2);
    }

    public double getAltitude(double d10) {
        String string2 = TAG_GPS_ALTITUDE;
        double d11 = -1.0;
        double d12 = this.getAttributeDouble(string2, d11);
        String string3 = TAG_GPS_ALTITUDE_REF;
        int n10 = -1;
        int n11 = this.getAttributeInt(string3, n10);
        double d13 = 0.0;
        double d14 = d12 - d13;
        Object object = d14 == 0.0 ? 0 : (d14 > 0.0 ? 1 : -1);
        if (object >= 0 && n11 >= 0) {
            int n12 = 1;
            if (n11 != n12) {
                n10 = n12;
            }
            d10 = n10;
            return d12 * d10;
        }
        return d10;
    }

    public String getAttribute(String object) {
        Objects.requireNonNull(object, "tag shouldn't be null");
        Object[] objectArray = this.getExifAttribute((String)object);
        int n10 = 0;
        if (objectArray != null) {
            Object object2 = sTagSetForCompatibility;
            boolean n11 = ((HashSet)object2).contains(object);
            if (!n11) {
                object = this.mExifByteOrder;
                return objectArray.getStringValue((ByteOrder)object);
            }
            object2 = TAG_GPS_TIMESTAMP;
            boolean bl2 = ((String)object).equals(object2);
            if (bl2) {
                int n12 = objectArray.format;
                int n13 = 5;
                float f10 = 7.0E-45f;
                String string2 = TAG;
                if (n12 != n13) {
                    int n14 = 10;
                    f10 = 1.4E-44f;
                    if (n12 != n14) {
                        object = new StringBuilder();
                        ((StringBuilder)object).append("GPS Timestamp format is not rational. format=");
                        int n15 = objectArray.format;
                        ((StringBuilder)object).append(n15);
                        object = ((StringBuilder)object).toString();
                        Log.w((String)string2, (String)object);
                        return null;
                    }
                }
                object = this.mExifByteOrder;
                if ((object = (ExifInterface$Rational[])objectArray.getValue((ByteOrder)object)) != null) {
                    int n16 = ((Object)object).length;
                    int n17 = 3;
                    f10 = 4.2E-45f;
                    if (n16 == n17) {
                        objectArray = new Object[n17];
                        f10 = ((ExifInterface$Rational)object[0]).numerator;
                        float f11 = ((ExifInterface$Rational)object[0]).denominator;
                        objectArray[0] = object2 = Integer.valueOf((int)(f10 / f11));
                        n10 = 1;
                        f10 = ((ExifInterface$Rational)object[n10]).numerator;
                        f11 = ((ExifInterface$Rational)object[n10]).denominator;
                        objectArray[n10] = object2 = Integer.valueOf((int)(f10 / f11));
                        n10 = 2;
                        f10 = ((ExifInterface$Rational)object[n10]).numerator;
                        float f12 = ((ExifInterface$Rational)object[n10]).denominator;
                        objectArray[n10] = object = Integer.valueOf((int)(f10 / f12));
                        return String.format("%02d:%02d:%02d", objectArray);
                    }
                }
                objectArray = new StringBuilder();
                objectArray.append("Invalid GPS Timestamp array. array=");
                object = Arrays.toString((Object[])object);
                objectArray.append((String)object);
                object = objectArray.toString();
                Log.w((String)string2, (String)object);
                return null;
            }
            try {
                object = this.mExifByteOrder;
            }
            catch (NumberFormatException numberFormatException) {}
            double d10 = objectArray.getDoubleValue((ByteOrder)object);
            return Double.toString(d10);
        }
        return null;
    }

    public byte[] getAttributeBytes(String object) {
        String string2 = "tag shouldn't be null";
        Objects.requireNonNull(object, string2);
        object = this.getExifAttribute((String)object);
        if (object != null) {
            return ((ExifInterface$ExifAttribute)object).bytes;
        }
        return null;
    }

    public double getAttributeDouble(String object, double d10) {
        Object object2 = "tag shouldn't be null";
        Objects.requireNonNull(object, (String)object2);
        object = this.getExifAttribute((String)object);
        if (object == null) {
            return d10;
        }
        try {
            object2 = this.mExifByteOrder;
        }
        catch (NumberFormatException numberFormatException) {
            return d10;
        }
        return ((ExifInterface$ExifAttribute)object).getDoubleValue((ByteOrder)object2);
    }

    public int getAttributeInt(String object, int n10) {
        Object object2 = "tag shouldn't be null";
        Objects.requireNonNull(object, (String)object2);
        object = this.getExifAttribute((String)object);
        if (object == null) {
            return n10;
        }
        try {
            object2 = this.mExifByteOrder;
        }
        catch (NumberFormatException numberFormatException) {
            return n10;
        }
        return ((ExifInterface$ExifAttribute)object).getIntValue((ByteOrder)object2);
    }

    public long[] getAttributeRange(String object) {
        Object object2 = "tag shouldn't be null";
        Objects.requireNonNull(object, (String)object2);
        boolean bl2 = this.mModified;
        if (!bl2) {
            if ((object = this.getExifAttribute((String)object)) != null) {
                object2 = new long[2];
                long l10 = ((ExifInterface$ExifAttribute)object).bytesOffset;
                object2[0] = l10;
                l10 = ((ExifInterface$ExifAttribute)object).bytes.length;
                object2[1] = l10;
                return object2;
            }
            return null;
        }
        object = new IllegalStateException("The underlying file has been modified since being parsed");
        throw object;
    }

    public Long getDateTime() {
        String string2 = this.getAttribute(TAG_DATETIME);
        String string3 = this.getAttribute(TAG_SUBSEC_TIME);
        String string4 = this.getAttribute(TAG_OFFSET_TIME);
        return ExifInterface.parseDateTime(string2, string3, string4);
    }

    public Long getDateTimeDigitized() {
        String string2 = this.getAttribute(TAG_DATETIME_DIGITIZED);
        String string3 = this.getAttribute(TAG_SUBSEC_TIME_DIGITIZED);
        String string4 = this.getAttribute(TAG_OFFSET_TIME_DIGITIZED);
        return ExifInterface.parseDateTime(string2, string3, string4);
    }

    public Long getDateTimeOriginal() {
        String string2 = this.getAttribute(TAG_DATETIME_ORIGINAL);
        String string3 = this.getAttribute(TAG_SUBSEC_TIME_ORIGINAL);
        String string4 = this.getAttribute(TAG_OFFSET_TIME_ORIGINAL);
        return ExifInterface.parseDateTime(string2, string3, string4);
    }

    public Long getGpsDateTime() {
        boolean bl2;
        Object object;
        Matcher matcher;
        boolean bl3;
        String string2 = this.getAttribute(TAG_GPS_DATESTAMP);
        Object object2 = this.getAttribute(TAG_GPS_TIMESTAMP);
        if (string2 != null && object2 != null && ((bl3 = (matcher = ((Pattern)(object = NON_ZERO_TIME_PATTERN)).matcher(string2)).matches()) || (bl2 = ((Matcher)(object = ((Pattern)object).matcher((CharSequence)object2))).matches()))) {
            block8: {
                object = new StringBuilder();
                ((StringBuilder)object).append(string2);
                char c10 = ' ';
                ((StringBuilder)object).append(c10);
                ((StringBuilder)object).append((String)object2);
                string2 = ((StringBuilder)object).toString();
                bl2 = false;
                object = null;
                object2 = new ParsePosition(0);
                try {
                    object = sFormatterPrimary;
                }
                catch (IllegalArgumentException illegalArgumentException) {}
                object = ((SimpleDateFormat)object).parse(string2, (ParsePosition)object2);
                if (object != null) break block8;
                object = sFormatterSecondary;
                object = ((SimpleDateFormat)object).parse(string2, (ParsePosition)object2);
                if (object != null) break block8;
                return null;
            }
            long l10 = ((Date)object).getTime();
            return l10;
        }
        return null;
    }

    public boolean getLatLong(float[] fArray) {
        float f10;
        float f11;
        double[] dArray = this.getLatLong();
        boolean bl2 = false;
        if (dArray == null) {
            return false;
        }
        fArray[0] = f11 = (float)dArray[0];
        bl2 = true;
        fArray[bl2] = f10 = (float)dArray[bl2];
        return bl2;
    }

    public double[] getLatLong() {
        String string2 = this.getAttribute(TAG_GPS_LATITUDE);
        String string3 = this.getAttribute(TAG_GPS_LATITUDE_REF);
        String string4 = this.getAttribute(TAG_GPS_LONGITUDE);
        String string5 = this.getAttribute(TAG_GPS_LONGITUDE_REF);
        if (string2 != null && string3 != null && string4 != null && string5 != null) {
            int n10 = 2;
            int n11 = 1;
            double d10 = ExifInterface.convertRationalLatLonToDouble(string2, string3);
            double d11 = ExifInterface.convertRationalLatLonToDouble(string4, string5);
            double[] dArray = new double[n10];
            dArray[0] = d10;
            try {
                dArray[n11] = d11;
                return dArray;
            }
            catch (IllegalArgumentException illegalArgumentException) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Latitude/longitude values are not parsable. ");
                int n12 = 4;
                Object[] objectArray = new Object[n12];
                objectArray[0] = string2;
                objectArray[n11] = string3;
                objectArray[n10] = string4;
                int n13 = 3;
                objectArray[n13] = string5;
                string2 = String.format("latValue=%s, latRef=%s, lngValue=%s, lngRef=%s", objectArray);
                stringBuilder.append(string2);
                string2 = stringBuilder.toString();
                string3 = TAG;
                Log.w((String)string3, (String)string2);
            }
        }
        return null;
    }

    public int getRotationDegrees() {
        String string2 = TAG_ORIENTATION;
        int n10 = 1;
        int n11 = this.getAttributeInt(string2, n10);
        switch (n11) {
            default: {
                return 0;
            }
            case 6: 
            case 7: {
                return 90;
            }
            case 5: 
            case 8: {
                return 270;
            }
            case 3: 
            case 4: 
        }
        return 180;
    }

    public byte[] getThumbnail() {
        int n10 = this.mThumbnailCompression;
        int n11 = 6;
        if (n10 != n11 && n10 != (n11 = 7)) {
            return null;
        }
        return this.getThumbnailBytes();
    }

    public Bitmap getThumbnailBitmap() {
        int n10 = this.mHasThumbnail;
        int n11 = 0;
        ByteOrder byteOrder = null;
        if (n10 == 0) {
            return null;
        }
        Object object = this.mThumbnailBytes;
        if (object == null) {
            object = this.getThumbnailBytes();
            this.mThumbnailBytes = object;
        }
        n10 = this.mThumbnailCompression;
        int n12 = 6;
        int n13 = 0;
        Object object2 = null;
        if (n10 != n12 && n10 != (n12 = 7)) {
            n12 = 1;
            if (n10 == n12) {
                object = this.mThumbnailBytes;
                n10 = ((byte[])object).length / 3;
                int[] nArray = new int[n10];
                String string2 = null;
                for (int i10 = 0; i10 < n10; ++i10) {
                    byte[] byArray = this.mThumbnailBytes;
                    int n14 = i10 * 3;
                    int n15 = (byArray[n14] << 16) + 0;
                    int n16 = n14 + 1;
                    n16 = byArray[n16] << 8;
                    n15 += n16;
                    byte by2 = byArray[n14 += 2];
                    nArray[i10] = n15 += by2;
                }
                object = this.mAttributes;
                n13 = 4;
                object = (ExifInterface$ExifAttribute)object[n13].get(TAG_IMAGE_LENGTH);
                object2 = this.mAttributes[n13];
                string2 = TAG_IMAGE_WIDTH;
                object2 = (ExifInterface$ExifAttribute)((HashMap)object2).get(string2);
                if (object != null && object2 != null) {
                    byteOrder = this.mExifByteOrder;
                    n10 = object.getIntValue(byteOrder);
                    byteOrder = this.mExifByteOrder;
                    n11 = ((ExifInterface$ExifAttribute)object2).getIntValue(byteOrder);
                    object2 = Bitmap.Config.ARGB_8888;
                    return Bitmap.createBitmap((int[])nArray, (int)n11, (int)n10, (Bitmap.Config)object2);
                }
            }
            return null;
        }
        object = this.mThumbnailBytes;
        n11 = this.mThumbnailLength;
        return BitmapFactory.decodeByteArray((byte[])object, (int)0, (int)n11);
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public byte[] getThumbnailBytes() {
        block27: {
            block28: {
                block26: {
                    var1_1 = "ExifInterface";
                    var2_7 = this.mHasThumbnail;
                    var3_8 = null;
                    if (var2_7 == 0) {
                        return null;
                    }
                    var4_9 /* !! */  = this.mThumbnailBytes;
                    if (var4_9 /* !! */  != null) {
                        return var4_9 /* !! */ ;
                    }
                    var4_9 /* !! */  = (byte[])this.mAssetInputStream;
                    if (var4_9 /* !! */  == null) break block26;
                    try {
                        var5_10 = var4_9 /* !! */ .markSupported();
                        if (var5_10) {
                            var4_9 /* !! */ .reset();
lbl16:
                            // 2 sources

                            while (true) {
                                var5_10 = false;
                                var6_16 = null;
                                break block27;
                                break;
                            }
                        }
                        var6_17 = "Cannot read thumbnail from inputstream without mark/reset support";
                        Log.d((String)var1_1, (String)var6_17);
                    }
                    catch (Throwable var1_2) {
                        var5_11 = false;
                        var6_16 = null;
                    }
                    ExifInterface.closeQuietly((Closeable)var4_9 /* !! */ );
                    return null;
lbl28:
                    // 2 sources

                    while (true) {
                        var3_8 = var4_9 /* !! */ ;
lbl30:
                        // 3 sources

                        while (true) {
                            ExifInterface.closeQuietly(var3_8);
                            if (var6_16 != null) {
                                ExifInterface.closeFileDescriptor(var6_16);
                            }
                            throw var1_6;
                        }
                        break;
                    }
                    catch (Exception var7_19) {
                        var5_12 = false;
                        var6_16 = null;
                        ** GOTO lbl120
                    }
                }
                var4_9 /* !! */  = this.mFilename;
                if (var4_9 /* !! */  != null) {
                    var6_16 = this.mFilename;
                    var4_9 /* !! */  = new FileInputStream((String)var6_16);
                    ** continue;
                }
                var2_7 = Build.VERSION.SDK_INT;
                var5_13 = 21;
                if (var2_7 < var5_13) break block28;
                var4_9 /* !! */  = this.mSeekableFileDescriptor;
                var4_9 /* !! */  = Os.dup((FileDescriptor)var4_9 /* !! */ );
                var8_26 = 0L;
                try {
                    var10_27 = OsConstants.SEEK_SET;
                    Os.lseek((FileDescriptor)var4_9 /* !! */ , (long)var8_26, (int)var10_27);
                    var11_28 = var6_16 = new FileInputStream((FileDescriptor)var4_9 /* !! */ );
                    var6_16 = var4_9 /* !! */ ;
                    var4_9 /* !! */  = var11_28;
                    break block27;
                }
                catch (Throwable var1_3) {
                    var6_16 = var4_9 /* !! */ ;
                    ** GOTO lbl30
                }
                catch (Exception var7_20) {
                    var6_16 = var4_9 /* !! */ ;
                    var2_7 = 0;
                    var4_9 /* !! */  = null;
                    ** GOTO lbl120
                }
            }
            var2_7 = 0;
            var4_9 /* !! */  = null;
            var5_13 = 0;
            var6_16 = null;
        }
        if (var4_9 /* !! */  == null) ** GOTO lbl118
        ** try [egrp 4[TRYBLOCK] [30, 31 : 250->364)] { 
lbl76:
        // 1 sources

        ** GOTO lbl91
lbl77:
        // 1 sources

        catch (Throwable var1_5) {
            // empty catch block
            ** continue;
        }
        {
            block29: {
                catch (Throwable var1_4) {
                    var5_14 = false;
                    var6_16 = null;
                    ** continue;
                }
                catch (Exception var6_18) {
                    var2_7 = 0;
                    var4_9 /* !! */  = null;
                    var7_25 = var6_18;
                    var5_15 = false;
                    var6_16 = null;
                    break block29;
                }
lbl91:
                // 1 sources

                var12_29 = this.mThumbnailOffset;
                var10_27 = this.mOffsetToExifData;
                var13_30 = var12_29 += var10_27;
                var13_30 = var4_9 /* !! */ .skip(var13_30);
                var15_31 = this.mThumbnailOffset;
                var16_32 = this.mOffsetToExifData;
                var17_33 = var15_31 += var16_32;
                var12_29 = (int)(var13_30 == var17_33 ? 0 : (var13_30 < var17_33 ? -1 : 1));
                var19_34 = "Corrupted image";
                if (var12_29 != 0) ** GOTO lbl114
                var12_29 = this.mThumbnailLength;
                var7_21 /* !! */  = new byte[var12_29];
                var15_31 = var4_9 /* !! */ .read(var7_21 /* !! */ );
                if (var15_31 == (var16_32 = this.mThumbnailLength)) {
                    this.mThumbnailBytes = var7_21 /* !! */ ;
                    ExifInterface.closeQuietly((Closeable)var4_9 /* !! */ );
                    if (var6_16 != null) {
                        ExifInterface.closeFileDescriptor((FileDescriptor)var6_16);
                    }
                    return var7_21 /* !! */ ;
                }
                try {
                    var7_21 /* !! */  = (byte[])new IOException;
                    var7_21 /* !! */ (var19_34);
                    throw var7_21 /* !! */ ;
lbl114:
                    // 1 sources

                    var7_22 = new IOException(var19_34);
                    throw var7_22;
                }
lbl116:
                // 2 sources

                catch (Exception var7_23) {}
                break block29;
lbl118:
                // 1 sources

                var7_24 = new FileNotFoundException();
                throw var7_24;
            }
            var19_34 = "Encountered exception while getting thumbnail";
            Log.d((String)var1_1, (String)var19_34, (Throwable)var7_25);
        }
        ExifInterface.closeQuietly((Closeable)var4_9 /* !! */ );
        if (var6_16 != null) {
            ExifInterface.closeFileDescriptor((FileDescriptor)var6_16);
        }
        return null;
    }

    public long[] getThumbnailRange() {
        boolean bl2 = this.mModified;
        if (!bl2) {
            bl2 = this.mHasThumbnail;
            if (bl2) {
                long l10;
                bl2 = this.mHasThumbnailStrips;
                if (bl2 && !(bl2 = this.mAreThumbnailStripsConsecutive)) {
                    return null;
                }
                long[] lArray = new long[2];
                int n10 = this.mThumbnailOffset;
                int n11 = this.mOffsetToExifData;
                lArray[0] = l10 = (long)(n10 + n11);
                lArray[1] = l10 = (long)this.mThumbnailLength;
                return lArray;
            }
            return null;
        }
        IllegalStateException illegalStateException = new IllegalStateException("The underlying file has been modified since being parsed");
        throw illegalStateException;
    }

    public boolean hasAttribute(String object) {
        boolean bl2;
        if ((object = this.getExifAttribute((String)object)) != null) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    public boolean hasThumbnail() {
        return this.mHasThumbnail;
    }

    public boolean isFlipped() {
        int n10;
        String string2 = TAG_ORIENTATION;
        boolean bl2 = true;
        int n11 = this.getAttributeInt(string2, (int)(bl2 ? 1 : 0));
        if (n11 != (n10 = 2) && n11 != (n10 = 7) && n11 != (n10 = 4) && n11 != (n10 = 5)) {
            return false;
        }
        return bl2;
    }

    public boolean isThumbnailCompressed() {
        int n10 = this.mHasThumbnail;
        if (n10 == 0) {
            return false;
        }
        n10 = this.mThumbnailCompression;
        int n11 = 6;
        return n10 == n11 || n10 == (n11 = 7);
        {
        }
    }

    public void resetOrientation() {
        String string2 = Integer.toString(1);
        this.setAttribute(TAG_ORIENTATION, string2);
    }

    public void rotate(int n10) {
        int n11 = n10 % 90;
        if (n11 == 0) {
            Object object;
            String string2 = TAG_ORIENTATION;
            n11 = this.getAttributeInt(string2, 1);
            List list = ROTATION_ORDER;
            Integer n12 = n11;
            boolean bl2 = list.contains(n12);
            int n13 = 0;
            int n14 = 4;
            if (bl2) {
                Integer n15 = n11;
                n11 = list.indexOf(n15);
                if ((n11 = (n11 + (n10 /= 90)) % n14) < 0) {
                    n13 = n14;
                }
                object = (Integer)list.get(n11 += n13);
                n13 = (Integer)object;
            } else {
                list = FLIPPED_ROTATION_ORDER;
                n12 = n11;
                bl2 = list.contains(n12);
                if (bl2) {
                    Integer n16 = n11;
                    n11 = list.indexOf(n16);
                    if ((n11 = (n11 + (n10 /= 90)) % n14) < 0) {
                        n13 = n14;
                    }
                    object = (Integer)list.get(n11 += n13);
                    n13 = (Integer)object;
                }
            }
            object = Integer.toString(n13);
            this.setAttribute(string2, (String)object);
            return;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("degree should be a multiple of 90");
        throw illegalArgumentException;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void saveAttributes() {
        void var4_17;
        BufferedOutputStream bufferedOutputStream;
        boolean bl2;
        Object object;
        Object object2;
        block51: {
            Object object3;
            block48: {
                Object object4;
                boolean bl3;
                block55: {
                    Object object5;
                    block56: {
                        Object object6;
                        Object object7;
                        int n10;
                        long l10;
                        int n11;
                        Object object8;
                        int n12;
                        block49: {
                            void var4_21;
                            block54: {
                                block57: {
                                    block53: {
                                        int n13;
                                        block52: {
                                            block50: {
                                                block45: {
                                                    n12 = Build.VERSION.SDK_INT;
                                                    bl3 = this.isSupportedFormatForSavingAttributes();
                                                    if (!bl3) {
                                                        IOException iOException = new IOException("ExifInterface only supports saving attributes on JPEG, PNG, or WebP formats.");
                                                        throw iOException;
                                                    }
                                                    object8 = this.mSeekableFileDescriptor;
                                                    if (object8 == null && (object8 = this.mFilename) == null) {
                                                        IOException iOException = new IOException("ExifInterface does not support saving attributes for the current input.");
                                                        throw iOException;
                                                    }
                                                    this.mModified = bl3 = true;
                                                    object2 = this.getThumbnail();
                                                    this.mThumbnailBytes = object2;
                                                    n11 = 0;
                                                    object2 = null;
                                                    object = "temp";
                                                    object5 = "tmp";
                                                    object = File.createTempFile((String)object, (String)object5);
                                                    object5 = this.mFilename;
                                                    l10 = 0L;
                                                    n10 = 21;
                                                    if (object5 != null) {
                                                        object7 = this.mFilename;
                                                        object5 = new FileInputStream((String)object7);
                                                        break block45;
                                                    }
                                                    if (n12 >= n10) {
                                                        object5 = this.mSeekableFileDescriptor;
                                                        n13 = OsConstants.SEEK_SET;
                                                        Os.lseek((FileDescriptor)object5, (long)l10, (int)n13);
                                                        object7 = this.mSeekableFileDescriptor;
                                                        object5 = new FileInputStream((FileDescriptor)object7);
                                                        break block45;
                                                    }
                                                    bl2 = false;
                                                    object5 = null;
                                                }
                                                object7 = new FileOutputStream((File)object);
                                                ExifInterface.copy((InputStream)object5, (OutputStream)object7);
                                                ExifInterface.closeQuietly((Closeable)object5);
                                                ExifInterface.closeQuietly((Closeable)object7);
                                                bl2 = false;
                                                object5 = null;
                                                try {
                                                    block47: {
                                                        int n14;
                                                        block46: {
                                                            object7 = new FileInputStream((File)object);
                                                            try {
                                                                object4 = this.mFilename;
                                                                if (object4 != null) {
                                                                    object3 = this.mFilename;
                                                                    object4 = new FileOutputStream((String)object3);
                                                                    break block46;
                                                                }
                                                                if (n12 >= n10) {
                                                                    object4 = this.mSeekableFileDescriptor;
                                                                    n14 = OsConstants.SEEK_SET;
                                                                    Os.lseek((FileDescriptor)object4, (long)l10, (int)n14);
                                                                    object3 = this.mSeekableFileDescriptor;
                                                                    object4 = new FileOutputStream((FileDescriptor)object3);
                                                                    break block46;
                                                                }
                                                                object4 = null;
                                                            }
                                                            catch (Exception exception) {
                                                                boolean bl4 = false;
                                                                object3 = null;
                                                                bufferedOutputStream = null;
                                                                object2 = object7;
                                                                break block50;
                                                            }
                                                        }
                                                        try {
                                                            object3 = new BufferedInputStream((InputStream)object7);
                                                        }
                                                        catch (Exception exception) {
                                                            bufferedOutputStream = null;
                                                            object2 = object7;
                                                            object7 = exception;
                                                            n14 = 0;
                                                            object3 = null;
                                                            break block49;
                                                        }
                                                        bufferedOutputStream = new BufferedOutputStream((OutputStream)object4);
                                                        int n15 = this.mMimeType;
                                                        int n16 = 4;
                                                        if (n15 == n16) {
                                                            this.saveJpegAttributes((InputStream)object3, bufferedOutputStream);
                                                            break block47;
                                                        }
                                                        n16 = 13;
                                                        if (n15 == n16) {
                                                            this.savePngAttributes((InputStream)object3, bufferedOutputStream);
                                                            break block47;
                                                        }
                                                        n16 = 14;
                                                        if (n15 != n16) break block47;
                                                        this.saveWebpAttributes((InputStream)object3, bufferedOutputStream);
                                                    }
                                                    ExifInterface.closeQuietly((Closeable)object3);
                                                    ExifInterface.closeQuietly(bufferedOutputStream);
                                                    ((File)object).delete();
                                                    this.mThumbnailBytes = null;
                                                    return;
                                                    catch (Throwable throwable) {
                                                        bufferedOutputStream = null;
                                                        break block48;
                                                    }
                                                    catch (Exception exception) {
                                                        bufferedOutputStream = null;
                                                        object2 = object7;
                                                        object7 = exception;
                                                        break block49;
                                                    }
                                                }
                                                catch (Throwable throwable) {
                                                    bufferedOutputStream = null;
                                                    break block51;
                                                }
                                                catch (Exception exception) {
                                                    boolean bl5 = false;
                                                    object3 = null;
                                                    bufferedOutputStream = null;
                                                }
                                            }
                                            object7 = object4;
                                            object4 = null;
                                            break block49;
                                            catch (Throwable throwable) {
                                                break block52;
                                            }
                                            catch (Exception exception) {
                                                break block53;
                                            }
                                            catch (Throwable throwable) {
                                                n13 = 0;
                                                object7 = null;
                                            }
                                        }
                                        object2 = object5;
                                        break block54;
                                        catch (Exception exception) {
                                            n13 = 0;
                                            object7 = null;
                                        }
                                    }
                                    object2 = object5;
                                    break block57;
                                    catch (Throwable throwable) {
                                        boolean bl6 = false;
                                        object7 = null;
                                        break block54;
                                    }
                                    catch (Exception exception) {
                                        boolean bl7 = false;
                                        object7 = null;
                                    }
                                }
                                try {
                                    void var4_23;
                                    object = "Failed to copy original file to temp file";
                                    object8 = new IOException((String)object, (Throwable)var4_23);
                                    throw object8;
                                }
                                catch (Throwable throwable) {
                                    // empty catch block
                                }
                            }
                            ExifInterface.closeQuietly((Closeable)object2);
                            ExifInterface.closeQuietly(object7);
                            throw var4_21;
                            catch (Throwable throwable) {
                                break block48;
                            }
                            catch (Exception exception) {
                                Object object9 = object7;
                                object7 = exception;
                                object2 = object9;
                            }
                        }
                        FileInputStream fileInputStream = new FileInputStream((File)object);
                        try {
                            block59: {
                                block60: {
                                    block58: {
                                        object2 = this.mFilename;
                                        if (object2 != null) break block58;
                                        if (n12 < n10) break block59;
                                        object6 = this.mSeekableFileDescriptor;
                                        n11 = OsConstants.SEEK_SET;
                                        Os.lseek((FileDescriptor)object6, (long)l10, (int)n11);
                                        object2 = this.mSeekableFileDescriptor;
                                        object6 = new FileOutputStream((FileDescriptor)object2);
                                        break block60;
                                    }
                                    object2 = this.mFilename;
                                    object6 = new FileOutputStream((String)object2);
                                }
                                object4 = object6;
                            }
                            ExifInterface.copy(fileInputStream, (OutputStream)object4);
                        }
                        catch (Throwable throwable) {
                            bl3 = false;
                            object8 = null;
                            object2 = fileInputStream;
                            break block55;
                        }
                        catch (Exception exception) {
                            object2 = fileInputStream;
                            break block56;
                        }
                        {
                            ExifInterface.closeQuietly(fileInputStream);
                            ExifInterface.closeQuietly((Closeable)object4);
                            object8 = "Failed to save new file";
                            object6 = new IOException((String)object8, (Throwable)object7);
                            throw object6;
                        }
                        catch (Throwable throwable) {
                            bl3 = false;
                            object8 = null;
                            break block55;
                        }
                        catch (Exception exception) {
                            // empty catch block
                        }
                    }
                    try {
                        void var4_13;
                        CharSequence charSequence = new StringBuilder();
                        String string2 = "Failed to save new file. Original file is stored in ";
                        charSequence.append(string2);
                        string2 = ((File)object).getAbsolutePath();
                        charSequence.append(string2);
                        charSequence = charSequence.toString();
                        object5 = new IOException((String)charSequence, (Throwable)var4_13);
                        throw object5;
                    }
                    catch (Throwable throwable) {
                        // empty catch block
                    }
                }
                try {
                    void var4_15;
                    ExifInterface.closeQuietly((Closeable)object2);
                    ExifInterface.closeQuietly((Closeable)object4);
                    throw var4_15;
                }
                catch (Throwable throwable) {
                    bl2 = bl3;
                }
            }
            object2 = object3;
        }
        ExifInterface.closeQuietly((Closeable)object2);
        ExifInterface.closeQuietly(bufferedOutputStream);
        if (!bl2) {
            ((File)object).delete();
        }
        throw var4_17;
    }

    public void setAltitude(double d10) {
        double d11 = 0.0;
        double d12 = d10 - d11;
        Object object = d12 == 0.0 ? 0 : (d12 > 0.0 ? 1 : -1);
        String string2 = object >= 0 ? "0" : "1";
        d10 = Math.abs(d10);
        ExifInterface$Rational exifInterface$Rational = new ExifInterface$Rational(d10);
        String string3 = exifInterface$Rational.toString();
        this.setAttribute(TAG_GPS_ALTITUDE, string3);
        this.setAttribute(TAG_GPS_ALTITUDE_REF, string2);
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public void setAttribute(String var1_1, String var2_2) {
        var3_3 = this;
        var4_4 = var1_1;
        var5_5 = var2_2;
        Objects.requireNonNull(var1_1, "tag shouldn't be null");
        var6_6 = "DateTime";
        var7_7 = var6_6.equals(var1_1);
        var8_8 /* !! */  = " : ";
        var9_9 = "Invalid value for ";
        var10_10 = "ExifInterface";
        if ((var7_7 != 0 || (var7_7 = (var6_6 = "DateTimeOriginal").equals(var1_1)) != 0 || (var7_7 = (int)(var6_6 = "DateTimeDigitized").equals(var1_1)) != 0) && var5_5 != null) {
            var6_6 = ExifInterface.DATETIME_PRIMARY_FORMAT_PATTERN.matcher(var5_5);
            var7_7 = var6_6.find();
            var11_11 = ExifInterface.DATETIME_SECONDARY_FORMAT_PATTERN.matcher(var5_5);
            var12_12 = var11_11.find();
            var13_13 = var2_2.length();
            if (var13_13 == (var14_14 = 19) && (var7_7 != 0 || var12_12 != 0)) {
                if (var12_12 != 0) {
                    var6_6 = "-";
                    var11_11 = ":";
                    var5_5 = var5_5.replaceAll((String)var6_6, (String)var11_11);
                }
            } else {
                var6_6 = new StringBuilder();
                var6_6.append(var9_9);
                var6_6.append(var4_4);
                var6_6.append((String)var8_8 /* !! */ );
                var6_6.append((String)var5_5);
                var4_4 = var6_6.toString();
                Log.w((String)var10_10, (String)var4_4);
                return;
            }
        }
        if ((var7_7 = (var6_6 = "ISOSpeedRatings").equals(var4_4)) != 0) {
            var15_15 = ExifInterface.DEBUG;
            if (var15_15) {
                var4_4 = "setAttribute: Replacing TAG_ISO_SPEED_RATINGS with TAG_PHOTOGRAPHIC_SENSITIVITY.";
                Log.d((String)var10_10, (String)var4_4);
            }
            var4_4 = "PhotographicSensitivity";
        }
        var7_7 = 2;
        var12_12 = 1;
        var16_16 = 1.4E-45f;
        if (var5_5 != null && (var13_13 = (int)(var17_17 = ExifInterface.sTagSetForCompatibility).contains(var4_4)) != 0) {
            var17_17 = "GPSTimeStamp";
            var13_13 = (int)var4_4.equals(var17_17);
            if (var13_13 != 0) {
                var17_17 = ExifInterface.GPS_TIMESTAMP_PATTERN.matcher(var5_5);
                var14_14 = (int)var17_17.find();
                if (var14_14 == 0) {
                    var6_6 = new StringBuilder();
                    var6_6.append(var9_9);
                    var6_6.append(var4_4);
                    var6_6.append((String)var8_8 /* !! */ );
                    var6_6.append((String)var5_5);
                    var4_4 = var6_6.toString();
                    Log.w((String)var10_10, (String)var4_4);
                    return;
                }
                var5_5 = new StringBuilder();
                var18_18 = Integer.parseInt(var17_17.group(var12_12));
                var5_5.append(var18_18);
                var8_8 /* !! */  = "/1,";
                var5_5.append((String)var8_8 /* !! */ );
                var9_9 = var17_17.group(var7_7);
                var19_19 = Integer.parseInt(var9_9);
                var5_5.append(var19_19);
                var5_5.append((String)var8_8 /* !! */ );
                var18_18 = Integer.parseInt(var17_17.group(3));
                var5_5.append(var18_18);
                var8_8 /* !! */  = "/1";
                var5_5.append((String)var8_8 /* !! */ );
                var5_5 = var5_5.toString();
            } else {
                try {
                    var20_20 = Double.parseDouble((String)var5_5);
                }
                catch (NumberFormatException v0) {
                    var6_6 = new StringBuilder();
                    var6_6.append(var9_9);
                    var6_6.append(var4_4);
                    var6_6.append((String)var8_8 /* !! */ );
                    var6_6.append((String)var5_5);
                    var4_4 = var6_6.toString();
                    Log.w((String)var10_10, (String)var4_4);
                    return;
                }
                var22_21 = new ExifInterface$Rational(var20_20);
                var5_5 = var22_21.toString();
            }
        }
        var18_18 = 0;
        var8_8 /* !! */  = null;
        var9_9 = null;
        for (var19_19 = 0; var19_19 < (var13_13 = ((ExifInterface$ExifTag[][])(var17_17 = ExifInterface.EXIF_TAGS)).length); ++var19_19) {
            block42: {
                block36: {
                    block40: {
                        block38: {
                            block41: {
                                block39: {
                                    block37: {
                                        var13_13 = 4;
                                        if (var19_19 == var13_13 && (var13_13 = (int)var3_3.mHasThumbnail) == 0 || (var17_17 = (ExifInterface$ExifTag)ExifInterface.sExifTagMapsForWriting[var19_19].get(var4_4)) == null) break block36;
                                        if (var5_5 != null) break block37;
                                        var17_17 = var3_3.mAttributes[var19_19];
                                        var17_17.remove(var4_4);
                                        break block36;
                                    }
                                    var23_22 /* !! */  = ExifInterface.guessDataFormat((String)var5_5);
                                    var24_23 = var17_17.primaryFormat;
                                    var25_24 = (Integer)var23_22 /* !! */ .first;
                                    var26_25 = var25_24.intValue();
                                    var27_26 = -1;
                                    if (var24_23 == var26_25 || (var24_23 = var17_17.primaryFormat) == (var26_25 = (var25_24 = (Integer)var23_22 /* !! */ .second).intValue())) break block38;
                                    var24_23 = var17_17.secondaryFormat;
                                    if (var24_23 == var27_26 || var24_23 != (var26_25 = (var25_24 = (Integer)var23_22 /* !! */ .first).intValue()) && (var24_23 = var17_17.secondaryFormat) != (var26_25 = (var25_24 = (Integer)var23_22 /* !! */ .second).intValue())) break block39;
                                    var13_13 = var17_17.secondaryFormat;
                                    break block40;
                                }
                                var24_23 = var17_17.primaryFormat;
                                if (var24_23 == var12_12 || var24_23 == (var26_25 = 7) || var24_23 == var7_7) break block41;
                                var24_23 = (int)ExifInterface.DEBUG;
                                if (var24_23 != 0) {
                                    var22_21 = new StringBuilder();
                                    var22_21.append("Given tag (");
                                    var22_21.append(var4_4);
                                    var22_21.append(") value didn't match with one of expected formats: ");
                                    var25_24 = ExifInterface.IFD_FORMAT_NAMES;
                                    var28_27 = var17_17.primaryFormat;
                                    var29_28 = var25_24[var28_27];
                                    var22_21.append((String)var29_28);
                                    var28_27 = var17_17.secondaryFormat;
                                    var30_29 = "";
                                    var31_30 = ", ";
                                    if (var28_27 == var27_26) {
                                        var17_17 = var30_29;
                                    } else {
                                        var29_28 = new StringBuilder();
                                        var29_28.append(var31_30);
                                        var13_13 = var17_17.secondaryFormat;
                                        var17_17 = var25_24[var13_13];
                                        var29_28.append((String)var17_17);
                                        var17_17 = var29_28.toString();
                                    }
                                    var22_21.append((String)var17_17);
                                    var22_21.append(" (guess: ");
                                    var13_13 = (Integer)var23_22 /* !! */ .first;
                                    var17_17 = var25_24[var13_13];
                                    var22_21.append((String)var17_17);
                                    var17_17 = (Integer)var23_22 /* !! */ .second;
                                    var13_13 = var17_17.intValue();
                                    if (var13_13 != var27_26) {
                                        var17_17 = new StringBuilder();
                                        var17_17.append(var31_30);
                                        var14_14 = (Integer)var23_22 /* !! */ .second;
                                        var23_22 /* !! */  = var25_24[var14_14];
                                        var17_17.append((String)var23_22 /* !! */ );
                                        var30_29 = var17_17.toString();
                                    }
                                    var22_21.append((String)var30_29);
                                    var22_21.append(")");
                                    var17_17 = var22_21.toString();
                                    Log.d((String)var10_10, (String)var17_17);
                                }
                                break block36;
                            }
                            var13_13 = var24_23;
                            break block40;
                        }
                        var13_13 = var17_17.primaryFormat;
                    }
                    var23_22 /* !! */  = "/";
                    var22_21 = ",";
                    switch (var13_13) {
                        default: {
                            var32_31 = var12_12;
                            var33_32 = var16_16;
                            var7_7 = (int)ExifInterface.DEBUG;
                            if (var7_7 != 0) {
                                var6_6 = new StringBuilder();
                                var8_8 /* !! */  = "Data format isn't one of expected formats: ";
                                var6_6.append((String)var8_8 /* !! */ );
                                var6_6.append(var13_13);
                                var6_6 = var6_6.toString();
                                Log.d((String)var10_10, (String)var6_6);
                            }
                            break block42;
                        }
                        case 12: {
                            var17_17 = var5_5.split((String)var22_21, var27_26);
                            var14_14 = ((Object)var17_17).length;
                            var23_22 /* !! */  = (Pair)new double[var14_14];
                            var22_21 = null;
                            for (var24_23 = 0; var24_23 < (var26_25 = ((Object)var17_17).length); ++var24_23) {
                                var25_24 = var17_17[var24_23];
                                var34_33 = Double.parseDouble((String)var25_24);
                                var23_22 /* !! */ [var24_23] = (Pair)var34_33;
                            }
                            var17_17 = var3_3.mAttributes[var19_19];
                            var22_21 = var3_3.mExifByteOrder;
                            var23_22 /* !! */  = ExifInterface$ExifAttribute.createDouble((double[])var23_22 /* !! */ , (ByteOrder)var22_21);
                            var17_17.put(var4_4, var23_22 /* !! */ );
                            break block36;
                        }
                        case 10: {
                            var17_17 = var5_5.split((String)var22_21, var27_26);
                            var24_23 = ((Object)var17_17).length;
                            var22_21 = new ExifInterface$Rational[var24_23];
                            var25_24 = null;
                            for (var26_25 = 0; var26_25 < (var28_27 = ((Object)var17_17).length); ++var26_25) {
                                var29_28 = var17_17[var26_25].split((String)var23_22 /* !! */ , var27_26);
                                var31_30 = var29_28[0];
                                var36_34 = Double.parseDouble(var31_30);
                                var38_35 = (long)var36_34;
                                var29_28 = var29_28[var12_12];
                                var40_36 = Double.parseDouble((String)var29_28);
                                var42_37 = (long)var40_36;
                                var22_21[var26_25] = var30_29 = new ExifInterface$Rational(var38_35, var42_37);
                                var7_7 = 2;
                                var18_18 = 0;
                                var8_8 /* !! */  = null;
                                var12_12 = 1;
                                var16_16 = 1.4E-45f;
                            }
                            var6_6 = var3_3.mAttributes[var19_19];
                            var8_8 /* !! */  = var3_3.mExifByteOrder;
                            var8_8 /* !! */  = ExifInterface$ExifAttribute.createSRational((ExifInterface$Rational[])var22_21, (ByteOrder)var8_8 /* !! */ );
                            var6_6.put(var4_4, var8_8 /* !! */ );
                            ** GOTO lbl269
                        }
                        case 9: {
                            var6_6 = var5_5.split((String)var22_21, var27_26);
                            var18_18 = ((String[])var6_6).length;
                            var8_8 /* !! */  = (ExifInterface$Rational[])new int[var18_18];
                            var16_16 = 0.0f;
                            var11_11 = null;
                            for (var12_12 = 0; var12_12 < (var13_13 = ((Object)var6_6).length); ++var12_12) {
                                var17_17 = var6_6[var12_12];
                                var13_13 = Integer.parseInt((String)var17_17);
                                var8_8 /* !! */ [var12_12] = (ExifInterface$Rational)var13_13;
                            }
                            var6_6 = var3_3.mAttributes[var19_19];
                            var11_11 = var3_3.mExifByteOrder;
                            var8_8 /* !! */  = ExifInterface$ExifAttribute.createSLong((int[])var8_8 /* !! */ , (ByteOrder)var11_11);
                            var6_6.put(var4_4, var8_8 /* !! */ );
lbl269:
                            // 2 sources

                            var32_31 = 1;
                            var33_32 = 1.4E-45f;
                            break block42;
                        }
                        case 5: {
                            var6_6 = var5_5.split((String)var22_21, var27_26);
                            var18_18 = ((String[])var6_6).length;
                            var8_8 /* !! */  = new ExifInterface$Rational[var18_18];
                            var16_16 = 0.0f;
                            var11_11 = null;
                            for (var12_12 = 0; var12_12 < (var13_13 = ((Object)var6_6).length); ++var12_12) {
                                var17_17 = var6_6[var12_12].split((String)var23_22 /* !! */ , var27_26);
                                var26_25 = 0;
                                var25_24 = null;
                                var29_28 = var17_17[0];
                                var44_38 = Double.parseDouble((String)var29_28);
                                var46_39 = (long)var44_38;
                                var32_31 = 1;
                                var33_32 = 1.4E-45f;
                                var17_17 = var17_17[var32_31];
                                var34_33 = Double.parseDouble((String)var17_17);
                                var48_40 = (long)var34_33;
                                var8_8 /* !! */ [var12_12] = var22_21 = new ExifInterface$Rational(var46_39, var48_40);
                                var27_26 = -1;
                            }
                            var32_31 = 1;
                            var33_32 = 1.4E-45f;
                            var6_6 = var3_3.mAttributes[var19_19];
                            var11_11 = var3_3.mExifByteOrder;
                            var8_8 /* !! */  = ExifInterface$ExifAttribute.createURational(var8_8 /* !! */ , (ByteOrder)var11_11);
                            var6_6.put(var4_4, var8_8 /* !! */ );
                            break block42;
                        }
                        case 4: {
                            var32_31 = var12_12;
                            var33_32 = var16_16;
                            var7_7 = var27_26;
                            var6_6 = var5_5.split((String)var22_21, var27_26);
                            var18_18 = ((String[])var6_6).length;
                            var8_8 /* !! */  = (ExifInterface$Rational[])new long[var18_18];
                            var16_16 = 0.0f;
                            var11_11 = null;
                            for (var12_12 = 0; var12_12 < (var13_13 = ((Object)var6_6).length); ++var12_12) {
                                var17_17 = var6_6[var12_12];
                                var50_41 = Long.parseLong((String)var17_17);
                                var8_8 /* !! */ [var12_12] = (ExifInterface$Rational)var50_41;
                            }
                            var6_6 = var3_3.mAttributes[var19_19];
                            var11_11 = var3_3.mExifByteOrder;
                            var8_8 /* !! */  = ExifInterface$ExifAttribute.createULong((long[])var8_8 /* !! */ , (ByteOrder)var11_11);
                            var6_6.put(var4_4, var8_8 /* !! */ );
                            break block42;
                        }
                        case 3: {
                            var32_31 = var12_12;
                            var33_32 = var16_16;
                            var7_7 = var27_26;
                            var6_6 = var5_5.split((String)var22_21, var27_26);
                            var18_18 = ((String[])var6_6).length;
                            var8_8 /* !! */  = (ExifInterface$Rational[])new int[var18_18];
                            var16_16 = 0.0f;
                            var11_11 = null;
                            for (var12_12 = 0; var12_12 < (var13_13 = ((Object)var6_6).length); ++var12_12) {
                                var17_17 = var6_6[var12_12];
                                var13_13 = Integer.parseInt((String)var17_17);
                                var8_8 /* !! */ [var12_12] = (ExifInterface$Rational)var13_13;
                            }
                            var6_6 = var3_3.mAttributes[var19_19];
                            var11_11 = var3_3.mExifByteOrder;
                            var8_8 /* !! */  = ExifInterface$ExifAttribute.createUShort((int[])var8_8 /* !! */ , (ByteOrder)var11_11);
                            var6_6.put(var4_4, var8_8 /* !! */ );
                            break block42;
                        }
                        case 2: 
                        case 7: {
                            var32_31 = var12_12;
                            var33_32 = var16_16;
                            var6_6 = var3_3.mAttributes[var19_19];
                            var8_8 /* !! */  = ExifInterface$ExifAttribute.createString((String)var5_5);
                            var6_6.put(var4_4, var8_8 /* !! */ );
                            break block42;
                        }
                        case 1: 
                    }
                    var32_31 = var12_12;
                    var33_32 = var16_16;
                    var6_6 = var3_3.mAttributes[var19_19];
                    var8_8 /* !! */  = ExifInterface$ExifAttribute.createByte((String)var5_5);
                    var6_6.put(var4_4, var8_8 /* !! */ );
                    break block42;
                }
                var32_31 = var12_12;
                var33_32 = var16_16;
            }
            var12_12 = var32_31;
            var16_16 = var33_32;
            var7_7 = 2;
            var18_18 = 0;
            var8_8 /* !! */  = null;
        }
    }

    public void setDateTime(Long object) {
        long l10 = (Long)object % 1000L;
        SimpleDateFormat simpleDateFormat = sFormatterPrimary;
        long l11 = (Long)object;
        Date date = new Date(l11);
        object = simpleDateFormat.format(date);
        this.setAttribute(TAG_DATETIME, (String)object);
        object = Long.toString(l10);
        this.setAttribute(TAG_SUBSEC_TIME, (String)object);
    }

    public void setGpsInfo(Location object) {
        if (object == null) {
            return;
        }
        Object object2 = object.getProvider();
        this.setAttribute(TAG_GPS_PROCESSING_METHOD, (String)object2);
        double d10 = object.getLatitude();
        double d11 = object.getLongitude();
        this.setLatLong(d10, d11);
        d10 = object.getAltitude();
        this.setAltitude(d10);
        this.setAttribute(TAG_GPS_SPEED_REF, "K");
        float f10 = object.getSpeed();
        float f11 = TimeUnit.HOURS.toSeconds(1L);
        double d12 = f10 * f11 / 1000.0f;
        object2 = new ExifInterface$Rational(d12);
        object2 = ((ExifInterface$Rational)object2).toString();
        this.setAttribute(TAG_GPS_SPEED, (String)object2);
        object2 = sFormatterPrimary;
        long l10 = object.getTime();
        Date date = new Date(l10);
        object = ((DateFormat)object2).format(date).split("\\s+", -1);
        object2 = object[0];
        this.setAttribute(TAG_GPS_DATESTAMP, (String)object2);
        object = object[1];
        this.setAttribute(TAG_GPS_TIMESTAMP, (String)object);
    }

    public void setLatLong(double d10, double d11) {
        double d12;
        double d13;
        double d14 = -90.0;
        Object object = d10 == d14 ? 0 : (d10 < d14 ? -1 : 1);
        String string2 = " is not valid.";
        if (object >= 0 && (object = (d13 = d10 - (d12 = 90.0)) == 0.0 ? 0 : (d13 > 0.0 ? 1 : -1)) <= 0 && (object = (Object)Double.isNaN(d10)) == false) {
            double d15;
            d12 = -180.0;
            double d16 = d11 - d12;
            object = d16 == 0.0 ? 0 : (d16 < 0.0 ? -1 : 1);
            if (object >= 0 && (object = (d15 = d11 - (d12 = 180.0)) == 0.0 ? 0 : (d15 > 0.0 ? 1 : -1)) <= 0 && (object = (Object)Double.isNaN(d11)) == false) {
                d14 = 0.0;
                double d17 = d10 - d14;
                Object object2 = d17 == 0.0 ? 0 : (d17 > 0.0 ? 1 : -1);
                String string3 = object2 >= 0 ? "N" : LATITUDE_SOUTH;
                String string4 = TAG_GPS_LATITUDE_REF;
                this.setAttribute(string4, string3);
                d10 = Math.abs(d10);
                String string5 = this.convertDecimalDegree(d10);
                String string6 = TAG_GPS_LATITUDE;
                this.setAttribute(string6, string5);
                double d18 = d11 == d14 ? 0 : (d11 > d14 ? 1 : -1);
                string5 = d18 >= 0 ? LONGITUDE_EAST : LONGITUDE_WEST;
                this.setAttribute(TAG_GPS_LONGITUDE_REF, string5);
                d10 = Math.abs(d11);
                string5 = this.convertDecimalDegree(d10);
                this.setAttribute(TAG_GPS_LONGITUDE, string5);
                return;
            }
            CharSequence charSequence = new StringBuilder();
            charSequence.append("Longitude value ");
            charSequence.append(d11);
            charSequence.append(string2);
            charSequence = charSequence.toString();
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)charSequence);
            throw illegalArgumentException;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Latitude value ");
        stringBuilder.append(d10);
        stringBuilder.append(string2);
        String string7 = stringBuilder.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string7);
        throw illegalArgumentException;
    }
}

