package fr.jaipasid.goforlunch;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import fr.jaipasid.goforlunch.model.User;

public class MainActivity extends AppCompatActivity {


    FirebaseAuth mFirebaseAuth;
    FirebaseUser currentUser;


    TextView mSignOut;

    final Handler handler = new Handler();


    @Override
    protected void onStart() {
        super.onStart();
        mFirebaseAuth = FirebaseAuth.getInstance();
        currentUser = mFirebaseAuth.getCurrentUser();
        if (currentUser == null){
            handler.postDelayed(new Runnable()
            {
                public void run()
                {
                    Intent intent = new Intent(MainActivity.this, LogInPageActivity.class);
                    startActivity(intent);
                }
            }, 2000L);
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSignOut = findViewById(R.id.buttonSignOut);




        mSignOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LogOut();
                Intent lvIntent = new Intent(MainActivity.this, LogInPageActivity.class);
                startActivity(lvIntent);
            }
        });

    }


    public void LogOut(){
        FirebaseAuth.getInstance().signOut();
    }

}