package fr.jaipasid.goforlunch.viewmodel;


import androidx.lifecycle.ViewModel;

import fr.jaipasid.goforlunch.repository.FetchDataRepository;

public class FetchDataViewModel extends ViewModel{

    private FetchDataRepository fetchDataRepository;




    public FetchDataViewModel(FetchDataRepository fetchDataRepository) {
        this.fetchDataRepository = fetchDataRepository;
    }


    public void getRestaurants (String myLocation){
//TODO LIVEDATA LIST RESULT
    fetchDataRepository.fetchData(myLocation) ;


    }

}
