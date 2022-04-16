package com.jamshid.foodappsql.data.model.local

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.jamshid.foodappsql.common.DbConstants

class DbHelper(ctx: Context) : SQLiteOpenHelper(ctx, DbConstants.DB_NAME, null, 1) {

    override fun onCreate(p0: SQLiteDatabase?) {
        p0!!.execSQL(DbConstants.CREATE_TABLE)
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        p0!!.execSQL("DROP TABLE IF EXISTS " + DbConstants.TABLE_NAME)
        onCreate(p0)
    }
}