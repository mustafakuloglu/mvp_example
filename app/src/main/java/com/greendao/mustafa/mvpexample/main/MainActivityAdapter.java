package com.greendao.mustafa.mvpexample.main;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.greendao.mustafa.mvpexample.R;
import com.greendao.mustafa.mvpexample.model.NoteModel;
import com.greendao.mustafa.mvpexample.note.NoteActivity;

import java.util.List;

public class MainActivityAdapter extends RecyclerView.Adapter<MainActivityAdapter.MyViewHolder> {
    private List<NoteModel> noteList;
    private LayoutInflater mInflater;
    private Context context;

    public MainActivityAdapter(List<NoteModel> noteList, Context context) {
        this.context = context;
        this.noteList = noteList;
        mInflater = LayoutInflater.from(context);

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType != -1) {
            return new MyViewHolder(mInflater.inflate(R.layout.item_recycler_note, parent, false));
        }
        return null;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        final NoteModel noteModel = noteList.get((position));
        holder.title.setText(noteModel.getTitle());
        holder.body.setText(noteModel.getBody());
        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, NoteActivity.class);
                intent.putExtra("Note", noteModel);
                context.startActivity(intent);


            }
        });

    }

    @Override
    public int getItemCount() {
        return noteList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, body;
        LinearLayout layout;

        public MyViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.txt_title);
            body = itemView.findViewById(R.id.txt_body);
            layout = itemView.findViewById(R.id.item_layout);

        }
    }


}
