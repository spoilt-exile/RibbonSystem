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

package org.ribbon.dao;

/**
 * Abstract DAO factory class;
 * @author Stanislav Nepochatov
 * @deprecated use JPA, Luke!
 */
public abstract class DAOFactory {
    
    /**
     * Get IDAOUser new instance from factory;
     * @return new instance of user DAO;
     */
    public abstract IDAOUser getNewIDaoUserInstance();
    
    /**
     * Get IDAOGroup new instance from factory;
     * @return new instance of group DAO;
     */
    public abstract IDAOGroup getNewIDaoGroupInstance();
    
    /**
     * Get IDAODirectory new instance from factory;
     * @return new instance of directory DAO;
     */
    public abstract IDAODirectory getNewDaoDirectoryInstance();
    
    /**
     * Get IDAOMessage new instance from factory;
     * @return new instance of message DAO;
     */
    public abstract IDAOMessage getNewDaoMessageInstance();
}
