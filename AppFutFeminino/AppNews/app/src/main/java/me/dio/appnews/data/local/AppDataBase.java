package me.dio.appnews.data.local;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import me.dio.appnews.domain.News;

@Database(entities = {News.class}, version = 1)
public abstract class AppDataBase extends RoomDatabase {
    public abstract NewsDao newsDao();
}