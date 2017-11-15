package com.example.android.androidnews.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android.androidnews.Common.Common;
import com.example.android.androidnews.Interface.IconBetterIdeaService;
import com.example.android.androidnews.Interface.ItemClickListener;
import com.example.android.androidnews.Model.IconBetterIdea;
import com.example.android.androidnews.Model.WebSite;
import com.example.android.androidnews.R;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by hp on 11/15/2017.
 */
class ListSourceViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
{

    ItemClickListener itemClickListener;
    TextView source_title;
    CircleImageView source_image;

    public ListSourceViewHolder(View itemView) {
        super(itemView);

        source_image = (CircleImageView) itemView.findViewById(R.id.source_image);
        source_title = (TextView)itemView.findViewById(R.id.source_name);
    }

    public ListSourceViewHolder(View itemView, ItemClickListener itemClickListener) {
        super(itemView);
        this.itemClickListener = itemClickListener;
    }

    @Override
    public void onClick(View view) {
        itemClickListener.onclick(view,getAdapterPosition(),false);
    }

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }
}
public class ListSourceAdapter extends RecyclerView.Adapter<ListSourceViewHolder> {
private Context context;
    private WebSite webSite;
    private IconBetterIdeaService mService;
    public ListSourceAdapter(Context context, WebSite webSite) {
        this.context = context;
        this.webSite = webSite;
        mService = Common.getIconService();

    }





    @Override
    public ListSourceViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.source_layout,parent,false);
        return new ListSourceViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ListSourceViewHolder holder, int position) {
    StringBuilder iconBetterAPI = new StringBuilder(" https://icons.better-idea.org/allicons.json?url=http://www.abc.net.au/news.");
    iconBetterAPI.append(webSite.getSources().get(position).getUrl());

    mService.getIconUrl(iconBetterAPI.toString())
            .enqueue(new Callback<IconBetterIdea>() {
                @Override
                public void onResponse(Call<IconBetterIdea> call, Response<IconBetterIdea> response) {
                    if (response.body().getIcons().size() > 0)
                    {
                        Picasso.with(context)
                                .load(response.body().getIcons().get(0).getUrl());
                    }
                }

                @Override
                public void onFailure(Call<IconBetterIdea> call, Throwable t) {

                }
            });
        
        holder.source_title.setText(webSite.getSources().get(position).getName());
        
        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onclick(View view, int position, boolean isLongClick) {

            }
        });
        
    }




    @Override
    public int getItemCount() {
        return webSite.getSources().size();
    }
}
