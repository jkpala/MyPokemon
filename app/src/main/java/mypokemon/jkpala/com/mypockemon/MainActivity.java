package mypokemon.jkpala.com.mypockemon;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import mypokemon.jkpala.com.mypockemon.adapters.PokemonAdapter;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerViewPokemon ;
    private LinearLayoutManager linearLayoutManager;
    private PokemonAdapter pokemonAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerViewPokemon = (RecyclerView) findViewById(R.id.rv_pokemon);
        recyclerViewPokemon.setHasFixedSize(true);
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerViewPokemon.setLayoutManager(linearLayoutManager);
        pokemonAdapter = new PokemonAdapter(this);
        recyclerViewPokemon.setAdapter(pokemonAdapter);
    }
}
