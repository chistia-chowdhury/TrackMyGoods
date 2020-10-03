package com.example.trackmygoods.model;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;
import android.util.Log;

import com.example.trackmygoods.data.UserLogin;
import com.example.trackmygoods.util.uRepository;

import java.util.List;

public class uViewModel extends AndroidViewModel {
    private uRepository uRepo;
    private uViewModel viewModel;
    private List<UserLogin> userLoginlist;

    public uViewModel(@NonNull Application application,UserLogin userLogin) {
        super(application);

        uRepo = new uRepository(application,userLogin);

        Boolean stat= uRepo.getUserLogin();

        Log.d("ViewModel", "uViewModelCons: "+stat);
    }

  /*  public LiveData<List<UserLogin>> getUserLogin(){
        return userLoginlist;
    }*/
}
