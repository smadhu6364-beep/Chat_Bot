package com.example.chat_bot;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class chatRVAdapter extends RecyclerView.Adapter {
private ArrayList<ChatsModel>chatsModelArrayList;
private Context context;

    public chatRVAdapter(ArrayList<ChatsModel> chatsModelArrayList, Context context) {
        this.chatsModelArrayList = chatsModelArrayList;
        this.context = context;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        switch (viewType){
            case 0:
                view= LayoutInflater.from(parent.getContext()).inflate(R.layout.user_msg_rv_item,parent,false);
                return new UserViewHolder(view);
            case 1:
                view=LayoutInflater.from(parent.getContext()).inflate(R.layout.bot_msg_rv_item,parent,false);
                return new BotUserHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
      ChatsModel chatsModel = chatsModelArrayList.get(position);
     switch (chatsModel.getSender()){
       case "user":
        ((UserViewHolder)holder).userTV.setText(chatsModel.getMessage());
        break;
       case "bot":
        ((BotUserHolder)holder).botMsgTv.setText(chatsModel.getMessage());
        break;
     }
    }

    @Override
    public int getItemViewType(int position) {
        switch (chatsModelArrayList.get(position).getSender()){
            case "user":
                return 0;
            case "bot":
                return 1;
            default:
                return -1;
        }
    }

    @Override
    public int getItemCount() {
        return chatsModelArrayList.size();
    }

    public void notifyItemChanged() {
    }

    public static class  UserViewHolder extends RecyclerView.ViewHolder{
        TextView userTV;
        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            userTV=itemView.findViewById(R.id.idTVuser);
        }
    }

        public static class BotUserHolder extends RecyclerView.ViewHolder {
            TextView botMsgTv;

            public BotUserHolder(@NonNull View itemView) {
                super(itemView);
                botMsgTv = itemView.findViewById(R.id.idTVbot);
            }
        }

}
