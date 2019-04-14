package com.example.user.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper{
        public static final String DATABASE_NAME ="register.db";
        public static final String TABLE_NAME ="registeruser";
        public static final String COL_1 ="ID";
        public static final String COL_2 ="username";
        public static final String COL_3 ="password";
        public static final String COL_4 ="mobile";
        public static final String COL_5 ="bloodGroup";
    public static final String COL_6 ="address";

        public static final String TABLE_donor ="registerdonor";
        public static final String COL_d1 ="ID";
        public static final String COL_d2 ="username";
        public static final String COL_d3 ="password";
        public static final String COL_d4 ="mobile";
        public static final String COL_d5 ="bloodGroup";
    public static final String COL_d6 ="address";

    public static final String TABLE_blood ="blood_management";
    public static final String COL_dd1 ="ID";
    public static final String COL_dd2 ="value_per_bag";
    public static final String COL_dd3 ="ifPaid";
    public static final String COL_dd4 ="seeker_time_range";


        public DatabaseHelper(Context context) {
            super(context, DATABASE_NAME, null, 2);
        }

        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {
            sqLiteDatabase.execSQL("CREATE TABLE registeruser " +
                    "(ID INTEGER PRIMARY  KEY AUTOINCREMENT, username TEXT, password TEXT, mobile TEXT, bloodGroup TEXT, address TEXT)");
            sqLiteDatabase.execSQL("CREATE TABLE registerdonor " +
                    "(ID INTEGER PRIMARY  KEY AUTOINCREMENT, username TEXT, password TEXT, mobile TEXT, bloodGroup TEXT, address TEXT)");
            sqLiteDatabase.execSQL("CREATE TABLE blood_management " +
                    "(ID INTEGER PRIMARY  KEY AUTOINCREMENT, value_per_bag TEXT, ifPaid TEXT, seeker_time_range TEXT)");
        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
            sqLiteDatabase.execSQL(" DROP TABLE IF EXISTS " + TABLE_NAME);
            sqLiteDatabase.execSQL(" DROP TABLE IF EXISTS " + TABLE_donor);
            onCreate(sqLiteDatabase);
        }

        public long addUser(String user, String password,String bloodGroup,String contact,String address ){
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put("username",user);
            contentValues.put("password",password);
            contentValues.put("mobile", bloodGroup);
            contentValues.put("bloodGroup",contact);
            contentValues.put("address",address);
            long res = db.insert("registeruser",null,contentValues);
            db.close();
            return  res;
        }

    public long addDonor(String user, String password,String bloodGroup,String contact,String address ){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username",user);
        contentValues.put("password",password);
        contentValues.put("mobile", bloodGroup);
        contentValues.put("bloodGroup",contact);
        contentValues.put("address",address);
        long res = db.insert("registerdonor",null,contentValues);
        db.close();
        return  res;
    }

    public long addBlood(String vpb){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("value_per_bag",vpb);

        long res = db.insert("blood_management",null,contentValues);
        db.close();
        return  res;
    }
    public long addBlood2(String ip, String str){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("ifPaid",ip);
        contentValues.put("seeker_time_range", str);
        long res = db.insert("blood_management",null,contentValues);
        db.close();
        return  res;
    }




    public boolean checkUser(String username, String password){
            String[] columns = { COL_1 };
            SQLiteDatabase db = getReadableDatabase();
            String selection = COL_2 + "=?" + " and " + COL_3 + "=?";
            String[] selectionArgs = { username, password };
            Cursor cursor = db.query(TABLE_NAME,columns,selection,selectionArgs,null,null,null);
            int count = cursor.getCount();
            cursor.close();
            db.close();

            if(count>0)
                return  true;
            else
                return  false;
        }

        public boolean checkDonor(String username, String password){
            String[] columns = { COL_d1 };
            SQLiteDatabase db = getReadableDatabase();
            String selection = COL_d2 + "=?" + " and " + COL_d3 + "=?";
            String[] selectionArgs = { username, password };
            Cursor cursor = db.query(TABLE_donor,columns,selection,selectionArgs,null,null,null);
            int count = cursor.getCount();
            cursor.close();
            db.close();

            if(count>0)
                return  true;
            else
                return  false;
        }




    public List<Contact> getAllContacts() {
        List<Contact> contactList = new ArrayList<Contact>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_NAME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Contact contact = new Contact();
                contact.setID(Integer.parseInt(cursor.getString(0)));
                contact.setAddress(cursor.getString(1));
                contact.setUserName(cursor.getString(2));
                contact.setBloodGroup(cursor.getString(3));

                // Adding contact to list
                contactList.add(contact);
            } while (cursor.moveToNext());
        }

        // return contact list
        return contactList;
    }

    public List<DonorContact> getAllDonor() {
        List<DonorContact> contactList = new ArrayList<DonorContact>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_donor;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                DonorContact contact = new DonorContact();
                contact.setID(Integer.parseInt(cursor.getString(0)));
                contact.setAdd(cursor.getString(1));
                contact.setDem(cursor.getString(2));
                contact.setBloodGroup(cursor.getString(3));
                contact.setMob(cursor.getString(4));

                // Adding contact to list
                contactList.add(contact);
            } while (cursor.moveToNext());
        }

        // return contact list
        return contactList;
    }



}


