package e.fikri6998.fikrialfitrarahadi_1202150086_modul6;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by fikri6998 on 4/1/2018.
 */

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {

    Context context;
    List<Data> data;

    public DataAdapter(FragmentActivity activity, List<Data> data) {
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Data post = data.get(position);
        holder.recentUsername.setText(post.getUsername());
        holder.recentPhotoTitle.setText(post.getPhotoTitle());
        holder.recentPhotoDesc.setText(post.getPhotoDesc());

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView recentUsername, recentPhotoDesc, recentPhotoTitle;
        ImageView recentPhoto;

        public ViewHolder(View itemView) {
            super(itemView);
            recentUsername = itemView.findViewById(R.id.popularUsername);
            recentPhotoTitle = itemView.findViewById(R.id.popularPhotoTitle);
            recentPhotoDesc = itemView.findViewById(R.id.popularPhotoDesc);
            recentPhoto = itemView.findViewById(R.id.popularPhoto);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

            Intent intent = new Intent();
            context.startActivity(intent);

        }
    }
}
