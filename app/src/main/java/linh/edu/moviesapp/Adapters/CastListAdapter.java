package linh.edu.moviesapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import linh.edu.moviesapp.Domains.Cast;
import linh.edu.moviesapp.R;

public class CastListAdapter extends RecyclerView.Adapter<CastListAdapter.ViewHolder> {
    ArrayList <Cast> casts;
    Context context;

    public CastListAdapter(ArrayList<Cast> casts) {
        this.casts = casts;
    }

    @NonNull
    @Override
    public CastListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_actor, parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull CastListAdapter.ViewHolder holder, int position) {
        Glide.with(context)
                .load(casts.get(position).getPicUrl())
                .into(holder.pic);
        holder.nameTxt.setText(casts.get(position).getActor());
    }

    @Override
    public int getItemCount() {
        return casts.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView pic;
        TextView nameTxt;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            pic = itemView.findViewById(R.id.itemImage);
            nameTxt = itemView.findViewById(R.id.nameTxt);
        }
    }
}
