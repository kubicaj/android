package com.jkubica.persistence.datasource.entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;

import com.jkubica.persistence.datasource.converters.DateTimeConverter;

import java.util.Date;


/**
 * The class representation of database entity <code>Item</code>
 * <p>
 * Created by jkubica on 13.01.2018.
 */
@Entity(
        // reference to parent item
        foreignKeys = @ForeignKey(entity = EntityCategory.class, parentColumns = "ID", childColumns = "CATEGORY_ID"),
        tableName = "ITEM"
)
public class EntityItem {

    // =============================================================================================
    // Attributes
    // =============================================================================================

    /**
     * ItemProperties id
     */
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "ID", index = true)
    private Integer id;

    /**
     * Reference to category
     */
    @ColumnInfo(name = "CATEGORY_ID", index = true)
    private Integer categoryId;

    /**
     * The note of of item
     */
    @ColumnInfo(name = "NOTE")
    private String note;

    /**
     * The date when the item was added
     */
    @ColumnInfo(name = "ADDED_DATE")
    @TypeConverters({DateTimeConverter.class})
    private Date addedDate;

    // =============================================================================================
    // Getters and Setters
    // =============================================================================================


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Date getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(Date addedDate) {
        this.addedDate = addedDate;
    }
}
