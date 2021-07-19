/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.database;

import androidx.room.RoomDatabase;
import com.zhiyun.cama.data.database.dao.CEUpLoadCloudLogInfoDao;
import com.zhiyun.cama.data.database.dao.CameraDao;
import com.zhiyun.cama.data.database.dao.FeedbackDao;
import com.zhiyun.cama.data.database.dao.MessageDao;
import com.zhiyun.cama.data.database.dao.PrimeInfoDao;
import com.zhiyun.cama.data.database.dao.PublishLogDao;
import com.zhiyun.cama.data.database.dao.SplashAdDao;
import com.zhiyun.cama.data.database.dao.WorksDao;

public abstract class AppDatabase
extends RoomDatabase {
    public abstract CameraDao cameraDao();

    public abstract CEUpLoadCloudLogInfoDao ceUpLoadCloudLogInfoDao();

    public abstract FeedbackDao feedbackDao();

    public abstract MessageDao messageDao();

    public abstract PrimeInfoDao primeInfoDao();

    public abstract PublishLogDao publishLogDao();

    public abstract SplashAdDao splashAdDao();

    public abstract WorksDao worksDao();
}

