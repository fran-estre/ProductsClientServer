package com.company.Shared.Commands;

import com.company.Shared.ProductReader;
import com.company.Shared.Entities.Product;

public class PrepareAdd extends PrepareCommand {

    @Override
    public boolean execute(boolean isInteractive, Command command, DataBox dataBox, String[] parts, StringBuilder comments) {
        if (!isInteractive)
            return false;

        command.setCommandType(CommandType.ADD);
        dataBox = readDataCommandAdd();
        command.setDataBox(dataBox);
        return dataBox != null;
    }

    private static Product readProduct() {
        ProductReader productReader = new ProductReader();
        return productReader.createProduct();
    }

    private DataBox readDataCommandAdd() {
        Product product = readProduct();
        DataBox dataBox = new DataBox();
        dataBox.setProduct(product);
        return dataBox;
    }
}
