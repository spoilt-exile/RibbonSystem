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
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.ribbon.controller.Router;
import org.ribbon.enteties.Message;

/**
 * POST_MESG command class.
 * @author Stanislav Nepochatov
 */
public class ComPostMesg implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Message posted = new Message();
        posted.setHeader(request.getParameter("header"));
        posted.setDirId(org.ribbon.dao.mysql.MySqlDAOFactory.getNewInstance().getNewDaoDirectoryInstance().getDirByPath(request.getParameter("directory")).getId());
        posted.setPostDate(new Date());
        posted.setAuthId(org.ribbon.dao.mysql.MySqlDAOFactory.getNewInstance().getNewIDaoUserInstance().getUserByLogin(request.getSession().getAttribute("username").toString()).getId());
        //posted.setIsUrgent(request.getParameter("urgent").equals("on"));
        posted.setIsUrgent(false);
        posted.setBody(request.getParameter("body"));
        org.ribbon.dao.mysql.MySqlDAOFactory.getNewInstance().getNewDaoMessageInstance().save(posted);
        return Router.MAIN_PAGE;
    }

    @Override
    public Boolean isAuthRequired() {
        return true;
    }
    
}
