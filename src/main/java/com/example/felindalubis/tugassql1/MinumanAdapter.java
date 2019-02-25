package com.example.felindalubis.tugassql1;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.felindalubis.tugassql1.dbHelper.MinumanHelper;

import java.util.ArrayList;

public class MinumanAdapter extends RecyclerView.Adapter<MinumanAdapter.CustomViewHolder> {
    //private ArrayList<String> values;


    private LayoutInflater mInflater;
    private ArrayList<MinumanModel> minuman;
    private Context context;
    private MinumanHelper minumanHelper;


    public MinumanAdapter(Context context) {
        this.context = context;
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        minumanHelper = new MinumanHelper(context);
    }

    // Create new views (invoked by the layout manager)
    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup viewGroup,
                                               int viewType) {
        // create a new view
        mInflater = LayoutInflater.from(
                viewGroup.getContext());
        View v =
                mInflater.inflate(R.layout.minuman_row, viewGroup, false);
        // set the view's size, margins, paddings and layout parameters
        CustomViewHolder vh = new CustomViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(final CustomViewHolder holder, final int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        final String nama = minuman.get(position).getNama();
        final String harga = minuman.get(position).getHarga();
        final String toko = minuman.get(position).getToko();
        holder.editNama.setText(nama);
        holder.editHarga.setText(harga);
        holder.editToko.setText(toko);


        holder.btnupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                minuman.get(position).setNama(holder.editNama.getText().toString());
                minuman.get(position).setHarga(holder.editHarga.getText().toString());
                minuman.get(position).setToko(holder.editToko.getText().toString());
                minumanHelper.open();
                minumanHelper.update(minuman.get(position));
                minumanHelper.close();
                Toast.makeText(context, "updated", Toast.LENGTH_SHORT).show();
                notifyDataSetChanged();
            }
        });
        holder.btndelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                deleteitem(minuman.get(position).getId());
                minuman.remove(position);
                notifyDataSetChanged();

            }
        });


    }

    private void deleteitem(int id) {

        minumanHelper.open();
        minumanHelper.delete(id);
        minumanHelper.close();

        Toast.makeText(context, "deleted", Toast.LENGTH_SHORT).show();

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return minuman.size();
    }

    public void addItem(ArrayList<MinumanModel> mData) {
        this.minuman = mData;
        notifyDataSetChanged();
    }

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public class CustomViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        private EditText editNama, editHarga, editToko;
        private Button btnupdate, btndelete;

        public CustomViewHolder(View itemView) {
            super(itemView);

            editNama = (EditText) itemView.findViewById(R.id.edit_nama);
            editHarga = (EditText) itemView.findViewById(R.id.edit_harga);
            editToko = (EditText) itemView.findViewById(R.id.edit_toko);
            btnupdate = (Button) itemView.findViewById(R.id.btn_update);
            btndelete = (Button) itemView.findViewById(R.id.btn_delete);
        }

    }
}
