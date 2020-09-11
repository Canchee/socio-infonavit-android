package com.iacd.socioinfonavit;

import android.graphics.Color;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.iacd.socioinfonavit.model.Benevits;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import java.util.Calendar;
import java.util.Date;

public class AdapterBenevits extends RecyclerView.Adapter {
    ArrayList<Benevits> listBenevits = new ArrayList<>();

    public void setListBenevits(ArrayList<Benevits> listBenevits) {
        this.listBenevits = listBenevits;
        notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {

        if (listBenevits.isEmpty())
        {
            return 0;
        } else {
            if (!listBenevits.get(position).getLocked())
            {
                return 1;
            }
        }
        return 2;
    }

    @NonNull
    @Override
    public ViewHolderBenevits onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == 0)
        {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.component_skeleton_benevit, parent, false);
            return  new ViewHolderBenevitSkeleton(view);
        }
        else if (viewType == 1)
        {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.component_benevit, parent, false);
            return  new ViewHolderBenevits(view);
        }
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.component_get_benevit, parent, false);
        return  new ViewHolderBenevitLocked(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (getItemViewType(position) == 1)
        {
            try {
                ((ViewHolderBenevits) holder).setBenevit(
                        listBenevits.get(position).getAlly().getMiniLogoFullPath(),
                        listBenevits.get(position).getPrimaryColor(),
                        listBenevits.get(position).getTitle(),
                        listBenevits.get(position).getTerritories().get(0).getName(),
                        listBenevits.get(position).getExpirationDate());
            } catch (ParseException e) {
                e.printStackTrace();
            }
        } else if (getItemViewType(position)== 2)
        {
            ((ViewHolderBenevitLocked) holder).setBenevitLocked(
                    listBenevits.get(position).getAlly().getMiniLogoFullPath());
        }
    }

    @Override
    public int getItemCount() {
        if (listBenevits.isEmpty())
        {
            return 3;
        }
        return listBenevits.size();
    }

    public class ViewHolderBenevits extends RecyclerView.ViewHolder
    {
        ImageView logoBenevit;
        ImageView backGroundBenevit;
        TextView descriptionBenevit;
        TextView territoryBenevit;
        TextView timeBenevit;

        public ViewHolderBenevits(@NonNull View itemView) {
            super(itemView);

            logoBenevit = itemView.findViewById(R.id.component_benevit_logo);
            backGroundBenevit = itemView.findViewById(R.id.component_benevit_background);
            descriptionBenevit = itemView.findViewById(R.id.textBenevitDescription);
            territoryBenevit = itemView.findViewById(R.id.textBenevitTerritory);
            timeBenevit = itemView.findViewById(R.id.textBenevitExpTime);

        }

        public void setBenevit(String logo, String backgorundColor, String description, String territory, String time) throws ParseException {
            Glide.with(itemView.getContext())
                    .load(logo)
                    .into(logoBenevit);
            backGroundBenevit.setBackgroundColor(Color.parseColor(backgorundColor));
            descriptionBenevit.setText(description);
            territoryBenevit.setText(territory);

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date benevitDate = dateFormat.parse(time);
            Date currentDate = Calendar.getInstance().getTime();
            long diff = benevitDate.getTime() - currentDate.getTime();
            float dayCount = (float) diff / (24 * 60 * 60 * 1000);
            if (dayCount > 0) {
                timeBenevit.setText("Vence en: " + (String.valueOf((int)dayCount)) + " días");
            } else  {timeBenevit.setText("Expirado");}

        }

    }

    public class ViewHolderBenevitLocked extends ViewHolderBenevits
    {
        ImageView logoBenevitLocked;

        public ViewHolderBenevitLocked(@NonNull View itemView) {
            super(itemView);

            logoBenevitLocked = itemView.findViewById(R.id.imageLockedBenevit);
        }

        public void setBenevitLocked (String logo)
        {
            Glide.with(itemView.getContext())
                    .load(logo)
                    .into(logoBenevitLocked);
        }
    }

    public class ViewHolderBenevitSkeleton extends ViewHolderBenevits
    {

        public ViewHolderBenevitSkeleton(@NonNull View itemView) {
            super(itemView);
        }
    }
}
