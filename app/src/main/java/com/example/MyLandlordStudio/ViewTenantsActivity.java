package com.example.MyLandlordStudio;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.firestore.auth.User;

import java.util.ArrayList;
import java.util.List;

public class ViewTenantsActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List tenantList;
    private TenantsAdapter adapter;
    private Toolbar title_bar;



    private FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_tenants);

        recyclerView=findViewById(R.id.recyclerview_tenants);
        title_bar=findViewById(R.id.title_bar);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        db=FirebaseFirestore.getInstance();
        String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();

        setSupportActionBar(title_bar);




        tenantList=new ArrayList<>();
        adapter=new TenantsAdapter(this,tenantList);


        recyclerView.setAdapter(adapter);
        CollectionReference documentReference=db.collection("Users").document(uid).collection("tenants");


        documentReference.get()
        .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                if (!queryDocumentSnapshots.isEmpty()){
                    List<DocumentSnapshot> list=queryDocumentSnapshots.getDocuments();
                    for (DocumentSnapshot d:list){


                        Tenant tenant=d.toObject(Tenant.class);
                        tenantList.add(tenant);
                    }

                    adapter.notifyDataSetChanged();
                }else {
                    Toast.makeText(ViewTenantsActivity.this,"You don't have tenants",Toast.LENGTH_SHORT).show();
                }

            }
        }).addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                Toast.makeText(ViewTenantsActivity.this,"Success",Toast.LENGTH_SHORT).show();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(ViewTenantsActivity.this,"Failed to load",Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search_tenant,menu);
        return true;}


}
