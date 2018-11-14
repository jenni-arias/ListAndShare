package jenn.arga.listandshare.features.products.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import jenn.arga.listandshare.features.products.model.Product;
import jenn.arga.listandshare.R;

public class ProductsAdapter extends RecyclerView.Adapter<ProductsAdapter.ProductViewHolder> {

    private List<Product> listaProducts;
    private Context context;

    private RecyclerViewListeners recyclerViewListeners; //para que el fragment reciba el onclick del elemento pulsado

    public interface RecyclerViewListeners {
        void onProductItemClick(Product product);
        void onProductQuantityClick(Product product);
    }

    public void setProductsAdapterListeners(RecyclerViewListeners callBack) {
        this.recyclerViewListeners = callBack;
    }

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ProductViewHolder extends RecyclerView.ViewHolder
    {
        // each data item is just a string in this case
        TextView product_name;
        TextView product_description;
        EditText product_quantity;
        LinearLayout item;

        public ProductViewHolder(View itemView) {
            super(itemView);
            product_name = (TextView) itemView.findViewById(R.id.product_name);
            product_description = (TextView) itemView.findViewById(R.id.product_description);
            product_quantity = (EditText) itemView.findViewById(R.id.product_quantity);
            item = (LinearLayout) itemView.findViewById(R.id.item);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public ProductsAdapter(List<Product> listaProducts, Context context){
        this.listaProducts = listaProducts;
        this.context = context;
    }

    public ProductsAdapter(){

    }

    // Create new views (invoked by the layout manager)
    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_products_item, viewGroup, false);
        ProductViewHolder nvh = new ProductViewHolder(v);
        return nvh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(final ProductViewHolder viewHolder, final int position) {

        final Product product = listaProducts.get(position);

        //DATE
        //String date = convertTime(mensaje.getFechaCreacion());
        //viewHolder.tv_date.setText(date);

        //PRODUCT NAME
        viewHolder.product_name.setText(product.getProduct_name());

        //PRODUCT DESCRIPTION
        viewHolder.product_description.setText(product.getProduct_description());

        //PRODUCT QUANTITY --> es un EditText
        //viewHolder.product_quantity.setText(product.getProduct_quantity());


        viewHolder.item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recyclerViewListeners.onProductItemClick(product);
            }
        });

        viewHolder.item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recyclerViewListeners.onProductQuantityClick(product);
            }
        });
    }


    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return listaProducts.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    /*
    public String convertTime(long time){
        Date date = new Date(time);
        Format format = new SimpleDateFormat("dd/MM/yy");
        return format.format(date);
    } */
}
