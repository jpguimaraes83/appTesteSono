package com.example.testesono.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DadosOpenHelper extends SQLiteOpenHelper {

    public DadosOpenHelper(@Nullable Context context) {
        super(context, "HISTORICO", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db){

        db.execSQL(ScriptSQL.getCreateTable());

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){

    }
}
