package com.example.aniket.todo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by aniket on 31/01/18.
 */

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.NotesViewHolder> {


    private Context mcontx;
    private List<Notes> mnotes;

    public NotesAdapter(Context mcontx, List<Notes> mnotes) {
        this.mcontx = mcontx;
        this.mnotes = mnotes;
    }

    @Override
    public NotesAdapter.NotesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater=LayoutInflater.from(mcontx);
        View v=inflater.inflate(R.layout.list_recycler,null);
        NotesViewHolder vi=new NotesViewHolder(v);
        return  vi;
    }

    @Override
    public void onBindViewHolder(NotesViewHolder holder, int position) {

        Notes n=mnotes.get(position);

        holder.title.setText(n.getTitle());

        holder.desc.setText(n.getDescription());

    }

    @Override
    public int getItemCount() {
        return mnotes.size();
    }

    public class NotesViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        TextView desc;
        public NotesViewHolder(View itemView) {
            super(itemView);
            title=itemView.findViewById(R.id.textViewTitle);
            desc=itemView.findViewById(R.id.textViewShortDesc);
        }
    }
}
