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

package org.ribbon.commands;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.ribbon.controller.Router;
import org.ribbon.enteties.User;
import org.ribbon.dao.mysql.*;
import org.ribbon.service.Utils;
import java.util.Date;

/**
 * LOGIN command class.
 * @author Stanislav Nepochatov
 */
public class ComLogin implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User findedUser = MySqlDAOFactory.getNewInstance().getNewIDaoUserInstance().getUserByLogin(request.getParameter("login"));
        if (findedUser == null) {
            response.addHeader("login_error", "NOT_FOUND_OR_INCORRECT_PASSWD " + request.getParameter("login"));
            return Router.DEFAULT_PAGE;
        }
        if (findedUser.getPassw().equals(Utils.getHash(request.getParameter("passw")))) {
            request.getSession().setAttribute("username", findedUser.getLogin());
            findedUser.setIsActive(true);
            findedUser.setLogDate(new Date());
            MySqlDAOFactory.getNewInstance().getNewIDaoUserInstance().save(findedUser);
            return Router.MAIN_PAGE;
        } else {
            response.addHeader("login_error", "NOT_FOUND_OR_INCORRECT_PASSWD " + request.getParameter("login"));
            return Router.DEFAULT_PAGE;
        }
    }

    @Override
    public Boolean isAuthRequired() {
        return false;
    }
    
}
