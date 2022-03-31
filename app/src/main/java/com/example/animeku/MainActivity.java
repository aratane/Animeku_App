package com.example.animeku;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvFilm;
    private ArrayList<Film> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvFilm = findViewById(R.id.rv_film);
        rvFilm.setHasFixedSize(true);

        list.addAll(FilmData.getListdata());
        showRecyclerList();
    }

    private void showRecyclerList() {
        rvFilm.setLayoutManager(new LinearLayoutManager(this));
        ListFilmAdapter listFilmAdapter = new ListFilmAdapter(list);
        rvFilm.setAdapter(listFilmAdapter);

        listFilmAdapter.setOnItemClickCallback(new ListFilmAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(Film data) {
                showSelectedFilm(data);
            }
        });

    }

    private void showSelectedFilm(Film film) {
        Toast.makeText(this, "Kamu memilih " + film.getJudul(), Toast.LENGTH_SHORT).show();
    }
}
