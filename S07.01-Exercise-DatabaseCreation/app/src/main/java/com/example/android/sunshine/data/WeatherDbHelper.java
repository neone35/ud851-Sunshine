/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.sunshine.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import static android.content.ContentValues.TAG;

/**
 * Manages a local database for weather data.
 */
// COMPLETE (11) Extend SQLiteOpenHelper from WeatherDbHelper

public class WeatherDbHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "weather.db";
    private static final int DATABASE_VERSION = 1;

    public WeatherDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String tableName = WeatherContract.WeatherEntry.TABLE_NAME;
        String table_ID = WeatherContract.WeatherEntry._ID;
        String tableColumnID = WeatherContract.WeatherEntry.COLUMN_WEATHER_ID;
        String tableColumnDate = WeatherContract.WeatherEntry.COLUMN_DATE;
        String tableColumnMin = WeatherContract.WeatherEntry.COLUMN_MIN_TEMP;
        String tableColumnMax = WeatherContract.WeatherEntry.COLUMN_MAX_TEMP;
        String tableColumnHumidity = WeatherContract.WeatherEntry.COLUMN_HUMIDITY;
        String tableColumnPressure = WeatherContract.WeatherEntry.COLUMN_PRESSURE;
        String tableColumnWind = WeatherContract.WeatherEntry.COLUMN_WIND_SPEED;
        String tableColumnDegrees = WeatherContract.WeatherEntry.COLUMN_DEGREES;

        final String SQL_CREATE_WEATHER_TABLE =
                "CREATE TABLE " + tableName + " (" +
                        table_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                        tableColumnDate + " DATE," +
                        tableColumnID + " INTEGER," +
                        tableColumnMin + " INTEGER," +
                        tableColumnMax + " INTEGER," +
                        tableColumnHumidity + " REAL," +
                        tableColumnPressure + " REAL," +
                        tableColumnWind + " REAL," +
                        tableColumnDegrees + " REAL," +
                        ");";
        sqLiteDatabase.execSQL(SQL_CREATE_WEATHER_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

//  COMPLETE (12) Create a public static final String called DATABASE_NAME with value "weather.db"

//  COMPLETE (13) Create a private static final int called DATABASE_VERSION and set it to 1

//  COMPLETE (14) Create a constructor that accepts a context and call through to the superclass constructor

//  COMPLETE (15) Override onCreate and create the weather table from within it

//  COMPLETE (16) Override onUpgrade, but don't do anything within it yet
}