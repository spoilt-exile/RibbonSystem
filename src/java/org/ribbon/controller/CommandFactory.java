/*
 * Copyright (C) 2014 Stanislav Nepochatov
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */

package org.ribbon.controller;

import org.ribbon.commands.*;
import javax.servlet.http.HttpServletRequest;

/**
 * Controller command handler;
 * @author Stanislav Nepochatov
 */
public class CommandFactory {
    
    /**
     * Instance of factory.
     */
    private static CommandFactory instance;
    
    /**
     * Private constructor.
     */
    private CommandFactory() {};
    
    /**
     * Get instance of CommandFactory.
     * @return sigletone instance;
     */
    public static CommandFactory getInstance() {
        if (instance == null) {
            instance = new CommandFactory();
        }
        return instance;
    }
    
    /**
     * Get specified command reference;
     * @param request user request;
     * @return command ready to execute;
     */
    public Command getCommand(HttpServletRequest request) {
        try {
            return CommandTypes.valueOf(request.getParameter("command")).getCommand();
        } catch (IllegalArgumentException ex) {
            ex.printStackTrace();
            return null;    //TO-DO implement normal error page;
        }
    }
}
