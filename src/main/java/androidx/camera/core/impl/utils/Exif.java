/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.location.Location
 */
package androidx.camera.core.impl.utils;

import android.location.Location;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.utils.Exif$1;
import androidx.camera.core.impl.utils.Exif$2;
import androidx.camera.core.impl.utils.Exif$3;
import androidx.camera.core.impl.utils.Exif$Speed;
import androidx.camera.core.impl.utils.Exif$Speed$Converter;
import androidx.exifinterface.media.ExifInterface;
import java.io.File;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public final class Exif {
    private static final ThreadLocal DATETIME_FORMAT;
    private static final ThreadLocal DATE_FORMAT;
    public static final long INVALID_TIMESTAMP = 255L;
    private static final String KILOMETERS_PER_HOUR = "K";
    private static final String KNOTS = "N";
    private static final String MILES_PER_HOUR = "M";
    private static final String TAG = "Exif";
    private static final ThreadLocal TIME_FORMAT;
    private final ExifInterface mExifInterface;
    private boolean mRemoveTimestamp = false;

    static {
        ThreadLocal threadLocal = new Exif$1();
        DATE_FORMAT = threadLocal;
        threadLocal = new Exif$2();
        TIME_FORMAT = threadLocal;
        threadLocal = new Exif$3();
        DATETIME_FORMAT = threadLocal;
    }

    private Exif(ExifInterface exifInterface) {
        this.mExifInterface = exifInterface;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private void attachLastModifiedTimestamp() {
        long l10 = System.currentTimeMillis();
        Object object = Exif.convertToExifDateTime(l10);
        ExifInterface exifInterface = this.mExifInterface;
        String string2 = "DateTime";
        exifInterface.setAttribute(string2, (String)object);
        try {
            object = Exif.convertFromExifDateTime((String)object);
        }
        catch (ParseException parseException) {
            return;
        }
        long l11 = ((Date)object).getTime();
        l10 -= l11;
        String string3 = Long.toString(l10);
        ExifInterface exifInterface2 = this.mExifInterface;
        object = "SubSecTime";
        exifInterface2.setAttribute((String)object, string3);
    }

    private static Date convertFromExifDate(String string2) {
        return ((SimpleDateFormat)DATE_FORMAT.get()).parse(string2);
    }

    private static Date convertFromExifDateTime(String string2) {
        return ((SimpleDateFormat)DATETIME_FORMAT.get()).parse(string2);
    }

    private static Date convertFromExifTime(String string2) {
        return ((SimpleDateFormat)TIME_FORMAT.get()).parse(string2);
    }

    private static String convertToExifDateTime(long l10) {
        SimpleDateFormat simpleDateFormat = (SimpleDateFormat)DATETIME_FORMAT.get();
        Date date = new Date(l10);
        return simpleDateFormat.format(date);
    }

    public static Exif createFromFile(File file) {
        return Exif.createFromFileString(file.toString());
    }

    public static Exif createFromFileString(String string2) {
        ExifInterface exifInterface = new ExifInterface(string2);
        Exif exif = new Exif(exifInterface);
        return exif;
    }

    public static Exif createFromInputStream(InputStream inputStream) {
        ExifInterface exifInterface = new ExifInterface(inputStream);
        Exif exif = new Exif(exifInterface);
        return exif;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private long parseTimestamp(String object) {
        long l10 = -1;
        if (object == null) {
            return l10;
        }
        try {
            object = Exif.convertFromExifDateTime((String)object);
        }
        catch (ParseException parseException) {
            return l10;
        }
        return ((Date)object).getTime();
    }

    private long parseTimestamp(String object, String string2) {
        long l10 = -1;
        if (object == null && string2 == null) {
            return l10;
        }
        if (string2 == null) {
            try {
                object = Exif.convertFromExifDate((String)object);
            }
            catch (ParseException parseException) {
                return l10;
            }
            return ((Date)object).getTime();
        }
        if (object == null) {
            try {
                object = Exif.convertFromExifTime(string2);
            }
            catch (ParseException parseException) {
                return l10;
            }
            return ((Date)object).getTime();
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append((String)object);
        stringBuilder.append(" ");
        stringBuilder.append(string2);
        object = stringBuilder.toString();
        return this.parseTimestamp((String)object);
    }

    public void attachLocation(Location location) {
        this.mExifInterface.setGpsInfo(location);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void attachTimestamp() {
        long l10 = System.currentTimeMillis();
        Object object = Exif.convertToExifDateTime(l10);
        this.mExifInterface.setAttribute("DateTimeOriginal", (String)object);
        ExifInterface exifInterface = this.mExifInterface;
        String string2 = "DateTimeDigitized";
        exifInterface.setAttribute(string2, (String)object);
        try {
            object = Exif.convertFromExifDateTime((String)object);
            long l11 = ((Date)object).getTime();
            String string3 = Long.toString(l10 -= l11);
            ExifInterface exifInterface2 = this.mExifInterface;
            object = "SubSecTimeOriginal";
            exifInterface2.setAttribute((String)object, string3);
            exifInterface2 = this.mExifInterface;
            object = "SubSecTimeDigitized";
            exifInterface2.setAttribute((String)object, string3);
        }
        catch (ParseException parseException) {}
        this.mRemoveTimestamp = false;
    }

    public void flipHorizontally() {
        int n10 = this.getOrientation();
        switch (n10) {
            default: {
                n10 = 2;
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
            case 2: {
                n10 = 1;
            }
        }
        ExifInterface exifInterface = this.mExifInterface;
        String string2 = String.valueOf(n10);
        exifInterface.setAttribute("Orientation", string2);
    }

    public void flipVertically() {
        int n10 = this.getOrientation();
        switch (n10) {
            default: {
                n10 = 4;
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
            case 4: {
                n10 = 1;
                break;
            }
            case 3: {
                n10 = 2;
                break;
            }
            case 2: {
                n10 = 3;
            }
        }
        ExifInterface exifInterface = this.mExifInterface;
        String string2 = String.valueOf(n10);
        exifInterface.setAttribute("Orientation", string2);
    }

    public String getDescription() {
        return this.mExifInterface.getAttribute("ImageDescription");
    }

    public int getHeight() {
        return this.mExifInterface.getAttributeInt("ImageLength", 0);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public long getLastModifiedTimestamp() {
        long l10;
        Object object = this.mExifInterface;
        String string2 = "DateTime";
        long l11 = this.parseTimestamp((String)(object = ((ExifInterface)object).getAttribute(string2)));
        long l12 = l11 - (l10 = (long)-1);
        long l13 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (l13 == false) {
            return l10;
        }
        Object object2 = this.mExifInterface;
        String string3 = "SubSecTime";
        if ((object2 = ((ExifInterface)object2).getAttribute(string3)) == null) return l11;
        try {
            long l14;
            long l15;
            l10 = Long.parseLong((String)object2);
            while ((l13 = (l15 = l10 - (l14 = 1000L)) == 0L ? 0 : (l15 < 0L ? -1 : 1)) > 0) {
                l14 = 10;
                l10 /= l14;
            }
            l11 += l10;
            return l11;
        }
        catch (NumberFormatException numberFormatException) {
            return l11;
        }
    }

    public Location getLocation() {
        Exif exif = this;
        Object object = this.mExifInterface.getAttribute("GPSProcessingMethod");
        Object object2 = this.mExifInterface.getLatLong();
        Object object3 = this.mExifInterface;
        double d10 = 0.0;
        double d11 = ((ExifInterface)object3).getAltitude(d10);
        object3 = this.mExifInterface;
        String string2 = "GPSSpeed";
        double d12 = ((ExifInterface)object3).getAttributeDouble(string2, d10);
        object3 = this.mExifInterface.getAttribute("GPSSpeedRef");
        String string3 = KILOMETERS_PER_HOUR;
        if (object3 == null) {
            object3 = string3;
        }
        String string4 = exif.mExifInterface.getAttribute("GPSDateStamp");
        Object object4 = exif.mExifInterface;
        String string5 = "GPSTimeStamp";
        object4 = ((ExifInterface)object4).getAttribute(string5);
        long l10 = exif.parseTimestamp(string4, (String)object4);
        if (object2 == null) {
            return null;
        }
        if (object == null) {
            object = TAG;
        }
        string5 = new Location((String)object);
        float f10 = 0.0f;
        object = null;
        double d13 = object2[0];
        string5.setLatitude(d13);
        int n10 = 1;
        float f11 = Float.MIN_VALUE;
        double d14 = object2[n10];
        string5.setLongitude(d14);
        double d15 = d11 == d10 ? 0 : (d11 > d10 ? 1 : -1);
        if (d15 != false) {
            string5.setAltitude(d11);
        }
        if ((d15 = d12 == d10 ? 0 : (d12 > d10 ? 1 : -1)) != false) {
            int n11;
            d15 = -1;
            f10 = 0.0f / 0.0f;
            int n12 = ((String)object3).hashCode();
            if (n12 != (n11 = 75)) {
                n11 = 77;
                if (n12 != n11) {
                    n11 = 78;
                    if (n12 == n11 && (n12 = (int)(((String)object3).equals(object2 = (Object)KNOTS) ? 1 : 0)) != 0) {
                        d15 = n10;
                        f10 = f11;
                    }
                } else {
                    object2 = MILES_PER_HOUR;
                    n12 = ((String)object3).equals(object2) ? 1 : 0;
                    if (n12 != 0) {
                        d15 = 0.0;
                        f10 = 0.0f;
                        object = null;
                    }
                }
            } else {
                n12 = ((String)object3).equals(string3) ? 1 : 0;
                if (n12 != 0) {
                    d15 = 2;
                    f10 = 2.8E-45f;
                }
            }
            if (d15 != false) {
                if (d15 != n10) {
                    object = Exif$Speed.fromKilometersPerHour(d12);
                    d14 = ((Exif$Speed$Converter)object).toMetersPerSecond();
                } else {
                    object = Exif$Speed.fromKnots(d12);
                    d14 = ((Exif$Speed$Converter)object).toMetersPerSecond();
                }
            } else {
                object = Exif$Speed.fromMilesPerHour(d12);
                d14 = ((Exif$Speed$Converter)object).toMetersPerSecond();
            }
            f10 = (float)d14;
            string5.setSpeed(f10);
        }
        long l11 = -1;
        d14 = 0.0 / 0.0;
        d15 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        if (d15 != false) {
            string5.setTime(l10);
        }
        return string5;
    }

    public int getOrientation() {
        return this.mExifInterface.getAttributeInt("Orientation", 0);
    }

    public int getRotation() {
        int n10 = this.getOrientation();
        int n11 = 90;
        int n12 = 270;
        int n13 = 180;
        switch (n10) {
            default: {
                return 0;
            }
            case 8: {
                return n12;
            }
            case 6: 
            case 7: {
                return n11;
            }
            case 5: {
                return n12;
            }
            case 3: 
            case 4: 
        }
        return n13;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public long getTimestamp() {
        long l10;
        Object object = this.mExifInterface;
        String string2 = "DateTimeOriginal";
        long l11 = this.parseTimestamp((String)(object = ((ExifInterface)object).getAttribute(string2)));
        long l12 = l11 - (l10 = (long)-1);
        long l13 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (l13 == false) {
            return l10;
        }
        Object object2 = this.mExifInterface;
        String string3 = "SubSecTimeOriginal";
        if ((object2 = ((ExifInterface)object2).getAttribute(string3)) == null) return l11;
        try {
            long l14;
            long l15;
            l10 = Long.parseLong((String)object2);
            while ((l13 = (l15 = l10 - (l14 = 1000L)) == 0L ? 0 : (l15 < 0L ? -1 : 1)) > 0) {
                l14 = 10;
                l10 /= l14;
            }
            l11 += l10;
            return l11;
        }
        catch (NumberFormatException numberFormatException) {
            return l11;
        }
    }

    public int getWidth() {
        return this.mExifInterface.getAttributeInt("ImageWidth", 0);
    }

    public boolean isFlippedHorizontally() {
        int n10;
        int n11 = this.getOrientation();
        return n11 == (n10 = 2);
    }

    public boolean isFlippedVertically() {
        int n10 = this.getOrientation();
        int n11 = 4;
        boolean bl2 = true;
        if (n10 != n11 && n10 != (n11 = 5) && n10 != (n11 = 7)) {
            return false;
        }
        return bl2;
    }

    public void removeLocation() {
        this.mExifInterface.setAttribute("GPSProcessingMethod", null);
        this.mExifInterface.setAttribute("GPSLatitude", null);
        this.mExifInterface.setAttribute("GPSLatitudeRef", null);
        this.mExifInterface.setAttribute("GPSLongitude", null);
        this.mExifInterface.setAttribute("GPSLongitudeRef", null);
        this.mExifInterface.setAttribute("GPSAltitude", null);
        this.mExifInterface.setAttribute("GPSAltitudeRef", null);
        this.mExifInterface.setAttribute("GPSSpeed", null);
        this.mExifInterface.setAttribute("GPSSpeedRef", null);
        this.mExifInterface.setAttribute("GPSDateStamp", null);
        this.mExifInterface.setAttribute("GPSTimeStamp", null);
    }

    public void removeTimestamp() {
        this.mExifInterface.setAttribute("DateTime", null);
        this.mExifInterface.setAttribute("DateTimeOriginal", null);
        this.mExifInterface.setAttribute("DateTimeDigitized", null);
        this.mExifInterface.setAttribute("SubSecTime", null);
        this.mExifInterface.setAttribute("SubSecTimeOriginal", null);
        this.mExifInterface.setAttribute("SubSecTimeDigitized", null);
        this.mRemoveTimestamp = true;
    }

    public void rotate(int n10) {
        int n11 = n10 % 90;
        String string2 = "Orientation";
        int n12 = 1;
        if (n11 != 0) {
            Object object;
            String string3 = TAG;
            Locale locale = Locale.US;
            Object[] objectArray = new Object[n12];
            objectArray[0] = object = Integer.valueOf(n10);
            object = String.format(locale, "Can only rotate in right angles (eg. 0, 90, 180, 270). %d is unsupported.", objectArray);
            Logger.w(string3, (String)object);
            object = this.mExifInterface;
            string3 = String.valueOf(0);
            ((ExifInterface)object).setAttribute(string2, string3);
            return;
        }
        n10 %= 360;
        n11 = this.getOrientation();
        int n13 = 2;
        int n14 = 4;
        int n15 = 7;
        int n16 = 5;
        int n17 = 8;
        int n18 = 6;
        block17: while (n10 < 0) {
            n10 += 90;
            switch (n11) {
                default: {
                    n11 = n17;
                    continue block17;
                }
                case 7: {
                    n11 = n13;
                    continue block17;
                }
                case 6: {
                    n11 = n12;
                    continue block17;
                }
                case 5: {
                    n11 = n14;
                    continue block17;
                }
                case 4: {
                    n11 = n15;
                    continue block17;
                }
                case 3: 
                case 8: {
                    n11 = n18;
                    continue block17;
                }
                case 2: 
            }
            n11 = n16;
        }
        block18: while (n10 > 0) {
            n10 += -90;
            switch (n11) {
                default: {
                    n11 = n18;
                    continue block18;
                }
                case 8: {
                    n11 = n12;
                    continue block18;
                }
                case 7: {
                    n11 = n14;
                    continue block18;
                }
                case 6: {
                    n11 = 3;
                    continue block18;
                }
                case 5: {
                    n11 = n13;
                    continue block18;
                }
                case 4: {
                    n11 = n16;
                    continue block18;
                }
                case 3: {
                    n11 = n17;
                    continue block18;
                }
                case 2: 
            }
            n11 = n15;
        }
        ExifInterface exifInterface = this.mExifInterface;
        String string4 = String.valueOf(n11);
        exifInterface.setAttribute(string2, string4);
    }

    public void save() {
        boolean bl2 = this.mRemoveTimestamp;
        if (!bl2) {
            this.attachLastModifiedTimestamp();
        }
        this.mExifInterface.saveAttributes();
    }

    public void setDescription(String string2) {
        this.mExifInterface.setAttribute("ImageDescription", string2);
    }

    public void setOrientation(int n10) {
        ExifInterface exifInterface = this.mExifInterface;
        String string2 = String.valueOf(n10);
        exifInterface.setAttribute("Orientation", string2);
    }

    public String toString() {
        Locale locale = Locale.ENGLISH;
        Object object = this.getWidth();
        Object[] objectArray = new Object[]{object, object = Integer.valueOf(this.getHeight()), object = Integer.valueOf(this.getRotation()), object = Boolean.valueOf(this.isFlippedVertically()), object = Boolean.valueOf(this.isFlippedHorizontally()), object = this.getLocation(), object = Long.valueOf(this.getTimestamp()), object = this.getDescription()};
        return String.format(locale, "Exif{width=%s, height=%s, rotation=%d, isFlippedVertically=%s, isFlippedHorizontally=%s, location=%s, timestamp=%s, description=%s}", objectArray);
    }
}

