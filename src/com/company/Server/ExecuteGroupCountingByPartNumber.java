package com.company.Server;

import com.company.Shared.Commands.Command;
import com.company.Shared.Entities.Product;

import java.util.Hashtable;
import java.util.Vector;

import static com.company.Server.ServerApp.products;

public class ExecuteGroupCountingByPartNumber extends ExecuteCommand {

    @Override
    public String execute(Command command) {
        StringBuilder response = new StringBuilder();
        Hashtable<String, Integer> groups = new Hashtable();
        for (Product product : products) {
            if (product.getPartNumber() == null) {
                if (groups.containsKey("")) {
                    groups.replace("", groups.get("").intValue() + 1);
                } else {
                    groups.put("", 1);
                }
            }
            String group = Character.toString(product.getPartNumber().charAt(0));
            if (groups.containsKey(group)) {
                groups.replace(group, groups.get(group).intValue() + 1);
            } else {
                groups.put(group, 1);
            }
        }
        groups.forEach((k, v) -> response.append(String.format("group:%s, count:%s%n", k, v)));
        return response.toString();
    }
}
