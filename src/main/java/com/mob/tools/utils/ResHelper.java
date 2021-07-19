/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ContentResolver
 *  android.content.ContentValues
 *  android.content.Context
 *  android.graphics.Point
 *  android.media.MediaScannerConnection
 *  android.media.MediaScannerConnection$OnScanCompletedListener
 *  android.net.Uri
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.provider.MediaStore$Images$Media
 *  android.provider.MediaStore$Video$Media
 *  android.text.TextUtils
 *  android.util.DisplayMetrics
 *  android.view.Display
 *  android.view.WindowManager
 */
package com.mob.tools.utils;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.graphics.Point;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.mob.tools.MobLog;
import com.mob.tools.log.NLog;
import com.mob.tools.network.KVPair;
import com.mob.tools.utils.Data;
import com.mob.tools.utils.DeviceHelper;
import com.mob.tools.utils.Hashon;
import com.mob.tools.utils.ReflectHelper;
import com.mob.tools.utils.ResHelper$1;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.lang.constant.Constable;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLDecoder;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class ResHelper {
    private static float density;
    private static int deviceWidth;
    private static Uri mediaUri;
    private static Object rp;

    public static /* synthetic */ Uri access$002(Uri uri) {
        mediaUri = uri;
        return uri;
    }

    public static void clearCache(Context object) {
        object = ResHelper.getCachePath(object, null);
        File file = new File((String)object);
        ResHelper.deleteFileAndFolder(file);
    }

    public static String contentUriToPath(Context context, Uri objectArray) {
        Object[] objectArray2;
        block40: {
            Object object;
            Object object2;
            block39: {
                int n10;
                block38: {
                    Object[] objectArray3;
                    int n11;
                    Class<Context> clazz;
                    Object object3;
                    String string2;
                    block37: {
                        block36: {
                            objectArray2 = null;
                            if (objectArray == null) {
                                return null;
                            }
                            object2 = objectArray.getPath();
                            object = new File((String)object2);
                            boolean n12 = ((File)object).exists();
                            if (n12) {
                                return objectArray.getPath();
                            }
                            int n13 = Build.VERSION.SDK_INT;
                            n10 = 19;
                            string2 = "_data";
                            if (n13 < n10) break block36;
                            object = "android.provider.DocumentsContract";
                            object = Class.forName((String)object);
                            object2 = "isDocumentUri";
                            int n14 = 2;
                            object3 = new Class[n14];
                            clazz = Context.class;
                            object3[0] = clazz;
                            clazz = Uri.class;
                            n11 = 1;
                            object3[n11] = clazz;
                            object2 = ((Class)object).getMethod((String)object2, (Class<?>)object3);
                            object2.setAccessible(n11 != 0);
                            object3 = Boolean.TRUE;
                            objectArray3 = new Object[n14];
                            objectArray3[0] = context;
                            objectArray3[n11] = objectArray;
                            object2 = object2.invoke(null, objectArray3);
                            n10 = (int)(((Boolean)object3).equals(object2) ? 1 : 0);
                            if (n10 == 0) break block36;
                            object2 = "getDocumentId";
                            objectArray3 = new Class[n11];
                            object3 = Uri.class;
                            objectArray3[0] = object3;
                            object = ((Class)object).getMethod((String)object2, (Class<?>[])objectArray3);
                            ((Method)object).setAccessible(n11 != 0);
                            object2 = new Object[n11];
                            object2[0] = objectArray;
                            object = ((Method)object).invoke(null, object2);
                            object = String.valueOf(object);
                            object2 = ":";
                            object = ((String)object).split((String)object2);
                            object = object[n11];
                            String[] stringArray = new String[]{string2};
                            String string3 = "_id=?";
                            String[] stringArray2 = new String[n11];
                            stringArray2[0] = object;
                            ContentResolver contentResolver = context.getContentResolver();
                            Uri uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                            object = contentResolver.query(uri, stringArray, string3, stringArray2, null);
                            break block37;
                        }
                        boolean bl2 = false;
                        object = null;
                    }
                    if (object == null) {
                        object2 = context.getContentResolver();
                        object3 = null;
                        clazz = null;
                        n11 = 0;
                        objectArray3 = objectArray;
                        object = object2.query((Uri)objectArray, null, null, null, null);
                    }
                    if (object == null) break block40;
                    n10 = (int)(object.moveToFirst() ? 1 : 0);
                    if (n10 == 0) break block38;
                    n10 = object.getColumnIndex(string2);
                    object2 = object.getString(n10);
                    break block39;
                }
                n10 = 0;
                object2 = null;
            }
            try {
                object.close();
                objectArray2 = object2;
            }
            catch (Throwable throwable) {
                object2 = MobLog.getInstance();
                object2.w(throwable);
            }
        }
        return objectArray2;
    }

    public static void copyFile(FileInputStream fileInputStream, FileOutputStream fileOutputStream) {
        int n10 = 65536;
        byte[] byArray = new byte[n10];
        int n11 = fileInputStream.read(byArray);
        while (n11 > 0) {
            fileOutputStream.write(byArray, 0, n11);
            n11 = fileInputStream.read(byArray);
        }
        fileInputStream.close();
        fileOutputStream.close();
    }

    public static boolean copyFile(String object, String string2) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)object);
        if (!bl2 && !(bl2 = TextUtils.isEmpty((CharSequence)string2))) {
            Object object2 = new File((String)object);
            bl2 = ((File)object2).exists();
            if (!bl2) {
                return false;
            }
            try {
                object2 = new FileInputStream((String)object);
            }
            catch (Throwable throwable) {}
            object = new FileOutputStream(string2);
            ResHelper.copyFile((FileInputStream)object2, (FileOutputStream)object);
            return true;
        }
        return false;
    }

    public static int[] covertTimeInYears(long l10) {
        long l11 = System.currentTimeMillis() - l10;
        l10 = 0L;
        Object object = l11 == l10 ? 0 : (l11 < l10 ? -1 : 1);
        int n10 = 2;
        if (object <= 0) {
            int[] nArray = new int[n10];
            nArray[0] = 0;
            nArray[1] = 0;
            return nArray;
        }
        long l12 = 60;
        long l13 = (l11 /= 1000L) - l12;
        object = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
        int n11 = 1;
        if (object < 0) {
            int[] nArray = new int[n10];
            nArray[0] = n10 = (int)l11;
            nArray[n11] = 0;
            return nArray;
        }
        long l14 = (l11 /= l12) - l12;
        object = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
        if (object < 0) {
            int[] nArray = new int[n10];
            nArray[0] = n10 = (int)l11;
            nArray[n11] = n11;
            return nArray;
        }
        long l15 = (l11 /= l12) - (l12 = (long)24);
        object = l15 == 0L ? 0 : (l15 < 0L ? -1 : 1);
        if (object < 0) {
            int n12;
            int[] nArray = new int[n10];
            nArray[0] = n12 = (int)l11;
            nArray[n11] = n10;
            return nArray;
        }
        long l16 = (l11 /= l12) - (l12 = (long)30);
        object = l16 == 0L ? 0 : (l16 < 0L ? -1 : 1);
        if (object < 0) {
            int[] nArray = new int[n10];
            nArray[0] = n10 = (int)l11;
            nArray[n11] = 3;
            return nArray;
        }
        long l17 = (l11 /= l12) - (l12 = (long)12);
        object = l17 == 0L ? 0 : (l17 < 0L ? -1 : 1);
        if (object < 0) {
            int[] nArray = new int[n10];
            nArray[0] = n10 = (int)l11;
            nArray[n11] = 4;
            return nArray;
        }
        int[] nArray = new int[n10];
        nArray[0] = n10 = (int)(l11 /= l12);
        nArray[n11] = 5;
        return nArray;
    }

    public static long dateStrToLong(String string2) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        ParsePosition parsePosition = new ParsePosition(0);
        return simpleDateFormat.parse(string2, parsePosition).getTime();
    }

    public static long dateToLong(String object) {
        Date date;
        try {
            date = new Date((String)object);
            object = Calendar.getInstance();
        }
        catch (Throwable throwable) {
            MobLog.getInstance().w(throwable);
            return 0L;
        }
        ((Calendar)object).setTime(date);
        return ((Calendar)object).getTimeInMillis();
    }

    public static Bundle decodeUrl(String stringArray) {
        Bundle bundle = new Bundle();
        if (stringArray != null) {
            String string2 = "&";
            for (String string3 : stringArray.split(string2)) {
                String string4;
                int n10;
                String string5 = "=";
                String[] stringArray2 = string3.split(string5);
                int n11 = stringArray2.length;
                if (n11 >= (n10 = 2) && (string4 = stringArray2[n11 = 1]) != null) {
                    string4 = URLDecoder.decode(stringArray2[0]);
                    String string6 = URLDecoder.decode(stringArray2[n11]);
                    bundle.putString(string4, string6);
                    continue;
                }
                String string7 = URLDecoder.decode(stringArray2[0]);
                string5 = "";
                bundle.putString(string7, string5);
            }
        }
        return bundle;
    }

    public static void deleteFileAndFolder(File file) {
        boolean bl2;
        if (file != null && (bl2 = file.exists())) {
            int n10;
            bl2 = file.isFile();
            if (bl2) {
                file.delete();
                return;
            }
            String[] stringArray = file.list();
            if (stringArray != null && (n10 = stringArray.length) > 0) {
                for (String string2 : stringArray) {
                    File file2 = new File(file, string2);
                    boolean bl3 = file2.isDirectory();
                    if (bl3) {
                        ResHelper.deleteFileAndFolder(file2);
                        continue;
                    }
                    file2.delete();
                }
                file.delete();
                return;
            }
            file.delete();
        }
    }

    public static void deleteFilesInFolder(File file) {
        boolean bl2;
        if (file != null && (bl2 = file.exists())) {
            int n10;
            bl2 = file.isFile();
            if (bl2) {
                file.delete();
                return;
            }
            String[] stringArray = file.list();
            if (stringArray != null && (n10 = stringArray.length) > 0) {
                for (String string2 : stringArray) {
                    File file2 = new File(file, string2);
                    boolean bl3 = file2.isDirectory();
                    if (bl3) {
                        ResHelper.deleteFilesInFolder(file2);
                        continue;
                    }
                    file2.delete();
                }
            }
        }
    }

    public static int designToDevice(Context context, float f10, int n10) {
        float f11;
        float f12 = density;
        float f13 = f12 - 0.0f;
        Object object = f13 == 0.0f ? 0 : (f13 < 0.0f ? -1 : 1);
        if (object <= 0) {
            context = context.getResources().getDisplayMetrics();
            density = f11 = context.density;
        }
        f11 = n10;
        float f14 = density;
        return (int)(f11 * f14 / f10 + 0.5f);
    }

    public static int designToDevice(Context object, int n10, int n11) {
        int n12 = deviceWidth;
        if (n12 == 0) {
            object = ResHelper.getScreenSize(object);
            n12 = 0;
            Context context = object[0];
            int n13 = 1;
            Context context2 = object[n13];
            Context context3 = context < context2 ? object[0] : object[n13];
            deviceWidth = (int)context3;
        }
        float f10 = n11;
        float f11 = deviceWidth;
        float f12 = n10;
        return (int)((f10 *= f11) / f12 + 0.5f);
    }

    public static int dipToPx(Context context, int n10) {
        float f10;
        float f11 = density;
        float f12 = f11 - 0.0f;
        Object object = f12 == 0.0f ? 0 : (f12 < 0.0f ? -1 : 1);
        if (object <= 0) {
            context = context.getResources().getDisplayMetrics();
            density = f10 = context.density;
        }
        f10 = n10;
        float f13 = density;
        return (int)(f10 * f13 + 0.5f);
    }

    public static String encodeUrl(Bundle bundle) {
        boolean bl2;
        String string2 = "";
        if (bundle == null) {
            return string2;
        }
        StringBuilder stringBuilder = new StringBuilder();
        boolean bl3 = true;
        Iterator iterator2 = bundle.keySet().iterator();
        while (bl2 = iterator2.hasNext()) {
            CharSequence charSequence;
            String string3 = (String)iterator2.next();
            Object object = bundle.get(string3);
            if (object == null) {
                object = string2;
            }
            if (bl3) {
                bl3 = false;
            } else {
                charSequence = "&";
                stringBuilder.append((String)charSequence);
            }
            charSequence = new StringBuilder();
            string3 = Data.urlEncode(string3);
            ((StringBuilder)charSequence).append(string3);
            ((StringBuilder)charSequence).append("=");
            string3 = Data.urlEncode(String.valueOf(object));
            ((StringBuilder)charSequence).append(string3);
            string3 = ((StringBuilder)charSequence).toString();
            stringBuilder.append(string3);
        }
        return stringBuilder.toString();
    }

    public static String encodeUrl(ArrayList object) {
        boolean bl2;
        if (object == null) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        int n10 = 0;
        object = ((ArrayList)object).iterator();
        while (bl2 = object.hasNext()) {
            Object object2 = (KVPair)object.next();
            if (n10 > 0) {
                char c10 = '&';
                stringBuilder.append(c10);
            }
            String string2 = ((KVPair)object2).name;
            object2 = (String)((KVPair)object2).value;
            if (string2 == null) continue;
            if (object2 == null) {
                object2 = "";
            }
            StringBuilder stringBuilder2 = new StringBuilder();
            string2 = Data.urlEncode(string2);
            stringBuilder2.append(string2);
            string2 = "=";
            stringBuilder2.append(string2);
            object2 = Data.urlEncode((String)object2);
            stringBuilder2.append((String)object2);
            object2 = stringBuilder2.toString();
            stringBuilder.append((String)object2);
            ++n10;
        }
        return stringBuilder.toString();
    }

    public static Object forceCast(Object object) {
        return ResHelper.forceCast(object, null);
    }

    public static Object forceCast(Object object, Object object2) {
        if (object == null) {
            return object2;
        }
        int n10 = object instanceof Byte;
        boolean bl2 = true;
        if (n10 != 0) {
            Object object3 = object;
            object3 = (Byte)object;
            n10 = ((Byte)object3).byteValue();
            boolean bl3 = object2 instanceof Boolean;
            if (bl3) {
                if (n10 == 0) {
                    bl2 = false;
                }
                return bl2;
            }
            bl2 = object2 instanceof Short;
            if (bl2) {
                return (short)n10;
            }
            bl2 = object2 instanceof Character;
            if (bl2) {
                return Character.valueOf((char)n10);
            }
            bl2 = object2 instanceof Integer;
            if (bl2) {
                return n10;
            }
            bl2 = object2 instanceof Float;
            if (bl2) {
                return Float.valueOf(n10);
            }
            bl2 = object2 instanceof Long;
            if (bl2) {
                return (long)n10;
            }
            boolean bl4 = object2 instanceof Double;
            if (bl4) {
                return (double)n10;
            }
        } else {
            n10 = object instanceof Character;
            if (n10 != 0) {
                Object object4 = object;
                object4 = (Character)object;
                n10 = ((Character)object4).charValue();
                boolean bl5 = object2 instanceof Byte;
                if (bl5) {
                    return (byte)n10;
                }
                bl5 = object2 instanceof Boolean;
                if (bl5) {
                    if (n10 == 0) {
                        bl2 = false;
                    }
                    return bl2;
                }
                bl2 = object2 instanceof Short;
                if (bl2) {
                    return (short)n10;
                }
                bl2 = object2 instanceof Integer;
                if (bl2) {
                    return n10;
                }
                bl2 = object2 instanceof Float;
                if (bl2) {
                    return Float.valueOf(n10);
                }
                bl2 = object2 instanceof Long;
                if (bl2) {
                    return (long)n10;
                }
                boolean bl6 = object2 instanceof Double;
                if (bl6) {
                    return (double)n10;
                }
            } else {
                n10 = object instanceof Short;
                if (n10 != 0) {
                    Object object5 = object;
                    object5 = (Short)object;
                    n10 = ((Short)object5).shortValue();
                    boolean bl7 = object2 instanceof Byte;
                    if (bl7) {
                        return (byte)n10;
                    }
                    bl7 = object2 instanceof Boolean;
                    if (bl7) {
                        if (n10 == 0) {
                            bl2 = false;
                        }
                        return bl2;
                    }
                    bl2 = object2 instanceof Character;
                    if (bl2) {
                        return Character.valueOf((char)n10);
                    }
                    bl2 = object2 instanceof Integer;
                    if (bl2) {
                        return n10;
                    }
                    bl2 = object2 instanceof Float;
                    if (bl2) {
                        return Float.valueOf(n10);
                    }
                    bl2 = object2 instanceof Long;
                    if (bl2) {
                        return (long)n10;
                    }
                    boolean bl8 = object2 instanceof Double;
                    if (bl8) {
                        return (double)n10;
                    }
                } else {
                    n10 = object instanceof Integer;
                    if (n10 != 0) {
                        Object object6 = object;
                        object6 = (Integer)object;
                        n10 = (Integer)object6;
                        boolean bl9 = object2 instanceof Byte;
                        if (bl9) {
                            return (byte)n10;
                        }
                        bl9 = object2 instanceof Boolean;
                        if (bl9) {
                            if (n10 == 0) {
                                bl2 = false;
                            }
                            return bl2;
                        }
                        bl2 = object2 instanceof Character;
                        if (bl2) {
                            return Character.valueOf((char)n10);
                        }
                        bl2 = object2 instanceof Short;
                        if (bl2) {
                            return (short)n10;
                        }
                        bl2 = object2 instanceof Float;
                        if (bl2) {
                            return Float.valueOf(n10);
                        }
                        bl2 = object2 instanceof Long;
                        if (bl2) {
                            return (long)n10;
                        }
                        boolean bl10 = object2 instanceof Double;
                        if (bl10) {
                            return (double)n10;
                        }
                    } else {
                        n10 = object instanceof Float;
                        if (n10 != 0) {
                            Object object7 = object;
                            object7 = (Float)object;
                            float f10 = ((Float)object7).floatValue();
                            boolean bl11 = object2 instanceof Byte;
                            if (bl11) {
                                return (byte)f10;
                            }
                            bl11 = object2 instanceof Boolean;
                            if (bl11) {
                                object = null;
                                float f11 = f10 - 0.0f;
                                Object object8 = f11 == 0.0f ? 0 : (f11 > 0.0f ? 1 : -1);
                                if (object8 == false) {
                                    bl2 = false;
                                }
                                return bl2;
                            }
                            bl2 = object2 instanceof Character;
                            if (bl2) {
                                return Character.valueOf((char)f10);
                            }
                            bl2 = object2 instanceof Short;
                            if (bl2) {
                                return (short)f10;
                            }
                            bl2 = object2 instanceof Integer;
                            if (bl2) {
                                return (int)f10;
                            }
                            bl2 = object2 instanceof Long;
                            if (bl2) {
                                return (long)f10;
                            }
                            boolean bl12 = object2 instanceof Double;
                            if (bl12) {
                                return (double)f10;
                            }
                        } else {
                            n10 = object instanceof Long;
                            if (n10 != 0) {
                                Object object9 = object;
                                object9 = (Long)object;
                                long l10 = (Long)object9;
                                n10 = object2 instanceof Byte;
                                if (n10 != 0) {
                                    return (byte)l10;
                                }
                                n10 = object2 instanceof Boolean;
                                if (n10 != 0) {
                                    long l11 = 0L;
                                    double d10 = 0.0;
                                    Object object10 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
                                    if (object10 == false) {
                                        bl2 = false;
                                    }
                                    return bl2;
                                }
                                n10 = object2 instanceof Character;
                                if (n10 != 0) {
                                    return Character.valueOf((char)l10);
                                }
                                n10 = object2 instanceof Short;
                                if (n10 != 0) {
                                    return (short)l10;
                                }
                                n10 = object2 instanceof Integer;
                                if (n10 != 0) {
                                    return (int)l10;
                                }
                                n10 = object2 instanceof Float;
                                if (n10 != 0) {
                                    return Float.valueOf(l10);
                                }
                                boolean bl13 = object2 instanceof Double;
                                if (bl13) {
                                    return (double)l10;
                                }
                            } else {
                                n10 = object instanceof Double;
                                if (n10 != 0) {
                                    Object object11 = object;
                                    object11 = (Double)object;
                                    double d11 = (Double)object11;
                                    n10 = object2 instanceof Byte;
                                    if (n10 != 0) {
                                        return (byte)d11;
                                    }
                                    n10 = object2 instanceof Boolean;
                                    if (n10 != 0) {
                                        long l12 = 0L;
                                        double d12 = 0.0;
                                        double d13 = d11 - d12;
                                        Object object12 = d13 == 0.0 ? 0 : (d13 > 0.0 ? 1 : -1);
                                        if (object12 == false) {
                                            bl2 = false;
                                        }
                                        return bl2;
                                    }
                                    n10 = object2 instanceof Character;
                                    if (n10 != 0) {
                                        return Character.valueOf((char)d11);
                                    }
                                    n10 = object2 instanceof Short;
                                    if (n10 != 0) {
                                        return (short)d11;
                                    }
                                    n10 = object2 instanceof Integer;
                                    if (n10 != 0) {
                                        return (int)d11;
                                    }
                                    n10 = object2 instanceof Float;
                                    if (n10 != 0) {
                                        return Float.valueOf((float)d11);
                                    }
                                    boolean bl14 = object2 instanceof Long;
                                    if (bl14) {
                                        long l13 = (long)d11;
                                        object = l13;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return object;
    }

    public static int getAnimRes(Context context, String string2) {
        return ResHelper.getResId(context, "anim", string2);
    }

    public static int getBitmapRes(Context context, String string2) {
        String string3 = "drawable";
        int n10 = ResHelper.getResId(context, string3, string2);
        if (n10 <= 0) {
            string3 = "mipmap";
            n10 = ResHelper.getResId(context, string3, string2);
        }
        return n10;
    }

    public static String getCachePath(Context object, String string2) {
        boolean bl2;
        boolean bl3;
        Object object2;
        block11: {
            object2 = new StringBuilder();
            Object object3 = object.getFilesDir().getAbsolutePath();
            ((StringBuilder)object2).append((String)object3);
            object3 = "/Mob/cache/";
            ((StringBuilder)object2).append((String)object3);
            object2 = ((StringBuilder)object2).toString();
            object = DeviceHelper.getInstance((Context)object);
            boolean bl4 = ((DeviceHelper)object).getSdcardState();
            if (!bl4) break block11;
            object3 = ((DeviceHelper)object).getSdcardPath();
            if (object3 == null) break block11;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append((String)object3);
            object3 = "/Mob/";
            stringBuilder.append((String)object3);
            object = ((DeviceHelper)object).getPackageName();
            stringBuilder.append((String)object);
            object = "/cache/";
            try {
                stringBuilder.append((String)object);
                object2 = object = stringBuilder.toString();
            }
            catch (Throwable throwable) {
                object3 = MobLog.getInstance();
                ((NLog)object3).d(throwable);
            }
        }
        if (!(bl3 = TextUtils.isEmpty((CharSequence)string2))) {
            object = new StringBuilder();
            ((StringBuilder)object).append((String)object2);
            ((StringBuilder)object).append(string2);
            string2 = "/";
            ((StringBuilder)object).append(string2);
            object2 = ((StringBuilder)object).toString();
        }
        if (!(bl2 = ((File)(object = new File((String)object2))).exists()) || !(bl2 = ((File)object).isDirectory())) {
            ((File)object).mkdirs();
        }
        return object2;
    }

    public static String getCacheRoot(Context object) {
        CharSequence charSequence;
        block17: {
            block16: {
                Object object2;
                String string2 = "/Mob/";
                try {
                    charSequence = new StringBuilder();
                    object2 = object.getFilesDir();
                }
                catch (Throwable throwable) {
                    MobLog.getInstance().w(throwable);
                    return null;
                }
                object2 = ((File)object2).getAbsolutePath();
                ((StringBuilder)charSequence).append((String)object2);
                ((StringBuilder)charSequence).append(string2);
                charSequence = ((StringBuilder)charSequence).toString();
                object = DeviceHelper.getInstance((Context)object);
                boolean bl2 = ((DeviceHelper)object).getSdcardState();
                if (!bl2) break block16;
                object = ((DeviceHelper)object).getSdcardPath();
                if (object == null) break block16;
                charSequence = new StringBuilder();
                ((StringBuilder)charSequence).append((String)object);
                ((StringBuilder)charSequence).append(string2);
                charSequence = ((StringBuilder)charSequence).toString();
            }
            object = new File((String)charSequence);
            boolean bl3 = ((File)object).exists();
            if (bl3) break block17;
            ((File)object).mkdirs();
        }
        return charSequence;
    }

    public static File getCacheRootFile(Context object, String object2) {
        block7: {
            File file;
            block8: {
                object = ResHelper.getCacheRoot((Context)object);
                if (object == null) break block7;
                file = new File((String)object, (String)object2);
                object = file.getParentFile();
                boolean bl2 = ((File)object).exists();
                if (bl2) break block8;
                object = file.getParentFile();
                try {
                    ((File)object).mkdirs();
                }
                catch (Throwable throwable) {
                    object2 = MobLog.getInstance();
                    ((NLog)object2).w(throwable);
                }
            }
            return file;
        }
        return null;
    }

    public static int getColorRes(Context context, String string2) {
        return ResHelper.getResId(context, "color", string2);
    }

    public static String getDataCache(Context object) {
        Comparable<StringBuilder> comparable = new Comparable<StringBuilder>();
        object = object.getFilesDir().getAbsolutePath();
        ((StringBuilder)comparable).append((String)object);
        ((StringBuilder)comparable).append("/Mob/");
        object = ((StringBuilder)comparable).toString();
        comparable = new Comparable<StringBuilder>((String)object);
        boolean bl2 = ((File)comparable).exists();
        if (!bl2) {
            ((File)comparable).mkdirs();
        }
        return object;
    }

    public static File getDataCacheFile(Context object, String string2) {
        object = ResHelper.getDataCache(object);
        File file = new File((String)object, string2);
        return file;
    }

    public static float getDensity(Context context) {
        float f10 = density;
        float f11 = f10 - 0.0f;
        Object object = f11 == 0.0f ? 0 : (f11 < 0.0f ? -1 : 1);
        if (object <= 0) {
            float f12;
            context = context.getResources().getDisplayMetrics();
            density = f12 = context.density;
        }
        return density;
    }

    public static int getDensityDpi(Context context) {
        return context.getResources().getDisplayMetrics().densityDpi;
    }

    public static float[] getDensityXYDpi(Context context) {
        context = context.getResources().getDisplayMetrics();
        float f10 = context.xdpi;
        float f11 = context.ydpi;
        float[] fArray = new float[]{f10, f11};
        return fArray;
    }

    public static long getFileSize(File file) {
        boolean bl2 = file.exists();
        if (!bl2) {
            return 0L;
        }
        bl2 = file.isDirectory();
        if (bl2) {
            int n10;
            String[] stringArray = file.list();
            int n11 = 0;
            for (int i10 = 0; i10 < (n10 = stringArray.length); ++i10) {
                String string2 = stringArray[i10];
                File file2 = new File(file, string2);
                long l10 = n11;
                long l11 = ResHelper.getFileSize(file2);
                n11 = (int)(l10 += l11);
            }
            return n11;
        }
        return file.length();
    }

    public static long getFileSize(String string2) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (bl2) {
            return 0L;
        }
        File file = new File(string2);
        return ResHelper.getFileSize(file);
    }

    public static int getIdRes(Context context, String string2) {
        return ResHelper.getResId(context, "id", string2);
    }

    public static String getImageCachePath(Context context) {
        return ResHelper.getCachePath(context, "images");
    }

    public static int getLayoutRes(Context context, String string2) {
        return ResHelper.getResId(context, "layout", string2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static Uri getMediaUri(Context context, String stringArray, String object) {
        Class<ResHelper> clazz = ResHelper.class;
        synchronized (clazz) {
            block8: {
                long l10;
                Object object2 = new Object();
                mediaUri = null;
                int n10 = 1;
                String[] stringArray2 = new String[n10];
                stringArray2[0] = stringArray;
                stringArray = new String[n10];
                stringArray[0] = object;
                object = new ResHelper$1(object2);
                MediaScannerConnection.scanFile((Context)context, (String[])stringArray2, (String[])stringArray, (MediaScannerConnection.OnScanCompletedListener)object);
                try {
                    context = mediaUri;
                    if (context != null) break block8;
                    synchronized (object2) {
                        l10 = 10000L;
                    }
                }
                catch (Throwable throwable) {}
                {
                    object2.wait(l10);
                }
            }
            context = mediaUri;
            mediaUri = null;
            return context;
        }
    }

    public static int getPluralsRes(Context context, String string2) {
        return ResHelper.getResId(context, "plurals", string2);
    }

    public static int getRawRes(Context context, String string2) {
        return ResHelper.getResId(context, "raw", string2);
    }

    public static int getResId(Context object, String string2, String string3) {
        boolean bl2;
        Object object2 = String.class;
        int n10 = 0;
        Object object3 = null;
        if (object != null && !(bl2 = TextUtils.isEmpty((CharSequence)string2)) && !(bl2 = TextUtils.isEmpty((CharSequence)string3))) {
            Class<?> clazz = rp;
            if (clazz != null) {
                clazz = clazz.getClass();
                Object[] objectArray = "getResId";
                int n11 = 3;
                Class[] classArray = new Class[n11];
                Class<Context> clazz2 = Context.class;
                classArray[0] = clazz2;
                int n12 = 1;
                classArray[n12] = object2;
                int n13 = 2;
                classArray[n13] = object2;
                object2 = clazz.getMethod((String)objectArray, classArray);
                ((Method)object2).setAccessible(n12 != 0);
                clazz = rp;
                objectArray = new Object[n11];
                objectArray[0] = object;
                objectArray[n12] = string2;
                objectArray[n13] = string3;
                object2 = ((Method)object2).invoke(clazz, objectArray);
                object2 = (Integer)object2;
                try {
                    n10 = (Integer)object2;
                }
                catch (Throwable throwable) {
                    clazz = MobLog.getInstance();
                    ((NLog)((Object)clazz)).d(throwable);
                }
            }
            if (n10 <= 0) {
                object2 = object.getPackageName();
                bl2 = TextUtils.isEmpty((CharSequence)object2);
                if (bl2) {
                    return n10;
                }
                if (n10 <= 0 && (n10 = (object3 = object.getResources()).getIdentifier(string3, string2, (String)object2)) <= 0) {
                    int n14;
                    object = object.getResources();
                    object3 = string3.toLowerCase();
                    n10 = n14 = object.getIdentifier((String)object3, string2, (String)object2);
                }
                if (n10 <= 0) {
                    object = MobLog.getInstance();
                    object2 = new StringBuilder();
                    clazz = "failed to parse ";
                    ((StringBuilder)object2).append((String)((Object)clazz));
                    ((StringBuilder)object2).append(string2);
                    ((StringBuilder)object2).append(" resource \"");
                    ((StringBuilder)object2).append(string3);
                    ((StringBuilder)object2).append("\"");
                    string2 = ((StringBuilder)object2).toString();
                    ((NLog)object).w(string2);
                }
            }
        }
        return n10;
    }

    public static float getScaledDensity(Context context) {
        return context.getResources().getDisplayMetrics().scaledDensity;
    }

    public static int getScreenHeight(Context context) {
        return ResHelper.getScreenSize(context)[1];
    }

    public static int[] getScreenSize(Context object) {
        Object[] objectArray;
        GenericDeclaration genericDeclaration;
        Object object2 = null;
        Object object3 = DeviceHelper.getInstance(object);
        Object object4 = "window";
        object3 = ((DeviceHelper)object3).getSystemServiceSafe((String)object4);
        try {
            object3 = (WindowManager)object3;
        }
        catch (Throwable throwable) {
            object4 = MobLog.getInstance();
            ((NLog)object4).w(throwable);
            object3 = null;
        }
        int n10 = 2;
        if (object3 == null) {
            Object object5 = object = (Object)new int[n10];
            object5[0] = (Context)false;
            object5[1] = (Context)false;
            return object;
        }
        try {
            object2 = object3.getDefaultDisplay();
        }
        catch (Throwable throwable) {
            NLog nLog = MobLog.getInstance();
            nLog.w(throwable);
        }
        object3 = null;
        int n11 = 1;
        if (object2 == null) {
            try {
                object = object.getResources();
            }
            catch (Throwable throwable) {
                MobLog.getInstance().w(throwable);
                int[] nArray = new int[n10];
                nArray[0] = 0;
                nArray[1] = 0;
                return nArray;
            }
            object = object.getDisplayMetrics();
            object2 = new int[n10];
            int n12 = object.widthPixels;
            object2[0] = n12;
            int n13 = object.heightPixels;
            object2[n11] = (Display)n13;
            return object2;
        }
        int n14 = Build.VERSION.SDK_INT;
        int n15 = 13;
        if (n14 < n15) {
            try {
                object = new DisplayMetrics();
            }
            catch (Throwable throwable) {
                MobLog.getInstance().w(throwable);
                int[] nArray = new int[n10];
                nArray[0] = 0;
                nArray[1] = 0;
                return nArray;
            }
            object2.getMetrics((DisplayMetrics)object);
            object2 = new int[n10];
            n15 = object.widthPixels;
            object2[0] = (Display)n15;
            n14 = object.heightPixels;
            object2[n11] = (Display)n14;
            return object2;
        }
        try {
            object = new Point();
            genericDeclaration = object2.getClass();
            objectArray = "getRealSize";
        }
        catch (Throwable throwable) {
            MobLog.getInstance().w(throwable);
            int[] nArray = new int[n10];
            nArray[0] = 0;
            nArray[1] = 0;
            return nArray;
        }
        Class[] classArray = new Class[n11];
        Class<Point> clazz = Point.class;
        classArray[0] = clazz;
        genericDeclaration = ((Class)genericDeclaration).getMethod((String)objectArray, classArray);
        ((Method)genericDeclaration).setAccessible(n11 != 0);
        objectArray = new Object[n11];
        objectArray[0] = object;
        ((Method)genericDeclaration).invoke(object2, objectArray);
        object2 = new int[n10];
        n15 = object.x;
        object2[0] = (Display)n15;
        n14 = object.y;
        object2[n11] = (Display)n14;
        return object2;
    }

    public static int getScreenWidth(Context context) {
        return ResHelper.getScreenSize(context)[0];
    }

    public static int getStringArrayRes(Context context, String string2) {
        return ResHelper.getResId(context, "array", string2);
    }

    public static int getStringRes(Context context, String string2) {
        return ResHelper.getResId(context, "string", string2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static Object getStringValue(Context object, String clazz, Object object2) {
        try {
            Class<Constable> clazz2;
            int n10 = ResHelper.getStringRes((Context)object, clazz);
            object = object.getString(n10);
            object = ((String)object).trim();
            if (object2 == null) {
                return String.valueOf(object);
            }
            clazz = object2.getClass();
            boolean bl2 = clazz.equals(clazz2 = String.class);
            if (bl2) {
                return String.valueOf(object);
            }
            clazz2 = Integer.TYPE;
            bl2 = clazz.equals(clazz2);
            if (!bl2 && !(bl2 = clazz.equals(clazz2 = Integer.class))) {
                clazz2 = Long.TYPE;
                bl2 = clazz.equals(clazz2);
                if (!bl2 && !(bl2 = clazz.equals(clazz2 = Long.class))) {
                    clazz2 = Boolean.TYPE;
                    bl2 = clazz.equals(clazz2);
                    if (bl2) return Boolean.valueOf((String)object);
                    clazz2 = Boolean.class;
                    bl2 = clazz.equals(clazz2);
                    if (bl2) {
                        return Boolean.valueOf((String)object);
                    }
                    clazz2 = Float.TYPE;
                    bl2 = clazz.equals(clazz2);
                    if (!bl2 && !(bl2 = clazz.equals(clazz2 = Float.class))) {
                        clazz2 = Double.TYPE;
                        bl2 = clazz.equals(clazz2);
                        if (!bl2 && !(bl2 = clazz.equals(clazz2 = Double.class))) {
                            clazz2 = Character.TYPE;
                            bl2 = clazz.equals(clazz2);
                            if (!bl2 && !(bl2 = clazz.equals(clazz2 = Character.class))) {
                                clazz2 = Byte.TYPE;
                                bl2 = clazz.equals(clazz2);
                                if (!bl2 && !(bl2 = clazz.equals(clazz2 = Byte.class))) {
                                    clazz2 = Short.TYPE;
                                    bl2 = clazz.equals(clazz2);
                                    if (!bl2 && !(bl2 = clazz.equals(clazz2 = Short.class))) {
                                        clazz2 = new Hashon();
                                        return ((Hashon)((Object)clazz2)).fromJson((String)object, clazz);
                                    }
                                    object = String.valueOf(object);
                                    return Short.valueOf((String)object);
                                }
                                object = String.valueOf(object);
                                return Byte.valueOf((String)object);
                            }
                            object = String.valueOf(object);
                            n10 = 0;
                            clazz = null;
                            char c10 = ((String)object).charAt(0);
                            return Character.valueOf(c10);
                        }
                        object = String.valueOf(object);
                        return Double.valueOf((String)object);
                    }
                    object = String.valueOf(object);
                    return Float.valueOf((String)object);
                }
                object = String.valueOf(object);
                return Long.valueOf((String)object);
            }
            object = String.valueOf(object);
            return Integer.valueOf((String)object);
        }
        catch (Throwable throwable) {
            MobLog.getInstance().d(throwable);
            return object2;
        }
    }

    public static int getStyleRes(Context context, String string2) {
        return ResHelper.getResId(context, "style", string2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static int[] getStyleableRes(Context object, String clazz) {
        try {
            StringBuilder stringBuilder = new StringBuilder();
            object = object.getPackageName();
            stringBuilder.append((String)object);
            object = ".R$styleable";
            stringBuilder.append((String)object);
            object = stringBuilder.toString();
            object = ReflectHelper.importClass((String)object);
            object = ReflectHelper.getStaticField((String)object, (String)((Object)clazz));
            if (object == null) {
                return new int[0];
            }
            clazz = object.getClass();
            boolean bl2 = clazz.isArray();
            if (bl2) {
                return (int[])object;
            }
            int n10 = 1;
            clazz = (Class<?>)new int[n10];
            object = (Integer)object;
            int n11 = (Integer)object;
            clazz[0] = n11;
            return clazz;
        }
        catch (Throwable throwable) {
            MobLog.getInstance().d(throwable);
            return new int[0];
        }
    }

    public static int getTextLengthInWord(String object) {
        Object object2;
        object = object == null ? (Object)new char[0] : (Object)((String)object).toCharArray();
        int n10 = 0;
        for (int i10 = 0; i10 < (object2 = ((Object)object).length); ++i10) {
            object2 = object[i10];
            Object object3 = 256;
            object2 = object2 < object3 ? 1 : 2;
            n10 += object2;
        }
        return n10;
    }

    public static boolean isEqual(Object object, Object object2) {
        boolean bl2;
        boolean bl3 = true;
        if (object == null && object2 != null || object != null && !(bl2 = object.equals(object2))) {
            bl2 = bl3;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2 ^ bl3;
    }

    public static boolean isLeapYear(int n10) {
        int n11 = n10 % 400;
        n10 = n11 != 0 && ((n11 = n10 % 4) != 0 || (n10 %= 100) == 0) ? 0 : 1;
        return n10 != 0;
    }

    public static Date longToDate(long l10) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(l10);
        return calendar.getTime();
    }

    public static String longToTime(long l10, int n10) {
        int n11 = 1;
        String string2 = n10 != n11 ? (n10 != (n11 = 2) ? (n10 != (n11 = 5) ? (n10 != (n11 = 10) ? (n10 != (n11 = 12) ? "yyyy-MM-dd kk:mm:ss" : "yyyy-MM-dd kk:mm") : "yyyy-MM-dd kk") : "yyyy-MM-dd") : "yyyy-MM") : "yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(string2);
        Long l11 = l10;
        return simpleDateFormat.format(l11);
    }

    public static int parseInt(String string2) {
        return ResHelper.parseInt(string2, 10);
    }

    public static int parseInt(String string2, int n10) {
        return Integer.parseInt(string2, n10);
    }

    public static long parseLong(String string2) {
        return ResHelper.parseLong(string2, 10);
    }

    public static long parseLong(String string2, int n10) {
        return Long.parseLong(string2, n10);
    }

    public static Uri pathToContentUri(Context object, String object2) {
        block24: {
            Object object3;
            Object object4;
            block25: {
                object4 = "_id";
                object3 = DeviceHelper.getInstance((Context)object);
                String string2 = "android.permission.READ_EXTERNAL_STORAGE";
                boolean n10 = ((DeviceHelper)object3).checkPermission(string2);
                if (!n10) break block24;
                string2 = object.getContentResolver();
                Uri uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                String[] stringArray = new String[]{object4};
                String string3 = "_data=? ";
                int n11 = 1;
                String[] stringArray2 = new String[n11];
                boolean bl2 = false;
                object3 = null;
                stringArray2[0] = object2;
                object3 = string2.query(uri, stringArray, string3, stringArray2, null);
                if (object3 == null) break block25;
                boolean bl3 = object3.moveToFirst();
                if (!bl3) break block25;
                int n12 = object3.getColumnIndex((String)object4);
                n12 = object3.getInt(n12);
                object2 = "content://media/external/images/media";
                object2 = Uri.parse((String)object2);
                object4 = new StringBuilder();
                object3 = "";
                ((StringBuilder)object4).append((String)object3);
                ((StringBuilder)object4).append(n12);
                object = ((StringBuilder)object4).toString();
                return Uri.withAppendedPath((Uri)object2, (String)object);
            }
            object4 = new File((String)object2);
            boolean bl4 = ((File)object4).exists();
            if (!bl4) break block24;
            object4 = new ContentValues();
            object3 = "_data";
            object4.put((String)object3, (String)object2);
            object2 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
            object = object.getContentResolver();
            try {
                return object.insert((Uri)object2, (ContentValues)object4);
            }
            catch (Throwable throwable) {
                object2 = MobLog.getInstance();
                ((NLog)object2).w(throwable);
            }
        }
        return null;
    }

    public static int pxToDip(Context context, int n10) {
        float f10;
        float f11 = density;
        float f12 = f11 - 0.0f;
        Object object = f12 == 0.0f ? 0 : (f12 < 0.0f ? -1 : 1);
        if (object <= 0) {
            context = context.getResources().getDisplayMetrics();
            density = f10 = context.density;
        }
        f10 = n10;
        float f13 = density;
        return (int)(f10 / f13 + 0.5f);
    }

    public static Object readObjectFromFile(String object) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)object);
        if (!bl2) {
            Object object2;
            block11: {
                try {
                    object2 = new File((String)object);
                    boolean bl3 = ((File)object2).exists();
                    if (bl3) break block11;
                }
                catch (Throwable throwable) {
                    object2 = MobLog.getInstance();
                    ((NLog)object2).d(throwable);
                }
                bl2 = false;
                object2 = null;
            }
            if (object2 != null) {
                object = new FileInputStream((File)object2);
                object2 = new GZIPInputStream((InputStream)object);
                object = new ObjectInputStream((InputStream)object2);
                object2 = ((ObjectInputStream)object).readObject();
                try {
                    ((ObjectInputStream)object).close();
                    return object2;
                }
                catch (Throwable throwable) {
                    object2 = MobLog.getInstance();
                    ((NLog)object2).d(throwable);
                }
            }
        }
        return null;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static boolean saveObjectToFile(String object, Object object2) {
        Object object3;
        boolean bl2 = TextUtils.isEmpty((CharSequence)object);
        if (bl2) return false;
        try {
            object3 = new File((String)object);
            boolean bl3 = ((File)object3).exists();
            if (bl3) {
                ((File)object3).delete();
            }
            if (!(bl3 = ((File)(object = ((File)object3).getParentFile())).exists())) {
                object = ((File)object3).getParentFile();
                ((File)object).mkdirs();
            }
            ((File)object3).createNewFile();
        }
        catch (Throwable throwable) {
            MobLog.getInstance().d(throwable);
            return false;
        }
        if (object3 == null) return false;
        try {
            object = new FileOutputStream((File)object3);
            object3 = new GZIPOutputStream((OutputStream)object);
            object = new ObjectOutputStream((OutputStream)object3);
            ((ObjectOutputStream)object).writeObject(object2);
            ((ObjectOutputStream)object).flush();
            ((ObjectOutputStream)object).close();
            return true;
        }
        catch (Throwable throwable) {
            object2 = MobLog.getInstance();
            ((NLog)object2).d(throwable);
        }
        return false;
    }

    public static void setResourceProvider(Object object) {
        block8: {
            Object object2 = String.class;
            Class<?> clazz = object.getClass();
            String string2 = "getResId";
            int n10 = 3;
            Class[] classArray = new Class[n10];
            int n11 = 0;
            Class<Context> clazz2 = Context.class;
            classArray[0] = clazz2;
            n11 = 1;
            classArray[n11] = object2;
            n11 = 2;
            classArray[n11] = object2;
            object2 = clazz.getMethod(string2, classArray);
            if (object2 == null) break block8;
            try {
                rp = object;
            }
            catch (Throwable throwable) {
                object2 = MobLog.getInstance();
                ((NLog)object2).d(throwable);
            }
        }
    }

    public static long strToDate(String string2) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        ParsePosition parsePosition = new ParsePosition(0);
        return simpleDateFormat.parse(string2, parsePosition).getTime();
    }

    public static String toString(Object object) {
        object = object == null ? "" : object.toString();
        return object;
    }

    public static String toWordText(String object, int n10) {
        object = ((String)object).toCharArray();
        int n11 = 2;
        n10 *= n11;
        StringBuilder stringBuilder = new StringBuilder();
        for (Object object2 : object) {
            int n12 = 256;
            n12 = object2 < n12 ? 1 : n11;
            if ((n10 -= n12) < 0) {
                return stringBuilder.toString();
            }
            stringBuilder.append((char)object2);
        }
        return stringBuilder.toString();
    }

    public static Bundle urlToBundle(String string2) {
        Object object = "://";
        int n10 = string2.indexOf((String)object);
        String string3 = "http://";
        if (n10 >= 0) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string3);
            string2 = string2.substring(++n10);
            stringBuilder.append(string2);
            string2 = stringBuilder.toString();
        } else {
            object = new StringBuilder();
            ((StringBuilder)object).append(string3);
            ((StringBuilder)object).append(string2);
            string2 = ((StringBuilder)object).toString();
        }
        try {
            object = new URL(string2);
            string2 = ((URL)object).getQuery();
        }
        catch (Throwable throwable) {
            MobLog.getInstance().w(throwable);
            Bundle bundle = new Bundle();
            return bundle;
        }
        string2 = ResHelper.decodeUrl(string2);
        object = ((URL)object).getRef();
        object = ResHelper.decodeUrl((String)object);
        string2.putAll((Bundle)object);
        return string2;
    }

    public static Uri videoPathToContentUri(Context object, String object2) {
        block24: {
            Object object3;
            Object object4;
            block25: {
                object4 = "_id";
                object3 = DeviceHelper.getInstance((Context)object);
                String string2 = "android.permission.READ_EXTERNAL_STORAGE";
                boolean n10 = ((DeviceHelper)object3).checkPermission(string2);
                if (!n10) break block24;
                string2 = object.getContentResolver();
                Uri uri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                String[] stringArray = new String[]{object4};
                String string3 = "_data=? ";
                int n11 = 1;
                String[] stringArray2 = new String[n11];
                boolean bl2 = false;
                object3 = null;
                stringArray2[0] = object2;
                object3 = string2.query(uri, stringArray, string3, stringArray2, null);
                if (object3 == null) break block25;
                boolean bl3 = object3.moveToFirst();
                if (!bl3) break block25;
                int n12 = object3.getColumnIndex((String)object4);
                n12 = object3.getInt(n12);
                object2 = "content://media/external/video/media";
                object2 = Uri.parse((String)object2);
                object4 = new StringBuilder();
                object3 = "";
                ((StringBuilder)object4).append((String)object3);
                ((StringBuilder)object4).append(n12);
                object = ((StringBuilder)object4).toString();
                return Uri.withAppendedPath((Uri)object2, (String)object);
            }
            object4 = new File((String)object2);
            boolean bl4 = ((File)object4).exists();
            if (!bl4) break block24;
            object4 = new ContentValues();
            object3 = "_data";
            object4.put((String)object3, (String)object2);
            object2 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
            object = object.getContentResolver();
            try {
                return object.insert((Uri)object2, (ContentValues)object4);
            }
            catch (Throwable throwable) {
                object2 = MobLog.getInstance();
                ((NLog)object2).w(throwable);
            }
        }
        return null;
    }
}

