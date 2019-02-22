package com.example.xyzreader.data;

import android.content.Context;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.xyzreader.R;

import java.util.List;

public class DetailRecyclerAdapter extends RecyclerView.Adapter<DetailRecyclerAdapter.ViewHolder> {
    private String[] detailArticleData;
    private LayoutInflater layoutInflater;
    private Context context;

    public DetailRecyclerAdapter(Context context, String[] data) {
        this.context = context;
        this.layoutInflater = LayoutInflater.from( this.context);
        detailArticleData = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = layoutInflater.inflate(R.layout.article_detail_row, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        String temp = detailArticleData[i];
        if(temp!=null && !temp.isEmpty()) {
            viewHolder.detaildata.setText(Html.fromHtml(temp.trim()));
            viewHolder.detaildata.setMovementMethod(LinkMovementMethod.getInstance());
        }else {
            viewHolder.detaildata.setVisibility(View.GONE);
        }

    }

    @Override
    public int getItemCount() {
        if(detailArticleData!=null) {
            return detailArticleData.length;
        }
        return 0;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView detaildata;

        ViewHolder(View itemView) {
            super(itemView);
            detaildata = (TextView) itemView.findViewById(R.id.article_body);
            detaildata.setTypeface(Typeface.createFromAsset(context.getResources().getAssets(), "Rosario-Regular.ttf"));

        }
    }
}
