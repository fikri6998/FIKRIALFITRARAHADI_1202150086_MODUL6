package e.fikri6998.fikrialfitrarahadi_1202150086_modul6;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fikri6998 on 4/1/2018.
 */

public class Terbaru extends Fragment {

    RecyclerView recentRecycler;
    TerbaruAdapter adapter;
    List<Data> data;

    DatabaseReference databaseReference;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_terbaru, container, false);

        data = new ArrayList<>();

        recentRecycler = view.findViewById(R.id.recentRecycler);
        recentRecycler.setLayoutManager(new GridLayoutManager(getActivity(), 2));

        databaseReference = FirebaseDatabase.getInstance().getReference("posts");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    Data post = snapshot.getValue(Data.class);
                    data.add(post);
                }

                adapter = new TerbaruAdapter(getActivity(), data);
                recentRecycler.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        return view;
    }

}

