package com.jamshid.foodappsql.data.model.local

import android.content.ContentValues
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteException
import android.util.Log
import android.widget.Toast
import com.jamshid.foodappsql.common.DbConstants
import com.jamshid.foodappsql.domain.models.Food

class DbQueryImpl(helper: DbHelper) : DbQuery {

    private var sqLiteDatabase: SQLiteDatabase = helper.writableDatabase

    override suspend fun insertFood(food: Food) {
        val cv = ContentValues()
        cv.put(DbConstants.FOOD_NAME, food.name)
        cv.put(DbConstants.FOOD_DESC, food.name)
        cv.put(DbConstants.RATE, food.rate)
        cv.put(DbConstants.IMG_URL, food.urlList)
        cv.put(DbConstants.AMOUNT, food.amount)
        try {
            sqLiteDatabase.insertOrThrow(DbConstants.TABLE_NAME, null, cv)
        } catch (e: SQLiteException) {
            Log.d("SQL Exception", "insertFood: ${e.message}")
        }
    }

    override suspend fun getAllFood(): List<Food> {
        return emptyList()
    }

    override suspend fun searchFood(): List<Food> {
        return emptyList()
    }

    override suspend fun deleteFood(pos: Int) {
        sqLiteDatabase.delete(
            DbConstants.TABLE_NAME,
            DbConstants.ID + " = ? " + pos,
            null
        )
    }

    override suspend fun deleteAllFood() {
        sqLiteDatabase.execSQL("DROP TABLE "+DbConstants.TABLE_NAME)
    }

}