package com.android.tugasakhir;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class FashionAdapter extends RecyclerView.Adapter<FashionAdapter.ViewHolder> {

    private List<FashionModel.Result> results;
    private Context context;
    private AdapterListener listener;

    public FashionAdapter(Context context, List<FashionModel.Result> results, AdapterListener listener) {
        this.results    = results ;
        this.context    = context ;
        this.listener   = listener ;
    }

    @NonNull
    @Override
    public FashionAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        return new ViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_main,
                        parent, false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull FashionAdapter.ViewHolder viewHolder, int i) {
        final FashionModel.Result result = results.get(i);
        viewHolder.textView.setText( result.getTitle() );
        Picasso.get()
                .load( result.getImage() )
                .placeholder(R.drawable.img_placeholder)
                .fit(). centerCrop()
                .into(viewHolder.imageView);

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClick(result);
            }
        });
    }

    @Override
    public int getItemCount() {
        return results.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            textView = itemView.findViewById(R.id.textView);
        }
    }

    public void setData(List<FashionModel.Result> newResults) {
        results.clear();
        results.addAll(newResults);
        notifyDataSetChanged();
    }

    public interface AdapterListener {
        void onClick(FashionModel.Result result);
    }
}