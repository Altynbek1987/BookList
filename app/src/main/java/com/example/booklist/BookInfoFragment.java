package com.example.booklist;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.booklist.model.BooksModels;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class BookInfoFragment extends Fragment {
    private TextView bookName, bookDesc;
    private ArrayList<BooksModels> booksList = new ArrayList<>();
    private BooksModels models;

    public BookInfoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            models = (BooksModels) bundle.getSerializable("position"); // Key
            booksList.add(models);
        }
        return inflater.inflate(R.layout.fragment_book_info, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        bookName = view.findViewById(R.id.info_bookName);
        bookDesc = view.findViewById(R.id.info_desc);
        if (models != null) {
            bookName.setText(models.getBookName());
            bookDesc.setText(models.getBookDesc());
        }
    }
}
