/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.im;

import cn.leancloud.im.DatabaseDelegateFactory;
import cn.leancloud.im.DirectlyOperationTube;
import cn.leancloud.im.FileMetaAccessor;
import cn.leancloud.im.OperationTube;
import cn.leancloud.im.SimpleFileMetaAccessor;

public class InternalConfiguration {
    private static DatabaseDelegateFactory databaseDelegateFactory;
    private static FileMetaAccessor fileMetaAccessor;
    private static OperationTube operationTube;

    static {
        Object object = new DirectlyOperationTube(true);
        operationTube = object;
        fileMetaAccessor = object = new SimpleFileMetaAccessor();
        databaseDelegateFactory = null;
    }

    public static DatabaseDelegateFactory getDatabaseDelegateFactory() {
        return databaseDelegateFactory;
    }

    public static FileMetaAccessor getFileMetaAccessor() {
        return fileMetaAccessor;
    }

    public static OperationTube getOperationTube() {
        return operationTube;
    }

    public static void setDatabaseDelegateFactory(DatabaseDelegateFactory databaseDelegateFactory) {
        InternalConfiguration.databaseDelegateFactory = databaseDelegateFactory;
    }

    public static void setFileMetaAccessor(FileMetaAccessor fileMetaAccessor) {
        InternalConfiguration.fileMetaAccessor = fileMetaAccessor;
    }

    public static void setOperationTube(OperationTube operationTube) {
        InternalConfiguration.operationTube = operationTube;
    }
}

