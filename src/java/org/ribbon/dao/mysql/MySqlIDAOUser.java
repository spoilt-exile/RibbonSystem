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

import javax.naming.*;
import java.sql.*;
import java.util.*;
import org.ribbon.enteties.User;
import org.ribbon.service.*;

/**
 * MySql implementation of User DAO.
 * @author Stanislav Nepochatov
 */
public class MySqlIDAOUser implements org.ribbon.dao.IDAOUser {

    @Override
    public boolean save(User givenUser) {
        if (givenUser.getId() == -1) {
            Connection conn = null;
            PreparedStatement pstn = null;
            ResultSet res = null;
            try {
                conn = Utils.getNewConnection();
                pstn = conn.prepareStatement("INSERT INTO User (login,description,passw,crt_date,log_date,is_admin,is_enabled,is_active) VALUES(?,?,?,?,?,?,?,0);", Statement.RETURN_GENERATED_KEYS);
                pstn.setString(1, givenUser.getLogin());
                pstn.setString(2, givenUser.getDescription());
                pstn.setString(3, givenUser.getPassw());
                pstn.setDate(4, new java.sql.Date(givenUser.getCrtDate().getTime()));
                pstn.setDate(5, new java.sql.Date(givenUser.getLogDate().getTime()));
                pstn.setBoolean(6, givenUser.getIsAdmin());
                pstn.setBoolean(7, givenUser.getIsEnabled());
                pstn.executeUpdate();
                res = pstn.getGeneratedKeys();
                res.next();
                givenUser.setId(res.getInt(1));
                return true;
            } catch (Exception ex) {
                ex.printStackTrace();
                return false;
            } finally {
                try {
                    if (res != null) {
                        res.close();
                    }
                    if (pstn != null) {
                        pstn.close();
                    }
                    if (conn != null) {
                        conn.close();
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        } else {
            Connection conn = null;
            PreparedStatement pstn = null;
            try {
                conn = Utils.getNewConnection();
                pstn = conn.prepareStatement("UPDATE User SET login=?, description=?, passw=?, crt_date=?, log_date=?, is_admin=?, is_enabled=?, is_active=? WHERE id=" + givenUser.getId() + ";");
                pstn.setString(1, givenUser.getLogin());
                pstn.setString(2, givenUser.getDescription());
                pstn.setString(3, givenUser.getPassw());
                pstn.setDate(4, new java.sql.Date(givenUser.getCrtDate().getTime()));
                pstn.setDate(5, new java.sql.Date(givenUser.getLogDate().getTime()));
                pstn.setBoolean(7, givenUser.getIsAdmin());
                pstn.setBoolean(8, givenUser.getIsEnabled());
                pstn.setBoolean(9, givenUser.getIsActive());
                pstn.executeUpdate();
                return true;
            } catch (Exception ex) {
                ex.printStackTrace();
                return false;
            } finally {
                try {
                    if (pstn != null) {
                        pstn.close();
                    }
                    if (conn != null) {
                        conn.close();
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    @Override
    public User getUserById(int givenId) {
        User currUser = new User();
        Connection conn = null;
        Statement stn = null;
        ResultSet res = null;
        try {
            conn = Utils.getNewConnection();
            stn = conn.createStatement();
            res = stn.executeQuery("SELECT * FROM User WHERE id=" + givenId + ";");
            res.next();
            currUser.setId(res.getInt("id"));
            currUser.setLogin(res.getString("login"));
            currUser.setDescription(res.getString("description"));
            currUser.setPassw(res.getString("passw"));
            currUser.setCrtDate(res.getDate("crt_date"));
            currUser.setLogDate(res.getDate("log_date"));
            currUser.setIsAdmin(res.getBoolean("is_admin"));
            currUser.setIsEnabled(res.getBoolean("is_enabled"));
            currUser.setIsActive(res.getBoolean("is_active"));
        } catch (NamingException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (res != null) {
                    res.close();
                }
                if (stn != null) {
                    stn.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return currUser;
    }

    @Override
    public User getUserByLogin(String givenLogin) {
        User currUser = new User();
        Connection conn = null;
        Statement stn = null;
        ResultSet res = null;
        try {
            conn = Utils.getNewConnection();
            stn = conn.createStatement();
            res = stn.executeQuery("SELECT * FROM User WHERE login='" + givenLogin + "';");
            res.next();
            currUser.setId(res.getInt("id"));
            currUser.setLogin(res.getString("login"));
            currUser.setDescription(res.getString("description"));
            currUser.setPassw(res.getString("passw"));
            currUser.setCrtDate(res.getDate("crt_date"));
            currUser.setLogDate(res.getDate("log_date"));
            currUser.setIsAdmin(res.getBoolean("is_admin"));
            currUser.setIsEnabled(res.getBoolean("is_enabled"));
            currUser.setIsActive(res.getBoolean("is_active"));
        } catch (NamingException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (res != null) {
                    res.close();
                }
                if (stn != null) {
                    stn.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return currUser;
    }

    @Override
    public List<User> getAll() {
        List<User> rList = new ArrayList<User>();
        Connection conn = null;
        Statement stn = null;
        ResultSet res = null;
        try {
            conn = Utils.getNewConnection();
            stn = conn.createStatement();
            res = stn.executeQuery("SELECT * FROM User;");
            while(res.next()) {
                User currUser = new User();
                currUser.setId(res.getInt("id"));
                currUser.setLogin(res.getString("login"));
                currUser.setDescription(res.getString("description"));
                currUser.setPassw(res.getString("passw"));
                currUser.setCrtDate(res.getDate("crt_date"));
                currUser.setLogDate(res.getDate("log_date"));
                currUser.setIsAdmin(res.getBoolean("is_admin"));
                currUser.setIsEnabled(res.getBoolean("is_enabled"));
                currUser.setIsActive(res.getBoolean("is_active"));
                rList.add(currUser);
            }
        } catch (NamingException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (res != null) {
                    res.close();
                }
                if (stn != null) {
                    stn.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return rList;
    }

    @Override
    public List<User> getUsersByGroupId(int givenGroupId, Boolean includeDisabled) {
        List<User> rList = new ArrayList<User>();
        Connection conn = null;
        Statement stn = null;
        ResultSet res = null;
        try {
            conn = Utils.getNewConnection();
            stn = conn.createStatement();
            if (includeDisabled) {
                res = stn.executeQuery("SELECT User.* FROM User JOIN UserGroupsRel WHERE User.id=user_id AND group_id=1;");
            } else {
                res = stn.executeQuery("SELECT User.* FROM User JOIN UserGroupsRel WHERE User.id=user_id AND group_id=1 AND UserGroupsRel.is_enabled=TRUE;");
            }
            while(res.next()) {
                User currUser = new User();
                currUser.setId(res.getInt("id"));
                currUser.setLogin(res.getString("login"));
                currUser.setDescription(res.getString("description"));
                currUser.setPassw(res.getString("passw"));
                currUser.setCrtDate(res.getDate("crt_date"));
                currUser.setLogDate(res.getDate("log_date"));
                currUser.setIsAdmin(res.getBoolean("is_admin"));
                currUser.setIsEnabled(res.getBoolean("is_enabled"));
                currUser.setIsActive(res.getBoolean("is_active"));
                rList.add(currUser);
            }
        } catch (NamingException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (res != null) {
                    res.close();
                }
                if (stn != null) {
                    stn.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return rList;
    }
    
}
