
package Dev_J130.lists;

import java.util.List;
        
import Dev_J130.models.Products;
import Dev_J130.util.Repository;



public class ProductList {
    
    private static final ProductList productInstance = new ProductList();  
    private final List<Products> productsList;

    public ProductList() {
        productsList = new Repository().getProductsList();
	}

//Метод возвращает кол-во товаров, загруженных из базы данных.
    public int getProductsCount() {
        return productsList.size();
    }
//Метод возвращает данные о товаре в виде объекта класса Products.
    public Products getProduct(int index) {
        return productsList.get(index);
    }
//Статический метод для доступа к полям класса.
    public static ProductList getProductInstance() {
		return productInstance;
	}
//Метод возвращает весь список товаров.
    public List<Products> getProductList() {
        return productsList;
    }    
}
