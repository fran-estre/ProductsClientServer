package com.company.Server;

import com.company.Shared.Commands.Command;

import java.util.Vector;

public class ExecuteClear extends ExecuteCommand {

    @Override
    public String execute(Command command) {
        ServerApp.products = new Vector<>();
        return "the collection was cleared";
    }
}
