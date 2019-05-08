package com.mohit.chatappminor.frames;



import com.mohit.chatappminor.Notifications.MyResponse;
import com.mohit.chatappminor.Notifications.Sender;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface APIService {
    @Headers(
            {
                    "Content-Type:application/json",
                    "Authorization:key=AAAAkSHeftI:APA91bGOfPIcOQ8koHcmvJt_LqFqQXKVz41W8SsA3D_L4rIg0jpeaPIWFmwoZhlMPsg28jE2OJeiPMI23xw4Q42_MHcxj9bByMmRwul-7JewqRxwFekpwQx_NAyVvrsuKcrWFJp_5GAh"
            }
    )

    @POST("fcm/send")
    Call<MyResponse> sendNotification(@Body Sender body);
}
