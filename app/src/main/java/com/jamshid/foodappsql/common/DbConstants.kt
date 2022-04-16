package com.jamshid.foodappsql.common

object DbConstants {
    const val DB_NAME = "my_food"
    const val ID = "_id"
    const val FOOD_NAME = "name"
    const val FOOD_DESC = "desc"
    const val IMG_URL = "url"
    const val RATE = "rate"
    const val AMOUNT = "amount"
    const val TABLE_NAME = "food"
    const val CREATE_TABLE =
        "CREATE TABLE " + TABLE_NAME + "(" + ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                FOOD_NAME + " TEXT NOT NULL," + FOOD_DESC + " TEXT NOT NULL," + IMG_URL +
                " TEXT NOT NULL," + AMOUNT + " REAL," +
                RATE + " REAL)"
    const val SELECT_ALL = "SELECT*FROM " + TABLE_NAME

}