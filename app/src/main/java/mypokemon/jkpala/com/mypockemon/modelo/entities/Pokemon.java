package mypokemon.jkpala.com.mypockemon.modelo.entities;

import android.content.ContentValues;

import java.util.UUID;

import mypokemon.jkpala.com.mypockemon.modelo.sqllite.PokemonContract;

/**
 * Created by PEPE on 8/06/2017.
 */

public class Pokemon {
    private String id = "";
    private String nombre = "";
    private String tipo = "";
    private int color = 0;
    private int imagen = 0;

    public Pokemon(String nombre, String tipo, int color, int imagen) {
        this.id = UUID.randomUUID().toString();
        this.nombre = nombre;
        this.tipo = tipo;
        this.color = color;
        this.imagen = imagen;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public ContentValues toContentValues() {
        ContentValues values = new ContentValues();
        values.put(PokemonContract.PokemoEntry.ID,id);
        values.put(PokemonContract.PokemoEntry.NOMBRE,nombre);
        values.put(PokemonContract.PokemoEntry.COLOR,color);
        values.put(PokemonContract.PokemoEntry.IMAGEN,imagen);
        values.put(PokemonContract.PokemoEntry.TIPO,tipo);
        return values;
    }

}
