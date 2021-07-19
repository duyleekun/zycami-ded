/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ContentProvider
 *  android.content.ContentValues
 *  android.content.Context
 *  android.content.pm.PackageManager
 *  android.content.pm.ProviderInfo
 *  android.database.Cursor
 *  android.database.MatrixCursor
 *  android.net.Uri
 *  android.os.Build$VERSION
 *  android.os.Environment
 *  android.os.ParcelFileDescriptor
 *  android.webkit.MimeTypeMap
 *  org.xmlpull.v1.XmlPullParserException
 */
package androidx.core.content;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.webkit.MimeTypeMap;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider$PathStrategy;
import androidx.core.content.FileProvider$SimplePathStrategy;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParserException;

public class FileProvider
extends ContentProvider {
    private static final String ATTR_NAME = "name";
    private static final String ATTR_PATH = "path";
    private static final String[] COLUMNS;
    private static final File DEVICE_ROOT;
    private static final String DISPLAYNAME_FIELD = "displayName";
    private static final String META_DATA_FILE_PROVIDER_PATHS = "android.support.FILE_PROVIDER_PATHS";
    private static final String TAG_CACHE_PATH = "cache-path";
    private static final String TAG_EXTERNAL = "external-path";
    private static final String TAG_EXTERNAL_CACHE = "external-cache-path";
    private static final String TAG_EXTERNAL_FILES = "external-files-path";
    private static final String TAG_EXTERNAL_MEDIA = "external-media-path";
    private static final String TAG_FILES_PATH = "files-path";
    private static final String TAG_ROOT_PATH = "root-path";
    private static HashMap sCache;
    private FileProvider$PathStrategy mStrategy;

    static {
        Serializable serializable;
        COLUMNS = new String[]{"_display_name", "_size"};
        DEVICE_ROOT = serializable = new File("/");
        serializable = new HashMap();
        sCache = serializable;
    }

    private static File buildPath(File file, String ... stringArray) {
        for (String string2 : stringArray) {
            File file2;
            if (string2 == null) continue;
            file = file2 = new File(file, string2);
        }
        return file;
    }

    private static Object[] copyOf(Object[] objectArray, int n10) {
        Object[] objectArray2 = new Object[n10];
        System.arraycopy(objectArray, 0, objectArray2, 0, n10);
        return objectArray2;
    }

    private static String[] copyOf(String[] stringArray, int n10) {
        String[] stringArray2 = new String[n10];
        System.arraycopy(stringArray, 0, stringArray2, 0, n10);
        return stringArray2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static FileProvider$PathStrategy getPathStrategy(Context object, String object2) {
        HashMap hashMap = sCache;
        synchronized (hashMap) {
            Object object3 = sCache;
            object3 = ((HashMap)object3).get(object2);
            object3 = (FileProvider$PathStrategy)object3;
            if (object3 == null) {
                try {
                    object3 = FileProvider.parsePathStrategy((Context)object, (String)object2);
                    object = sCache;
                    ((HashMap)object).put(object2, object3);
                }
                catch (XmlPullParserException xmlPullParserException) {
                    object3 = "Failed to parse android.support.FILE_PROVIDER_PATHS meta-data";
                    object2 = new IllegalArgumentException((String)object3, xmlPullParserException);
                    throw object2;
                }
                catch (IOException iOException) {
                    object3 = "Failed to parse android.support.FILE_PROVIDER_PATHS meta-data";
                    object2 = new IllegalArgumentException((String)object3, iOException);
                    throw object2;
                }
            }
            return object3;
        }
    }

    public static Uri getUriForFile(Context context, String string2, File file) {
        return FileProvider.getPathStrategy(context, string2).getUriForFile(file);
    }

    public static Uri getUriForFile(Context context, String string2, File file, String string3) {
        return FileProvider.getUriForFile(context, string2, file).buildUpon().appendQueryParameter(DISPLAYNAME_FIELD, string3).build();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static int modeToMode(String string2) {
        Object object = "r";
        boolean bl2 = ((String)object).equals(string2);
        if (bl2) {
            return 0x10000000;
        }
        object = "w";
        bl2 = ((String)object).equals(string2);
        if (bl2) return 0x2C000000;
        object = "wt";
        bl2 = ((String)object).equals(string2);
        if (bl2) return 0x2C000000;
        object = "wa";
        bl2 = ((String)object).equals(string2);
        if (bl2) {
            return 0x2A000000;
        }
        object = "rw";
        bl2 = ((String)object).equals(string2);
        if (bl2) {
            return 0x38000000;
        }
        object = "rwt";
        bl2 = ((String)object).equals(string2);
        if (bl2) {
            return 0x3C000000;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Invalid mode: ");
        stringBuilder.append(string2);
        string2 = stringBuilder.toString();
        object = new IllegalArgumentException(string2);
        throw object;
    }

    private static FileProvider$PathStrategy parsePathStrategy(Context object, String string2) {
        Object object2 = new FileProvider$SimplePathStrategy(string2);
        Object object3 = object.getPackageManager();
        int n10 = 128;
        if ((object3 = object3.resolveContentProvider(string2, n10)) != null) {
            string2 = object.getPackageManager();
            String string3 = META_DATA_FILE_PROVIDER_PATHS;
            if ((string2 = object3.loadXmlMetaData((PackageManager)string2, string3)) != null) {
                int n11;
                while ((n11 = string2.next()) != (n10 = 1)) {
                    int n12 = 2;
                    if (n11 != n12) continue;
                    object3 = string2.getName();
                    n12 = 0;
                    Object object4 = null;
                    String string4 = string2.getAttributeValue(null, ATTR_NAME);
                    String string5 = string2.getAttributeValue(null, ATTR_PATH);
                    String string6 = TAG_ROOT_PATH;
                    int n13 = string6.equals(object3);
                    if (n13 != 0) {
                        object4 = DEVICE_ROOT;
                    } else {
                        string6 = TAG_FILES_PATH;
                        n13 = string6.equals(object3);
                        if (n13 != 0) {
                            object4 = object.getFilesDir();
                        } else {
                            string6 = TAG_CACHE_PATH;
                            n13 = string6.equals(object3);
                            if (n13 != 0) {
                                object4 = object.getCacheDir();
                            } else {
                                string6 = TAG_EXTERNAL;
                                n13 = string6.equals(object3);
                                if (n13 != 0) {
                                    object4 = Environment.getExternalStorageDirectory();
                                } else {
                                    string6 = TAG_EXTERNAL_FILES;
                                    n13 = string6.equals(object3);
                                    if (n13 != 0) {
                                        object3 = ContextCompat.getExternalFilesDirs(object, null);
                                        n13 = ((String[])object3).length;
                                        if (n13 > 0) {
                                            object4 = object3[0];
                                        }
                                    } else {
                                        string6 = TAG_EXTERNAL_CACHE;
                                        n13 = string6.equals(object3);
                                        if (n13 != 0) {
                                            object3 = ContextCompat.getExternalCacheDirs(object);
                                            n13 = ((String[])object3).length;
                                            if (n13 > 0) {
                                                object4 = object3[0];
                                            }
                                        } else {
                                            n13 = Build.VERSION.SDK_INT;
                                            int n14 = 21;
                                            if (n13 >= n14 && (n11 = (int)((string6 = TAG_EXTERNAL_MEDIA).equals(object3) ? 1 : 0)) != 0 && (n13 = ((String[])(object3 = object.getExternalMediaDirs())).length) > 0) {
                                                object4 = object3[0];
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    if (object4 == null) continue;
                    object3 = new String[n10];
                    object3[0] = string5;
                    object3 = FileProvider.buildPath((File)object4, object3);
                    ((FileProvider$SimplePathStrategy)object2).addRoot(string4, (File)object3);
                }
                return object2;
            }
            object = new IllegalArgumentException("Missing android.support.FILE_PROVIDER_PATHS meta-data");
            throw object;
        }
        object2 = new StringBuilder();
        ((StringBuilder)object2).append("Couldn't find meta-data for provider with authority ");
        ((StringBuilder)object2).append(string2);
        string2 = ((StringBuilder)object2).toString();
        object = new IllegalArgumentException(string2);
        throw object;
    }

    public void attachInfo(Context object, ProviderInfo object2) {
        super.attachInfo(object, object2);
        boolean bl2 = object2.exported;
        if (!bl2) {
            bl2 = object2.grantUriPermissions;
            if (bl2) {
                object2 = object2.authority.split(";")[0];
                object = FileProvider.getPathStrategy(object, (String)object2);
                this.mStrategy = object;
                return;
            }
            object = new SecurityException("Provider must grant uri permissions");
            throw object;
        }
        object = new SecurityException("Provider must not be exported");
        throw object;
    }

    public int delete(Uri uri, String string2, String[] stringArray) {
        return (int)(this.mStrategy.getFileForUri(uri).delete() ? 1 : 0);
    }

    public String getType(Uri object) {
        int n10;
        String string2 = ((File)(object = this.mStrategy.getFileForUri((Uri)object))).getName();
        int n11 = string2.lastIndexOf(n10 = 46);
        if (n11 >= 0) {
            object = ((File)object).getName();
            object = ((String)object).substring(++n11);
            string2 = MimeTypeMap.getSingleton();
            object = string2.getMimeTypeFromExtension((String)object);
            if (object != null) {
                return object;
            }
        }
        return "application/octet-stream";
    }

    public Uri insert(Uri object, ContentValues contentValues) {
        object = new UnsupportedOperationException("No external inserts");
        throw object;
    }

    public boolean onCreate() {
        return true;
    }

    public ParcelFileDescriptor openFile(Uri object, String string2) {
        object = this.mStrategy.getFileForUri((Uri)object);
        int n10 = FileProvider.modeToMode(string2);
        return ParcelFileDescriptor.open((File)object, (int)n10);
    }

    public Cursor query(Uri stringArray, String[] objectArray, String object, String[] stringArray2, String objectArray2) {
        object = this.mStrategy.getFileForUri((Uri)stringArray);
        stringArray2 = DISPLAYNAME_FIELD;
        stringArray = stringArray.getQueryParameter((String)stringArray2);
        if (objectArray == null) {
            objectArray = COLUMNS;
        }
        int n10 = objectArray.length;
        stringArray2 = new String[n10];
        int n11 = objectArray.length;
        objectArray2 = new Object[n11];
        int n12 = objectArray.length;
        int n13 = 0;
        for (int i10 = 0; i10 < n12; ++i10) {
            int n14;
            Object object2 = "_display_name";
            String string2 = objectArray[i10];
            boolean bl2 = object2.equals(string2);
            if (bl2) {
                stringArray2[n13] = object2;
                n14 = n13 + 1;
                object2 = stringArray == null ? ((File)object).getName() : stringArray;
                objectArray2[n13] = object2;
            } else {
                object2 = "_size";
                n14 = object2.equals(string2);
                if (n14 == 0) continue;
                stringArray2[n13] = object2;
                n14 = n13 + 1;
                long l10 = ((File)object).length();
                objectArray2[n13] = object2 = Long.valueOf(l10);
            }
            n13 = n14;
        }
        stringArray = FileProvider.copyOf(stringArray2, n13);
        objectArray = FileProvider.copyOf(objectArray2, n13);
        object = new MatrixCursor(stringArray, 1);
        object.addRow(objectArray);
        return object;
    }

    public int update(Uri object, ContentValues contentValues, String string2, String[] stringArray) {
        object = new UnsupportedOperationException("No external updates");
        throw object;
    }
}

