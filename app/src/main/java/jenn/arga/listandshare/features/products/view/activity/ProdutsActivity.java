package jenn.arga.listandshare.features.products.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;

import jenn.arga.listandshare.features.products.model.Product;
import jenn.arga.listandshare.features.products.presenter.ProductsPresenter;
import jenn.arga.listandshare.features.products.view.adapter.ProductsAdapter;
import jenn.arga.listandshare.R;

public class ProdutsActivity extends AppCompatActivity implements ProductsAdapter.RecyclerViewListeners{
    //--------------------------------------------------------------------------
    // CLEAN
    //--------------------------------------------------------------------------

    ProductsPresenter presenter;

    //--------------------------------------------------------------------------
    // VIEWS AND VARIABLES
    //--------------------------------------------------------------------------

    private RecyclerView rv_products;
    private ArrayList<Product> ProductsList;
    private ProductsAdapter products_adapter;


    //--------------------------------------------------------------------------
    // LIFE CYCLE
    //--------------------------------------------------------------------------

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produts);

        rv_products = (RecyclerView) findViewById(R.id.rv_products);

        ProductsList = new ArrayList<>();
        Log.i("Jenn", "Tamaño lista: " + String.valueOf(ProductsList.size()));
       // readRecipesList();

        products_adapter = new ProductsAdapter(ProductsList, this);
        products_adapter.setProductsAdapterListeners(this);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rv_products.setLayoutManager(linearLayoutManager);
        rv_products.setAdapter(products_adapter);

        ProductsList.add(0,  new Product("Pan", "de barra", 1));
        ProductsList.add(1,  new Product("Leche", "sin lactosa", 2));
        ProductsList.add(1,  new Product("Pasta", "Lacitos", 1));

    }

    @Override
    public void onProductItemClick(Product product) { }

    @Override
    public void onProductQuantityClick(Product product) { }
}

