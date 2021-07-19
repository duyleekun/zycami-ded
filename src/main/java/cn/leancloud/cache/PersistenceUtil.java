/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.cache;

import cn.leancloud.AVLogger;
import cn.leancloud.utils.LogUtil;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class PersistenceUtil {
    private static PersistenceUtil INSTANCE;
    public static final int MAX_FILE_BUF_SIZE = 0x200000;
    private static final AVLogger gLogger;
    private ConcurrentMap fileLocks;

    static {
        PersistenceUtil persistenceUtil;
        gLogger = LogUtil.getLogger(PersistenceUtil.class);
        INSTANCE = persistenceUtil = new PersistenceUtil();
    }

    private PersistenceUtil() {
        ConcurrentHashMap concurrentHashMap;
        this.fileLocks = concurrentHashMap = new ConcurrentHashMap();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void closeQuietly(Closeable closeable) {
        if (closeable == null) return;
        try {
            closeable.close();
            return;
        }
        catch (IOException iOException) {
            return;
        }
    }

    public static InputStream getInputStreamFromFile(File file) {
        BufferedInputStream bufferedInputStream = null;
        if (file == null) {
            return null;
        }
        boolean bl2 = file.exists();
        if (bl2 && (bl2 = file.isFile())) {
            FileInputStream fileInputStream = new FileInputStream(file);
            int n10 = 8192;
            bufferedInputStream = new BufferedInputStream(fileInputStream, n10);
        }
        return bufferedInputStream;
    }

    public static FileOutputStream getOutputStreamForFile(File file, boolean bl2) {
        if (file == null) {
            return null;
        }
        FileOutputStream fileOutputStream = new FileOutputStream(file, bl2);
        return fileOutputStream;
    }

    public static List listFiles(String fileArray) {
        ArrayList<File> arrayList = new ArrayList<File>();
        File file = new File((String)fileArray);
        boolean bl2 = file.exists();
        if (bl2 && (bl2 = file.isDirectory()) && (fileArray = file.listFiles()) != null) {
            for (File file2 : fileArray) {
                boolean bl3 = file2.isFile();
                if (!bl3) continue;
                arrayList.add(file2);
            }
        }
        return arrayList;
    }

    public static PersistenceUtil sharedInstance() {
        return INSTANCE;
    }

    public void clearDir(String fileArray, long l10) {
        File file = new File((String)fileArray);
        boolean bl2 = file.exists();
        if (bl2 && (bl2 = file.isDirectory()) && (fileArray = file.listFiles()) != null) {
            for (File file2 : fileArray) {
                Object object = file2.isFile();
                if (object != 0) {
                    String string2;
                    StringBuilder stringBuilder;
                    AVLogger aVLogger;
                    long l11 = file2.lastModified();
                    long l12 = l11 - l10;
                    object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
                    if (object < 0) {
                        object = this.deleteFile(file2);
                        if (object != 0) {
                            aVLogger = gLogger;
                            stringBuilder = new StringBuilder();
                            string2 = "succeed to delete file: ";
                            stringBuilder.append(string2);
                            String string3 = file2.getAbsolutePath();
                            stringBuilder.append(string3);
                            String string4 = stringBuilder.toString();
                            aVLogger.d(string4);
                            continue;
                        }
                        aVLogger = gLogger;
                        stringBuilder = new StringBuilder();
                        string2 = "failed to delete file: ";
                        stringBuilder.append(string2);
                        String string5 = file2.getAbsolutePath();
                        stringBuilder.append(string5);
                        String string6 = stringBuilder.toString();
                        aVLogger.d(string6);
                        continue;
                    }
                    aVLogger = gLogger;
                    stringBuilder = new StringBuilder();
                    string2 = "skip cache file: ";
                    stringBuilder.append(string2);
                    String string7 = file2.getAbsolutePath();
                    stringBuilder.append(string7);
                    String string8 = stringBuilder.toString();
                    aVLogger.d(string8);
                    continue;
                }
                object = file2.isDirectory();
                if (object == 0) continue;
                String string9 = file2.getAbsolutePath();
                this.clearDir(string9, l10);
            }
        }
    }

    public boolean deleteFile(File object) {
        boolean bl2;
        boolean bl3 = false;
        if (object != null && (bl2 = ((File)object).exists())) {
            Object object2 = ((File)object).getAbsolutePath();
            boolean bl4 = (object2 = this.getLock((String)object2).writeLock()).tryLock();
            if (bl4) {
                bl3 = ((File)object).delete();
                object2.unlock();
                object2 = gLogger;
                StringBuilder stringBuilder = new StringBuilder();
                String string2 = "succeed to obtain writeLock, and delete file: ";
                stringBuilder.append(string2);
                object = ((File)object).getAbsolutePath();
                stringBuilder.append((String)object);
                stringBuilder.append(", ret: ");
                stringBuilder.append(bl3);
                object = stringBuilder.toString();
                ((AVLogger)object2).d((String)object);
            } else {
                object2 = gLogger;
                StringBuilder stringBuilder = new StringBuilder();
                String string3 = "failed to lock writeLocker, skip to delete file:";
                stringBuilder.append(string3);
                object = ((File)object).getAbsolutePath();
                stringBuilder.append((String)object);
                object = stringBuilder.toString();
                ((AVLogger)object2).w((String)object);
            }
        }
        return bl3;
    }

    public boolean deleteFile(String string2) {
        File file = new File(string2);
        return this.deleteFile(file);
    }

    public boolean forceDeleteFile(File file) {
        boolean bl2;
        if (file != null && (bl2 = file.exists())) {
            return file.delete();
        }
        return false;
    }

    public ReentrantReadWriteLock getLock(String object) {
        ConcurrentMap concurrentMap;
        Object object2 = (ReentrantReadWriteLock)this.fileLocks.get(object);
        if (object2 == null && (object = (concurrentMap = this.fileLocks).putIfAbsent(object, object2 = new ReentrantReadWriteLock())) != null) {
            object2 = object;
        }
        return object2;
    }

    public byte[] readContentBytesFromFile(File object) {
        block17: {
            block19: {
                String string2;
                block18: {
                    Object object2;
                    Object object3;
                    Object object4;
                    Object object5;
                    block16: {
                        block15: {
                            string2 = "release read lock for file: ";
                            int n10 = 0;
                            object5 = null;
                            if (object == null) {
                                return null;
                            }
                            boolean bl2 = ((File)object).exists();
                            if (!bl2 || !(bl2 = ((File)object).isFile())) break block17;
                            object4 = ((File)object).getAbsolutePath();
                            int n11 = (object4 = this.getLock((String)object4).readLock()).tryLock();
                            if (n11 == 0) break block18;
                            object3 = gLogger;
                            Object object6 = new StringBuilder();
                            ((StringBuilder)object6).append("obtained read lock for file: ");
                            object2 = ((File)object).getAbsolutePath();
                            ((StringBuilder)object6).append((String)object2);
                            object6 = ((StringBuilder)object6).toString();
                            ((AVLogger)object3).d((String)object6);
                            long l10 = ((File)object).length();
                            n11 = (int)l10;
                            object6 = new byte[n11];
                            FileInputStream fileInputStream = new FileInputStream((File)object);
                            int n12 = 8192;
                            try {
                                object2 = new BufferedInputStream(fileInputStream, n12);
                                n10 = 0;
                                object5 = null;
                            }
                            catch (Throwable throwable) {
                                object2 = null;
                                object5 = throwable;
                                break block16;
                            }
                            catch (IOException iOException) {
                                object2 = null;
                                object5 = iOException;
                            }
                            while (n10 < n11) {
                                int n13 = n11 - n10;
                                try {
                                    if ((n13 = ((InputStream)object2).read((byte[])object6, n10, n13)) <= 0) continue;
                                    n10 += n13;
                                }
                                catch (IOException iOException) {
                                    break block15;
                                }
                            }
                            PersistenceUtil.closeQuietly((Closeable)object2);
                            object4.unlock();
                            object5 = gLogger;
                            object4 = new StringBuilder();
                            ((StringBuilder)object4).append(string2);
                            object = ((File)object).getAbsolutePath();
                            ((StringBuilder)object4).append((String)object);
                            object = ((StringBuilder)object4).toString();
                            ((AVLogger)object5).d((String)object);
                            return object6;
                        }
                        object3 = gLogger;
                        try {
                            ((AVLogger)object3).w((Throwable)object5);
                        }
                        catch (Throwable throwable) {
                            // empty catch block
                        }
                        PersistenceUtil.closeQuietly((Closeable)object2);
                        object4.unlock();
                        object5 = new StringBuilder();
                        ((StringBuilder)object5).append(string2);
                        object = ((File)object).getAbsolutePath();
                        ((StringBuilder)object5).append((String)object);
                        object = ((StringBuilder)object5).toString();
                        ((AVLogger)object3).d((String)object);
                        break block19;
                    }
                    PersistenceUtil.closeQuietly((Closeable)object2);
                    object4.unlock();
                    object4 = gLogger;
                    object3 = new StringBuilder();
                    ((StringBuilder)object3).append(string2);
                    object = ((File)object).getAbsolutePath();
                    ((StringBuilder)object3).append((String)object);
                    object = ((StringBuilder)object3).toString();
                    ((AVLogger)object4).d((String)object);
                    throw object5;
                }
                object = gLogger;
                string2 = "failed to lock readLocker, return empty result.";
                ((AVLogger)object).w(string2);
            }
            return new byte[0];
        }
        return null;
    }

    public String readContentFromFile(File object) {
        int n10;
        int n11;
        if ((object = (Object)this.readContentBytesFromFile((File)object)) != null && (n11 = ((Object)object).length) >= (n10 = 1)) {
            String string2 = new String((byte[])object);
            return string2;
        }
        return "";
    }

    public void removeLock(String string2) {
        this.fileLocks.remove(string2);
    }

    public boolean saveContentToFile(String object, File file) {
        if (file == null) {
            return false;
        }
        String string2 = "utf-8";
        try {
            object = ((String)object).getBytes(string2);
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            return false;
        }
        return this.saveContentToFile((byte[])object, file);
    }

    /*
     * Loose catch block
     * WARNING - void declaration
     */
    public boolean saveContentToFile(byte[] object, File object2) {
        boolean bl2;
        block12: {
            Object object3;
            CharSequence charSequence;
            block11: {
                Object object4;
                block10: {
                    void var1_4;
                    Object object5;
                    block9: {
                        charSequence = "release writeLock for file: ";
                        object3 = ((File)object2).getAbsolutePath();
                        object3 = this.getLock((String)object3).writeLock();
                        boolean bl3 = object3.tryLock();
                        bl2 = true;
                        if (!bl3) break block11;
                        object5 = gLogger;
                        CharSequence charSequence2 = new StringBuilder();
                        charSequence2.append("obtained writeLock for file: ");
                        object4 = ((File)object2).getAbsolutePath();
                        charSequence2.append((String)object4);
                        charSequence2 = charSequence2.toString();
                        ((AVLogger)object5).d((String)charSequence2);
                        charSequence2 = null;
                        object4 = null;
                        FileOutputStream fileOutputStream = new FileOutputStream((File)object2, false);
                        try {
                            fileOutputStream.write((byte[])object);
                            fileOutputStream.flush();
                        }
                        catch (Throwable throwable) {
                            object4 = fileOutputStream;
                            break block9;
                        }
                        catch (Exception exception) {
                            object4 = fileOutputStream;
                            break block10;
                        }
                        PersistenceUtil.closeQuietly(fileOutputStream);
                        object3.unlock();
                        object = new StringBuilder();
                        ((StringBuilder)object).append((String)charSequence);
                        object2 = ((File)object2).getAbsolutePath();
                        ((StringBuilder)object).append((String)object2);
                        object = ((StringBuilder)object).toString();
                        ((AVLogger)object5).d((String)object);
                        break block12;
                        catch (Throwable throwable) {
                            // empty catch block
                        }
                    }
                    if (object4 != null) {
                        PersistenceUtil.closeQuietly((Closeable)object4);
                    }
                    object3.unlock();
                    object3 = gLogger;
                    object5 = new StringBuilder();
                    ((StringBuilder)object5).append((String)charSequence);
                    object2 = ((File)object2).getAbsolutePath();
                    ((StringBuilder)object5).append((String)object2);
                    object2 = ((StringBuilder)object5).toString();
                    ((AVLogger)object3).d((String)object2);
                    throw var1_4;
                    catch (Exception exception) {}
                }
                if (object4 != null) {
                    PersistenceUtil.closeQuietly((Closeable)object4);
                }
                object3.unlock();
                object = gLogger;
                object3 = new StringBuilder();
                ((StringBuilder)object3).append((String)charSequence);
                object2 = ((File)object2).getAbsolutePath();
                ((StringBuilder)object3).append((String)object2);
                object2 = ((StringBuilder)object3).toString();
                ((AVLogger)object).d((String)object2);
                bl2 = false;
                break block12;
            }
            object = gLogger;
            charSequence = new StringBuilder();
            object3 = "failed to lock writeLocker, skip save content to file:";
            ((StringBuilder)charSequence).append((String)object3);
            object2 = ((File)object2).getAbsolutePath();
            ((StringBuilder)charSequence).append((String)object2);
            object2 = ((StringBuilder)charSequence).toString();
            ((AVLogger)object).w((String)object2);
        }
        return bl2;
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean saveFileToLocal(String object, File object2) {
        boolean bl2;
        Serializable serializable;
        block16: {
            Object object3;
            block14: {
                void var1_4;
                block13: {
                    block15: {
                        serializable = this.getLock((String)object).writeLock();
                        boolean bl3 = serializable.tryLock();
                        bl2 = false;
                        if (!bl3) {
                            object2 = gLogger;
                            serializable = new StringBuilder();
                            String string2 = "failed to lock writeLocker, skip save content to file:";
                            ((StringBuilder)serializable).append(string2);
                            ((StringBuilder)serializable).append((String)object);
                            object = ((StringBuilder)serializable).toString();
                            ((AVLogger)object2).w((String)object);
                            return bl2;
                        }
                        bl3 = false;
                        object3 = null;
                        try {
                            object2 = PersistenceUtil.getInputStreamFromFile((File)object2);
                        }
                        catch (Throwable throwable) {
                            object2 = null;
                            break block13;
                        }
                        catch (Exception exception) {
                            boolean bl4 = false;
                            object = null;
                            break block14;
                        }
                        try {
                            File file = new File((String)object);
                            object3 = PersistenceUtil.getOutputStreamForFile(file, false);
                            int n10 = 0x200000;
                            object = new byte[n10];
                            if (object2 != null && object3 != null) {
                                int n12;
                                int n11;
                                while ((n11 = ((InputStream)object2).read((byte[])object)) != (n12 = -1)) {
                                    ((FileOutputStream)object3).write((byte[])object, 0, n11);
                                }
                                bl2 = true;
                            }
                            if (object2 == null) break block15;
                        }
                        catch (Throwable throwable) {
                            Object object4 = object3;
                            object3 = object2;
                            object2 = object4;
                            break block13;
                        }
                        catch (Exception exception) {
                            object = object3;
                            object3 = object2;
                            break block14;
                        }
                        PersistenceUtil.closeQuietly((Closeable)object2);
                    }
                    if (object3 != null) {
                        PersistenceUtil.closeQuietly((Closeable)object3);
                    }
                    break block16;
                }
                if (object3 != null) {
                    PersistenceUtil.closeQuietly(object3);
                }
                if (object2 == null) throw var1_4;
                PersistenceUtil.closeQuietly((Closeable)object2);
                throw var1_4;
            }
            if (object3 != null) {
                PersistenceUtil.closeQuietly((Closeable)object3);
            }
            if (object != null) {
                PersistenceUtil.closeQuietly((Closeable)object);
            }
        }
        serializable.unlock();
        return bl2;
    }
}

