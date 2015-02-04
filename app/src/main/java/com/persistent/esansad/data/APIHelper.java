package com.persistent.esansad.data;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.persistent.esansad.data.MemberOfParliament;

/**
 * Created by pranav_tendolkar on 4/2/2015.
 * all API access done by the program from here. implements caching
 */


public class APIHelper {

    public MemberOfParliament getMPDetails(String constituency, Context context)
    {
        //check in localdb
        MemberOfParliament mp= new MemberOfParliament();
        //check in db

        MemberOfParliamentORM memberOfParliamentORM= new MemberOfParliamentORM();

        mp=MemberOfParliamentORM.getMP(constituency, context);

        if(mp == null)
        {
            //mp does not exist in localdb. query api
            // Instantiate the RequestQueue.
            RequestQueue queue = Volley.newRequestQueue(context);
            String url ="http://ourserver.com//mp/"+constituency;

            // Request a string response from the provided URL.
            StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                    new Response.Listener() {


                        public void onResponse(String response) {




                        }

                        @Override
                        public void onResponse(Object response) {



                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                }
            });
            // Add the request to the RequestQueue.
            queue.add(stringRequest);

        }













        //call
        return null;
    }

}
