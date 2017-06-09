package mypokemon.jkpala.com.mypockemon.modelo.sqllite;

import android.provider.BaseColumns;

/**
 * Created by PEPE on 8/06/2017.
 */

public class PokemonContract {

    public PokemonContract() {
    }

    public static class PokemoEntry implements BaseColumns {
        public static final String TABLE_NAME = "pokemon";
        public static final String ID = "id";
        public static final String NOMBRE = "nombre";
        public static final String TIPO = "tipo";
        public static final String  COLOR = "color";
        public static final String IMAGEN = "imagen";
    }
}
