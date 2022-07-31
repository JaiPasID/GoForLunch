package fr.jaipasid.goforlunch.activity.Authentification;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Objects;

import fr.jaipasid.goforlunch.MainActivity;
import fr.jaipasid.goforlunch.R;

public class RegistrerPageActivity extends AppCompatActivity{


        FirebaseAuth mFirebaseAuth;

        TextView goToLogIn;
        Button mCreateAccount;
        TextInputEditText mEmail, mPassword;

        private String email;
        private String password;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.register_page);

            goToLogIn = findViewById(R.id.accessToLogIn);
            mCreateAccount = findViewById(R.id.buttonCreateAccount);
            mEmail = findViewById(R.id.getEmail);
            mPassword = findViewById(R.id.getPassword);

            mFirebaseAuth = FirebaseAuth.getInstance();

            mCreateAccount.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    email = Objects.requireNonNull(mEmail.getText()).toString();
                    password = Objects.requireNonNull(mPassword.getText()).toString();
                    RegisterEmailAndPassword();
                    Intent lvIntent = new Intent(RegistrerPageActivity.this, MainActivity.class);
                    startActivity(lvIntent);

                }
            });

            goToLogIn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent lvIntent = new Intent(RegistrerPageActivity.this, LogInPageActivity.class);
                    startActivity(lvIntent);
                }
            });
        }

        public void RegisterEmailAndPassword(){
            mFirebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        FirebaseUser user = mFirebaseAuth.getCurrentUser();
                    }else {
                        Toast.makeText(RegistrerPageActivity.this, "Authentication failed.",
                                Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

