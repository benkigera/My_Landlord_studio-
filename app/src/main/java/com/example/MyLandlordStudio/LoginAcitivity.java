package com.example.MyLandlordStudio;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import static android.view.View.VISIBLE;

public class LoginAcitivity extends AppCompatActivity {

    //declare variables
    EditText editTextEmail,editTextPassword;
    CardView cardview_login;
    TextView textViewRegister;
    FirebaseAuth firebaseAuth;
    ProgressBar progress_circular_login;
    private FirebaseAuth.AuthStateListener authStateListener;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        firebaseAuth= FirebaseAuth.getInstance();
        editTextEmail =findViewById(R.id.editTextEmail);
        editTextPassword=findViewById(R.id.editTextPassword);
        cardview_login=findViewById(R.id.cardview_login);
        textViewRegister=findViewById(R.id.textViewRegister);
        progress_circular_login=findViewById(R.id.progress_circular_login);


        firebaseAuth=FirebaseAuth.getInstance();


        authStateListener=new FirebaseAuth.AuthStateListener() {




            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser firebaseUser=firebaseAuth.getCurrentUser();
                if (firebaseUser!=null){
                    Toast.makeText(LoginAcitivity.this,"You are logged in",Toast.LENGTH_SHORT).show();
                    Intent i =new Intent(LoginAcitivity.this, ApplicationFrame.class);
                    startActivity(i);
                }else {
                    Toast.makeText(LoginAcitivity.this,"Please Login",Toast.LENGTH_SHORT).show();
                }

            }
        };



        textViewRegister.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Intent registerIntent =new Intent(LoginAcitivity.this,RegisterActivity.class);
             startActivity(registerIntent);

          }
       });


        cardview_login.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {



                String email=editTextEmail.getText().toString();
                String password=editTextPassword.getText().toString();

                if (TextUtils.isEmpty(email)){
                    editTextEmail.setError("Email is required");
                    return;
                }

                if(TextUtils.isEmpty(password)){
                    editTextPassword.setError("password is Required");
                    return;
                }

                if (password.length()<6){

                    editTextPassword.setError("Password must be more than 6 characters");
                    return;
                }
                progress_circular_login.setVisibility(VISIBLE);

                //authenticate user
                firebaseAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(LoginAcitivity.this,new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progress_circular_login.setVisibility(View.GONE);


                        if (task.isSuccessful()){
                            Toast.makeText(LoginAcitivity.this,"Login successful",Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(), ApplicationFrame.class));
                        }
                        else {
                            Toast.makeText(LoginAcitivity.this,"Error!"+ task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                        }

                    }
                });

            }
        });




    }

    boolean isEmail(EditText text) {
        CharSequence email = text.getText().toString();
        return (!TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches());
    }
}
