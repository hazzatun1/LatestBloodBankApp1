package com.example.user.myapplication;

public class Contact {

    //private variables
        int _id;
        String _bloodGroup;
        String _contact;
        String _address;


        // Empty constructor
        public Contact(){

        }
    public Contact(int id, String bloodGroup,String contact,String address){
this._id=id;
        this._bloodGroup = bloodGroup;
        this._contact = contact;
        this._address = address;
    }

        // constructor
        public Contact(String bloodGroup,String contact,String address){

            this._bloodGroup = bloodGroup;
            this._contact = contact;
            this._address = address;
        }

        // getting ID
        public int getID(){
            return this._id;
        }

        // setting id
        public void setID(int id){
            this._id = id;
        }

        // getting first name
        public String getUserName(){
            return this._address;
        }

        // setting first name
        public void setUserName(String address){
            this._address = address;
        }

        // getting second name
        public String getAddress(){
            return this._contact;
        }

        // setting first name
        public void setAddress(String contact){
            this._contact = contact;
        }

        // getting phone number
        public String getBloodGroup(){
            return this._bloodGroup;
        }

        // setting phone number
        public void setBloodGroup(String bloodGroup){
            this._bloodGroup = bloodGroup;
        }

    }


