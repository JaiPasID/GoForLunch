package fr.jaipasid.goforlunch;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


import fr.jaipasid.goforlunch.activity.Authentification.LogInPageActivity;
import fr.jaipasid.goforlunch.databinding.ActivityMainBinding;
import fr.jaipasid.goforlunch.fragment.ListViewFragment;
import fr.jaipasid.goforlunch.fragment.MapFragment;
import fr.jaipasid.goforlunch.fragment.WorkmatesFragment;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    private Toolbar mToolbar;
    FirebaseAuth mFirebaseAuth;
    FirebaseUser currentUser;
    BottomNavigationView bottomNavigation;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        chooseFragment(new MapFragment());


        mToolbar = findViewById(R.id.toolBar);
        bottomNavigation = findViewById(R.id.bottomNavigation);

        mFirebaseAuth = FirebaseAuth.getInstance();
        currentUser = mFirebaseAuth.getCurrentUser();

       //setSupportActionBar(mToolbar);
       //getActionBar().setTitle("I'm Hungry !");



        binding.bottomNavigation.setOnItemSelectedListener(item -> {

            switch (item.getItemId()){

                case R.id.map: chooseFragment(new MapFragment());

                    break;
                case R.id.listView: chooseFragment(new ListViewFragment());
                    break;
                case R.id.workmates: chooseFragment(new WorkmatesFragment());
                    break;
            }

            return true;
        });


    }

    private void chooseFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_bottom_navigation, fragment);
        fragmentTransaction.commit();
    }




    public void LogOut(){
        FirebaseAuth.getInstance().signOut();
        Intent intent = new Intent(MainActivity.this, LogInPageActivity.class);
        startActivity(intent);
    }

}