package com.example.MyLandlordStudio;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

import static android.view.View.VISIBLE;

public class RegisterActivity extends AppCompatActivity {

    public static final String TAG = "TAG";
    CardView cardview_register;
    EditText editTextFname,editTextEmail,editTextLastName,editTextPassword,editTextPhoneNumber;
    ProgressBar progress_circular;
    FirebaseFirestore firebaseFirestore;
    FirebaseAuth firebaseAuth;
    private String userId;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_register);

        cardview_register= findViewById(R.id.cardview_register);
        editTextLastName=findViewById(R.id.editTextLname);
        editTextEmail=findViewById(R.id.editTextEmail);
        editTextPassword=findViewById(R.id.editTextPassword);
        editTextFname=findViewById(R.id.editTextFname);
        editTextPhoneNumber=findViewById(R.id.editTextPhoneNumber);

        progress_circular=findViewById(R.id.progress_circular);
        firebaseAuth=FirebaseAuth.getInstance();
        firebaseFirestore=FirebaseFirestore.getInstance();





        cardview_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final String email=editTextEmail.getText().toString();
                String password=editTextPassword.getText().toString();
                final String firstName=editTextFname.getText().toString();
                final String lastName=editTextLastName.getText().toString();
                final String phoneNumber=editTextPhoneNumber.getText().toString();
                String userID;

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
                progress_circular.setVisibility(VISIBLE);

                //register the user in firebase


                firebaseAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        progress_circular.setVisibility(View.INVISIBLE);


                        if (task.isSuccessful()){
                            Toast.makeText(RegisterActivity.this,"User Created.",Toast.LENGTH_SHORT).show();
                            userId =firebaseAuth.getCurrentUser().getUid();
                            DocumentReference documentReference=firebaseFirestore.collection("users").document(userId);
                            Map<String,Object> user=new HashMap<>();
                            user.put("FirstName",firstName);
                            user.put("LastName",lastName);
                            user.put("PhoneNumber",phoneNumber);
                            user.put("Email",email);
                            documentReference.set(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    Log.d(TAG,"OnSuccess:user profile is created for" + userId);
                                }
                            }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Log.d(TAG,"onFailure: "+ e.toString());
                                }
                            });
                            startActivity(new Intent(getApplicationContext(), ApplicationFrame.class));
                        }
                        else {
                            Toast.makeText(RegisterActivity.this,"Error!"+ task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });


    }
}