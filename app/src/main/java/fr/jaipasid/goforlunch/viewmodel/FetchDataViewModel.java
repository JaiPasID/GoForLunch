package fr.jaipasid.goforlunch.viewmodel;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import fr.jaipasid.goforlunch.models.MyFetchData;
import fr.jaipasid.goforlunch.repository.FetchDataRepository;

public class FetchDataViewModel extends ViewModel{


    private FetchDataRepository fetchDataRepository;




    public FetchDataViewModel(FetchDataRepository fetchDataRepository) {
        this.fetchDataRepository = fetchDataRepository;
    }


    public LiveData<MyFetchData> getRestaurants (String localisation){

        return fetchDataRepository.fetchData(localisation);

    }

}
