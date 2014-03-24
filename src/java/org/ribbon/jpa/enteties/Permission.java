/*
 * Copyright (C) 2014 spoilt
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

package org.ribbon.jpa.enteties;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author spoilt
 */
@Entity
@Table(name = "Permission")
@NamedQueries({
    @NamedQuery(name = "Permission.findAll", query = "SELECT p FROM Permission p"),
    @NamedQuery(name = "Permission.findById", query = "SELECT p FROM Permission p WHERE p.id = :id"),
    @NamedQuery(name = "Permission.findByDirId", query = "SELECT p FROM Permission p WHERE p.dirId = :dirId"),
    @NamedQuery(name = "Permission.findByGroupPerm", query = "SELECT p FROM Permission p WHERE p.groupPerm = :groupPerm"),
    @NamedQuery(name = "Permission.findByAllPerm", query = "SELECT p FROM Permission p WHERE p.allPerm = :allPerm"),
    @NamedQuery(name = "Permission.findByMayRead", query = "SELECT p FROM Permission p WHERE p.mayRead = :mayRead"),
    @NamedQuery(name = "Permission.findByMayPost", query = "SELECT p FROM Permission p WHERE p.mayPost = :mayPost"),
    @NamedQuery(name = "Permission.findByMayAdmin", query = "SELECT p FROM Permission p WHERE p.mayAdmin = :mayAdmin")})
public class Permission implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dir_id")
    private int dirId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "group_perm")
    private boolean groupPerm;
    @Column(name = "all_perm")
    private Boolean allPerm;
    @Basic(optional = false)
    @NotNull
    @Column(name = "may_read")
    private boolean mayRead;
    @Basic(optional = false)
    @NotNull
    @Column(name = "may_post")
    private boolean mayPost;
    @Basic(optional = false)
    @NotNull
    @Column(name = "may_admin")
    private boolean mayAdmin;
    @JoinColumn(name = "group_id", referencedColumnName = "id")
    @ManyToOne
    private Groups groupId;
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne
    private User userId;

    public Permission() {
    }

    public Permission(Integer id) {
        this.id = id;
    }

    public Permission(Integer id, int dirId, boolean groupPerm, boolean mayRead, boolean mayPost, boolean mayAdmin) {
        this.id = id;
        this.dirId = dirId;
        this.groupPerm = groupPerm;
        this.mayRead = mayRead;
        this.mayPost = mayPost;
        this.mayAdmin = mayAdmin;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getDirId() {
        return dirId;
    }

    public void setDirId(int dirId) {
        this.dirId = dirId;
    }

    public boolean getGroupPerm() {
        return groupPerm;
    }

    public void setGroupPerm(boolean groupPerm) {
        this.groupPerm = groupPerm;
    }

    public Boolean getAllPerm() {
        return allPerm;
    }

    public void setAllPerm(Boolean allPerm) {
        this.allPerm = allPerm;
    }

    public boolean getMayRead() {
        return mayRead;
    }

    public void setMayRead(boolean mayRead) {
        this.mayRead = mayRead;
    }

    public boolean getMayPost() {
        return mayPost;
    }

    public void setMayPost(boolean mayPost) {
        this.mayPost = mayPost;
    }

    public boolean getMayAdmin() {
        return mayAdmin;
    }

    public void setMayAdmin(boolean mayAdmin) {
        this.mayAdmin = mayAdmin;
    }

    public Groups getGroupId() {
        return groupId;
    }

    public void setGroupId(Groups groupId) {
        this.groupId = groupId;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Permission)) {
            return false;
        }
        Permission other = (Permission) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.ribbon.jpa.enteties.Permission[ id=" + id + " ]";
    }
    
}
