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

package org.ribbon.dao.mysql;

import java.util.*;
import java.sql.*;
import org.ribbon.dao.IDAOMessage;
import org.ribbon.enteties.Message;
import org.ribbon.service.Utils;

/**
 * MySql implementation of Message DAO.
 * @author Stanislav Nepochatov
 */
public class MySqlDAOMessage implements IDAOMessage {

    @Override
    public boolean save(Message givenMessage) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Message getMessageById(int givenId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Message> getMessagesByDirId(int givenDirId) {
        Connection conn = null;
        PreparedStatement pstn = null;
        ResultSet res = null;
        try {
            List<Message> rList = new ArrayList<Message>();
            conn = Utils.getConnection();
            pstn = conn.prepareStatement("SELECT Message.* FROM Message JOIN Directory WHERE Directory.id=dir_id AND dir_id=?;");
            pstn.setInt(1, givenDirId);
            res = pstn.executeQuery();
            while (res.next()) {
                Message addMesg = new Message();
                addMesg.setId(res.getInt("id"));
                addMesg.setHeader(res.getString("header"));
                addMesg.setDirId(res.getInt("dir_id"));
                addMesg.setPostDate(res.getDate("post_date"));
                addMesg.setAuthId(res.getInt("auth_id"));
                addMesg.setIsUrgent(res.getBoolean("is_urgent"));
                addMesg.setBody(res.getString("body"));
                rList.add(addMesg);
            }
            return rList;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        } finally {
            try {
                if (res != null) {
                    res.close();
                }
                if (pstn != null) {
                    pstn.close();
                }
                Utils.closeConnection(conn);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    
}
