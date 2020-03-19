package com.example.MyLandlordStudio;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class PropertyListView extends AppCompatActivity {

    ListView listview;
    String mtitle[]={"Thames apartment","Blessed apartment"};
    String propertyLocation[]={"Githurai","Rongai"};
    int images[]={R.drawable.ic_email_grey_24dp,R.drawable.apartment_logo};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_property_list_view);

        listview=findViewById(R.id.property_listView);
        //now create an adapter class

        MyAdapter myAdapter=new MyAdapter(this,mtitle,propertyLocation,images);
        listview.setAdapter(myAdapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });


    }

    class MyAdapter extends ArrayAdapter<String>{

        Context context;
        String rTitle[];
        String rLocation[];
        int[] rImages;

        public MyAdapter(Context context, String title[], String location[],int rImages[]) {
            super(context, R.layout.row_property_view,R.id.textView1,title);
            this.context=context;
            this.rTitle=title;
            this.rLocation=location;
            this.rImages=rImages;
        }

        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

            LayoutInflater layoutInflater=(LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row=layoutInflater.inflate(R.layout.row_property_view,parent,false);
            ImageView images=row.findViewById(R.id.image);
            TextView mTitle=row.findViewById(R.id.textView1);
            TextView location=row.findViewById(R.id.textView2);

            //now set ;our resources on views
            images.setImageResource(rImages[position]);
            mTitle.setText(rTitle[position]);
            location.setText(rLocation[position]);

            return row;
        }
    }
}
