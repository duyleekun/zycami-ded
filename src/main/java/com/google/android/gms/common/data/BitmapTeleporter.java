/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$Config
 *  android.os.Parcel
 *  android.os.ParcelFileDescriptor
 *  android.os.ParcelFileDescriptor$AutoCloseInputStream
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  android.util.Log
 */
package com.google.android.gms.common.data;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import android.util.Log;
import com.google.android.gms.common.data.zaa;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.util.Objects;

public class BitmapTeleporter
extends AbstractSafeParcelable
implements ReflectedParcelable {
    public static final Parcelable.Creator CREATOR;
    private final int mType;
    private final int zalf;
    private ParcelFileDescriptor zalg;
    private Bitmap zalh;
    private boolean zali;
    private File zalj;

    static {
        zaa zaa2 = new zaa();
        CREATOR = zaa2;
    }

    public BitmapTeleporter(int n10, ParcelFileDescriptor parcelFileDescriptor, int n11) {
        this.zalf = n10;
        this.zalg = parcelFileDescriptor;
        this.mType = n11;
        this.zalh = null;
        this.zali = false;
    }

    public BitmapTeleporter(Bitmap bitmap) {
        int n10;
        this.zalf = n10 = 1;
        this.zalg = null;
        this.mType = 0;
        this.zalh = bitmap;
        this.zali = n10;
    }

    private static void zaa(Closeable closeable) {
        try {
            closeable.close();
            return;
        }
        catch (IOException iOException) {
            Log.w((String)"BitmapTeleporter", (String)"Could not close stream", (Throwable)iOException);
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private final FileOutputStream zabz() {
        Serializable serializable = this.zalj;
        if (serializable == null) {
            serializable = new IllegalStateException("setTempDir() must be called before writing this object to a parcel");
            throw serializable;
        }
        Object object = "teleporter";
        String string2 = ".tmp";
        try {
            serializable = File.createTempFile((String)object, string2, (File)serializable);
        }
        catch (IOException iOException) {
            object = new IllegalStateException("Could not create temporary file", iOException);
            throw object;
        }
        try {
            object = new FileOutputStream((File)serializable);
            int n10 = 0x10000000;
            string2 = ParcelFileDescriptor.open((File)serializable, (int)n10);
            this.zalg = string2;
            ((File)serializable).delete();
            return object;
        }
        catch (FileNotFoundException fileNotFoundException) {
            serializable = new IllegalStateException("Temporary file is somehow already deleted");
            throw serializable;
        }
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public Bitmap get() {
        Throwable throwable2222222;
        Object object;
        block4: {
            boolean bl2 = this.zali;
            if (bl2) return this.zalh;
            Object object2 = this.zalg;
            Object object3 = new ParcelFileDescriptor.AutoCloseInputStream(object2);
            object = new DataInputStream((InputStream)object3);
            int n10 = ((DataInputStream)object).readInt();
            object3 = new byte[n10];
            int n11 = ((DataInputStream)object).readInt();
            int n12 = ((DataInputStream)object).readInt();
            String string2 = ((DataInputStream)object).readUTF();
            string2 = Bitmap.Config.valueOf((String)string2);
            ((DataInputStream)object).read((byte[])object3);
            {
                catch (Throwable throwable2222222) {
                    break block4;
                }
                catch (IOException iOException) {}
                {
                    String string3 = "Could not read from parcel file descriptor";
                    object2 = new IllegalStateException(string3, iOException);
                    throw object2;
                }
            }
            BitmapTeleporter.zaa((Closeable)object);
            object = ByteBuffer.wrap((byte[])object3);
            object3 = Bitmap.createBitmap((int)n11, (int)n12, (Bitmap.Config)string2);
            object3.copyPixelsFromBuffer((Buffer)object);
            this.zalh = object3;
            this.zali = bl2 = true;
            return this.zalh;
        }
        BitmapTeleporter.zaa((Closeable)object);
        throw throwable2222222;
    }

    public void release() {
        boolean bl2 = this.zali;
        if (!bl2) {
            ParcelFileDescriptor parcelFileDescriptor = this.zalg;
            try {
                parcelFileDescriptor.close();
                return;
            }
            catch (IOException iOException) {
                String string2 = "BitmapTeleporter";
                String string3 = "Could not close PFD";
                Log.w((String)string2, (String)string3, (Throwable)iOException);
            }
        }
    }

    public void setTempDir(File file) {
        Objects.requireNonNull(file, "Cannot set null temp directory");
        this.zalj = file;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void writeToParcel(Parcel parcel, int n10) {
        Object object;
        int n11;
        int n12;
        block6: {
            Object object2 = this.zalg;
            if (object2 == null) {
                Throwable throwable2222222;
                OutputStream outputStream;
                block5: {
                    object2 = this.zalh;
                    n12 = object2.getRowBytes();
                    n11 = object2.getHeight();
                    Object object3 = ByteBuffer.allocate(n12 *= n11);
                    object2.copyPixelsToBuffer((Buffer)object3);
                    object3 = ((ByteBuffer)object3).array();
                    outputStream = this.zabz();
                    object = new BufferedOutputStream(outputStream);
                    outputStream = new DataOutputStream((OutputStream)object);
                    n11 = ((Object)object3).length;
                    ((DataOutputStream)outputStream).writeInt(n11);
                    n11 = object2.getWidth();
                    ((DataOutputStream)outputStream).writeInt(n11);
                    n11 = object2.getHeight();
                    ((DataOutputStream)outputStream).writeInt(n11);
                    object2 = object2.getConfig();
                    object2 = object2.toString();
                    ((DataOutputStream)outputStream).writeUTF((String)object2);
                    ((FilterOutputStream)outputStream).write((byte[])object3);
                    {
                        catch (Throwable throwable2222222) {
                            break block5;
                        }
                        catch (IOException iOException) {}
                        {
                            object2 = "Could not write into unlinked file";
                            IllegalStateException illegalStateException = new IllegalStateException((String)object2, iOException);
                            throw illegalStateException;
                        }
                    }
                    BitmapTeleporter.zaa(outputStream);
                    break block6;
                }
                BitmapTeleporter.zaa(outputStream);
                throw throwable2222222;
            }
        }
        int n13 = 1;
        n12 = SafeParcelWriter.beginObjectHeader(parcel);
        n11 = this.zalf;
        SafeParcelWriter.writeInt(parcel, n13, n11);
        object = this.zalg;
        SafeParcelWriter.writeParcelable(parcel, 2, (Parcelable)object, n10 |= n13, false);
        n13 = this.mType;
        SafeParcelWriter.writeInt(parcel, 3, n13);
        SafeParcelWriter.finishObjectHeader(parcel, n12);
        this.zalg = null;
    }
}

