package com.example.startupfacbook;

import java.util.List;

import androidx.lifecycle.MutableLiveData;
import io.reactivex.Observable;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class post_client {
    private Retrofit retrofit;
    private String BASE_URL = "https://jsonplaceholder.typicode.com/";
    private static post_client client=null ;
    Observable<List<post_model>> observable ;
    data_access Dao ;
    public  post_client(){
        retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create()).build();
        Dao=retrofit.create(data_access.class);


    }
    public static post_client getInstance(){
        if (client==null){
            client=new post_client();
        }

 return client ;  }
 public Observable<List<post_model>> getposts(){
        return Dao.getposts();



 }


}
