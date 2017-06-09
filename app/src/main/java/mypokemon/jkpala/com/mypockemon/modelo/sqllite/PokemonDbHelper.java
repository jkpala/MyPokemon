package mypokemon.jkpala.com.mypockemon.modelo.sqllite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import mypokemon.jkpala.com.mypockemon.R;
import mypokemon.jkpala.com.mypockemon.modelo.entities.Pokemon;
import mypokemon.jkpala.com.mypockemon.modelo.sqllite.PokemonContract.PokemoEntry;
/**
 * Created by PEPE on 8/06/2017.
 */

public class PokemonDbHelper extends SQLiteOpenHelper {

    private static final String TEXT_TYPE = " TEXT";
    private static final String INT_TYPE = " INT";
    private static final String COMMA_SEP = ",";

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Pokemon.db";

    public PokemonDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_POKEMON);
        mockData(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_POKEMON);
        onCreate(db);
    }

    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }

    private static final String SQL_CREATE_POKEMON =
            "CREATE TABLE " + PokemoEntry.TABLE_NAME + " (" +
                    PokemoEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    PokemoEntry.ID  + TEXT_TYPE + COMMA_SEP +
                    PokemoEntry.NOMBRE + TEXT_TYPE + COMMA_SEP +
                    PokemoEntry.COLOR + INT_TYPE + COMMA_SEP +
                    PokemoEntry.IMAGEN + INT_TYPE + COMMA_SEP +
                    PokemoEntry.TIPO + TEXT_TYPE + COMMA_SEP +
                    "UNIQUE (" + PokemoEntry.ID + "))";


    private static final String SQL_DELETE_POKEMON =
            "DROP TABLE IF EXISTS " + PokemoEntry.TABLE_NAME;

    public long mockPokemon(SQLiteDatabase db, Pokemon pokemon) {
        return db.insert(
                PokemoEntry.TABLE_NAME,
                null,
                pokemon.toContentValues());
    }

    private void mockData(SQLiteDatabase sqLiteDatabase){
        mockPokemon(sqLiteDatabase,new Pokemon("Raichu","Electrico",R.color.electrico, R.drawable.ic_raichu));
        mockPokemon(sqLiteDatabase,new Pokemon("Clefable","Hada",R.color.hada,R.drawable.ic_clefable));
        mockPokemon(sqLiteDatabase,new Pokemon("Charizard","Fuego",R.color.dragon,R.drawable.ic_charizard));
        mockPokemon(sqLiteDatabase,new Pokemon("Blastoise","Agua",R.color.agua,R.drawable.ic_blastoise));
        mockPokemon(sqLiteDatabase,new Pokemon("ButterFree","Bicho",R.color.bicho,R.drawable.ic_butterfree));
        mockPokemon(sqLiteDatabase,new Pokemon("Dragonite","Dragon",R.color.dragon,R.drawable.ic_dragonite));
    }

    public Cursor getAllPokemones() {
        return getReadableDatabase()
                .query(
                        PokemoEntry.TABLE_NAME,
                        null,
                        null,
                        null,
                        null,
                        null,
                        null);
    }

    public Cursor getLawyerById(String pokemonId) {
        Cursor c = getReadableDatabase().query(
                PokemoEntry.TABLE_NAME,
                null,
                PokemoEntry.ID + " LIKE ?",
                new String[]{pokemonId},
                null,
                null,
                null);
        return c;
    }
}

