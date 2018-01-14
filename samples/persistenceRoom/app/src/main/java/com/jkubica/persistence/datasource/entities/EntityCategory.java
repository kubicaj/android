package com.jkubica.persistence.datasource.entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

/**
 * The class representation of database entity <code>Category</code>
 *
 * Created by jkubica on 13.01.2018.
 */
@Entity(
        // reference to parent item
        foreignKeys = @ForeignKey(entity = EntityCategory.class, parentColumns = "ID", childColumns = "PARENT_CATEGORY_ID"),
        tableName = "CATEGORY"
)
public class EntityCategory {

    // =============================================================================================
    // Attributes
    // =============================================================================================

    /**
     * Item id
     */
    @PrimaryKey
    @ColumnInfo(name = "ID")
    private Integer id;

    /**
     * The name of entity
     */
    @ColumnInfo(name = "NAME")
    private String name;


    /**
     * The name of entity
     */
    @ColumnInfo(name = "NOTE")
    private String note;

    /**
     * Category parent
     * FK to entity <code>EntityCategory</code>.
     */
    @ColumnInfo(name = "PARENT_CATEGORY_ID")
    private Integer parentCategoryId;

    // =============================================================================================
    // Getters and Setters
    // =============================================================================================

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getParentCategoryId() {
        return parentCategoryId;
    }

    public void setParentCategoryId(Integer parentCategoryId) {
        this.parentCategoryId = parentCategoryId;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
