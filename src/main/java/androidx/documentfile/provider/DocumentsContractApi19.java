/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.database.Cursor
 *  android.net.Uri
 *  android.provider.DocumentsContract
 *  android.text.TextUtils
 *  android.util.Log
 */
package androidx.documentfile.provider;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.DocumentsContract;
import android.text.TextUtils;
import android.util.Log;

public class DocumentsContractApi19 {
    private static final int FLAG_VIRTUAL_DOCUMENT = 512;
    private static final String TAG = "DocumentFile";

    private DocumentsContractApi19() {
    }

    public static boolean canRead(Context object, Uri uri) {
        boolean bl2 = true;
        int n10 = object.checkCallingOrSelfUriPermission(uri, (int)(bl2 ? 1 : 0));
        if (n10 != 0) {
            return false;
        }
        boolean bl3 = TextUtils.isEmpty((CharSequence)(object = DocumentsContractApi19.getRawType(object, uri)));
        if (bl3) {
            return false;
        }
        return bl2;
    }

    public static boolean canWrite(Context context, Uri object) {
        int n10 = 2;
        int n11 = context.checkCallingOrSelfUriPermission((Uri)object, n10);
        if (n11 != 0) {
            return false;
        }
        String string2 = DocumentsContractApi19.getRawType(context, (Uri)object);
        String string3 = "flags";
        int n12 = DocumentsContractApi19.queryForInt(context, (Uri)object, string3, 0);
        int n13 = TextUtils.isEmpty((CharSequence)string2);
        if (n13 != 0) {
            return false;
        }
        n13 = n12 & 4;
        boolean bl2 = true;
        if (n13 != 0) {
            return bl2;
        }
        object = "vnd.android.document/directory";
        n13 = (int)(((String)object).equals(string2) ? 1 : 0);
        if (n13 != 0 && (n13 = n12 & 8) != 0) {
            return bl2;
        }
        n13 = (int)(TextUtils.isEmpty((CharSequence)string2) ? 1 : 0);
        if (n13 == 0 && (n12 &= n10) != 0) {
            return bl2;
        }
        return false;
    }

    private static void closeQuietly(AutoCloseable autoCloseable) {
        if (autoCloseable != null) {
            try {
                autoCloseable.close();
            }
            catch (RuntimeException runtimeException) {
                throw runtimeException;
            }
            catch (Exception exception) {}
        }
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static boolean exists(Context context, Uri uri) {
        Throwable throwable2222222;
        Cursor cursor;
        block5: {
            Object object = context.getContentResolver();
            boolean bl2 = false;
            context = null;
            cursor = null;
            CharSequence charSequence = "document_id";
            String[] stringArray = new String[]{charSequence};
            charSequence = uri;
            cursor = object.query(uri, stringArray, null, null, null);
            int n10 = cursor.getCount();
            if (n10 > 0) {
                bl2 = true;
            }
            {
                catch (Throwable throwable2222222) {
                    break block5;
                }
                catch (Exception exception) {}
                object = TAG;
                {
                    charSequence = new StringBuilder();
                    String string2 = "Failed query: ";
                    ((StringBuilder)charSequence).append(string2);
                    ((StringBuilder)charSequence).append(exception);
                    String string3 = ((StringBuilder)charSequence).toString();
                    Log.w((String)object, (String)string3);
                }
                DocumentsContractApi19.closeQuietly((AutoCloseable)cursor);
                return false;
            }
            DocumentsContractApi19.closeQuietly((AutoCloseable)cursor);
            return bl2;
        }
        DocumentsContractApi19.closeQuietly(cursor);
        throw throwable2222222;
    }

    public static long getFlags(Context context, Uri uri) {
        return DocumentsContractApi19.queryForLong(context, uri, "flags", 0L);
    }

    public static String getName(Context context, Uri uri) {
        return DocumentsContractApi19.queryForString(context, uri, "_display_name", null);
    }

    private static String getRawType(Context context, Uri uri) {
        return DocumentsContractApi19.queryForString(context, uri, "mime_type", null);
    }

    public static String getType(Context object, Uri object2) {
        object2 = "vnd.android.document/directory";
        boolean bl2 = ((String)object2).equals(object = DocumentsContractApi19.getRawType(object, (Uri)object2));
        if (bl2) {
            object = null;
        }
        return object;
    }

    public static boolean isDirectory(Context object, Uri uri) {
        object = DocumentsContractApi19.getRawType(object, uri);
        return "vnd.android.document/directory".equals(object);
    }

    public static boolean isFile(Context object, Uri object2) {
        boolean bl2;
        object2 = "vnd.android.document/directory";
        boolean bl3 = ((String)object2).equals(object = DocumentsContractApi19.getRawType(object, (Uri)object2));
        return !bl3 && !(bl2 = TextUtils.isEmpty((CharSequence)object));
        {
        }
    }

    public static boolean isVirtual(Context context, Uri uri) {
        long l10;
        boolean bl2 = DocumentsContract.isDocumentUri((Context)context, (Uri)uri);
        boolean bl3 = false;
        if (!bl2) {
            return false;
        }
        long l11 = DocumentsContractApi19.getFlags(context, uri) & 0x200L;
        long l12 = l11 - (l10 = 0L);
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object != false) {
            bl3 = true;
        }
        return bl3;
    }

    public static long lastModified(Context context, Uri uri) {
        return DocumentsContractApi19.queryForLong(context, uri, "last_modified", 0L);
    }

    public static long length(Context context, Uri uri) {
        return DocumentsContractApi19.queryForLong(context, uri, "_size", 0L);
    }

    private static int queryForInt(Context context, Uri uri, String string2, int n10) {
        long l10 = n10;
        return (int)DocumentsContractApi19.queryForLong(context, uri, string2, l10);
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static long queryForLong(Context context, Uri object, String charSequence, long l10) {
        Throwable throwable2222222;
        Cursor cursor;
        block5: {
            block4: {
                Object object2 = context.getContentResolver();
                int n10 = 1;
                cursor = null;
                String[] stringArray = new String[n10];
                n10 = 0;
                context = null;
                stringArray[0] = charSequence;
                cursor = object2.query(object, stringArray, null, null, null);
                boolean bl2 = cursor.moveToFirst();
                if (!bl2 || (bl2 = cursor.isNull(0))) break block4;
                long l11 = cursor.getLong(0);
                {
                    catch (Throwable throwable2222222) {
                        break block5;
                    }
                    catch (Exception exception) {}
                    object = TAG;
                    {
                        charSequence = new StringBuilder();
                        object2 = "Failed query: ";
                        ((StringBuilder)charSequence).append((String)object2);
                        ((StringBuilder)charSequence).append(exception);
                        String string2 = ((StringBuilder)charSequence).toString();
                        Log.w((String)object, (String)string2);
                    }
                    DocumentsContractApi19.closeQuietly((AutoCloseable)cursor);
                    return l10;
                }
                DocumentsContractApi19.closeQuietly((AutoCloseable)cursor);
                return l11;
            }
            DocumentsContractApi19.closeQuietly((AutoCloseable)cursor);
            return l10;
        }
        DocumentsContractApi19.closeQuietly(cursor);
        throw throwable2222222;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static String queryForString(Context object, Uri object2, String charSequence, String string2) {
        Throwable throwable2222222;
        Cursor cursor;
        block5: {
            block4: {
                Object object3 = object.getContentResolver();
                int n10 = 1;
                cursor = null;
                String[] stringArray = new String[n10];
                n10 = 0;
                object = null;
                stringArray[0] = charSequence;
                cursor = object3.query(object2, stringArray, null, null, null);
                boolean bl2 = cursor.moveToFirst();
                if (!bl2 || (bl2 = cursor.isNull(0))) break block4;
                object = cursor.getString(0);
                {
                    catch (Throwable throwable2222222) {
                        break block5;
                    }
                    catch (Exception exception) {}
                    object2 = TAG;
                    {
                        charSequence = new StringBuilder();
                        object3 = "Failed query: ";
                        ((StringBuilder)charSequence).append((String)object3);
                        ((StringBuilder)charSequence).append(exception);
                        String string3 = ((StringBuilder)charSequence).toString();
                        Log.w((String)object2, (String)string3);
                    }
                    DocumentsContractApi19.closeQuietly((AutoCloseable)cursor);
                    return string2;
                }
                DocumentsContractApi19.closeQuietly((AutoCloseable)cursor);
                return object;
            }
            DocumentsContractApi19.closeQuietly((AutoCloseable)cursor);
            return string2;
        }
        DocumentsContractApi19.closeQuietly(cursor);
        throw throwable2222222;
    }
}

