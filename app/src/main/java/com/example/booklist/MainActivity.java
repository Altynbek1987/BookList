package com.example.booklist;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.util.Log;

import com.example.booklist.adapter.BookAdapter;
import com.example.booklist.data.TestRepository;
import com.example.booklist.interfaces.OnBookClickListener;
import com.example.booklist.model.BooksModels;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    BookAdapter adapter;
    private List<BooksModels> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        list = TestRepository.getBookList();
        adapter = new BookAdapter(list);
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        adapter.setOnBookClickListener(new OnBookClickListener() {
            @Override
            public void onItemClick(int position) {
                Log.e("ololo","main");
                Bundle bundle = new Bundle();
                bundle.putSerializable("position", position);
                BookInfoFragment fragment = new BookInfoFragment();
                fragment.setArguments(bundle);
                getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.fr_container, fragment)
                        .addToBackStack(null).commit();
            }
        });
    }
}
