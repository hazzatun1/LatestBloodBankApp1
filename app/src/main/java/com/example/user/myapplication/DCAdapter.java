package com.example.user.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

    public class DCAdapter extends ArrayAdapter<DonorContact> {

        Context context;
        ArrayList<DonorContact> mcontact;


        public DCAdapter(Context context, ArrayList<DonorContact> dcontact){
            super(context, R.layout.donorlist, dcontact);
            this.context=context;
            this.mcontact=dcontact;
        }

        public  class  Holder{

            TextView nameFV;
            TextView nameSV;
            TextView phoneV;
            TextView newv;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // Get the data item for this position

            DonorContact data = getItem(position);
            // Check if an existing view is being reused, otherwise inflate the view

            Holder viewHolder; // view lookup cache stored in tag

            if (convertView == null) {


                viewHolder = new Holder();
                LayoutInflater inflater = LayoutInflater.from(getContext());
                convertView = inflater.inflate(R.layout.userlist, parent, false);

                viewHolder.nameFV = (TextView) convertView.findViewById(R.id.txtView1);
                viewHolder.nameSV = (TextView) convertView.findViewById(R.id.txtView2);
                viewHolder.phoneV = (TextView) convertView.findViewById(R.id.txtView3);
                viewHolder.newv = (TextView) convertView.findViewById(R.id.txtView4);

                convertView.setTag(viewHolder);
            } else {
                viewHolder = (Holder) convertView.getTag();
            }


            viewHolder.nameFV.setText("Mob no: "+data.getMob());
            viewHolder.nameSV.setText("Value per bag: "+data.getdem());
            viewHolder.phoneV.setText("Blood group: "+data.getBloodGroup());
            viewHolder.newv.setText("Address: "+data.getAdd());

            // Return the completed view to render on screen
            return convertView;
        }

    }





