package com.company.util;

import com.company.models.IndustrialProduct;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;

public class DataUtil {
    public DataUtil() { }

    public String getDataFolderPath() {
        return System.getProperty("user.dir") + "/data/";
    }

    private JSONArray getJsonArrayFromFile(String path) throws IOException, ParseException {
        try {
            FileReader fileReader = new FileReader(path);
            JSONParser jsonParser = new JSONParser();
            Object object = jsonParser.parse(fileReader);
            JSONArray array = (JSONArray) object;

            return array;
        } catch (IOException exception) {
            throw exception;
        } catch (ParseException exception) {
            throw exception;
        }
    }

    public ArrayList<IndustrialProduct> getIndustrialProducts() {
        try {
            String dataFolderPath = this.getDataFolderPath();
            JSONArray products = this.getJsonArrayFromFile(dataFolderPath + "products.json");
            ArrayList<IndustrialProduct> parsedProducts = new ArrayList<IndustrialProduct>() {};

            products.forEach( product -> {
                IndustrialProduct parsed = this.parseIndustrialProductObject( (JSONObject) product );

                parsedProducts.add(parsed);
            });

            return parsedProducts;
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            System.exit(exception.hashCode());
            return null;
        }
    }

    private IndustrialProduct parseIndustrialProductObject(JSONObject product) {
        long registrationNumber = (long) product.get("registrationNumber");
        String name = (String) product.get("name");
        String model = (String) product.get("model");
        long amount = (long) product.get("amount");
        String manufacturer = (String) product.get("manufacturer");
        Date creationDate = new Date();

        return new IndustrialProduct(registrationNumber, name, model, amount, manufacturer, creationDate);
    }

    public void writeFile(String message, String filePath) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true));
            writer.write(message);

            writer.close();
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
