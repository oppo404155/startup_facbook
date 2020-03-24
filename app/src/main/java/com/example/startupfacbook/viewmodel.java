package com.example.startupfacbook;

import java.util.List;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class viewmodel extends ViewModel {
    public MutableLiveData<List<post_model>> mutableLiveData=new MutableLiveData<>();


   public void getpost(){
       post_client client =post_client.getInstance();
       Observable<List<post_model>> on=client.getposts().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
       on.subscribe(c->{mutableLiveData.setValue(c);});

   }












}
