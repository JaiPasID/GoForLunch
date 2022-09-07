package fr.jaipasid.goforlunch.viewmodel;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import fr.jaipasid.goforlunch.repository.FetchDataRepository;
import fr.jaipasid.goforlunch.utils.Retrofit;

public class NewModelFactory implements ViewModelProvider.Factory{

    private static NewModelFactory newModelFactory;
    private FetchDataRepository fetchDataRepository;
    /**
     * Singleton
     * instantiate ViewModelFactory with things inside constructors
     */
    public static NewModelFactory getInstance(Context context) {

        if (newModelFactory == null) {
            synchronized (NewModelFactory.class) {
                newModelFactory = new NewModelFactory(context);
            }
        }
        return newModelFactory;
    }

    /**
     * Constructor
     * Instantiate 1 repository
     */
    private NewModelFactory(Context context) {
       
        fetchDataRepository = new FetchDataRepository(Retrofit.getGoogleMapsApi());
       
    }



    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {

        if (modelClass.isAssignableFrom(FetchDataViewModel.class)) {
            return (T) new FetchDataViewModel(fetchDataRepository);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
