/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ContentResolver
 *  android.content.ContentValues
 *  android.location.Location
 *  android.net.Uri
 *  android.os.Build$VERSION
 */
package androidx.camera.core;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.location.Location;
import android.net.Uri;
import android.os.Build;
import androidx.camera.core.ImageCapture$Metadata;
import androidx.camera.core.ImageCapture$OutputFileOptions;
import androidx.camera.core.ImageCapture$OutputFileResults;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.ImageSaver$1;
import androidx.camera.core.ImageSaver$OnImageSavedCallback;
import androidx.camera.core.ImageSaver$SaveError;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.utils.Exif;
import androidx.camera.core.internal.compat.workaround.ExifRotationAvailability;
import androidx.camera.core.internal.utils.ImageUtil;
import androidx.camera.core.internal.utils.ImageUtil$CodecFailedException;
import androidx.core.util.Preconditions;
import b.a.b.o0;
import b.a.b.p0;
import b.a.b.q0;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.util.UUID;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

public final class ImageSaver
implements Runnable {
    private static final int COPY_BUFFER_SIZE = 1024;
    private static final int NOT_PENDING = 0;
    private static final int PENDING = 1;
    private static final String TAG = "ImageSaver";
    private static final String TEMP_FILE_PREFIX = "CameraX";
    private static final String TEMP_FILE_SUFFIX = ".tmp";
    private final ImageSaver$OnImageSavedCallback mCallback;
    private final ImageProxy mImage;
    private final int mOrientation;
    private final ImageCapture$OutputFileOptions mOutputFileOptions;
    private final Executor mSequentialIoExecutor;
    private final Executor mUserCallbackExecutor;

    public ImageSaver(ImageProxy imageProxy, ImageCapture$OutputFileOptions imageCapture$OutputFileOptions, int n10, Executor executor, Executor executor2, ImageSaver$OnImageSavedCallback imageSaver$OnImageSavedCallback) {
        this.mImage = imageProxy;
        this.mOutputFileOptions = imageCapture$OutputFileOptions;
        this.mOrientation = n10;
        this.mCallback = imageSaver$OnImageSavedCallback;
        this.mUserCallbackExecutor = executor;
        this.mSequentialIoExecutor = executor2;
    }

    private /* synthetic */ void a(ImageSaver$SaveError imageSaver$SaveError, String string2, Throwable throwable) {
        this.mCallback.onError(imageSaver$SaveError, string2, throwable);
    }

    private /* synthetic */ void c(Uri uri) {
        ImageSaver$OnImageSavedCallback imageSaver$OnImageSavedCallback = this.mCallback;
        ImageCapture$OutputFileResults imageCapture$OutputFileResults = new ImageCapture$OutputFileResults(uri);
        imageSaver$OnImageSavedCallback.onImageSaved(imageCapture$OutputFileResults);
    }

    private void copyTempFileToOutputStream(File object, OutputStream outputStream) {
        FileInputStream fileInputStream = new FileInputStream((File)object);
        int n10 = 1024;
        try {
            object = new byte[n10];
        }
        catch (Throwable throwable) {
            try {
                ((InputStream)fileInputStream).close();
            }
            catch (Throwable throwable2) {
                throwable.addSuppressed(throwable2);
            }
            throw throwable;
        }
        while (true) {
            int n11 = ((InputStream)fileInputStream).read((byte[])object);
            if (n11 <= 0) break;
            outputStream.write((byte[])object, 0, n11);
            continue;
            break;
        }
        ((InputStream)fileInputStream).close();
        return;
    }

    private boolean copyTempFileToUri(File file, Uri object) {
        ContentResolver contentResolver = this.mOutputFileOptions.getContentResolver();
        object = contentResolver.openOutputStream((Uri)object);
        if (object == null) {
            file = null;
            if (object != null) {
                ((OutputStream)object).close();
            }
            return false;
        }
        try {
            this.copyTempFileToOutputStream(file, (OutputStream)object);
            return true;
        }
        finally {
            if (object != null) {
                ((OutputStream)object).close();
            }
        }
    }

    private /* synthetic */ void e(File file) {
        this.copyTempFileToDestination(file);
    }

    private boolean isSaveToFile() {
        boolean bl2;
        File file = this.mOutputFileOptions.getFile();
        if (file != null) {
            bl2 = true;
        } else {
            bl2 = false;
            file = null;
        }
        return bl2;
    }

    private boolean isSaveToMediaStore() {
        boolean bl2;
        Uri uri = this.mOutputFileOptions.getSaveCollection();
        if (uri != null && (uri = this.mOutputFileOptions.getContentResolver()) != null && (uri = this.mOutputFileOptions.getContentValues()) != null) {
            bl2 = true;
        } else {
            bl2 = false;
            uri = null;
        }
        return bl2;
    }

    private boolean isSaveToOutputStream() {
        boolean bl2;
        OutputStream outputStream = this.mOutputFileOptions.getOutputStream();
        if (outputStream != null) {
            bl2 = true;
        } else {
            bl2 = false;
            outputStream = null;
        }
        return bl2;
    }

    private void postError(ImageSaver$SaveError object, String string2, Throwable throwable) {
        Executor executor = this.mUserCallbackExecutor;
        q0 q02 = new q0(this, (ImageSaver$SaveError)((Object)object), string2, throwable);
        try {
            executor.execute(q02);
        }
        catch (RejectedExecutionException rejectedExecutionException) {
            object = TAG;
            string2 = "Application executor rejected executing OnImageSavedCallback.onError callback. Skipping.";
            Logger.e((String)object, string2);
        }
    }

    private void postSuccess(Uri object) {
        Object object2 = this.mUserCallbackExecutor;
        o0 o02 = new o0(this, (Uri)object);
        try {
            object2.execute(o02);
        }
        catch (RejectedExecutionException rejectedExecutionException) {
            object = TAG;
            object2 = "Application executor rejected executing OnImageSavedCallback.onImageSaved callback. Skipping.";
            Logger.e((String)object, (String)object2);
        }
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private File saveImageToTempFile() {
        File file;
        Object object;
        Object object2;
        Object object3;
        block29: {
            block28: {
                int n10;
                Object object4;
                block27: {
                    try {
                        boolean bl2 = this.isSaveToFile();
                        object3 = TEMP_FILE_SUFFIX;
                        object2 = TEMP_FILE_PREFIX;
                        if (bl2) {
                            object = this.mOutputFileOptions;
                            object = ((ImageCapture$OutputFileOptions)object).getFile();
                            object = ((File)object).getParent();
                            object4 = new StringBuilder();
                            ((StringBuilder)object4).append((String)object2);
                            object2 = UUID.randomUUID();
                            object2 = ((UUID)object2).toString();
                            ((StringBuilder)object4).append((String)object2);
                            ((StringBuilder)object4).append((String)object3);
                            object3 = ((StringBuilder)object4).toString();
                            file = new File((String)object, (String)object3);
                            break block27;
                        }
                        file = File.createTempFile((String)object2, (String)object3);
                    }
                    catch (IOException iOException) {
                        ImageSaver$SaveError imageSaver$SaveError = ImageSaver$SaveError.FILE_IO_FAILED;
                        this.postError(imageSaver$SaveError, "Failed to create temp file", iOException);
                        return null;
                    }
                }
                object3 = this.mImage;
                object2 = new FileOutputStream(file);
                object = this.mImage;
                object = ImageUtil.imageToJpegByteArray((ImageProxy)object);
                ((FileOutputStream)object2).write((byte[])object);
                object = Exif.createFromFile(file);
                ((Exif)object).attachTimestamp();
                object4 = new ExifRotationAvailability();
                Object object5 = this.mImage;
                int n11 = ((ExifRotationAvailability)object4).shouldUseExifOrientation((ImageProxy)object5);
                if (n11 != 0) {
                    object4 = this.mImage;
                    object4 = object4.getPlanes();
                    n10 = 0;
                    object5 = null;
                    object4 = object4[0];
                    object4 = object4.getBuffer();
                    ((ByteBuffer)object4).rewind();
                    n10 = ((Buffer)object4).capacity();
                    object5 = new byte[n10];
                    ((ByteBuffer)object4).get((byte[])object5);
                    object4 = new ByteArrayInputStream((byte[])object5);
                    object4 = Exif.createFromInputStream((InputStream)object4);
                    n11 = ((Exif)object4).getOrientation();
                    ((Exif)object).setOrientation(n11);
                } else {
                    n11 = this.mOrientation;
                    ((Exif)object).rotate(n11);
                }
                object4 = this.mOutputFileOptions;
                object4 = ((ImageCapture$OutputFileOptions)object4).getMetadata();
                n10 = ((ImageCapture$Metadata)object4).isReversedHorizontal();
                if (n10 != 0) {
                    ((Exif)object).flipHorizontally();
                }
                if ((n10 = ((ImageCapture$Metadata)object4).isReversedVertical()) != 0) {
                    ((Exif)object).flipVertically();
                }
                if ((object4 = ((ImageCapture$Metadata)object4).getLocation()) != null) {
                    object4 = this.mOutputFileOptions;
                    object4 = ((ImageCapture$OutputFileOptions)object4).getMetadata();
                    object4 = ((ImageCapture$Metadata)object4).getLocation();
                    ((Exif)object).attachLocation((Location)object4);
                }
                ((Exif)object).save();
                ((FileOutputStream)object2).close();
                if (object3 == null) break block28;
                object3.close();
            }
            object3 = null;
            boolean bl3 = false;
            object2 = null;
            boolean bl4 = false;
            object = null;
            break block29;
            catch (Throwable throwable) {
                try {
                    ((FileOutputStream)object2).close();
                    throw throwable;
                }
                catch (Throwable throwable2) {
                    try {
                        throwable.addSuppressed(throwable2);
                        throw throwable;
                    }
                    catch (Throwable throwable3) {
                        if (object3 == null) throw throwable3;
                        try {
                            object3.close();
                            throw throwable3;
                        }
                        catch (Throwable throwable4) {
                            try {
                                throwable3.addSuppressed(throwable4);
                                throw throwable3;
                            }
                            catch (ImageUtil$CodecFailedException imageUtil$CodecFailedException) {
                                object2 = ImageSaver$1.$SwitchMap$androidx$camera$core$internal$utils$ImageUtil$CodecFailedException$FailureType;
                                object = imageUtil$CodecFailedException.getFailureType();
                                int n12 = ((Enum)object).ordinal();
                                Object object6 = object2[n12];
                                n12 = 1;
                                if (object6 != n12) {
                                    n12 = 2;
                                    if (object6 != n12) {
                                        object2 = ImageSaver$SaveError.UNKNOWN;
                                        object = "Failed to transcode mImage";
                                        break block29;
                                    } else {
                                        object2 = ImageSaver$SaveError.CROP_FAILED;
                                        object = "Failed to crop mImage";
                                    }
                                    break block29;
                                }
                                object2 = ImageSaver$SaveError.ENCODE_FAILED;
                                object = "Failed to encode mImage";
                                break block29;
                            }
                            catch (IllegalArgumentException illegalArgumentException) {
                            }
                            catch (IOException iOException) {
                                // empty catch block
                            }
                        }
                    }
                }
            }
            object2 = ImageSaver$SaveError.FILE_IO_FAILED;
            object = "Failed to write temp file";
        }
        if (object2 == null) return file;
        this.postError((ImageSaver$SaveError)((Object)object2), (String)object, (Throwable)object3);
        file.delete();
        return null;
    }

    private void setContentValuePending(ContentValues contentValues, int n10) {
        int n11 = Build.VERSION.SDK_INT;
        int n12 = 29;
        if (n11 >= n12) {
            Integer n13 = n10;
            String string2 = "is_pending";
            contentValues.put(string2, n13);
        }
    }

    private void setUriNotPending(Uri uri) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 29;
        if (n10 >= n11) {
            ContentValues contentValues = new ContentValues();
            n11 = 0;
            this.setContentValuePending(contentValues, 0);
            ContentResolver contentResolver = this.mOutputFileOptions.getContentResolver();
            contentResolver.update(uri, contentValues, null, null);
        }
    }

    public /* synthetic */ void b(ImageSaver$SaveError imageSaver$SaveError, String string2, Throwable throwable) {
        this.a(imageSaver$SaveError, string2, throwable);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive exception aggregation
     */
    public void copyTempFileToDestination(File var1_1) {
        block21: {
            block19: {
                block20: {
                    block22: {
                        block23: {
                            block18: {
                                Preconditions.checkNotNull(var1_1);
                                var2_2 = null;
                                var3_6 = this.isSaveToMediaStore();
                                if (!var3_6) break block18;
                                var4_7 = this.mOutputFileOptions;
                                if ((var4_7 = var4_7.getContentValues()) != null) {
                                    var5_10 /* !! */  = this.mOutputFileOptions;
                                    var5_10 /* !! */  = var5_10 /* !! */ .getContentValues();
                                    var4_7 = new ContentValues((ContentValues)var5_10 /* !! */ );
                                } else {
                                    var4_7 = new ContentValues();
                                }
                                var6_11 = 1;
                                this.setContentValuePending((ContentValues)var4_7, var6_11);
                                var5_10 /* !! */  = this.mOutputFileOptions;
                                var5_10 /* !! */  = var5_10 /* !! */ .getContentResolver();
                                var7_13 = this.mOutputFileOptions;
                                var7_13 = var7_13.getSaveCollection();
                                var4_7 = var5_10 /* !! */ .insert((Uri)var7_13, (ContentValues)var4_7);
                                if (var4_7 != null) ** GOTO lbl27
                                try {
                                    var5_10 /* !! */  = ImageSaver$SaveError.FILE_IO_FAILED;
                                    var7_13 = "Failed to insert URI.";
                                    break block19;
lbl27:
                                    // 1 sources

                                    var6_11 = (int)this.copyTempFileToUri(var1_1, (Uri)var4_7);
                                    if (var6_11 == 0) {
                                        var5_10 /* !! */  = ImageSaver$SaveError.FILE_IO_FAILED;
                                        var7_13 = "Failed to save to URI.";
                                    } else {
                                        var6_11 = 0;
                                        var5_10 /* !! */  = null;
                                        var7_13 = null;
                                    }
                                    this.setUriNotPending((Uri)var4_7);
                                    break block19;
                                }
                                catch (IllegalArgumentException var2_3) {
                                    break block20;
                                }
                                catch (IOException var2_4) {
                                    break block20;
                                }
                            }
                            var3_6 = this.isSaveToOutputStream();
                            if (!var3_6) break block23;
                            var4_7 = this.mOutputFileOptions;
                            var4_7 = var4_7.getOutputStream();
                            this.copyTempFileToOutputStream(var1_1, (OutputStream)var4_7);
                            ** GOTO lbl-1000
                        }
                        var3_6 = this.isSaveToFile();
                        if (!var3_6) ** GOTO lbl-1000
                        var4_7 = this.mOutputFileOptions;
                        var6_12 = (var4_7 = var4_7.getFile()).exists();
                        if (var6_12) {
                            var4_7.delete();
                        }
                        if (!(var3_6 = var1_1.renameTo((File)var4_7))) {
                            var5_10 /* !! */  = ImageSaver$SaveError.FILE_IO_FAILED;
                            var7_13 = "Failed to rename file.";
                            var3_6 = false;
                            var4_7 = null;
                        } else lbl-1000:
                        // 3 sources

                        {
                            var3_6 = false;
                            var4_7 = null;
                            var6_12 = false;
                            var5_10 /* !! */  = null;
                            var7_13 = null;
                        }
                        break block19;
                        catch (Throwable var2_5) {
                            break block21;
                        }
                        catch (IllegalArgumentException var4_8) {
                            break block22;
                        }
                        catch (IOException var4_9) {
                            // empty catch block
                        }
                    }
                    var8_14 = var4_7;
                    var3_6 = false;
                    var4_7 = null;
                    var2_2 = var8_14;
                }
                var5_10 /* !! */  = ImageSaver$SaveError.FILE_IO_FAILED;
                var7_13 = "Failed to write destination file.";
            }
            var1_1.delete();
            if (var5_10 /* !! */  != null) {
                this.postError(var5_10 /* !! */ , (String)var7_13, var2_2);
            } else {
                this.postSuccess((Uri)var4_7);
            }
            return;
        }
        var1_1.delete();
        throw var2_5;
    }

    public /* synthetic */ void d(Uri uri) {
        this.c(uri);
    }

    public /* synthetic */ void f(File file) {
        this.e(file);
    }

    public void run() {
        File file = this.saveImageToTempFile();
        if (file != null) {
            Executor executor = this.mSequentialIoExecutor;
            p0 p02 = new p0(this, file);
            executor.execute(p02);
        }
    }
}

