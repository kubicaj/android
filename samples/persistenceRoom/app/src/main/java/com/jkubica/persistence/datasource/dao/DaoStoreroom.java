package com.jkubica.persistence.datasource.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.jkubica.persistence.datasource.entities.EntityCategory;
import com.jkubica.persistence.datasource.entities.EntityItem;

import java.util.List;

/**
 * The class for data access. The class consist all methods for access to database
 *
 * Created by jkubica on 13.01.2018.
 */
@Dao
public interface DaoStoreroom {

    // =============================================================================================
    // Insert methods
    // =============================================================================================

    /**
     * add new {@link EntityCategory} into database
     *
     * @param entityCategory - entity to add
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertCategory(EntityCategory entityCategory);


    /**
     * add new {@link EntityItem} into database
     *
     * @param entityItem - entity to add
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertItem(EntityItem entityItem);

    // =============================================================================================
    // Update methods
    // =============================================================================================

    /**
     * update {@link EntityCategory} into database
     *
     * @param entityCategory - entity to update
     */
    @Update(onConflict = OnConflictStrategy.REPLACE)
    public void updateCategory(EntityCategory entityCategory);

    // =============================================================================================
    // Select methods
    // =============================================================================================

    /**
     * Select root categories. That mean the category which do not have a parent category
     *
     * @return - {@link List} of {@link EntityCategory}
     */
    @Query("Select * from CATEGORY where PARENT_CATEGORY_ID is null")
    public List<EntityCategory> getRootCategories();

    /**
     * Find category by id
     *
     * @param categoryId - category id of entity which will be find
     * @return {@link EntityCategory}
     */
    @Query("Select * from CATEGORY where ID = :categoryId")
    public EntityCategory getCategoryById(Integer categoryId);

    /**
     * Find item by id
     *
     * @param itemId - item id of entity which will be find
     * @return {@link EntityItem}
     */
    @Query("Select * from ITEM where ID = :itemId")
    public EntityItem getItemById(Integer itemId);
}
