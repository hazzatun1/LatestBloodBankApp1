package com.example.user.myapplication;

public class DonorContact {


        //private variables
        int _id;
        String _bloodGroup;
        String _demand;
        String _address;
        String _mobile;


        // Empty constructor
        public DonorContact(){

        }
        public DonorContact(int id, String bloodGroup,String demand,String address, String mobile){
            this._id=id;
            this._bloodGroup = bloodGroup;
            this._demand = demand;
            this._address = address;
            this._mobile = mobile;
        }

        // constructor
        public DonorContact(String bloodGroup,String demand,String address, String mobile){
            this._bloodGroup = bloodGroup;
            this._demand = demand;
            this._address = address;
            this._mobile = mobile;
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
        public String getAdd(){
            return this._address;
        }

        // setting first name
        public void setAdd(String address){
            this._address = address;
        }

        // getting second name
        public String getdem(){
            return this._demand;
        }

        // setting first name
        public void setDem(String demand){
            this._demand = demand;
        }

        // getting phone number
        public String getBloodGroup(){
            return this._bloodGroup;
        }

        // setting phone number
        public void setBloodGroup(String bloodGroup){
            this._bloodGroup = bloodGroup;
        }

        public String getMob(){
            return this._mobile;
        }

        // setting phone number
        public void setMob(String mobile){
            this._mobile = mobile;
        }
    }




