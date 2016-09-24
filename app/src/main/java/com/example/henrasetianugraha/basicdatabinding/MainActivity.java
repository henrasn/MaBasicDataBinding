package com.example.henrasetianugraha.basicdatabinding;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.henrasetianugraha.basicdatabinding.databinding.ActivityMainBinding;
import com.example.henrasetianugraha.basicdatabinding.databinding.ItemMenuBinding;
import com.example.henrasetianugraha.basicdatabinding.databinding.ItemsBinding;

public class MainActivity extends AppCompatActivity {

    public static String TAG="com.example.henrasetianugraha.basicdatabinding";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        DataSource dataSource=DataSource.get("Henra");
        DataSource include = DataSource.get("amazing");

        binding.setDataSource(dataSource);
        binding.setSource(include);

        ItemMenuBinding itemMenuBinding=ItemMenuBinding.inflate(getLayoutInflater(),binding.menu,false);
        itemMenuBinding.setItem(new MenuItem(true,"berry","3.00",2));
        binding.menu.addView(itemMenuBinding.getRoot());

        ItemMenuBinding menuBinding=ItemMenuBinding.inflate(getLayoutInflater(),binding.menu,false);
        menuBinding.setItem(new MenuItem(false,"berryss","5.00",0));
        binding.menu.addView(menuBinding.getRoot());

        binding.rv.setLayoutManager(new LinearLayoutManager(this));
        binding.rv.setAdapter(new bindAdapter(getLayoutInflater()));
        binding.rv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("dasdsa", "onClick: ");
            }
        });
    }

    private class bindAdapter extends RecyclerView.Adapter<ViewHolders> {
        private LayoutInflater layoutInflater;

        public bindAdapter(LayoutInflater layoutInflater) {
            this.layoutInflater = layoutInflater;
        }

        @Override
        public ViewHolders onCreateViewHolder(ViewGroup parent, int viewType) {
            ItemsBinding itemsBinding=ItemsBinding.inflate(layoutInflater,parent,false);
            return new ViewHolders(itemsBinding.getRoot());
        }

        @Override
        public void onBindViewHolder(ViewHolders holder, int position) {
            DataSource dataSource = DataSource.get("recycler view in " + position);
            ItemsBinding binding = DataBindingUtil.getBinding(holder.itemView);
            binding.setDataSource(dataSource);
        }

        @Override
        public int getItemCount() {
            return 10;
        }
    }

    private class ViewHolders extends RecyclerView.ViewHolder{
        public ViewHolders(View itemView) {
            super(itemView);
            ItemsBinding itemsBinding=DataBindingUtil.getBinding(itemView);
        }

    }
}
