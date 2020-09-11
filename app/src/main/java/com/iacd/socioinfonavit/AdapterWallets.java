package com.iacd.socioinfonavit;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.iacd.socioinfonavit.model.BenevitWallet;
import com.iacd.socioinfonavit.model.Benevits;
import com.iacd.socioinfonavit.model.Wallets;

import java.util.ArrayList;

public class AdapterWallets extends RecyclerView.Adapter {

    ArrayList<Wallets> listWallets = new ArrayList<>();
    ArrayList<BenevitWallet> listBenevitWallets = new ArrayList<>();
    ArrayList<Benevits> listBenevits = new ArrayList<>();

    ArrayList<Wallets> realListWallets = new ArrayList<>();




    public void setListWallets(ArrayList<Wallets> listWallets) {
        this.listWallets = listWallets;
        notifyDataSetChanged();
    }

    public void setListBenevitWallets(ArrayList<BenevitWallet> listBenevitWallets) {
        this.listBenevitWallets = listBenevitWallets;
    }

    public void setListBenevits(ArrayList<Benevits> listBenevits) {
        this.listBenevits = listBenevits;
        notifyDataSetChanged();
    }

    public void setRealListWallets(ArrayList<Wallets> realListWallets) {

        this.realListWallets = realListWallets;
    }

    @Override
    public int getItemViewType(int position) {
        if (listWallets.isEmpty())
        {
            return 0;
        }
        return 1;
    }

    @NonNull
    @Override
    public ViewHolderWallets onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == 0)
        {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.component_skeleton_wallet, parent, false);
            return  new  ViewHolderWallets(view);
        }

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_wallets, parent, false);
        return new ViewHolderWallets(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ArrayList<Benevits> auxListBenevits = new ArrayList<>();
        auxListBenevits.clear();

        if (getItemViewType(position) ==  1)
        {
            for (int i = 0; i < listBenevits.size(); i++)
            {
                if (listWallets.get(position).getId() == listBenevits.get(i).getBenevitWallet().getId())
                {
                    auxListBenevits.add(listBenevits.get(i));
                }
            }
            ((ViewHolderWallets) holder).setWallets( auxListBenevits, listWallets.get(position).getName());

        }

    }

    @Override
    public int getItemCount() {
        if (listWallets.isEmpty())
        {
            return 3;
        }
        return listWallets.size();
    }

    public class ViewHolderWallets extends RecyclerView.ViewHolder {

        TextView walletName;
        RecyclerView recyclerView;
        AdapterBenevits adapterBenevits;


        public ViewHolderWallets(@NonNull View itemView) {
            super(itemView);

            walletName = itemView.findViewById(R.id.walletName);
            recyclerView = itemView.findViewById(R.id.benevitRecycler);
            adapterBenevits = new AdapterBenevits();
            recyclerView.setAdapter(adapterBenevits);
        }

        public void setWallets(ArrayList<Benevits> benevitsForWallet, String name) {
            walletName.setText(name);
            adapterBenevits.setListBenevits(benevitsForWallet);
        }
    }
    public class ViewHolderWalletsSkeleton extends RecyclerView.ViewHolder {

        public ViewHolderWalletsSkeleton(@NonNull View itemView) {
            super(itemView);
        }
    }

}
