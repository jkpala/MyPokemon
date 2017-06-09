package mypokemon.jkpala.com.mypockemon.adapters;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import mypokemon.jkpala.com.mypockemon.R;
import mypokemon.jkpala.com.mypockemon.modelo.sqllite.PokemonDbHelper;


/**
 * Created by PEPE on 8/06/2017.
 */

public class PokemonAdapter extends RecyclerView.Adapter<PokemonAdapter.ViewHolder>{
    public static String PACKAGE_NAME;
    public static String RESOURCE_ANDROID;
    private static Context context = null;
    private Cursor items = null;

    public PokemonAdapter(Context context1) {
        PACKAGE_NAME = context1.getPackageName();
        RESOURCE_ANDROID = "android.resource://" + PACKAGE_NAME+"/";
        this.context = context1;
        this.swapCursor(new PokemonDbHelper(this.context).getAllPokemones());
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.list_item_pokemon,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String s;
        int i;

        items.moveToPosition(position);

        s = items.getString(ConsultaPokemones.NOMBRE);
        holder.tvNombre.setText(s);

        s = items.getString(ConsultaPokemones.TIPO);
        holder.tvTipo.setText(s);

        i = items.getInt(ConsultaPokemones.IMAGEN);
        holder.ivPokemon.setImageURI(Uri.parse(RESOURCE_ANDROID + i));

        i = items.getInt(ConsultaPokemones.COLOR);
        holder.rlItem.setBackgroundResource(i);
    }

    @Override
    public int getItemCount() {
        if(items != null)
            return items.getCount();
        return 0;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivPokemon;
        TextView tvNombre;
        TextView tvTipo;
        RelativeLayout rlItem;

        public ViewHolder(View itemView) {
            super(itemView);
            rlItem = (RelativeLayout) itemView.findViewById(R.id.rl_item);
            tvNombre = (TextView) itemView.findViewById(R.id.tv_nombre);
            tvTipo = (TextView) itemView.findViewById(R.id.tv_tipo);
            ivPokemon = (ImageView) itemView.findViewById(R.id.iv_imagen);
        }
    }
    interface ConsultaPokemones {
        int ID_POKEMON = 1;
        int NOMBRE = 2;
        int COLOR = 3;
        int IMAGEN = 4;
        int TIPO = 5;
    }

    public void swapCursor(Cursor nuevoCursor) {
        if (nuevoCursor != null) {
            items = nuevoCursor;
            notifyDataSetChanged();
        }
    }
}
