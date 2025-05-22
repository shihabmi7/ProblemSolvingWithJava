package com.shihab.general.stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ProductsStream {

//    final String uri = "*****";
//    RestTemplate restTemplate = new RestTemplate();
//    String result = restTemplate.getForObject(uri, String.class);
//    JSONObject root = new JSONObject(result);
//    JSONArray data = root.getJSONArray("data");

//    ObjectMapper mapper = new ObjectMapper();
//    List<Product> products = mapper.readValue(data.toString(),
//            new TypeReference<List<Product>>() {
//            });


    public static void main(String[] args) {
        ArrayList<Product> products = new ArrayList<>();
        String data = "";
        int init_price = 500;
        int final_price = 600;

        //  ✅ Sort by Price (Ascending):
        List<Product> sortedByPrice = products.stream()
                .sorted(Comparator.comparingInt(Product::getPrice))
                .collect(Collectors.toList());
        //✅ Sort by Price (Descending):
        List<Product> sortedByPriceDesc = products.stream()
                .sorted(Comparator.comparingInt(Product::getPrice).reversed())
                .collect(Collectors.toList());
        //✅Sort by Name(Alphabetically):
        List<Product> sortedByName = products.stream()
                .sorted(Comparator.comparing(Product::getItem))
                .collect(Collectors.toList());
        //✅Sort by Discount(Highest First):
        List<Product> sortedByDiscountDesc = products.stream()
                .sorted(Comparator.comparingInt(Product::getDiscount).reversed())
                .collect(Collectors.toList());
        //✅If You Want Both Filter + Sort:+Map

        List<Product> filteredAndSorted = products.stream()
                .filter(p -> p.getPrice() >= init_price && p.getPrice() <= final_price)
                .sorted(Comparator.comparingInt(Product::getPrice))
                .collect(Collectors.toList());
        List<FilteredProducts> result = products.stream()
                .filter(product -> product.getPrice() >= init_price && product.getPrice() <= final_price)
                .sorted(Comparator.comparingInt(Product::getPrice)) // sort ascending
                .map(product -> new FilteredProducts(product.getBarcode())) // map to desired object
                .collect(Collectors.toList());

        List<FilteredProducts> filteredProductList = products.stream()
                .filter(product -> product.getPrice() >= init_price && product.getPrice() <= final_price)
                .map(product -> new FilteredProducts(product.getBarcode()))
                .collect(Collectors.toList());

    }


}
