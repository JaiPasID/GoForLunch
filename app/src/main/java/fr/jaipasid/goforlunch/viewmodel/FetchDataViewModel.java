package fr.jaipasid.goforlunch.viewmodel;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import fr.jaipasid.goforlunch.models.MyFetchData;
import fr.jaipasid.goforlunch.models.Result;
import fr.jaipasid.goforlunch.repository.FetchDataRepository;

public class FetchDataViewModel extends ViewModel{

    private FetchDataRepository fetchDataRepository;




    public FetchDataViewModel(FetchDataRepository fetchDataRepository) {
        this.fetchDataRepository = fetchDataRepository;
    }


    public void getRestaurants (String myLocation){

    fetchDataRepository.fetchData(myLocation) ;


    }

}
