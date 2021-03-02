package com.example.gasia.Adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ahmadrosid.svgloader.SvgLoader;
import com.example.gasia.R;
import com.example.gasia.models.Country;
import com.example.gasia.models.languages;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    private Context context;
    private List<Country> countries;

    public Adapter(Context context,List<Country> countries) {
        this.context = context;
        this.countries=countries;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Country country = countries.get(position);
        holder.name.setText(country.getName());
        holder.capital.setText(country.getCapital());
        holder.region.setText(country.getRegion());
        holder.subregion.setText(country.getSubregion());
        int population=country.getPopulation();
        holder.population.setText(String.valueOf(population));
        List<languages> langList=country.getLanguages();
        String language="";
        for(languages lang:langList){
            language=language+lang.getName()+", ";
        }
        holder.languages.setText(language);

        List<String> border=country.getBorders();
        String borders="";
        for(String bord:border){
            borders=borders+bord+", ";
        }
        holder.borders.setText(borders);
        SvgLoader.pluck().with((Activity) context).setPlaceHolder(R.mipmap.ic_launcher,R.mipmap.ic_launcher).load(country.getFlag(),holder.image);

    }

    @Override
    public int getItemCount() {
        return countries.size();
    }

    public void setData(List<Country> countries){
        this.countries=countries;
        notifyDataSetChanged();
    }

    public void getAllDatas(List<Country> countries)
    {
        this.countries=countries;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView name;
        TextView capital;
        TextView region;
        TextView subregion;
        TextView population;
        TextView languages;
        TextView borders;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.imageView);
            name = itemView.findViewById(R.id.name);
            capital = itemView.findViewById(R.id.capital);
            region = itemView.findViewById(R.id.region);
            subregion = itemView.findViewById(R.id.subregion);
            population = itemView.findViewById(R.id.population);
            languages = itemView.findViewById(R.id.languages);
            borders = itemView.findViewById(R.id.borders);
        }
    }
}
