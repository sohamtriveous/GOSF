package com.soham.gosf.network;

import com.soham.gosf.network.model.GOSFDeals;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;
import retrofit.http.GET;


/**
 * Created by sohammondal on 23/12/14.
 */
public class APIClient {
    private static final String API_URL = "https://www.kimonolabs.com/api";
    private static GOSFDealsInterface gosfDealsInterface = null;

    public static GOSFDealsInterface getApi() {
        if(gosfDealsInterface == null) {
            RestAdapter restAdapter = new RestAdapter.Builder()
                    .setEndpoint(API_URL)
                    .build();
            gosfDealsInterface = restAdapter.create(GOSFDealsInterface.class);
        }

        return gosfDealsInterface;
    }

    public interface GOSFDealsInterface {
        @GET("/dh5sm01o?apikey=ZdSnJCoFzxb1gjUS3m9wSx97NrSPDbdQ")
        public GOSFDeals getDeals();

        @GET("/dh5sm01o?apikey=ZdSnJCoFzxb1gjUS3m9wSx97NrSPDbdQ")
        public void getDeals(Callback<GOSFDeals> gosfDealsCallback);
    }
}
