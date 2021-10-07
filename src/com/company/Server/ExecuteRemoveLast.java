package com.company.Server;

import com.company.Shared.Commands.Command;

import java.util.Vector;

public class ExecuteRemoveLast extends ExecuteCommand {

    @Override
    public String execute(Command command) {
        int last = ServerApp.products.size();
        ServerApp.products.removeElementAt(last - 1);
        return "the last Product was removed";
    }
}
